package mz;

/**
 * The inheritors of this interface arrange any data type that is T.
 * @param <T> when entering it, you can set which class type the interface is used as.
 * @since 1.0
 * @author <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 * @see mz.Selection
 * @see mz.Bubble
 */
public interface SortSwap<T>
extends Sort<T> {

    /**
     * Swaps two elements in the array.
     * When implemented in other classes, they do not have to create a predefined method, overwriting is possible.
     * @param array in which the two selected elements are swapped.
     * @param a element whose value will be changed to the value of element b.
     * @param b element whose value will be changed to the value of element a.
     */
    default void swap(T[] array, int a, int b) {
        T select = array[a];
        array[a] = array[b];
        array[b] = select;
    }
}
