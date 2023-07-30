package mz;

import java.util.List;

/**
 * Gnome Sort, also known as Stupid Sort, is a simple sorting algorithm that works
 * by repeatedly comparing adjacent elements and swapping them if they are in the wrong order.
 * It gets its name from the way it "stumbles" through the list, similar to a gnome moving around.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Gnome
extends Bubble {

    /**
     * <b>Gnome Sort:</b><br>
     * Also known as Stupid Sort, is a simple sorting algorithm that works
     * by repeatedly comparing adjacent elements and swapping them if they are in the wrong order.
     * It gets its name from the way it "stumbles" through the list, similar to a gnome moving around.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Set the current position {@code (pos)} to 0.</li>
     *     <li>While {@code pos} is less than the length of the array:</li>
     *     <li>If {@code pos} is 0 or the current element is in the correct order with the previous element,
     *     move to the next position by incrementing {@code pos}.</li>
     *     <li>If the current element is out of order with the previous element,
     *     swap them and move one position back by decrementing {@code pos}.</li>
     *     <li>Repeat step 3 until {@code pos} reaches the end of the array.</li>
     *     <li>The array is now sorted.</li>
     * </ol>
     * <b>Note:</b><br>
     * Gnome Sort iteratively moves through the array, comparing adjacent elements and swapping them if necessary.
     * If a swap occurs, it moves one position back to recheck the element with the previous one.
     * This process continues until the entire array is sorted.<br><br>
     * Gnome Sort has a time complexity of <em>O(n^2)</em> in the average and worst cases, where <em>n</em> is the number of elements in the array.
     * It is not considered an efficient sorting algorithm for large datasets due to its quadratic time complexity.
     * However, it is relatively easy to understand and implement.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n)</em><br>
     * Average Case Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>No</b>
     * @see         mz.intro.IntroGnome#IntroGnome() IntroGnome
     */
    public Gnome() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        gnomeInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        gnomeDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        gnome(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        gnomeInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        gnomeDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        gnome(list, functional);
    }

    /**
     * {@code gnomeInc} that implements the Gnome Sort algorithm to sort an array of
     * {@link java.lang.Comparable Comparable} objects in ascending order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Set the current position {@code (pos)} to 0.</li>
     *     <li>While {@code pos} is less than the length of the array:</li>
     *     <li>If {@code pos} is 0 or the current element is in the correct order with the previous element,
     *     move to the next position by incrementing {@code pos}.</li>
     *     <li>If the current element is out of order with the previous element,
     *     swap them and move one position back by decrementing {@code pos}.</li>
     *     <li>Repeat step 3 until {@code pos} reaches the end of the array.</li>
     * </ul>
     * {@code gnomeInc} method implements the Gnome Sort algorithm to sort the given
     * {@code array} of Comparable objects in ascending order.
     * @param       array to be arranged.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void gnomeInc(Comparable[] array) {
        int n = array.length, pos = 0;
        while (pos < n) {
            if ((pos == 0) || (array[pos].compareTo(array[(pos - 1)]) >= 0)) {
                pos++;
            } else {
                swap(array, pos, --pos);
            }
        }
    }

    /**
     * {@code gnomeDec} that implements the Gnome Sort algorithm to sort an array of
     * {@link java.lang.Comparable Comparable} objects in descending order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Set the current position {@code (pos)} to 0.</li>
     *     <li>While {@code pos} is less than the length of the array:</li>
     *     <li>If {@code pos} is 0 or the current element is in the correct order with the previous element,
     *     move to the next position by incrementing {@code pos}.</li>
     *     <li>If the current element is out of order with the previous element,
     *     swap them and move one position back by decrementing {@code pos}.</li>
     *     <li>Repeat step 3 until {@code pos} reaches the end of the array.</li>
     * </ul>
     * {@code gnomeDec} method implements the Gnome Sort algorithm to sort the given
     * {@code array} of Comparable objects in descending order.
     * @param       array to be arranged.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void gnomeDec(Comparable[] array) {
        int n = array.length, pos = 0;
        while (pos < n) {
            if ((pos == 0) || (array[pos].compareTo(array[(pos - 1)]) <= 0)) {
                pos++;
            } else {
                swap(array, pos, --pos);
            }
        }
    }

    /**
     * {@code gnome} method takes an array of {@link java.lang.Comparable Comparable} objects,
     * It also takes a {@code SortFunctional<Comparable>} object representing the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method starts by initializing a {@code pos} variable to {@code n},
     *     representing the current position in the array.</li>
     *     <li>Next, a {@code functionalAddEquals} object is created by calling the {@code functionalComparableToAddEquals} method,
     *     which seems to convert the original comparison logic to a new logic where elements
     *     that are equal are considered as "greater" for the purpose of the sorting algorithm.</li>
     *     <li>The algorithm then enters a while loop that continues as long as {@code pos} is less than {@code n}.
     *     Within the loop, there is an if-else condition:</li>
     *     <li>If pos is equal to <i>0</i> or the comparison using the {@code functionalAddEquals} object indicates that
     *     the current element is "greater" than the previous element,
     *     the {@code pos} is incremented to move to the next position.</li>
     *     <li>Otherwise, if the current element is "less" than the previous element,
     *     the {@code swap} method is called to swap the elements,
     *     and {@code pos} is decremented to move backward in the array.</li>
     * </ul>
     * {@code gnome} method implements the Gnome Sort algorithm to sort the given
     * {@code array} of Comparable objects in function defined from order.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.Sort#functionalComparableToAddEquals(SortFunctional)
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    protected void gnome(Comparable[] array, SortFunctional<Comparable> functional) {
        int n = array.length, pos = 0;
        SortFunctional<Comparable> functionalAddEquals = functionalComparableToAddEquals(functional);
        while (pos < n) {
            if ((pos == 0) || (functionalAddEquals.functionalCompareTo(array[pos], array[(pos - 1)]))) {
                pos++;
            } else {
                swap(array, pos, --pos);
            }
        }
    }

    /**
     * {@code gnomeInc} that implements the Gnome Sort algorithm to sort an array of
     * {@link java.lang.Comparable Comparable} objects in ascending order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Set the current position {@code (pos)} to 0.</li>
     *     <li>While {@code pos} is less than the length of the array:</li>
     *     <li>If {@code pos} is 0 or the current element is in the correct order with the previous element,
     *     move to the next position by incrementing {@code pos}.</li>
     *     <li>If the current element is out of order with the previous element,
     *     swap them and move one position back by decrementing {@code pos}.</li>
     *     <li>Repeat step 3 until {@code pos} reaches the end of the array.</li>
     * </ul>
     * {@code gnomeInc} method implements the Gnome Sort algorithm to sort the given
     * {@code array} of Comparable objects in ascending order.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void gnomeInc(Comparable[] array, int left, int right) {
        int pos = left;
        while (pos < right) {
            if ((pos == 0) || (array[pos].compareTo(array[(pos - 1)]) >= 0)) {
                pos++;
            } else {
                swap(array, pos, --pos);
            }
        }
    }

    /**
     * {@code gnomeDec} that implements the Gnome Sort algorithm to sort an array of
     * {@link java.lang.Comparable Comparable} objects in descending order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Set the current position {@code (pos)} to 0.</li>
     *     <li>While {@code pos} is less than the length of the array:</li>
     *     <li>If {@code pos} is 0 or the current element is in the correct order with the previous element,
     *     move to the next position by incrementing {@code pos}.</li>
     *     <li>If the current element is out of order with the previous element,
     *     swap them and move one position back by decrementing {@code pos}.</li>
     *     <li>Repeat step 3 until {@code pos} reaches the end of the array.</li>
     * </ul>
     * {@code gnomeDec} method implements the Gnome Sort algorithm to sort the given
     * {@code array} of Comparable objects in descending order.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    @SuppressWarnings("unchecked")
    protected void gnomeDec(Comparable[] array, int left, int right) {
        int pos = left;
        while (pos < right) {
            if ((pos == 0) || (array[pos].compareTo(array[(pos - 1)]) <= 0)) {
                pos++;
            } else {
                swap(array, pos, --pos);
            }
        }
    }

    /**
     * {@code gnome} method takes an array of {@link java.lang.Comparable Comparable} objects,
     * along with the {@code left} and {@code right} indices specifying the range of elements to be sorted.
     * It also takes a {@code SortFunctional<Comparable>} object representing the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method starts by initializing a {@code pos} variable to {@code left},
     *     representing the current position in the array.</li>
     *     <li>Next, a {@code functionalAddEquals} object is created by calling the {@code functionalComparableToAddEquals} method,
     *     which seems to convert the original comparison logic to a new logic where elements
     *     that are equal are considered as "greater" for the purpose of the sorting algorithm.</li>
     *     <li>The algorithm then enters a while loop that continues as long as {@code pos} is less than {@code right}.
     *     Within the loop, there is an if-else condition:</li>
     *     <li>If pos is equal to <i>0</i> or the comparison using the {@code functionalAddEquals} object indicates that
     *     the current element is "greater" than the previous element,
     *     the {@code pos} is incremented to move to the next position.</li>
     *     <li>Otherwise, if the current element is "less" than the previous element,
     *     the {@code swap} method is called to swap the elements,
     *     and {@code pos} is decremented to move backward in the array.</li>
     * </ul>
     * {@code gnome} method implements the Gnome Sort algorithm to sort the given
     * {@code array} of Comparable objects in function defined from order.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         mz.Sort#functionalComparableToAddEquals(SortFunctional)
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         mz.SortSwap#swap(Comparable[], int, int)
     */
    protected void gnome(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        int pos = left;
        SortFunctional<Comparable> functionalAddEquals = functionalComparableToAddEquals(functional);
        while (pos < right) {
            if ((pos == 0) || (functionalAddEquals.functionalCompareTo(array[pos], array[(pos - 1)]))) {
                pos++;
            } else {
                swap(array, pos, --pos);
            }
        }
    }

    /**
     * {@code gnomeInc} that implements the Gnome Sort algorithm to sort an list of
     * {@link java.lang.Comparable Comparable} objects in ascending order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>Start with an unsorted list of elements.</li>
     *     <li>Set the current position {@code (pos)} to 0.</li>
     *     <li>While {@code pos} is less than the length of the list:</li>
     *     <li>If {@code pos} is 0 or the current element is in the correct order with the previous element,
     *     move to the next position by incrementing {@code pos}.</li>
     *     <li>If the current element is out of order with the previous element,
     *     swap them and move one position back by decrementing {@code pos}.</li>
     *     <li>Repeat step 3 until {@code pos} reaches the end of the list.</li>
     * </ul>
     * {@code gnomeInc} method implements the Gnome Sort algorithm to sort the given
     * {@code list} of Comparable objects in ascending order.
     * @param       list to be arranged.
     * @see         mz.SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void gnomeInc(List<L> list) {
        int n = list.size(), pos = 0;
        while (pos < n) {
            if ((pos == 0) || (list.get(pos).compareTo(list.get(pos - 1)) >= 0)) {
                pos++;
            } else {
                swap(list, pos, --pos);
            }
        }
    }

    /**
     * {@code gnomeDec} that implements the Gnome Sort algorithm to sort a list of
     * {@link java.lang.Comparable Comparable} objects in descending order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>Start with an unsorted list of elements.</li>
     *     <li>Set the current position {@code (pos)} to 0.</li>
     *     <li>While {@code pos} is less than the length of the list:</li>
     *     <li>If {@code pos} is 0 or the current element is in the correct order with the previous element,
     *     move to the next position by incrementing {@code pos}.</li>
     *     <li>If the current element is out of order with the previous element,
     *     swap them and move one position back by decrementing {@code pos}.</li>
     *     <li>Repeat step 3 until {@code pos} reaches the end of the list.</li>
     * </ul>
     * {@code gnomeDec} method implements the Gnome Sort algorithm to sort the given
     * {@code list} of Comparable objects in descending order.
     * @param       list to be arranged.
     * @see         mz.SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void gnomeDec(List<L> list) {
        int n = list.size(), pos = 0;
        while (pos < n) {
            if ((pos == 0) || (list.get(pos).compareTo(list.get(pos - 1)) <= 0)) {
                pos++;
            } else {
                swap(list, pos, --pos);
            }
        }
    }

    /**
     * {@code gnome} method takes a list of {@link java.lang.Comparable Comparable} objects,
     * It also takes a {@code SortFunctional<Comparable>} object representing the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method starts by initializing a {@code pos} variable to {@code n},
     *     representing the current position in the list.</li>
     *     <li>Next, a {@code functionalAddEquals} object is created by calling the {@code functionalComparableToAddEquals} method,
     *     which seems to convert the original comparison logic to a new logic where elements
     *     that are equal are considered as "greater" for the purpose of the sorting algorithm.</li>
     *     <li>The algorithm then enters a while loop that continues as long as {@code pos} is less than {@code n}.
     *     Within the loop, there is an if-else condition:</li>
     *     <li>If pos is equal to <i>0</i> or the comparison using the {@code functionalAddEquals} object indicates that
     *     the current element is "greater" than the previous element,
     *     the {@code pos} is incremented to move to the next position.</li>
     *     <li>Otherwise, if the current element is "less" than the previous element,
     *     the {@code swap} method is called to swap the elements,
     *     and {@code pos} is decremented to move backward in the list.</li>
     * </ul>
     * {@code gnome} method implements the Gnome Sort algorithm to sort the given
     * {@code list} of Comparable objects in function defined from order.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.Sort#functionalComparableToAddEquals(SortFunctional)
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         mz.SortSwap#swap(List, int, int)
     */
    protected <L extends Comparable> void gnome(List<L> list, SortFunctional<Comparable> functional) {
        int n = list.size(), pos = 0;
        SortFunctional<Comparable> functionalAddEquals = functionalComparableToAddEquals(functional);
        while (pos < n) {
            if ((pos == 0) || (functionalAddEquals.functionalCompareTo(list.get(pos), list.get(pos - 1)))) {
                pos++;
            } else {
                swap(list, pos, --pos);
            }
        }
    }

    /**
     * {@code gnomeInc} that implements the Gnome Sort algorithm to sort an list of
     * {@link java.lang.Comparable Comparable} objects in ascending order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>Start with an unsorted list of elements.</li>
     *     <li>Set the current position {@code (pos)} to 0.</li>
     *     <li>While {@code pos} is less than the length of the list:</li>
     *     <li>If {@code pos} is 0 or the current element is in the correct order with the previous element,
     *     move to the next position by incrementing {@code pos}.</li>
     *     <li>If the current element is out of order with the previous element,
     *     swap them and move one position back by decrementing {@code pos}.</li>
     *     <li>Repeat step 3 until {@code pos} reaches the end of the list.</li>
     * </ul>
     * {@code gnomeInc} method implements the Gnome Sort algorithm to sort the given
     * {@code list} of Comparable objects in ascending order.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         mz.SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void gnomeInc(List<L> list, int left, int right) {
        int pos = left;
        while (pos < right) {
            if ((pos == 0) || (list.get(pos).compareTo(list.get(pos - 1)) >= 0)) {
                pos++;
            } else {
                swap(list, pos, --pos);
            }
        }
    }

    /**
     * {@code gnomeDec} that implements the Gnome Sort algorithm to sort a list of
     * {@link java.lang.Comparable Comparable} objects in descending order.
     * <ul>
     *     <li>The {@link java.lang.SuppressWarnings @SuppressWarnings}{@code ("unchecked")} annotation is used to suppress compiler warnings related to type
     *     safety when using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>Start with an unsorted list of elements.</li>
     *     <li>Set the current position {@code (pos)} to 0.</li>
     *     <li>While {@code pos} is less than the length of the list:</li>
     *     <li>If {@code pos} is 0 or the current element is in the correct order with the previous element,
     *     move to the next position by incrementing {@code pos}.</li>
     *     <li>If the current element is out of order with the previous element,
     *     swap them and move one position back by decrementing {@code pos}.</li>
     *     <li>Repeat step 3 until {@code pos} reaches the end of the list.</li>
     * </ul>
     * {@code gnomeDec} method implements the Gnome Sort algorithm to sort the given
     * {@code list} of Comparable objects in descending order.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         mz.SortSwap#swap(List, int, int)
     */
    @SuppressWarnings("unchecked")
    protected <L extends Comparable> void gnomeDec(List<L> list, int left, int right) {
        int pos = left;
        while (pos < right) {
            if ((pos == 0) || (list.get(pos).compareTo(list.get(pos - 1)) <= 0)) {
                pos++;
            } else {
                swap(list, pos, --pos);
            }
        }
    }

    /**
     * {@code gnome} method takes a list of {@link java.lang.Comparable Comparable} objects,
     * along with the {@code left} and {@code right} indices specifying the range of elements to be sorted.
     * It also takes a {@code SortFunctional<Comparable>} object representing the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method starts by initializing a {@code pos} variable to {@code left},
     *     representing the current position in the list.</li>
     *     <li>Next, a {@code functionalAddEquals} object is created by calling the {@code functionalComparableToAddEquals} method,
     *     which seems to convert the original comparison logic to a new logic where elements
     *     that are equal are considered as "greater" for the purpose of the sorting algorithm.</li>
     *     <li>The algorithm then enters a while loop that continues as long as {@code pos} is less than {@code right}.
     *     Within the loop, there is an if-else condition:</li>
     *     <li>If pos is equal to <i>0</i> or the comparison using the {@code functionalAddEquals} object indicates that
     *     the current element is "greater" than the previous element,
     *     the {@code pos} is incremented to move to the next position.</li>
     *     <li>Otherwise, if the current element is "less" than the previous element,
     *     the {@code swap} method is called to swap the elements,
     *     and {@code pos} is decremented to move backward in the list.</li>
     * </ul>
     * {@code gnome} method implements the Gnome Sort algorithm to sort the given
     * {@code list} of Comparable objects in function defined from order.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         mz.Sort#functionalComparableToAddEquals(SortFunctional)
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     * @see         mz.SortSwap#swap(List, int, int)
     */
    protected <L extends Comparable> void gnome(List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        int pos = left;
        SortFunctional<Comparable> functionalAddEquals = functionalComparableToAddEquals(functional);
        while (pos < right) {
            if ((pos == 0) || (functionalAddEquals.functionalCompareTo(list.get(pos), list.get(pos - 1)))) {
                pos++;
            } else {
                swap(list, pos, --pos);
            }
        }
    }
}