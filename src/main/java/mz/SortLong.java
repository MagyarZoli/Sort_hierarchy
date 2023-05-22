package mz;

/**
 * The inheritors of this abstract class arrange any data type that is Long.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public abstract class SortLong
implements Sort<Long> {

    /**
     * SortLong abstract class modifies the input type.
     * @param       array to be arranged.
     * @param       sequence {@code SortType} you can choose from 4 selectable queue layout types. Order can be specified here, which row arrangement you want to use.
     */
    @Override
    public void sortArray(Long[] array, SortType sequence) {
        Sort.super.sortArray(array, sequence);
    }

    /**
     * Iterates through the array elements and selects the largest/last element.
     * @param       array to be arranged.
     * @return      largest/last element.
     */
    Long findMax(Long[] array) {
        Long max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * iterates through the array elements and selects the smallest/first element.
     * @param       array to be arranged.
     * @return      smallest/first element.
     */
    Long findMin(Long[] array) {
        Long min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}