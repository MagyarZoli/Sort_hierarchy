package github.magyarzoli;

import java.util.List;

/**
 * SelectionInterface, containing the methods of Selection Sort to implement other classes.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public interface SelectionInterface<T extends Comparable>
extends Sorter<T>, SortSwap<T>, SortFind<T> {

    /**
     * {@code selectionInc} that performs the Selection Sort algorithm on an array of {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and performs the Selection Sort algorithm on it.</li>
     *     <li>The method starts by defining the length of the {@code array} as {@code n}.</li>
     *     <li>The outer loop runs from 0 to {@code (n - 1)} and represents the current position of the sorted portion of the array.</li>
     *     <li>Inside the outer loop, an integer variable {@code index} is initialized with the value of {@code i}.
     *     This {@code index} represents the index of the minimum element in the unsorted portion of the array.</li>
     *     <li>The inner loop runs from {@code (i + 1)} to {@code (n - 1)} and iterates over the remaining unsorted portion of the array.</li>
     *     <li>Inside the inner loop, the {@code minIndex} method is called to find the index of the minimum element between
     *     the current index {@code j} and the current minimum {@code index} index.</li>
     *     <li>After the inner loop completes, the minimum element in the unsorted portion of the array is found, and its index is stored in {@code index}.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code index} and {@code i}.
     *     This places the minimum element in its correct sorted position.</li>
     *     <li>The process repeats until the entire array is sorted.</li>
     * </ul>
     * {@code selectionInc} method implements the Selection Sort algorithm to sort the given {@code array} of Comparable objects in ascending order.
     * It iterates through the array, finds the minimum element in the unsorted portion,
     * and swaps it with the element at the current position in the sorted portion.
     * This process is repeated until the array is fully sorted.
     * @param       array to be arranged.
     * @see         SortFind#findMinimumIndex(Comparable[], int, int)
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    default void selectionInc(T[] array) {
        int n = array.length;
        for (int i = 0; i < (n - 1); i++) {
            int index = i;
            for (int j = (i + 1) ; j < n; j++) {
                index = findMinimumIndex(array, j, index);
            }
            swap(array, index, i);
        }
    }

    /**
     * {@code selectionDec} that performs the Selection Sort algorithm on an array of {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and performs the Selection Sort algorithm on it.</li>
     *     <li>The method starts by defining the length of the {@code array} as {@code n}.</li>
     *     <li>The outer loop runs from 0 to {@code (n - 1)} and represents the current position of the sorted portion of the array.</li>
     *     <li>Inside the outer loop, an integer variable {@code index} is initialized with the value of {@code i}.
     *     This {@code index} represents the index of the maximum element in the unsorted portion of the array.</li>
     *     <li>The inner loop runs from {@code (i + 1)} to {@code (n - 1)} and iterates over the remaining unsorted portion of the array.</li>
     *     <li>Inside the inner loop, the {@code maxIndex} method is called to find the index of the maximum element between
     *     the current index {@code j} and the current maximum {@code index} index.</li>
     *     <li>After the inner loop completes, the maximum element in the unsorted portion of the array is found, and its index is stored in {@code index}.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code index} and {@code i}.
     *     This places the maximum element in its correct sorted position.</li>
     *     <li>The process repeats until the entire array is sorted.</li>
     * </ul>
     * {@code selectionDec} method implements the Selection Sort algorithm to sort the given {@code array} of Comparable objects in descending order.
     * It iterates through the array, finds the maximum element in the unsorted portion,
     * and swaps it with the element at the current position in the sorted portion.
     * This process is repeated until the array is fully sorted.
     * @param       array to be arranged.
     * @see         SortFind#findMaximumIndex(Comparable[], int, int)
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    default void selectionDec(T[] array) {
        int n = array.length;
        for (int i = 0; i < (n - 1); i++) {
            int index = i;
            for (int j = (i + 1) ; j < n; j++) {
                index = findMaximumIndex(array, j, index);
            }
            swap(array, index, i);
        }
    }

    /**
     * {@code selection} method takes an array {@code array} of type {@code T} and an instance of {@code mz.SortFunctional<T>} as parameters.
     * <ul>
     *     <li>It starts by assigning the length of the {@code array} to the variable {@code n}.</li>
     *     <li>It initializes a {@code for} loop that iterates from {@code i = 0} to {@code (n - 1)}.
     *     This loop represents the pass for selecting the minimum element in each iteration.</li>
     *     <li>Within the outer loop, it declares a variable {@code index} and initializes it with the value of {@code i}.
     *     This variable will keep track of the index of the minimum element found.</li>
     *     <li>It enters an inner for loop that starts from {@code (i + 1)} and iterates until {@code (j < n)}.
     *     This loop is responsible for finding the index of the minimum element starting from {@code j}.</li>
     *     <li>Within the inner loop, it calls the {@code findValueIndex} method, passing the
     *     {@code array}, {@code j}, {@code index}, and {@code functional} as parameters.
     *     This method compares elements using the {@code functional} instance and returns the index of
     *     the element that is considered greater according to the comparison logic.</li>
     *     <li>The value of {@code index} is updated with the returned index from the {@code findValueIndex} method.</li>
     *     <li>After the inner loop completes, it calls the {@code swap} method to swap the element at
     *     the {@code index} index with the element at the index {@code i}.
     *     This places the minimum element in its correct sorted position.</li>
     *     <li>The outer loop continues until all elements have been sorted in ascending order.</li>
     * </ul>
     * {@code selection} this method is to perform selection sort on the {@code array} using the comparison logic defined by the {@code mz.SortFunctional} instance.
     * It iterates through the array and selects the minimum element in each iteration, swapping it with the current position.
     * This process continues until the array is sorted in ascending order.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         SortFind#findValueIndex(Comparable[], int, int, SortFunctional)
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    default void selection(T[] array, SortFunctional<T> functional) {
        int n = array.length;
        for (int i = 0; i < (n - 1); i++) {
            int index = i;
            for (int j = (i + 1) ; j < n; j++) {
                index = findValueIndex(array, j, index, functional);
            }
            swap(array, index, i);
        }
    }

    /**
     * {@code selectionInc} that performs the Selection Sort algorithm on an array of {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and performs the Selection Sort algorithm on it.</li>
     *     <li>The method starts the {@code left} of the {@code array} as {@code right}.</li>
     *     <li>The outer loop runs from {@code left} to {@code (right - 1)} and represents the current position of the sorted portion of the array.</li>
     *     <li>Inside the outer loop, an integer variable {@code index} is initialized with the value of {@code i}.
     *     This {@code index} represents the index of the minimum element in the unsorted portion of the array.</li>
     *     <li>The inner loop runs from {@code (i + 1)} to {@code (right - 1)} and iterates over the remaining unsorted portion of the array.</li>
     *     <li>Inside the inner loop, the {@code minIndex} method is called to find the index of the minimum element between
     *     the current index {@code j} and the current minimum {@code index} index.</li>
     *     <li>After the inner loop completes, the minimum element in the unsorted portion of the array is found, and its index is stored in {@code index}.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code index} and {@code i}.
     *     This places the minimum element in its correct sorted position.</li>
     *     <li>The process repeats until the entire array is sorted.</li>
     * </ul>
     * {@code selectionInc} method implements the Selection Sort algorithm to sort the given {@code array} of Comparable objects in ascending order.
     * It iterates through the array, finds the minimum element in the unsorted portion,
     * and swaps it with the element at the current position in the sorted portion.
     * This process is repeated until the array is fully sorted.
     * @param       array to be arranged.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @see         SortFind#findMinimumIndex(Comparable[], int, int)
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    default void selectionInc(T[] array, int left, int right) {
        for (int i = left; i < (right - 1); i++) {
            int index = i;
            for (int j = (i + 1) ; j < right; j++) {
                index = findMinimumIndex(array, j, index);
            }
            swap(array, index, i);
        }
    }

    /**
     * {@code selectionDec} that performs the Selection Sort algorithm on an array of {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and performs the Selection Sort algorithm on it.</li>
     *     <li>The method starts the {@code left} of the {@code array} as {@code right}.</li>
     *     <li>The outer loop runs from {@code left} to {@code (right - 1)} and represents the current position of the sorted portion of the array.</li>
     *     <li>Inside the outer loop, an integer variable {@code index} is initialized with the value of {@code i}.
     *     This {@code index} represents the index of the maximum element in the unsorted portion of the array.</li>
     *     <li>The inner loop runs from {@code (i + 1)} to {@code (right - 1)} and iterates over the remaining unsorted portion of the array.</li>
     *     <li>Inside the inner loop, the {@code maxIndex} method is called to find the index of the maximum element between
     *     the current index {@code j} and the current maximum {@code index} index.</li>
     *     <li>After the inner loop completes, the maximum element in the unsorted portion of the array is found, and its index is stored in {@code index}.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code index} and {@code i}.
     *     This places the maximum element in its correct sorted position.</li>
     *     <li>The process repeats until the entire array is sorted.</li>
     * </ul>
     * {@code selectionDec} method implements the Selection Sort algorithm to sort the given {@code array} of Comparable objects in descending order.
     * It iterates through the array, finds the maximum element in the unsorted portion,
     * and swaps it with the element at the current position in the sorted portion.
     * This process is repeated until the array is fully sorted.
     * @param       array to be arranged.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @see         SortFind#findMaximumIndex(Comparable[], int, int)
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    default void selectionDec(T[] array, int left, int right) {
        for (int i = left; i < (right - 1); i++) {
            int index = i;
            for (int j = (i + 1) ; j < right; j++) {
                index = findMaximumIndex(array, j, index);
            }
            swap(array, index, i);
        }
    }

    /**
     * {@code selection} method takes an array {@code array} of type {@code T}, two integer parameters {@code left} and {@code right},
     * and an instance of {@code mz.SortFunctional<T>} as parameters.
     * <ul>
     *     <li>It starts by initializing a {@code for} loop that iterates from {@code i = left} to {@code (right - 1)}.
     *     This loop represents the pass for selecting the minimum element in each iteration within the specified range of indices.</li>
     *     <li>Within the outer loop, it declares a variable {@code index} and initializes it with the value of {@code i}.
     *     This variable will keep track of the index of the minimum element found within the specified range.</li>
     *     <li>It enters an inner {@code for} loop that starts from {@code (i + 1)} and iterates until {@code (j < right)}.
     *     This loop is responsible for finding the index of the minimum element within the specified range starting from {@code j}.</li>
     *     <li>Within the inner loop, it calls the {@code findValueIndex} method,
     *     passing the {@code array}, {@code j}, {@code index}, and {@code functional} as parameters.
     *     This method compares elements using the {@code functional} instance and returns the index of
     *     the element that is considered greater according to the comparison logic, within the specified range.</li>
     *     <li>The value of {@code index} is updated with the returned index from the {@code findValueIndex} method.</li>
     *     <li>After the inner loop completes, it calls the {@code swap} method to swap the element at
     *     the index {@code index} with the element at the index {@code i} within the specified range.
     *     This places the minimum element in its correct sorted position within the range.</li>
     *     <li>The outer loop continues until all elements within the specified range have been sorted in ascending order.</li>
     * </ul>
     * {@code selection} this method is to perform selection sort on a specified range of 
     * the {@code array} using the comparison logic defined by the {@code mz.SortFunctional} instance.
     * It iterates through the specified range of the array and selects the minimum element in each iteration,
     * swapping it with the current position within the range. 
     * This process continues until the elements within the range are sorted in ascending order.
     * @param       array to be arranged.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         SortFind#findValueIndex(Comparable[], int, int, SortFunctional)
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    default void selection(T[] array, int left, int right, SortFunctional<T> functional) {
        for (int i = left; i < (right - 1); i++) {
            int index = i;
            for (int j = (i + 1) ; j < right; j++) {
                index = findValueIndex(array, j, index, functional);
            }
            swap(array, index, i);
        }
    }

    /**
     * {@code selectionInc} that performs the Selection Sort algorithm on a list of {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an list of Comparable objects, {@code list}, and performs the Selection Sort algorithm on it.</li>
     *     <li>The method starts by defining the length of the {@code list} as {@code n}.</li>
     *     <li>The outer loop runs from 0 to {@code (n - 1)} and represents the current position of the sorted portion of the list.</li>
     *     <li>Inside the outer loop, an integer variable {@code index} is initialized with the value of {@code i}.
     *     This {@code index} represents the index of the minimum element in the unsorted portion of the list.</li>
     *     <li>The inner loop runs from {@code (i + 1)} to {@code (n - 1)} and iterates over the remaining unsorted portion of the list.</li>
     *     <li>Inside the inner loop, the {@code minIndex} method is called to find the index of the minimum element between
     *     the current index {@code j} and the current minimum {@code index} index.</li>
     *     <li>After the inner loop completes, the minimum element in the unsorted portion of the list is found, and its index is stored in {@code index}.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code index} and {@code i}.
     *     This places the minimum element in its correct sorted position.</li>
     *     <li>The process repeats until the entire list is sorted.</li>
     * </ul>
     * {@code selectionInc} method implements the Selection Sort algorithm to sort the given {@code list} of Comparable objects in ascending order.
     * It iterates through the list, finds the minimum element in the unsorted portion,
     * and swaps it with the element at the current position in the sorted portion.
     * This process is repeated until the list is fully sorted.
     * @param       list to be arranged.
     * @see         SortFind#findMinimumIndex(List, int, int)
     * @see         SortSwap#swap(List, int, int)
     */
    default <L extends T> void selectionInc(List<L> list) {
        int n = list.size();
        for (int i = 0; i < (n - 1); i++) {
            int index = i;
            for (int j = (i + 1) ; j < n; j++) {
                index = findMinimumIndex(list, j, index);
            }
            swap(list, index, i);
        }
    }

    /**
     * {@code selectionDec} that performs the Selection Sort algorithm on an list of {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an list of Comparable objects, {@code list}, and performs the Selection Sort algorithm on it.</li>
     *     <li>The method starts by defining the length of the {@code list} as {@code n}.</li>
     *     <li>The outer loop runs from 0 to {@code (n - 1)} and represents the current position of the sorted portion of the list.</li>
     *     <li>Inside the outer loop, an integer variable {@code index} is initialized with the value of {@code i}.
     *     This {@code index} represents the index of the maximum element in the unsorted portion of the list.</li>
     *     <li>The inner loop runs from {@code (i + 1)} to {@code (n - 1)} and iterates over the remaining unsorted portion of the list.</li>
     *     <li>Inside the inner loop, the {@code maxIndex} method is called to find the index of the maximum element between
     *     the current index {@code j} and the current maximum {@code index} index.</li>
     *     <li>After the inner loop completes, the maximum element in the unsorted portion of the list is found, and its index is stored in {@code index}.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code index} and {@code i}.
     *     This places the maximum element in its correct sorted position.</li>
     *     <li>The process repeats until the entire list is sorted.</li>
     * </ul>
     * {@code selectionDec} method implements the Selection Sort algorithm to sort the given {@code list} of Comparable objects in descending order.
     * It iterates through the list, finds the maximum element in the unsorted portion,
     * and swaps it with the element at the current position in the sorted portion.
     * This process is repeated until the list is fully sorted.
     * @param       list to be arranged.
     * @see         SortFind#findMaximumIndex(List, int, int)
     * @see         SortSwap#swap(List, int, int)
     */
    default <L extends T> void selectionDec(List<L> list) {
        int n = list.size();
        for (int i = 0; i < (n - 1); i++) {
            int index = i;
            for (int j = (i + 1) ; j < n; j++) {
                index = findMaximumIndex(list, j, index);
            }
            swap(list, index, i);
        }
    }

    /**
     * {@code selection} method takes an list {@code list} of type {@code T} and an instance of {@code mz.SortFunctional<T>} as parameters.
     * <ul>
     *     <li>It starts by assigning the length of the {@code list} to the variable {@code n}.</li>
     *     <li>It initializes a {@code for} loop that iterates from {@code i = 0} to {@code (n - 1)}.
     *     This loop represents the pass for selecting the minimum element in each iteration.</li>
     *     <li>Within the outer loop, it declares a variable {@code index} and initializes it with the value of {@code i}.
     *     This variable will keep track of the index of the minimum element found.</li>
     *     <li>It enters an inner for loop that starts from {@code (i + 1)} and iterates until {@code (j < n)}.
     *     This loop is responsible for finding the index of the minimum element starting from {@code j}.</li>
     *     <li>Within the inner loop, it calls the {@code findValueIndex} method, passing the
     *     {@code list}, {@code j}, {@code index}, and {@code functional} as parameters.
     *     This method compares elements using the {@code functional} instance and returns the index of
     *     the element that is considered greater according to the comparison logic.</li>
     *     <li>The value of {@code index} is updated with the returned index from the {@code findValueIndex} method.</li>
     *     <li>After the inner loop completes, it calls the {@code swap} method to swap the element at
     *     the {@code index} index with the element at the index {@code i}.
     *     This places the minimum element in its correct sorted position.</li>
     *     <li>The outer loop continues until all elements have been sorted in ascending order.</li>
     * </ul>
     * {@code selection} this method is to perform selection sort on the {@code list} using the comparison logic defined by the {@code mz.SortFunctional} instance.
     * It iterates through the list and selects the minimum element in each iteration, swapping it with the current position.
     * This process continues until the list is sorted in ascending order.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         SortFind#findValueIndex(List, int, int, SortFunctional)
     * @see         SortSwap#swap(List, int, int)
     */
    default <L extends T> void selection(List<L> list, SortFunctional<T> functional) {
        int n = list.size();
        for (int i = 0; i < (n - 1); i++) {
            int index = i;
            for (int j = (i + 1) ; j < n; j++) {
                index = findValueIndex(list, j, index, functional);
            }
            swap(list, index, i);
        }
    }

    /**
     * {@code selectionInc} that performs the Selection Sort algorithm on an list of {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an list of Comparable objects, {@code list}, and performs the Selection Sort algorithm on it.</li>
     *     <li>The method starts the {@code left} of the {@code list} as {@code right}.</li>
     *     <li>The outer loop runs from {@code left} to {@code (right - 1)} and represents the current position of the sorted portion of the list.</li>
     *     <li>Inside the outer loop, an integer variable {@code index} is initialized with the value of {@code i}.
     *     This {@code index} represents the index of the minimum element in the unsorted portion of the list.</li>
     *     <li>The inner loop runs from {@code (i + 1)} to {@code (right - 1)} and iterates over the remaining unsorted portion of the list.</li>
     *     <li>Inside the inner loop, the {@code minIndex} method is called to find the index of the minimum element between
     *     the current index {@code j} and the current minimum {@code index} index.</li>
     *     <li>After the inner loop completes, the minimum element in the unsorted portion of the list is found, and its index is stored in {@code index}.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code index} and {@code i}.
     *     This places the minimum element in its correct sorted position.</li>
     *     <li>The process repeats until the entire list is sorted.</li>
     * </ul>
     * {@code selectionInc} method implements the Selection Sort algorithm to sort the given {@code list} of Comparable objects in ascending order.
     * It iterates through the list, finds the minimum element in the unsorted portion,
     * and swaps it with the element at the current position in the sorted portion.
     * This process is repeated until the list is fully sorted.
     * @param       list to be arranged.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @see         SortFind#findMinimumIndex(List, int, int)
     * @see         SortSwap#swap(List, int, int)
     */
    default <L extends T> void selectionInc(List<L> list, int left, int right) {
        for (int i = left; i < (right - 1); i++) {
            int index = i;
            for (int j = (i + 1) ; j < right; j++) {
                index = findMinimumIndex(list, j, index);
            }
            swap(list, index, i);
        }
    }

    /**
     * {@code selectionDec} that performs the Selection Sort algorithm on an list of {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an list of Comparable objects, {@code list}, and performs the Selection Sort algorithm on it.</li>
     *     <li>The method starts the {@code left} of the {@code list} as {@code right}.</li>
     *     <li>The outer loop runs from {@code left} to {@code (right - 1)} and represents the current position of the sorted portion of the list.</li>
     *     <li>Inside the outer loop, an integer variable {@code index} is initialized with the value of {@code i}.
     *     This {@code index} represents the index of the maximum element in the unsorted portion of the list.</li>
     *     <li>The inner loop runs from {@code (i + 1)} to {@code (right - 1)} and iterates over the remaining unsorted portion of the list.</li>
     *     <li>Inside the inner loop, the {@code maxIndex} method is called to find the index of the maximum element between
     *     the current index {@code j} and the current maximum {@code index} index.</li>
     *     <li>After the inner loop completes, the maximum element in the unsorted portion of the list is found, and its index is stored in {@code index}.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code index} and {@code i}.
     *     This places the maximum element in its correct sorted position.</li>
     *     <li>The process repeats until the entire list is sorted.</li>
     * </ul>
     * {@code selectionDec} method implements the Selection Sort algorithm to sort the given {@code list} of Comparable objects in descending order.
     * It iterates through the list, finds the maximum element in the unsorted portion,
     * and swaps it with the element at the current position in the sorted portion.
     * This process is repeated until the list is fully sorted.
     * @param       list to be arranged.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @see         SortFind#findMaximumIndex(List, int, int)
     * @see         SortSwap#swap(List, int, int)
     */
    default <L extends T> void selectionDec(List<L> list, int left, int right) {
        for (int i = left; i < (right - 1); i++) {
            int index = i;
            for (int j = (i + 1) ; j < right; j++) {
                index = findMaximumIndex(list, j, index);
            }
            swap(list, index, i);
        }
    }

    /**
     * {@code selection} method takes an list {@code list} of type {@code T}, two integer parameters {@code left} and {@code right},
     * and an instance of {@code mz.SortFunctional<T>} as parameters.
     * <ul>
     *     <li>It starts by initializing a {@code for} loop that iterates from {@code i = left} to {@code (right - 1)}.
     *     This loop represents the pass for selecting the minimum element in each iteration within the specified range of indices.</li>
     *     <li>Within the outer loop, it declares a variable {@code index} and initializes it with the value of {@code i}.
     *     This variable will keep track of the index of the minimum element found within the specified range.</li>
     *     <li>It enters an inner {@code for} loop that starts from {@code (i + 1)} and iterates until {@code (j < right)}.
     *     This loop is responsible for finding the index of the minimum element within the specified range starting from {@code j}.</li>
     *     <li>Within the inner loop, it calls the {@code findValueIndex} method,
     *     passing the {@code list}, {@code j}, {@code index}, and {@code functional} as parameters.
     *     This method compares elements using the {@code functional} instance and returns the index of
     *     the element that is considered greater according to the comparison logic, within the specified range.</li>
     *     <li>The value of {@code index} is updated with the returned index from the {@code findValueIndex} method.</li>
     *     <li>After the inner loop completes, it calls the {@code swap} method to swap the element at
     *     the index {@code index} with the element at the index {@code i} within the specified range.
     *     This places the minimum element in its correct sorted position within the range.</li>
     *     <li>The outer loop continues until all elements within the specified range have been sorted in ascending order.</li>
     * </ul>
     * {@code selection} this method is to perform selection sort on a specified range of
     * the {@code list} using the comparison logic defined by the {@code mz.SortFunctional} instance.
     * It iterates through the specified range of the list and selects the minimum element in each iteration,
     * swapping it with the current position within the range.
     * This process continues until the elements within the range are sorted in ascending order.
     * @param       list to be arranged.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         SortFind#findValueIndex(List, int, int, SortFunctional)
     * @see         SortSwap#swap(List, int, int)
     */
    default <L extends T> void selection(List<L> list, int left, int right, SortFunctional<T> functional) {
        for (int i = left; i < (right - 1); i++) {
            int index = i;
            for (int j = (i + 1) ; j < right; j++) {
                index = findValueIndex(list, j, index, functional);
            }
            swap(list, index, i);
        }
    }
}