package mz;

import java.util.List;

/**
 * InsertionInterface, containing the methods of Insertion Sort to implement other classes.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public interface InsertionInterface<T extends Comparable>
extends Sorter<T> {

    /**
     * {@code insertionInc} that performs the Insertion Sort algorithm on a portion of an array of Comparable objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and an integer index specifying
     *     the starting index of the portion to be sorted.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method uses a {@code for} loop that starts from the given {@code index} and iterates up to the end of the {@code array}.</li>
     *     <li>Inside the loop, the element at index {@code i} is selected and stored in the {@code select} variable.</li>
     *     <li>An integer variable {@code j} is initialized with the value of {@code i}.</li>
     *     <li>A {@code while} loop is used to shift elements to the right and find the correct position for
     *     the {@code select} element within the portion of the array.</li>
     *     <li>The condition {@code (j >= index)} ensures that the {@code while} loop executes as long as the index
     *     is within the specified portion of the array.</li>
     *     <li>The condition {@code array[(j - index)].compareTo(select) > 0}
     *     compares the element at index {@code (j - index)} with the {@code select} element.
     *     If the element at index {@code (j - index)} is greater than the {@code select} element, it needs to be shifted to the right.</li>
     *     <li>Inside the {@code while} loop, the element at index {@code j} is replaced with the element at index {@code (j - index)},
     *     effectively shifting the element to the right.</li>
     *     <li>The index {@code j} is decremented by {@code index} to continue comparing and shifting elements until
     *     the correct position for the {@code select} element is found.</li>
     *     <li>Once the correct position is determined, the {@code select} element is placed at index {@code j}.</li>
     * </ul>
     * {@code insertionInc} method implements the Insertion Sort algorithm on a portion of the given {@code array} of Comparable objects.
     * It iterates over the elements starting from the specified index, compares and shifts elements to the right,
     * and places the selected element at its correct position within the portion of the array.
     * The sorting is done in ascending order.
     * @param       array to be arranged.
     */
    @SuppressWarnings("unchecked")
    default void insertionInc(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T select = array[i];
            int j = i;
            while ((j >= 1) && (array[(j - 1)].compareTo(select) > 0)) {
                array[j] = array[(j - 1)];
                j--;
            }
            array[j] = select;
        }
    }

    /**
     * {@code insertionDec} that performs the Insertion Sort algorithm on a portion of an array of Comparable objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and an integer index specifying
     *     the starting index of the portion to be sorted.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method uses a {@code for} loop that starts from the given {@code index} and iterates up to the end of the {@code array}.</li>
     *     <li>Inside the loop, the element at index {@code i} is selected and stored in the {@code select} variable.</li>
     *     <li>An integer variable {@code j} is initialized with the value of {@code i}.</li>
     *     <li>A {@code while} loop is used to shift elements to the right and find the correct position for
     *     the {@code select} element within the portion of the array.</li>
     *     <li>The condition {@code (j >= index)} ensures that the {@code while} loop executes as long as the index
     *     is within the specified portion of the array.</li>
     *     <li>The condition {@code array[(j - index)].compareTo(select) < 0}
     *     compares the element at index {@code (j - index)} with the {@code select} element.
     *     If the element at index {@code (j - index)} is smaller than the {@code select} element, it needs to be shifted to the right.</li>
     *     <li>Inside the {@code while} loop, the element at index {@code j} is replaced with the element at index {@code (j - index)},
     *     effectively shifting the element to the right.</li>
     *     <li>The index {@code j} is decremented by {@code index} to continue comparing and shifting elements until
     *     the correct position for the {@code select} element is found.</li>
     *     <li>Once the correct position is determined, the {@code select} element is placed at index {@code j}.</li>
     * </ul>
     * {@code insertionDec} method implements the Insertion Sort algorithm on a portion of the given {@code array} of Comparable objects.
     * It iterates over the elements starting from the specified index, compares and shifts elements to the right,
     * and places the selected element at its correct position within the portion of the array.
     * The sorting is done in descending order.
     * @param       array to be arranged.
     */
    @SuppressWarnings("unchecked")
    default void insertionDec(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T select = array[i];
            int j = i;
            while ((j >= 1) && (array[(j - 1)].compareTo(select) < 0)) {
                array[j] = array[(j - 1)];
                j--;
            }
            array[j] = select;
        }
    }

    /**
     * {@code insertion} within an interface.
     * This method takes an array of type {@code T[]} and an instance of the {@code SortFunctional} interface as parameters.
     * <ul>
     *     <li>The method iterates over the array from index <i>0</i> to the last index {@code (array.length - 1)}.</li>
     *     <li>For each iteration, it selects an element {@code select} from the array at index {@code i}.</li>
     *     <li>It initializes a variable {@code j} with the value of {@code i}.</li>
     *     <li>It enters a {@code while} loop that continues as long as {@code j} is greater than or equal to <i>1</i> and
     *     the comparison condition in {@code functionalCompareTo} is satisfied between {@code array[(j - 1)]} and {@code select}.</li>
     *     <li>Inside the loop, it shifts elements towards the right
     *     by assigning {@code array[(j - 1)]} to {@code array[j]} and decrements {@code j}.</li>
     *     <li>After the loop ends, it assigns the {@code select} element to {@code array[j]},
     *     placing it at the correct position in the sorted sequence.</li>
     *     <li>The process continues until all elements in the array have been processed.</li>
     * </ul>
     * {@code insertion} method uses the insertion sort algorithm to sort the array in ascending order based on
     * the comparison condition provided by the {@code functionalCompareTo} method of the {@code SortFunctional} interface.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default void insertion(T[] array, SortFunctional<T> functional) {
        for (int i = 0; i < array.length; i++) {
            T select = array[i];
            int j = i;
            while ((j >= 1) && (functional.functionalCompareTo(array[(j - 1)], select))) {
                array[j] = array[(j - 1)];
                j--;
            }
            array[j] = select;
        }
    }

    /**
     * {@code insertionInc} that performs the Insertion Sort algorithm on a portion of an array of Comparable objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and an integer index specifying
     *     the starting index of the portion to be sorted.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method uses a {@code for} loop that starts from the given {@code index} and iterates up to the end of the {@code array}.</li>
     *     <li>Inside the loop, the element at index {@code i} is selected and stored in the {@code select} variable.</li>
     *     <li>An integer variable {@code j} is initialized with the value of {@code i}.</li>
     *     <li>A {@code while} loop is used to shift elements to the right and find the correct position for
     *     the {@code select} element within the portion of the array.</li>
     *     <li>The condition {@code (j >= index)} ensures that the {@code while} loop executes as long as the index
     *     is within the specified portion of the array.</li>
     *     <li>The condition {@code array[(j - index)].compareTo(select) > 0}
     *     compares the element at index {@code (j - index)} with the {@code select} element.
     *     If the element at index {@code (j - index)} is greater than the {@code select} element, it needs to be shifted to the right.</li>
     *     <li>Inside the {@code while} loop, the element at index {@code j} is replaced with the element at index {@code (j - index)},
     *     effectively shifting the element to the right.</li>
     *     <li>The index {@code j} is decremented by {@code index} to continue comparing and shifting elements until
     *     the correct position for the {@code select} element is found.</li>
     *     <li>Once the correct position is determined, the {@code select} element is placed at index {@code j}.</li>
     * </ul>
     * {@code insertionInc} method implements the Insertion Sort algorithm on a portion of the given {@code array} of Comparable objects.
     * It iterates over the elements starting from the specified index, compares and shifts elements to the right,
     * and places the selected element at its correct position within the portion of the array.
     * The sorting is done in ascending order.
     * @param       array to be arranged.
     * @param       from the element from which to start the analysis.
     * @param       to the element to be analyzed.
     */
    @SuppressWarnings("unchecked")
    default void insertionInc(T[] array, int from, int to) {
        for (int i = from; i <= to; i++) {
            T select = array[i];
            int j = i;
            while ((j > from) && ((array[(j - 1)] != null) && (array[(j - 1)].compareTo(select) > 0))) {
                array[j] = array[(j - 1)];
                j--;
            }
            array[j] = select;
        }
    }

    /**
     * {@code insertionDec} that performs the Insertion Sort algorithm on a portion of an array of Comparable objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and an integer index specifying
     *     the starting index of the portion to be sorted.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method uses a {@code for} loop that starts from the given {@code index} and iterates up to the end of the {@code array}.</li>
     *     <li>Inside the loop, the element at index {@code i} is selected and stored in the {@code select} variable.</li>
     *     <li>An integer variable {@code j} is initialized with the value of {@code i}.</li>
     *     <li>A {@code while} loop is used to shift elements to the right and find the correct position for
     *     the {@code select} element within the portion of the array.</li>
     *     <li>The condition {@code (j >= index)} ensures that the {@code while} loop executes as long as the index
     *     is within the specified portion of the array.</li>
     *     <li>The condition {@code array[(j - index)].compareTo(select) < 0}
     *     compares the element at index {@code (j - index)} with the {@code select} element.
     *     If the element at index {@code (j - index)} is smaller than the {@code select} element, it needs to be shifted to the right.</li>
     *     <li>Inside the {@code while} loop, the element at index {@code j} is replaced with the element at index {@code (j - index)},
     *     effectively shifting the element to the right.</li>
     *     <li>The index {@code j} is decremented by {@code index} to continue comparing and shifting elements until
     *     the correct position for the {@code select} element is found.</li>
     *     <li>Once the correct position is determined, the {@code select} element is placed at index {@code j}.</li>
     * </ul>
     * {@code insertionDec} method implements the Insertion Sort algorithm on a portion of the given {@code array} of Comparable objects.
     * It iterates over the elements starting from the specified index, compares and shifts elements to the right,
     * and places the selected element at its correct position within the portion of the array.
     * The sorting is done in descending order.
     * @param       array to be arranged.
     * @param       from the element from which to start the analysis.
     * @param       to the element to be analyzed.
     */
    @SuppressWarnings("unchecked")
    default void insertionDec(T[] array, int from, int to) {
        for (int i = from; i <= to; i++) {
            T select = array[i];
            int j = i;
            while ((j > from) && (array[(j - 1)] != null && array[(j - 1)].compareTo(select) < 0)) {
                array[j] = array[(j - 1)];
                j--;
            }
            array[j] = select;
        }
    }

    /**
     * {@code insertion} within an interface. This method takes an array of type {@code T[]},
     * an integer {@code from} representing the starting index,
     * an integer {@code to} representing the ending index,
     * and an instance of the {@code SortFunctional} interface as parameters.
     * The method implements the insertion sort algorithm using
     * the {@code functionalCompareTo} method provided by the {@code SortFunctional} interface.
     * <ul>
     *     <li>The method iterates over the array {@code from} the from index to the {@code to} index (inclusive).</li>
     *     <li>For each iteration, it selects an element {@code select} from the array at index {@code i}.</li>
     *     <li>It initializes a variable {@code j} with the value of {@code i}.</li>
     *     <li>It enters a while loop that continues as long as {@code j} is greater than {@code from},
     *     {@code array[(j - 1)]} is not null, and the comparison condition in {@code functionalCompareTo}
     *     is satisfied between {@code array[(j - 1)]} and {@code select}.</li>
     *     <li>Inside the loop, it shifts elements towards the right
     *     by assigning {@code array[(j - 1)]} to {@code array[j]} and decrements {@code j}.</li>
     *     <li>After the loop ends, it assigns the {@code select} element to {@code array[j]},
     *     placing it at the correct position in the sorted sequence.</li>
     *     <li>The process continues until all elements in the specified range have been processed.</li>
     * </ul>
     * {@code insertion} method uses the insertion sort algorithm
     * to sort a portion of the array (from index {@code from} to index {@code to})
     * in ascending order based on the comparison condition provided
     * by the {@code functionalCompareTo} method of the {@code SortFunctional} interface.
     * @param       array to be arranged.
     * @param       from the element from which to start the analysis.
     * @param       to the element to be analyzed.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default void insertion(T[] array, int from, int to, SortFunctional<T> functional) {
        for (int i = from; i <= to; i++) {
            T select = array[i];
            int j = i;
            while ((j > from) && ((array[(j - 1)] != null) && (functional.functionalCompareTo(array[(j - 1)], select)))) {
                array[j] = array[(j - 1)];
                j--;
            }
            array[j] = select;
        }
    }

    /**
     * {@code insertionInc} that performs the Insertion Sort algorithm on a portion of a list of
     * {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an list of {@code Comparable} objects, {@code list}, and an integer index specifying
     *     the starting index of the portion to be sorted.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method uses a {@code for} loop that starts from the given {@code index} and iterates up to the end of the {@code list}.</li>
     *     <li>Inside the loop, the element at index {@code i} is selected and stored in the {@code select} variable.</li>
     *     <li>An integer variable {@code j} is initialized with the value of {@code i}.</li>
     *     <li>A {@code while} loop is used to shift elements to the right and find the correct position for
     *     the {@code select} element within the portion of the list.</li>
     *     <li>The condition {@code (j >= index)} ensures that the {@code while} loop executes as long as the index
     *     is within the specified portion of the list.</li>
     *     <li>The condition {@code list.get(j - index).compareTo(select) > 0}
     *     compares the element at index {@code (j - index)} with the {@code select} element.
     *     If the element at index {@code (j - index)} is greater than the {@code select} element, it needs to be shifted to the right.</li>
     *     <li>Inside the {@code while} loop, the element at index {@code j} is replaced with the element at index {@code (j - index)},
     *     effectively shifting the element to the right.</li>
     *     <li>The index {@code j} is decremented by {@code index} to continue comparing and shifting elements until
     *     the correct position for the {@code select} element is found.</li>
     *     <li>Once the correct position is determined, the {@code select} element is placed at index {@code j}.</li>
     * </ul>
     * {@code insertionInc} method implements the Insertion Sort algorithm on a portion of the given {@code list} of Comparable objects.
     * It iterates over the elements starting from the specified index, compares and shifts elements to the right,
     * and places the selected element at its correct position within the portion of the list.
     * The sorting is done in ascending order.
     * @param       list to be arranged.
     */
    @SuppressWarnings("unchecked")
    default <L extends T> void insertionInc(List<L> list) {
        for (int i = 0; i < list.size(); i++) {
            L select = list.get(i);
            int j = i;
            while ((j >= 1) && (list.get(j - 1).compareTo(select) > 0)) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, select);
        }
    }

    /**
     * {@code insertionDec} that performs the Insertion Sort algorithm on a portion of a list of
     * {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an list of {@code Comparable} objects, {@code list}, and an integer index specifying
     *     the starting index of the portion to be sorted.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method uses a {@code for} loop that starts from the given {@code index} and iterates up to the end of the {@code list}.</li>
     *     <li>Inside the loop, the element at index {@code i} is selected and stored in the {@code select} variable.</li>
     *     <li>An integer variable {@code j} is initialized with the value of {@code i}.</li>
     *     <li>A {@code while} loop is used to shift elements to the right and find the correct position for
     *     the {@code select} element within the portion of the list.</li>
     *     <li>The condition {@code (j >= index)} ensures that the {@code while} loop executes as long as the index
     *     is within the specified portion of the list.</li>
     *     <li>The condition {@code list.get(j - index).compareTo(select) < 0}
     *     compares the element at index {@code (j - index)} with the {@code select} element.
     *     If the element at index {@code (j - index)} is smaller than the {@code select} element, it needs to be shifted to the right.</li>
     *     <li>Inside the {@code while} loop, the element at index {@code j} is replaced with the element at index {@code (j - index)},
     *     effectively shifting the element to the right.</li>
     *     <li>The index {@code j} is decremented by {@code index} to continue comparing and shifting elements until
     *     the correct position for the {@code select} element is found.</li>
     *     <li>Once the correct position is determined, the {@code select} element is placed at index {@code j}.</li>
     * </ul>
     * {@code insertionDec} method implements the Insertion Sort algorithm on a portion of the given {@code list} of Comparable objects.
     * It iterates over the elements starting from the specified index, compares and shifts elements to the right,
     * and places the selected element at its correct position within the portion of the list.
     * The sorting is done in descending order.
     * @param       list to be arranged.
     */
    @SuppressWarnings("unchecked")
    default <L extends T> void insertionDec(List<L> list) {
        for (int i = 0; i < list.size(); i++) {
            L select = list.get(i);
            int j = i;
            while ((j >= 1) && (list.get(j - 1).compareTo(select) < 0)) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, select);
        }
    }

    /**
     * {@code insertion} within an interface.
     * This method takes a list of type {@code List<T>} and an instance of the {@code SortFunctional} interface as parameters.
     * <ul>
     *     <li>The method iterates over the list from index <i>0</i> to the last index {@code (list.size() - 1)}.</li>
     *     <li>For each iteration, it selects an element {@code select} from the list at index {@code i}.</li>
     *     <li>It initializes a variable {@code j} with the value of {@code i}.</li>
     *     <li>It enters a {@code while} loop that continues as long as {@code j} is greater than or equal to <i>1</i> and
     *     the comparison condition in {@code functionalCompareTo} is satisfied between {@code list.get(j - 1)} and {@code select}.</li>
     *     <li>Inside the loop, it shifts elements towards the right
     *     by assigning {@code list.get(j - 1)} to {@code list.get(j)} and decrements {@code j}.</li>
     *     <li>After the loop ends, it assigns the {@code select} element to {@code list.get(j)},
     *     placing it at the correct position in the sorted sequence.</li>
     *     <li>The process continues until all elements in the list have been processed.</li>
     * </ul>
     * {@code insertion} method uses the insertion sort algorithm to sort the list in ascending order based on
     * the comparison condition provided by the {@code functionalCompareTo} method of the {@code SortFunctional} interface.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default <L extends T> void insertion(List<L> list, SortFunctional<T> functional) {
        for (int i = 0; i < list.size(); i++) {
            L select = list.get(i);
            int j = i;
            while ((j >= 1) && (functional.functionalCompareTo(list.get(j - 1), select))) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, select);
        }
    }

    /**
     * {@code insertionInc} that performs the Insertion Sort algorithm on a portion of a list of
     * {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an list of {@code Comparable} objects, {@code list}, and an integer index specifying
     *     the starting index of the portion to be sorted.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method uses a {@code for} loop that starts from the given {@code index} and iterates up to the end of the {@code list}.</li>
     *     <li>Inside the loop, the element at index {@code i} is selected and stored in the {@code select} variable.</li>
     *     <li>An integer variable {@code j} is initialized with the value of {@code i}.</li>
     *     <li>A {@code while} loop is used to shift elements to the right and find the correct position for
     *     the {@code select} element within the portion of the list.</li>
     *     <li>The condition {@code (j >= index)} ensures that the {@code while} loop executes as long as the index
     *     is within the specified portion of the list.</li>
     *     <li>The condition {@code list.get(j - index).compareTo(select) > 0}
     *     compares the element at index {@code (j - index)} with the {@code select} element.
     *     If the element at index {@code (j - index)} is greater than the {@code select} element, it needs to be shifted to the right.</li>
     *     <li>Inside the {@code while} loop, the element at index {@code j} is replaced with the element at index {@code (j - index)},
     *     effectively shifting the element to the right.</li>
     *     <li>The index {@code j} is decremented by {@code index} to continue comparing and shifting elements until
     *     the correct position for the {@code select} element is found.</li>
     *     <li>Once the correct position is determined, the {@code select} element is placed at index {@code j}.</li>
     * </ul>
     * {@code insertionInc} method implements the Insertion Sort algorithm on a portion of the given {@code list} of Comparable objects.
     * It iterates over the elements starting from the specified index, compares and shifts elements to the right,
     * and places the selected element at its correct position within the portion of the list.
     * The sorting is done in ascending order.
     * @param       list to be arranged.
     * @param       from the element from which to start the analysis.
     * @param       to the element to be analyzed.
     */
    @SuppressWarnings("unchecked")
    default <L extends T> void insertionInc(List<L> list, int from, int to) {
        for (int i = from; i <= to; i++) {
            L select = list.get(i);
            int j = i;
            while ((j > from) && ((list.get(j - 1) != null) && (list.get(j - 1).compareTo(select) > 0))) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, select);
        }
    }

    /**
     * {@code insertionDec} that performs the Insertion Sort algorithm on a portion of a list of
     * {@link java.lang.Comparable Comparable} objects.
     * The sorting is done in descending order.
     * <ul>
     *     <li>The method takes in an list of {@code Comparable} objects, {@code list}, and an integer index specifying
     *     the starting index of the portion to be sorted.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method uses a {@code for} loop that starts from the given {@code index} and iterates up to the end of the {@code list}.</li>
     *     <li>Inside the loop, the element at index {@code i} is selected and stored in the {@code select} variable.</li>
     *     <li>An integer variable {@code j} is initialized with the value of {@code i}.</li>
     *     <li>A {@code while} loop is used to shift elements to the right and find the correct position for
     *     the {@code select} element within the portion of the list.</li>
     *     <li>The condition {@code (j >= index)} ensures that the {@code while} loop executes as long as the index
     *     is within the specified portion of the list.</li>
     *     <li>The condition {@code list.get(j - index)].compareTo(select) < 0}
     *     compares the element at index {@code (j - index)} with the {@code select} element.
     *     If the element at index {@code (j - index)} is smaller than the {@code select} element, it needs to be shifted to the right.</li>
     *     <li>Inside the {@code while} loop, the element at index {@code j} is replaced with the element at index {@code (j - index)},
     *     effectively shifting the element to the right.</li>
     *     <li>The index {@code j} is decremented by {@code index} to continue comparing and shifting elements until
     *     the correct position for the {@code select} element is found.</li>
     *     <li>Once the correct position is determined, the {@code select} element is placed at index {@code j}.</li>
     * </ul>
     * {@code insertionDec} method implements the Insertion Sort algorithm on a portion of the given {@code list} of Comparable objects.
     * It iterates over the elements starting from the specified index, compares and shifts elements to the right,
     * and places the selected element at its correct position within the portion of the list.
     * The sorting is done in descending order.
     * @param       list to be arranged.
     * @param       from the element from which to start the analysis.
     * @param       to the element to be analyzed.
     */
    @SuppressWarnings("unchecked")
    default <L extends T> void insertionDec(List<L> list, int from, int to) {
        for (int i = from; i <= to; i++) {
            L select = list.get(i);
            int j = i;
            while ((j > from) && (list.get(j - 1) != null && list.get(j - 1).compareTo(select) < 0)) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, select);
        }
    }

    /**
     * {@code insertion} within an interface. This method takes a list of type {@code List<T>},
     * an integer {@code from} representing the starting index,
     * an integer {@code to} representing the ending index,
     * and an instance of the {@code SortFunctional} interface as parameters.
     * The method implements the insertion sort algorithm using
     * the {@code functionalCompareTo} method provided by the {@code mz.SortFunctional} interface.
     * <ul>
     *     <li>The method iterates over the list {@code from} the from index to the {@code to} index (inclusive).</li>
     *     <li>For each iteration, it selects an element {@code select} from the list at index {@code i}.</li>
     *     <li>It initializes a variable {@code j} with the value of {@code i}.</li>
     *     <li>It enters a while loop that continues as long as {@code j} is greater than {@code from},
     *     {@code list.get(j - 1)} is not null, and the comparison condition in {@code functionalCompareTo}
     *     is satisfied between {@code list.get(j - 1)} and {@code select}.</li>
     *     <li>Inside the loop, it shifts elements towards the right
     *     by assigning {@code list.get(j - 1)} to {@code list.get(j)} and decrements {@code j}.</li>
     *     <li>After the loop ends, it assigns the {@code select} element to {@code list.get(j)},
     *     placing it at the correct position in the sorted sequence.</li>
     *     <li>The process continues until all elements in the specified range have been processed.</li>
     * </ul>
     * {@code insertion} method uses the insertion sort algorithm
     * to sort a portion of the list (from index {@code from} to index {@code to})
     * in ascending order based on the comparison condition provided
     * by the {@code functionalCompareTo} method of the {@code SortFunctional} interface.
     * @param       list to be arranged.
     * @param       from the element from which to start the analysis.
     * @param       to the element to be analyzed.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default <L extends T> void insertion(List<L> list, int from, int to, SortFunctional<T> functional) {
        for (int i = from; i <= to; i++) {
            L select = list.get(i);
            int j = i;
            while ((j > from) && ((list.get(j - 1) != null) && (functional.functionalCompareTo(list.get(j - 1), select)))) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, select);
        }
    }
}