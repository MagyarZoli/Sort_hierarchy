package mz;

/**
 * Smooth Heap Sort it is another version of heapsort that is designed to minimize the number of comparisons performed during the sort.
 * Like heapsort, smooth sort sorts an array by building a heap and repeatedly extracting the maximum element.
 * @since       1.2
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class SmoothHeap
extends Heap {

    /**
     * Which is an array of {@link java.lang.Comparable Comparable} objects with an initial size of 256,
     */
    protected Comparable[] buffer = new Comparable[256];

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
     * @see         mz.intro.IntroSmoothHeap#IntroSmoothHeap() IntroSmoothHeap
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
     * @return      selected {@code Sort} class initialized.
     */
    @Override
    public Sort sortThreadClass() {
        return new SmoothHeap();
    }

    /**
     * {@code smoothInc}. This method performs a Smooth Heap Sort on an array of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
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
     * @see         mz.SmoothHeap#insertInc(Comparable)
     * @see         SmoothHeap#deleteMinInc()
     */
    protected void smoothInc(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            insertInc(array[i]);
        }
        for (int i = 0; i < n; i++) {
            array[i] = deleteMinInc();
        }
    }

    /**
     * {@code smoothDec}. This method performs a Smooth Heap Sort on an array of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
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
     * @see         mz.SmoothHeap#insertDec(Comparable)
     * @see         SmoothHeap#deleteMinDec()
     */
    protected void smoothDec(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            insertDec(array[i]);
        }
        for (int i = 0; i < n; i++) {
            array[i] = deleteMinDec();
        }
    }

    /**
     * {@code smooth} that takes an array of {@link java.lang.Comparable Comparable} objects {@code array},
     * and a {@code SortFunctional<Comparable>} object as parameters.
     * This method performs a smooth sort on the specified portion of the array using
     * the {@code insert} and {@code deleteMin} methods while maintaining the ordering based on the {@code SortFunctional} object.
     * <ul>
     *     <li>It iterates over the elements in the range from <i>0</i> to {@code array.length} (exclusive) of the {@code array}.</li>
     *     <li>Inside the loop, it calls the {@code insert} method with the current element and the {@code functional} object as arguments.
     *     This inserts the element into a buffer (presumably a binary heap) while maintaining
     *     the ordering based on the {@code SortFunctional} object.</li>
     *     <li>After the first loop, all elements in the specified range have been inserted into the buffer.</li>
     *     <li>It iterates again over the same range of elements from <i>0</i> to {@code n}.</li>
     *     <li>Inside this loop, it assigns the result of calling the {@code deleteMin} method with
     *     the {@code functional} object to the corresponding element in the {@code array}.
     *     This operation removes the minimum element from the buffer while maintaining the ordering based on
     *     the {@code SortFunctional} object and assigns it to the current index in the {@code array}.</li>
     *     <li>After the second loop, the elements in the specified range of the {@code array}
     *     have been sorted in non-decreasing order based on the {@code functional} object.</li>
     * </ul>
     * {@code smooth} method uses the {@code insert} and {@code deleteMin} methods to perform a smooth sort on the given array,
     * resulting in the elements being sorted.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.SmoothHeap#insert(Comparable, SortFunctional)
     * @see         mz.SmoothHeap#deleteMin(SortFunctional)
     */
    protected void smooth(Comparable[] array, SortFunctional<Comparable> functional) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            insert(array[i], functional);
        }
        for (int i = 0; i < n; i++) {
            array[i] = deleteMin(functional);
        }
    }

    /**
     * {@code smoothInc}. This method performs a Smooth Heap Sort on an array of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
     * It utilizes the {@code insertInc} and {@code deleteMinInc} methods to build a heap from the array elements and then extract
     * the elements from the heap in sorted order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, as a parameter.</li>
     *     <li>The variable {@code right} is assigned the length of the {@code array}.</li>
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
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.SmoothHeap#insertInc(Comparable)
     * @see         SmoothHeap#deleteMinInc()
     */
    protected void smoothInc(Comparable[] array, int left, int right) {
        for (int i = left; i < right; i++) {
            insertInc(array[i]);
        }
        for (int i = left; i < right; i++) {
            array[i] = deleteMinInc();
        }
    }

    /**
     * {@code smoothDec}. This method performs a Smooth Heap Sort on an array of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
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
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.SmoothHeap#insertDec(Comparable)
     * @see         SmoothHeap#deleteMinDec()
     */
    protected void smoothDec(Comparable[] array, int left, int right) {
        for (int i = left; i < right; i++) {
            insertDec(array[i]);
        }
        for (int i = left; i < right; i++) {
            array[i] = deleteMinDec();
        }
    }

    /**
     * {@code smooth} that takes an array of {@link java.lang.Comparable Comparable}
     * objects {@code array}, indices {@code left} and {@code right},
     * and a {@code SortFunctional<Comparable>} object as parameters.
     * This method performs a smooth sort on the specified portion of the array using
     * the {@code insert} and {@code deleteMin} methods while maintaining the ordering based on the {@code SortFunctional} object.
     * <ul>
     *     <li>It iterates over the elements in the range from {@code left} to {@code right} (exclusive) of the {@code array}.</li>
     *     <li>Inside the loop, it calls the {@code insert} method with the current element and the {@code functional} object as arguments.
     *     This inserts the element into a buffer (presumably a binary heap) while maintaining
     *     the ordering based on the {@code SortFunctional} object.</li>
     *     <li>After the first loop, all elements in the specified range have been inserted into the buffer.</li>
     *     <li>It iterates again over the same range of elements from {@code left} to {@code right}.</li>
     *     <li>Inside this loop, it assigns the result of calling the {@code deleteMin} method with
     *     the {@code functional} object to the corresponding element in the {@code array}.
     *     This operation removes the minimum element from the buffer while maintaining the ordering based on
     *     the {@code SortFunctional} object and assigns it to the current index in the {@code array}.</li>
     *     <li>After the second loop, the elements in the specified range of the {@code array}
     *     have been sorted in non-decreasing order based on the {@code functional} object.</li>
     * </ul>
     * {@code smooth} method uses the {@code insert} and {@code deleteMin} methods to perform a smooth sort on the given array,
     * resulting in the elements being sorted.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         mz.SmoothHeap#insert(Comparable, SortFunctional)
     * @see         mz.SmoothHeap#deleteMin(SortFunctional)
     */
    protected void smooth(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        for (int i = left; i < right; i++) {
            insert(array[i], functional);
        }
        for (int i = left; i < right; i++) {
            array[i] = deleteMin(functional);
        }
    }

    /**
     * {@code insertInc} this method is likely a part of a heap-related algorithm or data structure implementation
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
     * {@code insertInc} method adds a new element to a heap structure stored in
     * the {@code buffer} array and ensures that the heap property is maintained after the insertion.
     * It achieves this by adding the element to the end of the heap, resizing the buffer if necessary,
     * and iteratively comparing and swapping elements with their parents to restore the heap property.
     * @param       insert starts by inserting the element.
     * @see         mz.SmoothHeap#resize(int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void insertInc(Comparable insert) {
        buffer[size++] = insert;
        resize(buffer.length * 2);
        if (size > 1) {
            int i = (size - 1);
            while (i != 0) {
                int j = ((i - 1) / 2);
                if (buffer[j].compareTo(buffer[i]) > 0) {
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
     * {@code insertDec} method adds a new element to a heap structure stored in
     * the {@code buffer} array and ensures that the heap property is maintained after the insertion.
     * It achieves this by adding the element to the end of the heap, resizing the buffer if necessary,
     * and iteratively comparing and swapping elements with their parents to restore the heap property.
     * @param       insert starts by inserting the element.
     * @see         mz.SmoothHeap#resize(int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void insertDec(Comparable insert) {
        buffer[size++] = insert;
        resize(buffer.length * 2);
        if (size > 1) {
            int i = (size - 1);
            while (i != 0) {
                int j = ((i - 1) / 2);
                if (buffer[j].compareTo(buffer[i]) < 0) {
                    swap(buffer, i, j);
                    i = j;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * {@code insert} that takes a {@link java.lang.Comparable Comparable} object insert
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
     *     the buffer while maintaining the ordering based on the {@code SortFunctional} object.</li>
     * </ul>
     * {@code insert} method adds a new element to a heap structure stored in
     * the {@code buffer} array and ensures that the heap property is maintained after the insertion.
     * It achieves this by adding the element to the end of the heap, resizing the buffer if necessary,
     * and iteratively comparing and swapping elements with their parents to restore the heap property.
     * @param       insert starts by inserting the element.
     * @param       functional lambda expression for comparison.
     * @see         mz.SmoothHeap#resize(int)
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     *
     */
    protected void insert(Comparable insert, SortFunctional<Comparable> functional) {
        buffer[size++] = insert;
        resize(buffer.length * 2);
        if (size > 1) {
            int i = (size - 1);
            while (i != 0) {
                int j = ((i - 1) / 2);
                if (functional.functionalCompareTo(buffer[j], buffer[i])) {
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
     * {@code deleteMinInc} method deletes the minimum element from a heap structure stored in the {@code buffer} array and ensures that
     * the heap property is maintained after the deletion.
     * It achieves this by swapping the minimum element with the last element, adjusting the size of the heap,
     * and iteratively comparing and swapping elements to restore the heap property.
     * @return      the deleted minimum element stored in the {@code result} variable
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected Comparable deleteMinInc() {
        Comparable result = buffer[0];
        swap(buffer, 0, --size);
        int i = 0;
        while (((2 * i) + 1) < size) {
            int j = ((2 * i) + 1);
            if (((j + 1) < size) && (buffer[j].compareTo(buffer[(j + 1)]) > 0)) {
                j++;
            }
            if (buffer[i].compareTo(buffer[j]) > 0) {
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
     * {@code deleteMinDec} method deletes the minimum element from a heap structure stored in the {@code buffer} array and ensures that
     * the heap property is maintained after the deletion.
     * It achieves this by swapping the minimum element with the last element, adjusting the size of the heap,
     * and iteratively comparing and swapping elements to restore the heap property.
     * @return      the deleted minimum element stored in the {@code result} variable
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected Comparable deleteMinDec() {
        Comparable result = buffer[0];
        swap(buffer, 0, --size);
        int i = 0;
        while (((2 * i) + 1) < size) {
            int j = ((2 * i) + 1);
            if (((j + 1) < size) && (buffer[j].compareTo(buffer[(j + 1)]) < 0)) {
                j++;
            }
            if (buffer[i].compareTo(buffer[j]) < 0) {
                swap(buffer, j, i);
                i = j;
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * {@code deleteMin} that takes a {@code SortFunctional<Comparable>} object as a parameter.
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
     * {@code deleteMin} method deletes the minimum element from a heap structure stored in the {@code buffer} array and ensures that
     * the heap property is maintained after the deletion.
     * It achieves this by swapping the minimum element with the last element, adjusting the size of the heap,
     * and iteratively comparing and swapping elements to restore the heap property.
     * @param       functional lambda expression for comparison.
     * @return      the deleted minimum element stored in the {@code result} variable
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    protected Comparable deleteMin(SortFunctional<Comparable> functional) {
        Comparable result = buffer[0];
        swap(buffer, 0, --size);
        int i = 0;
        while (((2 * i) + 1) < size) {
            int j = ((2 * i) + 1);
            if (((j + 1) < size) && (functional.functionalCompareTo(buffer[j], buffer[(j + 1)]))) {
                j++;
            }
            if (functional.functionalCompareTo(buffer[i], buffer[j])) {
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
     *     <li>The {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy} method is then used to copy the existing elements from the current buffer {@code (buffer)}
     *     to the newly created buffer {@code (newBuffer)}, up to the current {@code size}.</li>
     *     <li>Finally, the reference to the new buffer is assigned to the {@code buffer} variable,
     *     effectively resizing the buffer to the specified capacity.</li>
     * </ul>
     * {@code resize} method ensures that the buffer is resized when the number of elements stored in it reaches half of its capacity.
     * It creates a new buffer with the desired capacity and copies the existing elements from the old buffer to the new buffer.
     * @param       capacity the new capacity of the buffer
     */
    protected void resize(int capacity) {
        if (size == (capacity / 2)) {
            Comparable[] newBuffer = new Comparable[capacity];
            System.arraycopy(buffer, 0, newBuffer, 0, size);
            buffer = newBuffer;
        }
    }
}