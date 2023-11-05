import {Insertion} from "./Insertion";
import {SortFunctional} from "../SortFunctional";
import {argChecking} from "../argChecking";
import {Comparable} from "../Sort";

export class Shell
        extends Insertion {

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.shellInc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.shellDec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.shell(array, functional);
    }

    @argChecking
    shellInc(array: any[], left?: number, right?: number) {
        for (let i = (right / 2); i > left; i /= 2) {
            this.insertionInc(array, left, right);
        }
    }

    @argChecking
    shellDec(array: any[], left?: number, right?: number) {
        for (let i = (right / 2); i > left; i /= 2) {
            this.insertionDec(array, i, right);
        }
    }

    @argChecking
    shell(array: any[], functional: SortFunctional<any>, left?: number, right?: number) {
        for (let i = (right / 2); i > left; i /= 2) {
            this.insertion(array, functional, i, right);
        }
    }
}