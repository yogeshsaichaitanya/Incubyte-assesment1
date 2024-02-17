package main;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;

        int n = numbers.length();
        int sum = 0;

        String[] split = numbers.split(",");

        for (String s : split) {
            int i = Integer.parseInt(s);
            sum += i;
        }

        return sum;
    }
}
