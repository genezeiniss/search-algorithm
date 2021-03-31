package com.genezeiniss.search_algorithm.utils;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchUtil {

    /**
     * returns the index position of a target if found, else returns -1.
     */
    public static int linearSearch(List<Integer> searchRange, int target) {

        for (int i = 0; i < searchRange.size(); i++) {
            if (target == searchRange.get(i)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * returns the index position of a target if found, else returns -1.
     * note: the values in the list must be sorted in ascending order!
     * <p>
     * current implementation:
     * we are pointing to the different sections of the original list (without to create a sub-list).
     * it means, that search complexity is constant (it takes constant space of size n - O(1)), since
     * the amount of storage required for this algorithm doesn't effected by target value position. it's always equal to number of original list elements.
     */
    public static int iterativeBinarySearch(List<Integer> searchRange, int target) {

        int firstElementIndex = 0;
        int lastElementIndex = searchRange.size() - 1;

        while (firstElementIndex <= lastElementIndex) {
            int midElementIndex = (firstElementIndex + lastElementIndex) / 2;

            if (searchRange.get(midElementIndex) == target) {
                return midElementIndex;
            } else if (searchRange.get(midElementIndex) < target) {
                firstElementIndex = midElementIndex + 1;
            } else {
                lastElementIndex = midElementIndex - 1;
            }
        }

        return -1;
    }

    /**
     * returns true if target is found in the provided list, else returns false.
     * note: the return value is boolean and not int since the algorithm is running on sub-lists, which shuffles the indexes of the values.
     * <p>
     * current implementation:
     * the new sub list is created (from original list), each time the recursive function is called.
     * it means, that we allocating additional memory of size n/2, n/4 and so on for each recursive call,
     * until we have a sub-list that is empty, or contain the single value.
     */
    public static boolean recursiveBinarySearch(List<Integer> searchRange, int target) {

        if (!searchRange.isEmpty()) {

            int midPoint = searchRange.size() / 2;

            if (searchRange.get(midPoint) == target) {
                return true;
            } else if (searchRange.get(midPoint) < target) {
                // call to same function with the shortest list: from the midpoint to the end
                return recursiveBinarySearch(searchRange.subList(midPoint + 1, searchRange.size()), target);
            } else {
                // call to same function with the shortest list: from the start up to the midpoint
                return recursiveBinarySearch(searchRange.subList(0, midPoint), target);
            }
        }

        return false;
    }
}
