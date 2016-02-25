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
public class Level2MakingPredicatesAndFunctions {

    List<Integer> numbers = Arrays.asList(2, 8, 5, 1, 6, 4);

/*
    Given: List of integers. Using streams filter odd values and output the maximal one.
    1) using stream max
    2) using IntStream max
    3) using stream reduce
    4) using Collectors max
    5) using Collectors reducing
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

        //3)
        int maxUsingReduce = (numbers).stream().filter(getOdd).reduce(Integer::max).get();

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
        assertEquals(Arrays.asList(8, 5, 6), actual);

    }
}
