package github.magyarzoli.junit4.sort.intro;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.intro.IntroWiki;

@SuppressWarnings("rawtypes")
public class IntroWikiTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new IntroWiki();
    }
}