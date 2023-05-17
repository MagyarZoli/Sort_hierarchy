package mz;

/**
 * Shell sort is mainly a variation of Insertion Sort. In insertion sort, we move elements only one position ahead.
 * When an element has to be moved far ahead, many movements are involved. The idea of ShellSort is to allow the exchange of far items.
 * In Shell sort, we make the array <em>h</em>-sorted for a large value of <em>h</em>. We keep reducing the value of <em>h</em> until it becomes 1.
 * An array is said to be <em>h</em>-sorted if all sublists of every <em>h</em>’th element are sorted.
 * @since 1.0
 * @author <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class Shell
extends Insertion {

    /**
     * <b>Shell Sort:</b><br>
     * Shell sort is mainly a variation of Insertion Sort. In insertion sort, we move elements only one position ahead.
     * When an element has to be moved far ahead, many movements are involved. The idea of ShellSort is to allow the exchange of far items.
     * In Shell sort, we make the array <em>h</em>-sorted for a large value of <em>h</em>. We keep reducing the value of <em>h</em> until it becomes 1.
     * An array is said to be <em>h</em>-sorted if all sublists of every <em>h</em>’th element are sorted.<br><br>
     * <b>Example:</b><br>
     * <em>n</em> - array length<br>
     * <em>i</em> - the element that is located in the sorted part compares it with the first element of the not yet sorted elements with <em>j</em>.<br>
     * <em>j</em> - is the element that is the first element of the unordered elements.<br>
     * <em>h</em> - the element on the basis of which it divides the array and the Insertion sort examines elements <em>i</em> and <em>j</em> only up to that element.
     * <dl>
     *     <dt><em>i</em>, <em>j</em>, comparing elements of a to element <em>h</em>:<br></dt>
     *     <dd>- <em>h</em> a limiting element, specifying how long the elements must be examined.</dd>
     *     <dd>- <em>i</em> the elements that are in the ordered part</dd>
     *     <dd>- <em>j</em> is the element that is the first element of the unordered part, compare it with the ordered elements <em>i</em></dd>
     * </dl>
     * <dl>
     *     <dt>Walks through the array based on the number of <em>n</em> elements:</dt>
     *     <dd>- Walks through the array based on the number of <em>h</em> elements:</dd>
     *     <dd>- if <em>j</em> is smaller than the selected <em>i</em>, it is checked by selecting the next element <em>i</em>, but only up to the specified element <em>h</em>.</dd>
     *     <dd>- if the element <em>j</em> is greater than or equal to <em>i</em>, then the value of <em>i</em> will be <em>j</em> and <em>j</em> will be the selected element with which it will be compared with the first element of the unordered mind, but only up to the specified element <em>h</em>.</dd>
     *     <dd>- if the row arrangement between the initial value and the <em>h</em> value is completed, then an intermediate division is examined.</dd>
     *     <dd>- When all divisions are done, the line arrangement is done.</dd>
     * </dl>
     * <b>Property:</b><br>
     * Time Complexity: <em>O(n^2)</em><br>
     * Worst Case Complexity: <em>O(n^2)</em><br>
     * Best Case Complexity: <em>Ω(n log(n))</em><br>
     * Average Case Complexity: <em>θ(n log(n)2)</em><br>
     * Auxiliary Space: <em>O(1)</em>
     */
    public Shell(){}

    /**
     * {@inheritDoc}
     * @param array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        shellInc(array);
    }

    /**
     * {@inheritDoc}
     * @param array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        shellDec(array);
    }

    /**
     * Calling a method inherited from the Insertion super class, putting it in a shell for loop.
     * @param array to be arranged.
     */
    void shellInc(Comparable[] array) {
        for (int h = (array.length / 2); h > 0; h /= 2) {
            insertionInc(array, h);
        }
    }

    /**
     * Calling a method inherited from the Insertion super class, putting it in a shell for loop.
     * @param array to be arranged.
     */
    void shellDec(Comparable[] array) {
        for (int h = (array.length / 2); h > 0; h /= 2) {
            insertionDec(array, h);
        }
    }
}