package mz;

/**
 * HeapInterface, containing the methods of Heap Sort to implement other classes.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.1
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
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
     * {@code heap} within an interface.
     * This method takes an array of type {@code T[]},
     * and an instance of the {@code SortFunctional} interface as parameters.
     * <ul>
     *     <li>The first for loop initializes a variable {@code i} to {@code ((array.length / 2) - 1)}</li>
     *     <li>Within each iteration, it calls the {@code heapify} method to rearrange the elements in
     *     the {@code array} and maintain the heap property starting from index {@code i}.</li>
     *     <li>This first loop ensures that the entire array is transformed into a valid heap structure.</li>
     *     <li>The second {@code for} loop initializes a variable {@code i} to {@code (n - 1)}
     *     and iterates backwards from {@code i} to <i>0</i>.</li>
     *     <li>Within each iteration, it calls the {@code swap} method to swap the elements at indices <i>0</i> and {@code i} in the array.
     *     This places the largest element (root of the heap) at index <i>0</i> and
     *     the next largest element at the end of the range.</li>
     *     <li>After the swap, it calls the {@code heapify} method to maintain
     *     the heap property within the reduced range <i>0</i> from to {@code i}.</li>
     *     <li>The loop continues until the entire range is sorted.</li>
     * </ul>
     * {@code heap} method implements the heap sort algorithm to sort a portion of the array
     * (from index <i>0</i> to index {@code array.length})
     * in ascending order based on the comparison condition provided
     * by the {@code functionalCompareTo} method of the {@code SortFunctional} interface.
     * It transforms the array into a heap structure, swaps the largest element to the beginning of the range,
     * and recursively maintains the heap property while reducing the range until the entire range is sorted.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.HeapInterface#heapify(Comparable[], int, int, SortFunctional)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    default void heap(T[] array, SortFunctional<T> functional) {
        int n = array.length;
        for (int i = ((n / 2) - 1); i >= 0; i--) {
            heapify(array, n, i, functional);
        }
        for (int i = (n - 1); i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0, functional);
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
     * {@code heap} within an interface.
     * This method takes an array of type {@code T[]},
     * an integer {@code from} representing the starting index,
     * an integer {@code to} representing the ending index,
     * and an instance of the {@code SortFunctional} interface as parameters.
     * <ul>
     *     <li>The first for loop initializes a variable {@code i} to {@code ((to / 2) - 1)}
     *     and iterates backwards from {@code i} to {@code from}.</li>
     *     <li>Within each iteration, it calls the {@code heapify} method to rearrange the elements in
     *     the {@code array} and maintain the heap property starting from index {@code i}.</li>
     *     <li>This first loop ensures that the entire array is transformed into a valid heap structure.</li>
     *     <li>The second {@code for} loop initializes a variable {@code i} to {@code (to - 1)}
     *     and iterates backwards from {@code i} to {@code (from + 1)}.</li>
     *     <li>Within each iteration, it calls the {@code swap} method to swap the elements at indices {@code from} and {@code i} in the array.
     *     This places the largest element (root of the heap) at index {@code from} and
     *     the next largest element at the end of the range.</li>
     *     <li>After the swap, it calls the {@code heapify} method to maintain
     *     the heap property within the reduced range {@code from} from to {@code i}.</li>
     *     <li>The loop continues until the entire range is sorted.</li>
     * </ul>
     * {@code heap} method implements the heap sort algorithm to sort a portion of the array (from index {@code from} to index {@code to})
     * in ascending order based on the comparison condition provided
     * by the {@code functionalCompareTo} method of the {@code SortFunctional} interface.
     * It transforms the array into a heap structure, swaps the largest element to the beginning of the range,
     * and recursively maintains the heap property while reducing the range until the entire range is sorted.
     * @param       array to be arranged.
     * @param       from the element from which to start the analysis.
     * @param       to the element to be analyzed.
     * @param       functional lambda expression for comparison.
     * @see         mz.HeapInterface#heapify(Comparable[], int, int, SortFunctional)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    default void heap(T[] array, int from, int to, SortFunctional<T> functional) {
        for (int i = ((to / 2) - 1); i >= from; i--) {
            heapify(array, to, i, functional);
        }
        for (int i = (to - 1); i > from; i--) {
            swap(array, from, i);
            heapify(array, i, from, functional);
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
     * {@code heapify} within an interface.
     * This method takes an array of type {@code T[]},
     * an integer {@code n}, an integer {@code i},
     * and an instance of the {@code SortFunctional} interface as parameters.
     * <ul>
     *     <li>It calls the {@code heapSplit} method to find the index of
     *     the largest child node of the current parent node at index {@code i}.</li>
     *     <li>If the {@code largest} index is not equal to {@code i}, it means that
     *     the parent node is smaller than one of its child nodes and violates the heap property.</li>
     *     <li>In this case, the method calls the {@code swap} method
     *     to swap the elements at indices {@code i} and {@code largest} in the {@code array}.
     *     This ensures that the largest child node becomes the new parent node.</li>
     *     <li>After the swap, the method calls itself recursively on the new parent node index {@code largest}.
     *     This is done to propagate the violation upwards and ensure that the heap property is maintained throughout the entire heap.</li>
     *     <li>The recursive calls continue until the entire heap is rearranged correctly.</li>
     * </ul>
     * {@code heapify} method is responsible for rearranging elements in the {@code array}
     * to maintain the heap property based on the comparison condition provided
     * by the {@code functionalCompareTo} method of the {@code SortFunctional} interface.
     * It performs swaps and recursive calls to fix violations in the heap structure.
     * @param       array to be arranged.
     * @param       n of the array.
     * @param       i the current element
     * @param       functional lambda expression for comparison.
     * @see         mz.HeapInterface#heapSplit(Comparable[], int, int, SortFunctional)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    default void heapify(T[] array, int n, int i, SortFunctional<T> functional) {
        int largest = heapSplit(array, n, i, functional);
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest, functional);
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
        int left = ((2 * i) + 1), right = ((2 * i) + 2), largest = heapChildInc(array, n, i, left);
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
        int left = ((2 * i) + 1), right = ((2 * i) + 2), largest = heapChildDec(array, n, i, left);
        largest = heapChildDec(array, n, largest, right);
        return largest;
    }

    /**
     * {@code heapSplit} within an interface.
     * This method takes an array of type {@code T[]},
     * an integer {@code n}, an integer {@code i}, and an instance of
     * the {@code SortFunctional} interface as parameters. It returns an integer value.
     * <ul>
     *     <li>It calculates the indices of the left child node and
     *     the right child node using the formula {@code ((2 * i) + 1)} and {@code ((2 * i) + 2)} respectively.</li>
     *     <li>It calls the {@code heapChild} method twice to compare the left child and the right child with the current {@code i} index,
     *     and it initializes the {@code largest} variable with the index of the child that is smaller based on
     *     the comparison condition provided by the {@code functionalCompareTo} method.</li>
     *     <li>Finally, it returns the value of {@code largest}, which represents the index of the largest child node.</li>
     * </ul>
     * {@code heapSplit} method is responsible for comparing two child nodes of a parent node in the {@code array} based on
     * the comparison condition provided by the {@code functionalCompareTo} method of the {@code SortFunctional} interface.
     * It returns the index of the largest child node, which is useful for maintaining
     * the heap property in heap-based algorithms or data structures.
     * @param       array to be arranged.
     * @param       n of the array.
     * @param       i the current element
     * @param       functional lambda expression for comparison.
     * @return      the value of {@code largest}
     * @see         mz.HeapInterface#heapChild(Comparable[], int, int, int, SortFunctional)
     */
    default int heapSplit(T[] array, int n, int i, SortFunctional<T> functional) {
        int left = ((2 * i) + 1), right = ((2 * i) + 2), largest = heapChild(array, n, i, left, functional);
        largest = heapChild(array, n, largest, right, functional);
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
        if ((child < n) && (array[child].compareTo(array[result]) > 0)) {
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
        if ((child < n) && (array[child].compareTo(array[result]) < 0)) {
            result = child;
        }
        return result;
    }

    /**
     * {@code heapChild} within an interface. This method takes an array of type {@code T[]},
     * an integer {@code n}, an integer {@code result}, an integer {@code child},
     * and an instance of the {@code SortFunctional} interface as parameters.
     * It returns an integer value.
     * <ul>
     *     <li>It first checks if the {@code child} index is less than {@code n} (the size of the array)
     *     and if the comparison condition in {@code functionalCompareTo}
     *     is satisfied between {@code array[child]} and {@code array[result]}.</li>
     *     <li>If the condition is {@code true},
     *     it updates the result variable with the value of {@code child}.</li>
     *     <li>Finally, it returns the value of {@code result}.</li>
     * </ul>
     * {@code heapChild} method is responsible for comparing two elements in the {@code array} based on
     * the comparison condition provided by the {@code functionalCompareTo} method of the {@code SortFunctional} interface.
     * It returns the index of the smaller child node, which is useful for maintaining the heap property
     * in heap-based algorithms such as heap sort or heap-based data structures.
     * @param       array to be arranged.
     * @param       n of the array.
     * @param       result the current result value.
     * @param       child the index of the child element to compare.
     * @param       functional lambda expression for comparison.
     * @return      the updated {@code result} value.
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default int heapChild(T[] array, int n, int result, int child, SortFunctional<T> functional) {
        if ((child < n) && (functional.functionalCompareTo(array[child], array[result]))) {
            result = child;
        }
        return result;
    }
}