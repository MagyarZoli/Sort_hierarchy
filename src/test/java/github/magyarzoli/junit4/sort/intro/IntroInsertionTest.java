package github.magyarzoli.junit4.sort.intro;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.sort.InsertionTest;
import github.magyarzoli.sort.intro.IntroInsertion;

@SuppressWarnings("rawtypes")
public class IntroInsertionTest
        extends InsertionTest {

    @Override
    public Sorter selectSorter() {
        return new IntroInsertion();
    }
}