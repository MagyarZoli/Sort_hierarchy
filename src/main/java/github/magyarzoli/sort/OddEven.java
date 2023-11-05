package github.magyarzoli.sort;

import github.magyarzoli.SortFunctional;
import github.magyarzoli.SortSwap;
import github.magyarzoli.sort.intro.IntroOddEven;

import java.util.List;

/**
 * The Odd-even (Brick) Sort algorithm is a variation of the Bubble Sort algorithm that is specifically designed to
 * sort arrays in parallel.
 * It works by comparing and swapping adjacent elements in pairs repeatedly until the array is sorted.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class OddEven
        extends Bubble {

    /**
     * <b>Odd-even (Brick) Sort:</b><br>
     * The Odd-even Sort algorithm is a variation of the Bubble Sort algorithm that is specifically designed to sort
     * arrays in parallel.
     * It works by comparing and swapping adjacent elements in pairs repeatedly until the array is sorted.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Repeat the following steps until the array is sorted:</li>
     *     <li>Compare and swap adjacent elements in pairs, starting from the first and second elements.</li>
     *     <li>Compare and swap adjacent elements in pairs, starting from the second and third elements.</li>
     *     <li>Continue alternating between odd and even adjacent element comparisons and swaps until the last pair of
     *     elements.</li>
     *     <li>After each iteration, the largest element in the unsorted portion of the array will move to its correct
     *     position at the end.</li>
     *     <li>Repeat the above steps until the entire array is sorted.</li>
     * </ol>
     * <b>Note:</b><br>
     * The odd-even sort algorithm works well for parallel computing because
     * the comparisons and swaps can be performed independently on different pairs of elements.
     * However, it is not as efficient as some other sorting algorithms,
     * and it has a worst-case time complexity of <em>O(n^2)</em>, where n is the number of elements to be
     * sorted.<br><br>
     * Transposition sort is a stable sorting algorithm.
     * This means that it maintains the relative order of elements with equal values during the sorting process.
     * If two elements have the same value,
     * the algorithm will not swap them unless their relative order is disturbed by other adjacent elements.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n^2)</em><br>
     * Average Case Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>Yes</b>
     * @see         IntroOddEven#IntroOddEven() IntroOddEven
     * @see         OddEvenMerge#OddEvenMerge() OddEvenMerge
     */
    public OddEven() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        oddEvenInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        oddEvenDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        oddEven(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        oddEvenInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        oddEvenDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        oddEven(list, functional);
    }

    /**
     * {@code oddEvenInc} that takes an array of {@link java.lang.Comparable Comparable} objects as a parameter.
     * The method aims to sort the array in an incremental order using the odd-even sort algorithm.
     * <ul>
     *     <li>The method begins by initializing a boolean variable named {@code isSorted} to false.
     *     This variable will serve as a flag to indicate whether the array is sorted or not.</li>
     *     <li>There is a {@code while} loop that continues until {@code isSorted} is {@code true}.
     *     Within the loop, the value of {@code isSorted} is set to {@code true} to assume that the array is already
     *     sorted.</li>
     *     <li>The {@code indexedElementInc} method is then called twice within the loop.
     *     <li>The first call passes the array, index <i>1</i>, and the length of the {@code array} as parameters.</li>
     *     <li>The second call passes the array, index <i>0</i>, and the length of the {@code array} as parameters.</li>
     *     <li>The purpose of these calls is to check if the indexed elements of the array are sorted in incremental
     *     order.
     *     The {@code indexedElementInc} method, returns {@code true}
     *     if the elements at the specified indices do not require any swaps to achieve incremental order,
     *     and {@code false} otherwise.</li>
     *     <li>If any of the {@code indexedElementInc} calls return {@code false}, it means that at least one swap was
     *     performed to achieve the desired order.
     *     In such cases, the isSorted variable is set to {@code false}, indicating that the array is not completely
     *     sorted.</li>
     *     <li>The {@code while} loop continues until both {@code indexedElementInc} calls return {@code true},
     *     indicating that the entire array is sorted in incremental order.</li>
     * </ul>
     * {@code oddEvenInc} method repeatedly calls the {@code indexedElementInc} method on alternating indices to sort
     * the array using
     * the odd-even sort algorithm until the entire array is sorted in incremental order.
     * @param       array to be arranged.
     * @see         OddEven#indexedElementInc(Comparable[], int, int)
     */
    protected void oddEvenInc(Comparable[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = indexedElementInc(array, 1, array.length);
            isSorted = indexedElementInc(array, 0, array.length);
        }
    }

    /**
     * {@code oddEvenDec} that takes an array of {@link java.lang.Comparable Comparable} objects as a parameter.
     * The method aims to sort the array in a decremental order using the odd-even sort algorithm.
     * <ul>
     *     <li>The method begins by initializing a boolean variable named {@code isSorted} to false.
     *     This variable will serve as a flag to indicate whether the array is sorted or not.</li>
     *     <li>There is a {@code while} loop that continues until {@code isSorted} is {@code true}.
     *     Within the loop, the value of {@code isSorted} is set to {@code true} to assume that the array is already
     *     sorted.</li>
     *     <li>The {@code indexedElementDec} method is then called twice within the loop.</li>
     *     <li>The first call passes the array, index <i>1</i>, and the length of the {@code array} as parameters.</li>
     *     <li>The second call passes the array, index <i>0</i>, and the length of the {@code array} as parameters.</li>
     *     <li>The purpose of these calls is to check if the indexed elements of the array are sorted in decremental
     *     order.
     *     The {@code indexedElementDec} method, returns {@code true}
     *     if the elements at the specified indices do not require any swaps to achieve decremental order,
     *     and {@code false} otherwise.</li>
     *     <li>If any of the {@code indexedElementDec} calls return {@code false}, it means that at least one swap was
     *     performed to achieve the desired order.
     *     In such cases, the isSorted variable is set to {@code false}, indicating that the array is not completely
     *     sorted.</li>
     *     <li>The {@code while} loop continues until both {@code indexedElementDec} calls return {@code true},
     *     indicating that the entire array is sorted in decremental order.</li>
     * </ul>
     * {@code oddEvenInc} method repeatedly calls the {@code indexedElementDec} method on alternating indices to sort
     * the array using
     * the odd-even sort algorithm until the entire array is sorted in decremental order.
     * @param       array to be arranged.
     * @see         OddEven#indexedElementDec(Comparable[], int, int)
     */
    protected void oddEvenDec(Comparable[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = indexedElementDec(array, 1, array.length);
            isSorted = indexedElementDec(array, 0, array.length);
        }
    }

    /**
     * {@code oddEven} method you provided takes an array {@code array} of type {@link java.lang.Comparable Comparable},
     * and an instance of the {@code SortFunctional<Comparable>} interface as parameters.
     * It performs the odd-even sort algorithm on the elements within the specified range.
     * <ul>
     *     <li>The method initializes a boolean variable {@code isSorted} with the value {@code false}.
     *     This variable will be used to determine if the array is fully sorted.</li>
     *     <li>It enters a while loop that continues until the array is sorted ({@code isSorted} is {@code true}).</li>
     *     <li>Inside the while loop, it sets {@code isSorted} to {@code true} to assume that the array is sorted
     *     initially.</li>
     *     <li>It then calls the {@code indexedElement} method twice:</li>
     *     <li>The first call checks if the elements starting from <i>1</i> and progressing
     *     by steps of <i>2</i> {@code (i += 2)} are in the correct order according to the given {@code functional}
     *     interface.
     *     This is done by passing <i>1</i> as the {@code j} parameter and {@code array.length} as the {@code n}
     *     parameter to the {@code indexedElement} method.
     *     If any adjacent pair of elements is found to require swapping, {@code indexedElement} returns {@code false},
     *     indicating that the array is not yet fully sorted.
     *     In this case, the {@code isSorted} variable is set to {@code false}.</li>
     *     <li>The second call checks if the elements starting from <i>0</i> and progressing
     *     by steps of <i>2</i> {@code (i += 2)} are in the correct order according to the given {@code functional}
     *     interface.
     *     This is done by passing <i>0</i> as the {@code j} parameter and {@code array.length} as the {@code n}
     *     parameter to the {@code indexedElement} method.
     *     Similarly, if any adjacent pair of elements requires swapping, {@code indexedElement} returns {@code false},
     *     and the {@code isSorted} variable is set to {@code false}.</li>
     *     <li>After both calls to {@code indexedElement}, if no adjacent pair of elements required swapping,
     *     {@code isSorted} remains {@code true},
     *     indicating that the array is fully sorted.</li>
     *     <li>The while loop continues until {@code isSorted} is {@code true},
     *     which means the array is sorted.</li>
     * </ul>
     * {@code oddEven} method sorts a specific range of the {@code array} using the odd-even sort algorithm
     * by repeatedly calling the {@code indexedElement} method on alternating indices within the range until the range
     * is completely sorted.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         OddEven#indexedElement(Comparable[], int, int, SortFunctional)
     */
    protected void oddEven(Comparable[] array, SortFunctional<Comparable> functional) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = indexedElement(array, 1, array.length, functional);
            isSorted = indexedElement(array, 0, array.length, functional);
        }
    }

    /**
     * {@code oddEvenInc} that takes an array of {@link java.lang.Comparable Comparable} objects,
     * an integer {@code left}, and an integer {@code right}.
     * The method aims to sort the array in an incremental order using the odd-even sort algorithm.
     * <ul>
     *     <li>The method starts by initializing a boolean variable named {@code isSorted} to {@code false},
     *     indicating that the array range is initially unsorted.</li>
     *     <li>there is a {@code while} loop that continues until {@code isSorted} is {@code true}.
     *     Within the loop, the value of {@code isSorted} is set to {@code true}
     *     to assume that the {@code array} range is already sorted.</li>
     *     <li>The {@code indexedElementInc} method is called twice within the loop.</li>
     *     <li>The first call passes the array, {@code (left + 1)}, and {@code right} as parameters.</li>
     *     <li>The second call passes the array, {@code left}, and {@code right} as parameters.</li>
     *     <li>The purpose of these calls is to check if the indexed elements of the array range are sorted in
     *     incremental order.
     *     The {@code indexedElementInc} method, as previously discussed,
     *     returns {@code true} if the elements at the specified indices within the range do not require any swaps to
     *     achieve incremental order,
     *     and {@code false} otherwise.</li>
     *     <li>If any of the {@code indexedElementInc} calls return {@code false},
     *     indicating that at least one swap was performed within the range,
     *     the {@code isSorted} variable is set to false,
     *     indicating that the array range is not completely sorted.</li>
     *     <li>The {@code while} loop continues until both {@code indexedElementInc} calls return {@code true},
     *     indicating that the specified array range is sorted in incremental order.</li>
     * </ul>
     * {@code oddEvenInc} method sorts a specific range of the {@code array} using the odd-even sort algorithm
     * by repeatedly calling the {@code indexedElementInc} method on alternating indices within the range until the
     * range is completely sorted.
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       right specific range of the array.
     * @see         OddEven#indexedElementInc(Comparable[], int, int)
     */
    protected void oddEvenInc(Comparable[] array, int left, int right) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = indexedElementInc(array, (left + 1), right);
            isSorted = indexedElementInc(array, left, right);
        }
    }

    /**
     * {@code oddEvenDec} that takes an array of {@link java.lang.Comparable Comparable} objects,
     * an integer {@code left}, and an integer {@code right}.
     * The method aims to sort the array in a decremental order using the odd-even sort algorithm.
     * <ul>
     *     <li>The method starts by initializing a boolean variable named {@code isSorted} to {@code false},
     *     indicating that the array range is initially unsorted.</li>
     *     <li>there is a {@code while} loop that continues until {@code isSorted} is {@code true}.
     *     Within the loop, the value of {@code isSorted} is set to {@code true}
     *     to assume that the {@code array} range is already sorted.</li>
     *     <li>The {@code indexedElementDec} method is called twice within the loop.</li>
     *     <li>The first call passes the array, {@code (left + 1)}, and {@code right} as parameters.</li>
     *     <li>The second call passes the array, {@code left}, and {@code right} as parameters.</li>
     *     <li>The purpose of these calls is to check if the indexed elements of the array range are sorted in
     *     decremental order.
     *     The {@code indexedElementDec} method, as previously discussed,
     *     returns {@code true} if the elements at the specified indices within the range do not require any swaps to
     *     achieve decremental order,
     *     and {@code false} otherwise.</li>
     *     <li>If any of the {@code indexedElementDec} calls return {@code false},
     *     indicating that at least one swap was performed within the range,
     *     the {@code isSorted} variable is set to false,
     *     indicating that the array range is not completely sorted.</li>
     *     <li>The {@code while} loop continues until both {@code indexedElementDec} calls return {@code true},
     *     indicating that the specified array range is sorted in decremental order.</li>
     * </ul>
     * {@code oddEvenDec} method sorts a specific range of the {@code array} using the odd-even sort algorithm
     * by repeatedly calling the {@code indexedElementDec} method on alternating indices within the range until the
     * range is completely sorted.
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       right specific range of the array.
     * @see         OddEven#indexedElementDec(Comparable[], int, int)
     */
    protected void oddEvenDec(Comparable[] array, int left, int right) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = indexedElementDec(array, (left + 1), right);
            isSorted = indexedElementDec(array, left, right);
        }
    }

    /**
     * {@code oddEven} method you provided takes an array {@code array} of type {@link java.lang.Comparable Comparable},
     * an integer {@code left}, an integer {@code right},
     * and an instance of the {@code SortFunctional<Comparable>} interface as parameters.
     * It performs the odd-even sort algorithm on the elements within the specified range.
     * <ul>
     *     <li>The method initializes a boolean variable {@code isSorted} with the value {@code false}.
     *     This variable will be used to determine if the array is fully sorted.</li>
     *     <li>It enters a while loop that continues until the array is sorted ({@code isSorted} is {@code true}).</li>
     *     <li>Inside the while loop, it sets {@code isSorted} to {@code true} to assume that the array is sorted
     *     initially.</li>
     *     <li>It then calls the {@code indexedElement} method twice:</li>
     *     <li>The first call checks if the elements starting from {@code (left + 1)} and progressing
     *     by steps of <i>2</i> {@code (i += 2)} are in the correct order according to the given {@code functional}
     *     interface.
     *     This is done by passing {@code (left + 1)} as the {@code j} parameter and {@code right} as the {@code n}
     *     parameter to the {@code indexedElement} method.
     *     If any adjacent pair of elements is found to require swapping, {@code indexedElement} returns {@code false},
     *     indicating that the array is not yet fully sorted.
     *     In this case, the {@code isSorted} variable is set to {@code false}.</li>
     *     <li>The second call checks if the elements starting from {@code left} and progressing
     *     by steps of <i>2</i> {@code (i += 2)} are in the correct order according to the given {@code functional}
     *     interface.
     *     This is done by passing {@code left} as the {@code j} parameter and {@code right} as the {@code n} parameter
     *     to the {@code indexedElement} method.
     *     Similarly, if any adjacent pair of elements requires swapping, {@code indexedElement} returns {@code false},
     *     and the {@code isSorted} variable is set to {@code false}.</li>
     *     <li>After both calls to {@code indexedElement}, if no adjacent pair of elements required swapping,
     *     {@code isSorted} remains {@code true},
     *     indicating that the array is fully sorted.</li>
     *     <li>The while loop continues until {@code isSorted} is {@code true},
     *     which means the array is sorted.</li>
     * </ul>
     * {@code oddEven} method sorts a specific range of the {@code array} using the odd-even sort algorithm
     * by repeatedly calling the {@code indexedElement} method on alternating indices within the range until the range
     * is completely sorted.
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       right specific range of the array.
     * @param       functional lambda expression for comparison.
     * @see         OddEven#indexedElement(Comparable[], int, int, SortFunctional)
     */
    protected void oddEven(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = indexedElement(array, (left + 1), right, functional);
            isSorted = indexedElement(array, left, right, functional);
        }
    }

    /**
     * {@code indexedElementInc} that takes an array of
     * {@link java.lang.Comparable Comparable} objects, an integer {@code j}, and an integer {@code n} as parameters.
     * The method iterates through the array elements starting from index {@code j}
     * and incrementing the index by <i>2</i> in each iteration until reaching {@code (n - 2)}.
     * <ul>
     *     <li>Within the {@code for} loop, the method calls another method named {@code isSwapInc} and passes the
     *     array, the current index {@code i}, and the value <i>1</i> as parameters.</li>
     *     <li>If the {@code isSwapInc} method returns {@code true},
     *     indicating that swapping the elements would result in an incremental order,
     *     the element variable is set to {@code false},
     *     indicating that there was at least one swap required to achieve the desired order.</li>
     * </ul>
     * {@code indexedElementInc} the method returns the value of the element variable,
     * which would be {@code true} if no swaps were needed or
     * {@code false} if at least one swap occurred.
     * @param       array to be arranged.
     * @param       j the array elements starting from index.
     * @param       n the array elements ending from index.
     * @return      true if there was no exchange.<br>
     *              false if there was at least <i>1</i> exchange.
     * @see         SortSwap#isSwapInc(Comparable[], int, int)
     */
    protected boolean indexedElementInc(Comparable[] array, int j, int n) {
        boolean element = true;
        for (int i = j; i <= (n - 2); i += 2) {
            if (isSwapInc(array, i, 1)) element = false;
        }
        return element;
    }

    /**
     * {@code indexedElementDec} that takes an array of
     * {@link java.lang.Comparable Comparable} objects, an integer {@code j}, and an integer {@code n} as parameters.
     * The method iterates through the array elements starting from index {@code j}
     * and incrementing the index by <i>2</i> in each iteration until reaching {@code (n - 2)}.
     * <ul>
     *     <li>Within the {@code for} loop, the method calls another method named {@code isSwapDec} and passes the
     *     array, the current index {@code i}, and the value <i>1</i> as parameters.</li>
     *     <li>If the {@code isSwapDec} method returns {@code true},
     *     indicating that swapping the elements would result in and decremental order,
     *     the element variable is set to {@code false},
     *     indicating that there was at least one swap required to achieve the desired order.</li>
     * </ul>
     * {@code indexedElementDec} the method returns the value of the element variable,
     * which would be {@code true} if no swaps were needed or
     * {@code false} if at least one swap occurred.
     * @param       array to be arranged.
     * @param       j the array elements starting from index.
     * @param       n the array elements ending from index.
     * @return      true if there was no exchange.<br>
     *              false if there was at least <i>1</i> exchange.
     * @see         SortSwap#isSwapInc(Comparable[], int, int)
     */
    protected boolean indexedElementDec(Comparable[] array, int j, int n) {
        boolean element = true;
        for (int i = j; i <= (n - 2); i += 2) {
            if (isSwapDec(array, i, 1)) element = false;
        }
        return element;
    }

    /**
     * {@code indexedElement} method you provided takes an array {@code array} of type {@link java.lang.Comparable
     * Comparable},
     * an integer {@code j}, an integer {@code n}, and an instance of the {@code SortFunctional<Comparable>} interface
     * as parameters.
     * <ul>
     *     <li>The method initializes a boolean variable {@code element} with the value {@code true}.
     *     This variable will be used to keep track of whether the indexed element at position {@code j} satisfies the
     *     condition.</li>
     *     <li>It enters a for loop that iterates from {@code j} to {@code (n - 2)} in steps of <i>1</i>.
     *     This means it only considers elements at even indices within the specified range.</li>
     *     <li>Inside the loop, it checks if the element at index {@code i} should be swapped with
     *     the adjacent element at index {@code (i + 1)} based on the given {@code functional} interface.
     *     The {@code isSwap} method is used to perform the comparison.</li>
     *     <li>If the {@code isSwap} method returns {@code true} for any pair of adjacent elements,
     *     it means the condition is not satisfied.
     *     In this case, the element variable is set to {@code false} to indicate that
     *     the indexed element at position {@code j} does not meet the condition.</li>
     *     <li>After the loop completes, the method returns the value of the {@code element} variable.</li>
     * </ul>
     * {@code indexedElementDec} the method returns the value of the element variable,
     * which would be {@code true} if no swaps were needed or
     * {@code false} if at least one swap occurred.
     * @param       array to be arranged.
     * @param       j the array elements starting from index.
     * @param       n the array elements ending from index.
     * @param       functional lambda expression for comparison.
     * @return      true if there was no exchange.<br>
     *              false if there was at least <i>1</i> exchange.
     * @see         SortSwap#isSwap(Comparable[], int, int, SortFunctional)
     */
    protected boolean indexedElement(Comparable[] array, int j, int n, SortFunctional<Comparable> functional) {
        boolean element = true;
        for (int i = j; i <= (n - 2); i += 2) {
            if (isSwap(array, i, 1, functional)) element = false;
        }
        return element;
    }

    /**
     * {@code oddEvenInc} that takes a list of {@link java.lang.Comparable Comparable} objects as a parameter.
     * The method aims to sort the list in an incremental order using the odd-even sort algorithm.
     * <ul>
     *     <li>The method begins by initializing a boolean variable named {@code isSorted} to false.
     *     This variable will serve as a flag to indicate whether the list is sorted or not.</li>
     *     <li>There is a {@code while} loop that continues until {@code isSorted} is {@code true}.
     *     Within the loop, the value of {@code isSorted} is set to {@code true} to assume that the list is already
     *     sorted.</li>
     *     <li>The {@code indexedElementInc} method is then called twice within the loop.
     *     <li>The first call passes the list, index <i>1</i>, and the length of the {@code list} as parameters.</li>
     *     <li>The second call passes the list, index <i>0</i>, and the length of the {@code list} as parameters.</li>
     *     <li>The purpose of these calls is to check if the indexed elements of the list are sorted in incremental
     *     order. The {@code indexedElementInc} method, returns {@code true}
     *     if the elements at the specified indices do not require any swaps to achieve incremental order,
     *     and {@code false} otherwise.</li>
     *     <li>If any of the {@code indexedElementInc} calls return {@code false}, it means that at least one swap was
     *     performed to achieve the desired order.
     *     In such cases, the isSorted variable is set to {@code false}, indicating that the list is not completely sorted.</li>
     *     <li>The {@code while} loop continues until both {@code indexedElementInc} calls return {@code true},
     *     indicating that the entire list is sorted in incremental order.</li>
     * </ul>
     * {@code oddEvenInc} method repeatedly calls the {@code indexedElementInc} method on alternating indices to sort the list using
     * the odd-even sort algorithm until the entire list is sorted in incremental order.
     * @param       list to be arranged.
     * @see         OddEven#indexedElementInc(List, int, int)
     */
    protected <L extends Comparable> void oddEvenInc(List<L> list) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = indexedElementInc(list, 1, list.size());
            isSorted = indexedElementInc(list, 0, list.size());
        }
    }

    /**
     * {@code oddEvenDec} that takes an list of {@link java.lang.Comparable Comparable} objects as a parameter.
     * The method aims to sort the list in a decremental order using the odd-even sort algorithm.
     * <ul>
     *     <li>The method begins by initializing a boolean variable named {@code isSorted} to false.
     *     This variable will serve as a flag to indicate whether the list is sorted or not.</li>
     *     <li>There is a {@code while} loop that continues until {@code isSorted} is {@code true}.
     *     Within the loop, the value of {@code isSorted} is set to {@code true} to assume that the list is already
     *     sorted.</li>
     *     <li>The {@code indexedElementDec} method is then called twice within the loop.</li>
     *     <li>The first call passes the list, index <i>1</i>, and the length of the {@code list} as parameters.</li>
     *     <li>The second call passes the list, index <i>0</i>, and the length of the {@code list} as parameters.</li>
     *     <li>The purpose of these calls is to check if the indexed elements of the list are sorted in decremental
     *     order. The {@code indexedElementDec} method, returns {@code true}
     *     if the elements at the specified indices do not require any swaps to achieve decremental order,
     *     and {@code false} otherwise.</li>
     *     <li>If any of the {@code indexedElementDec} calls return {@code false}, it means that at least one swap was
     *     performed to achieve the desired order.
     *     In such cases, the isSorted variable is set to {@code false}, indicating that the list is not completely
     *     sorted.</li>
     *     <li>The {@code while} loop continues until both {@code indexedElementDec} calls return {@code true},
     *     indicating that the entire list is sorted in decremental order.</li>
     * </ul>
     * {@code oddEvenInc} method repeatedly calls the {@code indexedElementDec} method on alternating indices to sort
     * the list using
     * the odd-even sort algorithm until the entire list is sorted in decremental order.
     * @param       list to be arranged.
     * @see         OddEven#indexedElementDec(List, int, int)
     */
    protected <L extends Comparable> void oddEvenDec(List<L> list) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = indexedElementDec(list, 1, list.size());
            isSorted = indexedElementDec(list, 0, list.size());
        }
    }

    /**
     * {@code oddEven} method you provided takes a list {@code list} of type {@link java.lang.Comparable Comparable},
     * and an instance of the {@code SortFunctional<Comparable>} interface as parameters.
     * It performs the odd-even sort algorithm on the elements within the specified range.
     * <ul>
     *     <li>The method initializes a boolean variable {@code isSorted} with the value {@code false}.
     *     This variable will be used to determine if the list is fully sorted.</li>
     *     <li>It enters a while loop that continues until the list is sorted ({@code isSorted} is {@code true}).</li>
     *     <li>Inside the while loop, it sets {@code isSorted} to {@code true} to assume that the list is sorted
     *     initially.</li>
     *     <li>It then calls the {@code indexedElement} method twice:</li>
     *     <li>The first call checks if the elements starting from <i>1</i> and progressing
     *     by steps of <i>2</i> {@code (i += 2)} are in the correct order according to the given {@code functional}
     *     interface.
     *     This is done by passing <i>1</i> as the {@code j} parameter and {@code list.length} as the {@code n}
     *     parameter to the {@code indexedElement} method.
     *     If any adjacent pair of elements is found to require swapping, {@code indexedElement} returns {@code false},
     *     indicating that the list is not yet fully sorted.
     *     In this case, the {@code isSorted} variable is set to {@code false}.</li>
     *     <li>The second call checks if the elements starting from <i>0</i> and progressing
     *     by steps of <i>2</i> {@code (i += 2)} are in the correct order according to the given {@code functional}
     *     interface.
     *     This is done by passing <i>0</i> as the {@code j} parameter and {@code list.length} as the {@code n}
     *     parameter to the {@code indexedElement} method.
     *     Similarly, if any adjacent pair of elements requires swapping, {@code indexedElement} returns {@code false},
     *     and the {@code isSorted} variable is set to {@code false}.</li>
     *     <li>After both calls to {@code indexedElement}, if no adjacent pair of elements required swapping,
     *     {@code isSorted} remains {@code true},
     *     indicating that the list is fully sorted.</li>
     *     <li>The while loop continues until {@code isSorted} is {@code true},
     *     which means the list is sorted.</li>
     * </ul>
     * {@code oddEven} method sorts a specific range of the {@code list} using the odd-even sort algorithm
     * by repeatedly calling the {@code indexedElement} method on alternating indices within the range until the range
     * is completely sorted.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         OddEven#indexedElement(List, int, int, SortFunctional)
     */
    protected <L extends Comparable> void oddEven(List<L> list, SortFunctional<Comparable> functional) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = indexedElement(list, 1, list.size(), functional);
            isSorted = indexedElement(list, 0, list.size(), functional);
        }
    }

    /**
     * {@code oddEvenInc} that takes a list of {@link java.lang.Comparable Comparable} objects,
     * an integer {@code left}, and an integer {@code right}.
     * The method aims to sort the list in an incremental order using the odd-even sort algorithm.
     * <ul>
     *     <li>The method starts by initializing a boolean variable named {@code isSorted} to {@code false},
     *     indicating that the list range is initially unsorted.</li>
     *     <li>there is a {@code while} loop that continues until {@code isSorted} is {@code true}.
     *     Within the loop, the value of {@code isSorted} is set to {@code true}
     *     to assume that the {@code list} range is already sorted.</li>
     *     <li>The {@code indexedElementInc} method is called twice within the loop.</li>
     *     <li>The first call passes the list, {@code (left + 1)}, and {@code right} as parameters.</li>
     *     <li>The second call passes the list, {@code left}, and {@code right} as parameters.</li>
     *     <li>The purpose of these calls is to check if the indexed elements of the list range are sorted in
     *     incremental order.
     *     The {@code indexedElementInc} method, as previously discussed,
     *     returns {@code true} if the elements at the specified indices within the range do not require any swaps to
     *     achieve incremental order,
     *     and {@code false} otherwise.</li>
     *     <li>If any of the {@code indexedElementInc} calls return {@code false},
     *     indicating that at least one swap was performed within the range,
     *     the {@code isSorted} variable is set to false,
     *     indicating that the list range is not completely sorted.</li>
     *     <li>The {@code while} loop continues until both {@code indexedElementInc} calls return {@code true},
     *     indicating that the specified list range is sorted in incremental order.</li>
     * </ul>
     * {@code oddEvenInc} method sorts a specific range of the {@code list} using the odd-even sort algorithm
     * by repeatedly calling the {@code indexedElementInc} method on alternating indices within the range until the
     * range is completely sorted.
     * @param       list to be arranged.
     * @param       left specific range of the list.
     * @param       right specific range of the list.
     * @see         OddEven#indexedElementInc(List, int, int)
     */
    protected <L extends Comparable> void oddEvenInc(List<L> list, int left, int right) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = indexedElementInc(list, (left + 1), right);
            isSorted = indexedElementInc(list, left, right);
        }
    }

    /**
     * {@code oddEvenDec} that takes a list of {@link java.lang.Comparable Comparable} objects,
     * an integer {@code left}, and an integer {@code right}.
     * The method aims to sort the list in a decremental order using the odd-even sort algorithm.
     * <ul>
     *     <li>The method starts by initializing a boolean variable named {@code isSorted} to {@code false},
     *     indicating that the list range is initially unsorted.</li>
     *     <li>there is a {@code while} loop that continues until {@code isSorted} is {@code true}.
     *     Within the loop, the value of {@code isSorted} is set to {@code true}
     *     to assume that the {@code list} range is already sorted.</li>
     *     <li>The {@code indexedElementDec} method is called twice within the loop.</li>
     *     <li>The first call passes the list, {@code (left + 1)}, and {@code right} as parameters.</li>
     *     <li>The second call passes the list, {@code left}, and {@code right} as parameters.</li>
     *     <li>The purpose of these calls is to check if the indexed elements of the list range are sorted in
     *     decremental order.
     *     The {@code indexedElementDec} method, as previously discussed,
     *     returns {@code true} if the elements at the specified indices within the range do not require any swaps to
     *     achieve decremental order,
     *     and {@code false} otherwise.</li>
     *     <li>If any of the {@code indexedElementDec} calls return {@code false},
     *     indicating that at least one swap was performed within the range,
     *     the {@code isSorted} variable is set to false,
     *     indicating that the list range is not completely sorted.</li>
     *     <li>The {@code while} loop continues until both {@code indexedElementDec} calls return {@code true},
     *     indicating that the specified list range is sorted in decremental order.</li>
     * </ul>
     * {@code oddEvenDec} method sorts a specific range of the {@code list} using the odd-even sort algorithm
     * by repeatedly calling the {@code indexedElementDec} method on alternating indices within the range until the
     * range is completely sorted.
     * @param       list to be arranged.
     * @param       left specific range of the list.
     * @param       right specific range of the list.
     * @see         OddEven#indexedElementDec(List, int, int)
     */
    protected <L extends Comparable> void oddEvenDec(List<L> list, int left, int right) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = indexedElementDec(list, (left + 1), right);
            isSorted = indexedElementDec(list, left, right);
        }
    }

    /**
     * {@code oddEven} method you provided takes a list {@code list} of type {@link java.lang.Comparable Comparable},
     * an integer {@code left}, an integer {@code right},
     * and an instance of the {@code SortFunctional<Comparable>} interface as parameters.
     * It performs the odd-even sort algorithm on the elements within the specified range.
     * <ul>
     *     <li>The method initializes a boolean variable {@code isSorted} with the value {@code false}.
     *     This variable will be used to determine if the list is fully sorted.</li>
     *     <li>It enters a while loop that continues until the list is sorted ({@code isSorted} is {@code true}).</li>
     *     <li>Inside the while loop, it sets {@code isSorted} to {@code true} to assume that the list is sorted
     *     initially.</li>
     *     <li>It then calls the {@code indexedElement} method twice:</li>
     *     <li>The first call checks if the elements starting from {@code (left + 1)} and progressing
     *     by steps of <i>2</i> {@code (i += 2)} are in the correct order according to the given {@code functional}
     *     interface.
     *     This is done by passing {@code (left + 1)} as the {@code j} parameter and {@code right} as the {@code n}
     *     parameter to the {@code indexedElement} method.
     *     If any adjacent pair of elements is found to require swapping, {@code indexedElement} returns {@code false},
     *     indicating that the list is not yet fully sorted.
     *     In this case, the {@code isSorted} variable is set to {@code false}.</li>
     *     <li>The second call checks if the elements starting from {@code left} and progressing
     *     by steps of <i>2</i> {@code (i += 2)} are in the correct order according to the given {@code functional}
     *     interface.
     *     This is done by passing {@code left} as the {@code j} parameter and {@code right} as the {@code n} parameter
     *     to the {@code indexedElement} method.
     *     Similarly, if any adjacent pair of elements requires swapping, {@code indexedElement} returns {@code false},
     *     and the {@code isSorted} variable is set to {@code false}.</li>
     *     <li>After both calls to {@code indexedElement}, if no adjacent pair of elements required swapping,
     *     {@code isSorted} remains {@code true},
     *     indicating that the list is fully sorted.</li>
     *     <li>The while loop continues until {@code isSorted} is {@code true},
     *     which means the list is sorted.</li>
     * </ul>
     * {@code oddEven} method sorts a specific range of the {@code list} using the odd-even sort algorithm
     * by repeatedly calling the {@code indexedElement} method on alternating indices within the range until the range
     * is completely sorted.
     * @param       list to be arranged.
     * @param       left specific range of the list.
     * @param       right specific range of the list.
     * @param       functional lambda expression for comparison.
     * @see         OddEven#indexedElement(List, int, int, SortFunctional)
     */
    protected <L extends Comparable> void oddEven(
            List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = indexedElement(list, (left + 1), right, functional);
            isSorted = indexedElement(list, left, right, functional);
        }
    }

    /**
     * {@code indexedElementInc} that takes a list of
     * {@link java.lang.Comparable Comparable} objects, an integer {@code j}, and an integer {@code n} as parameters.
     * The method iterates through the list elements starting from index {@code j}
     * and incrementing the index by <i>2</i> in each iteration until reaching {@code (n - 2)}.
     * <ul>
     *     <li>Within the {@code for} loop, the method calls another method named {@code isSwapInc} and passes the list,
     *     the current index {@code i}, and the value <i>1</i> as parameters.</li>
     *     <li>If the {@code isSwapInc} method returns {@code true},
     *     indicating that swapping the elements would result in an incremental order,
     *     the element variable is set to {@code false},
     *     indicating that there was at least one swap required to achieve the desired order.</li>
     * </ul>
     * {@code indexedElementInc} the method returns the value of the element variable,
     * which would be {@code true} if no swaps were needed or
     * {@code false} if at least one swap occurred.
     * @param       list to be arranged.
     * @param       j the list elements starting from index.
     * @param       n the list elements ending from index.
     * @return      true if there was no exchange.<br>
     *              false if there was at least <i>1</i> exchange.
     * @see         SortSwap#isSwapInc(List, int, int)
     */
    protected <L extends Comparable> boolean indexedElementInc(List<L> list, int j, int n) {
        boolean element = true;
        for (int i = j; i <= (n - 2); i += 2) {
            if (isSwapInc(list, i, 1)) element = false;
        }
        return element;
    }

    /**
     * {@code indexedElementDec} that takes a list of
     * {@link java.lang.Comparable Comparable} objects, an integer {@code j}, and an integer {@code n} as parameters.
     * The method iterates through the list elements starting from index {@code j}
     * and incrementing the index by <i>2</i> in each iteration until reaching {@code (n - 2)}.
     * <ul>
     *     <li>Within the {@code for} loop, the method calls another method named {@code isSwapDec} and passes the list,
     *     the current index {@code i}, and the value <i>1</i> as parameters.</li>
     *     <li>If the {@code isSwapDec} method returns {@code true},
     *     indicating that swapping the elements would result in and decremental order,
     *     the element variable is set to {@code false},
     *     indicating that there was at least one swap required to achieve the desired order.</li>
     * </ul>
     * {@code indexedElementDec} the method returns the value of the element variable,
     * which would be {@code true} if no swaps were needed or
     * {@code false} if at least one swap occurred.
     * @param       list to be arranged.
     * @param       j the list elements starting from index.
     * @param       n the list elements ending from index.
     * @return      true if there was no exchange.<br>
     *              false if there was at least <i>1</i> exchange.
     * @see         SortSwap#isSwapInc(List, int, int)
     */
    protected <L extends Comparable> boolean indexedElementDec(List<L> list, int j, int n) {
        boolean element = true;
        for (int i = j; i <= (n - 2); i += 2) {
            if (isSwapDec(list, i, 1)) element = false;
        }
        return element;
    }

    /**
     * {@code indexedElement} method you provided takes a list {@code list} of type {@link java.lang.Comparable
     * Comparable},
     * an integer {@code j}, an integer {@code n}, and an instance of the {@code SortFunctional<Comparable>} interface
     * as parameters.
     * <ul>
     *     <li>The method initializes a boolean variable {@code element} with the value {@code true}.
     *     This variable will be used to keep track of whether the indexed element at position {@code j} satisfies the
     *     condition.</li>
     *     <li>It enters a for loop that iterates from {@code j} to {@code (n - 2)} in steps of <i>1</i>.
     *     This means it only considers elements at even indices within the specified range.</li>
     *     <li>Inside the loop, it checks if the element at index {@code i} should be swapped with
     *     the adjacent element at index {@code (i + 1)} based on the given {@code functional} interface.
     *     The {@code isSwap} method is used to perform the comparison.</li>
     *     <li>If the {@code isSwap} method returns {@code true} for any pair of adjacent elements,
     *     it means the condition is not satisfied.
     *     In this case, the element variable is set to {@code false} to indicate that
     *     the indexed element at position {@code j} does not meet the condition.</li>
     *     <li>After the loop completes, the method returns the value of the {@code element} variable.</li>
     * </ul>
     * {@code indexedElementDec} the method returns the value of the element variable,
     * which would be {@code true} if no swaps were needed or
     * {@code false} if at least one swap occurred.
     * @param       list to be arranged.
     * @param       j the list elements starting from index.
     * @param       n the list elements ending from index.
     * @param       functional lambda expression for comparison.
     * @return      true if there was no exchange.<br>
     *              false if there was at least <i>1</i> exchange.
     * @see         SortSwap#isSwap(List, int, int, SortFunctional)
     */
    protected <L extends Comparable> boolean indexedElement(
            List<L> list, int j, int n, SortFunctional<Comparable> functional) {
        boolean element = true;
        for (int i = j; i <= (n - 2); i += 2) {
            if (isSwap(list, i, 1, functional)) element = false;
        }
        return element;
    }
}