package mz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("rawtypes")
public interface SortArray<T extends Comparable>
extends Sort<T> {

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
    void sortArrayFun(T[] array, Sort.SortFunctional<T> functional);

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
    default void sortArray(T[] array, Sort.SortType sequence) {
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
    default void sortArray(T[] array, Sort.SortFunctional<T> functional) {
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
    default void sortArray(T[] array, Sort.SortType sequence, int thread) {
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
    default void sortArray(T[] array, Sort.SortFunctional<T> functional, int thread) {
        threadArray(array, functional, thread);
    }

    /**
     * {@code threadArray} that performs parallel sorting of an array using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the array that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>The {@code listArray} and {@code threads} lists are created as {@link java.util.ArrayList ArrayList} objects.</li>
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
     * @see         Sort#threadsStart(List)
     * @see         Sort#newArray(List, int, int, int)
     * @see         mz.SortArray#sortArray(Comparable[], int)
     */
    default void threadArray(T[] array, int type, int thread) {
        int n = array.length;
        int length = (n / thread);
        int correction = (n % thread);
        List<T[]> listArray = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            int startIndex = length * i;
            int endIndex = startIndex + length + (i == thread - 1 ? correction : 0);
            T[] subArray = Arrays.copyOfRange(array, startIndex, endIndex);
            listArray.add(subArray);
            threads.add(new Thread(() -> sortArray(subArray, type)));
        }
        threadsStart(threads);
        System.arraycopy(newArray(listArray, n, length, correction), 0, array, 0, n);
        sortArray(array, type);
    }

    /**
     * {@code threadArray} that performs parallel sorting of an array using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the array that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>The {@code listArray} and {@code threads} lists are created as {@link java.util.ArrayList ArrayList} objects.</li>
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
     * @see         Sort#threadsStart(List)
     * @see         Sort#newArray(List, int, int, int)
     * @see         mz.SortArray#sortArray(Comparable[], SortType)
     */
    default void threadArray(T[] array, SortType sequence, int thread) {
        int n = array.length;
        int length = (n / thread);
        int correction = (n % thread);
        List<T[]> listArray = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            int startIndex = length * i;
            int endIndex = startIndex + length + (i == thread - 1 ? correction : 0);
            T[] subArray = Arrays.copyOfRange(array, startIndex, endIndex);
            listArray.add(subArray);
            threads.add(new Thread(() -> sortArray(subArray, sequence)));
        }
        threadsStart(threads);
        System.arraycopy(newArray(listArray, n, length, correction), 0, array, 0, array.length);
        sortArray(array, sequence);
    }

    /**
     * {@code threadArray} that performs parallel sorting of an array using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the array that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>The {@code listArray} and {@code threads} lists are created as {@link java.util.ArrayList ArrayList} objects.</li>
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
     * @see         Sort#threadsStart(List)
     * @see         Sort#newArray(List, int, int, int)
     * @see         mz.SortArray#sortArray(Comparable[], SortFunctional)
     */
    default void threadArray(T[] array, SortFunctional<T> functional, int thread) {
        int n = array.length;
        int length = (n / thread);
        int correction = (n % thread);
        List<T[]> listArray = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            int startIndex = length * i;
            int endIndex = startIndex + length + (i == thread - 1 ? correction : 0);
            T[] subArray = Arrays.copyOfRange(array, startIndex, endIndex);
            listArray.add(subArray);
            threads.add(new Thread(() -> sortArray(subArray, functional)));
        }
        threadsStart(threads);
        System.arraycopy(newArray(listArray, n, length, correction), 0, array, 0, array.length);
        sortArray(array, functional);
    }

    /**
     * {@code threadArrayRev} that performs parallel array reversal using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the array that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>A {@link java.util.List List} called {@code listArray} is created to store
     *     the portions of the array that will be processed by each thread,
     *     and a {@code List} called {@code threads} is created to store the {@code SortThread} objects.</li>
     *     <li>A loop is then executed where each iteration creates a {@code subArray} using
     *     {@link java.util.Arrays#copyOfRange(Object[], int, int) Arrays.copyOfRange}
     *     to extract the appropriate portion of the original {@code array} based on the {@code length},
     *     {@code correction}, and the current {@code i} value.
     *     The {@code subArray} is added to the {@code listArray},
     *     and a new {@code Thread} object is created with
     *     the {@code subArray} as a parameter and added to the {@code threads} list.</li>
     *     <li>After the loop, the {@code threadsStart} method is called to start
     *     the execution of the threads in the {@code threads} list.</li>
     *     <li>Finally, the {@code newArrayRev} method is called to create a reversed version of the {@code listArray},
     *     and the elements from the reversed {@code listArray} are copied back into the original {@code array} using
     *     {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy}.</li>
     * </ul>
     * {@code threadArray} divides the array {@code array} in a specified way and based on the number of threads,
     * then starting the threads simultaneously, the sub-arrays are arranged in reverse order
     * at the end, the subarrays are added, creating the ordered array.
     * @param       array The array to be reversed.
     * @param       thread on how many threads to run the queue arrangement.
     */
    default void threadArrayRev(T[] array, int thread) {
        int n = array.length;
        int length = (n / thread);
        int correction = (n % thread);
        List<T[]> listArray = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            int startIndex = length * i;
            int endIndex = startIndex + length + (i == thread - 1 ? correction : 0);
            T[] subArray = Arrays.copyOfRange(array, startIndex, endIndex);
            listArray.add(subArray);
            threads.add(new Thread(() -> sortArrayRev(subArray)));
        }
        threadsStart(threads);
        System.arraycopy(newArrayRev(listArray, n, length, correction), 0, array, 0, array.length);
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
}