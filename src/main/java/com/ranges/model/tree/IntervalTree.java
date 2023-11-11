package com.ranges.model.tree;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.ranges.model.Range;
import com.ranges.model.RangePosition;
import com.ranges.utils.RangeUtils;

public class IntervalTree {

    private final Node root;

    public IntervalTree(Set<Range> ranges) {
        this.root = createNode(ranges);
    }

    //TODO: Avoid using recursivity to create the tree: StackOverFlowException may be possible but since, it is a test, not a production code, I took some shortcuts
    public Node createNode(Set<Range> ranges) {
        long centerX = RangeUtils.estimateCenterX(ranges);

        Map<RangePosition, Set<Range>> mapByPosition = RangeUtils.splitRangesByCenterX(centerX, ranges);

        Set<Range> leftRanges = mapByPosition.get(RangePosition.LEFT);
        Node leftNode = leftRanges != null ? createNode(leftRanges) : null;
        Set<Range> rightRanges = mapByPosition.get(RangePosition.RIGHT);
        Node rightNode = rightRanges != null ? createNode(rightRanges) : null;

        Set<Range> centerRanges = mapByPosition.get(RangePosition.CENTER);
        Set<Range> rangedByLower = centerRanges != null ? centerRanges.stream()
                .sorted(Comparator.comparingLong(Range::lowerBound))
                .collect(Collectors.toCollection(LinkedHashSet::new)) : Set.of();
        Set<Range> rangedByUpper = centerRanges != null ? centerRanges.stream()
                .sorted(Comparator.comparingLong(Range::upperBound).reversed())
                .collect(Collectors.toCollection(LinkedHashSet::new)) : Set.of();

        return new Node(centerX, leftNode, rightNode, rangedByLower, rangedByUpper);
    }

    public Set<Range> search(long value) {
        Set<Range> result = new HashSet<>();
        search(root, value, result);
        return result;
    }

    //TODO: Avoid using recursivity to search in the tree: StackOverFlowException may be possible but since, it is a test, not a production code, I took some shortcuts
    private void search(Node node, long value, Set<Range> result) {
        if(node == null) {
            return;
        }
        if(value < node.center()) {
            if(node.left() != null) {
                search(node.left(), value, result);
            }
            addRangesDependingOnCenterXValue(node.rangedByLower(), result, r -> r.isLowerBoundBelow(value));
        } else if(value > node.center()) {
            if(node.right() != null) {
                search(node.right(), value, result);
            }
            addRangesDependingOnCenterXValue(node.rangedByUpper(), result, r -> r.isUpperBoundAbove(value));
        } else {
            result.addAll(node.rangedByLower());
        }
    }

    private void addRangesDependingOnCenterXValue(Set<Range> sortedRanges, Set<Range> result, Predicate<Range> rangePredicate) {
        for (Range range : sortedRanges) {
            if (rangePredicate.test(range)) {
                result.add(range);
            } else {
                break;
            }
        }
    }

}
