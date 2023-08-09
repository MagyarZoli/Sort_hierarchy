package mz;

import java.util.List;

/**
 * Slow Sort is a Divide and Conquer algorithm. It divides the input array into two halves, calls itself the two halves,
 * and then compares the maximum element of the two halves. It stores the maximum element of a sub-array at the top
 * position of the sub-array, then, it recursively calls the sub-array without the maximum element.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Slow
extends Quick {

    /**
     * <b>Slow Sort:</b><br>
     * Is a Divide and Conquer algorithm. It divides the input array into two halves, calls itself the two halves,
     * and then compares the maximum element of the two halves. It stores the maximum element of a sub-array at the top
     * position of the sub-array, then, it recursively calls the sub-array without the maximum element.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Sort the first half, recursively</li>
     *     <li>Sort the second half, recursively</li>
     *     <li>Find the maximum of the whole array by comparing the results of first half and second half, and place it
     *     at the end of the list.</li>
     *     <li>Sort the entire list (except for the maximum now at the end), recursively</li>
     * </ol>
     * <b>Note:</b><br>
     * Is a sorting algorithm. It is of humorous nature and not useful. It is a reluctant algorithm based on the principle
     * of multiply and surrender (a parody formed by taking the opposites of divide and conquer).<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^(log(n)/2))</em><br>
     * Best Case Complexity:    <em>O(n^(log(n)/2+e))</em> where <em>e</em> > <i>0</i><br>
     * Average Case Complexity: <em>O(n^(log(n)/2))</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>No</b>
     * @see         mz.Stooge#Stooge() Stooge
     */
    public Slow() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        slowInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        slowDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        slow(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        slowInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        slowDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        slow(list, functional);
    }

    /**
     * {@code slowInc} This method takes an array of {@link java.lang.Comparable Comparable} elements as input.
     * <ul>
     *     <li>It calls the overloaded version of {@code slowInc} with additional parameters: <i>0</i> represents the
     *     left index (starting point of the sorting), and {@code (array.length - 1)} represents the right index
     *     (end point of the sorting). This effectively sorts the entire array.</li>
     *     <li>The sorting logic is defined in the {@code slowInc} method. The sorting process uses the algorithm,
     *     which is a recursive divide-and-conquer algorithm.</li>
     * </ul>
     * By recursively calling the {@code slowInc} method with different subranges of the array, the algorithm repeatedly
     * divides the array into smaller pieces and then combines them back in sorted order. The base case of the recursion
     * is when the subarray has one element or is empty, which means it's already sorted.
     * @param       array to be arranged.
     * @see         mz.Slow#slowInc(Comparable[], int, int)
     */
    protected void slowInc(Comparable[] array) {
        slowInc(array, 0, (array.length - 1));
    }

    /**
     * {@code slowDec} This method takes an array of {@link java.lang.Comparable Comparable} elements as input.
     * <ul>
     *     <li>It calls the overloaded version of {@code slowDec} with additional parameters: <i>0</i> represents the
     *     left index (starting point of the sorting), and {@code (array.length - 1)} represents the right index
     *     (end point of the sorting). This effectively sorts the entire array.</li>
     *     <li>The sorting logic is defined in the {@code slowDec} method. The sorting process uses the algorithm,
     *     which is a recursive divide-and-conquer algorithm.</li>
     * </ul>
     * By recursively calling the {@code slowDec} method with different subranges of the array, the algorithm repeatedly
     * divides the array into smaller pieces and then combines them back in sorted order. The base case of the recursion
     * is when the subarray has one element or is empty, which means it's already sorted.
     * @param       array to be arranged.
     * @see         mz.Slow#slowDec(Comparable[], int, int)
     */
    protected void slowDec(Comparable[] array) {
        slowDec(array, 0, (array.length - 1));
    }

    /**
     * {@code slow} This method takes an array of {@link java.lang.Comparable Comparable} elements as input and a
     * {@code functional} parameter of type {@code SortFunctional<Comparable>}. The {@code functional} parameter is used
     * to define a custom comparison logic for sorting the elements.
     * <ul>
     *     <li>It calls the overloaded version of the {@code slow} method with additional parameters: <i>0</i> represents
     *     the left index (starting point of the sorting), {@code (array.length - 1)} represents the right index
     *     (end point of the sorting), and {@code functional} represents the custom comparison logic.</li>
     *     <li>The sorting logic is defined in the {@code slow} method. The sorting process uses the algorithm,
     *     which is a recursive divide-and-conquer algorithm.</li>
     * </ul>
     * By recursively calling the {@code slow} method with different subranges of the array and the custom comparison logic,
     * the algorithm repeatedly divides the array into smaller pieces and then combines them back in the sorted order,
     * following the custom comparison logic provided by the {@code functional} parameter.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.Slow#slow(List, int, int, SortFunctional)
     */
    protected void slow(Comparable[] array, SortFunctional<Comparable> functional) {
        slow(array, 0, (array.length - 1), functional);
    }

    /**
     * {@code slowInc} This method takes an array of {@link java.lang.Comparable Comparable} elements as input and sorts
     * the elements between the indices {@code left} and {@code right}.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>This is the base case of the recursive function. If the left index is greater than or equal to the right
     *     index, it means there is either one element or no elements to be sorted, so the function returns without
     *     doing anything.</li>
     *     <li>The midpoint index {@code mid} is calculated as the average of {@code left} and {@code right}. This will
     *     be used to split the array into two halves for sorting.</li>
     *     <li>Recursively call {@code slowInc} to sort the left half of the array from {@code left} to {@code mid}.</li>
     *     <li>Recursively call {@code slowInc} to sort the right half of the array from {@code (mid + 1)} to
     *     {@code right}.</li>
     *     <li>After the left and right halves are sorted, the code checks if the element at the {@code mid} index is
     *     greater than the element at the {@code right} index. If so, it means the right half contains a smaller value
     *     than the left half's maximum value. In order to ensure the elements are in ascending order, it swaps the
     *     elements at the {@code mid} and {@code right} indices.</li>
     *     <li>Finally, it makes a recursive call to sort the right half again, excluding the last element
     *     {@code (right - 1)}. This is done to ensure the rightmost element (the one previously at the {@code mid} index)
     *     is in its correct position.</li>
     * </ul>
     * {@code slowInc} this implementation uses a divide-and-conquer approach to sort the array. The base case and
     * recursive calls ensure that each subarray is eventually sorted, and then the merging of the sorted subarrays
     * takes place.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void slowInc(Comparable[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = ((left + right) / 2);
        slowInc(array, left, mid);
        slowInc(array, (mid + 1), right);
        if (array[mid].compareTo(array[right]) > 0) {
            swap(array, mid, right);
        }
        slowInc(array, left, (right - 1));
    }

    /**
     * {@code slowDec} This method takes an array of {@link java.lang.Comparable Comparable} elements as input and sorts
     * the elements between the indices {@code left} and {@code right}.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>This is the base case of the recursive function. If the left index is greater than or equal to the right
     *     index, it means there is either one element or no elements to be sorted, so the function returns without
     *     doing anything.</li>
     *     <li>The midpoint index {@code mid} is calculated as the average of {@code left} and {@code right}. This will
     *     be used to split the array into two halves for sorting.</li>
     *     <li>Recursively call {@code slowInc} to sort the left half of the array from {@code left} to {@code mid}.</li>
     *     <li>Recursively call {@code slowInc} to sort the right half of the array from {@code (mid + 1)} to
     *     {@code right}.</li>
     *     <li>After the left and right halves are sorted, the code checks if the element at the {@code mid} index is
     *     greater than the element at the {@code right} index. If so, it means the right half contains a greater value
     *     than the left half's maximum value. In order to ensure the elements are in descending order, it swaps the
     *     elements at the {@code mid} and {@code right} indices.</li>
     *     <li>Finally, it makes a recursive call to sort the right half again, excluding the last element
     *     {@code (right - 1)}. This is done to ensure the rightmost element (the one previously at the {@code mid} index)
     *     is in its correct position.</li>
     * </ul>
     * {@code slowDec} this implementation uses a divide-and-conquer approach to sort the array. The base case and
     * recursive calls ensure that each subarray is eventually sorted, and then the merging of the sorted subarrays
     * takes place.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void slowDec(Comparable[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = ((left + right) / 2);
        slowDec(array, left, mid);
        slowDec(array, (mid + 1), right);
        if (array[mid].compareTo(array[right]) < 0) {
            swap(array, mid, right);
        }
        slowDec(array, left, (right - 1));
    }

    /**
     * {@code slow} This method takes an array of {@link java.lang.Comparable Comparable} elements as input, along with
     * {@code left} and {@code right} indices indicating the range to be sorted. Additionally, it takes a {@code functional}
     * parameter, which is a custom comparison logic.
     * <ul>
     *     <li>This is the base case of the recursive function. If the left index is greater than or equal to the right
     *     index, it means there is either one element or no elements to be sorted, so the function returns without
     *     doing anything.</li>
     *     <li>The midpoint index {@code mid} is calculated as the average of {@code left} and {@code right}. This will
     *     be used to split the array into two halves for sorting.</li>
     *     <li>Recursively call {@code slow} to sort the left half of the array from {@code left} to {@code mid}, using
     *     the provided {@code functional} for comparisons.</li>
     *     <li>Recursively call {@code slow} to sort the right half of the array from {@code (mid + 1)} to {@code right},
     *     using the provided {@code functional} for comparisons.</li>
     *     <li>After the left and right halves are sorted, the code uses the custom comparison logic provided through the
     *     {@code functional} interface to compare the elements at the {@code mid} and {@code right} indices. If the
     *     custom comparison returns {@code true}, it means the element at mid should be placed after the element at
     *     {@code right} in the sorted order. Therefore, it swaps the elements at the {@code mid} and {@code right}
     *     indices.</li>
     *     <li>Finally, it makes a recursive call to sort the right half again, excluding the last element {@code (right - 1)}.
     *     This is done to ensure the rightmost element (the one previously at the {@code mid} index) is in its correct
     *     position.</li>
     * </ul>
     * {@code slow} This implementation is still based on the divide-and-conquer approach of  but allows for customizable
     * comparison logic through the {@code functional} parameter, which can make it more versatile for different sorting
     * scenarios.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    protected void slow(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        if (left >= right) {
            return;
        }
        int mid = ((left + right) / 2);
        slow(array, left, mid, functional);
        slow(array, (mid + 1), right, functional);
        if (functional.functionalCompareTo(array[mid], array[right])) {
            swap(array, mid, right);
        }
        slow(array, left, (right - 1), functional);
    }

    /**
     * {@code slowInc} This method takes a {@link java.util.List List} of {@link java.lang.Comparable Comparable} elements
     * ({@code L} should be a type that implements the {@code Comparable} interface) as input.
     * <ul>
     *     <li>It calls the overloaded version of {@code slowInc} with additional parameters: <i>0</i> represents the left
     *     index (starting point of the sorting), and {@code (list.size() - 1)} represents the right index
     *     (end point of the sorting). This effectively sorts the entire list.</li>
     *     <li>The sorting logic is defined in the {@code slowInc} method. The sorting process uses the algorithm,
     *     which is a recursive divide-and-conquer algorithm.</li>
     * </ul>
     * {@code slowInc} By recursively calling the {@code slowInc} method with different subranges of the list, the
     * algorithm repeatedly divides the list into smaller pieces and then combines them back in sorted order. The base
     * case of the recursion is when the sublist has one element or is empty, which means it's already sorted.
     * @param       list to be arranged.
     * @param       <L> allows this method to be used with different types.
     * @see         mz.Slow#slowInc(List, int, int)
     */
    protected <L extends Comparable> void slowInc(List<L> list) {
        slowInc(list, 0, (list.size() - 1));
    }

    /**
     * {@code slowDec} This method takes a {@link java.util.List List} of {@link java.lang.Comparable Comparable} elements
     * ({@code L} should be a type that implements the {@code Comparable} interface) as input.
     * <ul>
     *     <li>It calls the overloaded version of {@code slowDec} with additional parameters: <i>0</i> represents the left
     *     index (starting point of the sorting), and {@code (list.size() - 1)} represents the right index
     *     (end point of the sorting). This effectively sorts the entire list.</li>
     *     <li>The sorting logic is defined in the {@code slowDec} method. The sorting process uses the algorithm,
     *     which is a recursive divide-and-conquer algorithm.</li>
     * </ul>
     * {@code slowDec} By recursively calling the {@code slowDec} method with different subranges of the list, the
     * algorithm repeatedly divides the list into smaller pieces and then combines them back in sorted order. The base
     * case of the recursion is when the sublist has one element or is empty, which means it's already sorted.
     * @param       list to be arranged.
     * @param       <L> allows this method to be used with different types.
     * @see         mz.Slow#slowDec(List, int, int)
     */
    protected <L extends Comparable> void slowDec(List<L> list) {
        slowDec(list, 0, (list.size() - 1));
    }

    /**
     * {@code slow} This method takes a {@link java.util.List List} of {@link java.lang.Comparable Comparable} elements
     * ({@code L} should be a type that implements the {@code Comparable} interface) as input and a {@code functional}
     * parameter of type {@code SortFunctional<Comparable>}. The {@code functional} parameter is used to define a custom
     * comparison logic for sorting the elements.
     * <ul>
     *     <li>It calls the overloaded version of the {@code slow} method with additional parameters: <i>0</i> represents
     *     the left index (starting point of the sorting), {@code (list.size() - 1)} represents the right index
     *     (end point of the sorting), and {@code functional} represents the custom comparison logic.</li>
     * </ul>
     * {@code slow} By recursively calling the {@code slow} method with different subranges of the list and the custom
     * comparison logic, the algorithm repeatedly divides the list into smaller pieces and then combines them back in
     * sorted order, following the custom comparison logic provided by the {@code functional} parameter.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @param       <L> allows this method to be used with different types.
     * @see         mz.Slow#slow(List, int, int, SortFunctional)
     */
    protected <L extends Comparable> void slow(List<L> list, SortFunctional<Comparable> functional) {
        slow(list, 0, (list.size() - 1), functional);
    }

    /**
     * {@code slowInc} This method takes a {@link java.util.List List} of {@link java.lang.Comparable Comparable} elements
     * ({@code L} should be a type that implements the {@code Comparable} interface) as input, along with {@code left} and
     * {@code right} indices indicating the range to be sorted.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} This annotation is used to suppress
     *     compiler warnings. In this context, it is likely suppressing warnings related to the use of unchecked conversions
     *     (i.e., type safety) because of the generic type {@code L} extends {@code Comparable}.</li>
     *     <li>This is the base case of the recursive function. If the left index is greater than or equal to the right
     *     index, it means there is either one element or no elements to be sorted, so the function returns without doing
     *     anything.</li>
     *     <li>The midpoint index {@code mid} is calculated as the average of {@code left} and {@code right}. This will
     *     be used to split the list into two halves for sorting.</li>
     *     <li>Recursively call {@code slowInc} to sort the left half of the list from {@code left} to {@code mid}.</li>
     *     <li>Recursively call {@code slowInc} to sort the right half of the list from {@code (mid + 1)} to {@code right}.</li>
     *     <li>After the left and right halves are sorted, the code checks if the element at the {@code mid} index is
     *     greater than the element at the {@code right} index. If so, it means the right half contains a smaller value
     *     than the left half's maximum value. In order to ensure the elements are in ascending order, it swaps the
     *     elements at the {@code mid} and {@code right} indices.</li>
     *     <li>Finally, it makes a recursive call to sort the right half again, excluding the last element {@code (right - 1)}.
     *     This is done to ensure the rightmost element (the one previously at the {@code mid} index) is in its correct position.</li>
     * </ul>
     * {@code slowInc} The implementation is but adapted for working with Lists. The generic type {@code L} is used to
     * indicate that the {@code List} should contain elements of a type that implements the Comparable interface. This
     * allows the use of {@link java.lang.Comparable#compareTo(Object) compareTo} for comparing elements during the
     * sorting process.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @param       <L> allows this method to be used with different types.
     * @see         mz.SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void slowInc(List<L> list, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = ((left + right) / 2);
        slowInc(list, left, mid);
        slowInc(list, (mid + 1), right);
        if (list.get(mid).compareTo(list.get(right)) > 0) {
            swap(list, mid, right);
        }
        slowInc(list, left, (right - 1));
    }

    /**
     * {@code slowDec} This method takes a {@link java.util.List List} of {@link java.lang.Comparable Comparable} elements
     * ({@code L} should be a type that implements the {@code Comparable} interface) as input, along with {@code left} and
     * {@code right} indices indicating the range to be sorted.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} This annotation is used to suppress
     *     compiler warnings. In this context, it is likely suppressing warnings related to the use of unchecked conversions
     *     (i.e., type safety) because of the generic type {@code L} extends {@code Comparable}.</li>
     *     <li>This is the base case of the recursive function. If the left index is greater than or equal to the right
     *     index, it means there is either one element or no elements to be sorted, so the function returns without doing
     *     anything.</li>
     *     <li>The midpoint index {@code mid} is calculated as the average of {@code left} and {@code right}. This will
     *     be used to split the list into two halves for sorting.</li>
     *     <li>Recursively call {@code slowInc} to sort the left half of the list from {@code left} to {@code mid}.</li>
     *     <li>Recursively call {@code slowInc} to sort the right half of the list from {@code (mid + 1)} to {@code right}.</li>
     *     <li>After the left and right halves are sorted, the code checks if the element at the {@code mid} index is
     *     greater than the element at the {@code right} index. If so, it means the right half contains a smaller value
     *     than the left half's maximum value. In order to ensure the elements are in descending order, it swaps the
     *     elements at the {@code mid} and {@code right} indices.</li>
     *     <li>Finally, it makes a recursive call to sort the right half again, excluding the last element {@code (right - 1)}.
     *     This is done to ensure the rightmost element (the one previously at the {@code mid} index) is in its correct position.</li>
     * </ul>
     * {@code slowDec} The implementation is but adapted for working with Lists. The generic type {@code L} is used to
     * indicate that the {@code List} should contain elements of a type that implements the Comparable interface. This
     * allows the use of {@link java.lang.Comparable#compareTo(Object) compareTo} for comparing elements during the
     * sorting process.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @param       <L> allows this method to be used with different types.
     * @see         mz.SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void slowDec(List<L> list, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = ((left + right) / 2);
        slowDec(list, left, mid);
        slowDec(list, (mid + 1), right);
        if (list.get(mid).compareTo(list.get(right)) < 0) {
            swap(list, mid, right);
        }
        slowDec(list, left, (right - 1));
    }

    /**
     * {@code slow} This method takes a {@link java.util.List List} of {@link java.lang.Comparable Comparable} elements
     * ({@code L} should be a type that implements the {@code Comparable} interface) as input, along with {@code left}
     * and {@code right} indices indicating the range to be sorted. Additionally, it takes a {@code functional} parameter
     * of type {@code SortFunctional<Comparable>}, which is a custom comparison logic.
     * <ul>
     *     <li>This is the base case of the recursive function. If the left index is greater than or equal to the right
     *     index, it means there is either one element or no elements to be sorted, so the function returns without doing
     *     anything.</li>
     *     <li>The midpoint index {@code mid} is calculated as the average of {@code left} and {@code right}. This will
     *     be used to split the list into two halves for sorting.</li>
     *     <li>Recursively call {@code slow} to sort the left half of the list from {@code left} to {@code mid}, using
     *     the provided {@code functional} for comparisons.</li>
     *     <li>Recursively call {@code slow} to sort the right half of the list from {@code (mid + 1)} to {@code right},
     *     using the provided {@code functional} for comparisons.</li>
     *     <li>After the left and right halves are sorted, the code uses the custom comparison logic provided through the
     *     {@code functional} interface to compare the elements at the {@code mid} and {@code right} indices. If the custom
     *     comparison returns {@code true}, it means the element at {@code mid} should be placed after the element at
     *     {@code right} in the sorted order. Therefore, it swaps the elements at the {@code mid} and {@code right} indices.</li>
     *     <li>Finally, it makes a recursive call to sort the right half again, excluding the last element {@code (right - 1)}.
     *     This is done to ensure the rightmost element (the one previously at the {@code mid} index) is in its correct position.</li>
     * </ul>
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @param       <L> allows this method to be used with different types.
     * @see         mz.SortSwap#swap(List, int, int)
     */
    protected <L extends Comparable> void slow(List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        if (left >= right) {
            return;
        }
        int mid = ((left + right) / 2);
        slow(list, left, mid, functional);
        slow(list, (mid + 1), right, functional);
        if (functional.functionalCompareTo(list.get(mid), list.get(right))) {
            swap(list, mid, right);
        }
        slow(list, left, (right - 1), functional);
    }
}