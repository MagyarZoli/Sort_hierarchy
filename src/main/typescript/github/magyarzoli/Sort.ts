import {SortFunctional} from "./SortFunctional";

export interface Comparable<T> {
    compareTo(other: T): number;
}

export class Sort<T extends Comparable<T>> {

    static INC = 1;
    static DEC = 2;
    static NOT = 3;
    static REV = 4;

    private constructor() {
    }

    functionalComparableToAddEquals(functional: SortFunctional<T>): SortFunctional<T> {
        let newFunctional: SortFunctional<T> | null = null;
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

    functionalComparableToRemoveEquals(functional: SortFunctional<T>): SortFunctional<T> {
        let newFunctional: SortFunctional<T> | null = null;
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

    functionalComparableToReverse(functional: SortFunctional<T>): SortFunctional<T> {
        let newFunctional: SortFunctional<T> | null = null;
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

    scanFunctionalComparableTo(functional: SortFunctional<T | number>): number {
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
}