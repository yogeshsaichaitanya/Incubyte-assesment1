package main;

import main.exceptions.NegativeNumberException;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;

        int n = numbers.length();
        int sum = 0;
        StringBuilder numTillNow = new StringBuilder();

        boolean isNegative = false;
        List<Integer> negativeNumList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = numbers.charAt(i);

            if (c == '-') {
                if (numTillNow.isEmpty())
                    isNegative = !isNegative;
            } else if (c >= '0' && c <= '9') {
                numTillNow.append(c);
            } else {
                int i1 = 0;

                if (!numTillNow.isEmpty())
                    i1 = Integer.parseInt(numTillNow.toString());

                numTillNow = new StringBuilder();

                if (isNegative && i1 != 0)
                    negativeNumList.add(-1 * i1);
                else
                    sum += i1;

                isNegative = false;
            }
        }

        if (!numTillNow.isEmpty()) {
            int i1 = Integer.parseInt(numTillNow.toString());
            if (isNegative)
                negativeNumList.add(-1 * i1);
            else
                sum += i1;

            isNegative = false;
        }

        if (!negativeNumList.isEmpty())
            throw new NegativeNumberException("Cannot add negative numbers : " + negativeNumList);
        return sum;
    }
}
