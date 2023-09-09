package github.magyarzoli.junit4.sort;

import github.magyarzoli.Sorter;
import github.magyarzoli.junit4.SorterTest;
import github.magyarzoli.sort.Cocktail;

@SuppressWarnings("rawtypes")
public class CocktailTest
        extends SorterTest {

    @Override
    public Sorter selectSorter() {
        return new Cocktail();
    }
}