import {Selection} from "./Selection";
import {Comparable} from "../Sort";
import {SortFunctional} from "../SortFunctional";
import {argChecking} from "../argChecking";

export class Cocktail
        extends Selection {

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.cocktailInc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.cocktailDec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.cocktail(array, functional);
    }

    @argChecking
    cocktailInc(array: any[], left?: number, right?: number): void {
        let swapped = true;
        let start = left, end = (right - 1);
        while (swapped) {
            swapped = false;
            for (let i = start; i < end; ++i) {
                if (this.isSwapInc(array, i, 1)) swapped = true;
            }
            if (!swapped) break;
            swapped = false;
            for (let i = (--end - 1); i >= start; i--) {
                if (this.isSwapInc(array, i, 1)) swapped = true;
            }
            ++start;
        }
    }

    @argChecking
    cocktailDec(array: any[], left?: number, right?: number): void {
        let swapped = true;
        let start = left, end = (right - 1);
        while (swapped) {
            swapped = false;
            for (let i = start; i < end; ++i) {
                if (this.isSwapDec(array, i, 1)) swapped = true;
            }
            if (!swapped) break;
            swapped = false;
            for (let i = (--end - 1); i >= start; i--) {
                if (this.isSwapDec(array, i, 1)) swapped = true;
            }
            ++start;
        }
    }

    @argChecking
    cocktail(array: any[], functional: SortFunctional<any>, left?: number, right?: number): void {
        let swapped = true;
        let start = left, end = (right - 1);
        while (swapped) {
            swapped = false;
            for (let i = start; i < end; ++i) {
                if (this.isSwap(array, i, 1, functional)) swapped = true;
            }
            if (!swapped) break;
            swapped = false;
            for (let i = (--end - 1); i >= start; i--) {
                if (this.isSwap(array, i, 1, functional)) swapped = true;
            }
            ++start;
        }
    }
}