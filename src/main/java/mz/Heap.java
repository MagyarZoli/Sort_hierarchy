package mz;

/**
 * Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure to sort elements.
 * It works by constructing a heap from the input array and repeatedly extracting
 * the maximum (or minimum) element from the heap and placing it at the end of the sorted portion of the array.
 * @since       1.2
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Heap
extends SortComparable
implements HeapInterface<Comparable> {

    /**
     * <b>Heap Sort:</b><br>
     * Is a comparison-based sorting algorithm that uses a binary heap data structure to sort elements.
     * It works by constructing a heap from the input array and repeatedly extracting
     * the maximum (or minimum) element from the heap and placing it at the end of the sorted portion of the array.<br><br>
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
     * @see         mz.intro.IntroHeap#IntroHeap() IntroHeap
     * @see         mz.SmoothHeap#SmoothHeap() SmoothHeap
     * @see         mz.TernaryHeap#TernaryHeap() TernaryHeap
     * @see         mz.WeakHeap#WeakHeap() WeakHeap
     */
    public Heap() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        heapInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        heapDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        heap(array, functional);
    }

    /**
     * {@inheritDoc}
     * @return      selected {@code Sort} class initialized.
     */
    @Override
    public Sort sortThreadClass() {
        return new Heap();
    }
}