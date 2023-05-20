package mz;

import java.util.Arrays;

/**
 * Counting Sort is a non-comparison based sorting algorithm that sorts elements based on their numeric values.
 * It works by determining, for each element in the input array, the number of elements that are smaller than it.
 * With this information, it can then determine the correct position of each element in the sorted output array.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class Counting
extends SortLong {

    /**
     * <b>Counting Sort:</b><br> You can only sort with whole numbers!
     * Is a non-comparison based sorting algorithm that sorts elements based on their numeric values.
     * It works by determining, for each element in the input array, the number of elements that are smaller than it.
     * With this information, it can then determine the correct position of each element in the sorted output array.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Find the maximum element in the input array and determine its value.
     *     Let's call this maximum value "k".</li>
     *     <li>Create a count array of size k+1, initialized with all elements set to 0. This count array
     *     will be used to store the frequency of each distinct element in the input array.</li>
     *     <li>Iterate through the input array and increment the corresponding count in the count array for each element encountered.
     *     This step essentially counts the number of occurrences of each element.</li>
     *     <li>Modify the count array by adding the previous count to the current count at each index.
     *     This modification allows the count array to store the starting position of each element in the sorted output array.</li>
     *     <li>Create a sorted output array of the same size as the input array.</li>
     *     <li>Iterate through the input array in reverse order.
     *     For each element encountered, find its corresponding position in the sorted output array using the count array.
     *     Place the element in the sorted output array at the determined position and decrement the count in the count array.</li>
     *     <li>The sorted output array now contains the elements in the input array sorted in non-decreasing order.</li>
     * </ol>
     * <b>Note:</b><br>
     * Counting Sort has a time complexity of <em>O(n + k)</em>, where n is the number of elements in the input array and k is the range of the input values.
     * It is most effective when the range of input values is relatively small compared to the number of elements.
     * However, it requires additional memory space for the count array, which makes it less practical for large ranges of input values.<br><br>
     * Counting Sort is stable, meaning it preserves the relative order of elements with equal values.
     * It is often used as a subroutine in other sorting algorithms or when sorting elements with known ranges,
     * such as non-negative integers.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n+k)</em><br>
     * Best Case Complexity:    <em>O(n+k)</em><br>
     * Average Case Complexity: <em>O(n+k)</em><br>
     * Auxiliary Space:         <em>O(max)</em><br>
     * Stability:               <b>Yes</b>
     */
    public Counting(){}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         mz.Counting#countingInc(Long[]) 
     */
    @Override
    public void sortArrayInc(Long[] array) {
        countingInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         mz.Counting#countingDec(Long[])                    
     */
    @Override
    public void sortArrayDec(Long[] array) {
        countingDec(array);
    }

    /**
     * {@code countingInc} that performs an incremental counting sort on an array of Long values.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an array of Long values, {@code array},
     *     and performs an incremental counting sort on it.</li>
     *     <li>It begins by determining the length of the {@code array}
     *     and finding the maximum value in the array using the {@code findMax} method.</li>
     *     <li>A new array, {@code output}, is created and initialized as a copy of the original
     *     {@code array} using {@code Arrays.copyOf}.
     *     This {@code output} array will store the sorted elements.</li>
     *     <li>An integer array, {@code count}, is created with a length of {@code (k + 1)},
     *     where {@code k} is the maximum value in the {@code array}.</li>
     *     <li>The {@code countingUpload} method is called to perform counting based on the elements in the {@code array}.
     *     This updates the {@code count} array accordingly.</li>
     *     <li>The {@code countingCycles} method is called to perform cumulative counting on the {@code count} array.</li>
     *     <li>A backward {@code for} loop is used to iterate through the elements of the {@code array} in reverse order.
     *     This loop is responsible for placing the elements in their sorted positions in the {@code output} array.</li>
     *     <ul>
     *         <li>The {@code output} array is updated by assigning the value {@code array[i]} to the index calculated based on
     *         the count of the element in the {@code count} array:
     *         {@code output[count[Math.toIntExact(array[i])] - 1] = array[i]}.</li>
     *         <li>The {@code count} of the element in the count array is then decremented:
     *         {@code count[Math.toIntExact(array[i])]--}.</li>
     *     </ul>
     *     <li>Finally, a forward {@code for} loop is used to copy the sorted elements from the {@code output} array
     *     back to the original {@code array} in ascending order.</li>
     * </ul>
     * {@code countingInc} method uses counting sort to sort the given {@code array} of Long values in ascending order.
     * It performs counting, cumulative counting, and placement of elements in their sorted positions using auxiliary arrays.
     * The original {@code array} is then updated with the sorted elements.
     * @param       array to be arranged.
     */
    void countingInc(Long[] array) {
        int n = array.length;
        Long k = findMax(array);
        Long[] output = Arrays.copyOf(array, array.length);
        int[] count = new int[(int) (k + 1)];
        countingUpload(count, n, array, 0L);
        countingCycles(count, k);
        for (int i = (n - 1); i >= 0; i--) {
            output[count[Math.toIntExact(array[i])] - 1] = array[i];
            count[Math.toIntExact(array[i])]--;
        }
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    /**
     * {@code countingDec} that performs a decremental counting sort on an array of Long values.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an array of Long values, {@code array},
     *     and performs an decremental counting sort on it.</li>
     *     <li>It begins by determining the length of the {@code array}
     *     and finding the maximum value in the array using the {@code findMax} method.</li>
     *     <li>A new array, {@code output}, is created and initialized as a copy of the original
     *     {@code array} using {@code Arrays.copyOf}.
     *     This {@code output} array will store the sorted elements.</li>
     *     <li>An integer array, {@code count}, is created with a length of {@code (k + 1)},
     *     where {@code k} is the maximum value in the {@code array}.</li>
     *     <li>The {@code countingUpload} method is called to perform counting based on the elements in the {@code array}.
     *     This updates the {@code count} array accordingly.</li>
     *     <li>The {@code countingCycles} method is called to perform cumulative counting on the {@code count} array.</li>
     *     <li>A backward {@code for} loop is used to iterate through the elements of the {@code array} in reverse order.
     *     This loop is responsible for placing the elements in their sorted positions in the {@code output} array.</li>
     *     <ul>
     *         <li>The {@code output} array is updated by assigning the value {@code array[i]} to the index calculated based on
     *         the count of the element in the {@code count} array:
     *         {@code output[count[Math.toIntExact(array[i])] - 1] = array[i]}.</li>
     *         <li>The {@code count} of the element in the count array is then decremented:
     *         {@code count[Math.toIntExact(array[i])]--}.</li>
     *     </ul>
     *     <li>Finally, a forward {@code for} loop is used to copy the sorted elements from the {@code output} array
     *     back to the original {@code array} in descending order.</li>
     * </ul>
     * {@code countingDec} method uses counting sort to sort the given {@code array} of Long values in ascending order.
     * It performs counting, cumulative counting, and placement of elements in their sorted positions using auxiliary arrays.
     * The original {@code array} is then updated with the sorted elements.
     * @param       array to be arranged.
     */
    void countingDec(Long[] array) {
        int n = array.length;
        Long k = findMax(array);
        Long[] output = Arrays.copyOf(array, array.length);
        int[] count = new int[(int) (k + 1)];
        countingUpload(count, n, array, 0L);
        countingCycles(count, k);
        for (int i = (n - 1); i >= 0; i--) {
            output[count[Math.toIntExact(array[i])] - 1] = array[i];
            count[Math.toIntExact(array[i])]--;
        }
        for (int i = 0; i < n; i++) {
            array[i] = output[(n - i - 1)];
        }
    }

    /**
     * {@code countingUpload} that takes in an array of integers {@code count}, an integer {@code n}, an array of Longs {@code array},
     * and a long value {@code min}. The purpose of this method is to perform counting based on the elements
     * in the {@code array} and update the {@code count} array accordingly.<br>
     * The method uses a {@code for} loop to iterate over the elements of the array:
     * <ul>
     *     <li>Inside the loop, it subtracts the {@code min} value from the current element in the array: {@code array[i] - min}.</li>
     *     <li>The result of the subtraction is then converted to an integer using {@code Math.toIntExact()}.</li>
     *     <li>The resulting index is used to access the {@code count} array, and the corresponding element is incremented by 1:
     *     {@code count[Math.toIntExact(array[i] - min)]++}.</li>
     * </ul>
     * {@code countingUpload} method performs counting by updating the count array based on the values in the array after
     * subtracting min from each element. The method assumes that the count array has enough space to accommodate 
     * the range of values obtained after subtraction.
     * @param       count an array of integers that will store the count of occurrences.
     * @param       n an integer representing the length of the array that needs to be processed.
     * @param       array an array of Long values that will be used for counting.
     * @param       min a long value that will be subtracted from each element in the array.
     * @see         mz.Counting#countingInc(Long[])
     * @see         mz.Counting#countingDec(Long[])
     */
    void countingUpload(int[] count, int n, Long[] array, long min) {
        for (int i = 0; i < n; i++) {
            count[Math.toIntExact(array[i] - min)]++;
        }
    }

    /**
     * {@code countingCycles} that takes in an array of integers {@code count} and a Long value {@code k}.
     * The purpose of this method is to perform a counting operation on the {@code count} array and update it based on cumulative counts.<br>
     * The method uses a {@code for} loop to iterate from 1 to {@code k} (inclusive):
     * <ul>
     *     <li>Inside the loop, it accesses the {@code count} array at index {@code i} and adds the value at the previous index {@code (i - 1)}: {@code count[i] += count[i - 1]}.</li>
     *     <li>This operation updates the current element in the count array with the cumulative {@code count} up to that index.</li>
     * </ul>
     * {@code countingCycles} method performs a cumulative count operation on the {@code count} array,
     * where each element represents the count of occurrences. The counts are updated by adding the previous count value to the current element,
     * resulting in a cumulative count. The loop iterates from 1 to {@code k} and updates the array accordingly.
     * @param       count an array of integers that will store the count of occurrences.
     * @param       k a Long value representing the maximum value to iterate up to.
     * @see         mz.Counting#countingInc(Long[])
     * @see         mz.Counting#countingDec(Long[])
     */
    void countingCycles(int[] count, Long k) {
        for (int i = 1; i <= k; i++) {
            count[i] += count[(i - 1)];
        }
    }
}