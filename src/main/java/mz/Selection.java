package mz;

/**
 * Selection sort is a simple and efficient sorting algorithm that works by repeatedly selecting the smallest (or largest)
 * element from the unordered part of the list and moving it to the ordered part of the list. The algorithm repeatedly
 * selects the smallest (or largest) element from the unordered part of the list and swaps it with the first element in
 * the unordered part. This process is repeated for the remaining unordered part of the list until the entire list is sorted.
 * @since 1.0
 * @author <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class Selection
extends SortComparable
implements SortSwap<Comparable> {

    /**
     * <b>Selection Sort:</b><br>
     * Selection sort is a simple and efficient sorting algorithm that works by repeatedly selecting the smallest (or largest)
     * element from the unordered part of the list and moving it to the ordered part of the list. The algorithm repeatedly
     * selects the smallest (or largest) element from the unordered part of the list and swaps it with the first element in
     * the unordered part. This process is repeated for the remaining unordered part of the list until the entire list is sorted.<br><br>
     * <b>Example:</b><br>
     * <em>n</em> - array length<br>
     * <em>i</em> - is the element that is the first element of the unordered part<br>
     * <em>j</em> - is an element that is one of the selected elements of the unordered array part.
     * <dl>
     *     <dt><em>i</em>, <em>j</em>, comparing elements:<br></dt>
     *     <dd>- <em>i</em> is smaller than <em>j</em> elements in the unordered part of the array, then <em>i</em> remains in its existing place and moves to the ordered part.</dd>
     *     <dd>- <em>i</em> is greater than one of the next <em>j</em> elements in the unordered part of the array, then <em>i</em> and <em>j</em> are exchanged and the first unordered element is moved to the ordered part.</dd>
     * </dl>
     * <dl>
     *     <dt>Walks through the array based on the number of <em>n</em> elements:</dt>
     *     <dd>- When it goes through the elements of the array, it replaces the desired elements by then and is done.</dd>
     * </dl>
     * <b>Property:</b><br>
     * Time Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space: <em>O(1)</em>
     */
    public Selection() {}

    /**
     * {@inheritDoc}
     * @param array to be arranged.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void sortArrayInc(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < (n - 1); i++) {
            int index = i;
            for (int j = (i + 1); j < n; j++) {
                if (array[j].compareTo(array[index]) < 0) {
                    index = j;
                }
            }
            swap(array, index, i);
        }
    }

    /**
     * {@inheritDoc}
     * @param array to be arranged.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void sortArrayDec(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < (n - 1); i++) {
            int index = i;
            for (int j = (i + 1); j < n; j++) {
                if (array[j].compareTo(array[index]) > 0) {
                    index = j;
                }
            }
            swap(array, index, i);
        }
    }
}
