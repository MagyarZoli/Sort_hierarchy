package mz;

import java.util.Arrays;

/**
 * Merge Sort is a comparison-based sorting algorithm that follows the divide-and-conquer approach.
 * It works by dividing the unsorted list into smaller sublists, sorting those sublists recursively,
 * and then merging them back together to obtain a sorted list.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public class Merge
extends SortComparable
implements MergeInterface<Comparable> {

    /**
     * <b>Merge Sort:</b><br>
     * Is a comparison-based sorting algorithm that follows the divide-and-conquer approach.
     * It works by dividing the unsorted list into smaller sublists, sorting those sublists recursively,
     * and then merging them back together to obtain a sorted list.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Divide the unsorted list into two equal-sized sublists.</li>
     *     <li>Recursively sort each sublist by applying Merge Sort to them.</li>
     *     <li>Merge the sorted sublists back together to form a single sorted list.</li>
     *     <ul>
     *         <li>Start with two pointers, one for each sublist, pointing to the beginning of each sublist.</li>
     *         <li>Compare the elements at the pointers and select the smaller (or larger) element to be placed in the merged list.</li>
     *         <li>Move the pointer of the selected element to the next position.</li>
     *         <li>Repeat the comparison and merging process until all elements from both sublists are merged into the final sorted list.</li>
     *     </ul>
     * </ol>
     * <b>Note:</b><br>
     * The key step in Merge Sort is the merging process, where two sorted sublists are combined to form a single sorted list.
     * This process ensures that the elements are appropriately sorted during the merge phase.<br><br>
     * Merge Sort has a time complexity of <em>O(n log(n))</em> in the average and worst cases, where n is the number of elements in the list.
     * It is considered an efficient sorting algorithm and is particularly useful for large datasets.
     * Merge Sort's time complexity remains the same regardless of the input sequence, making it a reliable choice for sorting.<br><br>
     * Merge Sort is a stable sorting algorithm, meaning it maintains the relative order of elements with equal values.
     * It is an in-place algorithm in its purest form, meaning it can sort the elements using only a small, constant amount of additional memory.
     * However, in most practical implementations, it requires auxiliary space proportional to the size of the input list.<br><br>
     * Merge Sort is widely used in various applications due to its stability, efficiency, and ease of implementation.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>Yes</b>
     * @see         mz.intro.IntroMerge#IntroMerge() IntroMerge
     * @see         mz.intro.IntroTim#IntroTim() IntroTim
     * @see         mz.intro.IntroWiki#IntroWiki() IntroWiki
     * @see         mz.Tim#Tim() Tim
     * @see         mz.Wiki#Wiki() Wiki
     */
    public Merge() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        mergeInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        mergeDec(array);
    }
}