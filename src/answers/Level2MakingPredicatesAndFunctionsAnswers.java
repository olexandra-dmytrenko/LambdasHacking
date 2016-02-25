package answers;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by olexandra on 2/25/16.
 */
public class Level2MakingPredicatesAndFunctionsAnswers {

    List<Integer> numbers = Arrays.asList(2, 8, 5, 1, 6, 4, 9, 7, 8, 4, 0);


    /*
    Given: List of more than 10 integers. Using streams filter even values and output the sum of 3 -5 elements.
     */
    @Test
    @Ignore
    public void SumOf3Dash5Elemnts() {

        //given
        Predicate<Integer> getOdd = curInt -> curInt % 2 == 0;

        //when
        List<Integer> odd2To5Values = numbers.stream().filter(getOdd).limit(5).skip(2).collect(Collectors.toList());
        long sumOfIntStream = odd2To5Values.stream().mapToInt(Integer::intValue).sum();

        long sumSummarizing = numbers.stream().filter(getOdd).limit(5).skip(2)
                .collect(Collectors.summarizingInt(Integer::intValue)).getSum();

        long sumSumming = numbers.stream().filter(getOdd).limit(5).skip(2)
                .collect(Collectors.summingInt(Integer::intValue));

        long sumReduceOwn = odd2To5Values.stream().reduce(0, (a, b) -> a + b);

        long sumReduceInteger = odd2To5Values.stream().reduce(Integer::sum).get();

        //then
        assertEquals(Arrays.asList(6, 4, 8), odd2To5Values);
        assertEquals(18, sumOfIntStream);
        assertEquals(18, sumSummarizing);
        assertEquals(18, sumSumming);
        assertEquals(18, sumReduceOwn);
        assertEquals(18, sumReduceInteger);

    }

/*
    Given: List of integers. Using streams filter odd values and output the maximal one.
    1) using stream max
    2) using IntStream max
    3) using stream reduce + Integer max function
    4) using Collectors max
    5) using Collectors reducing + Integer max function
    6) using Collectors summarizing
 */

    @Test
    @Ignore
    public void filterOddMax() {

        //given
        Predicate<Integer> getOdd = curInt -> curInt % 2 == 0;

        //when
        //1)
        int maxInStream = (numbers).stream().filter(getOdd).max(Comparator.naturalOrder()).get();

        //2)
        int maxInIntStream = (numbers).stream().filter(getOdd).mapToInt(Integer::intValue).max().getAsInt();

        //3.1)
        int maxUsingReduce = (numbers).stream().filter(getOdd).reduce(Integer::max).get();

        //3.2)
        int maxUsingCollectorsReduceOwn = (numbers).stream().filter(getOdd).reduce(0, (a, b) -> Integer.max(a, b)).intValue();

        //4)
        int maxUsingComparatorMax = (numbers).stream().filter(getOdd).collect(Collectors.maxBy(Comparator.naturalOrder())).get();

        //5)
        int maxUsingCollectorsReduce = (numbers).stream().filter(getOdd).collect(Collectors.reducing(Integer::max)).get();

        //6)
        int maxUsingCollectorsSummarizing = (numbers).stream().filter(getOdd).collect(Collectors.summarizingInt(Integer::intValue)).getMax();

        //then
        assertEquals(8, maxInStream);
        assertEquals(8, maxInIntStream);
        assertEquals(8, maxUsingReduce);
        assertEquals(8, maxUsingComparatorMax);
        assertEquals(8, maxUsingCollectorsReduce);
        assertEquals(8, maxUsingCollectorsSummarizing);

    }

        /* Exercise 1
            Write the function which will compare (gt) current int of the stream with the input int and return predicate:
         Function<Integer, Predicate<Integer>> compareNumbers.
        */

    @Test
    @Ignore
    public void makeFunction() {

        //given
        final int intToCompare = 4;
        Function<Integer, Predicate<Integer>> getGreaterThan = withWhatToCompare -> whatToCompare -> whatToCompare > withWhatToCompare;

        //when
        List<Integer> actual = numbers.stream().filter(getGreaterThan.apply(intToCompare)).collect(Collectors.toList());

        //then
        assertEquals(Arrays.asList(8, 5, 6, 9, 7, 8), actual);

    }
}
