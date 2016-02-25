import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

/**
 * Created by olexandra on 2/25/16.
 */
public class Level2MakingPredicatesAndFunctions {

    List<Integer> numbers = Arrays.asList(2, 8, 5, 1, 6, 4, 9, 7, 8, 4, 0);


    /* Exercise 1
    Given: List of more than 10 integers. Using streams filter even values and output the sum of 3 -5 elements.
     */
    @Test
    @Ignore
    public void SumOf3Dash5Elemnts() {

        //given
        //TODO: write your implementation instead of nulls and 0
        Predicate<Integer> getEven = null;

        //when
        List<Integer> even2To5Values = null;
        long sumOfIntStream = 0;

        long sumSummarizing = 0;

        long sumSumming = 0;

        long sumReduceOwn = 0;

        long sumReduceInteger = 0;

        //then
        assertEquals(Arrays.asList(6, 4, 8), even2To5Values);
        assertEquals(18, sumOfIntStream);
        assertEquals(18, sumSummarizing);
        assertEquals(18, sumSumming);
        assertEquals(18, sumReduceOwn);
        assertEquals(18, sumReduceInteger);

    }

    /* Exercise 2
    Given: List of integers. Using streams filter even values and output the maximal one.
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

        //TODO: write your implementation instead of nulls and 0

        //given
        Predicate<Integer> getEven = null;

        //when
        //1)
        int maxInStream = 0;

        //2)
        int maxInIntStream = 0;

        //3.1)
        int maxUsingReduce = 0;

        //3.2)
        int maxUsingCollectorsReduceOwn = 0;

        //4)
        int maxUsingComparatorMax = 0;

        //5)
        int maxUsingCollectorsReduce = 0;

        //6)
        int maxUsingCollectorsSummarizing = 0;

        //then
        assertEquals(8, maxInStream);
        assertEquals(8, maxInIntStream);
        assertEquals(8, maxUsingReduce);
        assertEquals(8, maxUsingCollectorsReduceOwn);
        assertEquals(8, maxUsingComparatorMax);
        assertEquals(8, maxUsingCollectorsReduce);
        assertEquals(8, maxUsingCollectorsSummarizing);

    }

    /* Exercise 3
            Write the function which will compare (gt) current int of the stream with the input int and return predicate:
         Function<Integer, Predicate<Integer>> compareNumbers.
        */

    @Test
    @Ignore
    public void makeFunction() {

        //given
        final int intToCompare = 4;
        Function<Integer, Predicate<Integer>> getGreaterThan = null;

        //when
        List<Integer> actual = null;

        //then
        assertEquals(Arrays.asList(8, 5, 6, 9, 7, 8), actual);

    }
}
