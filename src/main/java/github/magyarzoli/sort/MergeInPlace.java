package github.magyarzoli.sort;

import github.magyarzoli.Sort;
import github.magyarzoli.SortFunctional;
import github.magyarzoli.sort.Merge;
import github.magyarzoli.sort.intro.IntroMergeInPlace;

import java.util.List;

/**
 * Merge In Place Sort is a variant of the merge sort algorithm that performs the sorting operation directly on the
 * input array,
 * without using any additional arrays for merging.
 * It achieves this by carefully manipulating the elements within the original array during the merging process.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class MergeInPlace
        extends Merge {

    /**
     * <b>Merge In Place Sort:</b><br>
     * Is a variant of the merge sort algorithm that performs the sorting operation directly on the input array,
     * without using any additional arrays for merging.
     * It achieves this by carefully manipulating the elements within the original array during the merging
     * process.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>The algorithm recursively divides the array into smaller subarrays until each subarray contains only one
     *     element (considered sorted).</li>
     *     <li>Then, it starts merging the subarrays in pairs, using an in-place merging technique.</li>
     *     <li>To perform an in-place merge of two subarrays, the algorithm follows these steps:</li>
     *     <li> It compares the first element of the left subarray with the first element of the right subarray.
     *     If the left element is greater, it swaps the two elements.</li>
     *     <li>After the swap, it compares the new first element of the right subarray with the next element in the
     *     left subarray,
     *     and so on, until the elements in both subarrays are in the correct sorted order.</li>
     *     <li>Meanwhile, the elements in the left subarray are shifted one position to the right to make space for
     *     the swapped element from the right subarray.</li>
     *     <li>Once the merging of two subarrays is complete, the algorithm moves on to merge the next pair of
     *     subarrays, until the entire array is sorted.</li>
     * </ol>
     * <b>Note:</b><br>
     * Time Complexity of above approach is <em>O(n^2 * log(n))</em> because merge is <em>O(n^2)</em>.
     * Time complexity of standard merge sort is less, <em>O(n log(n))</em>.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>Yes</b>
     * @see         IntroMergeInPlace#IntroMergeInPlace() IntroMergeInPlace
     */
    public MergeInPlace() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        mergeInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        mergeDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        merge(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        mergeInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        mergeDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        merge(list, functional);
    }

    /**
     * {@code mergingInc} is a Java implementation of the merging step in the merge sort algorithm.
     * It takes an array of {@link java.lang.Comparable Comparable} objects, along with the indices representing
     * the left, middle, and right boundaries of the subarray being merged.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method starts by initializing the start variable to {@code (mid + 1)}.
     *     This is the index where the second subarray begins.</li>
     *     <li>The code then checks if the element at index {@code mid} is less than or equal to the element at
     *     index {@code start}.
     *     If this condition is true, it means that the two subarrays are already sorted, and there is no need to
     *     perform any merging.
     *     In that case, the method simply returns.</li>
     *     <li>If the condition in step 3 is false, indicating that merging is necessary, a {@code while} loop is used
     *     to compare elements from both subarrays and merge them in sorted order.</li>
     *     <li>Within the {@code while} loop, there is an {@code if}-{@code else} statement that compares the elements
     *     at indices {@code left} and {@code start}.
     *     If the element at {@code left} is less than or equal to the element at {@code start},
     *     it means that the element at {@code left} is already in its correct sorted position,
     *     and we can simply move to the next element in the {@code left} subarray by incrementing the {@code left}
     *     variable.</li>
     *     <li>If the element at {@code left} is greater than the element at {@code start},
     *     it means that the element at {@code start} needs to be inserted into its correct position in the {@code left}
     *     subarray.
     *     The code creates a temporary variable value to store the value at index {@code start},
     *     and an index variable {@code index} to keep track of the position where value will be inserted.</li>
     *     <li>A {@code while} loop is used to shift the elements from {@code index} to {@code left} in the
     *     {@code array} one position to the {@code right},
     *     effectively making space for {@code value} to be inserted at the correct position.</li>
     *     <li>After shifting the elements, {@code value} is inserted at index {@code left}, and both {@code left}
     *     and {@code start} are incremented to move to the next elements in their respective subarrays.</li>
     *     <li>The {@code while} loop continues until either the {@code left} subarray or the {@code start} subarray
     *     is exhausted, i.e.,
     *     all elements from either subarray have been merged.</li>
     * </ul>
     * {@code mergingInc} this method performs the merging of two sorted subarrays within the larger array.
     * It uses a temporary variable to insert elements from the second subarray into their correct positions within
     * the first subarray, effectively merging the two subarrays into a single sorted subarray.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater
     *              than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void mergingInc(Comparable[] array, int left, int mid, int right) {
        int start = (mid + 1);
        if (array[start].compareTo(array[mid]) >= 0) {
            return;
        }
        while ((left <= mid) && (start <= right)) {
            if (array[start].compareTo(array[left]) >= 0) {
                left++;
            } else {
                Comparable value = array[start];
                int index = start;
                while (index != left) {
                    array[index] = array[(index - 1)];
                    index--;
                }
                array[left++] = value;
                mid++;
                start++;
            }
        }
    }

    /**
     * {@code mergingDec} is a Java implementation of the merging step in the merge sort algorithm.
     * It takes an array of {@link java.lang.Comparable Comparable} objects, along with the indices representing
     * the left, middle, and right boundaries of the subarray being merged.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method starts by initializing the start variable to {@code (mid + 1)}.
     *     This is the index where the second subarray begins.</li>
     *     <li>The code then checks if the element at index {@code mid} is more than or equal to the element at index
     *     {@code start}.
     *     If this condition is true, it means that the two subarrays are already sorted, and there is no need to
     *     perform any merging.
     *     In that case, the method simply returns.</li>
     *     <li>If the condition in step 3 is false, indicating that merging is necessary, a {@code while} loop is used
     *     to compare elements from both subarrays and merge them in sorted order.</li>
     *     <li>Within the {@code while} loop, there is an {@code if}-{@code else} statement that compares the elements
     *     at indices {@code left} and {@code start}.
     *     If the element at {@code left} is more than or equal to the element at {@code start},
     *     it means that the element at {@code left} is already in its correct sorted position,
     *     and we can simply move to the next element in the {@code left} subarray by decrementing the {@code left}
     *     variable.</li>
     *     <li>If the element at {@code left} is smaller than the element at {@code start},
     *     it means that the element at {@code start} needs to be inserted into its correct position in the {@code left}
     *     subarray.
     *     The code creates a temporary variable value to store the value at index {@code start},
     *     and an index variable {@code index} to keep track of the position where value will be inserted.</li>
     *     <li>A {@code while} loop is used to shift the elements from {@code index} to {@code left} in the
     *     {@code array} one position to the {@code right},
     *     effectively making space for {@code value} to be inserted at the correct position.</li>
     *     <li>After shifting the elements, {@code value} is inserted at index {@code left}, and both {@code left}
     *     and {@code start} are decremented to move to the next elements in their respective subarrays.</li>
     *     <li>The {@code while} loop continues until either the {@code left} subarray or the {@code start} subarray is
     *     exhausted, i.e.,
     *     all elements from either subarray have been merged.</li>
     * </ul>
     * {@code mergingDec} this method performs the merging of two sorted subarrays within the larger array.
     * It uses a temporary variable to insert elements from the second subarray into their correct positions within
     * the first subarray, effectively merging the two subarrays into a single sorted subarray.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater
     *              than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void mergingDec(Comparable[] array, int left, int mid, int right) {
        int start = (mid + 1);
        if (array[start].compareTo(array[mid]) <= 0) {
            return;
        }
        while ((left <= mid) && (start <= right)) {
            if (array[start].compareTo(array[left]) <= 0) {
                left++;
            } else {
                Comparable value = array[start];
                int index = start;
                while (index != left) {
                    array[index] = array[(index - 1)];
                    index--;
                }
                array[left++] = value;
                mid++;
                start++;
            }
        }
    }

    /**
     * {@code merging} method being overridden.
     * This method is responsible for merging two sorted subarrays
     * {@code (array[left] to array[mid] and array[mid+1] to array[right])} into a single sorted subarray.
     * <ul>
     *     <li>It initializes the {@code start} variable as {@code (mid + 1)},
     *     which represents the starting index of the second subarray.</li>
     *     <li>It creates a new {@code SortFunctional<Comparable>} object called {@code functionalAddEquals}
     *     by calling the method {@code functionalComparableToAddEquals(functional)}.
     *     The purpose of this new functional interface.</li>
     *     <li>It checks if the first element of the second subarray {@code array[start]} is greater than or equal to
     *     the last element of the first subarray {@code array[mid]}
     *     by using the {@code functionalAddEquals} functional interface.
     *     If this condition is {@code true}, it means that the two subarrays are already in order,
     *     and the method returns without performing any further merging.</li>
     *     <li>It enters a {@code while} loop that continues until either
     *     the first subarray or the second subarray is completely traversed.</li>
     *     Inside the {@code while} loop, it compares the elements at {@code array[start]} and {@code array[left]}.
     *     If the element at {@code array[start]} is greater than or equal to the element at {@code array[left]},
     *     it means that the next element in the merged subarray should come from the first subarray.
     *     In this case, it increments the {@code left} index to move to the next element in the first subarray.
     *     <li>If the element at {@code array[start]} is smaller than the element at {@code array[left]}, it means that
     *     the next element in the merged subarray should come from the second subarray.
     *     In this case, it performs a series of element shifts in
     *     the first subarray to make space for the element at {@code array[start]}.
     *     It starts from the current {@code start} index and moves backward,
     *     shifting each element one position to the right until it reaches the left index.
     *     Finally, it assigns the element at {@code array[start]} to the {@code left} index.</li>
     *     <li>After each element is processed, it increments {@code left} to move to the next position in the first
     *     subarray,
     *     increments {@code mid} to account for the element insertion,
     *     and increments {@code start} to move to the next position in the second subarray.</li>
     *     <li>Once the while loop exits, the merging is complete, and the two subarrays are merged into a single sorted
     *     subarray.</li>
     * </ul>
     * {@code merging} this method performs the merging of two sorted subarrays within the larger array.
     * It uses a temporary variable to insert elements from the second subarray into their correct positions within
     * the first subarray, effectively merging the two subarrays into a single sorted subarray.
     * @param       array to be arranged.
     * @param       left from the array, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the array, index value, must be smaller than the {@code right} value, and must be greater
     *              than the {@code left}.
     * @param       right from the array, index value, must be greater than the {@code left} and {@code mid} value.
     * @param       functional lambda expression for comparison.
     * @see         Sort#functionalComparableToAddEquals(SortFunctional)
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    @Override
    public void merging(Comparable[] array, int left, int mid, int right, SortFunctional<Comparable> functional) {
        int start = (mid + 1);
        SortFunctional<Comparable> functionalAddEquals = functionalComparableToAddEquals(functional);
        if (functionalAddEquals.functionalCompareTo(array[start], array[mid])) {
            return;
        }
        while ((left <= mid) && (start <= right)) {
            if (functionalAddEquals.functionalCompareTo(array[start],array[left])) {
                left++;
            } else {
                Comparable value = array[start];
                int index = start;
                while (index != left) {
                    array[index] = array[(index - 1)];
                    index--;
                }
                array[left++] = value;
                mid++;
                start++;
            }
        }
    }

    /**
     * {@code mergingInc} is a Java implementation of the merging step in the merge sort algorithm.
     * It takes a list of {@link java.lang.Comparable Comparable} objects, along with the indices representing
     * the left, middle, and right boundaries of the sublist being merged.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method starts by initializing the start variable to {@code (mid + 1)}.
     *     This is the index where the second sublist begins.</li>
     *     <li>The code then checks if the element at index {@code mid} is less than or equal to the element at index
     *     {@code start}.
     *     If this condition is true, it means that the two sublists are already sorted, and there is no need to
     *     perform any merging.
     *     In that case, the method simply returns.</li>
     *     <li>If the condition in step 3 is false, indicating that merging is necessary, a {@code while} loop is used
     *     to compare elements from both sublists and merge them in sorted order.</li>
     *     <li>Within the {@code while} loop, there is an {@code if}-{@code else} statement that compares the elements
     *     at indices {@code left} and {@code start}.
     *     If the element at {@code left} is less than or equal to the element at {@code start},
     *     it means that the element at {@code left} is already in its correct sorted position,
     *     and we can simply move to the next element in the {@code left} sublist by incrementing the {@code left}
     *     variable.</li>
     *     <li>If the element at {@code left} is greater than the element at {@code start},
     *     it means that the element at {@code start} needs to be inserted into its correct position in the {@code left}
     *     sublist.
     *     The code creates a temporary variable value to store the value at index {@code start},
     *     and an index variable {@code index} to keep track of the position where value will be inserted.</li>
     *     <li>A {@code while} loop is used to shift the elements from {@code index} to {@code left} in the {@code list}
     *     one position to the {@code right},
     *     effectively making space for {@code value} to be inserted at the correct position.</li>
     *     <li>After shifting the elements, {@code value} is inserted at index {@code left}, and both {@code left}
     *     and {@code start} are incremented to move to the next elements in their respective sublists.</li>
     *     <li>The {@code while} loop continues until either the {@code left} sublist or the {@code start} sublist is
     *     exhausted, i.e.,
     *     all elements from either sublist have been merged.</li>
     * </ul>
     * {@code mergingInc} this method performs the merging of two sorted sublists within the larger list.
     * It uses a temporary variable to insert elements from the second sublist into their correct positions within
     * the first sublist, effectively merging the two sublists into a single sorted sublist.
     * @param       list to be arranged.
     * @param       left from the list, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the list, index value, must be smaller than the {@code right} value, and must be greater
     *              than the {@code left}.
     * @param       right from the list, index value, must be greater than the {@code left} and {@code mid} value.
     */
    @Override
    @SuppressWarnings("unchecked")
    public <L extends Comparable> void mergingInc(List<L> list, int left, int mid, int right) {
        int start = (mid + 1);
        if (list.get(start).compareTo(list.get(mid)) >= 0) {
            return;
        }
        while ((left <= mid) && (start <= right)) {
            if (list.get(start).compareTo(list.get(left)) >= 0) {
                left++;
            } else {
                L value = list.get(start);
                int index = start;
                while (index != left) {
                    list.set(index, list.get(index - 1));
                    index--;
                }
                list.set(left++, value);
                mid++;
                start++;
            }
        }
    }

    /**
     * {@code mergingDec} is a Java implementation of the merging step in the merge sort algorithm.
     * It takes a list of {@link java.lang.Comparable Comparable} objects, along with the indices representing
     * the left, middle, and right boundaries of the sublist being merged.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method starts by initializing the start variable to {@code (mid + 1)}.
     *     This is the index where the second sublist begins.</li>
     *     <li>The code then checks if the element at index {@code mid} is more than or equal to the element at index
     *     {@code start}.
     *     If this condition is true, it means that the two sublists are already sorted, and there is no need to
     *     perform any merging.
     *     In that case, the method simply returns.</li>
     *     <li>If the condition in step 3 is false, indicating that merging is necessary, a {@code while} loop is used
     *     to compare elements from both sublists and merge them in sorted order.</li>
     *     <li>Within the {@code while} loop, there is an {@code if}-{@code else} statement that compares the elements
     *     at indices {@code left} and {@code start}.
     *     If the element at {@code left} is more than or equal to the element at {@code start},
     *     it means that the element at {@code left} is already in its correct sorted position,
     *     and we can simply move to the next element in the {@code left} sublist by decrementing the {@code left}
     *     variable.</li>
     *     <li>If the element at {@code left} is smaller than the element at {@code start},
     *     it means that the element at {@code start} needs to be inserted into its correct position in the
     *     {@code left} sublist.
     *     The code creates a temporary variable value to store the value at index {@code start},
     *     and an index variable {@code index} to keep track of the position where value will be inserted.</li>
     *     <li>A {@code while} loop is used to shift the elements from {@code index} to {@code left} in the {@code list}
     *     one position to the {@code right},
     *     effectively making space for {@code value} to be inserted at the correct position.</li>
     *     <li>After shifting the elements, {@code value} is inserted at index {@code left}, and both {@code left}
     *     and {@code start} are decremented to move to the next elements in their respective sublists.</li>
     *     <li>The {@code while} loop continues until either the {@code left} sublist or the {@code start} sublist is
     *     exhausted, i.e.,
     *     all elements from either sublist have been merged.</li>
     * </ul>
     * {@code mergingDec} this method performs the merging of two sorted sublists within the larger list.
     * It uses a temporary variable to insert elements from the second sublist into their correct positions within
     * the first sublist, effectively merging the two sublists into a single sorted sublist.
     * @param       list to be arranged.
     * @param       left from the list, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the list, index value, must be smaller than the {@code right} value, and must be greater
     *              than the {@code left}.
     * @param       right from the list, index value, must be greater than the {@code left} and {@code mid} value.
     */
    @Override
    @SuppressWarnings("unchecked")
    public <L extends Comparable> void mergingDec(List<L> list, int left, int mid, int right) {
        int start = (mid + 1);
        if (list.get(start).compareTo(list.get(mid)) <= 0) {
            return;
        }
        while ((left <= mid) && (start <= right)) {
            if (list.get(start).compareTo(list.get(left)) <= 0) {
                left++;
            } else {
                L value = list.get(start);
                int index = start;
                while (index != left) {
                    list.set(index, list.get(index - 1));
                    index--;
                }
                list.set(left++, value);
                mid++;
                start++;
            }
        }
    }

    /**
     * {@code merging} method being overridden.
     * This method is responsible for merging two sorted sublists
     * {@code (list.set(left) to list.set(mid) and list.set(mid + 1) to list.set(right))} into a single sorted sublist.
     * <ul>
     *     <li>It initializes the {@code start} variable as {@code (mid + 1)},
     *     which represents the starting index of the second sublist.</li>
     *     <li>It creates a new {@code SortFunctional<Comparable>} object called {@code functionalAddEquals}
     *     by calling the method {@code functionalComparableToAddEquals(functional)}.
     *     The purpose of this new functional interface.</li>
     *     <li>It checks if the first element of the second sublist {@code list.set(start)} is greater than or equal to
     *     the last element of the first sublist {@code list.set(mid)}
     *     by using the {@code functionalAddEquals} functional interface.
     *     If this condition is {@code true}, it means that the two sublists are already in order,
     *     and the method returns without performing any further merging.</li>
     *     <li>It enters a {@code while} loop that continues until either
     *     the first sublist or the second sublist is completely traversed.</li>
     *     Inside the {@code while} loop, it compares the elements at {@code list.set(start)} and
     *     {@code list.set(left)}.
     *     If the element at {@code list.set(start)} is greater than or equal to the element at {@code list.set(left)},
     *     it means that the next element in the merged sublist should come from the first sublist.
     *     In this case, it increments the {@code left} index to move to the next element in the first sublist.
     *     <li>If the element at {@code list.set(start)} is smaller than the element at {@code list.set(left)}, it
     *     means that
     *     the next element in the merged sublist should come from the second sublist.
     *     In this case, it performs a series of element shifts in
     *     the first sublist to make space for the element at {@code list.set(start)}.
     *     It starts from the current {@code start} index and moves backward,
     *     shifting each element one position to the right until it reaches the left index.
     *     Finally, it assigns the element at {@code list.get(start)} to the {@code left} index.</li>
     *     <li>After each element is processed, it increments {@code left} to move to the next position in the first
     *     sublist,
     *     increments {@code mid} to account for the element insertion,
     *     and increments {@code start} to move to the next position in the second sublist.</li>
     *     <li>Once the while loop exits, the merging is complete, and the two sublists are merged into a single
     *     sorted sublist.</li>
     * </ul>
     * {@code merging} this method performs the merging of two sorted sublists within the larger list.
     * It uses a temporary variable to insert elements from the second sublist into their correct positions within
     * the first sublist, effectively merging the two sublists into a single sorted sublist.
     * @param       list to be arranged.
     * @param       left from the list, index value, must be smaller than the {@code mid} and {@code right} value.
     * @param       mid from the list, index value, must be smaller than the {@code right} value, and must be greater
     *              than the {@code left}.
     * @param       right from the list, index value, must be greater than the {@code left} and {@code mid} value.
     * @param       functional lambda expression for comparison.
     * @see         Sort#functionalComparableToAddEquals(SortFunctional)
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    @Override
    public <L extends Comparable> void merging(
            List<L> list, int left, int mid, int right, SortFunctional<Comparable> functional) {
        int start = (mid + 1);
        SortFunctional<Comparable> functionalAddEquals = functionalComparableToAddEquals(functional);
        if (functionalAddEquals.functionalCompareTo(list.get(start), list.get(mid))) {
            return;
        }
        while ((left <= mid) && (start <= right)) {
            if (functionalAddEquals.functionalCompareTo(list.get(start), list.get(left))) {
                left++;
            } else {
                L value = list.get(start);
                int index = start;
                while (index != left) {
                    list.set(index, list.get(index - 1));
                    index--;
                }
                list.set(left++, value);
                mid++;
                start++;
            }
        }
    }
}