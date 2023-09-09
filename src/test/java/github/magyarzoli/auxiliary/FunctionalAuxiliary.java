package github.magyarzoli.auxiliary;

import github.magyarzoli.Sorter;

@FunctionalInterface
@SuppressWarnings("rawtypes")
public interface FunctionalAuxiliary<S extends Sorter<Comparable>, T extends Comparable<T>> {

     void functional(S sorter, T[] array);
}