package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User renat = new User();
            renat.setFirstName("Renat");
            renat.setLastName("Skosarev");
            renat.setBirthDate(new Date(105, 7, 22));
            renat.setMale(true);
            renat.setCountry(User.Country.RUSSIA);

            User artem = new User();
            artem.setFirstName("Artem");
            artem.setLastName("Zagovenko");
            artem.setBirthDate(new Date(97, 11, 31));
            artem.setMale(true);
            artem.setCountry(User.Country.UKRAINE);

            javaRush.users.add(renat);
            javaRush.users.add(artem);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            StringBuilder result = new StringBuilder("");
            if (!users.isEmpty()) {
                for (User user : users) {
                    Date bd = user.getBirthDate();
                    String birthday = String.valueOf(bd.getTime());
                    String userSpecs = user.getFirstName() + ":" + user.getLastName() + ":" +
                            birthday + ":" + user.isMale() + ":" + user.getCountry().getDisplayName();
                    result.append(userSpecs + " ");
                }

                result = new StringBuilder(result.substring(0, result.length() - 1));
                outputStream.write(String.valueOf(result).getBytes());
                outputStream.flush();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (inputStream.available() != 0) {
                StringBuilder data = new StringBuilder("");
                while (inputStream.available() > 0) {
                    data.append((char) inputStream.read());
                }
                String[] strUsers = String.valueOf(data).split(" ");
                ArrayList<User> users = new ArrayList<>();

                for (String strUser : strUsers) {
                    String[] elements = strUser.split(":");
                    String firstName = elements[0];
                    String lastName = elements[1];
                    String strCountry = elements[4];
                    Boolean isMale = Boolean.valueOf(elements[3]);

                    long bd = Long.parseLong(elements[2]);
                    Date birthday = new Date(bd);

                    User.Country country = User.Country.RUSSIA;

                    switch (strCountry) {
                        case "Ukraine":
                            country = User.Country.UKRAINE;
                            break;
                        case "Other":
                            country = User.Country.OTHER;
                    }
                    User user = new User();
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setBirthDate(birthday);
                    user.setCountry(country);
                    user.setMale(isMale ? true : false);

                    users.add(user);
                }

                this.users = users;
            } else {
                this.users = new ArrayList<User>();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
