package github.magyarzoli.sort;

import github.magyarzoli.SortFind;
import github.magyarzoli.SortSwap;
import github.magyarzoli.sort.intro.IntroPancake;

import java.util.List;

/**
 * Pancake Sort is a sorting algorithm that aims to sort an array of elements in ascending or descending order.
 * It gets its name from the analogy of flipping pancakes with a spatula to sort them.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Pancake
extends Selection {

    /**
     * <b>Pancake Sort:</b><br>
     * Pancake Sort is a sorting algorithm that aims to sort an array of elements in ascending or descending order.
     * It gets its name from the analogy of flipping pancakes with a spatula to sort them.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with the entire array of elements to be sorted.</li>
     *     <li>Find the index of the maximum (or minimum, depending on the desired order) element in the unsorted portion of the array.
     *     This is typically done by iterating over the unsorted portion of the array and keeping track of
     *     the index with the maximum (or minimum) value.</li>
     *     <li>Once the maximum (or minimum) element is found, the following steps are performed:</li>
     *     <li>If the maximum (or minimum) element is already at the rightmost position in the unsorted portion,
     *     no action is required for this iteration.</li>
     *     <li>If the maximum (or minimum) element is not at the rightmost position,
     *     perform a flip operation to move it to the beginning of the unsorted portion.
     *     This is done by reversing the order of elements from the start of the array up to
     *     the position of the maximum (or minimum) element.</li>
     *     <li>Perform a flip operation to move the maximum (or minimum) element from its current position at
     *     the beginning of the unsorted portion to the end of the sorted portion.
     *     This is done by reversing the order of elements from the start of the array up to the end of the unsorted portion.</li>
     *     <li>Repeat steps 2 and 3 for the remaining unsorted portion of the array until the entire array is sorted.</li>
     * </ol>
     * <b>Note:</b><br>
     * Pancake Sort essentially works by identifying the maximum (or minimum) element in each iteration and
     * using a combination of flipping operations to move it to its correct position in the sorted portion of the array.
     * The number of iterations required depends on the size and order of the array.<br><br>
     * It's worth noting that Pancake Sort has a worst-case time complexity of <em>O(n^2)</em>,
     * where n is the number of elements in the array.
     * However, it can be optimized to <em>O(n log(n))</em> by using a data structure such as a
     * heap to efficiently find the maximum (or minimum) element in each iteration.<br><br>
     * Pancake Sort is stable, meaning that elements with equal values retain their relative order after sorting.
     * If two elements have the same value, their order in the original array will be preserved in the sorted array.
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n)</em><br>
     * Average Case Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>Yes</b>
     * @see         IntroPancake#IntroPancake() IntroPancake
     */
    public Pancake() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        pancakeInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        pancakeDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        pancake(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        pancakeInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        pancakeDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        pancake(list, functional);
    }

    /**
     * {@code pancakeInc} sorts an array of {@link java.lang.Comparable Comparable} elements in ascending order.
     * <ul>
     *     <li>It initializes the variable {@code n} to the length of the array,
     *     representing the number of elements.</li>
     *     <li>A loop is started with the variable {@code i} initialized to {@code n}.
     *     The loop continues as long as {@code i} is greater than <i>1</i>.
     *     This loop iterates over the array from right to left, gradually reducing the range of unsorted elements.</li>
     *     <li>Inside the loop, the {@code findMaxIndex} method is called, passing the array and the current value of {@code i}.
     *     This method finds the index of the maximum element within the unsorted range of the array.</li>
     *     <li>If the maximum element is not at index {@code (i - 1)} (the rightmost position within the unsorted range),
     *     the {@code flip} method is called twice. The {@code flip} method reverses the order of elements in a subarray.
     *     The first {@code flip} operation brings the maximum element to the beginning of the unsorted range,
     *     and the second {@code flip} operation moves it to the correct position at the end of the sorted range.</li>
     *     <li>The loop continues until the entire array is sorted,
     *     as the range of unsorted elements shrinks with each iteration.</li>
     * </ul>
     * {@code pancakeInc} method uses a combination of finding the maximum element
     * and flipping subarrays to gradually sort the input array in ascending order.
     * @param       array to be arranged.
     * @see         SortFind#findMaxIndex(Comparable[], int)
     * @see         SortSwap#flip(Comparable[], int)
     */
    protected void pancakeInc(Comparable[] array) {
        int n = array.length;
        for (int i = n; i > 1; i--) {
            int max = findMaxIndex(array, i);
            if (max != (i - 1)) {
                flip(array, max);
                flip(array, (i - 1));
            }
        }
    }

    /**
     * {@code pancakeDec} sorts an array of {@link java.lang.Comparable Comparable} elements in descending order.
     * <ul>
     *     <li>It initializes the variable {@code n} to the length of the array,
     *     representing the number of elements.</li>
     *     <li>A loop is started with the variable {@code i} initialized to {@code n}.
     *     The loop continues as long as {@code i} is greater than <i>1</i>.
     *     This loop iterates over the array from right to left, gradually reducing the range of unsorted elements.</li>
     *     <li>Inside the loop, the {@code findMinIndex} method is called, passing the array and the current value of {@code i}.
     *     This method finds the index of the minimum element within the unsorted range of the array.</li>
     *     <li>If the minimum element is not at index {@code (i - 1)} (the rightmost position within the unsorted range),
     *     the {@code flip} method is called twice. The {@code flip} method reverses the order of elements in a subarray.
     *     The first {@code flip} operation brings the minimum element to the beginning of the unsorted range,
     *     and the second {@code flip} operation moves it to the correct position at the end of the sorted range.</li>
     *     <li>The loop continues until the entire array is sorted,
     *     as the range of unsorted elements shrinks with each iteration.</li>
     * </ul>
     * {@code pancakeDec} method uses a combination of finding the minimum element
     * and flipping subarrays to gradually sort the input array in descending order.
     * @param       array to be arranged.
     * @see         SortFind#findMinIndex(Comparable[], int)
     * @see         SortSwap#flip(Comparable[], int)
     */
    protected void pancakeDec(Comparable[] array) {
        int n = array.length;
        for (int i = n; i > 1; i--) {
            int min = findMinIndex(array, i);
            if (min != (i - 1)) {
                flip(array, min);
                flip(array, (i - 1));
            }
        }
    }

    /**
     * {@code pancake} method takes an array of {@link java.lang.Comparable Comparable} objects,
     * It also takes a {@code SortFunctional<Comparable>} object representing
     * the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method starts with a loop that iterates from {@code right} to <i>1</i> in a descending order.
     *     This loop controls the number of pancake flips needed to sort the array.</li>
     *     <li>Inside the loop, the {@code findIndex} method is called to find the index of
     *     the maximum element within the current range (<i>0</i> to {@code i}) using the provided comparison logic.
     *     The {@code findIndex} method likely searches for the index of
     *     the maximum element based on the {@code SortFunctional} comparison logic.</li>
     *     <li>If the found index {@code value} is not equal to {@code (i - 1)}, indicating that
     *     the maximum element is not already at the correct position,
     *     the flip method is called twice.
     *     The first flip operation flips the subarray from {@code n} to {@code value},
     *     bringing the maximum element to the beginning of the range.
     *     The second flip operation then flips the entire subarray from {@code n} to {@code (i - 1)},
     *     moving the maximum element to its correct position at the end of the range.</li>
     *     <li>The loop continues until the entire range is sorted, with the largest element at the end.
     *     At the end of the {@code pancake} method, the specified range of
     *     the array is sorted according to the provided comparison logic.</li>
     * </ul>
     * {@code pancake} method performs a variation of the Pancake Sort algorithm on a specific subarray defined by
     * the {@code left} and {@code right} indices.
     * This allows for sorting different sections of the array independently, which can be useful in certain scenarios.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         SortFind#findIndex(Comparable[], int, SortFunctional)
     * @see         SortSwap#flip(Comparable[], int, int)
     */
    protected void pancake(Comparable[] array, SortFunctional<Comparable> functional) {
        int n = array.length;
        for (int i = n; i > 1; i--) {
            int value = findIndex(array, i, functional);
            if (value != (i - 1)) {
                flip(array, value);
                flip(array, (i - 1));
            }
        }

    }

    /**
     * {@code pancakeInc} sorts an array of {@link java.lang.Comparable Comparable} elements in ascending order.
     * <ul>
     *     <li>Now takes three parameters:
     *     the {@code array} to be sorted,
     *     {@code left} representing the left index of the current subarray,
     *     and {@code right} representing the right index of the current subarray.</li>
     *     <li>The loop is now started with {@code i} initialized to {@code right} instead of {@code n},
     *     representing the rightmost index of the current subarray.</li>
     *     <li>The loop continues as long as {@code i} is greater than {@code (left + 1)}.
     *     This means that the loop will stop when the subarray has only one element remaining.</li>
     *     <li>Inside the loop, the {@code findMaxIndex} method is called, passing the {@code array}, {@code left},
     *     and the current value of {@code i}.
     *     This method finds the index of the maximum element within the current subarray.</li>
     *     <li>If the maximum element is not at index {@code (i - 1)}, the flip method is called twice.
     *     The {@code flip} method now takes three parameters:
     *     the {@code array}, {@code left}, and the target index to which the subarray will be flipped.
     *     The first {@code flip} operation brings the maximum element to the leftmost position of the subarray,
     *     and the second {@code flip} operation moves it to the correct position within the subarray.</li>
     *     <li>The loop continues until the subarray is sorted,
     *     as the range of unsorted elements within the subarray decreases with each iteration.</li>
     * </ul>
     * {@code pancakeInc} method performs a variation of the Pancake Sort algorithm on a specific subarray defined by
     * the {@code left} and {@code right} indices.
     * This allows for sorting different sections of the array independently, which can be useful in certain scenarios.
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       right specific range of the array.
     * @see         SortFind#findMaxIndex(Comparable[], int, int)
     * @see         SortSwap#flip(Comparable[], int, int)
     */
    protected void pancakeInc(Comparable[] array, int left, int right) {
        for (int i = right; i > (left + 1); i--) {
            int max = findMaxIndex(array, left, i);
            if (max != (i - 1)) {
                flip(array, left, max);
                flip(array, left, (i - 1));
            }
        }
    }

    /**
     * {@code pancakeDec} sorts an array of {@link java.lang.Comparable Comparable} elements in descending order.
     * <ul>
     *     <li>Now takes three parameters:
     *     the {@code array} to be sorted,
     *     {@code left} representing the left index of the current subarray,
     *     and {@code right} representing the right index of the current subarray.</li>
     *     <li>The loop is now started with {@code i} initialized to {@code right} instead of {@code n},
     *     representing the rightmost index of the current subarray.</li>
     *     <li>The loop continues as long as {@code i} is greater than {@code (left + 1)}.
     *     This means that the loop will stop when the subarray has only one element remaining.</li>
     *     <li>Inside the loop, the {@code findMinIndex} method is called, passing the {@code array}, {@code left},
     *     and the current value of {@code i}.
     *     This method finds the index of the minimum element within the current subarray.</li>
     *     <li>If the minimum element is not at index {@code (i - 1)}, the flip method is called twice.
     *     The {@code flip} method now takes three parameters:
     *     the {@code array}, {@code left}, and the target index to which the subarray will be flipped.
     *     The first {@code flip} operation brings the minimum element to the leftmost position of the subarray,
     *     and the second {@code flip} operation moves it to the correct position within the subarray.</li>
     *     <li>The loop continues until the subarray is sorted,
     *     as the range of unsorted elements within the subarray decreases with each iteration.</li>
     * </ul>
     * {@code pancakeDec} method performs a variation of the Pancake Sort algorithm on a specific subarray defined by
     * the {@code left} and {@code right} indices.
     * This allows for sorting different sections of the array independently, which can be useful in certain scenarios.
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       right specific range of the array.
     * @see         SortFind#findMaxIndex(Comparable[], int, int)
     * @see         SortSwap#flip(Comparable[], int, int)
     */
    protected void pancakeDec(Comparable[] array, int left, int right) {
        for (int i = right; i > (left + 1); i--) {
            int min = findMinIndex(array, left, i);
            if (min != (i - 1)) {
                flip(array, left, min);
                flip(array, left, (i - 1));
            }
        }
    }

    /**
     * {@code pancake} method takes an array of {@link java.lang.Comparable Comparable} objects,
     * along with the {@code left} and {@code right} indices specifying the range of elements to be sorted.
     * It also takes a {@code SortFunctional<Comparable>} object representing
     * the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method starts with a loop that iterates from {@code right} to {@code (left + 1)} in a descending order.
     *     This loop controls the number of pancake flips needed to sort the array.</li>
     *     <li>Inside the loop, the {@code findIndex} method is called to find the index of
     *     the maximum element within the current range ({@code left} to {@code i}) using the provided comparison logic.
     *     The {@code findIndex} method likely searches for the index of
     *     the maximum element based on the {@code SortFunctional} comparison logic.</li>
     *     <li>If the found index {@code value} is not equal to {@code (i - 1)}, indicating that
     *     the maximum element is not already at the correct position,
     *     the flip method is called twice.
     *     The first flip operation flips the subarray from {@code left} to {@code value},
     *     bringing the maximum element to the beginning of the range.
     *     The second flip operation then flips the entire subarray from {@code left} to {@code (i - 1)},
     *     moving the maximum element to its correct position at the end of the range.</li>
     *     <li>The loop continues until the entire range is sorted, with the largest element at the end.
     *     At the end of the {@code pancake} method, the specified range of
     *     the array is sorted according to the provided comparison logic.</li>
     * </ul>
     * {@code pancake} method performs a variation of the Pancake Sort algorithm on a specific subarray defined by
     * the {@code left} and {@code right} indices.
     * This allows for sorting different sections of the array independently, which can be useful in certain scenarios.
     * @param       array to be arranged.
     * @param       left specific range of the array.
     * @param       right specific range of the array.
     * @param       functional lambda expression for comparison.
     * @see         SortFind#findIndex(Comparable[], int, int, SortFunctional)
     * @see         SortSwap#flip(Comparable[], int, int)
     */
    protected void pancake(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        for (int i = right; i > (left + 1); i--) {
            int value = findIndex(array, left, i, functional);
            if (value != (i - 1)) {
                flip(array, left, value);
                flip(array, left, (i - 1));
            }
        }
    }

    /**
     * {@code pancakeInc} sorts a list of {@link java.lang.Comparable Comparable} elements in ascending order.
     * <ul>
     *     <li>It initializes the variable {@code n} to the length of the list,
     *     representing the number of elements.</li>
     *     <li>A loop is started with the variable {@code i} initialized to {@code n}.
     *     The loop continues as long as {@code i} is greater than <i>1</i>.
     *     This loop iterates over the list from right to left, gradually reducing the range of unsorted elements.</li>
     *     <li>Inside the loop, the {@code findMaxIndex} method is called, passing the list and the current value of {@code i}.
     *     This method finds the index of the maximum element within the unsorted range of the list.</li>
     *     <li>If the maximum element is not at index {@code (i - 1)} (the rightmost position within the unsorted range),
     *     the {@code flip} method is called twice. The {@code flip} method reverses the order of elements in a subarray.
     *     The first {@code flip} operation brings the maximum element to the beginning of the unsorted range,
     *     and the second {@code flip} operation moves it to the correct position at the end of the sorted range.</li>
     *     <li>The loop continues until the entire list is sorted,
     *     as the range of unsorted elements shrinks with each iteration.</li>
     * </ul>
     * {@code pancakeInc} method uses a combination of finding the maximum element
     * and flipping subarrays to gradually sort the input list in ascending order.
     * @param       list to be arranged.
     * @see         SortFind#findMaxIndex(List, int)
     * @see         SortSwap#flip(List, int)
     */
    protected <L extends Comparable> void pancakeInc(List<L> list) {
        int n = list.size();
        for (int i = n; i > 1; i--) {
            int max = findMaxIndex(list, i);
            if (max != (i - 1)) {
                flip(list, max);
                flip(list, (i - 1));
            }
        }
    }

    /**
     * {@code pancakeDec} sorts a list of {@link java.lang.Comparable Comparable} elements in descending order.
     * <ul>
     *     <li>It initializes the variable {@code n} to the length of the list,
     *     representing the number of elements.</li>
     *     <li>A loop is started with the variable {@code i} initialized to {@code n}.
     *     The loop continues as long as {@code i} is greater than <i>1</i>.
     *     This loop iterates over the list from right to left, gradually reducing the range of unsorted elements.</li>
     *     <li>Inside the loop, the {@code findMinIndex} method is called, passing the list and the current value of {@code i}.
     *     This method finds the index of the minimum element within the unsorted range of the list.</li>
     *     <li>If the minimum element is not at index {@code (i - 1)} (the rightmost position within the unsorted range),
     *     the {@code flip} method is called twice. The {@code flip} method reverses the order of elements in a subarray.
     *     The first {@code flip} operation brings the minimum element to the beginning of the unsorted range,
     *     and the second {@code flip} operation moves it to the correct position at the end of the sorted range.</li>
     *     <li>The loop continues until the entire list is sorted,
     *     as the range of unsorted elements shrinks with each iteration.</li>
     * </ul>
     * {@code pancakeDec} method uses a combination of finding the minimum element
     * and flipping subarrays to gradually sort the input list in descending order.
     * @param       list to be arranged.
     * @see         SortFind#findMinIndex(List, int)
     * @see         SortSwap#flip(List, int)
     */
    protected <L extends Comparable> void pancakeDec(List<L> list) {
        int n = list.size();
        for (int i = n; i > 1; i--) {
            int min = findMinIndex(list, i);
            if (min != (i - 1)) {
                flip(list, min);
                flip(list, (i - 1));
            }
        }
    }

    /**
     * {@code pancake} method takes a list of {@link java.lang.Comparable Comparable} objects,
     * It also takes a {@code SortFunctional<Comparable>} object representing
     * the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method starts with a loop that iterates from {@code right} to <i>1</i> in a descending order.
     *     This loop controls the number of pancake flips needed to sort the list.</li>
     *     <li>Inside the loop, the {@code findIndex} method is called to find the index of
     *     the maximum element within the current range (<i>0</i> to {@code i}) using the provided comparison logic.
     *     The {@code findIndex} method likely searches for the index of
     *     the maximum element based on the {@code SortFunctional} comparison logic.</li>
     *     <li>If the found index {@code value} is not equal to {@code (i - 1)}, indicating that
     *     the maximum element is not already at the correct position,
     *     the flip method is called twice.
     *     The first flip operation flips the subarray from {@code n} to {@code value},
     *     bringing the maximum element to the beginning of the range.
     *     The second flip operation then flips the entire subarray from {@code n} to {@code (i - 1)},
     *     moving the maximum element to its correct position at the end of the range.</li>
     *     <li>The loop continues until the entire range is sorted, with the largest element at the end.
     *     At the end of the {@code pancake} method, the specified range of
     *     the list is sorted according to the provided comparison logic.</li>
     * </ul>
     * {@code pancake} method performs a variation of the Pancake Sort algorithm on a specific subarray defined by
     * the {@code left} and {@code right} indices.
     * This allows for sorting different sections of the list independently, which can be useful in certain scenarios.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         SortFind#findIndex(List, int, SortFunctional)
     * @see         SortSwap#flip(List, int, int)
     */
    protected <L extends Comparable> void pancake(List<L> list, SortFunctional<Comparable> functional) {
        int n = list.size();
        for (int i = n; i > 1; i--) {
            int value = findIndex(list, i, functional);
            if (value != (i - 1)) {
                flip(list, value);
                flip(list, (i - 1));
            }
        }

    }

    /**
     * {@code pancakeInc} sorts a list of {@link java.lang.Comparable Comparable} elements in ascending order.
     * <ul>
     *     <li>Now takes three parameters:
     *     the {@code list} to be sorted,
     *     {@code left} representing the left index of the current subarray,
     *     and {@code right} representing the right index of the current subarray.</li>
     *     <li>The loop is now started with {@code i} initialized to {@code right} instead of {@code n},
     *     representing the rightmost index of the current subarray.</li>
     *     <li>The loop continues as long as {@code i} is greater than {@code (left + 1)}.
     *     This means that the loop will stop when the subarray has only one element remaining.</li>
     *     <li>Inside the loop, the {@code findMaxIndex} method is called, passing the {@code list}, {@code left},
     *     and the current value of {@code i}.
     *     This method finds the index of the maximum element within the current subarray.</li>
     *     <li>If the maximum element is not at index {@code (i - 1)}, the flip method is called twice.
     *     The {@code flip} method now takes three parameters:
     *     the {@code list}, {@code left}, and the target index to which the subarray will be flipped.
     *     The first {@code flip} operation brings the maximum element to the leftmost position of the subarray,
     *     and the second {@code flip} operation moves it to the correct position within the subarray.</li>
     *     <li>The loop continues until the subarray is sorted,
     *     as the range of unsorted elements within the subarray decreases with each iteration.</li>
     * </ul>
     * {@code pancakeInc} method performs a variation of the Pancake Sort algorithm on a specific subarray defined by
     * the {@code left} and {@code right} indices.
     * This allows for sorting different sections of the list independently, which can be useful in certain scenarios.
     * @param       list to be arranged.
     * @param       left specific range of the list.
     * @param       right specific range of the list.
     * @see         SortFind#findMaxIndex(List, int, int)
     * @see         SortSwap#flip(List, int, int)
     */
    protected <L extends Comparable> void pancakeInc(List<L> list, int left, int right) {
        for (int i = right; i > (left + 1); i--) {
            int max = findMaxIndex(list, left, i);
            if (max != (i - 1)) {
                flip(list, left, max);
                flip(list, left, (i - 1));
            }
        }
    }

    /**
     * {@code pancakeDec} sorts a list of {@link java.lang.Comparable Comparable} elements in descending order.
     * <ul>
     *     <li>Now takes three parameters:
     *     the {@code list} to be sorted,
     *     {@code left} representing the left index of the current subarray,
     *     and {@code right} representing the right index of the current subarray.</li>
     *     <li>The loop is now started with {@code i} initialized to {@code right} instead of {@code n},
     *     representing the rightmost index of the current subarray.</li>
     *     <li>The loop continues as long as {@code i} is greater than {@code (left + 1)}.
     *     This means that the loop will stop when the subarray has only one element remaining.</li>
     *     <li>Inside the loop, the {@code findMinIndex} method is called, passing the {@code list}, {@code left},
     *     and the current value of {@code i}.
     *     This method finds the index of the minimum element within the current subarray.</li>
     *     <li>If the minimum element is not at index {@code (i - 1)}, the flip method is called twice.
     *     The {@code flip} method now takes three parameters:
     *     the {@code list}, {@code left}, and the target index to which the subarray will be flipped.
     *     The first {@code flip} operation brings the minimum element to the leftmost position of the subarray,
     *     and the second {@code flip} operation moves it to the correct position within the subarray.</li>
     *     <li>The loop continues until the subarray is sorted,
     *     as the range of unsorted elements within the subarray decreases with each iteration.</li>
     * </ul>
     * {@code pancakeDec} method performs a variation of the Pancake Sort algorithm on a specific subarray defined by
     * the {@code left} and {@code right} indices.
     * This allows for sorting different sections of the list independently, which can be useful in certain scenarios.
     * @param       list to be arranged.
     * @param       left specific range of the list.
     * @param       right specific range of the list.
     * @see         SortFind#findMaxIndex(List, int, int)
     * @see         SortSwap#flip(List, int, int)
     */
    protected <L extends Comparable> void pancakeDec(List<L> list, int left, int right) {
        for (int i = right; i > (left + 1); i--) {
            int min = findMinIndex(list, left, i);
            if (min != (i - 1)) {
                flip(list, left, min);
                flip(list, left, (i - 1));
            }
        }
    }

    /**
     * {@code pancake} method takes a list of {@link java.lang.Comparable Comparable} objects,
     * along with the {@code left} and {@code right} indices specifying the range of elements to be sorted.
     * It also takes a {@code SortFunctional<Comparable>} object representing
     * the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method starts with a loop that iterates from {@code right} to {@code (left + 1)} in a descending order.
     *     This loop controls the number of pancake flips needed to sort the list.</li>
     *     <li>Inside the loop, the {@code findIndex} method is called to find the index of
     *     the maximum element within the current range ({@code left} to {@code i}) using the provided comparison logic.
     *     The {@code findIndex} method likely searches for the index of
     *     the maximum element based on the {@code SortFunctional} comparison logic.</li>
     *     <li>If the found index {@code value} is not equal to {@code (i - 1)}, indicating that
     *     the maximum element is not already at the correct position,
     *     the flip method is called twice.
     *     The first flip operation flips the subarray from {@code left} to {@code value},
     *     bringing the maximum element to the beginning of the range.
     *     The second flip operation then flips the entire subarray from {@code left} to {@code (i - 1)},
     *     moving the maximum element to its correct position at the end of the range.</li>
     *     <li>The loop continues until the entire range is sorted, with the largest element at the end.
     *     At the end of the {@code pancake} method, the specified range of
     *     the list is sorted according to the provided comparison logic.</li>
     * </ul>
     * {@code pancake} method performs a variation of the Pancake Sort algorithm on a specific subarray defined by
     * the {@code left} and {@code right} indices.
     * This allows for sorting different sections of the list independently, which can be useful in certain scenarios.
     * @param       list to be arranged.
     * @param       left specific range of the list.
     * @param       right specific range of the list.
     * @param       functional lambda expression for comparison.
     * @see         SortFind#findIndex(List, int, int, SortFunctional)
     * @see         SortSwap#flip(List, int, int)
     */
    protected <L extends Comparable> void pancake(List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        for (int i = right; i > (left + 1); i--) {
            int value = findIndex(list, left, i, functional);
            if (value != (i - 1)) {
                flip(list, left, value);
                flip(list, left, (i - 1));
            }
        }
    }
}