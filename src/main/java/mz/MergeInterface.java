package mz;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * MergeInterface, containing the methods of Merge Sort to implement other classes.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public interface MergeInterface<T extends Comparable>
extends Sorter<T> {

    /**
     * {@code mergeInc} that performs a Merge Sort on an array of {@link java.lang.Comparable Comparable} objects in increasing order.
     * The method recursively divides the array into smaller subarrays, sorts them individually,
     * and then merges them together using the {@code mergingInc} method.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array},
     *     and the indices {@code left} is <i>0</i>, {@code mid} is {@code (array.length / 2)}, and {@code right}
     *     is {@code (array.length - 1)} that define the portion of the array to be sorted.</li>
     *     <li>The condition {@code if (left < right)} checks if the portion of the array has more than one element.
     *     If so, it proceeds with the merge sort algorithm.</li>
     *     <li>Inside the condition, the method recursively calls itself to sort the left and right halves of the portion.</li>
     *     <li>The first recursive call {@code mergeInc(array, left, ((left + mid) / 2), mid)} divides the left half of
     *     the portion by updating the {@code mid} index to be the midpoint between {@code left} and {@code mid}.</li>
     *     <li>The second recursive call {@code mergeInc(array, (mid + 1), (((mid + 1) + right) / 2), right)} divides
     *     the right half of the portion by updating the {@code mid} index to be the midpoint between {@code (mid + 1)} and {@code right}.</li>
     *     <li>After the recursive calls, the {@code mergingInc} method is called to merge the two sorted halves together.
     *     The {@code mergingInc} method takes the {@code array}, {@code left}, {@code mid}, and {@code right} indices as arguments.</li>
     *     <li>The overall effect of the {@code mergeInc} method is to recursively divide the array into smaller subarrays until they consist of individual elements.
     *     Then, it merges and sorts these individual elements to gradually build the sorted array.</li>
     * </ul>
     * {@code mergeInc} this implementation follows the divide-and-conquer strategy of merge sort, where the array is recursively divided into smaller subarrays,
     * sorted individually, and then merged back together.
     * @param       array to be arranged.
     * @see         mz.MergeInterface#mergeInc(Comparable[], int, int, int)
     */
    default void mergeInc(T[] array) {
        mergeInc(array, 0, (array.length / 2), (array.length - 1));
    }

    /**
     * {@code mergeDec} that performs a Merge Sort on an array of {@link java.lang.Comparable Comparable} objects in decreasing order.
     * The method recursively divides the array into smaller subarrays, sorts them individually,
     * and then merges them together using the {@code mergingDec} method.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array},
     *     and the indices {@code left} is <i>0</i>, {@code mid} is {@code (array.length / 2)}, and {@code right}
     *     is {@code (array.length - 1)} that define the portion of the array to be sorted.</li>
     *     <li>The condition {@code if (left < right)} checks if the portion of the array has more than one element.
     *     If so, it proceeds with the merge sort algorithm.</li>
     *     <li>Inside the condition, the method recursively calls itself to sort the left and right halves of the portion.</li>
     *     <li>The first recursive call {@code mergeDec(array, left, ((left + mid) / 2), mid)} divides the left half of
     *     the portion by updating the {@code mid} index to be the midpoint between {@code left} and {@code mid}.</li>
     *     <li>The second recursive call {@code mergeDec(array, (mid + 1), (((mid + 1) + right) / 2), right)} divides
     *     the right half of the portion by updating the {@code mid} index to be the midpoint between {@code (mid + 1)} and {@code right}.</li>
     *     <li>After the recursive calls, the {@code mergingDec} method is called to merge the two sorted halves together.
     *     The {@code mergingDec} method takes the {@code array}, {@code left}, {@code mid}, and {@code right} indices as arguments.</li>
     *     <li>The overall effect of the {@code mergeDec} method is to recursively divide the array into greater subarrays until they consist of individual elements.
     *     Then, it merges and sorts these individual elements to gradually build the sorted array.</li>
     * </ul>
     * {@code mergeDec} this implementation follows the divide-and-conquer strategy of merge sort, where the array is recursively divided into smaller subarrays,
     * sorted individually, and then merged back together.
     * @param       array to be arranged.
     * @see         mz.MergeInterface#mergeDec(Comparable[], int, int, int)
     */
    default void mergeDec(T[] array) {
        mergeDec(array, 0, (array.length / 2), (array.length - 1));
    }

    /**
     * {@code merge} method merge takes an array {@code array},
     * as the {@code mz.SortFunctional} as parameters for custom sorting logic.
     * <ul>
     *     <li>The method begins with a base case check:
     *     if <i>0</i> is less than {@code array.length}, the sorting operation continues.</li>
     *     <li>Inside the base case, the {@code merge} method is recursively called three times:</li>
     *     <li>The first recursive call is made with the indices <i>0</i>, {@code (array.length / 2)}
     *     which splits the left half of the array recursively.</li>
     *     <li>The second recursive call is made with the indices {@code ((array.length / 2) + 1)},
     *     {@code ((((array.length / 2) + 1) + right) / 2)}, {@code array.length},
     *     which splits the right half of the array recursively.</li>
     *     <li>The third recursive call is made to the {@code merging} method with the original indices <i>0</i>, {@code (array.length / 2)}, and {@code array.length}.
     *     This is the merge step where two sorted subarrays (from <i>0</i> to {@code (array.length / 2)}
     *     and from {@code ((array.length / 2) + 1)} to {@code array.length})
     *     are merged into a single sorted array using the provided sorting logic.</li>
     *     <li>The recursion continues until the base case is reached, where <i>0</i> is no longer less than {@code array.length}.
     *     At this point, the recursion unwinds,
     *     and the merge operations are performed for each level of recursion until the original array is completely sorted.</li>
     * </ul>
     * merge two sorted subarrays into a single sorted array according to the intended sorting logic.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.MergeInterface#merge(Comparable[], int, int, int, SortFunctional)
     */
    default void merge(T[] array, SortFunctional<T> functional) {
        merge(array, 0, (array.length / 2), (array.length - 1), functional);
    }

    /**
     * {@code mergeInc} that performs a Merge Sort on an array of {@link java.lang.Comparable Comparable} objects in increasing order.
     * The method recursively divides the array into smaller subarrays, sorts them individually,
     * and then merges them together using the {@code mergingInc} method.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array},
     *     and the indices {@code left}, {@code mid}, and {@code right} that define the portion of the array to be sorted.</li>
     *     <li>The condition {@code if (left < right)} checks if the portion of the array has more than one element.
     *     If so, it proceeds with the merge sort algorithm.</li>
     *     <li>Inside the condition, the method recursively calls itself to sort the left and right halves of the portion.</li>
     *     <li>The first recursive call {@code mergeInc(array, left, ((left + mid) / 2), mid)} divides the left half of
     *     the portion by updating the {@code mid} index to be the midpoint between {@code left} and {@code mid}.</li>
     *     <li>The second recursive call {@code mergeInc(array, (mid + 1), (((mid + 1) + right) / 2), right)} divides
     *     the right half of the portion by updating the {@code mid} index to be the midpoint between {@code (mid + 1)} and {@code right}.</li>
     *     <li>After the recursive calls, the {@code mergingInc} method is called to merge the two sorted halves together.
     *     The {@code mergingInc} method takes the {@code array}, {@code left}, {@code mid}, and {@code right} indices as arguments.</li>
     *     <li>The overall effect of the {@code mergeInc} method is to recursively divide the array into smaller subarrays until they consist of individual elements.
     *     Then, it merges and sorts these individual elements to gradually build the sorted array.</li>
     * </ul>
     * {@code mergeInc} this implementation follows the divide-and-conquer strategy of merge sort, where the array is recursively divided into smaller subarrays,
     * sorted individually, and then merged back together.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     * @see         mz.MergeInterface#mergingInc(Comparable[], int, int, int)
     */
    default void mergeInc(T[] array, int left, int mid, int right) {
        if (left < right) {
            mergeInc(array, left, ((left + mid) / 2), mid);
            mergeInc(array, (mid + 1), (((mid + 1) + right) / 2), right);
            mergingInc(array, left, mid, right);
        }
    }

    /**
     * {@code mergeDec} that performs a Merge Sort on an array of {@link java.lang.Comparable Comparable} objects in decreasing order.
     * The method recursively divides the array into smaller subarrays, sorts them individually,
     * and then merges them together using the {@code mergingDec} method.
     * <ul>
     *     <li>The method takes an array of {@code Comparable} objects, denoted by {@code array},
     *     and the indices {@code left}, {@code mid}, and {@code right} that define the portion of the array to be sorted.</li>
     *     <li>The condition {@code if (left < right)} checks if the portion of the array has more than one element.
     *     If so, it proceeds with the merge sort algorithm.</li>
     *     <li>Inside the condition, the method recursively calls itself to sort the left and right halves of the portion.</li>
     *     <li>The first recursive call {@code mergeDec(array, left, ((left + mid) / 2), mid)} divides the left half of
     *     the portion by updating the {@code mid} index to be the midpoint between {@code left} and {@code mid}.</li>
     *     <li>The second recursive call {@code mergeDec(array, (mid + 1), (((mid + 1) + right) / 2), right)} divides
     *     the right half of the portion by updating the {@code mid} index to be the midpoint between {@code (mid + 1)} and {@code right}.</li>
     *     <li>After the recursive calls, the {@code mergingDec} method is called to merge the two sorted halves together.
     *     The {@code mergingDec} method takes the {@code array}, {@code left}, {@code mid}, and {@code right} indices as arguments.</li>
     *     <li>The overall effect of the {@code mergeDec} method is to recursively divide the array into greater subarrays until they consist of individual elements.
     *     Then, it merges and sorts these individual elements to gradually build the sorted array.</li>
     * </ul>
     * {@code mergeDec} this implementation follows the divide-and-conquer strategy of merge sort, where the array is recursively divided into smaller subarrays,
     * sorted individually, and then merged back together.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     * @see         mz.MergeInterface#mergingDec(Comparable[], int, int, int)
     */
    default void mergeDec(T[] array, int left, int mid, int right) {
        if (left < right) {
            mergeDec(array, left, ((left + mid) / 2), mid);
            mergeDec(array, (mid + 1), (((mid + 1) + right) / 2), right);
            mergingDec(array, left, mid, right);
        }
    }

    /**
     * {@code merge} method merge takes an array {@code array},
     * and the indices {@code left}, {@code mid}, {@code right},
     * as well as the {@code mz.SortFunctional} as parameters for custom sorting logic.
     * <ul>
     *     <li>The method begins with a base case check:
     *     if {@code left} is less than {@code right}, the sorting operation continues.</li>
     *     <li>Inside the base case, the {@code merge} method is recursively called three times:</li>
     *     <li>The first recursive call is made with the indices {@code left}, {@code ((left + mid) / 2)}, {@code mid},
     *     which splits the left half of the array recursively.</li>
     *     <li>The second recursive call is made with the indices {@code (mid + 1)}, {@code (((mid + 1) + right) / 2)}, {@code right},
     *     which splits the right half of the array recursively.</li>
     *     <li>The third recursive call is made to the {@code merging} method with the original indices {@code left}, {@code mid}, and {@code right}.
     *     This is the merge step where two sorted subarrays (from {@code left} to {@code mid} and from {@code (mid + 1)} to {@code right})
     *     are merged into a single sorted array using the provided sorting logic.</li>
     *     <li>The recursion continues until the base case is reached, where {@code left} is no longer less than {@code right}.
     *     At this point, the recursion unwinds,
     *     and the merge operations are performed for each level of recursion until the original array is completely sorted.</li>
     * </ul>
     * merge two sorted subarrays into a single sorted array according to the intended sorting logic.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     * @param       functional lambda expression for comparison.
     * @see         mz.MergeInterface#merging(Comparable[], int, int, int, SortFunctional)
     */
    default void merge(T[] array, int left, int mid, int right, SortFunctional<T> functional) {
        if (left < right) {
            merge(array, left, ((left + mid) / 2), mid, functional);
            merge(array, (mid + 1), (((mid + 1) + right) / 2), right, functional);
            merging(array, left, mid, right, functional);
        }
    }

    /**
     * {@code mergeInc} method for performing an iterative bottom-up merge sort on an array.
     * It divides the array into subarrays of increasing sizesand merges them together until the entire array is sorted.
     * <ul>
     *     <li>This {@code while} loop iterates until the {@code left} index becomes equal to or greater than the {@code right} index,
     *     indicating that the entire array is sorted.</li>
     *     <li>This {@code for} loop iterates through the array in increments of {@code (left * 2)},
     *     effectively dividing the array into subarrays of size {@code (left * 2)} for merging.</li>
     *     <li>This calculates the indices for the merging operation.
     *     {@code mid} represents the midpoint of the current subarray, and
     *     {@code end} represents the ending index of the current subarray or the ending index of the entire array
     *     if it's reached before the subarray size.</li>
     *     <li>This calls the {@code mergingInc} method to merge the subarray defined by the indices
     *     {@code i}, {@code mid}, and {@code end}.</li>
     *     <li>{@code left *= 2} After each iteration of the outer loop, the {@code left} variable is doubled.
     *     This increases the size of the subarrays being merged in the next iteration.</li>
     * </ul>
     * {@code mergeInc} method performs an iterative bottom-up merge sort by repeatedly merging subarrays of
     * increasing sizes until the entire array is sorted.
     * It utilizes the {@code mergingInc} method to perform the merging operation.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @see         mz.MergeInterface#mergingInc(Comparable[], int, int, int)
     */
    default void mergeInc(T[] array, int left, int right) {
        while (left < right) {
            for (int i = 0; i < right; i += (left * 2)) {
                int mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                mergingInc(array, i, mid, end);
            }
            left *= 2;
        }
    }

    /**
     * {@code mergeDec} method for performing an iterative bottom-up merge sort on an array.
     * It divides the array into subarrays of increasing sizesand merges them together until the entire array is sorted.
     * <ul>
     *     <li>This {@code while} loop iterates until the {@code left} index becomes equal to or greater than the {@code right} index,
     *     indicating that the entire array is sorted.</li>
     *     <li>This {@code for} loop iterates through the array in increments of {@code (left * 2)},
     *     effectively dividing the array into subarrays of size {@code (left * 2)} for merging.</li>
     *     <li>This calculates the indices for the merging operation.
     *     {@code mid} represents the midpoint of the current subarray, and
     *     {@code end} represents the ending index of the current subarray or the ending index of the entire array
     *     if it's reached before the subarray size.</li>
     *     <li>This calls the {@code mergingDec} method to merge the subarray defined by the indices
     *     {@code i}, {@code mid}, and {@code end}.</li>
     *     <li>{@code left *= 2} After each iteration of the outer loop, the {@code left} variable is doubled.
     *     This decreases the size of the subarrays being merged in the next iteration.</li>
     * </ul>
     * {@code mergeDec} method performs an iterative bottom-up merge sort by repeatedly merging subarrays of
     * increasing sizes until the entire array is sorted.
     * It utilizes the {@code mergingDec} method to perform the merging operation.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @see         mz.MergeInterface#mergingDec(Comparable[], int, int, int)
     */
    default void mergeDec(T[] array, int left, int right) {
        while (left < right) {
            for (int i = 0; i < right; i += (left * 2)) {
                int mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                mergingDec(array, i, mid, end);
            }
            left *= 2;
        }
    }

    /**
     * {@code merge} method merge takes an array {@code array},
     * indices {@code left} and {@code right}, and a {@code SortFunctional} as parameters that defines the sorting logic.
     * <ul>
     *     <li>The {@code while} loop continues until the {@code left} index is less than the {@code right} index.</li>
     *     <li>Inside the {@code while} loop, there is a {@code for} loop that iterates over the array segments with a size of {@code (left * 2)}.
     *     This means that in each iteration of the {@code for} loop,
     *     the array is divided into segments of length {@code (left * 2)}.</li>
     *     <li>Within the {@code for} loop,
     *     the variables {@code mid} and {@code end} are calculated to determine the indices for the merging operation.</li>
     *     <li>{@code mid} is set to {@code (i + left - 1)},
     *     which is the index of the middle element of the current segment.</li>
     *     <li>{@code end} is set to the minimum value between {@code (i + (left * 2) - 1)} and {@code (right - 1)}.
     *     This ensures that end does not go beyond the right boundary of the array.</li>
     *     <li>The {@code merging} method is called with the array,
     *     the indices {@code i}, {@code mid}, {@code end}, and the {@code functional} as parameters.
     *     The merging method performs the merge operation for the specified array segment using the provided sorting logic.</li>
     *     <li>After the {@code for} loop completes, the {@code left} value is multiplied by 2 to double its value, preparing for the next iteration.
     *     This step ensures that the array segments to be merged in the next iteration are twice as large as in the previous iteration.</li>
     *     <li>The process continues until the {@code left} index is no longer less than the {@code right} index,
     *     indicating that the entire array has been sorted.</li>
     * </ul>
     * For merging two sorted array segments according to the chosen sorting logic.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         mz.MergeInterface#merging(Comparable[], int, int, int, SortFunctional)
     */
    default void merge(T[] array, int left, int right, SortFunctional<T> functional) {
        while (left < right) {
            for (int i = 0; i < right; i += (left * 2)) {
                int mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                merging(array, i, mid, end, functional);
            }
            left *= 2;
        }
    }

    /**
     * {@code mergeInc} method for performing an iterative bottom-up merge sort on an array.
     * It divides the array into subarrays of increasing sizesand merges them together until the entire array is sorted.
     * <ul>
     *     <li>This {@code while} loop iterates until the {@code left} index becomes equal to or greater than the {@code right} index,
     *     indicating that the entire array is sorted.</li>
     *     <li>This {@code for} loop iterates through the array in increments of {@code (left * 2)},
     *     effectively dividing the array into subarrays of size {@code (left * 2)} for merging.</li>
     *     <li>This calculates the indices for the merging operation.
     *     {@code mid} represents the midpoint of the current subarray, and
     *     {@code end} represents the ending index of the current subarray or the ending index of the entire array
     *     if it's reached before the subarray size.</li>
     *     <li>This calls the {@code mergingInc} method to merge the subarray defined by the indices
     *     {@code i}, {@code mid}, and {@code end} into the {@code buffer} array.</li>
     *     <li>{@code left *= 2} After each iteration of the outer loop, the {@code left} variable is doubled.
     *     This increases the size of the subarrays being merged in the next iteration.</li>
     * </ul>
     * {@code mergeInc} method performs an iterative bottom-up merge sort by repeatedly merging subarrays of
     * increasing sizes until the entire array is sorted.
     * It utilizes the {@code mergingInc} method to perform the merging operation.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @param       buffer An auxiliary array used for merging.
     * @see         mz.MergeInterface#mergingInc(Comparable[], int, int, int, Comparable[])
     */
    default void mergeInc(T[] array, int left, int right, T[] buffer) {
        while (left < right) {
            for (int i = 0; i < right; i += (left * 2)) {
                int mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                mergingInc(array, i, mid, end, buffer);
            }
            left *= 2;
        }
    }

    /**
     * {@code mergeDec} method for performing an iterative bottom-up merge sort on an array.
     * It divides the array into subarrays of increasing sizesand merges them together until the entire array is sorted.
     * <ul>
     *     <li>This {@code while} loop iterates until the {@code left} index becomes equal to or greater than the {@code right} index,
     *     indicating that the entire array is sorted.</li>
     *     <li>This {@code for} loop iterates through the array in increments of {@code (left * 2)},
     *     effectively dividing the array into subarrays of size {@code (left * 2)} for merging.</li>
     *     <li>This calculates the indices for the merging operation.
     *     {@code mid} represents the midpoint of the current subarray, and
     *     {@code end} represents the ending index of the current subarray or the ending index of the entire array
     *     if it's reached before the subarray size.</li>
     *     <li>This calls the {@code mergingDec} method to merge the subarray defined by the indices
     *     {@code i}, {@code mid}, and {@code end} into the {@code buffer} array.</li>
     *     <li>{@code left *= 2} After each iteration of the outer loop, the {@code left} variable is doubled.
     *     This decreases the size of the subarrays being merged in the next iteration.</li>
     * </ul>
     * {@code mergeDec} method performs an iterative bottom-up merge sort by repeatedly merging subarrays of
     * increasing sizes until the entire array is sorted.
     * It utilizes the {@code mergingDec} method to perform the merging operation.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @param       buffer An auxiliary array used for merging.
     * @see         mz.MergeInterface#mergingDec(Comparable[], int, int, int, Comparable[])
     */
    default void mergeDec(T[] array, int left, int right, T[] buffer) {
        while (left < right) {
            for (int i = 0; i < right; i += (left * 2)) {
                int mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                mergingDec(array, i, mid, end, buffer);
            }
            left *= 2;
        }
    }

    /**
     * {@code merge} method for performing an iterative bottom-up merge sort on an array.
     * It divides the array into subarrays of increasing sizesand merges them together until the entire array is sorted.
     * <ul>
     *     <li>The method takes in parameters {@code left} and {@code right},
     *     which represent the boundaries of the subarray to be merged.
     *     It also takes a {@code buffer} array to store the merged elements and
     *     the {@code functional} instance for element comparison.</li>
     *     <li>The method enters a {@code while} loop that continues as long as {@code left} is less than {@code right}.
     *     This loop iterates over multiple merge passes, doubling the merge size {@code left} in each iteration.</li>
     *     <li>Within the {@code while} loop, there is a {@code for} loop that iterates over subarrays of size {@code (left * 2)}.
     *     The loop variable {@code i} represents the starting index of each subarray.</li>
     *     <li>For each subarray, it calculates the {@code mid} index as {@code (i + left - 1)},
     *     which represents the {@code end} of the first half of the subarray.
     *     The end index is calculated as the minimum of {@code (i + (left * 2) - 1)} and {@code (right - 1)},
     *     ensuring that it does not exceed the right boundary of the array.</li>
     *     <li>It calls the {@code merging} method to merge the subarray,
     *     passing the {@code array}, {@code i}, {@code mid}, {@code end}, {@code buffer},
     *     and {@code functional} as parameters.</li>
     *     <li>After merging a subarray, the {@code left} value is doubled {@code (left *= 2)}
     *     to increase the merge size for the next iteration.</li>
     *     <li>The process continues until {@code left} becomes greater than or equal to {@code right},
     *     indicating that the entire array has been sorted.</li>
     * </ul>
     * {@code merge} method implements a bottom-up merge sort algorithm by repeatedly merging subarrays of increasing sizes.
     * It uses the {@code merging} method to perform the merging operation.
     * The method starts with a merge size of {@code left} and doubles it in each iteration until the entire array is sorted.
     * @param       array The array to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @param       buffer An auxiliary array used for merging.
     * @param       functional lambda expression for comparison.
     * @see         mz.MergeInterface#merging(Comparable[], int, int, int, Comparable[], SortFunctional)
     */
    default void merge(T[] array, int left, int right, T[] buffer, SortFunctional<T> functional) {
        while (left < right) {
            for (int i = 0; i < right; i += (left * 2)) {
                int mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                merging(array, i, mid, end, buffer, functional);
            }
            left *= 2;
        }
    }

    /**
     * {@code mergeInc} method for merging three sorted subarrays into a single array. It takes the indices of the subarray boundaries
     * and uses four pointers {@code i, j, k, l} to iterate through the subarrays and merge them into a buffer array.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}: This annotation suppresses unchecked warnings that might occur when using generics,
     *     indicating that the code will handle any necessary type checking appropriately.</li>
     *     <li>Initializes four pointers {@code i, j, k, l}.
     *     {@code i} points to the current position in the first subarray,
     *     {@code j} points to the current position in the second subarray,
     *     {@code k} points to the current position in the third subarray, and
     *     {@code l} points to the current position in the buffer array.</li>
     *     <li>This {@code while} loop continues as long as all three subarrays have remaining elements to be processed.</li>
     *     <li>This condition checks if the element at position {@code i} in the first subarray is less than the element
     *     at position {@code j} in the second subarray.</li>
     *     <li>{@code if (array[i].compareTo(array[k]) < 0)}:
     *     This nested condition checks if the element at position {@code i} in the first subarray is also less than the element
     *     at position {@code k} in the third subarray.</li>
     *     <li> If both conditions in steps 5 and 6 are true, the element at position {@code i} in the first subarray is copied to
     *     the {@code buffer} array at position {@code l}.
     *     Then, both {@code i} and {@code l} pointers are incremented.</li>
     *     <li>If the condition in step 6 is false, the element at position {@code k} in the third subarray is selected for merging.</li>
     *     <li>The element at position {@code k} in the third subarray is copied to the {@code buffer} array at position {@code l}.
     *     Then, both {@code k} and {@code l} pointers are incremented.</li>
     *     <li>If the condition in step 5 is false, the element at position {@code j} in the second subarray is selected for merging.</li>
     *     <li>{@code if (array[j].compareTo(array[k]) < 0)}:
     *     This nested condition checks if the element at position {@code j} in the second subarray is less than the element
     *     at position {@code k} in the third subarray.</li>
     *     <li>If the condition in step 11 is true, the element at position {@code j} in the second subarray is copied to
     *     the {@code buffer} array at position {@code l}.
     *     Then, both {@code j} and {@code l} pointers are incremented.</li>
     *     <li>If the condition in step 11 is false, the element at position {@code k} in the third subarray is selected for merging.</li>
     *     <li>The element at position {@code k} in the third subarray is copied to the buffer array at position {@code l}.
     *     Then, both {@code k} and {@code l} pointers are incremented.</li>
     *     <li>The following three while loops merge any remaining elements
     *     in pairs of subarrays {@code ((i, j), (j, k), (i, k))} into the buffer array, similar to the previous steps.</li>
     *     <li>The remaining three {@code while} loops copy any remaining elements from the subarrays {@code i, j, k} to the buffer array.</li>
     * </ul>
     * {@code mergeInc} this method merges three sorted subarrays into a single sorted array using four pointers to iterate through
     * the subarrays and merge their elements into a buffer array.
     * The merged elements are then copied back to the original {@code array}.
     * @param       array The array containing the subarrays to be merged.
     * @param       left The starting index of the first subarray.
     * @param       mid1 The ending index (exclusive) of the first subarray.
     * @param       mid2 The ending index (exclusive) of the second subarray.
     * @param       right The ending index (exclusive) of the third subarray.
     * @param       buffer An auxiliary array used for merging.
     */
    @SuppressWarnings("unchecked")
    default void mergeInc(T[] array, int left, int mid1, int mid2, int right, T[] buffer) {
        int i = left, j = mid1, k = mid2, l = left;
        while ((i < mid1) && (j < mid2) && (k < right)) {
            if (array[j].compareTo(array[i]) > 0) {
                if (array[k].compareTo(array[i]) > 0) {
                    buffer[l++] = array[i++];
                } else {
                    buffer[l++] = array[k++];
                }
            } else {
                if (array[k].compareTo(array[j]) > 0) {
                    buffer[l++] = array[j++];
                } else {
                    buffer[l++] = array[k++];
                }
            }
        }
        while ((i < mid1) && (j < mid2)) {
            if (array[j].compareTo(array[i]) > 0) {
                buffer[l++] = array[i++];
            } else {
                buffer[l++] = array[j++];
            }
        }
        while ((j < mid2) && (k < right)) {
            if (array[k].compareTo(array[j]) > 0) {
                buffer[l++] = array[j++];
            } else {
                buffer[l++] = array[k++];
            }
        }
        while ((i < mid1) && (k < right)) {
            if (array[k].compareTo(array[i]) > 0) {
                buffer[l++] = array[i++];
            } else {
                buffer[l++] = array[k++];
            }
        }
        while (i < mid1) {
            buffer[l++] = array[i++];
        }
        while (j < mid2) {
            buffer[l++] = array[j++];
        }
        while (k < right) {
            buffer[l++] = array[k++];
        }
    }

    /**
     * {@code mergeDec} method for merging three sorted subarrays into a single array. It takes the indices of the subarray boundaries
     * and uses four pointers {@code i, j, k, l} to iterate through the subarrays and merge them into a buffer array.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}: This annotation suppresses unchecked warnings that might occur when using generics,
     *     indicating that the code will handle any necessary type checking appropriately.</li>
     *     <li>Initializes four pointers {@code i, j, k, l}.
     *     {@code i} points to the current position in the first subarray,
     *     {@code j} points to the current position in the second subarray,
     *     {@code k} points to the current position in the third subarray, and
     *     {@code l} points to the current position in the buffer array.</li>
     *     <li>This {@code while} loop continues as long as all three subarrays have remaining elements to be processed.</li>
     *     <li>This condition checks if the element at position {@code i} in the first subarray is more than the element
     *     at position {@code j} in the second subarray.</li>
     *     <li>{@code if (array[i].compareTo(array[k]) > 0)}:
     *     This nested condition checks if the element at position {@code i} in the first subarray is also less than the element
     *     at position {@code k} in the third subarray.</li>
     *     <li> If both conditions in steps 5 and 6 are true, the element at position {@code i} in the first subarray is copied to
     *     the {@code buffer} array at position {@code l}.
     *     Then, both {@code i} and {@code l} pointers are incremented.</li>
     *     <li>If the condition in step 6 is false, the element at position {@code k} in the third subarray is selected for merging.</li>
     *     <li>The element at position {@code k} in the third subarray is copied to the {@code buffer} array at position {@code l}.
     *     Then, both {@code k} and {@code l} pointers are incremented.</li>
     *     <li>If the condition in step 5 is false, the element at position {@code j} in the second subarray is selected for merging.</li>
     *     <li>{@code if (array[j].compareTo(array[k]) > 0)}:
     *     This nested condition checks if the element at position {@code j} in the second subarray is more than the element
     *     at position {@code k} in the third subarray.</li>
     *     <li>If the condition in step 11 is true, the element at position {@code j} in the second subarray is copied to
     *     the {@code buffer} array at position {@code l}.
     *     Then, both {@code j} and {@code l} pointers are incremented.</li>
     *     <li>If the condition in step 11 is false, the element at position {@code k} in the third subarray is selected for merging.</li>
     *     <li>The element at position {@code k} in the third subarray is copied to the buffer array at position {@code l}.
     *     Then, both {@code k} and {@code l} pointers are incremented.</li>
     *     <li>The following three while loops merge any remaining elements
     *     in pairs of subarrays {@code ((i, j), (j, k), (i, k))} into the buffer array, similar to the previous steps.</li>
     *     <li>The remaining three {@code while} loops copy any remaining elements from the subarrays {@code i, j, k} to the buffer array.</li>
     * </ul>
     * {@code mergeInc} this method merges three sorted subarrays into a single sorted array using four pointers to iterate through
     * the subarrays and merge their elements into a buffer array.
     * The merged elements are then copied back to the original {@code array}.
     * @param       array The array containing the subarrays to be merged.
     * @param       left The starting index of the first subarray.
     * @param       mid1 The ending index (exclusive) of the first subarray.
     * @param       mid2 The ending index (exclusive) of the second subarray.
     * @param       right The ending index (exclusive) of the third subarray.
     * @param       buffer An auxiliary array used for merging.
     */
    @SuppressWarnings("unchecked")
    default void mergeDec(T[] array, int left, int mid1, int mid2, int right, T[] buffer) {
        int i = left, j = mid1, k = mid2, l = left;
        while ((i < mid1) && (j < mid2) && (k < right)) {
            if (array[j].compareTo(array[i]) < 0) {
                if (array[k].compareTo(array[i]) < 0) {
                    buffer[l++] = array[i++];
                } else {
                    buffer[l++] = array[k++];
                }
            } else {
                if (array[k].compareTo(array[j]) < 0) {
                    buffer[l++] = array[j++];
                } else {
                    buffer[l++] = array[k++];
                }
            }
        }
        while ((i < mid1) && (j < mid2)) {
            if (array[j].compareTo(array[i]) < 0) {
                buffer[l++] = array[i++];
            } else {
                buffer[l++] = array[j++];
            }
        }
        while ((j < mid2) && (k < right)) {
            if (array[k].compareTo(array[j]) < 0) {
                buffer[l++] = array[j++];
            } else {
                buffer[l++] = array[k++];
            }
        }
        while ((i < mid1) && (k < right)) {
            if (array[k].compareTo(array[i]) < 0) {
                buffer[l++] = array[i++];
            } else {
                buffer[l++] = array[k++];
            }
        }
        while (i < mid1) {
            buffer[l++] = array[i++];
        }
        while (j < mid2) {
            buffer[l++] = array[j++];
        }
        while (k < right) {
            buffer[l++] = array[k++];
        }
    }

    /**
     * {@code mergeDec} method for merging three sorted subarrays into a single array. It takes the indices of the subarray boundaries
     * and uses four pointers {@code i, j, k, l} and an instance of {@code mz.SortFunctional<T>} as parameters,
     * to iterate through the subarrays and merge them into a buffer array.
     * <ul>
     *     <li>The method takes in additional parameters {@code mid1} and {@code mid2},
     *     which represent the boundaries of the two middle subarrays.</li>
     *     <li>It initializes variables {@code i, j, k, l} to keep track of
     *     the current indices in the three subarrays and the merged array ({@code buffer}), respectively.
     *     The initial value of {@code l} is set to {@code left}.</li>
     *     <li>It enters a {@code while} loop that continues as long as {@code i} is less than {@code mid1}, {@code j}
     *     is less than {@code mid2}, and {@code k} is less than {@code right}.
     *     Within the loop, it performs comparisons using the {@code functional} instance to determine the order of the elements.</li>
     *     <li>If {@code array[j]} is smaller than {@code array[i]},
     *     it further checks if {@code array[k]} is also smaller than {@code array[i]}.
     *     If so, it assigns {@code array[i]} to {@code buffer[l++]} and increments {@code i}.
     *     Otherwise, it assigns {@code array[k]} to {@code buffer[l++]} and increments {@code k}.</li>
     *     <li>If {@code array[i]} is smaller than or equal to {@code array[j]},
     *     it checks if {@code array[k]} is smaller than {@code array[j]}.
     *     If so, it assigns {@code array[j]} to {@code buffer[l++]} and increments {@code j}.
     *     Otherwise, it assigns {@code array[k]} to {@code buffer[l++]} and increments {@code k}.</li>
     *     <li>After the {@code while} loop, there are three possible cases:</li>
     *     <li>Elements remaining in both the first and second subarrays:
     *     It compares {@code array[j]} and {@code array[i]} using
     *     the {@code functional} instance and assigns the smaller element to {@code buffer[l++]}.
     *     It then increments the corresponding counters {@code i} and {@code j}.</li>
     *     <li>Elements remaining in the second and third subarrays:
     *     It compares {@code array[k]} and {@code array[j]} using
     *     the {@code functional} instance and assigns the smaller element to {@code buffer[l++]}.
     *     It then increments the corresponding counters {@code j} and {@code k}.</li>
     *     <li>Elements remaining in the first and third subarrays:
     *     It compares {@code array[k]} and {@code array[i]} using
     *     the {@code functional} instance and assigns the smaller element to {@code buffer[l++]}.
     *     It then increments the corresponding counters {@code i} and {@code k}.</li>
     *     <li>It handles the remaining elements in the first, second, and third subarrays
     *     individually using separate {@code while} loops.
     *     It assigns the remaining elements to {@code buffer[l++]} and increments the corresponding counters.</li>
     * </ul>
     * {@code merge} method performs a three-way merge of subarrays within the {@code array} by comparing elements using the {@code functional} instance.
     * It maintains separate indices for each subarray and incrementally merges the elements into the {@code buffer} array.
     * After merging all the elements, it copies the merged elements back to the original {@code array}.
     * @param       array The array containing the subarrays to be merged.
     * @param       left The starting index of the first subarray.
     * @param       mid1 The ending index (exclusive) of the first subarray.
     * @param       mid2 The ending index (exclusive) of the second subarray.
     * @param       right The ending index (exclusive) of the third subarray.
     * @param       buffer An auxiliary array used for merging.
     * @param       functional lambda expression for comparison.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default void merge(T[] array, int left, int mid1, int mid2, int right, T[] buffer, SortFunctional<T> functional) {
        int i = left, j = mid1, k = mid2, l = left;
        while ((i < mid1) && (j < mid2) && (k < right)) {
            if (functional.functionalCompareTo(array[j], array[i])) {
                if (functional.functionalCompareTo(array[k], array[i])) {
                    buffer[l++] = array[i++];
                } else {
                    buffer[l++] = array[k++];
                }
            } else {
                if (functional.functionalCompareTo(array[k], array[j])) {
                    buffer[l++] = array[j++];
                } else {
                    buffer[l++] = array[k++];
                }
            }
        }
        while ((i < mid1) && (j < mid2)) {
            if (functional.functionalCompareTo(array[j], array[i])) {
                buffer[l++] = array[i++];
            } else {
                buffer[l++] = array[j++];
            }
        }
        while ((j < mid2) && (k < right)) {
            if (functional.functionalCompareTo(array[k], array[j])) {
                buffer[l++] = array[j++];
            } else {
                buffer[l++] = array[k++];
            }
        }
        while ((i < mid1) && (k < right)) {
            if (functional.functionalCompareTo(array[k], array[i])) {
                buffer[l++] = array[i++];
            } else {
                buffer[l++] = array[k++];
            }
        }
        while (i < mid1) {
            buffer[l++] = array[i++];
        }
        while (j < mid2) {
            buffer[l++] = array[j++];
        }
        while (k < right) {
            buffer[l++] = array[k++];
        }
    }

    /**
     * {@code mergingInc} that performs a merging operation for the purpose of merging two sorted portions of an array into a single sorted portion.
     * The method assumes that the left portion of the array, from index {@code left} to {@code mid}, and the {@code right} portion,
     * from index {@code (mid + 1)} to {@code right}, are already sorted in increasing order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@code compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method starts by checking if the indices {@code left}, {@code mid}, and {@code right} are within valid bounds.
     *     If the {@code condition left > mid || mid + 1 > right} is true, it means that either the left portion or
     *     the right portion is empty or the indices are not properly specified.
     *     In such cases, the method returns without performing any merging.</li>
     *     <li>The variables {@code n1} and {@code n2} are assigned the sizes of the left and right portions, respectively.</li>
     *     <li>Two new arrays, {@code leftArray} and {@code rightArray}, are created using the {@link java.util.Arrays#copyOfRange(Object[], int, int) Arrays.copyOfRange} method.
     *     These arrays contain copies of the respective portions of the original {@code array}.</li>
     *     <li>The variables {@code i} and {@code j} are used as indices to iterate over {@code leftArray} and {@code rightArray}, respectively.</li>
     *     <li>The variable {@code k} is used as an index to update the {@code array} with the merged elements.</li>
     *     <li>The subsequent {@code while} loop continues as long as both {@code i} and {@code j} are within their respective array sizes, {@code n1} and {@code n2}.
     *     It compares the elements at indices {@code i} and {@code j} of {@code leftArray} and {@code rightArray},
     *     respectively, and assigns the smaller element to {@code array[k]}.
     *     The corresponding index ({@code i} or {@code j}) and {@code k} are incremented accordingly.</li>
     *     <li>After the {@code while} loop, there might still be remaining elements in either {@code leftArray} or {@code rightArray}.
     *     The next two {@code while} loops handle the remaining elements by copying them into array starting from index {@code k}.</li>
     *     <li>Finally, the merging operation is complete, and the merged sorted portion is stored in the original {@code array} from index {@code left} to {@code right}.</li>
     * </ul>
     * {@code mergingInc} method is commonly used as part of merge sort algorithms to merge two sorted portions of an array into a single sorted portion.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     */
    @SuppressWarnings("unchecked")
    default void mergingInc(T[] array, int left, int mid, int right) {
        if ((left > mid) || ((mid + 1) > right)) {
            return;
        }
        int n1 = (mid - left + 1), n2 = (right - mid), i = 0, j = 0, k = left;
        T[] leftArray = Arrays.copyOfRange(array, left, (mid + 1)), rightArray = Arrays.copyOfRange(array, (mid + 1), (right + 1));
        while (i < n1 && j < n2) {
            if (rightArray[j].compareTo(leftArray[i]) > 0) {
                array[k] = leftArray[i++];
            } else {
                array[k] = rightArray[j++];
            }
            k++;
        }
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    /**
     * {@code mergingDec} that performs a merging operation for the purpose of merging two sorted portions of an array into a single sorted portion.
     * The method assumes that the left portion of the array, from index {@code left} to {@code mid}, and the {@code right} portion,
     * from index {@code (mid + 1)} to {@code right}, are already sorted in increasing order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@code compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method starts by checking if the indices {@code left}, {@code mid}, and {@code right} are within valid bounds.
     *     If the {@code condition left > mid || mid + 1 > right} is true, it means that either the left portion or
     *     the right portion is empty or the indices are not properly specified.
     *     In such cases, the method returns without performing any merging.</li>
     *     <li>The variables {@code n1} and {@code n2} are assigned the sizes of the left and right portions, respectively.</li>
     *     <li>Two new arrays, {@code leftArray} and {@code rightArray}, are created using the {@link java.util.Arrays#copyOfRange(Object[], int, int) Arrays.copyOfRange} method.
     *     These arrays contain copies of the respective portions of the original {@code array}.</li>
     *     <li>The variables {@code i} and {@code j} are used as indices to iterate over {@code leftArray} and {@code rightArray}, respectively.</li>
     *     <li>The variable {@code k} is used as an index to update the {@code array} with the merged elements.</li>
     *     <li>The subsequent {@code while} loop continues as long as both {@code i} and {@code j} are within their respective array sizes, {@code n1} and {@code n2}.
     *     It compares the elements at indices {@code i} and {@code j} of {@code leftArray} and {@code rightArray},
     *     respectively, and assigns the greater element to {@code array[k]}.
     *     The corresponding index ({@code i} or {@code j}) and {@code k} are incremented accordingly.</li>
     *     <li>After the {@code while} loop, there might still be remaining elements in either {@code leftArray} or {@code rightArray}.
     *     The next two {@code while} loops handle the remaining elements by copying them into array starting from index {@code k}.</li>
     *     <li>Finally, the merging operation is complete, and the merged sorted portion is stored in the original {@code array} from index {@code left} to {@code right}.</li>
     * </ul>
     * {@code mergingDec} method is commonly used as part of merge sort algorithms to merge two sorted portions of an array into a single sorted portion.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     */
    @SuppressWarnings("unchecked")
    default void mergingDec(T[] array, int left, int mid, int right) {
        if ((left > mid) || ((mid + 1) > right)) {
            return;
        }
        int n1 = (mid - left + 1), n2 = (right - mid), i = 0, j = 0, k = left;
        T[] leftArray = Arrays.copyOfRange(array, left, (mid + 1)), rightArray = Arrays.copyOfRange(array, (mid + 1), (right + 1));
        while (i < n1 && j < n2) {
            if (rightArray[j].compareTo(leftArray[i]) < 0) {
                array[k] = leftArray[i++];
            } else {
                array[k] = rightArray[j++];
            }
            k++;
        }
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    /**
     * {@code merging} that performs a merging operation for the purpose of merging two sorted portions of an array into a single sorted portion.
     * The method assumes that the left portion of the array, from index {@code left} to {@code mid}, and the {@code right} portion,
     * from index {@code (mid + 1)} to {@code right},
     * and an instance of {@code mz.SortFunctional<T>} as parameters,
     * are already sorted in increasing order.
     * <ul>
     *     <li>{@code merging} method now includes an additional check at the beginning.
     *     If the condition {@code (left > mid) || ((mid + 1) > right)} is satisfied,
     *     it means that either the left subarray is empty or the right subarray is empty,
     *     indicating that there is no need to perform the merging. In such cases, the method simply returns.</li>
     *     <li>It initializes variables {@code n1} and {@code n2} to store the sizes of the left and right subarrays, respectively.
     *     The values are calculated as {@code (mid - left + 1)} and {@code (right - mid)}.</li>
     *     <li>It initializes counters {@code i}, {@code j}, and {@code k} to keep track of the current indices in the left array, right array,
     *     and the merged array ({@code array}), respectively.
     *     The initial value of {@code k} is set to {@code left}.</li>
     *     <li>It creates two new arrays, {@code leftArray} and {@code rightArray},
     *     using {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy}.
     *     These arrays store the respective subarrays extracted from {@code array}.</li>
     *     <li>It enters a {@code while} loop that continues as long as both {@code i} and {@code j} are within their respective
     *     subarray bounds ({@code (i < n1 && j < n2)}).
     *     Within the loop, it performs the comparison using
     *     the {@code functional} instance and assigns the smaller element to {@code array[k]}.
     *     After assigning the element, it increments the corresponding counters ({@code i}, {@code j}, and {@code k}).</li>
     *     <li>After exiting the {@code while} loop, it checks if there are any remaining elements in the left subarray {@code (i < n1)}.
     *     If so, it copies the remaining elements to {@code array[k]} and increments both {@code i} and {@code k}.</li>
     *     <li>Similarly, it checks if there are any remaining elements in the right subarray {@code (j < n2)}.
     *     If so, it copies the remaining elements to {@code array[k]} and increments both {@code j} and {@code k}.</li>
     * </ul>
     * {@code merging} method merges two sorted subarrays ({@code leftArray} and {@code rightArray}) into a single sorted array ({@code array}).
     * It compares elements using the {@code functional} instance and assigns the smaller element to {@code array[k]} at each step.
     * The method handles cases where one of the subarrays is empty or when there are remaining elements in either
     * the left or right subarray after the initial merging.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     * @param       functional lambda expression for comparison.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default void merging(T[] array, int left, int mid, int right, SortFunctional<T> functional) {
        if ((left > mid) || ((mid + 1) > right)) {
            return;
        }
        int n1 = (mid - left + 1), n2 = (right - mid), i = 0, j = 0, k = left;
        T[] leftArray = Arrays.copyOfRange(array, left, (mid + 1)), rightArray = Arrays.copyOfRange(array, (mid + 1), (right + 1));
        while (i < n1 && j < n2) {
            if (functional.functionalCompareTo(rightArray[j], leftArray[i])) {
                array[k] = leftArray[i++];
            } else {
                array[k] = rightArray[j++];
            }
            k++;
        }
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    /**
     * {@code mergingInc} method for merging two sorted subarrays within an array using the merge sort algorithm.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}: This annotation suppresses unchecked warnings that might occur when using generics,
     *     indicating that the code will handle any necessary type checking appropriately.</li>
     *     <li>Initializes two pointers {@code n1} and {@code n2} to keep track of
     *     the current positions within the subarrays to be merged.
     *     {@code n1} is initially set to the leftmost index, and {@code n2} is set to the index immediately after the midpoint.</li>
     *     <li>This loop iterates from the {@code left} index to the {@code right} index (inclusive) to merge the subarrays.</li>
     *     <li>This condition checks if the current element at position {@code n1} in the left subarray is less than or equal to
     *     the current element at position {@code n2} in the right subarray.
     *     It also checks if the {@code n2} pointer has reached the end of the right subarray.
     *     If either of these conditions is true, the element at {@code n1} is selected for merging.</li>
     *     <li>If the condition in the previous step is true, the element at position {@code n1} in
     *     the left subarray is copied to the {@code buffer} array at position {@code i}.
     *     Then, the {@code n1} pointer is incremented.</li>
     *     <li>If the condition in step 5 is false, the element at position {@code n2} in the right subarray is selected for merging.</li>
     *     <li>The element at position {@code n2} in the right subarray is copied to the {@code buffer} array at position {@code i}.
     *     Then, the {@code n2} pointer is incremented.</li>
     *     <li> Once the merging is complete, the merged elements in the {@code buffer} array are copied back to
     *     the original {@code array} starting from the {@code left} index.
     *     The number of elements to copy is {@code (right - left + 1)}.</li>
     * </ul>
     * {@code mergingInc} this method performs the merging step of the merge sort algorithm by comparing elements from two sorted subarrays
     * and merging them into a temporary buffer array.
     * After the merging is complete, the merged elements are copied back {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy} to the original array.
     * @param       array to be arranged.
     * @param       left The index of the leftmost element of the subarray to be merged.
     * @param       mid The index of the midpoint element in the subarray to be merged.
     * @param       right The index of the rightmost element of the subarray to be merged.
     * @param       buffer An auxiliary array used for storing the merged elements temporarily.
     */
    @SuppressWarnings("unchecked")
    default void mergingInc(T[] array, int left, int mid, int right, T[] buffer) {
        int n1 = left, n2 = (mid + 1);
        for (int i = left; i <= right; i++) {
            if ((n1 <= mid) && ((n2 > right) || (array[n2].compareTo(array[n1]) >= 0))) {
                buffer[i] = array[n1++];
            } else {
                buffer[i] = array[n2++];
            }
        }
        System.arraycopy(buffer, left, array, left, (right - left + 1));
    }

    /**
     * {@code mergingDec} method for merging two sorted subarrays within an array using the merge sort algorithm.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}: This annotation suppresses unchecked warnings that might occur when using generics,
     *     indicating that the code will handle any necessary type checking appropriately.</li>
     *     <li>Initializes two pointers {@code n1} and {@code n2} to keep track of
     *     the current positions within the subarrays to be merged.
     *     {@code n1} is initially set to the leftmost index, and {@code n2} is set to the index immediately after the midpoint.</li>
     *     <li>This loop iterates from the {@code left} index to the {@code right} index (inclusive) to merge the subarrays.</li>
     *     <li>This condition checks if the current element at position {@code n1} in the left subarray is more than or equal to
     *     the current element at position {@code n2} in the right subarray.
     *     It also checks if the {@code n2} pointer has reached the end of the right subarray.
     *     If either of these conditions is true, the element at {@code n1} is selected for merging.</li>
     *     <li>If the condition in the previous step is true, the element at position {@code n1} in
     *     the left subarray is copied to the {@code buffer} array at position {@code i}.
     *     Then, the {@code n1} pointer is incremented.</li>
     *     <li>If the condition in step 5 is false, the element at position {@code n2} in the right subarray is selected for merging.</li>
     *     <li>The element at position {@code n2} in the right subarray is copied to the {@code buffer} array at position {@code i}.
     *     Then, the {@code n2} pointer is incremented.</li>
     *     <li> Once the merging is complete, the merged elements in the {@code buffer} array are copied back to
     *     the original {@code array} starting from the {@code left} index.
     *     The number of elements to copy is {@code (right - left + 1)}.</li>
     * </ul>
     * {@code mergingDec} this method performs the merging step of the merge sort algorithm by comparing elements from two sorted subarrays
     * and merging them into a temporary buffer array.
     * After the merging is complete, the merged elements are copied back {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy} to the original array.
     * @param       array to be arranged.
     * @param       left The index of the leftmost element of the subarray to be merged.
     * @param       mid The index of the midpoint element in the subarray to be merged.
     * @param       right The index of the rightmost element of the subarray to be merged.
     * @param       buffer An auxiliary array used for storing the merged elements temporarily.
     */
    @SuppressWarnings("unchecked")
    default void mergingDec(T[] array, int left, int mid, int right, T[] buffer) {
        int n1 = left, n2 = (mid + 1);
        for (int i = left; i <= right; i++) {
            if ((n1 <= mid) && ((n2 > right) || (array[n2].compareTo(array[n1]) <= 0))) {
                buffer[i] = array[n1++];
            } else {
                buffer[i] = array[n2++];
            }
        }
        System.arraycopy(buffer, left, array, left, (right - left + 1));
    }

    /**
     * {@code merging} method now takes additional parameters compared to the previous version:
     * {@code buffer}, an auxiliary array of type {@code T[]},
     * and the indices {@code left}, {@code mid}, and {@code right} that define the range of elements to be merged.
     * <ul>
     *     <li>It initializes two variables: {@code n1} to track the index of the current element in the left subarray,
     *     and {@code n2} to track the index of the current element in the right subarray.</li>
     *     <li>It creates a {@code functionalAddEquals} instance using the {@code functionalComparableToAddEquals} method,
     *     which is responsible for defining the comparison logic for determining element order.</li>
     *     <li>It enters a {@code for} loop that iterates over the range from {@code left} to {@code right} (inclusive).
     *     Within the loop, it checks two conditions:</li>
     *     <li>If {@code n1} is within the range of the left subarray and either {@code n2} is out of the range of
     *     the right subarray or the comparison between the elements at indices {@code n2} and {@code n1} indicates that
     *     the element in the right subarray is greater or equal,
     *     it assigns the element from the left subarray to {@code buffer[i]} and increments {@code n1}.</li>
     *     <li>Otherwise, it assigns the element from the right subarray to {@code buffer[i]} and increments {@code n2}.</li>
     *     <li>After the loop, it uses {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy}
     *     to copy the elements from {@code buffer} back to the original {@code array},
     *     starting from the {@code left} index and copying {@code (right - left + 1)} elements.</li>
     * </ul>
     * {@code merging} method merges two sorted subarrays, specified by the indices {@code left}, {@code mid}, and {@code right},
     * into a single sorted array {@code array}.
     * It utilizes an auxiliary {@code buffer} array to store the merged result temporarily.
     * The comparison logic for element order is determined by the {@code functional} instance,
     * specifically through the {@code functionalComparableToAddEquals} method.
     * @param       array to be arranged.
     * @param       left The index of the leftmost element of the subarray to be merged.
     * @param       mid The index of the midpoint element in the subarray to be merged.
     * @param       right The index of the rightmost element of the subarray to be merged.
     * @param       buffer An auxiliary array used for storing the merged elements temporarily.
     * @param       functional lambda expression for comparison.
     * @see         Sort#functionalComparableToAddEquals(SortFunctional)
     *
     */
    default void merging(T[] array, int left, int mid, int right, T[] buffer, SortFunctional<T> functional) {
        int n1 = left, n2 = (mid + 1);
        SortFunctional<T> functionalAddEquals = functionalComparableToAddEquals(functional);
        for (int i = left; i <= right; i++) {
            if ((n1 <= mid) && ((n2 > right) || (functionalAddEquals.functionalCompareTo(array[n2], array[n1])))) {
                buffer[i] = array[n1++];
            } else {
                buffer[i] = array[n2++];
            }
        }
        System.arraycopy(buffer, left, array, left, (right - left + 1));
    }

    /**
     * {@code mergingInc} method for merging two sorted subarrays into a single array.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}: This annotation suppresses unchecked warnings that might occur when using generics,
     *     indicating that the code will handle any necessary type checking appropriately.</li>
     *     <li>Initializes three pointers {@code i, j, k}. {@code i} points to the current position in the left subarray,
     *     {@code j} points to the current position in the right subarray, and {@code k} points to the current position in the merged array.</li>
     *     <li>This {@code while} loop continues as long as both {@code i} and {@code j} are within the bounds of their respective subarrays.</li>
     *     <li>{@code if (leftArray[i].compareTo(rightArray[j]) < 0)}:
     *     This condition checks if the element at position {@code i} in the left subarray is less than the element at position {@code j} in the right subarray.
     *     If true, the element from the left subarray is selected for merging.</li>
     *     <li>If the condition in the previous step is true, the element at position {@code i} in the left subarray is copied to the {@code array} at position {@code k}.
     *     Then, all three pointers {@code i, j, k} are incremented.</li>
     *     <li>If the condition in step 5 is false, the element at position {@code j} in the right subarray is selected for merging.</li>
     *     <li>The element at position {@code j} in the right subarray is copied to the {@code array} at position {@code k}.
     *     Then, all three pointers {@code i, j, k} are incremented.</li>
     *     <li>This {@code while} loop copies any remaining elements in the left subarray to the {@code array} if there are any.</li>
     *     <li>The remaining element at position {@code i} in the left subarray is copied to the {@code array} at position {@code k}.
     *     Then, both i and {@code k} pointers are incremented.</li>
     *     <li>This loop copies any remaining elements in the right subarray to the {@code array} if there are any.</li>
     *     <li>The remaining element at position {@code j} in the right subarray is copied to the {@code array} at position {@code k}.
     *     Then, both {@code j} and {@code k} pointers are incremented.</li>
     * </ul>
     * {@code mergingInc} this method merges two sorted subarrays {@code leftArray} and {@code rightArray} into a single sorted array {@code array}.
     * It compares elements from both subarrays and copies them to the {@code array} in the correct order until one of the subarrays is fully processed.
     * Then, it copies any remaining elements from the unfinished subarray to the array.
     * @param       array to be arranged.
     * @param       leftArray The left subarray that is sorted in ascending order.
     * @param       rightArray The right subarray that is sorted in ascending order.
     */
    @SuppressWarnings("unchecked")
    default void mergingInc(T[] array, T[] leftArray, T[] rightArray) {
        int i = 0, j = 0, k = 0;
        while ((i < leftArray.length) && (j < rightArray.length)) {
            if (rightArray[j].compareTo(leftArray[i]) > 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

    /**
     * {@code mergingDec} method for merging two sorted subarrays into a single array.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}: This annotation suppresses unchecked warnings that might occur when using generics,
     *     indicating that the code will handle any necessary type checking appropriately.</li>
     *     <li>Initializes three pointers {@code i, j, k}. {@code i} points to the current position in the left subarray,
     *     {@code j} points to the current position in the right subarray, and {@code k} points to the current position in the merged array.</li>
     *     <li>This {@code while} loop continues as long as both {@code i} and {@code j} are within the bounds of their respective subarrays.</li>
     *     <li>{@code if (leftArray[i].compareTo(rightArray[j]) > 0)}:
     *     This condition checks if the element at position {@code i} in the left subarray is more than the element at position {@code j} in the right subarray.
     *     If true, the element from the left subarray is selected for merging.</li>
     *     <li>If the condition in the previous step is true, the element at position {@code i} in the left subarray is copied to the {@code array} at position {@code k}.
     *     Then, all three pointers {@code i, j, k} are incremented.</li>
     *     <li>If the condition in step 5 is false, the element at position {@code j} in the right subarray is selected for merging.</li>
     *     <li>The element at position {@code j} in the right subarray is copied to the {@code array} at position {@code k}.
     *     Then, all three pointers {@code i, j, k} are incremented.</li>
     *     <li>This {@code while} loop copies any remaining elements in the left subarray to the {@code array} if there are any.</li>
     *     <li>The remaining element at position {@code i} in the left subarray is copied to the {@code array} at position {@code k}.
     *     Then, both i and {@code k} pointers are incremented.</li>
     *     <li>This loop copies any remaining elements in the right subarray to the {@code array} if there are any.</li>
     *     <li>The remaining element at position {@code j} in the right subarray is copied to the {@code array} at position {@code k}.
     *     Then, both {@code j} and {@code k} pointers are incremented.</li>
     * </ul>
     * {@code mergingDec} this method merges two sorted subarrays {@code leftArray} and {@code rightArray} into a single sorted array {@code array}.
     * It compares elements from both subarrays and copies them to the {@code array} in the correct order until one of the subarrays is fully processed.
     * Then, it copies any remaining elements from the unfinished subarray to the array.
     * @param       array to be arranged.
     * @param       leftArray The left subarray that is sorted in descending order.
     * @param       rightArray The right subarray that is sorted in descending order.
     */
    @SuppressWarnings("unchecked")
    default void mergingDec(T[] array, T[] leftArray, T[] rightArray) {
        int i = 0, j = 0, k = 0;
        while ((i < leftArray.length) && (j < rightArray.length)) {
            if (rightArray[j].compareTo(leftArray[i]) < 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

    /**
     * {@code merging} method takes an array {@code array} of type {@code T},
     * two subarrays {@code leftArray} and {@code rightArray} of type {@code T},
     * and an instance of {@code mz.SortFunctional<T>} as parameters.
     * <ul>
     *     <li>It initializes three variables:
     *     {@code i} to track the index of the current element in {@code leftArray},
     *     {@code j} to track the index of the current element in {@code rightArray}, and
     *     {@code k} to track the index of the current element in {@code array}.</li>
     *     <li>It enters a {@code while} loop that continues until either {@code i} reaches
     *     the end of {@code leftArray} or {@code j} reaches the end of {@code rightArray}.
     *     This loop merges the elements from {@code leftArray} and {@code rightArray}
     *     into array based on the comparison logic defined by the {@code functional} instance.</li>
     *     <li>Within the loop, it compares the current elements at indices i and j from leftArray and rightArray, respectively.
     *     If the comparison indicates that the element in {@code rightArray} is considered greater than the element in {@code leftArray},
     *     it assigns the element from {@code leftArray} to {@code array[k]} and increments {@code i} and {@code k}.
     *     Otherwise, it assigns the element from {@code rightArray} to {@code array[k]} and increments {@code j} and {@code k}.</li>
     *     <li>After the loop, it checks if there are any remaining elements in {@code leftArray} and {@code rightArray} that haven't been processed.
     *     It uses separate {@code while} loops to copy any remaining elements into {@code array}.</li>
     *     <li>Finally, the method completes, and the merged result is stored in {@code array}.</li>
     * </ul>
     * {@code merging} method merges two sorted subarrays, {@code leftArray} and {@code rightArray}, into a single sorted array {@code array}.
     * It uses the comparison logic defined by the {@code mz.SortFunctional} instance to determine the order of elements during the merging process.
     * @param       array to be arranged.
     * @param       leftArray The left subarray that is sorted in descending order.
     * @param       rightArray The right subarray that is sorted in descending order.
     * @param       functional lambda expression for comparison.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default void merging(T[] array, T[] leftArray, T[] rightArray, SortFunctional<T> functional) {
        int i = 0, j = 0, k = 0;
        while ((i < leftArray.length) && (j < rightArray.length)) {
            if (functional.functionalCompareTo(rightArray[j], leftArray[i])) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

    /**
     * {@code mergeInc} that performs a Merge Sort on a list of {@link java.lang.Comparable Comparable} objects in increasing order.
     * The method recursively divides the list into smaller subarrays, sorts them individually,
     * and then merges them together using the {@code mergingInc} method.
     * <ul>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list},
     *     and the indices {@code left} is <i>0</i>, {@code mid} is {@code (list.size() / 2)}, and {@code right}
     *     is {@code (list.size() - 1)} that define the portion of the list to be sorted.</li>
     *     <li>The condition {@code if (left < right)} checks if the portion of the list has more than one element.
     *     If so, it proceeds with the merge sort algorithm.</li>
     *     <li>Inside the condition, the method recursively calls itself to sort the left and right halves of the portion.</li>
     *     <li>The first recursive call {@code mergeInc(list, left, ((left + mid) / 2), mid)} divides the left half of
     *     the portion by updating the {@code mid} index to be the midpoint between {@code left} and {@code mid}.</li>
     *     <li>The second recursive call {@code mergeInc(list, (mid + 1), (((mid + 1) + right) / 2), right)} divides
     *     the right half of the portion by updating the {@code mid} index to be the midpoint between {@code (mid + 1)} and {@code right}.</li>
     *     <li>After the recursive calls, the {@code mergingInc} method is called to merge the two sorted halves together.
     *     The {@code mergingInc} method takes the {@code list}, {@code left}, {@code mid}, and {@code right} indices as arguments.</li>
     *     <li>The overall effect of the {@code mergeInc} method is to recursively divide the list into smaller subarrays until they consist of individual elements.
     *     Then, it merges and sorts these individual elements to gradually build the sorted list.</li>
     * </ul>
     * {@code mergeInc} this implementation follows the divide-and-conquer strategy of merge sort, where the list is recursively divided into smaller subarrays,
     * sorted individually, and then merged back together.
     * @param       list to be arranged.
     * @see         mz.MergeInterface#mergeInc(List, int, int, int)
     */
    default <L extends T> void mergeInc(List<L> list) {
        mergeInc(list, 0, (list.size() / 2), (list.size() - 1));
    }

    /**
     * {@code mergeDec} that performs a Merge Sort on a list of {@link java.lang.Comparable Comparable} objects in decreasing order.
     * The method recursively divides the list into smaller subarrays, sorts them individually,
     * and then merges them together using the {@code mergingDec} method.
     * <ul>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list},
     *     and the indices {@code left} is <i>0</i>, {@code mid} is {@code (list.size() / 2)}, and {@code right}
     *     is {@code (list.size() - 1)} that define the portion of the list to be sorted.</li>
     *     <li>The condition {@code if (left < right)} checks if the portion of the list has more than one element.
     *     If so, it proceeds with the merge sort algorithm.</li>
     *     <li>Inside the condition, the method recursively calls itself to sort the left and right halves of the portion.</li>
     *     <li>The first recursive call {@code mergeDec(list, left, ((left + mid) / 2), mid)} divides the left half of
     *     the portion by updating the {@code mid} index to be the midpoint between {@code left} and {@code mid}.</li>
     *     <li>The second recursive call {@code mergeDec(list, (mid + 1), (((mid + 1) + right) / 2), right)} divides
     *     the right half of the portion by updating the {@code mid} index to be the midpoint between {@code (mid + 1)} and {@code right}.</li>
     *     <li>After the recursive calls, the {@code mergingDec} method is called to merge the two sorted halves together.
     *     The {@code mergingDec} method takes the {@code list}, {@code left}, {@code mid}, and {@code right} indices as arguments.</li>
     *     <li>The overall effect of the {@code mergeDec} method is to recursively divide the list into greater subarrays until they consist of individual elements.
     *     Then, it merges and sorts these individual elements to gradually build the sorted list.</li>
     * </ul>
     * {@code mergeDec} this implementation follows the divide-and-conquer strategy of merge sort, where the list is recursively divided into smaller subarrays,
     * sorted individually, and then merged back together.
     * @param       list to be arranged.
     * @see         mz.MergeInterface#mergeDec(List, int, int, int)
     */
    default <L extends T> void mergeDec(List<L> list) {
        mergeDec(list, 0, (list.size() / 2), (list.size() - 1));
    }

    /**
     * {@code merge} method merge takes a list {@code list},
     * as the {@code SortFunctional} as parameters for custom sorting logic.
     * <ul>
     *     <li>The method begins with a base case check:
     *     if <i>0</i> is less than {@code list.size()}, the sorting operation continues.</li>
     *     <li>Inside the base case, the {@code merge} method is recursively called three times:</li>
     *     <li>The first recursive call is made with the indices <i>0</i>, {@code (list.size() / 2)}
     *     which splits the left half of the list recursively.</li>
     *     <li>The second recursive call is made with the indices {@code ((list.size() / 2) + 1)},
     *     {@code ((((list.size() / 2) + 1) + right) / 2)}, {@code list.size()},
     *     which splits the right half of the list recursively.</li>
     *     <li>The third recursive call is made to the {@code merging} method with the original indices <i>0</i>, {@code (list.size() / 2)}, and {@code list.length}.
     *     This is the merge step where two sorted subarrays (from <i>0</i> to {@code (list.size() / 2)}
     *     and from {@code ((list.size() / 2) + 1)} to {@code list.size()})
     *     are merged into a single sorted list using the provided sorting logic.</li>
     *     <li>The recursion continues until the base case is reached, where <i>0</i> is no longer less than {@code list.size()}.
     *     At this point, the recursion unwinds,
     *     and the merge operations are performed for each level of recursion until the original list is completely sorted.</li>
     * </ul>
     * merge two sorted subarrays into a single sorted list according to the intended sorting logic.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.MergeInterface#merge(List, int, int, int, SortFunctional)
     */
    default <L extends T> void merge(List<L> list, SortFunctional<T> functional) {
        merge(list, 0, (list.size() / 2), (list.size() - 1), functional);
    }

    /**
     * {@code mergeInc} that performs a Merge Sort on a list of {@link java.lang.Comparable Comparable} objects in increasing order.
     * The method recursively divides the list into smaller subarrays, sorts them individually,
     * and then merges them together using the {@code mergingInc} method.
     * <ul>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list},
     *     and the indices {@code left}, {@code mid}, and {@code right} that define the portion of the list to be sorted.</li>
     *     <li>The condition {@code if (left < right)} checks if the portion of the list has more than one element.
     *     If so, it proceeds with the merge sort algorithm.</li>
     *     <li>Inside the condition, the method recursively calls itself to sort the left and right halves of the portion.</li>
     *     <li>The first recursive call {@code mergeInc(list, left, ((left + mid) / 2), mid)} divides the left half of
     *     the portion by updating the {@code mid} index to be the midpoint between {@code left} and {@code mid}.</li>
     *     <li>The second recursive call {@code mergeInc(list, (mid + 1), (((mid + 1) + right) / 2), right)} divides
     *     the right half of the portion by updating the {@code mid} index to be the midpoint between {@code (mid + 1)} and {@code right}.</li>
     *     <li>After the recursive calls, the {@code mergingInc} method is called to merge the two sorted halves together.
     *     The {@code mergingInc} method takes the {@code list}, {@code left}, {@code mid}, and {@code right} indices as arguments.</li>
     *     <li>The overall effect of the {@code mergeInc} method is to recursively divide the list into smaller subarrays until they consist of individual elements.
     *     Then, it merges and sorts these individual elements to gradually build the sorted list.</li>
     * </ul>
     * {@code mergeInc} this implementation follows the divide-and-conquer strategy of merge sort, where the list is recursively divided into smaller subarrays,
     * sorted individually, and then merged back together.
     * @param       list to be arranged.
     * @param       left from the list, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the list, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the list, index value, must be greater than the {@code left} and {@code mid} value.
     * @see         mz.MergeInterface#mergingInc(List, int, int, int)
     */
    default <L extends T> void mergeInc(List<L> list, int left, int mid, int right) {
        if (left < right) {
            mergeInc(list, left, ((left + mid) / 2), mid);
            mergeInc(list, (mid + 1), (((mid + 1) + right) / 2), right);
            mergingInc(list, left, mid, right);
        }
    }

    /**
     * {@code mergeDec} that performs a Merge Sort on a list of {@link java.lang.Comparable Comparable} objects in decreasing order.
     * The method recursively divides the list into smaller subarrays, sorts them individually,
     * and then merges them together using the {@code mergingDec} method.
     * <ul>
     *     <li>The method takes an list of {@code Comparable} objects, denoted by {@code list},
     *     and the indices {@code left}, {@code mid}, and {@code right} that define the portion of the list to be sorted.</li>
     *     <li>The condition {@code if (left < right)} checks if the portion of the list has more than one element.
     *     If so, it proceeds with the merge sort algorithm.</li>
     *     <li>Inside the condition, the method recursively calls itself to sort the left and right halves of the portion.</li>
     *     <li>The first recursive call {@code mergeDec(list, left, ((left + mid) / 2), mid)} divides the left half of
     *     the portion by updating the {@code mid} index to be the midpoint between {@code left} and {@code mid}.</li>
     *     <li>The second recursive call {@code mergeDec(list, (mid + 1), (((mid + 1) + right) / 2), right)} divides
     *     the right half of the portion by updating the {@code mid} index to be the midpoint between {@code (mid + 1)} and {@code right}.</li>
     *     <li>After the recursive calls, the {@code mergingDec} method is called to merge the two sorted halves together.
     *     The {@code mergingDec} method takes the {@code list}, {@code left}, {@code mid}, and {@code right} indices as arguments.</li>
     *     <li>The overall effect of the {@code mergeDec} method is to recursively divide the list into greater subarrays until they consist of individual elements.
     *     Then, it merges and sorts these individual elements to gradually build the sorted list.</li>
     * </ul>
     * {@code mergeDec} this implementation follows the divide-and-conquer strategy of merge sort, where the list is recursively divided into smaller subarrays,
     * sorted individually, and then merged back together.
     * @param       list to be arranged.
     * @param       left from the list, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the list, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the list, index value, must be greater than the {@code left} and {@code mid} value.
     * @see         mz.MergeInterface#mergingDec(List, int, int, int)
     */
    default <L extends T> void mergeDec(List<L> list, int left, int mid, int right) {
        if (left < right) {
            mergeDec(list, left, ((left + mid) / 2), mid);
            mergeDec(list, (mid + 1), (((mid + 1) + right) / 2), right);
            mergingDec(list, left, mid, right);
        }
    }

    /**
     * {@code merge} method merge takes a list {@code list},
     * and the indices {@code left}, {@code mid}, {@code right},
     * as well as the {@code SortFunctional} as parameters for custom sorting logic.
     * <ul>
     *     <li>The method begins with a base case check:
     *     if {@code left} is less than {@code right}, the sorting operation continues.</li>
     *     <li>Inside the base case, the {@code merge} method is recursively called three times:</li>
     *     <li>The first recursive call is made with the indices {@code left}, {@code ((left + mid) / 2)}, {@code mid},
     *     which splits the left half of the list recursively.</li>
     *     <li>The second recursive call is made with the indices {@code (mid + 1)}, {@code (((mid + 1) + right) / 2)}, {@code right},
     *     which splits the right half of the list recursively.</li>
     *     <li>The third recursive call is made to the {@code merging} method with the original indices {@code left}, {@code mid}, and {@code right}.
     *     This is the merge step where two sorted subarrays (from {@code left} to {@code mid} and from {@code (mid + 1)} to {@code right})
     *     are merged into a single sorted list using the provided sorting logic.</li>
     *     <li>The recursion continues until the base case is reached, where {@code left} is no longer less than {@code right}.
     *     At this point, the recursion unwinds,
     *     and the merge operations are performed for each level of recursion until the original list is completely sorted.</li>
     * </ul>
     * merge two sorted subarrays into a single sorted list according to the intended sorting logic.
     * @param       list to be arranged.
     * @param       left from the list, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the list, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the list, index value, must be greater than the {@code left} and {@code mid} value.
     * @param       functional lambda expression for comparison.
     * @see         mz.MergeInterface#merging(List, int, int, int, SortFunctional)
     */
    default <L extends T> void merge(List<L> list, int left, int mid, int right, SortFunctional<T> functional) {
        if (left < right) {
            merge(list, left, ((left + mid) / 2), mid, functional);
            merge(list, (mid + 1), (((mid + 1) + right) / 2), right, functional);
            merging(list, left, mid, right, functional);
        }
    }

    /**
     * {@code mergeInc} method for performing an iterative bottom-up merge sort on a list.
     * It divides the list into subarrays of increasing sizesand merges them together until the entire list is sorted.
     * <ul>
     *     <li>This {@code while} loop iterates until the {@code left} index becomes equal to or greater than the {@code right} index,
     *     indicating that the entire list is sorted.</li>
     *     <li>This {@code for} loop iterates through the list in increments of {@code (left * 2)},
     *     effectively dividing the list into subarrays of size {@code (left * 2)} for merging.</li>
     *     <li>This calculates the indices for the merging operation.
     *     {@code mid} represents the midpoint of the current subarray, and
     *     {@code end} represents the ending index of the current subarray or the ending index of the entire list
     *     if it's reached before the subarray size.</li>
     *     <li>This calls the {@code mergingInc} method to merge the subarray defined by the indices
     *     {@code i}, {@code mid}, and {@code end}.</li>
     *     <li>{@code left *= 2} After each iteration of the outer loop, the {@code left} variable is doubled.
     *     This increases the size of the subarrays being merged in the next iteration.</li>
     * </ul>
     * {@code mergeInc} method performs an iterative bottom-up merge sort by repeatedly merging subarrays of
     * increasing sizes until the entire list is sorted.
     * It utilizes the {@code mergingInc} method to perform the merging operation.
     * @param       list The list to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @see         mz.MergeInterface#mergingInc(List, int, int, int)
     */
    default <L extends T> void mergeInc(List<L> list, int left, int right) {
        while (left < right) {
            for (int i = 0; i < right; i += (left * 2)) {
                int mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                mergingInc(list, i, mid, end);
            }
            left *= 2;
        }
    }

    /**
     * {@code mergeDec} method for performing an iterative bottom-up merge sort on a list.
     * It divides the list into subarrays of increasing sizesand merges them together until the entire list is sorted.
     * <ul>
     *     <li>This {@code while} loop iterates until the {@code left} index becomes equal to or greater than the {@code right} index,
     *     indicating that the entire list is sorted.</li>
     *     <li>This {@code for} loop iterates through the list in increments of {@code (left * 2)},
     *     effectively dividing the list into subarrays of size {@code (left * 2)} for merging.</li>
     *     <li>This calculates the indices for the merging operation.
     *     {@code mid} represents the midpoint of the current subarray, and
     *     {@code end} represents the ending index of the current subarray or the ending index of the entire list
     *     if it's reached before the subarray size.</li>
     *     <li>This calls the {@code mergingDec} method to merge the subarray defined by the indices
     *     {@code i}, {@code mid}, and {@code end}.</li>
     *     <li>{@code left *= 2} After each iteration of the outer loop, the {@code left} variable is doubled.
     *     This decreases the size of the subarrays being merged in the next iteration.</li>
     * </ul>
     * {@code mergeDec} method performs an iterative bottom-up merge sort by repeatedly merging subarrays of
     * increasing sizes until the entire list is sorted.
     * It utilizes the {@code mergingDec} method to perform the merging operation.
     * @param       list The list to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @see         mz.MergeInterface#mergingDec(List, int, int, int)
     */
    default <L extends T> void mergeDec(List<L> list, int left, int right) {
        while (left < right) {
            for (int i = 0; i < right; i += (left * 2)) {
                int mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                mergingDec(list, i, mid, end);
            }
            left *= 2;
        }
    }

    /**
     * {@code merge} method merge takes a list {@code list},
     * indices {@code left} and {@code right}, and a {@code SortFunctional} as parameters that defines the sorting logic.
     * <ul>
     *     <li>The {@code while} loop continues until the {@code left} index is less than the {@code right} index.</li>
     *     <li>Inside the {@code while} loop, there is a {@code for} loop that iterates over the list segments with a size of {@code (left * 2)}.
     *     This means that in each iteration of the {@code for} loop,
     *     the list is divided into segments of length {@code (left * 2)}.</li>
     *     <li>Within the {@code for} loop,
     *     the variables {@code mid} and {@code end} are calculated to determine the indices for the merging operation.</li>
     *     <li>{@code mid} is set to {@code (i + left - 1)},
     *     which is the index of the middle element of the current segment.</li>
     *     <li>{@code end} is set to the minimum value between {@code (i + (left * 2) - 1)} and {@code (right - 1)}.
     *     This ensures that end does not go beyond the right boundary of the list.</li>
     *     <li>The {@code merging} method is called with the list,
     *     the indices {@code i}, {@code mid}, {@code end}, and the {@code functional} as parameters.
     *     The merging method performs the merge operation for the specified list segment using the provided sorting logic.</li>
     *     <li>After the {@code for} loop completes, the {@code left} value is multiplied by 2 to double its value, preparing for the next iteration.
     *     This step ensures that the list segments to be merged in the next iteration are twice as large as in the previous iteration.</li>
     *     <li>The process continues until the {@code left} index is no longer less than the {@code right} index,
     *     indicating that the entire list has been sorted.</li>
     * </ul>
     * For merging two sorted list segments according to the chosen sorting logic.
     * @param       list The list to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @param       functional lambda expression for comparison.
     * @see         mz.MergeInterface#merging(List, int, int, int, SortFunctional)
     */
    default <L extends T> void merge(List<L> list, int left, int right, SortFunctional<T> functional) {
        while (left < right) {
            for (int i = 0; i < right; i += (left * 2)) {
                int mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                merging(list, i, mid, end, functional);
            }
            left *= 2;
        }
    }

    /**
     * {@code mergeInc} method for performing an iterative bottom-up merge sort on a list.
     * It divides the list into subarrays of increasing sizesand merges them together until the entire list is sorted.
     * <ul>
     *     <li>This {@code while} loop iterates until the {@code left} index becomes equal to or greater than the {@code right} index,
     *     indicating that the entire list is sorted.</li>
     *     <li>This {@code for} loop iterates through the list in increments of {@code (left * 2)},
     *     effectively dividing the list into subarrays of size {@code (left * 2)} for merging.</li>
     *     <li>This calculates the indices for the merging operation.
     *     {@code mid} represents the midpoint of the current subarray, and
     *     {@code end} represents the ending index of the current subarray or the ending index of the entire list
     *     if it's reached before the subarray size.</li>
     *     <li>This calls the {@code mergingInc} method to merge the subarray defined by the indices
     *     {@code i}, {@code mid}, and {@code end} into the {@code buffer} list.</li>
     *     <li>{@code left *= 2} After each iteration of the outer loop, the {@code left} variable is doubled.
     *     This increases the size of the subarrays being merged in the next iteration.</li>
     * </ul>
     * {@code mergeInc} method performs an iterative bottom-up merge sort by repeatedly merging subarrays of
     * increasing sizes until the entire list is sorted.
     * It utilizes the {@code mergingInc} method to perform the merging operation.
     * @param       list The list to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @param       buffer An auxiliary list used for merging.
     * @see         mz.MergeInterface#mergingInc(List, int, int, int, List)
     */
    default <L extends T> void mergeInc(List<L> list, int left, int right, List<L> buffer) {
        while (left < right) {
            for (int i = 0; i < right; i += (left * 2)) {
                int mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                mergingInc(list, i, mid, end, buffer);
            }
            left *= 2;
        }
    }

    /**
     * {@code mergeDec} method for performing an iterative bottom-up merge sort on a list.
     * It divides the list into subarrays of increasing sizesand merges them together until the entire list is sorted.
     * <ul>
     *     <li>This {@code while} loop iterates until the {@code left} index becomes equal to or greater than the {@code right} index,
     *     indicating that the entire list is sorted.</li>
     *     <li>This {@code for} loop iterates through the list in increments of {@code (left * 2)},
     *     effectively dividing the list into subarrays of size {@code (left * 2)} for merging.</li>
     *     <li>This calculates the indices for the merging operation.
     *     {@code mid} represents the midpoint of the current subarray, and
     *     {@code end} represents the ending index of the current subarray or the ending index of the entire list
     *     if it's reached before the subarray size.</li>
     *     <li>This calls the {@code mergingDec} method to merge the subarray defined by the indices
     *     {@code i}, {@code mid}, and {@code end} into the {@code buffer} list.</li>
     *     <li>{@code left *= 2} After each iteration of the outer loop, the {@code left} variable is doubled.
     *     This decreases the size of the subarrays being merged in the next iteration.</li>
     * </ul>
     * {@code mergeDec} method performs an iterative bottom-up merge sort by repeatedly merging subarrays of
     * increasing sizes until the entire list is sorted.
     * It utilizes the {@code mergingDec} method to perform the merging operation.
     * @param       list The list to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @param       buffer An auxiliary list used for merging.
     * @see         mz.MergeInterface#mergingDec(List, int, int, int, List)
     */
    default <L extends T> void mergeDec(List<L> list, int left, int right, List<L> buffer) {
        while (left < right) {
            for (int i = 0; i < right; i += (left * 2)) {
                int mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                mergingDec(list, i, mid, end, buffer);
            }
            left *= 2;
        }
    }

    /**
     * {@code merge} method for performing an iterative bottom-up merge sort on a list.
     * It divides the list into subarrays of increasing sizesand merges them together until the entire list is sorted.
     * <ul>
     *     <li>The method takes in parameters {@code left} and {@code right},
     *     which represent the boundaries of the subarray to be merged.
     *     It also takes a {@code buffer} list to store the merged elements and
     *     the {@code functional} instance for element comparison.</li>
     *     <li>The method enters a {@code while} loop that continues as long as {@code left} is less than {@code right}.
     *     This loop iterates over multiple merge passes, doubling the merge size {@code left} in each iteration.</li>
     *     <li>Within the {@code while} loop, there is a {@code for} loop that iterates over subarrays of size {@code (left * 2)}.
     *     The loop variable {@code i} represents the starting index of each subarray.</li>
     *     <li>For each subarray, it calculates the {@code mid} index as {@code (i + left - 1)},
     *     which represents the {@code end} of the first half of the subarray.
     *     The end index is calculated as the minimum of {@code (i + (left * 2) - 1)} and {@code (right - 1)},
     *     ensuring that it does not exceed the right boundary of the list.</li>
     *     <li>It calls the {@code merging} method to merge the subarray,
     *     passing the {@code list}, {@code i}, {@code mid}, {@code end}, {@code buffer},
     *     and {@code functional} as parameters.</li>
     *     <li>After merging a subarray, the {@code left} value is doubled {@code (left *= 2)}
     *     to increase the merge size for the next iteration.</li>
     *     <li>The process continues until {@code left} becomes greater than or equal to {@code right},
     *     indicating that the entire list has been sorted.</li>
     * </ul>
     * {@code merge} method implements a bottom-up merge sort algorithm by repeatedly merging subarrays of increasing sizes.
     * It uses the {@code merging} method to perform the merging operation.
     * The method starts with a merge size of {@code left} and doubles it in each iteration until the entire list is sorted.
     * @param       list The list to be sorted.
     * @param       left The starting index of the subarray to be sorted.
     * @param       right The ending index (exclusive) of the subarray to be sorted.
     * @param       buffer An auxiliary list used for merging.
     * @param       functional lambda expression for comparison.
     * @see         mz.MergeInterface#merging(List, int, int, int, List, SortFunctional)
     */
    default <L extends T> void merge(List<L> list, int left, int right, List<L> buffer, SortFunctional<T> functional) {
        while (left < right) {
            for (int i = 0; i < right; i += (left * 2)) {
                int mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                merging(list, i, mid, end, buffer, functional);
            }
            left *= 2;
        }
    }

    /**
     * {@code mergeInc} method for merging three sorted subarrays into a single list. It takes the indices of the subarray boundaries
     * and uses four pointers {@code i, j, k, l} to iterate through the subarrays and merge them into a buffer list.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}: This annotation suppresses unchecked warnings that might occur when using generics,
     *     indicating that the code will handle any necessary type checking appropriately.</li>
     *     <li>Initializes four pointers {@code i, j, k, l}.
     *     {@code i} points to the current position in the first subarray,
     *     {@code j} points to the current position in the second subarray,
     *     {@code k} points to the current position in the third subarray, and
     *     {@code l} points to the current position in the buffer list.</li>
     *     <li>This {@code while} loop continues as long as all three subarrays have remaining elements to be processed.</li>
     *     <li>This condition checks if the element at position {@code i} in the first subarray is less than the element
     *     at position {@code j} in the second subarray.</li>
     *     <li>{@code if (list.get(k).compareTo(list.get(i)) > 0)}:
     *     This nested condition checks if the element at position {@code i} in the first subarray is also less than the element
     *     at position {@code k} in the third subarray.</li>
     *     <li> If both conditions in steps 5 and 6 are true, the element at position {@code i} in the first subarray is copied to
     *     the {@code buffer} list at position {@code l}.
     *     Then, both {@code i} and {@code l} pointers are incremented.</li>
     *     <li>If the condition in step 6 is false, the element at position {@code k} in the third subarray is selected for merging.</li>
     *     <li>The element at position {@code k} in the third subarray is copied to the {@code buffer} list at position {@code l}.
     *     Then, both {@code k} and {@code l} pointers are incremented.</li>
     *     <li>If the condition in step 5 is false, the element at position {@code j} in the second subarray is selected for merging.</li>
     *     <li>{@code if (list.get(k).compareTo(list.get(j)) > 0)}:
     *     This nested condition checks if the element at position {@code j} in the second subarray is less than the element
     *     at position {@code k} in the third subarray.</li>
     *     <li>If the condition in step 11 is true, the element at position {@code j} in the second subarray is copied to
     *     the {@code buffer} list at position {@code l}.
     *     Then, both {@code j} and {@code l} pointers are incremented.</li>
     *     <li>If the condition in step 11 is false, the element at position {@code k} in the third subarray is selected for merging.</li>
     *     <li>The element at position {@code k} in the third subarray is copied to the buffer list at position {@code l}.
     *     Then, both {@code k} and {@code l} pointers are incremented.</li>
     *     <li>The following three while loops merge any remaining elements
     *     in pairs of subarrays {@code ((i, j), (j, k), (i, k))} into the buffer list, similar to the previous steps.</li>
     *     <li>The remaining three {@code while} loops copy any remaining elements from the subarrays {@code i, j, k} to the buffer list.</li>
     * </ul>
     * {@code mergeInc} this method merges three sorted subarrays into a single sorted list using four pointers to iterate through
     * the subarrays and merge their elements into a buffer list.
     * The merged elements are then copied back to the original {@code list}.
     * @param       list The list containing the subarrays to be merged.
     * @param       left The starting index of the first subarray.
     * @param       mid1 The ending index (exclusive) of the first subarray.
     * @param       mid2 The ending index (exclusive) of the second subarray.
     * @param       right The ending index (exclusive) of the third subarray.
     * @param       buffer An auxiliary list used for merging.
     */
    @SuppressWarnings("unchecked")
    default <L extends T> void mergeInc(List<L> list, int left, int mid1, int mid2, int right, List<L> buffer) {
        int i = left, j = mid1, k = mid2, l = left;
        while ((i < mid1) && (j < mid2) && (k < right)) {
            if (list.get(j).compareTo(list.get(i)) > 0) {
                if (list.get(k).compareTo(list.get(i)) > 0) {
                    buffer.add(l++, list.get(i++));
                } else {
                    buffer.add(l++, list.get(k++));
                }
            } else {
                if (list.get(k).compareTo(list.get(j)) > 0) {
                    buffer.add(l++, list.get(j++));
                } else {
                    buffer.add(l++, list.get(k++));
                }
            }
        }
        while ((i < mid1) && (j < mid2)) {
            if (list.get(j).compareTo(list.get(i)) > 0) {
                buffer.add(l++, list.get(i++));
            } else {
                buffer.add(l++, list.get(j++));
            }
        }
        while ((j < mid2) && (k < right)) {
            if (list.get(k).compareTo(list.get(j)) > 0) {
                buffer.add(l++, list.get(j++));
            } else {
                buffer.add(l++, list.get(k++));
            }
        }
        while ((i < mid1) && (k < right)) {
            if (list.get(k).compareTo(list.get(i)) > 0) {
                buffer.add(l++, list.get(i++));
            } else {
                buffer.add(l++, list.get(k++));
            }
        }
        while (i < mid1) {
            buffer.add(l++, list.get(i++));
        }
        while (j < mid2) {
            buffer.add(l++, list.get(j++));
        }
        while (k < right) {
            buffer.add(l++, list.get(k++));
        }
    }

    /**
     * {@code mergeDec} method for merging three sorted subarrays into a single list. It takes the indices of the subarray boundaries
     * and uses four pointers {@code i, j, k, l} to iterate through the subarrays and merge them into a buffer list.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}: This annotation suppresses unchecked warnings that might occur when using generics,
     *     indicating that the code will handle any necessary type checking appropriately.</li>
     *     <li>Initializes four pointers {@code i, j, k, l}.
     *     {@code i} points to the current position in the first subarray,
     *     {@code j} points to the current position in the second subarray,
     *     {@code k} points to the current position in the third subarray, and
     *     {@code l} points to the current position in the buffer list.</li>
     *     <li>This {@code while} loop continues as long as all three subarrays have remaining elements to be processed.</li>
     *     <li>This condition checks if the element at position {@code i} in the first subarray is more than the element
     *     at position {@code j} in the second subarray.</li>
     *     <li>{@code if (list.get(j).compareTo(list.get(i)) < 0)}:
     *     This nested condition checks if the element at position {@code i} in the first subarray is also less than the element
     *     at position {@code k} in the third subarray.</li>
     *     <li> If both conditions in steps 5 and 6 are true, the element at position {@code i} in the first subarray is copied to
     *     the {@code buffer} list at position {@code l}.
     *     Then, both {@code i} and {@code l} pointers are incremented.</li>
     *     <li>If the condition in step 6 is false, the element at position {@code k} in the third subarray is selected for merging.</li>
     *     <li>The element at position {@code k} in the third subarray is copied to the {@code buffer} list at position {@code l}.
     *     Then, both {@code k} and {@code l} pointers are incremented.</li>
     *     <li>If the condition in step 5 is false, the element at position {@code j} in the second subarray is selected for merging.</li>
     *     <li>{@code if (list.get(k).compareTo(list.get(j)) < 0)}:
     *     This nested condition checks if the element at position {@code j} in the second subarray is more than the element
     *     at position {@code k} in the third subarray.</li>
     *     <li>If the condition in step 11 is true, the element at position {@code j} in the second subarray is copied to
     *     the {@code buffer} list at position {@code l}.
     *     Then, both {@code j} and {@code l} pointers are incremented.</li>
     *     <li>If the condition in step 11 is false, the element at position {@code k} in the third subarray is selected for merging.</li>
     *     <li>The element at position {@code k} in the third subarray is copied to the buffer list at position {@code l}.
     *     Then, both {@code k} and {@code l} pointers are incremented.</li>
     *     <li>The following three while loops merge any remaining elements
     *     in pairs of subarrays {@code ((i, j), (j, k), (i, k))} into the buffer list, similar to the previous steps.</li>
     *     <li>The remaining three {@code while} loops copy any remaining elements from the subarrays {@code i, j, k} to the buffer list.</li>
     * </ul>
     * {@code mergeInc} this method merges three sorted subarrays into a single sorted list using four pointers to iterate through
     * the subarrays and merge their elements into a buffer list.
     * The merged elements are then copied back to the original {@code list}.
     * @param       list The list containing the subarrays to be merged.
     * @param       left The starting index of the first subarray.
     * @param       mid1 The ending index (exclusive) of the first subarray.
     * @param       mid2 The ending index (exclusive) of the second subarray.
     * @param       right The ending index (exclusive) of the third subarray.
     * @param       buffer An auxiliary list used for merging.
     */
    @SuppressWarnings("unchecked")
    default <L extends T> void mergeDec(List<L> list, int left, int mid1, int mid2, int right, List<L> buffer) {
        int i = left, j = mid1, k = mid2, l = left;
        while ((i < mid1) && (j < mid2) && (k < right)) {
            if (list.get(j).compareTo(list.get(i)) < 0) {
                if (list.get(k).compareTo(list.get(i)) < 0) {
                    buffer.add(l++, list.get(i++));
                } else {
                    buffer.add(l++, list.get(k++));
                }
            } else {
                if (list.get(k).compareTo(list.get(j)) < 0) {
                    buffer.add(l++, list.get(j++));
                } else {
                    buffer.add(l++, list.get(k++));
                }
            }
        }
        while ((i < mid1) && (j < mid2)) {
            if (list.get(j).compareTo(list.get(i)) < 0) {
                buffer.add(l++, list.get(i++));
            } else {
                buffer.add(l++, list.get(j++));
            }
        }
        while ((j < mid2) && (k < right)) {
            if (list.get(k).compareTo(list.get(j)) < 0) {
                buffer.add(l++, list.get(j++));
            } else {
                buffer.add(l++, list.get(k++));
            }
        }
        while ((i < mid1) && (k < right)) {
            if (list.get(k).compareTo(list.get(i)) < 0) {
                buffer.add(l++, list.get(i++));
            } else {
                buffer.add(l++, list.get(k++));
            }
        }
        while (i < mid1) {
            buffer.add(l++, list.get(i++));
        }
        while (j < mid2) {
            buffer.add(l++, list.get(j++));
        }
        while (k < right) {
            buffer.add(l++, list.get(k++));
        }
    }

    /**
     * {@code mergeDec} method for merging three sorted subarrays into a single list. It takes the indices of the subarray boundaries
     * and uses four pointers {@code i, j, k, l} and an instance of {@code SortFunctional<T>} as parameters,
     * to iterate through the subarrays and merge them into a buffer list.
     * <ul>
     *     <li>The method takes in additional parameters {@code mid1} and {@code mid2},
     *     which represent the boundaries of the two middle subarrays.</li>
     *     <li>It initializes variables {@code i, j, k, l} to keep track of
     *     the current indices in the three subarrays and the merged list ({@code buffer}), respectively.
     *     The initial value of {@code l} is set to {@code left}.</li>
     *     <li>It enters a {@code while} loop that continues as long as {@code i} is less than {@code mid1}, {@code j}
     *     is less than {@code mid2}, and {@code k} is less than {@code right}.
     *     Within the loop, it performs comparisons using the {@code functional} instance to determine the order of the elements.</li>
     *     <li>If {@code list.get(j)} is smaller than {@code list.get(i)},
     *     it further checks if {@code list.get(k)} is also smaller than {@code list.get(i)}.
     *     If so, it assigns {@code list.get(i)} to {@code buffer.get(l++)} and increments {@code i}.
     *     Otherwise, it assigns {@code list.get(k)} to {@code buffer.get(l++)} and increments {@code k}.</li>
     *     <li>If {@code list.get(i)} is smaller than or equal to {@code list.get(j)},
     *     it checks if {@code list.get(k)} is smaller than {@code list.get(j)}.
     *     If so, it assigns {@code list.get(j)} to {@code buffer.get(l++)} and increments {@code j}.
     *     Otherwise, it assigns {@code list.get(k)} to {@code buffer.get(l++)} and increments {@code k}.</li>
     *     <li>After the {@code while} loop, there are three possible cases:</li>
     *     <li>Elements remaining in both the first and second subarrays:
     *     It compares {@code list.get(j)} and {@code list.get(i)} using
     *     the {@code functional} instance and assigns the smaller element to {@code buffer.get(l++)}.
     *     It then increments the corresponding counters {@code i} and {@code j}.</li>
     *     <li>Elements remaining in the second and third subarrays:
     *     It compares {@code list.get(k)} and {@code list.get(j)} using
     *     the {@code functional} instance and assigns the smaller element to {@code buffer.get(l++)}.
     *     It then increments the corresponding counters {@code j} and {@code k}.</li>
     *     <li>Elements remaining in the first and third subarrays:
     *     It compares {@code list.get(k)} and {@code list.get(i)} using
     *     the {@code functional} instance and assigns the smaller element to {@code buffer.get(l++)}.
     *     It then increments the corresponding counters {@code i} and {@code k}.</li>
     *     <li>It handles the remaining elements in the first, second, and third subarrays
     *     individually using separate {@code while} loops.
     *     It assigns the remaining elements to {@code buffer.get(l++)} and increments the corresponding counters.</li>
     * </ul>
     * {@code merge} method performs a three-way merge of subarrays within the {@code list} by comparing elements using the {@code functional} instance.
     * It maintains separate indices for each subarray and incrementally merges the elements into the {@code buffer} list.
     * After merging all the elements, it copies the merged elements back to the original {@code list}.
     * @param       list The list containing the subarrays to be merged.
     * @param       left The starting index of the first subarray.
     * @param       mid1 The ending index (exclusive) of the first subarray.
     * @param       mid2 The ending index (exclusive) of the second subarray.
     * @param       right The ending index (exclusive) of the third subarray.
     * @param       buffer An auxiliary list used for merging.
     * @param       functional lambda expression for comparison.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default <L extends T> void merge(List<L> list, int left, int mid1, int mid2, int right, List<L> buffer, SortFunctional<T> functional) {
        int i = left, j = mid1, k = mid2, l = left;
        while ((i < mid1) && (j < mid2) && (k < right)) {
            if (functional.functionalCompareTo(list.get(j), list.get(i))) {
                if (functional.functionalCompareTo(list.get(k), list.get(i))) {
                    buffer.add(l++, list.get(i++));
                } else {
                    buffer.add(l++, list.get(k++));
                }
            } else {
                if (functional.functionalCompareTo(list.get(k), list.get(j))) {
                    buffer.add(l++, list.get(j++));
                } else {
                    buffer.add(l++, list.get(k++));
                }
            }
        }
        while ((i < mid1) && (j < mid2)) {
            if (functional.functionalCompareTo(list.get(j), list.get(i))) {
                buffer.add(l++, list.get(i++));
            } else {
                buffer.add(l++, list.get(j++));
            }
        }
        while ((j < mid2) && (k < right)) {
            if (functional.functionalCompareTo(list.get(k), list.get(j))) {
                buffer.add(l++, list.get(j++));
            } else {
                buffer.add(l++, list.get(k++));
            }
        }
        while ((i < mid1) && (k < right)) {
            if (functional.functionalCompareTo(list.get(k), list.get(i))) {
                buffer.add(l++, list.get(i++));
            } else {
                buffer.add(l++, list.get(k++));
            }
        }
        while (i < mid1) {
            buffer.add(l++, list.get(i++));
        }
        while (j < mid2) {
            buffer.add(l++, list.get(j++));
        }
        while (k < right) {
            buffer.add(l++, list.get(k++));
        }
    }

    /**
     * {@code mergingInc} that performs a merging operation for the purpose of merging two sorted portions of a list into a single sorted portion.
     * The method assumes that the left portion of the list, from index {@code left} to {@code mid}, and the {@code right} portion,
     * from index {@code (mid + 1)} to {@code right}, are already sorted in increasing order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@code compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method starts by checking if the indices {@code left}, {@code mid}, and {@code right} are within valid bounds.
     *     If the {@code condition left > mid || mid + 1 > right} is true, it means that either the left portion or
     *     the right portion is empty or the indices are not properly specified.
     *     In such cases, the method returns without performing any merging.</li>
     *     <li>The variables {@code n1} and {@code n2} are assigned the sizes of the left and right portions, respectively.</li>
     *     <li>The left sublist is obtained using {@link java.util.List#subList(int, int) subList} from {@code  left} to {@code (mid + 1)},
     *     while the right sublist is obtained using {@code subList} from {@code (mid + 1)} to {@code (right + 1)}.</li>
     *     <li>The variables {@code i} and {@code j} are used as indices to iterate over {@code leftArray} and {@code rightArray}, respectively.</li>
     *     <li>The variable {@code k} is used as an index to update the {@code list} with the merged elements.</li>
     *     <li>The subsequent {@code while} loop continues as long as both {@code i} and {@code j} are within their respective list sizes, {@code n1} and {@code n2}.
     *     It compares the elements at indices {@code i} and {@code j} of {@code leftArray} and {@code rightArray},
     *     respectively, and assigns the smaller element to {@code list.get(k)}.
     *     The corresponding index ({@code i} or {@code j}) and {@code k} are incremented accordingly.</li>
     *     <li>After the {@code while} loop, there might still be remaining elements in either {@code leftArray} or {@code rightArray}.
     *     The next two {@code while} loops handle the remaining elements by copying them into list starting from index {@code k}.</li>
     *     <li>Finally, the merging operation is complete, and the merged sorted portion is stored in the original {@code list} from index {@code left} to {@code right}.</li>
     * </ul>
     * {@code mergingInc} method is commonly used as part of merge sort algorithms to merge two sorted portions of a list into a single sorted portion.
     * @param       list to be arranged.
     * @param       left from the list, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the list, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the list, index value, must be greater than the {@code left} and {@code mid} value.
     */
    @SuppressWarnings("unchecked")
    default <L extends T> void mergingInc(List<L> list, int left, int mid, int right) {
        if ((left > mid) || ((mid + 1) > right)) {
            return;
        }
        int n1 = (mid - left + 1), n2 = (right - mid), i = 0, j = 0, k = left;
        List<L> leftList = list.subList(left, (mid + 1)), rightList = list.subList((mid + 1), (right + 1));
        while (i < n1 && j < n2) {
            if (rightList.get(j).compareTo(leftList.get(i)) > 0) {
                list.set(k, leftList.get(i++));
            } else {
                list.set(k, rightList.get(j++));
            }
            k++;
        }
        while (i < n1) {
            list.set(k++, leftList.get(i++));
        }
        while (j < n2) {
            list.set(k++, rightList.get(j++));
        }
    }

    /**
     * {@code mergingDec} that performs a merging operation for the purpose of merging two sorted portions of a list into a single sorted portion.
     * The method assumes that the left portion of the list, from index {@code left} to {@code mid}, and the {@code right} portion,
     * from index {@code (mid + 1)} to {@code right}, are already sorted in increasing order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to unchecked type casting when using the {@code compareTo} method.
     *     This annotation is not directly related to the functionality of the method but rather a way to handle warnings.</li>
     *     <li>The method starts by checking if the indices {@code left}, {@code mid}, and {@code right} are within valid bounds.
     *     If the {@code condition left > mid || mid + 1 > right} is true, it means that either the left portion or
     *     the right portion is empty or the indices are not properly specified.
     *     In such cases, the method returns without performing any merging.</li>
     *     <li>The variables {@code n1} and {@code n2} are assigned the sizes of the left and right portions, respectively.</li>
     *     <li>The left sublist is obtained using {@link java.util.List#subList(int, int) subList} from {@code  left} to {@code (mid + 1)},
     *     while the right sublist is obtained using {@code subList} from {@code (mid + 1)} to {@code (right + 1)}.</li>
     *     <li>The variables {@code i} and {@code j} are used as indices to iterate over {@code leftArray} and {@code rightArray}, respectively.</li>
     *     <li>The variable {@code k} is used as an index to update the {@code list} with the merged elements.</li>
     *     <li>The subsequent {@code while} loop continues as long as both {@code i} and {@code j} are within their respective list sizes, {@code n1} and {@code n2}.
     *     It compares the elements at indices {@code i} and {@code j} of {@code leftArray} and {@code rightArray},
     *     respectively, and assigns the greater element to {@code list.get(k)}.
     *     The corresponding index ({@code i} or {@code j}) and {@code k} are incremented accordingly.</li>
     *     <li>After the {@code while} loop, there might still be remaining elements in either {@code leftArray} or {@code rightArray}.
     *     The next two {@code while} loops handle the remaining elements by copying them into list starting from index {@code k}.</li>
     *     <li>Finally, the merging operation is complete, and the merged sorted portion is stored in the original {@code list} from index {@code left} to {@code right}.</li>
     * </ul>
     * {@code mergingDec} method is commonly used as part of merge sort algorithms to merge two sorted portions of a list into a single sorted portion.
     * @param       list to be arranged.
     * @param       left from the list, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the list, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the list, index value, must be greater than the {@code left} and {@code mid} value.
     */
    @SuppressWarnings("unchecked")
    default <L extends T> void mergingDec(List<L> list, int left, int mid, int right) {
        if ((left > mid) || ((mid + 1) > right)) {
            return;
        }
        int n1 = (mid - left + 1), n2 = (right - mid), i = 0, j = 0, k = left;
        List<L> leftList = list.subList(left, (mid + 1)), rightList = list.subList((mid + 1), (right + 1));
        while (i < n1 && j < n2) {
            if (rightList.get(j).compareTo(leftList.get(i)) < 0) {
                list.set(k, leftList.get(i++));
            } else {
                list.set(k, rightList.get(j++));
            }
            k++;
        }
        while (i < n1) {
            list.set(k++, leftList.get(i++));
        }
        while (j < n2) {
            list.set(k++, rightList.get(j++));
        }
    }

    /**
     * {@code merging} that performs a merging operation for the purpose of merging two sorted portions of a list into a single sorted portion.
     * The method assumes that the left portion of the list, from index {@code left} to {@code mid}, and the {@code right} portion,
     * from index {@code (mid + 1)} to {@code right},
     * and an instance of {@code mz.SortFunctional<T>} as parameters,
     * are already sorted in increasing order.
     * <ul>
     *     <li>{@code merging} method now includes an additional check at the beginning.
     *     If the condition {@code (left > mid) || ((mid + 1) > right)} is satisfied,
     *     it means that either the left subarray is empty or the right subarray is empty,
     *     indicating that there is no need to perform the merging. In such cases, the method simply returns.</li>
     *     <li>It initializes variables {@code n1} and {@code n2} to store the sizes of the left and right subarrays, respectively.
     *     The values are calculated as {@code (mid - left + 1)} and {@code (right - mid)}.</li>
     *     <li>It initializes counters {@code i}, {@code j}, and {@code k} to keep track of the current indices in the left list, right list,
     *     and the merged list ({@code list}), respectively.
     *     The initial value of {@code k} is set to {@code left}.</li>
     *     <li>The left sublist is obtained using {@link java.util.List#subList(int, int) subList} from {@code  left} to {@code (mid + 1)},
     *     while the right sublist is obtained using {@code subList} from {@code (mid + 1)} to {@code (right + 1)}.</li>
     *     <li>It enters a {@code while} loop that continues as long as both {@code i} and {@code j} are within their respective
     *     subarray bounds ({@code (i < n1 && j < n2)}).
     *     Within the loop, it performs the comparison using
     *     the {@code functional} instance and assigns the smaller element to {@code list.get(k)}.
     *     After assigning the element, it increments the corresponding counters ({@code i}, {@code j}, and {@code k}).</li>
     *     <li>After exiting the {@code while} loop, it checks if there are any remaining elements in the left subarray {@code (i < n1)}.
     *     If so, it copies the remaining elements to {@code list.get(k)} and increments both {@code i} and {@code k}.</li>
     *     <li>Similarly, it checks if there are any remaining elements in the right subarray {@code (j < n2)}.
     *     If so, it copies the remaining elements to {@code list.get(k)} and increments both {@code j} and {@code k}.</li>
     * </ul>
     * {@code merging} method merges two sorted subarrays ({@code leftArray} and {@code rightArray}) into a single sorted list ({@code list}).
     * It compares elements using the {@code functional} instance and assigns the smaller element to {@code list.get(k)} at each step.
     * The method handles cases where one of the subarrays is empty or when there are remaining elements in either
     * the left or right subarray after the initial merging.
     * @param       list to be arranged.
     * @param       left from the list, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the list, index value, must be smaller than the {@code right} value, and must be greater than the {@code left}.
     * @param       right from the list, index value, must be greater than the {@code left} and {@code mid} value.
     * @param       functional lambda expression for comparison.
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default <L extends T> void merging(List<L> list, int left, int mid, int right, SortFunctional<T> functional) {
        if ((left > mid) || ((mid + 1) > right)) {
            return;
        }
        int n1 = (mid - left + 1), n2 = (right - mid), i = 0, j = 0, k = left;
        List<L> leftList = list.subList(left, (mid + 1)), rightList = list.subList((mid + 1), (right + 1));
        while (i < n1 && j < n2) {
            if (functional.functionalCompareTo(rightList.get(j), leftList.get(i))) {
                list.set(k, leftList.get(i++));
            } else {
                list.set(k, rightList.get(j++));
            }
            k++;
        }
        while (i < n1) {
            list.set(k++, leftList.get(i++));
        }
        while (j < n2) {
            list.set(k++, rightList.get(j++));
        }
    }

    /**
     * {@code mergingInc} method for merging two sorted subarrays within a list using the merge sort algorithm.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}: This annotation suppresses unchecked warnings that might occur when using generics,
     *     indicating that the code will handle any necessary type checking appropriately.</li>
     *     <li>Initializes two pointers {@code n1} and {@code n2} to keep track of
     *     the current positions within the subarrays to be merged.
     *     {@code n1} is initially set to the leftmost index, and {@code n2} is set to the index immediately after the midpoint.</li>
     *     <li>This loop iterates from the {@code left} index to the {@code right} index (inclusive) to merge the subarrays.</li>
     *     <li>This condition checks if the current element at position {@code n1} in the left subarray is less than or equal to
     *     the current element at position {@code n2} in the right subarray.
     *     It also checks if the {@code n2} pointer has reached the end of the right subarray.
     *     If either of these conditions is true, the element at {@code n1} is selected for merging.</li>
     *     <li>If the condition in the previous step is true, the element at position {@code n1} in
     *     the left subarray is copied to the {@code buffer} list at position {@code i}.
     *     Then, the {@code n1} pointer is incremented.</li>
     *     <li>If the condition in step 5 is false, the element at position {@code n2} in the right subarray is selected for merging.</li>
     *     <li>The element at position {@code n2} in the right subarray is copied to the {@code buffer} list at position {@code i}.
     *     Then, the {@code n2} pointer is incremented.</li>
     *     <li>First remove the elements from {@code list} using the {@link java.util.List#subList(int, int) subList}
     *     method and then clear the sublist using {@link java.util.List#clear() clear()}.</li>
     *     <li>Next, we use {@link java.util.List#addAll(int, Collection) addAll}
     *     to add the elements from {@code buffer} to {@code list}.
     *     We use subList again to get the sublist from {@code buffer} that corresponds to the range {@code (left, right + 1)}.</li>
     *     <li>The {@code addAll} operation is performed at the specified index {@code left},
     *     ensuring that the elements from {@code buffer} are inserted at the correct position in {@code list}.</li>
     * </ul>
     * {@code mergingInc} this method performs the merging step of the merge sort algorithm by comparing elements from two sorted subarrays
     * and merging them into a temporary buffer list.
     * After the merging is complete, the merged elements are copied back {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy} to the original list.
     * @param       list to be arranged.
     * @param       left The index of the leftmost element of the subarray to be merged.
     * @param       mid The index of the midpoint element in the subarray to be merged.
     * @param       right The index of the rightmost element of the subarray to be merged.
     * @param       buffer An auxiliary list used for storing the merged elements temporarily.
     */
    @SuppressWarnings("unchecked")
    default <L extends T> void mergingInc(List<L> list, int left, int mid, int right, List<L> buffer) {
        int n1 = left, n2 = (mid + 1);
        for (int i = left; i <= right; i++) {
            if ((n1 <= mid) && ((n2 > right) || (list.get(n2).compareTo(list.get(n1)) >= 0))) {
                buffer.add(i, list.get(n1++));
            } else {
                buffer.add(i, list.get(n2++));
            }
        }
        list.subList(left, right + 1).clear();
        list.addAll(left, buffer.subList(left, right + 1));
    }

    /**
     * {@code mergingDec} method for merging two sorted subarrays within a list using the merge sort algorithm.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}: This annotation suppresses unchecked warnings that might occur when using generics,
     *     indicating that the code will handle any necessary type checking appropriately.</li>
     *     <li>Initializes two pointers {@code n1} and {@code n2} to keep track of
     *     the current positions within the subarrays to be merged.
     *     {@code n1} is initially set to the leftmost index, and {@code n2} is set to the index immediately after the midpoint.</li>
     *     <li>This loop iterates from the {@code left} index to the {@code right} index (inclusive) to merge the subarrays.</li>
     *     <li>This condition checks if the current element at position {@code n1} in the left subarray is more than or equal to
     *     the current element at position {@code n2} in the right subarray.
     *     It also checks if the {@code n2} pointer has reached the end of the right subarray.
     *     If either of these conditions is true, the element at {@code n1} is selected for merging.</li>
     *     <li>If the condition in the previous step is true, the element at position {@code n1} in
     *     the left subarray is copied to the {@code buffer} list at position {@code i}.
     *     Then, the {@code n1} pointer is incremented.</li>
     *     <li>If the condition in step 5 is false, the element at position {@code n2} in the right subarray is selected for merging.</li>
     *     <li>The element at position {@code n2} in the right subarray is copied to the {@code buffer} list at position {@code i}.
     *     Then, the {@code n2} pointer is incremented.</li>
     *     <li>First remove the elements from {@code list} using the {@link java.util.List#subList(int, int) subList}
     *     method and then clear the sublist using {@link java.util.List#clear() clear()}.</li>
     *     <li>Next, we use {@link java.util.List#addAll(int, Collection) addAll}
     *     to add the elements from {@code buffer} to {@code list}.
     *     We use subList again to get the sublist from {@code buffer} that corresponds to the range {@code (left, right + 1)}.</li>
     *     <li>The {@code addAll} operation is performed at the specified index {@code left},
     *     ensuring that the elements from {@code buffer} are inserted at the correct position in {@code list}.</li>
     * </ul>
     * {@code mergingDec} this method performs the merging step of the merge sort algorithm by comparing elements from two sorted subarrays
     * and merging them into a temporary buffer list.
     * After the merging is complete, the merged elements are copied back {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy} to the original list.
     * @param       list to be arranged.
     * @param       left The index of the leftmost element of the subarray to be merged.
     * @param       mid The index of the midpoint element in the subarray to be merged.
     * @param       right The index of the rightmost element of the subarray to be merged.
     * @param       buffer An auxiliary list used for storing the merged elements temporarily.
     */
    @SuppressWarnings("unchecked")
    default <L extends T> void mergingDec(List<L> list, int left, int mid, int right, List<L> buffer) {
        int n1 = left, n2 = (mid + 1);
        for (int i = left; i <= right; i++) {
            if ((n1 <= mid) && ((n2 > right) || (list.get(n2).compareTo(list.get(n1)) <= 0))) {
                buffer.add(i, list.get(n1++));
            } else {
                buffer.add(i, list.get(n2++));
            }
        }
        list.subList(left, right + 1).clear();
        list.addAll(left, buffer.subList(left, right + 1));
    }

    /**
     * {@code merging} method now takes additional parameters compared to the previous version:
     * {@code buffer}, an auxiliary list of type {@code List<T>},
     * and the indices {@code left}, {@code mid}, and {@code right} that define the range of elements to be merged.
     * <ul>
     *     <li>It initializes two variables: {@code n1} to track the index of the current element in the left subarray,
     *     and {@code n2} to track the index of the current element in the right subarray.</li>
     *     <li>It creates a {@code functionalAddEquals} instance using the {@code functionalComparableToAddEquals} method,
     *     which is responsible for defining the comparison logic for determining element order.</li>
     *     <li>It enters a {@code for} loop that iterates over the range from {@code left} to {@code right} (inclusive).
     *     Within the loop, it checks two conditions:</li>
     *     <li>If {@code n1} is within the range of the left subarray and either {@code n2} is out of the range of
     *     the right subarray or the comparison between the elements at indices {@code n2} and {@code n1} indicates that
     *     the element in the right subarray is greater or equal,
     *     it assigns the element from the left subarray to {@code buffer[i]} and increments {@code n1}.</li>
     *     <li>Otherwise, it assigns the element from the right subarray to {@code buffer[i]} and increments {@code n2}.</li>
     *     <li>First remove the elements from {@code list} using the {@link java.util.List#subList(int, int) subList}
     *     method and then clear the sublist using {@link java.util.List#clear() clear()}.</li>
     *     <li>Next, we use {@link java.util.List#addAll(int, Collection) addAll}
     *     to add the elements from {@code buffer} to {@code list}.
     *     We use subList again to get the sublist from {@code buffer} that corresponds to the range {@code (left, right + 1)}.</li>
     *     <li>The {@code addAll} operation is performed at the specified index {@code left},
     *     ensuring that the elements from {@code buffer} are inserted at the correct position in {@code list}.</li>
     * </ul>
     * {@code merging} method merges two sorted subarrays, specified by the indices {@code left}, {@code mid}, and {@code right},
     * into a single sorted list {@code list}.
     * It utilizes an auxiliary {@code buffer} list to store the merged result temporarily.
     * The comparison logic for element order is determined by the {@code functional} instance,
     * specifically through the {@code functionalComparableToAddEquals} method.
     * @param       list to be arranged.
     * @param       left The index of the leftmost element of the subarray to be merged.
     * @param       mid The index of the midpoint element in the subarray to be merged.
     * @param       right The index of the rightmost element of the subarray to be merged.
     * @param       buffer An auxiliary list used for storing the merged elements temporarily.
     * @param       functional lambda expression for comparison.
     * @see         mz.Sort#functionalComparableToAddEquals(SortFunctional)
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default <L extends T> void merging(List<L> list, int left, int mid, int right, List<L> buffer, SortFunctional<T> functional) {
        int n1 = left, n2 = (mid + 1);
        SortFunctional<T> functionalAddEquals = functionalComparableToAddEquals(functional);
        for (int i = left; i <= right; i++) {
            if ((n1 <= mid) && ((n2 > right) || (functionalAddEquals.functionalCompareTo(list.get(n2), list.get(n1))))) {
                buffer.add(i, list.get(n1++));
            } else {
                buffer.add(i, list.get(n2++));
            }
        }
        list.subList(left, right + 1).clear();
        list.addAll(left, buffer.subList(left, right + 1));
    }

    /**
     * {@code mergingInc} method for merging two sorted subarrays into a single list.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}: This annotation suppresses unchecked warnings that might occur when using generics,
     *     indicating that the code will handle any necessary type checking appropriately.</li>
     *     <li>Initializes three pointers {@code i, j, k}. {@code i} points to the current position in the left subarray,
     *     {@code j} points to the current position in the right subarray, and {@code k} points to the current position in the merged list.</li>
     *     <li>This {@code while} loop continues as long as both {@code i} and {@code j} are within the bounds of their respective subarrays.</li>
     *     <li>{@code if (rightList.get(j).compareTo(leftList.get(i)) > 0)}:
     *     This condition checks if the element at position {@code i} in the left subarray is less than the element at position {@code j} in the right subarray.
     *     If true, the element from the left subarray is selected for merging.</li>
     *     <li>If the condition in the previous step is true, the element at position {@code i} in the left subarray is copied to the {@code list} at position {@code k}.
     *     Then, all three pointers {@code i, j, k} are incremented.</li>
     *     <li>If the condition in step 5 is false, the element at position {@code j} in the right subarray is selected for merging.</li>
     *     <li>The element at position {@code j} in the right subarray is copied to the {@code list} at position {@code k}.
     *     Then, all three pointers {@code i, j, k} are incremented.</li>
     *     <li>This {@code while} loop copies any remaining elements in the left subarray to the {@code list} if there are any.</li>
     *     <li>The remaining element at position {@code i} in the left subarray is copied to the {@code list} at position {@code k}.
     *     Then, both i and {@code k} pointers are incremented.</li>
     *     <li>This loop copies any remaining elements in the right subarray to the {@code list} if there are any.</li>
     *     <li>The remaining element at position {@code j} in the right subarray is copied to the {@code list} at position {@code k}.
     *     Then, both {@code j} and {@code k} pointers are incremented.</li>
     * </ul>
     * {@code mergingInc} this method merges two sorted subarrays {@code leftList} and {@code rightList} into a single sorted list {@code list}.
     * It compares elements from both subarrays and copies them to the {@code list} in the correct order until one of the subarrays is fully processed.
     * Then, it copies any remaining elements from the unfinished subarray to the list.
     * @param       list to be arranged.
     * @param       leftList The left subarray that is sorted in ascending order.
     * @param       rightList The right subarray that is sorted in ascending order.
     */
    @SuppressWarnings("unchecked")
    default <L extends T> void mergingInc(List<L> list, List<L> leftList, List<L> rightList) {
        int i = 0, j = 0, k = 0;
        while ((i < leftList.size()) && (j < rightList.size())) {
            if (rightList.get(j).compareTo(leftList.get(i)) > 0) {
                list.set(k++, leftList.get(i++));
            } else {
                list.set(k++, rightList.get(j++));
            }
        }
        while (i < leftList.size()) {
            list.set(k++, leftList.get(i++));
        }
        while (j < rightList.size()) {
            list.set(k++, rightList.get(j++));
        }
    }

    /**
     * {@code mergingDec} method for merging two sorted subarrays into a single list.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")}: This annotation suppresses unchecked warnings that might occur when using generics,
     *     indicating that the code will handle any necessary type checking appropriately.</li>
     *     <li>Initializes three pointers {@code i, j, k}. {@code i} points to the current position in the left subarray,
     *     {@code j} points to the current position in the right subarray, and {@code k} points to the current position in the merged list.</li>
     *     <li>This {@code while} loop continues as long as both {@code i} and {@code j} are within the bounds of their respective subarrays.</li>
     *     <li>{@code if (rightList.get(j).compareTo(leftList.get(i)) < 0)}:
     *     This condition checks if the element at position {@code i} in the left subarray is more than the element at position {@code j} in the right subarray.
     *     If true, the element from the left subarray is selected for merging.</li>
     *     <li>If the condition in the previous step is true, the element at position {@code i} in the left subarray is copied to the {@code list} at position {@code k}.
     *     Then, all three pointers {@code i, j, k} are incremented.</li>
     *     <li>If the condition in step 5 is false, the element at position {@code j} in the right subarray is selected for merging.</li>
     *     <li>The element at position {@code j} in the right subarray is copied to the {@code list} at position {@code k}.
     *     Then, all three pointers {@code i, j, k} are incremented.</li>
     *     <li>This {@code while} loop copies any remaining elements in the left subarray to the {@code list} if there are any.</li>
     *     <li>The remaining element at position {@code i} in the left subarray is copied to the {@code list} at position {@code k}.
     *     Then, both i and {@code k} pointers are incremented.</li>
     *     <li>This loop copies any remaining elements in the right subarray to the {@code list} if there are any.</li>
     *     <li>The remaining element at position {@code j} in the right subarray is copied to the {@code list} at position {@code k}.
     *     Then, both {@code j} and {@code k} pointers are incremented.</li>
     * </ul>
     * {@code mergingDec} this method merges two sorted subarrays {@code leftList} and {@code rightList} into a single sorted list {@code list}.
     * It compares elements from both subarrays and copies them to the {@code list} in the correct order until one of the subarrays is fully processed.
     * Then, it copies any remaining elements from the unfinished subarray to the list.
     * @param       list to be arranged.
     * @param       leftList The left subarray that is sorted in descending order.
     * @param       rightList The right subarray that is sorted in descending order.
     */
    @SuppressWarnings("unchecked")
    default <L extends T> void mergingDec(List<L> list, List<L> leftList, List<L> rightList) {
        int i = 0, j = 0, k = 0;
        while ((i < leftList.size()) && (j < rightList.size())) {
            if (rightList.get(j).compareTo(leftList.get(i)) < 0) {
                list.set(k++, leftList.get(i++));
            } else {
                list.set(k++, rightList.get(j++));
            }
        }
        while (i < leftList.size()) {
            list.set(k++, leftList.get(i++));
        }
        while (j < rightList.size()) {
            list.set(k++, rightList.get(j++));
        }
    }

    /**
     * {@code merging} method takes a list {@code list} of type {@code T},
     * two subarrays {@code leftList} and {@code rightList} of type {@code T},
     * and an instance of {@code SortFunctional<T>} as parameters.
     * <ul>
     *     <li>It initializes three variables:
     *     {@code i} to track the index of the current element in {@code leftList},
     *     {@code j} to track the index of the current element in {@code rightList}, and
     *     {@code k} to track the index of the current element in {@code list}.</li>
     *     <li>It enters a {@code while} loop that continues until either {@code i} reaches
     *     the end of {@code leftList} or {@code j} reaches the end of {@code rightList}.
     *     This loop merges the elements from {@code leftList} and {@code rightList}
     *     into list based on the comparison logic defined by the {@code functional} instance.</li>
     *     <li>Within the loop, it compares the current elements at indices i and j from leftList and rightList, respectively.
     *     If the comparison indicates that the element in {@code rightList} is considered greater than the element in {@code leftList},
     *     it assigns the element from {@code leftList} to {@code list.get(k)} and increments {@code i} and {@code k}.
     *     Otherwise, it assigns the element from {@code rightList} to {@code list.get(k)} and increments {@code j} and {@code k}.</li>
     *     <li>After the loop, it checks if there are any remaining elements in {@code leftList} and {@code rightList} that haven't been processed.
     *     It uses separate {@code while} loops to copy any remaining elements into {@code list}.</li>
     *     <li>Finally, the method completes, and the merged result is stored in {@code list}.</li>
     * </ul>
     * {@code merging} method merges two sorted subarrays, {@code leftList} and {@code rightList}, into a single sorted list {@code list}.
     * It uses the comparison logic defined by the {@code SortFunctional} instance to determine the order of elements during the merging process.
     * @param       list to be arranged.
     * @param       leftList The left subarray that is sorted in descending order.
     * @param       rightList The right subarray that is sorted in descending order.
     * @param       functional lambda expression for comparison.
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default <L extends T> void merging(List<L> list, List<L> leftList, List<L> rightList, SortFunctional<T> functional) {
        int i = 0, j = 0, k = 0;
        while ((i < leftList.size()) && (j < rightList.size())) {
            if (functional.functionalCompareTo(rightList.get(j), leftList.get(i))) {
                list.set(k++, leftList.get(i++));
            } else {
                list.set(k++, rightList.get(j++));
            }
        }
        while (i < leftList.size()) {
            list.set(k++, leftList.get(i++));
        }
        while (j < rightList.size()) {
            list.set(k++, rightList.get(j++));
        }
    }
}