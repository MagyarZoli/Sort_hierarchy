package github.magyarzoli.sort.intro.introDPQ;

import github.magyarzoli.InsertionInterface;
import github.magyarzoli.QuickInterface;
import github.magyarzoli.SortFunctional;
import github.magyarzoli.sort.intro.Intro;

import java.util.List;

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
 * @since       1.3
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
     *     <li>Calls the {@code partitionDualInc} method to partition the sub-array and obtain the pivot indices.</li>
     *     <li>Recursively calls {@code introRecursiveInc} on the three sub-arrays:</li>
     *     <li>From {@code left} to {@code (pivots[0] - 1)} (elements smaller than the first pivot)</li>
     *     <li>From {@code (pivots[0] + 1)} to {@code (pivots[1] - 1)} (elements between the two pivots)</li>
     *     <li>From {@code (pivots[1] + 1)} to {@code right} (elements greater than the second pivot)</li>
     *     <li>The recursion depth {@code maxDepth} is decremented by <i>1</i> in each recursive call.</li>
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
     * @see         Intro#INTRO_SIZE
     * @see         Intro#introSortClassInc(Comparable[], int, int)
     * @see         QuickInterface#partitionDualInc(Comparable[], int, int)
     * @see         Intro#introRecursiveInc(Comparable[], int, int, int)
     * @see         InsertionInterface#insertionInc(Comparable[], int, int)
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
     *     <li>Calls the {@code partitionDualDec} method to partition the sub-array and obtain the pivot indices.</li>
     *     <li>Recursively calls {@code introRecursiveDec} on the three sub-arrays:</li>
     *     <li>From {@code left} to {@code (pivots[0] - 1)} (elements smaller than the first pivot)</li>
     *     <li>From {@code (pivots[0] + 1)} to {@code (pivots[1] - 1)} (elements between the two pivots)</li>
     *     <li>From {@code (pivots[1] + 1)} to {@code right} (elements greater than the second pivot)</li>
     *     <li>The recursion depth {@code maxDepth} is decremented by <i>1</i> in each recursive call.</li>
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
     * @see         Intro#INTRO_SIZE
     * @see         Intro#introSortClassDec(Comparable[], int, int)
     * @see         QuickInterface#partitionDualDec(Comparable[], int, int)
     * @see         Intro#introRecursiveDec(Comparable[], int, int, int)
     * @see         InsertionInterface#insertionDec(Comparable[], int, int)
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

    /**
     * {@code introRecursive} method is assumed to be a member of a class that overrides the interface method.
     * It takes a parameter array of type {@code T[]},
     * an integer {@code left} representing the left index, an integer {@code right} representing the right index,
     * an integer {@code maxDepth} representing the maximum recursion depth,
     * and an instance of the {@code mz.SortFunctional<T>} interface as parameters.
     * <ul>
     *     <li>It checks if the size of the range {@code (right - left)}
     *     is greater than a predefined constant value {@code INTRO_SIZE}.
     *     If it is, it proceeds with the sorting algorithm.
     *     Otherwise, it directly calls the {@code insertion} method to perform insertion sort on the smaller range.</li>
     *     <li>If the size of the range is larger than {@code INTRO_SIZE} and the {@code maxDepth} is <i>0</i>
     *     (indicating that the recursion depth has reached its maximum allowed value),
     *     it calls the {@code introSortClass} method to perform a specific sorting operation for the remaining range.</li>
     *     <li>If the size of the range is larger than {@code INTRO_SIZE} and the {@code maxDepth} is not <i>0</i>,
     *     it proceeds with the intro sort algorithm.</li>
     *     <li>It calls the {@code partitionDual} method to select two pivot elements and partition the range into three sub-ranges.</li>
     *     <li>It recursively calls the {@code introRecursive} method on the left sub-range,
     *     from {@code left} to {@code (pivots[0] - 1)}, with the {@code maxDepth} reduced by <i>1</i>.</li>
     *     <li>It recursively calls the {@code introRecursive} method on the middle sub-range,
     *     from {@code (pivots[0] + 1)} to {@code (pivots[1] - 1)}, with the maxDepth reduced by <i>1</i>.</li>
     *     <li>It recursively calls the introRecursive method on the right sub-range,
     *     from {@code pivots[1] + 1} to {@code right}, with the {@code maxDepth} reduced by <i>1</i>.</li>
     *     <li>The recursion continues until the range is small enough to switch to insertion sort.</li>
     *     <li>At that point, it calls the {@code insertion} method to perform insertion sort on the remaining range.</li>
     * </ul>
     * {@code introRecursive} method recursively applies the intro sort algorithm to sort a given array.
     * It switches to insertion sort when the sub-array size becomes small enough.
     * The maximum recursion depth is used to limit the depth of recursion to prevent excessive stack usage.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @param       functional lambda expression for comparison.
     * @see         Intro#INTRO_SIZE
     * @see         Intro#introSortClass(Comparable[], int, int, SortFunctional)
     * @see         QuickInterface#partitionDual(Comparable[], int, int, SortFunctional)
     * @see         Intro#introRecursive(Comparable[], int, int, int, SortFunctional)
     * @see         InsertionInterface#insertion(Comparable[], int, int, SortFunctional)
     */
    @Override
    default void introRecursive(T[] array, int left, int right, int maxDepth, SortFunctional<T> functional) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClass(array, left, right, functional);
            }
            int[] pivots = partitionDual(array, left, right, functional);
            introRecursive(array, left, (pivots[0] - 1), (maxDepth - 1), functional);
            introRecursive(array, (pivots[0] + 1), (pivots[1] - 1), (maxDepth - 1), functional);
            introRecursive(array, (pivots[1] + 1), right, (maxDepth - 1), functional);
        } else {
            insertion(array, left, right, functional);
        }
    }

    /**
     * {@code introRecursiveInc} that performs a recursive implementation of the intro sort algorithm.
     * <ul>
     *     <li>It checks if the size of the sub-list {@code (right - left)} is larger than {@code INTRO_SIZE}.
     *     If it is, it proceeds with the intro sort algorithm.
     *     If not, it uses insertion sort to sort the sub-list.</li>
     *     <li>If the maximum recursion depth {@code maxDepth} is <i>0</i>,
     *     it directly uses the {@code introSortClassInc} method to sort the sub-list using a different sorting algorithm.
     *     This is a base case to prevent excessive recursion.</li>
     *     <li>If the sub-list size is larger than {@code INTRO_SIZE} and the maximum recursion depth is not <i>0</i>, it performs the following steps:</li>
     *     <li>Calls the {@code partitionDualInc} method to partition the sub-list and obtain the pivot indices.</li>
     *     <li>Recursively calls {@code introRecursiveInc} on the three sub-arrays:</li>
     *     <li>From {@code left} to {@code (pivots[0] - 1)} (elements smaller than the first pivot)</li>
     *     <li>From {@code (pivots[0] + 1)} to {@code (pivots[1] - 1)} (elements between the two pivots)</li>
     *     <li>From {@code (pivots[1] + 1)} to {@code right} (elements greater than the second pivot)</li>
     *     <li>The recursion depth {@code maxDepth} is decremented by <i>1</i> in each recursive call.</li>
     *     <li>If the sub-list size is smaller or equal to {@code INTRO_SIZE}, it uses
     *     the {@code insertionInc} method to perform insertion sort on the sub-list.</li>
     * </ul>
     * {@code introRecursiveInc} method recursively applies the intro sort algorithm to sort a given list.
     * It switches to insertion sort when the sub-list size becomes small enough.
     * The maximum recursion depth is used to limit the depth of recursion to prevent excessive stack usage.
     * @param       list The list to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @see         Intro#INTRO_SIZE
     * @see         Intro#introSortClassInc(List, int, int)
     * @see         QuickInterface#partitionDualInc(List, int, int)
     * @see         Intro#introRecursiveInc(List, int, int, int)
     * @see         InsertionInterface#insertionInc(List, int, int)
     */
    @Override
    default <L extends T> void introRecursiveInc(List<L> list, int left, int right, int maxDepth) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClassInc(list, left, right);
            }
            int[] pivots = partitionDualInc(list, left, right);
            introRecursiveInc(list, left, (pivots[0] - 1), (maxDepth - 1));
            introRecursiveInc(list, (pivots[0] + 1), (pivots[1] - 1), (maxDepth - 1));
            introRecursiveInc(list, (pivots[1] + 1), right, (maxDepth - 1));
        } else {
            insertionInc(list, left, right);
        }
    }

    /**
     * {@code introRecursiveDec} that performs a recursive implementation of the intro sort algorithm.
     * <ul>
     *     <li>It checks if the size of the sub-list {@code (right - left)} is larger than {@code INTRO_SIZE}.
     *     If it is, it proceeds with the intro sort algorithm.
     *     If not, it uses insertion sort to sort the sub-list.</li>
     *     <li>If the maximum recursion depth {@code maxDepth} is <i>0</i>,
     *     it directly uses the {@code introSortClassDec} method to sort the sub-list using a different sorting algorithm.
     *     This is a base case to prevent excessive recursion.</li>
     *     <li>If the sub-list size is larger than {@code INTRO_SIZE} and the maximum recursion depth is not <i>0</i>, it performs the following steps:</li>
     *     <li>Calls the {@code partitionDualDec} method to partition the sub-list and obtain the pivot indices.</li>
     *     <li>Recursively calls {@code introRecursiveDec} on the three sub-arrays:</li>
     *     <li>From {@code left} to {@code (pivots[0] - 1)} (elements smaller than the first pivot)</li>
     *     <li>From {@code (pivots[0] + 1)} to {@code (pivots[1] - 1)} (elements between the two pivots)</li>
     *     <li>From {@code (pivots[1] + 1)} to {@code right} (elements greater than the second pivot)</li>
     *     <li>The recursion depth {@code maxDepth} is decremented by <i>1</i> in each recursive call.</li>
     *     <li>If the sub-list size is smaller or equal to {@code INTRO_SIZE}, it uses
     *     the {@code insertionDec} method to perform insertion sort on the sub-list.</li>
     * </ul>
     * {@code introRecursiveDec} method recursively applies the intro sort algorithm to sort a given list.
     * It switches to insertion sort when the sub-list size becomes small enough.
     * The maximum recursion depth is used to limit the depth of recursion to prevent excessive stack usage.
     * @param       list The list to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @see         Intro#INTRO_SIZE
     * @see         Intro#introSortClassDec(List, int, int)
     * @see         QuickInterface#partitionDualDec(List, int, int)
     * @see         Intro#introRecursiveDec(List, int, int, int)
     * @see         InsertionInterface#insertionDec(List, int, int)
     */
    @Override
    default <L extends T> void introRecursiveDec(List<L> list, int left, int right, int maxDepth) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClassDec(list, left, right);
            }
            int[] pivots = partitionDualDec(list, left, right);
            introRecursiveDec(list, left, (pivots[0] - 1), (maxDepth - 1));
            introRecursiveDec(list, (pivots[0] + 1), (pivots[1] - 1), (maxDepth - 1));
            introRecursiveDec(list, (pivots[1] + 1), right, (maxDepth - 1));
        } else {
            insertionDec(list, left, right);
        }
    }

    /**
     * {@code introRecursive} method is assumed to be a member of a class that overrides the interface method.
     * It takes a parameter list of type {@code T[]},
     * an integer {@code left} representing the left index, an integer {@code right} representing the right index,
     * an integer {@code maxDepth} representing the maximum recursion depth,
     * and an instance of the {@code mz.SortFunctional<T>} interface as parameters.
     * <ul>
     *     <li>It checks if the size of the range {@code (right - left)}
     *     is greater than a predefined constant value {@code INTRO_SIZE}.
     *     If it is, it proceeds with the sorting algorithm.
     *     Otherwise, it directly calls the {@code insertion} method to perform insertion sort on the smaller range.</li>
     *     <li>If the size of the range is larger than {@code INTRO_SIZE} and the {@code maxDepth} is <i>0</i>
     *     (indicating that the recursion depth has reached its maximum allowed value),
     *     it calls the {@code introSortClass} method to perform a specific sorting operation for the remaining range.</li>
     *     <li>If the size of the range is larger than {@code INTRO_SIZE} and the {@code maxDepth} is not <i>0</i>,
     *     it proceeds with the intro sort algorithm.</li>
     *     <li>It calls the {@code partitionDual} method to select two pivot elements and partition the range into three sub-ranges.</li>
     *     <li>It recursively calls the {@code introRecursive} method on the left sub-range,
     *     from {@code left} to {@code (pivots[0] - 1)}, with the {@code maxDepth} reduced by <i>1</i>.</li>
     *     <li>It recursively calls the {@code introRecursive} method on the middle sub-range,
     *     from {@code (pivots[0] + 1)} to {@code (pivots[1] - 1)}, with the maxDepth reduced by <i>1</i>.</li>
     *     <li>It recursively calls the introRecursive method on the right sub-range,
     *     from {@code pivots[1] + 1} to {@code right}, with the {@code maxDepth} reduced by <i>1</i>.</li>
     *     <li>The recursion continues until the range is small enough to switch to insertion sort.</li>
     *     <li>At that point, it calls the {@code insertion} method to perform insertion sort on the remaining range.</li>
     * </ul>
     * {@code introRecursive} method recursively applies the intro sort algorithm to sort a given list.
     * It switches to insertion sort when the sub-list size becomes small enough.
     * The maximum recursion depth is used to limit the depth of recursion to prevent excessive stack usage.
     * @param       list The list to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       maxDepth The maximum depth or recursion level allowed before switching to another sorting algorithm.
     * @param       functional lambda expression for comparison.
     * @see         Intro#INTRO_SIZE
     * @see         Intro#introSortClass(List, int, int, SortFunctional)
     * @see         QuickInterface#partitionDual(List, int, int, SortFunctional)
     * @see         Intro#introRecursive(List, int, int, int, SortFunctional)
     * @see         InsertionInterface#insertion(List, int, int, SortFunctional)
     */
    @Override
    default <L extends T> void introRecursive(List<L> list, int left, int right, int maxDepth, SortFunctional<T> functional) {
        if ((right - left) > INTRO_SIZE) {
            if (maxDepth == 0) {
                introSortClass(list, left, right, functional);
            }
            int[] pivots = partitionDual(list, left, right, functional);
            introRecursive(list, left, (pivots[0] - 1), (maxDepth - 1), functional);
            introRecursive(list, (pivots[0] + 1), (pivots[1] - 1), (maxDepth - 1), functional);
            introRecursive(list, (pivots[1] + 1), right, (maxDepth - 1), functional);
        } else {
            insertion(list, left, right, functional);
        }
    }
}