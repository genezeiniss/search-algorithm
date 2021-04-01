# algorithm

A set of steps or instructions for completing a task.  
Algorithm efficiency have two aspects:

1. Time complexity - how long it takes to complete a task (running time of an algorithm).
2. Space complexity - amount of memory take from the computer, while working on a task.

# search strategies

## linear search

Linear search ran on the array and sequentially check each value, till target value is found.

1. Best case: target value is a first element in the list (index 0).
2. Worst case: target value is a last element in the list or is out of the list (not exist).

## binary search

Binary search, also known as **half-interval search**. Binary search compares the target value to the middle element of the array.  
Pre-conditions:

1. The list must be sorted.
2. The steps need to be distinct.
3. The algorithm should produce a result.