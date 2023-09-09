package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Heap;

@SuppressWarnings("rawtypes")
public class HeapTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Heap();
    }
}