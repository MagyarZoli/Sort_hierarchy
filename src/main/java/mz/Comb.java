package mz;

import java.util.List;

/**
 * Comb Sort is a comparison-based sorting algorithm that is an improvement over Bubble Sort.
 * It works by repeatedly comparing and swapping elements with a specific gap value, gradually reducing the gap until it reaches 1,
 * at which point the algorithm performs a final pass similar to Bubble Sort.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Comb
extends Cocktail {

    /**
     * <b>Comb Sort:</b><br>
     * Is a comparison-based sorting algorithm that is an improvement over Bubble Sort.
     * It works by repeatedly comparing and swapping elements with a specific gap value, gradually reducing the gap until it reaches 1,
     * at which point the algorithm performs a final pass similar to Bubble Sort.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with an unsorted list of elements.</li>
     *     <li>Initialize the gap value as the length of the list.</li>
     *     <li>Repeat the following steps until the gap becomes 1:</li>
     *     <li>Calculate the new gap value by dividing the current gap by a shrink factor, typically around<br>
     *     <em>1.3 (commonly denoted as 1.3 or 1.3-sqrt(2))</em>.</li>
     *     <li>If the new gap value is less than 1, set it to 1 to ensure a final pass with a gap of 1.</li>
     *     <li>Perform a pass through the list, comparing elements that are {@code gap} positions apart
     *     and swapping them if they are in the wrong order.</li>
     *     <li>Continue moving through the list with the specified gap until reaching the end of the list.</li>
     *     <li>Once the gap becomes 1, perform a final pass similar to Bubble Sort, comparing adjacent elements and swapping them if necessary.</li>
     *     <li>The sorted list is obtained once the final pass is completed.</li>
     * </ol>
     * <b>Note:</b><br>
     * The key idea behind Comb Sort is to eliminate the "turtle" effect in Bubble Sort,
     * where small elements at the end of the list take a long time to move towards their correct positions.
     * By gradually reducing the gap, Comb Sort helps bring such elements closer to their correct positions earlier in the sorting process.<br><br>
     * Comb Sort has a time complexity of <em>O(n^2)</em> in the worst case,
     * but it can be improved to have an average time complexity of <em>O(n log(n))</em> by using an optimal shrink factor.<br><br>
     * Comb Sort is an in-place sorting algorithm, meaning it requires only a constant amount of additional memory beyond the original list.
     * It is relatively easy to implement and can be useful in certain scenarios where simplicity and memory efficiency are priorities.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n^2 / 2^p)</em> where <em>p</em> is the number of increments<br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>Yes</b>
     * @see         mz.intro.IntroComb#IntroComb() IntroComb
     */
    public Comb() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        combInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        combDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        comb(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        combInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        combDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        comb(list, functional);
    }

    /**
     * {@code combInc} that implements the comb sort algorithm to sort an array of {@link java.lang.Comparable Comparable} objects in increasing order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, and performs the comb sort algorithm on it.</li>
     *     <li>The variable {@code n} is assigned the length of the array, representing the total number of elements in the array.</li>
     *     <li>The variable {@code gap} is initially set to {@code n}, representing the initial gap value for comparisons and swaps.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the array.</li>
     *     <li>The outer {@code while} loop continues as long as the gap is not equal to 1 or there are still swaps being made in the array.</li>
     *     <li>Inside the {@code while} loop, the {@code getNextGap} method is called to calculate the next gap value based on the current gap.</li>
     *     <li>The {@code for} loop iterates from 0 to {@code (n - gap)}, performing comparisons and swaps between elements with a specific gap.</li>
     *     <li>Inside the {@code for} loop, the {@code isSwap} method is called to determine if a swap is necessary between two elements with the given gap.
     *     If a swap is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the {@code for} loop, the outer {@code while} loop continues until the gap becomes 1 and no more swaps are made in the array.</li>
     * </ul>
     * {@code combInc} the Comb Sort algorithm is an improvement over the Bubble Sort algorithm.
     * It starts with a large {@code gap} value and gradually reduces it in each iteration.
     * The goal is to eliminate small values at the end of the array quickly.
     * The algorithm continues until the gap becomes 1, which is equivalent to a regular Bubble Sort
     * pass with adjacent element comparisons and swaps.
     * @param       array to be arranged.
     * @see         mz.Comb#getNextGap(int)
     * @see         mz.SortSwap#isSwapInc(Comparable[], int, int)
     */
    protected void combInc(Comparable[] array) {
        int n = array.length, gap = n;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < (n - gap); i++) {
                if (isSwapInc(array, i, gap)) {
                    swapped = true;
                }
            }
        }
    }

    /**
     * {@code combDec} that implements the comb sort algorithm to sort an array of {@link java.lang.Comparable Comparable} objects in decreasing order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, and performs the comb sort algorithm on it.</li>
     *     <li>The variable {@code n} is assigned the length of the array, representing the total number of elements in the array.</li>
     *     <li>The variable {@code gap} is initially set to {@code n}, representing the initial gap value for comparisons and swaps.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the array.</li>
     *     <li>The outer {@code while} loop continues as long as the gap is not equal to 1 or there are still swaps being made in the array.</li>
     *     <li>Inside the {@code while} loop, the {@code getNextGap} method is called to calculate the next gap value based on the current gap.</li>
     *     <li>The {@code for} loop iterates from 0 to {@code (n - gap)}, performing comparisons and swaps between elements with a specific gap.</li>
     *     <li>Inside the {@code for} loop, the {@code isSwap} method is called to determine if a swap is necessary between two elements with the given gap.
     *     If a swap is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the {@code for} loop, the outer {@code while} loop continues until the gap becomes 1 and no more swaps are made in the array.</li>
     * </ul>
     * {@code combDec} the Comb Sort algorithm is an improvement over the Bubble Sort algorithm.
     * It starts with a large {@code gap} value and gradually reduces it in each iteration.
     * The goal is to eliminate small values at the end of the array quickly.
     * The algorithm continues until the gap becomes 1, which is equivalent to a regular Bubble Sort
     * pass with adjacent element comparisons and swaps.
     * @param       array to be arranged.
     * @see         mz.Comb#getNextGap(int)
     * @see         mz.SortSwap#isSwapDec(Comparable[], int, int)
     */
    protected void combDec(Comparable[] array) {
        int n = array.length, gap = n;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < (n - gap); i++) {
                if (isSwapDec(array, i, gap)) {
                    swapped = true;
                }
            }
        }
    }

    /**
     * comb method takes an array {@code array} of type {@link java.lang.Comparable Comparable}
     * and an instance of the {@code SortFunctional<Comparable>} interface as parameters.
     * <ul>
     *     <li>It initializes an integer variable {@code n} with the length of the {@code array}.</li>
     *     <li>It initializes an integer variable {@code gap} with the value of {@code n}.</li>
     *     <li>It initializes a boolean variable {@code swapped} to {@code true} to indicate that a swap has occurred.</li>
     *     <li>The method enters a while loop that continues until {@code gap} is equal to <i>1</i> and no swaps are made.</li>
     *     <li>Inside the loop, it updates the value of {@code gap} by calling the {@code getNextGap} method,
     *     which determines the next gap size to be used in the comb sort algorithm.</li>
     *     <li>It sets {@code swapped} to {@code false} before each pass.</li>
     *     <li>It uses a for loop to iterate from <i>0</i> to {@code (n - gap)}.
     *     Inside this loop, it calls the {@code isSwap} method to determine if a swap
     *     is needed between the elements at indices {@code i} and {@code (i + gap)}.
     *     If a swap is required, it sets {@code swapped} to {@code true}.</li>
     *     <li>After the pass, it continues to the next iteration of
     *     the while loop if either {@code gap} is not equal to <i>1</i> or a swap occurred during the pass.</li>
     *     <li>The process continues until the array is fully sorted,
     *     indicated by {@code gap} being equal to <i>1</i> and no swaps being made.</li>
     * </ul>
     * {@code comb} the Comb Sort algorithm is an improvement over the Bubble Sort algorithm.
     * It starts with a large {@code gap} value and gradually reduces it in each iteration.
     * The goal is to eliminate small values at the end of the array quickly.
     * The algorithm continues until the gap becomes 1, which is equivalent to a regular Bubble Sort
     * pass with adjacent element comparisons and swaps.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.Comb#getNextGap(int)
     * @see         mz.SortSwap#isSwap(Comparable[], int, int, SortFunctional)
     */
    protected void comb(Comparable[] array, SortFunctional<Comparable> functional) {
        int n = array.length, gap = n;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < (n - gap); i++) {
                if (isSwap(array, i, gap, functional)) {
                    swapped = true;
                }
            }
        }
    }

    /**
     * {@code combInc} that implements the comb sort algorithm to sort an array of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, and performs the comb sort algorithm on it.</li>
     *     <li>The variable {@code right} is assigned the length of the array, representing the total number of elements in the array.</li>
     *     <li>The variable {@code gap} is initially set to {@code right}, representing the initial gap value for comparisons and swaps.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the array.</li>
     *     <li>The outer {@code while} loop continues as long as the gap is not equal to 1 or there are still swaps being made in the array.</li>
     *     <li>Inside the {@code while} loop, the {@code getNextGap} method is called to calculate the next gap value based on the current gap.</li>
     *     <li>The {@code for} loop iterates from 0 to {@code (right - gap)}, performing comparisons and swaps between elements with a specific gap.</li>
     *     <li>Inside the {@code for} loop, the {@code isSwap} method is called to determine if a swap is necessary between two elements with the given gap.
     *     If a swap is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the {@code for} loop, the outer {@code while} loop continues until the gap becomes 1 and no more swaps are made in the array.</li>
     * </ul>
     * {@code combInc} the Comb Sort algorithm is an improvement over the Bubble Sort algorithm.
     * It starts with a large {@code gap} value and gradually reduces it in each iteration.
     * The goal is to eliminate small values at the end of the array quickly.
     * The algorithm continues until the gap becomes 1, which is equivalent to a regular Bubble Sort
     * pass with adjacent element comparisons and swaps.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.Comb#getNextGap(int)
     * @see         mz.SortSwap#isSwapInc(Comparable[], int, int)
     */
    protected void combInc(Comparable[] array, int left, int right) {
        int gap = right;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = left; i < (right - gap); i++) {
                if (isSwapInc(array, i, gap)) {
                    swapped = true;
                }
            }
        }
    }

    /**
     * {@code combDec} that implements the comb sort algorithm to sort an array of
     * {@link java.lang.Comparable Comparable} objects in decreasing order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, and performs the comb sort algorithm on it.</li>
     *     <li>The variable {@code right} is assigned the length of the array, representing the total number of elements in the array.</li>
     *     <li>The variable {@code gap} is initially set to {@code right}, representing the initial gap value for comparisons and swaps.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the array.</li>
     *     <li>The outer {@code while} loop continues as long as the gap is not equal to 1 or there are still swaps being made in the array.</li>
     *     <li>Inside the {@code while} loop, the {@code getNextGap} method is called to calculate the next gap value based on the current gap.</li>
     *     <li>The {@code for} loop iterates from 0 to {@code (right - gap)}, performing comparisons and swaps between elements with a specific gap.</li>
     *     <li>Inside the {@code for} loop, the {@code isSwap} method is called to determine if a swap is necessary between two elements with the given gap.
     *     If a swap is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the {@code for} loop, the outer {@code while} loop continues until the gap becomes 1 and no more swaps are made in the array.</li>
     * </ul>
     * {@code combDec} the Comb Sort algorithm is an improvement over the Bubble Sort algorithm.
     * It starts with a large {@code gap} value and gradually reduces it in each iteration.
     * The goal is to eliminate small values at the end of the array quickly.
     * The algorithm continues until the gap becomes 1, which is equivalent to a regular Bubble Sort
     * pass with adjacent element comparisons and swaps.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.Comb#getNextGap(int)
     * @see         mz.SortSwap#isSwapDec(Comparable[], int, int)
     */
    protected void combDec(Comparable[] array, int left, int right) {
        int gap = right;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = left; i < (right - gap); i++) {
                if (isSwapDec(array, i, gap)) {
                    swapped = true;
                }
            }
        }
    }

    /**
     * {@code comb} method takes an array {@code array} of type {@link java.lang.Comparable Comparable},
     * an integer {@code left} representing the left index, an integer {@code right} representing the right index,
     * and an instance of the {@code SortFunctional<Comparable>} interface as parameters.
     * <ul>
     *     <li>It initializes an integer variable {@code gap} with the value of {@code right}.</li>
     *     <li>It initializes a boolean variable {@code swapped} to {@code true} to indicate that a swap has occurred.</li>
     *     <li>The method enters a while loop that continues until {@code gap} is equal to <i>1</i> and no swaps are made.</li>
     *     <li>Inside the loop, it updates the value of {@code gap} by calling the {@code getNextGap} method.
     *     This method determines the next gap size to be used in the comb sort algorithm.</li>
     *     <li>It sets {@code swapped} to {@code false} before each pass.</li>
     *     <li>It uses a for loop to iterate from {@code left} to {@code (right - gap)}.
     *     Inside this loop, it calls the {@code isSwap} method to determine if
     *     a swap is needed between the elements at indices {@code i} and {@code (i + gap)}.
     *     If a swap is required, it sets {@code swapped} to {@code true}.</li>
     *     <li>After the pass, it continues to the next iteration of
     *     the while loop if either {@code gap} is not equal to <i>1</i> or a swap occurred during the pass.</li>
     *     <li>The process continues until the array is fully sorted,
     *     indicated by {@code gap} being equal to <i>1</i> and no swaps being made.</li>
     * </ul>
     * {@code comb} the Comb Sort algorithm is an improvement over the Bubble Sort algorithm.
     * It starts with a large {@code gap} value and gradually reduces it in each iteration.
     * The goal is to eliminate small values at the end of the array quickly.
     * The algorithm continues until the gap becomes 1, which is equivalent to a regular Bubble Sort
     * pass with adjacent element comparisons and swaps.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         mz.Comb#getNextGap(int)
     * @see         mz.SortSwap#isSwap(Comparable[], int, int, SortFunctional)
     */
    protected void comb(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        int gap = right;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = left; i < (right - gap); i++) {
                if (isSwap(array, i, gap, functional)) {
                    swapped = true;
                }
            }
        }
    }

    /**
     * {@code combInc} that implements the comb sort algorithm to sort a list of {@link java.lang.Comparable Comparable} objects in increasing order.
     * <ul>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list}, and performs the comb sort algorithm on it.</li>
     *     <li>The variable {@code n} is assigned the length of the list, representing the total number of elements in the list.</li>
     *     <li>The variable {@code gap} is initially set to {@code n}, representing the initial gap value for comparisons and swaps.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the list.</li>
     *     <li>The outer {@code while} loop continues as long as the gap is not equal to 1 or there are still swaps being made in the list.</li>
     *     <li>Inside the {@code while} loop, the {@code getNextGap} method is called to calculate the next gap value based on the current gap.</li>
     *     <li>The {@code for} loop iterates from 0 to {@code (n - gap)}, performing comparisons and swaps between elements with a specific gap.</li>
     *     <li>Inside the {@code for} loop, the {@code isSwap} method is called to determine if a swap is necessary between two elements with the given gap.
     *     If a swap is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the {@code for} loop, the outer {@code while} loop continues until the gap becomes 1 and no more swaps are made in the list.</li>
     * </ul>
     * {@code combInc} the Comb Sort algorithm is an improvement over the Bubble Sort algorithm.
     * It starts with a large {@code gap} value and gradually reduces it in each iteration.
     * The goal is to eliminate small values at the end of the list quickly.
     * The algorithm continues until the gap becomes 1, which is equivalent to a regular Bubble Sort
     * pass with adjacent element comparisons and swaps.
     * @param       list to be arranged.
     * @see         mz.Comb#getNextGap(int)
     * @see         mz.SortSwap#isSwapInc(List, int, int)
     */
    protected <L extends Comparable> void combInc(List<L> list) {
        int n = list.size(), gap = n;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < (n - gap); i++) {
                if (isSwapInc(list, i, gap)) {
                    swapped = true;
                }
            }
        }
    }

    /**
     * {@code combDec} that implements the comb sort algorithm to sort a list of {@link java.lang.Comparable Comparable} objects in decreasing order.
     * <ul>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list}, and performs the comb sort algorithm on it.</li>
     *     <li>The variable {@code n} is assigned the length of the list, representing the total number of elements in the list.</li>
     *     <li>The variable {@code gap} is initially set to {@code n}, representing the initial gap value for comparisons and swaps.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the list.</li>
     *     <li>The outer {@code while} loop continues as long as the gap is not equal to 1 or there are still swaps being made in the list.</li>
     *     <li>Inside the {@code while} loop, the {@code getNextGap} method is called to calculate the next gap value based on the current gap.</li>
     *     <li>The {@code for} loop iterates from 0 to {@code (n - gap)}, performing comparisons and swaps between elements with a specific gap.</li>
     *     <li>Inside the {@code for} loop, the {@code isSwap} method is called to determine if a swap is necessary between two elements with the given gap.
     *     If a swap is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the {@code for} loop, the outer {@code while} loop continues until the gap becomes 1 and no more swaps are made in the list.</li>
     * </ul>
     * {@code combDec} the Comb Sort algorithm is an improvement over the Bubble Sort algorithm.
     * It starts with a large {@code gap} value and gradually reduces it in each iteration.
     * The goal is to eliminate small values at the end of the list quickly.
     * The algorithm continues until the gap becomes 1, which is equivalent to a regular Bubble Sort
     * pass with adjacent element comparisons and swaps.
     * @param       list to be arranged.
     * @see         mz.Comb#getNextGap(int)
     * @see         mz.SortSwap#isSwapDec(List, int, int)
     */
    protected <L extends Comparable> void combDec(List<L> list) {
        int n = list.size(), gap = n;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < (n - gap); i++) {
                if (isSwapDec(list, i, gap)) {
                    swapped = true;
                }
            }
        }
    }

    /**
     * comb method takes an list {@code list} of type {@link java.lang.Comparable Comparable}
     * and an instance of the {@code SortFunctional<Comparable>} interface as parameters.
     * <ul>
     *     <li>It initializes an integer variable {@code n} with the length of the {@code list}.</li>
     *     <li>It initializes an integer variable {@code gap} with the value of {@code n}.</li>
     *     <li>It initializes a boolean variable {@code swapped} to {@code true} to indicate that a swap has occurred.</li>
     *     <li>The method enters a while loop that continues until {@code gap} is equal to <i>1</i> and no swaps are made.</li>
     *     <li>Inside the loop, it updates the value of {@code gap} by calling the {@code getNextGap} method,
     *     which determines the next gap size to be used in the comb sort algorithm.</li>
     *     <li>It sets {@code swapped} to {@code false} before each pass.</li>
     *     <li>It uses a for loop to iterate from <i>0</i> to {@code (n - gap)}.
     *     Inside this loop, it calls the {@code isSwap} method to determine if a swap
     *     is needed between the elements at indices {@code i} and {@code (i + gap)}.
     *     If a swap is required, it sets {@code swapped} to {@code true}.</li>
     *     <li>After the pass, it continues to the next iteration of
     *     the while loop if either {@code gap} is not equal to <i>1</i> or a swap occurred during the pass.</li>
     *     <li>The process continues until the list is fully sorted,
     *     indicated by {@code gap} being equal to <i>1</i> and no swaps being made.</li>
     * </ul>
     * {@code comb} the Comb Sort algorithm is an improvement over the Bubble Sort algorithm.
     * It starts with a large {@code gap} value and gradually reduces it in each iteration.
     * The goal is to eliminate small values at the end of the list quickly.
     * The algorithm continues until the gap becomes 1, which is equivalent to a regular Bubble Sort
     * pass with adjacent element comparisons and swaps.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.Comb#getNextGap(int)
     * @see         mz.SortSwap#isSwap(List, int, int, SortFunctional)
     */
    protected <L extends Comparable> void comb(List<L> list, SortFunctional<Comparable> functional) {
        int n = list.size(), gap = n;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < (n - gap); i++) {
                if (isSwap(list, i, gap, functional)) {
                    swapped = true;
                }
            }
        }
    }

    /**
     * {@code combInc} that implements the comb sort algorithm to sort an list of
     * {@link java.lang.Comparable Comparable} objects in increasing order.
     * <ul>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list}, and performs the comb sort algorithm on it.</li>
     *     <li>The variable {@code right} is assigned the length of the list, representing the total number of elements in the list.</li>
     *     <li>The variable {@code gap} is initially set to {@code right}, representing the initial gap value for comparisons and swaps.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the list.</li>
     *     <li>The outer {@code while} loop continues as long as the gap is not equal to 1 or there are still swaps being made in the list.</li>
     *     <li>Inside the {@code while} loop, the {@code getNextGap} method is called to calculate the next gap value based on the current gap.</li>
     *     <li>The {@code for} loop iterates from 0 to {@code (right - gap)}, performing comparisons and swaps between elements with a specific gap.</li>
     *     <li>Inside the {@code for} loop, the {@code isSwap} method is called to determine if a swap is necessary between two elements with the given gap.
     *     If a swap is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the {@code for} loop, the outer {@code while} loop continues until the gap becomes 1 and no more swaps are made in the list.</li>
     * </ul>
     * {@code combInc} the Comb Sort algorithm is an improvement over the Bubble Sort algorithm.
     * It starts with a large {@code gap} value and gradually reduces it in each iteration.
     * The goal is to eliminate small values at the end of the list quickly.
     * The algorithm continues until the gap becomes 1, which is equivalent to a regular Bubble Sort
     * pass with adjacent element comparisons and swaps.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         mz.Comb#getNextGap(int)
     * @see         mz.SortSwap#isSwapInc(List, int, int)
     */
    protected <L extends Comparable> void combInc(List<L> list, int left, int right) {
        int gap = right;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = left; i < (right - gap); i++) {
                if (isSwapInc(list, i, gap)) {
                    swapped = true;
                }
            }
        }
    }

    /**
     * {@code combDec} that implements the comb sort algorithm to sort an list of
     * {@link java.lang.Comparable Comparable} objects in decreasing order.
     * <ul>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list}, and performs the comb sort algorithm on it.</li>
     *     <li>The variable {@code right} is assigned the length of the list, representing the total number of elements in the list.</li>
     *     <li>The variable {@code gap} is initially set to {@code right}, representing the initial gap value for comparisons and swaps.</li>
     *     <li>The swapped variable is initially set to {@code true}, indicating that there may be swaps to perform in the list.</li>
     *     <li>The outer {@code while} loop continues as long as the gap is not equal to 1 or there are still swaps being made in the list.</li>
     *     <li>Inside the {@code while} loop, the {@code getNextGap} method is called to calculate the next gap value based on the current gap.</li>
     *     <li>The {@code for} loop iterates from 0 to {@code (right - gap)}, performing comparisons and swaps between elements with a specific gap.</li>
     *     <li>Inside the {@code for} loop, the {@code isSwap} method is called to determine if a swap is necessary between two elements with the given gap.
     *     If a swap is made, the swapped variable is set to {@code true}.</li>
     *     <li>After the {@code for} loop, the outer {@code while} loop continues until the gap becomes 1 and no more swaps are made in the list.</li>
     * </ul>
     * {@code combDec} the Comb Sort algorithm is an improvement over the Bubble Sort algorithm.
     * It starts with a large {@code gap} value and gradually reduces it in each iteration.
     * The goal is to eliminate small values at the end of the list quickly.
     * The algorithm continues until the gap becomes 1, which is equivalent to a regular Bubble Sort
     * pass with adjacent element comparisons and swaps.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         mz.Comb#getNextGap(int)
     * @see         mz.SortSwap#isSwapDec(List, int, int)
     */
    protected <L extends Comparable> void combDec(List<L> list, int left, int right) {
        int gap = right;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = left; i < (right - gap); i++) {
                if (isSwapDec(list, i, gap)) {
                    swapped = true;
                }
            }
        }
    }

    /**
     * {@code comb} method takes a list {@code list} of type {@link java.lang.Comparable Comparable},
     * an integer {@code left} representing the left index, an integer {@code right} representing the right index,
     * and an instance of the {@code SortFunctional<Comparable>} interface as parameters.
     * <ul>
     *     <li>It initializes an integer variable {@code gap} with the value of {@code right}.</li>
     *     <li>It initializes a boolean variable {@code swapped} to {@code true} to indicate that a swap has occurred.</li>
     *     <li>The method enters a while loop that continues until {@code gap} is equal to <i>1</i> and no swaps are made.</li>
     *     <li>Inside the loop, it updates the value of {@code gap} by calling the {@code getNextGap} method.
     *     This method determines the next gap size to be used in the comb sort algorithm.</li>
     *     <li>It sets {@code swapped} to {@code false} before each pass.</li>
     *     <li>It uses a for loop to iterate from {@code left} to {@code (right - gap)}.
     *     Inside this loop, it calls the {@code isSwap} method to determine if
     *     a swap is needed between the elements at indices {@code i} and {@code (i + gap)}.
     *     If a swap is required, it sets {@code swapped} to {@code true}.</li>
     *     <li>After the pass, it continues to the next iteration of
     *     the while loop if either {@code gap} is not equal to <i>1</i> or a swap occurred during the pass.</li>
     *     <li>The process continues until the list is fully sorted,
     *     indicated by {@code gap} being equal to <i>1</i> and no swaps being made.</li>
     * </ul>
     * {@code comb} the Comb Sort algorithm is an improvement over the Bubble Sort algorithm.
     * It starts with a large {@code gap} value and gradually reduces it in each iteration.
     * The goal is to eliminate small values at the end of the list quickly.
     * The algorithm continues until the gap becomes 1, which is equivalent to a regular Bubble Sort
     * pass with adjacent element comparisons and swaps.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         mz.Comb#getNextGap(int)
     * @see         mz.SortSwap#isSwap(List, int, int, SortFunctional)
     */
    protected <L extends Comparable> void comb(List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        int gap = right;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = left; i < (right - gap); i++) {
                if (isSwap(list, i, gap, functional)) {
                    swapped = true;
                }
            }
        }
    }

    /**
     * {@code getNextGap} that calculates the next {@code gap} value to be used in the Comb Sort algorithm.
     * The gap value determines the interval between elements being compared and swapped during each iteration of the sort.
     * <ul>
     *     <li>The method takes an integer {@code gap} as input and calculates the next gap value to be used.</li>
     *     <li>The expression {@code gap = ((gap * 10) / 13)} calculates the next {@code gap} by multiplying the current gap by 10 and then dividing it by 13.
     *     The multiplication and division operations are used to adjust the {@code gap} value.</li>
     *     <li>The condition {@code if (gap < 1)} checks if the calculated {@code gap} value is less than 1.
     *     If so, it sets the gap value to 1.
     *     This ensures that the gap value never becomes zero or negative.</li>
     *     <li>Finally, the method returns the calculated or adjusted gap value.</li>
     * </ul>
     * {@code getNextGap} method is commonly used in comb sort algorithms to determine the next gap value during each iteration.
     * The {@code gap} is gradually reduced until it becomes 1,
     * at which point the algorithm performs a final pass with a gap of 1 to ensure full sorting.
     * The specific formula used to calculate the next gap value may vary depending on the implementation.
     * @param       gap value to be used.
     * @return      the calculated or adjusted {@code gap} value.
     */
    protected int getNextGap(int gap) {
        gap = ((gap * 10) / 13);
        if (gap < 1) {
            return 1;
        }
        return gap;
    }
}