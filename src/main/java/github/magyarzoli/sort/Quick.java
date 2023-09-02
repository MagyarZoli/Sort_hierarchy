package github.magyarzoli.sort;

import github.magyarzoli.*;
import github.magyarzoli.sort.intro.IntroQuick;

import java.util.List;

/**
 * Quick Sort is a widely used comparison-based sorting algorithm that follows a divide-and-conquer approach.
 * It works by selecting a pivot element from the array and partitioning the other elements into two sub-arrays,
 * according to whether they are less than or greater than the pivot. The sub-arrays are then recursively sorted,
 * and the sorted sub-arrays are combined to produce the final sorted array.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Quick
        extends SortComparable
        implements QuickInterface<Comparable>, SortFind<Comparable> {

    /**
     * <b>Quick Sort:</b><br>
     * Quick Sort is a widely used comparison-based sorting algorithm that follows a divide-and-conquer approach.
     * It works by selecting a pivot element from the array and partitioning the other elements into two sub-arrays,
     * according to whether they are less than or greater than the pivot. The sub-arrays are then recursively sorted,
     * and the sorted sub-arrays are combined to produce the final sorted array.
     * <b>Example:</b>
     * <ol>
     *     <li>Choose a pivot element from the array. This can be done in various ways, such as selecting
     *     the first, last, or middle element.</li>
     *     <li>Partition the array into two sub-arrays: the elements less than the pivot and the elements greater than
     *     the pivot.
     *     This can be done by iterating through the array and moving elements to the left or right of the pivot based
     *     on their values.</li>
     *     <li>Recursively apply Quick Sort to the two sub-arrays generated in the previous step.</li>
     *     <li>Combine the sorted sub-arrays along with the pivot element to produce the final sorted array.</li>
     * </ol>
     * <b>Note:</b><br>
     * The key step in Quick Sort is the partitioning process,
     * which efficiently places the pivot element in its correct sorted position and divides the array into two
     * sub-arrays.
     * This process ensures that the pivot element is in its final sorted position in each recursive call.<br><br>
     * The choice of pivot can impact the efficiency of the algorithm. In the worst case,
     * where the pivot is consistently selected as the smallest or largest element, Quick Sort can have a time
     * complexity of <em>O(n^2)</em>.
     * However, on average, Quick Sort has a time complexity of <em>O(n log(n))</em>, which makes it efficient for
     * large datasets.<br><br>
     * Quick Sort is an in-place sorting algorithm, meaning it does not require any additional memory beyond the
     * original array.
     * It is widely used due to its efficiency and simplicity.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(log(n))</em><br>
     * Stability:               <b>No</b>
     * @see         IntroQuick#IntroQuick() IntroQuick
     * @see         DualPivotQuick#DualPivotQuick() DualPivotQuick
     * @see         Quick3#Quick3() Quick3
     * @see         StableQuick#StableQuick() StableQuick
     * @see         Slow#Slow() Slow
     */
    public Quick() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        quickInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        quickDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        quick(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        quickInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        quickDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        quick(list, functional);
    }
}