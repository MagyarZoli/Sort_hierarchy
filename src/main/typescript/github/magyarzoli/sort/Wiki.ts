import {Merge} from "./Merge";
import {InsertionInterface} from "../InsertionInterface";
import {argChecking} from "../argChecking";
import {SortFunctional} from "../SortFunctional";
import {Comparable} from "../Sort";

export class Wiki
        extends Merge
        implements InsertionInterface<any> {

    WIKI_BLOCK = 32;

    constructor() {
        super();
    }

    sortArrayInc(array: Comparable<any>[]): void {
        this.wikiInc(array);
    }

    sortArrayDec(array: Comparable<any>[]): void {
        this.wikiDec(array);
    }

    sortArrayFun(array: Comparable<any>[], functional: SortFunctional<Comparable<any>>): void {
        this.wiki(array, functional);
    }

    @argChecking
    wikiInc(array: any[], left?: number, right?: number): void {
        let buffer: any[] = [];
        for (let i = left; i < right; i += this.WIKI_BLOCK) {
            this.insertionInc(array, i, (Math.min((i + this.WIKI_BLOCK), right) - 1));
        }
        this.mergeV3Inc(array, this.WIKI_BLOCK, right, buffer);
    }

    @argChecking
    wikiDec(array: any[], left?: number, right?: number): void {
        let buffer: any[] = [];
        for (let i = left; i < right; i += this.WIKI_BLOCK) {
            this.insertionDec(array, i, (Math.min((i + this.WIKI_BLOCK), right) - 1));
        }
        this.mergeV3Dec(array, this.WIKI_BLOCK, right, buffer);
    }

    @argChecking
    wiki(array: any[], functional: SortFunctional<any>, left?: number, right?: number): void {
        let buffer: any[] = [];
        for (let i = left; i < right; i += this.WIKI_BLOCK) {
            this.insertion(array, functional, i, (Math.min((i + this.WIKI_BLOCK), right) - 1));
        }
        this.mergeV3(array, functional, this.WIKI_BLOCK, right, buffer);
    }

    @argChecking
    insertionInc(array: any[], from?: number, to?: number): void {
        for (let i = from; i <= to; i++) {
            let select = array[i];
            let j = i;
            while ((j > from)
                    && ((array[(j - 1)] != null)
                    && (array[(j - 1)].compareTo(select) > 0))) {
                array[j] = array[(j - 1)];
                j--;
            }
            array[j] = select;
        }
    }

    @argChecking
    insertionDec(array: any[], from?: number, to?: number): void {
        for (let i = from; i <= to; i++) {
            let select = array[i];
            let j = i;
            while ((j > from)
                    && ((array[(j - 1)] != null)
                    && (array[(j - 1)].compareTo(select) < 0))) {
                array[j] = array[(j - 1)];
                j--;
            }
            array[j] = select;
        }
    }

    @argChecking
    insertion(array: any[], functional:SortFunctional<any>, from?: number, to?: number): void {
        for (let i = from; i <= to; i++) {
            let select = array[i];
            let j = i;
            while ((j > from)
                    && ((array[(j - 1)] != null)
                    && (functional(array[(j - 1)], select)))) {
                array[j] = array[(j - 1)];
                j--;
            }
            array[j] = select;
        }
    }
}