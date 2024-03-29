package github.magyarzoli.sort;

import github.magyarzoli.*;
import github.magyarzoli.sort.intro.IntroBubble;

import java.util.List;

/**
 * Bubble Sort is a simple sorting algorithm that repeatedly compares adjacent elements and swaps them if they are in
 * the wrong order.
 * It works by repeatedly "bubbling" the largest (or smallest) element to its correct position in each iteration.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Bubble
        extends Selection {

    /**
     * <b>Bubble Sort:</b><br>
     * Bubble Sort is a simple sorting algorithm that repeatedly compares adjacent elements and swaps them if they are
     * in the wrong order.
     * It works by repeatedly "bubbling" the largest (or smallest) element to its correct position in each
     * iteration.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Compare each pair of adjacent elements starting from the beginning of the array.</li>
     *     <li>If the elements are in the wrong order (e.g., the current element is greater than the next element for
     *     ascending order), swap them.</li>
     *     <li>Move to the next pair of adjacent elements and repeat steps 2-3.</li>
     *     <li>After the first pass, the largest (or smallest) element will be in its correct position at the end of
     *     the array.</li>
     *     <li>Repeat steps 2-5 for the remaining elements (excluding the last sorted element) until the entire array
     *     is sorted.</li>
     * </ol>
     * <b>Note:</b><br>
     * Bubble Sort gets its name from the way smaller (or larger) elements "bubble" to their correct positions during
     * each iteration.
     * In each pass, the largest (or smallest) element gradually moves towards the end (or beginning) of the
     * array.<br><br>
     * Bubble Sort has a time complexity of <em>O(n^2)</em> in the average and worst cases. It is not considered an
     * efficient sorting
     * algorithm for large datasets due to its quadratic time complexity. However, it has the advantage of simplicity
     * and ease of implementation.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n)</em><br>
     * Average Case Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>Yes</b>
     * @see         IntroBubble#IntroBubble() IntroBubble
     * @see         Cocktail#Cocktail() Cocktail
     * @see         Gnome#Gnome() Gnome
     * @see         OddEven#OddEven() OddEven
     */
    public Bubble() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        bubbleInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        bubbleDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        bubble(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        bubbleInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        bubbleDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        bubble(list, functional);
    }

    /**
     * {@code bubbleInc} that performs the Bubble Sort algorithm on an array of {@link java.lang.Comparable Comparable}
     * objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an {@code array} of Comparable objects, array, and performs the Bubble Sort algorithm
     *     on it.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method starts with defining the length of the {@code array} as {@code n}.</li>
     *     <li>Two nested {@code for} loops are used for iterating over the elements of the array and comparing adjacent
     *     elements to perform the sorting.</li>
     *     <li>The outer loop iterates from 0 to {@code (n - 1)} and represents the number of passes performed in the
     *     Bubble Sort algorithm.</li>
     *     <li>The inner loop iterates from 1 to {@code (n - i) - 1} and represents the range of elements to be compared
     *     in each pass.
     *     The {@code (n - i)} part is because the largest {@code i} elements are already sorted and placed at the end
     *     in each pass.</li>
     *     <li>Inside the inner loop, an {@code if} condition is used to compare adjacent elements. If the element at
     *     index {@code (j - 1)} is greater than the element at index {@code j}, the elements are swapped to bring
     *     the smaller element towards the beginning of the array.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code (j - 1)} and {@code j}.</li>
     * </ul>
     * {@code bubbleInc} method implements the Bubble Sort algorithm to sort the given array of {@code Comparable}
     * objects in ascending order.
     * It repeatedly compares adjacent elements and swaps them if necessary until the array is sorted.
     * @param       array to be arranged.
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void bubbleInc(Comparable[] array) {
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
     * {@code bubbleDec} that performs the Bubble Sort algorithm on an array of {@link java.lang.Comparable Comparable}
     * objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an {@code array} of Comparable objects, array, and performs the Bubble Sort algorithm
     *     on it.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method starts with defining the length of the {@code array} as {@code n}.</li>
     *     <li>Two nested {@code for} loops are used for iterating over the elements of the array and comparing adjacent
     *     elements to perform the sorting.</li>
     *     <li>The outer loop iterates from 0 to {@code (n - 1)} and represents the number of passes performed in the
     *     Bubble Sort algorithm.</li>
     *     <li>The inner loop iterates from 1 to {@code (n - i) - 1} and represents the range of elements to be compared
     *     in each pass.
     *     The {@code (n - i)} part is because the largest {@code i} elements are already sorted and placed at the end
     *     in each pass.</li>
     *     <li>Inside the inner loop, an {@code if} condition is used to compare adjacent elements. If the element at
     *     index {@code (j - 1)} is smaller than the element at index {@code j}, the elements are swapped to bring
     *     the greater element towards the beginning of the array.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code (j - 1)} and {@code j}.</li>
     * </ul>
     * {@code bubbleInc} method implements the Bubble Sort algorithm to sort the given array of {@code Comparable}
     * objects in descending order.
     * It repeatedly compares adjacent elements and swaps them if necessary until the array is sorted.
     * @param       array to be arranged.
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void bubbleDec(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[(j - 1)].compareTo(array[j]) < 0) {
                    swap(array, (j - 1), j);
                }
            }
        }
    }

    /**
     * {@code bubble} this method performs the bubble sort algorithm on a specific range of an array.
     * <ul>
     *     <li>The method takes an array {@code array} of type {@link java.lang.Comparable Comparable}
     *     and an instance of the {@code SortFunctional<Comparable>} interface as parameters.</li>
     *     <li>It determines the {@code length} of the array using the length property {@code n = array.length}.</li>
     *     <li>It uses two nested loops to iterate over the elements of the array.</li>
     *     <li>The outer loop iterates from index <i>0</i> to the last index of the array
     *     {@code for (int i = 0; i < n; i++)}.</li>
     *     <li>The inner loop iterates from index <i>1</i> to the difference between the length of the array and
     *     {@code i}
     *     {@code for (int j = 1; j < (n - i); j++)}.</li>
     *     <li>Inside the inner loop, it compares adjacent elements at indices {@code (j - 1)} and {@code j} using
     *     the {@code functionalCompareTo} method from the {@code SortFunctional} interface.</li>
     *     <li>If the comparison returns {@code true} (indicating that the elements are out of order),
     *     it swaps the elements by calling the {@code swap} method
     *     and passing the array and the indices {@code (j - 1)} and {@code j}.</li>
     *     <li>The process continues until the outer loop completes,
     *     resulting in the entire array being sorted in ascending order.</li>
     * </ul>
     * {@code bubble} method implements the Bubble Sort algorithm to sort the given array of {@code Comparable} objects
     * in descending order.
     * It repeatedly compares adjacent elements and swaps them if necessary until the array is sorted.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    protected void bubble(Comparable[] array, SortFunctional<Comparable> functional) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (functional.functionalCompareTo(array[(j - 1)], array[j])) {
                    swap(array, (j - 1), j);
                }
            }
        }
    }

    /**
     * {@code bubbleInc} that performs the Bubble Sort algorithm on an array of {@link java.lang.Comparable Comparable}
     * objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an {@code array} of Comparable objects, array, and performs the Bubble Sort
     *     algorithm on it.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method starts with defining the length of the {@code array} as {@code right}.</li>
     *     <li>Two nested {@code for} loops are used for iterating over the elements of the array and comparing adjacent
     *     elements to perform the sorting.</li>
     *     <li>The outer loop iterates from 0 to {@code (right - 1)} and represents the number of passes performed in
     *     the Bubble Sort algorithm.</li>
     *     <li>The inner loop iterates from 1 to {@code (right - i) - 1} and represents the range of elements to be
     *     compared in each pass.
     *     The {@code (right - i)} part is because the largest {@code i} elements are already sorted and placed at the
     *     end in each pass.</li>
     *     <li>Inside the inner loop, an {@code if} condition is used to compare adjacent elements. If the element at
     *     index {@code (j - 1)} is greater than the element at index {@code j}, the elements are swapped to bring
     *     the smaller element towards the beginning of the array.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code (j - 1)} and {@code j}.</li>
     * </ul>
     * {@code bubbleInc} method implements the Bubble Sort algorithm to sort the given array of {@code Comparable}
     * objects in ascending order.
     * It repeatedly compares adjacent elements and swaps them if necessary until the array is sorted.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void bubbleInc(Comparable[] array, int left, int right) {
        for (int i = left; i < right; i++) {
            for (int j = 1; j < (right - i); j++) {
                if (array[(j - 1)].compareTo(array[j]) > 0) {
                    swap(array, (j - 1), j);
                }
            }
        }
    }

    /**
     * {@code bubbleDec} that performs the Bubble Sort algorithm on an array of {@link java.lang.Comparable Comparable}
     * objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an {@code array} of Comparable objects, array, and performs the Bubble Sort algorithm
     *     on it.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method starts with defining the length of the {@code array} as {@code right}.</li>
     *     <li>Two nested {@code for} loops are used for iterating over the elements of the array and comparing adjacent
     *     elements to perform the sorting.</li>
     *     <li>The outer loop iterates from 0 to {@code (right - 1)} and represents the number of passes performed in
     *     the Bubble Sort algorithm.</li>
     *     <li>The inner loop iterates from 1 to {@code (right - i) - 1} and represents the range of elements to be
     *     compared in each pass.
     *     The {@code (right - i)} part is because the largest {@code i} elements are already sorted and placed at the
     *     end in each pass.</li>
     *     <li>Inside the inner loop, an {@code if} condition is used to compare adjacent elements. If the element at
     *     index {@code (j - 1)} is smaller than the element at index {@code j}, the elements are swapped to bring
     *     the greater element towards the beginning of the array.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code (j - 1)} and {@code j}.</li>
     * </ul>
     * {@code bubbleInc} method implements the Bubble Sort algorithm to sort the given array of {@code Comparable}
     * objects in descending order.
     * It repeatedly compares adjacent elements and swaps them if necessary until the array is sorted.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void bubbleDec(Comparable[] array, int left, int right) {
        for (int i = left; i < right; i++) {
            for (int j = 1; j < (right - i); j++) {
                if (array[(j - 1)].compareTo(array[j]) < 0) {
                    swap(array, (j - 1), j);
                }
            }
        }
    }

    /**
     * {@code bubble} this method performs the bubble sort algorithm on a specific range of an array.
     * <ul>
     *     <li>The method takes an array array of type {@code Comparable[]},
     *     an integer {@code left} representing the left index, an integer {@code right} representing the right index,
     *     and an instance of the {@code mz.SortFunctional<Comparable>} interface as parameters.</li>
     *     <li>It uses two nested loops to iterate over the range of the array.</li>
     *     <li>The outer loop iterates from the {@code left} index to the element before
     *     the {@code right} index {@code for (int i = left; i < right; i++)}.</li>
     *     <li>The inner loop iterates from index <i>1</i> to
     *     the difference between {@code right} and {@code i} {@code for (int j = 1; j < (right - i); j++)}.</li>
     *     <li>Inside the inner loop, it compares adjacent elements at indices {@code (j - 1)} and {@code j} using
     *     the {@code functionalCompareTo} method from the {@code mz.SortFunctional} interface.</li>
     *     <li>If the comparison returns {@code true} (indicating that the elements are out of order),
     *     it swaps the elements by calling the {@code swap} method and passing the array and the indices
     *     {@code (j - 1)} and {@code j}.</li>
     *     <li>The process continues until the outer loop completes, resulting in the range being sorted in ascending
     *     order.</li>
     * </ul>
     * {@code bubble} method implements the Bubble Sort algorithm to sort the given array of {@link java.lang.Comparable
     * Comparable} objects in descending order.
     * It repeatedly compares adjacent elements and swaps them if necessary until the array is sorted.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    protected void bubble(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        for (int i = left; i < right; i++) {
            for (int j = 1; j < (right - i); j++) {
                if (functional.functionalCompareTo(array[(j - 1)], array[j])) {
                    swap(array, (j - 1), j);
                }
            }
        }
    }

    /**
     * {@code bubbleInc} that performs the Bubble Sort algorithm on a list of {@link java.lang.Comparable Comparable}
     * objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an {@code list} of Comparable objects, list, and performs the Bubble Sort algorithm
     *     on it.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method starts with defining the length of the {@code list} as {@code n}.</li>
     *     <li>Two nested {@code for} loops are used for iterating over the elements of the list and comparing adjacent
     *     elements to perform the sorting.</li>
     *     <li>The outer loop iterates from 0 to {@code (n - 1)} and represents the number of passes performed in the
     *     Bubble Sort algorithm.</li>
     *     <li>The inner loop iterates from 1 to {@code (n - i) - 1} and represents the range of elements to be compared
     *     in each pass.
     *     The {@code (n - i)} part is because the largest {@code i} elements are already sorted and placed at the end
     *     in each pass.</li>
     *     <li>Inside the inner loop, an {@code if} condition is used to compare adjacent elements. If the element at
     *     index {@code (j - 1)} is greater than the element at index {@code j}, the elements are swapped to bring
     *     the smaller element towards the beginning of the list.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code (j - 1)} and {@code j}.</li>
     * </ul>
     * {@code bubbleInc} method implements the Bubble Sort algorithm to sort the given list of {@code Comparable}
     * objects in ascending order.
     * It repeatedly compares adjacent elements and swaps them if necessary until the list is sorted.
     * @param       list to be arranged.
     * @see         SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void bubbleInc(List<L> list) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (list.get(j - 1).compareTo(list.get(j)) > 0) {
                    swap(list, (j - 1), j);
                }
            }
        }
    }

    /**
     * {@code bubbleDec} that performs the Bubble Sort algorithm on a list of {@link java.lang.Comparable Comparable}
     * objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an {@code list} of Comparable objects, list, and performs the Bubble Sort algorithm
     *     on it.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method starts with defining the length of the {@code list} as {@code n}.</li>
     *     <li>Two nested {@code for} loops are used for iterating over the elements of the list and comparing adjacent
     *     elements to perform the sorting.</li>
     *     <li>The outer loop iterates from 0 to {@code (n - 1)} and represents the number of passes performed in the
     *     Bubble Sort algorithm.</li>
     *     <li>The inner loop iterates from 1 to {@code (n - i) - 1} and represents the range of elements to be compared
     *     in each pass.
     *     The {@code (n - i)} part is because the largest {@code i} elements are already sorted and placed at the end
     *     in each pass.</li>
     *     <li>Inside the inner loop, an {@code if} condition is used to compare adjacent elements. If the element at
     *     index {@code (j - 1)} is smaller than the element at index {@code j}, the elements are swapped to bring
     *     the greater element towards the beginning of the list.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code (j - 1)} and {@code j}.</li>
     * </ul>
     * {@code bubbleInc} method implements the Bubble Sort algorithm to sort the given list of {@code Comparable}
     * objects in descending order.
     * It repeatedly compares adjacent elements and swaps them if necessary until the list is sorted.
     * @param       list to be arranged.
     * @see         SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void bubbleDec(List<L> list) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (list.get(j - 1).compareTo(list.get(j)) < 0) {
                    swap(list, (j - 1), j);
                }
            }
        }
    }

    /**
     * {@code bubble} this method performs the bubble sort algorithm on a specific range of a list.
     * <ul>
     *     <li>The method takes an list {@code list} of type {@code Comparable}
     *     and an instance of the {@code SortFunctional<Comparable>} interface as parameters.</li>
     *     <li>It determines the {@code length} of the list using the length property {@code n = list.size()}.</li>
     *     <li>It uses two nested loops to iterate over the elements of the list.</li>
     *     <li>The outer loop iterates from index <i>0</i> to the last index of the list
     *     {@code for (int i = 0; i < n; i++)}.</li>
     *     <li>The inner loop iterates from index <i>1</i> to the difference between the length of the list and {@code i}
     *     {@code for (int j = 1; j < (n - i); j++)}.</li>
     *     <li>Inside the inner loop, it compares adjacent elements at indices {@code (j - 1)} and {@code j} using
     *     the {@code functionalCompareTo} method from the {@code mz.SortFunctional} interface.</li>
     *     <li>If the comparison returns {@code true} (indicating that the elements are out of order),
     *     it swaps the elements by calling the {@code swap} method
     *     and passing the list and the indices {@code (j - 1)} and {@code j}.</li>
     *     <li>The process continues until the outer loop completes,
     *     resulting in the entire list being sorted in ascending order.</li>
     * </ul>
     * {@code bubble} method implements the Bubble Sort algorithm to sort the given list of {@link java.lang.Comparable
     * Comparable} objects in descending order.
     * It repeatedly compares adjacent elements and swaps them if necessary until the list is sorted.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         SortSwap#swap(List, int, int)
     */
    protected <L extends Comparable> void bubble(List<L> list, SortFunctional<Comparable> functional) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (functional.functionalCompareTo(list.get(j - 1), list.get(j))) {
                    swap(list, (j - 1), j);
                }
            }
        }
    }

    /**
     * {@code bubbleInc} that performs the Bubble Sort algorithm on a list of {@link java.lang.Comparable Comparable}
     * objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an {@code list} of Comparable objects, list, and performs the Bubble Sort algorithm
     *     on it.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method starts with defining the length of the {@code list} as {@code right}.</li>
     *     <li>Two nested {@code for} loops are used for iterating over the elements of the list and comparing adjacent
     *     elements to perform the sorting.</li>
     *     <li>The outer loop iterates from 0 to {@code (right - 1)} and represents the number of passes performed in
     *     the Bubble Sort algorithm.</li>
     *     <li>The inner loop iterates from 1 to {@code (right - i) - 1} and represents the range of elements to be
     *     compared in each pass.
     *     The {@code (right - i)} part is because the largest {@code i} elements are already sorted and placed at the
     *     end in each pass.</li>
     *     <li>Inside the inner loop, an {@code if} condition is used to compare adjacent elements. If the element at
     *     index {@code (j - 1)} is greater than the element at index {@code j}, the elements are swapped to bring
     *     the smaller element towards the beginning of the list.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code (j - 1)} and {@code j}.</li>
     * </ul>
     * {@code bubbleInc} method implements the Bubble Sort algorithm to sort the given list of {@code Comparable}
     * objects in ascending order.
     * It repeatedly compares adjacent elements and swaps them if necessary until the list is sorted.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void bubbleInc(List<L> list, int left, int right) {
        for (int i = left; i < right; i++) {
            for (int j = 1; j < (right - i); j++) {
                if (list.get(j - 1).compareTo(list.get(j)) > 0) {
                    swap(list, (j - 1), j);
                }
            }
        }
    }

    /**
     * {@code bubbleDec} that performs the Bubble Sort algorithm on a list of {@link java.lang.Comparable Comparable}
     * objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an {@code list} of Comparable objects, list, and performs the Bubble Sort algorithm
     *     on it.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method starts with defining the length of the {@code list} as {@code right}.</li>
     *     <li>Two nested {@code for} loops are used for iterating over the elements of the list and comparing adjacent
     *     elements to perform the sorting.</li>
     *     <li>The outer loop iterates from 0 to {@code (right - 1)} and represents the number of passes performed in
     *     the Bubble Sort algorithm.</li>
     *     <li>The inner loop iterates from 1 to {@code (right - i) - 1} and represents the range of elements to be
     *     compared in each pass.
     *     The {@code (right - i)} part is because the largest {@code i} elements are already sorted and placed at the
     *     end in each pass.</li>
     *     <li>Inside the inner loop, an {@code if} condition is used to compare adjacent elements. If the element at
     *     index {@code (j - 1)} is smaller than the element at index {@code j}, the elements are swapped to bring
     *     the greater element towards the beginning of the list.</li>
     *     <li>The {@code swap} method is called to swap the elements at indices {@code (j - 1)} and {@code j}.</li>
     * </ul>
     * {@code bubbleInc} method implements the Bubble Sort algorithm to sort the given list of {@code Comparable}
     * objects in descending order.
     * It repeatedly compares adjacent elements and swaps them if necessary until the list is sorted.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void bubbleDec(List<L> list, int left, int right) {
        for (int i = left; i < right; i++) {
            for (int j = 1; j < (right - i); j++) {
                if (list.get(j - 1).compareTo(list.get(j)) < 0) {
                    swap(list, (j - 1), j);
                }
            }
        }
    }

    /**
     * {@code bubble} this method performs the bubble sort algorithm on a specific range of a list.
     * <ul>
     *     <li>The method takes an list list of type {@code Comparable[]},
     *     an integer {@code left} representing the left index, an integer {@code right} representing the right index,
     *     and an instance of the {@code SortFunctional<Comparable>} interface as parameters.</li>
     *     <li>It uses two nested loops to iterate over the range of the list.</li>
     *     <li>The outer loop iterates from the {@code left} index to the element before
     *     the {@code right} index {@code for (int i = left; i < right; i++)}.</li>
     *     <li>The inner loop iterates from index <i>1</i> to
     *     the difference between {@code right} and {@code i} {@code for (int j = 1; j < (right - i); j++)}.</li>
     *     <li>Inside the inner loop, it compares adjacent elements at indices {@code (j - 1)} and {@code j} using
     *     the {@code functionalCompareTo} method from the {@code SortFunctional} interface.</li>
     *     <li>If the comparison returns {@code true} (indicating that the elements are out of order),
     *     it swaps the elements by calling the {@code swap} method and passing the list and the indices {@code (j - 1)}
     *     and {@code j}.</li>
     *     <li>The process continues until the outer loop completes, resulting in the range being sorted in ascending
     *     order.</li>
     * </ul>
     * {@code bubble} method implements the Bubble Sort algorithm to sort the given list of {@link java.lang.Comparable
     * Comparable} objects in descending order.
     * It repeatedly compares adjacent elements and swaps them if necessary until the list is sorted.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         SortSwap#swap(List, int, int)
     */
    protected <L extends Comparable> void bubble(
            List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        for (int i = left; i < right; i++) {
            for (int j = 1; j < (right - i); j++) {
                if (functional.functionalCompareTo(list.get(j - 1), list.get(j))) {
                    swap(list, (j - 1), j);
                }
            }
        }
    }
}