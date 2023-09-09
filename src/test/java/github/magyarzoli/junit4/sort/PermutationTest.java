package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Permutation;

@SuppressWarnings("rawtypes")
public class PermutationTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        setLength(2);
        return new Permutation();
    }
}