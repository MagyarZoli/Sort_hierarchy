import {Selection} from "./Selection";
import {Comparable} from "../Sort";
import {SortFunctional} from "../SortFunctional";
import {argChecking} from "../argChecking";

export class DoubleSelection
        extends Selection {

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.doubleSelectionInc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.doubleSelectionDec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.doubleSelection(array, functional);
    }

    @argChecking
    doubleSelectionInc(array: any[], left?: number, right?: number): void {
        while (left < right) {
            let minIndex = left, maxIndex = right;
            for (let j = left; j <= right; j++) {
                minIndex = this.findMinimumIndex(array, j, minIndex);
                maxIndex = this.findMaximumIndex(array, j, maxIndex);
            }
            this.swap(array, minIndex, left);
            if (maxIndex == left) maxIndex = minIndex;
            this.swap(array, maxIndex, right--);
            left++;
        }
    }

    @argChecking
    doubleSelectionDec(array: any[], left?: number, right?: number): void {
        while (left < right) {
            let minIndex = left, maxIndex = right;
            for (let j = left; j <= right; j++) {
                minIndex = this.findMinimumIndex(array, j, minIndex);
                maxIndex = this.findMaximumIndex(array, j, maxIndex);
            }
            this.swap(array, maxIndex, left);
            if (minIndex == left) minIndex = maxIndex;
            this.swap(array, minIndex, right--);
            left++;
        }
    }

    @argChecking
    doubleSelection(array: any[], functional: SortFunctional<any>, left?: number, right?: number): void {
        while (left < right) {
            let valueIndex = left, valueReverseIndex = right;
            let functionalReverse: SortFunctional<any> = this.functionalComparableToReverse(functional);
            for (let j = left; j <= right; j++) {
                valueIndex = this.findValueIndex(array, j, valueIndex, functional);
                valueReverseIndex = this.findValueIndex(array, j, valueReverseIndex, functionalReverse);
            }
            this.swap(array, valueReverseIndex, left);
            if (valueIndex == left) valueIndex = valueReverseIndex;
            this.swap(array, valueIndex, right--);
            left++;
        }
    }
}