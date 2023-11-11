package com.ranges.searcher;

import java.util.Set;

import com.ranges.model.Range;

public final class NaiveRangeSearcher extends RangeSearcher {

    private final Set<Range> ranges;

    public NaiveRangeSearcher(Set<Range> ranges) {
        this.ranges = ranges;
    }

    @Override
    public String[] marchingLabels(long item) {
        return ranges.stream()
                .filter(range -> range.isInRange(item))
                .map(Range::label)
                .toArray(String[]::new);
    }
}
