import {Merge} from "./Merge";
import {Comparable} from "../Sort";
import {SortFunctional} from "../SortFunctional";
import {argChecking} from "../argChecking";

export class MergeInPlace
        extends Merge {

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.mergeInc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.mergeDec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.merge(array, functional);
    }

    @argChecking
    mergingInc(array: any[], left?: number, mid?: number, right?: number): void {
        let start = (mid + 1);
        if (array[start].compareTo(array[mid]) >= 0) return;
        while ((left <= mid) && (start <= right)) {
            if (array[start].compareTo(array[left]) >= 0) {
                left++;
            } else {
                let value = array[start];
                let index = start;
                while (index != left) {
                    array[index] = array[(index - 1)];
                    index--;
                }
                array[left++] = value;
                mid++;
                start++;
            }
        }
    }

    @argChecking
    mergingDec(array: any[], left?: number, mid?: number, right?: number): void {
        let start = (mid + 1);
        if (array[start].compareTo(array[mid]) <= 0) return;
        while ((left <= mid) && (start <= right)) {
            if (array[start].compareTo(array[left]) <= 0) {
                left++;
            } else {
                let value = array[start];
                let index = start;
                while (index != left) {
                    array[index] = array[(index - 1)];
                    index--;
                }
                array[left++] = value;
                mid++;
                start++;
            }
        }
    }

    @argChecking
    merging(array: any[], functional: SortFunctional<any>, left?: number, mid?: number, right?: number): void {
        let start = (mid + 1);
        let functionalAddEquals: SortFunctional<any> = this.functionalComparableToAddEquals(functional);
            if (functionalAddEquals(array[start], array[mid])) return;
            while ((left <= mid) && (start <= right)) {
                if (functionalAddEquals(array[start],array[left])) {
                    left++;
                } else {
                    let value = array[start];
                    let index = start;
                    while (index != left) {
                        array[index] = array[(index - 1)];
                        index--;
                    }
                array[left++] = value;
                mid++;
                start++;
            }
        }
    }
}