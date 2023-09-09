package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.BatcherOddEvenMerge;

@SuppressWarnings("rawtypes")
public class BatcherOddEvenMergeTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new BatcherOddEvenMerge();
    }
}