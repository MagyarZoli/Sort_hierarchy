package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Quick;

@SuppressWarnings("rawtypes")
public class QuickTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Quick();
    }
}