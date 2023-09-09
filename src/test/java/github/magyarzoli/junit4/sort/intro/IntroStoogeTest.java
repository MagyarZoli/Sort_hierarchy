package github.magyarzoli.junit4.sort.intro;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.intro.IntroStooge;

@SuppressWarnings("rawtypes")
public class IntroStoogeTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new IntroStooge();
    }
}