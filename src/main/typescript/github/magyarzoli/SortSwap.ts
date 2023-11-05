import {Comparable} from "./Sort";
import {SortFunctional} from "./SortFunctional";

export interface SortSwap<T extends Comparable<T>> {

    swap(array: T[], a: number, b: number): void;

    isSwapInc(array: T[], i: number, j: number): boolean;

    isSwapDec(array:T[], i: number, j: number): boolean;

    isSwap(array: T[], i: number, j: number, functional: SortFunctional<T>): boolean;

    flip(array: T[], from?: number, to?: number): void;

    flipBetween(array: T[], from: number, to: number): void;
}