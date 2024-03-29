package github.magyarzoli.sort;

import github.magyarzoli.Sort;
import github.magyarzoli.SortFunctional;
import github.magyarzoli.SortSwap;
import github.magyarzoli.sort.intro.IntroQuick3;

import java.util.List;

/**
 * Quick Sort 3-Way in simple QuickSort algorithm, we select an element as pivot,
 * partition the array around a pivot and recur for subarrays on the left and right of the pivot.
 * Simple Quick Sort, we fix only one 4 and recursively process remaining occurrences.
 * The idea of 3 way Quick Sort is to process all occurrences of the pivot
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Quick3
        extends Quick {

    /**
     * Storing {@code i} and {@code j} in the variable field.
     */
    protected int i, j;

    /**
     * <b>Quick Sort 3-Way:</b><br>
     * Quick Sort 3-Way in simple QuickSort algorithm, we select an element as pivot,
     * partition the array around a pivot and recur for subarrays on the left and right of the pivot.
     * Simple Quick Sort, we fix only one 4 and recursively process remaining occurrences.
     * The idea of 3 way Quick Sort is to process all occurrences of the pivot.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Choose a pivot element from the array.
     *     This can be done in various ways, such as selecting the {@code left}, {@code right} element.</li>
     *     <li>Partition the array into two sub-arrays:
     *     one with elements less than the pivot and another with elements greater than the pivot.
     *     The pivot should be in its final sorted position.</li>
     *     <li>Recursively apply the above steps to the sub-arrays, until the entire array is sorted.</li>
     *     <li>The base case of the recursion is when a sub-array has fewer than two elements,
     *     in which case it is already considered sorted.</li>
     * </ol>
     * <b>Note:</b><br>
     * Quicksort has an average-case time complexity of <em>O(n log(n))</em> and performs well in practice.
     * It is widely used and is considered one of the fastest general-purpose sorting algorithms.
     * The average number of recursive calls made to the quicksort function is <em>log(n)</em>,
     * and every time the function is called we are traversing the given array/list which requires <em>O(N)</em> time.
     * Thus, the total time complexity is <em>O(n log(n))</em>.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(log(n))</em><br>
     * Stability:               <b>No</b>
     * @see         IntroQuick3#IntroQuick3() IntroQuick3
     */
    public Quick3() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        quick3Inc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        quick3Dec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        quick3(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        quick3Inc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        quick3Dec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        quick3(list, functional);
    }

    /**
     * {@code quick3Inc} that implements the Quick Sort algorithm to sort an array of
     * {@link java.lang.Comparable Comparable} objects in ascending order.
     * <ul>
     *     <li>The method takes in an array of {@code Comparable} objects, {@code array},
     *     and the left is <i>0</i> and right is {@code (array.length - 1)} indices specifying the portion of the
     *     array to be sorted.</li>
     *     <li>The method first checks if the left index is greater than or equal to the right index. If so,
     *     it means the portion of the array is empty or contains only one element, and no further sorting is required.
     *     In such cases, the method returns.</li>
     *     <li>If there are more than one elements in the portion, the method proceeds with the sorting process.</li>
     *     <li>The variables {@code i} and {@code j} are set to {@code left} and {@code right}, respectively,
     *     representing the boundaries of the partition.</li>
     *     <li>The {@code partition3Inc} method is called to partition the array into three parts using the three-way
     *     partitioning technique.</li>
     *     <li>After the partitioning, the array is divided into three parts: elements less than the pivot,
     *     elements equal to the pivot, and elements greater than the pivot.</li>
     *     <li>The method recursively calls itself to sort the left and right partitions separately.</li>
     *     <li>The first recursive call, {@code quickInc(array, left, i)}, sorts the left partition from {@code left}
     *     to {@code i}.</li>
     *     <li>The second recursive call, {@code quickInc(array, j, right)}, sorts the right partition from {@code j}
     *     to {@code right}.</li>
     *     <li>The sorting process continues recursively until the entire array is sorted.</li>
     * </ul>
     * {@code quick3Inc} method implements the Quick Sort algorithm to sort the given {@code array} of Comparable
     * objects in ascending order.
     * It performs a three-way partitioning and recursively sorts the left and right partitions until the entire array
     * is sorted.
     * @param       array to be arranged.
     * @see         Quick3#quick3Inc(Comparable[], int, int)
     */
    protected void quick3Inc(Comparable[] array) {
        quick3Inc(array, 0, (array.length - 1));
    }

    /**
     * {@code quick3Dec} that implements the Quick Sort algorithm to sort an array of
     * {@link java.lang.Comparable Comparable} objects in descending order.
     * <ul>
     *     <li>The method takes in an array of {@code Comparable} objects, {@code array},
     *     and the left is <i>0</i> and right is {@code (array.length - 1)} indices specifying the portion of the array
     *     to be sorted.</li>
     *     <li>The method first checks if the left index is greater than or equal to the right index. If so,
     *     it means the portion of the array is empty or contains only one element, and no further sorting is required.
     *     In such cases, the method returns.</li>
     *     <li>If there are more than one elements in the portion, the method proceeds with the sorting process.</li>
     *     <li>The variables {@code i} and {@code j} are set to {@code left} and {@code right}, respectively,
     *     representing the boundaries of the partition.</li>
     *     <li>The {@code partition3Dec} method is called to partition the array into three parts using the three-way
     *     partitioning technique.</li>
     *     <li>After the partitioning, the array is divided into three parts: elements less than the pivot,
     *     elements equal to the pivot, and elements greater than the pivot.</li>
     *     <li>The method recursively calls itself to sort the left and right partitions separately.</li>
     *     <li>The first recursive call, {@code quickDec(array, left, i)}, sorts the left partition from {@code left}
     *     to {@code i}.</li>
     *     <li>The second recursive call, {@code quickDec(array, j, right)}, sorts the right partition from {@code j}
     *     to {@code right}.</li>
     *     <li>The sorting process continues recursively until the entire array is sorted.</li>
     * </ul>
     * {@code quick3Dec} method implements the Quick Sort algorithm to sort the given {@code array} of Comparable
     * objects in descending order.
     * It performs a three-way partitioning and recursively sorts the left and right partitions until the entire array
     * is sorted.
     * @param       array to be arranged.
     * @see         Quick3#quick3Dec(Comparable[], int, int)
     */
    protected void quick3Dec(Comparable[] array) {
        quick3Dec(array, 0, (array.length - 1));
    }

    /**
     * The method {@code quick3} takes four parameters:
     * {@code array} an array of {@link java.lang.Comparable Comparable} objects,
     * and {@code functional} an instance of {@code SortFunctional} representing a functional interface for comparison
     * operations.
     * <ul>
     *     <li>The first line of code checks if <i>0</i> is greater than or equal to {@code (array.length - 1)},
     *     which indicates that the partition has one or zero elements.
     *     In such cases, there is nothing to sort, so the method returns.</li>
     *     <li>The code then sets the variables {@code i} to {@code left} and {@code j} to {@code right}.
     *     These variables are used to keep track of the current partition boundaries.</li>
     *     <li>The {@code partition3} method is called with the {@code array}, {@code left}, {@code right}, and
     *     {@code functional} parameters.
     *     This method performs the three-way partitioning of the array.</li>
     *     <li>After the partitioning is done, the array is divided into three parts:
     *     elements less than the pivot, elements equal to the pivot, and elements greater than the pivot.</li>
     *     <li>The method calls itself recursively twice: {@code quick3(array, left, i, functional)}
     *     to sort the left partition (elements less than the pivot), and {@code quick3(array, j, right, functional)}
     *     to sort the right partition (elements greater than the pivot).</li>
     *     <li>The recursive calls continue until all subpartitions have been sorted,
     *     resulting in a fully sorted array.</li>
     * </ul>
     * {@code quick3} method implements the Quick Sort algorithm using a three-way partitioning scheme.
     * It recursively partitions the array into smaller subpartitions, sorts them, and combines them to achieve a final
     * sorted array.
     * The specific comparison operation used for sorting is defined by the {@code functional} object passed as a
     * parameter.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         Quick3#quick3(Comparable[], int, int, SortFunctional)
     */
    protected void quick3(Comparable[] array, SortFunctional<Comparable> functional) {
        quick3(array, 0, (array.length - 1), functional);
    }

    /**
     * {@code quick3Inc} that implements the Quick Sort algorithm to sort an array of
     * {@link java.lang.Comparable Comparable} objects in ascending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array},
     *     and the left and right indices specifying the portion of the array to be sorted.</li>
     *     <li>The method first checks if the left index is greater than or equal to the right index. If so,
     *     it means the portion of the array is empty or contains only one element, and no further sorting is required.
     *     In such cases, the method returns.</li>
     *     <li>If there are more than one elements in the portion, the method proceeds with the sorting process.</li>
     *     <li>The variables {@code i} and {@code j} are set to {@code left} and {@code right}, respectively,
     *     representing the boundaries of the partition.</li>
     *     <li>The {@code partition3Inc} method is called to partition the array into three parts using the three-way
     *     partitioning technique.</li>
     *     <li>After the partitioning, the array is divided into three parts: elements less than the pivot,
     *     elements equal to the pivot, and elements greater than the pivot.</li>
     *     <li>The method recursively calls itself to sort the left and right partitions separately.</li>
     *     <li>The first recursive call, {@code quickInc(array, left, i)}, sorts the left partition from {@code left}
     *     to {@code i}.</li>
     *     <li>The second recursive call, {@code quickInc(array, j, right)}, sorts the right partition from {@code j}
     *     to {@code right}.</li>
     *     <li>The sorting process continues recursively until the entire array is sorted.</li>
     * </ul>
     * {@code quick3Inc} method implements the Quick Sort algorithm to sort the given {@code array} of Comparable
     * objects in ascending order.
     * It performs a three-way partitioning and recursively sorts the left and right partitions until the entire array
     * is sorted.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         Quick3#partition3Inc(Comparable[], int, int)
     */
    protected void quick3Inc(Comparable[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        i = left;
        j = right;
        partition3Inc(array, left, right);
        quick3Inc(array, left, i);
        quick3Inc(array, j, right);
    }

    /**
     * {@code quick3Dec} that implements the Quick Sort algorithm to sort an array of
     * {@link java.lang.Comparable Comparable} objects in descending order.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array},
     *     and the left and right indices specifying the portion of the array to be sorted.</li>
     *     <li>The method first checks if the left index is greater than or equal to the right index. If so,
     *     it means the portion of the array is empty or contains only one element, and no further sorting is required.
     *     In such cases, the method returns.</li>
     *     <li>If there are more than one elements in the portion, the method proceeds with the sorting process.</li>
     *     <li>The variables {@code i} and {@code j} are set to {@code left} and {@code right}, respectively,
     *     representing the boundaries of the partition.</li>
     *     <li>The {@code partition3Dec} method is called to partition the array into three parts using the three-way
     *     partitioning technique.</li>
     *     <li>After the partitioning, the array is divided into three parts: elements less than the pivot,
     *     elements equal to the pivot, and elements greater than the pivot.</li>
     *     <li>The method recursively calls itself to sort the left and right partitions separately.</li>
     *     <li>The first recursive call, {@code quickDec(array, left, i)}, sorts the left partition from {@code left}
     *     to {@code i}.</li>
     *     <li>The second recursive call, {@code quickDec(array, j, right)}, sorts the right partition from {@code j}
     *     to {@code right}.</li>
     *     <li>The sorting process continues recursively until the entire array is sorted.</li>
     * </ul>
     * {@code quick3Dec} method implements the Quick Sort algorithm to sort the given {@code array} of Comparable
     * objects in descending order.
     * It performs a three-way partitioning and recursively sorts the left and right partitions until the entire array
     * is sorted.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         Quick3#partition3Dec(Comparable[], int, int)
     */
    protected void quick3Dec(Comparable[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        i = left;
        j = right;
        partition3Dec(array, left, right);
        quick3Dec(array, left, i);
        quick3Dec(array, j, right);
    }

    /**
     * The method {@code quick3} takes four parameters:
     * {@code array} an array of {@link java.lang.Comparable Comparable} objects,
     * {@code left} the starting index of the partition, {@code right} the ending index of the partition,
     * and {@code functional} an instance of {@code SortFunctional} representing a functional interface for comparison
     * operations.
     * <ul>
     *     <li>The first line of code checks if {@code left} is greater than or equal to {@code right},
     *     which indicates that the partition has one or zero elements.
     *     In such cases, there is nothing to sort, so the method returns.</li>
     *     <li>The code then sets the variables {@code i} to {@code left} and {@code j} to {@code right}.
     *     These variables are used to keep track of the current partition boundaries.</li>
     *     <li>The {@code partition3} method is called with the {@code array}, {@code left}, {@code right}, and
     *     {@code functional} parameters.
     *     This method performs the three-way partitioning of the array.</li>
     *     <li>After the partitioning is done, the array is divided into three parts:
     *     elements less than the pivot, elements equal to the pivot, and elements greater than the pivot.</li>
     *     <li>The method calls itself recursively twice: {@code quick3(array, left, i, functional)}
     *     to sort the left partition (elements less than the pivot), and {@code quick3(array, j, right, functional)}
     *     to sort the right partition (elements greater than the pivot).</li>
     *     <li>The recursive calls continue until all subpartitions have been sorted,
     *     resulting in a fully sorted array.</li>
     * </ul>
     * {@code quick3} method implements the Quick Sort algorithm using a three-way partitioning scheme.
     * It recursively partitions the array into smaller subpartitions, sorts them, and combines them to achieve a final
     * sorted array.
     * The specific comparison operation used for sorting is defined by the {@code functional} object passed as a
     * parameter.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         Quick3#partition(Comparable[], int, int, SortFunctional)
     */
    protected void quick3(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        if (left >= right) {
            return;
        }
        i = left;
        j = right;
        partition3(array, left, right, functional);
        quick3(array, left, i, functional);
        quick3(array, j, right, functional);
    }

    /**
     * {@code partition3Inc} that partitions an array of
     * {@link java.lang.Comparable Comparable} objects into three parts:
     * elements less than a pivot, elements equal to the pivot, and elements greater than the pivot.
     * The partitioning is done in-place.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array},
     *     and the left and right indices specifying the portion of the array to be partitioned.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo}
     *     method.</li>
     *     <li>The method first checks if the portion of the array to be partitioned has one or zero elements.
     *     If so, it performs a simple check to ensure that the elements are in the correct order,
     *     swaps them if necessary, and sets {@code i} to {@code left} and {@code j} to {@code right}.</li>
     *     <li>If the portion has more than one element, the method proceeds to perform a three-way partition using
     *     the pivot element.</li>
     *     <li>The {@code mid} variable is initialized with the value of {@code left}.
     *     This variable represents the current index being considered during the partitioning process.</li>
     *     <li>The pivot element is chosen as the element at index {@code right}.</li>
     *     <li>A {@code while} loop is used to iterate from {@code left} to {@code right},
     *     comparing each element with the pivot and performing the necessary swaps to achieve the three-way
     *     partition.</li>
     *     <li>If the element at index {@code mid} is less than the pivot, it is swapped with the element at
     *     index {@code left}.
     *     {@code left} and {@code mid} are then incremented to move to the next elements.</li>
     *     <li>If the element at index {@code mid} is equal to the pivot,
     *     {@code mid} is incremented to move to the next element without performing any swaps.</li>
     *     <li>If the element at index {@code mid} is greater than the pivot, it is swapped with the element at
     *     index {@code right}.
     *     {@code right} is decremented to move to the next element.</li>
     *     <li>After the {@code while} loop completes, the array is partitioned into three parts:
     *     elements less than the pivot, elements equal to the pivot, and elements greater than the pivot.</li>
     *     <li>The variable {@code i} is set to {@code (left - 1)} to represent the index of the last element in the
     *     left partition.</li>
     *     <li>The variable {@code j} is set to {@code mid} to represent the index where the middle partition
     *     begins.</li>
     * </ul>
     * {@code partition3Inc} method partitions the given {@code array} of
     * {@link java.lang.Comparable Comparable} objects into three parts:
     * elements less than the pivot, elements equal to the pivot, and elements greater than the pivot.
     * It uses the last element as the pivot and performs swaps to achieve the partitioning.
     * The indices {@code i} and {@code j} are updated to represent the boundaries of the partitions.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void partition3Inc(Comparable[] array, int left, int right) {
        if (((right + 1) - left) <= 1) {
            if (array[right].compareTo(array[left]) < 0) {
                swap(array, right, left);
            }
            i = left;
            j = right;
            return;
        }
        int mid = left;
        Comparable pivot = array[right];
        while (mid <= right) {
            if (pivot.compareTo(array[mid]) > 0) {
                swap(array, left++, mid++);
            } else if (pivot.compareTo(array[mid]) == 0) {
                mid++;
            } else if (pivot.compareTo(array[mid]) < 0) {
                swap(array, mid, right--);
            }
        }
        i = (left - 1);
        j = mid;
    }

    /**
     * {@code partition3Dec} that partitions an array of
     * {@link java.lang.Comparable Comparable} objects into three parts:
     * elements less than a pivot, elements equal to the pivot, and elements smaller than the pivot.
     * The partitioning is done in-place.
     * <ul>
     *     <li>The method takes in an array of Comparable objects, {@code array},
     *     and the left and right indices specifying the portion of the array to be partitioned.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used
     *     to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo}
     *     method.</li>
     *     <li>The method first checks if the portion of the array to be partitioned has one or zero elements.
     *     If so, it performs a simple check to ensure that the elements are in the correct order,
     *     swaps them if necessary, and sets {@code i} to {@code left} and {@code j} to {@code right}.</li>
     *     <li>If the portion has more than one element, the method proceeds to perform a three-way partition
     *     using the pivot element.</li>
     *     <li>The {@code mid} variable is initialized with the value of {@code left}.
     *     This variable represents the current index being considered during the partitioning process.</li>
     *     <li>The pivot element is chosen as the element at index {@code right}.</li>
     *     <li>A {@code while} loop is used to iterate from {@code left} to {@code right},
     *     comparing each element with the pivot and performing the necessary swaps to achieve the three-way
     *     partition.</li>
     *     <li>If the element at index {@code mid} is greater than the pivot, it is swapped with the element at
     *     index {@code left}.
     *     {@code left} and {@code mid} are then incremented to move to the next elements.</li>
     *     <li>If the element at index {@code mid} is equal to the pivot,
     *     {@code mid} is incremented to move to the next element without performing any swaps.</li>
     *     <li>If the element at index {@code mid} is less than the pivot, it is swapped with the element at
     *     index {@code right}.
     *     {@code right} is decremented to move to the next element.</li>
     *     <li>After the {@code while} loop completes, the array is partitioned into three parts:
     *     elements less than the pivot, elements equal to the pivot, and elements smaller than the pivot.</li>
     *     <li>The variable {@code i} is set to {@code (left - 1)} to represent the index of the last element in
     *     the left partition.</li>
     *     <li>The variable {@code j} is set to {@code mid} to represent the index where the middle partition
     *     begins.</li>
     * </ul>
     * {@code partition3Dec} method partitions the given {@code array} of Comparable objects into three parts:
     * elements less than the pivot, elements equal to the pivot, and elements smaller than the pivot.
     * It uses the last element as the pivot and performs swaps to achieve the partitioning.
     * The indices {@code i} and {@code j} are updated to represent the boundaries of the partitions.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void partition3Dec(Comparable[] array, int left, int right) {
        if (((right + 1) - left) <= 1) {
            if (array[right].compareTo(array[left]) < 0) {
                swap(array, right, left);
            }
            i = left;
            j = right;
            return;
        }
        int mid = left;
        Comparable pivot = array[right];
        while (mid <= right) {
            if (pivot.compareTo(array[mid]) < 0) {
                swap(array, left++, mid++);
            } else if (pivot.compareTo(array[mid]) == 0) {
                mid++;
            } else if (pivot.compareTo(array[mid]) > 0) {
                swap(array, mid, right--);
            }
        }
        i = (left - 1);
        j = mid;
    }

    /**
     * The method {@code partition3} takes four parameters: {@code array} an array of {@link java.lang.Comparable
     * Comparable} objects,
     * {@code left} the starting index of the partition, {@code right} the ending index of the partition,
     * and {@code functional} an instance of SortFunctional representing a functional interface for comparison
     * operations.
     * <ul>
     *     <li>The condition {@code ((right + 1) - left) <= 1} checks if the partition has at most one element.
     *     If this condition is {@code true}, it swaps the elements at indices {@code left} and {@code right}
     *     if necessary
     *     to ensure that the left element is smaller than or equal to the right element.
     *     Then it sets {@code i} to {@code left} and {@code j} to {@code right} and returns.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is
     *     used to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object)
     *     compareTo} method.</li>
     *     <li>If the partition has more than one element,
     *     the code initializes {@code mid} to {@code left} and selects the pivot element as {@code array[right]}.</li>
     *     <li>It defines a new {@code SortFunctional<Comparable>} called {@code functionalReverse}
     *     by passing {@code functional} to a method {@code functionalComparableToReverse}.
     *     This method returns a {@code SortFunctional} object that performs the reverse of
     *     the comparison operation defined in the original {@code functional} object.</li>
     *     <li>The code enters a loop that iterates while {@code mid} is less than or equal to {@code right}.
     *     Inside the loop, it compares the element at {@code array[mid]} to
     *     the pivot using the {@code functional.functionalCompareTo} method.</li>
     *     <li>If the result of the comparison is {@code true} (i.e., the element at {@code array[mid]} is
     *     less than the pivot),
     *     it swaps the elements at {@code left} and {@code mid},
     *     increments both {@code left} and {@code mid} by <i>1</i>, and continues to the next iteration.</li>
     *     <li>If the element at {@code array[mid]} is equal to the pivot,
     *     it simply increments {@code mid} by <i>1</i> and continues to the next iteration.</li>
     *     <li>If the element at {@code array[mid]} is greater than the pivot
     *     (according to the reverse comparison defined by {@code functionalReverse}),
     *     it swaps the elements at {@code mid} and {@code right}, decrements {@code right} by <i>1</i>,
     *     and continues to the next iteration.</li>
     *     <li>After the loop finishes, the variables {@code i} and {@code j} are set.
     *     {@code i} is set to {@code (left - 1)}(the index of the last element in the left partition),
     *     and {@code j} is set to {@code mid} (the index where the middle and right partitions begin).</li>
     * </ul>
     * {@code partition3} method partitions the given {@code array} of Comparable objects into three parts:
     * elements less than the pivot, elements equal to the pivot, and elements smaller than the pivot.
     * It uses the last element as the pivot and performs swaps to achieve the partitioning.
     * The indices {@code i} and {@code j} are updated to represent the boundaries of the partitions.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         SortSwap#swap(Comparable[], int, int)
     * @see         Sort#functionalComparableToReverse(SortFunctional)
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    @SuppressWarnings("unchecked")
    protected void partition3(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        if (((right + 1) - left) <= 1) {
            if (array[right].compareTo(array[left]) < 0) {
                swap(array, right, left);
            }
            i = left;
            j = right;
            return;
        }
        int mid = left;
        Comparable pivot = array[right];
        SortFunctional<Comparable> functionalReverse = functionalComparableToReverse(functional);
        while (mid <= right) {
            if (functional.functionalCompareTo(array[mid], pivot)) {
                swap(array, left++, mid++);
            } else if (array[mid].compareTo(pivot) == 0) {
                mid++;
            } else if (functionalReverse.functionalCompareTo(array[mid], pivot)) {
                swap(array, mid, right--);
            }
        }
        i = (left - 1);
        j = mid;
    }

    /**
     * {@code quick3Inc} that implements the Quick Sort algorithm to sort a list of
     * {@link java.lang.Comparable Comparable} objects in ascending order.
     * <ul>
     *     <li>The method takes in an list of {@code Comparable} objects, {@code list},
     *     and the left is <i>0</i> and right is {@code (list.length - 1)} indices specifying the portion of the
     *     list to be sorted.</li>
     *     <li>The method first checks if the left index is greater than or equal to the right index. If so,
     *     it means the portion of the list is empty or contains only one element, and no further sorting is required.
     *     In such cases, the method returns.</li>
     *     <li>If there are more than one elements in the portion, the method proceeds with the sorting process.</li>
     *     <li>The variables {@code i} and {@code j} are set to {@code left} and {@code right}, respectively,
     *     representing the boundaries of the partition.</li>
     *     <li>The {@code partition3Inc} method is called to partition the list into three parts using the
     *     three-way partitioning technique.</li>
     *     <li>After the partitioning, the list is divided into three parts: elements less than the pivot,
     *     elements equal to the pivot, and elements greater than the pivot.</li>
     *     <li>The method recursively calls itself to sort the left and right partitions separately.</li>
     *     <li>The first recursive call, {@code quickInc(list, left, i)}, sorts the left partition from {@code left}
     *     to {@code i}.</li>
     *     <li>The second recursive call, {@code quickInc(list, j, right)}, sorts the right partition from {@code j}
     *     to {@code right}.</li>
     *     <li>The sorting process continues recursively until the entire list is sorted.</li>
     * </ul>
     * {@code quick3Inc} method implements the Quick Sort algorithm to sort the given {@code list} of Comparable
     * objects in ascending order.
     * It performs a three-way partitioning and recursively sorts the left and right partitions until the entire
     * list is sorted.
     * @param       list to be arranged.
     * @see         Quick3#quick3Inc(List, int, int)
     */
    protected <L extends Comparable> void quick3Inc(List<L> list) {
        quick3Inc(list, 0, (list.size() - 1));
    }

    /**
     * {@code quick3Dec} that implements the Quick Sort algorithm to sort a list of
     * {@link java.lang.Comparable Comparable} objects in descending order.
     * <ul>
     *     <li>The method takes in an list of {@code Comparable} objects, {@code list},
     *     and the left is <i>0</i> and right is {@code (list.length - 1)} indices specifying the portion of the
     *     list to be sorted.</li>
     *     <li>The method first checks if the left index is greater than or equal to the right index. If so,
     *     it means the portion of the list is empty or contains only one element, and no further sorting is required.
     *     In such cases, the method returns.</li>
     *     <li>If there are more than one elements in the portion, the method proceeds with the sorting process.</li>
     *     <li>The variables {@code i} and {@code j} are set to {@code left} and {@code right}, respectively,
     *     representing the boundaries of the partition.</li>
     *     <li>The {@code partition3Dec} method is called to partition the list into three parts using the
     *     three-way partitioning technique.</li>
     *     <li>After the partitioning, the list is divided into three parts: elements less than the pivot,
     *     elements equal to the pivot, and elements greater than the pivot.</li>
     *     <li>The method recursively calls itself to sort the left and right partitions separately.</li>
     *     <li>The first recursive call, {@code quickDec(list, left, i)}, sorts the left partition from {@code left}
     *     to {@code i}.</li>
     *     <li>The second recursive call, {@code quickDec(list, j, right)}, sorts the right partition from {@code j}
     *     to {@code right}.</li>
     *     <li>The sorting process continues recursively until the entire list is sorted.</li>
     * </ul>
     * {@code quick3Dec} method implements the Quick Sort algorithm to sort the given {@code list} of Comparable
     * objects in descending order.
     * It performs a three-way partitioning and recursively sorts the left and right partitions until the entire
     * list is sorted.
     * @param       list to be arranged.
     * @see         Quick3#quick3Dec(List, int, int)
     */
    protected <L extends Comparable> void quick3Dec(List<L> list) {
        quick3Dec(list, 0, (list.size() - 1));
    }

    /**
     * The method {@code quick3} takes four parameters:
     * {@code list} an list of {@link java.lang.Comparable Comparable} objects,
     * and {@code functional} an instance of {@code mz.SortFunctional} representing a functional interface for
     * comparison operations.
     * <ul>
     *     <li>The first line of code checks if <i>0</i> is greater than or equal to {@code (list.length - 1)},
     *     which indicates that the partition has one or zero elements.
     *     In such cases, there is nothing to sort, so the method returns.</li>
     *     <li>The code then sets the variables {@code i} to {@code left} and {@code j} to {@code right}.
     *     These variables are used to keep track of the current partition boundaries.</li>
     *     <li>The {@code partition3} method is called with the {@code list}, {@code left}, {@code right}, and
     *     {@code functional} parameters.
     *     This method performs the three-way partitioning of the list.</li>
     *     <li>After the partitioning is done, the list is divided into three parts:
     *     elements less than the pivot, elements equal to the pivot, and elements greater than the pivot.</li>
     *     <li>The method calls itself recursively twice: {@code quick3(list, left, i, functional)}
     *     to sort the left partition (elements less than the pivot), and {@code quick3(list, j, right, functional)}
     *     to sort the right partition (elements greater than the pivot).</li>
     *     <li>The recursive calls continue until all subpartitions have been sorted,
     *     resulting in a fully sorted list.</li>
     * </ul>
     * {@code quick3} method implements the Quick Sort algorithm using a three-way partitioning scheme.
     * It recursively partitions the list into smaller subpartitions, sorts them, and combines them to achieve
     * a final sorted list.
     * The specific comparison operation used for sorting is defined by the {@code functional} object passed
     * as a parameter.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         Quick3#quick3(List, int, int, SortFunctional)
     */
    protected <L extends Comparable> void quick3(List<L> list, SortFunctional<Comparable> functional) {
        quick3(list, 0, (list.size() - 1), functional);
    }

    /**
     * {@code quick3Inc} that implements the Quick Sort algorithm to sort a list of
     * {@link java.lang.Comparable Comparable} objects in ascending order.
     * <ul>
     *     <li>The method takes in an list of Comparable objects, {@code list},
     *     and the left and right indices specifying the portion of the list to be sorted.</li>
     *     <li>The method first checks if the left index is greater than or equal to the right index. If so,
     *     it means the portion of the list is empty or contains only one element, and no further sorting is required.
     *     In such cases, the method returns.</li>
     *     <li>If there are more than one elements in the portion, the method proceeds with the sorting process.</li>
     *     <li>The variables {@code i} and {@code j} are set to {@code left} and {@code right}, respectively,
     *     representing the boundaries of the partition.</li>
     *     <li>The {@code partition3Inc} method is called to partition the list into three parts using the
     *     three-way partitioning technique.</li>
     *     <li>After the partitioning, the list is divided into three parts: elements less than the pivot,
     *     elements equal to the pivot, and elements greater than the pivot.</li>
     *     <li>The method recursively calls itself to sort the left and right partitions separately.</li>
     *     <li>The first recursive call, {@code quickInc(list, left, i)}, sorts the left partition from {@code left}
     *     to {@code i}.</li>
     *     <li>The second recursive call, {@code quickInc(list, j, right)}, sorts the right partition from {@code j}
     *     to {@code right}.</li>
     *     <li>The sorting process continues recursively until the entire list is sorted.</li>
     * </ul>
     * {@code quick3Inc} method implements the Quick Sort algorithm to sort the given {@code list} of Comparable
     * objects in ascending order.
     * It performs a three-way partitioning and recursively sorts the left and right partitions until the entire
     * list is sorted.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         Quick3#partition3Inc(List, int, int)
     */
    protected <L extends Comparable> void quick3Inc(List<L> list, int left, int right) {
        if (left >= right) {
            return;
        }
        i = left;
        j = right;
        partition3Inc(list, left, right);
        quick3Inc(list, left, i);
        quick3Inc(list, j, right);
    }

    /**
     * {@code quick3Dec} that implements the Quick Sort algorithm to sort a list of
     * {@link java.lang.Comparable Comparable} objects in descending order.
     * <ul>
     *     <li>The method takes in an list of Comparable objects, {@code list},
     *     and the left and right indices specifying the portion of the list to be sorted.</li>
     *     <li>The method first checks if the left index is greater than or equal to the right index. If so,
     *     it means the portion of the list is empty or contains only one element, and no further sorting is required.
     *     In such cases, the method returns.</li>
     *     <li>If there are more than one elements in the portion, the method proceeds with the sorting process.</li>
     *     <li>The variables {@code i} and {@code j} are set to {@code left} and {@code right}, respectively,
     *     representing the boundaries of the partition.</li>
     *     <li>The {@code partition3Dec} method is called to partition the list into three parts using the three-way
     *     partitioning technique.</li>
     *     <li>After the partitioning, the list is divided into three parts: elements less than the pivot,
     *     elements equal to the pivot, and elements greater than the pivot.</li>
     *     <li>The method recursively calls itself to sort the left and right partitions separately.</li>
     *     <li>The first recursive call, {@code quickDec(list, left, i)}, sorts the left partition from {@code left}
     *     to {@code i}.</li>
     *     <li>The second recursive call, {@code quickDec(list, j, right)}, sorts the right partition from {@code j}
     *     to {@code right}.</li>
     *     <li>The sorting process continues recursively until the entire list is sorted.</li>
     * </ul>
     * {@code quick3Dec} method implements the Quick Sort algorithm to sort the given {@code list} of Comparable
     * objects in descending order.
     * It performs a three-way partitioning and recursively sorts the left and right partitions until the entire
     * list is sorted.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         Quick3#partition3Dec(List, int, int)
     */
    protected <L extends Comparable> void quick3Dec(List<L> list, int left, int right) {
        if (left >= right) {
            return;
        }
        i = left;
        j = right;
        partition3Dec(list, left, right);
        quick3Dec(list, left, i);
        quick3Dec(list, j, right);
    }

    /**
     * The method {@code quick3} takes four parameters:
     * {@code list} an list of {@link java.lang.Comparable Comparable} objects,
     * {@code left} the starting index of the partition, {@code right} the ending index of the partition,
     * and {@code functional} an instance of {@code mz.SortFunctional} representing a functional interface for
     * comparison operations.
     * <ul>
     *     <li>The first line of code checks if {@code left} is greater than or equal to {@code right},
     *     which indicates that the partition has one or zero elements.
     *     In such cases, there is nothing to sort, so the method returns.</li>
     *     <li>The code then sets the variables {@code i} to {@code left} and {@code j} to {@code right}.
     *     These variables are used to keep track of the current partition boundaries.</li>
     *     <li>The {@code partition3} method is called with the {@code list}, {@code left}, {@code right}, and
     *     {@code functional} parameters.
     *     This method performs the three-way partitioning of the list.</li>
     *     <li>After the partitioning is done, the list is divided into three parts:
     *     elements less than the pivot, elements equal to the pivot, and elements greater than the pivot.</li>
     *     <li>The method calls itself recursively twice: {@code quick3(list, left, i, functional)}
     *     to sort the left partition (elements less than the pivot), and {@code quick3(list, j, right, functional)}
     *     to sort the right partition (elements greater than the pivot).</li>
     *     <li>The recursive calls continue until all subpartitions have been sorted,
     *     resulting in a fully sorted list.</li>
     * </ul>
     * {@code quick3} method implements the Quick Sort algorithm using a three-way partitioning scheme.
     * It recursively partitions the list into smaller subpartitions, sorts them, and combines them to achieve a
     * final sorted list.
     * The specific comparison operation used for sorting is defined by the {@code functional} object passed as
     * a parameter.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         Quick3#partition(List, int, int, SortFunctional)
     */
    protected <L extends Comparable> void quick3(
            List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        if (left >= right) {
            return;
        }
        i = left;
        j = right;
        partition3(list, left, right, functional);
        quick3(list, left, i, functional);
        quick3(list, j, right, functional);
    }

    /**
     * {@code partition3Inc} that partitions a list of
     * {@link java.lang.Comparable Comparable} objects into three parts:
     * elements less than a pivot, elements equal to the pivot, and elements greater than the pivot.
     * The partitioning is done in-place.
     * <ul>
     *     <li>The method takes in an list of Comparable objects, {@code list},
     *     and the left and right indices specifying the portion of the list to be partitioned.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to
     *     suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo}
     *     method.</li>
     *     <li>The method first checks if the portion of the list to be partitioned has one or zero elements.
     *     If so, it performs a simple check to ensure that the elements are in the correct order,
     *     swaps them if necessary, and sets {@code i} to {@code left} and {@code j} to {@code right}.</li>
     *     <li>If the portion has more than one element, the method proceeds to perform a three-way partition
     *     using the pivot element.</li>
     *     <li>The {@code mid} variable is initialized with the value of {@code left}.
     *     This variable represents the current index being considered during the partitioning process.</li>
     *     <li>The pivot element is chosen as the element at index {@code right}.</li>
     *     <li>A {@code while} loop is used to iterate from {@code left} to {@code right},
     *     comparing each element with the pivot and performing the necessary swaps to achieve the three-way
     *     partition.</li>
     *     <li>If the element at index {@code mid} is less than the pivot, it is swapped with the element at
     *     index {@code left}.
     *     {@code left} and {@code mid} are then incremented to move to the next elements.</li>
     *     <li>If the element at index {@code mid} is equal to the pivot,
     *     {@code mid} is incremented to move to the next element without performing any swaps.</li>
     *     <li>If the element at index {@code mid} is greater than the pivot, it is swapped with the element
     *     at index {@code right}.
     *     {@code right} is decremented to move to the next element.</li>
     *     <li>After the {@code while} loop completes, the list is partitioned into three parts:
     *     elements less than the pivot, elements equal to the pivot, and elements greater than the pivot.</li>
     *     <li>The variable {@code i} is set to {@code (left - 1)} to represent the index of the last element
     *     in the left partition.</li>
     *     <li>The variable {@code j} is set to {@code mid} to represent the index where the middle partition
     *     begins.</li>
     * </ul>
     * {@code partition3Inc} method partitions the given {@code list} of
     * {@link java.lang.Comparable Comparable} objects into three parts:
     * elements less than the pivot, elements equal to the pivot, and elements greater than the pivot.
     * It uses the last element as the pivot and performs swaps to achieve the partitioning.
     * The indices {@code i} and {@code j} are updated to represent the boundaries of the partitions.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void partition3Inc(List<L> list, int left, int right) {
        if (((right + 1) - left) <= 1) {
            if (list.get(right).compareTo(list.get(left)) < 0) {
                swap(list, right, left);
            }
            i = left;
            j = right;
            return;
        }
        int mid = left;
        L pivot = list.get(right);
        while (mid <= right) {
            if (pivot.compareTo(list.get(mid)) > 0) {
                swap(list, left++, mid++);
            } else if (pivot.compareTo(list.get(mid)) == 0) {
                mid++;
            } else if (pivot.compareTo(list.get(mid)) < 0) {
                swap(list, mid, right--);
            }
        }
        i = (left - 1);
        j = mid;
    }

    /**
     * {@code partition3Dec} that partitions a list of
     * {@link java.lang.Comparable Comparable} objects into three parts:
     * elements less than a pivot, elements equal to the pivot, and elements smaller than the pivot.
     * The partitioning is done in-place.
     * <ul>
     *     <li>The method takes in an list of Comparable objects, {@code list},
     *     and the left and right indices specifying the portion of the list to be partitioned.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used
     *     to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo}
     *     method.</li>
     *     <li>The method first checks if the portion of the list to be partitioned has one or zero elements.
     *     If so, it performs a simple check to ensure that the elements are in the correct order,
     *     swaps them if necessary, and sets {@code i} to {@code left} and {@code j} to {@code right}.</li>
     *     <li>If the portion has more than one element, the method proceeds to perform a three-way partition
     *     using the pivot element.</li>
     *     <li>The {@code mid} variable is initialized with the value of {@code left}.
     *     This variable represents the current index being considered during the partitioning process.</li>
     *     <li>The pivot element is chosen as the element at index {@code right}.</li>
     *     <li>A {@code while} loop is used to iterate from {@code left} to {@code right},
     *     comparing each element with the pivot and performing the necessary swaps to achieve the three-way
     *     partition.</li>
     *     <li>If the element at index {@code mid} is greater than the pivot, it is swapped with the element
     *     at index {@code left}.
     *     {@code left} and {@code mid} are then incremented to move to the next elements.</li>
     *     <li>If the element at index {@code mid} is equal to the pivot,
     *     {@code mid} is incremented to move to the next element without performing any swaps.</li>
     *     <li>If the element at index {@code mid} is less than the pivot, it is swapped with the element at
     *     index {@code right}.
     *     {@code right} is decremented to move to the next element.</li>
     *     <li>After the {@code while} loop completes, the list is partitioned into three parts:
     *     elements less than the pivot, elements equal to the pivot, and elements smaller than the pivot.</li>
     *     <li>The variable {@code i} is set to {@code (left - 1)} to represent the index of the last element in
     *     the left partition.</li>
     *     <li>The variable {@code j} is set to {@code mid} to represent the index where the middle partition
     *     begins.</li>
     * </ul>
     * {@code partition3Dec} method partitions the given {@code list} of Comparable objects into three parts:
     * elements less than the pivot, elements equal to the pivot, and elements smaller than the pivot.
     * It uses the last element as the pivot and performs swaps to achieve the partitioning.
     * The indices {@code i} and {@code j} are updated to represent the boundaries of the partitions.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void partition3Dec(List<L> list, int left, int right) {
        if (((right + 1) - left) <= 1) {
            if (list.get(right).compareTo(list.get(left)) < 0) {
                swap(list, right, left);
            }
            i = left;
            j = right;
            return;
        }
        int mid = left;
        L pivot = list.get(right);
        while (mid <= right) {
            if (pivot.compareTo(list.get(mid)) < 0) {
                swap(list, left++, mid++);
            } else if (pivot.compareTo(list.get(mid)) == 0) {
                mid++;
            } else if (pivot.compareTo(list.get(mid)) > 0) {
                swap(list, mid, right--);
            }
        }
        i = (left - 1);
        j = mid;
    }

    /**
     * The method {@code partition3} takes four parameters: {@code list} an list of {@link java.lang.Comparable
     * Comparable} objects,
     * {@code left} the starting index of the partition, {@code right} the ending index of the partition,
     * and {@code functional} an instance of mz.SortFunctional representing a functional interface for comparison
     * operations.
     * <ul>
     *     <li>The condition {@code ((right + 1) - left) <= 1} checks if the partition has at most one element.
     *     If this condition is {@code true}, it swaps the elements at indices {@code left} and {@code right}
     *     if necessary
     *     to ensure that the left element is smaller than or equal to the right element.
     *     Then it sets {@code i} to {@code left} and {@code j} to {@code right} and returns.</li>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is
     *     used to suppress compiler
     *     warnings related to type safety when using the {@link java.lang.Comparable#compareTo(Object)
     *     compareTo} method.</li>
     *     <li>If the partition has more than one element,
     *     the code initializes {@code mid} to {@code left} and selects the pivot element as
     *     {@code list.get(right)}.</li>
     *     <li>It defines a new {@code SortFunctional<Comparable>} called {@code functionalReverse}
     *     by passing {@code functional} to a method {@code functionalComparableToReverse}.
     *     This method returns a {@code mz.SortFunctional} object that performs the reverse of
     *     the comparison operation defined in the original {@code functional} object.</li>
     *     <li>The code enters a loop that iterates while {@code mid} is less than or equal to {@code right}.
     *     Inside the loop, it compares the element at {@code list.get(mid)} to
     *     the pivot using the {@code functional.functionalCompareTo} method.</li>
     *     <li>If the result of the comparison is {@code true} (i.e., the element at {@code list.get(mid)}
     *     is less than the pivot),
     *     it swaps the elements at {@code left} and {@code mid},
     *     increments both {@code left} and {@code mid} by <i>1</i>, and continues to the next iteration.</li>
     *     <li>If the element at {@code list.get(mid)} is equal to the pivot,
     *     it simply increments {@code mid} by <i>1</i> and continues to the next iteration.</li>
     *     <li>If the element at {@code list.get(mid)} is greater than the pivot
     *     (according to the reverse comparison defined by {@code functionalReverse}),
     *     it swaps the elements at {@code mid} and {@code right}, decrements {@code right} by <i>1</i>,
     *     and continues to the next iteration.</li>
     *     <li>After the loop finishes, the variables {@code i} and {@code j} are set.
     *     {@code i} is set to {@code (left - 1)}(the index of the last element in the left partition),
     *     and {@code j} is set to {@code mid} (the index where the middle and right partitions begin).</li>
     * </ul>
     * {@code partition3} method partitions the given {@code list} of Comparable objects into three parts:
     * elements less than the pivot, elements equal to the pivot, and elements smaller than the pivot.
     * It uses the last element as the pivot and performs swaps to achieve the partitioning.
     * The indices {@code i} and {@code j} are updated to represent the boundaries of the partitions.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         SortSwap#swap(List, int, int)
     * @see         Sort#functionalComparableToReverse(SortFunctional)
     * @see         SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void partition3(
            List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        if (((right + 1) - left) <= 1) {
            if (list.get(right).compareTo(list.get(left)) < 0) {
                swap(list, right, left);
            }
            i = left;
            j = right;
            return;
        }
        int mid = left;
        L pivot = list.get(right);
        SortFunctional<Comparable> functionalReverse = functionalComparableToReverse(functional);
        while (mid <= right) {
            if (functional.functionalCompareTo(list.get(mid), pivot)) {
                swap(list, left++, mid++);
            } else if (list.get(mid).compareTo(pivot) == 0) {
                mid++;
            } else if (functionalReverse.functionalCompareTo(list.get(mid), pivot)) {
                swap(list, mid, right--);
            }
        }
        i = (left - 1);
        j = mid;
    }
}