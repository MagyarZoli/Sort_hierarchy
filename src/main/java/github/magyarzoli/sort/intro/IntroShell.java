package github.magyarzoli.sort.intro;

import github.magyarzoli.sort.Shell;
import github.magyarzoli.sort.intro.introDPQ.IntroDPQShell;

import java.util.List;

/**
 * Intro Sort is a hybrid sorting algorithm that combines the strengths of Quick Sort and Insertion Sort.
 * It aims to provide fast average-case performance while maintaining worst-case guarantees.
 * The basic idea behind Intro Sort is to start with Quick Sort, which is known for its efficiency on average,
 * but has a worst-case time complexity of <em>O(n^2)</em> in certain scenarios.
 * To mitigate the risk of Quick Sort's worst-case behavior, Intro Sort monitors the recursion depth during the sorting process.
 * If the depth exceeds a certain threshold, the algorithm switches to
 * Another Sort is Shell Sort.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class IntroShell
extends Shell
implements Intro<Comparable> {

    /**
     * <b>Intro Insertion Sort:</b><br>
     * Is a hybrid sorting algorithm that combines the strengths of Quick Sort and Insertion Sort.
     * It aims to provide fast average-case performance while maintaining worst-case guarantees.
     * The basic idea behind Intro Sort is to start with Quick Sort, which is known for its efficiency on average,
     * but has a worst-case time complexity of <em>O(n^2)</em> in certain scenarios.<br><br>
     * To mitigate the risk of Quick Sort's worst-case behavior, Intro Sort monitors the recursion depth during the sorting process.
     * If the depth exceeds a certain threshold, the algorithm switches to
     * Another Sort is Shell Sort.
     * Implements an adaptive sorting algorithm called Intro Sort Interface.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>This condition checks if the size of the subarray is greater than {@code INTRO_SIZE}.
     *     If true, the array is large enough to be sorted using QuickSort.</li>
     *     <li>This condition checks if the maximum depth has been reached.
     *     If true, the maximum depth has been exceeded,
     *     and the sorting algorithm switches to another sorting method is Shell Sort</li>
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
     * algorithm with a switch to another sorting algorithm Insertion Sort when the recursion depth exceeds a specified threshold {@code maxDepth}.
     * The purpose of this adaptive approach is to optimize performance by leveraging the strengths of different sorting algorithms depending on the input size.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>No</b>
     * @see         IntroDPQShell#IntroDPQShell() IntroDPQShell
     */
    public IntroShell() {}

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
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        intro(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        introInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        introDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        intro(list, functional);
    }

    /**
     * {@inheritDoc}
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     */
    @Override
    public void introSortClassInc(Comparable[] array, int left, int right) {
        shellInc(array, left, right);
    }

    /**
     * {@inheritDoc}
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     */
    @Override
    public void introSortClassDec(Comparable[] array, int left, int right) {
        shellDec(array, left, right);
    }

    /**
     * {@inheritDoc}
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void introSortClass(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        shell(array, left, right, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list The array to be sorted.
     * @param       left The starting index of the sublist to be sorted.
     * @param       right The ending index (inclusive) of the sublist to be sorted.
     */
    @Override
    public <L extends Comparable> void introSortClassInc(List<L> list, int left, int right) {
        shellInc(list, left, right);
    }

    /**
     * {@inheritDoc}
     * @param       list The array to be sorted.
     * @param       left The starting index of the sublist to be sorted.
     * @param       right The ending index (inclusive) of the sublist to be sorted.
     */
    @Override
    public <L extends Comparable> void introSortClassDec(List<L> list, int left, int right) {
        shellDec(list, left, right);
    }

    /**
     * {@inheritDoc}
     * @param       list The array to be sorted.
     * @param       left The starting index of the sublist to be sorted.
     * @param       right The ending index (inclusive) of the sublist to be sorted.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public <L extends Comparable> void introSortClass(List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        shell(list, left, right, functional);
    }
}