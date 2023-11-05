import {Comparable} from "./Sort";
import {Sorter} from "./Sorter";
import {SortFunctional} from "./SortFunctional";

export interface InsertionInterface<T extends Comparable<T>>
        extends Sorter<T> {

    insertionInc(array: T[], from?: number, to?: number): void;

    insertionDec(array: T[], from?: number, to?: number): void;

    insertion(array: T[], functional:SortFunctional<T>, from?: number, to?: number): void;
}