package com.genezeiniss.search_algorithm.utils

import spock.lang.Specification
import spock.lang.Unroll

class SearchUtilSpec extends Specification {

    @Unroll
    def "linear search - #scenario"() {
        when:
        def targetIndex = SearchUtil.linearSearch(list, target)

        then:
        assert targetIndex == expectedIndex

        where:
        scenario                                            | list                            | target || expectedIndex
        "list is sorted ascending; target is first element" | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 1      || 0
        "list is sorted ascending; target is last element"  | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 10     || 9
        "list is sorted ascending; target is the middle"    | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 5      || 4
        "list is sorted ascending; target is not included"  | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 11     || -1
        "list is not sorted; target included"               | [1, 2, 7, 4, 5, 6, 3, 8, 9, 10] | 3      || 6
        "list is empty; "                                   | []                              | 1      || -1
    }

    @Unroll
    def "iterative binary search - #scenario"() {
        when:
        def targetIndex = SearchUtil.iterativeBinarySearch(list, target)

        then:
        assert targetIndex == expectedIndex

        where:
        scenario                                                                                 | list                            | target || expectedIndex
        "list is sorted ascending; target is first element"                                      | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 1      || 0
        "list is sorted ascending; target is last element"                                       | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 10     || 9
        "list is sorted ascending; target is the middle"                                         | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 5      || 4
        "list is sorted ascending; target is not included"                                       | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 11     || -1
        "list is not sorted; target included - expected index is -1, since list must be sorted!" | [1, 2, 7, 4, 5, 6, 3, 8, 9, 10] | 3      || -1
        "list is empty; "                                                                        | []                              | 1      || -1
    }

    @Unroll
    def "recursive binary search - #scenario"() {
        when:
        def includedInList = SearchUtil.recursiveBinarySearch(list, target)

        then:
        assert includedInList == expectedResult

        where:
        scenario                                                                                     | list                            | target || expectedResult
        "list is sorted ascending; target is first element"                                          | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 1      || true
        "list is sorted ascending; target is last element"                                           | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 10     || true
        "list is sorted ascending; target is the middle"                                             | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 5      || true
        "list is sorted ascending; target is not included"                                           | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 11     || false
        "list is not sorted; target included - expected result is false, since list must be sorted!" | [1, 2, 7, 4, 5, 6, 3, 8, 9, 10] | 3      || false
        "list is empty; "                                                                            | []                              | 1      || false
    }
}
