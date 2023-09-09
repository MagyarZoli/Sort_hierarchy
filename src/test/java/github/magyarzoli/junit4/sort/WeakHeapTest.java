package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.WeakHeap;

@SuppressWarnings("rawtypes")
public class WeakHeapTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new WeakHeap();
    }
}