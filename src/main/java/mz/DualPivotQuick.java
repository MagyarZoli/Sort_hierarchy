package mz;

/**
 * Dual Pivot Quick Sort is an enhanced version of the traditional Quick Sort algorithm that uses
 * two pivot values to partition the array instead of one.
 * This modification improves the efficiency of the sorting algorithm,
 * especially when dealing with arrays that contain many duplicate elements.
 * @since       1.0
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
     * @see         mz.intro.introDPQ.IntroDPQDualPivotQuick#IntroDPQDualPivotQuick() IntroDPQDualPivotQuick
     * @see         mz.intro.IntroDualPivotQuick#IntroDualPivotQuick() IntroDualPivotQuick
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
     * @see         mz.DualPivotQuick#dualPivotQuickInc(Comparable[], int, int)
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
     * @see         mz.DualPivotQuick#dualPivotQuickDec(Comparable[], int, int)
     */
    protected void dualPivotQuickDec(Comparable[] array) {
        dualPivotQuickDec(array, 0, (array.length - 1));
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
     * @see         mz.QuickInterface#partitionDualInc(Comparable[], int, int)
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
     * @see         mz.QuickInterface#partitionDualInc(Comparable[], int, int)
     */
    protected void dualPivotQuickDec(Comparable[] array, int left, int right) {
        if(left < right) {
            int[] pivot = partitionDualDec(array, left, right);
            dualPivotQuickDec(array, left, (pivot[0] - 1));
            dualPivotQuickDec(array, (pivot[0] + 1), (pivot[1] - 1));
            dualPivotQuickDec(array, (pivot[1] + 1), right);
        }
    }
}