package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.DualPivotQuick;

@SuppressWarnings("rawtypes")
public class DualPivotQuickTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new DualPivotQuick();
    }
}