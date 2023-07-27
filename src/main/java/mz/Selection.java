package mz;

import java.util.List;

/**
 * Selection Sort is a simple sorting algorithm that works by dividing an array into two parts:
 * a sorted portion and an unsorted portion. The algorithm repeatedly selects the smallest (or largest)
 * element from the unsorted portion and swaps it with the element at the beginning of the unsorted portion,
 * thereby expanding the sorted portion. This process continues until the entire array becomes sorted.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Selection
extends SortComparable
implements SelectionInterface<Comparable> {

    /**
     * <b>Selection Sort:</b><br>
     * Selection Sort is a simple sorting algorithm that works by dividing an array into two parts:
     * a sorted portion and an unsorted portion. The algorithm repeatedly selects the smallest (or largest)
     * element from the unsorted portion and swaps it with the element at the beginning of the unsorted portion,
     * thereby expanding the sorted portion. This process continues until the entire array becomes sorted.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Find the minimum (or maximum) element in the unsorted portion of the array.</li>
     *     <li>Swap the minimum (or maximum) element with the first element of the unsorted portion.</li>
     *     <li>Expand the sorted portion by moving the boundary one position to the right.</li>
     *     <li>Repeat steps 2-4 until the entire array is sorted.</li>
     * </ol>
     * <b>Note:</b><br>
     * Selection Sort is called "selection" because it repeatedly selects the smallest (or largest) element and places
     * it in its correct position. The algorithm requires n-1 passes for an array of size n to sort it completely.
     * Selection Sort has a time complexity of <em>O(n^2)</em> in the average and worst cases, making it inefficient for large datasets.
     * However, it has the advantage of simplicity and requires only a constant amount of additional space.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n^2)</em><br>
     * Average Case Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>No</b>
     * @see         mz.intro.IntroSelection#IntroSelection() IntroSelection
     * @see         mz.Bubble#Bubble() Bubble
     * @see         mz.DoubleSelection#DoubleSelection() DoubleSelection
     * @see         mz.Pancake#Pancake() Pancake
     */
    public Selection() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        selectionInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        selectionDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        selection(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        selectionInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        selectionDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        selection(list, functional);
    }
}