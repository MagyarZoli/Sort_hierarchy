package mz;

/**
 * Bubble Sort is a simple sorting algorithm that repeatedly compares adjacent elements and swaps them if they are in the wrong order.
 * It works by repeatedly "bubbling" the largest (or smallest) element to its correct position in each iteration.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 * @see         mz.Cocktail
 * @see         mz.Comb
 */
public class Bubble
extends SortComparable
implements SortSwap<Comparable> {

    /**
     * <b>Bubble Sort:</b><br>
     * Bubble Sort is a simple sorting algorithm that repeatedly compares adjacent elements and swaps them if they are in the wrong order.
     * It works by repeatedly "bubbling" the largest (or smallest) element to its correct position in each iteration.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Compare each pair of adjacent elements starting from the beginning of the array.</li>
     *     <li>If the elements are in the wrong order (e.g., the current element is greater than the next element for ascending order), swap them.</li>
     *     <li>Move to the next pair of adjacent elements and repeat steps 2-3.</li>
     *     <li>After the first pass, the largest (or smallest) element will be in its correct position at the end of the array.</li>
     *     <li>Repeat steps 2-5 for the remaining elements (excluding the last sorted element) until the entire array is sorted.</li>
     * </ol>
     * <b>Note:</b><br>
     * Bubble Sort gets its name from the way smaller (or larger) elements "bubble" to their correct positions during each iteration.
     * In each pass, the largest (or smallest) element gradually moves towards the end (or beginning) of the array.<br><br>
     * Bubble Sort has a time complexity of <em>O(n^2)</em> in the average and worst cases. It is not considered an efficient sorting
     * algorithm for large datasets due to its quadratic time complexity. However, it has the advantage of simplicity
     * and ease of implementation.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n)</em><br>
     * Average Case Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>Yes</b>
     * @see         mz.Cocktail#Cocktail()
     * @see         mz.Comb#Comb()
     */
    public Bubble() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         mz.Bubble#bubbleInc(Comparable[])
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        bubbleInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         mz.Bubble#bubbleDec(Comparable[])
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        bubbleDec(array);
    }

    /**
     * {@code bubbleInc} that performs the Bubble Sort algorithm on an array of Comparable objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an {@code array} of Comparable objects, array, and performs the Bubble Sort algorithm on it.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@code compareTo} method.</li>
     *     <li>The method starts with defining the length of the {@code array} as {@code n}.</li>
     *     <li>Two nested {@code for} loops are used for iterating over the elements of the array and comparing adjacent elements to perform the sorting.</li>
     *     <ul>
     *         <li>The outer loop iterates from 0 to {@code (n - 1)} and represents the number of passes performed in the Bubble Sort algorithm.</li>
     *         <li>The inner loop iterates from 1 to {@code (n - i) - 1} and represents the range of elements to be compared in each pass.
     *         The {@code (n - i)} part is because the largest {@code i} elements are already sorted and placed at the end in each pass.</li>
     *         <li>Inside the inner loop, an {@code if} condition is used to compare adjacent elements. If the element at
     *         index {@code (j - 1)} is greater than the element at index {@code j}, the elements are swapped to bring
     *         the smaller element towards the beginning of the array.</li>
     *     </ul>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code (j - 1)} and {@code j}.</li>
     * </ul>
     * {@code bubbleInc} method implements the Bubble Sort algorithm to sort the given array of Comparable objects in ascending order.
     * It repeatedly compares adjacent elements and swaps them if necessary until the array is sorted.
     * @param       array to be arranged.
     */
    @SuppressWarnings("unchecked")
    void bubbleInc(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[(j - 1)].compareTo(array[j]) > 0) {
                    swap(array, (j - 1), j);
                }
            }
        }
    }

    /**
     * {@code bubbleDec} that performs the Bubble Sort algorithm on an array of Comparable objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an {@code array} of Comparable objects, array, and performs the Bubble Sort algorithm on it.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@code compareTo} method.</li>
     *     <li>The method starts with defining the length of the {@code array} as {@code n}.</li>
     *     <li>Two nested {@code for} loops are used for iterating over the elements of the array and comparing adjacent elements to perform the sorting.</li>
     *     <ul>
     *         <li>The outer loop iterates from 0 to {@code (n - 1)} and represents the number of passes performed in the Bubble Sort algorithm.</li>
     *         <li>The inner loop iterates from 1 to {@code (n - i) - 1} and represents the range of elements to be compared in each pass.
     *         The {@code (n - i)} part is because the largest {@code i} elements are already sorted and placed at the end in each pass.</li>
     *         <li>Inside the inner loop, an {@code if} condition is used to compare adjacent elements. If the element at
     *         index {@code (j - 1)} is smaller than the element at index {@code j}, the elements are swapped to bring
     *         the greater element towards the beginning of the array.</li>
     *     </ul>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code (j - 1)} and {@code j}.</li>
     * </ul>
     * {@code bubbleInc} method implements the Bubble Sort algorithm to sort the given array of Comparable objects in descending order.
     * It repeatedly compares adjacent elements and swaps them if necessary until the array is sorted.
     * @param       array to be arranged.
     */
    @SuppressWarnings("unchecked")
    void bubbleDec(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[(j - 1)].compareTo(array[j]) < 0) {
                    swap(array, (j - 1), j);
                }
            }
        }
    }
}