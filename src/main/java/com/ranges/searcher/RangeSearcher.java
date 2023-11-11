package com.ranges.searcher;

public sealed abstract class RangeSearcher permits NaiveRangeSearcher, TreeRangeSearcher {

    public abstract String[] marchingLabels(long item);
}
