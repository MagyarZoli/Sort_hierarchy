package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Shell;

@SuppressWarnings("rawtypes")
public class ShellTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Shell();
    }
}