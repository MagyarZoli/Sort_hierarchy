package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Comb;

@SuppressWarnings("rawtypes")
public class CombTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Comb();
    }
}