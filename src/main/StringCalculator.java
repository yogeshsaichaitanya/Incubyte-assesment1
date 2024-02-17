package main;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;

        int n = numbers.length();
        int sum = 0;
        StringBuilder numTillNow = new StringBuilder();

//        //;\n1;2;31%^4
        for (int i = 0; i < n; i++) {
            char c = numbers.charAt(i);

            if (c >= '0' && c <= '9') {
                numTillNow.append(c);
            } else {
                int i1 = 0;

                if (!numTillNow.isEmpty())
                    i1 = Integer.parseInt(numTillNow.toString());

                numTillNow = new StringBuilder();

                sum += i1;
            }
        }

        if (!numTillNow.isEmpty()) {
            int i1 = Integer.parseInt(numTillNow.toString());
            sum += i1;
        }
        return sum;
    }
}
