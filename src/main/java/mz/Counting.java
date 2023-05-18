package mz;

import java.util.Arrays;

/**
 * Counting sort is a sorting technique based on keys between a specific range. It works by counting the number of objects
 * having distinct key values (a kind of hashing). Then do some arithmetic operations to calculate the position of each object in the output sequence.
 * @since 1.0
 * @author <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class Counting
extends SortLong {

    /**
     * <b>Counting Sort:</b><br> You can only sort with whole numbers!
     * Counting sort is a sorting technique based on keys between a specific range. It works by counting the number of objects
     * having distinct key values (a kind of hashing). Then do some arithmetic operations to calculate the position of each object in the output sequence.
     * <b>Example:</b><br>
     * <em>n</em> - array length<br>
     * <em>k</em> - count length<br>
     * <em>i</em> - is the selected element which, by examining it, adds its own value by 1 to the count array.<br>
     * <em>j</em> - elements of count.
     * <dl>
     *     <dt><em>i</em>, <em>j</em> comparing elements:<br></dt>
     *     <dd>- <em>i</em> element in the array.</dd>
     *     <dd>- <em>j</em> increase element if it matches <em>i</em> value.</dd>
     * </dl>
     * <dl>
     *     <dt>Walks through the array based on the number of <em>n</em> elements:</dt>
     *     <dd>- Walks through the count based on the number of <em>k</em> elements:</dd>
     *     <dd>- If the value of element <em>i</em> matches the index of one of the elements <em>j</em> of the count, then the value of element <em>j</em> is increased by 1.</dd>
     *     <dd>- if you have gone through the array, subtract the minimum value from the elements of the count and return the sorted array.</dd>
     * </dl>
     * <b>Property:</b><br>
     * Time Complexity: <em>O(n+k)</em><br>
     * Auxiliary Space: <em>O(n)</em>
     */
    public Counting(){}

    /**
     * {@inheritDoc}
     * @param array to be arranged.
     */
    @Override
    public void sortArrayInc(Long[] array) {
        int n = array.length;
        Long max = findMax();
        Long[] output = Arrays.copyOf(array, array.length);
        int[] count = new int[(int) (max + 1)];
        countingUpload(count, n, array, 0L);
        countingCycles(count, max);
        for (int i = n - 1; i >= 0; i--) {
            output[count[Math.toIntExact(array[i])] - 1] = array[i];
            count[Math.toIntExact(array[i])]--;
        }
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    /**
     * {@inheritDoc}
     * @param array to be arranged.
     */
    @Override
    public void sortArrayDec(Long[] array) {
        int n = array.length;
        Long max = findMax();
        int[] count = new int[(int) (max + 1)];
        Long[] output = Arrays.copyOf(array, array.length);
        countingUpload(count, n, array, 0L);
        countingCycles(count, max);
        for (int i = n - 1; i >= 0; i--) {
            output[count[Math.toIntExact(array[i])] - 1] = array[i];
            count[Math.toIntExact(array[i])]--;
        }
        for (int i = 0; i < n; i++) {
            array[i] = output[(n - i - 1)];
        }
    }

    /**
     * The purpose of this method is to perform counting based on the elements in the array and update the count array accordingly.
     * Inside the loop, it subtracts the min value from the current element in the array: {@code array[i] - min}.
     * The result of the subtraction is then converted to an integer using {@code Math.toIntExact()}.
     * The resulting index is used to access the count array, and the corresponding element is incremented by 1:
     * {@code count[Math.toIntExact(array[i] - min)]++}.
     * @param count an array of integers that will store the count of occurrences.
     * @param n an integer representing the length of the array that needs to be processed.
     * @param array an array of Long values that will be used for counting.
     * @param min a long value that will be subtracted from each element in the array.
     */
    void countingUpload(int[] count, int n, Long[] array, long min) {
        for (int i = 0; i < n; i++) {
            count[Math.toIntExact(array[i] - min)]++;
        }
    }

    /**
     * Method performs a cumulative count operation on the count array, where each element represents the count of occurrences.
     * The counts are updated by adding the previous count value to the current element, resulting in a cumulative count.
     * The loop iterates from 1 to max and updates the array accordingly.
     * @param count an array of integers that will store the count of occurrences.
     * @param max a Long value representing the maximum value to iterate up to.
     */
    void countingCycles(int[] count, Long max) {
        for (int i = 1; i <= max; i++) {
            count[i] += count[(i - 1)];
        }
    }
}