package mz;

/**
 * Selection Sort is a simple sorting algorithm that works by dividing an array into two parts:
 * a sorted portion and an unsorted portion. The algorithm repeatedly selects the smallest (or largest)
 * element from the unsorted portion and swaps it with the element at the beginning of the unsorted portion,
 * thereby expanding the sorted portion. This process continues until the entire array becomes sorted.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Selection
extends SortComparable
implements SelectionInterface<Comparable> {

    /**
     * <b>Selection Sort:</b><br>
     * Selection Sort is a simple sorting algorithm that works by dividing an array into two parts:
     * a sorted portion and an unsorted portion. The algorithm repeatedly selects the smallest (or largest)
     * element from the unsorted portion and swaps it with the element at the beginning of the unsorted portion,
     * thereby expanding the sorted portion. This process continues until the entire array becomes sorted.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Start with an unsorted array of elements.</li>
     *     <li>Find the minimum (or maximum) element in the unsorted portion of the array.</li>
     *     <li>Swap the minimum (or maximum) element with the first element of the unsorted portion.</li>
     *     <li>Expand the sorted portion by moving the boundary one position to the right.</li>
     *     <li>Repeat steps 2-4 until the entire array is sorted.</li>
     * </ol>
     * <b>Note:</b><br>
     * Selection Sort is called "selection" because it repeatedly selects the smallest (or largest) element and places
     * it in its correct position. The algorithm requires n-1 passes for an array of size n to sort it completely.
     * Selection Sort has a time complexity of <em>O(n^2)</em> in the average and worst cases, making it inefficient for large datasets.
     * However, it has the advantage of simplicity and requires only a constant amount of additional space.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n^2)</em><br>
     * Best Case Complexity:    <em>O(n^2)</em><br>
     * Average Case Complexity: <em>O(n^2)</em><br>
     * Auxiliary Space:         <em>O(1)</em><br>
     * Stability:               <b>No</b>
     * @see         mz.Bubble#Bubble() Bubble
     * @see         mz.Cocktail#Cocktail() Cocktail
     * @see         mz.Comb#Comb() Comb
     * @see         mz.DoubleSelection#DoubleSelection() DoubleSelection
     * @see         mz.Gnome#Gnome() Gnome
     * @see         mz.intro.IntroBubble#IntroBubble() IntroBubble
     * @see         mz.intro.IntroCocktail#IntroCocktail() IntroCocktail
     * @see         mz.intro.IntroComb#IntroComb() IntroComb
     * @see         mz.intro.introDPQ.IntroDPQBubble#IntroDPQBubble() IntroDPQBubble
     * @see         mz.intro.introDPQ.IntroDPQCocktail#IntroDPQCocktail() IntroDPQCocktail
     * @see         mz.intro.introDPQ.IntroDPQComb#IntroDPQComb() IntroDPQComb
     * @see         mz.intro.introDPQ.IntroDPQDoubleSelection#IntroDPQDoubleSelection() IntroDPQDoubleSelection
     * @see         mz.intro.introDPQ.IntroDPQGnome#IntroDPQGnome() IntroDPQGnome
     * @see         mz.intro.introDPQ.IntroDPQSelection#IntroDPQSelection() IntroDPQSelection
     * @see         mz.intro.IntroDoubleSelection#IntroDoubleSelection() IntroDoubleSelection
     * @see         mz.intro.IntroGnome#IntroGnome() IntroGnome
     * @see         mz.intro.IntroSelection#IntroSelection() IntroSelection
     */
    public Selection() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        selectionInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        selectionDec(array);
    }
}