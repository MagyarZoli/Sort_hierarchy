package mz;

/**
 * Smooth Heap Sort it is another version of heapsort that is designed to minimize the number of comparisons performed during the sort.
 * Like heapsort, smooth sort sorts an array by building a heap and repeatedly extracting the maximum element.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class SmoothHeap
extends Heap {

    /**
     * Which is an array of {@code Comparable} objects with an initial size of 256,
     */
    private Comparable[] buffer = new Comparable[256];

    /**
     * Which represents the number of elements currently stored in the buffer.
     */
    private int size = 0;

    /**
     * <b>Smooth Heap Sort:</b><br>
     * It is another version of heapsort that is designed to minimize the number of comparisons performed during the sort.
     * Like heapsort, smooth sort sorts an array by building a heap and repeatedly extracting the maximum element.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>The first {@code for} loop iterates over the elements of the array. For each element, it
     *     adds a new element to a heap structure stored in the array and ensures that the heap property is maintained after the insertion.</li>
     *     <li>After the first loop completes, the {@code buffer} contains all the elements from the {@code array} in a heap structure.</li>
     *     <li>The second {@code for} loop iterates over the indices of the {@code array}. For each index {@code i}, it calls
     *     the deletes the minimum element from a heap structure stored in the {@code buffer} array and ensures that
     *     the heap property is maintained after the deletion.</li>
     *     <li>At the end, the {@code array} will contain the elements sorted in increasing order.</li>
     * </ol>
     * <b>Note:</b><br>
     * Like Heapsort, Smooth Sort is an in-place algorithm with an upper bound of <em>O(n log(n))</em>, but it is not a stable sort.
     * The advantage of Smooth Sort is that it comes closer to <em>O(n)</em> time if the input is already sorted to some degree,
     * whereas heapsort averages <em>O(n log(n))</em> regardless of the initial sorted state.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n log(n))</em><br>
     * Best Case Complexity:    <em>O(n)</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>No</b>
     */
    public SmoothHeap() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         mz.SmoothHeap#smoothInc(Comparable[])
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        smoothInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         mz.SmoothHeap#smoothDec(Comparable[])
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        smoothDec(array);
    }

    /**
     * {@code smoothInc}. This method performs a Smooth Heap Sort on an array of {@code Comparable} objects in increasing order.
     * It utilizes the {@code insertInc} and {@code deleteMinInc} methods to build a heap from the array elements and then extract
     * the elements from the heap in sorted order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, as a parameter.</li>
     *     <li>The variable {@code n} is assigned the length of the {@code array}.</li>
     *     <li>The first {@code for} loop iterates over the elements of the {@code array}. For each element, it calls the {@code insertInc} method
     *     to insert the element into the heap represented by the {@code buffer}.</li>
     *     <li>After the first loop completes, the {@code buffer} contains all the elements from the {@code array} in a heap structure.</li>
     *     <li>The second {@code for} loop iterates over the indices of the {@code array}. For each index {@code i}, it calls
     *     the {@code deleteMinInc} method to extract the minimum element from the heap and assigns it back to the {@code array[i]}.
     *     This effectively sorts the elements of the {@code array} in increasing order.</li>
     *     <li>At the end of the method, the {@code array} will contain the elements sorted in increasing order.</li>
     * </ul>
     * {@code smoothInc} method uses the {@code insertInc} and {@code deleteMinInc} methods to perform a smooth sort on the given array,
     * resulting in the elements being sorted in increasing order.
     * @param       array to be arranged.
     */
    void smoothInc(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            insertInc(array[i]);
        }
        for (int i = 0; i < n; i++) {
            array[i] = deleteMinInc();
        }
    }

    /**
     * {@code smoothDec}. This method performs a Smooth Heap Sort on an array of {@code Comparable} objects in increasing order.
     * It utilizes the {@code insertDec} and {@code deleteMinDec} methods to build a heap from the array elements and then extract
     * the elements from the heap in sorted order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, as a parameter.</li>
     *     <li>The variable {@code n} is assigned the length of the {@code array}.</li>
     *     <li>The first {@code for} loop iterates over the elements of the {@code array}. For each element, it calls the {@code insertDec} method
     *     to insert the element into the heap represented by the {@code buffer}.</li>
     *     <li>After the first loop completes, the {@code buffer} contains all the elements from the {@code array} in a heap structure.</li>
     *     <li>The second {@code for} loop iterates over the indices of the {@code array}. For each index {@code i}, it calls
     *     the {@code deleteMinDec} method to extract the minimum element from the heap and assigns it back to the {@code array[i]}.
     *     This effectively sorts the elements of the {@code array} in increasing order.</li>
     *     <li>At the end of the method, the {@code array} will contain the elements sorted in increasing order.</li>
     * </ul>
     * {@code smoothDec} method uses the {@code insertDec} and {@code deleteMinDec} methods to perform a smooth sort on the given array,
     * resulting in the elements being sorted in increasing order.
     * @param       array to be arranged.
     */
    void smoothDec(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            insertDec(array[i]);
        }
        for (int i = 0; i < n; i++) {
            array[i] = deleteMinDec();
        }
    }

    /**
     * {@code insertInc} this method is likely a part of a heap-related algorithm or data structure implementation
     * and is used to insert a new element into a heap structure stored in the buffer array.
     * The method takes a Comparable object called insert as a parameter.
     * <ul>
     *     <li>The {@code @SuppressWarnings("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@code compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method starts by inserting the {@code insert} element at index {@code size} in the {@code buffer}
     *     array and then increments the {@code size} variable.
     *     This step adds the new element to the end of the heap structure.</li>
     *     <li>The {@code resize} method is called to check if the size of the buffer exceeds half of its capacity.
     *     If it does, the buffer is resized by doubling its capacity using the expression {@code (buffer.length * 2)}.</li>
     *     <li>The {@code if (size > 1)} condition checks if there is more than one element in the buffer.
     *     If so, the method enters a loop that continues as long as the current index {@code i} is not equal to 0 (the root of the heap).</li>
     *     <li>Inside the loop, the variable {@code j} is assigned the index of the parent element of the current element
     *     at index {@code i}, calculated using the expression {@code ((i - 1) / 2)}.</li>
     *     <li>The subsequent {@code if} condition {@code buffer[i].compareTo(buffer[j]) < 0} compares
     *     the current element at index {@code i} with its parent element at index {@code j}.
     *     If the current element is smaller than its parent, it performs a swap between the elements at indices {@code i} and {@code j}.
     *     After the swap, it updates {@code i} to {@code j}, allowing the loop to continue comparing and swapping elements with their parents.</li>
     *     <li>If the current element is not smaller than its parent, the {@code else} block is executed, and the loop is terminated using {@code break},
     *     as the heap property is already satisfied.</li>
     * </ul>
     * {@code insertInc} method adds a new element to a heap structure stored in 
     * the {@code buffer} array and ensures that the heap property is maintained after the insertion. 
     * It achieves this by adding the element to the end of the heap, resizing the buffer if necessary, 
     * and iteratively comparing and swapping elements with their parents to restore the heap property.
     * @param       insert starts by inserting the element.
     * @see         mz.SmoothHeap#smoothInc(Comparable[])
     */
    @SuppressWarnings("unchecked")
    void insertInc(Comparable insert) {
        buffer[size++] = insert;
        resize(buffer.length * 2);
        if (size > 1) {
            int i = (size - 1);
            while (i != 0) {
                int j = ((i - 1) / 2);
                if (buffer[i].compareTo(buffer[j]) < 0) {
                    swap(buffer, i, j);
                    i = j;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * {@code insertDec} this method is likely a part of a heap-related algorithm or data structure implementation
     * and is used to insert a new element into a heap structure stored in the buffer array.
     * The method takes a Comparable object called insert as a parameter.
     * <ul>
     *     <li>The {@code @SuppressWarnings("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@code compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method starts by inserting the {@code insert} element at index {@code size} in the {@code buffer}
     *     array and then increments the {@code size} variable.
     *     This step adds the new element to the end of the heap structure.</li>
     *     <li>The {@code resize} method is called to check if the size of the buffer exceeds half of its capacity.
     *     If it does, the buffer is resized by doubling its capacity using the expression {@code (buffer.length * 2)}.</li>
     *     <li>The {@code if (size > 1)} condition checks if there is more than one element in the buffer.
     *     If so, the method enters a loop that continues as long as the current index {@code i} is not equal to 0 (the root of the heap).</li>
     *     <li>Inside the loop, the variable {@code j} is assigned the index of the parent element of the current element
     *     at index {@code i}, calculated using the expression {@code ((i - 1) / 2)}.</li>
     *     <li>The subsequent {@code if} condition {@code buffer[i].compareTo(buffer[j]) > 0} compares
     *     the current element at index {@code i} with its parent element at index {@code j}.
     *     If the current element is greater than its parent, it performs a swap between the elements at indices {@code i} and {@code j}.
     *     After the swap, it updates {@code i} to {@code j}, allowing the loop to continue comparing and swapping elements with their parents.</li>
     *     <li>If the current element is not greater than its parent, the {@code else} block is executed, and the loop is terminated using {@code break},
     *     as the heap property is already satisfied.</li>
     * </ul>
     * {@code insertDec} method adds a new element to a heap structure stored in 
     * the {@code buffer} array and ensures that the heap property is maintained after the insertion. 
     * It achieves this by adding the element to the end of the heap, resizing the buffer if necessary, 
     * and iteratively comparing and swapping elements with their parents to restore the heap property.
     * @param       insert starts by inserting the element.
     * @see         mz.SmoothHeap#smoothDec(Comparable[])
     */
    @SuppressWarnings("unchecked")
    void insertDec(Comparable insert) {
        buffer[size++] = insert;
        resize(buffer.length * 2);
        if (size > 1) {
            int i = (size - 1);
            while (i != 0) {
                int j = ((i - 1) / 2);
                if (buffer[i].compareTo(buffer[j]) > 0) {
                    swap(buffer, i, j);
                    i = j;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * {@code deleteMinInc}. This method is likely a part of a heap-related algorithm or
     * data structure implementation and is used
     * to delete the minimum element from a heap structure that is stored in the {@code buffer} array.
     * The method returns the deleted minimum element, which is of type {@code Comparable}.
     * <ul>
     *     <li>The {@code @SuppressWarnings("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@code compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method starts by assigning the value of the element at index 0 in the {@code buffer} to the variable {@code result}.
     *     This represents the minimum element that will be deleted.</li>
     *     <li>The {@code size} variable is decremented by 1 to reflect the removal of an element from the heap.</li>
     *     <li>The {@code swap} method is called to exchange the elements at indices 0 and {@code size} in the {@code buffer} array.
     *     This step effectively removes the minimum element from the heap by moving it to the last position in the buffer.</li>
     *     <li>The method then enters a loop that continues as long as the left child of the current element at index {@code i} {@code ((2 * i) + 1)}
     *     is within the valid range of the buffer (less than {@code size}).</li>
     *     <li>Inside the loop, the variable {@code j} is assigned the index of the left child of the current element.</li>
     *     <li>The subsequent {@code if} condition {@code (j + 1) < size && buffer[j].compareTo(buffer[(j + 1)]) > 0}
     *     checks if the right child of {@code i} exists and is smaller than the left child.
     *     If so, {@code j} is updated to the index of the right child {@code (j + 1)}.</li>
     *     <li>The next if condition {@code buffer[j].compareTo(buffer[i]) < 0} compares the element
     *     at index {@code j} (the smaller child) with the element at index {@code i}.
     *     If the child is smaller, it performs a swap between the elements at indices {@code j} and {@code i}.
     *     After the swap, it updates {@code i} to {@code j}, allowing the loop to continue
     *     the comparisons and swaps downward in the heap structure.</li>
     *     <li>If the child is not smaller than the current element,
     *     the {@code else} block is executed, and the loop is terminated using {@code break},
     *     as the heap property is already satisfied.</li>
     *     <li>Finally, the method returns the deleted minimum element stored in the {@code result} variable.</li>
     * </ul>
     * {@code deleteMinInc} method deletes the minimum element from a heap structure stored in the {@code buffer} array and ensures that
     * the heap property is maintained after the deletion.
     * It achieves this by swapping the minimum element with the last element, adjusting the size of the heap,
     * and iteratively comparing and swapping elements to restore the heap property.
     * @return      the deleted minimum element stored in the {@code result} variable
     * @see         mz.SmoothHeap#smoothInc(Comparable[])
     */
    @SuppressWarnings("unchecked")
    Comparable deleteMinInc() {
        Comparable result = buffer[0];
        size--;
        swap(buffer, 0, size);
        int i = 0;
        while (((2 * i) + 1) < size) {
            int j = ((2 * i) + 1);
            if ((j + 1) < size && buffer[j].compareTo(buffer[(j + 1)]) > 0) {
                j++;
            }
            if (buffer[j].compareTo(buffer[i]) < 0) {
                swap(buffer, j, i);
                i = j;
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * {@code deleteMinDec}. This method is likely a part of a heap-related algorithm or
     * data structure implementation and is used
     * to delete the minimum element from a heap structure that is stored in the {@code buffer} array.
     * The method returns the deleted minimum element, which is of type {@code Comparable}.
     * <ul>
     *     <li>The {@code @SuppressWarnings("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@code compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method starts by assigning the value of the element at index 0 in the {@code buffer} to the variable {@code result}.
     *     This represents the minimum element that will be deleted.</li>
     *     <li>The {@code size} variable is decremented by 1 to reflect the removal of an element from the heap.</li>
     *     <li>The {@code swap} method is called to exchange the elements at indices 0 and {@code size} in the {@code buffer} array.
     *     This step effectively removes the minimum element from the heap by moving it to the last position in the buffer.</li>
     *     <li>The method then enters a loop that continues as long as the left child of the current element at index {@code i} {@code ((2 * i) + 1)}
     *     is within the valid range of the buffer (less than {@code size}).</li>
     *     <li>Inside the loop, the variable {@code j} is assigned the index of the left child of the current element.</li>
     *     <li>The subsequent {@code if} condition {@code (j + 1) < size && buffer[j].compareTo(buffer[(j + 1)]) < 0}
     *     checks if the right child of {@code i} exists and is smaller than the left child.
     *     If so, {@code j} is updated to the index of the right child {@code (j + 1)}.</li>
     *     <li>The next if condition {@code buffer[j].compareTo(buffer[i]) > 0} compares the element
     *     at index {@code j} (the smaller child) with the element at index {@code i}.
     *     If the child is smaller, it performs a swap between the elements at indices {@code j} and {@code i}.
     *     After the swap, it updates {@code i} to {@code j}, allowing the loop to continue
     *     the comparisons and swaps downward in the heap structure.</li>
     *     <li>If the child is not smaller than the current element,
     *     the {@code else} block is executed, and the loop is terminated using {@code break},
     *     as the heap property is already satisfied.</li>
     *     <li>Finally, the method returns the deleted minimum element stored in the {@code result} variable.</li>
     * </ul>
     * {@code deleteMinDec} method deletes the minimum element from a heap structure stored in the {@code buffer} array and ensures that
     * the heap property is maintained after the deletion.
     * It achieves this by swapping the minimum element with the last element, adjusting the size of the heap,
     * and iteratively comparing and swapping elements to restore the heap property.
     * @return      the deleted minimum element stored in the {@code result} variable
     * @see         mz.SmoothHeap#smoothDec(Comparable[])
     */
    @SuppressWarnings("unchecked")
    Comparable deleteMinDec() {
        Comparable result = buffer[0];
        size--;
        swap(buffer, 0, size);
        int i = 0;
        while (((2 * i) + 1) < size) {
            int j = ((2 * i) + 1);
            if ((j + 1) < size && buffer[j].compareTo(buffer[(j + 1)]) < 0) {
                j++;
            }
            if (buffer[j].compareTo(buffer[i]) > 0) {
                swap(buffer, j, i);
                i = j;
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * {@code resize} this method is used to resize the internal buffer of an object or class that contains an array of {@code Comparable} objects.
     * The method takes a capacity parameter to specify the new capacity of the buffer.
     * <ul>
     *     <li>The code snippet includes two private variables:
     *     {@code buffer}, which is an array of {@code Comparable} objects with an initial size of 256,
     *     and {@code size}, which represents the number of elements currently stored in the buffer.</li>
     *     <li>The {@code resize} method is used to adjust the capacity of the buffer based on the provided {@code capacity} parameter.
     *     It checks if the current {@code size} of the buffer is half of the desired {@code capacity}.</li>
     *     <li>If the condition is met, indicating that the current buffer is utilizing half or more of its capacity,
     *     the method creates a new buffer with the specified {@code capacity} using the {@code Comparable} array type.</li>
     *     <li>The {@code System.arraycopy} method is then used to copy the existing elements from the current buffer {@code (buffer)}
     *     to the newly created buffer {@code (newBuffer)}, up to the current {@code size}.</li>
     *     <li>Finally, the reference to the new buffer is assigned to the {@code buffer} variable,
     *     effectively resizing the buffer to the specified capacity.</li>
     * </ul>
     * {@code resize} method ensures that the buffer is resized when the number of elements stored in it reaches half of its capacity.
     * It creates a new buffer with the desired capacity and copies the existing elements from the old buffer to the new buffer.
     * @param       capacity the new capacity of the buffer
     * @see         mz.SmoothHeap#insertInc(Comparable)
     * @see         mz.SmoothHeap#insertDec(Comparable)
     */
    void resize(int capacity) {
        if (size == (capacity / 2)) {
            Comparable[] newBuffer = new Comparable[capacity];
            System.arraycopy(buffer, 0, newBuffer, 0, size);
            buffer = newBuffer;
        }
    }
}