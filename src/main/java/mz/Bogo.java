package mz;

/**
 * Bogo sort is a highly inefficient and random sorting algorithm.
 * It works by repeatedly shuffling the elements of the array randomly and checking if the array is sorted.
 * If it's not sorted, it repeats the process until the elements happen to end up in the correct order.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Bogo
extends Bubble {

    /**
     * <b>Bogo Sort:</b><br>
     * Is a highly inefficient and random sorting algorithm.
     * It works by repeatedly shuffling the elements of the array randomly and checking if the array is sorted.
     * If it's not sorted, it repeats the process until the elements happen to end up in the correct order.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with an unsorted array.</li>
     *     <li>While the array is not sorted:
     *     Shuffle the elements randomly. Check if the array is sorted.
     *     If it is sorted, stop. If it is not sorted, repeat the process.</li>
     * </ol>
     * <b>Note:</b><br>
     * The key idea behind Bogo Sort is that it relies on randomness to eventually generate the correct order.
     * In each iteration, the algorithm randomly permutes the elements of the array, essentially creating a random permutation.
     * It then checks if this permutation is sorted.
     * If it is not, the algorithm repeats the process, shuffling the elements randomly again.<br><br>
     * Bogo Sort has a worst-case and average-case time complexity of <em>O((n + 1)!)</em>,
     * where <em>n</em> is the number of elements in the array.
     * This means the time it takes to sort the array grows factorially with the number of elements.
     * As a result, Bogo Sort is highly inefficient and impractical for sorting large arrays.<br><br>
     * There is no fixed upper bound on the worst-case complexity of Bogo sort because it operates based on random shuffling.
     * In the worst case, the algorithm may keep shuffling indefinitely, resulting in an infinite time complexity.
     * However, on average, the number of iterations required to sort the array grows factorially with the number of elements.<br><br>
     * Bogo sort is not a stable sorting algorithm.
     * Stability refers to the preservation of the relative order of elements with equal values.
     * Since Bogo sort randomly shuffles the elements, it does not guarantee the preservation of the original order of equal elements.<br><br>
     * Due to its poor performance, Bogo Sort is mainly used as an educational example to illustrate
     * the concept of sorting algorithms and to highlight the importance of efficiency in real-world applications.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(∞)</em><br>
     * Best Case Complexity:    <em>O((n + 1)!)</em><br>
     * Average Case Complexity: <em>O((n + 1)!)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>No</b>
     * @see         mz.intro.IntroBogo#IntroBogo() IntroBogo
     */
    public Bogo() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        bogoInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        bogoDec(array);
    }

    /**
     * The {@code bogoInc} method takes an array of {@code Comparable} objects.
     * <ul>
     *     <li>The {@code bogoInc} method uses a while loop that continues until the portion of
     *     the array specified by <i>1</i> and {@code array.length} is sorted in non-decreasing order. In each iteration of the loop,
     *     it calls the {@code isSortedInc} method to check if the array is sorted</li>
     *     <li> If it's not sorted, it calls the {@code shuffle} method to randomize the elements within the specified range.</li>
     * </ul>
     * The {@code bogoInc} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * <b>It is not recommended for practical use, as it has a very high average and worst-case time complexity.</b>
     * @param       array The array to be sorted.
     * @see         mz.Bogo#isSortedInc(Comparable[], int, int)
     * @see         mz.Bogo#shuffle(Comparable[], int, int)
     */
    protected void bogoInc(Comparable[] array) {
        while (!isSortedInc(array)) {
            shuffle(array);
        }
    }

    /**
     * The {@code bogoDec} method takes an array of {@code Comparable} objects.
     * <ul>
     *     <li>The {@code bogoDec} method uses a while loop that continues until the portion of
     *     the array specified by <i>1</i> and {@code array.length} is sorted in non-decreasing order. In each iteration of the loop,
     *     it calls the {@code isSortedInc} method to check if the array is sorted</li>
     *     <li> If it's not sorted, it calls the {@code shuffle} method to randomize the elements within the specified range.</li>
     * </ul>
     * The {@code bogoInc} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * <b>It is not recommended for practical use, as it has a very high average and worst-case time complexity.</b>
     * @param       array The array to be sorted.
     * @see         mz.Bogo#isSortedDec(Comparable[], int, int)
     * @see         mz.Bogo#shuffle(Comparable[], int, int)
     */
    protected void bogoDec(Comparable[] array) {
        while (!isSortedDec(array)) {
            shuffle(array);
        }
    }

    /**
     * The {@code bogoInc} method takes an array of {@code Comparable} objects,
     * as well as the indices {@code left} and {@code right} that specify the range to sort.
     * <ul>
     *     <li>The {@code bogoInc} method uses a while loop that continues until the portion of
     *     the array specified by {@code left} and {@code right} is sorted in non-decreasing order. In each iteration of the loop,
     *     it calls the {@code isSortedInc} method to check if the array is sorted</li>
     *     <li> If it's not sorted, it calls the {@code shuffle} method to randomize the elements within the specified range.</li>
     * </ul>
     * The {@code bogoInc} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * <b>It is not recommended for practical use, as it has a very high average and worst-case time complexity.</b>
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @see         mz.Bogo#isSortedInc(Comparable[], int, int)
     * @see         mz.Bogo#shuffle(Comparable[], int, int)
     */
    protected void bogoInc(Comparable[] array, int left, int right) {
        while (!isSortedInc(array, left, right)) {
            shuffle(array, left, right);
        }
    }

    /**
     * The {@code bogoDec} method takes an array of {@code Comparable} objects,
     * as well as the indices {@code left} and {@code right} that specify the range to sort.
     * <ul>
     *     <li>The {@code bogoDec} method uses a while loop that continues until the portion of
     *     the array specified by {@code left} and {@code right} is sorted in non-decreasing order. In each iteration of the loop,
     *     it calls the {@code isSortedInc} method to check if the array is sorted</li>
     *     <li> If it's not sorted, it calls the {@code shuffle} method to randomize the elements within the specified range.</li>
     * </ul>
     * The {@code bogoInc} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * <b>It is not recommended for practical use, as it has a very high average and worst-case time complexity.</b>
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @see         mz.Bogo#isSortedDec(Comparable[], int, int)
     * @see         mz.Bogo#shuffle(Comparable[], int, int)
     */
    protected void bogoDec(Comparable[] array, int left, int right) {
        while (!isSortedDec(array, left, right)) {
            shuffle(array, left, right);
        }
    }

    /**
     * {@code isSortedInc} that checks if a portion of an array is sorted in non-decreasing order.
     * The method takes an array of {@code Comparable} objects, as well as
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}
     *     annotation is used to suppress unchecked warnings
     *     that may arise due to using {@link java.lang.Comparable Comparable} objects
     *     in Java without specifying their concrete type.
     *     This annotation tells the compiler to ignore these warnings.</li>
     *     <li>The {@code isSortedInc} method starts iterating from index <i>1</i> up to {@code (array.length)}.
     *     Within each iteration, it compares the current element {@code array[i]} with the previous element {@code array[(i - 1)]}.</li>
     *     <li>the comparison shows that the current element is smaller than the previous one
     *     (as determined by the {@link java.lang.Comparable#compareTo(Object) compareTo} method),
     *     it means the array is not sorted in non-decreasing order, and the method returns {@code false}.
     *     If the loop completes without finding any out-of-order elements,
     *     it means the array is sorted, and the method returns {@code true}.</li>
     * </ul>
     * @param       array The array to be sorted.
     * @return      array order if it is ordered, {@code true} if not then {@code false}.
     */
    @SuppressWarnings("unchecked")
    protected boolean isSortedInc(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[(i - 1)].compareTo(array[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@code isSortedDec} that checks if a portion of an array is sorted in non-decreasing order.
     * The method takes an array of {@code Comparable} objects, as well as
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}
     *     annotation is used to suppress unchecked warnings
     *     that may arise due to using {@link java.lang.Comparable Comparable} objects
     *     in Java without specifying their concrete type.
     *     This annotation tells the compiler to ignore these warnings.</li>
     *     <li>The {@code isSortedInc} method starts iterating from index <i>1</i> up to {@code (array.length)}.
     *     Within each iteration, it compares the current element {@code array[i]} with the previous element {@code array[(i - 1)]}.</li>
     *     <li>the comparison shows that the current element is greater than the previous one
     *     (as determined by the {@link java.lang.Comparable#compareTo(Object) compareTo} method),
     *     it means the array is not sorted in non-decreasing order, and the method returns {@code false}.
     *     If the loop completes without finding any out-of-order elements,
     *     it means the array is sorted, and the method returns {@code true}.</li>
     * </ul>
     * @param       array The array to be sorted.
     * @return      array order if it is ordered, {@code true} if not then {@code false}.
     */
    @SuppressWarnings("unchecked")
    protected boolean isSortedDec(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[(i - 1)].compareTo(array[i]) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@code isSortedInc} that checks if a portion of an array is sorted in non-decreasing order.
     * The method takes an array of {@code Comparable} objects, as well as
     * the indices {@code left} and {@code right} that specify the range to check.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}
     *     annotation is used to suppress unchecked warnings
     *     that may arise due to using {@link java.lang.Comparable Comparable} objects
     *     in Java without specifying their concrete type.
     *     This annotation tells the compiler to ignore these warnings.</li>
     *     <li>The {@code isSortedInc} method starts iterating from index {@code (left + 1)} up to {@code (right - 1)}.
     *     Within each iteration, it compares the current element {@code array[i]} with the previous element {@code array[(i - 1)]}.</li>
     *     <li>the comparison shows that the current element is smaller than the previous one
     *     (as determined by the {@link java.lang.Comparable#compareTo(Object) compareTo} method),
     *     it means the array is not sorted in non-decreasing order, and the method returns {@code false}.
     *     If the loop completes without finding any out-of-order elements,
     *     it means the array is sorted, and the method returns {@code true}.</li>
     * </ul>
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @return      array order if it is ordered, {@code true} if not then {@code false}.
     */
    @SuppressWarnings("unchecked")
    protected boolean isSortedInc(Comparable[] array, int left, int right) {
        for (int i = (left + 1); i < right; i++) {
            if (array[(i - 1)].compareTo(array[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@code isSortedDec} that checks if a portion of an array is sorted in non-decreasing order.
     * The method takes an array of {@code Comparable} objects, as well as
     * the indices {@code left} and {@code right} that specify the range to check.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}
     *     annotation is used to suppress unchecked warnings
     *     that may arise due to using {@link java.lang.Comparable Comparable} objects
     *     in Java without specifying their concrete type.
     *     This annotation tells the compiler to ignore these warnings.</li>
     *     <li>The {@code isSortedInc} method starts iterating from index {@code (left + 1)} up to {@code (right - 1)}.
     *     Within each iteration, it compares the current element {@code array[i]} with the previous element {@code array[(i - 1)]}.</li>
     *     <li>the comparison shows that the current element is greater than the previous one
     *     (as determined by the {@link java.lang.Comparable#compareTo(Object) compareTo} method),
     *     it means the array is not sorted in non-decreasing order, and the method returns {@code false}.
     *     If the loop completes without finding any out-of-order elements,
     *     it means the array is sorted, and the method returns {@code true}.</li>
     * </ul>
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @return      array order if it is ordered, {@code true} if not then {@code false}.
     */
    @SuppressWarnings("unchecked")
    protected boolean isSortedDec(Comparable[] array, int left, int right) {
        for (int i = (left + 1); i < right; i++) {
            if (array[(i - 1)].compareTo(array[i]) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@code shuffle} method uses a loop to iterate over the elements of
     * the array starting from index <i>1</i> up to {@code (array.length)}.
     * Within each iteration, it calls the {@code swap} method to exchange the current element with a
     * randomly chosen element from the range {@code (1, array.length)}.
     * <ul>
     *     <li>{@code for (int i = 1; i < array.length; i++)}
     *     in the for loop, the {@code swap} method is called,
     *     which swaps the {@code i} index of the array array and the ({@link java.lang.Math#random() Math.random()}  {@code * i}) index.</li>
     * </ul>
     * {@code shuffle} method shuffles the elements in a random order by repeatedly selecting a random index within
     * the range (<i>1</i>, {@code i}) and swapping it with the element at index {@code i}.
     * This algorithm ensures that each element in the range has an equal probability of ending up at any position within the range.
     * @param       array The array to be sorted.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    protected void shuffle(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            swap(array, i, ((int) (Math.random() * i)));
        }
    }

    /**
     * {@code shuffle} method uses a loop to iterate over the elements of
     * the array starting from index {@code (left + 1)} up to {@code (right - 1)}.
     * Within each iteration, it calls the {@code swap} method to exchange the current element with a
     * randomly chosen element from the range {@code (left, i)}.
     * <ul>
     *     <li>{@code for (int i = (left + 1); i < right; i++)}
     *     in the for loop, the {@code swap} method is called,
     *     which swaps the {@code i} index of the array array and the ({@link java.lang.Math#random() Math.random()}  {@code * i}) index.</li>
     * </ul>
     * {@code shuffle} method shuffles the elements in a random order by repeatedly selecting a random index within
     * the range ({@code left}, {@code i}) and swapping it with the element at index {@code i}.
     * This algorithm ensures that each element in the range has an equal probability of ending up at any position within the range.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    protected void shuffle(Comparable[] array, int left, int right) {
        for (int i = (left + 1); i < right; i++) {
            swap(array, i, ((int) (Math.random() * i)));
        }
    }
}