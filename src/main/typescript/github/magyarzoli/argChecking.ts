import {SortFunctional} from "./SortFunctional";

export function argChecking(target: any, property: string, descriptor: PropertyDescriptor) {
    const originalMethod = descriptor.value;
    descriptor.value = function (
        array: any[],
        from?: number,
        mid?: number,
        mid2?: number,
        to?: number,
        buffer?: any[],
        functional?: SortFunctional<any>
    ): any {
        from = from === undefined || from === null ? 0 : from;
        to = to === undefined || to === null ? array.length : to;
        mid = mid === undefined || mid === null ? ((from + to) / 2) : mid;
        mid2 = mid2 === undefined || mid2 === null ? ((from + to) / 2) : mid2;
        return originalMethod.call(this, array, from, mid, mid2, to, buffer, functional);
    };
    return descriptor;
}