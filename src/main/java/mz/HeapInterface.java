package mz;

/**
 * HeapInterface, containing the methods of Heap Sort to implement other classes.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public interface HeapInterface<T extends Comparable>
extends Sort<T>, SortSwap<T> {

    /**
     * {@code heapInc}. This method is likely a part of a heap-related algorithm or data structure implementation
     * and is used to sort an array in ascending order using a max heap.
     * <ul>
     *     <li>The method starts by calculating the length of the array and assigning it to the variable {@code n}.</li>
     *     <li>The first {@code for} loop iterates over the indices of the elements in the array from {@code (n / 2 - 1)} down to 0.
     *     This loop is used to build the initial max heap structure in the array.
     *     It calls a method named {@code heapifyInc} with the array, length {@code n}, and the current index {@code i}.
     *     The purpose of this call is to perform the heapification process, ensuring that
     *     the subtree rooted at index {@code i} satisfies the max heap property.</li>
     *     <li>After the first {@code for} loop, the array is transformed into a max heap structure.</li>
     *     <li>The second {@code for} loop starts from {@code (n - 1)} and iterates down to 1.
     *     This loop is used to extract elements from the max heap one by one and place them in their correct sorted position at the end of the array.
     *     In each iteration, it swaps the element at index 0 (the root of the max heap) with the element at index i.
     *     It then calls {@code heapifyInc} on the reduced heap (with length {@code i}) and index 0 to restore
     *     the max heap property on the remaining elements.</li>
     *     <li>After both loops complete, the array is sorted in ascending order.</li>
     * </ul>
     * {@code heapInc} method implements the Heap Sort algorithm to sort the given array in ascending order by transforming
     * it into a max heap and repeatedly extracting the maximum element from the heap.
     * @param       array to be arranged.
     * @see         mz.HeapInterface#heapifyInc(Comparable[], int, int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    default void heapInc(T[] array) {
        int n = array.length;
        for (int i = ((n / 2) - 1); i >= 0; i--) {
            heapifyInc(array, n, i);
        }
        for (int i = (n - 1); i > 0; i--) {
            swap(array, 0, i);
            heapifyInc(array, i, 0);
        }
    }

    /**
     * {@code heapDec}. This method is likely a part of a heap-related algorithm or data structure implementation
     * and is used to sort an array in descending order using a max heap.
     * <ul>
     *     <li>The method starts by calculating the length of the array and assigning it to the variable {@code n}.</li>
     *     <li>The first {@code for} loop iterates over the indices of the elements in the array from {@code (n / 2 - 1)} down to 0.
     *     This loop is used to build the initial max heap structure in the array.
     *     It calls a method named {@code heapifyDec} with the array, length {@code n}, and the current index {@code i}.
     *     The purpose of this call is to perform the heapification process, ensuring that
     *     the subtree rooted at index {@code i} satisfies the max heap property.</li>
     *     <li>After the first {@code for} loop, the array is transformed into a max heap structure.</li>
     *     <li>The second {@code for} loop starts from {@code (n - 1)} and iterates down to 1.
     *     This loop is used to extract elements from the max heap one by one and place them in their correct sorted position at the end of the array.
     *     In each iteration, it swaps the element at index 0 (the root of the max heap) with the element at index i.
     *     It then calls {@code heapifyDec} on the reduced heap (with length {@code i}) and index 0 to restore
     *     the max heap property on the remaining elements.</li>
     *     <li>After both loops complete, the array is sorted in ascending order.</li>
     * </ul>
     * {@code heapDec} method implements the Heap Sort algorithm to sort the given array in descending order by transforming
     * it into a max heap and repeatedly extracting the maximum element from the heap.
     * @param       array to be arranged.
     * @see         mz.HeapInterface#heapifyDec(Comparable[], int, int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    default void heapDec(T[] array) {
        int n = array.length;
        for (int i = ((n / 2) - 1); i >= 0; i--) {
            heapifyDec(array, n, i);
        }
        for (int i = (n - 1); i > 0; i--) {
            swap(array, 0, i);
            heapifyDec(array, i, 0);
        }
    }

    /**
     * {@code heapInc}. This method is likely a part of a heap-related algorithm or data structure implementation
     * and is used to sort an array in ascending order using a max heap.
     * <ul>
     *     <li>The method starts by calculating the length of the array and assigning it to the variable {@code n}.</li>
     *     <li>The first {@code for} loop iterates over the indices of the elements in the array from {@code (n / 2 - 1)} down to 0.
     *     This loop is used to build the initial max heap structure in the array.
     *     It calls a method named {@code heapifyInc} with the array, length {@code n}, and the current index {@code i}.
     *     The purpose of this call is to perform the heapification process, ensuring that
     *     the subtree rooted at index {@code i} satisfies the max heap property.</li>
     *     <li>After the first {@code for} loop, the array is transformed into a max heap structure.</li>
     *     <li>The second {@code for} loop starts from {@code (n - 1)} and iterates down to 1.
     *     This loop is used to extract elements from the max heap one by one and place them in their correct sorted position at the to of the array.
     *     In each iteration, it swaps the element at index 0 (the root of the max heap) with the element at index i.
     *     It then calls {@code heapifyInc} on the reduced heap (with length {@code i}) and index 0 to restore
     *     the max heap property on the remaining elements.</li>
     *     <li>After both loops complete, the array is sorted in ascending order.</li>
     * </ul>
     * {@code heapInc} method implements the Heap Sort algorithm to sort the given array in ascending order by transforming
     * it into a max heap and repeatedly extracting the maximum element from the heap.
     * @param       array to be arranged.
     * @param       from the element from which to start the analysis.
     * @param       to the element to be analyzed.
     * @see         mz.HeapInterface#heapifyInc(Comparable[], int, int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    default void heapInc(T[] array, int from, int to) {
        for (int i = ((to / 2) - 1); i >= from; i--) {
            heapifyInc(array, to, i);
        }
        for (int i = (to - 1); i > from; i--) {
            swap(array, from, i);
            heapifyInc(array, i, from);
        }
    }

    /**
     * {@code heapDec}. This method is likely a part of a heap-related algorithm or data structure implementation
     * and is used to sort an array in descending order using a max heap.
     * <ul>
     *     <li>The method starts by calculating the length of the array and assigning it to the variable {@code n}.</li>
     *     <li>The first {@code for} loop iterates over the indices of the elements in the array from {@code (n / 2 - 1)} down to 0.
     *     This loop is used to build the initial max heap structure in the array.
     *     It calls a method named {@code heapifyDec} with the array, length {@code n}, and the current index {@code i}.
     *     The purpose of this call is to perform the heapification process, ensuring that
     *     the subtree rooted at index {@code i} satisfies the max heap property.</li>
     *     <li>After the first {@code for} loop, the array is transformed into a max heap structure.</li>
     *     <li>The second {@code for} loop starts from {@code (n - 1)} and iterates down to 1.
     *     This loop is used to extract elements from the max heap one by one and place them in their correct sorted position at the end of the array.
     *     In each iteration, it swaps the element at index 0 (the root of the max heap) with the element at index i.
     *     It then calls {@code heapifyDec} on the reduced heap (with length {@code i}) and index 0 to restore
     *     the max heap property on the remaining elements.</li>
     *     <li>After both loops complete, the array is sorted in ascending order.</li>
     * </ul>
     * {@code heapDec} method implements the Heap Sort algorithm to sort the given array in descending order by transforming
     * it into a max heap and repeatedly extracting the maximum element from the heap.
     * @param       array to be arranged.
     * @param       from the element from which to start the analysis.
     * @param       to the element to be analyzed.
     * @see         mz.HeapInterface#heapifyInc(Comparable[], int, int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    default void heapDec(T[] array, int from, int to) {
        for (int i = ((to / 2) - 1); i >= from; i--) {
            heapifyDec(array, to, i);
        }
        for (int i = (to - 1); i > from; i--) {
            swap(array, from, i);
            heapifyDec(array, i, from);
        }
    }

    /**
     * {@code heapifyInc}. This method is likely a part of a heap-related algorithm or data structure implementation.
     * It takes an {@code array} of Comparable objects, the {@code n} of the array, and an index {@code i} as parameters.
     * The purpose of this method is to rearrange the elements in the array in a way that satisfies the properties of a max heap,
     * with the largest element at the root.
     * <ul>
     *     <li>The method starts by calling a method named {@code heapSplitInc} with the array, n, and index {@code i} as parameters.
     *     but it likely performs a split or comparison operation within the heap structure and returns
     *     the index of the largest element among the current element {@code i} and its child elements.</li>
     *     <li>If the {@code largest} value returned from {@code heapSplitInc} is different from the original index {@code i},
     *     it means that the element at index {@code i} is not the largest among its child elements.
     *     In this case, the method proceeds to swap the element at index {@code i} with
     *     the element at index {@code largest} using a {@code swap} method.</li>
     *     <li>After the swap, the method recursively calls itself with the updated index largest.
     *     This recursive call is performed to continue the heapification process downward from the new index largest.
     *     By recursively calling {@code heapifyInc} on the updated index, the method ensures that the heap property
     *     is maintained throughout the entire heap structure.</li>
     * </ul>
     * {@code heapifyInc} method is used to transform an array into a max heap by recursively rearranging
     * the elements based on their values and their relationships with their child elements.
     * @param       array to be arranged.
     * @param       n of the array.
     * @param       i the current element
     * @see         mz.HeapInterface#heapSplitInc(Comparable[], int, int)
     * @see         mz.HeapInterface#heapifyInc(Comparable[], int, int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    default void heapifyInc(T[] array, int n, int i) {
        int largest = heapSplitInc(array, n, i);
        if (largest != i) {
            swap(array, i, largest);
            heapifyInc(array, n, largest);
        }
    }

    /**
     * {@code heapifyDec}. This method is likely a part of a heap-related algorithm or data structure implementation.
     * It takes an {@code array} of Comparable objects, the {@code n} of the array, and an index {@code i} as parameters.
     * The purpose of this method is to rearrange the elements in the array in a way that satisfies the properties of a max heap,
     * with the largest element at the root.
     * <ul>
     *     <li>The method starts by calling a method named {@code heapSplitDec} with the array, n, and index {@code i} as parameters.
     *     but it likely performs a split or comparison operation within the heap structure and returns
     *     the index of the largest element among the current element {@code i} and its child elements.</li>
     *     <li>If the {@code largest} value returned from {@code heapSplitDec} is different from the original index {@code i},
     *     it means that the element at index {@code i} is not the largest among its child elements.
     *     In this case, the method proceeds to swap the element at index {@code i} with
     *     the element at index {@code largest} using a {@code swap} method.</li>
     *     <li>After the swap, the method recursively calls itself with the updated index largest.
     *     This recursive call is performed to continue the heapification process downward from the new index largest.
     *     By recursively calling {@code heapifyDec} on the updated index, the method ensures that the heap property
     *     is maintained throughout the entire heap structure.</li>
     * </ul>
     * {@code heapifyDec} method is used to transform an array into a max heap by recursively rearranging
     * the elements based on their values and their relationships with their child elements.
     * @param       array to be arranged.
     * @param       n of the array.
     * @param       i the current element
     * @see         mz.HeapInterface#heapSplitDec(Comparable[], int, int)
     * @see         mz.HeapInterface#heapifyDec(Comparable[], int, int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    default void heapifyDec(T[] array, int n, int i) {
        int largest = heapSplitDec(array, n, i);
        if (largest != i) {
            swap(array, i, largest);
            heapifyDec(array, n, largest);
        }
    }

    /**
     * {@code heapSplitInc}. This method is likely a part of a heap-related algorithm or data structure implementation.
     * It takes an array of {@code Comparable} objects, the {@code n} of the array, and an index {@code i} as parameters.
     * The purpose of this method is to find the index of the largest child element among
     * the {@code left} child at index {@code (2 * i + 1)} and
     * the {@code right} child at index {@code (2 * i + 2)} of the current element at index {@code i}.
     * <ul>
     *     <li>The method starts by calculating the indices of the {@code left} and {@code right} child elements of the current element at index {@code i}.
     *     The {@code left} child index is {@code (2 * i + 1)}, and the {@code right} child index is {@code (2 * i + 2)}.</li>
     *     <li>The method then calls a method named {@code heapChildInc} twice. The first call is with
     *     the parameters {@code array}, {@code n}, {@code i}, and {@code left}, and the second call is with
     *     the parameters {@code array}, {@code n}, {@code largest}, and {@code right}.
     *     The purpose of the {@code heapChildInc} method, compares the elements at the provided indices and returns the index of the larger element.</li>
     *     <li>The returned values from the {@code heapChildInc} method calls are assigned to the variable {@code largest}.
     *     Since the second call to {@code heapChildInc} is performed using the updated value of {@code largest},
     *     it means that the method is finding the largest among the three elements:
     *     the element at index {@code i}, the {@code left} child element, and the {@code right} child element.</li>
     *     <li>Finally, the method returns the value of {@code largest}, which represents the index of
     *     the largest child element among the left and right children of the element at index {@code i}.</li>
     * </ul>
     * {@code heapSplitInc} method is used to find the index of the largest child element among
     * the {@code left} and {@code right} children of a given element in a heap structure.
     * @param       array to be arranged.
     * @param       n of the array.
     * @param       i the current element
     * @return      the value of {@code largest}
     * @see         mz.HeapInterface#heapChildInc(Comparable[], int, int, int)
     */
    default int heapSplitInc(T[] array, int n, int i) {
        int left = ((2 * i) + 1);
        int right = ((2 * i) + 2);
        int largest = heapChildInc(array, n, i, left);
        largest = heapChildInc(array, n, largest, right);
        return largest;
    }

    /**
     * {@code heapSplitDec}. This method is likely a part of a heap-related algorithm or data structure implementation.
     * It takes an array of {@code Comparable} objects, the {@code n} of the array, and an index {@code i} as parameters.
     * The purpose of this method is to find the index of the largest child element among
     * the {@code left} child at index {@code (2 * i + 1)} and
     * the {@code right} child at index {@code (2 * i + 2)} of the current element at index {@code i}.
     * <ul>
     *     <li>The method starts by calculating the indices of the {@code left} and {@code right} child elements of the current element at index {@code i}.
     *     The {@code left} child index is {@code (2 * i + 1)}, and the {@code right} child index is {@code (2 * i + 2)}.</li>
     *     <li>The method then calls a method named {@code heapChildDec} twice. The first call is with
     *     the parameters {@code array}, {@code n}, {@code i}, and {@code left}, and the second call is with
     *     the parameters {@code array}, {@code n}, {@code largest}, and {@code right}.
     *     The purpose of the {@code heapChildDec} method, compares the elements at the provided indices and returns the index of the larger element.</li>
     *     <li>The returned values from the {@code heapChildDec} method calls are assigned to the variable {@code largest}.
     *     Since the second call to {@code heapChildDec} is performed using the updated value of {@code largest},
     *     it means that the method is finding the largest among the three elements:
     *     the element at index {@code i}, the {@code left} child element, and the {@code right} child element.</li>
     *     <li>Finally, the method returns the value of {@code largest}, which represents the index of
     *     the largest child element among the left and right children of the element at index {@code i}.</li>
     * </ul>
     * {@code heapSplitDec} method is used to find the index of the largest child element among
     * the {@code left} and {@code right} children of a given element in a heap structure.
     * @param       array to be arranged.
     * @param       n of the array.
     * @param       i the current element
     * @return      the value of {@code largest}
     * @see         mz.HeapInterface#heapChildDec(Comparable[], int, int, int)
     */
    default int heapSplitDec(T[] array, int n, int i) {
        int left = ((2 * i) + 1), right = ((2 * i) + 2);
        int largest = heapChildDec(array, n, i, left);
        largest = heapChildDec(array, n, largest, right);
        return largest;
    }

    /**
     * {@code heapChildInc}, which takes an array of Comparable objects, the n of the array, a result value,
     * and a child index as parameters. The method compares the {@code child} element of the array with the element at the {@code result} index,
     * and if the {@code child} element is greater, it updates the {@code result} to the {@code child} index.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The {@code if} condition checks if the {@code child} index is within the valid range (less than {@code n})
     *     and if the {@code child} element is greater than the element at the {@code result} index.
     *     If the condition is true, it means the {@code child} element is larger, so the {@code result} is updated to the {@code child} index.</li>
     *     <li>The method returns the updated {@code result} value.</li>
     * </ul>
     * {@code heapChildInc} it compares child elements with the result element and updates the result if a larger child is found.
     * @param       array to be arranged.
     * @param       n of the array.
     * @param       result the current result value.
     * @param       child the index of the child element to compare.
     * @return      the updated {@code result} value
     */
    @SuppressWarnings("unchecked")
    default int heapChildInc(T[] array, int n, int result, int child) {
        if (child < n && array[child].compareTo(array[result]) > 0) {
            result = child;
        }
        return result;
    }

    /**
     * {@code heapChildDec}, which takes an array of Comparable objects, the n of the array, a result value,
     * and a child index as parameters. The method compares the {@code child} element of the array with the element at the {@code result} index,
     * and if the {@code child} element is smaller, it updates the {@code result} to the {@code child} index.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The {@code if} condition checks if the {@code child} index is within the valid range (less than {@code n})
     *     and if the {@code child} element is smaller than the element at the {@code result} index.
     *     If the condition is true, it means the {@code child} element is small, so the {@code result} is updated to the {@code child} index.</li>
     *     <li>The method returns the updated {@code result} value.</li>
     * </ul>
     * {@code heapChildDec} it compares child elements with the result element and updates the result if a small child is found.
     * @param       array to be arranged.
     * @param       n of the array.
     * @param       result the current result value.
     * @param       child the index of the child element to compare.
     * @return      the updated {@code result} value.
     */
    @SuppressWarnings("unchecked")
    default int heapChildDec(T[] array, int n, int result, int child) {
        if (child < n && array[child].compareTo(array[result]) < 0) {
            result = child;
        }
        return result;
    }
}