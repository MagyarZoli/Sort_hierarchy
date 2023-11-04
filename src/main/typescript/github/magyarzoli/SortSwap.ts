import {Comparable} from "./Sort";
import {SortFunctional} from "./SortFunctional";

export class SortSwap<T extends Comparable<T>> {

    private constructor() {
    }

    swap(array: T[], a: number, b: number): void {
        let select = array[a];
        array[a] = array[b];
        array[b] = select;
    }

    isSwapInc(array: T[], i: number, j: number): boolean {
        if (array[i].compareTo(array[(i + j)]) > 0) {
            this.swap(array, i, (i + j));
            return true;
        }
        return false;
    }

    isSwapDec(array:T[], i: number, j: number): boolean {
        if (array[i].compareTo(array[(i + j)]) < 0) {
            this.swap(array, i, (i + j));
            return true;
        }
        return false;
    }

    isSwap(array: T[], i: number, j: number, functional: SortFunctional<T>): boolean {
        if (functional(array[i], array[(i + j)])) {
            this.swap(array, i, (i + j));
            return true;
        }
        return false;
    }

    flipTo(array: T[], to: number): void {
        let from = 0;
        while (from < to) {
            this.swap(array, from++, to--);
        }
    }

    flipBetween(array: T[], from: number, to: number): void {
        while (from < to) {
            this.swap(array, from++, to--);
        }
    }
}