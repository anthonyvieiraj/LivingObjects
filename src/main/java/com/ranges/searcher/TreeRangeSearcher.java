package com.ranges.searcher;

import java.util.Set;

import com.ranges.model.Range;
import com.ranges.model.tree.IntervalTree;

public final class TreeRangeSearcher extends RangeSearcher {

    private final IntervalTree intervalTree;

    public TreeRangeSearcher(Set<Range> ranges) {
        this.intervalTree = new IntervalTree(ranges);
    }

    @Override
    public String[] marchingLabels(long item) {
        return this.intervalTree.search(item)
                .stream()
                .map(Range::label)
                .toArray(String[]::new);
    }
}
