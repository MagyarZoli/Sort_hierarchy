package mz;

/**
 * Merge Insertion Sort or the Ford–Johnson algorithm is a comparison sorting algorithm.
 * It uses fewer comparisons in the worst case than the best previously known algorithms,
 * insertion sort and merge sort, it remains of theoretical interest in connection with
 * the problem of sorting with a minimum number of comparisons.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class MergeInsertion
extends Merge
implements InsertionInterface<Comparable>{

    /**
     * The threshold value for when to switch from merge sort to insertion sort. This value determines
     * the size of subarrays below which insertion sort will be used instead of merge sort.
     */
    protected int MERGE_THRESHOLD = 10;

    /**
     * <b>Merge Insertion Sort:</b><br>
     * Merge Insertion Sort or the Ford–Johnson algorithm is a comparison sorting algorithm.
     * It uses fewer comparisons in the worst case than the best previously known algorithms,
     * insertion sort and merge sort, it remains of theoretical interest in connection with
     * the problem of sorting with a minimum number of comparisons.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Group the elements pairs of {@code (n / 2)} elements, arbitrarily,
     *     leaving one element unpaired if there is an odd number of elements.</li>
     *     <li>Perform {@code (n / 2)} comparisons, one per pair, to determine the larger of the two elements in each pair.</li>
     *     <li>Recursively sort the {@code (n / 2)} larger elements from each pair, creating a
     *     sorted sequence selected of {@code (n / 2)} of the input elements.</li>
     *     <li>Insert at the start of selected the element that was paired with the first and smallest element of selected.</li>
     *     <li>Insert the remaining {@code ((n / 2) - 1)} elements of selected one at a time, with a specially chosen insertion ordering described below.
     *     Use binary search in subsequences of selected (as described below) to determine the position at which each element should be inserted.</li>
     * </ol>
     * <b>Note:</b><br>
     * The algorithm is designed to take advantage of the fact that the binary searches used
     * to insert elements into selected are most efficient (from the point of view of worst case analysis)
     * when the length of the subsequence that is searched is one less than a power of two.<br><br>
     * This is because, for those lengths, all outcomes of the search use the same number of comparisons as each other.
     * To choose an insertion ordering that produces these lengths, consider the sorted sequence selected after
     * step 4 of the outline above (before inserting the remaining elements).<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>Yes</b>
     * @see         mz.intro.IntroMergeInsertion#IntroMergeInsertion() IntroMergeInsertion
     */
    public MergeInsertion() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        mergeInsertionInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        mergeInsertionDec(array);
    }

    /**
     * {@code mergeInsertionInc} is a modified version of the Merge Sort algorithm that incorporates an insertion sort optimization.
     * It sorts an array of Comparable objects by recursively dividing
     * it into smaller subarrays and performing either an insertion sort or a merge sort, depending on the size of the subarray.
     * <ul>
     *     <li>it first checks if the left index is less than the right index.
     *     If this condition is false, it means the subarray contains only one element or is empty,
     *     so no sorting operation is needed.</li>
     *     <li>If the condition in step 1 is true, it checks if the size of the subarray
     *     {@code (right - left)} is less than or equal to the {@code MERGE_THRESHOLD} value.
     *     If it is, it performs an insertion sort on that subarray by calling the {@code insertionInc} method.</li>
     *     <li>If the size of the subarray is greater than the {@code MERGE_THRESHOLD}, it proceeds with the merge sort algorithm.
     *     It calculates the mid index as {@code (left + (right - left) / 2)} and recursively calls {@code mergeInsertionInc}
     *     on the left and right halves of the subarray.</li>
     *     <li>Finally, it calls the {@code mergingInc} method to merge the two sorted halves of the subarray.</li>
     * </ul>
     * By using the insertion sort optimization for small subarrays, the algorithm aims to improve
     * the performance of merge sort when dealing with smaller chunks of data.
     * Insertion sort is generally more efficient than merge sort for small arrays,
     * as it has a lower constant factor and performs fewer comparisons and swaps.
     * @param       array to be arranged.
     * @see         mz.InsertionInterface#insertionInc(Comparable[], int, int)
     * @see         mz.Merge#mergingInc(Comparable[], int, int, int)
     */
    protected void mergeInsertionInc(Comparable[] array) {
        mergeInsertionInc(array, 0, (array.length - 1));
    }

    /**
     * {@code mergeInsertionDec} is a modified version of the Merge Sort algorithm that incorporates an insertion sort optimization.
     * It sorts an array of Comparable objects by recursively dividing
     * it into smaller subarrays and performing either an insertion sort or a merge sort, depending on the size of the subarray.
     * <ul>
     *     <li>it first checks if the left index is less than the right index.
     *     If this condition is false, it means the subarray contains only one element or is empty,
     *     so no sorting operation is needed.</li>
     *     <li>If the condition in step 1 is true, it checks if the size of the subarray
     *     {@code (right - left)} is less than or equal to the {@code MERGE_THRESHOLD} value.
     *     If it is, it performs an insertion sort on that subarray by calling the {@code insertionDec} method.</li>
     *     <li>If the size of the subarray is greater than the {@code MERGE_THRESHOLD}, it proceeds with the merge sort algorithm.
     *     It calculates the mid index as {@code (left + (right - left) / 2)} and recursively calls {@code mergeInsertionDec}
     *     on the left and right halves of the subarray.</li>
     *     <li>Finally, it calls the {@code mergingDec} method to merge the two sorted halves of the subarray.</li>
     * </ul>
     * By using the insertion sort optimization for small subarrays, the algorithm aims to improve
     * the performance of merge sort when dealing with smaller chunks of data.
     * Insertion sort is generally more efficient than merge sort for small arrays,
     * as it has a lower constant factor and performs fewer comparisons and swaps.
     * @param       array to be arranged.
     * @see         mz.InsertionInterface#insertionInc(Comparable[], int, int)
     * @see         mz.Merge#mergingInc(Comparable[], int, int, int)
     */
    protected void mergeInsertionDec(Comparable[] array) {
        mergeInsertionDec(array, 0, (array.length - 1));
    }

    /**
     * {@code mergeInsertionInc} is a modified version of the Merge Sort algorithm that incorporates an insertion sort optimization.
     * It sorts an array of Comparable objects by recursively dividing
     * it into smaller subarrays and performing either an insertion sort or a merge sort, depending on the size of the subarray.
     * <ul>
     *     <li>it first checks if the left index is less than the right index.
     *     If this condition is false, it means the subarray contains only one element or is empty,
     *     so no sorting operation is needed.</li>
     *     <li>If the condition in step 1 is true, it checks if the size of the subarray
     *     {@code (right - left)} is less than or equal to the {@code MERGE_THRESHOLD} value.
     *     If it is, it performs an insertion sort on that subarray by calling the {@code insertionInc} method.</li>
     *     <li>If the size of the subarray is greater than the {@code MERGE_THRESHOLD}, it proceeds with the merge sort algorithm.
     *     It calculates the mid index as {@code (left + (right - left) / 2)} and recursively calls {@code mergeInsertionInc}
     *     on the left and right halves of the subarray.</li>
     *     <li>Finally, it calls the {@code mergingInc} method to merge the two sorted halves of the subarray.</li>
     * </ul>
     * By using the insertion sort optimization for small subarrays, the algorithm aims to improve
     * the performance of merge sort when dealing with smaller chunks of data.
     * Insertion sort is generally more efficient than merge sort for small arrays,
     * as it has a lower constant factor and performs fewer comparisons and swaps.
     * @param       array to be arranged.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @see         mz.InsertionInterface#insertionInc(Comparable[], int, int)
     * @see         mz.Merge#mergingInc(Comparable[], int, int, int)
     */
    protected void mergeInsertionInc(Comparable[] array, int left, int right) {
        if (left < right) {
            if ((right - left) <= MERGE_THRESHOLD) {
                insertionInc(array, left, right);
            } else {
                int mid = (left + ((right - left) / 2));
                mergeInsertionInc(array, left, mid);
                mergeInsertionInc(array, (mid + 1), right);
                mergingInc(array, left, mid, right);
            }
        }
    }

    /**
     * {@code mergeInsertionDec} is a modified version of the Merge Sort algorithm that incorporates an insertion sort optimization.
     * It sorts an array of Comparable objects by recursively dividing
     * it into smaller subarrays and performing either an insertion sort or a merge sort, depending on the size of the subarray.
     * <ul>
     *     <li>it first checks if the left index is less than the right index.
     *     If this condition is false, it means the subarray contains only one element or is empty,
     *     so no sorting operation is needed.</li>
     *     <li>If the condition in step 1 is true, it checks if the size of the subarray
     *     {@code (right - left)} is less than or equal to the {@code MERGE_THRESHOLD} value.
     *     If it is, it performs an insertion sort on that subarray by calling the {@code insertionDec} method.</li>
     *     <li>If the size of the subarray is greater than the {@code MERGE_THRESHOLD}, it proceeds with the merge sort algorithm.
     *     It calculates the mid index as {@code (left + (right - left) / 2)} and recursively calls {@code mergeInsertionDec}
     *     on the left and right halves of the subarray.</li>
     *     <li>Finally, it calls the {@code mergingDec} method to merge the two sorted halves of the subarray.</li>
     * </ul>
     * By using the insertion sort optimization for small subarrays, the algorithm aims to improve
     * the performance of merge sort when dealing with smaller chunks of data.
     * Insertion sort is generally more efficient than merge sort for small arrays,
     * as it has a lower constant factor and performs fewer comparisons and swaps.
     * @param       array to be arranged.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @see         mz.InsertionInterface#insertionInc(Comparable[], int, int)
     * @see         mz.Merge#mergingInc(Comparable[], int, int, int)
     */
    protected void mergeInsertionDec(Comparable[] array, int left, int right) {
        if (left < right) {
            if ((right - left) <= MERGE_THRESHOLD) {
                insertionDec(array, left, right);
            } else {
                int mid = (left + ((right - left) / 2));
                mergeInsertionDec(array, left, mid);
                mergeInsertionDec(array, (mid + 1), right);
                mergingDec(array, left, mid, right);
            }
        }
    }
}