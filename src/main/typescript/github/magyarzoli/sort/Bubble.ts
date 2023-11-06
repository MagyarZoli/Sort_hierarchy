import {Selection} from "./Selection";
import {Comparable} from "../Sort";
import {SortFunctional} from "../SortFunctional";
import {argChecking} from "../argChecking";

export class Bubble
        extends Selection {

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.bubbleInc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.bubbleDec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.bubble(array, functional);
    }

    @argChecking
    bubbleInc(array: any[], left?: number, right?: number): void {
        for (let i = left; i < right; i++) {
            for (let j = 1; j < (right - i); j++) {
                if (array[(j - 1)].compareTo(array[j]) > 0) this.swap(array, (j - 1), j);
            }
        }
    }

    @argChecking
    bubbleDec(array: any[], left?: number, right?: number): void {
        for (let i = left; i < right; i++) {
            for (let j = 1; j < (right - i); j++) {
                if (array[(j - 1)].compareTo(array[j]) < 0) this.swap(array, (j - 1), j);
            }
        }
    }

    @argChecking
    bubble(array: any[], functional: SortFunctional<any>, left?: number, right?: number): void {
        for (let i = left; i < right; i++) {
            for (let j = 1; j < (right - i); j++) {
                if (functional(array[(j - 1)], array[j])) this.swap(array, (j - 1), j);
            }
        }
    }
}