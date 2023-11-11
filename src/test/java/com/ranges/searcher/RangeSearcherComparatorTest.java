package com.ranges.searcher;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Test;

import com.ranges.model.Range;

/**
 * IMHO, this shouldn't be written in an Unit test but since this code is just an exam, not production code, I will take some shortcut
 * This test will compare both implementation at the limits, A.K.A, with a LOT of ranges and search calling.
 * This kind of behavior should not be set as an unit test because it makes UT pipeline much slower and UT are not supposed to estimate performance
 */
public class RangeSearcherComparatorTest {

    private static final long MAX_VALUE = 300000;

    private NaiveRangeSearcher naiveRangeSearcher;
    private TreeRangeSearcher treeRangeSearcher;

    /**
     * Obviously, initializing the tree as a cost, compared to the naive searcher, I will not compare the initialization
     */
    @Test
    public void performanceTest() {
        Set<Range> ranges = generateRanges();
        naiveRangeSearcher = new NaiveRangeSearcher(ranges);
        treeRangeSearcher = new TreeRangeSearcher(ranges);
        long naiveDelay = searchAddReturnDelay(naiveRangeSearcher);
        long treeDelay = searchAddReturnDelay(treeRangeSearcher);
        assertTrue(treeDelay < naiveDelay);
    }

    /**
     * System.currentTimeMillis() method is not very accurate for very low delay (below 10ms) but it will be enough for this this, It will last multiple seconds
     */
    private long searchAddReturnDelay(RangeSearcher rangeSearcher) {
        long startTime = System.currentTimeMillis();
        //No parallelism at all to be able to compare.
        for(int i = 0; i < MAX_VALUE; i++) {
            rangeSearcher.marchingLabels(i);
        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    private Set<Range> generateRanges() {
        Set<Range> ranges = new HashSet<>();
        for(int i = 0; i < 2500; i++)  {
            long lower = ThreadLocalRandom.current().nextLong(0, MAX_VALUE - 1);
            long upper = ThreadLocalRandom.current().nextLong(lower, MAX_VALUE);
            ranges.add(new Range(Integer.toString(i), lower, upper));
        }
        return ranges;
    }

}
