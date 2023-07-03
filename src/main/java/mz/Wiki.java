package mz;

/**
 * Wiki Sort, also known as Block Merge Sort, is an efficient comparison-based sorting algorithm designed to improve upon the performance.
 * Wiki Sort is a stable sorting algorithm, meaning that it preserves the relative order of elements with equal values.
 * It achieves a time complexity of <em>O(n log(n))</em> in the worst case.
 * @since       1.1
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Wiki
extends Merge
implements InsertionInterface<Comparable> {

    /**
     * Block merge size storage.
     */
    protected final int WIKI_BLOCK = 32;

    /**
     * <b>Wiki Sort:</b><br>
     * Also known as Block Merge Sort, is an efficient comparison-based sorting algorithm designed to improve upon the performance.
     * Wiki Sort is a stable sorting algorithm, meaning that it preserves the relative order of elements with equal values.
     * It achieves a time complexity of <em>O(n log(n))</em> in the worst case.<br><br>
     * The key idea behind Wiki Sort is to use a divide-and-conquer approach to sort the array.
     * It divides the array into blocks of elements and sorts each block independently.
     * Then it repeatedly merges the blocks together until the entire array is sorted.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Divide the input array into blocks of a fixed size (often chosen based on the cache size or other hardware considerations).</li>
     *     <li>Sort each block individually using an efficient sorting algorithm, such as Insertion Sort or another divide-and-conquer algorithm.</li>
     *     <li>Merge adjacent pairs of blocks together, repeatedly merging until only one block remains.</li>
     *     <li>Perform a final merge pass to merge the remaining blocks until the entire array is sorted.</li>
     * </ol>
     * <b>Note:</b><br>
     * The merging process in Wiki Sort is where it differs from other sorting algorithms.
     * It uses a clever technique called to efficiently merge the blocks together.
     * Instead of comparing and merging individual elements, it works with entire blocks,
     * reducing the number of comparisons and improving cache efficiency.<br><br>
     * Wiki Sort's performance benefits come from its ability to exploit the data locality of modern computer architectures.
     * By dividing the array into blocks and sorting them independently,
     * it minimizes data movement between levels of the memory hierarchy and takes advantage of cache locality.<br><br>
     * Wiki Sort is a highly efficient and practical sorting algorithm that offers better performance than some traditional sorting algorithms.
     * Its design incorporates techniques to optimize cache usage and minimize the number of comparisons,
     * making it particularly useful for sorting large arrays or datasets with repeated elements.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n log(n))</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>Yes</b>
     * @see         mz.intro.IntroWiki#IntroWiki() IntroWiki
     */
    public Wiki() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        wikiInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        wikiDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        wiki(array, functional);
    }

    /**
     * {@code wikiInc}, is a helper function used in the Wiki Sort algorithm to sort a portion of the input array.
     * <ul>
     *     <li>It assigns the value of {@code array.length} to the variable {@code n}.</li>
     *     <li>It creates a new temporary array called {@code buffer} of size {@code n} to store the merged blocks during the merge operation.</li>
     *     <li>The subsequent for loop divides the portion of the array into blocks of size {@code WIKI_BLOCK}
     *     and performs an incremental insertion sort on each block using the {@code insertionInc} method.
     *     The loop increments i by {@code WIKI_BLOCK} in each iteration to move to the next block.</li>
     *     <li>Once all the blocks have been individually sorted, the {@code mergeInc} method is called to merge the blocks together using the temporary buffer array.
     *     The block size is specified as {@code WIKI_BLOCK}, and the range is from {@code left} to {@code right}.</li>
     * </ul>
     * {@code wikiInc} method is to sort a portion of the input array using incremental insertion sort for small blocks
     * and then perform the merging step using the {@code mergeInc} method.
     * This process is a part of the overall Wiki Sort algorithm, which involves dividing the array into blocks,
     * sorting the blocks, and then merging them to obtain the final sorted array.
     * @param       array to be arranged.
     * @see         mz.Wiki#WIKI_BLOCK
     * @see         mz.InsertionInterface#insertionInc(Comparable[], int, int)
     * @see         mz.MergeInterface#mergeInc(Comparable[], int, int, int)
     */
    protected void wikiInc(Comparable[] array) {
        int n = array.length;
        Comparable[] buffer = new Comparable[n];
        for (int i = 0; i < n; i += WIKI_BLOCK) {
            insertionInc(array, i, (Math.min((i + WIKI_BLOCK), n) - 1));
        }
        mergeInc(array, WIKI_BLOCK, n, buffer);
    }

    /**
     * {@code wikiDec}, is a helper function used in the Wiki Sort algorithm to sort a portion of the input array.
     * <ul>
     *     <li>It assigns the value of {@code array.length} to the variable {@code n}.</li>
     *     <li>It creates a new temporary array called {@code buffer} of size {@code n} to store the merged blocks during the merge operation.</li>
     *     <li>The subsequent for loop divides the portion of the array into blocks of size {@code WIKI_BLOCK}
     *     and performs an incremental insertion sort on each block using the {@code insertionDec} method.
     *     The loop increments i by {@code WIKI_BLOCK} in each iteration to move to the next block.</li>
     *     <li>Once all the blocks have been individually sorted, the {@code mergeDec} method is called to merge the blocks together using the temporary buffer array.
     *     The block size is specified as {@code WIKI_BLOCK}, and the range is from {@code left} to {@code right}.</li>
     * </ul>
     * {@code wikiDec} method is to sort a portion of the input array using incremental insertion sort for small blocks
     * and then perform the merging step using the {@code mergeDec} method.
     * This process is a part of the overall Wiki Sort algorithm, which involves dividing the array into blocks,
     * sorting the blocks, and then merging them to obtain the final sorted array.
     * @param       array to be arranged.
     * @see         mz.Wiki#WIKI_BLOCK
     * @see         mz.InsertionInterface#insertionDec(Comparable[], int, int)
     * @see         mz.MergeInterface#mergeDec(Comparable[], int, int, int)
     */
    protected void wikiDec(Comparable[] array) {
        int n = array.length;
        Comparable[] buffer = new Comparable[n];
        for (int i = 0; i < n; i += WIKI_BLOCK) {
            insertionDec(array, i, (Math.min((i + WIKI_BLOCK), n) - 1));
        }
        mergeDec(array, WIKI_BLOCK, n, buffer);
    }

    /**
     * {@code wiki} method takes an array of {@link java.lang.Comparable Comparable} objects,
     * It also takes a {@code SortFunctional<Comparable>} object representing
     * the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method starts by creating a {@code buffer} array of {@code Comparable} objects with
     *     the same size as the original array {@code array}.
     *     This buffer array will be used during the merging process.</li>
     *     <li>Next, the method enters a {@code for} loop
     *     that starts from {@code i = 0} and increments {@code i} by {@code WIKI_BLOCK} in each iteration.
     *     This loop is responsible for performing insertion sort on small blocks of size {@code WIKI_BLOCK}.
     *     The insertion method used to sort the elements within each block individually using the provided comparison logic.</li>
     *     <li>After sorting each block, the {@code merge} method is called to merge the sorted blocks back into the original array.
     *     The {@code merge} method takes the original array, the block size {@code WIKI_BLOCK},
     *     the right index, the buffer array, and the comparison logic.
     *     The {@code merge} method implements the merging logic of merge sort,
     *     combining sorted subarrays into a larger sorted subarray.</li>
     * </ul>
     * {@code wiki} method is to sort a portion of the input array using incremental insertion sort for small blocks
     * and then perform the merging step using the {@code merge} method.
     * This process is a part of the overall Wiki Sort algorithm, which involves dividing the array into blocks,
     * sorting the blocks, and then merging them to obtain the final sorted array.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.Wiki#WIKI_BLOCK
     * @see         mz.InsertionInterface#insertion(Comparable[], int, int, SortFunctional)
     * @see         mz.MergeInterface#merge(Comparable[], int, int, Comparable[], SortFunctional)
     */
    protected void wiki(Comparable[] array, SortFunctional<Comparable> functional) {
        int n = array.length;
        Comparable[] buffer = new Comparable[n];
        for (int i = 0; i < n; i += WIKI_BLOCK) {
            insertion(array, i, (Math.min((i + WIKI_BLOCK), n) - 1), functional);
        }
        merge(array, WIKI_BLOCK, n, buffer, functional);
    }

    /**
     * {@code wikiInc}, is a helper function used in the Wiki Sort algorithm to sort a portion of the input array.
     * <ul>
     *     <li>It assigns the value of {@code right} (the index of the rightmost element in
     *     the current portion of the array being sorted) to the variable {@code right}.</li>
     *     <li>It creates a new temporary array called {@code buffer} of size {@code n} to store the merged blocks during the merge operation.</li>
     *     <li>The subsequent for loop divides the portion of the array into blocks of size {@code WIKI_BLOCK}
     *     and performs an incremental insertion sort on each block using the {@code insertionInc} method.
     *     The loop increments i by {@code WIKI_BLOCK} in each iteration to move to the next block.</li>
     *     <li>Once all the blocks have been individually sorted, the {@code mergeInc} method is called to merge the blocks together using the temporary buffer array.
     *     The block size is specified as {@code WIKI_BLOCK}, and the range is from {@code left} to {@code right}.</li>
     * </ul>
     * {@code wikiInc} method is to sort a portion of the input array using incremental insertion sort for small blocks
     * and then perform the merging step using the {@code mergeInc} method.
     * This process is a part of the overall Wiki Sort algorithm, which involves dividing the array into blocks,
     * sorting the blocks, and then merging them to obtain the final sorted array.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.Wiki#WIKI_BLOCK
     * @see         mz.InsertionInterface#insertionInc(Comparable[], int, int)
     * @see         mz.MergeInterface#mergeInc(Comparable[], int, int, int)
     */
    protected void wikiInc(Comparable[] array, int left, int right) {
        Comparable[] buffer = new Comparable[right];
        for (int i = left; i < right; i += WIKI_BLOCK) {
            insertionInc(array, i, (Math.min((i + WIKI_BLOCK), right) - 1));
        }
        mergeInc(array, WIKI_BLOCK, right, buffer);
    }

    /**
     * {@code wikiDec}, is a helper function used in the Wiki Sort algorithm to sort a portion of the input array.
     * <ul>
     *     <li>It assigns the value of {@code right} (the index of the rightmost element in
     *     the current portion of the array being sorted) to the variable {@code right}.</li>
     *     <li>It creates a new temporary array called {@code buffer} of size {@code n} to store the merged blocks during the merge operation.</li>
     *     <li>The subsequent for loop divides the portion of the array into blocks of size {@code WIKI_BLOCK}
     *     and performs an incremental insertion sort on each block using the {@code insertionDec} method.
     *     The loop increments i by {@code WIKI_BLOCK} in each iteration to move to the next block.</li>
     *     <li>Once all the blocks have been individually sorted, the {@code mergeDec} method is called to merge the blocks together using the temporary buffer array.
     *     The block size is specified as {@code WIKI_BLOCK}, and the range is from {@code left} to {@code right}.</li>
     * </ul>
     * {@code wikiDec} method is to sort a portion of the input array using incremental insertion sort for small blocks
     * and then perform the merging step using the {@code mergeDec} method.
     * This process is a part of the overall Wiki Sort algorithm, which involves dividing the array into blocks,
     * sorting the blocks, and then merging them to obtain the final sorted array.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.Wiki#WIKI_BLOCK
     * @see         mz.InsertionInterface#insertionDec(Comparable[], int, int)
     * @see         mz.MergeInterface#mergeDec(Comparable[], int, int, int)
     */
    protected void wikiDec(Comparable[] array, int left, int right) {
        Comparable[] buffer = new Comparable[right];
        for (int i = left; i < right; i += WIKI_BLOCK) {
            insertionDec(array, i, (Math.min((i + WIKI_BLOCK), right) - 1));
        }
        mergeDec(array, WIKI_BLOCK, right, buffer);
    }

    /**
     * {@code wiki} method takes an array of {@link java.lang.Comparable Comparable} objects,
     * along with the left and right indices specifying the range of elements to be sorted.
     * It also takes a {@code SortFunctional<Comparable>} object representing
     * the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method starts by creating a {@code buffer} array of {@code Comparable} objects with
     *     the same size as the original array {@code array}.
     *     This buffer array will be used during the merging process.</li>
     *     <li>Next, the method enters a {@code for} loop
     *     that starts from {@code i = left} and increments {@code i} by {@code WIKI_BLOCK} in each iteration.
     *     This loop is responsible for performing insertion sort on small blocks of size {@code WIKI_BLOCK}.
     *     The insertion method used to sort the elements within each block individually using the provided comparison logic.</li>
     *     <li>After sorting each block, the {@code merge} method is called to merge the sorted blocks back into the original array.
     *     The {@code merge} method takes the original array, the block size {@code WIKI_BLOCK},
     *     the right index, the buffer array, and the comparison logic.
     *     The {@code merge} method implements the merging logic of merge sort,
     *     combining sorted subarrays into a larger sorted subarray.</li>
     * </ul>
     * {@code wiki} method is to sort a portion of the input array using incremental insertion sort for small blocks
     * and then perform the merging step using the {@code merge} method.
     * This process is a part of the overall Wiki Sort algorithm, which involves dividing the array into blocks,
     * sorting the blocks, and then merging them to obtain the final sorted array.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         mz.Wiki#WIKI_BLOCK
     * @see         mz.InsertionInterface#insertion(Comparable[], int, int, SortFunctional)
     * @see         mz.MergeInterface#merge(Comparable[], int, int, Comparable[], SortFunctional)
     */
    protected void wiki(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        Comparable[] buffer = new Comparable[right];
        for (int i = left; i < right; i += WIKI_BLOCK) {
            insertion(array, i, (Math.min((i + WIKI_BLOCK), right) - 1), functional);
        }
        merge(array, WIKI_BLOCK, right, buffer, functional);
    }
}