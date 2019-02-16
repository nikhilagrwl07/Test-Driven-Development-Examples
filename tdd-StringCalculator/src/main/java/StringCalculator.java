import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringCalculator {
    public int calculate(String numbers) {

        if (isEmpty.test(numbers))
            return 0;

        List<String> tokenizedString = tokenize(numbers);

        containsNegativeNumber(tokenizedString);

        tokenizedString = filterOutNumberGreaterThanThreshold(tokenizedString);

        return getSum(tokenizedString);
    }

    private void containsNegativeNumber(List<String> tokenizedString) {

        List<String> negativeNumber = tokenizedString.stream().filter(number -> toInt.andThen(isNumberNegative).apply(number)).collect(Collectors.toList());

        if (negativeNumber.size() > 0) {
            throw new NegativeNumberException(String.join(",", negativeNumber));
        }
    }

    private List<String> filterOutNumberGreaterThanThreshold(List<String> tokenizedString) {

        List<String> filteredList = tokenizedString.stream().filter(number -> !toInt.andThen(isNumberGreaterThan1000).apply(number)).collect(Collectors.toList());

        return filteredList;
    }

    private List<String> tokenizeWithCustomRegex(String numbers) {
        String customRegex = numbers.substring(2, 3);
        return Arrays.asList(numbers.substring(4).split(customRegex));
    }


    private List<String> tokenize(String numbers) {

        if (numberStartsWithDoubleForwardSlash.test(numbers)) {
            return tokenizeWithCustomRegex(numbers);
        }

        if (numbers.contains(",")) {
            return Arrays.asList(numbers.split(",|\n"));
        }

        ArrayList<String> defaultList = new ArrayList<>();
        defaultList.add(numbers);
        return defaultList;
    }

    private int getSum(List<String> splittedNumber) {
        return splittedNumber.stream().mapToInt(s -> toInt.apply(s)).sum();
    }


    private Function<Integer, Boolean> isNumberNegative = x -> x < 0;

    private Function<Integer, Boolean> isNumberGreaterThan1000 = x -> x > 1000;

    private Predicate<String> numberStartsWithDoubleForwardSlash = s -> s.startsWith("//");

    private Predicate<String> isEmpty = s -> s.isEmpty();

    private Function<String, Integer> toInt = (s) -> Integer.parseInt(s);

}
