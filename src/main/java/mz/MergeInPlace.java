package mz;

/**
 * Merge In Place Sort is a variant of the merge sort algorithm that performs the sorting operation directly on the input array,
 * without using any additional arrays for merging.
 * It achieves this by carefully manipulating the elements within the original array during the merging process.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class MergeInPlace
extends Merge {

    /**
     * <b>Merge In Place Sort:</b><br>
     * Is a variant of the merge sort algorithm that performs the sorting operation directly on the input array,
     * without using any additional arrays for merging.
     * It achieves this by carefully manipulating the elements within the original array during the merging process.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>The algorithm recursively divides the array into smaller subarrays until each subarray contains only one element (considered sorted).</li>
     *     <li>Then, it starts merging the subarrays in pairs, using an in-place merging technique.</li>
     *     <li>To perform an in-place merge of two subarrays, the algorithm follows these steps:</li>
     *     <ul>
     *         <li> It compares the first element of the left subarray with the first element of the right subarray.
     *         If the left element is greater, it swaps the two elements.</li>
     *         <li>After the swap, it compares the new first element of the right subarray with the next element in the left subarray,
     *         and so on, until the elements in both subarrays are in the correct sorted order.</li>
     *         <li>Meanwhile, the elements in the left subarray are shifted one position to the right to make space for
     *         the swapped element from the right subarray.</li>
     *     </ul>
     *     <li>Once the merging of two subarrays is complete, the algorithm moves on to merge the next pair of subarrays,
     *     until the entire array is sorted.</li>
     * </ol>
     * <b>Note:</b><br>
     * Time Complexity of above approach is <em>O(n^2 * log(n))</em> because merge is <em>O(n^2)</em>.
     * Time complexity of standard merge sort is less, <em>O(n log(n))</em>.
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>Yes</b>
     * @see         mz.intro.IntroMergeInPlace#IntroMergeInPlace() IntroMergeInPlace
     */
    public MergeInPlace() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        mergeInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        mergeDec(array);
    }

    /**
     * {@code mergingInc} is a Java implementation of the merging step in the merge sort algorithm.
     * It takes an array of Comparable objects, along with the indices representing
     * the left, middle, and right boundaries of the subarray being merged.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method starts by initializing the start variable to {@code (mid + 1)}.
     *     This is the index where the second subarray begins.</li>
     *     <li>The code then checks if the element at index {@code mid} is less than or equal to the element at index {@code start}.
     *     If this condition is true, it means that the two subarrays are already sorted, and there is no need to perform any merging.
     *     In that case, the method simply returns.</li>
     *     <li>If the condition in step 3 is false, indicating that merging is necessary, a {@code while} loop is used
     *     to compare elements from both subarrays and merge them in sorted order.</li>
     *     <li>Within the {@code while} loop, there is an {@code if}-{@code else} statement that compares the elements at indices {@code left} and {@code start}.
     *     If the element at {@code left} is less than or equal to the element at {@code start},
     *     it means that the element at {@code left} is already in its correct sorted position,
     *     and we can simply move to the next element in the {@code left} subarray by incrementing the {@code left} variable.</li>
     *     <li>If the element at {@code left} is greater than the element at {@code start},
     *     it means that the element at {@code start} needs to be inserted into its correct position in the {@code left} subarray.
     *     The code creates a temporary variable value to store the value at index {@code start},
     *     and an index variable {@code index} to keep track of the position where value will be inserted.</li>
     *     <li>A {@code while} loop is used to shift the elements from {@code index} to {@code left} in the {@code array} one position to the {@code right},
     *     effectively making space for {@code value} to be inserted at the correct position.</li>
     *     <li>After shifting the elements, {@code value} is inserted at index {@code left}, and both {@code left}
     *     and {@code start} are incremented to move to the next elements in their respective subarrays.</li>
     *     <li>The {@code while} loop continues until either the {@code left} subarray or the {@code start} subarray is exhausted, i.e.,
     *     all elements from either subarray have been merged.</li>
     * </ul>
     * {@code mergingInc} this method performs the merging of two sorted subarrays within the larger array.
     * It uses a temporary variable to insert elements from the second subarray into their correct positions within
     * the first subarray, effectively merging the two subarrays into a single sorted subarray.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void mergingInc(Comparable[] array, int left, int mid, int right) {
        int start = (mid + 1);
        if (array[mid].compareTo(array[start]) <= 0) {
            return;
        }
        while (left <= mid && start <= right) {
            if (array[left].compareTo(array[start]) <= 0) {
                left++;
            } else {
                Comparable value = array[start];
                int index = start;
                while (index != left) {
                    array[index] = array[(index - 1)];
                    index--;
                }
                array[left++] = value;
                mid++;
                start++;
            }
        }
    }

    /**
     * {@code mergingDec} is a Java implementation of the merging step in the merge sort algorithm.
     * It takes an array of Comparable objects, along with the indices representing
     * the left, middle, and right boundaries of the subarray being merged.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method starts by initializing the start variable to {@code (mid + 1)}.
     *     This is the index where the second subarray begins.</li>
     *     <li>The code then checks if the element at index {@code mid} is more than or equal to the element at index {@code start}.
     *     If this condition is true, it means that the two subarrays are already sorted, and there is no need to perform any merging.
     *     In that case, the method simply returns.</li>
     *     <li>If the condition in step 3 is false, indicating that merging is necessary, a {@code while} loop is used
     *     to compare elements from both subarrays and merge them in sorted order.</li>
     *     <li>Within the {@code while} loop, there is an {@code if}-{@code else} statement that compares the elements at indices {@code left} and {@code start}.
     *     If the element at {@code left} is more than or equal to the element at {@code start},
     *     it means that the element at {@code left} is already in its correct sorted position,
     *     and we can simply move to the next element in the {@code left} subarray by decrementing the {@code left} variable.</li>
     *     <li>If the element at {@code left} is smaller than the element at {@code start},
     *     it means that the element at {@code start} needs to be inserted into its correct position in the {@code left} subarray.
     *     The code creates a temporary variable value to store the value at index {@code start},
     *     and an index variable {@code index} to keep track of the position where value will be inserted.</li>
     *     <li>A {@code while} loop is used to shift the elements from {@code index} to {@code left} in the {@code array} one position to the {@code right},
     *     effectively making space for {@code value} to be inserted at the correct position.</li>
     *     <li>After shifting the elements, {@code value} is inserted at index {@code left}, and both {@code left}
     *     and {@code start} are decremented to move to the next elements in their respective subarrays.</li>
     *     <li>The {@code while} loop continues until either the {@code left} subarray or the {@code start} subarray is exhausted, i.e.,
     *     all elements from either subarray have been merged.</li>
     * </ul>
     * {@code mergingDec} this method performs the merging of two sorted subarrays within the larger array.
     * It uses a temporary variable to insert elements from the second subarray into their correct positions within
     * the first subarray, effectively merging the two subarrays into a single sorted subarray.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void mergingDec(Comparable[] array, int left, int mid, int right) {
        int start = (mid + 1);
        if (array[mid].compareTo(array[start]) >= 0) {
            return;
        }
        while (left <= mid && start <= right) {
            if (array[left].compareTo(array[start]) >= 0) {
                left++;
            } else {
                Comparable value = array[start];
                int index = start;
                while (index != left) {
                    array[index] = array[(index - 1)];
                    index--;
                }
                array[left++] = value;
                mid++;
                start++;
            }
        }
    }
}