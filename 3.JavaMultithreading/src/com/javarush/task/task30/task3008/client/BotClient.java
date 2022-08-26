package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {


    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("������! � ���, ������� �������: ����, ����, �����, ���, �����, ���, ������, �������.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            // ������� ����� ��������� � �������
            ConsoleHelper.writeMessage(message);

            // �������� ����������� �� ������ ���������
            String userNameDelimiter = ": ";
            String[] split = message.split(userNameDelimiter);
            if (split.length != 2) return;

            String messageWithoutUserName = split[1];

            // �������������� ������ ��� �������� ���� �������� �������
            String format = null;
            switch (messageWithoutUserName) {
                case "����":
                    format = "d.MM.YYYY";
                    break;
                case "����":
                    format = "d";
                    break;
                case "�����":
                    format = "MMMM";
                    break;
                case "���":
                    format = "YYYY";
                    break;
                case "�����":
                    format = "H:mm:ss";
                    break;
                case "���":
                    format = "H";
                    break;
                case "������":
                    format = "m";
                    break;
                case "�������":
                    format = "s";
                    break;
                case "������":
                    BotClient.this.sendTextMessage("� ���� ������!");
                    break;
            }

            if (format != null) {
                String answer = new SimpleDateFormat(format).format(Calendar.getInstance().getTime());
                BotClient.this.sendTextMessage("���������� ��� " + split[0] + ": " + answer);
            }
        }
    }


    // override methods
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "bot-" + (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
