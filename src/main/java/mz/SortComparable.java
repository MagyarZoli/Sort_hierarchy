package mz;

/**
 * The inheritors of this abstract class arrange any data type that is Comparable.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 * @see         mz.Quick
 * @see         mz.Quick3
 * @see         mz.Selection
 * @see         mz.DoubleSelection
 * @see         mz.Insertion
 * @see         mz.Heap
 * @see         mz.WeakHeap
 * @see         mz.TernaryHeap
 * @see         mz.SmoothHeap
 * @see         mz.Shell
 * @see         mz.Gnome
 * @see         mz.Bubble
 * @see         mz.Cocktail
 * @see         mz.Comb
 */
public abstract class SortComparable
implements Sort<Comparable> {

    /**
     * SortComparable abstract class modifies the input type.
     * @param       array to be arranged.
     * @param       sequence {@code SortType} you can choose from 4 selectable queue layout types. Order can be specified here, which row arrangement you want to use.
     */
    @Override
    public void sortArray(Comparable[] array, SortType sequence) {
        Sort.super.sortArray(array, sequence);
    }
}