package mz;

import java.util.Arrays;
import java.util.Collections;

/**
 * The topmost interface of the hierarchy, through which all other interface, abstract, super, sub, classes are available with polymorphism.
 * @param <T> setting of a type based on which the elements can be sorted. It is not mandatory to specify, additional pre-written subclasses specify the type.
 * @since 1.0
 * @author <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 * @see mz.SortSwap
 * @see mz.SortComparable
 * @see mz.SortLong
 * @see mz.Selection
 * @see mz.Insertion
 * @see mz.Shell
 * @see mz.Bubble
 */
public interface Sort<T> {

    /**
     * You can set the desired sort by specifying sort type.
     * <dl>
     *      <dt><i>INCREASING</i></dt>
     *      <dd>Puts items in ascending order.</dd>
     *      <dt><i>DECREASING</i></dt>
     *      <dd>Places the elements in descending order.</dd>
     *      <dt><i>DO_NOT_CHANGE_IT</i></dt>
     *      <dd>Does not change the order of the elements!</dd>
     *      <dt><i>REVERSE_ORDER</i></dt>
     *      <dd>It reverses the order of the elements, what was first becomes last.</dd>
     * </dl>
     */
    enum SortType {

        /**
         * Puts items in ascending order.
         */
        INCREASING,

        /**
         * Places the elements in descending order.
         */
        DECREASING,

        /**
         * Does not change the order of the elements!
         */
        DO_NOT_CHANGE_IT,

        /**
         * It reverses the order of the elements, what was first becomes last.
         */
        REVERSE_ORDER;
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls additional methods.
     * @param array to be arranged.
     * @param sequence {@code SortType} you can choose from 4 selectable queue layout types. Order can be specified here, which row arrangement you want to use.
     * @see Sort.SortType
     */
    default public void sortArray(T[] array, SortType sequence) {
        switch (sequence) {
            case INCREASING -> sortArrayInc(array);
            case DECREASING -> sortArrayDec(array);
            case DO_NOT_CHANGE_IT -> {}
            case REVERSE_ORDER -> sortArrayRev(array);
            default -> {}
        }
    }

    /**
     * Increasing method that the inherited classes have to create. its task is to arrange the elements of the array in ascending order.
     * @param array to be arranged.
     */
    void sortArrayInc(T[] array);

    /**
     * Decreasing method that inherited classes must create. its task is to arrange the elements of the array in decreasing order.
     * @param array to be arranged.
     */
    void sortArrayDec(T[] array);

    /**
     * Pre-prepared method, so that every inherited class does not have to prepare the method, it cannot be overridden. Its task is to reverse the order of the elements of the array.
     * @param array
     */
    private void sortArrayRev(T[] array) {
        Collections.reverse(Arrays.asList(array));
    }
}