package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Merge;

@SuppressWarnings("rawtypes")
public class MergeTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Merge();
    }
}