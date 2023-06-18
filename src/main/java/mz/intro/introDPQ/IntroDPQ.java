package mz.intro.introDPQ;

import mz.intro.Intro;

/**
 * IntroDPQ (Dual Pivot Quick) Sort is a hybrid sorting algorithm that combines the strengths of Dual Pivot Quick Sort and Insertion Sort.
 * It aims to provide fast average-case performance while maintaining worst-case guarantees.
 * The basic idea behind Intro Sort is to start with Dual Pivot Quick Sort, which is known for its efficiency on average,
 * but has a worst-case time complexity of <em>O(n^2)</em> in certain scenarios.
 * To mitigate the risk of Dual Pivot Quick Sort's worst-case behavior, Intro Sort monitors the recursion depth during the sorting process.
 * If the depth exceeds a certain threshold, the algorithm switches to HeapSort,
 * which guarantees worst-case <em>O(n log(n))</em> time complexity but has higher overhead.
 * Additionally, for small subarrays, IntroSort switches to Insertion Sort, which has good performance for small input sizes.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public interface IntroDPQ<T extends Comparable>
extends Intro<T> {

    /**
     * {@code introRecursiveInc} that performs a recursive implementation of the intro sort algorithm.
     * <ul>
     *     <li>It checks if the size of the sub-array {@code (right - left)} is larger than {@code INTRO_SIZE}.
     *     If it is, it proceeds with the intro sort algorithm.
     *     If not, it uses insertion sort to sort the sub-array.</li>
     *     <li>If the maximum recursion depth {@code maxDepth} is <i>0</i>,
     *     it directly uses the {@code introSortClassInc} method to sort the sub-array using a different sorting algorithm.
     *     This is a base case to prevent excessive recursion.</li>
     *     <li>If the sub-array size is larger than {@code INTRO_SIZE} and the maximum recursion depth is not <i>0</i>, it performs the following steps:</li>
     *     <ul>
     *         <li>Calls the {@code partitionDualInc} method to partition the sub-array and obtain the pivot indices.</li>
     *         <li>Recursively calls {@code introRecursiveInc} on the three sub-arrays:</li>
     *         <ul>
     *             <li>From {@code left} to {@code (pivots[0] - 1)} (elements smaller than the first pivot)</li>
     *             <li>From {@code (pivots[0] + 1)} to {@code (pivots[1] - 1)} (elements between the two pivots)</li>
     *             <li>From {@code (pivots[1] + 1)} to {@code right} (elements greater than the second pivot)</li>
     *         </ul>
     *         <li>The recursion depth {@code maxDepth} is decremented by <i>1</i> in each recursive call.</li>
     *     </ul>
     *     <li>If the sub-array size is smaller or equal to {@code INTRO_SIZE}, it uses
     *     the {@code insertionInc} method to perform insertion sort on the sub-array.</li>
     * </ul>
     * {@code introRecursiveInc} method recursively applies the intro sort algorithm to sort a given array.
     * It switches to insertion sort when the sub-array size becomes small enough.
     * The maximum recursion depth is used to limit the depth of recursion to prevent excessive stack usage.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     */
    @Override
    default void introRecursiveInc(T[] array, int left, int right, int maxDepth) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClassInc(array, left, right);
            }
            int[] pivots = partitionDualInc(array, left, right);
            introRecursiveInc(array, left, (pivots[0] - 1), (maxDepth - 1));
            introRecursiveInc(array, (pivots[0] + 1), (pivots[1] - 1), (maxDepth - 1));
            introRecursiveInc(array, (pivots[1] + 1), right, (maxDepth - 1));
        } else {
            insertionInc(array, left, right);
        }
    }

    /**
     * {@code introRecursiveDec} that performs a recursive implementation of the intro sort algorithm.
     * <ul>
     *     <li>It checks if the size of the sub-array {@code (right - left)} is larger than {@code INTRO_SIZE}.
     *     If it is, it proceeds with the intro sort algorithm.
     *     If not, it uses insertion sort to sort the sub-array.</li>
     *     <li>If the maximum recursion depth {@code maxDepth} is <i>0</i>,
     *     it directly uses the {@code introSortClassDec} method to sort the sub-array using a different sorting algorithm.
     *     This is a base case to prevent excessive recursion.</li>
     *     <li>If the sub-array size is larger than {@code INTRO_SIZE} and the maximum recursion depth is not <i>0</i>, it performs the following steps:</li>
     *     <ul>
     *         <li>Calls the {@code partitionDualDec} method to partition the sub-array and obtain the pivot indices.</li>
     *         <li>Recursively calls {@code introRecursiveDec} on the three sub-arrays:</li>
     *         <ul>
     *             <li>From {@code left} to {@code (pivots[0] - 1)} (elements smaller than the first pivot)</li>
     *             <li>From {@code (pivots[0] + 1)} to {@code (pivots[1] - 1)} (elements between the two pivots)</li>
     *             <li>From {@code (pivots[1] + 1)} to {@code right} (elements greater than the second pivot)</li>
     *         </ul>
     *         <li>The recursion depth {@code maxDepth} is decremented by <i>1</i> in each recursive call.</li>
     *     </ul>
     *     <li>If the sub-array size is smaller or equal to {@code INTRO_SIZE}, it uses
     *     the {@code insertionDec} method to perform insertion sort on the sub-array.</li>
     * </ul>
     * {@code introRecursiveDec} method recursively applies the intro sort algorithm to sort a given array.
     * It switches to insertion sort when the sub-array size becomes small enough.
     * The maximum recursion depth is used to limit the depth of recursion to prevent excessive stack usage.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     */
    @Override
    default void introRecursiveDec(T[] array, int left, int right, int maxDepth) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClassDec(array, left, right);
            }
            int[] pivots = partitionDualDec(array, left, right);
            introRecursiveDec(array, left, (pivots[0] - 1), (maxDepth - 1));
            introRecursiveDec(array, (pivots[0] + 1), (pivots[1] - 1), (maxDepth - 1));
            introRecursiveDec(array, (pivots[1] + 1), right, (maxDepth - 1));
        } else {
            insertionDec(array, left, right);
        }
    }
}