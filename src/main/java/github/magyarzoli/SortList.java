package github.magyarzoli;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * The part of the hierarchy that refers to List, through which all other interfaces, abstracts, supers, subclasses are
 * accessible with polymorphism.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public interface SortList<T extends Comparable>
        extends Sort<T> {

    /**
     * Increasing method that the inherited classes have to create. its task is to arrange the elements of the list in
     * ascending order.
     * @param       list to be arranged.
     */
    void sortListInc(List<? extends T> list);

    /**
     * Decreasing method that inherited classes must create. its task is to arrange the elements of the list in
     * decreasing order.
     * @param       list to be arranged.
     */
    void sortListDec(List<? extends T> list);

    /**
     * A custom method that inherited classes must create. its task is to arrange
     * the elements of the list in a custom order with the lambda function.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    void sortListFun(List<? extends T> list, Sort.SortFunctional<T> functional);

    /**
     * Pre-prepared method, so that every inherited class does not have to prepare the method, it cannot be overridden.
     * Its task is to reverse the order of the elements of the array.
     * @param       list to be arranged.
     */
    default void sortListRev(List<? extends T> list) {
        Collections.reverse(list);
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls
     * additional methods. The {@code sortList} method takes the {@code list} and the sorting {@code type} as
     * parameters. It then uses a switch statement to determine the value of type and perform the corresponding sorting
     * operation.
     * @param       list to be arranged.
     * @param       type sorting is done according to 4 different integer type settings.
     */
    default void sortList(List<? extends T> list, int type) {
        switch (type) {
            case INC:
                sortListInc(list);
                break;
            case DEC:
                sortListDec(list);
                break;
            case NOT:
                break;
            case REV:
                sortListRev(list);
                break;
            default:
                break;
        }
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls
     * additional methods. The {@code sortList} method takes the {@code list} and the sorting {@code sequence} as
     * parameters. It then uses a switch statement to determine the value of sequence and perform the corresponding
     * sorting operation.
     * @param       list to be arranged.
     * @param       sequence {@code SortType} you can choose from 4 selectable queue layout types.
     *              Order can be specified here, which row arrangement you want to use.
     * @see         Sort.SortType
     */
    default void sortList(List<? extends T> list, Sort.SortType sequence) {
        switch (sequence) {
            case INCREASING:
                sortListInc(list);
                break;
            case DECREASING:
                sortListDec(list);
                break;
            case DO_NOT_CHANGE_IT:
                break;
            case REVERSE_ORDER:
                sortListRev(list);
                break;
        }
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls
     * additional methods.
     * The {@code sortList} method takes the {@code list} and the sorting {@code functional} as parameters.
     * It then uses a switch statement to determine the value of functional and perform the corresponding sorting operation.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         Sort.SortFunctional
     */
    default void sortList(List<? extends T> list, Sort.SortFunctional<T> functional) {
        sortListFun(list, functional);
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls
     * additional methods.
     * The {@code sortList} method takes the {@code list} and the sorting {@code type} as parameters.
     * It then uses a switch statement to determine the value of type and perform the corresponding sorting operation.
     * @param       list to be arranged.
     * @param       type sorting is done according to 4 different integer type settings.
     * @param       thread on how many threads to run the queue arrangement.
     */
    default void sortList(List<? extends T> list, int type, int thread) {
        switch (type) {
            case INC:
            case DEC:
                threadList(list, type, thread);
                break;
            case NOT:
                break;
            case REV:
                threadListRev(list, thread);
                break;
            default:
                break;
        }
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls
     * additional methods.
     * The {@code sortList} method takes the {@code list} and the sorting {@code sequence} as parameters.
     * It then uses a switch statement to determine the value of sequence and perform the corresponding sorting
     * operation.
     * @param       list to be arranged.
     * @param       sequence {@code SortType} you can choose from 4 selectable queue layout types.
     *              Order can be specified here, which row arrangement you want to use.
     * @param       thread on how many threads to run the queue arrangement.
     * @see         Sort.SortType
     */
    default void sortList(List<? extends T> list, Sort.SortType sequence, int thread) {
        switch (sequence) {
            case INCREASING:
            case DECREASING:
                threadList(list, sequence, thread);
                break;
            case DO_NOT_CHANGE_IT:
                break;
            case REVERSE_ORDER:
                threadListRev(list, thread);
                break;
        }
    }

    /**
     * Every class inherited by polymorphism will contain the callable method. default pre-created method calls
     * additional methods.
     * The {@code sortList} method takes the {@code list} and the sorting {@code functional} as parameters.
     * It then uses a switch statement to determine the value of functional and perform the corresponding sorting
     * operation.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @param       thread on how many threads to run the queue arrangement.
     * @see         Sort.SortFunctional
     */
    default void sortList(List<? extends T> list, Sort.SortFunctional<T> functional, int thread) {
        threadList(list, functional, thread);
    }

    /**
     * {@code threadList} that performs parallel sorting of a list using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the list that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>The {@code listList} and {@code threads} lists are created as {@link java.util.ArrayList ArrayList}
     *     objects.</li>
     *     <li>Inside the loop, the {@code subArray} is declared without setting it to {@code null} initially.
     *     The declaration and assignment are combined into one line.</li>
     *     <li>The {@code if} statement now checks if {@code i} is equal to {@code (thread - 1)}
     *     to handle the last portion of the list correctly.</li>
     *     <li>The {@link java.lang.Runnable Runnable} interface is not implemented explicitly.
     *     Instead, an anonymous inner class extending {@link java.lang.Thread Thread} is used to override the run
     *     method. This allows the sorting operation to be performed within each thread.</li>
     *     <li>The {@code threadsStart} method is called to start the execution of the sorting threads.</li>
     *     <li>The sorted sublists are added to {@code listList} using
     *     {@code listList.}{@link java.util.List#add(Object) add}{@code (finalSubList)}.</li>
     *     <li>After the threads have finished executing, the sorted sublists are merged back into the original
     *     {@code list}
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
     * @see         SortList#sortList(List, int)
     */
    default <L extends T> void threadList(List<L> list, int type, int thread) {
        int n = list.size();
        int length = (n / thread);
        int correction = (n % thread);
        List<List<L>> listList = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        List<L> mergedList = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            int startIndex = length * i;
            int endIndex = startIndex + length + (i == thread - 1 ? correction : 0);
            List<L> subList = list.subList(startIndex, endIndex);
            listList.add(subList);
            threads.add(new Thread(() -> sortList(subList, type)));
        }
        threadsStart(threads);
        for (List<L> subList : listList) {
            mergedList.addAll(subList);
        }
        list.clear();
        list.addAll(mergedList);
        sortList(list, type);
    }

    /**
     * {@code threadList} that performs parallel sorting of a list using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the list that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>The {@code listList} and {@code threads} lists are created as {@link java.util.ArrayList ArrayList}
     *     objects.</li>
     *     <li>Inside the loop, the {@code subArray} is declared without setting it to {@code null} initially.
     *     The declaration and assignment are combined into one line.</li>
     *     <li>The {@code if} statement now checks if {@code i} is equal to {@code (thread - 1)}
     *     to handle the last portion of the list correctly.</li>
     *     <li>The {@link java.lang.Runnable Runnable} interface is not implemented explicitly.
     *     Instead, an anonymous inner class extending {@link java.lang.Thread Thread} is used to override the run
     *     method. This allows the sorting operation to be performed within each thread.</li>
     *     <li>The {@code threadsStart} method is called to start the execution of the sorting threads.</li>
     *     <li>The sorted sublists are added to {@code listList} using
     *     {@code listList.}{@link java.util.List#add(Object) add}{@code (finalSubList)}.</li>
     *     <li>After the threads have finished executing, the sorted sublists are merged back into the original
     *     {@code list} using {@code list.}{@link java.util.List#addAll(Collection) addAll}{@code (finalSubList)} in a
     *     loop.</li>
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
     * @see         SortList#sortList(List, SortType)
     */
    default <L extends T> void threadList(List<L> list, SortType sequence, int thread) {
        int n = list.size();
        int length = (n / thread);
        int correction = (n % thread);
        List<List<L>> listList = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        List<L> mergedList = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            int startIndex = length * i;
            int endIndex = startIndex + length + (i == thread - 1 ? correction : 0);
            List<L> subList = list.subList(startIndex, endIndex);
            listList.add(subList);
            threads.add(new Thread(() -> sortList(subList, sequence)));
        }
        threadsStart(threads);
        for (List<L> subList : listList) {
            mergedList.addAll(subList);
        }
        list.clear();
        list.addAll(mergedList);
        sortList(list, sequence);
    }

    /**
     * {@code threadList} that performs parallel sorting of a list using multiple threads.
     * <ul>
     *     <li>The method begins by calculating the values of {@code length} and {@code correction}.
     *     {@code length} represents the length of each portion of the list that will be processed by each thread,
     *     while {@code correction} represents the remaining length that is not evenly divisible among the threads.</li>
     *     <li>The {@code listList} and {@code threads} lists are created as {@link java.util.ArrayList ArrayList}
     *     objects.</li>
     *     <li>Inside the loop, the {@code subArray} is declared without setting it to {@code null} initially.
     *     The declaration and assignment are combined into one line.</li>
     *     <li>The {@code if} statement now checks if {@code i} is equal to {@code (thread - 1)}
     *     to handle the last portion of the list correctly.</li>
     *     <li>The {@link java.lang.Runnable Runnable} interface is not implemented explicitly.
     *     Instead, an anonymous inner class extending {@link java.lang.Thread Thread} is used to override the run
     *     method. This allows the sorting operation to be performed within each thread.</li>
     *     <li>The {@code threadsStart} method is called to start the execution of the sorting threads.</li>
     *     <li>The sorted sublists are added to {@code listList} using
     *     {@code listList.}{@link java.util.List#add(Object) add}{@code (finalSubList)}.</li>
     *     <li>After the threads have finished executing, the sorted sublists are merged back into the original
     *     {@code list} using {@code list.}{@link java.util.List#addAll(Collection) addAll}{@code (finalSubList)} in a
     *     loop.</li>
     *     <li>The {@code sortList} method is called to perform a final sorting operation on the entire list.</li>
     * </ul>
     * {@code threadList} divides the list {@code list} in a specified way and based on the number of threads,
     * then starting the threads at the same time, sorting the sub-lists.
     * at the end, the sub-lists are added together and rearranged, creating the ordered list.
     * @param       list The list to be sorted.
     * @param       functional lambda expression for comparison.
     * @param       thread on how many threads to run the queue arrangement.
     * @see         Sort#threadsStart(List)
     * @see         SortList#sortList(List, SortFunctional)
     */
    default <L extends T> void threadList(List<L> list, SortFunctional<T> functional, int thread) {
        int n = list.size();
        int length = (n / thread);
        int correction = (n % thread);
        List<List<L>> listList = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        List<L> mergedList = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            int startIndex = length * i;
            int endIndex = startIndex + length + (i == thread - 1 ? correction : 0);
            List<L> subList = list.subList(startIndex, endIndex);
            listList.add(subList);
            threads.add(new Thread(() -> sortList(subList, functional)));
        }
        threadsStart(threads);
        for (List<L> subList : listList) {
            mergedList.addAll(subList);
        }
        list.clear();
        list.addAll(mergedList);
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
     *     Instead, an anonymous inner class extending {@link java.lang.Thread Thread} is used to override the
     *     run method. This allows the sorting operation to be performed within each thread.</li>
     *     <li>After the loop, the {@code threadsStart} method is called to start
     *     the execution of the threads in the {@code threads} list.</li>
     *     <li>The sorted sublists are added to {@code listList} using
     *     {@code listList.}{@link java.util.List#add(Object) add}{@code (finalSubList)}.</li>
     *     <li>After the threads have finished executing, the sorted sublists are merged back into the original
     *     {@code list} using {@code list.}{@link java.util.List#addAll(Collection) addAll}{@code (finalSubList)} in a
     *     loop.</li>
     * </ul>
     * {@code threadListRev} divides the list {@code list} in a specified way and based on the number of threads,
     * then starting the threads simultaneously, the sub-lists are arranged in reverse order
     * at the end, the subarrays are added, creating the ordered list.
     * @param       list The list to be reversed.
     * @param       thread on how many threads to run the queue arrangement.
     * @see         Sort#threadsStart(List)
     * @see         SortList#sortListRev(List)
     */
    default <L extends T> void threadListRev(List<L> list, int thread) {
        int n = list.size();
        int length = (n / thread);
        int correction = (n % thread);
        List<List<L>> listList = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        List<L> mergedList = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            int startIndex = length * i;
            int endIndex = startIndex + length + (i == thread - 1 ? correction : 0);
            List<L> subList = list.subList(startIndex, endIndex);
            listList.add(subList);
            threads.add(new Thread(() -> sortListRev(subList)));
        }
        threadsStart(threads);
        for (List<L> subList : listList) {
            mergedList.addAll(subList);
        }
        list.clear();
        list.addAll(mergedList);
    }

    /**
     * {@code addBetween} that takes a {@code List<T>} called {@code list},
     * as well as two indices {@code from} and {@code to}.
     * This method creates a new {@link java.util.ArrayList ArrayList} called {@code betweenList} and
     * adds the elements from the original {@code list} between
     * the indices {@code from} and {@code to} (inclusive) to the {@code betweenList}.
     * <ul>
     *     <li>It creates a new {@code ArrayList} called {@code betweenList}.</li>
     *     <li>It iterates over the indices from {@code from} to {@code to} (inclusive) using a {@code for} loop.</li>
     *     <li>Inside the loop, it retrieves the element at the current index {@code i} from the original {@code list}
     *     using the {@link java.util.List#get(int) get()} method, and adds it to the {@code betweenList} using
     *     the {@link java.util.List#add(Object) add()} method.</li>
     *     <li>After the loop completes, it returns the {@code betweenList} containing the extracted elements.</li>
     * </ul>
     * {@code addBetween} creates a new {@link java.util.List List} {@code betweenList}
     * and adds the elements from the original list {@code list} between the indices {@code from} and {@code to} to the
     * {@code betweenList}. The method then returns the {@code betweenList} containing the extracted elements.
     * @param       list to be sorted.
     * @param       from index representing the start of the range.
     * @param       to index representing the end of the range.
     * @return      the betweenList containing the extracted elements.
     */
    default <L extends T> List<L> addBetween(List<L> list, int from, int to) {
        List<L> betweenList = new ArrayList<>();
        for (int i = from; i < to ; i++) {
            betweenList.add(list.get(i));
        }
        return betweenList;
    }

    /**
     * {@code removeBetween} that takes a {@code List<T>} called {@code list},
     * as well as two indices {@code from} and {@code to}.
     * This method removes the elements from the original {@code list} between the indices {@code from} and {@code to}
     * (inclusive) using the {@link java.util.List#remove(Object) remove()} method.
     * <ul>
     *     <li>It iterates over the indices from {@code from} to {@code to} (inclusive) using a {@code for} loop.</li>
     *     <li>Inside the loop, it retrieves the element at the current index {@code i} from the original {@code list}
     *     using the {@link java.util.List#get(int) get()} method, and removes it from the list using the
     *     {@code remove()} method.</li>
     *     <li>After the loop completes, it returns the modified {@code list}.</li>
     * </ul>
     * {@code removeBetween} removes the elements from the original {@code list} between the indices {@code from} and
     * {@code to}. It iterates over the sublist and removes each element using the {@code remove()} method.
     * The method then returns the modified {@code list}.
     * @param       list to be sorted.
     * @param       from index representing the start of the range.
     * @param       to index representing the end of the range.
     * @return      the modified list.
     */
    default <L extends T> List<L> removeBetween(List<L> list, int from, int to) {
        for (int i = from; i <= to ; i++) {
            list.remove(list.get(i));
        }
        return list;
    }
}