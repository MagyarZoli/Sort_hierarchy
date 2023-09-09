package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Gnome;

@SuppressWarnings("rawtypes")
public class GnomeTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Gnome();
    }
}