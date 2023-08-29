package github.magyarzoli.sort.intro.introDPQ;

import github.magyarzoli.sort.intro.IntroOddEvenMerge;

/**
 * IntroDPQ (Dual Pivot Quick) Odd-even Merge Sort is a hybrid sorting algorithm that combines the strengths of Dual Pivot Quick Sort and Odd-even Merge Sort.
 * It aims to provide fast average-case performance while maintaining worst-case guarantees.
 * The basic idea behind Intro Sort is to start with Dual Pivot Quick Sort, which is known for its efficiency on average,
 * but has a worst-case time complexity of <em>O(n^2)</em> in certain scenarios.
 * To mitigate the risk of Dual Pivot Quick Sort's worst-case behavior, Odd-even Merge Sort monitors the recursion depth during the sorting process.
 * If the depth exceeds a certain threshold, the algorithm switches to HeapSort,
 * which guarantees worst-case <em>O(n log(n))</em> time complexity but has higher overhead.
 * Additionally, for small subarrays, Intro switches to Odd-even Merge Sort, which has good performance for small input sizes.
 * @since       1.1
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class IntroDPQOddEvenMerge
extends IntroOddEvenMerge
implements IntroDPQ<Comparable> {

    /**
     * <b>IntroDPQ (Dual Pivot Quick) Odd-even Merge Sort:</b><br>
     * Is a hybrid sorting algorithm that combines the strengths of Dual Pivot Quick Sort and Odd-even Merge Sort.
     * It aims to provide fast average-case performance while maintaining worst-case guarantees.
     * The basic idea behind Intro Sort is to start with Dual Pivot Quick Sort, which is known for its efficiency on average,
     * but has a worst-case time complexity of <em>O(n^2)</em> in certain scenarios.<br><br>
     * To mitigate the risk of Dual Pivot Quick Sort's worst-case behavior, Odd-even Merge Sort monitors the recursion depth during the sorting process.
     * If the depth exceeds a certain threshold, the algorithm switches to HeapSort,
     * which guarantees worst-case <em>O(n log(n))</em> time complexity but has higher overhead.
     * Additionally, for small subarrays, Intro switches to Odd-even Merge Sort, which has good performance for small input sizes.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>It checks if the size of the sub-array length is larger than {@code INTRO_SIZE}.
     *     If it is, it proceeds with the intro sort algorithm.
     *     If not, it uses insertion sort to sort the sub-array.</li>
     *     <li>If the maximum recursion depth is <i>0</i>,
     *     it directly to sort the sub-array using a Intro Odd-even Merge sorting algorithm.
     *     This is a base case to prevent excessive recursion.</li>
     *     <li>If the sub-array size is larger than {@code INTRO_SIZE} and the maximum recursion depth is not <i>0</i>, it performs the following steps:</li>
     *     <li>Partition the sub-array and obtain the pivot indices.</li>
     *     <li>Recursively on the three sub-arrays:</li>
     *     <li>From left to elements smaller than the first pivot</li>
     *     <li>From elements between the two pivots</li>
     *     <li>From elements greater than the second pivot</li>
     *     <li>The recursion depth is decremented by <i>1</i> in each recursive call.</li>
     *     <li>If the sub-array size is smaller or equal to {@code INTRO_SIZE},
     *     perform insertion sort on the sub-array.</li>
     * </ol>
     * <b>Note:</b><br>
     * Recursively applies the intro sort algorithm to sort a given array.
     * It switches to insertion sort when the sub-array size becomes small enough.
     * The maximum recursion depth is used to limit the depth of recursion to prevent excessive stack usage.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(log(n))</em><br>
     * Stability:               <b>No</b>
     */
    public IntroDPQOddEvenMerge() {}
}