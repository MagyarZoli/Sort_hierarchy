package mz;

/**
 * The inheritors of this abstract class arrange any data type that is Long.
 * @since 1.0
 * @author <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public abstract class SortLong
implements Sort<Long>{

    /**
     * For additional methods to store the elements of the specified array in an array.
     * @see SortLong#sortArray(Long[], SortType)
     * @see SortLong#findMax()
     * @see SortLong#findMin()
     */
    private Long[] smooth;

    /**
     * SortLong abstract class modifies the input type.
     * @param array to be arranged.
     * @param sequence {@code SortType} you can choose from 4 selectable queue layout types. Order can be specified here, which row arrangement you want to use.
     */
    @Override
    public void sortArray(Long[] array, SortType sequence) {
        this.smooth = array;
        Sort.super.sortArray(array, sequence);
    }

    /**
     * Iterates through the array elements and selects the largest/last element.
     * @return largest/last element.
     */
    Long findMax() {
        Long max = smooth[0];
        for (int i = 1; i < smooth.length; i++) {
            if (smooth[i] > max) {
                max = smooth[i];
            }
        }
        return max;
    }

    /**
     * iterates through the array elements and selects the smallest/first element.
     * @return smallest/first element.
     */
    Long findMin() {
        Long min = smooth[0];
        for (int i = 1; i < smooth.length; i++) {
            if (smooth[i] < min) {
                min = smooth[i];
            }
        }
        return min;
    }
}