package mz.intro;

import mz.SortComparable;

/**
 * Intro Another Sort is a hybrid sorting algorithm that combines the strengths of Quick Sort and any Another Sort.
 * It aims to provide fast average-case performance while maintaining worst-case guarantees.
 * The basic idea behind Intro Sort is to start with Quick Sort, which is known for its efficiency on average,
 * but has a worst-case time complexity of <em>O(n^2)</em> in certain scenarios.
 * To mitigate the risk of Quick Sort's worst-case behavior, any Another Sort monitors the recursion depth during the sorting process.
 * If the depth exceeds a certain threshold, the algorithm switches to HeapSort,
 * which guarantees worst-case <em>O(n log(n))</em> time complexity but has higher overhead.
 * Additionally, for small subarrays, Another switches to Another Sort, which has good performance for small input sizes.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public abstract class IntroAnother
extends SortComparable
implements Intro<Comparable> {

    /**
     * <b>Intro Another Sort:</b><br>
     * Is a hybrid sorting algorithm that combines the strengths of Quick Sort and any Another Sort.
     * It aims to provide fast average-case performance while maintaining worst-case guarantees.
     * The basic idea behind Intro Sort is to start with Quick Sort, which is known for its efficiency on average,
     * but has a worst-case time complexity of <em>O(n^2)</em> in certain scenarios.<br><br>
     * To mitigate the risk of Quick Sort's worst-case behavior, Another Sort monitors the recursion depth during the sorting process.
     * If the depth exceeds a certain threshold, the algorithm switches to
     * Another Sort.
     * Implements an adaptive sorting algorithm called Intro Sort Interface.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>This condition checks if the size of the subarray is greater than {@code INTRO_SIZE}.
     *     If true, the array is large enough to be sorted using QuickSort.</li>
     *     <li>This condition checks if the maximum depth has been reached.
     *     If true, the maximum depth has been exceeded,
     *     and the sorting algorithm switches to another sorting method is Another Sort</li>
     *     <li>If the maximum depth has been reached, the sort the subarray using a different sorting algorithm.</li>
     *     <li>If the maximum depth has not been reached,
     *     the to perform the partitioning step of QuickSort.
     *     It returns the index of the pivot element.</li>
     *     <li>The recursively called on the left subarray (elements smaller than the pivot) to further sort it.</li>
     *     <li>The recursively called on the right subarray (elements greater than the pivot) to further sort it.</li>
     *     <li>Else the size of the subarray is not greater than {@code INTRO_SIZE}, the array is considered small, and the
     *     perform insertion sort on the subarray.</li>
     *     <li>This is a abstract method declaration.
     *     It appears to be a separate sorting algorithm that is called when the maximum depth is reached.</li>
     * </ol>
     * <b>Note:</b><br>
     * Implements an adaptive sorting algorithm called Intro Sort. It combines the Quick Sort
     * algorithm with a switch to another sorting algorithm Another Sort when the recursion depth exceeds a specified threshold {@code maxDepth}.
     * The purpose of this adaptive approach is to optimize performance by leveraging the strengths of different sorting algorithms depending on the input size.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(?)</em><br>
     * Best Case Complexity:    <em>O(?)</em><br>
     * Average Case Complexity: <em>O(?)</em><br>
     * Auxiliary Space:         <em>O(?)</em><br>
     * Stability:               <b>No</b>
     */
    public IntroAnother() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array){
        introInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array){
        introDec(array);
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
     *     <li>Else the size of the subarray is not greater than {@code INTRO_SIZE}, the array is considered small, and the {@code introSortClass2Inc}
     *     method is called to perform Another sort on the subarray.</li>
     *     <li>This is a method declaration for {@code introSortClassInc}.
     *     It appears to be a separate sorting algorithm that is called when the maximum depth is reached.</li>
     * </ul>
     * {@code introRecursiveInc} method implements an adaptive sorting algorithm called <b>Another Sort.</b> It combines the <b>Quick Sort</b>
     * algorithm with a switch to another sorting algorithm <b>Another Sort</b> when the recursion depth exceeds a specified threshold {@code maxDepth}.
     * The purpose of this adaptive approach is to optimize performance by leveraging the strengths of different sorting algorithms depending on the input size.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @see         mz.intro.Intro#INTRO_SIZE
     * @see         mz.intro.Intro#introSortClassInc(Comparable[], int, int)
     * @see         mz.QuickInterface#partitionInc(Comparable[], int, int)
     * @see         mz.intro.IntroAnother#introSortClass2Inc(Comparable[], int, int)
     */
    @Override
    public void introRecursiveInc(Comparable[] array, int left, int right, int maxDepth) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClassInc(array, left, right);
            }
            int pivot = partitionInc(array, left, right);
            introRecursiveInc(array, left, (pivot - 1), (maxDepth - 1));
            introRecursiveInc(array, (pivot + 1), right, (maxDepth - 1));
        } else {
            introSortClass2Inc(array, left, right);
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
     *     <li>Else the size of the subarray is not greater than {@code INTRO_SIZE}, the array is considered small, and the {@code introSortClass2Inc}
     *     method is called to perform insertion sort on the subarray.</li>
     *     <li>This is a method declaration for {@code introSortClassDec}.
     *     It appears to be a separate sorting algorithm that is called when the maximum depth is reached.</li>
     * </ul>
     * {@code introRecursiveDec} method implements an adaptive sorting algorithm called <b>Another Sort.</b> It combines the <b>Quick Sort</b>
     * algorithm with a switch to another sorting algorithm <b>Another Sort</b> when the recursion depth exceeds a specified threshold {@code maxDepth}.
     * The purpose of this adaptive approach is to optimize performance by leveraging the strengths of different sorting algorithms depending on the input size.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @see         mz.intro.Intro#INTRO_SIZE
     * @see         mz.intro.Intro#introSortClassDec(Comparable[], int, int)
     * @see         mz.QuickInterface#partitionDec(Comparable[], int, int)
     * @see         mz.intro.IntroAnother#introSortClass2Dec(Comparable[], int, int)
     */
    @Override
    public void introRecursiveDec(Comparable[] array, int left, int right, int maxDepth) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClassDec(array, left, right);
            }
            int pivot = partitionDec(array, left, right);
            introRecursiveDec(array, left, (pivot - 1), (maxDepth - 1));
            introRecursiveDec(array, (pivot + 1), right, (maxDepth - 1));
        } else {
            introSortClass2Dec(array, left, right);
        }
    }

    /**
     * The another sorting algorithm can be added in this method.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @see         Intro#introRecursiveInc(Comparable[], int, int, int)
     */
    protected abstract void introSortClass2Inc(Comparable[] array, int left, int right);

    /**
     * The another sorting algorithm can be added in this method.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @see         Intro#introRecursiveDec(Comparable[], int, int, int)
     */
    protected abstract void introSortClass2Dec(Comparable[] array, int left, int right);
}