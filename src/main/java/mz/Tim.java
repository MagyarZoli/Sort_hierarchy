package mz;

import java.util.List;

/**
 * Tim Sort is a hybrid sorting algorithm that combines the strengths of Merge Sort and Insertion Sort to achieve efficient and stable sorting.
 * The default sorting algorithm in Java's {@link java.util.Arrays#sort(Object[]) Arrays.sort()} method.
 * @since       1.3
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public class Tim
extends Merge
implements InsertionInterface<Comparable> {

    /**
     * Minimum merge size storage.
     */
    protected final int MIN_MERGE = 32;

    /**
     * <b>Tim Sort:</b><br>
     * Is a hybrid sorting algorithm that combines the strengths of Merge Sort and Insertion Sort to achieve efficient and stable sorting.
     * The default sorting algorithm in Java's {@link java.util.Arrays#sort(Object[]) Arrays.sort()} method.<br><br>
     * <b>Example:</b>
     * <ol>
     *     <li>Insertion Sort: Tim Sort starts by dividing the input array into small chunks or "runs."
     *     It uses Insertion Sort to sort these runs individually.
     *     Insertion Sort is chosen for small chunks because it performs well on already partially sorted data.</li>
     *     <li>Merge Step: After the runs are sorted, Tim Sort begins merging them.
     *     It repeatedly merges pairs of runs into larger sorted runs until there is only one run remaining.
     *     The merging process is similar to the merge step in Merge Sort.</li>
     *     <li>Run Size Determination: Tim Sort employs a concept called "galloping" to determine the size of runs during the merging process.
     *     It dynamically adjusts the run size based on the distribution of the data, aiming to minimize the number of comparisons and movements.
     *     This adaptive nature of Tim Sort allows it to adapt to different types of input data.</li>
     *     <li>Stability: Tim Sort is a stable sorting algorithm, meaning that it preserves the relative order of elements with equal values.
     *     It ensures that equal elements maintain their original order during the sorting process.</li>
     *     <li>Optimization Techniques: Tim Sort incorporates various optimizations to improve performance.
     *     These include the use of a temporary buffer array during merging,
     *     reducing the number of comparisons by exploiting sorted subsequences, and minimizing data movements.</li>
     * </ol>
     * <b>Note:</b><br>
     * Tim Sort is designed to perform well on various types of real-world data, including arrays with a mix of already sorted and unsorted elements,
     * as well as datasets with duplicate elements.
     * It aims to minimize the number of comparisons and data movements while providing good worst-case time complexity.<br><br>
     * The time complexity of Tim Sort is O(n log n) in the worst case. This occurs when the input data is in reverse order or has no pre-existing order.
     * In practice, Tim Sort often performs better than the worst-case time complexity due to its ability to efficiently handle partially sorted and duplicate elements.<br><br>
     * Tim Sort's ability to handle different types of input data, its stability, and its worst-case time complexity of <em>O(n log(n))</em>
     * make it a widely used and reliable sorting algorithm in many programming languages and applications.<br><br>
     * <b>Property:</b><br>
     * Worst Case Complexity:   <em>O(n log(n))</em><br>
     * Best Case Complexity:    <em>O(n log(n))</em><br>
     * Average Case Complexity: <em>O(n log(n))</em><br>
     * Auxiliary Space:         <em>O(n)</em><br>
     * Stability:               <b>Yes</b>
     * @see         mz.intro.IntroTim#IntroTim() IntroTim
     */
    public Tim() {}

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayInc(Comparable[] array) {
        timInc(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     */
    @Override
    public void sortArrayDec(Comparable[] array) {
        timDec(array);
    }

    /**
     * {@inheritDoc}
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortArrayFun(Comparable[] array, SortFunctional<Comparable> functional) {
        tim(array, functional);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListInc(List<? extends Comparable> list) {
        timInc(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     */
    @Override
    public void sortListDec(List<? extends Comparable> list) {
        timDec(list);
    }

    /**
     * {@inheritDoc}
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     */
    @Override
    public void sortListFun(List<? extends Comparable> list, SortFunctional<Comparable> functional) {
        tim(list, functional);
    }

    /**
     * {@code timInc} that takes an array of {@link java.lang.Comparable Comparable} objects.
     * This method performs an incremental variant of the Tim Sort algorithm to sort the specified range of the array.
     * <ul>
     *     <li>The method starts by initializing the variables {@code n} and {@code minRun}.
     *     The {@code n} variable is assigned the value of the {@code array.length}, which represents the exclusive upper bound of the range to be sorted.
     *     The {@code minRun} variable is assigned the result of the {@code minRunLength} method called with the {@code MIN_MERGE} constant.</li>
     *     <li>The first {@code for} loop iterates over the range from <i>0</i> to {@code n} with a step size of {@code minRun}.
     *     It calls the {@code insertionInc} method to perform an incremental insertion sort on the subarray from {@code i}
     *     to ({@link java.lang.Math Math.min}{@code ((i + MIN_MERGE), n) - 1}).
     *     This step is used to ensure that each small run within the array is sorted.</li>
     *     <li>The second {@code for} loop performs the merging step of the Tim Sort algorithm.
     *     It starts with a {@code size} value of {@code minRun} and doubles the value of {@code size} in each iteration.
     *     It iterates over the range from <i>0</i> to {@code n} with a step size of {@code (2 * size)}.
     *     Within each iteration, it determines the mid index {@code mid} and the upper bound index {@code j} of the current subarray.
     *     If {@code mid} is less than {@code j}, it calls the {@code mergeInc} method to merge the subarrays
     *     from {@code i} to mid and from {@code (mid + 1)} to {@code j}.
     *     This step merges adjacent sorted subarrays together until the entire range is sorted.</li>
     * </ul>
     * {@code timInc} method uses incremental insertion sort to sort small runs within
     * the array and then performs merging steps to combine adjacent sorted subarrays.
     * This incremental variant of Tim Sort provides efficient sorting
     * for arrays that may already have some degree of ordering or partial sorting.
     * @param       array to be arranged.
     * @see         mz.Tim#MIN_MERGE
     * @see         mz.Tim#minRunLength(int)
     * @see         mz.InsertionInterface#insertionInc(Comparable[], int, int)
     * @see         mz.MergeInterface#mergeInc(Comparable[], int, int, int)
     */
    protected void timInc(Comparable[] array) {
        int n = array.length, minRun = minRunLength(MIN_MERGE);
        for (int i = 0; i < n; i += minRun) {
            insertionInc(array, i, (Math.min((i + MIN_MERGE), n) - 1));
        }
        for (int size = minRun; size < n; size *= 2) {
            for (int i = 0; i < n; i += (2 * size)) {
                int mid = (i + size - 1), j = (Math.min(i + (2 * size), n) - 1);
                if (mid < j) {
                    mergeInc(array, i, mid, j);
                }
            }
        }
    }

    /**
     * {@code timDec} that takes an array of {@link java.lang.Comparable Comparable} objects.
     * This method performs a decremental variant of the Tim Sort algorithm to sort the specified range of the array.
     * <ul>
     *     <li>The method starts by initializing the variables {@code n} and {@code minRun}.
     *     The {@code n} variable is assigned the value of the {@code array.length}, which represents the exclusive upper bound of the range to be sorted.
     *     The {@code minRun} variable is assigned the result of the {@code minRunLength} method called with the {@code MIN_MERGE} constant.</li>
     *     <li>The first {@code for} loop iterates over the range from <i>0</i> to {@code n} with a step size of {@code minRun}.
     *     It calls the {@code insertionDec} method to perform an incremental insertion sort on the subarray from {@code i}
     *     to ({@link java.lang.Math Math.min}{@code ((i + MIN_MERGE), n) - 1}).
     *     This step is used to ensure that each small run within the array is sorted.</li>
     *     <li>The second {@code for} loop performs the merging step of the Tim Sort algorithm.
     *     It starts with a {@code size} value of {@code minRun} and doubles the value of {@code size} in each iteration.
     *     It iterates over the range from <i>0</i> to {@code n} with a step size of {@code (2 * size)}.
     *     Within each iteration, it determines the mid index {@code mid} and the upper bound index {@code j} of the current subarray.
     *     If {@code mid} is less than {@code j}, it calls the {@code mergeDec} method to merge the subarrays
     *     from {@code i} to mid and from {@code (mid + 1)} to {@code j}.
     *     This step merges adjacent sorted subarrays together until the entire range is sorted.</li>
     * </ul>
     * {@code timDec} method uses decremental insertion sort to sort small runs within
     * the array and then performs merging steps to combine adjacent sorted subarrays.
     * This decremental variant of Tim Sort provides efficient sorting
     * for arrays that may already have some degree of ordering or partial sorting.
     * @param       array to be arranged.
     * @see         mz.Tim#MIN_MERGE
     * @see         mz.Tim#minRunLength(int)
     * @see         mz.InsertionInterface#insertionInc(Comparable[], int, int)
     * @see         mz.MergeInterface#mergeInc(Comparable[], int, int, int)
     */
    protected void timDec(Comparable[] array) {
        int n = array.length, minRun = minRunLength(MIN_MERGE);
        for (int i = 0; i < n; i += minRun) {
            insertionInc(array, i, (Math.min((i + MIN_MERGE), n) - 1));
        }
        for (int size = minRun; size < n; size *= 2) {
            for (int i = 0; i < n; i += (2 * size)) {
                int mid = (i + size - 1), j = (Math.min(i + (2 * size), n) - 1);
                if (mid < j) {
                    mergeDec(array, i, mid, j);
                }
            }
        }
    }

    /**
     * {@code tim} method takes an array of {@link java.lang.Comparable Comparable} objects,
     * It also takes a {@code SortFunctional<Comparable>} object representing
     * the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method begins by calculating the {@code minRun} length,
     *     which determines the minimum size of a run in the Tim sort algorithm.
     *     The {@code minRunLength} method calculates the minimum run length based
     *     on a predefined constant ({@code MIN_MERGE}).</li>
     *     <li>Next, the method enters a {@code for} loop that starts from {@code i = 0} and increments {@code i}
     *     by minRun in each iteration. This loop is responsible for performing insertion sort on small subarrays called runs.
     *     The {@code insertion} method implements the insertion sort algorithm to sort the elements within each run,
     *     using the provided comparison logic.</li>
     *     <li>After sorting each run, the method enters another {@code for} loop that iterates over different sizes of runs.
     *     It starts from {@code size = minRun} and doubles the size in each iteration {@code size *= 2}.</li>
     *     <li>Within this loop, there is another {@code for} loop that iterates over the elements in the array with an interval of {@code (2 * size)}.
     *     This loop handles the merging step of the Tim sort algorithm.
     *     It merges adjacent subarrays of size {@code size} by calling the {@code merge} method with the appropriate indices.
     *     The {@code merge} method likely implements the merging logic of merge sort,
     *     combining two sorted subarrays into a larger sorted subarray, using the provided comparison logic.</li>
     * </ul>
     * {@code tim} method insertion sort to sort small runs within
     * the array and then performs merging steps to combine adjacent sorted subarrays.
     * This decremental variant of Tim Sort provides efficient sorting
     * for arrays that may already have some degree of ordering or partial sorting.
     * @param       array to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.Tim#MIN_MERGE
     * @see         mz.Tim#minRunLength(int)
     * @see         mz.InsertionInterface#insertion(Comparable[], int, int, SortFunctional)
     * @see         mz.MergeInterface#merge(Comparable[], int, int, int, SortFunctional)
     */
    protected void tim(Comparable[] array, SortFunctional<Comparable> functional) {
        int n = array.length, minRun = minRunLength(MIN_MERGE);
        for (int i = 0; i < n; i += minRun) {
            insertion(array, i, (Math.min((i + MIN_MERGE), n) - 1), functional);
        }
        for (int size = minRun; size < n; size *= 2) {
            for (int i = 0; i < n; i += (2 * size)) {
                int mid = (i + size - 1), j = (Math.min(i + (2 * size), n) - 1);
                if (mid < j) {
                    merge(array, i, mid, j, functional);
                }
            }
        }
    }

    /**
     * {@code timInc} that takes an array of {@link java.lang.Comparable Comparable} objects,
     * an integer {@code left}, and an integer {@code right} as input.
     * This method performs an incremental variant of the Tim Sort algorithm to sort the specified range of the array.
     * <ul>
     *     <li>The method starts by initializing the variable {@code minRun}.
     *     The {@code right} parameter, which represents the exclusive upper bound of the range to be sorted.
     *     The {@code minRun} variable is assigned the result of the {@code minRunLength} method called with the {@code MIN_MERGE} constant.</li>
     *     <li>The first {@code for} loop iterates over the range from <i>0</i> to {@code right} with a step size of {@code minRun}.
     *     It calls the {@code insertionInc} method to perform an incremental insertion sort on the subarray from {@code i}
     *     to ({@link java.lang.Math Math.min}{@code ((i + MIN_MERGE), right) - 1}).
     *     This step is used to ensure that each small run within the array is sorted.</li>
     *     <li>The second {@code for} loop performs the merging step of the Tim Sort algorithm.
     *     It starts with a {@code size} value of {@code minRun} and doubles the value of {@code size} in each iteration.
     *     It iterates over the range from {@code left} to {@code right} with a step size of {@code (2 * size)}.
     *     Within each iteration, it determines the mid index {@code mid} and the upper bound index {@code j} of the current subarray.
     *     If {@code mid} is less than {@code j}, it calls the {@code mergeInc} method to merge the subarrays
     *     from {@code i} to mid and from {@code (mid + 1)} to {@code j}.
     *     This step merges adjacent sorted subarrays together until the entire range is sorted.</li>
     * </ul>
     * {@code timInc} method uses incremental insertion sort to sort small runs within
     * the array and then performs merging steps to combine adjacent sorted subarrays.
     * This incremental variant of Tim Sort provides efficient sorting
     * for arrays that may already have some degree of ordering or partial sorting.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.Tim#MIN_MERGE
     * @see         mz.Tim#minRunLength(int)
     * @see         mz.InsertionInterface#insertionInc(Comparable[], int, int)
     * @see         mz.MergeInterface#mergeInc(Comparable[], int, int, int)
     */
    protected void timInc(Comparable[] array, int left, int right) {
        int minRun = minRunLength(MIN_MERGE);
        for (int i = 0; i < right; i += minRun) {
            insertionInc(array, i, (Math.min((i + MIN_MERGE), right) - 1));
        }
        for (int size = minRun; size < right; size *= 2) {
            for (int i = left; i < right; i += (2 * size)) {
                int mid = (i + size - 1), j = (Math.min(i + (2 * size), right) - 1);
                if (mid < j) {
                    mergeInc(array, i, mid, j);
                }
            }
        }
    }

    /**
     * {@code timDec} that takes an array of {@link java.lang.Comparable Comparable} objects,
     * an integer {@code left}, and an integer {@code right} as input.
     * This method performs a decremental variant of the Tim Sort algorithm to sort the specified range of the array.
     * <ul>
     *     <li>The method starts by initializing the variable {@code minRun}.
     *     The {@code right} parameter, which represents the exclusive upper bound of the range to be sorted.
     *     The {@code minRun} variable is assigned the result of the {@code minRunLength} method called with the {@code MIN_MERGE} constant.</li>
     *     <li>The first {@code for} loop iterates over the range from <i>0</i> to {@code right} with a step size of {@code minRun}.
     *     It calls the {@code insertionDec} method to perform an incremental insertion sort on the subarray from {@code i}
     *     to ({@link java.lang.Math Math.min}{@code ((i + MIN_MERGE), right) - 1}).
     *     This step is used to ensure that each small run within the array is sorted.</li>
     *     <li>The second {@code for} loop performs the merging step of the Tim Sort algorithm.
     *     It starts with a {@code size} value of {@code minRun} and doubles the value of {@code size} in each iteration.
     *     It iterates over the range from {@code left} to {@code right} with a step size of {@code (2 * size)}.
     *     Within each iteration, it determines the mid index {@code mid} and the upper bound index {@code j} of the current subarray.
     *     If {@code mid} is less than {@code j}, it calls the {@code mergeDec} method to merge the subarrays
     *     from {@code i} to mid and from {@code (mid + 1)} to {@code j}.
     *     This step merges adjacent sorted subarrays together until the entire range is sorted.</li>
     * </ul>
     * {@code timDec} method uses decremental insertion sort to sort small runs within
     * the array and then performs merging steps to combine adjacent sorted subarrays.
     * This decremental variant of Tim Sort provides efficient sorting
     * for arrays that may already have some degree of ordering or partial sorting.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @see         mz.Tim#MIN_MERGE
     * @see         mz.Tim#minRunLength(int)
     * @see         mz.InsertionInterface#insertionInc(Comparable[], int, int)
     * @see         mz.MergeInterface#mergeInc(Comparable[], int, int, int)
     */
    protected void timDec(Comparable[] array, int left, int right) {
        int minRun = minRunLength(MIN_MERGE);
        for (int i = 0; i < right; i += minRun) {
            insertionInc(array, i, (Math.min((i + MIN_MERGE), right) - 1));
        }
        for (int size = minRun; size < right; size *= 2) {
            for (int i = left; i < right; i += (2 * size)) {
                int mid = (i + size - 1), j = (Math.min(i + (2 * size), right) - 1);
                if (mid < j) {
                    mergeDec(array, i, mid, j);
                }
            }
        }
    }

    /**
     * {@code tim} method takes an array of {@link java.lang.Comparable Comparable} objects,
     * along with the left and right indices specifying the range of elements to be sorted.
     * It also takes a {@code SortFunctional<Comparable>} object representing
     * the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method begins by calculating the {@code minRun} length,
     *     which determines the minimum size of a run in the Tim sort algorithm.
     *     The {@code minRunLength} method calculates the minimum run length based
     *     on a predefined constant ({@code MIN_MERGE}).</li>
     *     <li>Next, the method enters a {@code for} loop that starts from {@code i = 0} and increments {@code i}
     *     by minRun in each iteration. This loop is responsible for performing insertion sort on small subarrays called runs.
     *     The {@code insertion} method implements the insertion sort algorithm to sort the elements within each run,
     *     using the provided comparison logic.</li>
     *     <li>After sorting each run, the method enters another {@code for} loop that iterates over different sizes of runs.
     *     It starts from {@code size = minRun} and doubles the size in each iteration {@code size *= 2}.</li>
     *     <li>Within this loop, there is another {@code for} loop that iterates over the elements in the array with an interval of {@code (2 * size)}.
     *     This loop handles the merging step of the Tim sort algorithm.
     *     It merges adjacent subarrays of size {@code size} by calling the {@code merge} method with the appropriate indices.
     *     The {@code merge} method likely implements the merging logic of merge sort,
     *     combining two sorted subarrays into a larger sorted subarray, using the provided comparison logic.</li>
     * </ul>
     * {@code tim} method insertion sort to sort small runs within
     * the array and then performs merging steps to combine adjacent sorted subarrays.
     * This decremental variant of Tim Sort provides efficient sorting
     * for arrays that may already have some degree of ordering or partial sorting.
     * @param       array to be arranged.
     * @param       left the value in the array must be smaller than a {@code right} parameter.
     * @param       right the value in the array must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         mz.Tim#MIN_MERGE
     * @see         mz.Tim#minRunLength(int)
     * @see         mz.InsertionInterface#insertion(Comparable[], int, int, SortFunctional)
     * @see         mz.MergeInterface#merge(Comparable[], int, int, int, SortFunctional)
     */
    protected void tim(Comparable[] array, int left, int right, SortFunctional<Comparable> functional) {
        int minRun = minRunLength(MIN_MERGE);
        for (int i = 0; i < right; i += minRun) {
            insertion(array, i, (Math.min((i + MIN_MERGE), right) - 1), functional);
        }
        for (int size = minRun; size < right; size *= 2) {
            for (int i = left; i < right; i += (2 * size)) {
                int mid = (i + size - 1), j = (Math.min(i + (2 * size), right) - 1);
                if (mid < j) {
                    merge(array, i, mid, j, functional);
                }
            }
        }
    }

    /**
     * {@code timInc} that takes a list of {@link java.lang.Comparable Comparable} objects.
     * This method performs an incremental variant of the Tim Sort algorithm to sort the specified range of the list.
     * <ul>
     *     <li>The method starts by initializing the variables {@code n} and {@code minRun}.
     *     The {@code n} variable is assigned the value of the {@code list.length}, which represents the exclusive upper bound of the range to be sorted.
     *     The {@code minRun} variable is assigned the result of the {@code minRunLength} method called with the {@code MIN_MERGE} constant.</li>
     *     <li>The first {@code for} loop iterates over the range from <i>0</i> to {@code n} with a step size of {@code minRun}.
     *     It calls the {@code insertionInc} method to perform an incremental insertion sort on the subarray from {@code i}
     *     to ({@link java.lang.Math Math.min}{@code ((i + MIN_MERGE), n) - 1}).
     *     This step is used to ensure that each small run within the list is sorted.</li>
     *     <li>The second {@code for} loop performs the merging step of the Tim Sort algorithm.
     *     It starts with a {@code size} value of {@code minRun} and doubles the value of {@code size} in each iteration.
     *     It iterates over the range from <i>0</i> to {@code n} with a step size of {@code (2 * size)}.
     *     Within each iteration, it determines the mid index {@code mid} and the upper bound index {@code j} of the current subarray.
     *     If {@code mid} is less than {@code j}, it calls the {@code mergeInc} method to merge the subarrays
     *     from {@code i} to mid and from {@code (mid + 1)} to {@code j}.
     *     This step merges adjacent sorted subarrays together until the entire range is sorted.</li>
     * </ul>
     * {@code timInc} method uses incremental insertion sort to sort small runs within
     * the list and then performs merging steps to combine adjacent sorted subarrays.
     * This incremental variant of Tim Sort provides efficient sorting
     * for arrays that may already have some degree of ordering or partial sorting.
     * @param       list to be arranged.
     * @see         mz.Tim#MIN_MERGE
     * @see         mz.Tim#minRunLength(int)
     * @see         mz.InsertionInterface#insertionInc(List, int, int)
     * @see         mz.MergeInterface#mergeInc(List, int, int, int)
     */
    protected <L extends Comparable> void timInc(List<L> list) {
        int n = list.size(), minRun = minRunLength(MIN_MERGE);
        for (int i = 0; i < n; i += minRun) {
            insertionInc(list, i, (Math.min((i + MIN_MERGE), n) - 1));
        }
        for (int size = minRun; size < n; size *= 2) {
            for (int i = 0; i < n; i += (2 * size)) {
                int mid = (i + size - 1), j = (Math.min(i + (2 * size), n) - 1);
                if (mid < j) {
                    mergeInc(list, i, mid, j);
                }
            }
        }
    }

    /**
     * {@code timDec} that takes a list of {@link java.lang.Comparable Comparable} objects.
     * This method performs a decremental variant of the Tim Sort algorithm to sort the specified range of the list.
     * <ul>
     *     <li>The method starts by initializing the variables {@code n} and {@code minRun}.
     *     The {@code n} variable is assigned the value of the {@code list.length}, which represents the exclusive upper bound of the range to be sorted.
     *     The {@code minRun} variable is assigned the result of the {@code minRunLength} method called with the {@code MIN_MERGE} constant.</li>
     *     <li>The first {@code for} loop iterates over the range from <i>0</i> to {@code n} with a step size of {@code minRun}.
     *     It calls the {@code insertionDec} method to perform an incremental insertion sort on the subarray from {@code i}
     *     to ({@link java.lang.Math Math.min}{@code ((i + MIN_MERGE), n) - 1}).
     *     This step is used to ensure that each small run within the list is sorted.</li>
     *     <li>The second {@code for} loop performs the merging step of the Tim Sort algorithm.
     *     It starts with a {@code size} value of {@code minRun} and doubles the value of {@code size} in each iteration.
     *     It iterates over the range from <i>0</i> to {@code n} with a step size of {@code (2 * size)}.
     *     Within each iteration, it determines the mid index {@code mid} and the upper bound index {@code j} of the current subarray.
     *     If {@code mid} is less than {@code j}, it calls the {@code mergeDec} method to merge the subarrays
     *     from {@code i} to mid and from {@code (mid + 1)} to {@code j}.
     *     This step merges adjacent sorted subarrays together until the entire range is sorted.</li>
     * </ul>
     * {@code timDec} method uses decremental insertion sort to sort small runs within
     * the list and then performs merging steps to combine adjacent sorted subarrays.
     * This decremental variant of Tim Sort provides efficient sorting
     * for arrays that may already have some degree of ordering or partial sorting.
     * @param       list to be arranged.
     * @see         mz.Tim#MIN_MERGE
     * @see         mz.Tim#minRunLength(int)
     * @see         mz.InsertionInterface#insertionInc(List, int, int)
     * @see         mz.MergeInterface#mergeInc(List, int, int, int)
     */
    protected <L extends Comparable> void timDec(List<L> list) {
        int n = list.size(), minRun = minRunLength(MIN_MERGE);
        for (int i = 0; i < n; i += minRun) {
            insertionInc(list, i, (Math.min((i + MIN_MERGE), n) - 1));
        }
        for (int size = minRun; size < n; size *= 2) {
            for (int i = 0; i < n; i += (2 * size)) {
                int mid = (i + size - 1), j = (Math.min(i + (2 * size), n) - 1);
                if (mid < j) {
                    mergeDec(list, i, mid, j);
                }
            }
        }
    }

    /**
     * {@code tim} method takes a list of {@link java.lang.Comparable Comparable} objects,
     * It also takes a {@code SortFunctional<Comparable>} object representing
     * the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method begins by calculating the {@code minRun} length,
     *     which determines the minimum size of a run in the Tim sort algorithm.
     *     The {@code minRunLength} method calculates the minimum run length based
     *     on a predefined constant ({@code MIN_MERGE}).</li>
     *     <li>Next, the method enters a {@code for} loop that starts from {@code i = 0} and increments {@code i}
     *     by minRun in each iteration. This loop is responsible for performing insertion sort on small subarrays called runs.
     *     The {@code insertion} method implements the insertion sort algorithm to sort the elements within each run,
     *     using the provided comparison logic.</li>
     *     <li>After sorting each run, the method enters another {@code for} loop that iterates over different sizes of runs.
     *     It starts from {@code size = minRun} and doubles the size in each iteration {@code size *= 2}.</li>
     *     <li>Within this loop, there is another {@code for} loop that iterates over the elements in the list with an interval of {@code (2 * size)}.
     *     This loop handles the merging step of the Tim sort algorithm.
     *     It merges adjacent subarrays of size {@code size} by calling the {@code merge} method with the appropriate indices.
     *     The {@code merge} method likely implements the merging logic of merge sort,
     *     combining two sorted subarrays into a larger sorted subarray, using the provided comparison logic.</li>
     * </ul>
     * {@code tim} method insertion sort to sort small runs within
     * the list and then performs merging steps to combine adjacent sorted subarrays.
     * This decremental variant of Tim Sort provides efficient sorting
     * for arrays that may already have some degree of ordering or partial sorting.
     * @param       list to be arranged.
     * @param       functional lambda expression for comparison.
     * @see         mz.Tim#MIN_MERGE
     * @see         mz.Tim#minRunLength(int)
     * @see         mz.InsertionInterface#insertion(List, int, int, SortFunctional)
     * @see         mz.MergeInterface#merge(List, int, int, int, SortFunctional)
     */
    protected <L extends Comparable> void tim(List<L> list, SortFunctional<Comparable> functional) {
        int n = list.size(), minRun = minRunLength(MIN_MERGE);
        for (int i = 0; i < n; i += minRun) {
            insertion(list, i, (Math.min((i + MIN_MERGE), n) - 1), functional);
        }
        for (int size = minRun; size < n; size *= 2) {
            for (int i = 0; i < n; i += (2 * size)) {
                int mid = (i + size - 1), j = (Math.min(i + (2 * size), n) - 1);
                if (mid < j) {
                    merge(list, i, mid, j, functional);
                }
            }
        }
    }

    /**
     * {@code timInc} that takes a list of {@link java.lang.Comparable Comparable} objects,
     * an integer {@code left}, and an integer {@code right} as input.
     * This method performs an incremental variant of the Tim Sort algorithm to sort the specified range of the list.
     * <ul>
     *     <li>The method starts by initializing the variable {@code minRun}.
     *     The {@code right} parameter, which represents the exclusive upper bound of the range to be sorted.
     *     The {@code minRun} variable is assigned the result of the {@code minRunLength} method called with the {@code MIN_MERGE} constant.</li>
     *     <li>The first {@code for} loop iterates over the range from <i>0</i> to {@code right} with a step size of {@code minRun}.
     *     It calls the {@code insertionInc} method to perform an incremental insertion sort on the subarray from {@code i}
     *     to ({@link java.lang.Math Math.min}{@code ((i + MIN_MERGE), right) - 1}).
     *     This step is used to ensure that each small run within the list is sorted.</li>
     *     <li>The second {@code for} loop performs the merging step of the Tim Sort algorithm.
     *     It starts with a {@code size} value of {@code minRun} and doubles the value of {@code size} in each iteration.
     *     It iterates over the range from {@code left} to {@code right} with a step size of {@code (2 * size)}.
     *     Within each iteration, it determines the mid index {@code mid} and the upper bound index {@code j} of the current subarray.
     *     If {@code mid} is less than {@code j}, it calls the {@code mergeInc} method to merge the subarrays
     *     from {@code i} to mid and from {@code (mid + 1)} to {@code j}.
     *     This step merges adjacent sorted subarrays together until the entire range is sorted.</li>
     * </ul>
     * {@code timInc} method uses incremental insertion sort to sort small runs within
     * the list and then performs merging steps to combine adjacent sorted subarrays.
     * This incremental variant of Tim Sort provides efficient sorting
     * for arrays that may already have some degree of ordering or partial sorting.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         mz.Tim#MIN_MERGE
     * @see         mz.Tim#minRunLength(int)
     * @see         mz.InsertionInterface#insertionInc(List, int, int)
     * @see         mz.MergeInterface#mergeInc(List, int, int, int)
     */
    protected <L extends Comparable> void timInc(List<L> list, int left, int right) {
        int minRun = minRunLength(MIN_MERGE);
        for (int i = 0; i < right; i += minRun) {
            insertionInc(list, i, (Math.min((i + MIN_MERGE), right) - 1));
        }
        for (int size = minRun; size < right; size *= 2) {
            for (int i = left; i < right; i += (2 * size)) {
                int mid = (i + size - 1), j = (Math.min(i + (2 * size), right) - 1);
                if (mid < j) {
                    mergeInc(list, i, mid, j);
                }
            }
        }
    }

    /**
     * {@code timDec} that takes a list of {@link java.lang.Comparable Comparable} objects,
     * an integer {@code left}, and an integer {@code right} as input.
     * This method performs a decremental variant of the Tim Sort algorithm to sort the specified range of the list.
     * <ul>
     *     <li>The method starts by initializing the variable {@code minRun}.
     *     The {@code right} parameter, which represents the exclusive upper bound of the range to be sorted.
     *     The {@code minRun} variable is assigned the result of the {@code minRunLength} method called with the {@code MIN_MERGE} constant.</li>
     *     <li>The first {@code for} loop iterates over the range from <i>0</i> to {@code right} with a step size of {@code minRun}.
     *     It calls the {@code insertionDec} method to perform an incremental insertion sort on the subarray from {@code i}
     *     to ({@link java.lang.Math Math.min}{@code ((i + MIN_MERGE), right) - 1}).
     *     This step is used to ensure that each small run within the list is sorted.</li>
     *     <li>The second {@code for} loop performs the merging step of the Tim Sort algorithm.
     *     It starts with a {@code size} value of {@code minRun} and doubles the value of {@code size} in each iteration.
     *     It iterates over the range from {@code left} to {@code right} with a step size of {@code (2 * size)}.
     *     Within each iteration, it determines the mid index {@code mid} and the upper bound index {@code j} of the current subarray.
     *     If {@code mid} is less than {@code j}, it calls the {@code mergeDec} method to merge the subarrays
     *     from {@code i} to mid and from {@code (mid + 1)} to {@code j}.
     *     This step merges adjacent sorted subarrays together until the entire range is sorted.</li>
     * </ul>
     * {@code timDec} method uses decremental insertion sort to sort small runs within
     * the list and then performs merging steps to combine adjacent sorted subarrays.
     * This decremental variant of Tim Sort provides efficient sorting
     * for arrays that may already have some degree of ordering or partial sorting.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @see         mz.Tim#MIN_MERGE
     * @see         mz.Tim#minRunLength(int)
     * @see         mz.InsertionInterface#insertionInc(List, int, int)
     * @see         mz.MergeInterface#mergeInc(List, int, int, int)
     */
    protected <L extends Comparable> void timDec(List<L> list, int left, int right) {
        int minRun = minRunLength(MIN_MERGE);
        for (int i = 0; i < right; i += minRun) {
            insertionInc(list, i, (Math.min((i + MIN_MERGE), right) - 1));
        }
        for (int size = minRun; size < right; size *= 2) {
            for (int i = left; i < right; i += (2 * size)) {
                int mid = (i + size - 1), j = (Math.min(i + (2 * size), right) - 1);
                if (mid < j) {
                    mergeDec(list, i, mid, j);
                }
            }
        }
    }

    /**
     * {@code tim} method takes a list of {@link java.lang.Comparable Comparable} objects,
     * along with the left and right indices specifying the range of elements to be sorted.
     * It also takes a {@code SortFunctional<Comparable>} object representing
     * the custom comparison logic to be used for sorting.
     * <ul>
     *     <li>The method begins by calculating the {@code minRun} length,
     *     which determines the minimum size of a run in the Tim sort algorithm.
     *     The {@code minRunLength} method calculates the minimum run length based
     *     on a predefined constant ({@code MIN_MERGE}).</li>
     *     <li>Next, the method enters a {@code for} loop that starts from {@code i = 0} and increments {@code i}
     *     by minRun in each iteration. This loop is responsible for performing insertion sort on small subarrays called runs.
     *     The {@code insertion} method implements the insertion sort algorithm to sort the elements within each run,
     *     using the provided comparison logic.</li>
     *     <li>After sorting each run, the method enters another {@code for} loop that iterates over different sizes of runs.
     *     It starts from {@code size = minRun} and doubles the size in each iteration {@code size *= 2}.</li>
     *     <li>Within this loop, there is another {@code for} loop that iterates over the elements in the list with an interval of {@code (2 * size)}.
     *     This loop handles the merging step of the Tim sort algorithm.
     *     It merges adjacent subarrays of size {@code size} by calling the {@code merge} method with the appropriate indices.
     *     The {@code merge} method likely implements the merging logic of merge sort,
     *     combining two sorted subarrays into a larger sorted subarray, using the provided comparison logic.</li>
     * </ul>
     * {@code tim} method insertion sort to sort small runs within
     * the list and then performs merging steps to combine adjacent sorted subarrays.
     * This decremental variant of Tim Sort provides efficient sorting
     * for arrays that may already have some degree of ordering or partial sorting.
     * @param       list to be arranged.
     * @param       left the value in the list must be smaller than a {@code right} parameter.
     * @param       right the value in the list must be greater than a {@code left} parameter.
     * @param       functional lambda expression for comparison.
     * @see         mz.Tim#MIN_MERGE
     * @see         mz.Tim#minRunLength(int)
     * @see         mz.InsertionInterface#insertion(List, int, int, SortFunctional)
     * @see         mz.MergeInterface#merge(List, int, int, int, SortFunctional)
     */
    protected <L extends Comparable> void tim(List<L> list, int left, int right, SortFunctional<Comparable> functional) {
        int minRun = minRunLength(MIN_MERGE);
        for (int i = 0; i < right; i += minRun) {
            insertion(list, i, (Math.min((i + MIN_MERGE), right) - 1), functional);
        }
        for (int size = minRun; size < right; size *= 2) {
            for (int i = left; i < right; i += (2 * size)) {
                int mid = (i + size - 1), j = (Math.min(i + (2 * size), right) - 1);
                if (mid < j) {
                    merge(list, i, mid, j, functional);
                }
            }
        }
    }

    /**
     * {@code minRunLength} that takes an integer {@code n} as input and returns an integer value.
     * This method calculates the minimum run length based on the value of {@code n}.
     * <ul>
     *     <li>The {@code assert} statement checks if {@code n} is greater than or equal to <i>0</i>.
     *     If this condition is false, an {@link java.lang.AssertionError AssertionError} will be thrown, indicating a violation of the assumed precondition.
     *     It serves as a check to ensure that the input is valid.</li>
     *     <li>An integer variable {@code r} is initialized to <i>0</i>.
     *     This variable will be used to store the least significant bit of {@code n}.</li>
     *     <li>The {@code while} loop continues as long as {@code n} is greater than or equal to a constant value {@code MIN_MERGE}.
     *     This condition implies that the loop will execute until {@code n} becomes smaller than {@code MIN_MERGE}.</li>
     *     <li>Inside the loop, the least significant bit of {@code n} is obtained using the bitwise AND operator {@code &} with <i>1</i> {@code (n & 1)}.
     *     The result is then combined with {@code r} using the bitwise OR operator {@code |} {@code (r |= (n & 1))}.
     *     This operation sets the least significant bit of {@code r} to the same value as the least significant bit of {@code n}.</li>
     *     <li>Next, {@code n} is right-shifted by <i>1</i> {@code (n >>= 1)}, effectively dividing it by <i>2</i>.
     *     This is done to gradually reduce the value of n in each iteration until it becomes smaller than {@code MIN_MERGE}.</li>
     *     <li>Finally, outside the loop, the value of {@code n} is added to {@code r (n + r)},
     *     and the result is returned as the minimum run length.</li>
     * </ul>
     * {@code minRunLength} method calculates the minimum run length based on the input value {@code n} by repeatedly dividing {@code n} by <i>2</i> until it becomes smaller than {@code MIN_MERGE}.
     * The least significant bit of each division is stored in {@code r}, and at the end, {@code r} is added to the remaining value of {@code n} to obtain the final minimum run length.
     * @param       n the minimum run length based on the input value.
     * @return      the result as the minimum run length.
     * @see         mz.Tim#MIN_MERGE
     */
    protected int minRunLength(int n) {
        assert n >= 0;
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return (n + r);
    }
}