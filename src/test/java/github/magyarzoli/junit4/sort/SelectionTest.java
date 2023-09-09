package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Selection;

@SuppressWarnings("rawtypes")
public class SelectionTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Selection();
    }
}