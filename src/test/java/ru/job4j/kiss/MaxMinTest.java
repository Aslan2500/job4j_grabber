package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void whenMax() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(1);
        list.add(2);
        list.add(30);
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Integer::compareTo;
        assertThat(maxMin.max(list, comparator), is(30));
    }

    @Test
    public void whenMin() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(1);
        list.add(2);
        list.add(30);
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Integer::compareTo;
        assertThat(maxMin.min(list, comparator), is(1));
    }
}