package mz;

import java.util.Arrays;

/**
 * Weave Merge Sort is a variation of the Merge Sort algorithm that aims to achieve better performance by reducing the number of array copies during the merging step.
 * In Weave Merge Sort, instead of creating a new merged array, the merging process is performed directly on the original array.
 * This is achieved by using additional subarrays,
 * left array and right array, to store the elements from the original array temporarily.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class WeaveMerge
extends Merge {

    /**
     * <b>Weave Merge Sort:</b><br>
     * Is a variation of the Merge Sort algorithm that aims to achieve better performance by reducing the number of array copies during the merging step.
     * In Weave Merge Sort, instead of creating a new merged array, the merging process is performed directly on the original array.
     * This is achieved by using additional subarrays,
     * left array and right array, to store the elements from the original array temporarily.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>The method takes an array, a left index, and a right index as parameters.</li>
     *     <li>It calculates the size of the range to be sorted and stores it in the variable {@code n}.</li>
     *     <li>If the size {@code n} is less than or equal to <i>1</i>, the range is already sorted, so the method returns.</li>
     *     <li>Otherwise, it calculates the middle index of the range and stores it in the variable mid.</li>
     *     <li>Two new subarrays, left Array and right Array, are created using {@link java.util.Arrays#copyOfRange(Object[], int, int) Arrays.copyOfRange}.
     *     left Array contains the elements from the array parameter starting from the left index up to (but not including) the middle index.
     *     right Array contains the elements from the middle index up to (but not including) the right index.</li>
     *     <li>The method then calls itself recursively twice. The first recursive call sorts the left subarray by passing the range from the left index to the middle index.
     *     The second recursive call sorts the right subarray by passing the range from the middle index to the right index.</li>
     *     <li>After the recursive calls, passing the original array, left Array, and right Array as parameters.
     *     This helper method performs the merging step by comparing elements from left Array and right Array and placing them in the correct order in the original array.</li>
     *     <li>The recursion continues until the base case is reached, which occurs when the range to be sorted has a size of <i>1</i> or less.
     *     At this point, the recursive calls stop, and the sorting process is complete.</li>
     * </ol>
     * <b>Note:</b><br>
     * By performing the merging step directly on the original array, Weave Merge Sort eliminates the need for creating
     * a new merged array at each recursion level, reducing the number of array copies and potentially improving the performance of the sorting algorithm.<br><br>
     * It's important to note that the efficiency of the Weave Merge Sort algorithm is still determined
     * by the same asymptotic complexity as the standard Merge Sort algorithm, which is <em>O(n log(n))</em>
     * in the average and worst cases, where n is the number of elements in the array.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>Yes</b>
     * @see         mz.intro.introDPQ.IntroDPQWeakHeap#IntroDPQWeakHeap() IntroDPQWeakHeap
     * @see         mz.intro.IntroWeaveMerge#IntroWeaveMerge() IntroWeaveMerge
     */
    public WeaveMerge() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        weaveMergeInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        weaveMergeDec(array);
    }

    /**
     * {@code weaveMergeInc} that performs a weave merge sort algorithm to sort a {@code Comparable} array in ascending order.
     * <ul>
     *     <li>It first calculates the size of the range to be sorted by subtracting <i>0</i> from {@code array.length},
     *     storing the result in the variable {@code n}.</li>
     *     <li>If the size {@code n} is less than or equal to <i>1</i>,
     *     it means the range has at most one element or is empty, so there's nothing to sort, and the method returns.</li>
     *     <li>If the range has more than one element, the method proceeds to calculate the middle index of the range to half of {@code n}.
     *     The result is stored in the variable {@code mid}.</li>
     *     <li>The method then creates two new arrays: {@code leftArray} and {@code rightArray}.
     *     They are created using {@link java.util.Arrays#copyOfRange(Object[], int, int) Arrays.copyOfRange}, which creates a new array containing
     *     the elements from the array parameter starting from
     *     index <i>0</i> (inclusive) and ending at
     *     index {@code mid} (exclusive) for {@code leftArray}, and starting from
     *     index {@code mid} (inclusive) and ending at
     *     index {@code n} (exclusive) for {@code rightArray}.</li>
     *     <li>After creating the <i>0</i> and {@code n} subarrays, the method calls itself recursively twice:
     *     once with the range from <i>0</i> to {@code mid}, and
     *     once with the range from {@code mid} to {@code n}.
     *     This recursive step is responsible for recursively dividing the array into smaller subarrays until the base case {@code (n <= 1)} is reached.</li>
     *     <li>Finally, the method calls another helper method {@code mergingInc} to merge the sorted {@code leftArray} and {@code rightArray} back into the original array,
     *     effectively sorting the entire range from <i>0</i> to {@code n} in ascending order.</li>
     * </ul>
     * {@code weaveMergeInc} method modifies the original array in place rather than returning a new sorted array.
     * @param       array to be sorted.
     * @see         mz.MergeInterface#mergingInc(Comparable[], Comparable[], Comparable[])
     */
    protected void weaveMergeInc(Comparable[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        int mid = (n / 2);
        Comparable[] leftArray = Arrays.copyOfRange(array, 0, mid);
        Comparable[] rightArray = Arrays.copyOfRange(array, mid, n);
        weaveMergeInc(leftArray);
        weaveMergeInc(rightArray);
        mergingInc(array, leftArray, rightArray);
    }

    /**
     * {@code weaveMergeDec} that performs a weave merge sort algorithm to sort a {@code Comparable} array in descending order.
     * <ul>
     *     <li>It first calculates the size of the range to be sorted by subtracting <i>0</i> from {@code array.length},
     *     storing the result in the variable {@code n}.</li>
     *     <li>If the size {@code n} is less than or equal to <i>1</i>,
     *     it means the range has at most one element or is empty, so there's nothing to sort, and the method returns.</li>
     *     <li>If the range has more than one element, the method proceeds to calculate the middle index of the range to half of {@code n}.
     *     The result is stored in the variable {@code mid}.</li>
     *     <li>The method then creates two new arrays: {@code leftArray} and {@code rightArray}.
     *     They are created using {@link java.util.Arrays#copyOfRange(Object[], int, int) Arrays.copyOfRange}, which creates a new array containing
     *     the elements from the array parameter starting from
     *     index <i>0</i> (inclusive) and ending at
     *     index {@code mid} (exclusive) for {@code leftArray}, and starting from
     *     index {@code mid} (inclusive) and ending at
     *     index {@code n} (exclusive) for {@code rightArray}.</li>
     *     <li>After creating the <i>0</i> and {@code n} subarrays, the method calls itself recursively twice:
     *     once with the range from <i>0</i> to {@code mid}, and
     *     once with the range from {@code mid} to {@code n}.
     *     This recursive step is responsible for recursively dividing the array into smaller subarrays until the base case {@code (n <= 1)} is reached.</li>
     *     <li>Finally, the method calls another helper method {@code mergingDec} to merge the sorted {@code leftArray} and {@code rightArray} back into the original array,
     *     effectively sorting the entire range from <i>0</i> to {@code n} in descending order.</li>
     * </ul>
     * {@code weaveMergeInc} method modifies the original array in place rather than returning a new sorted array.
     * @param       array to be sorted.
     * @see         mz.MergeInterface#mergingInc(Comparable[], Comparable[], Comparable[])
     */
    protected void weaveMergeDec(Comparable[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        int mid = (n / 2);
        Comparable[] leftArray = Arrays.copyOfRange(array, 0, mid);
        Comparable[] rightArray = Arrays.copyOfRange(array, mid, n);
        weaveMergeDec(leftArray);
        weaveMergeDec(rightArray);
        mergingDec(array, leftArray, rightArray);
    }

    /**
     * {@code weaveMergeInc} that performs a weave merge sort algorithm to sort a {@code Comparable} array in ascending order.
     * <ul>
     *     <li>It first calculates the size of the range to be sorted by subtracting {@code left} from {@code right},
     *     storing the result in the variable {@code n}.</li>
     *     <li>If the size {@code n} is less than or equal to <i>1</i>,
     *     it means the range has at most one element or is empty, so there's nothing to sort, and the method returns.</li>
     *     <li>If the range has more than one element, the method proceeds to calculate the middle index of the range by adding {@code left} to half of {@code n}.
     *     The result is stored in the variable {@code mid}.</li>
     *     <li>The method then creates two new arrays: {@code leftArray} and {@code rightArray}.
     *     They are created using {@link java.util.Arrays#copyOfRange(Object[], int, int) Arrays.copyOfRange}, which creates a new array containing
     *     the elements from the array parameter starting from
     *     index {@code left} (inclusive) and ending at
     *     index {@code mid} (exclusive) for {@code leftArray}, and starting from
     *     index {@code mid} (inclusive) and ending at
     *     index {@code right} (exclusive) for {@code rightArray}.</li>
     *     <li>After creating the {@code left} and {@code right} subarrays, the method calls itself recursively twice:
     *     once with the range from {@code left} to {@code mid}, and
     *     once with the range from {@code mid} to {@code right}.
     *     This recursive step is responsible for recursively dividing the array into smaller subarrays until the base case {@code (n <= 1)} is reached.</li>
     *     <li>Finally, the method calls another helper method {@code mergingInc} to merge the sorted {@code leftArray} and {@code rightArray} back into the original array,
     *     effectively sorting the entire range from {@code left} to {@code right} in ascending order.</li>
     * </ul>
     * {@code weaveMergeInc} method modifies the original array in place rather than returning a new sorted array.
     * @param       array to be sorted.
     * @param       left  index representing the start of the range to be sorted.
     * @param       right index representing the end of the range to be sorted.
     * @see         mz.MergeInterface#mergingInc(Comparable[], Comparable[], Comparable[])
     */
    protected void weaveMergeInc(Comparable[] array, int left, int right) {
        int n = (right - left);
        if (n <= 1) {
            return;
        }
        int mid = (left + (n / 2));
        Comparable[] leftArray = Arrays.copyOfRange(array, left, mid);
        Comparable[] rightArray = Arrays.copyOfRange(array, mid, right);
        weaveMergeInc(array, left, mid);
        weaveMergeInc(array, mid, right);
        mergingInc(array, leftArray, rightArray);
    }

    /**
     * {@code weaveMergeDec} that performs a weave merge sort algorithm to sort a {@code Comparable} array in descending order.
     * <ul>
     *     <li>It first calculates the size of the range to be sorted by subtracting {@code left} from {@code right},
     *     storing the result in the variable {@code n}.</li>
     *     <li>If the size {@code n} is less than or equal to <i>1</i>,
     *     it means the range has at most one element or is empty, so there's nothing to sort, and the method returns.</li>
     *     <li>If the range has more than one element, the method proceeds to calculate the middle index of the range by adding {@code left} to half of {@code n}.
     *     The result is stored in the variable {@code mid}.</li>
     *     <li>The method then creates two new arrays: {@code leftArray} and {@code rightArray}.
     *     They are created using {@link java.util.Arrays#copyOfRange(Object[], int, int) Arrays.copyOfRange}, which creates a new array containing
     *     the elements from the array parameter starting from
     *     index {@code left} (inclusive) and ending at
     *     index {@code mid} (exclusive) for {@code leftArray}, and starting from
     *     index {@code mid} (inclusive) and ending at
     *     index {@code right} (exclusive) for {@code rightArray}.</li>
     *     <li>After creating the {@code left} and {@code right} subarrays, the method calls itself recursively twice:
     *     once with the range from {@code left} to {@code mid}, and
     *     once with the range from {@code mid} to {@code right}.
     *     This recursive step is responsible for recursively dividing the array into smaller subarrays until the base case {@code (n <= 1)} is reached.</li>
     *     <li>Finally, the method calls another helper method {@code mergingDec} to merge the sorted {@code leftArray} and {@code rightArray} back into the original array,
     *     effectively sorting the entire range from {@code left} to {@code right} in descending order.</li>
     * </ul>
     * {@code weaveMergeDec} method modifies the original array in place rather than returning a new sorted array.
     * @param       array to be sorted.
     * @param       left  index representing the start of the range to be sorted.
     * @param       right index representing the end of the range to be sorted.
     * @see         mz.MergeInterface#mergingDec(Comparable[], Comparable[], Comparable[])
     */
    protected void weaveMergeDec(Comparable[] array, int left, int right) {
        int n = (right - left);
        if (n <= 1) {
            return;
        }
        int mid = (left + (n / 2));
        Comparable[] leftArray = Arrays.copyOfRange(array, left, mid);
        Comparable[] rightArray = Arrays.copyOfRange(array, mid, right);
        weaveMergeDec(array, left, mid);
        weaveMergeDec(array, mid, right);
        mergingDec(array, leftArray, rightArray);
    }
}