import {Comparable} from "./Sort";
import {Sorter} from "./Sorter";
import {SortFunctional} from "./SortFunctional";

export interface MergeInterface<T extends Comparable<T>>
        extends Sorter<T> {

    mergeInc(array: T[], left?: number, mid?: number, right?: number): void;

    mergeDec(array: T[], left?: number, mid?: number, right?: number): void;

    merge(array: T[], functional: SortFunctional<T>, left?: number, mid?: number, right?: number): void;

    mergeV2Inc(array: T[], left?: number, right?: number): void;

    mergeV2Dec(array: T[], left?: number, right?: number): void;

    mergeV2(array: T[], functional: SortFunctional<T>, left?: number, right?: number): void;

    mergeV3Inc(array: T[], left: number, right: number, buffer: T[]): void;

    mergeV3Dec(array: T[], left: number, right: number, buffer: T[]): void;

    mergeV3(array: T[], functional: SortFunctional<T>, left: number, right: number, buffer: T[]): void;

    mergeV4Inc(array: T[], left: number, mid1: number, mid2: number, right: number, buffer: T[]): void;

    mergeV4Dec(array: T[], left: number, mid1: number, mid2: number, right: number, buffer: T[]): void;

    mergeV4(array: T[], functional: SortFunctional<T>, left: number, mid1: number, mid2: number, right: number, buffer: T[]): void;

    mergingInc(array: T[], left: number, mid: number, right: number): void;

    mergingDec(array: T[], left: number, mid: number, right: number): void;

    merging(array: T[], functional: SortFunctional<T>, left: number, mid: number, right: number): void;

    mergingV3Inc(array: T[], left: number, mid: number, right: number, buffer: T[]): void;

    mergingV3Dec(array: T[], left: number, mid: number, right: number, buffer: T[]): void;

    mergingV3(array: T[], functional: SortFunctional<T>, left: number, mid: number, right: number, buffer: T[]): void;

    mergingArraysInc(array: T[], leftArray: T[], rightArray: T[]): void;

    mergingArraysDec(array: T[], leftArray: T[], rightArray: T[]): void;

    mergingArrays(array: T[], functional: SortFunctional<T>, leftArray: T[], rightArray: T[]): void;
}