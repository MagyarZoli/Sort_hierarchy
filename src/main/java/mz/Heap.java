package mz;

/**
 * Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure to sort elements.
 * It works by constructing a heap from the input array and repeatedly extracting
 * the maximum (or minimum) element from the heap and placing it at the end of the sorted portion of the array.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 * @see         mz.WeakHeap
 * @see         mz.TernaryHeap
 */
public class Heap
extends Insertion
implements SortSwap<Comparable> {

    /**
     * <b>Heap Sort:</b><br>
     * Is a comparison-based sorting algorithm that uses a binary heap data structure to sort elements.
     * It works by constructing a heap from the input array and repeatedly extracting
     * the maximum (or minimum) element from the heap and placing it at the end of the sorted portion of the array.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Build a binary heap from the input array. This is done by starting with the last parent node in the array
     *     and repeatedly {@code heapify} the array to satisfy the heap property.</li>
     *     <ul>
     *         <li>{@code heapify} is a process where the element at index i is compared with its children, and if necessary,
     *         swapped to maintain the heap property (max-heap or min-heap).</li>
     *         <li>This process is performed for all parent nodes, starting from the last parent down to the root.</li>
     *     </ul>
     *     <li>Once the binary heap is constructed, repeatedly extract the maximum (or minimum)
     *     element from the heap and place it at the end of the array.</li>
     *     <ul>
     *         <li>Swap the root element (which is the maximum or minimum element depending on whether it's a max-heap or min-heap)
     *         with the last element of the heap.</li>
     *         <li>Reduce the size of the heap by one.</li>
     *         <li>Perform {@code heapify} on the root to restore the heap property.</li>
     *     </ul>
     *     <li>Repeat step 2 until all elements have been extracted from the heap. The extracted elements will be in the reverse order for
     *     a max-heap (sorted in ascending order) or in the correct order for a min-heap (sorted in descending order).</li>
     * </ol>
     * <b>Note:</b><br>
     * Heap Sort has a time complexity of <em>O(n log n)</em> in the average and worst cases, where <em>n</em> is the number of elements in the array.
     * It is considered an efficient sorting algorithm and is particularly useful when a stable sort is not required.
     * However, Heap Sort has a higher constant factor compared to some other sorting algorithms.<br><br>
     * Heap Sort is an in-place sorting algorithm, meaning it requires only a constant amount of additional memory beyond the original array.
     * It is commonly used in situations where an in-place sorting algorithm is needed, or when the input data is too large to fit into the main memory.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n log(n))</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>No</b>
     * @see         mz.WeakHeap#WeakHeap()
     * @see         mz.TernaryHeap#TernaryHeap()
     */
    public Heap() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         mz.Heap#heapInc(Comparable[])
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        heapInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         mz.Heap#heapDec(Comparable[])
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        heapDec(array);
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
     *     This loop is used to extract elements from the max heap one by one and place them in their correct sorted position at the end of the array.
     *     In each iteration, it swaps the element at index 0 (the root of the max heap) with the element at index i.
     *     It then calls {@code heapifyInc} on the reduced heap (with length {@code i}) and index 0 to restore
     *     the max heap property on the remaining elements.</li>
     *     <li>After both loops complete, the array is sorted in ascending order.</li>
     * </ul>
     * {@code heapInc} method implements the Heap Sort algorithm to sort the given array in ascending order by transforming
     * it into a max heap and repeatedly extracting the maximum element from the heap.
     * @param       array to be arranged.
     */
    void heapInc(Comparable[] array) {
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
     */
    void heapDec(Comparable[] array) {
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
     * {@code heapifyInc}. This method is likely a part of a heap-related algorithm or data structure implementation.
     * It takes an {@code array} of Comparable objects, the {@code length} of the array, and an index {@code i} as parameters.
     * The purpose of this method is to rearrange the elements in the array in a way that satisfies the properties of a max heap,
     * with the largest element at the root.
     * <ul>
     *     <li>The method starts by calling a method named {@code heapSplitInc} with the array, length, and index {@code i} as parameters.
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
     * @param       length of the array.
     * @param       i the current element
     * @see         mz.Heap#heapInc(Comparable[])
     * @see         mz.WeakHeap#heapifyInc(Comparable[], int, int)
     */
    void heapifyInc(Comparable[] array, int length, int i) {
        int largest = heapSplitInc(array, length, i);
        if (largest != i) {
            swap(array, i, largest);
            heapifyInc(array, length, largest);
        }
    }

    /**
     * {@code heapifyDec}. This method is likely a part of a heap-related algorithm or data structure implementation.
     * It takes an {@code array} of Comparable objects, the {@code length} of the array, and an index {@code i} as parameters.
     * The purpose of this method is to rearrange the elements in the array in a way that satisfies the properties of a max heap,
     * with the largest element at the root.
     * <ul>
     *     <li>The method starts by calling a method named {@code heapSplitDec} with the array, length, and index {@code i} as parameters.
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
     * @param       length of the array.
     * @param       i the current element
     * @see         mz.Heap#heapDec(Comparable[])
     * @see         mz.WeakHeap#heapifyDec(Comparable[], int, int)
     */
    void heapifyDec(Comparable[] array, int length, int i) {
        int largest = heapSplitDec(array, length, i);
        if (largest != i) {
            swap(array, i, largest);
            heapifyDec(array, length, largest);
        }
    }

    /**
     * {@code heapSplitInc}. This method is likely a part of a heap-related algorithm or data structure implementation.
     * It takes an array of {@code Comparable} objects, the {@code length} of the array, and an index {@code i} as parameters.
     * The purpose of this method is to find the index of the largest child element among
     * the {@code left} child at index {@code (2 * i + 1)} and
     * the {@code right} child at index {@code (2 * i + 2)} of the current element at index {@code i}.
     * <ul>
     *     <li>The method starts by calculating the indices of the {@code left} and {@code right} child elements of the current element at index {@code i}.
     *     The {@code left} child index is {@code (2 * i + 1)}, and the {@code right} child index is {@code (2 * i + 2)}.</li>
     *     <li>The method then calls a method named {@code heapChildInc} twice. The first call is with
     *     the parameters {@code array}, {@code length}, {@code i}, and {@code left}, and the second call is with
     *     the parameters {@code array}, {@code length}, {@code largest}, and {@code right}.
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
     * @param       length of the array.
     * @param       i the current element
     * @return      the value of {@code largest}
     * @see         mz.Heap#heapifyInc(Comparable[], int, int)
     * @see         mz.TernaryHeap#heapSplitInc(Comparable[], int, int)
     */
    int heapSplitInc(Comparable[] array, int length, int i) {
        int left = ((2 * i) + 1);
        int right = ((2 * i) + 2);
        int largest = heapChildInc(array, length, i, left);
        largest = heapChildInc(array, length, largest, right);
        return largest;
    }

    /**
     * {@code heapSplitDec}. This method is likely a part of a heap-related algorithm or data structure implementation.
     * It takes an array of {@code Comparable} objects, the {@code length} of the array, and an index {@code i} as parameters.
     * The purpose of this method is to find the index of the largest child element among
     * the {@code left} child at index {@code (2 * i + 1)} and
     * the {@code right} child at index {@code (2 * i + 2)} of the current element at index {@code i}.
     * <ul>
     *     <li>The method starts by calculating the indices of the {@code left} and {@code right} child elements of the current element at index {@code i}.
     *     The {@code left} child index is {@code (2 * i + 1)}, and the {@code right} child index is {@code (2 * i + 2)}.</li>
     *     <li>The method then calls a method named {@code heapChildDec} twice. The first call is with
     *     the parameters {@code array}, {@code length}, {@code i}, and {@code left}, and the second call is with
     *     the parameters {@code array}, {@code length}, {@code largest}, and {@code right}.
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
     * @param       length of the array.
     * @param       i the current element
     * @return      the value of {@code largest}
     * @see         mz.Heap#heapifyDec(Comparable[], int, int)
     * @see         mz.TernaryHeap#heapSplitDec(Comparable[], int, int)
     */
    int heapSplitDec(Comparable[] array, int length, int i) {
        int left = ((2 * i) + 1);
        int right = ((2 * i) + 2);
        int largest = heapChildDec(array, length, i, left);
        largest = heapChildDec(array, length, largest, right);
        return largest;
    }

    /**
     * {@code heapChildInc}, which takes an array of Comparable objects, the length of the array, a result value,
     * and a child index as parameters. The method compares the {@code child} element of the array with the element at the {@code result} index,
     * and if the {@code child} element is greater, it updates the {@code result} to the {@code child} index.
     * <ul>
     *     <li>The {@code @SuppressWarnings("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@code compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The {@code if} condition checks if the {@code child} index is within the valid range (less than {@code length})
     *     and if the {@code child} element is greater than the element at the {@code result} index.
     *     If the condition is true, it means the {@code child} element is larger, so the {@code result} is updated to the {@code child} index.</li>
     *     <li>The method returns the updated {@code result} value.</li>
     * </ul>
     * {@code heapChildInc} it compares child elements with the result element and updates the result if a larger child is found.
     * @param       array to be arranged.
     * @param       length of the array.
     * @param       result the current result value.
     * @param       child the index of the child element to compare.
     * @return      the updated {@code result} value
     * @see         mz.Heap#heapSplitInc(Comparable[], int, int)
     * @see         mz.TernaryHeap#heapSplitInc(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    int heapChildInc(Comparable[] array, int length, int result, int child) {
        if (child < length && array[child].compareTo(array[result]) > 0) {
            result = child;
        }
        return result;
    }

    /**
     * {@code heapChildDec}, which takes an array of Comparable objects, the length of the array, a result value,
     * and a child index as parameters. The method compares the {@code child} element of the array with the element at the {@code result} index,
     * and if the {@code child} element is smaller, it updates the {@code result} to the {@code child} index.
     * <ul>
     *     <li>The {@code @SuppressWarnings("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@code compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The {@code if} condition checks if the {@code child} index is within the valid range (less than {@code length})
     *     and if the {@code child} element is smaller than the element at the {@code result} index.
     *     If the condition is true, it means the {@code child} element is small, so the {@code result} is updated to the {@code child} index.</li>
     *     <li>The method returns the updated {@code result} value.</li>
     * </ul>
     * {@code heapChildDec} it compares child elements with the result element and updates the result if a small child is found.
     * @param       array to be arranged.
     * @param       length of the array.
     * @param       result the current result value.
     * @param       child the index of the child element to compare.
     * @return      the updated {@code result} value.
     * @see         mz.Heap#heapSplitDec(Comparable[], int, int)
     * @see         mz.TernaryHeap#heapSplitDec(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    int heapChildDec(Comparable[] array, int length, int result, int child) {
        if (child < length && array[child].compareTo(array[result]) < 0) {
            result = child;
        }
        return result;
    }
}