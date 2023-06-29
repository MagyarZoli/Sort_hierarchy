package mz;

/**
 * InsertionInterface, containing the methods of Insertion Sort to implement other classes.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public interface InsertionInterface<T extends Comparable>
extends Sort<T> {

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
}