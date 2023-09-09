package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Wiki;

@SuppressWarnings("rawtypes")
public class WikiTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Wiki();
    }
}