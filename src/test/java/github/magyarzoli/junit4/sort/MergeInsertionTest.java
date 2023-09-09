package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.MergeInsertion;

@SuppressWarnings("rawtypes")
public class MergeInsertionTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new MergeInsertion();
    }
}