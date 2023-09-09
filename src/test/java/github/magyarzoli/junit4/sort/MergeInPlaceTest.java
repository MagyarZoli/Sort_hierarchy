package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.MergeInPlace;

@SuppressWarnings("rawtypes")
public class MergeInPlaceTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new MergeInPlace();
    }
}