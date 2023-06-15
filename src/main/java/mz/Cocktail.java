package mz;

/**
 * Cocktail Sort, also known as Cocktail Shaker Sort or Bidirectional Bubble Sort, is a variation of the Bubble Sort algorithm.
 * It works by repeatedly moving through the list in both directions, comparing adjacent elements and swapping them if they are in the wrong order.
 * This bidirectional movement helps to optimize the sorting process by sorting the largest and smallest elements simultaneously.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Cocktail
extends Bubble {

    /**
     * <b>Cocktail Sort:</b><br>
     * Also known as Cocktail Shaker Sort or Bidirectional Bubble Sort, is a variation of the Bubble Sort algorithm.
     * It works by repeatedly moving through the list in both directions, comparing adjacent elements and swapping them if they are in the wrong order.
     * This bidirectional movement helps to optimize the sorting process by sorting the largest and smallest elements simultaneously.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with an unsorted list of elements.</li>
     *     <li>Set two pointers, {@code start} and {@code end}, initially pointing to the first and last elements of the list, respectively.</li>
     *     <li>Repeat the following steps until no more swaps are made:</li>
     *     <ul>
     *         <li>Move the {@code start} pointer from left to right, comparing adjacent elements and swapping them if they are in the wrong order.</li>
     *         <li>If any swaps are made during this pass, mark that a swap occurred.</li>
     *         <li>Move the {@code end} pointer from right to left, comparing adjacent elements and swapping them if they are in the wrong order.</li>
     *         <li>If any swaps are made during this pass, mark that a swap occurred.</li>
     *         <li>If no swaps occurred during the entire pass (both from {@code start} to {@code end} and from {@code end} to {@code start}),
     *         the list is already sorted, and the algorithm can terminate.</li>
     *     </ul>
     *     <li>The sorted list is obtained once the algorithm terminates.</li>
     * </ol>
     * <b>Note:</b><br>
     * Cocktail Sort differs from the traditional Bubble Sort by introducing the bidirectional movement.
     * This bidirectional traversal helps to improve the efficiency of the algorithm by bringing both
     * the largest and smallest elements closer to their correct positions with each pass.<br><br>
     * Cocktail Sort has a time complexity of <em>O(n^2)</em> in the average and worst cases,
     * where <em>n</em> is the number of elements in the list. Although it has the same time complexity as Bubble Sort,
     * Cocktail Sort tends to perform better in practice due to the bidirectional movement.
     * However, it is still considered relatively inefficient for large datasets.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n^2)</em><br>
     * Average Case Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>Yes</b>
     * @see         mz.Comb#Comb() Comb
     * @see         mz.intro.IntroCocktail#IntroCocktail() IntroCocktail
     * @see         mz.intro.IntroComb#IntroComb() IntroComb
     */
    public Cocktail() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        cocktailInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        cocktailDec(array);
    }

    /**
     * {@code cocktailInc} that implements the cocktail sort algorithm to sort an array of Comparable objects in increasing order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, and performs the cocktail sort algorithm on it.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the array.</li>
     *     <li>The {@code start} variable is set to the index 0, representing the starting point of the current iteration.</li>
     *     <li>The {@code end} variable is set to the index of the last element in the array, representing the end point of the current iteration.</li>
     *     <li>The outer {@code while} loop continues as long as there are swaps being made in the array.</li>
     *     <li>Inside the {@code while} loop, the first {@code for} loop iterates from {@code start} to {@code (end - 1)}.
     *     It checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a swap is necessary.
     *     If a {@code swap} is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the first {@code for} loop, an if condition checks {@code if} any swaps were made in the iteration.
     *     If no swaps were made {@code (!swapped)}, it means the array is already sorted, and the loop breaks.</li>
     *     <li>Next, the {@code end} index is decremented by 1, as the largest element has already been placed at
     *     the correct position in the previous iteration.</li>
     *     <li>The second {@code for} loop iterates from {@code (end - 1)} to {@code start} in reverse order.
     *     It also checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a {@code swap} is necessary.
     *     If a {@code swap} is made, the swapped variable is set to true.</li>
     *     <li>After the second {@code for} loop, the {@code start} index is incremented by 1, as the smallest element
     *     has already been placed at the correct position in the previous iteration.</li>
     *     <li>The outer {@code while} loop continues until no swaps are made in the array, indicating that the array is fully sorted.</li>
     * </ul>
     * {@code cocktailInc} method combines the concepts of bubble sort and selection sort by traversing the array bidirectionally,
     * repeatedly swapping adjacent elements if they are out of order.
     * This process continues until the array becomes fully sorted.
     * @param       array to be arranged.
     * @see         mz.Cocktail#isSwapInc(Comparable[], int, int)
     */
    protected void cocktailInc(Comparable[] array) {
        boolean swapped = true;
        int start = 0, end = (array.length - 1);
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; ++i) {
                if (isSwapInc(array, i, 1)) {
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            --end;
            for (int i = end - 1; i >= start; i--) {
                if (isSwapInc(array, i, 1)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }

    /**
     * {@code cocktailDec} that implements the cocktail sort algorithm to sort an array of Comparable objects in decreasing order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, and performs the cocktail sort algorithm on it.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the array.</li>
     *     <li>The {@code start} variable is set to the index 0, representing the starting point of the current iteration.</li>
     *     <li>The {@code end} variable is set to the index of the last element in the array, representing the end point of the current iteration.</li>
     *     <li>The outer {@code while} loop continues as long as there are swaps being made in the array.</li>
     *     <li>Inside the {@code while} loop, the first {@code for} loop iterates from {@code start} to {@code (end - 1)}.
     *     It checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a swap is necessary.
     *     If a {@code swap} is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the first {@code for} loop, an if condition checks {@code if} any swaps were made in the iteration.
     *     If no swaps were made {@code (!swapped)}, it means the array is already sorted, and the loop breaks.</li>
     *     <li>Next, the {@code end} index is decremented by 1, as the largest element has already been placed at
     *     the correct position in the previous iteration.</li>
     *     <li>The second {@code for} loop iterates from {@code (end - 1)} to {@code start} in reverse order.
     *     It also checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a {@code swap} is necessary.
     *     If a {@code swap} is made, the swapped variable is set to true.</li>
     *     <li>After the second {@code for} loop, the {@code start} index is incremented by 1, as the smallest element
     *     has already been placed at the correct position in the previous iteration.</li>
     *     <li>The outer {@code while} loop continues until no swaps are made in the array, indicating that the array is fully sorted.</li>
     * </ul>
     * {@code cocktailDec} method combines the concepts of bubble sort and selection sort by traversing the array bidirectionally,
     * repeatedly swapping adjacent elements if they are out of order.
     * This process continues until the array becomes fully sorted.
     * @param       array to be arranged.
     * @see         mz.Cocktail#isSwapDec(Comparable[], int, int)
     */
    protected void cocktailDec(Comparable[] array) {
        boolean swapped = true;
        int start = 0, end = (array.length - 1);
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; ++i) {
                if (isSwapDec(array, i, 1)) {
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            --end;
            for (int i = (end - 1); i >= start; i--) {
                if (isSwapDec(array, i, 1)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }

    /**
     * {@code cocktailInc} that implements the cocktail sort algorithm to sort an array of Comparable objects in increasing order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, and performs the cocktail sort algorithm on it.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the array.</li>
     *     <li>The {@code start} variable is set to the index 0, representing the starting point of the current iteration.</li>
     *     <li>The {@code end} variable is set to the index of the last element in the array, representing the end point of the current iteration.</li>
     *     <li>The outer {@code while} loop continues as long as there are swaps being made in the array.</li>
     *     <li>Inside the {@code while} loop, the first {@code for} loop iterates from {@code start} to {@code (end - 1)}.
     *     It checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a swap is necessary.
     *     If a {@code swap} is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the first {@code for} loop, an if condition checks {@code if} any swaps were made in the iteration.
     *     If no swaps were made {@code (!swapped)}, it means the array is already sorted, and the loop breaks.</li>
     *     <li>Next, the {@code end} index is decremented by 1, as the largest element has already been placed at
     *     the correct position in the previous iteration.</li>
     *     <li>The second {@code for} loop iterates from {@code (end - 1)} to {@code start} in reverse order.
     *     It also checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a {@code swap} is necessary.
     *     If a {@code swap} is made, the swapped variable is set to true.</li>
     *     <li>After the second {@code for} loop, the {@code start} index is incremented by 1, as the smallest element
     *     has already been placed at the correct position in the previous iteration.</li>
     *     <li>The outer {@code while} loop continues until no swaps are made in the array, indicating that the array is fully sorted.</li>
     * </ul>
     * {@code cocktailInc} method combines the concepts of bubble sort and selection sort by traversing the array bidirectionally,
     * repeatedly swapping adjacent elements if they are out of order.
     * This process continues until the array becomes fully sorted.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.SortSwap#isSwapInc(Comparable[], int, int)
     */
    protected void cocktailInc(Comparable[] array, int left, int right) {
        boolean swapped = true;
        int start = left, end = (right - 1);
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; ++i) {
                if (isSwapInc(array, i, 1)) {
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            --end;
            for (int i = (end - 1); i >= start; i--) {
                if (isSwapInc(array, i, 1)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }

    /**
     * {@code cocktailDec} that implements the cocktail sort algorithm to sort an array of Comparable objects in decreasing order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, and performs the cocktail sort algorithm on it.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the array.</li>
     *     <li>The {@code start} variable is set to the index 0, representing the starting point of the current iteration.</li>
     *     <li>The {@code end} variable is set to the index of the last element in the array, representing the end point of the current iteration.</li>
     *     <li>The outer {@code while} loop continues as long as there are swaps being made in the array.</li>
     *     <li>Inside the {@code while} loop, the first {@code for} loop iterates from {@code start} to {@code (end - 1)}.
     *     It checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a swap is necessary.
     *     If a {@code swap} is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the first {@code for} loop, an if condition checks {@code if} any swaps were made in the iteration.
     *     If no swaps were made {@code (!swapped)}, it means the array is already sorted, and the loop breaks.</li>
     *     <li>Next, the {@code end} index is decremented by 1, as the largest element has already been placed at
     *     the correct position in the previous iteration.</li>
     *     <li>The second {@code for} loop iterates from {@code (end - 1)} to {@code start} in reverse order.
     *     It also checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a {@code swap} is necessary.
     *     If a {@code swap} is made, the swapped variable is set to true.</li>
     *     <li>After the second {@code for} loop, the {@code start} index is incremented by 1, as the smallest element
     *     has already been placed at the correct position in the previous iteration.</li>
     *     <li>The outer {@code while} loop continues until no swaps are made in the array, indicating that the array is fully sorted.</li>
     * </ul>
     * {@code cocktailDec} method combines the concepts of bubble sort and selection sort by traversing the array bidirectionally,
     * repeatedly swapping adjacent elements if they are out of order.
     * This process continues until the array becomes fully sorted.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.SortSwap#isSwapDec(Comparable[], int, int)
     */
    protected void cocktailDec(Comparable[] array, int left, int right) {
        boolean swapped = true;
        int start = left, end = (right - 1);
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; ++i) {
                if (isSwapDec(array, i, 1)) {
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            --end;
            for (int i = (end - 1); i >= start; i--) {
                if (isSwapDec(array, i, 1)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }
}