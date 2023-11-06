import {Merge} from "./Merge";
import {InsertionInterface} from "../InsertionInterface";
import {argChecking} from "../argChecking";
import {SortFunctional} from "../SortFunctional";
import {Comparable} from "../Sort";

export class MergeInsertion
        extends Merge
        implements InsertionInterface<any> {

    MERGE_THRESHOLD = 10;

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.mergeInsertionInc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.mergeInsertionDec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.mergeInsertion(array, functional);
    }

    @argChecking
    mergeInsertionInc(array: any[], left?: number, right?: number): void {
        if (left < right) {
            if ((right - left) <= this.MERGE_THRESHOLD) {
                this.insertionInc(array, left, right);
            } else {
                let mid = (left + ((right - left) / 2));
                this.mergeInsertionInc(array, left, mid);
                this.mergeInsertionInc(array, (mid + 1), right);
                this.mergingInc(array, left, mid, right);
            }
        }
    }

    @argChecking
    mergeInsertionDec(array: any[], left?: number, right?: number): void {
        if (left < right) {
            if ((right - left) <= this.MERGE_THRESHOLD) {
                this.insertionDec(array, left, right);
            } else {
                let mid = (left + ((right - left) / 2));
                this.mergeInsertionDec(array, left, mid);
                this.mergeInsertionDec(array, (mid + 1), right);
                this.mergingDec(array, left, mid, right);
            }
        }
    }

    @argChecking
    mergeInsertion(array: any[], functional: SortFunctional<any>, left?: number, right?: number): void {
        if (left < right) {
            if ((right - left) <= this.MERGE_THRESHOLD) {
                this.insertion(array, functional, left, right);
            } else {
                let mid = (left + ((right - left) / 2));
                this.mergeInsertion(array, functional, left, mid);
                this.mergeInsertion(array, functional, (mid + 1), right);
                this.merging(array, functional, left, mid, right);
            }
        }
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