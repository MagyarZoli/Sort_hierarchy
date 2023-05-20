package mz;

/**
 * Selection Sort is a simple sorting algorithm that works by dividing an array into two parts:
 * a sorted portion and an unsorted portion. The algorithm repeatedly selects the smallest (or largest)
 * element from the unsorted portion and swaps it with the element at the beginning of the unsorted portion,
 * thereby expanding the sorted portion. This process continues until the entire array becomes sorted.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class Selection
extends SortComparable
implements SortSwap<Comparable> {

    /**
     * <b>Selection Sort:</b><br>
     * Selection Sort is a simple sorting algorithm that works by dividing an array into two parts:
     * a sorted portion and an unsorted portion. The algorithm repeatedly selects the smallest (or largest)
     * element from the unsorted portion and swaps it with the element at the beginning of the unsorted portion,
     * thereby expanding the sorted portion. This process continues until the entire array becomes sorted.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Find the minimum (or maximum) element in the unsorted portion of the array.</li>
     *     <li>Swap the minimum (or maximum) element with the first element of the unsorted portion.</li>
     *     <li>Expand the sorted portion by moving the boundary one position to the right.</li>
     *     <li>Repeat steps 2-4 until the entire array is sorted.</li>
     * </ol>
     * <b>Note:</b><br>
     * Selection Sort is called "selection" because it repeatedly selects the smallest (or largest) element and places
     * it in its correct position. The algorithm requires n-1 passes for an array of size n to sort it completely.
     * Selection Sort has a time complexity of <em>O(n^2)</em> in the average and worst cases, making it inefficient for large datasets.
     * However, it has the advantage of simplicity and requires only a constant amount of additional space.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n^2)</em><br>
     * Average Case Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>No</b>
     */
    public Selection() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         mz.Selection#sortArrayInc(Comparable[])
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        selectionInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         mz.Selection#sortArrayDec(Comparable[])
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        selectionDec(array);
    }

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
     */
    void selectionInc(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < (n - 1); i++) {
            int index = i;
            for (int j = (i + 1) ; j < n; j++) {
                index = minIndex(array, j, index);
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
     */
    void selectionDec(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < (n - 1); i++) {
            int index = i;
            for (int j = (i + 1) ; j < n; j++) {
                index = maxIndex(array, j, index);
            }
            swap(array, index, i);
        }
    }

    /**
     * {@code minIndex} that finds the index of the minimum element in a portion of an array of Comparable objects.
     * <ul>
     *     <li>The method takes in an {@code array} of Comparable objects, array, an integer {@code j} representing the current index,
     *     and an integer {@code index} representing the current index of the minimum element.</li>
     *     <li>The method compares the element at index {@code j} with the element at index {@code index} using the {@code compareTo} method.</li>
     *     <li>If the element at index {@code j} is smaller than the element at index {@code index}, the {@code if} condition evaluates to true,
     *     and the value of {@code index} is updated to {@code j}.</li>
     *     <li>The updated value of {@code index} is then returned.</li>
     * </ul>
     * {@code minIndex} method compares the element at index {@code j} with the current minimum element represented by {@code index} in
     * the given {@code array} of Comparable objects. It updates and returns the index of the minimum element if the element at index {@code j} is smaller.
     * @param       array to be arranged.
     * @param       j an integer representing the current index.
     * @param       index representing the current index of the maximum element.
     * @return      the index of the maximum element.
     * @see         mz.Selection#selectionInc(Comparable[])
     */
    @SuppressWarnings("unchecked")
    int minIndex(Comparable[] array, int j, int index) {
        if (array[j].compareTo(array[index]) < 0) {
            index = j;
        }
        return index;
    }

    /**
     * {@code maxIndex} that finds the index of the maximum element in a portion of an array of Comparable objects.
     * <ul>
     *     <li>The method takes in an {@code array} of Comparable objects, array, an integer {@code j} representing the current index,
     *     and an integer {@code index} representing the current index of the maximum element.</li>
     *     <li>The method compares the element at index {@code j} with the element at index {@code index} using the {@code compareTo} method.</li>
     *     <li>If the element at index {@code j} is greater than the element at index {@code index}, the {@code if} condition evaluates to true,
     *     and the value of {@code index} is updated to {@code j}.</li>
     *     <li>The updated value of {@code index} is then returned.</li>
     * </ul>
     * {@code maxIndex} method compares the element at index {@code j} with the current maximum element represented by {@code index} in
     * the given {@code array} of Comparable objects. It updates and returns the index of the maximum element if the element at index {@code j} is greater.
     * @param       array to be arranged.
     * @param       j an integer representing the current index.
     * @param       index representing the current index of the maximum element.
     * @return      the index of the maximum element.
     * @see         mz.Selection#selectionDec(Comparable[])
     */
    @SuppressWarnings("unchecked")
    int maxIndex(Comparable[] array, int j, int index) {
        if (array[j].compareTo(array[index]) > 0) {
            index = j;
        }
        return index;
    }
}