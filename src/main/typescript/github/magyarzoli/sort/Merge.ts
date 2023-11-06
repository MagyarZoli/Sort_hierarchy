import {SortComparable} from "../SortComparable";
import {MergeInterface} from "../MergeInterface";
import {SortFunctional} from "../SortFunctional";
import {Comparable} from "../Sort";
import {argChecking} from "../argChecking";

export class Merge
        extends SortComparable
        implements MergeInterface<any> {

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
    mergeInc(array: any[], left?: number, mid?: number, right?: number): void {
        if (left < right) {
            this.mergeInc(array, left, ((left + mid) / 2), mid);
            this.mergeInc(array, (mid + 1), (((mid + 1) + right) / 2), right);
            this.mergingInc(array, left, mid, right);
        }
    }

    @argChecking
    mergeDec(array: any[], left?: number, mid?: number, right?: number): void {
        if (left < right) {
            this.mergeDec(array, left, ((left + mid) / 2), mid);
            this.mergeDec(array, (mid + 1), (((mid + 1) + right) / 2), right);
            this.mergingDec(array, left, mid, right);
        }
    }

    @argChecking
    merge(array: any[], functional: SortFunctional<any>, left?: number, mid?: number, right?: number): void {
        if (left < right) {
            this.merge(array, functional, left, ((left + mid) / 2), mid);
            this.merge(array, functional, (mid + 1), (((mid + 1) + right) / 2), right);
            this.merging(array, functional, left, mid, right);
        }
    }

    @argChecking
    mergeV2Inc(array: any[], left?: number, right?: number): void {
        while (left < right) {
            for (let i = 0; i < right; i += (left * 2)) {
                let mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                this.mergingInc(array, i, mid, end);
            }
            left *= 2;
        }
    }

    @argChecking
    mergeV2Dec(array: any[], left?: number, right?: number): void {
        while (left < right) {
            for (let i = 0; i < right; i += (left * 2)) {
                let mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                this.mergingDec(array, i, mid, end);
            }
            left *= 2;
        }
    }

    @argChecking
    mergeV2(array: any[], functional: SortFunctional<any>, left?: number, right?: number): void {
        while (left < right) {
            for (let i = 0; i < right; i += (left * 2)) {
                let mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                this.merging(array, functional, i, mid, end);
            }
            left *= 2;
        }
    }

    mergeV3Inc(array: any[], left: number, right: number, buffer: any[]): void {
        while (left < right) {
            for (let i = 0; i < right; i += (left * 2)) {
                let mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                this.mergingV3Inc(array, i, mid, end, buffer);
            }
            left *= 2;
        }
    }

    mergeV3Dec(array: any[], left: number, right: number, buffer: any[]): void {
        while (left < right) {
            for (let i = 0; i < right; i += (left * 2)) {
                let mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                this.mergingV3Dec(array, i, mid, end, buffer);
            }
            left *= 2;
        }
    }

    mergeV3(array: any[], functional: SortFunctional<any>, left: number, right: number, buffer: any[]): void {
        while (left < right) {
            for (let i = 0; i < right; i += (left * 2)) {
                let mid = (i + left - 1), end = Math.min((i + (left * 2) - 1), (right - 1));
                this.mergingV3(array, functional, i, mid, end, buffer);
            }
            left *= 2;
        }
    }

    mergeV4Inc(array: any[], left: number, mid1: number, mid2: number, right: number, buffer: any[]): void {
        let i = left, j = mid1, k = mid2, l = left;
        while ((i < mid1) && (j < mid2) && (k < right)) {
            if (array[j].compareTo(array[i]) > 0) {
                if (array[k].compareTo(array[i]) > 0) buffer[l++] = array[i++];
                else buffer[l++] = array[k++];
            } else {
                if (array[k].compareTo(array[j]) > 0) buffer[l++] = array[j++];
                else buffer[l++] = array[k++];
            }
        }
        while ((i < mid1) && (j < mid2)) {
            if (array[j].compareTo(array[i]) > 0) buffer[l++] = array[i++];
            else buffer[l++] = array[j++];
        }
        while ((j < mid2) && (k < right)) {
            if (array[k].compareTo(array[j]) > 0) buffer[l++] = array[j++];
            else buffer[l++] = array[k++];
        }
        while ((i < mid1) && (k < right)) {
            if (array[k].compareTo(array[i]) > 0) buffer[l++] = array[i++];
            else buffer[l++] = array[k++];
        }
        while (i < mid1) buffer[l++] = array[i++];
        while (j < mid2) buffer[l++] = array[j++];
        while (k < right) buffer[l++] = array[k++];
    }

    mergeV4Dec(array: any[], left: number, mid1: number, mid2: number, right: number, buffer: any[]): void {
        let i = left, j = mid1, k = mid2, l = left;
        while ((i < mid1) && (j < mid2) && (k < right)) {
            if (array[j].compareTo(array[i]) < 0) {
                if (array[k].compareTo(array[i]) < 0) buffer[l++] = array[i++];
                else buffer[l++] = array[k++];
            } else {
                if (array[k].compareTo(array[j]) < 0) buffer[l++] = array[j++];
                else buffer[l++] = array[k++];
            }
        }
        while ((i < mid1) && (j < mid2)) {
            if (array[j].compareTo(array[i]) < 0) buffer[l++] = array[i++];
            else buffer[l++] = array[j++];
        }
        while ((j < mid2) && (k < right)) {
            if (array[k].compareTo(array[j]) < 0) buffer[l++] = array[j++];
            else buffer[l++] = array[k++];
        }
        while ((i < mid1) && (k < right)) {
            if (array[k].compareTo(array[i]) < 0) buffer[l++] = array[i++];
            else buffer[l++] = array[k++];
        }
        while (i < mid1) buffer[l++] = array[i++];
        while (j < mid2) buffer[l++] = array[j++];
        while (k < right) buffer[l++] = array[k++];
    }

    mergeV4(array: any[], functional: SortFunctional<any>, left: number, mid1: number, mid2: number, right: number, buffer: any[]): void {
        let i = left, j = mid1, k = mid2, l = left;
        while ((i < mid1) && (j < mid2) && (k < right)) {
            if (functional(array[j], array[i])) {
                if (functional(array[k], array[i])) buffer[l++] = array[i++];
                else buffer[l++] = array[k++];
            } else {
                if (functional(array[k], array[j])) buffer[l++] = array[j++];
                else buffer[l++] = array[k++];
            }
        }
        while ((i < mid1) && (j < mid2)) {
            if (functional(array[j], array[i])) buffer[l++] = array[i++];
            else buffer[l++] = array[j++];
        }
        while ((j < mid2) && (k < right)) {
            if (functional(array[k], array[j])) buffer[l++] = array[j++];
            else buffer[l++] = array[k++];
        }
        while ((i < mid1) && (k < right)) {
            if (functional(array[k], array[i])) buffer[l++] = array[i++];
            else buffer[l++] = array[k++];
        }
        while (i < mid1) buffer[l++] = array[i++];
        while (j < mid2) buffer[l++] = array[j++];
        while (k < right) buffer[l++] = array[k++];
    }

    mergingInc(array: any[], left: number, mid: number, right: number): void {
        if ((left > mid) || ((mid + 1) > right)) return;
        let n1 = (mid - left + 1), n2 = (right - mid), i = 0, j = 0, k = left;
        let leftArray = () => {
            let a = [];
            for (let i = 0; i < (mid + 1) - left; i++) a[i] = array[left + i];
            return a;
        };
        let rightArray = () => {
            let a = [];
            for (let i = 0; i < (right + 1) - (mid + 1); i++) a[i] = array[(mid + 1) + i];
            return a;
        };
        while (i < n1 && j < n2) {
            if (rightArray[j].compareTo(leftArray[i]) > 0) array[k] = leftArray[i++];
            else array[k] = rightArray[j++];
            k++;
        }
        while (i < n1) array[k++] = leftArray[i++];
        while (j < n2) array[k++] = rightArray[j++];
    }

    mergingDec(array: any[], left: number, mid: number, right: number): void {
        if ((left > mid) || ((mid + 1) > right)) return;
        let n1 = (mid - left + 1), n2 = (right - mid), i = 0, j = 0, k = left;
        let leftArray = () => {
            let a = [];
            for (let i = 0; i < (mid + 1) - left; i++) a[i] = array[left + i];
            return a;
        };
        let rightArray = () => {
            let a = [];
            for (let i = 0; i < (right + 1) - (mid + 1); i++) a[i] = array[(mid + 1) + i];
            return a;
        };
        while (i < n1 && j < n2) {
            if (rightArray[j].compareTo(leftArray[i]) < 0) array[k] = leftArray[i++];
            else array[k] = rightArray[j++];
            k++;
        }
        while (i < n1) array[k++] = leftArray[i++];
        while (j < n2) array[k++] = rightArray[j++];
    }

    merging(array: any[], functional: SortFunctional<any>, left: number, mid: number, right: number): void {
        if ((left > mid) || ((mid + 1) > right)) return;
        let n1 = (mid - left + 1), n2 = (right - mid), i = 0, j = 0, k = left;
        let leftArray = () => {
            let a = [];
            for (let i = 0; i < (mid + 1) - left; i++) a[i] = array[left + i];
            return a;
        };
        let rightArray = () => {
            let a = [];
            for (let i = 0; i < (right + 1) - (mid + 1); i++) a[i] = array[(mid + 1) + i];
            return a;
        };
        while (i < n1 && j < n2) {
            if (functional(rightArray[j], leftArray[i])) array[k] = leftArray[i++];
            else array[k] = rightArray[j++];
            k++;
        }
        while (i < n1) array[k++] = leftArray[i++];
        while (j < n2) array[k++] = rightArray[j++];
    }

    mergingV3Inc(array: any[], left: number, mid: number, right: number, buffer: any[]): void {
        let n1 = left, n2 = (mid + 1);
        for (let i = left; i <= right; i++) {
            if ((n1 <= mid) && ((n2 > right) || (array[n2].compareTo(array[n1]) >= 0))) buffer[i] = array[n1++];
            else buffer[i] = array[n2++];
        }
        for (let i = 0; i < (right - left + 1); i++) buffer[left + i] = array[left + i];
    }

    mergingV3Dec(array: any[], left: number, mid: number, right: number, buffer: any[]): void {
        let n1 = left, n2 = (mid + 1);
        for (let i = left; i <= right; i++) {
            if ((n1 <= mid) && ((n2 > right) || (array[n2].compareTo(array[n1]) <= 0))) buffer[i] = array[n1++];
            else buffer[i] = array[n2++];
        }
        for (let i = 0; i < (right - left + 1); i++) buffer[left + i] = array[left + i];
    }

    mergingV3(array: any[], functional: SortFunctional<any>, left: number, mid: number, right: number, buffer: any[]): void {
        let n1 = left, n2 = (mid + 1);
        let functionalAddEquals: SortFunctional<any> = this.functionalComparableToAddEquals(functional);
        for (let i = left; i <= right; i++) {
            if ((n1 <= mid) && ((n2 > right) || (functionalAddEquals(array[n2], array[n1])))) buffer[i] = array[n1++];
            else buffer[i] = array[n2++];
        }
        for (let i = 0; i < (right - left + 1); i++) buffer[left + i] = array[left + i];
    }

    mergingArraysInc(array: any[], leftArray: any[], rightArray: any[]): void {
        let i = 0, j = 0, k = 0;
        while ((i < leftArray.length) && (j < rightArray.length)) {
            if (rightArray[j].compareTo(leftArray[i]) > 0) array[k++] = leftArray[i++];
            else array[k++] = rightArray[j++];
        }
        while (i < leftArray.length) array[k++] = leftArray[i++];
        while (j < rightArray.length) array[k++] = rightArray[j++];
    }

    mergingArraysDec(array: any[], leftArray: any[], rightArray: any[]): void {
        let i = 0, j = 0, k = 0;
        while ((i < leftArray.length) && (j < rightArray.length)) {
            if (rightArray[j].compareTo(leftArray[i]) < 0) array[k++] = leftArray[i++];
            else array[k++] = rightArray[j++];
        }
        while (i < leftArray.length) array[k++] = leftArray[i++];
        while (j < rightArray.length) array[k++] = rightArray[j++];
    }

    mergingArrays(array: any[], functional: SortFunctional<any>, leftArray: any[], rightArray: any[]): void {
        let i = 0, j = 0, k = 0;
        while ((i < leftArray.length) && (j < rightArray.length)) {
            if (functional(rightArray[j], leftArray[i])) array[k++] = leftArray[i++];
            else array[k++] = rightArray[j++];
        }
        while (i < leftArray.length) array[k++] = leftArray[i++];
        while (j < rightArray.length) array[k++] = rightArray[j++];
    }
}