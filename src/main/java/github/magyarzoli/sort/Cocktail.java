package github.magyarzoli.sort;

import github.magyarzoli.SortSwap;
import github.magyarzoli.sort.intro.IntroCocktail;

import java.util.List;

/**
 * Cocktail Sort, also known as Cocktail Shaker Sort or Bidirectional Bubble Sort, is a variation of the Bubble Sort algorithm.
 * It works by repeatedly moving through the list in both directions, comparing adjacent elements and swapping them if they are in the wrong order.
 * This bidirectional movement helps to optimize the sorting process by sorting the largest and smallest elements simultaneously.
 * @since       1.3
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
     *     <li>Move the {@code start} pointer from left to right, comparing adjacent elements and swapping them if they are in the wrong order.</li>
     *     <li>If any swaps are made during this pass, mark that a swap occurred.</li>
     *     <li>Move the {@code end} pointer from right to left, comparing adjacent elements and swapping them if they are in the wrong order.</li>
     *     <li>If any swaps are made during this pass, mark that a swap occurred.</li>
     *     <li>If no swaps occurred during the entire pass (both from {@code start} to {@code end} and from {@code end} to {@code start}),
     *     the list is already sorted, and the algorithm can terminate.</li>
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
     * @see         IntroCocktail#IntroCocktail() IntroCocktail
     * @see         Comb#Comb() Comb
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
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        cocktail(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        cocktailInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        cocktailDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        cocktail(list, functional);
    }

    /**
     * {@code cocktailInc} that implements the cocktail sort algorithm to sort an array of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
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
     * @see         Cocktail#isSwapInc(Comparable[], int, int)
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
            for (int i = (--end - 1); i >= start; i--) {
                if (isSwapInc(array, i, 1)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }

    /**
     * {@code cocktailDec} that implements the cocktail sort algorithm to sort an array of
     * {@link java.lang.Comparable Comparable} objects in decreasing order.
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
     * @see         Cocktail#isSwapDec(Comparable[], int, int)
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
            for (int i = (--end - 1); i >= start; i--) {
                if (isSwapDec(array, i, 1)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }

    /**
     * {@code cocktail} method takes an array {@code array} of type {@link java.lang.Comparable Comparable},
     * and an instance of the {@code SortFunctional<Comparable>} interface as parameters.
     * <ul>
     *     <li>It initializes a boolean variable {@code swapped} to {@code true} to indicate that a swap has occurred.</li>
     *     <li>It initializes two integer variables: {@code start} as the left index and <i>0</i> as {@code (array.length - 1)}.</li>
     *     <li>The method enters a while loop that continues as long as {@code swapped} is {@code true}.
     *     This loop performs one pass of the cocktail sort algorithm.</li>
     *     <li>Inside the loop, it sets {@code swapped} to {@code false} before each pass.</li>
     *     <li>It uses a for loop to iterate from start to end (left to right).
     *     Inside this loop, it calls the {@code isSwap} method to determine
     *     if a swap is needed between the elements at indices {@code i} and {@code (i + 1)}.
     *     If a swap is required, it sets {@code swapped} to {@code true}.</li>
     *     <li>After the forward pass, it checks if {@code swapped} is still {@code false}.
     *     If so, it breaks out of the loop since no swaps were made, and the array is already sorted.</li>
     *     <li>It sets {@code swapped} back to {@code false} before the backward pass.</li>
     *     <li>It uses a for loop to iterate from {@code (end - 1)} to {@code start} (right to left).
     *     Inside this loop, it again calls the {@code isSwap} method to determine
     *     if a swap is needed between the elements at indices {@code i} and {@code (i + 1)}.
     *     If a swap is required, it sets {@code swapped} to {@code true}.</li>
     *     <li>After the backward pass, it increments {@code start} by <i>1</i>,
     *     indicating that the elements at the left end are already sorted.</li>
     *     <li>The process continues until no swaps are made in either the forward or backward pass,
     *     indicating that the array is fully sorted.</li>
     * </ul>
     * {@code cocktail} method combines the concepts of bubble sort and selection sort by traversing the array bidirectionally,
     * repeatedly swapping adjacent elements if they are out of order.
     * This process continues until the array becomes fully sorted.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         SortSwap#isSwap(Comparable[], int, int, SortFunctional)
     */
    protected void cocktail(Comparable[] array, SortFunctional<Comparable> functional) {
        boolean swapped = true;
        int start = 0, end = (array.length - 1);
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; ++i) {
                if (isSwap(array, i, 1, functional)) {
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = (--end - 1); i >= start; i--) {
                if (isSwap(array, i, 1, functional)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }

    /**
     * {@code cocktailInc} that implements the cocktail sort algorithm to sort an array of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
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
     * @see         SortSwap#isSwapInc(Comparable[], int, int)
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
            for (int i = (--end - 1); i >= start; i--) {
                if (isSwapInc(array, i, 1)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }

    /**
     * {@code cocktailDec} that implements the cocktail sort algorithm to sort an array of
     * {@link java.lang.Comparable Comparable} objects in decreasing order.
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
     * @see         SortSwap#isSwapDec(Comparable[], int, int)
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
            for (int i = (--end - 1); i >= start; i--) {
                if (isSwapDec(array, i, 1)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }

    /**
     * {@code cocktail} method takes an array {@code array} of type {@link java.lang.Comparable Comparable},
     * an integer {@code left} representing the left index, an integer {@code right} representing the right index,
     * and an instance of the {@code SortFunctional<Comparable>} interface as parameters.
     * <ul>
     *     <li>It initializes a boolean variable {@code swapped} to {@code true} to indicate that a swap has occurred.</li>
     *     <li>It initializes two integer variables: {@code start} as the left index and {@code end} as {@code (right - 1)}.</li>
     *     <li>The method enters a while loop that continues as long as {@code swapped} is {@code true}.
     *     This loop performs one pass of the cocktail sort algorithm.</li>
     *     <li>Inside the loop, it sets {@code swapped} to {@code false} before each pass.</li>
     *     <li>It uses a for loop to iterate from start to end (left to right).
     *     Inside this loop, it calls the {@code isSwap} method to determine
     *     if a swap is needed between the elements at indices {@code i} and {@code (i + 1)}.
     *     If a swap is required, it sets {@code swapped} to {@code true}.</li>
     *     <li>After the forward pass, it checks if {@code swapped} is still {@code false}.
     *     If so, it breaks out of the loop since no swaps were made, and the array is already sorted.</li>
     *     <li>It sets {@code swapped} back to {@code false} before the backward pass.</li>
     *     <li>It uses a for loop to iterate from {@code (end - 1)} to {@code start} (right to left).
     *     Inside this loop, it again calls the {@code isSwap} method to determine
     *     if a swap is needed between the elements at indices {@code i} and {@code (i + 1)}.
     *     If a swap is required, it sets {@code swapped} to {@code true}.</li>
     *     <li>After the backward pass, it increments {@code start} by <i>1</i>,
     *     indicating that the elements at the left end are already sorted.</li>
     *     <li>The process continues until no swaps are made in either the forward or backward pass,
     *     indicating that the array is fully sorted.</li>
     * </ul>
     * {@code cocktail} method combines the concepts of bubble sort and selection sort by traversing the array bidirectionally,
     * repeatedly swapping adjacent elements if they are out of order.
     * This process continues until the array becomes fully sorted.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         SortSwap#isSwap(Comparable[], int, int, SortFunctional)
     */
    protected void cocktail(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        boolean swapped = true;
        int start = left, end = (right - 1);
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; ++i) {
                if (isSwap(array, i, 1, functional)) {
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = (--end - 1); i >= start; i--) {
                if (isSwap(array, i, 1, functional)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }

    /**
     * {@code cocktailInc} that implements the cocktail sort algorithm to sort a list of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list}, and performs the cocktail sort algorithm on it.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the list.</li>
     *     <li>The {@code start} variable is set to the index 0, representing the starting point of the current iteration.</li>
     *     <li>The {@code end} variable is set to the index of the last element in the list, representing the end point of the current iteration.</li>
     *     <li>The outer {@code while} loop continues as long as there are swaps being made in the list.</li>
     *     <li>Inside the {@code while} loop, the first {@code for} loop iterates from {@code start} to {@code (end - 1)}.
     *     It checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a swap is necessary.
     *     If a {@code swap} is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the first {@code for} loop, an if condition checks {@code if} any swaps were made in the iteration.
     *     If no swaps were made {@code (!swapped)}, it means the list is already sorted, and the loop breaks.</li>
     *     <li>Next, the {@code end} index is decremented by 1, as the largest element has already been placed at
     *     the correct position in the previous iteration.</li>
     *     <li>The second {@code for} loop iterates from {@code (end - 1)} to {@code start} in reverse order.
     *     It also checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a {@code swap} is necessary.
     *     If a {@code swap} is made, the swapped variable is set to true.</li>
     *     <li>After the second {@code for} loop, the {@code start} index is incremented by 1, as the smallest element
     *     has already been placed at the correct position in the previous iteration.</li>
     *     <li>The outer {@code while} loop continues until no swaps are made in the list, indicating that the list is fully sorted.</li>
     * </ul>
     * {@code cocktailInc} method combines the concepts of bubble sort and selection sort by traversing the list bidirectionally,
     * repeatedly swapping adjacent elements if they are out of order.
     * This process continues until the list becomes fully sorted.
     * @param       list to be arranged.
     * @see         Cocktail#isSwapInc(List, int, int)
     */
    protected <L extends Comparable> void cocktailInc(List<L> list) {
        boolean swapped = true;
        int start = 0, end = (list.size() - 1);
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; ++i) {
                if (isSwapInc(list, i, 1)) {
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = (--end - 1); i >= start; i--) {
                if (isSwapInc(list, i, 1)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }

    /**
     * {@code cocktailDec} that implements the cocktail sort algorithm to sort a list of
     * {@link java.lang.Comparable Comparable} objects in decreasing order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list}, and performs the cocktail sort algorithm on it.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the list.</li>
     *     <li>The {@code start} variable is set to the index 0, representing the starting point of the current iteration.</li>
     *     <li>The {@code end} variable is set to the index of the last element in the list, representing the end point of the current iteration.</li>
     *     <li>The outer {@code while} loop continues as long as there are swaps being made in the list.</li>
     *     <li>Inside the {@code while} loop, the first {@code for} loop iterates from {@code start} to {@code (end - 1)}.
     *     It checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a swap is necessary.
     *     If a {@code swap} is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the first {@code for} loop, an if condition checks {@code if} any swaps were made in the iteration.
     *     If no swaps were made {@code (!swapped)}, it means the list is already sorted, and the loop breaks.</li>
     *     <li>Next, the {@code end} index is decremented by 1, as the largest element has already been placed at
     *     the correct position in the previous iteration.</li>
     *     <li>The second {@code for} loop iterates from {@code (end - 1)} to {@code start} in reverse order.
     *     It also checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a {@code swap} is necessary.
     *     If a {@code swap} is made, the swapped variable is set to true.</li>
     *     <li>After the second {@code for} loop, the {@code start} index is incremented by 1, as the smallest element
     *     has already been placed at the correct position in the previous iteration.</li>
     *     <li>The outer {@code while} loop continues until no swaps are made in the list, indicating that the list is fully sorted.</li>
     * </ul>
     * {@code cocktailDec} method combines the concepts of bubble sort and selection sort by traversing the list bidirectionally,
     * repeatedly swapping adjacent elements if they are out of order.
     * This process continues until the list becomes fully sorted.
     * @param       list to be arranged.
     * @see         Cocktail#isSwapDec(List, int, int)
     */
    protected <L extends Comparable> void cocktailDec(List<L> list) {
        boolean swapped = true;
        int start = 0, end = (list.size() - 1);
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; ++i) {
                if (isSwapDec(list, i, 1)) {
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = (--end - 1); i >= start; i--) {
                if (isSwapDec(list, i, 1)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }

    /**
     * {@code cocktail} method takes a list {@code list} of type {@link java.lang.Comparable Comparable},
     * and an instance of the {@code SortFunctional<Comparable>} interface as parameters.
     * <ul>
     *     <li>It initializes a boolean variable {@code swapped} to {@code true} to indicate that a swap has occurred.</li>
     *     <li>It initializes two integer variables: {@code start} as the left index and <i>0</i> as {@code (list.size() - 1)}.</li>
     *     <li>The method enters a while loop that continues as long as {@code swapped} is {@code true}.
     *     This loop performs one pass of the cocktail sort algorithm.</li>
     *     <li>Inside the loop, it sets {@code swapped} to {@code false} before each pass.</li>
     *     <li>It uses a for loop to iterate from start to end (left to right).
     *     Inside this loop, it calls the {@code isSwap} method to determine
     *     if a swap is needed between the elements at indices {@code i} and {@code (i + 1)}.
     *     If a swap is required, it sets {@code swapped} to {@code true}.</li>
     *     <li>After the forward pass, it checks if {@code swapped} is still {@code false}.
     *     If so, it breaks out of the loop since no swaps were made, and the list is already sorted.</li>
     *     <li>It sets {@code swapped} back to {@code false} before the backward pass.</li>
     *     <li>It uses a for loop to iterate from {@code (end - 1)} to {@code start} (right to left).
     *     Inside this loop, it again calls the {@code isSwap} method to determine
     *     if a swap is needed between the elements at indices {@code i} and {@code (i + 1)}.
     *     If a swap is required, it sets {@code swapped} to {@code true}.</li>
     *     <li>After the backward pass, it increments {@code start} by <i>1</i>,
     *     indicating that the elements at the left end are already sorted.</li>
     *     <li>The process continues until no swaps are made in either the forward or backward pass,
     *     indicating that the list is fully sorted.</li>
     * </ul>
     * {@code cocktail} method combines the concepts of bubble sort and selection sort by traversing the list bidirectionally,
     * repeatedly swapping adjacent elements if they are out of order.
     * This process continues until the list becomes fully sorted.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         SortSwap#isSwap(List, int, int, SortFunctional)
     */
    protected <L extends Comparable> void cocktail(List<L> list, SortFunctional<Comparable> functional) {
        boolean swapped = true;
        int start = 0, end = (list.size() - 1);
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; ++i) {
                if (isSwap(list, i, 1, functional)) {
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = (--end - 1); i >= start; i--) {
                if (isSwap(list, i, 1, functional)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }

    /**
     * {@code cocktailInc} that implements the cocktail sort algorithm to sort a list of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
     * <ul>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list}, and performs the cocktail sort algorithm on it.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the list.</li>
     *     <li>The {@code start} variable is set to the index 0, representing the starting point of the current iteration.</li>
     *     <li>The {@code end} variable is set to the index of the last element in the list, representing the end point of the current iteration.</li>
     *     <li>The outer {@code while} loop continues as long as there are swaps being made in the list.</li>
     *     <li>Inside the {@code while} loop, the first {@code for} loop iterates from {@code start} to {@code (end - 1)}.
     *     It checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a swap is necessary.
     *     If a {@code swap} is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the first {@code for} loop, an if condition checks {@code if} any swaps were made in the iteration.
     *     If no swaps were made {@code (!swapped)}, it means the list is already sorted, and the loop breaks.</li>
     *     <li>Next, the {@code end} index is decremented by 1, as the largest element has already been placed at
     *     the correct position in the previous iteration.</li>
     *     <li>The second {@code for} loop iterates from {@code (end - 1)} to {@code start} in reverse order.
     *     It also checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a {@code swap} is necessary.
     *     If a {@code swap} is made, the swapped variable is set to true.</li>
     *     <li>After the second {@code for} loop, the {@code start} index is incremented by 1, as the smallest element
     *     has already been placed at the correct position in the previous iteration.</li>
     *     <li>The outer {@code while} loop continues until no swaps are made in the list, indicating that the list is fully sorted.</li>
     * </ul>
     * {@code cocktailInc} method combines the concepts of bubble sort and selection sort by traversing the list bidirectionally,
     * repeatedly swapping adjacent elements if they are out of order.
     * This process continues until the list becomes fully sorted.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         SortSwap#isSwapInc(List, int, int)
     */
    protected <L extends Comparable> void cocktailInc(List<L> list, int left, int right) {
        boolean swapped = true;
        int start = left, end = (right - 1);
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; ++i) {
                if (isSwapInc(list, i, 1)) {
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = (--end - 1); i >= start; i--) {
                if (isSwapInc(list, i, 1)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }

    /**
     * {@code cocktailDec} that implements the cocktail sort algorithm to sort a list of
     * {@link java.lang.Comparable Comparable} objects in decreasing order.
     * <ul>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list}, and performs the cocktail sort algorithm on it.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the list.</li>
     *     <li>The {@code start} variable is set to the index 0, representing the starting point of the current iteration.</li>
     *     <li>The {@code end} variable is set to the index of the last element in the list, representing the end point of the current iteration.</li>
     *     <li>The outer {@code while} loop continues as long as there are swaps being made in the list.</li>
     *     <li>Inside the {@code while} loop, the first {@code for} loop iterates from {@code start} to {@code (end - 1)}.
     *     It checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a swap is necessary.
     *     If a {@code swap} is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the first {@code for} loop, an if condition checks {@code if} any swaps were made in the iteration.
     *     If no swaps were made {@code (!swapped)}, it means the list is already sorted, and the loop breaks.</li>
     *     <li>Next, the {@code end} index is decremented by 1, as the largest element has already been placed at
     *     the correct position in the previous iteration.</li>
     *     <li>The second {@code for} loop iterates from {@code (end - 1)} to {@code start} in reverse order.
     *     It also checks pairs of adjacent elements and calls the {@code isSwap} method to determine if a {@code swap} is necessary.
     *     If a {@code swap} is made, the swapped variable is set to true.</li>
     *     <li>After the second {@code for} loop, the {@code start} index is incremented by 1, as the smallest element
     *     has already been placed at the correct position in the previous iteration.</li>
     *     <li>The outer {@code while} loop continues until no swaps are made in the list, indicating that the list is fully sorted.</li>
     * </ul>
     * {@code cocktailDec} method combines the concepts of bubble sort and selection sort by traversing the list bidirectionally,
     * repeatedly swapping adjacent elements if they are out of order.
     * This process continues until the list becomes fully sorted.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         SortSwap#isSwapDec(List, int, int)
     */
    protected <L extends Comparable> void cocktailDec(List<L> list, int left, int right) {
        boolean swapped = true;
        int start = left, end = (right - 1);
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; ++i) {
                if (isSwapDec(list, i, 1)) {
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = (--end - 1); i >= start; i--) {
                if (isSwapDec(list, i, 1)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }

    /**
     * {@code cocktail} method takes a list {@code list} of type {@link java.lang.Comparable Comparable},
     * an integer {@code left} representing the left index, an integer {@code right} representing the right index,
     * and an instance of the {@code SortFunctional<Comparable>} interface as parameters.
     * <ul>
     *     <li>It initializes a boolean variable {@code swapped} to {@code true} to indicate that a swap has occurred.</li>
     *     <li>It initializes two integer variables: {@code start} as the left index and {@code end} as {@code (right - 1)}.</li>
     *     <li>The method enters a while loop that continues as long as {@code swapped} is {@code true}.
     *     This loop performs one pass of the cocktail sort algorithm.</li>
     *     <li>Inside the loop, it sets {@code swapped} to {@code false} before each pass.</li>
     *     <li>It uses a for loop to iterate from start to end (left to right).
     *     Inside this loop, it calls the {@code isSwap} method to determine
     *     if a swap is needed between the elements at indices {@code i} and {@code (i + 1)}.
     *     If a swap is required, it sets {@code swapped} to {@code true}.</li>
     *     <li>After the forward pass, it checks if {@code swapped} is still {@code false}.
     *     If so, it breaks out of the loop since no swaps were made, and the list is already sorted.</li>
     *     <li>It sets {@code swapped} back to {@code false} before the backward pass.</li>
     *     <li>It uses a for loop to iterate from {@code (end - 1)} to {@code start} (right to left).
     *     Inside this loop, it again calls the {@code isSwap} method to determine
     *     if a swap is needed between the elements at indices {@code i} and {@code (i + 1)}.
     *     If a swap is required, it sets {@code swapped} to {@code true}.</li>
     *     <li>After the backward pass, it increments {@code start} by <i>1</i>,
     *     indicating that the elements at the left end are already sorted.</li>
     *     <li>The process continues until no swaps are made in either the forward or backward pass,
     *     indicating that the list is fully sorted.</li>
     * </ul>
     * {@code cocktail} method combines the concepts of bubble sort and selection sort by traversing the list bidirectionally,
     * repeatedly swapping adjacent elements if they are out of order.
     * This process continues until the list becomes fully sorted.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         SortSwap#isSwap(List, int, int, SortFunctional)
     */
    protected <L extends Comparable> void cocktail(List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        boolean swapped = true;
        int start = left, end = (right - 1);
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; ++i) {
                if (isSwap(list, i, 1, functional)) {
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = (--end - 1); i >= start; i--) {
                if (isSwap(list, i, 1, functional)) {
                    swapped = true;
                }
            }
            ++start;
        }
    }
}