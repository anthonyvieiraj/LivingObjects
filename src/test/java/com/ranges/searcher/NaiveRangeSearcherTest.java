package com.ranges.searcher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ranges.model.Range;

public class NaiveRangeSearcherTest {

    private final Range rangeA = new Range("A", 0, 6);
    private final Range rangeB = new Range("B", 5, 7);

    private NaiveRangeSearcher naiveRangeSearcher;

    @BeforeEach
    public void fixture() {
        naiveRangeSearcher = new NaiveRangeSearcher(Set.of(rangeA, rangeB));
    }

    @Test
    public void marchingLabelsCaseA() {
        String[] result = naiveRangeSearcher.marchingLabels(2);
        assertEquals(1, result.length);
        assertEquals("A", result[0]);
    }

    @Test
    public void marchingLabelsCaseB() {
        String[] result = naiveRangeSearcher.marchingLabels(6);
        assertEquals(1, result.length);
        assertEquals("B", result[0]);
    }

    @Test
    public void marchingLabelsCaseEmpty() {
        String[] result = naiveRangeSearcher.marchingLabels(8);
        assertEquals(0, result.length);
    }

    @Test
    public void marchingLabelsCaseMultipleRanges() {
        String[] result = naiveRangeSearcher.marchingLabels(5);
        assertEquals(2, result.length);
    }
}
