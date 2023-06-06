package mz;

/**
 * The inheritors of this interface arrange any data type that is T.
 * @param       <T> when entering it, you can set which class type the interface is used as.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public interface SortSwap<T extends Comparable>
extends Sort<T> {

    /**
     * Swaps two elements in the array.
     * When implemented in other classes, they do not have to create a predefined method, overwriting is possible.
     * <pre>
     * default void swap(T[] array, int a, int b) {
     *     T select = array[a];
     *     array[a] = array[b];
     *     array[b] = select;
     * }
     * </pre>
     * @param       array in which the two selected elements are swapped.
     * @param       a element whose value will be changed to the value of element b.
     * @param       b element whose value will be changed to the value of element a.
     */
    default void swap(T[] array, int a, int b) {
        T select = array[a];
        array[a] = array[b];
        array[b] = select;
    }

    /**
     * {@code flip}, which takes an array {@code array} and one indices {@code to} as input.
     * It performs an in-place flipping of elements within the specified range of the array.
     * <ul>
     *     <li>The method enters a {@code while} loop, which continues as long as the {@code from} index is <i>0</i>, is less than the {@code to} index.</li>
     *     <li>Inside the loop, the {@link mz.SortSwap#swap(Comparable[], int, int) swap} method
     *     is called to exchange the elements at indices {@code from} and {@code to} in the {@code array}.
     *     The {@code swap} method is assumed to be defined elsewhere, and it swaps the elements in-place.</li>
     *     <li>After swapping the elements, the {@code from} index is incremented by one {@code from++},
     *     and the {@code to} index is decremented by one {@code to--}.</li>
     *     <li>The loop continues until the {@code from} index is no longer less than
     *     the {@code to} index, at which point the flipping is complete.</li>
     * </ul>
     * {@code flip} method reverses the order of elements in the specified range of the array.
     * It does this by swapping elements from the beginning and end of the range, gradually moving towards the middle until the entire range is flipped.
     * @param       array in which the two selected index are flip.
     * @param       to is the index by which to finish the analyzed.
     */
    default void flip(T[] array, int to) {
        int from = 0;
        while (from < to) {
            swap(array, from++, to--);
        }
    }

    /**
     * {@code flip}, which takes an array {@code array} and two indices {@code from} and {@code to} as input.
     * It performs an in-place flipping of elements within the specified range of the array.
     * <ul>
     *     <li>The method enters a {@code while} loop, which continues as long as the {@code from} index is less than the {@code to} index.</li>
     *     <li>Inside the loop, the {@link mz.SortSwap#swap(Comparable[], int, int) swap} method
     *     is called to exchange the elements at indices {@code from} and {@code to} in the {@code array}.
     *     The {@code swap} method is assumed to be defined elsewhere, and it swaps the elements in-place.</li>
     *     <li>After swapping the elements, the {@code from} index is incremented by one {@code from++},
     *     and the {@code to} index is decremented by one {@code to--}.</li>
     *     <li>The loop continues until the {@code from} index is no longer less than
     *     the {@code to} index, at which point the flipping is complete.</li>
     * </ul>
     * {@code flip} method reverses the order of elements in the specified range of the array.
     * It does this by swapping elements from the beginning and end of the range, gradually moving towards the middle until the entire range is flipped.
     * @param       array in which the two selected index are flip.
     * @param       from is the index from which the analyzed should start.
     * @param       to is the index by which to finish the analyzed.
     */
    default void flip(T[] array, int from, int to) {
        while (from < to) {
            swap(array, from++, to--);
        }
    }
}