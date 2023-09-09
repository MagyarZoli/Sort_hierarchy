package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.OddEven;

@SuppressWarnings("rawtypes")
public class OddEvenTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new OddEven();
    }
}