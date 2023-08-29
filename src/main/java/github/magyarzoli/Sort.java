package github.magyarzoli;

import java.util.List;

/**
 * The topmost interface of the hierarchy, through which all other interface, abstract, super, sub, classes are available with polymorphism.
 * @param       <T> setting of a type based on which the elements can be sorted.
 *              It is not mandatory to specify, additional pre-written subclasses specify the type.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings({"rawtypes", "unchecked"})
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
     * {@code functionalComparableToAddEquals} to the {@code SortFunctional} interface.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation
     *     is used to suppress compiler warnings related to unchecked type casting in this method.</li>
     *     <li>The {@code functionalComparableToAddEquals} method takes
     *     an instance of {@code SortFunctional} as a parameter.</li>
     *     <li>It declares a new {@code SortFunctional} variable called {@code newFunctional}
     *     and initializes it with a value of {@code null}.</li>
     *     <li>The method then uses a {@code switch} statement to determine
     *     the value returned by the {@code scanFunctionalComparableTo} method</li>
     *     <li>Depending on the return value of {@code scanFunctionalComparableTo},
     *     different cases are evaluated.</li>
     *     <li>Finally, the method returns the {@code newFunctional} variable.</li>
     * </ul>
     * {@code functionalComparableToAddEquals} this method to be to create a new {@code SortFunctional}
     * instance that modifies the behavior of the original {@code functionalCompareTo} method based on
     * the result of the {@code scanFunctionalComparableTo} method.
     * @param       functional lambda expression for comparison.
     * @return      creates a new lambda expression for the comparison that contains the equality.
     * @see         SortFunctional
     * @see         Sort#scanFunctionalComparableTo(SortFunctional)
     */
    default SortFunctional<T> functionalComparableToAddEquals (SortFunctional<T> functional) {
        SortFunctional<T> newFunctional = null;
        switch (scanFunctionalComparableTo(functional)) {
            case 0:
                newFunctional = (a, b) -> a.compareTo(b) >= 0;
                break;
            case 2:
                newFunctional = (a, b) -> a.compareTo(b) <= 0;
                break;
            case 4:
                newFunctional = (a, b) -> a.compareTo(b) == 0;
                break;
            case 1:
            case 3:
            case 5:
                newFunctional = functional;
                break;
        }
        return newFunctional;
    }

    /**
     * {@code functionalComparableToRemoveEquals} to the {@code SortFunctional} interface.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation
     *     is used to suppress compiler warnings related to unchecked type casting in this method.</li>
     *     <li>The {@code functionalComparableToRemoveEquals} method takes
     *     an instance of {@code SortFunctional} as a parameter.</li>
     *     <li>It declares a new {@code SortFunctional} variable called {@code newFunctional}
     *     and initializes it with a value of {@code null}.</li>
     *     <li>The method then uses a {@code switch} statement to determine
     *     the value returned by the {@code scanFunctionalComparableTo} method</li>
     *     <li>Depending on the return value of {@code scanFunctionalComparableTo},
     *     different cases are evaluated.</li>
     *     <li>Finally, the method returns the {@code newFunctional} variable.</li>
     * </ul>
     * {@code functionalComparableToRemoveEquals} this method to be to create a new {@code SortFunctional}
     * instance that modifies the behavior of the original {@code functionalCompareTo} method by removing
     * the equality checks based on the result of the {@code scanFunctionalComparableTo} method.
     * @param       functional lambda expression for comparison.
     * @return      creates a new lambda expression for comparison that does not include equality.
     * @see         SortFunctional
     * @see         Sort#scanFunctionalComparableTo(SortFunctional)
     */
    default SortFunctional<T> functionalComparableToRemoveEquals(SortFunctional<T> functional) {
        SortFunctional<T> newFunctional = null;
        switch (scanFunctionalComparableTo(functional)) {
            case 1:
                newFunctional = (a, b) -> a.compareTo(b) > 0;
                break;
            case 3:
                newFunctional = (a, b) -> a.compareTo(b) < 0;
                break;
            case 5:
                newFunctional = (a, b) -> a.compareTo(b) != 0;
                break;
            case 0:
            case 2:
            case 4:
                newFunctional = functional;
        }
        return newFunctional;
    }

    /**
     * {@code functionalComparableToReverse} to the {@code SortFunctional} interface.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation
     *     is used to suppress compiler warnings related to unchecked type casting in this method.</li>
     *     <li>The {@code functionalComparableToReverse} method takes
     *     an instance of {@code SortFunctional} as a parameter.</li>
     *     <li>It declares a new {@code SortFunctional} variable called {@code newFunctional}
     *     and initializes it with a value of {@code null}.</li>
     *     <li>The method then uses a {@code switch} statement to determine
     *     the value returned by the {@code scanFunctionalComparableTo} method</li>
     *     <li>Depending on the return value of {@code scanFunctionalComparableTo},
     *     different cases are evaluated.</li>
     *     <li>Finally, the method returns the {@code newFunctional} variable.</li>
     * </ul>
     * {@code functionalComparableToReverse} this method to be to create a new {@code SortFunctional}
     * instance that reverses the behavior of the original {@code functionalCompareTo} method based on
     * the result of the {@code scanFunctionalComparableTo} method.
     * Each comparison case is reversed to its opposite result.
     * @param       functional lambda expression for comparison.
     * @return      creates a new lambda expression for comparison, the opposite of the preceding defined function.
     * @see         SortFunctional
     * @see         Sort#scanFunctionalComparableTo(SortFunctional)
     */
    default SortFunctional<T> functionalComparableToReverse(SortFunctional<T> functional) {
        SortFunctional<T> newFunctional = null;
        switch (scanFunctionalComparableTo(functional)) {
            case 0:
                newFunctional = (a, b) -> a.compareTo(b) < 0;
                break;
            case 1:
                newFunctional = (a, b) -> a.compareTo(b) <= 0;
                break;
            case 2:
                newFunctional = (a, b) -> a.compareTo(b) > 0;
                break;
            case 3:
                newFunctional = (a, b) -> a.compareTo(b) >= 0;
                break;
            case 4:
                newFunctional = (a, b) -> a.compareTo(b) == 0;
                break;
            case 5:
                newFunctional = (a, b) -> a.compareTo(b) != 0;
                break;
        }
        return newFunctional;
    }

    /**
     * The {@code scanFunctionalComparableTo} method is a default implementation provided in the interface.
     * It takes an instance of {@code SortFunctional} and performs comparisons using the {@code functionalCompareTo} method.
     * <ul>
     *     <li>Inside the method, two {@code Integer} variables {@code a} and {@code b} are declared
     *     and assigned values of <i>1</i> and <i>2</i>, respectively.</li>
     *     <li>The {@code functionalCompareTo} method is invoked three times with different arguments:
     *     {@code f((T) a, (T) a,) g((T) a, (T) b,) h((T) b, (T) a)}.</li>
     *     <li>The results of the comparisons are stored in boolean variables {@code f}, {@code g}, and {@code h}.</li>
     *     <li>A series of if-else statements are used to determine the return value based on the combinations of the {@code boolean} variables.
     *     The return values range from <i>0</i> to <i>5</i>, representing different scenarios of the comparison results.</li>
     * </ul>
     * {@code scanFunctionalComparableTo} method examines the lambda function and returns the result of what type of setting lambda is defined.
     * @param       functional lambda expression for comparison.
     * @return      the result of what type of setting lambda is defined.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default int scanFunctionalComparableTo(SortFunctional<T> functional) {
        Integer a = 1, b = 2;
        boolean f = functional.functionalCompareTo((T) a, (T) a),
                g = functional.functionalCompareTo((T) a, (T) b),
                h = functional.functionalCompareTo((T) b, (T) a);
        if (!f && !g && h) {
            return 0;
        } else if (f && !g && h) {
            return 1;
        } else if (!f && g && !h) {
            return 2;
        } else if (f && g && !h) {
            return 3;
        } else if (!f && g && h) {
            return 4;
        } else {
            return 5;
        }
    }

    /**
     * {@code threadsStart} that takes a List of {@link java.lang.Thread Thread<T>} objects as a parameter.
     * The purpose of this method is to start the execution of the threads in the {@code threads} list.
     * <ul>
     *     <li>Within the method, there is a {@code for} loop
     *     that iterates over each {@code Thread} object in the threads {@code list}.
     *     For each {@code Thread} object, the {@link java.lang.Thread#start() start()}
     *     method is called to initiate the execution of the thread.</li>
     *     <li>By calling the {@code start()} method on a {@code Thread} object,
     *     it triggers the invocation of the {@link java.lang.Thread#run()}  run()}
     *     method overridden in the {@code Thread} class.
     *     The {@code run()} method typically contains the logic that needs to be executed in a separate thread.</li>
     *     <li>This line waits for each thread to finish execution by
     *     calling the {@link java.lang.Thread#join() join()} method on the {@code threadObj}.
     *     The {@code join()} method causes the calling thread to wait until the thread represented by {@code threadObj} terminates.</li>
     *     <li>If any thread is interrupted while waiting (e.g., if another thread calls {@link java.lang.Thread#interrupt() interrupt()} on it),
     *     it will throw an {@link java.lang.InterruptedException InterruptedException}.
     *     In that case, the catch block will be executed,
     *     and it will print the stack trace of the exception using {@code e.printStackTrace()}.</li>
     * </ul>
     * {@code threadsStart} method with a list of {@code Thread} objects,
     * you can start the execution of each thread in parallel,
     * potentially performing concurrent sorting or other operations,
     * depending on the implementation of the {@code Thread} class and the overridden {@code run()} method.
     * @param       threads a list of parallel threads.
     */
    default void threadsStart(List<Thread> threads) {
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread threadObj : threads) {
            try {
                threadObj.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * {@link java.lang.FunctionalInterface @FunctionalInterface}: This annotation indicates that the interface is a functional interface.
     * A functional interface is an interface that has only one abstract method and is used for lambda expressions or method references.
     * This line defines the interface CompareTo with a generic type parameter {@code T} that extends the {@link java.lang.Comparable Comparable} interface.
     * The Comparable interface is a built-in interface in Java that represents objects that can be compared to each other.
     * @param       <T> when entering it, you can set which class type the interface is used as.
     */
    @FunctionalInterface
    interface SortFunctional<T extends Comparable> {

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
        REVERSE_ORDER,
    }
}