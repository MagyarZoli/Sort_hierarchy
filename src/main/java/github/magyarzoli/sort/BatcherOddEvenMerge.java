package github.magyarzoli.sort;

import github.magyarzoli.Sort;
import github.magyarzoli.SortFunctional;
import github.magyarzoli.SortSwap;

import java.util.ArrayList;
import java.util.List;

/**
 * Batcher's Odd-even Merge Sort is a parallel sorting algorithm that combines the odd-even transposition sort and
 * the batcher's merge algorithm to achieve efficient sorting.
 * It is designed to take advantage of parallel processing capabilities in order to speed up the sorting process.
 * @since       1.3
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
     * It is designed to take advantage of parallel processing capabilities in order to speed up the sorting
     * process.<br>
     * <ol>
     *     <li>Divide the array: The algorithm begins by dividing the input array into smaller subarrays.
     *     Each subarray is assigned to a processing element or a thread for parallel processing.</li>
     *     <li>Odd-even transposition sort: Within each processing element, the subarray is sorted using the odd-even
     *     transposition sort algorithm.
     *     This algorithm compares and swaps adjacent elements in pairs,
     *     iteratively performing odd-even comparisons and transpositions until the subarray is sorted locally.</li>
     *     <li>Odd-even merge: After the odd-even transposition sort phase, the sorted subarrays need to be merged to
     *     obtain the globally sorted array.
     *     This is done using the batcher's merge algorithm, which merges pairs of adjacent subarrays in a parallel
     *     manner.</li>
     *     <li>Recursive merge: The merging step is performed recursively until all subarrays are merged into a single
     *     sorted array.
     *     This process involves repeatedly merging adjacent pairs of subarrays until the final sorted array is
     *     obtained.</li>
     * </ol>
     * <b>Note:</b><br>
     * The Odd-even Merge Sort algorithm leverages parallelism by sorting and merging subarrays concurrently.
     * This parallelism can be achieved using multiple processing elements, threads, or parallel computing
     * techniques.<br><br>
     * Batcher's odd-even merge sort has a complexity of <em>O(n log^2(n))</em>, where n is the number of elements in
     * the input array.
     * It offers better scalability and potential speedup compared to traditional sorting algorithms
     * like quicksort or mergesort when executed on parallel computing architectures.<br><br>
     * It's worth noting that the efficiency and performance of Batcher's Odd-even Merge Sort
     * depend on factors such as the underlying parallel processing capabilities,
     * the size of the input array, and the specific implementation details of the algorithm and its supporting
     * operations.<br><br>
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
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        batcherOddEvenMerge(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        batcherOddEvenMergeInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        batcherOddEvenMergeDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        batcherOddEvenMerge(list, functional);
    }

    /**
     * {@code batcherOddEvenMergeInc} that implements the odd-even merge sort algorithm using the batcher's merge
     * algorithm.
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
     * @see         BatcherOddEvenMerge#batcherOddEvenMergeInc(Comparable[], int, int)
     */
    protected void batcherOddEvenMergeInc(Comparable[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        batcherOddEvenMergeInc(array, 0, n);
    }

    /**
     * {@code batcherOddEvenMergeDec} that implements the odd-even merge sort algorithm using the batcher's merge
     * algorithm.
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
     * @see         BatcherOddEvenMerge#batcherOddEvenMergeDec(Comparable[], int, int)
     */
    protected void batcherOddEvenMergeDec(Comparable[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        batcherOddEvenMergeDec(array, 0, n);
    }

    /**
     * {@code batcherOddEvenMerge} that implements the odd-even merge sort algorithm using the batcher's merge
     * algorithm.
     * <ul>
     *     <li>The {@code batcherOddEvenMerge} method takes an array {@code array} of type {@link java.lang.Comparable
     *     Comparable}
     *     and an instance of {@code SortFunctional<Comparable>} as parameters.</li>
     *     <li>It starts by assigning the length of the array {@code array.length} to the variable {@code n}.</li>
     *     <li>If the length {@code n} of the array is less than or equal to <i>1</i>,
     *     which means the array has <i>0</i> or <i>1</i> element,
     *     the method returns early, as there is no need for further sorting.</li>
     *     <li>If the length {@code n} of the array is greater than <i>1</i>,
     *     the method calls another overloaded version of the {@code batcherOddEvenMerge} method,
     *     passing the {@code array}, the starting index <i>0</i>, the length {@code n},
     *     and the {@code functional} instance as parameters.</li>
     * </ul>
     * {@code batcherOddEvenMerge} this method is to initiate the batcher odd-even merge sorting algorithm.
     * It checks if the array has more than one element and then proceeds to call the main sorting method, passing the
     * necessary parameters.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         BatcherOddEvenMerge#batcherOddEvenMerge(Comparable[], int, int, SortFunctional)
     */
    protected void batcherOddEvenMerge(Comparable[] array, SortFunctional<Comparable> functional) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        batcherOddEvenMerge(array, 0, n, functional);
    }

    /**
     * {@code batcherOddEvenMergeInc} that implements the odd-even merge sort algorithm using the batcher's merge
     * algorithm.
     * <ul>
     *     <li>It takes an array of {@link java.lang.Comparable Comparable} objects,
     *     and the indices {@code left} and {@code right} that define the range of the subarray to be sorted.</li>
     *     <li>It calculates the size {@code n} of the subarray.</li>
     *     <li>If the size {@code n} is less than or equal to <i>1</i>, it means the subarray is already sorted or
     *     empty, so it returns and the method execution terminates.</li>
     *     <li>It calculates the {@code mid} index by adding {@code left} and half of the size {@code n}.</li>
     *     <li>It recursively calls {@code batcherOddEvenMergeInc} twice, dividing the subarray into two halves:
     *     from {@code left} to {@code mid}, and from {@code mid} to {@code right}.
     *     This step recursively sorts each half of the subarray.</li>
     *     <li>Finally, it calls the {@code batcherMergingInc} method to merge the two sorted halves together to obtain
     *     the final sorted subarray.</li>
     * </ul>
     * The {@code batcherOddEvenMergeInc} method essentially follows a divide-and-conquer approach.
     * It divides the subarray into smaller subarrays, recursively sorts them using the same method,
     * and then merges them together using the {@code batcherMergingInc} method.
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       right specific range of the array.
     * @see         BatcherOddEvenMerge#batcherMergingInc(Comparable[], int, int, int)
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
     * {@code batcherOddEvenMergeDec} that implements the odd-even merge sort algorithm using the batcher's merge
     * algorithm.
     * <ul>
     *     <li>It takes an array of {@link java.lang.Comparable Comparable} objects,
     *     and the indices {@code left} and {@code right} that define the range of the subarray to be sorted.</li>
     *     <li>It calculates the size {@code n} of the subarray.</li>
     *     <li>If the size {@code n} is more than or equal to <i>1</i>, it means the subarray is already sorted or
     *     empty, so it returns and the method execution terminates.</li>
     *     <li>It calculates the {@code mid} index by adding {@code left} and half of the size {@code n}.</li>
     *     <li>It recursively calls {@code batcherOddEvenMergeDec} twice, dividing the subarray into two halves:
     *     from {@code left} to {@code mid}, and from {@code mid} to {@code right}.
     *     This step recursively sorts each half of the subarray.</li>
     *     <li>Finally, it calls the {@code batcherMergingDec} method to merge the two sorted halves together to obtain
     *     the final sorted subarray.</li>
     * </ul>
     * The {@code batcherOddEvenMergeDec} method essentially follows a divide-and-conquer approach.
     * It divides the subarray into smaller subarrays, recursively sorts them using the same method,
     * and then merges them together using the {@code batcherMergingDec} method.
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       right specific range of the array.
     * @see         BatcherOddEvenMerge#batcherMergingDec(Comparable[], int, int, int)
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
     * {@code batcherOddEvenMerge} method.
     * This method performs the odd-even merge operation in the Batchers' odd-even merge sort algorithm.
     * <ul>
     *     <li>The method takes an array array of type {@link java.lang.Comparable Comparable[]},
     *     an integer {@code left} representing the left index, an integer {@code right} representing the right index,
     *     and an instance of the {@code SortFunctional<Comparable>} interface as parameters.</li>
     *     <li>It calculates the size of the range by subtracting the {@code left} index from the {@code right} index
     *     {@code n = (right - left)}.</li>
     *     <li>If the size of the range is less than or equal to <i>1</i> (indicating that the range is already sorted
     *     or empty),
     *     the method returns without performing any further operations.</li>
     *     <li>If the size of the range is greater than <i>1</i>, the method proceeds with the odd-even merge
     *     operation.</li>
     *     <li>It calculates the middle index of the range by adding
     *     the {@code left} index to half of the size {@code mid = (left + (n / 2))}.</li>
     *     <li>The method recursively calls itself to perform the odd-even merge operation on the left sub-range,
     *     from {@code left} to {@code mid}.</li>
     *     <li>The method recursively calls itself to perform the odd-even merge operation on the right sub-range,
     *     from {@code mid} to {@code right}.</li>
     *     <li>Finally, the method calls the {@code batcherMerging} method to merge the two sub-ranges together in an
     *     odd-even manner.</li>
     * </ul>
     * The {@code batcherOddEvenMerge} method essentially follows a divide-and-conquer approach.
     * It divides the subarray into smaller subarrays, recursively sorts them using the same method,
     * and then merges them together using the {@code batcherMerging} method.
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       right specific range of the array.
     * @param       functional lambda expression for comparison.
     * @see         BatcherOddEvenMerge#batcherMerging(Comparable[], int, int, int, SortFunctional)
     */
    protected void batcherOddEvenMerge(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        int n = (right - left);
        if (n <= 1) {
            return;
        }
        int mid = (left + (n / 2));
        batcherOddEvenMerge(array, left, mid, functional);
        batcherOddEvenMerge(array, mid, right, functional);
        batcherMerging(array, left, mid, right, functional);
    }

    /**
     * {@code batcherMergingInc} that performs merging and sorting operations on a subarray of a given
     * {@code array} using the batcher's merge algorithm.
     * <ul>
     *     <li>It takes an array of {@link java.lang.Comparable Comparable} objects,
     *     the indices {@code left}, {@code mid}, and {@code right} that define the range of the subarray to be
     *     merged.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object)
     *     compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle
     *     warnings.</li>
     *     <li>It calculates the size {@code n} of the subarray.</li>
     *     <li>It creates a new array called {@code merged} with a length of {@code n} to store the merged
     *     elements.</li>
     *     <li>It initializes three pointers:
     *     {@code i} pointing to the start of the left subarray,
     *     {@code j} pointing to the start of the right subarray, and
     *     {@code k} pointing to the start of the merged array.</li>
     *     <li>It compares the elements at indices {@code i} and {@code j} in the original array and copies the smaller
     *     element into the merged array.
     *     It increments the respective pointers ({@code i} or {@code j}) and the {@code k} pointer.</li>
     *     <li>It continues the merging process until either the {@code i} pointer reaches the end of the left
     *     subarray or
     *     the {@code j} pointer reaches the end of the right subarray.</li>
     *     <li>It copies any remaining elements from the left subarray,
     *     if there are any, into the {@code merged} array.</li>
     *     <li>It copies any remaining elements from the right subarray,
     *     if there are any, into the {@code merged} array.</li>
     *     <li>It copies the sorted elements from the {@code merged} array back into the original array at the correct
     *     positions.</li>
     *     <li>It performs a final pass to ensure that adjacent pairs of elements are in sorted order.
     *     It compares elements at even indices with their adjacent odd indices ({@code m} and {@code (m + 1)}),
     *     and if they are out of order, it {@code swaps} them using the swap method</li>
     * </ul>
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       mid the middle value of the specified range of the array.
     * @param       right specific range of the array.
     * @see         SortSwap#swap(Comparable[], int, int)
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
     *     the indices {@code left}, {@code mid}, and {@code right} that define the range of the subarray to be
     *     merged.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object)
     *     compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle
     *     warnings.</li>
     *     <li>It calculates the size {@code n} of the subarray.</li>
     *     <li>It creates a new array called {@code merged} with a length of {@code n} to store the merged
     *     elements.</li>
     *     <li>It initializes three pointers:
     *     {@code i} pointing to the start of the left subarray,
     *     {@code j} pointing to the start of the right subarray, and
     *     {@code k} pointing to the start of the merged array.</li>
     *     <li>It compares the elements at indices {@code i} and {@code j} in the original array and copies the greater
     *     element into the merged array.
     *     It decrements the respective pointers ({@code i} or {@code j}) and the {@code k} pointer.</li>
     *     <li>It continues the merging process until either the {@code i} pointer reaches the end of the left
     *     subarray or
     *     the {@code j} pointer reaches the end of the right subarray.</li>
     *     <li>It copies any remaining elements from the left subarray,
     *     if there are any, into the {@code merged} array.</li>
     *     <li>It copies any remaining elements from the right subarray,
     *     if there are any, into the {@code merged} array.</li>
     *     <li>It copies the sorted elements from the {@code merged} array back into the original array at the correct
     *     positions.</li>
     *     <li>It performs a final pass to ensure that adjacent pairs of elements are in sorted order.
     *     It compares elements at even indices with their adjacent odd indices ({@code m} and {@code (m + 1)}),
     *     and if they are out of order, it {@code swaps} them using the swap method</li>
     * </ul>
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       mid the middle value of the specified range of the array.
     * @param       right specific range of the array.
     * @see         SortSwap#swap(Comparable[], int, int)
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

    /**
     * {@code batcherMerging} method takes an array {@code array} of type {@link java.lang.Comparable Comparable},
     * three integer parameters {@code left}, {@code mid}, and {@code right},
     * and an instance of {@code SortFunctional<Comparable>} as parameters.
     * <ul>
     *     <li>It starts by calculating the length {@code n} of the subarray to be merged, which is
     *     {@code (right - left)}.</li>
     *     <li>It initializes three variables {@code i}, {@code j}, and {@code k} with the values of {@code left},
     *     {@code mid}, and <i>0</i> respectively.
     *     These variables will be used as indices for merging and populating the merged array.</li>
     *     <li>It creates a new array {@code merged} of type {@code Comparable} with a length {@code n} to store the
     *     merged elements.</li>
     *     <li>It creates a new instance of {@code SortFunctional<Comparable>} called {@code functionalAddEquals}
     *     by calling the {@code functionalComparableToAddEquals} method, passing the {@code functional} instance as a
     *     parameter.</li>
     *     <li>The method enters a {@code while} loop that continues as long as {@code i} is less than {@code mid} and
     *     {@code j} is less than {@code right}.
     *     This loop performs the merging of elements from the two halves of the subarray based on
     *     the comparison logic defined by the {@code functionalAddEquals} instance.</li>
     *     <li>If the comparison between {@code array[j]} and {@code array[i]} using the {@code functionalAddEquals}
     *     instance returns {@code true},
     *     indicating that {@code array[j]} is greater or equal to {@code array[i]},
     *     the element {@code array[i]} is added to the {@code merged} array, and {@code i} and {@code k} are
     *     incremented.</li>
     *     <li>If the comparison returns {@code false},
     *     indicating that {@code array[i]} is greater than {@code array[j]},
     *     the element {@code array[j]} is added to the {@code merged} array, and {@code j} and {@code k} are
     *     incremented.</li>
     *     <li>After the first {@code while} loop, there may be remaining elements in either the left or
     *     right subarray.
     *     Two additional {@code while} loops handle the remaining elements:</li>
     *     <li>The first {@code while} loop runs while {@code i} is less than {@code mid},
     *     indicating that there are still elements in the left subarray.
     *     It adds these remaining elements to the {@code merged} array and increments {@code i} and {@code k}.</li>
     *     <li>The second {@code while} loop runs while {@code j} is less than {@code right},
     *     indicating that there are still elements in the {@code right} subarray.
     *     It adds these remaining elements to the {@code merged} array and increments {@code j} and {@code k}.</li>
     *     <li>Once all elements are merged and stored in the {@code merged} array,
     *     the method updates the corresponding elements in the original {@code array} from indices {@code (left + m)}
     *     with the values of {@code merged[m]} using a {@code for} loop.</li>
     *     <li>The last {@code for} loop iterates through the odd indices from {@code (left + 1)} to {@code (right - 1)}
     *     and checks if adjacent elements need to be swapped based on the comparison logic defined by the
     *     {@code functional} instance.
     *     If the comparison returns {@code true}, the {@code swap} method</li>
     * </ul>
     * {@code batcherMerging} method performs the merging step of the Batcher's odd-even merge sorting algorithm.
     * It merges two sorted halves of a subarray and updates the original array accordingly.
     * It uses the {@code functionalAddEquals} instance to compare elements and the {@code functional} instance
     * to check for swaps during the final step of the merging process.
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       mid the middle value of the specified range of the array.
     * @param       right specific range of the array.
     * @param       functional lambda expression for comparison.
     * @see         Sort#functionalComparableToAddEquals(SortFunctional)
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    protected void batcherMerging(
            Comparable[] array, int left, int mid, int right, SortFunctional<Comparable> functional) {
        int n = (right - left), i = left, j = mid, k = 0;
        Comparable[] merged = new Comparable[n];
        SortFunctional<Comparable> functionalAddEquals = functionalComparableToAddEquals(functional);
        while (i < mid && j < right) {
            if (functionalAddEquals.functionalCompareTo(array[j], array[i])) {
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
            if (functional.functionalCompareTo(array[m], array[(m + 1)])) {
                swap(array, m, (m + 1));
            }
        }
    }

    /**
     * {@code batcherOddEvenMergeInc} that implements the odd-even merge sort algorithm using the batcher's merge
     * algorithm.
     * <ul>
     *     <li>It takes an list of {@link java.lang.Comparable Comparable} objects as input.</li>
     *     <li>It determines the length {@code n} of the list.</li>
     *     <li>If the length {@code n} is less than or equal to <i>1</i>, it means the list is already sorted or empty,
     *     so it returns and the method execution terminates.</li>
     *     <li>Otherwise, it calls the overloaded {@code batcherOddEvenMergeInc} method
     *     with {@code left} equal to <i>0</i> and {@code right} equal to {@code n}.
     *     This initiates the sorting process on the entire list.</li>
     * </ul>
     * By calling the overloaded method with {@code left} as <i>0</i> and {@code right} as the length of the list,
     * the entire list is considered as the sublist to be sorted.
     * The method then proceeds to sort the entire list using the odd-even merge sort algorithm.
     * @param       list to be arranged.
     * @see         BatcherOddEvenMerge#batcherOddEvenMergeInc(List, int, int)
     */
    protected <L extends Comparable> void batcherOddEvenMergeInc(List<L> list) {
        int n = list.size();
        if (n <= 1) {
            return;
        }
        batcherOddEvenMergeInc(list, 0, n);
    }

    /**
     * {@code batcherOddEvenMergeDec} that implements the odd-even merge sort algorithm using the batcher's merge
     * algorithm.
     * <ul>
     *     <li>It takes an list of {@link java.lang.Comparable Comparable} objects as input.</li>
     *     <li>It determines the length {@code n} of the list.</li>
     *     <li>If the length {@code n} is more than or equal to <i>1</i>, it means the list is already sorted or empty,
     *     so it returns and the method execution terminates.</li>
     *     <li>Otherwise, it calls the overloaded {@code batcherOddEvenMergeDec} method
     *     with {@code left} equal to <i>0</i> and {@code right} equal to {@code n}.
     *     This initiates the sorting process on the entire list.</li>
     * </ul>
     * By calling the overloaded method with {@code left} as <i>0</i> and {@code right} as the length of the list,
     * the entire list is considered as the sublist to be sorted.
     * The method then proceeds to sort the entire list using the odd-even merge sort algorithm.
     * @param       list to be arranged.
     * @see         BatcherOddEvenMerge#batcherOddEvenMergeDec(List, int, int)
     */
    protected <L extends Comparable> void batcherOddEvenMergeDec(List<L> list) {
        int n = list.size();
        if (n <= 1) {
            return;
        }
        batcherOddEvenMergeDec(list, 0, n);
    }

    /**
     * {@code batcherOddEvenMerge} that implements the odd-even merge sort algorithm using the batcher's merge
     * algorithm.
     * <ul>
     *     <li>The {@code batcherOddEvenMerge} method takes an list {@code list} of type {@link java.lang.Comparable
     *     Comparable}
     *     and an instance of {@code SortFunctional<Comparable>} as parameters.</li>
     *     <li>It starts by assigning the length of the list {@code list.size()} to the variable {@code n}.</li>
     *     <li>If the length {@code n} of the list is less than or equal to <i>1</i>,
     *     which means the list has <i>0</i> or <i>1</i> element,
     *     the method returns early, as there is no need for further sorting.</li>
     *     <li>If the length {@code n} of the list is greater than <i>1</i>,
     *     the method calls another overloaded version of the {@code batcherOddEvenMerge} method,
     *     passing the {@code list}, the starting index <i>0</i>, the length {@code n},
     *     and the {@code functional} instance as parameters.</li>
     * </ul>
     * {@code batcherOddEvenMerge} this method is to initiate the batcher odd-even merge sorting algorithm.
     * It checks if the list has more than one element and then proceeds to call the main sorting method, passing the
     * necessary parameters.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         BatcherOddEvenMerge#batcherOddEvenMerge(List, int, int, SortFunctional)
     */
    protected <L extends Comparable> void batcherOddEvenMerge(List<L> list, SortFunctional<Comparable> functional) {
        int n = list.size();
        if (n <= 1) {
            return;
        }
        batcherOddEvenMerge(list, 0, n, functional);
    }

    /**
     * {@code batcherOddEvenMergeInc} that implements the odd-even merge sort algorithm using the batcher's merge
     * algorithm.
     * <ul>
     *     <li>It takes an list of {@link java.lang.Comparable Comparable} objects,
     *     and the indices {@code left} and {@code right} that define the range of the sublist to be sorted.</li>
     *     <li>It calculates the size {@code n} of the sublist.</li>
     *     <li>If the size {@code n} is less than or equal to <i>1</i>, it means the sublist is already sorted
     *     or empty,
     *     so it returns and the method execution terminates.</li>
     *     <li>It calculates the {@code mid} index by adding {@code left} and half of the size {@code n}.</li>
     *     <li>It recursively calls {@code batcherOddEvenMergeInc} twice, dividing the sublist into two halves:
     *     from {@code left} to {@code mid}, and from {@code mid} to {@code right}.
     *     This step recursively sorts each half of the subarray.</li>
     *     <li>Finally, it calls the {@code batcherMergingInc} method to merge the two sorted halves together to obtain
     *     the final sorted sublist.</li>
     * </ul>
     * The {@code batcherOddEvenMergeInc} method essentially follows a divide-and-conquer approach.
     * It divides the sublist into smaller sublists, recursively sorts them using the same method,
     * and then merges them together using the {@code batcherMergingInc} method.
     * @param       list to be arranged.
     * @param       left specific range of the list.
     * @param       right specific range of the list.
     * @see         BatcherOddEvenMerge#batcherMergingInc(List, int, int, int)
     */
    protected <L extends Comparable> void batcherOddEvenMergeInc(List<L> list, int left, int right) {
        int n = (right - left);
        if (n <= 1) {
            return;
        }
        int mid = (left + (n / 2));
        batcherOddEvenMergeInc(list, left, mid);
        batcherOddEvenMergeInc(list, mid, right);
        batcherMergingInc(list, left, mid, right);
    }

    /**
     * {@code batcherOddEvenMergeDec} that implements the odd-even merge sort algorithm using the batcher's merge
     * algorithm.
     * <ul>
     *     <li>It takes an list of {@link java.lang.Comparable Comparable} objects,
     *     and the indices {@code left} and {@code right} that define the range of the sublist to be sorted.</li>
     *     <li>It calculates the size {@code n} of the sublist.</li>
     *     <li>If the size {@code n} is more than or equal to <i>1</i>, it means the sublist is already sorted or empty,
     *     so it returns and the method execution terminates.</li>
     *     <li>It calculates the {@code mid} index by adding {@code left} and half of the size {@code n}.</li>
     *     <li>It recursively calls {@code batcherOddEvenMergeDec} twice, dividing the sublist into two halves:
     *     from {@code left} to {@code mid}, and from {@code mid} to {@code right}.
     *     This step recursively sorts each half of the subarray.</li>
     *     <li>Finally, it calls the {@code batcherMergingDec} method to merge the two sorted halves together to obtain
     *     the final sorted sublist.</li>
     * </ul>
     * The {@code batcherOddEvenMergeDec} method essentially follows a divide-and-conquer approach.
     * It divides the sublist into smaller sublist, recursively sorts them using the same method,
     * and then merges them together using the {@code batcherMergingDec} method.
     * @param       list to be arranged.
     * @param       left specific range of the list.
     * @param       right specific range of the list.
     * @see         BatcherOddEvenMerge#batcherMergingDec(List, int, int, int)
     */
    protected <L extends Comparable> void batcherOddEvenMergeDec(List<L> list, int left, int right) {
        int n = (right - left);
        if (n <= 1) {
            return;
        }
        int mid = (left + (n / 2));
        batcherOddEvenMergeDec(list, left, mid);
        batcherOddEvenMergeDec(list, mid, right);
        batcherMergingDec(list, left, mid, right);
    }

    /**
     * {@code batcherOddEvenMerge} method.
     * This method performs the odd-even merge operation in the Batchers' odd-even merge sort algorithm.
     * <ul>
     *     <li>The method takes an list list of type {@code Comparable[]},
     *     an integer {@code left} representing the left index, an integer {@code right} representing the right index,
     *     and an instance of the {@code SortFunctional<Comparable>} interface as parameters.</li>
     *     <li>It calculates the size of the range by subtracting the {@code left} index from the {@code right} index
     *     {@code n = (right - left)}.</li>
     *     <li>If the size of the range is less than or equal to <i>1</i> (indicating that the range is already sorted
     *     or empty),
     *     the method returns without performing any further operations.</li>
     *     <li>If the size of the range is greater than <i>1</i>, the method proceeds with the odd-even merge
     *     operation.</li>
     *     <li>It calculates the middle index of the range by adding
     *     the {@code left} index to half of the size {@code mid = (left + (n / 2))}.</li>
     *     <li>The method recursively calls itself to perform the odd-even merge operation on the left sub-range,
     *     from {@code left} to {@code mid}.</li>
     *     <li>The method recursively calls itself to perform the odd-even merge operation on the right sub-range,
     *     from {@code mid} to {@code right}.</li>
     *     <li>Finally, the method calls the {@code batcherMerging} method to merge the two sub-ranges together in an
     *     odd-even manner.</li>
     * </ul>
     * The {@code batcherOddEvenMerge} method essentially follows a divide-and-conquer approach.
     * It divides the sublist into smaller sublists, recursively sorts them using the same method,
     * and then merges them together using the {@code batcherMerging} method.
     * @param       list to be arranged.
     * @param       left specific range of the list.
     * @param       right specific range of the list.
     * @param       functional lambda expression for comparison.
     * @see         BatcherOddEvenMerge#batcherMerging(List, int, int, int, SortFunctional)
     */
    protected <L extends Comparable> void batcherOddEvenMerge(
            List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        int n = (right - left);
        if (n <= 1) {
            return;
        }
        int mid = (left + (n / 2));
        batcherOddEvenMerge(list, left, mid, functional);
        batcherOddEvenMerge(list, mid, right, functional);
        batcherMerging(list, left, mid, right, functional);
    }

    /**
     * {@code batcherMergingInc} that performs an incremental merging operation on a sublist of
     * the {@code list} between the indices {@code left} and {@code right}.
     * It is part of the Batcher's merge sort algorithm.
     * <ul>
     *     <li>It calculates the size of the sublist by subtracting {@code left} from {@code right}
     *     and assigns the result to the variable {@code n}.
     *     It also initializes variables {@code i} and {@code j} to {@code left} and {@code mid}, respectively,
     *     and {@code k} to <i>0</i>.</li>
     *     <li>It creates a new {@link java.util.ArrayList ArrayList} called {@code merged} to store the merged
     *     elements.</li>
     *     <li>It enters a while loop that continues as long as {@code i} is less than {@code mid} and {@code j} is less
     *     than {@code right}.</li>
     *     <li>Inside the loop, it compares the elements at indices {@code i} and {@code j} in the {@code list}.
     *     If the element at index {@code j} is greater than or equal to the element at index {@code i},
     *     it adds the element at index {@code i} to the {@code merged} list and increments {@code i} and {@code k}.
     *     Otherwise, it adds the element at index {@code j} to the {@code merged} list and increments {@code j} and
     *     {@code k}.</li>
     *     <li>It enters two separate while loops to handle the remaining elements in the first and second halves of
     *     the sublist.
     *     If there are elements remaining in the first half {@code (i < mid)},
     *     it adds them to the {@code merged} list and increments {@code i} and {@code k}.
     *     Similarly, if there are elements remaining in the second half {@code (j < right)},
     *     it adds them to the {@code merged} list and increments {@code j} and {@code k}.</li>
     *     <li>It updates the original {@code list} by setting the elements from indices {@code left} to
     *     {@code (left + n - 1)}
     *     to their corresponding values in the {@code merged} list.</li>
     *     <li>It enters a for loop that iterates over the indices from {@code (left + 1)} to {@code (right - 1)}
     *     with a step size of <i>2</i>.</li>
     *     <li>Inside the loop, it compares the element at index {@code m} with the element at index {@code (m + 1)} in
     *     the {@code list}.
     *     If the element at index {@code m} is greater than the element at index {@code (m + 1)},
     *     it swaps them using the {@code swap} method.</li>
     * </ul>
     * {@code batcherMergingInc} performs an incremental merging operation on a sublist of the {@code list} between the
     * indices {@code left} and {@code right}.
     * It merges the two halves of the sublist into a new {@code merged} list, updates the original {@code list} with
     * the merged elements,
     * and performs a final sorting pass to ensure the odd-even ordering of adjacent elements.
     * @param       list to be arranged.
     * @param       left specific range of the list.
     * @param       mid the middle value of the specified range of the list.
     * @param       right specific range of the list.
     * @see         SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void batcherMergingInc(List<L> list, int left, int mid, int right) {
        int n = (right - left), i = left, j = mid, k = 0;
        List<L> merged = new ArrayList<>();
        while (i < mid && j < right) {
            if (list.get(j).compareTo(list.get(i)) >= 0) {
                merged.add(k++, list.get(i++));
            } else {
                merged.add(k++, list.get(j++));
            }
        }
        while (i < mid) {
            merged.add(k++, list.get(i++));
        }
        while (j < right) {
            merged.add(k++, list.get(j++));
        }
        for (int m = 0; m < n; m++) {
            list.set((left + m), merged.get(m));
        }
        for (int m = (left + 1); m < (right - 1); m += 2) {
            if (list.get(m).compareTo(list.get(m + 1)) > 0) {
                swap(list, m, (m + 1));
            }
        }
    }

    /**
     * {@code batcherMergingDec} that performs a decremental merging operation on a sublist of
     * the {@code list} between the indices {@code left} and {@code right}.
     * It is part of the Batcher's merge sort algorithm.
     * <ul>
     *     <li>It calculates the size of the sublist by subtracting {@code left} from {@code right}
     *     and assigns the result to the variable {@code n}.
     *     It also initializes variables {@code i} and {@code j} to {@code left} and {@code mid}, respectively,
     *     and {@code k} to <i>0</i>.</li>
     *     <li>It creates a new {@link java.util.ArrayList ArrayList} called {@code merged} to store the merged
     *     elements.</li>
     *     <li>It enters a while loop that continues as long as {@code i} is less than {@code mid} and {@code j} is
     *     less than {@code right}.</li>
     *     <li>Inside the loop, it compares the elements at indices {@code i} and {@code j} in the {@code list}.
     *     If the element at index {@code j} is smaller than or equal to the element at index {@code i},
     *     it adds the element at index {@code i} to the {@code merged} list and increments {@code i} and {@code k}.
     *     Otherwise, it adds the element at index {@code j} to the {@code merged} list and increments {@code j} and
     *     {@code k}.</li>
     *     <li>It enters two separate while loops to handle the remaining elements in the first and second halves of
     *     the sublist.
     *     If there are elements remaining in the first half {@code (i < mid)},
     *     it adds them to the {@code merged} list and increments {@code i} and {@code k}.
     *     Similarly, if there are elements remaining in the second half {@code (j < right)},
     *     it adds them to the {@code merged} list and increments {@code j} and {@code k}.</li>
     *     <li>It updates the original {@code list} by setting the elements from indices {@code left} to
     *     {@code (left + n - 1)}
     *     to their corresponding values in the {@code merged} list.</li>
     *     <li>It enters a for loop that iterates over the indices from {@code (left + 1)} to {@code (right - 1)}
     *     with a step size of <i>2</i>.</li>
     *     <li>Inside the loop, it compares the element at index {@code m} with the element at index {@code (m + 1)} in
     *     the {@code list}.
     *     If the element at index {@code m} is smaller than the element at index {@code (m + 1)},
     *     it swaps them using the {@code swap} method.</li>
     * </ul>
     * {@code batcherMergingDec} performs a decremental merging operation on a sublist of the {@code list} between the
     * indices {@code left} and {@code right}.
     * It merges the two halves of the sublist into a new {@code merged} list, updates the original {@code list} with
     * the merged elements,
     * and performs a final sorting pass to ensure the odd-even ordering of adjacent elements.
     * @param       list to be arranged.
     * @param       left specific range of the list.
     * @param       mid the middle value of the specified range of the list.
     * @param       right specific range of the list.
     * @see         SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void batcherMergingDec(List<L> list, int left, int mid, int right) {
        int n = (right - left), i = left, j = mid, k = 0;
        List<L> merged = new ArrayList<>();
        while (i < mid && j < right) {
            if (list.get(j).compareTo(list.get(i)) <= 0) {
                merged.add(k++, list.get(i++));
            } else {
                merged.add(k++, list.get(j++));
            }
        }
        while (i < mid) {
            merged.add(k++, list.get(i++));
        }
        while (j < right) {
            merged.add(k++, list.get(j++));
        }
        for (int m = 0; m < n; m++) {
            list.set((left + m), merged.get(m));
        }
        for (int m = (left + 1); m < (right - 1); m += 2) {
            if (list.get(m).compareTo(list.get(m + 1)) < 0) {
                swap(list, m, (m + 1));
            }
        }
    }

    /**
     * {@code batcherMerging} method that includes a {@code SortFunctional} object called {@code functional}.
     * This object is used for comparing elements in the buffer list during the merging process.
     * <ul>
     *     <li>It calculates the size of the sublist by subtracting {@code left} from {@code right}
     *     and assigns the result to the variable {@code n}.
     *     It also initializes variables {@code i} and {@code j} to {@code left} and {@code mid}, respectively,
     *     and {@code k} to <i>0</i>.</li>
     *     <li>It creates a new {@link java.util.ArrayList ArrayList} called {@code merged} to store the merged
     *     elements.</li>
     *     <li>It initializes a new {@code SortFunctional} object called {@code functionalAddEquals}
     *     by calling a method {@code functionalComparableToAddEquals} with the {@code functional} object as an
     *     argument.</li>
     *     <li>It enters a while loop that continues as long as {@code i} is less than {@code mid} and {@code j} is
     *     less than {@code right}.</li>
     *     <li>Inside the loop, it performs a comparison between the elements at indices i and j in the list using the
     *     functionalAddEquals object.
     *     If the comparison indicates that the element at index {@code j} is greater,
     *     it adds the element at index {@code i} to the {@code merged} list and increments {@code i} and {@code k}.
     *     Otherwise, it adds the element at index {@code j} to the {@code merged} list and increments {@code j} and
     *     {@code k}.</li>
     *     <li>It enters two separate while loops to handle the remaining elements in the first and second halves of
     *     the sublist.
     *     If there are elements remaining in the first half {@code (i < mid)},
     *     it adds them to the {@code merged} list and increments {@code i} and {@code k}.
     *     Similarly, if there are elements remaining in the second half {@code (j < right)},
     *     it adds them to the {@code merged} list and increments {@code j} and {@code k}.</li>
     *     <li>It updates the original {@code list} by setting the elements from indices {@code left} to
     *     {@code (left + n - 1)}
     *     to their corresponding values in the {@code merged} list.</li>
     *     <li>It enters a for loop that iterates over the indices from {@code (left + 1)} to {@code (right - 1)}
     *     with a step size of <i>2</i>.</li>
     *     <li>Inside the loop, it performs a comparison between the element at index {@code m} and
     *     the element at index {@code (m + 1)} in the list using the {@code functional} object.
     *     If the comparison indicates that the element at index {@code m} is greater,
     *     it swaps them using the {@code swap} method.</li>
     * </ul>
     * {@code batcherMergingInc} performs the merging operation on a sublist of the {@code list} between the indices
     * {@code left} and {@code right}
     * using a custom sorting implementation provided through the {@code SortFunctional} object.
     * It merges the two halves of the sublist into a new {@code merged} list,
     * updates the original {@code list} with the merged elements,
     * and performs a final sorting pass to ensure the ordering of adjacent elements using the {@code functional}
     * object for comparisons.
     * @param       list to be arranged.
     * @param       left specific range of the list.
     * @param       mid the middle value of the specified range of the list.
     * @param       right specific range of the list.
     * @param       functional lambda expression for comparison.
     * @see         Sort#functionalComparableToAddEquals(SortFunctional)
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         SortSwap#swap(List, int, int)
     */
    protected <L extends Comparable> void batcherMerging(
            List<L> list, int left, int mid, int right, SortFunctional<Comparable> functional) {
        int n = (right - left), i = left, j = mid, k = 0;
        List<L> merged = new ArrayList<>();
        SortFunctional<Comparable> functionalAddEquals = functionalComparableToAddEquals(functional);
        while (i < mid && j < right) {
            if (functionalAddEquals.functionalCompareTo(list.get(j), list.get(i))) {
                merged.add(k++, list.get(i++));
            } else {
                merged.add(k++, list.get(j++));
            }
        }
        while (i < mid) {
            merged.add(k++, list.get(i++));
        }
        while (j < right) {
            merged.add(k++, list.get(j++));
        }
        for (int m = 0; m < n; m++) {
            list.set((left + m), merged.get(m));
        }
        for (int m = (left + 1); m < (right - 1); m += 2) {
            if (functional.functionalCompareTo(list.get(m), list.get(m + 1))) {
                swap(list, m, (m + 1));
            }
        }
    }
}