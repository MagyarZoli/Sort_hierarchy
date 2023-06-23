package mz;

/**
 * Gnome Sort, also known as Stupid Sort, is a simple sorting algorithm that works
 * by repeatedly comparing adjacent elements and swapping them if they are in the wrong order.
 * It gets its name from the way it "stumbles" through the list, similar to a gnome moving around.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Gnome
extends Bubble {

    /**
     * <b>Gnome Sort:</b><br>
     * Also known as Stupid Sort, is a simple sorting algorithm that works
     * by repeatedly comparing adjacent elements and swapping them if they are in the wrong order.
     * It gets its name from the way it "stumbles" through the list, similar to a gnome moving around.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Set the current position {@code (pos)} to 0.</li>
     *     <li>While {@code pos} is less than the length of the array:</li>
     *     <li>If {@code pos} is 0 or the current element is in the correct order with the previous element,
     *     move to the next position by incrementing {@code pos}.</li>
     *     <li>If the current element is out of order with the previous element,
     *     swap them and move one position back by decrementing {@code pos}.</li>
     *     <li>Repeat step 3 until {@code pos} reaches the end of the array.</li>
     *     <li>The array is now sorted.</li>
     * </ol>
     * <b>Note:</b><br>
     * Gnome Sort iteratively moves through the array, comparing adjacent elements and swapping them if necessary.
     * If a swap occurs, it moves one position back to recheck the element with the previous one.
     * This process continues until the entire array is sorted.<br><br>
     * Gnome Sort has a time complexity of <em>O(n^2)</em> in the average and worst cases, where <em>n</em> is the number of elements in the array.
     * It is not considered an efficient sorting algorithm for large datasets due to its quadratic time complexity.
     * However, it is relatively easy to understand and implement.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n)</em><br>
     * Average Case Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>No</b>
     * @see         mz.intro.introDPQ.IntroDPQGnome#IntroDPQGnome() IntroDPQGnome
     * @see         mz.intro.IntroGnome#IntroGnome() IntroGnome
     */
    public Gnome() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        gnomeInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        gnomeDec(array);
    }

    /**
     * {@code gnomeInc} that implements the Gnome Sort algorithm to sort an array of Comparable objects in ascending order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Set the current position {@code (pos)} to 0.</li>
     *     <li>While {@code pos} is less than the length of the array:</li>
     *     <li>If {@code pos} is 0 or the current element is in the correct order with the previous element,
     *     move to the next position by incrementing {@code pos}.</li>
     *     <li>If the current element is out of order with the previous element,
     *     swap them and move one position back by decrementing {@code pos}.</li>
     *     <li>Repeat step 3 until {@code pos} reaches the end of the array.</li>
     * </ul>
     * {@code gnomeInc} method implements the Gnome Sort algorithm to sort the given
     * {@code array} of Comparable objects in ascending order.
     * @param       array to be arranged.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void gnomeInc(Comparable[] array) {
        int n = array.length, pos = 0;
        while (pos < n) {
            if (pos == 0 || array[pos].compareTo(array[(pos - 1)]) >= 0) {
                pos++;
            } else {
                swap(array, pos, (pos - 1));
                pos--;
            }
        }
    }

    /**
     * {@code gnomeDec} that implements the Gnome Sort algorithm to sort an array of Comparable objects in descending order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Set the current position {@code (pos)} to 0.</li>
     *     <li>While {@code pos} is less than the length of the array:</li>
     *     <li>If {@code pos} is 0 or the current element is in the correct order with the previous element,
     *     move to the next position by incrementing {@code pos}.</li>
     *     <li>If the current element is out of order with the previous element,
     *     swap them and move one position back by decrementing {@code pos}.</li>
     *     <li>Repeat step 3 until {@code pos} reaches the end of the array.</li>
     * </ul>
     * {@code gnomeDec} method implements the Gnome Sort algorithm to sort the given
     * {@code array} of Comparable objects in descending order.
     * @param       array to be arranged.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void gnomeDec(Comparable[] array) {
        int n = array.length, pos = 0;
        while (pos < n) {
            if (pos == 0 || array[pos].compareTo(array[(pos - 1)]) <= 0) {
                pos++;
            } else {
                swap(array, pos, (pos - 1));
                pos--;
            }
        }
    }

    /**
     * {@code gnomeInc} that implements the Gnome Sort algorithm to sort an array of Comparable objects in ascending order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Set the current position {@code (pos)} to 0.</li>
     *     <li>While {@code pos} is less than the length of the array:</li>
     *     <li>If {@code pos} is 0 or the current element is in the correct order with the previous element,
     *     move to the next position by incrementing {@code pos}.</li>
     *     <li>If the current element is out of order with the previous element,
     *     swap them and move one position back by decrementing {@code pos}.</li>
     *     <li>Repeat step 3 until {@code pos} reaches the end of the array.</li>
     * </ul>
     * {@code gnomeInc} method implements the Gnome Sort algorithm to sort the given
     * {@code array} of Comparable objects in ascending order.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void gnomeInc(Comparable[] array, int left, int right) {
        int pos = left;
        while (pos < right) {
            if (pos == 0 || array[pos].compareTo(array[(pos - 1)]) >= 0) {
                pos++;
            } else {
                swap(array, pos, (pos - 1));
                pos--;
            }
        }
    }

    /**
     * {@code gnomeDec} that implements the Gnome Sort algorithm to sort an array of Comparable objects in descending order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Set the current position {@code (pos)} to 0.</li>
     *     <li>While {@code pos} is less than the length of the array:</li>
     *     <li>If {@code pos} is 0 or the current element is in the correct order with the previous element,
     *     move to the next position by incrementing {@code pos}.</li>
     *     <li>If the current element is out of order with the previous element,
     *     swap them and move one position back by decrementing {@code pos}.</li>
     *     <li>Repeat step 3 until {@code pos} reaches the end of the array.</li>
     * </ul>
     * {@code gnomeDec} method implements the Gnome Sort algorithm to sort the given
     * {@code array} of Comparable objects in descending order.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void gnomeDec(Comparable[] array, int left, int right) {
        int pos = left;
        while (pos < right) {
            if (pos == 0 || array[pos].compareTo(array[(pos - 1)]) <= 0) {
                pos++;
            } else {
                swap(array, pos, (pos - 1));
                pos--;
            }
        }
    }
}