package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.DoubleSelection;

@SuppressWarnings("rawtypes")
public class DoubleSelectionTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new DoubleSelection();
    }
}