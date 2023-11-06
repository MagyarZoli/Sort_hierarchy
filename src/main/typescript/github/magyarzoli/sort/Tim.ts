import {Merge} from "./Merge";
import {InsertionInterface} from "../InsertionInterface";
import {SortFunctional} from "../SortFunctional";
import {argChecking} from "../argChecking";
import {Comparable} from "../Sort";

export class Tim
        extends Merge
        implements InsertionInterface<any> {

    MIN_MERGE = 32;

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.timInc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.timDec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.tim(array, functional);
    }

    @argChecking
    timInc(array: any[], left?: number, right?: number): void {
        let minRun = this.minRunLength(this.MIN_MERGE);
        for (let i = 0; i < right; i += minRun) {
            this.insertionInc(array, i, (Math.min((i + this.MIN_MERGE), right) - 1));
        }
        for (let size = minRun; size < right; size *= 2) {
            for (let i = left; i < right; i += (2 * size)) {
                let mid = (i + size - 1), j = (Math.min(i + (2 * size), right) - 1);
                if (mid < j) this.mergeInc(array, i, mid, j);
            }
        }
    }

    @argChecking
    timDec(array: any[], left?: number, right?: number): void {
        let minRun = this.minRunLength(this.MIN_MERGE);
        for (let i = 0; i < right; i += minRun) {
            this.insertionDec(array, i, (Math.min((i + this.MIN_MERGE), right) - 1));
        }
        for (let size = minRun; size < right; size *= 2) {
            for (let i = left; i < right; i += (2 * size)) {
                let mid = (i + size - 1), j = (Math.min(i + (2 * size), right) - 1);
                if (mid < j) this.mergeDec(array, i, mid, j);
            }
        }
    }

    @argChecking
    tim(array: any[], functional: SortFunctional<any>, left?: number, right?: number) {
        let minRun = this.minRunLength(this.MIN_MERGE);
        for (let i = 0; i < right; i += minRun) {
            this.insertion(array, functional, i, (Math.min((i + this.MIN_MERGE), right) - 1));
        }
        for (let size = minRun; size < right; size *= 2) {
            for (let i = left; i < right; i += (2 * size)) {
                let mid = (i + size - 1), j = (Math.min(i + (2 * size), right) - 1);
                if (mid < j) this.merge(array, functional, i, mid, j);
            }
        }
    }

    minRunLength(n: number): number {
        if (n < 0) return;
        let r = 0;
        while (n >= this.MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return (n + r);
    }

    @argChecking
    insertionInc(array: any[], from?: number, to?: number): void {
        for (let i = from; i <= to; i++) {
            let select = array[i];
            let j = i;
            while ((j > from)
                    && ((array[(j - 1)] != null)
                    && (array[(j - 1)].compareTo(select) > 0))) {
                array[j] = array[(j - 1)];
                j--;
            }
            array[j] = select;
        }
    }

    @argChecking
    insertionDec(array: any[], from?: number, to?: number): void {
        for (let i = from; i <= to; i++) {
            let select = array[i];
            let j = i;
            while ((j > from)
                    && ((array[(j - 1)] != null)
                    && (array[(j - 1)].compareTo(select) < 0))) {
                array[j] = array[(j - 1)];
                j--;
            }
            array[j] = select;
        }
    }

    @argChecking
    insertion(array: any[], functional:SortFunctional<any>, from?: number, to?: number): void {
        for (let i = from; i <= to; i++) {
            let select = array[i];
            let j = i;
            while ((j > from)
                    && ((array[(j - 1)] != null)
                    && (functional(array[(j - 1)], select)))) {
                array[j] = array[(j - 1)];
                j--;
            }
            array[j] = select;
        }
    }
}