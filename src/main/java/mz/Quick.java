package mz;

/**
 * Quick Sort is a widely used comparison-based sorting algorithm that follows a divide-and-conquer approach.
 * It works by selecting a pivot element from the array and partitioning the other elements into two sub-arrays,
 * according to whether they are less than or greater than the pivot. The sub-arrays are then recursively sorted,
 * and the sorted sub-arrays are combined to produce the final sorted array.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class Quick
extends SortComparable
implements SortSwap<Comparable> {

    /**
     * <b>Quick Sort:</b><br>
     * Quick Sort is a widely used comparison-based sorting algorithm that follows a divide-and-conquer approach.
     * It works by selecting a pivot element from the array and partitioning the other elements into two sub-arrays,
     * according to whether they are less than or greater than the pivot. The sub-arrays are then recursively sorted,
     * and the sorted sub-arrays are combined to produce the final sorted array.
     * <b>Example:</b>
     * <ol>
     *     <li>Choose a pivot element from the array. This can be done in various ways, such as selecting
     *     the first, last, or middle element.</li>
     *     <li>Partition the array into two sub-arrays: the elements less than the pivot and the elements greater than the pivot.
     *     This can be done by iterating through the array and moving elements to the left or right of the pivot based on their values.</li>
     *     <li>Recursively apply Quick Sort to the two sub-arrays generated in the previous step.</li>
     *     <li>Combine the sorted sub-arrays along with the pivot element to produce the final sorted array.</li>
     * </ol>
     * <b>Note:</b><br>
     * The key step in Quick Sort is the partitioning process,
     * which efficiently places the pivot element in its correct sorted position and divides the array into two sub-arrays.
     * This process ensures that the pivot element is in its final sorted position in each recursive call.<br><br>
     * The choice of pivot can impact the efficiency of the algorithm. In the worst case,
     * where the pivot is consistently selected as the smallest or largest element, Quick Sort can have a time complexity of <em>O(n^2)</em>.
     * However, on average, Quick Sort has a time complexity of <em>O(n log(n))</em>, which makes it efficient for large datasets.<br><br>
     * Quick Sort is an in-place sorting algorithm, meaning it does not require any additional memory beyond the original array.
     * It is widely used due to its efficiency and simplicity.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(log(n))</em><br>
     * Stability:               <b>No</b>
     */
    public Quick() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         mz.Quick#quickInc(Comparable[], int, int)
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        quickInc(array, 0, (array.length - 1));
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         mz.Quick#quickDec(Comparable[], int, int)
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        quickDec(array, 0, (array.length - 1));
    }

    /**
     * Implementation of a quick sort algorithm for sorting the array of comparable objects in ascending order.
     * The {@code quickInc} method follows the divide-and-conquer strategy of quicksort,
     * recursively partitioning the array into smaller subarrays and sorting them individually.
     * The base case of the recursion is when the subarray has only one element, in which case it is considered already sorted.
     * <ull>
     *     <li>The method {@code quickInc} takes an array of Comparable objects,
     *     along with the indices {@code left} and {@code right} that define the range of the subarray being sorted.</li>
     *     <li>The first condition {@code if (left < right)} checks if the subarray has more than one element.
     *     If it does, the sorting continues; otherwise, the subarray is already sorted, and the method returns.</li>
     *     <li>Inside the condition, the {@code quickInc} method is called to partition the array and obtain the {@code partitionIndex},
     *     which represents the correct position of the pivot element after the partitioning.</li>
     *     <li>The {@code quickInc} method is recursively called twice:</li>
     *     <ul>
     *         <li>The first recursive call sorts the left partition of the array by calling {@code quickInc}
     *         with left as the start index and {@code (partitionIndex - 1)} as the end index.</li>
     *         <li>The second recursive call sorts the right partition of the array by calling {@code quickInc} with
     *         {@code (partitionIndex + 1)} as the start index and {@code right} as the end index.</li>
     *     </ul>
     *     <li>This process is repeated until the entire array is sorted.</li>
     * </ull>
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     */
    void quickInc(Comparable[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partitionInc(array, left, right);
            quickInc(array, left, (partitionIndex - 1));
            quickInc(array, (partitionIndex +1), right);
        }
    }

    /**
     * Implementation of a quick sort algorithm for sorting the array of comparable objects in ascending order.
     * The {@code quickDec} method follows the divide-and-conquer strategy of quicksort,
     * recursively partitioning the array into smaller subarrays and sorting them individually.
     * The base case of the recursion is when the subarray has only one element, in which case it is considered already sorted.
     * <ul>
     *     <li>The method {@code quickDec} takes an array of Comparable objects,
     *     along with the indices {@code left} and {@code right} that define the range of the subarray being sorted.</li>
     *     <li>The first condition {@code if (left < right)} checks if the subarray has more than one element.
     *     If it does, the sorting continues; otherwise, the subarray is already sorted, and the method returns.</li>
     *     <li>Inside the condition, the {@code quickDec} method is called to partition the array and obtain the {@code partitionIndex},
     *     which represents the correct position of the pivot element after the partitioning.</li>
     *     <li>The {@code quickDec} method is recursively called twice:</li>
     *     <ul>
     *         <li>The first recursive call sorts the left partition of the array by calling {@code quickDec}
     *         with left as the start index and {@code (partitionIndex - 1)} as the end index.</li>
     *         <li>The second recursive call sorts the right partition of the array by calling {@code quickDec} with
     *         {@code (partitionIndex + 1)} as the start index and {@code right} as the end index.</li>
     *     </ul>
     *     <li>This process is repeated until the entire array is sorted.</li>
     * </ul>
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     */
    void quickDec(Comparable[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partitionDec(array, left, right);
            quickDec(array, left, (partitionIndex - 1));
            quickDec(array, (partitionIndex +1), right);
        }
    }

    /**
     * Provided seems to be an implementation of the partitioning step of the quicksort algorithm.
     * It partitions an array into two parts, one with elements smaller than a pivot and another with elements greater than or equal to the pivot.
     * <ull>
     *     <li>The method {@code partitionInc} takes an array of {@code Comparable} objects, along with the indices left and right
     *     that define the range of the subarray being partitioned.
     *     It returns the index of the pivot element after the partitioning is done.</li>
     *     <li>The pivot element is chosen as {@code array[right]}, which is the last element of the subarray.</li>
     *     <li>The variable i is initialized to {@code (left - 1)}. It will keep track of the boundary between the elements smaller
     *     than the pivot and those greater than or equal to the pivot.</li>
     *     <li>A loop is executed from left to {@code (right - 1)} to iterate over the elements of the subarray.</li>
     *     <li>Inside the loop, each element {@code array[j]} is compared to the pivot using the {@code compareTo} method of {@code Comparable}.
     *     If the element is smaller than the pivot, the following steps are executed:</li>
     *     <ul>
     *         <li>{@code i} is incremented by 1 to expand the smaller elements region.</li>
     *         <li>The swap method is called to {@code swap} {@code array[i]} and {@code array[j]}, moving the smaller element to the left.</li>
     *     </ul>
     *     <li>After the loop, the pivot element is moved to its correct position by swapping it with {@code array[i + 1]}.
     *     This ensures that all elements to the left of {@code array[i + 1]} are smaller than or equal to the pivot,
     *     and all elements to the right are greater than the pivot.</li>
     * </ull>
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @return      index of the pivot element.
     * @see         mz.Quick#quickInc(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    int partitionInc(Comparable[] array, int left, int right) {
        Comparable pivot = array[right];
        int i = (left - 1);
        for (int j = left; j <= (right -1); j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, (i + 1), right);
        return (i + 1);
    }

    /**
     * Provided seems to be an implementation of the partitioning step of the quicksort algorithm.
     * It partitions an array into two parts, one with elements smaller than a pivot and another with elements greater than or equal to the pivot.
     * <ull>
     *     <li>The method {@code partitionDec} takes an array of {@code Comparable} objects, along with the indices left and right
     *     that define the range of the subarray being partitioned.
     *     It returns the index of the pivot element after the partitioning is done.</li>
     *     <li>The pivot element is chosen as {@code array[right]}, which is the last element of the subarray.</li>
     *     <li>The variable i is initialized to {@code (left - 1)}. It will keep track of the boundary between the elements smaller
     *     than the pivot and those greater than or equal to the pivot.</li>
     *     <li>A loop is executed from left to {@code (right - 1)} to iterate over the elements of the subarray.</li>
     *     <li>Inside the loop, each element {@code array[j]} is compared to the pivot using the {@code compareTo} method of {@code Comparable}.
     *     If the element is greater than the pivot, the following steps are executed:</li>
     *     <ul>
     *         <li>{@code i} is incremented by 1 to expand the smaller elements region.</li>
     *         <li>The swap method is called to {@code swap} {@code array[i]} and {@code array[j]}, moving the smaller element to the left.</li>
     *     </ul>
     *     <li>After the loop, the pivot element is moved to its correct position by swapping it with {@code array[i + 1]}.
     *     This ensures that all elements to the left of {@code array[i + 1]} are smaller than or equal to the pivot,
     *     and all elements to the right are greater than the pivot.</li>
     * </ull>
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @return      the index of the pivot element.
     * @see         mz.Quick#quickDec(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    int partitionDec(Comparable[] array, int left, int right) {
        Comparable pivot = array[right];
        int i = (left - 1);
        for (int j = left; j <= (right -1); j++) {
            if (array[j].compareTo(pivot) > 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, (i + 1), right);
        return (i + 1);
    }
}