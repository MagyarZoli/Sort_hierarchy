package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.TernaryHeap;

@SuppressWarnings("rawtypes")
public class TernaryHeapTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new TernaryHeap();
    }
}