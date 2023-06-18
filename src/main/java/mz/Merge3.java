package mz;

/**
 * Merge3 Sort the sorting process is divided into three parts and performed incrementally.
 * The idea behind this approach is to split the input array into three roughly equal parts and recursively sort each part separately.
 * Then, the sorted parts are merged together to obtain the final sorted array.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Merge3
extends Merge {

    /**
     * <b>Merge3 Sort:</b><br>
     * The sorting process is divided into three parts and performed incrementally.
     * The idea behind this approach is to split the input array into three roughly equal parts and recursively sort each part separately.
     * Then, the sorted parts are merged together to obtain the final sorted array.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Divide the input range into three parts by calculating two midpoints.
     *     These midpoints split the range into three roughly equal parts.</li>
     *     <li>Recursively sort each part using.
     *     This method is called four times to sort the left, middle, and right parts of the range, as well as to merge the sorted parts together.</li>
     *     <li>The performs the actual sorting and merging operations.
     *     completes, the sorted elements are stored in a temporary buffer array.
     *     Finally, the sorted elements are copied back from the buffer array to the original array.</li>
     * </ol>
     * <b>Note:</b><br>
     * Merge3 Sort customized or adapted version of merge sort with sorting and merging steps.
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>Yes</b>
     * @see         mz.intro.introDPQ.IntroDPQMerge3#IntroDPQMerge3() IntroDPQMerge3
     * @see         mz.intro.IntroMerge3#IntroMerge3() IntroMerge3
     */
    public Merge3() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        merge3Inc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        merge3Dec(array);
    }

    /**
     * {@code merge3Inc} the method, a new temporary array called {@code buffer} is created with the same length as the input array.
     * The {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy}
     * method is used to copy the elements from the input array into the buffer array.
     * <ul>
     *     <li>Is called with the {@code buffer} array as the temporary storage.
     *     This method will recursively sort the specified range (<i>0</i> to {@code array.length}) using the {@code buffer} array.</li>
     *     <li>After the {@code mergeInc} method completes, the sorted elements are stored in the buffer array.
     *     Finally, the sorted elements are copied back from the buffer array to the original array using another {@code System.arraycopy} call.</li>
     * </ul>
     * {@code merge3Inc} method serves as a wrapper for the {@code mergeInc} method,
     * providing the necessary setup and cleanup steps for the incremental merge sort algorithm.
     * @param       array The array to be sorted.
     * @see         mz.Merge3#mergeInc(Comparable[], int, int, Comparable[])
     */
    protected void merge3Inc(Comparable[] array) {
        Comparable[] buffer = new Comparable[array.length];
        System.arraycopy(array, 0, buffer, 0, buffer.length);
        mergeInc(buffer, 0, array.length, array);
        System.arraycopy(buffer, 0, array, 0, buffer.length);
    }

    /**
     * {@code merge3Dec} the method, a new temporary array called {@code buffer} is created with the same length as the input array.
     * The {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy}
     * method is used to copy the elements from the input array into the buffer array.
     * <ul>
     *     <li>Is called with the {@code buffer} array as the temporary storage.
     *     This method will recursively sort the specified range (<i>0</i> to {@code array.length}) using the {@code buffer} array.</li>
     *     <li>After the {@code mergeDec} method completes, the sorted elements are stored in the buffer array.
     *     Finally, the sorted elements are copied back from the buffer array to the original array using another {@code System.arraycopy} call.</li>
     * </ul>
     * {@code merge3Dec} method serves as a wrapper for the {@code mergeDec} method,
     * providing the necessary setup and cleanup steps for the decremental merge sort algorithm.
     * @param       array The array to be sorted.
     * @see         mz.Merge3#mergeDec(Comparable[], int, int, Comparable[])
     */
    protected void merge3Dec(Comparable[] array) {
        Comparable[] buffer = new Comparable[array.length];
        System.arraycopy(array, 0, buffer, 0, buffer.length);
        mergeDec(buffer, 0, array.length, array);
        System.arraycopy(buffer, 0, array, 0, buffer.length);
    }

    /**
     * {@code merge3Inc} the method, a new temporary array called {@code buffer} is created with the same length as the input array.
     * The {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy}
     * method is used to copy the elements from the input array into the buffer array.
     * <ul>
     *     <li>Is called with the {@code buffer} array as the temporary storage.
     *     This method will recursively sort the specified range ({@code left} to {@code right}) using the {@code buffer} array.</li>
     *     <li>After the {@code mergeInc} method completes, the sorted elements are stored in the buffer array.
     *     Finally, the sorted elements are copied back from the buffer array to the original array using another {@code System.arraycopy} call.</li>
     * </ul>
     * {@code merge3Inc} method serves as a wrapper for the {@code mergeInc} method,
     * providing the necessary setup and cleanup steps for the incremental merge sort algorithm.
     * @param       array The array to be sorted.
     * @param       left indices representing the range of elements to be sorted.
     * @param       right indices representing the range of elements to be sorted.
     * @see         mz.Merge3#mergeInc(Comparable[], int, int, Comparable[])
     */
    protected void merge3Inc(Comparable[] array, int left, int right) {
        Comparable[] buffer = new Comparable[array.length];
        System.arraycopy(array, 0, buffer, 0, buffer.length);
        mergeInc(buffer, left, right, array);
        System.arraycopy(buffer, 0, array, 0, buffer.length);
    }

    /**
     * {@code merge3Dec} the method, a new temporary array called {@code buffer} is created with the same length as the input array.
     * The {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy}
     * method is used to copy the elements from the input array into the buffer array.
     * <ul>
     *     <li>Is called with the {@code buffer} array as the temporary storage.
     *     This method will recursively sort the specified range ({@code left} to {@code right}) using the {@code buffer} array.</li>
     *     <li>After the {@code mergeDec} method completes, the sorted elements are stored in the buffer array.
     *     Finally, the sorted elements are copied back from the buffer array to the original array using another {@code System.arraycopy} call.</li>
     * </ul>
     * {@code merge3Dec} method serves as a wrapper for the {@code mergeDec} method,
     * providing the necessary setup and cleanup steps for the decremental merge sort algorithm.
     * @param       array The array to be sorted.
     * @param       left indices representing the range of elements to be sorted.
     * @param       right indices representing the range of elements to be sorted.
     * @see         mz.Merge3#mergeDec(Comparable[], int, int, Comparable[])
     */
    protected void merge3Dec(Comparable[] array, int left, int right) {
        Comparable[] buffer = new Comparable[array.length];
        System.arraycopy(array, 0, buffer, 0, buffer.length);
        mergeDec(buffer, left, right, array);
        System.arraycopy(buffer, 0, array, 0, buffer.length);
    }

    /**
     * {@code mergeInc} method for performing an iterative bottom-up merge sort on an array.
     * It divides the array into subarrays of increasing sizesand merges them together until the entire array is sorted.
     * <ul>
     *     <li>first conditional statement {@code (right - left) < 2} checks if the current range has less than two elements.
     *     If true, it means the range is already sorted, so the method returns without performing any further operations.</li>
     *     <li>Next, the method calculates two midpoints: {@code mid1} and {@code mid2}.
     *     These midpoints divide the current range into three roughly equal parts.</li>
     *     <li>It recursively sorts the {@code left / mid / right} part of the range from
     *     {@code left to mid1 /mid1 to mid2 / mid2 to right} using the buffer array as the temporary storage.</li>
     *     <li>Call method {@code mergeInc}. mergeInc method for merging three sorted subarrays into a single array.
     *     It takes the indices of the subarray boundaries and uses four pointers left, mid1, mid2, right,
     *     to iterate through the subarrays and merge them into a buffer array.</li>
     * </ul>
     * {@code mergeInc} The recursive calls ensure that the algorithm recursively divides the input array into smaller parts until each part has less than two elements,
     * and then merges the sorted parts together to obtain the final sorted array.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @param       buffer An auxiliary array used for merging.
     * @see         mz.MergeInterface#mergeInc(Comparable[], int, int, int, int, Comparable[])
     */
    @Override
    public void mergeInc(Comparable[] array, int left, int right, Comparable[] buffer){
        if ((right - left) < 2) {
            return;
        }
        int mid1 = (left + ((right - left) / 3)), mid2 = (left + (2 * ((right - left) / 3)) + 1);
        mergeInc(buffer, left, mid1, array);
        mergeInc(buffer, mid1, mid2, array);
        mergeInc(buffer, mid2, right, array);
        mergeInc(buffer, left, mid1, mid2, right, array);
    }

    /**
     * {@code mergeDec} method for performing an iterative bottom-up merge sort on an array.
     * It divides the array into subarrays of decreasing sizesand merges them together until the entire array is sorted.
     * <ul>
     *     <li>first conditional statement {@code (right - left) < 2} checks if the current range has less than two elements.
     *     If true, it means the range is already sorted, so the method returns without performing any further operations.</li>
     *     <li>Next, the method calculates two midpoints: {@code mid1} and {@code mid2}.
     *     These midpoints divide the current range into three roughly equal parts.</li>
     *     <li>It recursively sorts the {@code left / mid / right} part of the range from
     *     {@code left to mid1 /mid1 to mid2 / mid2 to right} using the buffer array as the temporary storage.</li>
     *     <li>Call method {@code mergeInc}. mergeInc method for merging three sorted subarrays into a single array.
     *     It takes the indices of the subarray boundaries and uses four pointers left, mid1, mid2, right,
     *     to iterate through the subarrays and merge them into a buffer array.</li>
     * </ul>
     * {@code mergeDec} The recursive calls ensure that the algorithm recursively divides the input array into smaller parts until each part has less than two elements,
     * and then merges the sorted parts together to obtain the final sorted array.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @param       buffer An auxiliary array used for merging.
     * @see         mz.MergeInterface#mergeDec(Comparable[], int, int, int, int, Comparable[])
     */
    @Override
    public void mergeDec(Comparable[] array, int left, int right, Comparable[] buffer){
        if ((right - left) < 2) {
            return;
        }
        int mid1 = (left + ((right - left) / 3)), mid2 = (left + (2 * ((right - left) / 3)) + 1);
        mergeDec(buffer, left, mid1, array);
        mergeDec(buffer, mid1, mid2, array);
        mergeDec(buffer, mid2, right, array);
        mergeDec(buffer, left, mid1, mid2, right, array);
    }
}