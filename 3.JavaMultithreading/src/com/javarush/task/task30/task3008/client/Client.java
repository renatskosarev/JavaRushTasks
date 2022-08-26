package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected;

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("������� ����� �������:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("������� ���� �������:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("������� ���� ���:");
        return ConsoleHelper.readString();
    }

    public class SocketThread extends Thread {
        @Override
        public void run() {
            try {
                // ������� ���������� � ��������
                connection = new Connection(new Socket(getServerAddress(), getServerPort()));

                clientHandshake();
                clientMainLoop();

            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();

                if (message.getType() == MessageType.NAME_REQUEST) { // ������ �������� ��� ������������
                    // ����������� ���� ����� � �������
                    String name = getUserName();
                    // ���������� ��� �� ������
                    connection.send(new Message(MessageType.USER_NAME, name));

                } else if (message.getType() == MessageType.NAME_ACCEPTED) { // ������ ������ ��� ������������
                    // �������� �������� ������, ��� �� ����� ���������� ������
                    notifyConnectionStatusChanged(true);
                    return;

                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            // ���� ��������� ��������� �������
            while (true) {
                Message message = connection.receive();

                if (message.getType() == MessageType.TEXT) { // ������ ������� ��������� � �������
                    processIncomingMessage(message.getData());
                } else if (MessageType.USER_ADDED == message.getType()) {
                    informAboutAddingNewUser(message.getData());
                } else if (MessageType.USER_REMOVED == message.getType()) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void processIncomingMessage(String message) {
            // ������� ����� ��������� � �������
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            // ������� ���������� � ���������� ���������
            ConsoleHelper.writeMessage("�������� '" + userName + "' ������������� � ����.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            // ������� ���������� � ������ ���������
            ConsoleHelper.writeMessage("�������� '" + userName + "' ������� ���.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("�� ������� ��������� ���������");
            clientConnected = false;
        }
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        // �������� ����� ��� daemon
        socketThread.setDaemon(true);
        socketThread.start();

        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("��������� ������ �� ����� ������ �������.");
            return;
        }

        if (clientConnected)
            ConsoleHelper.writeMessage("���������� �����������. ��� ������ �������� ������� 'exit'.");
        else
            ConsoleHelper.writeMessage("��������� ������ �� ����� ������ �������.");

        // ���� �� ����� ������� ������� exit, ��������� ��������� � ������� � ���������� �� �� ������
        while (clientConnected) {
            String text = ConsoleHelper.readString();
            if (text.equalsIgnoreCase("exit"))
                break;

            if (shouldSendTextFromConsole())
                sendTextMessage(text);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
