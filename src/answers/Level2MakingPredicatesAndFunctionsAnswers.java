package answers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by olexandra on 2/25/16.
 */
public class Level2MakingPredicatesAndFunctionsAnswers {

    private List<Integer> numbers;

    @Before
    public void setUpBufferedReader() throws IOException {
        numbers = Arrays.asList(2, 8, 5, 1, 6, 4, 9, 7, 8, 4, 0);
    }

    /** Exercise 1
     Given: List of integers - "numbers". Using streams filter even values and output the maximal one.
     1) using stream max
     2) using IntStream max
     3) using stream reduce and inside Integer max function
     4) using Collectors max
     5) using Collectors reducing + Integer max function
     6) using Collectors summarizing
     */

    @Test
    public void filterEvenMax() {

        // given
        Predicate<Integer> getEven = curInt -> curInt % 2 == 0;

        // when
        // 1)
        int maxInStream = (numbers).stream().filter(getEven).max(Comparator.naturalOrder()).get();

        // 2)
        int maxInIntStream = (numbers).stream().filter(getEven).mapToInt(Integer::intValue).max().getAsInt();

        // 3.1)
        int maxUsingReduce = (numbers).stream().filter(getEven).reduce(Integer::max).get();

        // 3.2)
        int maxUsingCollectorsReduceOwn = (numbers).stream().filter(getEven).reduce(0, (a, b) -> Integer.max(a, b));

        // 4)
        int maxUsingComparatorMax = (numbers).stream().filter(getEven)
                .collect(Collectors.maxBy(Comparator.naturalOrder())).get();

        // 5)
        int maxUsingCollectorsReduce = (numbers).stream().filter(getEven).collect(Collectors.reducing(Integer::max))
                .get();

        // 6)
        int maxUsingCollectorsSummarizing = (numbers).stream().filter(getEven)
                .collect(Collectors.summarizingInt(Integer::intValue)).getMax();

        // then
        assertEquals(8, maxInStream);
        assertEquals(8, maxInIntStream);
        assertEquals(8, maxUsingReduce);
        assertEquals(8, maxUsingCollectorsReduceOwn);
        assertEquals(8, maxUsingComparatorMax);
        assertEquals(8, maxUsingCollectorsReduce);
        assertEquals(8, maxUsingCollectorsSummarizing);

    }

    /** Exercise 2
     Given: List of more than 10 integers - "numbers". Using streams filter even values and output the sum of 3 - 5 elements.
     0) even3To5Values - check you've composed the array correctly
     1) sumOfIntStream - IntStream sum method
     2) sumSummarizing - Collectors summarizing and then sum methods
     3) sumSumming - Collectors summing method
     4) sumReduceOwn - stream reduce method with your own realization of sum method inside
     5) sumReduceInteger - stream reduce using Integer sum function
     */

    @Test
    public void SumOf3Dash5Elements() {

        // given
        Predicate<Integer> getEven = curInt -> curInt % 2 == 0;

        // when
        List<Integer> even3To5Values = numbers.stream().filter(getEven).limit(5).skip(2).collect(Collectors.toList());

        long sumOfIntStream = even3To5Values.stream().mapToInt(Integer::intValue).sum();

        long sumSummarizing = numbers.stream().filter(getEven).limit(5).skip(2)
                .collect(Collectors.summarizingInt(Integer::intValue)).getSum();

        long sumSumming = numbers.stream().filter(getEven).limit(5).skip(2)
                .collect(Collectors.summingInt(Integer::intValue));

        long sumReduceOwn = even3To5Values.stream().reduce(0, (a, b) -> a + b);

        long sumReduceInteger = even3To5Values.stream().reduce(Integer::sum).get();

        // then
        assertEquals(Arrays.asList(6, 4, 8), even3To5Values);
        assertEquals(18, sumOfIntStream);
        assertEquals(18, sumSummarizing);
        assertEquals(18, sumSumming);
        assertEquals(18, sumReduceOwn);
        assertEquals(18, sumReduceInteger);

    }

    /*
     * Exercise 1 Write the function which will compare (gt) current int of the stream with the
     * input int and return predicate: Function<Integer, Predicate<Integer>> compareNumbers.
     */

    @Test
    public void makeFunction() {

        // given
        final int intToCompare = 4;
        Function<Integer, Predicate<Integer>> getGreaterThan = withWhatToCompare -> whatToCompare -> whatToCompare > withWhatToCompare;

        // when
        List<Integer> actual = numbers.stream().filter(getGreaterThan.apply(intToCompare)).collect(Collectors.toList());

        // then
        assertEquals(Arrays.asList(8, 5, 6, 9, 7, 8), actual);

    }
}
