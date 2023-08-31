package github.magyarzoli;

/**
 * {@link java.lang.FunctionalInterface @FunctionalInterface}: This annotation indicates that the interface is a
 * functional interface. A functional interface is an interface that has only one abstract method and is used for
 * lambda expressions or method references. This line defines the interface CompareTo with a generic type parameter
 * {@code T} that extends the {@link java.lang.Comparable Comparable} interface. The Comparable interface is a
 * built-in interface in Java that represents objects that can be compared to each other.
 * @param       <T> when entering it, you can set which class type the interface is used as.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@FunctionalInterface
@SuppressWarnings("rawtypes")
public interface SortFunctional<T extends Comparable> {

    /**
     * Declares the abstract method {@code functionalCompareTo} within the interface.
     * The method takes two parameters of type {@code T} (which extends {@link java.lang.Comparable Comparable})
     * named {@code a} and {@code b} and returns a boolean value. This method is intended to compare two objects of
     * type {@code T} and determine whether they satisfy a certain condition.
     * @param       a first element to be examined.
     * @param       b second element to be examined.
     * @return      the returns a boolean value.
     */
    boolean functionalCompareTo(T a, T b);
}