package github.magyarzoli.sort.intro;

import github.magyarzoli.InsertionInterface;
import github.magyarzoli.QuickInterface;
import github.magyarzoli.SortFunctional;
import github.magyarzoli.Sorter;

import java.util.List;

import static java.lang.Math.floor;
import static java.lang.Math.log;

/**
 * Intro Sort is a hybrid sorting algorithm that combines the strengths of Quick Sort and Insertion Sort.
 * It aims to provide fast average-case performance while maintaining worst-case guarantees.
 * The basic idea behind Intro Sort is to start with Quick Sort, which is known for its efficiency on average,
 * but has a worst-case time complexity of <em>O(n^2)</em> in certain scenarios.
 * To mitigate the risk of Quick Sort's worst-case behavior, Intro Sort monitors the recursion depth during the
 * sorting process.
 * If the depth exceeds a certain threshold, the algorithm switches to HeapSort,
 * which guarantees worst-case <em>O(n log(n))</em> time complexity but has higher overhead.
 * Additionally, for small subarrays, IntroSort switches to Insertion Sort, which has good performance for small
 * input sizes.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public interface Intro<T extends Comparable>
        extends Sorter<T>, InsertionInterface<T>, QuickInterface<T> {

    /**
     * Size of each intro
     */
    int INTRO_SIZE = 16;

    /**
     * The other sorting algorithm can be added in this method.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @see         Intro#introRecursiveInc(Comparable[], int, int, int)
     */
    void introSortClassInc(T[] array, int left, int right);

    /**
     * The other sorting algorithm can be added in this method.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @see         Intro#introRecursiveDec(Comparable[], int, int, int)
     */
    void introSortClassDec(T[] array, int left, int right);

    /**
     * The other sorting algorithm can be added in this method.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         Intro#introRecursive(Comparable[], int, int, int, SortFunctional)
     */
    void introSortClass(T[] array, int left, int right, SortFunctional<T> functional);

    /**
     * The other sorting algorithm can be added in this method.
     * @param       list The list to be sorted.
     * @param       left The starting index of the sublist to be sorted.
     * @param       right The ending index (inclusive) of the sublist to be sorted.
     * @see         Intro#introRecursiveInc(Comparable[], int, int, int)
     */
    <L extends T> void introSortClassInc(List<L> list, int left, int right);

    /**
     * The other sorting algorithm can be added in this method.
     * @param       list The list to be sorted.
     * @param       left The starting index of the sublist to be sorted.
     * @param       right The ending index (inclusive) of the sublist to be sorted.
     * @see         Intro#introRecursiveDec(Comparable[], int, int, int)
     */
    <L extends T> void introSortClassDec(List<L> list, int left, int right);

    /**
     * The other sorting algorithm can be added in this method.
     * @param       list The list to be sorted.
     * @param       left The starting index of the sublist to be sorted.
     * @param       right The ending index (inclusive) of the sublist to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         Intro#introRecursive(Comparable[], int, int, int, SortFunctional)
     */
    <L extends T> void introSortClass(List<L> list, int left, int right, SortFunctional<T> functional);

    /**
     * {@code introInc} that serves as the entry point for performing an <b>Intro Sort</b> on the given array.<br>
     * <b>An Override call is required to use the Interface method.</b>
     * <ul>
     *     <li> This line calls the introRecursiveInc method to perform the IntroSort on the array. The parameters
     *     passed are:</li>
     *     <li><i>0</i> The starting index of the array.</li>
     *     <li>The ending index (inclusive) of the array.</li>
     *     <li>The maximum depth or recursion level allowed for <b>Quick Sort</b>.
     *     It is calculated as twice the logarithm (base 2) of the length of the array,
     *     rounded down to the nearest integer.
     *     This value determines when the algorithm switches to a different sorting method.</li>
     *     <li>default void introInc(T[] array),
     *     call introRecursiveInc(array, 0, (array.length - 1), (int) (2 * {@link java.lang.Math#floor(double)
     *     Math.floor}({@link java.lang.Math#log(double) Math.log}(array.length))));</li>
     * </ul>
     * {@code introInc} method provides a convenient entry point for sorting an array using the IntroSort algorithm.
     * It calculates the maximum depth based on the array length and then calls the introRecursiveInc method to
     * perform the sorting.
     * @param       array The array to be sorted.
     * @see         Intro#introRecursiveInc(Comparable[], int, int, int)
     */
    default void introInc(T[] array) {
        introRecursiveInc(array, 0, (array.length - 1), (int) (2 * floor(log(array.length))));
    }

    /**
     * {@code introDec} that serves as the entry point for performing an <b>Intro Sort</b> on the given array.<br>
     * <b>An Override call is required to use the Interface method.</b>
     * <ul>
     *     <li> This line calls the introRecursiveInc method to perform the IntroSort on the array. The
     *     parameters passed are:</li>
     *     <li><i>0</i> The starting index of the array.</li>
     *     <li>The ending index (inclusive) of the array.</li>
     *     <li>The maximum depth or recursion level allowed for <b>Quick Sort</b>.
     *     It is calculated as twice the logarithm (base 2) of the length of the array, rounded down to
     *     the nearest integer.
     *     This value determines when the algorithm switches to a different sorting method.</li>
     *     <li>default void introDec(T[] array),
     *     call introRecursiveDec(array, 0, (array.length - 1), (int) (2 * {@link java.lang.Math#floor(double)
     *     Math.floor}({@link java.lang.Math#log(double) Math.log}(array.length))));</li>
     * </ul>
     * {@code introInc} method provides a convenient entry point for sorting an array using the IntroSort algorithm.
     * It calculates the maximum depth based on the array length and then calls the introRecursiveInc
     * method to perform the sorting.
     * @param       array The array to be sorted.
     * @see         Intro#introRecursiveDec(Comparable[], int, int, int)
     */
    default void introDec(T[] array) {
        introRecursiveDec(array, 0, (array.length - 1), (int) (2 * floor(log(array.length))));
    }

    /**
     * {@code intro} within an interface.
     * This method takes an array of type {@code T[]}
     * and an instance of the {@code mz.SortFunctional} interface as parameters.
     * The method serves as an entry point to the intro sort algorithm for sorting the entire array.
     * <ul>
     *     <li>It calls the {@code introRecursive} method to sort the array, passing the following parameters:
     *     {@code array} the array to be sorted. <i>0</i> the left index of the range, indicating
     *     the start of the array.
     *     {@code (array.length - 1)} the right index of the range, indicating the end of the array.
     *     The maximum recursion depth {@code (int) (2 * }{@link java.lang.Math#floor(double)
     *     Math.floor}({@link java.lang.Math#log(double) Math.log}{@code (array.length)))),}
     *     which is calculated as twice the logarithm (base <i>2</i>) of the length of the array
     *     , rounded down to the nearest integer.
     *     {@code functional} An instance of the mz.SortFunctional interface used for comparison operations.</li>
     *     <li>The {@code introRecursive} method will then perform the sorting process according
     *     to the intro sort algorithm,
     *     which combines quicksort and insertion sort based on the specified recursion depth.</li>
     * </ul>
     * {@code intro} method is responsible for initiating the intro sort algorithm on the entire array,
     * utilizing the {@code introRecursive} method to perform the sorting operation.
     * It calculates the maximum recursion depth based on the length of
     * the array and provides the necessary parameters for the recursive sorting process.
     * @param       array The array to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         Intro#introRecursive(Comparable[], int, int, int, SortFunctional)
     */
    default void intro(T[] array, SortFunctional<T> functional) {
        introRecursive(array, 0, (array.length - 1), (int) (2 * floor(log(array.length))), functional);
    }

    /**
     * {@code introRecursiveInc} method implements an adaptive sorting algorithm called Intro Sort.
     * <ul>
     *     <li>This condition checks if the size of the subarray is greater than {@code INTRO_SIZE}.
     *     If true, the array is large enough to be sorted using QuickSort.</li>
     *     <li>This condition checks if the maximum depth has been reached.
     *     If true, the maximum depth has been exceeded,
     *     and the sorting algorithm switches to another sorting method.</li>
     *     <li>{@code introSortClassInc(array, left, right)}:
     *     If the maximum depth has been reached, the {@code introSortClassInc}
     *     method is called to sort the subarray using a different sorting algorithm.</li>
     *     <li>{@code partitionInc(array, left, right)}: If the maximum depth has not been reached,
     *     the {@code partitionInc} method is called to perform the partitioning step of QuickSort.
     *     It returns the index of the pivot element.</li>
     *     <li>The {@code introRecursiveInc} method is recursively called on the left subarray
     *     (elements smaller than the pivot) to further sort it.</li>
     *     <li>The {@code introRecursiveInc} method is recursively called on the right subarray
     *     (elements greater than the pivot) to further sort it.</li>
     *     <li>Else the size of the subarray is not greater than {@code INTRO_SIZE}, the array
     *     is considered small, and the {@code insertionInc}
     *     method is called to perform insertion sort on the subarray.</li>
     *     <li>This is a method declaration for {@code introSortClassInc}.
     *     It appears to be a separate sorting algorithm that is called when the maximum depth is reached.</li>
     * </ul>
     * {@code introRecursiveInc} method implements an adaptive sorting algorithm called
     * <b>Intro Sort.</b> It combines the <b>Quick Sort</b>
     * algorithm with a switch to another sorting algorithm <b>Insertion Sort</b> when
     * the recursion depth exceeds a specified threshold {@code maxDepth}.
     * The purpose of this adaptive approach is to optimize performance by leveraging
     * the strengths of different sorting algorithms depending on the input size.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @see         Intro#INTRO_SIZE
     * @see         Intro#introInc(Comparable[])
     * @see         Intro#introSortClassInc(Comparable[], int, int)
     * @see         InsertionInterface#insertionInc(Comparable[], int, int)
     */
    default void introRecursiveInc(T[] array, int left, int right, int maxDepth) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClassInc(array, left, right);
            }
            int pivot = partitionInc(array, left, right);
            introRecursiveInc(array, left, (pivot - 1), (maxDepth - 1));
            introRecursiveInc(array, (pivot + 1), right, (maxDepth - 1));
        } else {
            insertionInc(array, left, right);
        }
    }

    /**
     * {@code introRecursiveDec} method implements an adaptive sorting algorithm called Intro Sort.
     * <ul>
     *     <li>This condition checks if the size of the subarray is greater than {@code INTRO_SIZE}.
     *     If true, the array is large enough to be sorted using QuickSort.</li>
     *     <li>This condition checks if the maximum depth has been reached.
     *     If true, the maximum depth has been exceeded,
     *     and the sorting algorithm switches to another sorting method.</li>
     *     <li>{@code introSortClassDec(array, left, right)}:
     *     If the maximum depth has been reached, the {@code introSortClassDec}
     *     method is called to sort the subarray using a different sorting algorithm.</li>
     *     <li>{@code partitionDec(array, left, right)}: If the maximum depth has not been reached,
     *     the {@code partitionDec} method is called to perform the partitioning step of QuickSort.
     *     It returns the index of the pivot element.</li>
     *     <li>The {@code introRecursiveDec} method is recursively called on the left subarray
     *     (elements smaller than the pivot) to further sort it.</li>
     *     <li>The {@code introRecursiveDec} method is recursively called on the right subarray
     *     (elements greater than the pivot) to further sort it.</li>
     *     <li>Else the size of the subarray is not greater than {@code INTRO_SIZE}, the array
     *     is considered small, and the {@code insertionInc}
     *     method is called to perform insertion sort on the subarray.</li>
     *     <li>This is a method declaration for {@code introSortClassDec}.
     *     It appears to be a separate sorting algorithm that is called when the maximum depth is reached.</li>
     * </ul>
     * {@code introRecursiveDec} method implements an adaptive sorting algorithm called
     * <b>Intro Sort.</b> It combines the <b>Quick Sort</b>
     * algorithm with a switch to another sorting algorithm <b>Insertion Sort</b> when
     * the recursion depth exceeds a specified threshold {@code maxDepth}.
     * The purpose of this adaptive approach is to optimize performance by leveraging
     * the strengths of different sorting algorithms depending on the input size.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @see         Intro#INTRO_SIZE
     * @see         Intro#introDec(Comparable[])
     * @see         Intro#introSortClassDec(Comparable[], int, int)
     * @see         InsertionInterface#insertionDec(Comparable[], int, int)
     */
    default void introRecursiveDec(T[] array, int left, int right, int maxDepth) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClassDec(array, left, right);
            }
            int pivot = partitionDec(array, left, right);
            introRecursiveDec(array, left, (pivot - 1), (maxDepth - 1));
            introRecursiveDec(array, (pivot + 1), right, (maxDepth - 1));
        } else {
            insertionDec(array, left, right);
        }
    }

    /**
     * {@code introRecursive} within an interface.
     * This method takes an array of type {@code T[]},
     * an integer {@code left} representing the left index,
     * an integer {@code right} representing the right index,
     * an integer {@code maxDepth} representing the maximum recursion depth,
     * and an instance of the {@code mz.SortFunctional} interface as parameters.
     * The method implements an intro sort algorithm,
     * which is a hybrid sorting algorithm that combines quicksort and insertion sort.
     * <ul>
     *     <li>It first checks if the size of the range {@code (right - left)}
     *     is greater than a predefined constant value {@code INTRO_SIZE}.
     *     If it is, it proceeds with the sorting algorithm.
     *     Otherwise, it directly calls the {@code insertion} method to sort the
     *     smaller range using insertion sort.</li>
     *     <li>If the size of the range is larger than {@code INTRO_SIZE} and
     *     the {@code maxDepth} is <i>0</i> (indicating that the recursion depth has reached its maximum allowed value),
     *     it calls the {@code introSortClass} method to perform a full quicksort on the range.</li>
     *     <li>If the size of the range is larger than {@code INTRO_SIZE} and the {@code maxDepth} is not <i>0</i>,
     *     it proceeds with the quicksort algorithm.</li>
     *     <li>It calls the {@code partition} method
     *     to select a pivot element and partition the range into two sub-ranges.</li>
     *     <li>It recursively calls the {@code introRecursive} method on the left sub-range,
     *     from {@code left} to {@code (pivot - 1)}, with the {@code maxDepth} reduced by <i>1</i>.</li>
     *     <li>It recursively calls the {@code introRecursive} method on the right sub-range,
     *     from {@code pivot + 1} to {@code right}, with the {@code maxDepth} reduced by <i>1</i>.</li>
     *     <li>The recursion continues until the range is small enough to switch to insertion sort.</li>
     *     <li>At that point, it calls the {@code insertion} method to sort the
     *     remaining range using insertion sort.</li>
     * </ul>
     * {@code introRecursive} method implements an intro sort algorithm to sort the
     * array within a specified range ({@code left} to {@code right})
     * in ascending order based on the comparison condition provided by the
     * {@code functionalCompareTo} method of the {@code mz.SortFunctional} interface.
     * It switches to insertion sort for small ranges and performs quicksort
     * recursively for larger ranges,
     * while keeping track of the maximum recursion depth.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @param       functional lambda expression for comparison.
     * @see         Intro#INTRO_SIZE
     * @see         Intro#intro(Comparable[], SortFunctional)
     * @see         Intro#introSortClass(Comparable[], int, int, SortFunctional)
     * @see         InsertionInterface#insertion(Comparable[], int, int, SortFunctional)
     */
    default void introRecursive(T[] array, int left, int right, int maxDepth, SortFunctional<T> functional) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClass(array, left, right, functional);
            }
            int pivot = partition(array, left, right, functional);
            introRecursive(array, left, (pivot - 1), (maxDepth - 1), functional);
            introRecursive(array, (pivot + 1), right, (maxDepth - 1), functional);
        } else {
            insertion(array, left, right, functional);
        }
    }

    /**
     * {@code introInc} that serves as the entry point for performing an <b>Intro Sort</b> on the given list.<br>
     * <b>An Override call is required to use the Interface method.</b>
     * <ul>
     *     <li> This line calls the introRecursiveInc method to perform the
     *     IntroSort on the list. The parameters passed are:</li>
     *     <li><i>0</i> The starting index of the list.</li>
     *     <li>The ending index (inclusive) of the list.</li>
     *     <li>The maximum depth or recursion level allowed for <b>Quick Sort</b>.
     *     It is calculated as twice the logarithm (base 2) of the length of the
     *     list, rounded down to the nearest integer.
     *     This value determines when the algorithm switches to a different sorting method.</li>
     *     <li>default void introInc(List<T> list),
     *     call introRecursiveInc(list, 0, (list.size() - 1), (int) (2 * {@link java.lang.Math#floor(double)
     *     Math.floor}({@link java.lang.Math#log(double) Math.log}(list.size()))));</li>
     * </ul>
     * {@code introInc} method provides a convenient entry point for sorting a list using the IntroSort algorithm.
     * It calculates the maximum depth based on the list length and then calls the
     * introRecursiveInc method to perform the sorting.
     * @param       list The list to be sorted.
     * @see         Intro#introRecursiveInc(List, int, int, int)
     */
    default <L extends T> void introInc(List<L> list) {
        introRecursiveInc(list, 0, (list.size() - 1), (int) (2 * floor(log(list.size()))));
    }

    /**
     * {@code introDec} that serves as the entry point for performing an <b>Intro Sort</b> on the given list.<br>
     * <b>An Override call is required to use the Interface method.</b>
     * <ul>
     *     <li> This line calls the introRecursiveInc method to perform the IntroSort
     *     on the list. The parameters passed are:</li>
     *     <li><i>0</i> The starting index of the list.</li>
     *     <li>The ending index (inclusive) of the list.</li>
     *     <li>The maximum depth or recursion level allowed for <b>Quick Sort</b>.
     *     It is calculated as twice the logarithm (base 2) of the length of the list,
     *     rounded down to the nearest integer.
     *     This value determines when the algorithm switches to a different sorting method.</li>
     *     <li>default void introDec(List<T> list),
     *     call introRecursiveDec(list, 0, (list.size() - 1), (int) (2 * {@link java.lang.Math#floor(double)
     *     Math.floor}({@link java.lang.Math#log(double) Math.log}(list.size()))));</li>
     * </ul>
     * {@code introInc} method provides a convenient entry point for sorting a list using the IntroSort algorithm.
     * It calculates the maximum depth based on the list length and then calls the
     * introRecursiveInc method to perform the sorting.
     * @param       list The list to be sorted.
     * @see         Intro#introRecursiveDec(List, int, int, int)
     */
    default <L extends T> void introDec(List<L> list) {
        introRecursiveDec(list, 0, (list.size() - 1), (int) (2 * floor(log(list.size()))));
    }

    /**
     * {@code intro} within an interface.
     * This method takes a list of type {@code List<T>}
     * and an instance of the {@code SortFunctional} interface as parameters.
     * The method serves as an entry point to the intro sort algorithm for sorting the entire list.
     * <ul>
     *     <li>It calls the {@code introRecursive} method to sort the list, passing the following parameters:
     *     {@code list} the list to be sorted. <i>0</i> the left index of the range, indicating the start of the list.
     *     {@code (list.size() - 1)} the right index of the range, indicating the end of the list.
     *     The maximum recursion depth {@code (int) (2 * }{@link java.lang.Math#floor(double)
     *     Math.floor}({@link java.lang.Math#log(double) Math.log}{@code (list.size())))),}
     *     which is calculated as twice the logarithm (base <i>2</i>) of the length of
     *     the list, rounded down to the nearest integer.
     *     {@code functional} An instance of the mz.SortFunctional interface used for comparison operations.</li>
     *     <li>The {@code introRecursive} method will then perform the sorting process
     *     according to the intro sort algorithm,
     *     which combines quicksort and insertion sort based on the specified recursion depth.</li>
     * </ul>
     * {@code intro} method is responsible for initiating the intro sort algorithm on the entire list,
     * utilizing the {@code introRecursive} method to perform the sorting operation.
     * It calculates the maximum recursion depth based on the length of
     * the list and provides the necessary parameters for the recursive sorting process.
     * @param       list The list to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         Intro#introRecursive(List, int, int, int, SortFunctional)
     */
    default <L extends T> void intro(List<L> list, SortFunctional<T> functional) {
        introRecursive(list, 0, (list.size() - 1), (int) (2 * floor(log(list.size()))), functional);
    }

    /**
     * {@code introRecursiveInc} method implements an adaptive sorting algorithm called Intro Sort.
     * <ul>
     *     <li>This condition checks if the size of the sublist is greater than {@code INTRO_SIZE}.
     *     If true, the list is large enough to be sorted using QuickSort.</li>
     *     <li>This condition checks if the maximum depth has been reached.
     *     If true, the maximum depth has been exceeded,
     *     and the sorting algorithm switches to another sorting method.</li>
     *     <li>{@code introSortClassInc(list, left, right)}:
     *     If the maximum depth has been reached, the {@code introSortClassInc}
     *     method is called to sort the sublist using a different sorting algorithm.</li>
     *     <li>{@code partitionInc(list, left, right)}: If the maximum depth has not been reached,
     *     the {@code partitionInc} method is called to perform the partitioning step of QuickSort.
     *     It returns the index of the pivot element.</li>
     *     <li>The {@code introRecursiveInc} method is recursively called on the left sublist
     *     (elements smaller than the pivot) to further sort it.</li>
     *     <li>The {@code introRecursiveInc} method is recursively called on the right sublis
     *     (elements greater than the pivot) to further sort it.</li>
     *     <li>Else the size of the sublist is not greater than {@code INTRO_SIZE}, the list
     *     is considered small, and the {@code insertionInc}
     *     method is called to perform insertion sort on the sublist.</li>
     *     <li>This is a method declaration for {@code introSortClassInc}.
     *     It appears to be a separate sorting algorithm that is called when the maximum depth is reached.</li>
     * </ul>
     * {@code introRecursiveInc} method implements an adaptive sorting algorithm called
     * <b>Intro Sort.</b> It combines the <b>Quick Sort</b>
     * algorithm with a switch to another sorting algorithm <b>Insertion Sort</b> when
     * the recursion depth exceeds a specified threshold {@code maxDepth}.
     * The purpose of this adaptive approach is to optimize performance by leveraging
     * the strengths of different sorting algorithms depending on the input size.
     * @param       list The list to be sorted.
     * @param       left The starting index of the sublist to be sorted.
     * @param       right The ending index (inclusive) of the sublist to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @see         Intro#INTRO_SIZE
     * @see         Intro#introInc(List)
     * @see         Intro#introSortClassInc(List, int, int)
     * @see         InsertionInterface#insertionInc(List, int, int)
     */
    default <L extends T> void introRecursiveInc(List<L> list, int left, int right, int maxDepth) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClassInc(list, left, right);
            }
            int pivot = partitionInc(list, left, right);
            introRecursiveInc(list, left, (pivot - 1), (maxDepth - 1));
            introRecursiveInc(list, (pivot + 1), right, (maxDepth - 1));
        } else {
            insertionInc(list, left, right);
        }
    }

    /**
     * {@code introRecursiveDec} method implements an adaptive sorting algorithm called Intro Sort.
     * <ul>
     *     <li>This condition checks if the size of the sublist is greater than {@code INTRO_SIZE}.
     *     If true, the list is large enough to be sorted using QuickSort.</li>
     *     <li>This condition checks if the maximum depth has been reached.
     *     If true, the maximum depth has been exceeded,
     *     and the sorting algorithm switches to another sorting method.</li>
     *     <li>{@code introSortClassDec(list, left, right)}:
     *     If the maximum depth has been reached, the {@code introSortClassDec}
     *     method is called to sort the sublist using a different sorting algorithm.</li>
     *     <li>{@code partitionDec(list, left, right)}: If the maximum depth has not been reached,
     *     the {@code partitionDec} method is called to perform the partitioning step of QuickSort.
     *     It returns the index of the pivot element.</li>
     *     <li>The {@code introRecursiveDec} method is recursively called on the left sublist
     *     (elements smaller than the pivot) to further sort it.</li>
     *     <li>The {@code introRecursiveDec} method is recursively called on the right sublist
     *     (elements greater than the pivot) to further sort it.</li>
     *     <li>Else the size of the sublist is not greater than {@code INTRO_SIZE}, the
     *     list is considered small, and the {@code insertionInc}
     *     method is called to perform insertion sort on the sublist.</li>
     *     <li>This is a method declaration for {@code introSortClassDec}.
     *     It appears to be a separate sorting algorithm that is called when the maximum depth is reached.</li>
     * </ul>
     * {@code introRecursiveDec} method implements an adaptive sorting algorithm
     * called <b>Intro Sort.</b> It combines the <b>Quick Sort</b>
     * algorithm with a switch to another sorting algorithm <b>Insertion Sort</b>
     * when the recursion depth exceeds a specified threshold {@code maxDepth}.
     * The purpose of this adaptive approach is to optimize performance by
     * leveraging the strengths of different sorting algorithms depending on the input size.
     * @param       list The list to be sorted.
     * @param       left The starting index of the sublist to be sorted.
     * @param       right The ending index (inclusive) of the sublist to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @see         Intro#INTRO_SIZE
     * @see         Intro#introDec(List)
     * @see         Intro#introSortClassDec(List, int, int)
     * @see         InsertionInterface#insertionDec(List, int, int)
     */
    default <L extends T> void introRecursiveDec(List<L> list, int left, int right, int maxDepth) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClassDec(list, left, right);
            }
            int pivot = partitionDec(list, left, right);
            introRecursiveDec(list, left, (pivot - 1), (maxDepth - 1));
            introRecursiveDec(list, (pivot + 1), right, (maxDepth - 1));
        } else {
            insertionDec(list, left, right);
        }
    }

    /**
     * {@code introRecursive} within an interface.
     * This method takes a list of type {@code T[]},
     * an integer {@code left} representing the left index,
     * an integer {@code right} representing the right index,
     * an integer {@code maxDepth} representing the maximum recursion depth,
     * and an instance of the {@code SortFunctional} interface as parameters.
     * The method implements an intro sort algorithm,
     * which is a hybrid sorting algorithm that combines quicksort and insertion sort.
     * <ul>
     *     <li>It first checks if the size of the range {@code (right - left)}
     *     is greater than a predefined constant value {@code INTRO_SIZE}.
     *     If it is, it proceeds with the sorting algorithm.
     *     Otherwise, it directly calls the {@code insertion} method to sort the
     *     smaller range using insertion sort.</li>
     *     <li>If the size of the range is larger than {@code INTRO_SIZE} and
     *     the {@code maxDepth} is <i>0</i> (indicating that the recursion depth has reached its maximum allowed value),
     *     it calls the {@code introSortClass} method to perform a full quicksort on the range.</li>
     *     <li>If the size of the range is larger than {@code INTRO_SIZE} and the {@code maxDepth} is not <i>0</i>,
     *     it proceeds with the quicksort algorithm.</li>
     *     <li>It calls the {@code partition} method
     *     to select a pivot element and partition the range into two sub-ranges.</li>
     *     <li>It recursively calls the {@code introRecursive} method on the left sub-range,
     *     from {@code left} to {@code (pivot - 1)}, with the {@code maxDepth} reduced by <i>1</i>.</li>
     *     <li>It recursively calls the {@code introRecursive} method on the right sub-range,
     *     from {@code pivot + 1} to {@code right}, with the {@code maxDepth} reduced by <i>1</i>.</li>
     *     <li>The recursion continues until the range is small enough to switch to insertion sort.</li>
     *     <li>At that point, it calls the {@code insertion} method to sort the
     *     remaining range using insertion sort.</li>
     * </ul>
     * {@code introRecursive} method implements an intro sort algorithm to sort
     * the list within a specified range ({@code left} to {@code right})
     * in ascending order based on the comparison condition provided by the
     * {@code functionalCompareTo} method of the {@code mz.SortFunctional} interface.
     * It switches to insertion sort for small ranges and performs quicksort
     * recursively for larger ranges,
     * while keeping track of the maximum recursion depth.
     * @param       list The list to be sorted.
     * @param       left The starting index of the sublist to be sorted.
     * @param       right The ending index (inclusive) of the sublist to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @param       functional lambda expression for comparison.
     * @see         Intro#INTRO_SIZE
     * @see         Intro#intro(List, SortFunctional)
     * @see         Intro#introSortClass(List, int, int, SortFunctional)
     * @see         InsertionInterface#insertion(List, int, int, SortFunctional)
     */
    default <L extends T> void introRecursive(
            List<L> list, int left, int right, int maxDepth, SortFunctional<T> functional) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClass(list, left, right, functional);
            }
            int pivot = partition(list, left, right, functional);
            introRecursive(list, left, (pivot - 1), (maxDepth - 1), functional);
            introRecursive(list, (pivot + 1), right, (maxDepth - 1), functional);
        } else {
            insertion(list, left, right, functional);
        }
    }
}