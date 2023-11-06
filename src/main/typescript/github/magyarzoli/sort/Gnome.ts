import {Selection} from "./Selection";
import {Comparable} from "../Sort";
import {SortFunctional} from "../SortFunctional";
import {argChecking} from "../argChecking";

export class Gnome
        extends Selection {

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.gnomeInc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.gnomeDec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.gnome(array, functional);
    }

    @argChecking
    gnomeInc(array: any[], left?: number, right?: number): void {
        let pos = left;
        while (pos < right) {
            if ((pos == 0) || (array[pos].compareTo(array[(pos - 1)]) >= 0)) pos++;
            else this.swap(array, pos, --pos);
        }
    }

    @argChecking
    gnomeDec(array: any[], left?: number, right?: number): void {
        let pos = left;
        while (pos < right) {
            if ((pos == 0) || (array[pos].compareTo(array[(pos - 1)]) <= 0)) pos++;
            else this.swap(array, pos, --pos);
        }
    }

    @argChecking
    gnome(array: any[], functional: SortFunctional<any>, left?: number, right?: number): void {
        let pos = left;
        let  functionalAddEquals: SortFunctional<any> = this.functionalComparableToAddEquals(functional);
        while (pos < right) {
            if ((pos == 0) || (functionalAddEquals(array[pos], array[(pos - 1)]))) pos++;
            else this.swap(array, pos, --pos);
        }
    }
}