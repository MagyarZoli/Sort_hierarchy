package mz;

/**
 * QuickInterface, containing the methods of Quick Sort to implement other classes.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 * @see         mz.Quick
 * @see         mz.Quick3
 */
public interface QuickInterface<T extends Comparable>
extends Sort<T>, SortSwap<T> {

    /**
     * Implementation of a quick sort algorithm for sorting the array of comparable objects in ascending order.
     * The {@code quickInc} method follows the divide-and-conquer strategy of quicksort,
     * recursively partitioning the array into smaller subarrays and sorting them individually.
     * The base case of the recursion is when the subarray has only one element, in which case it is considered already sorted.
     * @param       array to be arranged.
     */
    default void quickInc(T[] array) {
        quickInc(array, 0, (array.length - 1));
    }

    /**
     * Implementation of a quick sort algorithm for sorting the array of comparable objects in ascending order.
     * The {@code quickDec} method follows the divide-and-conquer strategy of quicksort,
     * recursively partitioning the array into smaller subarrays and sorting them individually.
     * The base case of the recursion is when the subarray has only one element, in which case it is considered already sorted.
     * @param       array to be arranged.
     */
    default void quickDec(T[] array) {
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
     * @see         mz.QuickInterface#quickInc(Comparable[])
     * @see         mz.Quick3#quick3Inc(Comparable[], int, int)
     */
    default void quickInc(T[] array, int left, int right) {
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
     * @see         mz.QuickInterface#quickInc(Comparable[])
     * @see         mz.Quick3#quick3Dec(Comparable[], int, int)
     */
    default void quickDec(T[] array, int left, int right) {
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
     * @see         mz.QuickInterface#quickInc(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    default int partitionInc(T[] array, int left, int right) {
        T pivot = array[right];
        int i = (left - 1);
        for (int j = left; j <= (right -1); j++) {
            if (array[j].compareTo(pivot) < 0) {
                swap(array, ++i, j);
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
     * @see         mz.QuickInterface#quickDec(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    default int partitionDec(T[] array, int left, int right) {
        T pivot = array[right];
        int i = (left - 1);
        for (int j = left; j <= (right -1); j++) {
            if (array[j].compareTo(pivot) > 0) {
                swap(array, ++i, j);
            }
        }
        swap(array, (i + 1), right);
        return (i + 1);
    }
}