package ru.courses.numbers;

public class Sum {

    public double sum(String[] numbers) {
        double result = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (isNumber(numbers[i])) {
                result += Double.parseDouble(numbers[i]);
            }
        }
        return result;
    }

    private boolean isNumber(String str) {
        char[] strArray = str.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            if (!Character.isDigit(strArray[i])) {
                return false;
            }
        }
        return true;
    }
}
