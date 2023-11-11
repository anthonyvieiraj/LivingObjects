package com.ranges.model;

//TODO: Check that upperbound > lowerbound, throw an dedicated exception if that may happens
public record Range(String label, long lowerBound, long upperBound) {

    public boolean isInRange(long value) {
        return value >= lowerBound && value < upperBound;
    }

    public boolean isLowerBoundBelow(long value) {
        return lowerBound <= value;
    }

    public boolean isUpperBoundAbove(long value) {
        return upperBound > value;
    }

    public RangePosition getRangePosition(long centerX) {
        if (centerX < lowerBound) {
            return RangePosition.RIGHT;
        } else if (centerX >= upperBound) {
            return RangePosition.LEFT;
        } else {
            return RangePosition.CENTER;
        }
    }

    public long getCenter() {
        return (lowerBound + upperBound) / 2;
    }

}
