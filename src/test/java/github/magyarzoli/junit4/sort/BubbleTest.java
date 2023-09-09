package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Bubble;

@SuppressWarnings("rawtypes")
public class BubbleTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Bubble();
    }
}