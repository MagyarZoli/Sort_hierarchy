package mz;

/**
 * Ternary Heap Sort which uses a ternary heap instead of a binary heap; that is, each element in the heap has three children.
 * Ternary Heap Sort is somewhat more complicated to program, but it is potentially faster.
 * Each step in the sift operation of a ternary heap requires three comparisons and one swap,
 * whereas in a binary heap two comparisons and one swap are required.
 * The ternary heap can do two steps in less time than the binary heap requires for three steps.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class TernaryHeap
extends Heap {

    /**
     * <b>Ternary Heap Sort:</b><br>
     * Which uses a ternary heap instead of a binary heap; that is, each element in the heap has three children.
     * Ternary Heap Sort is somewhat more complicated to program, but it is potentially faster.
     * Each step in the sift operation of a ternary heap requires three comparisons and one swap,
     * whereas in a binary heap two comparisons and one swap are required.
     * The ternary heap can do two steps in less time than the binary heap requires for three steps.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Build a binary heap from the input array. This is done by starting with the last parent node in the array
     *     and repeatedly {@code heapify} the array to satisfy the heap property.</li>
     *     <li>{@code heapify} is a process where the element at index i is compared with its children, and if necessary,
     *     swapped to maintain the heap property (max-heap or min-heap).</li>
     *     <li>This process is performed for all parent nodes, starting from the last parent down to the root.</li>
     *     <li>Once the binary heap is constructed, repeatedly extract the maximum (or minimum)
     *     element from the heap and place it at the end of the array.</li>
     *     <li>Swap the root element (which is the maximum or minimum element depending on whether it's a max-heap or min-heap)
     *     with the last element of the heap.</li>
     *     <li>Reduce the size of the heap by one.</li>
     *     <li>Perform {@code heapify} on the root to restore the heap property.</li>
     *     <li>Repeat step 2 until all elements have been extracted from the heap. The extracted elements will be in the reverse order for
     *     a max-heap (sorted in ascending order) or in the correct order for a min-heap (sorted in descending order).</li>
     * </ol>
     * <b>Note:</b><br>
     * Thus, because of the <em>O(n log(n))</em> upper bound on heapsort's running time and constant upper bound on its auxiliary storage,
     * embedded systems with real-time constraints or systems concerned with security often use heapsort.
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n log(n))</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>No</b>
     * @see         mz.intro.IntroTernaryHeap#IntroTernaryHeap() IntroTernaryHeap
     */
    public TernaryHeap() {}

    /**
     * {@code heapSplitInc}. This method is likely a part of a heap-related algorithm or data structure implementation
     * and is used to find the index of the largest child element among the {@code left}, {@code mid}, and {@code right} children of
     * the current element at index {@code i}. The method takes an array of Comparable objects,
     * the length of the array, and an index {@code i} as parameters.
     * <ul>
     *     <li>The method calculates the indices of the {@code left}, {@code mid}, and {@code right} child elements of the current element index {@code i}.
     *     The {@code left} child index is {@code (3 * i + 1)},
     *     the {@code middle} child index is {@code (3 * i + 2)}, and
     *     the {@code right} child index is {@code (3 * i + 3)}.</li>
     *     <li>The method then calls the heapChildInc method three times.
     *     The first call compares the current element with the {@code left} child,
     *     the second call compares the current element with the {@code mid} child,
     *     and the third call compares the current element with the {@code right} child.
     *     The {@code heapChildInc} method compares the elements at the provided indices
     *     and returns the index of the {@code larger} element.</li>
     *     <li>The returned values from the {@code heapChildInc} method calls are assigned to the variable {@code largest}.
     *     Since each call updates {@code largest} based on the comparison result,
     *     the final value of largest represents the index of the {@code largest} child element among
     *     the {@code left}, {@code mid}, and {@code right} children.</li>
     *     <li>Finally, the method returns the value of {@code largest}, which is the index of the largest child element among
     *     the three children of the element at index {@code i}.</li>
     * </ul>
     * {@code heapSplitInc} method is used to find the index of the largest child element among
     * the {@code left}, {@code mid}, and {@code right} children of a given element in a heap structure.
     * @param       array to be arranged.
     * @param       n of the array.
     * @param       i the current element
     * @return      the value of {@code largest}
     * @see         mz.HeapInterface#heapSplitInc(Comparable[], int, int)
     * @see         mz.HeapInterface#heapChildInc(Comparable[], int, int, int)
     */
    @Override
    public int heapSplitInc(Comparable[] array, int n, int i) {
        int left = ((3 * i) + 1), mid = ((3 * i) + 2), right = ((3 * i) + 3);
        int largest = heapChildInc(array, n, i, left);
        largest = heapChildInc(array, n, largest, mid);
        largest = heapChildInc(array, n, largest, right);
        return largest;
    }

    /**
     * {@code heapSplitDec}. This method is likely a part of a heap-related algorithm or data structure implementation
     * and is used to find the index of the largest child element among the {@code left}, {@code mid}, and {@code right} children of
     * the current element at index {@code i}. The method takes an array of Comparable objects,
     * the length of the array, and an index {@code i} as parameters.
     * <ul>
     *     <li>The method calculates the indices of the {@code left}, {@code mid}, and {@code right} child elements of the current element index {@code i}.
     *     The {@code left} child index is {@code (3 * i + 1)},
     *     the {@code middle} child index is {@code (3 * i + 2)}, and
     *     the {@code right} child index is {@code (3 * i + )}3.</li>
     *     <li>The method then calls the heapChildInc method three times.
     *     The first call compares the current element with the {@code left} child,
     *     the second call compares the current element with the {@code mid} child,
     *     and the third call compares the current element with the {@code right} child.
     *     The {@code heapChildInc} method compares the elements at the provided indices
     *     and returns the index of the {@code larger} element.</li>
     *     <li>The returned values from the {@code heapChildDec} method calls are assigned to the variable {@code largest}.
     *     Since each call updates {@code largest} based on the comparison result,
     *     the final value of smallest represents the index of the {@code largest} child element among
     *     the {@code left}, {@code mid}, and {@code right} children.</li>
     *     <li>Finally, the method returns the value of {@code largest}, which is the index of the smallest child element among
     *     the three children of the element at index {@code i}.</li>
     * </ul>
     * {@code heapSplitDec} method is used to find the index of the smallest child element among
     * the {@code left}, {@code mid}, and {@code right} children of a given element in a heap structure.
     * @param       array to be arranged.
     * @param       n of the array.
     * @param       i the current element
     * @return      the value of {@code largest}
     * @see         mz.HeapInterface#heapSplitInc(Comparable[], int, int)
     * @see         mz.HeapInterface#heapChildDec(Comparable[], int, int, int)
     */
    @Override
    public int heapSplitDec(Comparable[] array, int n, int i) {
        int left = ((3 * i) + 1), mid = ((3 * i) + 2), right = ((3 * i) + 3);
        int largest = heapChildDec(array, n, i, left);
        largest = heapChildDec(array, n, largest, mid);
        largest = heapChildDec(array, n, largest, right);
        return largest;
    }
}