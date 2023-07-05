package mz;

/**
 * SortFind offered a pre-implemented methodology that can be added and modified outside the hierarchical system.
 * @param       <T> setting of a type based on which the elements can be sorted.
 *              It is not mandatory to specify, additional pre-written subclasses specify the type.
 * @since       1.2
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@SuppressWarnings("rawtypes")
public interface SortFind<T extends Comparable>
extends Sort<T> {

    /**
     * {@code findMax} is a generic method for finding the maximum element in an array of type {@code T}.
     * The generic type {@code T} should implement
     * the Comparable interface, which allows the use of the compareTo method for comparisons.
     * <ul>
     *     <li>The method is declared with a generic type {@code T}, and it has a default implementation.
     *     This means that classes implementing this interface don't need to provide their own implementation of this method.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler warnings related to unchecked generic array creation.
     *     This is because arrays of generic types in Java are not type-safe, and the compiler generates warnings to indicate this.</li>
     *     <li>The method takes an array of type {@code T} as a parameter.</li>
     *     <li>The first element of the array is assigned to the {@code max} variable as the initial maximum value.</li>
     *     <li>The method then iterates over the remaining elements of the array (starting from index 1)
     *     and compares each element to the current maximum using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     If an element is greater than the current maximum, it becomes the new maximum.</li>
     *     <li>Finally, the method returns the maximum element found in the array.</li>
     * </ul>
     * @param       array in which to find the maximum.
     * @return      the maximum element found in the array.
     */
    @SuppressWarnings("unchecked")
    default T findMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * {@code findMin} is a generic method for finding the minimum element in an array of type {@code T}.
     * The generic type {@code T} should implement
     * the Comparable interface, which allows the use of the compareTo method for comparisons.
     * <ul>
     *     <li>The method is declared with a generic type {@code T}, and it has a default implementation.
     *     This means that classes implementing this interface don't need to provide their own implementation of this method.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler warnings related to unchecked generic array creation.
     *     This is because arrays of generic types in Java are not type-safe, and the compiler generates warnings to indicate this.</li>
     *     <li>The method takes an array of type {@code T} as a parameter.</li>
     *     <li>The first element of the array is assigned to the {@code min} variable as the initial minimum value.</li>
     *     <li>The method then iterates over the remaining elements of the array (starting from index 1)
     *     and compares each element to the current minimum using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     If an element is smaller than the current minimum, it becomes the new minimum.</li>
     *     <li>Finally, the method returns the minimum element found in the array.</li>
     * </ul>
     * @param       array in which to find the minimum.
     * @return      the minimum element found in the array.
     */
    @SuppressWarnings("unchecked")
    default T findMin(T[] array) {
        T min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min.compareTo(array[i]) > 0) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * {@code find} within the SortFunctional interface.
     * <ul>
     *     <li>The {@code find} method takes an array array of type {@code T} and an instance of {@code SortFunctional} as parameters.</li>
     *     <li>It declares a variable {@code value} and initializes it with the first element of the {@code array}, {@code array[0]}.</li>
     *     <li>The method then iterates over the remaining elements of the {@code array} using a {@code for} loop.</li>
     *     <li>Within the loop, it calls the {@code functionalCompareTo} method of
     *     the {@code SortFunctional} instance to compare {@code value} with each element of the {@code array}.</li>
     *     <li>If the comparison returns {@code true},
     *     indicating that the current element is greater according to the comparison logic specified by the {@code functional} parameter,
     *     the {@code value} variable is updated to the current element {@code array[i]}.</li>
     *     <li>After iterating through all elements of the {@code array},
     *     the method returns the final value stored in the {@code value} variable.</li>
     * </ul>
     * {@code find} this method is to find the "maximum or minimum" element in the array according to
     * the comparison logic defined by the {@code SortFunctional} instance passed as a parameter.
     * It starts with the first element as the initial value and compares it with the remaining elements.
     * The final value is returned as the result.
     * @param       array in which the value determined by the function is found.
     * @param       functional lambda expression for comparison.
     * @return      a value according to the function defined by {@code functional}.
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default T find(T[] array, SortFunctional<T> functional) {
        T value = array[0];
        for (int i = 1; i < array.length; i++) {
            if (functional.functionalCompareTo(value, array[i])) {
                value = array[i];
            }
        }
        return value;
    }

    /**
     * {@code findMax} is a generic method for finding the maximum element in an array of type {@code T}.
     * The generic type {@code T} should implement
     * the Comparable interface, which allows the use of the compareTo method for comparisons.
     * <ul>
     *     <li>The method is declared with a generic type {@code T}, and it has a default implementation.
     *     This means that classes implementing this interface don't need to provide their own implementation of this method.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler warnings related to unchecked generic array creation.
     *     This is because arrays of generic types in Java are not type-safe, and the compiler generates warnings to indicate this.</li>
     *     <li>The method takes an array of type {@code T} as a parameter.</li>
     *     <li>The first element of the array is assigned to the {@code max} variable as the initial maximum value.</li>
     *     <li>The method then iterates over the remaining elements of the array (starting from index 1)
     *     and compares each element to the current maximum using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     If an element is greater than the current maximum, it becomes the new maximum.</li>
     *     <li>Finally, the method returns the maximum element found in the array.</li>
     * </ul>
     * @param       array in which to find the maximum.
     * @param       to examine to the last detail
     * @return      the maximum element found in the array.
     */
    @SuppressWarnings("unchecked")
    default T findMax(T[] array, int to) {
        T max = array[0];
        for (int i = 1; i < to; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * {@code findMin} is a generic method for finding the minimum element in an array of type {@code T}.
     * The generic type {@code T} should implement
     * the Comparable interface, which allows the use of the compareTo method for comparisons.
     * <ul>
     *     <li>The method is declared with a generic type {@code T}, and it has a default implementation.
     *     This means that classes implementing this interface don't need to provide their own implementation of this method.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler warnings related to unchecked generic array creation.
     *     This is because arrays of generic types in Java are not type-safe, and the compiler generates warnings to indicate this.</li>
     *     <li>The method takes an array of type {@code T} as a parameter.</li>
     *     <li>The first element of the array is assigned to the {@code min} variable as the initial minimum value.</li>
     *     <li>The method then iterates over the remaining elements of the array (starting from index 1)
     *     and compares each element to the current minimum using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     If an element is smaller than the current minimum, it becomes the new minimum.</li>
     *     <li>Finally, the method returns the minimum element found in the array.</li>
     * </ul>
     * @param       array in which to find the minimum.
     * @param       to examine to the last detail
     * @return      the minimum element found in the array.
     */
    @SuppressWarnings("unchecked")
    default T findMin(T[] array, int to) {
        T min = array[0];
        for (int i = 1; i < to; i++) {
            if (min.compareTo(array[i]) > 0) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * {@code find} within the SortFunctional interface.
     * <ul>
     *     <li>The {@code find} method takes an array array of type {@code T} and an instance of {@code SortFunctional} as parameters.</li>
     *     <li>It declares a variable {@code value} and initializes it with the first element of the {@code array}, {@code array[0]}.</li>
     *     <li>The method then iterates over the remaining elements of the {@code array} using a {@code for} loop.</li>
     *     <li>Within the loop, it calls the {@code functionalCompareTo} method of
     *     the {@code SortFunctional} instance to compare {@code value} with each element of the {@code array}.</li>
     *     <li>If the comparison returns {@code true},
     *     indicating that the current element is greater according to the comparison logic specified by the {@code functional} parameter,
     *     the {@code value} variable is updated to the current element {@code array[i]}.</li>
     *     <li>After iterating through all elements of the {@code array},
     *     the method returns the final value stored in the {@code value} variable.</li>
     * </ul>
     * {@code find} this method is to find the "maximum or minimum" element in the array according to
     * the comparison logic defined by the {@code SortFunctional} instance passed as a parameter.
     * It starts with the first element as the initial value and compares it with the remaining elements.
     * The final value is returned as the result.
     * @param       array in which the value determined by the function is found.
     * @param       to examine to the last detail
     * @param       functional lambda expression for comparison.
     * @return      a value according to the function defined by {@code functional}.
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default T find(T[] array, int to, SortFunctional<T> functional) {
        T value = array[0];
        for (int i = 1; i < to; i++) {
            if (functional.functionalCompareTo(value, array[i])) {
                value = array[i];
            }
        }
        return value;
    }

    /**
     * {@code findMax} is a generic method for finding the maximum element in an array of type {@code T}.
     * The generic type {@code T} should implement
     * the Comparable interface, which allows the use of the compareTo method for comparisons.
     * <ul>
     *     <li>The method is declared with a generic type {@code T}, and it has a default implementation.
     *     This means that classes implementing this interface don't need to provide their own implementation of this method.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler warnings related to unchecked generic array creation.
     *     This is because arrays of generic types in Java are not type-safe, and the compiler generates warnings to indicate this.</li>
     *     <li>The method takes an array of type {@code T} as a parameter.</li>
     *     <li>The first element of the array is assigned to the {@code max} variable as the initial maximum value.</li>
     *     <li>The method then iterates over the remaining elements of the array (starting from index 1)
     *     and compares each element to the current maximum using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     If an element is greater than the current maximum, it becomes the new maximum.</li>
     *     <li>Finally, the method returns the maximum element found in the array.</li>
     * </ul>
     * @param       array in which to find the maximum.
     * @param       from check the array starting from this value
     * @param       to examine to the last detail
     * @return      the maximum element found in the array.
     */
    @SuppressWarnings("unchecked")
    default T findMax(T[] array, int from, int to) {
        T max = array[from];
        for (int i = (from + 1); i < to; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * {@code findMin} is a generic method for finding the minimum element in an array of type {@code T}.
     * The generic type {@code T} should implement
     * the Comparable interface, which allows the use of the compareTo method for comparisons.
     * <ul>
     *     <li>The method is declared with a generic type {@code T}, and it has a default implementation.
     *     This means that classes implementing this interface don't need to provide their own implementation of this method.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler warnings related to unchecked generic array creation.
     *     This is because arrays of generic types in Java are not type-safe, and the compiler generates warnings to indicate this.</li>
     *     <li>The method takes an array of type {@code T} as a parameter.</li>
     *     <li>The first element of the array is assigned to the {@code min} variable as the initial minimum value.</li>
     *     <li>The method then iterates over the remaining elements of the array (starting from index 1)
     *     and compares each element to the current minimum using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     If an element is smaller than the current minimum, it becomes the new minimum.</li>
     *     <li>Finally, the method returns the minimum element found in the array.</li>
     * </ul>
     * @param       array in which to find the minimum.
     * @param       from check the array starting from this value
     * @param       to examine to the last detail
     * @return      the minimum element found in the array.
     */
    @SuppressWarnings("unchecked")
    default T findMin(T[] array, int from, int to) {
        T min = array[from];
        for (int i = (from + 1); i < to; i++) {
            if (min.compareTo(array[i]) > 0) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * {@code find} within the SortFunctional interface.
     * <ul>
     *     <li>The {@code find} method takes an array array of type {@code T} and an instance of {@code SortFunctional} as parameters.</li>
     *     <li>It declares a variable {@code value} and initializes it with the first element of the {@code array}, {@code array[0]}.</li>
     *     <li>The method then iterates over the remaining elements of the {@code array} using a {@code for} loop.</li>
     *     <li>Within the loop, it calls the {@code functionalCompareTo} method of
     *     the {@code SortFunctional} instance to compare {@code value} with each element of the {@code array}.</li>
     *     <li>If the comparison returns {@code true},
     *     indicating that the current element is greater according to the comparison logic specified by the {@code functional} parameter,
     *     the {@code value} variable is updated to the current element {@code array[i]}.</li>
     *     <li>After iterating through all elements of the {@code array},
     *     the method returns the final value stored in the {@code value} variable.</li>
     * </ul>
     * {@code find} this method is to find the "maximum or minimum" element in the array according to
     * the comparison logic defined by the {@code SortFunctional} instance passed as a parameter.
     * It starts with the first element as the initial value and compares it with the remaining elements.
     * The final value is returned as the result.
     * @param       array in which the value determined by the function is found.
     * @param       from check the array starting from this value
     * @param       to examine to the last detail
     * @param       functional lambda expression for comparison.
     * @return      a value according to the function defined by {@code functional}.
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default T find(T[] array, int from, int to, SortFunctional<T> functional) {
        T value = array[from];
        for (int i = (from + 1); i < to; i++) {
            if (functional.functionalCompareTo(value, array[i])) {
                value = array[i];
            }
        }
        return value;
    }

    /**
     * {@code findMaxIndex} is a generic method for finding the maximum element in an array of type {@code T}.
     * The generic type {@code T} should implement
     * the Comparable interface, which allows the use of the compareTo method for comparisons.
     * <ul>
     *     <li>The method is declared with a generic type {@code T}, and it has a default implementation.
     *     This means that classes implementing this interface don't need to provide their own implementation of this method.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler warnings related to unchecked generic array creation.
     *     This is because arrays of generic types in Java are not type-safe, and the compiler generates warnings to indicate this.</li>
     *     <li>The method takes an array of type {@code T} as a parameter.</li>
     *     <li>The first element of the array is assigned to the max variable as the initial maximum value.</li>
     *     <li>The {@code maxIndex} variable is initialized with 0, representing the index of the current maximum element.</li>
     *     <li>The method then iterates over the remaining elements of the array (starting from index 1) and compares each element to
     *     the current maximum using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     If an element is greater than the current maximum, it becomes the new maximum, and its index becomes the new {@code maxIndex}.</li>
     *     <li>Finally, the method returns the index of the maximum element found in the array.</li>
     * </ul>
     * @param       array in which to find the maximum.
     * @return      index of the maximum element found in the array.
     */
    @SuppressWarnings("unchecked")
    default int findMaxIndex(T[] array) {
        T max = array[0];
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * {@code findMinIndex} is a generic method for finding the minimum element in an array of type {@code T}.
     * The generic type {@code T} should implement
     * the Comparable interface, which allows the use of the compareTo method for comparisons.
     * <ul>
     *     <li>The method is declared with a generic type {@code T}, and it has a default implementation.
     *     This means that classes implementing this interface don't need to provide their own implementation of this method.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler warnings related to unchecked generic array creation.
     *     This is because arrays of generic types in Java are not type-safe, and the compiler generates warnings to indicate this.</li>
     *     <li>The method takes an array of type {@code T} as a parameter.</li>
     *     <li>The first element of the array is assigned to the min variable as the initial minimum value.</li>
     *     <li>The {@code minIndex} variable is initialized with 0, representing the index of the current minimum element.</li>
     *     <li>The method then iterates over the remaining elements of the array (starting from index 1) and compares each element to
     *     the current minimum using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     If an element is smaller than the current minimum, it becomes the new minimum, and its index becomes the new {@code minIndex}.</li>
     *     <li>Finally, the method returns the index of the minimum element found in the array.</li>
     * </ul>
     * @param       array in which to find the minimum.
     * @return      index of the minimum element found in the array.
     */
    @SuppressWarnings("unchecked")
    default int findMinIndex(T[] array) {
        T min = array[0];
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (min.compareTo(array[i]) > 0) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * {@code findIndex} within the {@code SortFunctional} interface.
     * <ul>
     *     <li>The {@code findIndex} method takes an array array of type {@code T} and an instance of {@code SortFunctional} as parameters.</li>
     *     <li>It declares a variable {@code value} and initializes it with the first element of the {@code array}, {@code array[0]}.</li>
     *     <li>It also declares a variable {@code valueIndex}
     *     and initializes it with the value <i>0</i>, representing the index of the initial value.</li>
     *     <li>The method then iterates over the remaining elements of the {@code array} using a {@code for} loop.</li>
     *     <li>Within the loop, it calls the {@code functionalCompareTo} method of
     *     the {@code SortFunctional} instance to compare {@code value} with each element of the {@code array}.</li>
     *     <li>If the comparison returns {@code true}, indicating that
     *     the current element is greater according to the comparison logic specified by the {@code functional} parameter,
     *     the {@code value} variable is updated to the current element {@code array[i]},
     *     and the valueIndex is updated to the current index {@code i}.</li>
     *     <li>After iterating through all elements of the {@code array}, the method returns the {@code valueIndex},
     *     which represents the index of the element that was found to have the maximum value according to the comparison logic.</li>
     * </ul>
     * {@code findIndex} this method is to find the index of the "maximum or minimum" element in the array according to
     * the comparison logic defined by the SortFunctional instance passed as a parameter.
     * It starts with the first element as the initial value and compares it with the remaining elements,
     * The index of the element is returned as the result.
     * @param       array in which the value index determined by the function is found.
     * @param       functional lambda expression for comparison.
     * @return      the index of the element specified by the function in the array.
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default int findIndex(T[] array, SortFunctional<T> functional) {
        T value = array[0];
        int valueIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (functional.functionalCompareTo(value, array[i])) {
                value = array[i];
                valueIndex = i;
            }
        }
        return valueIndex;
    }

    /**
     * {@code findMaxIndex} is a generic method for finding the maximum element in an array of type {@code T}.
     * The generic type {@code T} should implement
     * the Comparable interface, which allows the use of the compareTo method for comparisons.
     * <ul>
     *     <li>The method is declared with a generic type {@code T}, and it has a default implementation.
     *     This means that classes implementing this interface don't need to provide their own implementation of this method.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler warnings related to unchecked generic array creation.
     *     This is because arrays of generic types in Java are not type-safe, and the compiler generates warnings to indicate this.</li>
     *     <li>The method takes an array of type {@code T} as a parameter.</li>
     *     <li>The first element of the array is assigned to the max variable as the initial maximum value.</li>
     *     <li>The {@code maxIndex} variable is initialized with 0, representing the index of the current maximum element.</li>
     *     <li>The method then iterates over the remaining elements of the array (starting from index 1) and compares each element to
     *     the current maximum using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     If an element is greater than the current maximum, it becomes the new maximum, and its index becomes the new {@code maxIndex}.</li>
     *     <li>Finally, the method returns the index of the maximum element found in the array.</li>
     * </ul>
     * @param       array in which to find the maximum.
     * @param       to examine to the last detail
     * @return      index of the maximum element found in the array.
     */
    @SuppressWarnings("unchecked")
    default int findMaxIndex(T[] array, int to) {
        T max = array[0];
        int maxIndex = 0;
        for (int i = 1; i < to; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * {@code findMinIndex} is a generic method for finding the minimum element in an array of type {@code T}.
     * The generic type {@code T} should implement
     * the Comparable interface, which allows the use of the compareTo method for comparisons.
     * <ul>
     *     <li>The method is declared with a generic type {@code T}, and it has a default implementation.
     *     This means that classes implementing this interface don't need to provide their own implementation of this method.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler warnings related to unchecked generic array creation.
     *     This is because arrays of generic types in Java are not type-safe, and the compiler generates warnings to indicate this.</li>
     *     <li>The method takes an array of type {@code T} as a parameter.</li>
     *     <li>The first element of the array is assigned to the min variable as the initial minimum value.</li>
     *     <li>The {@code minIndex} variable is initialized with 0, representing the index of the current minimum element.</li>
     *     <li>The method then iterates over the remaining elements of the array (starting from index 1) and compares each element to
     *     the current minimum using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     If an element is smaller than the current minimum, it becomes the new minimum, and its index becomes the new {@code minIndex}.</li>
     *     <li>Finally, the method returns the index of the minimum element found in the array.</li>
     * </ul>
     * @param       array in which to find the minimum.
     * @param       to examine to the last detail
     * @return      index of the minimum element found in the array.
     */
    @SuppressWarnings("unchecked")
    default int findMinIndex(T[] array, int to) {
        T min = array[0];
        int minIndex = 0;
        for (int i = 1; i < to; i++) {
            if (min.compareTo(array[i]) > 0) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * {@code findIndex} within the {@code SortFunctional} interface.
     * <ul>
     *     <li>The {@code findIndex} method takes an array array of type {@code T} and an instance of {@code SortFunctional} as parameters.</li>
     *     <li>It declares a variable {@code value} and initializes it with the first element of the {@code array}, {@code array[0]}.</li>
     *     <li>It also declares a variable {@code valueIndex}
     *     and initializes it with the value <i>0</i>, representing the index of the initial value.</li>
     *     <li>The method then iterates over the remaining elements of the {@code array} using a {@code for} loop.</li>
     *     <li>Within the loop, it calls the {@code functionalCompareTo} method of
     *     the {@code SortFunctional} instance to compare {@code value} with each element of the {@code array}.</li>
     *     <li>If the comparison returns {@code true}, indicating that
     *     the current element is greater according to the comparison logic specified by the {@code functional} parameter,
     *     the {@code value} variable is updated to the current element {@code array[i]},
     *     and the valueIndex is updated to the current index {@code i}.</li>
     *     <li>After iterating through all elements of the {@code array}, the method returns the {@code valueIndex},
     *     which represents the index of the element that was found to have the maximum value according to the comparison logic.</li>
     * </ul>
     * {@code findIndex} this method is to find the index of the "maximum or minimum" element in the array according to
     * the comparison logic defined by the SortFunctional instance passed as a parameter.
     * It starts with the first element as the initial value and compares it with the remaining elements,
     * The index of the element is returned as the result.
     * @param       array in which the value index determined by the function is found.
     * @param       to examine to the last detail
     * @param       functional lambda expression for comparison.
     * @return      the index of the element specified by the function in the array.
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default int findIndex(T[] array, int to, SortFunctional<T> functional) {
        T value = array[0];
        int valueIndex = 0;
        for (int i = 1; i < to; i++) {
            if (functional.functionalCompareTo(value, array[i])) {
                value = array[i];
                valueIndex = i;
            }
        }
        return valueIndex;
    }

    /**
     * {@code findMaxIndex} is a generic method for finding the maximum element in an array of type {@code T}.
     * The generic type {@code T} should implement
     * the Comparable interface, which allows the use of the compareTo method for comparisons.
     * <ul>
     *     <li>The method is declared with a generic type {@code T}, and it has a default implementation.
     *     This means that classes implementing this interface don't need to provide their own implementation of this method.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler warnings related to unchecked generic array creation.
     *     This is because arrays of generic types in Java are not type-safe, and the compiler generates warnings to indicate this.</li>
     *     <li>The method takes an array of type {@code T} as a parameter.</li>
     *     <li>The first element of the array is assigned to the max variable as the initial maximum value.</li>
     *     <li>The {@code maxIndex} variable is initialized with 0, representing the index of the current maximum element.</li>
     *     <li>The method then iterates over the remaining elements of the array (starting from index 1) and compares each element to
     *     the current maximum using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     If an element is greater than the current maximum, it becomes the new maximum, and its index becomes the new {@code maxIndex}.</li>
     *     <li>Finally, the method returns the index of the maximum element found in the array.</li>
     * </ul>
     * @param       array in which to find the maximum.
     * @param       from check the array starting from this value
     * @param       to examine to the last detail
     * @return      index of the maximum element found in the array.
     */
    @SuppressWarnings("unchecked")
    default int findMaxIndex(T[] array, int from, int to) {
        T max = array[0];
        int maxIndex = 0;
        for (int i = (from + 1); i < to; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * {@code findMinIndex} is a generic method for finding the minimum element in an array of type {@code T}.
     * The generic type {@code T} should implement
     * the Comparable interface, which allows the use of the compareTo method for comparisons.
     * <ul>
     *     <li>The method is declared with a generic type {@code T}, and it has a default implementation.
     *     This means that classes implementing this interface don't need to provide their own implementation of this method.</li>
     *     <li>The {@code SuppressWarnings("unchecked")} annotation is used to suppress compiler warnings related to unchecked generic array creation.
     *     This is because arrays of generic types in Java are not type-safe, and the compiler generates warnings to indicate this.</li>
     *     <li>The method takes an array of type {@code T} as a parameter.</li>
     *     <li>The first element of the array is assigned to the min variable as the initial minimum value.</li>
     *     <li>The {@code minIndex} variable is initialized with 0, representing the index of the current minimum element.</li>
     *     <li>The method then iterates over the remaining elements of the array (starting from index 1) and compares each element to
     *     the current minimum using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.
     *     If an element is smaller than the current minimum, it becomes the new minimum, and its index becomes the new {@code minIndex}.</li>
     *     <li>Finally, the method returns the index of the minimum element found in the array.</li>
     * </ul>
     * @param       array in which to find the minimum.
     * @param       from check the array starting from this value
     * @param       to examine to the last detail
     * @return      index of the minimum element found in the array.
     */
    @SuppressWarnings("unchecked")
    default int findMinIndex(T[] array, int from, int to) {
        T min = array[0];
        int minIndex = 0;
        for (int i = (from + 1); i < to; i++) {
            if (min.compareTo(array[i]) > 0) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * {@code findIndex} within the {@code SortFunctional} interface.
     * <ul>
     *     <li>The {@code findIndex} method takes an array array of type {@code T} and an instance of {@code SortFunctional} as parameters.</li>
     *     <li>It declares a variable {@code value} and initializes it with the first element of the {@code array}, {@code array[0]}.</li>
     *     <li>It also declares a variable {@code valueIndex}
     *     and initializes it with the value <i>0</i>, representing the index of the initial value.</li>
     *     <li>The method then iterates over the remaining elements of the {@code array} using a {@code for} loop.</li>
     *     <li>Within the loop, it calls the {@code functionalCompareTo} method of
     *     the {@code SortFunctional} instance to compare {@code value} with each element of the {@code array}.</li>
     *     <li>If the comparison returns {@code true}, indicating that
     *     the current element is greater according to the comparison logic specified by the {@code functional} parameter,
     *     the {@code value} variable is updated to the current element {@code array[i]},
     *     and the valueIndex is updated to the current index {@code i}.</li>
     *     <li>After iterating through all elements of the {@code array}, the method returns the {@code valueIndex},
     *     which represents the index of the element that was found to have the maximum value according to the comparison logic.</li>
     * </ul>
     * {@code findIndex} this method is to find the index of the "maximum or minimum" element in the array according to
     * the comparison logic defined by the SortFunctional instance passed as a parameter.
     * It starts with the first element as the initial value and compares it with the remaining elements,
     * The index of the element is returned as the result.
     * @param       array in which the value index determined by the function is found.
     * @param       from check the array starting from this value
     * @param       to examine to the last detail
     * @param       functional lambda expression for comparison.
     * @return      the index of the element specified by the function in the array.
     * @see         mz.Sort.SortFunctional#functionalCompareTo(Comparable, Comparable)
     */
    default int findIndex(T[] array, int from, int to, SortFunctional<T> functional) {
        T value = array[0];
        int valueIndex = 0;
        for (int i = (from + 1); i < to; i++) {
            if (functional.functionalCompareTo(value, array[i])) {
                value = array[i];
                valueIndex = i;
            }
        }
        return valueIndex;
    }

    /**
     * {@code findMaximumIndex} that finds the b of the maximum element in a portion of an array of Comparable objects.
     * <ul>
     *     <li>The method takes in an {@code array} of Comparable objects, array, an integer {@code a} representing the current b,
     *     and an integer {@code b} representing the current b of the maximum element.</li>
     *     <li>The method compares the element at b {@code a} with the element at b {@code b} using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>If the element at b {@code a} is greater than the element at b {@code b}, the {@code if} condition evaluates to true,
     *     and the value of {@code b} is updated to {@code a}.</li>
     *     <li>The updated value of {@code b} is then returned.</li>
     * </ul>
     * {@code findMaximumIndex} method compares the element at b {@code a} with the current maximum element represented by {@code b} in
     * the given {@code array} of Comparable objects. It updates and returns the b of the maximum element if the element at b {@code a} is greater.
     * @param       array to be arranged.
     * @param       a an integer representing the current b.
     * @param       b representing the current b of the maximum element.
     * @return      the b of the maximum element.
     */
    @SuppressWarnings("unchecked")
    default int findMaximumIndex(T[] array, int a, int b) {
        if (array[b].compareTo(array[a]) < 0) {
            b = a;
        }
        return b;
    }

    /**
     * {@code findMinimumIndex} that finds the b of the minimum element in a portion of an array of Comparable objects.
     * <ul>
     *     <li>The method takes in an {@code array} of Comparable objects, array, an integer {@code a} representing the current b,
     *     and an integer {@code b} representing the current b of the minimum element.</li>
     *     <li>The method compares the element at b {@code a} with the element at b {@code b} using the {@link java.lang.Comparable#compareTo(Object) compareTo} method.</li>
     *     <li>If the element at b {@code a} is smaller than the element at b {@code b}, the {@code if} condition evaluates to true,
     *     and the value of {@code b} is updated to {@code a}.</li>
     *     <li>The updated value of {@code b} is then returned.</li>
     * </ul>
     * {@code findMinimumIndex} method compares the element at b {@code a} with the current minimum element represented by {@code b} in
     * the given {@code array} of Comparable objects. It updates and returns the b of the minimum element if the element at b {@code a} is smaller.
     * @param       array to be arranged.
     * @param       a an integer representing the current b.
     * @param       b representing the current b of the minimum element.
     * @return      the b of the minimum element.
     */
    @SuppressWarnings("unchecked")
    default int findMinimumIndex(T[] array, int a, int b) {
        if (array[b].compareTo(array[a]) > 0) {
            b = a;
        }
        return b;
    }

    /**
     * {@code findValueIndex} within the {@code SortFunctional} interface.
     * <ul>
     *     <li>The {@code findValueIndex} method takes an array {@code array} of type {@code T},
     *     two integer parameters {@code a} and {@code b}, and an instance of {@code SortFunctional} as parameters.</li>
     *     <li>The method starts with a comparison using the {@code functionalCompareTo} method of the {@code SortFunctional} instance.
     *     It compares the elements {@code array[b]} and {@code array[a]} using the comparison logic defined by the {@code functional} parameter.</li>
     *     <li>If the comparison returns {@code true},
     *     indicating that {@code array[b]} is greater than {@code array[a]} according to the comparison logic,
     *     the code block inside the {@code if} statement is executed.</li>
     *     <li>Within the {@code if} block, the value of {@code b} is updated with the value of {@code a}.
     *     This means that {@code b} now represents the index of the element that is considered greater according to the comparison logic.</li>
     *     <li>Finally, the method returns the value of {@code b}, which represents the index of the element that is considered greater according to the comparison logic.</li>
     * </ul>
     * {@code findValueIndex} this method is to compare two elements of the {@code array} based on the comparison logic defined by the {@code SortFunctional} instance.
     * It updates the value of {@code b} to the index of the element that is considered greater according to the comparison logic and returns that index.
     * @param       array to be arranged.
     * @param       a an integer representing the current b.
     * @param       b represents the current b of the element defined by the function.
     * @param       functional lambda expression for comparison.
     * @return      b of the element defined by the function.
     */
    default int findValueIndex(T[] array, int a, int b, SortFunctional<T> functional) {
        if (functional.functionalCompareTo(array[b], array[a])) {
            b = a;
        }
        return b;
    }
}