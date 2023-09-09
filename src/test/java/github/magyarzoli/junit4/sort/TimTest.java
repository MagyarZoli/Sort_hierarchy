package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Tim;

@SuppressWarnings("rawtypes")
public class TimTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Tim();
    }
}