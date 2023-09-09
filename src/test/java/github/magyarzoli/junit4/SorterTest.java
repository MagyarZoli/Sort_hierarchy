package github.magyarzoli.junit4;

import github.magyarzoli.Sorter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static github.magyarzoli.Sort.*;
import static github.magyarzoli.SortType.*;
import static github.magyarzoli.auxiliary.TestAuxiliary.classTypeArray;
import static github.magyarzoli.auxiliary.TestAuxiliary.classTypeList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Getter
@Setter
@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class SorterTest<T extends Comparable<T>, C extends Class<T>> {

    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private Sorter sorter;

    private T[] actualArray;
    private T[] expectedArray;
    private List<T> actualList;
    private List<T> expectedList;
    private int length = 1000;
    private int thread = 6;
    private Class<T> classType = (Class<T>) Integer.class;

    public abstract Sorter selectSorter();

    @Before
    public void setUp() {
        sorter = selectSorter();
        actualArray = classTypeArray(classType, length);
        expectedArray = Arrays.copyOf(actualArray, actualArray.length);
        actualList = classTypeList(classType, length);
        expectedList = new ArrayList<>(actualList);
    }

    @Test
    public void sortArrayIncTest() {
        Arrays.sort(expectedArray);
        sorter.sortArray(actualArray, INC);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayDecTest() {
        Arrays.sort(expectedArray, Comparator.reverseOrder());
        sorter.sortArray(actualArray, DEC);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayIncEnumTest() {
        Arrays.sort(expectedArray);
        sorter.sortArray(actualArray, INCREASING);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayDecEnumTest() {
        Arrays.sort(expectedArray, Comparator.reverseOrder());
        sorter.sortArray(actualArray, DECREASING);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayIncFunTest() {
        Arrays.sort(expectedArray);
        sorter.sortArray(actualArray, (a, b) -> a.compareTo(b) > 0);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayDecFunTest() {
        Arrays.sort(expectedArray, Comparator.reverseOrder());
        sorter.sortArray(actualArray, (a, b) -> a.compareTo(b) < 0);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayIncThreadTest() {
        Arrays.sort(expectedArray);
        sorter.sortArray(actualArray, INC, thread);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayDecThreadTest() {
        Arrays.sort(expectedArray, Comparator.reverseOrder());
        sorter.sortArray(actualArray, DEC, thread);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayIncEnumThreadTest() {
        Arrays.sort(expectedArray);
        sorter.sortArray(actualArray, INCREASING, thread);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayDecEnumThreadTest() {
        Arrays.sort(expectedArray, Comparator.reverseOrder());
        sorter.sortArray(actualArray, DECREASING, thread);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayIncFunThreadTest() {
        Arrays.sort(expectedArray);
        sorter.sortArray(actualArray, (a, b) -> a.compareTo(b) > 0, thread);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayDecFunThreadTest() {
        Arrays.sort(expectedArray, Comparator.reverseOrder());
        sorter.sortArray(actualArray, (a, b) -> a.compareTo(b) < 0, thread);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayNotTest() {
        sorter.sortArray(actualArray, NOT);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayNotEnumTest() {
        sorter.sortArray(actualArray, DO_NOT_CHANGE_IT);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayRevTest() {
        Arrays.sort(expectedArray, Collections.reverseOrder());
        sorter.sortArray(actualArray, REV);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayRevEnumTest() {
        Arrays.sort(expectedArray, Collections.reverseOrder());
        sorter.sortArray(actualArray, REVERSE_ORDER);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayNotThreadTest() {
        sorter.sortArray(actualArray, NOT, thread);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayNotEnumThreadTest() {
        sorter.sortArray(actualArray, DO_NOT_CHANGE_IT, thread);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayRevThreadTest() {
        Arrays.sort(expectedArray, Collections.reverseOrder());
        sorter.sortArray(actualArray, REV, thread);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortArrayRevEnumThreadTest() {
        Arrays.sort(expectedArray, Collections.reverseOrder());
        sorter.sortArray(actualArray, REVERSE_ORDER, thread);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void sortListIncTest() {
        Collections.sort(expectedList);
        sorter.sortList(actualList, INC);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListDecTest() {
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        sorter.sortList(actualList, DEC);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListIncEnumTest() {
        Collections.sort(expectedList);
        sorter.sortList(actualList, INCREASING);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListDecEnumTest() {
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        sorter.sortList(actualList, DECREASING);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListIncFunTest() {
        Collections.sort(expectedList);
        sorter.sortList(actualList, (a, b) -> a.compareTo(b) > 0);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListDecFunTest() {
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        sorter.sortList(actualList, (a, b) -> a.compareTo(b) < 0);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListIncThreadTest() {
        Collections.sort(expectedList);
        sorter.sortList(actualList, INC, thread);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListDecThreadTest() {
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        sorter.sortList(actualList, DEC, thread);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListIncEnumThreadTest() {
        Collections.sort(expectedList);
        sorter.sortList(actualList, INCREASING, thread);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListDecEnumThreadTest() {
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        sorter.sortList(actualList, DECREASING, thread);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListIncFunThreadTest() {
        Collections.sort(expectedList);
        sorter.sortList(actualList, (a, b) -> a.compareTo(b) > 0, thread);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListDecFunThreadTest() {
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        sorter.sortList(actualList, (a, b) -> a.compareTo(b) < 0, thread);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListNotTest() {
        sorter.sortList(actualList, NOT);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListNotEnumTest() {
        sorter.sortList(actualList, DO_NOT_CHANGE_IT);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListRevTest() {
        Collections.reverse(expectedList);
        sorter.sortList(actualList, REV);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListRevEnumTest() {
        Collections.reverse(expectedList);
        sorter.sortList(actualList, REVERSE_ORDER);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListNotThreadTest() {
        sorter.sortList(actualList, NOT, thread);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListNotEnumThreadTest() {
        sorter.sortList(actualList, DO_NOT_CHANGE_IT, thread);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListRevThreadTest() {
        Collections.reverse(expectedList);
        sorter.sortList(actualList, REV, thread);
        assertThat(actualList, is(expectedList));
    }

    @Test
    public void sortListRevEnumThreadTest() {
        Collections.reverse(expectedList);
        sorter.sortList(actualList, REVERSE_ORDER, thread);
        assertThat(actualList, is(expectedList));
    }

    @After
    public void tearDown() {
        Arrays.fill(actualArray, null);
        Arrays.fill(expectedArray, null);
        actualList.clear();
        expectedList.clear();
    }
}