package mz;

import java.util.List;

/**
 * Stooge Sort is a recursive sorting algorithm that works by recursively sorting the first two-thirds and last two-thirds
 * of the array until the array is sorted. It is similar to other divide-and-conquer algorithms, but its division ratio is
 * unique, dividing the array into three parts instead of two.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Stooge
extends Slow {

    /**
     * <b>Stooge Sort:</b><br>
     * Is a recursive sorting algorithm that works by recursively sorting the first two-thirds and last two-thirds
     * of the array until the array is sorted. It is similar to other divide-and-conquer algorithms, but its division ratio is
     * unique, dividing the array into three parts instead of two.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>If the element at the left index is greater than the element at the right index, swap them.</li>
     *     <li>Calculate the size of one-third of the subarray.</li>
     *     <li>If the subarray size is 2 or smaller, the array is already sorted (base case), and no further action is needed.</li>
     *     <li>Recursively apply Stooge sort to the first two-thirds of the array </li>
     *     <li>Recursively apply Stooge sort to the last two-thirds of the array </li>
     *     <li>Recursively apply Stooge sort again to the first two-thirds of the </li>
     * </ol>
     * <b>Note:</b><br>
     * The time complexity of Stooge sort is <em>O(n^(log 3/log 1.5))</em>. This makes it highly inefficient compared to
     * other sorting algorithms like quicksort or mergesort, which have better average and worst-case time complexities.<br><br>
     * Stability in sorting algorithms refers to whether equal elements maintain their relative order after sorting.
     * Unfortunately, Stooge sort is not a stable sorting algorithm. It means that the order of equal elements may change
     * during the sorting process, leading to an unstable result. The swapping operations in Stooge sort may disrupt the
     * relative order of equal elements.<br><br>
     * Stooge sort is a unique and interesting sorting algorithm, but it is generally not used in practical applications
     * due to its inefficiency. However, understanding its recursive nature and the divide-and-conquer approach can provide
     * valuable insights into the principles of sorting algorithms.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^(log 3/log 1.5))</em><br>
     * Best Case Complexity:    <em>O(n^(log 3/log 1.5))</em><br>
     * Average Case Complexity: <em>O(n^(log 3/log 1.5))</em><br>
     * Auxiliary Space:         <em>O(log(n))</em><br>
     * Stability:               <b>No</b>
     */
    public Stooge() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        stoogeInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        stoogeDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        stooge(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        stoogeInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        stoogeDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        stooge(list, functional);
    }

    /**
     * {@code stoogeInc} method on the entire array. It calls the {@code stoogeInc} method with the initial left and right
     * indices set to <i>0</i> and {@code (array.length - 1)}, respectively, to sort the entire array.
     * <ul>
     *     <li>This method is the public entry point for the stooge sort algorithm. It takes a single argument, an array
     *     of {@link java.lang.Comparable Comparable} objects.</li>
     *     <li>{@code stoogeInc(array, 0, (array.length - 1))} This line of code calls the recursive {@code stoogeInc}
     *     method, passing the entire array as the input and setting the initial left and right indices to <i>0</i> and
     *     {@code (array.length - 1)}, respectively.</li>
     *     <li>The {@code stoogeInc} method is responsible for performing the stooge sort algorithm on the subarray
     *     specified by the {@code left} and {@code right} indices. As described in the previous responses, the stooge
     *     sort algorithm recursively divides the array into three parts and sorts them.</li>
     * </ul>
     * {@code stoogeInc} on an array, you can use the stooge sort algorithm to sort the entire array in ascending order.
     * @param       array to be arranged.
     * @see         mz.Stooge#stoogeInc(Comparable[], int, int)
     */
    protected void stoogeInc(Comparable[] array) {
        stoogeInc(array, 0, (array.length - 1));
    }

    /**
     * {@code stoogeDec} method on the entire array. It calls the {@code stoogeDec} method with the initial left and right
     * indices set to <i>0</i> and {@code (array.length - 1)}, respectively, to sort the entire array.
     * <ul>
     *     <li>This method is the public entry point for the stooge sort algorithm. It takes a single argument, an array
     *     of {@link java.lang.Comparable Comparable} objects.</li>
     *     <li>{@code stoogeDec(array, 0, (array.length - 1))} This line of code calls the recursive {@code stoogeDec}
     *     method, passing the entire array as the input and setting the initial left and right indices to <i>0</i> and
     *     {@code (array.length - 1)}, respectively.</li>
     *     <li>The {@code stoogeDec} method is responsible for performing the stooge sort algorithm on the subarray
     *     specified by the {@code left} and {@code right} indices. As described in the previous responses, the stooge
     *     sort algorithm recursively divides the array into three parts and sorts them.</li>
     * </ul>
     * {@code stoogeDec} on an array, you can use the stooge sort algorithm to sort the entire array in descending order.
     * @param       array to be arranged.
     * @see         mz.Stooge#stoogeDec(Comparable[], int, int)
     */
    protected void stoogeDec(Comparable[] array) {
        stoogeDec(array, 0, (array.length - 1));
    }

    /**
     * {@code stooge} method on the entire array, with the added functionality of using a custom comparison logic through
     * the {@code SortFunctional} functional interface.
     * <ul>
     *     <li>This method is the public entry point for the stooge sort algorithm with custom comparison logic. It takes
     *     two arguments, an array of {@link java.lang.Comparable Comparable} objects and a {@code functional} object that
     *     implements the {@code SortFunctional<Comparable>} interface. This functional interface allows for custom
     *     comparison logic to be provided.</li>
     *     <li>{@code stooge(array, 0, (array.length - 1), functional)} This line of code calls the private recursive
     *     {@code stooge} method, passing the entire array as the input and setting the initial left and right indices
     *     to <i>0</i> and{@code ( array.length - 1)}, respectively. It also passes the {@code functional} object to
     *     perform custom comparisons.</li>
     *     <li>The {@code stooge} method is responsible for performing the stooge sort algorithm on the entire array with
     *     the custom comparison logic provided by the {@code functional} object. The implementation should be similar to
     *     the previously discussed recursive stooge sort, but with the added capability of using the custom comparison
     *     logic during element comparisons.</li>
     * </ul>
     * {@code stooge} on an array, using the stooge sorting algorithm, you can sort the entire array as implemented.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.Stooge#stooge(Comparable[], int, int, SortFunctional)
     */
    protected void stooge(Comparable[] array, SortFunctional<Comparable> functional) {
        stooge(array, 0, (array.length - 1), functional);
    }

    /**
     * {@code stoogeInc} method that takes three arguments: an array of {@link java.lang.Comparable Comparable} objects,
     * {@code left} (the starting index), and {@code right} (the ending index) of the portion of the array to be sorted.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The first condition {@code array[left].compareTo(array[right]) > 0} compares the elements at the {@code left}
     *     and {@code right} indices and swaps them if the element at the {@code left} index is greater than the element
     *     at the {@code right} index. This step ensures that the smallest element is at the beginning ({@code left}) and
     *     the largest element is at the end ({@code right}) of the current subarray.</li>
     *     <li>The variable {@code third} is calculated as {@code ((right - left + 1) / 3)}, which represents one-third
     *     of the subarray's size.</li>
     *     <li>The next condition if {@code ((third * 3) >= 3)} checks if the size of the current subarray is greater
     *     than or equal to <i>3</i> elements. If not, the method returns, as an array with <i>2</i> or fewer elements is
     *     already sorted.</li>
     *     <li>If the subarray size is greater than or equal to <i>3</i>, the {@code stoogeInc} method is called recursively
     *     three times:</li>
     *     <li>The first recursive call sorts the first two-thirds of the subarray:
     *     {@code stoogeInc(array, left, (right - third))}.</li>
     *     <li>The second recursive call sorts the last two-thirds of the subarray:
     *     {@code stoogeInc(array, (left + third), right)}.</li>
     *     <li>The third recursive call sorts again the first two-thirds of the subarray. The {@code left} index remains
     *     the same, but the {@code right} index is adjusted to {@code (right - third)} again.</li>
     * </ul>
     * {@code stoogeInc} the implementation divides the array into three parts, but the second and third recursive calls
     * are sorting the same part again (first two-thirds).
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void stoogeInc(Comparable[] array, int left, int right) {
        if (array[left].compareTo(array[right]) > 0) {
            swap(array, left, right);
        }
        int third = ((right - left + 1) / 3);
        if ((third * 3) >= 3) {
            stoogeInc(array, left, (right - third));
            stoogeInc(array, (left + third), right);
            stoogeInc(array, left, (right- third));
        }
    }

    /**
     * {@code stoogeDec} method that takes three arguments: an array of {@link java.lang.Comparable Comparable} objects,
     * {@code left} (the starting index), and {@code right} (the ending index) of the portion of the array to be sorted.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The first condition {@code array[left].compareTo(array[right]) < 0} compares the elements at the {@code left}
     *     and {@code right} indices and swaps them if the element at the {@code left} index is smaller than the element
     *     at the {@code right} index. This step ensures that the greatest element is at the beginning ({@code left}) and
     *     the largest element is at the end ({@code right}) of the current subarray.</li>
     *     <li>The variable {@code third} is calculated as {@code ((right - left + 1) / 3)}, which represents one-third
     *     of the subarray's size.</li>
     *     <li>The next condition if {@code ((third * 3) >= 3)} checks if the size of the current subarray is greater
     *     than or equal to <i>3</i> elements. If not, the method returns, as an array with <i>2</i> or fewer elements is
     *     already sorted.</li>
     *     <li>If the subarray size is greater than or equal to <i>3</i>, the {@code stoogeDec} method is called recursively
     *     three times:</li>
     *     <li>The first recursive call sorts the first two-thirds of the subarray:
     *     {@code stoogeDec(array, left, (right - third))}.</li>
     *     <li>The second recursive call sorts the last two-thirds of the subarray:
     *     {@code stoogeDec(array, (left + third), right)}.</li>
     *     <li>The third recursive call sorts again the first two-thirds of the subarray. The {@code left} index remains
     *     the same, but the {@code right} index is adjusted to {@code (right - third)} again.</li>
     * </ul>
     * {@code stoogeDec} the implementation divides the array into three parts, but the second and third recursive calls
     * are sorting the same part again (first two-thirds).
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void stoogeDec(Comparable[] array, int left, int right) {
        if (array[left].compareTo(array[right]) < 0) {
            swap(array, left, right);
        }
        int third = ((right - left + 1) / 3);
        if ((third * 3) >= 3) {
            stoogeDec(array, left, (right - third));
            stoogeDec(array, (left + third), right);
            stoogeDec(array, left, (right- third));
        }
    }

    /**
     * {@code stooge} method that takes three arguments: an array of {@link java.lang.Comparable Comparable} objects,
     * {@code left} (the starting index), and {@code right} (the ending index) an additional parameter
     * {@code SortFunctional<Comparable>} {@code functional}. This functional interface is used to compare elements in
     * the array. Instead of calling {@code compareTo}, it will call the {@code functionalCompareTo} method on the provided
     * functional object to perform the comparison.
     * <ul>
     *     <li>The first condition {@code functional.functionalCompareTo(array[left], array[right])} compares the elements
     *     at the {@code left} and {@code right} indices using the custom comparison logic provided by the {@code functional}
     *     object. If the result is true (indicating that the element at {@code left} is greater than the element at
     *     {@code right} based on the custom comparison), then it swaps the elements using the {@code swap} method.</li>
     *     <li>The variable {@code third} is calculated as {@code ((right - left + 1) / 3)}, representing one-third of
     *     the subarray's size.</li>
     *     <li>The next condition if {@code ((third * 3) >= 3)} checks if the size of the current subarray is greater
     *     than or equal to <i>3</i> elements. If not, the method returns, as an array with <i>2</i> or fewer elements
     *     is already sorted.</li>
     *     <li>If the subarray size is greater than or equal to <i>3</i>, the {@code stooge} method is called recursively
     *     three times:</li>
     *     <li>The first recursive call sorts the first two-thirds of the subarray:
     *     {@code stooge(array, left, (right - third), functional)}.</li>
     *     <li>The second recursive call sorts the last two-thirds of the subarray:
     *     {@code stooge(array, (left + third), right, functional)}.</li>
     *     <li>The third recursive call sorts again the first two-thirds of the subarray. The {@code left} index remains
     *     the same, but the {@code right} index is adjusted to {@code (right - third)} again:
     *     {@code stooge(array, left, (right - third), functional)}.</li>
     * </ul>
     * {@code stooge} the implementation divides the array into three parts, but the second and third recursive calls
     * are sorting the same part again (first two-thirds).
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    protected void stooge(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        if (functional.functionalCompareTo(array[left], array[right])) {
            swap(array, left, right);
        }
        int third = ((right - left + 1) / 3);
        if ((third * 3) >= 3) {
            stooge(array, left, (right - third), functional);
            stooge(array, (left + third), right, functional);
            stooge(array, left, (right- third), functional);
        }
    }

    /**
     * {@code stoogeInc} method with the initial left and right indices set to <i>0</i> and {@code (list.size() - 1)},
     * respectively, to sort the entire list.
     * <ul>
     *     <li>This method entry point for the stooge sort algorithm on a {@link java.util.List List}. It takes a single
     *     argument, a {@code List} of elements {@code List<L> list} that extend the {@link java.lang.Comparable Comparable}
     *     interface.</li>
     *     <li>{@code stoogeInc(list, 0, (list.size() - 1))} This line of code calls the recursive {@code stoogeInc} method,
     *     passing the entire list as the input and setting the initial left and right indices to <i>0</i> and
     *     {@code (list.size() - 1)}, respectively.</li>
     *     <li>{@code stoogeInc} method is responsible for performing the stooge sort algorithm on the sublist specified
     *     by the {@code left} and {@code right} indices. As described in the previous responses, the stooge sort algorithm
     *     recursively divides the list into three parts and sorts them.</li>
     * </ul>
     * By calling {@code stoogeInc} on a list, you can use the stooge sort algorithm to sort the entire list in ascending
     * order based on the natural ordering of the elements (as they extend the {@code Comparable} interface). The
     * {@code stoogeInc} method assumes the natural ordering of elements for comparison.
     * @param       list to be arranged.
     * @param       <L> allows this method to be used with different types.
     * @see         mz.Stooge#stoogeInc(List, int, int)
     */
    protected <L extends Comparable> void stoogeInc(List<L> list) {
        stoogeInc(list, 0, (list.size() - 1));
    }

    /**
     * {@code stoogeDec} method with the initial left and right indices set to <i>0</i> and {@code (list.size() - 1)},
     * respectively, to sort the entire list.
     * <ul>
     *     <li>This method entry point for the stooge sort algorithm on a {@link java.util.List List}. It takes a single
     *     argument, a {@code List} of elements {@code List<L> list} that extend the {@link java.lang.Comparable Comparable}
     *     interface.</li>
     *     <li>{@code stoogeDec(list, 0, (list.size() - 1))} This line of code calls the recursive {@code stoogeDec} method,
     *     passing the entire list as the input and setting the initial left and right indices to <i>0</i> and
     *     {@code (list.size() - 1)}, respectively.</li>
     *     <li>{@code stoogeDec} method is responsible for performing the stooge sort algorithm on the sublist specified
     *     by the {@code left} and {@code right} indices. As described in the previous responses, the stooge sort algorithm
     *     recursively divides the list into three parts and sorts them.</li>
     * </ul>
     * By calling {@code stoogeDec} on a list, you can use the stooge sort algorithm to sort the entire list in descending
     * order based on the natural ordering of the elements (as they extend the {@code Comparable} interface). The
     * {@code stoogeInc} method assumes the natural ordering of elements for comparison.
     * @param       list to be arranged.
     * @param       <L> allows this method to be used with different types.
     * @see         mz.Stooge#stoogeDec(List, int, int)
     */
    protected <L extends Comparable> void stoogeDec(List<L> list) {
        stoogeDec(list, 0, (list.size() - 1));
    }

    /**
     * {@code stooge} method entry point for the stooge sort algorithm on a {@link java.util.List List}. It takes two
     * arguments {@code List} of elements {@code List<L> list} that extend the {@link java.lang.Comparable Comparable}
     * interface and a {@code functional} object implementing the {@code SortFunctional<Comparable>} interface. This
     * {@code functional} interface allows for custom comparison logic to be provided.
     * <ul>
     *     <li>{@code stooge(list, 0, (list.size() - 1), functional)} This line of code calls recursive {@code stooge}
     *     method, passing the entire list as the input and setting the initial left and right indices to <i>0</i> and
     *     {@code (list.size() - 1)}, respectively. It also passes the {@code functional} object to perform custom
     *     comparisons.</li>
     *     <li>{@code stooge} method is responsible for performing the stooge sort algorithm on the sublist specified by
     *     the {@code left} and {@code right} indices. The implementation should be similar to the previously discussed
     *     recursive stooge sort, but with the added capability of using the custom comparison logic during element
     *     comparisons.</li>
     * </ul>
     * {@code stooge} method  allows for a flexible sorting process by using custom comparison logic through the
     * {@code functional} object. This makes the Stooge sort algorithm adaptable to a wide range of data types and custom
     * ordering requirements.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @param       <L> allows this method to be used with different types.
     * @see         mz.Stooge#stoogeDec(List, int, int)
     */
    protected <L extends Comparable> void stooge(List<L> list, SortFunctional<Comparable> functional) {
        stooge(list, 0, (list.size() - 1), functional);
    }

    /**
     * {@code stoogeInc} method that takes three parameters list of elements {@code List<L> list}, the {@code left} index,
     * and the {@code right} index of the portion of the list to be sorted. The generic type {@code L} extends the
     * {@link java.lang.Comparable Comparable} interface, ensuring that elements in the list can be compared.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} This annotation is used to suppress
     *     compiler warnings. In this context, it is likely suppressing warnings related to the use of unchecked conversions
     *     (i.e., type safety) because of the generic type {@code L} extends {@code Comparable}.</li>
     *     <li>If {@code (list.get(left).compareTo(list.get(right)) > 0)} This line compares the elements at the {@code left}
     *     and {@code right} indices in the list using their natural ordering defined by the {@code Comparable} interface.
     *     If the element at the {@code left} index is greater than the element at the {@code right} index, it swaps them
     *     using the {@code swap} method.</li>
     *     <li>The variable {@code third = ((right - left + 1) / 3)} calculates the size of one-third of the sublist.</li>
     *     <li>This condition checks if the sublist size is greater than or equal to <i>3</i> elements. If not, the method
     *     returns, as a sublist with <i>2</i> or fewer elements is already sorted.</li>
     *     <li>If the sublist size is greater than or equal to <i>3</i>, the {@code stoogeInc} method is called recursively
     *     three times to sort the sublist:</li>
     *     <li>The first recursive call sorts the first two-thirds of the sublist:
     *     {@code stoogeInc(list, left, (right - third))}.</li>
     *     <li>The second recursive call sorts the last two-thirds of the sublist:
     *     {@code stoogeInc(list, (left + third), right)}.</li>
     *     <li>The third recursive call sorts again the first two-thirds of the sublist. The {@code left} index remains
     *     the same, but the right index is adjusted to {@code (right - third)} again:
     *     {@code stoogeInc(list, left, (right - third))}.</li>
     * </ul>
     * {@code stoogeInc} the implementation divides the list into three parts, but the second and third recursive calls
     * are sorting the same part again (first two-thirds).
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @param       <L> allows this method to be used with different types.
     * @see         mz.SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void stoogeInc(List<L> list, int left, int right) {
        if (list.get(left).compareTo(list.get(right)) > 0) {
            swap(list, left, right);
        }
        int third = ((right - left + 1) / 3);
        if ((third * 3) >= 3) {
            stoogeInc(list, left, (right - third));
            stoogeInc(list, (left + third), right);
            stoogeInc(list, left, (right- third));
        }
    }

    /**
     * {@code stoogeDec} method that takes three parameters list of elements {@code List<L> list}, the {@code left} index,
     * and the {@code right} index of the portion of the list to be sorted. The generic type {@code L} extends the
     * {@link java.lang.Comparable Comparable} interface, ensuring that elements in the list can be compared.
     * <ul>
     *     <li>{@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} This annotation is used to suppress
     *     compiler warnings. In this context, it is likely suppressing warnings related to the use of unchecked conversions
     *     (i.e., type safety) because of the generic type {@code L} extends {@code Comparable}.</li>
     *     <li>If {@code (list.get(left).compareTo(list.get(right)) < 0)} This line compares the elements at the {@code left}
     *     and {@code right} indices in the list using their natural ordering defined by the {@code Comparable} interface.
     *     If the element at the {@code left} index is smaller than the element at the {@code right} index, it swaps them
     *     using the {@code swap} method.</li>
     *     <li>The variable {@code third = ((right - left + 1) / 3)} calculates the size of one-third of the sublist.</li>
     *     <li>This condition checks if the sublist size is greater than or equal to <i>3</i> elements. If not, the method
     *     returns, as a sublist with <i>2</i> or fewer elements is already sorted.</li>
     *     <li>If the sublist size is greater than or equal to <i>3</i>, the {@code stoogeDec} method is called recursively
     *     three times to sort the sublist:</li>
     *     <li>The first recursive call sorts the first two-thirds of the sublist:
     *     {@code stoogeDec(list, left, (right - third))}.</li>
     *     <li>The second recursive call sorts the last two-thirds of the sublist:
     *     {@code stoogeDec(list, (left + third), right)}.</li>
     *     <li>The third recursive call sorts again the first two-thirds of the sublist. The {@code left} index remains
     *     the same, but the right index is adjusted to {@code (right - third)} again:
     *     {@code stoogeDec(list, left, (right - third))}.</li>
     * </ul>
     * {@code stoogeDec} the implementation divides the list into three parts, but the second and third recursive calls
     * are sorting the same part again (first two-thirds).
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @param       <L> allows this method to be used with different types.
     * @see         mz.SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void stoogeDec(List<L> list, int left, int right) {
        if (list.get(left).compareTo(list.get(right)) < 0) {
            swap(list, left, right);
        }
        int third = ((right - left + 1) / 3);
        if ((third * 3) >= 3) {
            stoogeDec(list, left, (right - third));
            stoogeDec(list, (left + third), right);
            stoogeDec(list, left, (right- third));
        }
    }

    /**
     * {@code stooge} method that takes four parameters list of elements {@code List<L> list}, the {@code left} index,
     * the {@code right} index of the portion of the list to be sorted, and a {@code functional} object implementing the
     * {@code SortFunctional<Comparable>} interface.
     * <ul>
     *     <li>If {@code (functional.functionalCompareTo(list.get(left), list.get(right)))} This line compares the elements
     *     at the {@code left} and {@code right} indices in the list using the custom comparison logic provided by the
     *     {@code functional} object. If the result is true, it swaps them using the {@code swap} method</li>
     *     <li>The variable {@code third = ((right - left + 1) / 3)} calculates the size of one-third of the sublist.</li>
     *     <li>If {@code ((third * 3) >= 3)} This condition checks if the sublist size is greater than or equal to <i>3</i>
     *     elements. If not, the method returns, as a sublist with <i>2</i> or fewer elements is already sorted.</li>
     *     <li>If the sublist size is greater than or equal to <i>3</i>, the stooge method is called recursively three
     *     times to sort the sublist:</li>
     *     <li>The first recursive call sorts the first two-thirds of the sublist:
     *     {@code stooge(list, left, (right - third), functional)}.</li>
     *     <li>he second recursive call sorts the last two-thirds of the sublist:
     *     {@code stooge(list, (left + third), right, functional)}.</li>
     *     <li>The third recursive call sorts again the first two-thirds of the sublist. The {@code left} index remains
     *     the same, but the {@code right} index is adjusted to {@code (right - third)}again:
     *     {@code stooge(list, left, (right - third), functional)}.</li>
     * </ul>
     * {@code stooge} the implementation divides the list into three parts, but the second and third recursive calls
     * are sorting the same part again (first two-thirds).
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @param       <L> allows this method to be used with different types.
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         mz.SortSwap#swap(List, int, int)
     */
    protected <L extends Comparable> void stooge(List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        if (functional.functionalCompareTo(list.get(left), list.get(right))) {
            swap(list, left, right);
        }
        int third = ((right - left + 1) / 3);
        if ((third * 3) >= 3) {
            stooge(list, left, (right - third), functional);
            stooge(list, (left + third), right, functional);
            stooge(list, left, (right- third), functional);
        }
    }
}