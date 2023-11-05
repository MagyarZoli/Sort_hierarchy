import {Comparable} from "./Sort";
import {SortFunctional} from "./SortFunctional";

export interface SortFind<T extends Comparable<T>> {

    findMax(array: T[], from?: number, to?: number): T;

    findMin(array: T[], from?: number, to?: number): T;

    find(array: T[], functional: SortFunctional<T>, from?: number, to?: number): T;

    findMaxIndex(array: T[], from?: number, to?: number): number;

    findMinIndex(array: T[], from?: number, to?: number): number;

    findIndex(array: T[], functional: SortFunctional<T>, from?: number, to?: number): number;

    findMaximumIndex(array: T[], a: number, b: number): number;

    findMinimumIndex(array: T[], a: number, b: number): number;

    findValueIndex(array: T[], a: number, b: number, functional: SortFunctional<T>): number;
}