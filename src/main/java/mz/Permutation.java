package mz;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutation Sort is a simple but inefficient sorting algorithm that works by generating all possible permutations
 * of an array and selecting the one that is in sorted order. While conceptually straightforward, this approach leads
 * to a high time complexity and is not practical for sorting large arrays.
 * @since       1.1
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Permutation
extends Bogo {

    /**
     * <b>Permutation Sort:</b><br>
     * Is a simple but inefficient sorting algorithm that works by generating all possible permutations
     * of an array and selecting the one that is in sorted order. While conceptually straightforward, this approach leads
     * to a high time complexity and is not practical for sorting large arrays.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Generate Permutations for an array of {@code n} elements, Permutation Sort generates all {@code n!}
     *     permutations of the array. It does this by swapping elements in different positions recursively until all
     *     possible arrangements are generated.</li>
     *     <li>Check for Sorted Permutation for each generated permutation, the algorithm checks whether the current
     *     permutation is sorted in ascending order.</li>
     *     <li>Select Sorted Permutation when a sorted permutation is found, the algorithm stops and considers that
     *     permutation as the sorted arrangement of the array.</li>
     *     <li>Replace Original Array the sorted permutation is then copied back to the original array, replacing the
     *     original unsorted array.</li>
     * </ol>
     * <b>Note:</b><br>
     * The main problem with Permutation Sort is its extremely high time complexity. The algorithm generates <em>n!</em>
     * permutations and checks each permutation for sortedness, which makes the overall time complexity of
     * Permutation Sort <em>O(n! * n)</em>, where n is the number of elements in the array. This makes it highly
     * impractical for even moderately sized arrays because the number of operations grows factorially with the size
     * of the array.<br><br>
     * While the idea of Permutation Sort might be intuitive, its inefficiency makes it unsuitable for practical
     * sorting tasks. It serves more as a theoretical example to demonstrate the importance of optimizing sorting
     * algorithms for real-world scenarios.<br><br>
     * Permutation Sort is inherently stable because it only swaps elements within the array and doesn't involve any
     * comparison between elements. If two elements are equal, they will remain in the same relative order after the
     * permutation operations.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em> O(n! * n)</em><br>
     * Best Case Complexity:    <em> O(n! * n)</em><br>
     * Average Case Complexity: <em> O(n! * n)</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>Yes</b>
     */
    public Permutation() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        permutationInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        permutationDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        permutation(array, functional);
    }

    /**
     * {@code permutationInc} that generates a permutation of an entire array of {@link java.lang.Comparable Comparable}
     * elements in ascending order and copies the result back to the original array.
     * <ul>
     *     <li>Inside the method, the {@code permuteComparableInc} method is called with the entire {@code array}.
     *     This method generates a permutation of the entire array in ascending order.</li>
     *     <li>The resulting sorted permutation is then copied back to the original array using
     *     {@link java.lang.System System}.{@link java.lang.System#arraycopy(Object, int, Object, int, int) arraycopy}.
     *     The entire {@code array} is updated with the sorted permutation, replacing the original array contents.</li>
     * </ul>
     * {@code permutationInc} this method generates a sorted permutation of the entire array and replaces the original
     * array with the sorted permutation.
     * @param       array to be arranged.
     * @see         mz.Permutation#permuteComparableInc(Comparable[])
     */
    protected void permutationInc(Comparable[] array) {
        System.arraycopy(permuteComparableInc(array), 0, array, 0, array.length);
    }

    /**
     * {@code permutationDec} that generates a permutation of an entire array of {@link java.lang.Comparable Comparable}
     * elements in descending order and copies the result back to the original array.
     * <ul>
     *     <li>Inside the method, the {@code permuteComparableDec} method is called with the entire {@code array}.
     *     This method generates a permutation of the entire array in descending order.</li>
     *     <li>The resulting sorted permutation is then copied back to the original array using
     *     {@link java.lang.System System}.{@link java.lang.System#arraycopy(Object, int, Object, int, int) arraycopy}.
     *     The entire {@code array} is updated with the sorted permutation, replacing the original array contents.</li>
     * </ul>
     * {@code permutationDec} this method generates a sorted permutation of the entire array and replaces the original
     * array with the sorted permutation.
     * @param       array to be arranged.
     * @see         mz.Permutation#permuteComparableDec(Comparable[])
     */
    protected void permutationDec(Comparable[] array) {
        System.arraycopy(permuteComparableDec(array), 0, array, 0, array.length);
    }

    /**
     * {@code permutation} that generates a permutation of an entire array of {@link java.lang.Comparable Comparable}
     * elements based on a specific sorting condition defined by a {@code SortFunctional} object.
     * <ul>
     *     <li>Inside the method, the {@code permuteComparable} method is called with the entire {@code array} and the
     *     {@code functional} parameter. This method generates a permutation of the entire array based on the sorting
     *     condition defined by the {@code SortFunctional} object.</li>
     *     <li>The resulting permutation that satisfies the sorting condition is then copied back to the original array
     *     using {@link java.lang.System System}.
     *     {@link java.lang.System#arraycopy(Object, int, Object, int, int) arraycopy}. The entire {@code array} is
     *     updated with the sorted permutation, replacing the original array contents.</li>
     * </ul>
     * {@code permutation} this method provides a way to generate a permutation of the entire original array based on
     * a given sorting condition, and it replaces the original array with the sorted permutation that adheres to the
     * sorting condition.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.Permutation#permuteComparable(Comparable[], SortFunctional)
     */
    protected void permutation(Comparable[] array, SortFunctional<Comparable> functional) {
        System.arraycopy(permuteComparable(array, functional), 0, array, 0, array.length);
    }

    /**
     * {@code permutationInc} that seems to aim at generating a permutation of a subarray of {@code Comparable}
     * elements in ascending order and copying the result back to the original array.
     * <ul>
     *     <li>Inside the method, the {@code permuteComparableInc} method is called with the subarray defined by the
     *     {@code left} and {@code right} indices. This method generates a permutation of the subarray in ascending
     *     order.</li>
     *     <li>The resulting sorted permutation is then copied back to the original array using
     *     {@link java.lang.System System}.{@link java.lang.System#arraycopy(Object, int, Object, int, int) arraycopy}.
     *     The {@code array} is updated with the sorted permutation, replacing the original subarray defined by the
     *     {@code left} and {@code right} indices.</li>
     * </ul>
     * {@code permutationInc} this method is a convenient way to generate a sorted permutation of a specific subarray
     * within the original array and replace the original subarray with the sorted permutation. It takes advantage of
     * the {@code permuteComparableInc} method to generate the sorted permutation.
     * @param       array to be arranged.
     * @param       left the starting index of the subarray.
     * @param       right the ending index of the subarray.
     * @see         mz.Permutation#permuteComparableInc(Comparable[], int, int)
     */
    protected void permutationInc(Comparable[] array, int left, int right) {
        System.arraycopy(permuteComparableInc(array, left, right), left, array, left, right);
    }

    /**
     * {@code permutationDec} that seems to aim at generating a permutation of a subarray of {@code Comparable}
     * elements in descending order and copying the result back to the original array.
     * <ul>
     *     <li>Inside the method, the {@code permuteComparableDec} method is called with the subarray defined by the
     *     {@code left} and {@code right} indices. This method generates a permutation of the subarray in descending
     *     order.</li>
     *     <li>The resulting sorted permutation is then copied back to the original array using
     *     {@link java.lang.System System}.{@link java.lang.System#arraycopy(Object, int, Object, int, int) arraycopy}.
     *     The {@code array} is updated with the sorted permutation, replacing the original subarray defined by the
     *     {@code left} and {@code right} indices.</li>
     * </ul>
     * {@code permutationDec} this method is a convenient way to generate a sorted permutation of a specific subarray
     * within the original array and replace the original subarray with the sorted permutation. It takes advantage of
     * the {@code permuteComparableDec} method to generate the sorted permutation.
     * @param       array to be arranged.
     * @param       left the starting index of the subarray.
     * @param       right the ending index of the subarray.
     * @see         mz.Permutation#permuteComparableDec(Comparable[], int, int)
     */
    protected void permutationDec(Comparable[] array, int left, int right) {
        System.arraycopy(permuteComparableDec(array, left, right), left, array, left, right);
    }

    /**
     * {@code permutation} that seems to generate a permutation of a subarray of {@link java.lang.Comparable Comparable}
     * elements based on a specific sorting condition defined by a {@code SortFunctional} object.
     * <ul>
     *     <li>Inside the method, the {@code permuteComparable} method is called with the subarray defined by the
     *     {@code left} and {@code right} indices and the {@code functional} parameter. This method generates a
     *     permutation of the subarray based on the sorting condition defined by the {@code SortFunctional} object.</li>
     *     <li>The resulting permutation that satisfies the sorting condition is then copied back to the original
     *     array using {@link java.lang.System System}.
     *     {@link java.lang.System#arraycopy(Object, int, Object, int, int) arraycopy}. The {@code array} is updated
     *     with the sorted permutation, replacing the original subarray defined by the {@code left} and
     *     {@code right} indices.</li>
     * </ul>
     * {@code permutation} this method provides a way to generate a permutation of a specific subarray within the
     * original array based on a given sorting condition, and it replaces the original subarray with the sorted
     * permutation that adheres to the sorting condition.
     * @param       array to be arranged.
     * @param       left the starting index of the subarray.
     * @param       right the ending index of the subarray.
     * @param       functional lambda expression for comparison.
     * @see         mz.Permutation#permuteComparable(Comparable[], int, int, SortFunctional)
     */
    protected void permutation(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        System.arraycopy(permuteComparable(array, left, right, functional), left, array, left, right);
    }

    /**
     * {@code permuteComparableInc} that generates permutations of an entire array of
     * {@link java.lang.Comparable Comparable} elements and returns the first permutation that is in ascending order.
     * <ul>
     *     <li>Inside the method, a new {@link java.util.ArrayList ArrayList} named {@code permutations} is created.
     *     This list will store the generated permutations of the input array.</li>
     *     <li>The {@code permute} method is called with the entire {@code array} and its length, along with the
     *     {@code permutations} list. This generates all possible permutations of the input array and adds them to
     *     the {@code permutations} list.</li>
     *     <li>After generating the permutations and storing them in the permutations list, a loop iterates over each
     *     {@code permutation} stored in the list.</li>
     *     <li>For each permutation, the method {@code isSortedInc} is called to check if the permutation is in
     *     ascending order.</li>
     *     <li>If a permutation is found to be in ascending order, that permutation is returned from the
     *     {@code permuteComparableInc} method.</li>
     *     <li>If no permutation in ascending order is found, the method returns the original
     *     {@code array} unchanged.</li>
     * </ul>
     * {@code permuteComparableInc} generates all permutations of the input array and then checks each permutation for
     * ascending order. Once a sorted permutation is found, it's immediately returned. This approach could be
     * inefficient for larger arrays due to the generation of all permutations and the subsequent sorting checks.
     * @param       array to be arranged.
     * @return      The original array ascending order.
     * @see         mz.Permutation#permute(Comparable[], int, List)
     * @see         mz.Bogo#isSortedInc(Comparable[])
     */
    protected Comparable[] permuteComparableInc(Comparable[] array) {
        List<Comparable[]> permutations = new ArrayList<>();
        permute(array, array.length, permutations);
        for (Comparable[] comparable : permutations) {
            if (isSortedInc(comparable)) {
                return comparable;
            }
        }
        return array;
    }

    /**
     * {@code permuteComparableDec} that generates permutations of an entire array of
     * {@link java.lang.Comparable Comparable} elements and returns the first permutation that is in descending order.
     * <ul>
     *     <li>Inside the method, a new {@link java.util.ArrayList ArrayList} named {@code permutations} is created.
     *     This list will store the generated permutations of the input array.</li>
     *     <li>The {@code permute} method is called with the entire {@code array} and its length, along with the
     *     {@code permutations} list. This generates all possible permutations of the input array and adds them to
     *     the {@code permutations} list.</li>
     *     <li>After generating the permutations and storing them in the permutations list, a loop iterates over each
     *     {@code permutation} stored in the list.</li>
     *     <li>For each permutation, the method {@code isSortedDec} is called to check if the permutation is in
     *     descending order.</li>
     *     <li>If a permutation is found to be in descending order, that permutation is returned from the
     *     {@code permuteComparableDec} method.</li>
     *     <li>If no permutation in descending order is found, the method returns the original
     *     {@code array} unchanged.</li>
     * </ul>
     * {@code permuteComparableDec} generates all permutations of the input array and then checks each permutation for
     * descending order. Once a sorted permutation is found, it's immediately returned. This approach could be
     * inefficient for larger arrays due to the generation of all permutations and the subsequent sorting checks.
     * @param       array to be arranged.
     * @return      The original array descending order.
     * @see         mz.Permutation#permute(Comparable[], int, List)
     * @see         mz.Bogo#isSortedDec(Comparable[])
     */
    protected Comparable[] permuteComparableDec(Comparable[] array) {
        List<Comparable[]> permutations = new ArrayList<>();
        permute(array, array.length, permutations);
        for (Comparable[] comparable : permutations) {
            if (isSortedDec(comparable)) {
                return comparable;
            }
        }
        return array;
    }

    /**
     * {@code permuteComparable} that generates permutations of an entire array of {@code Comparable} elements and
     * returns the first permutation that satisfies a specific sorting condition defined by a
     * {@code SortFunctional} object.
     * <ul>
     *     <li>Inside the method, a new {@link java.util.ArrayList ArrayList} named {@code permutations} is created.
     *     This list will store the generated permutations of the input array.</li>
     *     <li>The {@code permute} method is called with the entire {@code array} and its length, along with the
     *     {@code permutations} list. This generates all possible permutations of the input array and adds them to
     *     the {@code permutations} list.</li>
     *     <li>After generating the permutations and storing them in the permutations list, a loop iterates over
     *     each {@code permutation} stored in the list.</li>
     *     <li>For each permutation, the method {@code isSorted} is called with the {@code functional} parameter to
     *     check if the permutation satisfies the sorting condition defined by the {@code SortFunctional} object.</li>
     *     <li>If a permutation is found to satisfy the sorting condition, that permutation is returned from the
     *     {@code permuteComparable} method.</li>
     *     <li>If no permutation satisfying the sorting condition is found, the method returns the original
     *     {@code array} unchanged.</li>
     * </ul>
     * {@code permuteComparable} that generate all permutations of the input array and then searches for the first
     * permutation that meets the specified sorting condition. The success of this method heavily depends on the
     * correctness of the {@code SortFunctional} interface or class and the {@code isSorted} method.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @return      The order of the original array defined by functions.
     * @see         mz.Permutation#permute(Comparable[], int, List)
     * @see         mz.Bogo#isSorted(Comparable[], SortFunctional)
     */
    protected Comparable[] permuteComparable(Comparable[] array, SortFunctional<Comparable> functional) {
        List<Comparable[]> permutations = new ArrayList<>();
        permute(array, array.length, permutations);
        for (Comparable[] comparable : permutations) {
            if (isSorted(comparable, functional)) {
                return comparable;
            }
        }
        return array;
    }

    /**
     * {@code permuteComparableInc} that aims to generate permutations of a subarray of
     * {@link java.lang.Comparable Comparable} elements and return the first permutation that is in ascending order.
     * <ul>
     *     <li>Inside the method, a new {@link java.util.ArrayList ArrayList} named {@code permutations} is created.
     *     This list will be used to store the generated permutations of the subarray.</li>
     *     <li>The method then calls the {@code permute} method to generate permutations of the given subarray.
     *     The generated permutations are added to the {@code permutations}.</li>
     *     <li>After generating the permutations and storing them in the {@code permutations}, a loop iterates over
     *     each permutation stored in the {@code permutations}.</li>
     *     <li>For each permutation, the method {@code isSortedInc} is called to check if the permutation is in
     *     ascending order.</li>
     *     <li>If a permutation is found to be in ascending order, that permutation is returned from the
     *     {@code permuteComparableInc} method.</li>
     *     <li>If no permutation in ascending order is found, the method returns the original {@code array}
     *     unchanged.</li>
     * </ul>
     * {@code permuteComparableInc} method to generate permutations of a subarray and return the first permutation that
     * is sorted in ascending order. It utilizes the {@code isSortedInc} method to check the sorting order of a
     * permutation.
     * @param       array to be arranged.
     * @param       left the starting index of the subarray.
     * @param       right the ending index of the subarray.
     * @return      The original array ascending order.
     * @see         mz.Permutation#permute(Comparable[], int, int, List)
     * @see         mz.Bogo#isSortedInc(Comparable[])
     */
    protected Comparable[] permuteComparableInc(Comparable[] array, int left, int right) {
        List<Comparable[]> permutations = new ArrayList<>();
        permute(array, left, right, permutations);
        for (Comparable[] comparable : permutations) {
            if (isSortedInc(comparable)) {
                return comparable;
            }
        }
        return array;
    }

    /**
     * {@code permuteComparableDec} that aims to generate permutations of a subarray of
     * {@link java.lang.Comparable Comparable} elements and return the first permutation that is in descending order.
     * <ul>
     *     <li>Inside the method, a new {@link java.util.ArrayList ArrayList} named {@code permutations} is created.
     *     This list will be used to store the generated permutations of the subarray.</li>
     *     <li>The method then calls the {@code permute} method to generate permutations of the given subarray.
     *     The generated permutations are added to the {@code permutations}.</li>
     *     <li>After generating the permutations and storing them in the {@code permutations}, a loop iterates over
     *     each permutation stored in the {@code permutations}.</li>
     *     <li>For each permutation, the method {@code isSortedInc} is called to check if the permutation is in
     *     descending order.</li>
     *     <li>If a permutation is found to be in descending order, that permutation is returned from the
     *     {@code permuteComparableDec} method.</li>
     *     <li>If no permutation in descending order is found, the method returns the original {@code array}
     *     unchanged.</li>
     * </ul>
     * {@code permuteComparableDec} method to generate permutations of a subarray and return the first permutation that
     * is sorted in descending order. It utilizes the {@code isSortedDec} method to check the sorting order of a
     * permutation.
     * @param       array to be arranged.
     * @param       left the starting index of the subarray.
     * @param       right the ending index of the subarray.
     * @return      The original array descending order.
     * @see         mz.Permutation#permute(Comparable[], int, int, List)
     * @see         mz.Bogo#isSortedDec(Comparable[])
     */
    protected Comparable[] permuteComparableDec(Comparable[] array, int left, int right) {
        List<Comparable[]> permutations = new ArrayList<>();
        permute(array, left, right, permutations);
        for (Comparable[] comparable : permutations) {
            if (isSortedDec(comparable)) {
                return comparable;
            }
        }
        return array;
    }

    /**
     * {@code permuteComparable} that generates permutations of a subarray of {@link java.lang.Comparable Comparable}
     * elements and returns the first permutation that satisfies a specific sorting condition defined by a
     * {@code SortFunctional} object.
     * <ul>
     *     <li>Inside the method, a new {@link java.util.ArrayList ArrayList} named {@code permutations} is created.
     *     This list will be used to store the generated permutations of the subarray.</li>
     *     <li>The method calls the {@code permute} method to generate permutations of the given subarray. The
     *     generated permutations are added to the {@code permutations} list.</li>
     *     <li>After generating the permutations and storing them in the {@code permutations} list, a loop iterates
     *     over each permutation stored in the list.</li>
     *     <li>For each permutation, the method {@code isSorted} is called with the {@code functional} parameter to
     *     check if the permutation satisfies the sorting condition specified by the {@code SortFunctional} object.</li>
     *     <li>If a permutation is found to satisfy the sorting condition, that permutation is returned from the
     *     {@code permuteComparable} method.</li>
     *     <li>If no permutation satisfying the sorting condition is found, the method returns the original
     *     {@code array} unchanged.</li>
     * </ul>
     * {@code permuteComparable} that functional class named {@code SortFunctional} that defines a sorting condition or rule. The {@code isSorted}
     * method a part of this functional interface or class, and it's used to determine if a permutation meets the
     * sorting condition defined by the {@code functional} object.
     * @param       array to be arranged.
     * @param       left the starting index of the subarray.
     * @param       right the ending index of the subarray.
     * @param       functional lambda expression for comparison.
     * @return      The order of the original array defined by functions.
     * @see         mz.Permutation#permute(Comparable[], int, int, List)
     * @see         mz.Bogo#isSorted(Comparable[], SortFunctional)
     */
    protected Comparable[] permuteComparable(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        List<Comparable[]> permutations = new ArrayList<>();
        permute(array, left, right, permutations);
        for (Comparable[] comparable : permutations) {
            if (isSorted(comparable, functional)) {
                return comparable;
            }
        }
        return array;
    }

    /**
     * {@code permute} method called permute which takes three arguments the array to be permuted {@code array},
     * the number of elements to consider for permutation {@code n}, and a {@code List<Comparable[]>} called
     * {@code permutations} that will store the generated permutations.
     * <ul>
     *     <li>The base case is when {@code n} reaches <i>1</i>. In this case, a copy of the current array is created
     *     using {@link java.lang.System System}.
     *     {@link java.lang.System#arraycopy(Object, int, Object, int, int) arraycopy}, and this copy is added to the
     *     {@code permutations} of permutations. This is done to avoid adding a reference to the same array multiple
     *     times in the permutations.</li>
     *     <li>If {@code n} is greater than <i>1</i>, the code enters a loop that iterates over each element of the
     *     array, up to the index {@code (n - 1)}.</li>
     *     <li>Inside the loop, the {@code swap} method is used to swap the element at index {@code i} with the
     *     element at index {@code (n - 1)}. This effectively fixes one element and recursively generates permutations
     *     for the remaining elements (those before the fixed element).</li>
     *     <li>The {@code permute} method is called recursively with {@code n} decremented by <i>1</i>. This ensures
     *     that the algorithm generates permutations for a smaller portion of the array in the next recursive call.</li>
     *     <li>After the recursive call, another swap is performed to revert the array back to its original state.
     *     This is necessary to backtrack and generate permutations correctly for other elements.</li>
     * </ul>
     * {@code permute} generates all possible permutations of the given array by recursively fixing each element at
     * the last position and generating permutations for the remaining elements. The swaps ensure that each element
     * gets a chance to be in the last position during the recursive process.
     * @param       array to be arranged.
     * @param       n the number of elements to consider for permutation
     * @param       permutations that will store the generated permutations.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    protected void permute(Comparable[] array, int n, List<Comparable[]> permutations) {
        if (n == 1) {
            Comparable[] array2 = new Comparable[array.length];
            System.arraycopy(array, 0, array2, 0, array.length);
            permutations.add(array2);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(array, i, (n - 1));
            permute(array, (n - 1), permutations);
            swap(array, i, (n - 1));
        }
    }

    /**
     * {@code permute} to generate permutations of a given subarray of {@link java.lang.Comparable Comparable} elements.
     * The key difference here is that instead of considering the whole array and reducing the n parameter to determine
     * the number of elements to permute, this version uses a range defined by {@code left} and {@code right}.
     * <ul>
     *     <li>The method signature now includes two additional parameters: {@code left} and {@code right}. These
     *     parameters define the range of the subarray to be permuted, specifically from index {@code left} to index
     *     {@code (right - 1)}.</li>
     *     <li>The base case remains the same, where {@code right} is checked against <i>1</i>. If {@code right} equals
     *     <i>1</i>, a subarray of length <i>1</i> is considered for permutation. The subarray's contents are copied to
     *     {@code array2} using {@link java.lang.System System}.
     *     {@link java.lang.System#arraycopy(Object, int, Object, int, int) arraycopy}, and then {@code array2} is
     *     added to the list of permutations.</li>
     *     <li>he loop now iterates over the elements within the range {@code left}, {@code (right - 1)}. This means
     *     that it considers a subarray defined by the {@code left} and {@code right} indices. The swapping and
     *     recursive calls are still performed to generate permutations within this subarray.</li>
     *     <li>The {@code swap} method is used to swap elements in the array. The recursive calls to {@code permute}
     *     generate permutations within the subarray by fixing one element at a time.</li>
     *     <li>After the recursive call, another swap is performed to backtrack and restore the subarray to its
     *     original state before moving to the next iteration of the loop.</li>
     * </ul>
     * {@code permute} the algorithm generates permutations for a specific subarray of the given array. It's useful
     * when you want to generate permutations for a smaller portion of the array or when you want to handle different
     * subarrays separately.
     * @param       array to be arranged.
     * @param       left first range defined.
     * @param       right last range defined.
     * @param       permutations that will store the generated permutations.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    protected void permute(Comparable[] array, int left, int right, List<Comparable[]> permutations) {
        if (right == 1) {
            Comparable[] array2 = new Comparable[array.length];
            System.arraycopy(array, left, array2, left, right);
            permutations.add(array2);
            return;
        }
        for (int i = left; i < right; i++) {
            swap(array, i, (right - 1));
            permute(array, left, (right - 1), permutations);
            swap(array, i, (right - 1));
        }
    }
}