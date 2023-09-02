package github.magyarzoli;

import java.util.List;

/**
 * The inheritors of this interface arrange any data type that is T.
 * @param       <T> when entering it, you can set which class type the interface is used as.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public interface SortSwap<T extends Comparable>
        extends Sorter<T> {

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
     * {@code isSwapInc} that checks if a swap operation is necessary between two elements in an array
     * of {@link java.lang.Comparable Comparable} objects in order to maintain the increasing order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, and the indices
     *     {@code i} and {@code j} of the two elements to be compared and potentially swapped.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to unchecked type casting when using the
     *     {@link java.lang.Comparable#compareTo(Object) compareTo} method. This annotation is not directly related to
     *     the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The variable {@code swap} is initially set to {@code false}, indicating that no swap operation has been
     *     performed yet.</li>
     *     <li>The condition {@code if (array[i].compareTo(array[(i + j)]) > 0)} compares the elements at indices
     *     {@code i} and {@code (i + j)} in the array to check if a swap is necessary. If the element at index {@code i}
     *     is greater than the element at index {@code (i + j)}, a swap operation is performed.</li>
     *     <li>Inside the {@code if} block, the swap method is called to {@code swap} the elements at indices {@code i}
     *     and {@code (i + j)} in the array. After the {@code swap}, the swapped variable is set to {@code true}.</li>
     *     <li>Finally, the method returns the value of swapped, indicating whether a swap operation was performed
     *     ({@code true}) or not ({@code false}).</li>
     * </ul>
     * {@code isSwapInc} method can be used as a helper method in sorting algorithms to check if a swap is necessary
     * between two elements in order to maintain the increasing order of the array.
     * @param       array to be arranged.
     * @param       i elements to be compared
     * @param       j elements to be compared
     * @return      the value of swapped.
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    default boolean isSwapInc(T[] array, int i, int j){
        if (array[i].compareTo(array[(i + j)]) > 0) {
            swap(array, i, (i + j));
            return true;
        }
        return false;
    }

    /**
     * {@code isSwapDec} that checks if a swap operation is necessary between two elements in an array
     * of {@link java.lang.Comparable Comparable} objects in order to maintain the decreasing order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array}, and the indices
     *     {@code i} and {@code j} of the two elements to be compared and potentially swapped.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to unchecked type casting when using the
     *     {@link java.lang.Comparable#compareTo(Object) compareTo} method. This annotation is not directly related to
     *     the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The variable {@code swap} is initially set to {@code false}, indicating that no swap operation has been
     *     performed yet.</li>
     *     <li>The condition {@code if (array[i].compareTo(array[(i + j)]) < 0)} compares the elements at indices
     *     {@code i} and {@code (i + j)} in the array to check if a swap is necessary. If the element at index {@code i}
     *     is smaller than the element at index {@code (i + j)}, a swap operation is performed.</li>
     *     <li>Inside the {@code if} block, the swap method is called to {@code swap} the elements at indices {@code i}
     *     and {@code (i + j)} in the array. After the {@code swap}, the swapped variable is set to {@code true}.</li>
     *     <li>Finally, the method returns the value of swapped, indicating whether a swap operation
     *     was performed ({@code true}) or not ({@code false}).</li>
     * </ul>
     * {@code isSwapDec} method can be used as a helper method in sorting algorithms to check if a swap is necessary
     * between two elements in order to maintain the decreasing order of the array.
     * @param       array to be arranged.
     * @param       i elements to be compared
     * @param       j elements to be compared
     * @return      the value of swapped.
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    default boolean isSwapDec(T[] array, int i, int j){
        if (array[i].compareTo(array[(i + j)]) < 0) {
            swap(array, i, (i + j));
            return true;
        }
        return false;
    }

    /**
     * {@code isSwap} that takes an array {@code array}, two indices {@code i} and {@code j}, and a {@code CompareTo<T>}
     * function as parameters. The method attempts to swap the elements at indices i and j in the array based on the
     * result of the comparison performed by the {@code functionalCompareTo} method.
     * <ul>
     *     <li>Calls the {@code functionalCompareTo} method from the {@code CompareTo<T>} function object, passing the
     *     elements at indices {@code i} and {@code (i + j)} of the array as arguments. It compares the two elements and
     *     returns a boolean value indicating whether the elements should be swapped.</li>
     *     <li>{@code if} This checks the result of the comparison.
     *     If it returns true, indicating that the elements should be swapped, the code inside the {@code if} statement
     *     will be executed.</li>
     *     <li>Calls a method swap to exchange the elements at indices {@code i} and {@code (i + j)} in the array.</li>
     *     <li>After the swap is performed, the method returns {@code true} to indicate that the elements were
     *     successfully swapped.</li>
     *     <li> If the comparison result is {@code false}, indicating that the elements should not be swapped, the
     *     method simply returns {@code false}.</li>
     * </ul>
     * {@code T} in {@code CompareTo<T>} represents a generic type, which means it can be replaced with any specific
     * type when invoking the {@code isSwap} method.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    default boolean isSwap(T[] array, int i, int j, SortFunctional<T> function){
        if (function.functionalCompareTo(array[i], array[(i + j)])) {
            swap(array, i, (i + j));
            return true;
        }
        return false;
    }

    /**
     * {@code flip}, which takes an array {@code array} and one indices {@code to} as input. It performs an in-place
     * flipping of elements within the specified range of the array.
     * <ul>
     *     <li>The method enters a {@code while} loop, which continues as long as the {@code from} index is <i>0</i>,
     *     is less than the {@code to} index.</li>
     *     <li>Inside the loop, the swap method is called to exchange the elements at indices {@code from} and
     *     {@code to} in the {@code array}.
     *     The {@code swap} method is assumed to be defined elsewhere, and it swaps the elements in-place.</li>
     *     <li>After swapping the elements, the {@code from} index is incremented by one {@code from++}, and the
     *     {@code to} index is decremented by one {@code to--}.</li>
     *     <li>The loop continues until the {@code from} index is no longer less than the {@code to} index, at which
     *     point the flipping is complete.</li>
     * </ul>
     * {@code flip} method reverses the order of elements in the specified range of the array. It does this by swapping
     * elements from the beginning and end of the range, gradually moving towards the middle until the entire range is
     * flipped.
     * @param       array in which the two selected index are flip.
     * @param       to is the index by which to finish the analyzed.
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    default void flip(T[] array, int to) {
        int from = 0;
        while (from < to) {
            swap(array, from++, to--);
        }
    }

    /**
     * {@code flip}, which takes an array {@code array} and two indices {@code from} and {@code to} as input. It
     * performs an in-place flipping of elements within the specified range of the array.
     * <ul>
     *     <li>The method enters a {@code while} loop, which continues as long as the {@code from} index is less than
     *     the {@code to} index.</li>
     *     <li>Inside the loop, the swap method is called to exchange the elements at indices {@code from} and
     *     {@code to} in the {@code array}.
     *     The {@code swap} method is assumed to be defined elsewhere, and it swaps the elements in-place.</li>
     *     <li>After swapping the elements, the {@code from} index is incremented by one {@code from++},
     *     and the {@code to} index is decremented by one {@code to--}.</li>
     *     <li>The loop continues until the {@code from} index is no longer less than
     *     the {@code to} index, at which point the flipping is complete.</li>
     * </ul>
     * {@code flip} method reverses the order of elements in the specified range of the array.
     * It does this by swapping elements from the beginning and end of the range, gradually moving towards the middle
     * until the entire range is flipped.
     * @param       array in which the two selected index are flip.
     * @param       from is the index from which the analyzed should start.
     * @param       to is the index by which to finish the analyzed.
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    default void flip(T[] array, int from, int to) {
        while (from < to) {
            swap(array, from++, to--);
        }
    }

    /**
     * Swaps two elements in the list.
     * When implemented in other classes, they do not have to create a predefined method, overwriting is possible.
     * <pre>
     * default <L extends T> void swap(List<L> list, int a, int b) {
     *     L select = list.get(a);
     *     list.set(a, list.get(b));
     *     list.set(b, select);
     * }
     * </pre>
     * @param       list in which the two selected elements are swapped.
     * @param       a element whose value will be changed to the value of element b.
     * @param       b element whose value will be changed to the value of element a.
     */
    default <L extends T> void swap(List<L> list, int a, int b) {
        L select = list.get(a);
        list.set(a, list.get(b));
        list.set(b, select);
    }

    /**
     * {@code isSwapInc} that checks if a swap operation is necessary between two elements in a list
     * of {@link java.lang.Comparable Comparable} objects in order to maintain the increasing order.
     * <ul>
     *     <li>The method takes a list of {@code Comparable} objects,
     *     denoted by {@code list}, and the indices {@code i} and {@code j} of
     *     the two elements to be compared and potentially swapped.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to unchecked type casting when using the
     *     {@link java.lang.Comparable#compareTo(Object) compareTo} method. This annotation is not directly related to
     *     the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The variable {@code swap} is initially set to {@code false}, indicating that no swap operation has been
     *     performed yet.</li>
     *     <li>The condition {@code if (list.get(i).compareTo(list.get(i + j)) > 0)} compares the elements at indices
     *     {@code i} and {@code (i + j)} in the array to check if a swap is necessary. If the element at index {@code i}
     *     is greater than the element at index {@code (i + j)}, a swap operation is performed.</li>
     *     <li>Inside the {@code if} block, the swap method is called to {@code swap} the elements at indices {@code i}
     *     and {@code (i + j)} in the list. After the {@code swap}, the swapped variable is set to {@code true}.</li>
     *     <li>Finally, the method returns the value of swapped, indicating whether a swap operation was performed
     *     ({@code true}) or not ({@code false}).</li>
     * </ul>
     * {@code isSwapInc} method can be used as a helper method in sorting algorithms to check if a swap is necessary
     * between two elements in order to maintain the increasing order of the list.
     * @param       list to be arranged.
     * @param       i elements to be compared
     * @param       j elements to be compared
     * @return      the value of swapped.
     * @see         SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    default <L extends T> boolean isSwapInc(List<L> list, int i, int j){
        if (list.get(i).compareTo(list.get(i + j)) > 0) {
            swap(list, i, (i + j));
            return true;
        }
        return false;
    }

    /**
     * {@code isSwapInc} that checks if a swap operation is necessary between two elements in an array
     * of {@link java.lang.Comparable Comparable} objects in order to maintain the decreasing order.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code list}, and the indices
     *     {@code i} and {@code j} of the two elements to be compared and potentially swapped.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to unchecked type casting when using the
     *     {@link java.lang.Comparable#compareTo(Object) compareTo} method. This annotation is not directly related to
     *     the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The variable {@code swap} is initially set to {@code false}, indicating that no swap operation has been
     *     performed yet.</li>
     *     <li>The condition {@code if (list.get(i).compareTo(list.get(i + j)) < 0)} compares the elements at indices
     *     {@code i} and {@code (i + j)} in the array to check if a swap is necessary. If the element at index {@code i}
     *     is greater than the element at index {@code (i + j)}, a swap operation is performed.</li>
     *     <li>Inside the {@code if} block, the swap method is called to {@code swap} the elements at indices {@code i}
     *     and {@code (i + j)} in the list. After the {@code swap}, the swapped variable is set to {@code true}.</li>
     *     <li>Finally, the method returns the value of swapped, indicating whether a swap operation was performed
     *     ({@code true}) or not ({@code false}).</li>
     * </ul>
     * {@code isSwapInc} method can be used as a helper method in sorting algorithms to check if a swap is necessary
     * between two elements in order to maintain the decreasing order of the list.
     * @param       list to be arranged.
     * @param       i elements to be compared
     * @param       j elements to be compared
     * @return      the value of swapped.
     * @see         SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    default <L extends T> boolean isSwapDec(List<L> list, int i, int j) {
        if (list.get(i).compareTo(list.get(i + j)) < 0) {
            swap(list, i, (i + j));
            return true;
        }
        return false;
    }

    /**
     * {@code isSwap} that takes a list {@code list}, two indices {@code i} and {@code j}, and a {@code CompareTo<T>}
     * function as parameters. The method attempts to swap the elements at indices i and j in the list based on the
     * result of the comparison performed by the {@code functionalCompareTo} method.
     * <ul>
     *     <li>Calls the {@code functionalCompareTo} method from the {@code CompareTo<T>} function object, passing the
     *     elements at indices {@code i} and {@code (i + j)} of the array as arguments. It compares the two elements and
     *     returns a boolean value indicating whether the elements should beswapped.</li>
     *     <li>{@code if} This checks the result of the comparison. If it returns true, indicating that the elements
     *     should be swapped, the code inside the {@code if} statement will be executed.</li>
     *     <li>Calls a method swap to exchange the elements at indices {@code i} and {@code (i + j)} in the list.</li>
     *     <li>After the swap is performed, the method returns {@code true} to indicate that the elements were
     *     successfully swapped.</li>
     *     <li> If the comparison result is {@code false}, indicating that the elements should not be swapped, the
     *     method simply returns {@code false}.</li>
     * </ul>
     * {@code T} in {@code CompareTo<T>} represents a generic type, which means it can be replaced with any specific
     * type when invoking the {@code isSwap} method.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         SortSwap#swap(List, int, int)
     */
    default <L extends T> boolean isSwap(List<L> list, int i, int j, SortFunctional<T> function){
        if (function.functionalCompareTo(list.get(i), list.get(i + j))) {
            swap(list, i, (i + j));
            return true;
        }
        return false;
    }

    /**
     * {@code flip}, which takes a list {@code list} and one indices {@code to} as input.
     * It performs an in-place flipping of elements within the specified range of the list.
     * <ul>
     *     <li>The method enters a {@code while} loop, which continues as long as the {@code from} index is <i>0</i>,
     *     is less than the {@code to} index.</li>
     *     <li>Inside the loop, the swap method
     *     is called to exchange the elements at indices {@code from} and {@code to} in the {@code list}.
     *     The {@code swap} method is assumed to be defined elsewhere, and it swaps the elements in-place.</li>
     *     <li>After swapping the elements, the {@code from} index is incremented by one {@code from++},
     *     and the {@code to} index is decremented by one {@code to--}.</li>
     *     <li>The loop continues until the {@code from} index is no longer less than
     *     the {@code to} index, at which point the flipping is complete.</li>
     * </ul>
     * {@code flip} method reverses the order of elements in the specified range of the list.
     * It does this by swapping elements from the beginning and end of the range, gradually moving towards the middle
     * until the entire range is flipped.
     * @param       list in which the two selected index are flip.
     * @param       to is the index by which to finish the analyzed.
     * @see         SortSwap#swap(List, int, int)
     */
    default <L extends T> void flip(List<L> list, int to) {
        int from = 0;
        while (from < to) {
            swap(list, from++, to--);
        }
    }

    /**
     * {@code flip}, which takes a list {@code list} and two indices {@code from} and {@code to} as input.
     * It performs an in-place flipping of elements within the specified range of the list.
     * <ul>
     *     <li>The method enters a {@code while} loop, which continues as long as the {@code from} index is less than
     *     the {@code to} index.</li>
     *     <li>Inside the loop, the swap method
     *     is called to exchange the elements at indices {@code from} and {@code to} in the {@code list}.
     *     The {@code swap} method is assumed to be defined elsewhere, and it swaps the elements in-place.</li>
     *     <li>After swapping the elements, the {@code from} index is incremented by one {@code from++},
     *     and the {@code to} index is decremented by one {@code to--}.</li>
     *     <li>The loop continues until the {@code from} index is no longer less than
     *     the {@code to} index, at which point the flipping is complete.</li>
     * </ul>
     * {@code flip} method reverses the order of elements in the specified range of the list.
     * It does this by swapping elements from the beginning and end of the range, gradually moving towards the middle
     * until the entire range is flipped.
     * @param       list in which the two selected index are flip.
     * @param       from is the index from which the analyzed should start.
     * @param       to is the index by which to finish the analyzed.
     * @see         SortSwap#swap(List, int, int)
     */
    default <L extends T> void flip(List<L> list, int from, int to) {
        while (from < to) {
            swap(list, from++, to--);
        }
    }
}