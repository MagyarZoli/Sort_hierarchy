package mz;

/**
 * Insertion Sort is a simple sorting algorithm that builds the final sorted array one element at a time.
 * It works by dividing the array into a sorted portion and an unsorted portion. The algorithm iterates through
 * the unsorted portion and "inserts" each element into its correct position in the sorted portion.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 * @see         mz.Shell
 * @see         mz.Heap
 * @see         mz.WeakHeap
 * @see         mz.TernaryHeap
 * @see         mz.SmoothHeap
 */
public class Insertion
extends SortComparable {

    /**
     * <b>Insertion Sort:</b><br>
     * Is a simple sorting algorithm that builds the final sorted array one element at a time.
     * It works by dividing the array into a sorted portion and an unsorted portion. The algorithm iterates through
     * the unsorted portion and "inserts" each element into its correct position in the sorted portion.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Take the first element from the unsorted portion and consider it as the "selected" element.</li>
     *     <li>Compare the selected element with the elements in the sorted portion, moving from right to left.</li>
     *     <li>Shift the elements in the sorted portion that are larger than the selected element to the right.</li>
     *     <li>Insert the selected element into its correct position in the sorted portion.</li>
     *     <li>Repeat steps 2-5 until all elements in the unsorted portion have been processed.</li>
     * </ol>
     * <b>Note:</b><br>
     * Insertion Sort is called "insertion" because it inserts each element into its appropriate position in the sorted portion.
     * The algorithm effectively builds the sorted array by repeatedly inserting elements in the correct order.
     * It has a time complexity of O(n^2) in the average and worst cases, making it inefficient for large datasets.
     * However, it performs well for small or partially sorted arrays and has the advantage of simplicity
     * and efficiency for small input sizes.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n)</em><br>
     * Average Case Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>Yes</b>
     * @see         mz.Shell#Shell()
     * @see         mz.Heap#Heap()
     * @see         mz.WeakHeap#WeakHeap()
     * @see         mz.TernaryHeap#TernaryHeap()
     * @see         mz.SmoothHeap#SmoothHeap()
     */
    public Insertion() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         mz.Insertion#insertionInc(Comparable[], int)
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        insertionInc(array, 1);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @see         mz.Insertion#insertionDec(Comparable[], int)
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        insertionDec(array, 1);
    }

    /**
     * {@code insertionInc} that performs the Insertion Sort algorithm on a portion of an array of Comparable objects.
     * The sorting is done in ascending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array}, and an integer index specifying
     *     the starting index of the portion to be sorted.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler
     *     warnings related to type safety when using the {@code compareTo} method.</li>
     *     <li>The method uses a {@code for} loop that starts from the given {@code index} and iterates up to the end of the {@code array}.</li>
     *     <li>Inside the loop, the element at index {@code i} is selected and stored in the {@code select} variable.</li>
     *     <li>An integer variable {@code j} is initialized with the value of {@code i}.</li>
     *     <li>A {@code while} loop is used to shift elements to the right and find the correct position for
     *     the {@code select} element within the portion of the array.</li>
     *     <ul>
     *         <li>The condition {@code (j >= index)} ensures that the {@code while} loop executes as long as the index
     *         is within the specified portion of the array.</li>
     *         <li>The condition {@code array[(j - index)].compareTo(select) > 0}
     *         compares the element at index {@code (j - index)} with the {@code select} element.
     *         If the element at index {@code (j - index)} is greater than the {@code select} element, it needs to be shifted to the right.</li>
     *         <li>Inside the {@code while} loop, the element at index {@code j} is replaced with the element at index {@code (j - index)},
     *         effectively shifting the element to the right.</li>
     *         <li>The index {@code j} is decremented by {@code index} to continue comparing and shifting elements until
     *         the correct position for the {@code select} element is found.</li>
     *     </ul>
     *     <li>Once the correct position is determined, the {@code select} element is placed at index {@code j}.</li>
     * </ul>
     * {@code insertionInc} method implements the Insertion Sort algorithm on a portion of the given {@code array} of Comparable objects.
     * It iterates over the elements starting from the specified index, compares and shifts elements to the right,
     * and places the selected element at its correct position within the portion of the array.
     * The sorting is done in ascending order.
     * @param       array to be arranged.
     * @param       index start the examined from the last index of the array.
     * @see         mz.Shell#shellInc(Comparable[])
     */
    @SuppressWarnings("unchecked")
    void insertionInc(Comparable[] array, int index) {
        for (int i = index; i < array.length; i++) {
            Comparable select = array[i];
            int j = i;
            while ((j >= index) && (array[(j - index)].compareTo(select) > 0)) {
                array[j] = array[(j - index)];
                j -= index;
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
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler
     *     warnings related to type safety when using the {@code compareTo} method.</li>
     *     <li>The method uses a {@code for} loop that starts from the given {@code index} and iterates up to the end of the {@code array}.</li>
     *     <li>Inside the loop, the element at index {@code i} is selected and stored in the {@code select} variable.</li>
     *     <li>An integer variable {@code j} is initialized with the value of {@code i}.</li>
     *     <li>A {@code while} loop is used to shift elements to the right and find the correct position for
     *     the {@code select} element within the portion of the array.</li>
     *     <ul>
     *         <li>The condition {@code (j >= index)} ensures that the {@code while} loop executes as long as the index
     *         is within the specified portion of the array.</li>
     *         <li>The condition {@code array[(j - index)].compareTo(select) < 0}
     *         compares the element at index {@code (j - index)} with the {@code select} element.
     *         If the element at index {@code (j - index)} is smaller than the {@code select} element, it needs to be shifted to the right.</li>
     *         <li>Inside the {@code while} loop, the element at index {@code j} is replaced with the element at index {@code (j - index)},
     *         effectively shifting the element to the right.</li>
     *         <li>The index {@code j} is decremented by {@code index} to continue comparing and shifting elements until
     *         the correct position for the {@code select} element is found.</li>
     *     </ul>
     *     <li>Once the correct position is determined, the {@code select} element is placed at index {@code j}.</li>
     * </ul>
     * {@code insertionDec} method implements the Insertion Sort algorithm on a portion of the given {@code array} of Comparable objects.
     * It iterates over the elements starting from the specified index, compares and shifts elements to the right,
     * and places the selected element at its correct position within the portion of the array.
     * The sorting is done in descending order.
     * @param       array to be arranged.
     * @param       index start the examined from the last index of the array.
     * @see         mz.Shell#shellDec(Comparable[])
     */
    @SuppressWarnings("unchecked")
    void insertionDec(Comparable[] array, int index) {
        for (int i = index; i < array.length; i++) {
            Comparable select = array[i];
            int j = i;
            while ((j >= index) && (array[(j - index)].compareTo(select) < 0)) {
                array[j] = array[(j - index)];
                j -= index;
            }
            array[j] = select;
        }
    }
}