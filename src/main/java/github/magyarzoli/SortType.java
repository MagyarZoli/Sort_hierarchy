package github.magyarzoli;

/**
 * You can set the desired sort by specifying sort type.
 * <ul>
 *     <li><i>INCREASING</i> - Puts items in ascending order.</li>
 *     <li><i>DECREASING</i> - Places the elements in descending order.</li>
 *     <li><i>DO_NOT_CHANGE_IT</i> - Does not change the order of the elements!</li>
 *     <li><i>REVERSE_ORDER</i> - It reverses the order of the elements, what was first becomes last.</li>
 * </ul>
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public enum SortType {

    /**
     * Puts items in ascending order.
     */
    INCREASING,

    /**
     * Places the elements in descending order.
     */
    DECREASING,

    /**
     * Does not change the order of the elements!
     */
    DO_NOT_CHANGE_IT,

    /**
     * It reverses the order of the elements, what was first becomes last.
     */
    REVERSE_ORDER,
}