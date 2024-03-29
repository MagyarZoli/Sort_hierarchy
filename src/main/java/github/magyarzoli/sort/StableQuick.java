package github.magyarzoli.sort;

import github.magyarzoli.Sort;
import github.magyarzoli.SortFunctional;
import github.magyarzoli.SortList;
import github.magyarzoli.sort.intro.IntroStableQuick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Stable QuickSort is an extension of the QuickSort algorithm that aims to preserve
 * the relative order of elements with equal values during the sorting process.
 * In a standard QuickSort algorithm, the order of equal elements may change, making it an unstable sorting algorithm.
 * Stable QuickSort addresses this limitation by introducing additional steps to maintain stability.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class StableQuick
        extends Quick {

    /**
     * <b>Stable Quick Sort:</b><br>
     * Is an extension of the QuickSort algorithm that aims to preserve
     * the relative order of elements with equal values during the sorting process.
     * In a standard QuickSort algorithm, the order of equal elements may change, making it an unstable
     * sorting algorithm.
     * Stable QuickSort addresses this limitation by introducing additional steps to maintain stability.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Select a pivot element: The first step is to choose a pivot element from the array.
     *     The pivot can be selected in various ways, such as picking the first, last, or middle element.</li>
     *     <li>Partitioning: The array is partitioned into two subarrays based on the pivot element.
     *     One subarray contains elements smaller than the pivot,
     *     while the other subarray contains elements greater than the pivot.
     *     The partitioning step ensures that the pivot element is in its final sorted position.</li>
     *     <li>Recursion: Recursively apply Stable QuickSort to the two subarrays created in the previous step.
     *     This step involves selecting a new pivot element for each subarray and performing partitioning until
     *     the subarrays reach a size of <i>1</i> or <i>0</i>, as these subarrays are considered already sorted.</li>
     *     <li>Concatenation: Once the recursion is complete, the sorted subarrays are concatenated to obtain
     *     the final sorted array.
     *     The order of concatenation is crucial to maintaining stability.
     *     The elements from the left subarray, which are smaller or equal to the pivot,
     *     should appear before the elements from the right subarray, which are greater than the pivot.</li>
     * </ol>
     * <b>Note:</b><br>
     * By carefully handling the partitioning and concatenation steps,
     * Stable QuickSort ensures that elements with equal values remain in their original relative order after sorting.
     * This makes it a stable sorting algorithm.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(log(n))</em><br>
     * Stability:               <b>Yes</b>
     * @see         IntroStableQuick#IntroStableQuick() IntroStableQuick
     */
    public StableQuick() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        stableQuickInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        stableQuickDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        stableQuick(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        stableQuickInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        stableQuickDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        stableQuick(list, functional);
    }

    /**
     * {@code stableQuickInc} that performs an in-place sorting of
     * a {@link java.lang.Comparable Comparable} array using a stable version of the QuickSort algorithm.
     * <ul>
     *     <li>The original array is converted into an {@code ArrayList} by creating a {@code new ArrayList}
     *     and passing the array as an argument to the {@code ArrayList} constructor:
     *     {@code new ArrayList<>}{@link java.util.Arrays#asList(Object[]) (Arrays.asList(array))}.</li>
     *     <li>The {@code ArrayList} is then passed as an argument to the {@code stableRecursiveInc} method,
     *     which performs a stable sorting of the {@code ArrayList} and returns a sorted {@code stableList}.</li>
     *     <li>The sorted stableList obtained from {@code stableRecursiveInc} is converted back into an array using
     *     the {@link java.util.List#toArray(Object[]) toArray()} method with an empty Comparable array as the argument:
     *     {@code stableList.toArray(new Comparable[0])}.</li>
     *     <li>The sorted elements are copied from the sorted stableList back into
     *     the original array using {@link java.lang.System#arraycopy(Object, int, Object, int, int)
     *     System.arraycopy()}.
     *     The elements are copied starting from the beginning of the original array index <i>0</i>, and
     *     the number of elements copied is equal to the length of the array: {@code array.length}.</li>
     * </ul>
     * {@code stableQuickInc} method uses the {@code stableRecursiveInc} method to sort
     * the original array in a stable manner by converting it into an {@code ArrayList}.
     * After obtaining the sorted stableList, the sorted elements are copied back into the original array.
     * This allows the QuickSort algorithm to maintain stability by using the {@code stableRecursiveInc}
     * method instead of
     * the standard partitioning logic in QuickSort.
     * @param       array The original array containing Comparable elements.
     * @see         StableQuick#stableRecursiveInc(List)
     */
    protected void stableQuickInc(Comparable[] array) {
        List<Comparable> stableList = stableRecursiveInc(new ArrayList<>(Arrays.asList(array)));
        System.arraycopy(stableList.toArray(new Comparable[0]), 0, array, 0, array.length);
    }

    /**
     * {@code stableQuickDec} that performs an in-place sorting of
     * a {@link java.lang.Comparable Comparable} array using a stable version of the QuickSort algorithm.
     * <ul>
     *     <li>The original array is converted into an {@code ArrayList} by creating a {@code new ArrayList}
     *     and passing the array as an argument to the {@code ArrayList} constructor:
     *     {@code new ArrayList<>}{@link java.util.Arrays#asList(Object[]) (Arrays.asList(array))}.</li>
     *     <li>The {@code ArrayList} is then passed as an argument to the {@code stableRecursiveInc} method,
     *     which performs a stable sorting of the {@code ArrayList} and returns a sorted {@code stableList}.</li>
     *     <li>The sorted stableList obtained from {@code stableRecursiveDec} is converted back into an array using
     *     the {@link java.util.List#toArray(Object[]) toArray()} method with an empty Comparable array as the argument:
     *     {@code stableList.toArray(new Comparable[0])}.</li>
     *     <li>The sorted elements are copied from the sorted stableList back into
     *     the original array using {@link java.lang.System#arraycopy(Object, int, Object, int, int)
     *     System.arraycopy()}.
     *     The elements are copied starting from the beginning of the original array index <i>0</i>, and
     *     the number of elements copied is equal to the length of the array: {@code array.length}.</li>
     * </ul>
     * {@code stableQuickDec} method uses the {@code stableRecursiveInc} method to sort
     * the original array in a stable manner by converting it into an {@code ArrayList}.
     * After obtaining the sorted stableList, the sorted elements are copied back into the original array.
     * This allows the QuickSort algorithm to maintain stability by using the {@code stableRecursiveInc}
     * method instead of
     * the standard partitioning logic in QuickSort.
     * @param       array The original array containing Comparable elements.
     * @see         StableQuick#stableRecursiveDec(List)
     */
    protected void stableQuickDec(Comparable[] array) {
        List<Comparable> stableList = stableRecursiveDec(new ArrayList<>(Arrays.asList(array)));
        System.arraycopy(stableList.toArray(new Comparable[0]), 0, array, 0, array.length);
    }

    /**
     * {@code stableQuick} method, which performs a stable sorting of the entire {@code array} using
     * a stable sorting algorithm.
     * <ul>
     *     <li>The method {@code stableQuick} takes two parameters:
     *     {@code array} an array of {@link java.lang.Comparable Comparable} objects
     *     and {@code functional} an instance of {@code mz.SortFunctional}
     *     representing a functional interface for comparison operations.</li>
     *     <li>The first line of code creates a new {@code ArrayList<Comparable>} called
     *     {@code stableList} by converting
     *     the {@code array} into a stableList using {@link java.util.Arrays#asList(Object[]) Arrays.asList(array)}.
     *     This creates a dynamic stableList that can be resized.</li>
     *     <li>The {@code stableRecursive} method is called, passing the {@code stableList} and
     *     {@code functional} as parameters.
     *     This method applies a stable sorting algorithm to the {@code stableList} using the
     *     {@code functional} object.</li>
     *     <li>The sorted {@code stableList} is then converted back to an array
     *     using {@link java.util.List#toArray(Object[]) stableList.toArray}{@code (new Comparable[0])}.</li>
     *     <li>Finally, the sorted elements from the {@code stableList} are copied back to the original {@code array}
     *     using {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy()}.
     *     The elements are copied starting from index <i>0</i> of the sorted array,
     *     and the destination in the original {@code array} starts at index <i>0</i>.
     *     The number of elements copied is equal to the length of the original {@code array}.</li>
     * </ul>
     * {@code stableQuick} method performs a stable sorting of the entire {@code array} using
     * a stable sorting algorithm based on the {@code functional} object.
     * It converts the array to a dynamic stableList, applies stable sorting to the stableList,
     * and then copies the sorted elements back to the original array.
     * This method allows for stable sorting with the efficiency of the Quick Sort algorithm.
     * @param       array The original array containing Comparable elements.
     * @param       functional lambda expression for comparison.
     * @see         StableQuick#stableRecursive(List, SortFunctional)
     */
    protected void stableQuick(Comparable[] array, SortFunctional<Comparable> functional) {
        List<Comparable> stableList = stableRecursive(new ArrayList<>(Arrays.asList(array)), functional);
        System.arraycopy(stableList.toArray(new Comparable[0]), 0, array, 0, array.length);
    }

    /**
     * {@code stableQuickInc} that performs an in-place sorting of a subarray within a
     * {@link java.lang.Comparable Comparable} array using a stable version of the QuickSort algorithm.
     * <ul>
     *     <li>The method creates a new array called {@code newArray} with a size equal to the length of the
     *     subarray to be sorted {@code (right - left)}.
     *     This new array will be used to create a temporary {@code stableList} for sorting.</li>
     *     <li>The elements from the original array that correspond to the subarray to be sorted are copied into
     *     the {@code newArray} using the {@link java.lang.System#arraycopy(Object, int, Object, int, int)
     *     System.arraycopy()} method.</li>
     *     <li>The "newArray" is converted into an ArrayList using {@link java.util.Arrays#asList(Object[])
     *     Arrays.asList()}
     *     and then passed as an argument to the {@code stableRecursiveInc} method.
     *     This method, as you previously provided, performs a stable sorting of the {@code ArrayList} and
     *     returns a sorted {@code stableList}.</li>
     *     <li>The sorted stableList obtained from "{@code stableRecursiveInc}" is converted back into
     *     an array using
     *     the {@link java.util.List#toArray(Object[]) toArray()} method with an empty Comparable array
     *     as the argument.</li>
     *     <li>The sorted elements are copied from the sorted {@code stableList} back into the original
     *     array using {@code System.arraycopy()}.
     *     The elements are copied starting from the left index of the original array,
     *     and the number of elements copied is equal to the size of the sorted stableList.</li>
     * </ul>
     * {@code stableQuickInc} method uses the {@code stableRecursiveInc} method to sort a subarray of
     * the original array in a stable manner
     * by creating a temporary array and converting it into an ArrayList.
     * After obtaining the sorted stableList, the sorted elements are copied back into the original array.
     * This allows the QuickSort algorithm to maintain stability by using the {@code stableRecursiveInc}
     * method instead of
     * the standard partitioning logic in QuickSort.
     * @param       array The original array containing Comparable elements.
     * @param       left The index representing the left boundary of the subarray to be sorted.
     * @param       right The index representing the right boundary of the subarray to be sorted.
     * @see         StableQuick#stableRecursiveInc(List)
     */
    protected void stableQuickInc(Comparable[] array, int left, int right) {
        Comparable[] newArray = new Comparable[(right - left)];
        System.arraycopy(array, left, newArray, 0, newArray.length);
        List<Comparable> stableList = stableRecursiveInc(new ArrayList<>(Arrays.asList(newArray)));
        System.arraycopy(stableList.toArray(new Comparable[0]), 0, array, left, stableList.size());
    }

    /**
     * {@code stableQuickDec} that performs an in-place sorting of a subarray within a
     * {@link java.lang.Comparable Comparable} array using a stable version of the QuickSort algorithm.
     * <ul>
     *     <li>The method creates a new array called {@code newArray} with a size equal to the length of
     *     the subarray to be sorted {@code (right - left)}.
     *     This new array will be used to create a temporary {@code stableList} for sorting.</li>
     *     <li>The elements from the original array that correspond to the subarray to be sorted are copied into
     *     the {@code newArray} using the {@link java.lang.System#arraycopy(Object, int, Object, int, int)
     *     System.arraycopy()} method.</li>
     *     <li>The "newArray" is converted into an ArrayList using {@link java.util.Arrays#asList(Object[])
     *     Arrays.asList()}
     *     and then passed as an argument to the {@code stableRecursiveDec} method.
     *     This method, as you previously provided, performs a stable sorting of the {@code ArrayList} and
     *     returns a sorted {@code stableList}.</li>
     *     <li>The sorted stableList obtained from "{@code stableRecursiveDec}" is converted back into
     *     an array using
     *     the {@link java.util.List#toArray(Object[]) toArray()} method with an empty Comparable array
     *     as the argument.</li>
     *     <li>The sorted elements are copied from the sorted {@code stableList} back into the original
     *     array using {@code System.arraycopy()}.
     *     The elements are copied starting from the left index of the original array,
     *     and the number of elements copied is equal to the size of the sorted stableList.</li>
     * </ul>
     * {@code stableQuickDec} method uses the {@code stableRecursiveDec} method to sort a subarray of
     * the original array in a stable manner
     * by creating a temporary array and converting it into an ArrayList.
     * After obtaining the sorted stableList, the sorted elements are copied back into the original array.
     * This allows the QuickSort algorithm to maintain stability by using the {@code stableRecursiveDec}
     * method instead of
     * the standard partitioning logic in QuickSort.
     * @param       array The original array containing Comparable elements.
     * @param       left The index representing the left boundary of the subarray to be sorted.
     * @param       right The index representing the right boundary of the subarray to be sorted.
     * @see         StableQuick#stableRecursiveDec(List)
     */
    protected void stableQuickDec(Comparable[] array, int left, int right) {
        Comparable[] newArray = new Comparable[(right - left)];
        System.arraycopy(array, left, newArray, 0, newArray.length);
        List<Comparable> stableList = stableRecursiveDec(new ArrayList<>(Arrays.asList(newArray)));
        System.arraycopy(stableList.toArray(new Comparable[0]), 0, array, left, stableList.size());
    }

    /**
     * The method {@code stableQuick} takes four parameters:
     * {@code array} an array of {@link java.lang.Comparable Comparable} objects,
     * {@code left} the starting index of the partition, {@code right} the ending index of the partition,
     * and {@code functional} an instance of SortFunctional representing a functional interface for
     * comparison operations.
     * <ul>
     *     <li>The first line of code creates a new {@code Comparable}
     *     array called {@code newArray} with a length equal to {@code (right - left)}.</li>
     *     <li>The {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy()}
     *     method is used to copy elements from the original {@code array},
     *     starting from index {@code left}, to the {@code newArray},
     *     starting at index <i>0</i>, and copying {@code newArray.length} elements.
     *     This effectively creates a new array containing the elements to be sorted.</li>
     *     <li>The {@code newArray} is then converted
     *     to a {@code List<Comparable>} using {@link java.util.Arrays#asList(Object[]) asList()}
     *     and wrapped in a new {@code ArrayList<>} to allow dynamic resizing.</li>
     *     <li>The {@code stableRecursive} method is called, passing the {@code stableList} and
     *     {@code functional} as parameters.
     *     This method applies a stable sorting algorithm to the {@code stableList} using the
     *     {@code functional} object.</li>
     *     <li>The sorted {@code stableList} is then converted back
     *     to an array using {@link java.util.List#toArray(Object[]) stableList.toArray}
     *     {@code (new Comparable[0])}.</li>
     *     <li>Finally, the sorted elements from the {@code stableList} are copied back to the
     *     original array using {@code System.arraycopy}.
     *     The elements are copied starting from index <i>0</i> of the sorted {@code array},
     *     and the destination in the original {@code array} starts at index {@code left}.
     *     The number of elements copied is equal to {@code stableList.}{@link java.util.List#size() size()}.</li>
     * </ul>
     * {@code stableQuick} method performs a stable sorting of a specific partition of
     * the {@code array} using a stable sorting algorithm based on the {@code functional} object.
     * It creates a temporary array, copies the elements from the original array to the temporary array,
     * applies stable sorting to the temporary array, and then copies the sorted elements back to the original array.
     * This method allows for stable sorting with the efficiency of the Quick Sort algorithm.
     * @param       array The original array containing {@code Comparable} elements.
     * @param       left The index representing the left boundary of the subarray to be sorted.
     * @param       right The index representing the right boundary of the subarray to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         StableQuick#stableRecursive(List, SortFunctional)
     */
    protected void stableQuick(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        Comparable[] newArray = new Comparable[(right - left)];
        System.arraycopy(array, left, newArray, 0, newArray.length);
        List<Comparable> stableList = stableRecursive(new ArrayList<>(Arrays.asList(newArray)), functional);
        System.arraycopy(stableList.toArray(new Comparable[0]), 0, array, left, stableList.size());
    }

    /**
     * {@code tableQuickInc} that takes a {@code List<Comparable>} called {@code list}.
     * This method appears to be an incremental version of the Quick Sort algorithm.
     * <ul>
     *     <li>It calls the {@code stableRecursiveInc} method, passing the {@code list} as an argument.
     *     The {@code stableRecursiveInc} method performs an incremental Quick Sort operation on the {@code list}.</li>
     * </ul>
     * {@code tableQuickInc} simply acts as a wrapper for the {@code stableRecursiveInc} method,
     * allowing you to call the incremental Quick Sort algorithm on the entire {@code list} by invoking
     * {@code stableQuickInc(list)}.
     * @param       list The original list containing Comparable elements.
     * @see         StableQuick#stableRecursiveInc(List)
     */
    protected <L extends Comparable> void stableQuickInc(List<L> list) {
        stableRecursiveInc(list);
    }

    /**
     * {@code tableQuickDec} that takes a {@code List<Comparable>} called {@code list}.
     * This method appears to be a decremental version of the Quick Sort algorithm.
     * <ul>
     *     <li>It calls the {@code stableRecursiveDec} method, passing the {@code list} as an argument.
     *     The {@code stableRecursiveDec} method performs an decremental Quick Sort operation on the {@code list}.</li>
     * </ul>
     * {@code tableQuickDec} simply acts as a wrapper for the {@code stableRecursiveInc} method,
     * allowing you to call the decremental Quick Sort algorithm on the entire {@code list} by invoking
     * {@code stableQuickDec(list)}.
     * @param       list The original list containing Comparable elements.
     * @see         StableQuick#stableRecursiveDec(List)
     */
    protected <L extends Comparable> void stableQuickDec(List<L> list) {
        stableRecursiveDec(list);
    }

    /**
     * {@code stableQuick} that takes a {@code List<Comparable>} called {@code list}
     * and a {@code SortFunctional} object called {@code functional}.
     * This method appears to be a version of the Quick Sort algorithm that allows you to provide a
     * custom sorting implementation through the {@code SortFunctional} interface.
     * <ul>
     *     <li>It calls the {@code stableRecursive} method, passing the {@code list} and {@code functional}
     *     as arguments.
     *     The {@code stableRecursive} method performs a Quick Sort operation on the list using the
     *     provided {@code functional} for sorting.</li>
     * </ul>
     * {@code stableQuick} acts as a wrapper for the {@code stableRecursive} method,
     * allowing you to perform Quick Sort on the entire {@code list} using a custom sorting implementation
     * provided through the {@code functional} parameter.
     * @param       list The original list containing Comparable elements.
     * @param       functional lambda expression for comparison.
     * @see         StableQuick#stableRecursive(List, SortFunctional)
     */
    protected <L extends Comparable> void stableQuick(List<L> list, SortFunctional<Comparable> functional) {
        stableRecursive(list, functional);
    }

    /**
     * {@code stableQuickInc} that takes a {@code List<Comparable>} called {@code list},
     * as well as two indices {@code left} and {@code right}.
     * This method performs an incremental version of the Quick Sort algorithm
     * on a sublist of the {@code list} between the indices {@code left} and {right}.
     * <ul>
     *     <li>It creates a new {@code List<Comparable>} called {@code newList} and initializes it by calling the
     *     {@code addBetween} method with the {@code list}, {@code left}, and {@code right} as arguments.
     *     The {@code addBetween} method returns a sublist of {@code list} containing the elements between
     *     the {@code left} and {@code right} indices.</li>
     *     <li>It updates the list variable by calling the {@code removeBetween} method with the {@code list},
     *     {@code left}, and {@code right} as arguments.
     *     The {@code removeBetween} method removes the elements between the {@code left} and {@code right}
     *     indices from the original {@code list}.</li>
     *     <li>It calls the {@code stableRecursiveInc} method with the {@code newList} as an argument.
     *     The {@code stableRecursiveInc} method presumably performs some sort of recursive operation on
     *     the {@code newList} and returns a modified version of it.</li>
     * </ul>
     * {@code stableQuickInc} performs an incremental QuickSort operation on the sublist of {@code list}
     * between the indices {@code left} and {@code right}.
     * It creates a new sublist called {@code newList} using the {@code addBetween} method,
     * removes the elements of the sublist from the original {@code list} using
     * the {@code removeBetween} method, and then adds the modified {@code newList} back to
     * the original {@code list} using the {@link java.util.List#addAll(Collection) addAll} method.
     * @param       list The original list containing Comparable elements.
     * @param       left The index representing the left boundary of the sublist to be sorted.
     * @param       right The index representing the right boundary of the sublist to be sorted.
     * @see         SortList#addBetween(List, int, int)
     * @see         SortList#removeBetween(List, int, int)
     * @see         StableQuick#stableRecursiveInc(List)
     */
    protected <L extends Comparable> void stableQuickInc(List<L> list, int left, int right) {
        List<L> newList = addBetween(list, left, right);
        list = removeBetween(list, left, right);
        list.addAll(stableRecursiveInc(newList));
    }

    /**
     * {@code stableQuickDec} that takes a {@code List<Comparable>} called {@code list},
     * as well as two indices {@code left} and {@code right}.
     * This method performs a decremental version of the Quick Sort algorithm
     * on a sublist of the {@code list} between the indices {@code left} and {right}.
     * <ul>
     *     <li>It creates a new {@code List<Comparable>} called {@code newList} and initializes it by calling the
     *     {@code addBetween} method with the {@code list}, {@code left}, and {@code right} as arguments.
     *     The {@code addBetween} method returns a sublist of {@code list} containing the elements between
     *     the {@code left} and {@code right} indices.</li>
     *     <li>It updates the list variable by calling the {@code removeBetween} method with the {@code list},
     *     {@code left}, and {@code right} as arguments.
     *     The {@code removeBetween} method removes the elements between the {@code left} and {@code right}
     *     indices from the original {@code list}.</li>
     *     <li>It calls the {@code stableRecursiveDec} method with the {@code newList} as an argument.
     *     The {@code stableRecursiveDec} method presumably performs some sort of recursive operation on
     *     the {@code newList} and returns a modified version of it.</li>
     * </ul>
     * {@code stableQuickDec} performs an decremental QuickSort operation on the sublist of {@code list} between
     * the indices {@code left} and {@code right}.
     * It creates a new sublist called {@code newList} using the {@code addBetween} method,
     * removes the elements of the sublist from the original {@code list} using
     * the {@code removeBetween} method, and then adds the modified {@code newList} back to
     * the original {@code list} using the {@link java.util.List#addAll(Collection) addAll} method.
     * @param       list The original list containing Comparable elements.
     * @param       left The index representing the left boundary of the sublist to be sorted.
     * @param       right The index representing the right boundary of the sublist to be sorted.
     * @see         SortList#addBetween(List, int, int)
     * @see         SortList#removeBetween(List, int, int)
     * @see         StableQuick#stableRecursiveDec(List)
     */
    protected <L extends Comparable> void stableQuickDec(List<L> list, int left, int right) {
        List<L> newList = addBetween(list, left, right);
        list = removeBetween(list, left, right);
        list.addAll(stableRecursiveDec(newList));
    }

    /**
     * {@code stableQuick} that takes a {@code List<Comparable>} called {@code list},
     * as well as two indices {@code left} and {@code right},
     * and a {@code SortFunctional} object called {@code functional}.
     * This method performs a Quick Sort algorithm on a sublist of
     * the {@code list} between the indices {@code left} and {@code right} using a provided
     * {@code SortFunctional} implementation.
     * <ul>
     *     <li>It creates a new {@code List<Comparable>} called {@code newList} and initializes it by calling
     *     the {@code addBetween} method with the {@code list}, {@code left}, and {@code right} as arguments.
     *     The {@code addBetween} method returns a sublist of {@code list} containing
     *     the elements between the {@code left} and {@code right} indices.</li>
     *     <li>It updates the {@code list} variable by calling the {@code removeBetween} method with
     *     the {@code list}, {@code left}, and {@code right} as arguments.
     *     The {@code removeBetween} method removes the elements between
     *     the {@code left} and {@code right} indices from the original {@code list}.</li>
     *     <li>It calls the {@code stableRecursive} method with the {@code newList} and {@code functional} as arguments.
     *     The {@code stableRecursive} method presumably performs some sort of recursive sorting operation on
     *     the {@code newList} using the provided {@code SortFunctional} implementation and returns a
     *     modified version of it.</li>
     * </ul>
     * {@code stableQuick} performs a Quick Sort operation on
     * the sublist of {@code list} between the indices {@code left} and {@code right} using a provided
     * {@code SortFunctional} implementation.
     * It creates a new sublist called {@code newList} using the {@code addBetween} method,
     * removes the elements of the sublist from the original list using the {@code removeBetween} method,
     * and then adds the modified {@code newList} back to the original list using the
     * {@link java.util.List#addAll(Collection) addAll} method.
     * The actual sorting operation is performed by the {@code stableRecursive} method,
     * which utilizes the provided {@code SortFunctional} implementation.
     * @param       list The original list containing {@code Comparable} elements.
     * @param       left The index representing the left boundary of the sublist to be sorted.
     * @param       right The index representing the right boundary of the sublist to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         SortList#addBetween(List, int, int)
     * @see         SortList#removeBetween(List, int, int)
     * @see         StableQuick#stableRecursive(List, SortFunctional)
     */
    protected <L extends Comparable> void stableQuick(
            List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        List<L> newList = addBetween(list, left, right);
        list = removeBetween(list, left, right);
        list.addAll(stableRecursive(newList, functional));
    }

    /**
     * {@code stableRecursiveInc} implements a recursive sorting algorithm called {@code stableRecursiveInc}
     * that sorts a list of {@link java.lang.Comparable Comparable} elements in ascending order.
     * The algorithm uses the concept of a pivot element and divides the list into two parts:
     * smaller elements and greater elements, relative to the pivot.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used
     *     to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method takes a {@code list} as input and checks if the size of the {@code list} is less than
     *     or equal to <i>1</i>.
     *     If so, it returns the {@code list} as it is already sorted (base case of the recursion).</li>
     *     <li>If the {@code list} has more than one element, it proceeds to find the {@code pivot} element.
     *     The {@code pivot} is the element at the middle index of the {@code list}.</li>
     *     <li>The algorithm creates two empty lists, {@code smaller} and {@code greater},
     *     to hold the elements smaller and greater than the {@code pivot}, respectively.</li>
     *     <li>It iterates through the original {@code list} and compares each element to the {@code pivot}.</li>
     *     <li>If the element is smaller than the {@code pivot}, it adds it to the {@code smaller} list.</li>
     *     <li>If the element is greater than the {@code pivot}, it adds it to the {@code greater} list.</li>
     *     <li>If the element is equal to the {@code pivot}, it determines its relative position to the pivot index
     *     and adds it to either the {@code smaller} or {@code greater} list accordingly.</li>
     *     <li>After the iteration, the algorithm recursively calls itself with the {@code smaller} list and
     *     the {@code greater} list, separately.</li>
     *     <li>The results of the recursive calls are stored in two lists, {@code sa1} and {@code sa2}.</li>
     *     <li>The algorithm creates a new list, "{@code ans}", and populates it by adding all the elements
     *     from {@code sa1},
     *     followed by the {@code pivot} element, and finally, all the elements from {@code sa2}.</li>
     * </ul>
     * {@code stableRecursiveInc} the algorithm uses the divide-and-conquer approach by recursively sorting
     * smaller sublists and combining them to produce the final sorted list.
     * The use of the pivot element helps in dividing the list into smaller parts, which allows the algorithm
     * to achieve an efficient sorting result.
     * @param       list sorts a list of Comparable elements in ascending order.
     * @return      The sorted list, is returned.
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> List<L> stableRecursiveInc(List<L> list) {
        if (list.size() <= 1) {
            return list;
        }
        int n = list.size(), mid = (n / 2);
        L pivot = list.get(mid);
        List<L> smaller = new ArrayList<>();
        List<L> greater = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            L value = list.get(i);
            if (i != mid) {
                if (pivot.compareTo(value) > 0) {
                    smaller.add(value);
                } else if (pivot.compareTo(value) < 0) {
                    greater.add(value);
                } else {
                    if (i < mid) {
                        smaller.add(value);
                    } else {
                        greater.add(value);
                    }
                }
            }
        }
        List<L> ans = new ArrayList<>();
        List<L> sa1 = stableRecursiveInc(smaller);
        List<L> sa2 = stableRecursiveInc(greater);
        ans.addAll(sa1);
        ans.add(pivot);
        ans.addAll(sa2);
        return ans;
    }

    /**
     * {@code stableRecursiveDec} implements a recursive sorting algorithm called {@code stableRecursiveDec}
     * that sorts a list of {@link java.lang.Comparable Comparable} elements in descending order.
     * The algorithm uses the concept of a pivot element and divides the list into two parts:
     * smaller elements and greater elements, relative to the pivot.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is
     *     used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method takes a {@code list} as input and checks if the size of the {@code list} is less
     *     than or equal to <i>1</i>.
     *     If so, it returns the {@code list} as it is already sorted (base case of the recursion).</li>
     *     <li>If the {@code list} has more than one element, it proceeds to find the {@code pivot} element.
     *     The {@code pivot} is the element at the middle index of the {@code list}.</li>
     *     <li>The algorithm creates two empty lists, {@code smaller} and {@code greater},
     *     to hold the elements smaller and greater than the {@code pivot}, respectively.</li>
     *     <li>It iterates through the original {@code list} and compares each element to the {@code pivot}.</li>
     *     <li>If the element is greater than the {@code pivot}, it adds it to the {@code smaller} list.</li>
     *     <li>If the element is smaller than the {@code pivot}, it adds it to the {@code greater} list.</li>
     *     <li>If the element is equal to the {@code pivot}, it determines its relative position to the pivot index
     *     and adds it to either the {@code smaller} or {@code greater} list accordingly.</li>
     *     <li>After the iteration, the algorithm recursively calls itself with the {@code smaller} list and
     *     the {@code greater} list, separately.</li>
     *     <li>The results of the recursive calls are stored in two lists, {@code sa1} and {@code sa2}.</li>
     *     <li>The algorithm creates a new list, "{@code ans}", and populates it by adding all the elements
     *     from {@code sa1},
     *     followed by the {@code pivot} element, and finally, all the elements from {@code sa2}.</li>
     * </ul>
     * {@code stableRecursiveDec} the algorithm uses the divide-and-conquer approach by recursively sorting
     * smaller sublists and combining them to produce the final sorted list.
     * The use of the pivot element helps in dividing the list into smaller parts, which allows the algorithm
     * to achieve an efficient sorting result.
     * @param       list sorts a list of Comparable elements in descending order.
     * @return      The sorted list, is returned.
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> List<L> stableRecursiveDec(List<L> list) {
        if (list.size() <= 1) {
            return list;
        }
        int n = list.size(), mid = (n / 2);
        L pivot = list.get(mid);
        List<L> smaller = new ArrayList<>();
        List<L> greater = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            L value = list.get(i);
            if (i != mid) {
                if (pivot.compareTo(value) < 0) {
                    smaller.add(value);
                } else if (pivot.compareTo(value) > 0) {
                    greater.add(value);
                } else {
                    if (i < mid) {
                        smaller.add(value);
                    } else {
                        greater.add(value);
                    }
                }
            }
        }
        List<L> ans = new ArrayList<>();
        List<L> sa1 = stableRecursiveDec(smaller);
        List<L> sa2 = stableRecursiveDec(greater);
        ans.addAll(sa1);
        ans.add(pivot);
        ans.addAll(sa2);
        return ans;
    }

    /**
     * The method {@code stableRecursive} takes two parameters:
     * {@code list} (a list of {@link java.lang.Comparable Comparable} objects)
     * and {@code functional} (an instance of SortFunctional representing a functional interface for
     * comparison operations).
     * <ul>
     *     <li>The first line of code checks if the size of the {@code list} is less than or equal to <i>1</i>.
     *     If this condition is true, it means there is nothing to sort,
     *     so the method returns the original list.</li>
     *     <li>The code then initializes variables:
     *     {@code n} to the size of the {@code list} and mid to the index of
     *     the middle element (rounded down if {@code n} is odd).</li>
     *     <li>It retrieves the pivot element from the {@code list} using {@code list.get(mid)}.</li>
     *     <li>Two empty lists are created: {@code smaller} to store elements smaller than
     *     the pivot and {@code greater} to store elements greater than the pivot.</li>
     *     <li>The method defines a new {@code SortFunctional<Comparable>} called {@code functionalReverse}
     *     by passing {@code functional} to a method {@code functionalComparableToReverse}.
     *     This method returns a {@code SortFunctional} object that performs the reverse of
     *     the comparison operation defined in the original {@code functional} object.</li>
     *     <li>A loop iterates over the elements of the {@code list}.
     *     For each element at index {@code i}, it compares the element to the pivot using
     *     the {@code functional.functionalCompareTo} method.</li>
     *     <li>If the result of the comparison is true (i.e., the pivot is greater than the element),
     *     the element is added to the {@code smaller} list using {@code smaller.add(value)}.</li>
     *     <li>If the result of the reverse comparison is true (i.e., the pivot is less than the element),
     *     the element is added to the {@code greater} list using {@code greater.add(value)}.</li>
     *     <li>If neither of the previous conditions is true, it means the element is equal to the pivot.
     *     In this case, it checks the index {@code i} against {@code mid} to determine whether the element
     *     should be added
     *     to the {@code smaller} or {@code greater} list.
     *     Elements before the pivot index {@code (i < mid)} are added to the {@code smaller} list,
     *     and elements after the pivot index {@code (i > mid)} are added to the {@code greater} list.</li>
     *     <li>After the loop finishes, the method recursively calls itself twice to sort the {@code smaller}
     *     and {@code greater} lists.
     *     It passes each list to the {@code stableRecursive} method and stores the results in {@code sa1}
     *     and {@code sa2} respectively.</li>
     *     <li>A new empty list called {@code ans} is created.</li>
     *     <li>The elements from {@code sa1} are added to {@code ans} using {@code ans.addAll(sa1)}.</li>
     *     <li>The pivot element is added to {@code ans} using {@code ans.add(pivot)}.</li>
     *     <li>The elements from {@code sa2} are added to {@code ans} using {@code ans.addAll(sa2)}.</li>
     *     <li>Finally, the sorted list {@code ans} is returned.</li>
     * </ul>
     * {@code stableRecursive} method recursively applies a stable sorting algorithm to sort a list of
     * {@code Comparable} objects.
     * It partitions the list based on a pivot element, recursively sorts the smaller and greater partitions,
     * and combines the results to produce a final sorted list.
     * The specific comparison operations used for sorting are defined by the {@code functional} object
     * passed as a parameter.
     * @param       list sorts a list of Comparable elements in descending order.
     * @param       functional lambda expression for comparison.
     * @return      The sorted list, is returned.
     * @see         Sort#functionalComparableToReverse(SortFunctional)
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    protected <L extends Comparable> List<L> stableRecursive(List<L> list, SortFunctional<Comparable> functional) {
        if (list.size() <= 1) {
            return list;
        }
        int n = list.size(), mid = (n / 2);
        L pivot = list.get(mid);
        List<L> smaller = new ArrayList<>();
        List<L> greater = new ArrayList<>();
        SortFunctional<Comparable> functionalReverse = functionalComparableToReverse(functional);
        for (int i = 0; i < n; i++) {
            L value = list.get(i);
            if (i != mid) {
                if (functional.functionalCompareTo(pivot, value)) {
                    smaller.add(value);
                } else if (functionalReverse.functionalCompareTo(pivot, value)) {
                    greater.add(value);
                } else {
                    if (i < mid) {
                        smaller.add(value);
                    } else {
                        greater.add(value);
                    }
                }
            }
        }
        List<L> ans = new ArrayList<>();
        List<L> sa1 = stableRecursive(smaller, functional);
        List<L> sa2 = stableRecursive(greater, functional);
        ans.addAll(sa1);
        ans.add(pivot);
        ans.addAll(sa2);
        return ans;
    }
}