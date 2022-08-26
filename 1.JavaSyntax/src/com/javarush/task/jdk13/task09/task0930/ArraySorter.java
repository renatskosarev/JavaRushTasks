package com.javarush.task.jdk13.task09.task0930;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArraySorter {

    public void sort(String[] array) {
        //напишите тут ваш код
        ArrayList<Boolean> isDigit = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String str: array) {
            if (isNumber(str)) {
                isDigit.add(true);
                numbers.add(Integer.parseInt(str));
            } else {
                isDigit.add(false);
                strings.add(str);
            }
        }
        
        isGreaterThan("as", "an");

        Collections.sort(strings);
        Collections.sort(numbers);
        Collections.reverse(numbers);
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < isDigit.size(); i++) {
            if (isDigit.get(i) == true) {
                Integer number = numbers.get(0);
                result.add(number + "");
                numbers.remove(number);
            } else {
                String str = strings.get(0);
                result.add(str);
                strings.remove(str);
            }
        }

        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public boolean isNumber(String text) {
        if (text.length() == 0) {
            return false;
        }

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];
            if ((i != 0 && character == '-') // Строка содержит '-'
                    || (!Character.isDigit(character) && character != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && character == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
