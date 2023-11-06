import {Cocktail} from "./Cocktail";
import {Comparable} from "../Sort";
import {SortFunctional} from "../SortFunctional";
import {argChecking} from "../argChecking";

export class Comb
        extends Cocktail {

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.combInc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.combDec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.comb(array, functional);
    }

    @argChecking
    combInc(array: any[], left?: number, right?: number): void {
        let gap = right;
        let swapped = true;
        while (gap != 1 || swapped) {
            gap = this.getNextGap(gap);
            swapped = false;
            for (let i = left; i < (right - gap); i++) {
                if (this.isSwapInc(array, i, gap)) {
                    swapped = true;
                }
            }
        }
    }

    @argChecking
    combDec(array: any[], left?: number, right?: number): void {
        let gap = right;
        let swapped = true;
        while (gap != 1 || swapped) {
            gap = this.getNextGap(gap);
            swapped = false;
            for (let i = left; i < (right - gap); i++) {
                if (this.isSwapDec(array, i, gap)) {
                    swapped = true;
                }
            }
        }
    }

    @argChecking
    comb(array: any[], functional: SortFunctional<any>, left?: number, right?: number): void {
        let gap = right;
        let swapped = true;
        while (gap != 1 || swapped) {
            gap = this.getNextGap(gap);
            swapped = false;
            for (let i = left; i < (right - gap); i++) {
                if (this.isSwap(array, i, gap, functional)) swapped = true;
            }
        }
    }

    getNextGap(gap: number): number {
        gap = ((gap * 10) / 13);
        return Math.max(gap, 1);
    }
}