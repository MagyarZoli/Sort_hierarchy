package mz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The topmost interface of the hierarchy, through which all other interface, abstract, super, sub, classes are available with polymorphism.
 * @param       <T> setting of a type based on which the elements can be sorted.
 *              It is not mandatory to specify, additional pre-written subclasses specify the type.
 * @since       1.2
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
     * A custom method that inherited classes must create. its task is to arrange
     * the elements of the array in a custom order with the lambda function.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    void sortArrayFun(T[] array, SortFunctional<T> functional);

    /**
     * Constructor of the class to be sorted is required for multithreaded sorting.
     * Which sorts the threads based on it, and the final merged sort.
     * @return      selected {@code Sort} class initialized.
     */
    Sort sortThreadClass();

    /**
     * Pre-prepared method, so that every inherited class does not have to prepare the method, it cannot be overridden.
     * Its task is to reverse the order of the elements of the array.
     * @param       array to be arranged.
     */
    default void sortArrayRev(T[] array) {
        Collections.reverse(Arrays.asList(array));
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls additional methods.
     * The {@code sortArray} method takes the {@code array} and the sorting {@code type} as parameters.
     * It then uses a switch statement to determine the value of type and perform the corresponding sorting operation.
     * @param       array to be arranged.
     * @param       type sorting is done according to 4 different integer type settings.
     */
    default void sortArray(T[] array, int type) {
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
    default void sortArray(T[] array, SortType sequence) {
        switch (sequence) {
            case INCREASING -> sortArrayInc(array);
            case DECREASING -> sortArrayDec(array);
            case DO_NOT_CHANGE_IT -> {}
            case REVERSE_ORDER -> sortArrayRev(array);
            default -> {}
        }
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls additional methods.
     * The {@code sortArray} method takes the {@code array} and the sorting {@code functional} as parameters.
     * It then uses a switch statement to determine the value of functional and perform the corresponding sorting operation.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         Sort.SortFunctional
     */
    default void sortArray(T[] array, SortFunctional<T> functional) {
        sortArrayFun(array, functional);
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls additional methods.
     * The {@code sortArray} method takes the {@code array} and the sorting {@code type} as parameters.
     * It then uses a switch statement to determine the value of type and perform the corresponding sorting operation.
     * @param       array to be arranged.
     * @param       type sorting is done according to 4 different integer type settings.
     * @param       thread on how many threads to run the queue arrangement.
     */
    default void sortArray(T[] array, int type, int thread) {
        switch (type) {
            case INC, DEC -> threadArray(array, type, thread);
            case NOT -> {}
            case REV -> threadArrayRev(array, thread);
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
     * @param       thread on how many threads to run the queue arrangement.
     * @see         Sort.SortType
     */
    default void sortArray(T[] array, SortType sequence, int thread) {
        switch (sequence) {
            case INCREASING, DECREASING -> threadArray(array, sequence, thread);
            case DO_NOT_CHANGE_IT -> {}
            case REVERSE_ORDER -> threadArrayRev(array, thread);
            default -> {}
        }
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls additional methods.
     * The {@code sortArray} method takes the {@code array} and the sorting {@code functional} as parameters.
     * It then uses a switch statement to determine the value of functional and perform the corresponding sorting operation.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @param       thread on how many threads to run the queue arrangement.
     * @see         Sort.SortFunctional
     */
    default void sortArray(T[] array, SortFunctional<T> functional, int thread) {
        threadArray(array, functional, thread);
    }

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
     * @see         mz.Sort.SortFunctional
     * @see         mz.Sort#scanFunctionalComparableTo(SortFunctional)
     */
    @SuppressWarnings("unchecked")
    default SortFunctional<T> functionalComparableToAddEquals (SortFunctional<T> functional) {
        SortFunctional<T> newFunctional = null;
        switch (scanFunctionalComparableTo(functional)) {
            case 0 -> newFunctional = (a, b) -> a.compareTo(b) >= 0;
            case 2 -> newFunctional = (a, b) -> a.compareTo(b) <= 0;
            case 4 -> newFunctional = (a, b) -> a.compareTo(b) == 0;
            case 1, 3, 5 -> newFunctional = functional;
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
     * @see         mz.Sort.SortFunctional
     * @see         mz.Sort#scanFunctionalComparableTo(SortFunctional)
     */
    @SuppressWarnings("unchecked")
    default SortFunctional<T> functionalComparableToRemoveEquals (SortFunctional<T> functional) {
        SortFunctional<T> newFunctional = null;
        switch (scanFunctionalComparableTo(functional)) {
            case 1 -> newFunctional = (a, b) -> a.compareTo(b) > 0;
            case 3 -> newFunctional = (a, b) -> a.compareTo(b) < 0;
            case 5 -> newFunctional = (a, b) -> a.compareTo(b) != 0;
            case 0, 2, 4 -> newFunctional = functional;
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
     * @see         mz.Sort.SortFunctional
     * @see         mz.Sort#scanFunctionalComparableTo(SortFunctional)
     */
    @SuppressWarnings("unchecked")
    default SortFunctional<T> functionalComparableToReverse (SortFunctional<T> functional) {
        SortFunctional<T> newFunctional = null;
        switch (scanFunctionalComparableTo(functional)) {
            case 0 -> newFunctional = (a, b) -> a.compareTo(b) < 0;
            case 1 -> newFunctional = (a, b) -> a.compareTo(b) <= 0;
            case 2 -> newFunctional = (a, b) -> a.compareTo(b) > 0;
            case 3 -> newFunctional = (a, b) -> a.compareTo(b) >= 0;
            case 4 -> newFunctional = (a, b) -> a.compareTo(b) == 0;
            case 5 -> newFunctional = (a, b) -> a.compareTo(b) != 0;
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
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    @SuppressWarnings("unchecked")
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
     * {@code threadArray} that performs parallel sorting of an array using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the array that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>The {@code list} and {@code threads} lists are created as {@link java.util.ArrayList ArrayList} objects.</li>
     *     <li>Inside the loop, the {@code subArray} is declared without setting it to {@code null} initially.
     *     The declaration and assignment are combined into one line.</li>
     *     <li>The {@code if} statement now checks if {@code i} is equal to {@code (thread - 1)}
     *     to handle the last portion of the array correctly.</li>
     *     <li>The {@code threadsStart} method is called to start the execution of the sorting threads.</li>
     *     <li>The {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy}
     *     method is used to copy the sorted portions of the array from the {@code newArray}
     *     method back into the original array.</li>
     *     <li>The {@code sortArray} method is called to perform a final sorting operation on the entire array.</li>
     * </ul>
     * {@code threadArray} divides the array {@code array} in a specified way and based on the number of threads,
     * then starting the threads at the same time, sorting the sub-arrays.
     * at the end, the sub-arrays are added together and rearranged, creating the ordered array.
     * @param       array The array to be sorted.
     * @param       type An integer representing the type of sorting to be performed.
     * @param       thread on how many threads to run the queue arrangement.
     * @see         mz.Sort#sortThreadClass()
     * @see         mz.Sort#threadsStart(List)
     * @see         mz.Sort#newArray(List, int, int, int)
     * @see         mz.Sort#sortArray(Comparable[], int)
     */
    default void threadArray(T[] array, int type, int thread) {
        int n = array.length,
                length = (n / thread),
                correction = (n - (length * thread));
        List<T[]> list = new ArrayList<>();
        List<SortThread<T>> threads = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            T[] subArray = null;
            if (i == (thread - 1)) {
                subArray = Arrays.copyOfRange(array, (length * i), ((length * (i + 1)) + correction));
            } else {
                subArray = Arrays.copyOfRange(array, (length * i), (length * (i + 1)));
            }
            list.add(subArray);
            threads.add(new SortThread<>(sortThreadClass(), subArray, type));
        }
        threadsStart(threads);
        System.arraycopy(newArray(list, n, length, correction), 0, array, 0, array.length);
        sortArray(array, type);
    }

    /**
     * {@code threadArray} that performs parallel sorting of an array using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the array that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>The {@code list} and {@code threads} lists are created as {@link java.util.ArrayList ArrayList} objects.</li>
     *     <li>Inside the loop, the {@code subArray} is declared without setting it to {@code null} initially.
     *     The declaration and assignment are combined into one line.</li>
     *     <li>The {@code if} statement now checks if {@code i} is equal to {@code (thread - 1)}
     *     to handle the last portion of the array correctly.</li>
     *     <li>The {@code threadsStart} method is called to start the execution of the sorting threads.</li>
     *     <li>The {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy}
     *     method is used to copy the sorted portions of the array from the {@code newArray}
     *     method back into the original array.</li>
     *     <li>The {@code sortArray} method is called to perform a final sorting operation on the entire array.</li>
     * </ul>
     * {@code threadArray} divides the array {@code array} in a specified way and based on the number of threads,
     * then starting the threads at the same time, sorting the sub-arrays.
     * at the end, the sub-arrays are added together and rearranged, creating the ordered array.
     * @param       array The array to be sorted.
     * @param       sequence {@code SortType} you can choose from 4 selectable queue layout types.
     *              Order can be specified here, which row arrangement you want to use.
     * @param       thread on how many threads to run the queue arrangement.
     * @see         mz.Sort#sortThreadClass()
     * @see         mz.Sort#threadsStart(List)
     * @see         mz.Sort#newArray(List, int, int, int)
     * @see         mz.Sort#sortArray(Comparable[], SortType)
     */
    default void threadArray(T[] array, SortType sequence, int thread) {
        int n = array.length,
                length = (n / thread),
                correction = (n - (length * thread));
        List<T[]> list = new ArrayList<>();
        List<SortThread<T>> threads = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            T[] subArray = null;
            if (i == (thread - 1)) {
                subArray = Arrays.copyOfRange(array, (length * i), ((length * (i + 1)) + correction));
            } else {
                subArray = Arrays.copyOfRange(array, (length * i), (length * (i + 1)));
            }
            list.add(subArray);
            threads.add(new SortThread<>(sortThreadClass(), subArray, sequence));
        }
        threadsStart(threads);
        System.arraycopy(newArray(list, n, length, correction), 0, array, 0, array.length);
        sortArray(array, sequence);
    }

    /**
     * {@code threadArray} that performs parallel sorting of an array using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the array that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>The {@code list} and {@code threads} lists are created as {@link java.util.ArrayList ArrayList} objects.</li>
     *     <li>Inside the loop, the {@code subArray} is declared without setting it to {@code null} initially.
     *     The declaration and assignment are combined into one line.</li>
     *     <li>The {@code if} statement now checks if {@code i} is equal to {@code (thread - 1)}
     *     to handle the last portion of the array correctly.</li>
     *     <li>The {@code threadsStart} method is called to start the execution of the sorting threads.</li>
     *     <li>The {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy}
     *     method is used to copy the sorted portions of the array from the {@code newArray}
     *     method back into the original array.</li>
     *     <li>The {@code sortArray} method is called to perform a final sorting operation on the entire array.</li>
     * </ul>
     * {@code threadArray} divides the array {@code array} in a specified way and based on the number of threads,
     * then starting the threads at the same time, sorting the sub-arrays.
     * at the end, the sub-arrays are added together and rearranged, creating the ordered array.
     * @param       array The array to be sorted.
     * @param       functional lambda expression for comparison.
     * @param       thread on how many threads to run the queue arrangement.
     * @see         mz.Sort#sortThreadClass()
     * @see         mz.Sort#threadsStart(List)
     * @see         mz.Sort#newArray(List, int, int, int)
     * @see         mz.Sort#sortArray(Comparable[], SortFunctional)
     */
    default void threadArray(T[] array, SortFunctional<T> functional, int thread) {
        int n = array.length,
                length = (n / thread),
                correction = (n - (length * thread));
        List<T[]> list = new ArrayList<>();
        List<SortThread<T>> threads = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            T[] subArray = null;
            if (i == (thread - 1)) {
                subArray = Arrays.copyOfRange(array, (length * i), ((length * (i + 1)) + correction));
            } else {
                subArray = Arrays.copyOfRange(array, (length * i), (length * (i + 1)));
            }
            list.add(subArray);
            threads.add(new SortThread<>(sortThreadClass(), subArray, functional));
        }
        threadsStart(threads);
        System.arraycopy(newArray(list, n, length, correction), 0, array, 0, array.length);
        sortArray(array, functional);
    }

    /**
     * {@code threadArrayRev} that performs parallel array reversal using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the array that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>A {@link java.util.List List} called {@code list} is created to store
     *     the portions of the array that will be processed by each thread,
     *     and a {@code List} called {@code threads} is created to store the {@code SortThread} objects.</li>
     *     <li>A loop is then executed where each iteration creates a {@code subArray} using
     *     {@link java.util.Arrays#copyOfRange(Object[], int, int) Arrays.copyOfRange}
     *     to extract the appropriate portion of the original {@code array} based on the {@code length},
     *     {@code correction}, and the current {@code i} value.
     *     The {@code subArray} is added to the {@code list},
     *     and a new {@code SortThread} object is created with
     *     the {@code subArray} as a parameter and added to the {@code threads} list.</li>
     *     <li>After the loop, the {@code threadsStart} method is called to start
     *     the execution of the threads in the {@code threads} list.</li>
     *     <li>Finally, the {@code newArrayRev} method is called to create a reversed version of the {@code list},
     *     and the elements from the reversed {@code list} are copied back into the original {@code array} using
     *     {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy}.</li>
     * </ul>
     * {@code threadArray} divides the array {@code array} in a specified way and based on the number of threads,
     * then starting the threads simultaneously, the sub-arrays are arranged in reverse order
     * at the end, the subarrays are added, creating the ordered array.
     * @param       array The array to be reversed.
     * @param       thread on how many threads to run the queue arrangement.
     */
    default void threadArrayRev(T[] array, int thread) {
        int n = array.length,
                length = (n / thread),
                correction = (n - (length * thread));
        List<T[]> list = new ArrayList<>();
        List<SortThread<T>> threads = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            T[] subArray = null;
            if (i == (thread - 1)) {
                subArray = Arrays.copyOfRange(array, (length * i), ((length * (i + 1)) + correction));
            } else {
                subArray = Arrays.copyOfRange(array, (length * i), (length * (i + 1)));
            }
            list.add(subArray);
            threads.add(new SortThread<>(subArray));
        }
        threadsStart(threads);
        System.arraycopy(newArrayRev(list, n, length, correction), 0, array, 0, array.length);
    }

    /**
     * {@code threadsStart} that takes a List of {@code SortThread<T>} objects as a parameter.
     * The purpose of this method is to start the execution of the threads in the {@code threads} list.
     * <ul>
     *     <li>Within the method, there is a {@code for} loop
     *     that iterates over each {@code SortThread} object in the threads {@code list}.
     *     For each {@code SortThread} object, the {@link java.lang.Thread#start() start()}
     *     method is called to initiate the execution of the thread.</li>
     *     <li>By calling the {@code start()} method on a {@link java.lang.Thread Thread} object,
     *     it triggers the invocation of the {@link java.lang.Thread#run()}  run()}
     *     method overridden in the {@code SortThread} class.
     *     The {@code run()} method typically contains the logic that needs to be executed in a separate thread.</li>
     * </ul>
     * {@code threadsStart} method with a list of {@code SortThread} objects,
     * you can start the execution of each thread in parallel,
     * potentially performing concurrent sorting or other operations,
     * depending on the implementation of the {@code SortThread} class and the overridden {@code run()} method.
     * @param       threads a list of parallel threads.
     */
    default void threadsStart(List<SortThread<T>> threads) {
        for (SortThread thread : threads) {
            thread.start();
        }
    }

    /**
     * {@code newArray} with a generic type parameter {@code T}.
     * This method is part of an interface that implements the interface.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}
     *     annotation is used to suppress compiler warnings related to
     *     the unchecked cast when converting {@link java.lang.Comparable Comparable[]} to {@code T[]}.
     *     This is necessary because arrays of generic types cannot
     *     be directly created or casted due to type erasure in Java.</li>
     *     <li>Within the method, a variable {@code j} is initialized to <i>0</i>.
     *     Then, a new array {@code newArray} of type {@code Comparable[]} is created with a length of {@code n}.
     *     It's important to note that the use of {@code Comparable[]} instead of {@code T[]} indicates that
     *     the code assumes that {@code T} is a type that extends the {@code Comparable} interface.</li>
     *     <li>The method then iterates over the {@code comparables} arrays in the {@code list}.
     *     For each {@code comparables} array, it checks if its length is equal to the expected length.
     *     If they are not equal, the {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy}
     *     method is used to copy the elements from the {@code comparables} array into the {@code newArray} at
     *     the correct index determined by {@code ((comparables.length - correction) * j)}.
     *     If they are equal, the elements are copied at the index {@code comparables.length * j}.</li>
     *     <li>After the loop, the {@code newArray} is cast to type {@code T[]} and returned.</li>
     * </ul>
     * @param       list A {@link java.util.List List} of arrays of type T[].
     * @param       n An integer representing the desired length of the new array.
     * @param       length An integer representing the expected length of the arrays in the {@code list}.
     * @param       correction An integer used to calculate the correct index when the length of an array in the {@code list}.
     * @return      the {@code newArray} is cast to type {@code T[]}.
     */
    @SuppressWarnings("unchecked")
    default T[] newArray(List<T[]> list, int n, int length, int correction) {
        int j = 0;
        Comparable[] newArray = new Comparable[n];
        for (Comparable[] comparables : list) {
            if (comparables.length != length) {
                System.arraycopy(comparables, 0, newArray, ((comparables.length - correction) * j), comparables.length);
            } else {
                System.arraycopy(comparables, 0, newArray, (comparables.length * j), comparables.length);
            }
            j++;
        }
        return (T[]) newArray;
    }

    /**
     * {@code newArrayRev} with a generic type parameter {@code T}.
     * This method appears to be another version of the {@code newArray} method,
     * but with the elements copied in reverse order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}
     *     annotation is used to suppress compiler warnings related to
     *     the unchecked cast when converting {@link java.lang.Comparable Comparable[]} to {@code T[]}.
     *     This is necessary because arrays of generic types cannot
     *     be directly created or casted due to type erasure in Java.</li>
     *     <li>Within the method, a new array {@code newArray} of type {@code Comparable[]} is created with a length of {@code n}.</li>
     *     <li>The method then enters a loop starting from {@code (n - 1)} and going down to <i>0</i>,
     *     decrementing {@code j} by <i>1</i> in each iteration.
     *     This loop is used to iterate through the {@code list} in reverse order.</li>
     *     <li>For each iteration, it checks if the length of
     *     the array at index {@code j} in the {@code list} is equal to the expected {@code length}.
     *     If they are not equal, the {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy}
     *     method is used to copy the elements from the array at index {@code j} into the {@code newArray} at
     *     the correct index determined by {@code ((list.get(j).length - correction) * j)}.
     *     If they are equal, the elements are copied at the index {@code (list.get(j).length * j)}.</li>
     *     <li>After the loop, the {@code newArray} is cast to type {@code T[]} and returned.</li>
     * </ul>
     * @param       list A {@link java.util.List List} of arrays of type T[].
     * @param       n An integer representing the desired length of the new array.
     * @param       length An integer representing the expected length of the arrays in the {@code list}.
     * @param       correction An integer used to calculate the correct index when the length of an array in the {@code list}.
     * @return      the {@code newArray} is cast to type {@code T[]}.
     */
    @SuppressWarnings("unchecked")
    default T[] newArrayRev(List<T[]> list, int n, int length, int correction) {
        Comparable[] newArray = new Comparable[n];
        for (int j = (n - 1); j >= 0; j--) {
            if (list.get(j).length != length) {
                System.arraycopy(list.get(j), 0, newArray, ((list.get(j).length - correction) * j), list.get(j).length);
            } else {
                System.arraycopy(list.get(j), 0, newArray, (list.get(j).length * j), list.get(j).length);
            }
        }
        return (T[]) newArray;
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
     * Inner generic class {@code SortThread} that extends the {@link java.lang.Thread Thread} class.
     * It has a type parameter {@code T} that extends the {@link java.lang.Comparable Comparable} interface,
     * indicating that the elements in the array must be comparable to each other.
     * @param       <T> when entering, we can set the class type to be used.
     */
    @SuppressWarnings("unchecked")
    class SortThread<T extends Comparable>
    extends Thread {

        /**
         * {@code Sort} is an inheriting class that can be achieved with polymorphism and its storage,
         * which type of sorting should take place on the parallel threads.
         */
        private Sort sort = null;

        /**
         * array to be arranged.
         */
        private T[] array = null;

        /**
         * Storage in Object type to specify 3 different arrangements.
         */
        private Object obj = null;

        /**
         * These parameters are used to initialize the member variables of the class.
         * The run method overrides the run method of the {@link java.lang.Thread Thread} class.
         * Inside the {@link java.lang.Thread#run() run()} method,
         * the {@code sortArray} method of the sort object is invoked,
         * passing the array and type variables as arguments.
         * This method is expected to perform the sorting operation on the array.
         * @param       sort An instance of the {@code Sort} class,
         *              which is used to perform the sorting operation.
         * @param       array An array of type {@code T} that will be sorted.
         * @param       type An integer value indicating the type of sorting to be performed.
         */
        public SortThread(Sort sort, T[] array, int type) {
            this.sort = sort;
            this.array = array;
            obj = type;
        }

        /**
         * These parameters are used to initialize the member variables of the class.
         * The run method overrides the run method of the {@link java.lang.Thread Thread} class.
         * Inside the {@link java.lang.Thread#run() run()} method,
         * the {@code sortArray} method of the sort object is invoked,
         * passing the array and sequence variables as arguments.
         * This method is expected to perform the sorting operation on the array.
         * @param       sort An instance of the {@code Sort} class,
         *              which is used to perform the sorting operation.
         * @param       array An array of type {@code T} that will be sorted.
         * @param       sequence {@code SortType} you can choose from 4 selectable queue layout types.
         *              Order can be specified here, which row arrangement you want to use.
         * @see         mz.Sort.SortType
         */
        public SortThread(Sort sort, T[] array, SortType sequence) {
            this.sort = sort;
            this.array = array;
            obj = sequence;
        }

        /**
         * These parameters are used to initialize the member variables of the class.
         * The run method overrides the run method of the {@link java.lang.Thread Thread} class.
         * Inside the {@link java.lang.Thread#run() run()} method,
         * the {@code sortArray} method of the sort object is invoked,
         * passing the array and functional variables as arguments.
         * This method is expected to perform the sorting operation on the array.
         * @param       sort An instance of the {@code Sort} class,
         *              which is used to perform the sorting operation.
         * @param       array An array of type {@code T} that will be sorted.
         * @param       functional lambda expression for comparison.
         * @see         Sort.SortFunctional
         */
        public SortThread(Sort sort, T[] array, SortFunctional<T> functional) {
            this.sort = sort;
            this.array = array;
            obj = functional;
        }

        /**
         * These parameters are used to initialize the member variables of the class.
         * The run method overrides the run method of the {@link java.lang.Thread Thread} class.
         * Inside the {@link java.lang.Thread#run() run()} method,
         * the {@code sortArray} method of the sort object is invoked,
         * passing the array variables as arguments.
         * This method is expected to perform the reverse sort operation on the array.
         * @param       array An array of type {@code T} that will be sorted.
         */
        public SortThread(T[] array) {
            this.array = array;
        }

        /**
         * {@inheritDoc}<br><br>
         * After override, it sorts the specified array according to its type.
         * @see     mz.Sort.SortThread#sortThreadArray(Comparable[], Object)
         */
        @Override
        public void run() {
            sortThreadArray(array, obj);
        }

        /**
         * {@code sortThreadArray} that takes an array {@code array} and an {@code obj} object as parameters.
         * Within the method, there are several conditional statements that check the type of
         * the {@code obj} parameter using the {@code instanceof} operator.
         * Depending on the type of {@code obj},
         * different sorting operations or array manipulations are performed:
         * <ul>
         *     <li>If {@code obj} is an instance of {@link java.lang.Integer Integer},
         *     it is cast to {@code (Integer)} and passed as an argument to
         *     the {@code sortArray} method of the {@code sort} object.</li>
         *     <li>If {@code obj} is an instance of {@code SortType},
         *     it is cast to {@code (SortType)} and passed as an argument to
         *     the {@code sortArray} method of the {@code sort} object.</li>
         *     <li>If {@code obj} is an instance of {@code SortFunctional},
         *     it is cast to {@code (SortFunctional)} and passed as an argument to
         *     the {@code sortArray} method of the {@code sort} object.</li>
         *     <li>If {@code obj} is {@code null}, the {@link java.util.Arrays#asList(Object[]) Arrays.asList(array)}
         *     method is used to convert the array into a {@link java.util.List List},
         *     and then {@link java.util.Collections#reverse(List) Collections.reverse}
         *     is called on the list to reverse the order of its elements.
         *     This operation effectively reverses the order of the array.</li>
         * </ul>
         * {@code sortThreadArray} method is responsible for sorting or manipulating
         * the {@code array} based on the type of {@code obj} that is passed to it.
         * @param       array to be arranged.
         * @param       obj type to specify 3 different arrangements
         * @see         mz.Sort#sortArray(Comparable[], int)
         * @see         mz.Sort#sortArray(Comparable[], SortType)
         * @see         mz.Sort#sortArray(Comparable[], SortFunctional)
         */
        private void sortThreadArray(T[] array, Object obj){
            if(obj instanceof Integer) {
                sort.sortArray(array, (Integer) obj);
            } else if (obj instanceof SortType) {
                sort.sortArray(array, (SortType) obj);
            } else if (obj instanceof SortFunctional) {
                sort.sortArray(array, (SortFunctional) obj);
            } else if (obj == null) {
                Collections.reverse(Arrays.asList(array));
            }
        }
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