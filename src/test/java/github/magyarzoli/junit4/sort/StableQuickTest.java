package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.StableQuick;

@SuppressWarnings("rawtypes")
public class StableQuickTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new StableQuick();
    }
}