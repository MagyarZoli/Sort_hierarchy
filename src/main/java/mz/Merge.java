package mz;

import java.util.Arrays;

/**
 * Merge Sort is a comparison-based sorting algorithm that follows the divide-and-conquer approach.
 * It works by dividing the unsorted list into smaller sublists, sorting those sublists recursively,
 * and then merging them back together to obtain a sorted list.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class Merge
extends SortComparable {

    /**
     * <b>Merge Sort:</b><br>
     * Is a comparison-based sorting algorithm that follows the divide-and-conquer approach.
     * It works by dividing the unsorted list into smaller sublists, sorting those sublists recursively,
     * and then merging them back together to obtain a sorted list.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Divide the unsorted list into two equal-sized sublists.</li>
     *     <li>Recursively sort each sublist by applying Merge Sort to them.</li>
     *     <li>Merge the sorted sublists back together to form a single sorted list.</li>
     *     <ul>
     *         <li>Start with two pointers, one for each sublist, pointing to the beginning of each sublist.</li>
     *         <li>Compare the elements at the pointers and select the smaller (or larger) element to be placed in the merged list.</li>
     *         <li>Move the pointer of the selected element to the next position.</li>
     *         <li>Repeat the comparison and merging process until all elements from both sublists are merged into the final sorted list.</li>
     *     </ul>
     * </ol>
     * <b>Note:</b><br>
     * The key step in Merge Sort is the merging process, where two sorted sublists are combined to form a single sorted list.
     * This process ensures that the elements are appropriately sorted during the merge phase.<br><br>
     * Merge Sort has a time complexity of <em>O(n log(n))</em> in the average and worst cases, where n is the number of elements in the list.
     * It is considered an efficient sorting algorithm and is particularly useful for large datasets.
     * Merge Sort's time complexity remains the same regardless of the input sequence, making it a reliable choice for sorting.<br><br>
     * Merge Sort is a stable sorting algorithm, meaning it maintains the relative order of elements with equal values.
     * It is an in-place algorithm in its purest form, meaning it can sort the elements using only a small, constant amount of additional memory.
     * However, in most practical implementations, it requires auxiliary space proportional to the size of the input list.<br><br>
     * Merge Sort is widely used in various applications due to its stability, efficiency, and ease of implementation.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>Yes</b>
     */
    public Merge() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         Merge#mergeInc(Comparable[], int, int, int)
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        mergeInc(array, 0, (array.length / 2), (array.length - 1));
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         Merge#mergeDec(Comparable[], int, int, int)
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        mergeDec(array, 0, (array.length / 2), (array.length - 1));
    }

    /**
     * {@code mergeInc} that performs a Merge Sort on an array of {@code Comparable} objects in increasing order.
     * The method recursively divides the array into smaller subarrays, sorts them individually,
     * and then merges them together using the {@code mergingInc} method.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array},
     *     and the indices {@code left}, {@code mid}, and {@code right} that define the portion of the array to be sorted.</li>
     *     <li>The condition {@code if (left < right)} checks if the portion of the array has more than one element.
     *     If so, it proceeds with the merge sort algorithm.</li>
     *     <li>Inside the condition, the method recursively calls itself to sort the left and right halves of the portion.</li>
     *     <ul>
     *         <li>The first recursive call {@code mergeInc(array, left, ((left + mid) / 2), mid)} divides the left half of
     *         the portion by updating the {@code mid} index to be the midpoint between {@code left} and {@code mid}.</li>
     *         <li>The second recursive call {@code mergeInc(array, (mid + 1), (((mid + 1) + right) / 2), right)} divides
     *         the right half of the portion by updating the {@code mid} index to be the midpoint between {@code (mid + 1)} and {@code right}.</li>
     *     </ul>
     *     <li>After the recursive calls, the {@code mergingInc} method is called to merge the two sorted halves together.
     *     The {@code mergingInc} method takes the {@code array}, {@code left}, {@code mid}, and {@code right} indices as arguments.</li>
     *     <li>The overall effect of the {@code mergeInc} method is to recursively divide the array into smaller subarrays until they consist of individual elements.
     *     Then, it merges and sorts these individual elements to gradually build the sorted array.</li>
     * </ul>
     * {@code mergeInc} this implementation follows the divide-and-conquer strategy of merge sort, where the array is recursively divided into smaller subarrays,
     * sorted individually, and then merged back together.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     */

    void mergeInc(Comparable[] array, int left, int mid, int right) {
        if (left < right) {
            mergeInc(array, left, ((left + mid) / 2), mid);
            mergeInc(array, (mid + 1), (((mid + 1) + right) / 2), right);
            mergingInc(array, left, mid, right);
        }
    }

    /**
     * {@code mergeDec} that performs a Merge Sort on an array of {@code Comparable} objects in decreasing order.
     * The method recursively divides the array into smaller subarrays, sorts them individually,
     * and then merges them together using the {@code mergingDec} method.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array},
     *     and the indices {@code left}, {@code mid}, and {@code right} that define the portion of the array to be sorted.</li>
     *     <li>The condition {@code if (left < right)} checks if the portion of the array has more than one element.
     *     If so, it proceeds with the merge sort algorithm.</li>
     *     <li>Inside the condition, the method recursively calls itself to sort the left and right halves of the portion.</li>
     *     <ul>
     *         <li>The first recursive call {@code mergeDec(array, left, ((left + mid) / 2), mid)} divides the left half of
     *         the portion by updating the {@code mid} index to be the midpoint between {@code left} and {@code mid}.</li>
     *         <li>The second recursive call {@code mergeDec(array, (mid + 1), (((mid + 1) + right) / 2), right)} divides
     *         the right half of the portion by updating the {@code mid} index to be the midpoint between {@code (mid + 1)} and {@code right}.</li>
     *     </ul>
     *     <li>After the recursive calls, the {@code mergingDec} method is called to merge the two sorted halves together.
     *     The {@code mergingDec} method takes the {@code array}, {@code left}, {@code mid}, and {@code right} indices as arguments.</li>
     *     <li>The overall effect of the {@code mergeDec} method is to recursively divide the array into greater subarrays until they consist of individual elements.
     *     Then, it merges and sorts these individual elements to gradually build the sorted array.</li>
     * </ul>
     * {@code mergeDec} this implementation follows the divide-and-conquer strategy of merge sort, where the array is recursively divided into smaller subarrays,
     * sorted individually, and then merged back together.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     */
    void mergeDec(Comparable[] array, int left, int mid, int right) {
        if (left < right) {
            mergeDec(array, left, ((left + mid) / 2), mid);
            mergeDec(array, (mid + 1), (((mid + 1) + right) / 2), right);
            mergingDec(array, left, mid, right);
        }
    }

    /**
     * {@code mergingInc} that performs a merging operation for the purpose of merging two sorted portions of an array into a single sorted portion.
     * The method assumes that the left portion of the array, from index {@code left} to {@code mid}, and the {@code right} portion,
     * from index {@code (mid + 1)} to {@code right}, are already sorted in increasing order.
     * <ul>
     *     <li>The {@code @SuppressWarnings("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@code compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method starts by checking if the indices {@code left}, {@code mid}, and {@code right} are within valid bounds.
     *     If the {@code condition left > mid || (mid + 1) > right} is true, it means that either the left portion or
     *     the right portion is empty or the indices are not properly specified.
     *     In such cases, the method returns without performing any merging.</li>
     *     <li>The variables {@code n1} and {@code n2} are assigned the sizes of the left and right portions, respectively.</li>
     *     <li>Two new arrays, {@code leftArray} and {@code rightArray}, are created using the {@code Arrays.copyOfRange} method.
     *     These arrays contain copies of the respective portions of the original {@code array}.</li>
     *     <li>The variables {@code i} and {@code j} are used as indices to iterate over {@code leftArray} and {@code rightArray}, respectively.</li>
     *     <li>The variable {@code k} is used as an index to update the {@code array} with the merged elements.</li>
     *     <li>The subsequent {@code while} loop continues as long as both {@code i} and {@code j} are within their respective array sizes, {@code n1} and {@code n2}.
     *     It compares the elements at indices {@code i} and {@code j} of {@code leftArray} and {@code rightArray},
     *     respectively, and assigns the smaller element to {@code array[k]}.
     *     The corresponding index ({@code i} or {@code j}) and {@code k} are incremented accordingly.</li>
     *     <li>After the {@code while} loop, there might still be remaining elements in either {@code leftArray} or {@code rightArray}.
     *     The next two {@code while} loops handle the remaining elements by copying them into array starting from index {@code k}.</li>
     *     <li>Finally, the merging operation is complete, and the merged sorted portion is stored in the original {@code array} from index {@code left} to {@code right}.</li>
     * </ul>
     * {@code mergingInc} method is commonly used as part of merge sort algorithms to merge two sorted portions of an array into a single sorted portion.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     */
    @SuppressWarnings("unchecked")
    void mergingInc(Comparable[] array, int left, int mid, int right) {
        if (left > mid || (mid + 1) > right) {
            return;
        }
        int n1 = (mid - left + 1);
        int n2 = (right - mid);
        Comparable[] leftArray = Arrays.copyOfRange(array, left, (mid + 1));
        Comparable[] rightArray = Arrays.copyOfRange(array, (mid + 1), (right + 1));
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) < 0) {
                array[k] = leftArray[i++];
            } else {
                array[k] = rightArray[j++];
            }
            k++;
        }
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    /**
     * {@code mergingDec} that performs a merging operation for the purpose of merging two sorted portions of an array into a single sorted portion.
     * The method assumes that the left portion of the array, from index {@code left} to {@code mid}, and the {@code right} portion,
     * from index {@code (mid + 1)} to {@code right}, are already sorted in increasing order.
     * <ul>
     *     <li>The {@code @SuppressWarnings("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@code compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method starts by checking if the indices {@code left}, {@code mid}, and {@code right} are within valid bounds.
     *     If the {@code condition left > mid || (mid + 1) > right} is true, it means that either the left portion or
     *     the right portion is empty or the indices are not properly specified.
     *     In such cases, the method returns without performing any merging.</li>
     *     <li>The variables {@code n1} and {@code n2} are assigned the sizes of the left and right portions, respectively.</li>
     *     <li>Two new arrays, {@code leftArray} and {@code rightArray}, are created using the {@code Arrays.copyOfRange} method.
     *     These arrays contain copies of the respective portions of the original {@code array}.</li>
     *     <li>The variables {@code i} and {@code j} are used as indices to iterate over {@code leftArray} and {@code rightArray}, respectively.</li>
     *     <li>The variable {@code k} is used as an index to update the {@code array} with the merged elements.</li>
     *     <li>The subsequent {@code while} loop continues as long as both {@code i} and {@code j} are within their respective array sizes, {@code n1} and {@code n2}.
     *     It compares the elements at indices {@code i} and {@code j} of {@code leftArray} and {@code rightArray},
     *     respectively, and assigns the greater element to {@code array[k]}.
     *     The corresponding index ({@code i} or {@code j}) and {@code k} are incremented accordingly.</li>
     *     <li>After the {@code while} loop, there might still be remaining elements in either {@code leftArray} or {@code rightArray}.
     *     The next two {@code while} loops handle the remaining elements by copying them into array starting from index {@code k}.</li>
     *     <li>Finally, the merging operation is complete, and the merged sorted portion is stored in the original {@code array} from index {@code left} to {@code right}.</li>
     * </ul>
     * {@code mergingDec} method is commonly used as part of merge sort algorithms to merge two sorted portions of an array into a single sorted portion.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     */
    @SuppressWarnings("unchecked")
    void mergingDec(Comparable[] array, int left, int mid, int right) {
        if (left > mid || (mid + 1) > right) {
            return;
        }
        int n1 = (mid - left + 1);
        int n2 = (right - mid);
        Comparable[] leftArray = Arrays.copyOfRange(array, left, (mid + 1));
        Comparable[] rightArray = Arrays.copyOfRange(array, (mid + 1), (right + 1));
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) > 0) {
                array[k] = leftArray[i++];
            } else {
                array[k] = rightArray[j++];
            }
            k++;
        }
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }
}