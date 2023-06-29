package mz;

/**
 * Batcher's Odd-even Merge Sort is a parallel sorting algorithm that combines the odd-even transposition sort and
 * the batcher's merge algorithm to achieve efficient sorting.
 * It is designed to take advantage of parallel processing capabilities in order to speed up the sorting process.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class BatcherOddEvenMerge
extends OddEvenMerge {

    /**
     * <b>Batcher's Odd-even Merge Sort:</b><br>
     * <b>Example:</b>
     * Is a parallel sorting algorithm that combines the odd-even transposition sort and
     * the batcher's merge algorithm to achieve efficient sorting.
     * It is designed to take advantage of parallel processing capabilities in order to speed up the sorting process.<br>
     * <ol>
     *     <li>Divide the array: The algorithm begins by dividing the input array into smaller subarrays.
     *     Each subarray is assigned to a processing element or a thread for parallel processing.</li>
     *     <li>Odd-even transposition sort: Within each processing element, the subarray is sorted using the odd-even transposition sort algorithm.
     *     This algorithm compares and swaps adjacent elements in pairs,
     *     iteratively performing odd-even comparisons and transpositions until the subarray is sorted locally.</li>
     *     <li>Odd-even merge: After the odd-even transposition sort phase, the sorted subarrays need to be merged to obtain the globally sorted array.
     *     This is done using the batcher's merge algorithm, which merges pairs of adjacent subarrays in a parallel manner.</li>
     *     <li>Recursive merge: The merging step is performed recursively until all subarrays are merged into a single sorted array.
     *     This process involves repeatedly merging adjacent pairs of subarrays until the final sorted array is obtained.</li>
     * </ol>
     * <b>Note:</b><br>
     * The Odd-even Merge Sort algorithm leverages parallelism by sorting and merging subarrays concurrently.
     * This parallelism can be achieved using multiple processing elements, threads, or parallel computing techniques.<br><br>
     * Batcher's odd-even merge sort has a complexity of <em>O(n log^2(n))</em>, where n is the number of elements in the input array.
     * It offers better scalability and potential speedup compared to traditional sorting algorithms
     * like quicksort or mergesort when executed on parallel computing architectures.<br><br>
     * It's worth noting that the efficiency and performance of Batcher's Odd-even Merge Sort
     * depend on factors such as the underlying parallel processing capabilities,
     * the size of the input array, and the specific implementation details of the algorithm and its supporting operations.<br><br>
     * Stability: Batcher's Odd-even Merge Sort is a stable sorting algorithm.
     * This means that it preserves the relative order of elements with equal values during the sorting process.
     * If there are multiple elements with the same value,
     * the algorithm ensures that their original order is maintained in the sorted output.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n log^2(n))</em><br>
     * Best Case Complexity:    <em>O(n log^2(n))</em><br>
     * Average Case Complexity: <em>O(n log^2(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>Yes</b>
     * @see         mz.intro.IntroBatcherOddEvenMerge#IntroBatcherOddEvenMerge() IntroBatcherOddEvenMerge
     */
    public BatcherOddEvenMerge() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        batcherOddEvenMergeInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        batcherOddEvenMergeDec(array);
    }

    /**
     * {@code batcherOddEvenMergeInc} that implements the odd-even merge sort algorithm using the batcher's merge algorithm.
     * <ul>
     *     <li>It takes an array of {@link java.lang.Comparable Comparable} objects as input.</li>
     *     <li>It determines the length {@code n} of the array.</li>
     *     <li>If the length {@code n} is less than or equal to <i>1</i>, it means the array is already sorted or empty,
     *     so it returns and the method execution terminates.</li>
     *     <li>Otherwise, it calls the overloaded {@code batcherOddEvenMergeInc} method
     *     with {@code left} equal to <i>0</i> and {@code right} equal to {@code n}.
     *     This initiates the sorting process on the entire array.</li>
     * </ul>
     * By calling the overloaded method with {@code left} as <i>0</i> and {@code right} as the length of the array,
     * the entire array is considered as the subarray to be sorted.
     * The method then proceeds to sort the entire array using the odd-even merge sort algorithm.
     * @param       array to be arranged.
     * @see         mz.BatcherOddEvenMerge#batcherOddEvenMergeInc(Comparable[], int, int)
     */
    protected void batcherOddEvenMergeInc(Comparable[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        batcherOddEvenMergeInc(array, 0, n);
    }

    /**
     * {@code batcherOddEvenMergeDec} that implements the odd-even merge sort algorithm using the batcher's merge algorithm.
     * <ul>
     *     <li>It takes an array of {@link java.lang.Comparable Comparable} objects as input.</li>
     *     <li>It determines the length {@code n} of the array.</li>
     *     <li>If the length {@code n} is more than or equal to <i>1</i>, it means the array is already sorted or empty,
     *     so it returns and the method execution terminates.</li>
     *     <li>Otherwise, it calls the overloaded {@code batcherOddEvenMergeDec} method
     *     with {@code left} equal to <i>0</i> and {@code right} equal to {@code n}.
     *     This initiates the sorting process on the entire array.</li>
     * </ul>
     * By calling the overloaded method with {@code left} as <i>0</i> and {@code right} as the length of the array,
     * the entire array is considered as the subarray to be sorted.
     * The method then proceeds to sort the entire array using the odd-even merge sort algorithm.
     * @param       array to be arranged.
     * @see         mz.BatcherOddEvenMerge#batcherOddEvenMergeDec(Comparable[], int, int)
     */
    protected void batcherOddEvenMergeDec(Comparable[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        batcherOddEvenMergeDec(array, 0, n);
    }

    /**
     * {@code batcherOddEvenMergeInc} that implements the odd-even merge sort algorithm using the batcher's merge algorithm.
     * <ul>
     *     <li>It takes an array of {@link java.lang.Comparable Comparable} objects,
     *     and the indices {@code left} and {@code right} that define the range of the subarray to be sorted.</li>
     *     <li>It calculates the size {@code n} of the subarray.</li>
     *     <li>If the size {@code n} is less than or equal to <i>1</i>, it means the subarray is already sorted or empty,
     *     so it returns and the method execution terminates.</li>
     *     <li>It calculates the {@code mid} index by adding {@code left} and half of the size {@code n}.</li>
     *     <li>It recursively calls {@code batcherOddEvenMergeInc} twice, dividing the subarray into two halves:
     *     from {@code left} to {@code mid}, and from {@code mid} to {@code right}.
     *     This step recursively sorts each half of the subarray.</li>
     *     <li>Finally, it calls the {@code batcherMergingInc} method to merge the two sorted halves together to obtain the final sorted subarray.</li>
     * </ul>
     * The {@code batcherOddEvenMergeInc} method essentially follows a divide-and-conquer approach.
     * It divides the subarray into smaller subarrays, recursively sorts them using the same method,
     * and then merges them together using the {@code batcherMergingInc} method.
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       right specific range of the array.
     * @see         mz.BatcherOddEvenMerge#batcherMergingInc(Comparable[], int, int, int)
     */
    protected void batcherOddEvenMergeInc(Comparable[] array, int left, int right) {
        int n = (right - left);
        if (n <= 1) {
            return;
        }
        int mid = (left + (n / 2));
        batcherOddEvenMergeInc(array, left, mid);
        batcherOddEvenMergeInc(array, mid, right);
        batcherMergingInc(array, left, mid, right);
    }

    /**
     * {@code batcherOddEvenMergeDec} that implements the odd-even merge sort algorithm using the batcher's merge algorithm.
     * <ul>
     *     <li>It takes an array of {@link java.lang.Comparable Comparable} objects,
     *     and the indices {@code left} and {@code right} that define the range of the subarray to be sorted.</li>
     *     <li>It calculates the size {@code n} of the subarray.</li>
     *     <li>If the size {@code n} is more than or equal to <i>1</i>, it means the subarray is already sorted or empty,
     *     so it returns and the method execution terminates.</li>
     *     <li>It calculates the {@code mid} index by adding {@code left} and half of the size {@code n}.</li>
     *     <li>It recursively calls {@code batcherOddEvenMergeDec} twice, dividing the subarray into two halves:
     *     from {@code left} to {@code mid}, and from {@code mid} to {@code right}.
     *     This step recursively sorts each half of the subarray.</li>
     *     <li>Finally, it calls the {@code batcherMergingDec} method to merge the two sorted halves together to obtain the final sorted subarray.</li>
     * </ul>
     * The {@code batcherOddEvenMergeDec} method essentially follows a divide-and-conquer approach.
     * It divides the subarray into smaller subarrays, recursively sorts them using the same method,
     * and then merges them together using the {@code batcherMergingDec} method.
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       right specific range of the array.
     * @see         mz.BatcherOddEvenMerge#batcherMergingDec(Comparable[], int, int, int)
     */
    protected void batcherOddEvenMergeDec(Comparable[] array, int left, int right) {
        int n = (right - left);
        if (n <= 1) {
            return;
        }
        int mid = (left + (n / 2));
        batcherOddEvenMergeDec(array, left, mid);
        batcherOddEvenMergeDec(array, mid, right);
        batcherMergingDec(array, left, mid, right);
    }

    /**
     * {@code batcherMergingInc} that performs merging and sorting operations on a subarray of a given
     * {@code array} using the batcher's merge algorithm.
     * <ul>
     *     <li>It takes an array of {@link java.lang.Comparable Comparable} objects,
     *     the indices {@code left}, {@code mid}, and {@code right} that define the range of the subarray to be merged.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>It calculates the size {@code n} of the subarray.</li>
     *     <li>It creates a new array called {@code merged} with a length of {@code n} to store the merged elements.</li>
     *     <li>It initializes three pointers:
     *     {@code i} pointing to the start of the left subarray,
     *     {@code j} pointing to the start of the right subarray, and
     *     {@code k} pointing to the start of the merged array.</li>
     *     <li>It compares the elements at indices {@code i} and {@code j} in the original array and copies the smaller element into the merged array.
     *     It increments the respective pointers ({@code i} or {@code j}) and the {@code k} pointer.</li>
     *     <li>It continues the merging process until either the {@code i} pointer reaches the end of the left subarray or
     *     the {@code j} pointer reaches the end of the right subarray.</li>
     *     <li>It copies any remaining elements from the left subarray,
     *     if there are any, into the {@code merged} array.</li>
     *     <li>It copies any remaining elements from the right subarray,
     *     if there are any, into the {@code merged} array.</li>
     *     <li>It copies the sorted elements from the {@code merged} array back into the original array at the correct positions.</li>
     *     <li>It performs a final pass to ensure that adjacent pairs of elements are in sorted order.
     *     It compares elements at even indices with their adjacent odd indices ({@code m} and {@code (m + 1)}),
     *     and if they are out of order, it {@code swaps} them using the swap method</li>
     * </ul>
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       mid the middle value of the specified range of the array.
     * @param       right specific range of the array.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void batcherMergingInc(Comparable[] array, int left, int mid, int right) {
        int n = (right - left), i = left, j = mid, k = 0;
        Comparable[] merged = new Comparable[n];
        while (i < mid && j < right) {
            if (array[j].compareTo(array[i]) >= 0) {
                merged[k++] = array[i++];
            } else {
                merged[k++] = array[j++];
            }
        }
        while (i < mid) {
            merged[k++] = array[i++];
        }
        while (j < right) {
            merged[k++] = array[j++];
        }
        for (int m = 0; m < n; m++) {
            array[(left + m)] = merged[m];
        }
        for (int m = (left + 1); m < (right - 1); m += 2) {
            if (array[m].compareTo(array[(m + 1)]) > 0) {
                swap(array, m, (m + 1));
            }
        }
    }

    /**
     * {@code batcherMergingDec} that performs merging and sorting operations on a subarray of a given
     * {@code array} using the batcher's merge algorithm.
     * <ul>
     *     <li>It takes an array of {@link java.lang.Comparable Comparable} objects,
     *     the indices {@code left}, {@code mid}, and {@code right} that define the range of the subarray to be merged.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>It calculates the size {@code n} of the subarray.</li>
     *     <li>It creates a new array called {@code merged} with a length of {@code n} to store the merged elements.</li>
     *     <li>It initializes three pointers:
     *     {@code i} pointing to the start of the left subarray,
     *     {@code j} pointing to the start of the right subarray, and
     *     {@code k} pointing to the start of the merged array.</li>
     *     <li>It compares the elements at indices {@code i} and {@code j} in the original array and copies the greater element into the merged array.
     *     It decrements the respective pointers ({@code i} or {@code j}) and the {@code k} pointer.</li>
     *     <li>It continues the merging process until either the {@code i} pointer reaches the end of the left subarray or
     *     the {@code j} pointer reaches the end of the right subarray.</li>
     *     <li>It copies any remaining elements from the left subarray,
     *     if there are any, into the {@code merged} array.</li>
     *     <li>It copies any remaining elements from the right subarray,
     *     if there are any, into the {@code merged} array.</li>
     *     <li>It copies the sorted elements from the {@code merged} array back into the original array at the correct positions.</li>
     *     <li>It performs a final pass to ensure that adjacent pairs of elements are in sorted order.
     *     It compares elements at even indices with their adjacent odd indices ({@code m} and {@code (m + 1)}),
     *     and if they are out of order, it {@code swaps} them using the swap method</li>
     * </ul>
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       mid the middle value of the specified range of the array.
     * @param       right specific range of the array.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void batcherMergingDec(Comparable[] array, int left, int mid, int right) {
        int n = (right - left), i = left, j = mid, k = 0;
        Comparable[] merged = new Comparable[n];
        while (i < mid && j < right) {
            if (array[j].compareTo(array[i]) <= 0) {
                merged[k++] = array[i++];
            } else {
                merged[k++] = array[j++];
            }
        }
        while (i < mid) {
            merged[k++] = array[i++];
        }
        while (j < right) {
            merged[k++] = array[j++];
        }
        for (int m = 0; m < n; m++) {
            array[(left + m)] = merged[m];
        }
        for (int m = (left + 1); m < (right - 1); m += 2) {
            if (array[m].compareTo(array[(m + 1)]) < 0) {
                swap(array, m, (m + 1));
            }
        }
    }
}