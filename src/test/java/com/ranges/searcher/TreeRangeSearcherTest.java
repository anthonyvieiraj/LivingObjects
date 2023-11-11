package com.ranges.searcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ranges.model.Range;

public class TreeRangeSearcherTest {

    private final Range rangeA = new Range("A", 0, 6);
    private final Range rangeB = new Range("B", 5, 14);
    private final Range rangeC = new Range("C", 3, 7);

    private final Range rangeD = new Range("D", 1, 21);
    private final Range rangeE = new Range("E", 9, 14);

    private TreeRangeSearcher treeRangeSearcher;

    @BeforeEach
    public void fixture() {
        treeRangeSearcher = new TreeRangeSearcher(Set.of(rangeA, rangeB, rangeC, rangeD, rangeE));
    }

    @Test
    public void testMarchingLabelsBasedOnTree() {
        String[] result = treeRangeSearcher.marchingLabels(5);
        assertEquals(4, result.length);
        assertTrue(Set.of(result).containsAll(Set.of("A", "B", "C", "D")));
    }

    @Test
    public void testMarchingLabelsEmpty() {
        String[] result = treeRangeSearcher.marchingLabels(42);
        assertEquals(0, result.length);
    }

    @Test
    public void testMarchingLabelsClosedUpperBoundCase() {
        String[] result = treeRangeSearcher.marchingLabels(6);
        assertEquals(3, result.length);
        assertTrue(Set.of(result).containsAll(Set.of("B", "C", "D")));
    }

}
