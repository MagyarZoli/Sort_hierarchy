package mz;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order.
 * This algorithm is not suitable for large data sets as its average and worst-case time complexity is quite high.
 * @since 1.0
 * @author <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class Bubble
extends SortComparable
implements SortSwap {

    /**
     * <b>Bubble Sort:</b><br>
     * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order.
     * This algorithm is not suitable for large data sets as its average and worst-case time complexity is quite high.<br><br>
     * <b>Example:</b><br>
     * <em>n</em> - array length<br>
     * <em>i</em> - element selected from array<br>
     * <em>j</em> - element <em>i</em>, its immediate next element.
     * <dl>
     *     <dt><em>i</em>, <em>j</em>, comparing elements:<br></dt>
     *     <dd>- <em>i</em> is greater than <em>j</em>, then it swaps the two elements.</dd>
     *     <dd>- <em>i</em> is less than <em>j</em>, then no exchange takes place.</dd>
     * </dl>
     * <dl>
     *     <dt>Walks through the array based on the number of <em>n</em> elements:</dt>
     *     <dd>- If there are two elements that you swapped, then the master examines the elements again.</dd>
     *     <dd>- If no elements to be exchanged were found in the array, the row arrangement is complete.</dd>
     * </dl>
     * <b>Property:</b><br>
     * Time Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space: <em>O(1)</em>
     */
    public Bubble(){}

    /**
     * {@inheritDoc}<br>
     * @param array to be arranged.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void sortArrayInc(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[(j - 1)].compareTo(array[j]) > 0) {
                    swap(array, (j - 1), j);
                }
            }
        }
    }

    /**
     * {@inheritDoc}<br>
     * @param array to be arranged.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void sortArrayDec(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[(j - 1)].compareTo(array[j]) < 0) {
                    swap(array, (j - 1), j);
                }
            }
        }
    }
}
