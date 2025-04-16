package com.solvians.showcase;

import java.util.concurrent.ThreadLocalRandom;

public class ISINGenerator {
    public static String generateISIN() {
        StringBuilder sb = new StringBuilder();

        sb.append((char) (ThreadLocalRandom.current().nextInt(26) + 'A'));
        sb.append((char) (ThreadLocalRandom.current().nextInt(26) + 'A'));

        for (int i = 0; i < 9; i++) {
            int value = ThreadLocalRandom.current().nextInt(36);
            if (value >= 10) {
                sb.append((char) (value - 10 + 'A'));
            } else {
                sb.append((char) (value + '0'));
            }
        }
        return sb.toString() + getCheckedDigit(sb.toString());
    }

    public static int getCheckedDigit(String number) {
        int digitSum = getReversedDigitsSum(number);
        return (((digitSum / 10) + 1) * 10 - digitSum) % 10;
    }

    private static int getReversedDigitsSum(String number) {
        String numbers = getNumberString(number);
        StringBuilder reversedNumbers = new StringBuilder(numbers).reverse();
        int digitSum = 0;
        for (int i = 0; i < reversedNumbers.length(); i++) {
            int currentDigit = reversedNumbers.charAt(i) - '0';
            if (i % 2 == 0) {
                currentDigit *= 2;
            }
            digitSum += currentDigit / 10 + currentDigit % 10;
        }
        return digitSum;
    }

    private static String getNumberString(String number) {
        StringBuilder numbers = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers.append(c);
            } else {
                numbers.append(charToNumber(c));
            }
        }

        return numbers.toString();
    }

    private static int charToNumber(char c) {
        return c - 'A' + 10;
    }

}
