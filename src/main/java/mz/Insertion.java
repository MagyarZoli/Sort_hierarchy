package mz;

/**
 * Insertion Sort is a simple sorting algorithm that builds the final sorted array one element at a time.
 * It works by dividing the array into a sorted portion and an unsorted portion. The algorithm iterates through
 * the unsorted portion and "inserts" each element into its correct position in the sorted portion.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class Insertion
extends SortComparable
implements InsertionInterface<Comparable> {

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
     * @see         mz.intro.IntroInsertion#IntroInsertion() IntroInsertion
     * @see         mz.intro.IntroShell#IntroShell() IntroShell
     * @see         mz.Shell#Shell() Shell
     */
    public Insertion() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        insertionInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        insertionDec(array);
    }
}