package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Stooge;

@SuppressWarnings("rawtypes")
public class StoogeTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Stooge();
    }
}