package mz;

/**
 * SelectionInterface, containing the methods of Selection Sort to implement other classes.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public interface SelectionInterface<T extends Comparable>
extends Sort<T>, SortSwap<T>, SortFind<T> {

    /**
     * {@code selectionInc} that performs the Selection Sort algorithm on an array of Comparable objects.
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
     * @see         mz.SortFind#findMinimumIndex(Comparable[], int, int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
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
     * {@code selectionDec} that performs the Selection Sort algorithm on an array of Comparable objects.
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
     * @see         mz.SortFind#findMaximumIndex(Comparable[], int, int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
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
     * {@code selectionInc} that performs the Selection Sort algorithm on an array of Comparable objects.
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
     * @see         mz.SortFind#findMinimumIndex(Comparable[], int, int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
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
     * {@code selectionDec} that performs the Selection Sort algorithm on an array of Comparable objects.
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
     * @see         mz.SortFind#findMaximumIndex(Comparable[], int, int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
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
}