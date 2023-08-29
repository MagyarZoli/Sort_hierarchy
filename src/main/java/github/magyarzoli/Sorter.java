package github.magyarzoli;

/**
 * The Sorter interface combines the implementations of the SortArray and SortList interfaces.
 * @param       <T> setting of a type based on which the elements can be sorted.
 *              It is not mandatory to specify, additional pre-written subclasses specify the type.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public interface Sorter<T extends Comparable>
extends SortArray<T>, SortList<T> { }