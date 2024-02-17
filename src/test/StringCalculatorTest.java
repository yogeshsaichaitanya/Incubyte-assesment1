package test;

import main.StringCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @Before
    public void before() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void emptyStringShouldReturnZero() {
        String numbers = "";
        int expected = 0;

        int actual = stringCalculator.add(numbers);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void comaSeparatedCase() {
        String numbers = "1,2,3";
        int expected = 6;

        int actual = stringCalculator.add(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void comaSeparatedWithSpacesInBetween() {
        String numbers = "1, 2 , 3";
        int expected = 6;

        int actual = stringCalculator.add(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void changeDelimiter() {
        String numbers = "//;\\n1;2";
        int expected = 3;

        int actual = stringCalculator.add(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void delimiterWithVaryingLength() {
        String numbers = "/[***]\\n1***2***3";
        int expected = 6;

        int actual = stringCalculator.add(numbers);

        Assert.assertEquals(expected, actual);
    }
}
