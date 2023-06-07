package mz;

/**
 * QuickInterface, containing the methods of Quick Sort to implement other classes.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public interface QuickInterface<T extends Comparable>
extends Sort<T>, SortSwap<T> {

    /**
     * Implementation of a quick sort algorithm for sorting the array of comparable objects in ascending order.
     * The {@code quickInc} method follows the divide-and-conquer strategy of quicksort,
     * recursively partitioning the array into smaller subarrays and sorting them individually.
     * The base case of the recursion is when the subarray has only one element, in which case it is considered already sorted.
     * @param       array to be arranged.
     * @see         mz.QuickInterface#quickInc(Comparable[], int, int)
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
     * @see         mz.QuickInterface#quickDec(Comparable[], int, int)
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
     * @see         mz.QuickInterface#partitionInc(Comparable[], int, int)
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
     * @see         mz.QuickInterface#partitionDec(Comparable[], int, int)
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
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
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
     * @see         mz.SortSwap#swap(Comparable[], int, int)
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
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
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
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    default int partitionDec(T[] array, int left, int right) {
        T pivot = array[right];
        int i = (left - 1);
        for (int j = left; j <= (right - 1); j++) {
            if (array[j].compareTo(pivot) > 0) {
                swap(array, ++i, j);
            }
        }
        swap(array, (i + 1), right);
        return (i + 1);
    }

    /**
     * {@code partitionDualInc} It partitions an array of elements {@code array} between the indices {@code left} and {@code right} (inclusive)
     * and returns an array of two integers representing the indices of the pivots after the partitioning.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The first step compares the elements at indices {@code left} and {@code right}
     *     and swaps them if the element at {@code left} is greater than the element at {@code right}.
     *     This ensures that the {@code pivot1} (the leftmost pivot) is smaller than or equal to {@code pivot2} (the rightmost pivot).</li>
     *     <li>The variables {@code newLeft}, {@code newRight}, and {@code selectIndex} are initialized.
     *     {@code newLeft} points to the index after the {@code pivot1}, {@code newRight} points to
     *     the index before {@code pivot2}, and {@code selectIndex} starts from the index after the left pivot.</li>
     *     <li>The algorithm enters a while loop that continues until {@code selectIndex} surpasses {@code newRight}.</li>
     *     <li>Inside the loop, the algorithm checks if the element at {@code selectIndex} is smaller than {@code pivot1}. If it is,
     *     the element is swapped with the element at {@code newLeft}, and {@code newLeft} is incremented by 1.</li>
     *     <li>If the element at {@code selectIndex} is not smaller than {@code pivot1}, the algorithm checks if it is greater than or equal to {@code pivot2}.
     *     If it is, the algorithm enters another loop that finds an element from the right side of the partition that is smaller than or equal to {@code pivot2}.
     *     This loop decrements {@code newRight} until it finds such an element or until {@code selectIndex} surpasses {@code newRight}.</li>
     *     <li>Once the element is found, the element at {@code selectIndex} is swapped with the found element, and {@code newRight} is decremented by 1.
     *     Then, if the element at {@code selectIndex} is smaller than {@code pivot1},
     *     the element is swapped with the element at {@codee newLeft}, and {@code newLeft} is incremented by 1.</li>
     *     <li>Finally, {@code selectIndex} is incremented by 1, and the while loop continues until {@code selectIndex} surpasses {@code newRight}.</li>
     *     <li>After the loop finishes, the left pivot {@code pivot1} is swapped with the element at {@code newLeft - 1}, and the right pivot {@code pivot2} is swapped with the element at {@code newRight + 1}.
     *     This step puts the pivots in their correct positions.</li>
     * </ul>
     * {@code partitionDualInc} The method returns an int array containing the indices of the pivots in the partitioned array, {@code [newLeft, newRight]}.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @return      the pivots in the partitioned array.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    default int[] partitionDualInc(T[] array, int left, int right) {
        if (array[left].compareTo(array[right]) > 0) {
            swap(array, left, right);
        }
        int newLeft = (left + 1), newRight = (right - 1), selectIndex = (left + 1);
        Comparable pivot1 = array[left], pivot2 = array[right];
        while(selectIndex <= newRight) {
            if(array[selectIndex].compareTo(pivot1) < 0) {
                swap(array, selectIndex, newLeft++);
            } else if (array[selectIndex].compareTo(pivot2) >= 0) {
                while (array[newRight].compareTo(pivot2) > 0 && selectIndex < newRight) {
                    newRight--;
                }
                swap(array, selectIndex, newRight--);
                if ( array[selectIndex].compareTo(pivot1) < 0) {
                    swap(array, selectIndex, newLeft++);
                }
            }
            selectIndex++;
        }
        swap(array, left, --newLeft);
        swap(array, right, ++newRight);
        return new int[] {newLeft, newRight};
    }

    /**
     * {@code partitionDualDec} It partitions an array of elements {@code array} between the indices {@code left} and {@code right} (inclusive)
     * and returns an array of two integers representing the indices of the pivots after the partitioning.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The first step compares the elements at indices {@code left} and {@code right}
     *     and swaps them if the element at {@code left} is greater than the element at {@code right}.
     *     This ensures that the {@code pivot1} (the leftmost pivot) is smaller than or equal to {@code pivot2} (the rightmost pivot).</li>
     *     <li>The variables {@code newLeft}, {@code newRight}, and {@code selectIndex} are initialized.
     *     {@code newLeft} points to the index after the {@code pivot1}, {@code newRight} points to
     *     the index before {@code pivot2}, and {@code selectIndex} starts from the index after the left pivot.</li>
     *     <li>The algorithm enters a while loop that continues until {@code selectIndex} surpasses {@code newRight}.</li>
     *     <li>Inside the loop, the algorithm checks if the element at {@code selectIndex} is greater than {@code pivot1}. If it is,
     *     the element is swapped with the element at {@code newLeft}, and {@code newLeft} is incremented by 1.</li>
     *     <li>If the element at {@code selectIndex} is not greater than {@code pivot1}, the algorithm checks if it is smaller than or equal to {@code pivot2}.
     *     If it is, the algorithm enters another loop that finds an element from the right side of the partition that is greater than or equal to {@code pivot2}.
     *     This loop decrements {@code newRight} until it finds such an element or until {@code selectIndex} surpasses {@code newRight}.</li>
     *     <li>Once the element is found, the element at {@code selectIndex} is swapped with the found element, and {@code newRight} is decremented by 1.
     *     Then, if the element at {@code selectIndex} is greater than {@code pivot1},
     *     the element is swapped with the element at {@codee newLeft}, and {@code newLeft} is incremented by 1.</li>
     *     <li>Finally, {@code selectIndex} is incremented by 1, and the while loop continues until {@code selectIndex} surpasses {@code newRight}.</li>
     *     <li>After the loop finishes, the left pivot {@code pivot1} is swapped with the element at {@code newLeft - 1}, and the right pivot {@code pivot2} is swapped with the element at {@code newRight + 1}.
     *     This step puts the pivots in their correct positions.</li>
     * </ul>
     * {@code partitionDualDec} The method returns an int array containing the indices of the pivots in the partitioned array, {@code [newLeft, newRight]}.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @return      the pivots in the partitioned array.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    default int[] partitionDualDec(T[] array, int left, int right) {
        if (array[left].compareTo(array[right]) < 0) {
            swap(array, left, right);
        }
        int newLeft = (left + 1), newRight = (right - 1), selectIndex = (left + 1);
        Comparable pivot1 = array[left], pivot2 = array[right];
        while(selectIndex <= newRight) {
            if(array[selectIndex].compareTo(pivot1) > 0) {
                swap(array, selectIndex, newLeft++);
            } else if (array[selectIndex].compareTo(pivot2) <= 0) {
                while (array[newRight].compareTo(pivot2) < 0 && selectIndex < newRight) {
                    newRight--;
                }
                swap(array, selectIndex, newRight--);
                if ( array[selectIndex].compareTo(pivot1) > 0) {
                    swap(array, selectIndex, newLeft++);
                }
            }
            selectIndex++;
        }
        swap(array, left, --newLeft);
        swap(array, right, ++newRight);
        return new int[] {newLeft, newRight};
    }
}