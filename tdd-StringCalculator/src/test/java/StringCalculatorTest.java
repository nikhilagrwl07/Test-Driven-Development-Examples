import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    
    private StringCalculator stringCalculator;

    static Integer threshold;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
         threshold = 1_000;
    }

    @Test
    public void returnZeroForEmptyString() {
        String numbers = "";
        int expectedValue = 0;

        int calculatedSum = stringCalculator.calculate(numbers);
        assertEquals(expectedValue, calculatedSum);
    }

    @Test
    public void returnSumForOneNumber(){
        String numbers = "2";
        int expectedValue = 2;

        int calculatedSum = stringCalculator.calculate(numbers);
        assertEquals(expectedValue, calculatedSum);
    }

    @Test
    public void returnSumForTwoNumberDelimitedByComma(){
        String numbers = "2,3";
        int expectedValue = 5;

        int calculatedSum = stringCalculator.calculate(numbers);
        assertEquals(expectedValue, calculatedSum);
    }

    @Test
    public void returnSumForNNumberDelimitedByComma(){
        String numbers = "1,2,3,4,5";
        int expectedValue = 15;

        int calculatedSum = stringCalculator.calculate(numbers);
        assertEquals(expectedValue, calculatedSum);
    }

    @Test
    public void returnSumForNewLineAsValidDelimited(){
        String numbers = "1,2\n3";
        int expectedValue = 6;

        int calculatedSum = stringCalculator.calculate(numbers);
        assertEquals(expectedValue, calculatedSum);
    }

    @Test
    public void returnSumForCustomDelimiter(){
        String numbers = "//;\n1;2;3;4";
        int expectedValue = 10;

        int calculatedSum = stringCalculator.calculate(numbers);
        assertEquals(expectedValue, calculatedSum);
    }

    @Test
    public void throwExceptionAddingNegativeNumber(){
        String numbers = "1,2,3,-10,4,-20";
        String expectedExpectionMessage = "-10,-20";

        try {
            stringCalculator.calculate(numbers);
            Assert.fail("Runtime exception expected");
        }catch (NegativeNumberException ex){
            assertEquals(ex.getMessage(), expectedExpectionMessage);
        }
    }

    @Test
    public void returnSumWithIgnoredNumberGreaterThanThreshold(){

        String numbers = "1,2,3,1001,2000";
        int sumExpected = 6;

        int calculatedSum = stringCalculator.calculate(numbers);

        assertEquals(calculatedSum, sumExpected);
    }


    // CustomRegexExpressionOfAnyLength
}
