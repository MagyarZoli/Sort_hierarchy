import {Comparable, Sort} from "./Sort";
import {SortFunctional} from "./SortFunctional";
import {SortType} from "./SortType";

export interface Sorter<T extends Comparable<T>>
        extends Sort<T> {

    sortArrayInc(array: T[]): void;

    sortArrayDec(array: T[]): void;

    sortArrayFun(array: T[], functional: SortFunctional<T>): void;

    sortArrayRev(array: T[]): void;

    sortArray(array: T[], type: number | SortType): void;
}