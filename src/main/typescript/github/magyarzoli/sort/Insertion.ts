import {SortComparable} from "../SortComparable";
import {InsertionInterface} from "../InsertionInterface";
import {SortFunctional} from "../SortFunctional";
import {argChecking} from "../argChecking";
import {Comparable} from "../Sort";

export class Insertion
        extends SortComparable
        implements InsertionInterface<any> {

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.insertionInc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.insertionDec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.insertion(array, functional);
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