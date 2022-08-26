package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("������� ���� �������:");
        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("���-������ �������.");
            while (true) {
                // ������� �������� ���������� � ��������� ��������� ����� ��� ��� ��������
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("��������� ������ ��� ������� ��� ������ �������.");
        }
    }


    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("����������� ���������� � �������� �������: " + socket.getRemoteSocketAddress());

            boolean flag = false;
            String name = "";

            try (Connection connection =  new Connection(socket)) {


                // ���������� ����������� � ��������, ��������� ���

                name = serverHandshake(connection);
                flag = true;

                // ��������� ���� ������������� ��������� � �������������
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name)); //  + " ������������� � ����."


                // ��������� ������ ��������� ���� � ���� �������������
                notifyUsers(connection, name);


                // ��������� ������� ���� ��������� ���������
                serverMainLoop(connection, name);


                //
            } catch (IOException e) {
                ConsoleHelper.writeMessage("��������� ������ ��� ������ ������� � ��������� �������");
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("��������� ������ ��� ������ ������� � ��������� �������");
            }

            if (flag) {
                connectionMap.remove(name);
            }
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name)); //  + " ����� �� ����."


            ConsoleHelper.writeMessage("���������� � ��������� ������� �������.");
        }


        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            connection.send(new Message(MessageType.NAME_REQUEST, "������� ��� ���. "));

            Message name = connection.receive();
            while (true) {
                if (name.getType() == MessageType.USER_NAME) {
                    if (name.getData() != "" && !connectionMap.containsKey(name.getData())) {
                        break;
                    }
                }
                connection.send(new Message(MessageType.NAME_REQUEST, "������� ������ ���."));
                name = connection.receive();
            }
            connectionMap.put(name.getData(), connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED, "��� �������."));
            return name.getData();
        }


        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (name.equals(userName))
                    continue;
                connection.send(new Message(MessageType.USER_ADDED, name + "������ � ����."));
            }
        }


        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {


                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String formattedMessage = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, formattedMessage));
                } else {
                    ConsoleHelper.writeMessage("������: �������� ��������� �� �������� �������.");
                }


            }
        }
    }


    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("��������� �� ���� ����������: " +
                        pair.getValue().getRemoteSocketAddress());
            }
        }
    }
}
