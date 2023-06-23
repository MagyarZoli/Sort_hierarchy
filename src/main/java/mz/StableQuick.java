package mz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Stable QuickSort is an extension of the QuickSort algorithm that aims to preserve
 * the relative order of elements with equal values during the sorting process.
 * In a standard QuickSort algorithm, the order of equal elements may change, making it an unstable sorting algorithm.
 * Stable QuickSort addresses this limitation by introducing additional steps to maintain stability.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class StableQuick
extends Quick {

    /**
     * <b>Stable Quick Sort:</b><br>
     * Is an extension of the QuickSort algorithm that aims to preserve
     * the relative order of elements with equal values during the sorting process.
     * In a standard QuickSort algorithm, the order of equal elements may change, making it an unstable sorting algorithm.
     * Stable QuickSort addresses this limitation by introducing additional steps to maintain stability.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Select a pivot element: The first step is to choose a pivot element from the array.
     *     The pivot can be selected in various ways, such as picking the first, last, or middle element.</li>
     *     <li>Partitioning: The array is partitioned into two subarrays based on the pivot element.
     *     One subarray contains elements smaller than the pivot,
     *     while the other subarray contains elements greater than the pivot.
     *     The partitioning step ensures that the pivot element is in its final sorted position.</li>
     *     <li>Recursion: Recursively apply Stable QuickSort to the two subarrays created in the previous step.
     *     This step involves selecting a new pivot element for each subarray and performing partitioning until
     *     the subarrays reach a size of <i>1</i> or <i>0</i>, as these subarrays are considered already sorted.</li>
     *     <li>Concatenation: Once the recursion is complete, the sorted subarrays are concatenated to obtain the final sorted array.
     *     The order of concatenation is crucial to maintaining stability.
     *     The elements from the left subarray, which are smaller or equal to the pivot,
     *     should appear before the elements from the right subarray, which are greater than the pivot.</li>
     * </ol>
     * <b>Note:</b><br>
     * By carefully handling the partitioning and concatenation steps,
     * Stable QuickSort ensures that elements with equal values remain in their original relative order after sorting.
     * This makes it a stable sorting algorithm.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(log(n))</em><br>
     * Stability:               <b>Yes</b>
     * @see         mz.intro.introDPQ.IntroDPQStableQuick#IntroDPQStableQuick() IntroDPQStableQuick
     * @see         mz.intro.IntroStableQuick#IntroStableQuick() IntroStableQuick
     */
    public StableQuick() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        stableQuickInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        stableQuickDec(array);
    }

    /**
     * {@code stableQuickInc} that performs an in-place sorting of a Comparable array using a stable version of the QuickSort algorithm.
     * <ul>
     *     <li>The original array is converted into an {@code ArrayList} by creating a {@code new ArrayList}
     *     and passing the array as an argument to the {@code ArrayList} constructor:
     *     {@code new ArrayList<>(Arrays.asList(array))}.</li>
     *     <li>The {@code ArrayList} is then passed as an argument to the {@code stableRecursiveInc} method,
     *     which performs a stable sorting of the {@code ArrayList} and returns a sorted {@code list}.</li>
     *     <li>The sorted list obtained from {@code stableRecursiveInc} is converted back into an array using
     *     the {@link java.util.List#toArray(Object[]) toArray()} method with an empty Comparable array as the argument:
     *     {@code list.toArray(new Comparable[0])}.</li>
     *     <li>The sorted elements are copied from the sorted list back into
     *     the original array using {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy()}.
     *     The elements are copied starting from the beginning of the original array index <i>0</i>, and
     *     the number of elements copied is equal to the length of the array: {@code array.length}.</li>
     * </ul>
     * {@code stableQuickInc} method uses the {@code stableRecursiveInc} method to sort
     * the original array in a stable manner by converting it into an {@code ArrayList}.
     * After obtaining the sorted list, the sorted elements are copied back into the original array.
     * This allows the QuickSort algorithm to maintain stability by using the {@code stableRecursiveInc} method instead of
     * the standard partitioning logic in QuickSort.
     * @param       array The original array containing Comparable elements.
     * @see         mz.StableQuick#stableRecursiveInc(List)
     */
    protected void stableQuickInc(Comparable[] array) {
        List<Comparable> list = stableRecursiveInc(new ArrayList<>(Arrays.asList(array)));
        System.arraycopy(list.toArray(new Comparable[0]), 0, array, 0, array.length);
    }

    /**
     * {@code stableQuickDec} that performs an in-place sorting of a Comparable array using a stable version of the QuickSort algorithm.
     * <ul>
     *     <li>The original array is converted into an {@code ArrayList} by creating a {@code new ArrayList}
     *     and passing the array as an argument to the {@code ArrayList} constructor:
     *     {@code new ArrayList<>(Arrays.asList(array))}.</li>
     *     <li>The {@code ArrayList} is then passed as an argument to the {@code stableRecursiveInc} method,
     *     which performs a stable sorting of the {@code ArrayList} and returns a sorted {@code list}.</li>
     *     <li>The sorted list obtained from {@code stableRecursiveDec} is converted back into an array using
     *     the {@link java.util.List#toArray(Object[]) toArray()} method with an empty Comparable array as the argument:
     *     {@code list.toArray(new Comparable[0])}.</li>
     *     <li>The sorted elements are copied from the sorted list back into
     *     the original array using {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy()}.
     *     The elements are copied starting from the beginning of the original array index <i>0</i>, and
     *     the number of elements copied is equal to the length of the array: {@code array.length}.</li>
     * </ul>
     * {@code stableQuickDec} method uses the {@code stableRecursiveInc} method to sort
     * the original array in a stable manner by converting it into an {@code ArrayList}.
     * After obtaining the sorted list, the sorted elements are copied back into the original array.
     * This allows the QuickSort algorithm to maintain stability by using the {@code stableRecursiveInc} method instead of
     * the standard partitioning logic in QuickSort.
     * @param       array The original array containing Comparable elements.
     * @see         mz.StableQuick#stableRecursiveDec(List)
     */
    protected void stableQuickDec(Comparable[] array) {
        List<Comparable> list = stableRecursiveDec(new ArrayList<>(Arrays.asList(array)));
        System.arraycopy(list.toArray(new Comparable[0]), 0, array, 0, array.length);
    }

    /**
     * {@code stableQuickInc} that performs an in-place sorting of a subarray within a
     * Comparable array using a stable version of the QuickSort algorithm.
     * <ul>
     *     <li>The method creates a new array called {@code newArray} with a size equal to the length of the subarray to be sorted {@code (right - left)}.
     *     This new array will be used to create a temporary {@code list} for sorting.</li>
     *     <li>The elements from the original array that correspond to the subarray to be sorted are copied into
     *     the {@code newArray} using the {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy()} method.</li>
     *     <li>The "newArray" is converted into an ArrayList using {@link java.util.Arrays#asList(Object[]) Arrays.asList()}
     *     and then passed as an argument to the {@code stableRecursiveInc} method.
     *     This method, as you previously provided, performs a stable sorting of the {@code ArrayList} and returns a sorted {@code list}.</li>
     *     <li>The sorted list obtained from "{@code stableRecursiveInc}" is converted back into an array using
     *     the {@link java.util.List#toArray(Object[]) toArray()} method with an empty Comparable array as the argument.</li>
     *     <li>The sorted elements are copied from the sorted {@code list} back into the original array using {@code System.arraycopy()}.
     *     The elements are copied starting from the left index of the original array,
     *     and the number of elements copied is equal to the size of the sorted list.</li>
     * </ul>
     * {@code stableQuickInc} method uses the {@code stableRecursiveInc} method to sort a subarray of the original array in a stable manner
     * by creating a temporary array and converting it into an ArrayList.
     * After obtaining the sorted list, the sorted elements are copied back into the original array.
     * This allows the QuickSort algorithm to maintain stability by using the {@code stableRecursiveInc} method instead of
     * the standard partitioning logic in QuickSort.
     * @param       array The original array containing Comparable elements.
     * @param       left The index representing the left boundary of the subarray to be sorted.
     * @param       right The index representing the right boundary of the subarray to be sorted.
     * @see         mz.StableQuick#stableRecursiveInc(List)
     */
    protected void stableQuickInc(Comparable[] array, int left, int right) {
        Comparable[] newArray = new Comparable[(right - left)];
        System.arraycopy(array, left, newArray, 0, newArray.length);
        List<Comparable> list = stableRecursiveInc(new ArrayList<>(Arrays.asList(newArray)));
        System.arraycopy(list.toArray(new Comparable[0]), 0, array, left, list.size());
    }

    /**
     * {@code stableQuickDec} that performs an in-place sorting of a subarray within a
     * Comparable array using a stable version of the QuickSort algorithm.
     * <ul>
     *     <li>The method creates a new array called {@code newArray} with a size equal to the length of the subarray to be sorted {@code (right - left)}.
     *     This new array will be used to create a temporary {@code list} for sorting.</li>
     *     <li>The elements from the original array that correspond to the subarray to be sorted are copied into
     *     the {@code newArray} using the {@link java.lang.System#arraycopy(Object, int, Object, int, int) System.arraycopy()} method.</li>
     *     <li>The "newArray" is converted into an ArrayList using {@link java.util.Arrays#asList(Object[]) Arrays.asList()}
     *     and then passed as an argument to the {@code stableRecursiveDec} method.
     *     This method, as you previously provided, performs a stable sorting of the {@code ArrayList} and returns a sorted {@code list}.</li>
     *     <li>The sorted list obtained from "{@code stableRecursiveDec}" is converted back into an array using
     *     the {@link java.util.List#toArray(Object[]) toArray()} method with an empty Comparable array as the argument.</li>
     *     <li>The sorted elements are copied from the sorted {@code list} back into the original array using {@code System.arraycopy()}.
     *     The elements are copied starting from the left index of the original array,
     *     and the number of elements copied is equal to the size of the sorted list.</li>
     * </ul>
     * {@code stableQuickDec} method uses the {@code stableRecursiveDec} method to sort a subarray of the original array in a stable manner
     * by creating a temporary array and converting it into an ArrayList.
     * After obtaining the sorted list, the sorted elements are copied back into the original array.
     * This allows the QuickSort algorithm to maintain stability by using the {@code stableRecursiveDec} method instead of
     * the standard partitioning logic in QuickSort.
     * @param       array The original array containing Comparable elements.
     * @param       left The index representing the left boundary of the subarray to be sorted.
     * @param       right The index representing the right boundary of the subarray to be sorted.
     * @see         mz.StableQuick#stableRecursiveDec(List)
     */
    protected void stableQuickDec(Comparable[] array, int left, int right) {
        Comparable[] newArray = new Comparable[(right - left)];
        System.arraycopy(array, left, newArray, 0, newArray.length);
        List<Comparable> list = stableRecursiveDec(new ArrayList<>(Arrays.asList(newArray)));
        System.arraycopy(list.toArray(new Comparable[0]), 0, array, left, list.size());
    }

    /**
     * {@code stableRecursiveInc} implements a recursive sorting algorithm called {@code stableRecursiveInc} that sorts a list of Comparable elements in ascending order.
     * The algorithm uses the concept of a pivot element and divides the list into two parts:
     * smaller elements and greater elements, relative to the pivot.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method takes a {@code list} as input and checks if the size of the {@code list} is less than or equal to <i>1</i>.
     *     If so, it returns the {@code list} as it is already sorted (base case of the recursion).</li>
     *     <li>If the {@code list} has more than one element, it proceeds to find the {@code pivot} element.
     *     The {@code pivot} is the element at the middle index of the {@code list}.</li>
     *     <li>The algorithm creates two empty lists, {@code smaller} and {@code greater},
     *     to hold the elements smaller and greater than the {@code pivot}, respectively.</li>
     *     <li>It iterates through the original {@code list} and compares each element to the {@code pivot}.</li>
     *     <li>If the element is smaller than the {@code pivot}, it adds it to the {@code smaller} list.</li>
     *     <li>If the element is greater than the {@code pivot}, it adds it to the {@code greater} list.</li>
     *     <li>If the element is equal to the {@code pivot}, it determines its relative position to the pivot index
     *     and adds it to either the {@code smaller} or {@code greater} list accordingly.</li>
     *     <li>After the iteration, the algorithm recursively calls itself with the {@code smaller} list and the {@code greater} list, separately.</li>
     *     <li>The results of the recursive calls are stored in two lists, {@code sa1} and {@code sa2}.</li>
     *     <li>The algorithm creates a new list, "{@code ans}", and populates it by adding all the elements from {@code sa1},
     *     followed by the {@code pivot} element, and finally, all the elements from {@code sa2}.</li>
     * </ul>
     * {@code stableRecursiveInc} the algorithm uses the divide-and-conquer approach by recursively sorting smaller sublists and combining them to produce the final sorted list.
     * The use of the pivot element helps in dividing the list into smaller parts, which allows the algorithm to achieve an efficient sorting result.
     * @param       list sorts a list of Comparable elements in ascending order.
     * @return      The sorted list, is returned.
     */
    @SuppressWarnings("unchecked")
    protected List<Comparable> stableRecursiveInc(List<Comparable> list) {
        if (list.size() <= 1) {
            return list;
        }
        int n = list.size(), mid = (n / 2);
        Comparable pivot = list.get(mid);
        List<Comparable> smaller = new ArrayList<>();
        List<Comparable> greater = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Comparable value = list.get(i);
            if (i != mid) {
                if (value.compareTo(pivot) < 0) {
                    smaller.add(value);
                } else if (value.compareTo(pivot) > 0) {
                    greater.add(value);
                } else {
                    if (i < mid) {
                        smaller.add(value);
                    } else {
                        greater.add(value);
                    }
                }
            }
        }
        List<Comparable> ans = new ArrayList<>();
        List<Comparable> sa1 = stableRecursiveInc(smaller);
        List<Comparable> sa2 = stableRecursiveInc(greater);
        ans.addAll(sa1);
        ans.add(pivot);
        ans.addAll(sa2);
        return ans;
    }

    /**
     * {@code stableRecursiveDec} implements a recursive sorting algorithm called {@code stableRecursiveDec} that sorts a list of Comparable elements in descending order.
     * The algorithm uses the concept of a pivot element and divides the list into two parts:
     * smaller elements and greater elements, relative to the pivot.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>The method takes a {@code list} as input and checks if the size of the {@code list} is less than or equal to <i>1</i>.
     *     If so, it returns the {@code list} as it is already sorted (base case of the recursion).</li>
     *     <li>If the {@code list} has more than one element, it proceeds to find the {@code pivot} element.
     *     The {@code pivot} is the element at the middle index of the {@code list}.</li>
     *     <li>The algorithm creates two empty lists, {@code smaller} and {@code greater},
     *     to hold the elements smaller and greater than the {@code pivot}, respectively.</li>
     *     <li>It iterates through the original {@code list} and compares each element to the {@code pivot}.</li>
     *     <li>If the element is greater than the {@code pivot}, it adds it to the {@code smaller} list.</li>
     *     <li>If the element is smaller than the {@code pivot}, it adds it to the {@code greater} list.</li>
     *     <li>If the element is equal to the {@code pivot}, it determines its relative position to the pivot index
     *     and adds it to either the {@code smaller} or {@code greater} list accordingly.</li>
     *     <li>After the iteration, the algorithm recursively calls itself with the {@code smaller} list and the {@code greater} list, separately.</li>
     *     <li>The results of the recursive calls are stored in two lists, {@code sa1} and {@code sa2}.</li>
     *     <li>The algorithm creates a new list, "{@code ans}", and populates it by adding all the elements from {@code sa1},
     *     followed by the {@code pivot} element, and finally, all the elements from {@code sa2}.</li>
     * </ul>
     * {@code stableRecursiveDec} the algorithm uses the divide-and-conquer approach by recursively sorting smaller sublists and combining them to produce the final sorted list.
     * The use of the pivot element helps in dividing the list into smaller parts, which allows the algorithm to achieve an efficient sorting result.
     * @param       list sorts a list of Comparable elements in descending order.
     * @return      The sorted list, is returned.
     */
    @SuppressWarnings("unchecked")
    protected List<Comparable> stableRecursiveDec(List<Comparable> list) {
        if (list.size() <= 1) {
            return list;
        }
        int n = list.size(), mid = (n / 2);
        Comparable pivot = list.get(mid);
        List<Comparable> smaller = new ArrayList<>();
        List<Comparable> greater = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Comparable value = list.get(i);
            if (i != mid) {
                if (value.compareTo(pivot) > 0) {
                    smaller.add(value);
                } else if (value.compareTo(pivot) < 0) {
                    greater.add(value);
                } else {
                    if (i > mid) {
                        smaller.add(value);
                    } else {
                        greater.add(value);
                    }
                }
            }
        }
        List<Comparable> ans = new ArrayList<>();
        List<Comparable> sa1 = stableRecursiveDec(smaller);
        List<Comparable> sa2 = stableRecursiveDec(greater);
        ans.addAll(sa1);
        ans.add(pivot);
        ans.addAll(sa2);
        return ans;
    }
}