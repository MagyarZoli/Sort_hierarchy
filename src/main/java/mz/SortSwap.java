package mz;

/**
 * The inheritors of this interface arrange any data type that is Comparable.
 * @since 1.0
 * @author <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public interface SortSwap
extends Sort<Comparable>{

    /**
     * Swaps two elements in the array.
     * When implemented in other classes, they do not have to create a predefined method, overwriting is possible.
     * @param array in which the two selected elements are swapped.
     * @param a element whose value will be changed to the value of element b.
     * @param b element whose value will be changed to the value of element a.
     */
    default void swap(Comparable[] array, int a, int b) {
        Comparable select = array[a];
        array[a] = array[b];
        array[b] = select;
    }
}
