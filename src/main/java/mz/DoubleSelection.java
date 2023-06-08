package mz;

/**
 * Double Selection if an item is not a smallest item, it's possible to check to see if it's the largest item and if it is, move it to the end of the array.
 * This way we can achieve two goals at the same time and perform the job faster.
 * This kind of addition to the burst-selection sort makes it somewhat faster.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class DoubleSelection
extends Selection {

    /**
     * <b>Double Selection Sort:</b><br>
     * If an item is not a smallest item, it's possible to check to see if it's the largest item and if it is, move it to the end of the array.
     * This way we can achieve two goals at the same time and perform the job faster.
     * This kind of addition to the burst-selection sort makes it somewhat faster.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Besides having a {@code minIndex}, create also a {@code maxIndex} index variable initialized to point to the last item in the array.</li>
     *     <li>Besides having a min variable, initialize also a max variable with the item at {@code maxIndex}.</li>
     *     <li>The {@code while} loop can now be performed from {@code maxIndex} to {@code minIndex} or ({@code minIndex} to {@code maxIndex}).</li>
     *     <li>One important thing to take into account is that the inner loop should not go to the next item if
     *     the current item was less than min or greater or equal to max, but it should stay at the same item in its next loop
     *     (that is, it should not increase the loop index variable).</li>
     *     <li>At the end of the outer loop, assign {@code maxIndex} to {@code minIndex}.</li>
     * </ol>
     * <b>Note:</b><br>
     * This addition makes the algorithm a bit more complex because swapping the current item with the item at
     * the current end of the array may actually bring a smallest item at the current place which means
     * we can't move to the next item in the array just yet (if we did, the algorithm would malfunction in some cases).<br><br>
     * Also, if a new minimum item is found (and is swapped to the start of the current array section),
     * the value swapped to the current item place may be a largest item, which also means that
     * we can't move to the next item yet. Otherwise the addition can be done basically by replicating
     * the burst-selection sort code in a way that it makes the reverse job.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n^2)</em><br>
     * Average Case Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>No</b>
     * @see         mz.intro.IntroDoubleSelection#IntroDoubleSelection() IntroDoubleSelection
     */
    public DoubleSelection() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        doubleSelectionInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        doubleSelectionDec(array);
    }

    /**
     * {@code doubleSelectionInc} that implements the Double Selection Sort algorithm to sort an array
     * of Comparable objects in ascending order.
     * <ul>
     *     <li>Besides having a {@code minIndex}, create also a {@code maxIndex} index variable initialized to point to the last item in the array.</li>
     *     <li>Besides having a min variable, initialize also a max variable with the item at {@code maxIndex}.</li>
     *     <li>The {@code while} loop can now be performed from {@code maxIndex} to {@code minIndex}.</li>
     *     <li>One important thing to take into account is that the inner loop should not go to the next item if
     *     the current item was less than min or greater or equal to max, but it should stay at the same item in its next loop
     *     (that is, it should not increase the loop index variable).</li>
     *     <li>At the end of the outer loop, assign {@code maxIndex} to {@code minIndex}.</li>
     * </ul>
     * {@code doubleSelectionInc} method implements the Double Selection Sort algorithm to sort the given
     * {@code array} of Comparable objects in ascending order.
     * @param       array to be arranged.
     * @see         mz.SortFind#findMinimumIndex(Comparable[], int, int)
     * @see         mz.SortFind#findMaximumIndex(Comparable[], int, int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    protected void doubleSelectionInc(Comparable[] array) {
        int n = array.length;
        int left = 0;
        int right = (n - 1);
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;
            for (int j = left; j <= right; j++) {
                minIndex = findMinimumIndex(array, j, minIndex);
                maxIndex = findMaximumIndex(array, j, maxIndex);
            }
            swap(array, minIndex, left);
            if (maxIndex == left) {
                maxIndex = minIndex;
            }
            swap(array, maxIndex, right--);
            left++;
        }
    }

    /**
     * {@code doubleSelectionDec} that implements the Double Selection Sort algorithm to sort an array
     * of Comparable objects in descending order.
     * <ul>
     *     <li>Besides having a {@code minIndex}, create also a {@code maxIndex} index variable initialized to point to the last item in the array.</li>
     *     <li>Besides having a min variable, initialize also a max variable with the item at {@code maxIndex}.</li>
     *     <li>The {@code while} loop can now be performed from {@code minIndex} to {@code maxIndex}.</li>
     *     <li>One important thing to take into account is that the inner loop should not go to the next item if
     *     the current item was less than min or greater or equal to max, but it should stay at the same item in its next loop
     *     (that is, it should not increase the loop index variable).</li>
     *     <li>At the end of the outer loop, assign {@code minIndex} to {@code maxIndex}.</li>
     * </ul>
     * {@code doubleSelectionDec} method implements the Double Selection Sort algorithm to sort the given
     * {@code array} of Comparable objects in descending order.
     * @param       array to be arranged.
     * @see         mz.SortFind#findMinimumIndex(Comparable[], int, int)
     * @see         mz.SortFind#findMaximumIndex(Comparable[], int, int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    protected void doubleSelectionDec(Comparable[] array) {
        int n = array.length;
        int left = 0;
        int right = (n - 1);
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;
            for (int j = left; j <= right; j++) {
                minIndex = findMinimumIndex(array, j, minIndex);
                maxIndex = findMaximumIndex(array, j, maxIndex);
            }
            swap(array, maxIndex, left);
            if (minIndex == left) {
                minIndex = maxIndex;
            }
            swap(array, minIndex, right--);
            left++;
        }
    }

    /**
     * {@code doubleSelectionInc} that implements the Double Selection Sort algorithm to sort an array
     * of Comparable objects in ascending order.
     * <ul>
     *     <li>Besides having a {@code minIndex}, create also a {@code maxIndex} index variable initialized to point to the last item in the array.</li>
     *     <li>Besides having a min variable, initialize also a max variable with the item at {@code maxIndex}.</li>
     *     <li>The {@code while} loop can now be performed from {@code maxIndex} to {@code minIndex}.</li>
     *     <li>One important thing to take into account is that the inner loop should not go to the next item if
     *     the current item was less than min or greater or equal to max, but it should stay at the same item in its next loop
     *     (that is, it should not increase the loop index variable).</li>
     *     <li>At the end of the outer loop, assign {@code maxIndex} to {@code minIndex}.</li>
     * </ul>
     * {@code doubleSelectionInc} method implements the Double Selection Sort algorithm to sort the given
     * {@code array} of Comparable objects in ascending order.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.SortFind#findMinimumIndex(Comparable[], int, int)
     * @see         mz.SortFind#findMaximumIndex(Comparable[], int, int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    protected void doubleSelectionInc(Comparable[] array, int left, int right) {
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;
            for (int j = left; j <= right; j++) {
                minIndex = findMinimumIndex(array, j, minIndex);
                maxIndex = findMaximumIndex(array, j, maxIndex);
            }
            swap(array, minIndex, left);
            if (maxIndex == left) {
                maxIndex = minIndex;
            }
            swap(array, maxIndex, right--);
            left++;
        }
    }

    /**
     * {@code doubleSelectionDec} that implements the Double Selection Sort algorithm to sort an array
     * of Comparable objects in descending order.
     * <ul>
     *     <li>Besides having a {@code minIndex}, create also a {@code maxIndex} index variable initialized to point to the last item in the array.</li>
     *     <li>Besides having a min variable, initialize also a max variable with the item at {@code maxIndex}.</li>
     *     <li>The {@code while} loop can now be performed from {@code minIndex} to {@code maxIndex}.</li>
     *     <li>One important thing to take into account is that the inner loop should not go to the next item if
     *     the current item was less than min or greater or equal to max, but it should stay at the same item in its next loop
     *     (that is, it should not increase the loop index variable).</li>
     *     <li>At the end of the outer loop, assign {@code minIndex} to {@code maxIndex}.</li>
     * </ul>
     * {@code doubleSelectionDec} method implements the Double Selection Sort algorithm to sort the given
     * {@code array} of Comparable objects in descending order.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.SortFind#findMinimumIndex(Comparable[], int, int)
     * @see         mz.SortFind#findMaximumIndex(Comparable[], int, int)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    protected void doubleSelectionDec(Comparable[] array, int left, int right) {
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;
            for (int j = left; j <= right; j++) {
                minIndex = findMinimumIndex(array, j, minIndex);
                maxIndex = findMaximumIndex(array, j, maxIndex);
            }
            swap(array, maxIndex, left);
            if (minIndex == left) {
                minIndex = maxIndex;
            }
            swap(array, minIndex, right--);
            left++;
        }
    }
}