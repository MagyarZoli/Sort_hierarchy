package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.WeaveMerge;

@SuppressWarnings("rawtypes")
public class WeaveMergeTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new WeaveMerge();
    }
}