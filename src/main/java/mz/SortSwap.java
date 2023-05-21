package mz;

/**
 * The inheritors of this interface arrange any data type that is T.
 * @param       <T> when entering it, you can set which class type the interface is used as.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 * @see         mz.Quick
 * @see         mz.Quick3
 * @see         mz.Selection
 * @see         mz.Bubble
 */
public interface SortSwap<T>
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
     * @see         mz.Quick#partitionInc(Comparable[], int, int)
     * @see         mz.Quick#partitionDec(Comparable[], int, int)
     * @see         mz.Quick3#partition3Inc(Comparable[], int, int)
     * @see         mz.Quick3#partition3Dec(Comparable[], int, int)
     * @see         mz.Selection#selectionInc(Comparable[])
     * @see         mz.Selection#selectionDec(Comparable[])
     * @see         mz.Bubble#bubbleInc(Comparable[])
     * @see         mz.Bubble#bubbleDec(Comparable[])
     */
    default void swap(T[] array, int a, int b) {
        T select = array[a];
        array[a] = array[b];
        array[b] = select;
    }
}