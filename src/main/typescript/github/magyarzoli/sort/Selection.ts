import {SortComparable} from "../SortComparable";
import {SelectionInterface} from "../SelectionInterface";
import {SortFunctional} from "../SortFunctional";
import {argChecking} from "../argChecking";
import {Comparable} from "../Sort";

export class Selection
        extends SortComparable
        implements SelectionInterface<any> {

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.selectionInc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.selectionDec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.selection(array, functional);
    }

    @argChecking
    selectionInc(array: any[], from?: number, to?: number): void {
        for (let i = from; i < (to - 1); i++) {
            let index = i;
            for (let j = (i + 1); j < to; j++) {
                index = this.findMinimumIndex(array, j, index);
            }
            this.swap(array, index, i);
        }
    }

    @argChecking
    selectionDec(array: any[], from?: number, to?: number): void {
        for (let i = from; i < (to - 1); i++) {
            let index = i;
            for (let j = (i + 1); j < to; j++) {
                index = this.findMaximumIndex(array, j, index);
            }
            this.swap(array, index, i);
        }
    }

    @argChecking
    selection(array: any[], functional: SortFunctional<any>, from?: number, to?: number): void {
        for (let i = from; i < (to - 1); i++) {
            let index = i;
            for (let j = (i + 1) ; j < to; j++) {
                index = this.findValueIndex(array, j, index, functional);
            }
            this.swap(array, index, i);
        }
    }

    swap(array: any[], a: number, b: number): void {
        let select = array[a];
        array[a] = array[b];
        array[b] = select;
    }

    isSwapInc(array: any[], i: number, j: number): boolean {
        if (array[i].compareTo(array[(i + j)]) > 0) {
            this.swap(array, i, (i + j));
            return true;
        }
        return false;
    }

    isSwapDec(array: any[], i: number, j: number): boolean {
        if (array[i].compareTo(array[(i + j)]) < 0) {
            this.swap(array, i, (i + j));
            return true;
        }
        return false;
    }

    isSwap(array: any[], i: number, j: number, functional: SortFunctional<any>): boolean {
        if (functional(array[i], array[(i + j)])) {
            this.swap(array, i, (i + j));
            return true;
        }
        return false;
    }

    flip(array: any[],from?: number, to?: number): void {
        while (from < to) {
            this.swap(array, from++, to--);
        }
    }

    flipBetween(array: any[], from: number, to: number): void {
        while (from < to) {
            this.swap(array, from++, to--);
        }
    }

    @argChecking
    findMax(array: any[], from?: number, to?: number): any {
        let max = array[0];
        for (let i = (from + 1); i < to; i++) {
            if (max.compareTo(array[i]) < 0) max = array[i];
        }
        return max;
    }

    @argChecking
    findMin(array: any[], from?: number, to?: number): any {
        let min = array[0];
        for (let i = (from + 1); i < to; i++) {
            if (min.compareTo(array[i]) > 0) min = array[i];
        }
        return min;
    }

    @argChecking
    find(array: any[], functional: SortFunctional<any>, from?: number, to?: number): any {
        let value = array[0];
        for (let i = (from + 1); i < to; i++) {
            if (functional(value, array[i])) value = array[i];
        }
        return value;
    }

    @argChecking
    findMaxIndex(array: any[], from?: number, to?: number) {
        let max = array[0];
        let maxIndex = 0;
        for (let i = (from + 1); i < to; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    @argChecking
    findMinIndex(array: any[], from?: number, to?: number): number {
        let min = array[0];
        let maxIndex = 0;
        for (let i = (from + 1); i < to; i++) {
            if (min.compareTo(array[i]) > 0) {
                min = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    @argChecking
    findIndex(array: any[], functional: SortFunctional<any>, from?: number, to?: number): number {
        let value = array[0];
        let valueIndex = 0;
        for (let i = (from + 1); i < to; i++) {
            if (functional(value, array[i])) {
                value = array[i];
                valueIndex = i;
            }
        }
        return valueIndex;
    }

    findMaximumIndex(array: any[], a: number, b: number): number {
        return array[b].compareTo(array[a]) < 0 ? a : b;
    }

    findMinimumIndex(array: any[], a: number, b: number): number {
        return array[b].compareTo(array[a]) > 0 ? a : b;
    }

    findValueIndex(array: any[], a: number, b: number, functional: SortFunctional<any>): number {
        return functional(array[b], array[a]) ? a : b;
    }
}