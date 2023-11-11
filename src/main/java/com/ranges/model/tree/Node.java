package com.ranges.model.tree;

import java.util.Set;

import com.ranges.model.Range;

public record Node(long center, Node left, Node right, Set<Range> rangedByLower, Set<Range> rangedByUpper) { }
