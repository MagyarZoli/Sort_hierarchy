package mz;

import java.util.List;
import java.util.Random;

/**
 * Bozo sort is a highly inefficient and random sorting algorithm.
 * It works by repeatedly shuffling the elements of the array randomly and checking if the array is sorted.
 * If it's not sorted, it repeats the process until the elements happen to end up in the correct order.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Bozo
extends Bogo {

    /**
     * <b>Bozo Sort:</b><br>
     * Is a highly inefficient and random sorting algorithm.
     * It works by repeatedly shuffling the elements of the array randomly and checking if the array is sorted.
     * If it's not sorted, it repeats the process until the elements happen to end up in the correct order.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with an unsorted array.</li>
     *     <li>While the array is not sorted:
     *     Swapping the elements at the given indices in the array. Check if the array is sorted.
     *     If it is sorted, stop. If it is not sorted, repeat the process.</li>
     * </ol>
     * <b>Note:</b><br>
     * The key idea behind Bozo Sort is that it relies on randomness to eventually generate the correct order.
     * In each iteration, the algorithm randomly permutes the elements of the array, essentially creating a random permutation.
     * It then checks if this permutation is sorted.
     * If it is not, the algorithm repeats the process, shuffling the elements randomly again.<br><br>
     * Bozo Sort has a worst-case and average-case time complexity of <em>O((n + 1)!)</em>,
     * where <em>n</em> is the number of elements in the array.
     * This means the time it takes to sort the array grows factorially with the number of elements.
     * As a result, Bozo Sort is highly inefficient and impractical for sorting large arrays.<br><br>
     * There is no fixed upper bound on the worst-case complexity of Bogo sort because it operates based on random shuffling.
     * In the worst case, the algorithm may keep shuffling indefinitely, resulting in an infinite time complexity.
     * However, on average, the number of iterations required to sort the array grows factorially with the number of elements.<br><br>
     * Bozo sort is not a stable sorting algorithm.
     * Stability refers to the preservation of the relative order of elements with equal values.
     * Since Bozo sort randomly shuffles the elements, it does not guarantee the preservation of the original order of equal elements.<br><br>
     * Due to its poor performance, Bozo Sort is mainly used as an educational example to illustrate
     * the concept of sorting algorithms and to highlight the importance of efficiency in real-world applications.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(∞)</em><br>
     * Best Case Complexity:    <em>O((n + 1)!)</em><br>
     * Average Case Complexity: <em>O((n + 1)!)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>No</b>
     * @see         mz.intro.IntroBozo#IntroBozo() IntroBozo
     */
    public Bozo() {}

    /**
     * The {@code bogoInc} method takes an array of {@link java.lang.Comparable Comparable} objects.
     * <ul>
     *     <li>The {@code bogoInc} method uses a while loop that continues until the portion of
     *     the array specified by <i>1</i> and {@code array.length} is sorted in non-decreasing order. In each iteration of the loop,
     *     it calls the {@code isSortedInc} method to check if the array is sorted</li>
     *     <li> If it's not sorted, it calls the {@code shuffleIndex} method to randomize the elements within the specified range.</li>
     * </ul>
     * The {@code bogoInc} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * <b>It is not recommended for practical use, as it has a very high average and worst-case time complexity.</b>
     * @param       array The array to be sorted.
     * @see         mz.Bogo#isSortedInc(Comparable[], int, int)
     * @see         mz.Bozo#shuffleIndex(Comparable[])
     */
    @Override
    protected void bogoInc(Comparable[] array) {
        while (!isSortedInc(array)) {
            shuffleIndex(array);
        }
    }

    /**
     * The {@code bogoDec} method takes an array of {@link java.lang.Comparable Comparable} objects.
     * <ul>
     *     <li>The {@code bogoDec} method uses a while loop that continues until the portion of
     *     the array specified by <i>1</i> and {@code array.length} is sorted in non-decreasing order. In each iteration of the loop,
     *     it calls the {@code isSortedInc} method to check if the array is sorted</li>
     *     <li> If it's not sorted, it calls the {@code shuffleIndex} method to randomize the elements within the specified range.</li>
     * </ul>
     * The {@code bogoInc} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * <b>It is not recommended for practical use, as it has a very high average and worst-case time complexity.</b>
     * @param       array The array to be sorted.
     * @see         mz.Bogo#isSortedDec(Comparable[], int, int)
     * @see         mz.Bozo#shuffleIndex(Comparable[])
     */
    @Override
    protected void bogoDec(Comparable[] array) {
        while (!isSortedDec(array)) {
            shuffleIndex(array);
        }
    }

    /**
     * The {@code bogo} method takes an array of {@link java.lang.Comparable Comparable} objects,
     * It also takes a {@code SortFunctional<Comparable>} object representing the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method enters a while loop that continues until the {@code isSorted} method returns {@code true},
     *     indicating that the array is sorted.</li>
     *     <li>Inside the loop, the {@code shuffleIndex} method is called to randomly shuffle
     *     the elements of the array within the specified range.</li>
     * </ul>
     * The {@code bogo} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * @param       array The array to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         mz.Bogo#isSorted(Comparable[], SortFunctional)
     * @see         mz.Bozo#shuffleIndex(Comparable[])
     */
    @Override
    protected void bogo(Comparable[] array, SortFunctional<Comparable> functional) {
        while (!isSorted(array, functional)) {
            shuffleIndex(array);
        }
    }

    /**
     * The {@code bogoInc} method takes an array of {@link java.lang.Comparable Comparable} objects,
     * as well as the indices {@code left} and {@code right} that specify the range to sort.
     * <ul>
     *     <li>The {@code bogoInc} method uses a while loop that continues until the portion of
     *     the array specified by {@code left} and {@code right} is sorted in non-decreasing order. In each iteration of the loop,
     *     it calls the {@code isSortedInc} method to check if the array is sorted</li>
     *     <li> If it's not sorted, it calls the {@code shuffleIndex} method to randomize the elements within the specified range.</li>
     * </ul>
     * The {@code bogoInc} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * <b>It is not recommended for practical use, as it has a very high average and worst-case time complexity.</b>
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @see         mz.Bogo#isSortedInc(Comparable[], int, int)
     * @see         mz.Bozo#shuffleIndex(Comparable[], int, int)
     */
    @Override
    protected void bogoInc(Comparable[] array, int left, int right) {
        while (!isSortedInc(array, left, right)) {
            shuffleIndex(array, left, right);
        }
    }

    /**
     * The {@code bogoDec} method takes an array of {@link java.lang.Comparable Comparable} objects,
     * as well as the indices {@code left} and {@code right} that specify the range to sort.
     * <ul>
     *     <li>The {@code bogoDec} method uses a while loop that continues until the portion of
     *     the array specified by {@code left} and {@code right} is sorted in non-decreasing order. In each iteration of the loop,
     *     it calls the {@code isSortedInc} method to check if the array is sorted</li>
     *     <li> If it's not sorted, it calls the {@code shuffleIndex} method to randomize the elements within the specified range.</li>
     * </ul>
     * The {@code bogoInc} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * <b>It is not recommended for practical use, as it has a very high average and worst-case time complexity.</b>
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @see         mz.Bogo#isSortedDec(Comparable[], int, int)
     * @see         mz.Bozo#shuffleIndex(Comparable[], int, int)
     */
    @Override
    protected void bogoDec(Comparable[] array, int left, int right) {
        while (!isSortedDec(array, left, right)) {
            shuffleIndex(array, left, right);
        }
    }

    /**
     * The {@code bogo} method takes an array of {@link java.lang.Comparable Comparable} objects,
     * along with the {@code left} and {@code right} indices specifying the range of elements to be sorted.
     * It also takes a {@code SortFunctional<Comparable>} object representing the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method enters a while loop that continues until the {@code isSorted} method returns {@code true},
     *     indicating that the array is sorted.</li>
     *     <li>Inside the loop, the {@code shuffleIndex} method is called to randomly shuffle
     *     the elements of the array within the specified range.</li>
     * </ul>
     * The {@code bogo} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         mz.Bogo#isSorted(Comparable[], int, int, SortFunctional)
     * @see         mz.Bozo#shuffleIndex(Comparable[], int, int)
     */
    @Override
    protected void bogo(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        while (!isSorted(array, left, right, functional)) {
            shuffleIndex(array, left, right);
        }
    }

    /**
     * The {@code bogoInc} method takes a list of {@link java.lang.Comparable Comparable} objects.
     * <ul>
     *     <li>The {@code bogoInc} method uses a while loop that continues until the portion of
     *     the list specified by <i>1</i> and {@code list.size()} is sorted in non-decreasing order. In each iteration of the loop,
     *     it calls the {@code isSortedInc} method to check if the list is sorted</li>
     *     <li> If it's not sorted, it calls the {@code shuffleIndex} method to randomize the elements within the specified range.</li>
     * </ul>
     * The {@code bogoInc} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * <b>It is not recommended for practical use, as it has a very high average and worst-case time complexity.</b>
     * @param       list The list to be sorted.
     * @see         mz.Bogo#isSortedInc(List, int, int)
     * @see         mz.Bozo#shuffleIndex(List)
     */
    @Override
    protected <L extends Comparable> void bogoInc(List<L> list) {
        while (!isSortedInc(list)) {
            shuffleIndex(list);
        }
    }

    /**
     * The {@code bogoDec} method takes a list of {@link java.lang.Comparable Comparable} objects.
     * <ul>
     *     <li>The {@code bogoDec} method uses a while loop that continues until the portion of
     *     the list specified by <i>1</i> and {@code list.size()} is sorted in non-decreasing order. In each iteration of the loop,
     *     it calls the {@code isSortedInc} method to check if the list is sorted</li>
     *     <li> If it's not sorted, it calls the {@code shuffleIndex} method to randomize the elements within the specified range.</li>
     * </ul>
     * The {@code bogoInc} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * <b>It is not recommended for practical use, as it has a very high average and worst-case time complexity.</b>
     * @param       list The list to be sorted.
     * @see         mz.Bogo#isSortedDec(List, int, int)
     * @see         mz.Bozo#shuffleIndex(List)
     */
    @Override
    protected <L extends Comparable> void bogoDec(List<L> list) {
        while (!isSortedDec(list)) {
            shuffleIndex(list);
        }
    }

    /**
     * The {@code bogo} method takes a list of {@link java.lang.Comparable Comparable} objects,
     * It also takes a {@code SortFunctional<Comparable>} object representing the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method enters a while loop that continues until the {@code isSorted} method returns {@code true},
     *     indicating that the list is sorted.</li>
     *     <li>Inside the loop, the {@code shuffleIndex} method is called to randomly shuffle
     *     the elements of the list within the specified range.</li>
     * </ul>
     * The {@code bogo} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * @param       list The list to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         mz.Bogo#isSorted(List, SortFunctional)
     * @see         mz.Bozo#shuffleIndex(List)
     */
    @Override
    protected <L extends Comparable> void bogo(List<L> list, SortFunctional<Comparable> functional) {
        while (!isSorted(list, functional)) {
            shuffleIndex(list);
        }
    }

    /**
     * The {@code bogoInc} method takes a list of {@link java.lang.Comparable Comparable} objects,
     * as well as the indices {@code left} and {@code right} that specify the range to sort.
     * <ul>
     *     <li>The {@code bogoInc} method uses a while loop that continues until the portion of
     *     the list specified by {@code left} and {@code right} is sorted in non-decreasing order. In each iteration of the loop,
     *     it calls the {@code isSortedInc} method to check if the list is sorted</li>
     *     <li> If it's not sorted, it calls the {@code shuffleIndex} method to randomize the elements within the specified range.</li>
     * </ul>
     * The {@code bogoInc} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * <b>It is not recommended for practical use, as it has a very high average and worst-case time complexity.</b>
     * @param       list The list to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @see         mz.Bogo#isSortedInc(List, int, int)
     * @see         mz.Bozo#shuffleIndex(List, int, int)
     */
    @Override
    protected <L extends Comparable> void bogoInc(List<L> list, int left, int right) {
        while (!isSortedInc(list, left, right)) {
            shuffleIndex(list, left, right);
        }
    }

    /**
     * The {@code bogoDec} method takes a list of {@link java.lang.Comparable Comparable} objects,
     * as well as the indices {@code left} and {@code right} that specify the range to sort.
     * <ul>
     *     <li>The {@code bogoDec} method uses a while loop that continues until the portion of
     *     the list specified by {@code left} and {@code right} is sorted in non-decreasing order. In each iteration of the loop,
     *     it calls the {@code isSortedInc} method to check if the list is sorted</li>
     *     <li> If it's not sorted, it calls the {@code shuffleIndex} method to randomize the elements within the specified range.</li>
     * </ul>
     * The {@code bogoInc} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * <b>It is not recommended for practical use, as it has a very high average and worst-case time complexity.</b>
     * @param       list The list to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @see         mz.Bogo#isSortedDec(List, int, int)
     * @see         mz.Bozo#shuffleIndex(List, int, int)
     */
    @Override
    protected <L extends Comparable> void bogoDec(List<L> list, int left, int right) {
        while (!isSortedDec(list, left, right)) {
            shuffleIndex(list, left, right);
        }
    }

    /**
     * The {@code bogo} method takes a list of {@link java.lang.Comparable Comparable} objects,
     * along with the {@code left} and {@code right} indices specifying the range of elements to be sorted.
     * It also takes a {@code SortFunctional<Comparable>} object representing the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method enters a while loop that continues until the {@code isSorted} method returns {@code true},
     *     indicating that the list is sorted.</li>
     *     <li>Inside the loop, the {@code shuffleIndex} method is called to randomly shuffle
     *     the elements of the list within the specified range.</li>
     * </ul>
     * The {@code bogo} algorithm is not an efficient sorting algorithm and has a high time complexity.
     * It repeatedly shuffles the elements randomly and checks if they are sorted until they eventually end up in the correct order.<br>
     * @param       list The list to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         mz.Bogo#isSorted(List, int, int, SortFunctional)
     * @see         mz.Bozo#shuffleIndex(List, int, int)
     */
    @Override
    protected <L extends Comparable> void bogo(List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        while (!isSorted(list, left, right, functional)) {
            shuffleIndex(list, left, right);
        }
    }

    /**
     * {@code shuffleIndex} method you provided shuffles.
     * <ul>
     *     <li>Create a new {@link java.util.Random Random} object to generate random numbers</li>
     *     <li>Generate two random indices within the value {@code array.length}:</li>
     *     <li>The {@link java.util.Random#nextInt(int) nextInt(int bound)} method of Random generates
     *     a random integer between <i>0</i> (inclusive) and bound (exclusive).
     *     In this case,
     *     so the generated indices will be within the range (<i>0</i>, {@code array.length}).
     *     By adding left to the generated random numbers.</li>
     *     <li>Swap the elements at {@code index1} and {@code index2} in the {@code array}.
     *     The {@code swap} method is responsible for swapping the elements at the given indices in the array.</li>
     * </ul>
     * shuffleIndex this method selects two random indices within
     * the specified range and then swaps the corresponding elements in the array.
     * This operation effectively shuffles the elements between left and right (exclusive).
     * @param       array The array to be sorted.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    protected void shuffleIndex(Comparable[] array) {
        Random random = new Random();
        int index1 = random.nextInt(array.length),
                index2 = random.nextInt(array.length);
        swap(array, index1, index2);
    }

    /**
     * {@code shuffleIndex} method you provided shuffles
     * the elements of a given array between the indices {@code left} and {@code right}.
     * <ul>
     *     <li>Create a new {@link java.util.Random Random} object to generate random numbers</li>
     *     <li>Generate two random indices within the range ({@code left}, {@code right}):</li>
     *     <li>The {@link java.util.Random#nextInt(int) nextInt(int bound)} method of Random generates
     *     a random integer between <i>0</i> (inclusive) and bound (exclusive).
     *     In this case, bound is {@code (right - left)},
     *     so the generated indices will be within the range (<i>0</i>, {@code (right - left)}).
     *     By adding left to the generated random numbers, we shift the range to ({@code left}, {@code right}).</li>
     *     <li>Swap the elements at {@code index1} and {@code index2} in the {@code array}.
     *     The {@code swap} method is responsible for swapping the elements at the given indices in the array.</li>
     * </ul>
     * shuffleIndex this method selects two random indices within
     * the specified range and then swaps the corresponding elements in the array.
     * This operation effectively shuffles the elements between left and right (exclusive).
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    protected void shuffleIndex(Comparable[] array, int left, int right) {
        Random random = new Random();
        int index1 = (random.nextInt((right - left)) + left),
                index2 = (random.nextInt((right - left)) + left);
        swap(array, index1, index2);
    }

    /**
     * {@code shuffleIndex} method you provided shuffles.
     * <ul>
     *     <li>Create a new {@link java.util.Random Random} object to generate random numbers</li>
     *     <li>Generate two random indices within the value {@code list.size()}:</li>
     *     <li>The {@link java.util.Random#nextInt(int) nextInt(int bound)} method of Random generates
     *     a random integer between <i>0</i> (inclusive) and bound (exclusive).
     *     In this case,
     *     so the generated indices will be within the range (<i>0</i>, {@code list.size()}).
     *     By adding left to the generated random numbers.</li>
     *     <li>Swap the elements at {@code index1} and {@code index2} in the {@code list}.
     *     The {@code swap} method is responsible for swapping the elements at the given indices in the list.</li>
     * </ul>
     * shuffleIndex this method selects two random indices within
     * the specified range and then swaps the corresponding elements in the list.
     * This operation effectively shuffles the elements between left and right (exclusive).
     * @param       list The list to be sorted.
     * @see         mz.SortSwap#swap(List, int, int)
     */
    protected <L extends Comparable> void shuffleIndex(List<L> list) {
        Random random = new Random();
        int index1 = random.nextInt(list.size()),
                index2 = random.nextInt(list.size());
        swap(list, index1, index2);
    }

    /**
     * {@code shuffleIndex} method you provided shuffles
     * the elements of a given list between the indices {@code left} and {@code right}.
     * <ul>
     *     <li>Create a new {@link java.util.Random Random} object to generate random numbers</li>
     *     <li>Generate two random indices within the range ({@code left}, {@code right}):</li>
     *     <li>The {@link java.util.Random#nextInt(int) nextInt(int bound)} method of Random generates
     *     a random integer between <i>0</i> (inclusive) and bound (exclusive).
     *     In this case, bound is {@code (right - left)},
     *     so the generated indices will be within the range (<i>0</i>, {@code (right - left)}).
     *     By adding left to the generated random numbers, we shift the range to ({@code left}, {@code right}).</li>
     *     <li>Swap the elements at {@code index1} and {@code index2} in the {@code list}.
     *     The {@code swap} method is responsible for swapping the elements at the given indices in the list.</li>
     * </ul>
     * shuffleIndex this method selects two random indices within
     * the specified range and then swaps the corresponding elements in the list.
     * This operation effectively shuffles the elements between left and right (exclusive).
     * @param       list The list to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (inclusive) of the subarray to be sorted.
     * @see         mz.SortSwap#swap(List, int, int)
     */
    protected <L extends Comparable> void shuffleIndex(List<L> list, int left, int right) {
        Random random = new Random();
        int index1 = (random.nextInt((right - left)) + left),
                index2 = (random.nextInt((right - left)) + left);
        swap(list, index1, index2);
    }
}