package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Insertion;

@SuppressWarnings("rawtypes")
public class InsertionTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Insertion();
    }
}