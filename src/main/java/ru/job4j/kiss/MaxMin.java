package ru.job4j.kiss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator).get(1);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator).get(0);
    }

    public static <T> List<T> compare(List<T> value, Comparator<T> comparator) {
        T min = value.get(0);
        T max = value.get(0);
        for (T val : value) {
            if (comparator.compare(min, val) > 0) {
                min = val;
            } else if (comparator.compare(max, val) < 0) {
                max = val;
            }
        }
        List<T> rsl = new ArrayList<>();
        rsl.add(min);
        rsl.add(max);
        return rsl;
    }
}
