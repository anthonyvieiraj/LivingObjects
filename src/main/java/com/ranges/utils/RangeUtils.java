package com.ranges.utils;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.Map;
import java.util.Set;

import com.ranges.model.Range;
import com.ranges.model.RangePosition;

public class RangeUtils {

    /**
     * I haven't found a deterministic way (whatever the input, it works) to keep the tree the most balanced as possible
     * @param ranges
     * @return
     */
    public static long estimateCenterX(Set<Range> ranges) {
        return (long) ranges.stream()
                .mapToLong(Range::getCenter)
                .average()
                .orElse(0);
    }

    public static Map<RangePosition, Set<Range>> splitRangesByCenterX(long centerX, Set<Range> ranges) {
        return ranges.stream().collect(groupingBy(range -> range.getRangePosition(centerX), toSet()));
    }

}
