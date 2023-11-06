import {Selection} from "./Selection";
import {Comparable} from "../Sort";
import {SortFunctional} from "../SortFunctional";
import {argChecking} from "../argChecking";

export class Bogo
        extends Selection {

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.bogoInc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.bogoDec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.bogo(array, functional);
    }

    @argChecking
    bogoInc(array: any[], left?: number, right?: number): void {
        while (!this.isSortedInc(array, left, right)) {
            this.shuffle(array, left, right);
        }
    }

    @argChecking
    bogoDec(array: any[], left?: number, right?: number): void {
        while (!this.isSortedDec(array, left, right)) {
            this.shuffle(array, left, right);
        }
    }

    @argChecking
    bogo(array: any[], functional: SortFunctional<any>, left?: number, right?: number): void {
        while (!this.isSorted(array, functional, left, right)) {
            this.shuffle(array, left, right);
        }
    }

    @argChecking
    isSortedInc(array: any[], left?: number, right?: number): boolean {
        for (let i = (left + 1); i < right; i++) {
            if (array[(i - 1)].compareTo(array[i]) > 0) return false;
        }
        return true;
    }

    @argChecking
    isSortedDec(array: any[], left?: number, right?: number): boolean {
        for (let i = (left + 1); i < right; i++) {
            if (array[(i - 1)].compareTo(array[i]) < 0) return false;
        }
        return true;
    }

    @argChecking
    isSorted(array: any[], functional: SortFunctional<any>, left?: number, right?: number): boolean {
        for (let i = (left + 1); i < right; i++) {
            if (functional(array[(i - 1)], array[i])) return false;
        }
        return true;
    }

    @argChecking
    shuffle(array: any[], left?: number, right?: number): void {
        for (let i = (left + 1); i < right; i++) {
            this.swap(array, i, (Math.random() * i));
        }
    }
}