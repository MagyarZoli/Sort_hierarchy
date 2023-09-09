package github.magyarzoli.junit4.sort.intro;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.intro.IntroBogo;

@SuppressWarnings("rawtypes")
public class IntroBogoTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        setLength(20);
        return new IntroBogo();
    }
}