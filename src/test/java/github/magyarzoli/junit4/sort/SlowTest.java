package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Slow;

@SuppressWarnings("rawtypes")
public class SlowTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        setLength(5);
        return new Slow();
    }
}