package github.magyarzoli.junit4.sort.intro;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.intro.IntroMerge3;

@SuppressWarnings("rawtypes")
public class IntroMerge3Test
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new IntroMerge3();
    }
}