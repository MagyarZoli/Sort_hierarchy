package github.magyarzoli.junit4.sort.intro;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.intro.IntroHeap;

@SuppressWarnings("rawtypes")
public class IntroHeapTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new IntroHeap();
    }
}