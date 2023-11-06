import {SortFunctional} from "./SortFunctional";

export function argChecking(target: any, property: string, descriptor: PropertyDescriptor) {
    const originalMethod = descriptor.value;
    descriptor.value = function (
        array: any[],
        from?: number,
        mid?: number,
        to?: number,
        functional?: SortFunctional<any>
    ): any {
        from = from === undefined || from === null ? 0 : from;
        to = to === undefined || to === null ? array.length : to;
        mid = mid === undefined || mid === null ? ((from + to) / 2) : mid;
        return originalMethod.call(this, array, from, mid, to, functional);
    };
    return descriptor;
}