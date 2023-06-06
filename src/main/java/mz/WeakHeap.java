package mz;

/**
 * Weak Heap Sort construction uses a buffer that supports constant-time insertion.
 * A new element is inserted into the buffer as long as the buffer size is below a threshold.
 * Once the buffer is full, all the elements of the buffer are moved to the weak heap.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class WeakHeap
extends Heap {

    /**
     * <b>Weak Heap Sort:</b><br>
     * Construction uses a buffer that supports constant-time insertion.
     * A new element is inserted into the buffer as long as the buffer size is below a threshold.
     * Once the buffer is full, all the elements of the buffer are moved to the weak heap.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>The root node has no left child</li>
     *     <li>For every node, the value associated with that node is greater than or equal to
     *     the values associated with all nodes in its right subtree.</li>
     *     <li>The leaves of the tree have heights that are all within one of each other.</li>
     * </ol>
     * <b>Note:</b><br>
     * Weak heaps were introduced as part of a variant heap sort algorithm that (unlike the standard heap sort using binary heaps)
     * could be used to sort n items using only <em>O(n log(n))</em> comparisons.
     * They were later investigated as a more generally applicable priority queue data structure.<br><br>
     * In a weak max-heap, the maximum value can be found (in constant time) as the value associated with the root node; similarly
     * in a weak min-heap, the minimum value can be found at the root.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n log(n))</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>No</b>
     */
    public WeakHeap() {}

    /**
     * {@code heapifyInc} method. This method is likely a part of a heap-related algorithm or data structure implementation
     * and is used to maintain the max heap property within a heap structure.
     * It takes an array of {@code Comparable} objects, the {@code length} of the heap (or array), and an index {@code i} as parameters.
     * <ul>
     *     <li>The {@code @SuppressWarnings("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method uses a {@code while} loop to iteratively perform comparisons and {@link mz.SortSwap#swap(Comparable[], int, int) swaps} to maintain the max heap property.</li>
     *     <li>The loop condition {@code (2 * i) < length} checks if the current element {@code i} has at least one child within the heap structure.
     *     If it does not have a child, it means the element is already in its correct position within the heap.</li>
     *     <li>Inside the loop, the variable {@code k} is assigned the index of the left child of
     *     the current element {@code i} (i.e., {@code (2 * i)}).</li>
     *     <li>The subsequent {@code if} condition {@code (k + 1) < length && array[(k + 1)].compareTo(array[k]) > 0}
     *     checks if the right child of {@code i} exists and is greater than the left child.
     *     If so, {@code k} is updated to the index of the right child (i.e., k + 1).</li>
     *     <li>The next {@code if} condition {@code array[k].compareTo(array[i]) > 0} compares the element
     *     at index {@code k} (the larger child) with the element at index {@code i}.
     *     If the child is greater, it performs a swap between the elements at indices {@code i} and {@code k}.
     *     After the swap, it updates i to k, allowing the loop to continue the comparisons and swaps downward in the heap structure.</li>
     *     <li>If the child is not greater than the current element,
     *     the {@code else} block is executed, and the loop is terminated using {@code break},
     *     as the max heap property is already satisfied.</li>
     * </ul>
     * {@code heapifyInc} method is used to maintain the max heap property within a heap structure by iteratively comparing
     * and swapping elements until the current element is in its correct position within the heap.
     * @param       array to be arranged.
     * @param       length of the array.
     * @param       i the current element
     */
    @Override
    @SuppressWarnings("unchecked")
    public void heapifyInc(Comparable[] array, int length, int i) {
        while ((2 * i) < length) {
            int k = (2 * i);
            if ((k + 1) < length && array[(k + 1)].compareTo(array[k]) > 0) {
                k++;
            }
            if (array[k].compareTo(array[i]) > 0) {
                swap(array, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    /**
     * {@code heapifyDec} method. This method is likely a part of a heap-related algorithm or data structure implementation
     * and is used to maintain the max heap property within a heap structure.
     * It takes an array of {@code Comparable} objects, the {@code length} of the heap (or array), and an index {@code i} as parameters.
     * <ul>
     *     <li>The {@code @SuppressWarnings("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method uses a {@code while} loop to iteratively perform comparisons and {@link mz.SortSwap#swap(Comparable[], int, int) swaps} to maintain the max heap property.</li>
     *     <li>The loop condition {@code (2 * i) < length} checks if the current element {@code i} has at least one child within the heap structure.
     *     If it does not have a child, it means the element is already in its correct position within the heap.</li>
     *     <li>Inside the loop, the variable {@code k} is assigned the index of the left child of
     *     the current element {@code i} (i.e., {@code (2 * i)}).</li>
     *     <li>The subsequent {@code if} condition {@code (k + 1) < length && array[(k + 1)].compareTo(array[k]) > 0}
     *     checks if the right child of {@code i} exists and is greater than the left child.
     *     If so, {@code k} is updated to the index of the right child (i.e., k + 1).</li>
     *     <li>The next {@code if} condition {@code array[k].compareTo(array[i]) < 0} compares the element
     *     at index {@code k} (the small child) with the element at index {@code i}.
     *     If the child is smaller, it performs a swap between the elements at indices {@code i} and {@code k}.
     *     After the swap, it updates i to k, allowing the loop to continue the comparisons and swaps downward in the heap structure.</li>
     *     <li>If the child is not smaller than the current element,
     *     the {@code else} block is executed, and the loop is terminated using {@code break},
     *     as the max heap property is already satisfied.</li>
     * </ul>
     * {@code heapifyDec} method is used to maintain the max heap property within a heap structure by iteratively comparing
     * and swapping elements until the current element is in its correct position within the heap.
     * @param       array to be arranged.
     * @param       length of the array.
     * @param       i the current element
     */
    @Override
    @SuppressWarnings("unchecked")
    public void heapifyDec(Comparable[] array, int length, int i) {
        while ((2 * i) < length) {
            int k = (2 * i);
            if ((k + 1) < length && array[(k + 1)].compareTo(array[k]) < 0) {
                k++;
            }
            if (array[k].compareTo(array[i]) < 0) {
                swap(array, i, k);
                i = k;
            } else {
                break;
            }
        }
    }
}