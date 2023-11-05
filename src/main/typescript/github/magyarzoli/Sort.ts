import {SortFunctional} from "./SortFunctional";

export interface Comparable<T> {
    compareTo(other: T): number;
}

export interface Sort<T extends Comparable<T>> {

    INC: number;
    DEC: number;
    NOT: number;
    REV: number;

    functionalComparableToAddEquals(functional: SortFunctional<T>): SortFunctional<T>;

    functionalComparableToRemoveEquals(functional: SortFunctional<T>): SortFunctional<T>;

    functionalComparableToReverse(functional: SortFunctional<T>): SortFunctional<T>;

    scanFunctionalComparableTo(functional: SortFunctional<T | number>): number;
}