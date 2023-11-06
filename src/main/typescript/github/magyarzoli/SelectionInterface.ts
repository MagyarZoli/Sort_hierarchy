import {Comparable} from "./Sort";
import {SortFind} from "./SortFind";
import {Sorter} from "./Sorter";
import {SortSwap} from "./SortSwap";
import {SortFunctional} from "./SortFunctional";

export interface SelectionInterface<T extends Comparable<T>>
        extends Sorter<T>, SortSwap<T>, SortFind<T> {

    selectionInc(array: T[], from?: number, to?: number): void;

    selectionDec(array: T[], from?: number, to?: number): void;

    selection(array: T[], functional: SortFunctional<T>, from?: number, to?: number): void;
}