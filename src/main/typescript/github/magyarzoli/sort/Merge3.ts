import {Merge} from "./Merge";
import {Comparable} from "../Sort";
import {SortFunctional} from "../SortFunctional";

export class Merge3
        extends Merge {

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.merge3Inc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.merge3Dec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.merge3(array, functional);
    }

    mergeV3Inc(array: any[], left: number, right: number, buffer: any[]): void {
        if ((right - left) < 2) return;
        let mid1 = (left + ((right - left) / 3)), mid2 = (left + (2 * ((right - left) / 3)) + 1);
        this.mergeV3Inc(buffer, left, mid1, array);
        this.mergeV3Inc(buffer, mid1, mid2, array);
        this.mergeV3Inc(buffer, mid2, right, array);
        this.mergeV4Inc(buffer, left, mid1, mid2, right, array);
    }

    mergeV3Dec(array: any[], left: number, right: number, buffer: any[]): void {
        if ((right - left) < 2) return;
        let mid1 = (left + ((right - left) / 3)), mid2 = (left + (2 * ((right - left) / 3)) + 1);
        this.mergeV3Dec(buffer, left, mid1, array);
        this.mergeV3Dec(buffer, mid1, mid2, array);
        this.mergeV3Dec(buffer, mid2, right, array);
        this.mergeV4Dec(buffer, left, mid1, mid2, right, array);
    }

    mergeV3(array: any[], functional: SortFunctional<any>, left: number, right: number, buffer: any[]): void {
        if ((right - left) < 2) return;
        let mid1 = (left + ((right - left) / 3)), mid2 = (left + (2 * ((right - left) / 3)) + 1);
        this.mergeV3(buffer, functional, left, mid1, array);
        this.mergeV3(buffer, functional, mid1, mid2, array);
        this.mergeV3(buffer, functional, mid2, right, array);
        this.mergeV4(buffer, functional, left, mid1, mid2, right, array);
    }

    merge3Inc(array: any[]): void {
        let buffer = [...array];
        this.mergeV3Inc(buffer, 0, array.length, array);
        for (let i = 0; i < buffer.length; i++) array[i] = buffer[i];
    }

    merge3Dec(array: any[]): void {
        let buffer = [...array];
        this.mergeV3Dec(buffer, 0, array.length, array);
        for (let i = 0; i < buffer.length; i++) array[i] = buffer[i];
    }

    merge3(array: any[], functional: SortFunctional<any>): void {
        let buffer = [...array];
        this.mergeV3(buffer, functional, 0, array.length, array);
        for (let i = 0; i < buffer.length; i++) array[i] = buffer[i];
    }
}
