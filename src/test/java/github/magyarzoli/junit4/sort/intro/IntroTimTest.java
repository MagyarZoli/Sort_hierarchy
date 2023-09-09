package github.magyarzoli.junit4.sort.intro;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.intro.IntroTim;

@SuppressWarnings("rawtypes")
public class IntroTimTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new IntroTim();
    }
}