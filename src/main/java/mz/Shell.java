package mz;

/**
 * Shell Sort is an efficient sorting algorithm that is an extension of Insertion Sort.
 * It addresses one of the limitations of Insertion Sort,
 * which is the excessive shifting of elements when dealing with small elements towards the end of the array.
 * @since       1.1
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Shell
extends Insertion {

    /**
     * <b>Shell Sort:</b><br>
     * Is an efficient sorting algorithm that is an extension of Insertion Sort.
     * It addresses one of the limitations of Insertion Sort,
     * which is the excessive shifting of elements when dealing with small elements towards the end of the array.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Choose a gap sequence, which is a series of decreasing integers.
     *     Common gap sequences include
     *     the <i>Knuth</i> sequence <em>(3^k - 1) / 2</em>and the <i>Sedgewick</i> sequence <em>(4^k + 3 * 2^(k-1) + 1)</em>.</li>
     *     <li>Iterate over the gap sequence, performing Insertion Sort on each subarray with the chosen gap.</li>
     *     <li>For each gap, divide the array into multiple subarrays, where the elements in each subarray are at a distance of the gap.</li>
     *     <li>Apply Insertion Sort to each subarray independently.</li>
     *     <li>Decrease the gap and repeat steps 4-5 until the gap becomes 1.</li>
     *     <li>Finally, apply Insertion Sort with a gap of 1 to sort the array completely.</li>
     * </ol>
     * <b>Note:</b><br>
     * The key idea behind Shell Sort is to sort the array in a way that allows for efficient shifting of elements across larger gaps.
     * By sorting the array in stages using different gap sizes, Shell Sort gradually reduces the amount of shifting needed,
     * leading to a more efficient sorting process.<br><br>
     * Shell Sort has a time complexity that depends on the chosen gap sequence.
     * It can have an average-case time complexity of <em>O(n log(n)^2)</em> or better,
     * which makes it faster than simple quadratic sorting algorithms like Insertion Sort or Selection Sort.<br><br>
     * Shell Sort is an in-place algorithm, meaning it does not require additional memory beyond the original array.
     * It is widely used for medium-sized arrays or as a sub-routine in more advanced sorting algorithms.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n)^2)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>No</b>
     * @see         mz.intro.IntroShell#IntroShell() IntroShell
     */
    public Shell() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        shellInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        shellDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        shell(array, functional);
    }

    /**
     * {@code shellInc} that performs the Shell Sort algorithm on an array of {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and performs the Shell Sort algorithm on it.</li>
     *     <li>The method uses a {@code for} loop to iterate over a series of decreasing values of {@code i},
     *     which represents the gap between elements to be compared and swapped.</li>
     *     <li>The initial value of {@code i} is set to half the length of the {@code array}: {@code (array.length / 2)}.</li>
     *     <li>In each iteration of the loop, the value of {@code i} is divided by 2: {@code i /= 2}.</li>
     *     <li>The loop continues as long as {@code i} is greater than 0.</li>
     *     <li>Inside the loop, the {@code insertionInc} method is called with the current value
     *     of {@code i} to perform an insertion sort on the array.</li>
     *     <li>The {@code insertionInc} method sorts a portion of the array using the Insertion Sort algorithm with the specified {@code i} value.</li>
     *     <li>The insertion sort is performed on elements that are {@code i} positions apart.</li>
     *     <li>The process continues with decreasing values of {@code i} until {@code i} becomes 0, at which point the array is sorted.</li>
     * </ul>
     * {@code shellInc} method implements the Shell Sort algorithm to sort the given array of Comparable objects in ascending order.
     * It performs insertion sort on different portions of the array with decreasing gaps {@code i} until the entire array is sorted.
     * @param       array to be arranged.
     * @see         mz.InsertionInterface#insertionInc(Comparable[], int, int)
     */
    protected void shellInc(Comparable[] array) {
        for (int i = (array.length / 2) ; i > 0; i /= 2) {
            insertionInc(array, (i - 1), (array.length - 1));
        }
    }

    /**
     * {@code shellDec} that performs the Shell Sort algorithm on an array of {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and performs the Shell Sort algorithm on it.</li>
     *     <li>The method uses a {@code for} loop to iterate over a series of decreasing values of {@code i},
     *     which represents the gap between elements to be compared and swapped.</li>
     *     <li>The initial value of {@code i} is set to half the length of the {@code array}: {@code (array.length / 2)}.</li>
     *     <li>In each iteration of the loop, the value of {@code i} is divided by 2: {@code i /= 2}.</li>
     *     <li>The loop continues as long as {@code i} is greater than 0.</li>
     *     <li>Inside the loop, the {@code insertionDec} method is called with the current value
     *     of {@code i} to perform an insertion sort on the array.</li>
     *     <li>The {@code insertionDec} method sorts a portion of the array using the Insertion Sort algorithm with the specified {@code i} value.</li>
     *     <li>The insertion sort is performed on elements that are {@code i} positions apart.</li>
     *     <li>The process continues with decreasing values of {@code i} until {@code i} becomes 0, at which point the array is sorted.</li>
     * </ul>
     * {@code shellDec} method implements the Shell Sort algorithm to sort the given array of Comparable objects in ascending order.
     * It performs insertion sort on different portions of the array with decreasing gaps {@code i} until the entire array is sorted.
     * @param       array to be arranged.
     * @see         mz.InsertionInterface#insertionDec(Comparable[], int, int)
     */
    protected void shellDec(Comparable[] array) {
        for (int i = (array.length / 2); i > 0; i /= 2) {
            insertionDec(array, (i - 1), (array.length - 1));
        }
    }

    /**
     * {@code shell} method takes an array of {@link java.lang.Comparable Comparable} objects,
     * along with the left and right indices specifying the range of elements to be sorted.
     * It also takes a {@code SortFunctional<Comparable>} object representing
     * the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method starts with a for loop that initializes {@code i} to {@code (array.length / 2)} and iterates
     *     as long as {@code i} is greater than <i>0</i>. The {@code i} value is then divided by <i>2</i> in each iteration,
     *     effectively reducing the interval between elements to be compared and sorted.</li>
     *     <li>Inside the loop, the {@code insertion} method is called, which likely implements
     *     the insertion sort algorithm to sort the elements within the specified range, using the provided comparison logic.
     *     The {@code insertion} method would perform the sorting operation on the subarray.</li>
     *     <li>By calling the {@code insertion} method with the interval of {@code i} and the range from {@code i} to {@code array.length },
     *     the algorithm performs an insertion sort on the elements at intervals of {@code i}.
     *     As the loop iterates, the interval is gradually reduced until it reaches <i>0</i>,
     *     resulting in a final insertion sort on the entire range of elements.</li>
     * </ul>
     * {@code shell} method implements the Shell Sort algorithm to sort the given array of Comparable objects in ascending order.
     * It performs insertion sort on different portions of the array with decreasing gaps {@code i} until the entire array is sorted.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.InsertionInterface#insertion(Comparable[], int, int, SortFunctional)
     */
    protected void shell(Comparable[] array, SortFunctional<Comparable> functional) {
        for (int i = (array.length / 2); i > 0; i /= 2) {
            insertion(array, (i - 1), (array.length - 1), functional);
        }
    }

    /**
     * {@code shellInc} that performs the Shell Sort algorithm on an array of {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and performs the Shell Sort algorithm on it.</li>
     *     <li>The method uses a {@code for} loop to iterate over a series of decreasing values of {@code i},
     *     which represents the gap between elements to be compared and swapped.</li>
     *     <li>The initial value of {@code i} is set to half the length of the {@code array}: {@code (array.length / 2)}.</li>
     *     <li>In each iteration of the loop, the value of {@code i} is divided by 2: {@code i /= 2}.</li>
     *     <li>The loop continues as long as {@code i} is greater than 0.</li>
     *     <li>Inside the loop, the {@code insertionInc} method is called with the current value
     *     of {@code i} to perform an insertion sort on the array.</li>
     *     <li>The {@code insertionInc} method sorts a portion of the array using the Insertion Sort algorithm with the specified {@code i} value.</li>
     *     <li>The insertion sort is performed on elements that are {@code i} positions apart.</li>
     *     <li>The process continues with decreasing values of {@code i} until {@code i} becomes 0, at which point the array is sorted.</li>
     * </ul>
     * {@code shellInc} method implements the Shell Sort algorithm to sort the given array of Comparable objects in ascending order.
     * It performs insertion sort on different portions of the array with decreasing gaps {@code i} until the entire array is sorted.
     * @param       array to be arranged.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @see         mz.InsertionInterface#insertionInc(Comparable[], int, int)
     */
    protected void shellInc(Comparable[] array, int left, int right) {
        for (int i = (right / 2); i > left; i /= 2) {
            insertionInc(array, left, right);
        }
    }

    /**
     * {@code shellDec} that performs the Shell Sort algorithm on an array of {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and performs the Shell Sort algorithm on it.</li>
     *     <li>The method uses a {@code for} loop to iterate over a series of decreasing values of {@code i},
     *     which represents the gap between elements to be compared and swapped.</li>
     *     <li>The initial value of {@code i} is set to half the length of the {@code array}: {@code (array.length / 2)}.</li>
     *     <li>In each iteration of the loop, the value of {@code i} is divided by 2: {@code i /= 2}.</li>
     *     <li>The loop continues as long as {@code i} is greater than 0.</li>
     *     <li>Inside the loop, the {@code insertionDec} method is called with the current value
     *     of {@code i} to perform an insertion sort on the array.</li>
     *     <li>The {@code insertionDec} method sorts a portion of the array using the Insertion Sort algorithm with the specified {@code i} value.</li>
     *     <li>The insertion sort is performed on elements that are {@code i} positions apart.</li>
     *     <li>The process continues with decreasing values of {@code i} until {@code i} becomes 0, at which point the array is sorted.</li>
     * </ul>
     * {@code shellDec} method implements the Shell Sort algorithm to sort the given array of Comparable objects in ascending order.
     * It performs insertion sort on different portions of the array with decreasing gaps {@code i} until the entire array is sorted.
     * @param       array to be arranged.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @see         mz.InsertionInterface#insertionDec(Comparable[], int, int)
     */
    protected void shellDec(Comparable[] array, int left, int right) {
        for (int i = (right / 2); i > left; i /= 2) {
            insertionDec(array, i, right);
        }
    }

    /**
     * {@code shell} method takes an array of {@link java.lang.Comparable Comparable} objects,
     * along with the left and right indices specifying the range of elements to be sorted.
     * It also takes a {@code SortFunctional<Comparable>} object representing
     * the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method starts with a for loop that initializes {@code i} to {@code (right / 2)} and iterates
     *     as long as {@code i} is greater than {@code left}. The {@code i} value is then divided by <i>2</i> in each iteration,
     *     effectively reducing the interval between elements to be compared and sorted.</li>
     *     <li>Inside the loop, the {@code insertion} method is called, which likely implements
     *     the insertion sort algorithm to sort the elements within the specified range, using the provided comparison logic.
     *     The {@code insertion} method would perform the sorting operation on the subarray.</li>
     *     <li>By calling the {@code insertion} method with the interval of {@code i} and the range from {@code i} to {@code right},
     *     the algorithm performs an insertion sort on the elements at intervals of {@code i}.
     *     As the loop iterates, the interval is gradually reduced until it reaches {@code left},
     *     resulting in a final insertion sort on the entire range of elements.</li>
     * </ul>
     * {@code shell} method implements the Shell Sort algorithm to sort the given array of Comparable objects in ascending order.
     * It performs insertion sort on different portions of the array with decreasing gaps {@code i} until the entire array is sorted.
     * @param       array to be arranged.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         mz.InsertionInterface#insertion(Comparable[], int, int, SortFunctional)
     */
    protected void shell(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        for (int i = (right / 2); i > left; i /= 2) {
            insertion(array, i, right, functional);
        }
    }
}