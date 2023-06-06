package mz.intro;

import mz.InsertionInterface;
import mz.QuickInterface;
import mz.Sort;

/**
 * Intro Sort is a hybrid sorting algorithm that combines the strengths of Quick Sort and Insertion Sort.
 * It aims to provide fast average-case performance while maintaining worst-case guarantees.
 * The basic idea behind Intro Sort is to start with Quick Sort, which is known for its efficiency on average,
 * but has a worst-case time complexity of <em>O(n^2)</em> in certain scenarios.
 * To mitigate the risk of Quick Sort's worst-case behavior, Intro Sort monitors the recursion depth during the sorting process.
 * If the depth exceeds a certain threshold, the algorithm switches to HeapSort,
 * which guarantees worst-case <em>O(n log(n))</em> time complexity but has higher overhead.
 * Additionally, for small subarrays, IntroSort switches to Insertion Sort, which has good performance for small input sizes.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public interface Intro<T extends Comparable>
extends Sort<T>, InsertionInterface<T>, QuickInterface<T> {

    /**
     * Size of each intro
     */
    int INTRO_SIZE = 16;

    /**
     * {@code introInc} that serves as the entry point for performing an <b>Intro Sort</b> on the given array.<br>
     * <b>An Override call is required to use the Interface method.</b>
     * <ul>
     *     <li> This line calls the introRecursiveInc method to perform the IntroSort on the array. The parameters passed are:</li>
     *     <li><i>0</i> The starting index of the array.</li>
     *     <li>The ending index (inclusive) of the array.</li>
     *     <li>The maximum depth or recursion level allowed for <b>Quick Sort</b>.
     *     It is calculated as twice the logarithm (base 2) of the length of the array, rounded down to the nearest integer.
     *     This value determines when the algorithm switches to a different sorting method.</li>
     *     <pre>
     *     default void introInc(T[] array) {
     *         introRecursiveInc(array, 0, (array.length - 1), (int) (2 * {@link java.lang.Math#floor(double) Math.floor}({@link java.lang.Math#log(double) Math.log}(array.length))));
     *     }
     *     </pre>
     * </ul>
     * {@code introInc} method provides a convenient entry point for sorting an array using the IntroSort algorithm.
     * It calculates the maximum depth based on the array length and then calls the introRecursiveInc method to perform the sorting.
     * @param       array The array to be sorted.
     * @see         Intro#introRecursiveInc(Comparable[], int, int, int)                    
     */
    default void introInc(T[] array) {
        introRecursiveInc(array, 0, (array.length - 1), (int) (2 * Math.floor(Math.log(array.length))));
    }

    /**
     * {@code introDec} that serves as the entry point for performing an <b>Intro Sort</b> on the given array.<br>
     * <b>An Override call is required to use the Interface method.</b>
     * <ul>
     *     <li> This line calls the introRecursiveInc method to perform the IntroSort on the array. The parameters passed are:</li>
     *     <li><i>0</i> The starting index of the array.</li>
     *     <li>The ending index (inclusive) of the array.</li>
     *     <li>The maximum depth or recursion level allowed for <b>Quick Sort</b>.
     *     It is calculated as twice the logarithm (base 2) of the length of the array, rounded down to the nearest integer.
     *     This value determines when the algorithm switches to a different sorting method.</li>
     *     <pre>
     *     default void introDec(T[] array) {
     *         introRecursiveDec(array, 0, (array.length - 1), (int) (2 * {@link java.lang.Math#floor(double) Math.floor}({@link java.lang.Math#log(double) Math.log}(array.length))));
     *     }
     *     </pre>
     * </ul>
     * {@code introInc} method provides a convenient entry point for sorting an array using the IntroSort algorithm.
     * It calculates the maximum depth based on the array length and then calls the introRecursiveInc method to perform the sorting.
     * @param       array The array to be sorted.
     * @see         Intro#introRecursiveDec(Comparable[], int, int, int)                    
     */
    default void introDec(T[] array) {
        introRecursiveDec(array, 0, (array.length - 1), (int) (2 * Math.floor(Math.log(array.length))));
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
     *     <li>The {@code introRecursiveInc} method is recursively called on the left subarray (elements smaller than the pivot) to further sort it.</li>
     *     <li>The {@code introRecursiveInc} method is recursively called on the right subarray (elements greater than the pivot) to further sort it.</li>
     *     <li>Else the size of the subarray is not greater than {@code INTRO_SIZE}, the array is considered small, and the {@code insertionInc}
     *     method is called to perform insertion sort on the subarray.</li>
     *     <li>This is a method declaration for {@code introSortClassInc}.
     *     It appears to be a separate sorting algorithm that is called when the maximum depth is reached.</li>
     * </ul>
     * {@code introRecursiveInc} method implements an adaptive sorting algorithm called <b>Intro Sort.</b> It combines the <b>Quick Sort</b>
     * algorithm with a switch to another sorting algorithm <b>Insertion Sort</b> when the recursion depth exceeds a specified threshold {@code maxDepth}.
     * The purpose of this adaptive approach is to optimize performance by leveraging the strengths of different sorting algorithms depending on the input size.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @see         Intro#INTRO_SIZE                      
     * @see         Intro#introInc(Comparable[]) 
     * @see         Intro#introSortClassInc(Comparable[], int, int) 
     * @see         mz.InsertionInterface#insertionInc(Comparable[], int, int) 
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
     *     <li>The {@code introRecursiveDec} method is recursively called on the left subarray (elements smaller than the pivot) to further sort it.</li>
     *     <li>The {@code introRecursiveDec} method is recursively called on the right subarray (elements greater than the pivot) to further sort it.</li>
     *     <li>Else the size of the subarray is not greater than {@code INTRO_SIZE}, the array is considered small, and the {@code insertionInc}
     *     method is called to perform insertion sort on the subarray.</li>
     *     <li>This is a method declaration for {@code introSortClassDec}.
     *     It appears to be a separate sorting algorithm that is called when the maximum depth is reached.</li>
     * </ul>
     * {@code introRecursiveDec} method implements an adaptive sorting algorithm called <b>Intro Sort.</b> It combines the <b>Quick Sort</b>
     * algorithm with a switch to another sorting algorithm <b>Insertion Sort</b> when the recursion depth exceeds a specified threshold {@code maxDepth}.
     * The purpose of this adaptive approach is to optimize performance by leveraging the strengths of different sorting algorithms depending on the input size.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @see         Intro#INTRO_SIZE
     * @see         Intro#introDec(Comparable[])
     * @see         Intro#introSortClassDec(Comparable[], int, int) 
     * @see         mz.InsertionInterface#insertionDec(Comparable[], int, int) 
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
}