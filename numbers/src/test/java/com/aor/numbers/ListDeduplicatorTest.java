package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    private List<Integer> list;

    @Before
    public void createDeduplicators() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void deduplicate() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new ListSorter(list));

        assertEquals(expected, distinct);
    }

    /**
     * Created a list with values "1, 2, 4 and 2".
     *
     * Tried to calculate the number of distinct values in the list but got 4 instead of 3.
     */
    @Test
    public void bug_8726() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        class SorterStub implements IListSorter {
            @Override
            public List<Integer> sort() {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(4);
                return list;
            }
        }

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new SorterStub());

        assertEquals(expected, distinct);
    }
}