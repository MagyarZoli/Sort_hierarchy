package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Merge3;

@SuppressWarnings("rawtypes")
public class Merge3Test
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Merge3();
    }
}