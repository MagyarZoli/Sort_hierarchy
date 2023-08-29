package github.magyarzoli.sort;

import github.magyarzoli.SortList;
import github.magyarzoli.SortSwap;
import github.magyarzoli.sort.intro.IntroSmoothHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * Smooth Heap Sort it is another version of heapsort that is designed to minimize the number of comparisons performed during the sort.
 * Like heapsort, smooth sort sorts an array by building a heap and repeatedly extracting the maximum element.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class SmoothHeap
extends Heap {

    /**
     * Which is an array of {@link java.lang.Comparable Comparable} objects with an initial size of 256,
     */
    protected Comparable[] bufferArray = new Comparable[256];

    /**
     * Which is a list of {@link java.lang.Comparable Comparable} objects with an initial new {@link java.util.ArrayList ArrayList},
     */
    protected List<Comparable> bufferList = new ArrayList<>();

    /**
     * Which represents the number of elements currently stored in the buffer.
     */
    protected int size = 0;

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
     * @see         IntroSmoothHeap#IntroSmoothHeap() IntroSmoothHeap
     */
    public SmoothHeap() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        smoothInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        smoothDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        smooth(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        smoothInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        smoothDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        smooth(list, functional);
    }

    /**
     * {@code smoothInc}. This method performs a Smooth Heap Sort on an array of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
     * It utilizes the {@code insertArrayInc} and {@code deleteArrayMinInc} methods to build a heap from the array elements and then extract
     * the elements from the heap in sorted order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, as a parameter.</li>
     *     <li>The variable {@code n} is assigned the length of the {@code array}.</li>
     *     <li>The first {@code for} loop iterates over the elements of the {@code array}. For each element, it calls the {@code insertArrayInc} method
     *     to insert the element into the heap represented by the {@code buffer}.</li>
     *     <li>After the first loop completes, the {@code buffer} contains all the elements from the {@code array} in a heap structure.</li>
     *     <li>The second {@code for} loop iterates over the indices of the {@code array}. For each index {@code i}, it calls
     *     the {@code deleteArrayMinInc} method to extract the minimum element from the heap and assigns it back to the {@code array[i]}.
     *     This effectively sorts the elements of the {@code array} in increasing order.</li>
     *     <li>At the end of the method, the {@code array} will contain the elements sorted in increasing order.</li>
     * </ul>
     * {@code smoothInc} method uses the {@code insertArrayInc} and {@code deleteArrayMinInc} methods to perform a smooth sort on the given array,
     * resulting in the elements being sorted in increasing order.
     * @param       array to be arranged.
     * @see         SmoothHeap#insertArrayInc(Comparable)
     * @see         SmoothHeap#deleteArrayMinInc()
     */
    protected void smoothInc(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            insertArrayInc(array[i]);
        }
        for (int i = 0; i < n; i++) {
            array[i] = deleteArrayMinInc();
        }
    }

    /**
     * {@code smoothDec}. This method performs a Smooth Heap Sort on an array of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
     * It utilizes the {@code insertDec} and {@code deleteArrayMinDec} methods to build a heap from the array elements and then extract
     * the elements from the heap in sorted order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, as a parameter.</li>
     *     <li>The variable {@code n} is assigned the length of the {@code array}.</li>
     *     <li>The first {@code for} loop iterates over the elements of the {@code array}. For each element, it calls the {@code insertArrayDec} method
     *     to insert the element into the heap represented by the {@code buffer}.</li>
     *     <li>After the first loop completes, the {@code buffer} contains all the elements from the {@code array} in a heap structure.</li>
     *     <li>The second {@code for} loop iterates over the indices of the {@code array}. For each index {@code i}, it calls
     *     the {@code deleteArrayMinDec} method to extract the minimum element from the heap and assigns it back to the {@code array[i]}.
     *     This effectively sorts the elements of the {@code array} in increasing order.</li>
     *     <li>At the end of the method, the {@code array} will contain the elements sorted in increasing order.</li>
     * </ul>
     * {@code smoothDec} method uses the {@code insertArrayDec} and {@code deleteArrayMinDec} methods to perform a smooth sort on the given array,
     * resulting in the elements being sorted in increasing order.
     * @param       array to be arranged.
     * @see         SmoothHeap#insertArrayDec(Comparable)
     * @see         SmoothHeap#deleteArrayMinDec()
     */
    protected void smoothDec(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            insertArrayDec(array[i]);
        }
        for (int i = 0; i < n; i++) {
            array[i] = deleteArrayMinDec();
        }
    }

    /**
     * {@code smooth} that takes an array of {@link java.lang.Comparable Comparable} objects {@code array},
     * and a {@code SortFunctional<Comparable>} object as parameters.
     * This method performs a smooth sort on the specified portion of the array using
     * the {@code insertArray} and {@code deleteArrayMin} methods while maintaining the ordering based on the {@code SortFunctional} object.
     * <ul>
     *     <li>It iterates over the elements in the range from <i>0</i> to {@code array.length} (exclusive) of the {@code array}.</li>
     *     <li>Inside the loop, it calls the {@code insertArray} method with the current element and the {@code functional} object as arguments.
     *     This inserts the element into a buffer (presumably a binary heap) while maintaining
     *     the ordering based on the {@code SortFunctional} object.</li>
     *     <li>After the first loop, all elements in the specified range have been inserted into the buffer.</li>
     *     <li>It iterates again over the same range of elements from <i>0</i> to {@code n}.</li>
     *     <li>Inside this loop, it assigns the result of calling the {@code deleteArrayMin} method with
     *     the {@code functional} object to the corresponding element in the {@code array}.
     *     This operation removes the minimum element from the buffer while maintaining the ordering based on
     *     the {@code SortFunctional} object and assigns it to the current index in the {@code array}.</li>
     *     <li>After the second loop, the elements in the specified range of the {@code array}
     *     have been sorted in non-decreasing order based on the {@code functional} object.</li>
     * </ul>
     * {@code smooth} method uses the {@code insertArray} and {@code deleteArrayMin} methods to perform a smooth sort on the given array,
     * resulting in the elements being sorted.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         SmoothHeap#insertArray(Comparable, SortFunctional)
     * @see         SmoothHeap#deleteListMin(SortFunctional)
     */
    protected void smooth(Comparable[] array, SortFunctional<Comparable> functional) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            insertArray(array[i], functional);
        }
        for (int i = 0; i < n; i++) {
            array[i] = deleteArrayMin(functional);
        }
    }

    /**
     * {@code smoothInc}. This method performs a Smooth Heap Sort on an array of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
     * It utilizes the {@code insertArrayInc} and {@code deleteArrayMinInc} methods to build a heap from the array elements and then extract
     * the elements from the heap in sorted order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, as a parameter.</li>
     *     <li>The variable {@code right} is assigned the length of the {@code array}.</li>
     *     <li>The first {@code for} loop iterates over the elements of the {@code array}. For each element, it calls the {@code insertArrayInc} method
     *     to insert the element into the heap represented by the {@code buffer}.</li>
     *     <li>After the first loop completes, the {@code buffer} contains all the elements from the {@code array} in a heap structure.</li>
     *     <li>The second {@code for} loop iterates over the indices of the {@code array}. For each index {@code i}, it calls
     *     the {@code deleteArrayMinInc} method to extract the minimum element from the heap and assigns it back to the {@code array[i]}.
     *     This effectively sorts the elements of the {@code array} in increasing order.</li>
     *     <li>At the end of the method, the {@code array} will contain the elements sorted in increasing order.</li>
     * </ul>
     * {@code smoothInc} method uses the {@code insertArrayInc} and {@code deleteArrayMinInc} methods to perform a smooth sort on the given array,
     * resulting in the elements being sorted in increasing order.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         SmoothHeap#insertArrayInc(Comparable)
     * @see         SmoothHeap#deleteArrayMinInc()
     */
    protected void smoothInc(Comparable[] array, int left, int right) {
        for (int i = left; i < right; i++) {
            insertArrayInc(array[i]);
        }
        for (int i = left; i < right; i++) {
            array[i] = deleteArrayMinInc();
        }
    }

    /**
     * {@code smoothDec}. This method performs a Smooth Heap Sort on an array of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
     * It utilizes the {@code insertArrayDec} and {@code deleteArrayMinDec} methods to build a heap from the array elements and then extract
     * the elements from the heap in sorted order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, as a parameter.</li>
     *     <li>The variable {@code n} is assigned the length of the {@code array}.</li>
     *     <li>The first {@code for} loop iterates over the elements of the {@code array}. For each element, it calls the {@code insertArrayDec} method
     *     to insert the element into the heap represented by the {@code buffer}.</li>
     *     <li>After the first loop completes, the {@code buffer} contains all the elements from the {@code array} in a heap structure.</li>
     *     <li>The second {@code for} loop iterates over the indices of the {@code array}. For each index {@code i}, it calls
     *     the {@code deleteArrayMinDec} method to extract the minimum element from the heap and assigns it back to the {@code array[i]}.
     *     This effectively sorts the elements of the {@code array} in increasing order.</li>
     *     <li>At the end of the method, the {@code array} will contain the elements sorted in increasing order.</li>
     * </ul>
     * {@code smoothDec} method uses the {@code insertArrayDec} and {@code deleteArrayMinDec} methods to perform a smooth sort on the given array,
     * resulting in the elements being sorted in increasing order.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         SmoothHeap#insertArrayDec(Comparable)
     * @see         SmoothHeap#deleteArrayMinDec()
     */
    protected void smoothDec(Comparable[] array, int left, int right) {
        for (int i = left; i < right; i++) {
            insertArrayDec(array[i]);
        }
        for (int i = left; i < right; i++) {
            array[i] = deleteArrayMinDec();
        }
    }

    /**
     * {@code smooth} that takes an array of
     * {@link java.lang.Comparable Comparable} objects {@code array}, indices {@code left} and {@code right},
     * and a {@code SortFunctional<Comparable>} object as parameters.
     * This method performs a smooth sort on the specified portion of the array using
     * the {@code insertArray} and {@code deleteArrayMin} methods while maintaining the ordering based on the {@code SortFunctional} object.
     * <ul>
     *     <li>It iterates over the elements in the range from {@code left} to {@code right} (exclusive) of the {@code array}.</li>
     *     <li>Inside the loop, it calls the {@code insertArray} method with the current element and the {@code functional} object as arguments.
     *     This inserts the element into a buffer (presumably a binary heap) while maintaining
     *     the ordering based on the {@code SortFunctional} object.</li>
     *     <li>After the first loop, all elements in the specified range have been inserted into the buffer.</li>
     *     <li>It iterates again over the same range of elements from {@code left} to {@code right}.</li>
     *     <li>Inside this loop, it assigns the result of calling the {@code deleteArrayMin} method with
     *     the {@code functional} object to the corresponding element in the {@code array}.
     *     This operation removes the minimum element from the buffer while maintaining the ordering based on
     *     the {@code SortFunctional} object and assigns it to the current index in the {@code array}.</li>
     *     <li>After the second loop, the elements in the specified range of the {@code array}
     *     have been sorted in non-decreasing order based on the {@code functional} object.</li>
     * </ul>
     * {@code smooth} method uses the {@code insertArray} and {@code deleteArrayMin} methods to perform a smooth sort on the given array,
     * resulting in the elements being sorted.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         SmoothHeap#insertArray(Comparable, SortFunctional)
     * @see         SmoothHeap#deleteListMin(SortFunctional)
     */
    protected void smooth(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        for (int i = left; i < right; i++) {
            insertArray(array[i], functional);
        }
        for (int i = left; i < right; i++) {
            array[i] = deleteArrayMin(functional);
        }
    }

    /**
     * {@code insertArrayInc} this method is likely a part of a heap-related algorithm or data structure implementation
     * and is used to insert a new element into a heap structure stored in the buffer array.
     * The method takes a {@link java.lang.Comparable Comparable} object called insert as a parameter.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
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
     * {@code insertArrayInc} method adds a new element to a heap structure stored in
     * the {@code buffer} array and ensures that the heap property is maintained after the insertion.
     * It achieves this by adding the element to the end of the heap, resizing the buffer if necessary,
     * and iteratively comparing and swapping elements with their parents to restore the heap property.
     * @param       insert starts by inserting the element.
     * @see         SmoothHeap#resizeArray(int)
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void insertArrayInc(Comparable insert) {
        bufferArray[size++] = insert;
        resizeArray(bufferArray.length * 2);
        if (size > 1) {
            int i = (size - 1);
            while (i != 0) {
                int j = ((i - 1) / 2);
                if (bufferArray[j].compareTo(bufferArray[i]) > 0) {
                    swap(bufferArray, i, j);
                    i = j;
                } else {
                    break;
                }
            }
        }
    }


    /**
     * {@code insertArrayDec} this method is likely a part of a heap-related algorithm or data structure implementation
     * and is used to insert a new element into a heap structure stored in the buffer array.
     * The method takes a {@link java.lang.Comparable Comparable} object called insert as a parameter.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
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
     * {@code insertArrayDec} method adds a new element to a heap structure stored in
     * the {@code buffer} array and ensures that the heap property is maintained after the insertion.
     * It achieves this by adding the element to the end of the heap, resizing the buffer if necessary,
     * and iteratively comparing and swapping elements with their parents to restore the heap property.
     * @param       insert starts by inserting the element.
     * @see         SmoothHeap#resizeArray(int)
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void insertArrayDec(Comparable insert) {
        bufferArray[size++] = insert;
        resizeArray(bufferArray.length * 2);
        if (size > 1) {
            int i = (size - 1);
            while (i != 0) {
                int j = ((i - 1) / 2);
                if (bufferArray[j].compareTo(bufferArray[i]) < 0) {
                    swap(bufferArray, i, j);
                    i = j;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * {@code insertArray} that takes a {@link java.lang.Comparable Comparable} object insert
     * and a {@code SortFunctional<Comparable>} object as parameters.
     * This method inserts an element into a buffer (presumably an array) while maintaining
     * the ordering of elements based on the {@code SortFunctional} object.
     * <ul>
     *     <li>It adds the {@code insert} element to the {@code buffer} array at
     *     the current {@code size} index and increments the {@code size} variable.</li>
     *     <li>It checks if the {@code size} is greater than <i>1</i>,
     *     indicating that there are already elements in the buffer.</li>
     *     <li>If there are elements in the buffer, it initializes the index {@code i} as the current {@code (size - 1)},
     *     representing the index of the newly inserted element.</li>
     *     <li>It enters a while loop that continues until {@code i} is not equal to <i>0</i>,
     *     indicating that the element has reached the root of the binary heap.</li>
     *     <li>Inside the while loop, it calculates the parent index of
     *     the current element using {@code ((i - 1) / 2)} and assigns it to the variable {@code j}.</li>
     *     <li>It compares the element at index {@code j} with the element at index {@code i}
     *     using {@code functional.functionalCompareTo(buffer[j], buffer[i])}.</li>
     *     <li>If the comparison indicates that the element at index {@code j} is less than the element at index {@code i},
     *     it means that the binary heap property is satisfied, and the {@code while} loop breaks.</li>
     *     <li>If the comparison indicates that the element at index {@code j} is greater than the element at index {@code i},
     *     it swaps the elements at indices {@code i} and {@code j} in the {@code buffer} array using the {@code swap} method.</li>
     *     <li>After the swap, it updates the value of {@code i} to be {@code j},
     *     indicating that the current element has moved up the binary heap.</li>
     *     <li>Finally, the method finishes executing, and the new element is successfully inserted into
     *     the buffer while maintaining the ordering based on the {@code mz.SortFunctional} object.</li>
     * </ul>
     * {@code insertArray} method adds a new element to a heap structure stored in
     * the {@code buffer} array and ensures that the heap property is maintained after the insertion.
     * It achieves this by adding the element to the end of the heap, resizing the buffer if necessary,
     * and iteratively comparing and swapping elements with their parents to restore the heap property.
     * @param       insert starts by inserting the element.
     * @param       functional lambda expression for comparison.
     * @see         SmoothHeap#resizeArray(int)
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         SortSwap#swap(Comparable[], int, int)
     *
     */
    protected void insertArray(Comparable insert, SortFunctional<Comparable> functional) {
        bufferArray[size++] = insert;
        resizeArray(bufferArray.length * 2);
        if (size > 1) {
            int i = (size - 1);
            while (i != 0) {
                int j = ((i - 1) / 2);
                if (functional.functionalCompareTo(bufferArray[j], bufferArray[i])) {
                    swap(bufferArray, i, j);
                    i = j;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * {@code deleteArrayMinInc}. This method is likely a part of a heap-related algorithm or
     * data structure implementation and is used
     * to delete the minimum element from a heap structure that is stored in the {@code buffer} array.
     * The method returns the deleted minimum element, which is of type {@link java.lang.Comparable Comparable}.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
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
     * {@code deleteArrayMinInc} method deletes the minimum element from a heap structure stored in the {@code buffer} array and ensures that
     * the heap property is maintained after the deletion.
     * It achieves this by swapping the minimum element with the last element, adjusting the size of the heap,
     * and iteratively comparing and swapping elements to restore the heap property.
     * @return      the deleted minimum element stored in the {@code result} variable
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected Comparable deleteArrayMinInc() {
        Comparable result = bufferArray[0];
        swap(bufferArray, 0, --size);
        int i = 0;
        while (((2 * i) + 1) < size) {
            int j = ((2 * i) + 1);
            if (((j + 1) < size) && (bufferArray[j].compareTo(bufferArray[(j + 1)]) > 0)) {
                j++;
            }
            if (bufferArray[i].compareTo(bufferArray[j]) > 0) {
                swap(bufferArray, j, i);
                i = j;
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * {@code deleteArrayMinDec}. This method is likely a part of a heap-related algorithm or
     * data structure implementation and is used
     * to delete the minimum element from a heap structure that is stored in the {@code buffer} array.
     * The method returns the deleted minimum element, which is of type {@link java.lang.Comparable Comparable}.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
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
     * {@code deleteArrayMinDec} method deletes the minimum element from a heap structure stored in the {@code buffer} array and ensures that
     * the heap property is maintained after the deletion.
     * It achieves this by swapping the minimum element with the last element, adjusting the size of the heap,
     * and iteratively comparing and swapping elements to restore the heap property.
     * @return      the deleted minimum element stored in the {@code result} variable
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected Comparable deleteArrayMinDec() {
        Comparable result = bufferArray[0];
        swap(bufferArray, 0, --size);
        int i = 0;
        while (((2 * i) + 1) < size) {
            int j = ((2 * i) + 1);
            if (((j + 1) < size) && (bufferArray[j].compareTo(bufferArray[(j + 1)]) < 0)) {
                j++;
            }
            if (bufferArray[i].compareTo(bufferArray[j]) < 0) {
                swap(bufferArray, j, i);
                i = j;
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * {@code deleteArrayMin} that takes a {@code SortFunctional<Comparable>} object as a parameter.
     * This method performs the deletion of the minimum element
     * from a buffer (presumably an array) and returns the deleted element.
     * <ul>
     *     <li>It stores the value of the element at index <i>0</i> in
     *     the {@code buffer} array as the {@code result} variable.</li>
     *     <li>It swaps the element at index <i>0</i> with the element at index {@code (size - 1)}
     *     in the {@code buffer} array and decrements the {@code size} variable.</li>
     *     <li>It initializes the index {@code i} as <i>0</i>,
     *     representing the current node being examined in the binary heap.</li>
     *     <li>It enters a {@code while} loop that continues as long as
     *     the left child of the current node (represented by {@code ((2 * i) + 1)}) is less than the {@code size} variable,
     *     which ensures that the current node has at least one child.</li>
     *     <li>Inside the {@code while} loop, it initializes the index {@code j} as {@code ((2 * i) + 1)},
     *     representing the left child of the current node.</li>
     *     <li>It checks if the right child of the current node exists {@code ((j + 1) < size)} and if
     *     the ordering of elements based on functional indicates that the right child is greater than
     *     the left child {@code (functional.functionalCompareTo(buffer[j], buffer[j + 1]))}.</li>
     *     <li>If the above condition is {@code true},
     *     it increments {@code j} to represent the index of the right child,
     *     indicating that the right child should be considered instead of the left child for further comparison.</li>
     *     <li>It compares the element at index i with the element at index {@code j} using
     *     {@code functional.functionalCompareTo(buffer[i], buffer[j])}.</li>
     *     <li>If the comparison indicates that the element at index {@code i} is greater than the element at index {@code j},
     *     it swaps the elements at indices {@code i} and {@code j} in the {@code buffer} array using the {@code swap} method.</li>
     *     <li>After the swap, it updates the value of {@code i} to be {@code j},
     *     indicating that the current node has moved down the binary heap.</li>
     *     <li>If the element at index {@code i} is not greater than the element at index {@code j},
     *     it means that the binary heap property is satisfied, and the {@code while} loop breaks.</li>
     *     <li>Finally, it returns the {@code result},
     *     which is the minimum element that was deleted from the buffer.</li>
     * </ul>
     * {@code deleteArrayMin} method deletes the minimum element from a heap structure stored in the {@code buffer} array and ensures that
     * the heap property is maintained after the deletion.
     * It achieves this by swapping the minimum element with the last element, adjusting the size of the heap,
     * and iteratively comparing and swapping elements to restore the heap property.
     * @param       functional lambda expression for comparison.
     * @return      the deleted minimum element stored in the {@code result} variable
     * @see         SortSwap#swap(Comparable[], int, int)
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    protected Comparable deleteArrayMin(SortFunctional<Comparable> functional) {
        Comparable result = bufferArray[0];
        swap(bufferArray, 0, --size);
        int i = 0;
        while (((2 * i) + 1) < size) {
            int j = ((2 * i) + 1);
            if (((j + 1) < size) && (functional.functionalCompareTo(bufferArray[j], bufferArray[(j + 1)]))) {
                j++;
            }
            if (functional.functionalCompareTo(bufferArray[i], bufferArray[j])) {
                swap(bufferArray, j, i);
                i = j;
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * {@code resizeArray} this method is used to resize the internal buffer of an object or
     * class that contains an array of {@link java.lang.Comparable Comparable} objects.
     * The method takes a capacity parameter to specify the new capacity of the buffer.
     * <ul>
     *     <li>The code snippet includes two private variables:
     *     {@code buffer}, which is an array of {@code Comparable} objects with an initial size of 256,
     *     and {@code size}, which represents the number of elements currently stored in the buffer.</li>
     *     <li>The {@code resizeArray} method is used to adjust the capacity of the buffer based on the provided {@code capacity} parameter.
     *     It checks if the current {@code size} of the buffer is half of the desired {@code capacity}.</li>
     *     <li>If the condition is met, indicating that the current buffer is utilizing half or more of its capacity,
     *     the method creates a new buffer with the specified {@code capacity} using the {@code Comparable} array type.</li>
     *     <li>The {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy} method is then used to copy the existing elements from the current buffer {@code (buffer)}
     *     to the newly created buffer {@code (newBuffer)}, up to the current {@code size}.</li>
     *     <li>Finally, the reference to the new buffer is assigned to the {@code buffer} variable,
     *     effectively resizing the buffer to the specified capacity.</li>
     * </ul>
     * {@code resizeArray} method ensures that the buffer is resized when the number of elements stored in it reaches half of its capacity.
     * It creates a new buffer with the desired capacity and copies the existing elements from the old buffer to the new buffer.
     * @param       capacity the new capacity of the buffer
     */
    protected void resizeArray(int capacity) {
        if (size == (capacity / 2)) {
            Comparable[] newBuffer = new Comparable[capacity];
            System.arraycopy(bufferArray, 0, newBuffer, 0, size);
            bufferArray = newBuffer;
        }
    }

    /**
     * {@code smoothInc}. This method performs a Smooth Heap Sort on a list of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
     * It utilizes the {@code insertListInc} and {@code deleteListMinInc} methods to build a heap from the list elements and then extract
     * the elements from the heap in sorted order.
     * <ul>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list}, as a parameter.</li>
     *     <li>The variable {@code n} is assigned the length of the {@code list}.</li>
     *     <li>The first {@code for} loop iterates over the elements of the {@code list}. For each element, it calls the {@code insertListInc} method
     *     to insert the element into the heap represented by the {@code buffer}.</li>
     *     <li>After the first loop completes, the {@code buffer} contains all the elements from the {@code list} in a heap structure.</li>
     *     <li>The second {@code for} loop iterates over the indices of the {@code list}. For each index {@code i}, it calls
     *     the {@code deleteListMinInc} method to extract the minimum element from the heap and assigns it back to the {@code list[i]}.
     *     This effectively sorts the elements of the {@code list} in increasing order.</li>
     *     <li>At the end of the method, the {@code list} will contain the elements sorted in increasing order.</li>
     * </ul>
     * {@code smoothInc} method uses the {@code insertListInc} and {@code deleteListMinInc} methods to perform a smooth sort on the given list,
     * resulting in the elements being sorted in increasing order.
     * @param       list to be arranged.
     * @see         SmoothHeap#insertListInc(Comparable)
     * @see         SmoothHeap#deleteListMinInc()
     */
    protected <L extends Comparable> void smoothInc(List<L> list) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            insertListInc(list.get(i));
        }
        for (int i = 0; i < n; i++) {
            list.set(i, deleteListMinInc());
        }
    }

    /**
     * {@code smoothDec}. This method performs a Smooth Heap Sort on a list of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
     * It utilizes the {@code insertListDec} and {@code deleteListMinDec} methods to build a heap from the list elements and then extract
     * the elements from the heap in sorted order.
     * <ul>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list}, as a parameter.</li>
     *     <li>The variable {@code n} is assigned the length of the {@code list}.</li>
     *     <li>The first {@code for} loop iterates over the elements of the {@code list}. For each element, it calls the {@code insertListDec} method
     *     to insert the element into the heap represented by the {@code buffer}.</li>
     *     <li>After the first loop completes, the {@code buffer} contains all the elements from the {@code list} in a heap structure.</li>
     *     <li>The second {@code for} loop iterates over the indices of the {@code list}. For each index {@code i}, it calls
     *     the {@code deleteListMinDec} method to extract the minimum element from the heap and assigns it back to the {@code list.get(i)}.
     *     This effectively sorts the elements of the {@code list} in increasing order.</li>
     *     <li>At the end of the method, the {@code list} will contain the elements sorted in increasing order.</li>
     * </ul>
     * {@code smoothDec} method uses the {@code insertListDec} and {@code deleteListMinDec} methods to perform a smooth sort on the given list,
     * resulting in the elements being sorted in increasing order.
     * @param       list to be arranged.
     * @see         SmoothHeap#insertListDec(Comparable)
     * @see         SmoothHeap#deleteListMinDec()
     */
    protected <L extends Comparable> void smoothDec(List<L> list) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            insertListDec(list.get(i));
        }
        for (int i = 0; i < n; i++) {
            list.set(i, deleteListMinDec());
        }
    }

    /**
     * {@code smooth} that takes a list of {@link java.lang.Comparable Comparable} objects {@code list},
     * and a {@code SortFunctional<Comparable>} object as parameters.
     * This method performs a smooth sort on the specified portion of the list using
     * the {@code insertList} and {@code deleteListMin} methods while maintaining the ordering based on the {@code mz.SortFunctional} object.
     * <ul>
     *     <li>It iterates over the elements in the range from <i>0</i> to {@code list.size()} (exclusive) of the {@code list}.</li>
     *     <li>Inside the loop, it calls the {@code insertList} method with the current element and the {@code functional} object as arguments.
     *     This inserts the element into a buffer (presumably a binary heap) while maintaining
     *     the ordering based on the {@code SortFunctional} object.</li>
     *     <li>After the first loop, all elements in the specified range have been inserted into the buffer.</li>
     *     <li>It iterates again over the same range of elements from <i>0</i> to {@code n}.</li>
     *     <li>Inside this loop, it assigns the result of calling the {@code deleteListMin} method with
     *     the {@code functional} object to the corresponding element in the {@code list}.
     *     This operation removes the minimum element from the buffer while maintaining the ordering based on
     *     the {@code SortFunctional} object and assigns it to the current index in the {@code list}.</li>
     *     <li>After the second loop, the elements in the specified range of the {@code list}
     *     have been sorted in non-decreasing order based on the {@code functional} object.</li>
     * </ul>
     * {@code smooth} method uses the {@code insertList} and {@code deleteListMin} methods to perform a smooth sort on the given list,
     * resulting in the elements being sorted.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         SmoothHeap#insertList(Comparable, SortFunctional)
     * @see         SmoothHeap#deleteListMin(SortFunctional)
     */
    protected <L extends Comparable> void smooth(List<L> list, SortFunctional<Comparable> functional) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            insertList(list.get(i), functional);
        }
        for (int i = 0; i < n; i++) {
            list.set(i, deleteListMin(functional));
        }
    }

    /**
     * {@code smoothInc}. This method performs a Smooth Heap Sort on a list of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
     * It utilizes the {@code insertListInc} and {@code deleteListMinInc} methods to build a heap from the list elements and then extract
     * the elements from the heap in sorted order.
     * <ul>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list}, as a parameter.</li>
     *     <li>The variable {@code right} is assigned the length of the {@code list}.</li>
     *     <li>The first {@code for} loop iterates over the elements of the {@code list}. For each element, it calls the {@code insertListInc} method
     *     to insert the element into the heap represented by the {@code buffer}.</li>
     *     <li>After the first loop completes, the {@code buffer} contains all the elements from the {@code list} in a heap structure.</li>
     *     <li>The second {@code for} loop iterates over the indices of the {@code list}. For each index {@code i}, it calls
     *     the {@code deleteListMinInc} method to extract the minimum element from the heap and assigns it back to the {@code list.get(i)}.
     *     This effectively sorts the elements of the {@code list} in increasing order.</li>
     *     <li>At the end of the method, the {@code list} will contain the elements sorted in increasing order.</li>
     * </ul>
     * {@code smoothInc} method uses the {@code insertListInc} and {@code deleteListMinInc} methods to perform a smooth sort on the given list,
     * resulting in the elements being sorted in increasing order.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         SmoothHeap#insertListInc(Comparable)
     * @see         SmoothHeap#deleteListMinInc()
     */
    protected <L extends Comparable> void smoothInc(List<L> list, int left, int right) {
        for (int i = left; i < right; i++) {
            insertListInc(list.get(i));
        }
        for (int i = left; i < right; i++) {
            list.set(i, deleteListMinInc());
        }
    }

    /**
     * {@code smoothDec}. This method performs a Smooth Heap Sort on a list of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
     * It utilizes the {@code insertListDec} and {@code deleteListMinDec} methods to build a heap from the list elements and then extract
     * the elements from the heap in sorted order.
     * <ul>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list}, as a parameter.</li>
     *     <li>The variable {@code n} is assigned the length of the {@code list}.</li>
     *     <li>The first {@code for} loop iterates over the elements of the {@code list}. For each element, it calls the {@code insertListDec} method
     *     to insert the element into the heap represented by the {@code buffer}.</li>
     *     <li>After the first loop completes, the {@code buffer} contains all the elements from the {@code list} in a heap structure.</li>
     *     <li>The second {@code for} loop iterates over the indices of the {@code list}. For each index {@code i}, it calls
     *     the {@code deleteListMinDec} method to extract the minimum element from the heap and assigns it back to the {@code list.get(i)}.
     *     This effectively sorts the elements of the {@code list} in increasing order.</li>
     *     <li>At the end of the method, the {@code list} will contain the elements sorted in increasing order.</li>
     * </ul>
     * {@code smoothDec} method uses the {@code insertListDec} and {@code deleteListMinDec} methods to perform a smooth sort on the given list,
     * resulting in the elements being sorted in increasing order.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         SmoothHeap#insertListDec(Comparable)
     * @see         SmoothHeap#deleteListMinDec()
     */
    protected <L extends Comparable> void smoothDec(List<L> list, int left, int right) {
        for (int i = left; i < right; i++) {
            insertListDec(list.get(i));
        }
        for (int i = left; i < right; i++) {
            list.set(i, deleteListMinDec());
        }
    }

    /**
     * {@code smooth} that takes a list of
     * {@link java.lang.Comparable Comparable} objects {@code list}, indices {@code left} and {@code right},
     * and a {@code SortFunctional<Comparable>} object as parameters.
     * This method performs a smooth sort on the specified portion of the list using
     * the {@code insert} and {@code deleteMin} methods while maintaining the ordering based on the {@code mz.SortFunctional} object.
     * <ul>
     *     <li>It iterates over the elements in the range from {@code left} to {@code right} (exclusive) of the {@code list}.</li>
     *     <li>Inside the loop, it calls the {@code insert} method with the current element and the {@code functional} object as arguments.
     *     This inserts the element into a buffer (presumably a binary heap) while maintaining
     *     the ordering based on the {@code SortFunctional} object.</li>
     *     <li>After the first loop, all elements in the specified range have been inserted into the buffer.</li>
     *     <li>It iterates again over the same range of elements from {@code left} to {@code right}.</li>
     *     <li>Inside this loop, it assigns the result of calling the {@code deleteListMin} method with
     *     the {@code functional} object to the corresponding element in the {@code list}.
     *     This operation removes the minimum element from the buffer while maintaining the ordering based on
     *     the {@code SortFunctional} object and assigns it to the current index in the {@code list}.</li>
     *     <li>After the second loop, the elements in the specified range of the {@code list}
     *     have been sorted in non-decreasing order based on the {@code functional} object.</li>
     * </ul>
     * {@code smooth} method uses the {@code insert} and {@code deleteListMin} methods to perform a smooth sort on the given list,
     * resulting in the elements being sorted.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         SmoothHeap#insertList(Comparable, SortFunctional)
     * @see         SmoothHeap#deleteListMin(SortFunctional)
     */
    protected <L extends Comparable> void smooth(List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        for (int i = left; i < right; i++) {
            insertList(list.get(i), functional);
        }
        for (int i = left; i < right; i++) {
            list.set(i, deleteListMin(functional));
        }
    }

    /**
     * {@code insertListInc} that takes a {@link java.lang.Comparable Comparable} object called {@code insert}.
     * This method inserts the {@code insert} element into a buffer list named {@code bufferList} in an incremental manner,
     * maintaining the heap property.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>It sets the {@code insert} element at index {@code size} in the {@code bufferList} and increments {@code size} afterwards.
     *     This effectively inserts the element at the end of the buffer list.</li>
     *     <li>It calls a method named {resizeList} with an argument of {@code (bufferList.size() * 2)}.</li>
     *     <li>It checks if the current size of the buffer list {@code size} is greater than <i>1</i>.
     *     If {@code true}, it enters a while loop that continues as long as the index {@code i} is not equal to <i>0</i>.</li>
     *     <li>Inside the loop, it calculates the index of the parent of the current index {@code (j = (i - 1) / 2)}.</li>
     *     <li>It performs a comparison between the element at index {@code j} and the element at index {@code i} in the buffer list.
     *     If the element at index {@code j} is greater,
     *     it swaps them and updates the value of {@code i} to {@code j}.</li>
     *     <li>If the comparison indicates that the element at index {@code j} is not greater than the element at index {@code i},
     *     it breaks out of the loop.</li>
     * </ul>
     * {@code insertListInc} performs the incremental insertion of an element into a buffer list.
     * It sets the element at the end of the buffer list, resizes the buffer list if necessary,
     * and maintains the heap property by comparing and swapping elements in an upward direction.
     * @param       insert starts by inserting the element.
     * @see         SmoothHeap#resizeList(int)
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void insertListInc(L insert) {
        bufferList.add(size++, insert);
        resizeList(bufferList.size() * 2);
        if (size > 1) {
            int i = (size - 1);
            while (i != 0) {
                int j = ((i - 1) / 2);
                if (bufferList.get(j).compareTo(bufferList.get(i)) > 0) {
                    swap(bufferList, i, j);
                    i = j;
                } else {
                    break;
                }
            }
        }
    }


    /**
     * {@code insertListDec} that takes a {@link java.lang.Comparable Comparable} object called {@code insert}.
     * This method inserts the {@code insert} element into a buffer list named {@code bufferList} in a decremental manner,
     * maintaining the heap property.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>It sets the {@code insert} element at index {@code size} in the {@code bufferList} and decrements {@code size} afterwards.
     *     This effectively inserts the element at the end of the buffer list.</li>
     *     <li>It calls a method named {resizeList} with an argument of {@code (bufferList.size() * 2)}.</li>
     *     <li>It checks if the current size of the buffer list {@code size} is greater than <i>1</i>.
     *     If {@code true}, it enters a while loop that continues as long as the index {@code i} is not equal to <i>0</i>.</li>
     *     <li>Inside the loop, it calculates the index of the parent of the current index {@code (j = (i - 1) / 2)}.</li>
     *     <li>It performs a comparison between the element at index {@code j} and the element at index {@code i} in the buffer list.
     *     If the element at index {@code j} is smaller,
     *     it swaps them and updates the value of {@code i} to {@code j}.</li>
     *     <li>If the comparison indicates that the element at index {@code j} is not smaller than the element at index {@code i},
     *     it breaks out of the loop.</li>
     * </ul>
     * {@code insertListDec} performs the decremental insertion of an element into a buffer list.
     * It sets the element at the end of the buffer list, resizes the buffer list if necessary,
     * and maintains the heap property by comparing and swapping elements in an upward direction.
     * @param       insert starts by inserting the element.
     * @see         SmoothHeap#resizeList(int)
     * @see         SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void insertListDec(L insert) {
        bufferList.add(size++, insert);
        resizeList(bufferList.size() * 2);
        if (size > 1) {
            int i = (size - 1);
            while (i != 0) {
                int j = ((i - 1) / 2);
                if (bufferList.get(j).compareTo(bufferList.get(i)) < 0) {
                    swap(bufferList, i, j);
                    i = j;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * {@code insertList} method that includes a {@code SortFunctional} object called {@code functional}.
     * This object is used for comparing elements in the buffer list during the insertion process.
     * <ul>
     *     <li>It starts similarly to the previous version by setting the
     *     {@code insert} element at index {@code size} in the {@code bufferList} and incrementing {@code size}.</li>
     *     <li>It calls a method named {@code resizeList} with an argument of {@code (bufferList.size() * 2)}.
     *     This method is used to resize the buffer list based on the specified capacity.</li>
     *     <li>It checks if the current size of the buffer list {@code size} is greater than <i>1</i>.
     *     If {@code true}, it enters a {@code while} loop that continues as long as the index {@code i} is not equal to <i>0</i>,
     *     similar to the previous version.</li>
     *     <li>Inside the loop, it calculates the index of the parent of the current index {@code (j = (i - 1) / 2)},
     *     similar to the previous version.</li>
     *     <li>It performs a comparison between the element at index {@code j} and
     *     the element at index {@code i} in the buffer list using the {@code functional} object.
     *     If the comparison indicates that the element at index {@code j} is greater,
     *     it swaps them and updates the value of {@code i} to {@code j}.</li>
     *     <li>If the comparison indicates that the element at index {@code j} is not greater than the element at index {@code i},
     *     it breaks out of the loop.</li>
     * </ul>
     * {@code insertList} performs the insertion of an element into a buffer list using a
     * custom sorting implementation provided through the {@code SortFunctional} object.
     * It sets the element at the end of the buffer list, resizes the buffer list if necessary,
     * and maintains the heap property by comparing and swapping elements
     * in an upward direction using the functional object for comparisons.
     * @param       insert starts by inserting the element.
     * @param       functional lambda expression for comparison.
     * @see         SmoothHeap#resizeList(int)
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         SortSwap#swap(List, int, int)
     */
    protected <L extends Comparable> void insertList(L insert, SortFunctional<Comparable> functional) {
        bufferList.add(size++, insert);
        resizeList(bufferList.size() * 2);
        if (size > 1) {
            int i = (size - 1);
            while (i != 0) {
                int j = ((i - 1) / 2);
                if (functional.functionalCompareTo(bufferList.get(j), bufferList.get(i))) {
                    swap(bufferList, i, j);
                    i = j;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * {@code deleteListMinInc} that performs an incremental deletion of the minimum element from a buffer list named {@code bufferList}.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>It retrieves the minimum element from the buffer list by accessing
     *     the element at index <i>0</i> and assigns it to the {@code result} variable.</li>
     *     <li>It swaps the minimum element with the element at the end of the buffer list.
     *     This is done by calling a {@code swap} method and passing the {@code bufferList}, index <i>0</i>, and the decremented {@code size} as arguments.
     *     The {@code size} variable represents the number of elements in the buffer list before the deletion,
     *     and decrementing it effectively removes the last element from consideration.</li>
     *     <li>It initializes a variable {@code i} with a value of <i>0</i>,
     *     which represents the current index of the element being compared and potentially swapped.</li>
     *     <li>It enters a while loop that continues as long as the left child of the current index {@code ((2 * i) + 1)}
     *     is within the valid range {@code size}.</li>
     *     <li>Inside the loop, it calculates the index of the left child {@code (j = (2 * i) + 1)}.
     *     If the right child is also within the valid range {@code ((j + 1) < size)}
     *     and the right child is smaller than the left child, it increments {@code j} to point to the right child.</li>
     *     <li>It compares the element at index {@code i} with the element at index {@code j}.
     *     If the element at {@code i} is greater than the element at {@code j},
     *     it swaps them and updates the value of {@code i} to {@code j}.</li>
     *     <li>If the element at {@code i} is not greater than the element at {@code j},
     *     it breaks out of the loop.</li>
     *     <li>After the loop completes, it returns the minimum element that was initially stored in the {@code result} variable.</li>
     * </ul>
     * {@code deleteListMinInc} performs an incremental deletion of the minimum element from a buffer list.
     * It swaps the minimum element with the last element, maintains
     * the heap property by comparing and swapping elements in a downward direction, and returns the minimum element.
     * @return      the deleted minimum element stored in the {@code result} variable
     * @see         SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> L deleteListMinInc() {
        L result = (L) bufferList.get(0);
        swap(bufferList, 0, --size);
        int i = 0;
        while (((2 * i) + 1) < size) {
            int j = ((2 * i) + 1);
            if (((j + 1) < size) && (bufferList.get(j).compareTo(bufferList.get(j + 1)) > 0)) {
                j++;
            }
            if (bufferList.get(i).compareTo(bufferList.get(j)) > 0) {
                swap(bufferList, j, i);
                i = j;
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * {@code deleteListMinDec} that performs a decremental deletion of the minimum element from a buffer list named {@code bufferList}.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>It retrieves the minimum element from the buffer list by accessing
     *     the element at index <i>0</i> and assigns it to the {@code result} variable.</li>
     *     <li>It swaps the minimum element with the element at the end of the buffer list.
     *     This is done by calling a {@code swap} method and passing the {@code bufferList}, index <i>0</i>, and the decremented {@code size} as arguments.
     *     The {@code size} variable represents the number of elements in the buffer list before the deletion,
     *     and decrementing it effectively removes the last element from consideration.</li>
     *     <li>It initializes a variable {@code i} with a value of <i>0</i>,
     *     which represents the current index of the element being compared and potentially swapped.</li>
     *     <li>It enters a while loop that continues as long as the left child of the current index {@code ((2 * i) + 1)}
     *     is within the valid range {@code size}.</li>
     *     <li>Inside the loop, it calculates the index of the left child {@code (j = (2 * i) + 1)}.
     *     If the right child is also within the valid range {@code ((j + 1) < size)}
     *     and the right child is smaller than the left child, it increments {@code j} to point to the right child.</li>
     *     <li>It compares the element at index {@code i} with the element at index {@code j}.
     *     If the element at {@code i} is smaller than the element at {@code j},
     *     it swaps them and updates the value of {@code i} to {@code j}.</li>
     *     <li>If the element at {@code i} is not smaller than the element at {@code j},
     *     it breaks out of the loop.</li>
     *     <li>After the loop completes, it returns the minimum element that was initially stored in the {@code result} variable.</li>
     * </ul>
     * {@code deleteListMinDec} performs a decremental deletion of the minimum element from a buffer list.
     * It swaps the minimum element with the last element, maintains
     * the heap property by comparing and swapping elements in a downward direction, and returns the minimum element.
     * @return      the deleted minimum element stored in the {@code result} variable
     * @see         SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> L deleteListMinDec() {
        L result = (L) bufferList.get(0);
        swap(bufferList, 0, --size);
        int i = 0;
        while (((2 * i) + 1) < size) {
            int j = ((2 * i) + 1);
            if (((j + 1) < size) && (bufferList.get(j).compareTo(bufferList.get(j + 1)) < 0)) {
                j++;
            }
            if (bufferList.get(i).compareTo(bufferList.get(j)) < 0) {
                swap(bufferList, j, i);
                i = j;
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * {@code deleteListMin} method that includes a {@code SortFunctional} object called {@code functional}.
     * This object is used for comparing elements in the buffer list during the deletion process.
     * <ul>
     *     <li>It starts similarly to the previous version by retrieving the minimum element from the buffer list
     *     at index <i>0</i> and assigning it to the {@code result} variable.</li>
     *     <li>It swaps the minimum element with the last element in the buffer list, similar to the previous version.</li>
     *     <li>It initializes the variable {@code i} to <i>0</i>, representing the current index of the element being compared.</li>
     *     <li>It enters a while loop that continues as long as the left child of
     *     the current index {@code ((2 * i) + 1)} is within the valid range {@code  size},
     *     similar to the previous version.</li>
     *     <li>Inside the loop, it calculates the index of the left child {@code (j = (2 * i) + 1)}.
     *     If the right child is also within the valid range {@code ((j + 1) < size)} and
     *     the comparison using the {@code functional} object indicates that the right child is smaller,
     *     it increments {@code j} to point to the right child.</li>
     *     <li>It performs the comparison between the element at index {@code i} and the element at index {@code j} using the {@code functional} object.
     *     If the comparison indicates that the element at {@code i} is greater,
     *     it swaps them and updates the value of {@code i} to {@code j}.</li>
     *     <li>If the comparison indicates that the element at {@code i} is not greater than the element at {@code j},
     *     it breaks out of the loop.</li>
     *     <li>After the loop completes, it returns the minimum element that was initially stored in the {@code result} variable.</li>
     * </ul>
     * {@code deleteListMin} performs the deletion of the minimum element from a buffer list using a
     * custom sorting implementation provided through the {@code SortFunctional} object.
     * It swaps the minimum element with the last element, maintains the heap property by comparing
     * and swapping elements in a downward direction using the functional object for comparisons,
     * and returns the minimum element.
     * @param       functional lambda expression for comparison.
     * @return      the deleted minimum element stored in the {@code result} variable
     * @see         SortSwap#swap(List, int, int)
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> L deleteListMin(SortFunctional<Comparable> functional) {
        L result = (L) bufferList.get(0);
        swap(bufferList, 0, --size);
        int i = 0;
        while (((2 * i) + 1) < size) {
            int j = ((2 * i) + 1);
            if (((j + 1) < size) && (functional.functionalCompareTo(bufferList.get(j), bufferList.get(j + 1)))) {
                j++;
            }
            if (functional.functionalCompareTo(bufferList.get(i), bufferList.get(j))) {
                swap(bufferList, j, i);
                i = j;
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * {@code resizeList} that takes an integer parameter called {@code capacity}.
     * This method is used to resize a buffer list named {@code bufferList} based on a specified capacity.
     * <ul>
     *     <li>It checks if the current size of the buffer list {@code size} is equal to half of the specified capacity {@code (capacity / 2)}.</li>
     *     <li>If the condition is {@code true}, it means that the buffer list is half full.
     *     In this case, it creates a new temporary buffer list named {@code newBuffer} and initializes it by calling the
     *     {@code addBetween} method with the {@code bufferList}, <i>0</i>, and {@code size} as arguments.
     *     This creates a sublist containing the elements from index <i>0</i> to the current size of the buffer list.</li>
     *     <li>It clears the original {@code bufferList} using the {@link java.util.List#clear() clear()}
     *     method to remove all elements.</li>
     *     <li>Finally, it adds all the elements from the temporary buffer list {@code newBuffer} back to
     *     the original {@code bufferList} using the {@link java.util.List#add(Object) addAll()} method.
     *     This effectively resizes the buffer list to match the current size.</li>
     * </ul>
     * {@code resizeList} checks if the buffer list is half full {@code (size == capacity / 2)} and,
     * if so, resizes the buffer list by creating a temporary buffer, clearing the original buffer,
     * and adding the elements back from the temporary buffer.
     * @param       capacity the new capacity of the buffer
     * @see         SortList#addBetween(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void resizeList(int capacity) {
        if (size == (capacity / 2)) {
            List<L> newBuffer = (List<L>) addBetween(bufferList, 0, size);
            bufferList.clear();
            bufferList.addAll(newBuffer);
        }
    }
}