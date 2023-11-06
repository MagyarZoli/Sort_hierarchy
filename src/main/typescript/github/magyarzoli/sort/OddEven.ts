import {Bubble} from "./Bubble";
import {Comparable} from "../Sort";
import {SortFunctional} from "../SortFunctional";
import {argChecking} from "../argChecking";

export class OddEven
        extends Bubble {

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
    oddEvenInc(array: any[], left?: number, right?: number): void {
        let isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = this.indexedElementInc(array, (left + 1), right);
            isSorted = this.indexedElementInc(array, left, right);
        }
    }

    @argChecking
    oddEvenDec(array: any[], left?: number, right?: number): void {
        let isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = this.indexedElementDec(array, (left + 1), right);
            isSorted = this.indexedElementDec(array, left, right);
        }
    }

    @argChecking
    oddEven(array: any[], functional: SortFunctional<any>, left?: number, right?: number): void {
        let isSorted = false;
        while (!isSorted) {
            isSorted = true;
            isSorted = this.indexedElement(array, functional, (left + 1), right);
            isSorted = this.indexedElement(array, functional, left, right);
        }
    }

    indexedElementInc(array: any[], j: number, n: number): boolean {
        let element = true;
        for (let i = j; i <= (n - 2); i += 2) {
            if (this.isSwapInc(array, i, 1)) element = false;
        }
        return element;
    }

    indexedElementDec(array: any[], j: number, n: number): boolean {
        let element = true;
        for (let i = j; i <= (n - 2); i += 2) {
            if (this.isSwapDec(array, i, 1)) element = false;
        }
        return element;
    }

    indexedElement(array: any[], functional: SortFunctional<any>, j: number, n: number): boolean {
        let element = true;
        for (let i = j; i <= (n - 2); i += 2) {
            if (this.isSwap(array, i, 1, functional)) element = false;
        }
        return element;
    }
}