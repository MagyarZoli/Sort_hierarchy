import {Sorter} from "./Sorter";
import {Comparable} from "./Sort";
import {SortFunctional} from "./SortFunctional";
import {SortType} from "./SortType";

export abstract class SortComparable
        implements Sorter<Comparable<any>> {

    INC: number = 1;
    DEC: number = 2;
    NOT: number = 3;
    REV: number = 4;

    functionalComparableToAddEquals(functional: SortFunctional<any>): SortFunctional<any> {
        let newFunctional: SortFunctional<any> | null = null;
        switch (this.scanFunctionalComparableTo(functional)) {
            case 0:
                newFunctional = (a, b) => a.compareTo(b) >= 0;
                break;
            case 2:
                newFunctional = (a, b) => a.compareTo(b) <= 0;
                break;
            case 4:
                newFunctional = (a, b) => a.compareTo(b) === 0;
                break;
            case 1:
            case 3:
            case 5:
                newFunctional = functional;
                break;
        }
        if (newFunctional === null) throw new Error("Invalid functional comparison");
        return newFunctional;
    }

    functionalComparableToRemoveEquals(functional: SortFunctional<any>): SortFunctional<any> {
        let newFunctional: SortFunctional<any> | null = null;
        switch (this.scanFunctionalComparableTo(functional)) {
            case 1:
                newFunctional = (a, b) => a.compareTo(b) > 0;
                break;
            case 3:
                newFunctional = (a, b) => a.compareTo(b) < 0;
                break;
            case 5:
                newFunctional = (a, b) => a.compareTo(b) !== 0;
                break;
            case 0:
            case 2:
            case 4:
                newFunctional = functional;
        }
        if (newFunctional === null) throw new Error("Invalid functional comparison");
        return newFunctional;
    }

    functionalComparableToReverse(functional: SortFunctional<any>): SortFunctional<any> {
        let newFunctional: SortFunctional<any> | null = null;
        switch (this.scanFunctionalComparableTo(functional)) {
            case 0:
                newFunctional = (a, b) => a.compareTo(b) < 0;
                break;
            case 1:
                newFunctional = (a, b) => a.compareTo(b) <= 0;
                break;
            case 2:
                newFunctional = (a, b) => a.compareTo(b) > 0;
                break;
            case 3:
                newFunctional = (a, b) => a.compareTo(b) >= 0;
                break;
            case 4:
                newFunctional = (a, b) => a.compareTo(b) === 0;
                break;
            case 5:
                newFunctional = (a, b) => a.compareTo(b) !== 0;
                break;
        }
        if (newFunctional === null) throw new Error("Invalid functional comparison");
        return newFunctional;
    }

    scanFunctionalComparableTo(functional: SortFunctional<any | number>): number {
        const a = 1, b = 2;
        const f = functional(a, a);
        const g = functional(a, b);
        const h = functional(b, a);
        if (!f && !g && h) return 0;
        else if (f && !g && h) return 1;
        else if (!f && g && !h) return 2;
        else if (f && g && !h) return 3;
        else if (!f && g && h) return 4;
        else return 5;
    }

    sortArrayInc(array: Comparable<any>[]): void {
    }

    sortArrayDec(array: Comparable<any>[]): void {
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
    }

    sortArrayRev(array: any[]): void {
        array = array.sort().reverse();
    }

    sortArray(array: any[], type: number | SortType) {
        switch (type) {
            case this.INC | SortType.INCREASING:
                this.sortArrayInc(array);
                break;
            case this.DEC | SortType.DECREASING:
                this.sortArrayDec(array);
                break;
            case this.NOT | SortType.DO_NOT_CHANGE_IT:
                break;
            case this.REV | SortType.REVERSE_ORDER:
                this.sortArrayRev(array);
                break;
            default:
                break;
        }
    }
}