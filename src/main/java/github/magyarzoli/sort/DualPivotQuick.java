package github.magyarzoli.sort;

import github.magyarzoli.QuickInterface;
import github.magyarzoli.sort.intro.IntroDualPivotQuick;

import java.util.List;

/**
 * Dual Pivot Quick Sort is an enhanced version of the traditional Quick Sort algorithm that uses
 * two pivot values to partition the array instead of one.
 * This modification improves the efficiency of the sorting algorithm,
 * especially when dealing with arrays that contain many duplicate elements.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class DualPivotQuick
extends Quick {

    /**
     * <b>Dual Pivot Quick Sort:</b><br>
     * Dual Pivot Quick Sort is an enhanced version of the traditional Quick Sort algorithm that uses
     * two pivot values to partition the array instead of one.
     * This modification improves the efficiency of the sorting algorithm,
     * especially when dealing with arrays that contain many duplicate elements.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>the traditional Quick Sort, a single pivot element is selected, usually from the middle of the array.
     *     In Dual Pivot Quick Sort, two pivot elements, called pivot1 and pivot2, are chosen.
     *     These pivot values are typically selected from different parts of the array, such as the first and last elements.</li>
     *     <li>The array is divided into three sections based on the pivot values.
     *     All elements less than pivot1 are placed to the left,
     *     all elements greater than pivot2 are placed to the right,
     *     and elements between pivot1 and pivot2 are placed in the middle.</li>
     *     <li>After partitioning the array, three subarrays are created:
     *     the left section, the middle section, and the right section.
     *     The Dual Pivot Quick Sort algorithm is then recursively applied to these subarrays.</li>
     *     <li>The left section contains elements smaller than pivot1.
     *     The Dual Pivot Quick Sort is called recursively on this section.</li>
     *     <li>The middle section contains elements between pivot1 and pivot2. If the middle section is non-empty,
     *     the Dual Pivot Quick Sort is called recursively on this section.</li>
     *     <li>The right section contains elements greater than pivot2.
     *     The Dual Pivot Quick Sort is called recursively on this section.</li>
     *     <li>Once the recursive sorting calls return, the subarrays are already sorted.
     *     The algorithm then combines these sorted subarrays to produce the final sorted array.</li>
     * </ol>
     * <b>Note:</b><br>
     * By using two pivot values and dividing the array into three sections,
     * the Dual Pivot Quick Sort algorithm achieves better performance than the traditional Quick Sort algorithm,
     * especially for arrays with many duplicate elements.
     * It reduces the number of comparisons and swaps required, leading to faster sorting times.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(log(n))</em><br>
     * Stability:               <b>No</b>
     * @see         IntroDualPivotQuick#IntroDualPivotQuick() IntroDualPivotQuick
     */
    public DualPivotQuick() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        dualPivotQuickInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        dualPivotQuickDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        dualPivotQuick(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        dualPivotQuickInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        dualPivotQuickDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        dualPivotQuick(list, functional);
    }

    /**
     * {@code dualPivotQuickInc} is a recursive implementation of the dual-pivot quicksort algorithm.
     * This algorithm is used to efficiently sort an array of elements by recursively dividing
     * it into smaller subarrays and rearranging the elements based on pivot values.
     * <ul>
     *     <li>The first check {@code if (left < right)} ensures that there are at least two elements in the subarray to be sorted.
     *     If there's only one element or if the left index is greater than or equal to the right index,
     *     then the subarray is already sorted, and the method returns without performing any further actions.</li>
     *     <li>If the condition {@code (left < right)} is satisfied,
     *     the method proceeds to call the {@code partitionDualInc} method to partition the subarray into three sections based on two pivot values.
     *     The {@code partitionDualInc} method would update the {@code array} such that elements smaller than the first pivot value are placed to the left,
     *     elements between the two pivot values are placed in the middle, and elements larger than the second pivot value are placed to the right.
     *     The pivot array returned by {@code partitionDualInc} contains the indices of the two pivot values.</li>
     *     <li>After partitioning the subarray,
     *     the method makes three recursive calls to {@code dualPivotQuickInc} to sort the three sections formed by the pivot values.
     *     The first recursive call sorts the left section of the subarray from the {@code left} index to {@code (pivot[0] - 1)}.
     *     The second recursive call sorts the middle section from {@code (pivot[0] + 1)} to {@code (pivot[1] - 1)}.
     *     The third recursive call sorts the right section from {@code (pivot[1] + 1)} to the {@code right} index.</li>
     * </ul>
     * By recursively partitioning and sorting the subarrays, the {@code dualPivotQuickInc} method eventually sorts the entire array.
     * @param       array to be arranged.
     * @see         DualPivotQuick#dualPivotQuickInc(Comparable[], int, int)
     */
    protected void dualPivotQuickInc(Comparable[] array) {
        dualPivotQuickInc(array, 0, (array.length - 1));
    }

    /**
     * {@code dualPivotQuickDec} is a recursive implementation of the dual-pivot quicksort algorithm.
     * This algorithm is used to efficiently sort an array of elements by recursively dividing
     * it into smaller subarrays and rearranging the elements based on pivot values.
     * <ul>
     *     <li>The first check {@code if (left < right)} ensures that there are at least two elements in the subarray to be sorted.
     *     If there's only one element or if the left index is greater than or equal to the right index,
     *     then the subarray is already sorted, and the method returns without performing any further actions.</li>
     *     <li>If the condition {@code (left < right)} is satisfied,
     *     the method proceeds to call the {@code partitionDualDec} method to partition the subarray into three sections based on two pivot values.
     *     The {@code partitionDualDec} method would update the {@code array} such that elements smaller than the first pivot value are placed to the left,
     *     elements between the two pivot values are placed in the middle, and elements larger than the second pivot value are placed to the right.
     *     The pivot array returned by {@code partitionDualDec} contains the indices of the two pivot values.</li>
     *     <li>After partitioning the subarray,
     *     the method makes three recursive calls to {@code dualPivotQuickDec} to sort the three sections formed by the pivot values.
     *     The first recursive call sorts the left section of the subarray from the {@code left} index to {@code (pivot[0] - 1)}.
     *     The second recursive call sorts the middle section from {@code (pivot[0] + 1)} to {@code (pivot[1] - 1)}.
     *     The third recursive call sorts the right section from {@code (pivot[1] + 1)} to the {@code right} index.</li>
     * </ul>
     * By recursively partitioning and sorting the subarrays, the {@code dualPivotQuickDec} method eventually sorts the entire array.
     * @param       array to be arranged.
     * @see         DualPivotQuick#dualPivotQuickDec(Comparable[], int, int)
     */
    protected void dualPivotQuickDec(Comparable[] array) {
        dualPivotQuickDec(array, 0, (array.length - 1));
    }

    /**
     * The method {@code dualPivotQuick} takes four parameters:
     * {@code array} an array of {@link java.lang.Comparable Comparable} objects,
     * and {@code functional} an instance of {@code SortFunctional}
     * representing a functional interface for comparison operations.
     * <ul>
     *     <li>The first line of code checks if <i>0</i> is less than {@code (array.length - 1)},
     *     which indicates that the partition has more than one element.
     *     If this condition is false, it means there is nothing to sort, so the method returns.</li>
     *     <li>The code then calls the {@code partitionDual} method,
     *     passing {@code array}, {@code left}, {@code right}, and {@code functional} as parameters.
     *     This method performs the dual-pivot partitioning and returns an array {@code pivot} containing two pivot indices.</li>
     *     <li>After the partitioning is done, the array is divided into three parts: elements less than the smaller pivot,
     *     elements between the two pivots (inclusive),
     *     and elements greater than the larger pivot.</li>
     *     <li>The method recursively calls itself three times to sort the three partitions.
     *     The parameters for the recursive calls are as follows:</li>
     *     <li>{@code dualPivotQuick(array, left, (pivot[0] - 1), functional)}
     *     to sort the left partition (elements less than the smaller pivot).</li>
     *     <li>{@code dualPivotQuick(array, (pivot[0] + 1), (pivot[1] - 1), functional)}
     *     to sort the middle partition (elements between the two pivots).</li>
     *     <li>{@code dualPivotQuick(array, (pivot[1] + 1), right, functional) }
     *     to sort the right partition (elements greater than the larger pivot).</li>
     *     <li>The recursive calls continue until all subpartitions have been sorted,
     *     resulting in a fully sorted array.</li>
     * </ul>
     * the {@code dualPivotQuick} method implements the Dual Pivot Quick Sort algorithm,
     * which is an optimized version of the Quick Sort algorithm.
     * It recursively partitions the array into smaller subpartitions using two pivots,
     * sorts them, and combines them to achieve a final sorted array.
     * The specific comparison operation used for sorting is defined
     * by the {@code functional} object passed as a parameter.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         DualPivotQuick#dualPivotQuick(Comparable[], int, int, SortFunctional)
     */
    protected void dualPivotQuick(Comparable[] array, SortFunctional<Comparable> functional) {
        dualPivotQuick(array, 0, (array.length - 1), functional);
    }

    /**
     * {@code dualPivotQuickInc} is a recursive implementation of the dual-pivot quicksort algorithm.
     * This algorithm is used to efficiently sort an array of elements by recursively dividing
     * it into smaller subarrays and rearranging the elements based on pivot values.
     * <ul>
     *     <li>The first check {@code if (left < right)} ensures that there are at least two elements in the subarray to be sorted.
     *     If there's only one element or if the left index is greater than or equal to the right index,
     *     then the subarray is already sorted, and the method returns without performing any further actions.</li>
     *     <li>If the condition {@code (left < right)} is satisfied,
     *     the method proceeds to call the {@code partitionDualInc} method to partition the subarray into three sections based on two pivot values.
     *     The {@code partitionDualInc} method would update the {@code array} such that elements smaller than the first pivot value are placed to the left,
     *     elements between the two pivot values are placed in the middle, and elements larger than the second pivot value are placed to the right.
     *     The pivot array returned by {@code partitionDualInc} contains the indices of the two pivot values.</li>
     *     <li>After partitioning the subarray,
     *     the method makes three recursive calls to {@code dualPivotQuickInc} to sort the three sections formed by the pivot values.
     *     The first recursive call sorts the left section of the subarray from the {@code left} index to {@code (pivot[0] - 1)}.
     *     The second recursive call sorts the middle section from {@code (pivot[0] + 1)} to {@code (pivot[1] - 1)}.
     *     The third recursive call sorts the right section from {@code (pivot[1] + 1)} to the {@code right} index.</li>
     * </ul>
     * By recursively partitioning and sorting the subarrays, the {@code dualPivotQuickInc} method eventually sorts the entire array.
     * @param       array to be arranged.
     * @param       left index of the subarray to be sorted.
     * @param       right index of the subarray to be sorted.
     * @see         QuickInterface#partitionDualInc(Comparable[], int, int)
     */
    protected void dualPivotQuickInc(Comparable[] array, int left, int right) {
        if(left < right) {
            int[] pivot = partitionDualInc(array, left, right);
            dualPivotQuickInc(array, left, (pivot[0] - 1));
            dualPivotQuickInc(array, (pivot[0] + 1), (pivot[1] - 1));
            dualPivotQuickInc(array, (pivot[1] + 1), right);
        }
    }

    /**
     * {@code dualPivotQuickDec} is a recursive implementation of the dual-pivot quicksort algorithm.
     * This algorithm is used to efficiently sort an array of elements by recursively dividing
     * it into smaller subarrays and rearranging the elements based on pivot values.
     * <ul>
     *     <li>The first check {@code if (left < right)} ensures that there are at least two elements in the subarray to be sorted.
     *     If there's only one element or if the left index is greater than or equal to the right index,
     *     then the subarray is already sorted, and the method returns without performing any further actions.</li>
     *     <li>If the condition {@code (left < right)} is satisfied,
     *     the method proceeds to call the {@code partitionDualDec} method to partition the subarray into three sections based on two pivot values.
     *     The {@code partitionDualDec} method would update the {@code array} such that elements smaller than the first pivot value are placed to the left,
     *     elements between the two pivot values are placed in the middle, and elements larger than the second pivot value are placed to the right.
     *     The pivot array returned by {@code partitionDualDec} contains the indices of the two pivot values.</li>
     *     <li>After partitioning the subarray,
     *     the method makes three recursive calls to {@code dualPivotQuickDec} to sort the three sections formed by the pivot values.
     *     The first recursive call sorts the left section of the subarray from the {@code left} index to {@code (pivot[0] - 1)}.
     *     The second recursive call sorts the middle section from {@code (pivot[0] + 1)} to {@code (pivot[1] - 1)}.
     *     The third recursive call sorts the right section from {@code (pivot[1] + 1)} to the {@code right} index.</li>
     * </ul>
     * By recursively partitioning and sorting the subarrays, the {@code dualPivotQuickDec} method eventually sorts the entire array.
     * @param       array to be arranged.
     * @param       left index of the subarray to be sorted.
     * @param       right index of the subarray to be sorted.
     * @see         QuickInterface#partitionDualInc(Comparable[], int, int)
     */
    protected void dualPivotQuickDec(Comparable[] array, int left, int right) {
        if(left < right) {
            int[] pivot = partitionDualDec(array, left, right);
            dualPivotQuickDec(array, left, (pivot[0] - 1));
            dualPivotQuickDec(array, (pivot[0] + 1), (pivot[1] - 1));
            dualPivotQuickDec(array, (pivot[1] + 1), right);
        }
    }

    /**
     * The method {@code dualPivotQuick} takes four parameters:
     * {@code array} an array of {@link java.lang.Comparable Comparable} objects,
     * {@code left} the starting index of the partition, {@code right} the ending index of the partition,
     * and {@code functional} an instance of {@code SortFunctional}
     * representing a functional interface for comparison operations.
     * <ul>
     *     <li>The first line of code checks if {@code left} is less than {@code right},
     *     which indicates that the partition has more than one element.
     *     If this condition is false, it means there is nothing to sort, so the method returns.</li>
     *     <li>The code then calls the {@code partitionDual} method,
     *     passing {@code array}, {@code left}, {@code right}, and {@code functional} as parameters.
     *     This method performs the dual-pivot partitioning and returns an array {@code pivot} containing two pivot indices.</li>
     *     <li>After the partitioning is done, the array is divided into three parts: elements less than the smaller pivot,
     *     elements between the two pivots (inclusive),
     *     and elements greater than the larger pivot.</li>
     *     <li>The method recursively calls itself three times to sort the three partitions.
     *     The parameters for the recursive calls are as follows:</li>
     *     <li>{@code dualPivotQuick(array, left, (pivot[0] - 1), functional)}
     *     to sort the left partition (elements less than the smaller pivot).</li>
     *     <li>{@code dualPivotQuick(array, (pivot[0] + 1), (pivot[1] - 1), functional)}
     *     to sort the middle partition (elements between the two pivots).</li>
     *     <li>{@code dualPivotQuick(array, (pivot[1] + 1), right, functional) }
     *     to sort the right partition (elements greater than the larger pivot).</li>
     *     <li>The recursive calls continue until all subpartitions have been sorted,
     *     resulting in a fully sorted array.</li>
     * </ul>
     * the {@code dualPivotQuick} method implements the Dual Pivot Quick Sort algorithm,
     * which is an optimized version of the Quick Sort algorithm.
     * It recursively partitions the array into smaller subpartitions using two pivots,
     * sorts them, and combines them to achieve a final sorted array.
     * The specific comparison operation used for sorting is defined
     * by the {@code functional} object passed as a parameter.
     * @param       array to be arranged.
     * @param       left index of the subarray to be sorted.
     * @param       right index of the subarray to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         QuickInterface#partitionDual(Comparable[], int, int, SortFunctional)
     */
    protected void dualPivotQuick(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        if(left < right) {
            int[] pivot = partitionDual(array, left, right, functional);
            dualPivotQuick(array, left, (pivot[0] - 1), functional);
            dualPivotQuick(array, (pivot[0] + 1), (pivot[1] - 1), functional);
            dualPivotQuick(array, (pivot[1] + 1), right, functional);
        }
    }

    /**
     * {@code dualPivotQuickInc} is a recursive implementation of the dual-pivot quicksort algorithm.
     * This algorithm is used to efficiently sort a list of elements by recursively dividing
     * it into smaller subarrays and rearranging the elements based on pivot values.
     * <ul>
     *     <li>The first check {@code if (left < right)} ensures that there are at least two elements in the subarray to be sorted.
     *     If there's only one element or if the left index is greater than or equal to the right index,
     *     then the subarray is already sorted, and the method returns without performing any further actions.</li>
     *     <li>If the condition {@code (left < right)} is satisfied,
     *     the method proceeds to call the {@code partitionDualInc} method to partition the subarray into three sections based on two pivot values.
     *     The {@code partitionDualInc} method would update the {@code list} such that elements smaller than the first pivot value are placed to the left,
     *     elements between the two pivot values are placed in the middle, and elements larger than the second pivot value are placed to the right.
     *     The pivot list returned by {@code partitionDualInc} contains the indices of the two pivot values.</li>
     *     <li>After partitioning the subarray,
     *     the method makes three recursive calls to {@code dualPivotQuickInc} to sort the three sections formed by the pivot values.
     *     The first recursive call sorts the left section of the subarray from the {@code left} index to {@code (pivot[0] - 1)}.
     *     The second recursive call sorts the middle section from {@code (pivot[0] + 1)} to {@code (pivot[1] - 1)}.
     *     The third recursive call sorts the right section from {@code (pivot[1] + 1)} to the {@code right} index.</li>
     * </ul>
     * By recursively partitioning and sorting the subarrays, the {@code dualPivotQuickInc} method eventually sorts the entire list.
     * @param       list to be arranged.
     * @see         DualPivotQuick#dualPivotQuickInc(Comparable[], int, int)
     */
    protected <L extends Comparable> void dualPivotQuickInc(List<L> list) {
        dualPivotQuickInc(list, 0, (list.size() - 1));
    }

    /**
     * {@code dualPivotQuickDec} is a recursive implementation of the dual-pivot quicksort algorithm.
     * This algorithm is used to efficiently sort a list of elements by recursively dividing
     * it into smaller subarrays and rearranging the elements based on pivot values.
     * <ul>
     *     <li>The first check {@code if (left < right)} ensures that there are at least two elements in the subarray to be sorted.
     *     If there's only one element or if the left index is greater than or equal to the right index,
     *     then the subarray is already sorted, and the method returns without performing any further actions.</li>
     *     <li>If the condition {@code (left < right)} is satisfied,
     *     the method proceeds to call the {@code partitionDualDec} method to partition the subarray into three sections based on two pivot values.
     *     The {@code partitionDualDec} method would update the {@code list} such that elements smaller than the first pivot value are placed to the left,
     *     elements between the two pivot values are placed in the middle, and elements larger than the second pivot value are placed to the right.
     *     The pivot list returned by {@code partitionDualDec} contains the indices of the two pivot values.</li>
     *     <li>After partitioning the subarray,
     *     the method makes three recursive calls to {@code dualPivotQuickDec} to sort the three sections formed by the pivot values.
     *     The first recursive call sorts the left section of the subarray from the {@code left} index to {@code (pivot[0] - 1)}.
     *     The second recursive call sorts the middle section from {@code (pivot[0] + 1)} to {@code (pivot[1] - 1)}.
     *     The third recursive call sorts the right section from {@code (pivot[1] + 1)} to the {@code right} index.</li>
     * </ul>
     * By recursively partitioning and sorting the subarrays, the {@code dualPivotQuickDec} method eventually sorts the entire list.
     * @param       list to be arranged.
     * @see         DualPivotQuick#dualPivotQuickDec(Comparable[], int, int)
     */
    protected <L extends Comparable> void dualPivotQuickDec(List<L> list) {
        dualPivotQuickDec(list, 0, (list.size() - 1));
    }

    /**
     * The method {@code dualPivotQuick} takes four parameters:
     * {@code list} an list of {@link java.lang.Comparable Comparable} objects,
     * and {@code functional} an instance of {@code SortFunctional}
     * representing a functional interface for comparison operations.
     * <ul>
     *     <li>The first line of code checks if <i>0</i> is less than {@code (list.size() - 1)},
     *     which indicates that the partition has more than one element.
     *     If this condition is false, it means there is nothing to sort, so the method returns.</li>
     *     <li>The code then calls the {@code partitionDual} method,
     *     passing {@code list}, {@code left}, {@code right}, and {@code functional} as parameters.
     *     This method performs the dual-pivot partitioning and returns an list {@code pivot} containing two pivot indices.</li>
     *     <li>After the partitioning is done, the list is divided into three parts: elements less than the smaller pivot,
     *     elements between the two pivots (inclusive),
     *     and elements greater than the larger pivot.</li>
     *     <li>The method recursively calls itself three times to sort the three partitions.
     *     The parameters for the recursive calls are as follows:</li>
     *     <li>{@code dualPivotQuick(list, left, (pivot[0] - 1), functional)}
     *     to sort the left partition (elements less than the smaller pivot).</li>
     *     <li>{@code dualPivotQuick(list, (pivot[0] + 1), (pivot[1] - 1), functional)}
     *     to sort the middle partition (elements between the two pivots).</li>
     *     <li>{@code dualPivotQuick(list, (pivot[1] + 1), right, functional) }
     *     to sort the right partition (elements greater than the larger pivot).</li>
     *     <li>The recursive calls continue until all subpartitions have been sorted,
     *     resulting in a fully sorted list.</li>
     * </ul>
     * the {@code dualPivotQuick} method implements the Dual Pivot Quick Sort algorithm,
     * which is an optimized version of the Quick Sort algorithm.
     * It recursively partitions the list into smaller subpartitions using two pivots,
     * sorts them, and combines them to achieve a final sorted list.
     * The specific comparison operation used for sorting is defined
     * by the {@code functional} object passed as a parameter.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         DualPivotQuick#dualPivotQuick(Comparable[], int, int, SortFunctional)
     */
    protected <L extends Comparable> void dualPivotQuick(List<L> list, SortFunctional<Comparable> functional) {
        dualPivotQuick(list, 0, (list.size() - 1), functional);
    }

    /**
     * {@code dualPivotQuickInc} is a recursive implementation of the dual-pivot quicksort algorithm.
     * This algorithm is used to efficiently sort a list of elements by recursively dividing
     * it into smaller subarrays and rearranging the elements based on pivot values.
     * <ul>
     *     <li>The first check {@code if (left < right)} ensures that there are at least two elements in the subarray to be sorted.
     *     If there's only one element or if the left index is greater than or equal to the right index,
     *     then the subarray is already sorted, and the method returns without performing any further actions.</li>
     *     <li>If the condition {@code (left < right)} is satisfied,
     *     the method proceeds to call the {@code partitionDualInc} method to partition the subarray into three sections based on two pivot values.
     *     The {@code partitionDualInc} method would update the {@code list} such that elements smaller than the first pivot value are placed to the left,
     *     elements between the two pivot values are placed in the middle, and elements larger than the second pivot value are placed to the right.
     *     The pivot list returned by {@code partitionDualInc} contains the indices of the two pivot values.</li>
     *     <li>After partitioning the subarray,
     *     the method makes three recursive calls to {@code dualPivotQuickInc} to sort the three sections formed by the pivot values.
     *     The first recursive call sorts the left section of the subarray from the {@code left} index to {@code (pivot[0] - 1)}.
     *     The second recursive call sorts the middle section from {@code (pivot[0] + 1)} to {@code (pivot[1] - 1)}.
     *     The third recursive call sorts the right section from {@code (pivot[1] + 1)} to the {@code right} index.</li>
     * </ul>
     * By recursively partitioning and sorting the subarrays, the {@code dualPivotQuickInc} method eventually sorts the entire list.
     * @param       list to be arranged.
     * @param       left index of the subarray to be sorted.
     * @param       right index of the subarray to be sorted.
     * @see         QuickInterface#partitionDualInc(Comparable[], int, int)
     */
    protected <L extends Comparable> void dualPivotQuickInc(List<L> list, int left, int right) {
        if(left < right) {
            int[] pivot = partitionDualInc(list, left, right);
            dualPivotQuickInc(list, left, (pivot[0] - 1));
            dualPivotQuickInc(list, (pivot[0] + 1), (pivot[1] - 1));
            dualPivotQuickInc(list, (pivot[1] + 1), right);
        }
    }

    /**
     * {@code dualPivotQuickDec} is a recursive implementation of the dual-pivot quicksort algorithm.
     * This algorithm is used to efficiently sort a list of elements by recursively dividing
     * it into smaller subarrays and rearranging the elements based on pivot values.
     * <ul>
     *     <li>The first check {@code if (left < right)} ensures that there are at least two elements in the subarray to be sorted.
     *     If there's only one element or if the left index is greater than or equal to the right index,
     *     then the subarray is already sorted, and the method returns without performing any further actions.</li>
     *     <li>If the condition {@code (left < right)} is satisfied,
     *     the method proceeds to call the {@code partitionDualDec} method to partition the subarray into three sections based on two pivot values.
     *     The {@code partitionDualDec} method would update the {@code list} such that elements smaller than the first pivot value are placed to the left,
     *     elements between the two pivot values are placed in the middle, and elements larger than the second pivot value are placed to the right.
     *     The pivot list returned by {@code partitionDualDec} contains the indices of the two pivot values.</li>
     *     <li>After partitioning the subarray,
     *     the method makes three recursive calls to {@code dualPivotQuickDec} to sort the three sections formed by the pivot values.
     *     The first recursive call sorts the left section of the subarray from the {@code left} index to {@code (pivot[0] - 1)}.
     *     The second recursive call sorts the middle section from {@code (pivot[0] + 1)} to {@code (pivot[1] - 1)}.
     *     The third recursive call sorts the right section from {@code (pivot[1] + 1)} to the {@code right} index.</li>
     * </ul>
     * By recursively partitioning and sorting the subarrays, the {@code dualPivotQuickDec} method eventually sorts the entire list.
     * @param       list to be arranged.
     * @param       left index of the subarray to be sorted.
     * @param       right index of the subarray to be sorted.
     * @see         QuickInterface#partitionDualInc(Comparable[], int, int)
     */
    protected <L extends Comparable> void dualPivotQuickDec(List<L> list, int left, int right) {
        if(left < right) {
            int[] pivot = partitionDualDec(list, left, right);
            dualPivotQuickDec(list, left, (pivot[0] - 1));
            dualPivotQuickDec(list, (pivot[0] + 1), (pivot[1] - 1));
            dualPivotQuickDec(list, (pivot[1] + 1), right);
        }
    }

    /**
     * The method {@code dualPivotQuick} takes four parameters:
     * {@code list} an list of {@link java.lang.Comparable Comparable} objects,
     * {@code left} the starting index of the partition, {@code right} the ending index of the partition,
     * and {@code functional} an instance of {@code SortFunctional}
     * representing a functional interface for comparison operations.
     * <ul>
     *     <li>The first line of code checks if {@code left} is less than {@code right},
     *     which indicates that the partition has more than one element.
     *     If this condition is false, it means there is nothing to sort, so the method returns.</li>
     *     <li>The code then calls the {@code partitionDual} method,
     *     passing {@code list}, {@code left}, {@code right}, and {@code functional} as parameters.
     *     This method performs the dual-pivot partitioning and returns an list {@code pivot} containing two pivot indices.</li>
     *     <li>After the partitioning is done, the list is divided into three parts: elements less than the smaller pivot,
     *     elements between the two pivots (inclusive),
     *     and elements greater than the larger pivot.</li>
     *     <li>The method recursively calls itself three times to sort the three partitions.
     *     The parameters for the recursive calls are as follows:</li>
     *     <li>{@code dualPivotQuick(list, left, (pivot[0] - 1), functional)}
     *     to sort the left partition (elements less than the smaller pivot).</li>
     *     <li>{@code dualPivotQuick(list, (pivot[0] + 1), (pivot[1] - 1), functional)}
     *     to sort the middle partition (elements between the two pivots).</li>
     *     <li>{@code dualPivotQuick(list, (pivot[1] + 1), right, functional) }
     *     to sort the right partition (elements greater than the larger pivot).</li>
     *     <li>The recursive calls continue until all subpartitions have been sorted,
     *     resulting in a fully sorted list.</li>
     * </ul>
     * the {@code dualPivotQuick} method implements the Dual Pivot Quick Sort algorithm,
     * which is an optimized version of the Quick Sort algorithm.
     * It recursively partitions the list into smaller subpartitions using two pivots,
     * sorts them, and combines them to achieve a final sorted list.
     * The specific comparison operation used for sorting is defined
     * by the {@code functional} object passed as a parameter.
     * @param       list to be arranged.
     * @param       left index of the subarray to be sorted.
     * @param       right index of the subarray to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         QuickInterface#partitionDual(Comparable[], int, int, SortFunctional)
     */
    protected <L extends Comparable> void dualPivotQuick(List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        if(left < right) {
            int[] pivot = partitionDual(list, left, right, functional);
            dualPivotQuick(list, left, (pivot[0] - 1), functional);
            dualPivotQuick(list, (pivot[0] + 1), (pivot[1] - 1), functional);
            dualPivotQuick(list, (pivot[1] + 1), right, functional);
        }
    }
}