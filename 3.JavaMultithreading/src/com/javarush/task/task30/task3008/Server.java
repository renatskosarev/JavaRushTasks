package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Задайте порт сервера:");
        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Чат-сервер запущен.");
            while (true) {
                // Ожидаем входящее соединение и запускаем отдельный поток при его принятии
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Произошла ошибка при запуске или работе сервера.");
        }
    }


    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с удалённым адресом: " + socket.getRemoteSocketAddress());

            boolean flag = false;
            String name = "";

            try (Connection connection =  new Connection(socket)) {


                // Производим рукопожатие с клиентом, сохраняем имя

                name = serverHandshake(connection);
                flag = true;

                // Рассылаем всем пользователям сообщение о присоединении
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name)); //  + " присоединился к чату."


                // Оповещаем нового участника чата о всех пользователях
                notifyUsers(connection, name);


                // Запускаем главный цикл обработки сообщений
                serverMainLoop(connection, name);


                //
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            }

            if (flag) {
                connectionMap.remove(name);
            }
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name)); //  + " вышел из чата."


            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто.");
        }


        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            connection.send(new Message(MessageType.NAME_REQUEST, "Введите своё имя. "));

            Message name = connection.receive();
            while (true) {
                if (name.getType() == MessageType.USER_NAME) {
                    if (name.getData() != "" && !connectionMap.containsKey(name.getData())) {
                        break;
                    }
                }
                connection.send(new Message(MessageType.NAME_REQUEST, "Введите другое имя."));
                name = connection.receive();
            }
            connectionMap.put(name.getData(), connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED, "Имя принято."));
            return name.getData();
        }


        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (name.equals(userName))
                    continue;
                connection.send(new Message(MessageType.USER_ADDED, name + "сейчас в чате."));
            }
        }


        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {


                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String formattedMessage = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, formattedMessage));
                } else {
                    ConsoleHelper.writeMessage("Ошибка: принятое сообщение не является текстом.");
                }


            }
        }
    }


    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Сообщение не было отправлено: " +
                        pair.getValue().getRemoteSocketAddress());
            }
        }
    }
}
