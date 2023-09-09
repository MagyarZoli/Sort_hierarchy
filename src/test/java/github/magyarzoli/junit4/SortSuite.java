package github.magyarzoli.junit4;

import github.magyarzoli.junit4.sort.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BatcherOddEvenMergeTest.class,
        BogoTest.class,
        BozoTest.class,
        BubbleTest.class,
        CocktailTest.class,
        CombTest.class,
        DoubleSelectionTest.class,
        DualPivotQuickTest.class,
        GnomeTest.class,
        HeapTest.class,
        InsertionTest.class,
        Merge3Test.class,
        MergeInPlaceTest.class,
        MergeInsertionTest.class,
        MergeTest.class,
        OddEvenMergeTest.class,
        OddEvenTest.class,
        PancakeTest.class,
        PermutationTest.class,
        Quick3Test.class,
        QuickTest.class,
        SelectionTest.class,
        ShellTest.class,
        SlowTest.class,
        SmoothHeapTest.class,
        StableQuickTest.class,
        StoogeTest.class,
        TernaryHeapTest.class,
        TimTest.class,
        WeakHeapTest.class,
        WeaveMergeTest.class,
        WikiTest.class
})
public class SortSuite {}