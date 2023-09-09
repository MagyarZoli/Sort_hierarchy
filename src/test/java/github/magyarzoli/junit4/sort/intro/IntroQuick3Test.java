package github.magyarzoli.junit4.sort.intro;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.intro.IntroQuick3;

@SuppressWarnings("rawtypes")
public class IntroQuick3Test
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new IntroQuick3();
    }
}