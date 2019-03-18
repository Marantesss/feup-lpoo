package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {

    List<Integer> list;

    /**
     * NOTE: We need to add the object being tested an attribute
     * Methods with a @Before annotation are called before each test
     */
    @Before
    public void createAggregators() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);
        int sum = aggregator.sum();
        assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);
        int max = aggregator.max();
        assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);
        int min = aggregator.min();
        assertEquals(1, min);
    }

    @Test
    public void distinct() {

        ListAggregator aggregator = new ListAggregator(list);

        class DeduplicateStub implements IListDeduplicator {
            @Override
            public List<Integer> deduplicate(IListSorter sorter) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(4);
                list.add(5);
                return list;
            }
        }

        class SorterStub implements IListSorter {
            @Override
            public List<Integer> sort() {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(2);
                list.add(4);
                list.add(5);
                return list;
            }
        }

        int distinct = aggregator.distinct(new DeduplicateStub(), new SorterStub());

        assertEquals(4, distinct);
    }

    /**
     * Created a list with values "-1, -4 and -5".
     *
     * Tried to calculate the maximum of these values but got 0 instead of -1.
     */
    @Test
    public void bug_7263() {
        List<Integer> bugList = new ArrayList<>();
        bugList.add(-1);
        bugList.add(-4);
        bugList.add(-5);

        ListAggregator aggregator = new ListAggregator(bugList);

        int max = aggregator.max();
        assertEquals(-1, max);
    }

    /**
     * Created a list with values "1, 2, 4 and 2".
     *
     * Tried to calculate the number of distinct values in the list but got 4 instead of 3.
     */
    @Test
    public void bug_8726() {
        List<Integer> bugList = new ArrayList<>();
        bugList.add(1);
        bugList.add(2);
        bugList.add(4);
        bugList.add(2);

        class DeduplicatorStub implements IListDeduplicator {
            @Override
            public List<Integer> deduplicate(IListSorter sorter) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(4);
                return list;
            }
        }

        class SorterStub implements IListSorter {
            @Override
            public List<Integer> sort() {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(2);
                list.add(4);
                return list;
            }
        }

        ListAggregator aggregator = new ListAggregator(bugList);

        int distinct = aggregator.distinct(new DeduplicatorStub(), new SorterStub());
        assertEquals(3, distinct);
    }
}
