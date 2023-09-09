package github.magyarzoli.junit4.sort.intro;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.intro.IntroPermutation;

@SuppressWarnings("rawtypes")
public class IntroPermutationTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        setLength(20);
        return new IntroPermutation();
    }
}