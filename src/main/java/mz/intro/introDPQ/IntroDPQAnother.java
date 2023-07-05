package mz.intro.introDPQ;

import mz.intro.IntroAnother;

/**
 * IntroDPQ (Dual Pivot Quick) Another Sort is a hybrid sorting algorithm that combines the strengths of Dual Pivot Quick Sort and any Another Sort.
 * It aims to provide fast average-case performance while maintaining worst-case guarantees.
 * The basic idea behind Intro Sort is to start with Dual Pivot Quick Sort, which is known for its efficiency on average,
 * but has a worst-case time complexity of <em>O(n^2)</em> in certain scenarios.
 * To mitigate the risk of Dual Pivot Quick Sort's worst-case behavior, any Another Sort monitors the recursion depth during the sorting process.
 * If the depth exceeds a certain threshold, the algorithm switches to HeapSort,
 * which guarantees worst-case <em>O(n log(n))</em> time complexity but has higher overhead.
 * Additionally, for small subarrays, Another switches to Another Sort, which has good performance for small input sizes.
 * @since       1.2
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public abstract class IntroDPQAnother
extends IntroAnother
implements IntroDPQ<Comparable> {

    /**
     * <b>IntroDPQ (Dual Pivot Quick) Another Sort:</b><br>
     * Is a hybrid sorting algorithm that combines the strengths of Dual Pivot Quick Sort and any Another Sort.
     * It aims to provide fast average-case performance while maintaining worst-case guarantees.
     * The basic idea behind Intro Sort is to start with Dual Pivot Quick Sort, which is known for its efficiency on average,
     * but has a worst-case time complexity of <em>O(n^2)</em> in certain scenarios.<br><br>
     * To mitigate the risk of Quick Sort's worst-case behavior, Another Sort monitors the recursion depth during the sorting process.
     * If the depth exceeds a certain threshold, the algorithm switches to
     * Another Sort.
     * Implements an adaptive sorting algorithm called Intro Sort Interface.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>This condition checks if the size of the subarray is greater than {@code INTRO_SIZE}.
     *     If true, the array is large enough to be sorted using Dual Pivot Quicks Sort.</li>
     *     <li>This condition checks if the maximum depth has been reached.
     *     If true, the maximum depth has been exceeded,
     *     and the sorting algorithm switches to another sorting method is Another Sort</li>
     *     <li>If the maximum depth has been reached, the sort the subarray using a different sorting algorithm.</li>
     *     <li>If the maximum depth has not been reached,
     *     the to perform the partitioning step of Dual Pivot Quick Sort.
     *     It returns the index of the pivot element.</li>
     *     <li>The recursively called on the left subarray (elements smaller than the pivot) to further sort it.</li>
     *     <li>The recursively called on the right subarray (elements greater than the pivot) to further sort it.</li>
     *     <li>Else the size of the subarray is not greater than {@code INTRO_SIZE}, the array is considered small, and the
     *     perform insertion sort on the subarray.</li>
     *     <li>This is a abstract method declaration.
     *     It appears to be a separate sorting algorithm that is called when the maximum depth is reached.</li>
     * </ol>
     * <b>Note:</b><br>
     * Implements an adaptive sorting algorithm called Intro Sort. It combines the Dual Pivot Quick Sort
     * algorithm with a switch to another sorting algorithm Another Sort when the recursion depth exceeds a specified threshold {@code maxDepth}.
     * The purpose of this adaptive approach is to optimize performance by leveraging the strengths of different sorting algorithms depending on the input size.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(?)</em><br>
     * Best Case Complexity:    <em>O(?)</em><br>
     * Average Case Complexity: <em>O(?)</em><br>
     * Auxiliary Space:         <em>O(?)</em><br>
     * Stability:               <b>No</b>
     */
    public IntroDPQAnother() {}

    /**
     * {@code introRecursiveInc} method implements an adaptive sorting algorithm called Intro Sort.
     * <ul>
     *     <li>The condition to check if the size of the sub-array is larger than {@code INTRO_SIZE} remains the same.</li>
     *     <li>If the maximum recursion depth {@code maxDepth} is <i>0</i>,
     *     it directly uses the {@code introSortClassInc} method to sort the sub-array.</li>
     *     <li>If the sub-array size is larger than {@code INTRO_SIZE} and the maximum recursion depth is not 0,
     *     it performs the following steps:</li>
     *     <li>Calls the {@code partitionDualInc} method to partition the sub-array and obtain the pivot indices.</li>
     *     <li>Recursively calls {@code introRecursiveInc} on the three sub-arrays as before.</li>
     *     <li>If the sub-array size is smaller or equal to {@code INTRO_SIZE},
     *     it uses the {@code introSortClass2Inc} method instead of {@code insertionInc} to sort the sub-array.
     *     It seems like a different sorting algorithm is being used for smaller sub-arrays in this case.</li>
     * </ul>
     * {@code introRecursiveInc} method still recursively applies the intro sort algorithm to sort a given array.
     * The main difference is the use of different sorting algorithms
     * ({@code introSortClassInc} and {@code introSortClass2Inc}) depending on the size of the sub-array.
     * @param array The array to be sorted.
     * @param left The starting index of the subarray to be sorted.
     * @param right The ending index (inclusive) of the subarray to be sorted.
     * @param maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @see         mz.intro.Intro#INTRO_SIZE
     * @see         mz.intro.Intro#introSortClassInc(Comparable[], int, int)
     * @see         mz.QuickInterface#partitionDualInc(Comparable[], int, int)
     * @see         mz.intro.IntroAnother#introSortClass2Inc(Comparable[], int, int)
     */
    @Override
    public void introRecursiveInc(Comparable[] array, int left, int right, int maxDepth) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClassInc(array, left, right);
            } else {
                int[] pivots = partitionDualInc(array, left, right);
                introRecursiveInc(array, left, (pivots[0] - 1), (maxDepth - 1));
                introRecursiveInc(array, (pivots[0] + 1), (pivots[1] - 1), (maxDepth - 1));
                introRecursiveInc(array, (pivots[1] + 1), right, (maxDepth - 1));
            }
        } else {
            introSortClass2Inc(array, left, right);
        }
    }

    /**
     * {@code introRecursiveInc} method implements an adaptive sorting algorithm called Intro Sort.
     * <ul>
     *     <li>The condition to check if the size of the sub-array is larger than {@code INTRO_SIZE} remains the same.</li>
     *     <li>If the maximum recursion depth {@code maxDepth} is <i>0</i>,
     *     it directly uses the {@code introSortClassInc} method to sort the sub-array.</li>
     *     <li>If the sub-array size is larger than {@code INTRO_SIZE} and the maximum recursion depth is not 0,
     *     it performs the following steps:</li>
     *     <li>Calls the {@code partitionDualInc} method to partition the sub-array and obtain the pivot indices.</li>
     *     <li>Recursively calls {@code introRecursiveInc} on the three sub-arrays as before.</li>
     *     <li>If the sub-array size is smaller or equal to {@code INTRO_SIZE},
     *     it uses the {@code introSortClass2Inc} method instead of {@code insertionInc} to sort the sub-array.
     *     It seems like a different sorting algorithm is being used for smaller sub-arrays in this case.</li>
     * </ul>
     * {@code introRecursiveDec} method still recursively applies the intro sort algorithm to sort a given array.
     * The main difference is the use of different sorting algorithms
     * ({@code introSortClassDec} and {@code introSortClass2Dec}) depending on the size of the sub-array.
     * @param array The array to be sorted.
     * @param left The starting index of the subarray to be sorted.
     * @param right The ending index (inclusive) of the subarray to be sorted.
     * @param maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @see         mz.intro.Intro#INTRO_SIZE
     * @see         mz.intro.Intro#introSortClassDec(Comparable[], int, int)
     * @see         mz.QuickInterface#partitionDualDec(Comparable[], int, int)
     * @see         mz.intro.IntroAnother#introSortClass2Dec(Comparable[], int, int)
     */
    @Override
    public void introRecursiveDec(Comparable[] array, int left, int right, int maxDepth) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClassDec(array, left, right);
            } else {
                int[] pivots = partitionDualDec(array, left, right);
                introRecursiveDec(array, left, (pivots[0] - 1), (maxDepth - 1));
                introRecursiveDec(array, (pivots[0] + 1), (pivots[1] - 1), (maxDepth - 1));
                introRecursiveDec(array, (pivots[1] + 1), right, (maxDepth - 1));
            }
        } else {
            introSortClass2Dec(array, left, right);
        }
    }

    /**
     * {@code introRecursive} method is assumed to be a member of a class that overrides the interface method.
     * It takes a parameter array of type {@code Comparable[]},
     * an integer {@code left} representing the left index, an integer {@code right} representing the right index,
     * an integer {@code maxDepth} representing the maximum recursion depth,
     * and an instance of the {@code SortFunctional<Comparable>} interface as parameters.
     * <ul>
     *     <li>It checks if the size of the range {@code (right - left)}
     *     is greater than a predefined constant value {@code INTRO_SIZE}.
     *     If it is, it proceeds with the sorting algorithm.
     *     Otherwise, it directly calls the {@code introSortClass2} method
     *     to perform a specific sorting operation for the smaller range.</li>
     *     <li>If the size of the range is larger than {@code INTRO_SIZE} and the {@code maxDepth} is <i>0</i>
     *     (indicating that the recursion depth has reached its maximum allowed value),
     *     it calls the {@code introSortClass} method to perform a specific sorting operation for the remaining range.</li>
     *     <li>If the size of the range is larger than {@code INTRO_SIZE} and the {@code maxDepth} is not <i>0</i>,
     *     it proceeds with the intro sort algorithm.</li>
     *     <li>It calls the partitionDual method to select two pivot elements and partition the range into three sub-ranges.</li>
     *     <li>It recursively calls the {@code introRecursive} method on the left sub-range,
     *     from {@code left} to {@code (pivots[0] - 1)}, with the {@code maxDepth} reduced by <i>1</i>.</li>
     *     <li>It recursively calls the {@code introRecursive} method on the middle sub-range,
     *     from {@code (pivots[0] + 1)} to {@code (pivots[1] - 1)}, with the {@code maxDepth} reduced by <i>1</i>.</li>
     *     <li>It recursively calls the {@code introRecursive} method on the right sub-range,
     *     from {@code (pivots[1] + 1)} to {@code right}, with the {@code maxDepth} reduced by <i>1</i>.</li>
     *     <li>The recursion continues until the range is small enough
     *     to switch to a specific sorting operation ({@code introSortClass} or {@code introSortClass2}).</li>
     *     <li>At that point, it calls the corresponding sorting method ({@code introSortClass} or {@code introSortClass2})
     *     to perform the sorting operation on the remaining range.</li>
     * </ul>
     * {@code introRecursive} method still recursively applies the intro sort algorithm to sort a given array.
     * The main difference is the use of different sorting algorithms
     * ({@code introSortClass} and {@code introSortClass2I}) depending on the size of the sub-array.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @param       functional lambda expression for comparison.
     * @see         mz.intro.Intro#INTRO_SIZE
     * @see         mz.intro.Intro#introSortClass(Comparable[], int, int, SortFunctional)
     * @see         mz.QuickInterface#partitionDual(Comparable[], int, int, SortFunctional)
     * @see         mz.intro.IntroAnother#introSortClass2(Comparable[], int, int, SortFunctional)
     */
    @Override
    public void introRecursive(Comparable[] array, int left, int right, int maxDepth, SortFunctional<Comparable> functional) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClass(array, left, right, functional);
            } else {
                int[] pivots = partitionDual(array, left, right, functional);
                introRecursive(array, left, (pivots[0] - 1), (maxDepth - 1), functional);
                introRecursive(array, (pivots[0] + 1), (pivots[1] - 1), (maxDepth - 1), functional);
                introRecursive(array, (pivots[1] + 1), right, (maxDepth - 1), functional);
            }
        } else {
            introSortClass2(array, left, right, functional);
        }
    }
}