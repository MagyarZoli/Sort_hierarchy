package mz;

/**
 * Shell Sort is an efficient sorting algorithm that is an extension of Insertion Sort.
 * It addresses one of the limitations of Insertion Sort,
 * which is the excessive shifting of elements when dealing with small elements towards the end of the array.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
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
     * {@code shellInc} that performs the Shell Sort algorithm on an array of Comparable objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and performs the Shell Sort algorithm on it.</li>
     *     <li>The method uses a {@code for} loop to iterate over a series of decreasing values of {@code k},
     *     which represents the gap between elements to be compared and swapped.</li>
     *     <ul>
     *         <li>The initial value of {@code k} is set to half the length of the {@code array}: {@code (array.length / 2)}.</li>
     *         <li>In each iteration of the loop, the value of {@code k} is divided by 2: {@code k /= 2}.</li>
     *         <li>The loop continues as long as {@code k} is greater than 0.</li>
     *     </ul>
     *     <li>Inside the loop, the {@link mz.InsertionInterface#insertionInc(Comparable[], int, int) insertionInc} method is called with the current value
     *     of {@code k} to perform an insertion sort on the array.</li>
     *     <ul>
     *         <li>The {@code insertionInc} method sorts a portion of the array using the Insertion Sort algorithm with the specified {@code k} value.</li>
     *         <li>The insertion sort is performed on elements that are {@code k} positions apart.</li>
     *     </ul>
     *     <li>The process continues with decreasing values of {@code k} until {@code k} becomes 0, at which point the array is sorted.</li>
     * </ul>
     * {@code shellInc} method implements the Shell Sort algorithm to sort the given array of Comparable objects in ascending order.
     * It performs insertion sort on different portions of the array with decreasing gaps {@code k} until the entire array is sorted.
     * @param       array to be arranged.
     */
    void shellInc(Comparable[] array) {
        for (int k = (array.length / 2); k > 0; k /= 2) {
            insertionInc(array, k, array.length);
        }
    }

    /**
     * {@code shellDec} that performs the Shell Sort algorithm on an array of Comparable objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and performs the Shell Sort algorithm on it.</li>
     *     <li>The method uses a {@code for} loop to iterate over a series of decreasing values of {@code k},
     *     which represents the gap between elements to be compared and swapped.</li>
     *     <ul>
     *         <li>The initial value of {@code k} is set to half the length of the {@code array}: {@code (array.length / 2)}.</li>
     *         <li>In each iteration of the loop, the value of {@code k} is divided by 2: {@code k /= 2}.</li>
     *         <li>The loop continues as long as {@code k} is greater than 0.</li>
     *     </ul>
     *     <li>Inside the loop, the {@link mz.InsertionInterface#insertionDec(Comparable[], int, int) insertionDec} method is called with the current value
     *     of {@code k} to perform an insertion sort on the array.</li>
     *     <ul>
     *         <li>The {@code insertionDec} method sorts a portion of the array using the Insertion Sort algorithm with the specified {@code k} value.</li>
     *         <li>The insertion sort is performed on elements that are {@code k} positions apart.</li>
     *     </ul>
     *     <li>The process continues with decreasing values of {@code k} until {@code k} becomes 0, at which point the array is sorted.</li>
     * </ul>
     * {@code shellDec} method implements the Shell Sort algorithm to sort the given array of Comparable objects in ascending order.
     * It performs insertion sort on different portions of the array with decreasing gaps {@code k} until the entire array is sorted.
     * @param       array to be arranged.
     */
    void shellDec(Comparable[] array) {
        for (int k = (array.length / 2); k > 0; k /= 2) {
            insertionDec(array, k, array.length);
        }
    }
}