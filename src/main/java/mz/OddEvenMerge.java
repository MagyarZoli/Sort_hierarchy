package mz;

import java.util.Arrays;

/**
 * Odd-even Merge Sort algorithm is a parallel sorting algorithm that is based on the concept of odd-even transposition sorting.
 * It works by repeatedly comparing and swapping adjacent elements in pairs until the entire array is sorted.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class OddEvenMerge
extends OddEven
implements MergeInterface<Comparable> {

    /**
     * <b>Odd-even Merge Sort:</b><br>
     * <b>Example:</b>
     * Odd-even Merge Sort algorithm is a parallel sorting algorithm that is based on the concept of odd-even transposition sorting.
     * It works by repeatedly comparing and swapping adjacent elements in pairs until the entire array is sorted.<br>
     * <ol>
     *     <li>Divide the array: The array is divided into two halves.
     *     The odd-indexed elements are considered in the first half,
     *     and the even-indexed elements are considered in the second half.</li>
     *     <li>Sort the halves: Both halves are sorted independently using the same odd-even merge sort algorithm.</li>
     *     <li>Merge the sorted halves: The sorted halves are merged by comparing and swapping adjacent elements in pairs.
     *     The odd-indexed elements of the first half are compared with their corresponding even-indexed elements in the second half.
     *     If an element in the first half is greater than the corresponding element in the second half, they are swapped.</li>
     *     <li>Repeat until sorted: Steps 2 and 3 are repeated recursively until the entire array is sorted.
     *     This involves repeatedly dividing the array into halves, sorting them, and merging them back together.</li>
     * </ol>
     * <b>Note:</b><br>
     * The odd-even merge sort algorithm takes advantage of the parallelism available in certain hardware architectures,
     * where pairs of adjacent elements can be compared and swapped simultaneously.
     * By sorting and merging the odd and even elements separately,
     * the algorithm exploits this parallelism and improves the sorting performance.<br><br>
     * It's important to note that the odd-even merge sort algorithm has a complexity of <em>O(n^2)</em> in the worst case,
     * where n is the number of elements in the array.
     * However, it can achieve better performance on parallel architectures due to its parallel nature.<br><br>
     * Stability: Odd-even merge sort is a stable sorting algorithm.
     * This means that the relative order of elements with equal values is preserved after sorting.
     * If two elements have the same value, the algorithm ensures that their original order is maintained in the sorted array.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n^2)</em><br>
     * Average Case Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>Yes</b>
     * @see         mz.intro.IntroOddEvenMerge#IntroOddEvenMerge() IntroOddEvenMerge
     * @see         mz.BatcherOddEvenMerge#BatcherOddEvenMerge() BatcherOddEvenMerge
     */
    public OddEvenMerge() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        oddEvenMergeInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        oddEvenMergeDec(array);
    }

    /**
     * {@code oddEvenMergeInc} takes an array of {@link java.lang.Comparable Comparable} objects,
     * along with the indices <i>0</i> and {@code array.length} indicating the range of elements to be sorted.
     * The Odd-even Merge Sort algorithm.
     * This algorithm is a parallel sorting algorithm that works by dividing the array into two halves, sorting them recursively,
     * and then merging them back together.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The variable {@code n} is initialized with the value of {@code array.length},
     *     representing the number of elements to be sorted in the current recursion.
     *     If {@code n} is less than or equal to <i>1</i>,
     *     the method returns, as there is no need to sort an array with <i>0</i> or <i>1</i> element.</li>
     *     <li>The variable {@code mid} is set to {@code (n / 2)}, representing the midpoint of the current range.</li>
     *     <li>Two new arrays, {@code oddHalf} and {@code evenHalf}, are created using {@link java.util.Arrays#copyOfRange(Object[], int, int) Arrays.copyOfRange}.
     *     {@code oddHalf} contains the elements from index <i>0</i> to {@code (mid - 1)} of the original array,
     *     and {@code evenHalf} contains the elements from index {@code mid} to {@code (n - 1)}.</li>
     *     <li>The {@code oddEvenMergeInc} method is recursively called on both {@code oddHalf} and {@code evenHalf} to sort them.</li>
     *     <li>A loop iterates from <i>0</i> to {@code (mid - 1)}.
     *     For iteration, it compares the element at index {@code i} with the element at index {@code (i + mid)} in the original array.
     *     If the element at index {@code i} is greater than the element at index {@code (i + mid)},
     *     a {@code swap} method is called to swap the two elements.</li>
     * </ul>
     * Finally, the {@code mergingInc} method is called with the original array, {@code oddHalf},
     * and {@code evenHalf} as arguments to merge the two sorted halves back into the original array.
     * @param       array to be arranged.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     * @see         mz.MergeInterface#mergingInc(Comparable[], Comparable[], Comparable[])
     */
    @SuppressWarnings("unchecked")
    protected void oddEvenMergeInc(Comparable[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        int mid = (n / 2);
        Comparable[] oddHalf = Arrays.copyOfRange(array, 0, mid);
        Comparable[] evenHalf = Arrays.copyOfRange(array, mid, n);
        oddEvenMergeInc(oddHalf);
        oddEvenMergeInc(evenHalf);
        for (int i = 0; i < mid; i++) {
            if (array[i].compareTo(array[(i + mid)]) > 0) {
                swap(array, i, mid);
            }
        }
        mergingInc(array, oddHalf, evenHalf);
    }

    /**
     * {@code oddEvenMergeDec} takes an array of {@link java.lang.Comparable Comparable} objects,
     * along with the indices <i>0</i> and {@code array.length} indicating the range of elements to be sorted.
     * The Odd-even Merge Sort algorithm.
     * This algorithm is a parallel sorting algorithm that works by dividing the array into two halves, sorting them recursively,
     * and then merging them back together.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The variable {@code n} is initialized with the value of {@code array.length},
     *     representing the number of elements to be sorted in the current recursion.
     *     If {@code n} is less than or equal to <i>1</i>,
     *     the method returns, as there is no need to sort an array with <i>0</i> or <i>1</i> element.</li>
     *     <li>The variable {@code mid} is set to {@code (n / 2)}, representing the midpoint of the current range.</li>
     *     <li>Two new arrays, {@code oddHalf} and {@code evenHalf}, are created using {@link java.util.Arrays#copyOfRange(Object[], int, int) Arrays.copyOfRange}.
     *     {@code oddHalf} contains the elements from index <i>0</i> to {@code (mid - 1)} of the original array,
     *     and {@code evenHalf} contains the elements from index {@code mid} to {@code (n - 1)}.</li>
     *     <li>The {@code oddEvenMergeDec} method is recursively called on both {@code oddHalf} and {@code evenHalf} to sort them.</li>
     *     <li>A loop iterates from <i>0</i> to {@code (mid - 1)}.
     *     For iteration, it compares the element at index {@code i} with the element at index {@code (i + mid)} in the original array.
     *     If the element at index {@code i} is smaller than the element at index {@code (i + mid)},
     *     a {@code swap} method is called to swap the two elements.</li>
     * </ul>
     * Finally, the {@code mergingDec} method is called with the original array, {@code oddHalf},
     * and {@code evenHalf} as arguments to merge the two sorted halves back into the original array.
     * @param       array to be arranged.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     * @see         mz.MergeInterface#mergingDec(Comparable[], Comparable[], Comparable[])
     */
    @SuppressWarnings("unchecked")
    protected void oddEvenMergeDec(Comparable[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        int mid = (n / 2);
        Comparable[] oddHalf = Arrays.copyOfRange(array, 0, mid);
        Comparable[] evenHalf = Arrays.copyOfRange(array, mid, n);
        oddEvenMergeDec(oddHalf);
        oddEvenMergeDec(evenHalf);
        for (int i = 0; i < mid; i++) {
            if (array[i].compareTo(array[(i + mid)]) < 0) {
                swap(array, i, mid);
            }
        }
        mergingDec(array, oddHalf, evenHalf);
    }

    /**
     * {@code oddEvenMergeInc} takes an array of {@link java.lang.Comparable Comparable} objects,
     * along with the indices {@code left} and {@code right} indicating the range of elements to be sorted.
     * The Odd-even Merge Sort algorithm.
     * This algorithm is a parallel sorting algorithm that works by dividing the array into two halves, sorting them recursively,
     * and then merging them back together.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The variable {@code n} is initialized with the value of {@code right},
     *     representing the number of elements to be sorted in the current recursion.
     *     If {@code n} is less than or equal to <i>1</i>,
     *     the method returns, as there is no need to sort an array with <i>0</i> or <i>1</i> element.</li>
     *     <li>The variable {@code mid} is set to {@code (n / 2)}, representing the midpoint of the current range.</li>
     *     <li>Two new arrays, {@code oddHalf} and {@code evenHalf}, are created using {@link java.util.Arrays#copyOfRange(Object[], int, int) Arrays.copyOfRange}.
     *     {@code oddHalf} contains the elements from index <i>0</i> to {@code (mid - 1)} of the original array,
     *     and {@code evenHalf} contains the elements from index {@code mid} to {@code (n - 1)}.</li>
     *     <li>The {@code oddEvenMergeInc} method is recursively called on both {@code oddHalf} and {@code evenHalf} to sort them.</li>
     *     <li>A loop iterates from {@code left} to {@code (mid - 1)}.
     *     For iteration, it compares the element at index {@code i} with the element at index {@code (i + mid)} in the original array.
     *     If the element at index {@code i} is greater than the element at index {@code (i + mid)},
     *     a {@code swap} method is called to swap the two elements.</li>
     * </ul>
     * Finally, the {@code mergingInc} method is called with the original array, {@code oddHalf},
     * and {@code evenHalf} as arguments to merge the two sorted halves back into the original array.
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       right specific range of the array.
     * @see         mz.OddEvenMerge#oddEvenInc(Comparable[])
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     * @see         mz.MergeInterface#mergingInc(Comparable[], Comparable[], Comparable[])
     */
    @SuppressWarnings("unchecked")
    protected void oddEvenMergeInc(Comparable[] array, int left, int right) {
        if (right <= 1) {
            return;
        }
        int mid = (right / 2);
        Comparable[] oddHalf = Arrays.copyOfRange(array, 0, mid);
        Comparable[] evenHalf = Arrays.copyOfRange(array, mid, right);
        oddEvenMergeInc(oddHalf);
        oddEvenMergeInc(evenHalf);
        for (int i = left; i < mid; i++) {
            if (array[i].compareTo(array[(i + mid)]) > 0) {
                swap(array, i, mid);
            }
        }
        mergingInc(array, oddHalf, evenHalf);
    }

    /**
     * {@code oddEvenMergeDec} takes an array of {@link java.lang.Comparable Comparable} objects,
     * along with the indices {@code left} and {@code right} indicating the range of elements to be sorted.
     * The Odd-even Merge Sort algorithm.
     * This algorithm is a parallel sorting algorithm that works by dividing the array into two halves, sorting them recursively,
     * and then merging them back together.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The variable {@code n} is initialized with the value of {@code right},
     *     representing the number of elements to be sorted in the current recursion.
     *     If {@code n} is less than or equal to <i>1</i>,
     *     the method returns, as there is no need to sort an array with <i>0</i> or <i>1</i> element.</li>
     *     <li>The variable {@code mid} is set to {@code (n / 2)}, representing the midpoint of the current range.</li>
     *     <li>Two new arrays, {@code oddHalf} and {@code evenHalf}, are created using {@link java.util.Arrays#copyOfRange(Object[], int, int) Arrays.copyOfRange}.
     *     {@code oddHalf} contains the elements from index <i>0</i> to {@code (mid - 1)} of the original array,
     *     and {@code evenHalf} contains the elements from index {@code mid} to {@code (n - 1)}.</li>
     *     <li>The {@code oddEvenMergeDec} method is recursively called on both {@code oddHalf} and {@code evenHalf} to sort them.</li>
     *     <li>A loop iterates from {@code left} to {@code (mid - 1)}.
     *     For iteration, it compares the element at index {@code i} with the element at index {@code (i + mid)} in the original array.
     *     If the element at index {@code i} is smaller than the element at index {@code (i + mid)},
     *     a {@code swap} method is called to swap the two elements.</li>
     * </ul>
     * Finally, the {@code mergingDec} method is called with the original array, {@code oddHalf},
     * and {@code evenHalf} as arguments to merge the two sorted halves back into the original array.
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       right specific range of the array.
     * @see         mz.OddEvenMerge#oddEvenDec(Comparable[])
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     * @see         mz.MergeInterface#mergingDec(Comparable[], Comparable[], Comparable[])
     */
    @SuppressWarnings("unchecked")
    protected void oddEvenMergeDec(Comparable[] array, int left, int right) {
        if (right <= 1) {
            return;
        }
        int mid = (right / 2);
        Comparable[] oddHalf = Arrays.copyOfRange(array, 0, mid);
        Comparable[] evenHalf = Arrays.copyOfRange(array, mid, right);
        oddEvenMergeDec(oddHalf);
        oddEvenMergeDec(evenHalf);
        for (int i = left; i < mid; i++) {
            if (array[i].compareTo(array[(i + mid)]) < 0) {
                swap(array, i, mid);
            }
        }
        mergingDec(array, oddHalf, evenHalf);
    }
}