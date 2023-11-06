import {Bogo} from "./Bogo";
import {argChecking} from "../argChecking";
import {SortFunctional} from "../SortFunctional";

export class Bozo
        extends Bogo {

    constructor() {
        super();
    }

    @argChecking
    bogoInc(array: any[], left?: number, right?: number): void {
        while (!this.isSortedInc(array, left, right)) {
            this.shuffleIndex(array, left, right);
        }
    }

    @argChecking
    bogoDec(array: any[], left?: number, right?: number): void {
        while (!this.isSortedDec(array, left, right)) {
            this.shuffleIndex(array, left, right);
        }
    }

    @argChecking
    bogo(array: any[], functional: SortFunctional<any>, left?: number, right?: number): void {
        while (!this.isSorted(array, functional, left, right)) {
            this.shuffleIndex(array, left, right);
        }
    }

    @argChecking
    shuffleIndex(array: any[], left?: number, right?: number): void {
        let index1 = (Math.floor(Math.random() * (right - left)) + left);
        let index2 = (Math.floor(Math.random() * (right - left)) + left);
        this.swap(array, index1, index2);
    }
}