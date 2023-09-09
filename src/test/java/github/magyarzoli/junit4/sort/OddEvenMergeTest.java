package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.OddEvenMerge;

@SuppressWarnings("rawtypes")
public class OddEvenMergeTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new OddEvenMerge();
    }
}