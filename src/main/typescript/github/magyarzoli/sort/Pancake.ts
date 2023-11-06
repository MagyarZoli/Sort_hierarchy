import {Selection} from "./Selection";
import {Comparable} from "../Sort";
import {SortFunctional} from "../SortFunctional";
import {argChecking} from "../argChecking";

export class Pancake
        extends Selection {

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.pancakeInc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.pancakeDec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.pancake(array, functional);
    }

    @argChecking
    pancakeInc(array: any[], left?: number, right?: number): void {
        for (let i = right; i > (left + 1); i--) {
            let max = this.findMaxIndex(array, left, i);
            if (max != (i - 1)) {
                this.flip(array, left, max);
                this.flip(array, left, (i - 1));
            }
        }
    }

    @argChecking
    pancakeDec(array: any[], left?: number, right?: number): void {
        for (let i = right; i > (left + 1); i--) {
            let min = this.findMinIndex(array, left, i);
            if (min != (i - 1)) {
                this.flip(array, left, min);
                this.flip(array, left, (i - 1));
            }
        }
    }

    @argChecking
    pancake(array: any[], functional: SortFunctional<any>, left?: number, right?: number): void {
        for (let i = right; i > (left + 1); i--) {
            let value = this.findIndex(array, functional, left, i);
            if (value != (i - 1)) {
                this.flip(array, left, value);
                this.flip(array, left, (i - 1));
            }
        }
    }
}