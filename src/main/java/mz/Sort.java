package mz;

import java.util.Arrays;
import java.util.Collections;

/**
 * The topmost interface of the hierarchy, through which all other interface, abstract, super, sub, classes are available with polymorphism.
 * @param       <T> setting of a type based on which the elements can be sorted.
 *              It is not mandatory to specify, additional pre-written subclasses specify the type.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public interface Sort<T extends Comparable> {

    /**
     * Puts items in ascending order.
     */
    int INC = 1;

    /**
     * Places the elements in descending order.
     */
    int DEC = 2;

    /**
     * Does not change the order of the elements!
     */
    int NOT = 3;

    /**
     * It reverses the order of the elements, what was first becomes last.
     */
    int REV = 4;

    /**
     * You can set the desired sort by specifying sort type.
     * <ul>
     *     <li><i>INCREASING</i> - Puts items in ascending order.</li>
     *     <li><i>DECREASING</i> - Places the elements in descending order.</li>
     *     <li><i>DO_NOT_CHANGE_IT</i> - Does not change the order of the elements!</li>
     *     <li><i>REVERSE_ORDER</i> - It reverses the order of the elements, what was first becomes last.</li>
     * </ul>
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
     * {@link java.lang.FunctionalInterface @FunctionalInterface}: This annotation indicates that the interface is a functional interface.
     * A functional interface is an interface that has only one abstract method and is used for lambda expressions or method references.
     * This line defines the interface CompareTo with a generic type parameter {@code T} that extends the {@link java.lang.Comparable Comparable} interface.
     * The Comparable interface is a built-in interface in Java that represents objects that can be compared to each other.
     * @param       <T> when entering it, you can set which class type the interface is used as.
     */
    @FunctionalInterface
    interface SortFunctional<T> {

        /**
         * Declares the abstract method {@code functionalCompareTo} within the interface.
         * The method takes two parameters of type {@code T} (which extends {@link java.lang.Comparable Comparable})
         * named {@code a} and {@code b} and returns a boolean value.
         * This method is intended to compare two objects of type {@code T} and determine whether they satisfy a certain condition.
         * @param       a first element to be examined.
         * @param       b second element to be examined.
         * @return      the returns a boolean value.
         */
        boolean functionalCompareTo(T a, T b);
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls additional methods.
     * The {@code sortArray} method takes the {@code array} and the sorting {@code type} as parameters.
     * It then uses a switch statement to determine the value of type and perform the corresponding sorting operation.
     * @param       array to be arranged.
     * @param       type sorting is done according to 4 different integer type settings.
     */
    default public void sortArray(T[] array, int type) {
        switch (type) {
            case INC -> sortArrayInc(array);
            case DEC -> sortArrayDec(array);
            case NOT -> {}
            case REV -> sortArrayRev(array);
            default -> {}
        }
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls additional methods.
     * The {@code sortArray} method takes the {@code array} and the sorting {@code sequence} as parameters.
     * It then uses a switch statement to determine the value of sequence and perform the corresponding sorting operation.
     * @param       array to be arranged.
     * @param       sequence {@code SortType} you can choose from 4 selectable queue layout types.
     *              Order can be specified here, which row arrangement you want to use.
     * @see         Sort.SortType
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
     * @param       array to be arranged.
     */
    void sortArrayInc(T[] array);

    /**
     * Decreasing method that inherited classes must create. its task is to arrange the elements of the array in decreasing order.
     * @param       array to be arranged.
     */
    void sortArrayDec(T[] array);

    /**
     * Pre-prepared method, so that every inherited class does not have to prepare the method, it cannot be overridden. Its task is to reverse the order of the elements of the array.
     * @param       array to be arranged.
     */
    default void sortArrayRev(T[] array) {
        Collections.reverse(Arrays.asList(array));
    }
}