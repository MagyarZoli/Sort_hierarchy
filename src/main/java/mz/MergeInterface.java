package mz;

import java.util.Arrays;

/**
 * MergeInterface, containing the methods of Merge Sort to implement other classes.
 * @param       <T> setting of a type based on which the elements can be sorted.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public interface MergeInterface<T extends Comparable>
extends Sort<T> {

    /**
     * {@code mergeInc} that performs a Merge Sort on an array of {@code Comparable} objects in increasing order.
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
     * {@code mergeDec} that performs a Merge Sort on an array of {@code Comparable} objects in decreasing order.
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
     * {@code mergeInc} that performs a Merge Sort on an array of {@code Comparable} objects in increasing order.
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
     * {@code mergeDec} that performs a Merge Sort on an array of {@code Comparable} objects in decreasing order.
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
}