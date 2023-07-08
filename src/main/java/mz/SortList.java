package mz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * The part of the hierarchy that refers to List, through which all other interfaces, abstracts, supers, subclasses are accessible with polymorphism.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public interface SortList<T extends Comparable>
        extends Sort<T> {

    /**
     * Increasing method that the inherited classes have to create. its task is to arrange the elements of the list in ascending order.
     * @param       list to be arranged.
     */
    void sortListInc(List<T> list);

    /**
     * Decreasing method that inherited classes must create. its task is to arrange the elements of the list in decreasing order.
     * @param       list to be arranged.
     */
    void sortListDec(List<T> list);

    /**
     * A custom method that inherited classes must create. its task is to arrange
     * the elements of the list in a custom order with the lambda function.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    void sortListFun(List<T> list, Sort.SortFunctional<T> functional);

    /**
     * Pre-prepared method, so that every inherited class does not have to prepare the method, it cannot be overridden.
     * Its task is to reverse the order of the elements of the array.
     * @param       list to be arranged.
     */
    default void sortListRev(List<T> list) {
        Collections.reverse(list);
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls additional methods.
     * The {@code sortList} method takes the {@code list} and the sorting {@code type} as parameters.
     * It then uses a switch statement to determine the value of type and perform the corresponding sorting operation.
     * @param       list to be arranged.
     * @param       type sorting is done according to 4 different integer type settings.
     */
    default void sortList(List<T> list, int type) {
        switch (type) {
            case INC -> sortListInc(list);
            case DEC -> sortListDec(list);
            case NOT -> {}
            case REV -> sortListRev(list);
            default -> {}
        }
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls additional methods.
     * The {@code sortList} method takes the {@code list} and the sorting {@code sequence} as parameters.
     * It then uses a switch statement to determine the value of sequence and perform the corresponding sorting operation.
     * @param       list to be arranged.
     * @param       sequence {@code SortType} you can choose from 4 selectable queue layout types.
     *              Order can be specified here, which row arrangement you want to use.
     * @see         mz.Sort.SortType
     */
    default void sortList(List<T> list, Sort.SortType sequence) {
        switch (sequence) {
            case INCREASING -> sortListInc(list);
            case DECREASING -> sortListDec(list);
            case DO_NOT_CHANGE_IT -> {}
            case REVERSE_ORDER -> sortListRev(list);
            default -> {}
        }
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls additional methods.
     * The {@code sortList} method takes the {@code list} and the sorting {@code functional} as parameters.
     * It then uses a switch statement to determine the value of functional and perform the corresponding sorting operation.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.Sort.SortFunctional
     */
    default void sortList(List<T> list, Sort.SortFunctional<T> functional) {
        sortListFun(list, functional);
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls additional methods.
     * The {@code sortList} method takes the {@code list} and the sorting {@code type} as parameters.
     * It then uses a switch statement to determine the value of type and perform the corresponding sorting operation.
     * @param       list to be arranged.
     * @param       type sorting is done according to 4 different integer type settings.
     * @param       thread on how many threads to run the queue arrangement.
     */
    default void sortList(List<T> list, int type, int thread) {
        switch (type) {
            case INC, DEC -> threadList(list, type, thread);
            case NOT -> {}
            case REV -> threadListRev(list, thread);
            default -> {}
        }
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls additional methods.
     * The {@code sortList} method takes the {@code list} and the sorting {@code sequence} as parameters.
     * It then uses a switch statement to determine the value of sequence and perform the corresponding sorting operation.
     * @param       list to be arranged.
     * @param       sequence {@code SortType} you can choose from 4 selectable queue layout types.
     *              Order can be specified here, which row arrangement you want to use.
     * @param       thread on how many threads to run the queue arrangement.
     * @see         mz.Sort.SortType
     */
    default void sortList(List<T> list, Sort.SortType sequence, int thread) {
        switch (sequence) {
            case INCREASING, DECREASING -> threadList(list, sequence, thread);
            case DO_NOT_CHANGE_IT -> {}
            case REVERSE_ORDER -> threadListRev(list, thread);
            default -> {}
        }
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls additional methods.
     * The {@code sortList} method takes the {@code list} and the sorting {@code functional} as parameters.
     * It then uses a switch statement to determine the value of functional and perform the corresponding sorting operation.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @param       thread on how many threads to run the queue arrangement.
     * @see         mz.Sort.SortFunctional
     */
    default void sortList(List<T> list, Sort.SortFunctional<T> functional, int thread) {
        threadList(list, functional, thread);
    }

    /**
     * {@code threadList} that performs parallel sorting of a list using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the list that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>The {@code listList} and {@code threads} lists are created as {@link java.util.ArrayList ArrayList} objects.</li>
     *     <li>Inside the loop, the {@code subArray} is declared without setting it to {@code null} initially.
     *     The declaration and assignment are combined into one line.</li>
     *     <li>The {@code if} statement now checks if {@code i} is equal to {@code (thread - 1)}
     *     to handle the last portion of the list correctly.</li>
     *     <li>The {@link java.lang.Runnable Runnable} interface is not implemented explicitly.
     *     Instead, an anonymous inner class extending {@link java.lang.Thread Thread} is used to override the run method.
     *     This allows the sorting operation to be performed within each thread.</li>
     *     <li>The {@code threadsStart} method is called to start the execution of the sorting threads.</li>
     *     <li>The sorted sublists are added to {@code listList} using
     *     {@code listList.}{@link java.util.List#add(Object) add}{@code (finalSubList)}.</li>
     *     <li>After the threads have finished executing, the sorted sublists are merged back into the original {@code list}
     *     using {@code list.}{@link java.util.List#addAll(Collection) addAll}{@code (finalSubList)} in a loop.</li>
     *     <li>The {@code sortList} method is called to perform a final sorting operation on the entire list.</li>
     * </ul>
     * {@code threadList} divides the list {@code list} in a specified way and based on the number of threads,
     * then starting the threads at the same time, sorting the sub-lists.
     * at the end, the sub-lists are added together and rearranged, creating the ordered list.
     * @param       list The list to be sorted.
     * @param       type An integer representing the type of sorting to be performed.
     * @param       thread on how many threads to run the queue arrangement.
     * @see         Sort#threadsStart(List)
     * @see         mz.SortList#sortList(List, int)
     */
    default void threadList(List<T> list, int type, int thread) {
        int n = list.size(),
                length = (n / thread),
                correction = (n - (length * thread));
        List<List<T>> listList = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            List<T> subList = null;
            if (i == (thread - 1)) {
                subList = list.subList((length * i), ((length * (i + 1)) + correction));
            } else {
                subList = list.subList((length * i), (length * (i + 1)));
            }
            List<T> finalSubList = subList;
            listList.add(finalSubList);
            threads.add(new Thread() {
                @Override
                public void run() {
                    sortList(finalSubList, type);
                }
            });
        }
        threadsStart(threads);
        for (List<T> finalSubList : listList) {
            list.addAll(finalSubList);
        }
        sortList(list, type);
    }

    /**
     * {@code threadList} that performs parallel sorting of a list using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the list that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>The {@code listList} and {@code threads} lists are created as {@link java.util.ArrayList ArrayList} objects.</li>
     *     <li>Inside the loop, the {@code subArray} is declared without setting it to {@code null} initially.
     *     The declaration and assignment are combined into one line.</li>
     *     <li>The {@code if} statement now checks if {@code i} is equal to {@code (thread - 1)}
     *     to handle the last portion of the list correctly.</li>
     *     <li>The {@link java.lang.Runnable Runnable} interface is not implemented explicitly.
     *     Instead, an anonymous inner class extending {@link java.lang.Thread Thread} is used to override the run method.
     *     This allows the sorting operation to be performed within each thread.</li>
     *     <li>The {@code threadsStart} method is called to start the execution of the sorting threads.</li>
     *     <li>The sorted sublists are added to {@code listList} using
     *     {@code listList.}{@link java.util.List#add(Object) add}{@code (finalSubList)}.</li>
     *     <li>After the threads have finished executing, the sorted sublists are merged back into the original {@code list}
     *     using {@code list.}{@link java.util.List#addAll(Collection) addAll}{@code (finalSubList)} in a loop.</li>
     *     <li>The {@code sortList} method is called to perform a final sorting operation on the entire list.</li>
     * </ul>
     * {@code threadList} divides the list {@code list} in a specified way and based on the number of threads,
     * then starting the threads at the same time, sorting the sub-lists.
     * at the end, the sub-lists are added together and rearranged, creating the ordered list.
     * @param       list The list to be sorted.
     * @param       sequence {@code SortType} you can choose from 4 selectable queue layout types.
     *              Order can be specified here, which row arrangement you want to use.
     * @param       thread on how many threads to run the queue arrangement.
     * @see         Sort#threadsStart(List)
     * @see         mz.SortList#sortList(List, SortType)
     */
    default void threadList(List<T> list, SortType sequence, int thread) {
        int n = list.size(),
                length = (n / thread),
                correction = (n - (length * thread));
        List<List<T>> listList = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            List<T> subList = null;
            if (i == (thread - 1)) {
                subList = list.subList((length * i), ((length * (i + 1)) + correction));
            } else {
                subList = list.subList((length * i), (length * (i + 1)));
            }
            List<T> finalSubList = subList;
            listList.add(finalSubList);
            threads.add(new Thread() {
                @Override
                public void run() {
                    sortList(finalSubList, sequence);
                }
            });
        }
        threadsStart(threads);
        for (List<T> finalSubList : listList) {
            list.addAll(finalSubList);
        }
        sortList(list, sequence);
    }

    /**
     * {@code threadList} that performs parallel sorting of a list using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the list that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>The {@code listList} and {@code threads} lists are created as {@link java.util.ArrayList ArrayList} objects.</li>
     *     <li>Inside the loop, the {@code subArray} is declared without setting it to {@code null} initially.
     *     The declaration and assignment are combined into one line.</li>
     *     <li>The {@code if} statement now checks if {@code i} is equal to {@code (thread - 1)}
     *     to handle the last portion of the list correctly.</li>
     *     <li>The {@link java.lang.Runnable Runnable} interface is not implemented explicitly.
     *     Instead, an anonymous inner class extending {@link java.lang.Thread Thread} is used to override the run method.
     *     This allows the sorting operation to be performed within each thread.</li>
     *     <li>The {@code threadsStart} method is called to start the execution of the sorting threads.</li>
     *     <li>The sorted sublists are added to {@code listList} using
     *     {@code listList.}{@link java.util.List#add(Object) add}{@code (finalSubList)}.</li>
     *     <li>After the threads have finished executing, the sorted sublists are merged back into the original {@code list}
     *     using {@code list.}{@link java.util.List#addAll(Collection) addAll}{@code (finalSubList)} in a loop.</li>
     *     <li>The {@code sortList} method is called to perform a final sorting operation on the entire list.</li>
     * </ul>
     * {@code threadList} divides the list {@code list} in a specified way and based on the number of threads,
     * then starting the threads at the same time, sorting the sub-lists.
     * at the end, the sub-lists are added together and rearranged, creating the ordered list.
     * @param       list The list to be sorted.
     * @param       functional lambda expression for comparison.
     * @param       thread on how many threads to run the queue arrangement.
     * @see         Sort#threadsStart(List)
     * @see         mz.SortList#sortList(List, SortFunctional)
     */
    default void threadList(List<T> list, SortFunctional<T> functional, int thread) {
        int n = list.size(),
                length = (n / thread),
                correction = (n - (length * thread));
        List<List<T>> listList = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            List<T> subList = null;
            if (i == (thread - 1)) {
                subList = list.subList((length * i), ((length * (i + 1)) + correction));
            } else {
                subList = list.subList((length * i), (length * (i + 1)));
            }
            List<T> finalSubList = subList;
            listList.add(finalSubList);
            threads.add(new Thread() {
                @Override
                public void run() {
                    sortList(finalSubList, functional);
                }
            });
        }
        threadsStart(threads);
        for (List<T> finalSubList : listList) {
            list.addAll(finalSubList);
        }
        sortList(list, functional);
    }

    /**
     * {@code threadListRev} that performs parallel list reversal using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the list that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>A {@link java.util.List List} called {@code listList} is created to store
     *     the portions of the list that will be processed by each thread,
     *     and a {@code List} called {@code threads} is created to store the {@code SortThread} objects.</li>
     *     <li>A loop is then executed where each iteration creates a {@code subArray} using
     *     {@link java.util.Arrays#copyOfRange(Object[], int, int) Arrays.copyOfRange}
     *     to extract the appropriate portion of the original {@code list} based on the {@code length},
     *     {@code correction}, and the current {@code i} value.
     *     The {@code subArray} is added to the {@code listList},
     *     and a new {@code Thread} object is created with
     *     the {@code subArray} as a parameter and added to the {@code threads} list.</li>
     *     <li>The {@link java.lang.Runnable Runnable} interface is not implemented explicitly.
     *     Instead, an anonymous inner class extending {@link java.lang.Thread Thread} is used to override the run method.
     *     This allows the sorting operation to be performed within each thread.</li>
     *     <li>After the loop, the {@code threadsStart} method is called to start
     *     the execution of the threads in the {@code threads} list.</li>
     *     <li>The sorted sublists are added to {@code listList} using
     *     {@code listList.}{@link java.util.List#add(Object) add}{@code (finalSubList)}.</li>
     *     <li>After the threads have finished executing, the sorted sublists are merged back into the original {@code list}
     *     using {@code list.}{@link java.util.List#addAll(Collection) addAll}{@code (finalSubList)} in a loop.</li>
     * </ul>
     * {@code threadListRev} divides the list {@code list} in a specified way and based on the number of threads,
     * then starting the threads simultaneously, the sub-lists are arranged in reverse order
     * at the end, the subarrays are added, creating the ordered list.
     * @param       list The list to be reversed.
     * @param       thread on how many threads to run the queue arrangement.
     * @see         mz.Sort#threadsStart(List)
     * @see         mz.SortList#sortListRev(List)
     */
    default void threadListRev(List<T> list, int thread) {
        int n = list.size(),
                length = (n / thread),
                correction = (n - (length * thread));
        List<List<T>> listList = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            List<T> subList = null;
            if (i == (thread - 1)) {
                subList = list.subList((length * i), ((length * (i + 1)) + correction));
            } else {
                subList = list.subList((length * i), (length * (i + 1)));
            }
            List<T> finalSubList = subList;
            listList.add(finalSubList);
            threads.add(new Thread() {
                @Override
                public void run() {
                    sortListRev(finalSubList);
                }
            });
        }
        threadsStart(threads);
        for (List<T> finalSubList : listList) {
            list.addAll(finalSubList);
        }
    }
}