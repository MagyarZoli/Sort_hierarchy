package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Pancake;

@SuppressWarnings("rawtypes")
public class PancakeTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Pancake();
    }
}