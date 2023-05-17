package mz;

/**
 * Insertion sort is a simple sorting algorithm. The array is virtually split into a sorted and an unsorted part.
 * Values from the unsorted part are picked and placed at the correct position in the sorted part.
 * @since 1.0
 * @author <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 * @see mz.Shell
 */
public class Insertion
extends SortComparable {

    /**
     * <b>Insertion Sort:</b><br>
     * Insertion sort is a simple sorting algorithm. The array is virtually split into a sorted and an unsorted part.
     * Values from the unsorted part are picked and placed at the correct position in the sorted part.<br><br>
     * <b>Example:</b><br>
     * <em>n</em> - array length<br>
     * <em>i</em> - the element that is located in the sorted part compares it with the first element of the not yet sorted elements with <em>j</em>.<br>
     * <em>j</em> - is the element that is the first element of the unordered elements.
     * <dl>
     *     <dt><em>i</em>, <em>j</em>, comparing elements:<br></dt>
     *     <dd>- <em>i</em> the elements that are in the ordered part</dd>
     *     <dd>- <em>j</em> is the element that is the first element of the unordered part, compare it with the ordered elements <em>i</em></dd>
     * </dl>
     * <dl>
     *     <dt>Walks through the array based on the number of <em>n</em> elements:</dt>
     *     <dd>- if <em>j</em> is smaller than the selected <em>i</em>, it is checked by selecting the next element <em>i</em>.</dd>
     *     <dd>- if the element <em>j</em> is greater than or equal to <em>i</em>, then the value of <em>i</em> will be <em>j</em> and <em>j</em> will be the selected element with which it will be compared with the first element of the unordered mind.</dd>
     * </dl>
     * <b>Property:</b><br>
     * Time Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space: <em>O(1)</em>
     * @see mz.Shell#Shell()
     */
    public Insertion(){}

    /**
     * {@inheritDoc}
     * @param array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        insertionInc(array, 1);
    }

    /**
     * {@inheritDoc}
     * @param array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        insertionDec(array, 1);
    }

    /**
     * Checks the selected element to see where it can be inserted in the sorted array.
     * @param array to be arranged.
     * @param index start the examined from the last index of the array.
     * @see mz.Shell#shellInc(Comparable[])
     */
    @SuppressWarnings("unchecked")
    void insertionInc(Comparable[] array, int index) {
        for (int i = index; i < array.length; i++) {
            Comparable select = array[i];
            int j = i;
            while ((j >= index) && (array[(j - index)].compareTo(select) > 0)) {
                array[j] = array[(j - index)];
                j -= index;
            }
            array[j] = select;
        }
    }

    /**
     * Checks the selected element to see where it can be inserted in the sorted array.
     * @param array to be arranged.
     * @param index start the examined from the last index of the array.
     * @see mz.Shell#shellDec(Comparable[])
     */
    @SuppressWarnings("unchecked")
    void insertionDec(Comparable[] array, int index) {
        for (int i = index; i < array.length; i++) {
            Comparable select = array[i];
            int j = i;
            while ((j >= index) && (array[(j - index)].compareTo(select) < 0)) {
                array[j] = array[(j - index)];
                j -= index;
            }
            array[j] = select;
        }
    }
}