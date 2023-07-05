package mz;

/**
 * QuickInterface, containing the methods of Quick Sort to implement other classes.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.2
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
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
     * {@code quick} method now takes an array {@code array} of type {@code T}
     * and an instance of {@code SortFunctional<T>} as parameters.
     * <ul>
     *     <li>It calls the overloaded {@code quick} method with additional parameters:
     *     {@code array}, <i>0</i> as the starting index ({@code left}),
     *     {@code (array.length - 1)} as the ending index ({@code right}), and the {@code functional} instance.</li>
     *     <li>The overloaded {@code quick} method is responsible for performing the actual sorting.
     *     It partitions the array within the specified range
     *     and recursively sorts the resulting subarrays using the {@code functional} instance.</li>
     *     <li>By calling {@code quick(array, 0, (array.length - 1), functional)},
     *     the {@code quick} method initiates the Quicksort algorithm on the entire array,
     *     sorting it in ascending order according to the comparison logic defined by the {@code SortFunctional} instance.</li>
     * </ul>
     * {@code quick} method provides a convenient way to invoke the Quicksort algorithm on the entire array using
     * the comparison logic defined by the {@code SortFunctional} instance.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.QuickInterface#quick(Comparable[], int, int, SortFunctional)
     */
    default void quick(T[] array, SortFunctional<T> functional) {
        quick(array, 0, (array.length - 1), functional);
    }

    /**
     * Implementation of a quick sort algorithm for sorting the array of comparable objects in ascending order.
     * The {@code quickInc} method follows the divide-and-conquer strategy of quicksort,
     * recursively partitioning the array into smaller subarrays and sorting them individually.
     * The base case of the recursion is when the subarray has only one element, in which case it is considered already sorted.
     * <ul>
     *     <li>The method {@code quickInc} takes an array of Comparable objects,
     *     along with the indices {@code left} and {@code right} that define the range of the subarray being sorted.</li>
     *     <li>The first condition {@code if (left < right)} checks if the subarray has more than one element.
     *     If it does, the sorting continues; otherwise, the subarray is already sorted, and the method returns.</li>
     *     <li>Inside the condition, the {@code quickInc} method is called to partition the array and obtain the {@code partitionIndex},
     *     which represents the correct position of the pivot element after the partitioning.</li>
     *     <li>The {@code quickInc} method is recursively called twice:</li>
     *     <li>The first recursive call sorts the left partition of the array by calling {@code quickInc}
     *     with left as the start index and {@code (partitionIndex - 1)} as the end index.</li>
     *     <li>The second recursive call sorts the right partition of the array by calling {@code quickInc} with
     *     {@code (partitionIndex + 1)} as the start index and {@code right} as the end index.</li>
     *     <li>This process is repeated until the entire array is sorted.</li>
     * </ul>
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
     *     <li>The first recursive call sorts the left partition of the array by calling {@code quickDec}
     *     with left as the start index and {@code (partitionIndex - 1)} as the end index.</li>
     *     <li>The second recursive call sorts the right partition of the array by calling {@code quickDec} with
     *     {@code (partitionIndex + 1)} as the start index and {@code right} as the end index.</li>
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
     * {@code quick} method takes an array {@code array} of type {@code T}, two integer parameters {@code left} and {@code right},
     * and an instance of {@code SortFunctional<T>} as parameters.
     * <ul>
     *     <li>It starts by checking if the value of {@code left} is less than the value of {@code right}.
     *     This condition ensures that there are at least two elements in the current partition range,
     *     making it necessary to perform a partitioning step.</li>
     *     <li>If the condition is {@code true},
     *     it proceeds to call the {@code partition} method to partition the array within
     *     the specified range using the {@code functional} instance as the comparison logic.
     *     The result of the partitioning step is stored in the {@code partitionIndex} variable.</li>
     *     <li>After the partitioning step, it recursively calls the {@code quick} method to sort the left subarray,
     *     from {@code left} to {@code (partitionIndex - 1)}, using the same {@code functional} instance.</li>
     *     <li>It also recursively calls the {@code quick} method to sort the right subarray,
     *     from {@code (partitionIndex + 1)} to {@code right}, using the same {@code functional} instance.</li>
     *     <li>The recursive calls continue until the base case is reached,
     *     where {@code left} becomes greater than or equal to {@code right}.
     *     At that point, the method returns without performing any further sorting.</li>
     * </ul>
     * {@code quick} method implements the Quicksort algorithm using the partitioning logic defined
     * by the {@code partition} method and the comparison logic defined by the {@code SortFunctional} instance.
     * It recursively divides the array into smaller subarrays,
     * partitions them based on the pivot element, and sorts them independently.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         mz.QuickInterface#partition(Comparable[], int, int, SortFunctional)
     */
    default void quick(T[] array, int left, int right, SortFunctional<T> functional) {
        if (left < right) {
            int partitionIndex = partition(array, left, right, functional);
            quick(array, left, (partitionIndex - 1), functional);
            quick(array, (partitionIndex +1), right, functional);
        }
    }

    /**
     * Provided seems to be an implementation of the partitioning step of the quicksort algorithm.
     * It partitions an array into two parts, one with elements smaller than a pivot and another with elements greater than or equal to the pivot.
     * <ul>
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
     *     <li>{@code i} is incremented by 1 to expand the smaller elements region.</li>
     *     <li>The swap method is called to {@code swap} {@code array[i]} and {@code array[j]}, moving the smaller element to the left.</li>
     *     <li>After the loop, the pivot element is moved to its correct position by swapping it with {@code array[i + 1]}.
     *     This ensures that all elements to the left of {@code array[i + 1]} are smaller than or equal to the pivot,
     *     and all elements to the right are greater than the pivot.</li>
     * </ul>
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
            if (pivot.compareTo(array[j]) > 0) {
                swap(array, ++i, j);
            }
        }
        swap(array, (i + 1), right);
        return (i + 1);
    }

    /**
     * Provided seems to be an implementation of the partitioning step of the quicksort algorithm.
     * It partitions an array into two parts, one with elements smaller than a pivot and another with elements greater than or equal to the pivot.
     * <ul>
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
     *     <li>{@code i} is incremented by 1 to expand the smaller elements region.</li>
     *     <li>The swap method is called to {@code swap} {@code array[i]} and {@code array[j]}, moving the smaller element to the left.</li>
     *     <li>After the loop, the pivot element is moved to its correct position by swapping it with {@code array[i + 1]}.
     *     This ensures that all elements to the left of {@code array[i + 1]} are smaller than or equal to the pivot,
     *     and all elements to the right are greater than the pivot.</li>
     * </ul>
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
            if (pivot.compareTo(array[j]) < 0) {
                swap(array, ++i, j);
            }
        }
        swap(array, (i + 1), right);
        return (i + 1);
    }

    /**
     * {@code partition} method takes an array {@code array} of type {@code T}, two integer parameters {@code left} and {@code right},
     * and an instance of {@code SortFunctional<T>} as parameters.
     * <ul>
     *     <li>It starts by assigning the element at index {@code right} to the variable {@code pivot}.
     *     This element will serve as the pivot for partitioning.</li>
     *     <li>It initializes the variable {@code i} to {@code (left - 1)}.
     *     This variable will keep track of the boundary between elements less than
     *     the pivot and elements greater than or equal to the pivot.</li>
     *     <li>It enters a {@code for} loop that iterates from {@code left} to {@code (right - 1)}.
     *     This loop examines each element within the partition range.</li>
     *     <li>Within the loop, it checks if the pivot element is considered greater than
     *     the element at index {@code j} according to the comparison logic defined by the {@code functional} instance.
     *     If so, it swaps the element at index {@code j} with the element at index {@code ++i}.
     *     This ensures that elements less than the pivot are moved to the left side of the partition.</li>
     *     <li>After the loop completes, it performs a final swap between
     *     the pivot element at index {@code right} and the element at index {@code (i + 1)}.
     *     This places the pivot element in its correct sorted position.</li>
     *     <li>Finally, it returns the index {@code (i + 1)} which represents
     *     the position of the pivot element in the sorted array.</li>
     * </ul>
     * {@code partition} this method is to partition the array within the specified range using a single pivot element ({@code pivot})
     * and the comparison logic defined by the {@code SortFunctional} instance.
     * It rearranges the elements within the partition range such that all elements less than
     * the pivot are placed to the left and all elements greater than or equal to the pivot are placed to the right.
     * The method returns the index of the pivot element in its final sorted position.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @return      the index of the pivot element.
     */
    default int partition(T[] array, int left, int right, SortFunctional<T> functional) {
        T pivot = array[right];
        int i = (left - 1);
        for (int j = left; j <= (right - 1); j++) {
            if (functional.functionalCompareTo(pivot, array[j])) {
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
     *     the element is swapped with the element at {@code newLeft}, and {@code newLeft} is incremented by 1.</li>
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
        T pivot1 = array[left], pivot2 = array[right];
        while(selectIndex <= newRight) {
            if(pivot1.compareTo(array[selectIndex]) > 0) {
                swap(array, selectIndex, newLeft++);
            } else if (array[selectIndex].compareTo(pivot2) >= 0) {
                while ((array[newRight].compareTo(pivot2) > 0) && (selectIndex < newRight)) {
                    newRight--;
                }
                swap(array, selectIndex, newRight--);
                if (pivot1.compareTo(array[selectIndex]) > 0) {
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
     *     the element is swapped with the element at {@code newLeft}, and {@code newLeft} is incremented by 1.</li>
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
        T pivot1 = array[left], pivot2 = array[right];
        while(selectIndex <= newRight) {
            if(pivot1.compareTo(array[selectIndex]) < 0) {
                swap(array, selectIndex, newLeft++);
            } else if (array[selectIndex].compareTo(pivot2) <= 0) {
                while ((array[newRight].compareTo(pivot2) < 0) && (selectIndex < newRight)) {
                    newRight--;
                }
                swap(array, selectIndex, newRight--);
                if (pivot1.compareTo(array[selectIndex]) < 0) {
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
     * {@code partitionDual} method takes an array {@code array} of type {@code T},
     * two integer parameters {@code left} and {@code right},
     * and an instance of {@code SortFunctional<T>} as parameters.
     * <ul>
     *     <li>It starts by checking if the element at index {@code left} is considered greater than
     *     the element at index {@code right} according to the comparison logic defined by the {@code functional} instance.
     *     If so, it swaps the elements at indices {@code left} and {@code right}.</li>
     *     <li>It initializes the variables {@code newLeft} and {@code newRight} to {@code (left + 1)} and {@code (right - 1)} respectively.
     *     These variables represent the boundaries of the partition.</li>
     *     <li>It initializes the variable {@code selectIndex} to {@code (left + 1)},
     *     which represents the current index being examined.</li>
     *     <li>It assigns the elements at indices {@code left} and {@code right} to the variables {@code pivot1} and {@code pivot2} respectively.
     *     These variables hold the pivot elements for partitioning.</li>
     *     <li>It initializes a {@code functionalAddEquals} instance using the {@code functionalComparableToAddEquals} method,
     *     passing the {@code functional} instance as a parameter.</li>
     *     <li>It enters a {@code while} loop that continues as long as {@code selectIndex} is less than or equal to {@code newRight}.
     *     This loop iterates over the array elements within the partition range.</li>
     *     <li>Within the loop, it checks if the element at index {@code selectIndex} is considered greater
     *     than {@code pivot1} according to the comparison logic defined by the {@code functional} instance.
     *     If so, it swaps the element with the element at index {@code newLeft} and increments {@code newLeft} by <i>1</i>.</li>
     *     <li>If the element at index {@code selectIndex} is considered equal to {@code pivot2} according to
     *     the comparison logic defined by the {@code functionalAddEquals} instance, it enters an inner {@code while} loop.
     *     This loop searches for the next element from the right that is not considered greater than {@code pivot2}.
     *     It decrements {@code newRight} until it finds such an element or until {@code selectIndex} becomes greater than {@code newRight}.</li>
     *     <li>Once the inner {@code while} loop exits,
     *     it swaps the element at index {@code selectIndex} with the element at index {@code newRight} and decrements {@code newRight} by <i>1</i>.
     *     After the swap, if the element at index {@code selectIndex} is considered greater than {@code pivot1} according to the {@code functional} instance,
     *     it swaps the element with the element at index {@code newLeft} and increments {@code newLeft} by <i>1</i>.</li>
     *     <li>After the necessary swaps and comparisons,
     *     it increments {@code selectIndex} by <i>1</i> to move to the next element in the partition range.</li>
     *     <li>Once the loop completes, it performs final swaps to place the pivot elements in their correct positions.
     *     It swaps the element at index {@code left} with the element at index {@code (newLeft - 1)}
     *     and the element at index {@code right} with the element at index {@code (newRight + 1)}.</li>
     *     <li>Finally, it returns an integer array containing {@code newLeft} and {@code newRight}.</li>
     * </ul>
     * {@code partitionDual} this method is to partition the array within the specified range based on two pivot elements ({@code pivot1} and {@code pivot2})
     * using the comparison logic defined by the {@code SortFunctional} instance.
     * It employs a dual-pivot partitioning scheme similar to the one used in Dual-Pivot Quicksort.
     * The elements are rearranged within the partition range such that all elements less than {@code pivot1} are placed to the left,
     * elements equal to or between {@code pivot1} and {@code pivot2} are placed in the middle, and elements greater than {@code pivot2} are placed to the right.
     * The method returns the indices marking the boundaries of the middle section.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @return      the pivots in the partitioned array.
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         mz.Sort#functionalComparableToAddEquals(SortFunctional)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    default int[] partitionDual(T[] array, int left, int right, SortFunctional<T> functional) {
        if (functional.functionalCompareTo(array[left], array[right])) {
            swap(array, left, right);
        }
        int newLeft = (left + 1), newRight = (right - 1), selectIndex = (left + 1);
        T pivot1 = array[left], pivot2 = array[right];
        SortFunctional<T> functionalAddEquals = functionalComparableToAddEquals(functional);
        while(selectIndex <= newRight) {
            if(functional.functionalCompareTo(pivot1, array[selectIndex])) {
                swap(array, selectIndex, newLeft++);
            } else if (functionalAddEquals.functionalCompareTo(array[selectIndex], pivot2)) {
                while ((functional.functionalCompareTo(array[newRight], pivot2)) && (selectIndex < newRight)) {
                    newRight--;
                }
                swap(array, selectIndex, newRight--);
                if (functional.functionalCompareTo(pivot1, array[selectIndex])) {
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