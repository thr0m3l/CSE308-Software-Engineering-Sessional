const Multiset = require('multiset');
const {getRandomSizedArray, 
        getRandomArray, getAscendingArray, 
        getDescendingArray, getEqualElementArray} = require('./generate');
const quickSort = require('./quicksort');

jest.setTimeout(100000);

const isSorted = (arr) => {
    for(let i = 1; i < arr.length; i++) {
        if (arr[i] < arr[i - 1]) {
            return false;
        }
    }
    return true;
}

const containsAll = (arr1, arr2) => {
    if (arr1.length !== arr2.length) {
        return false;
    }

    
    for(let i = 0; i < arr1.length; i++) {
        if (!arr2.includes(arr1[i])){
            return false;
        }
    }
    return true;
}

describe('A random sized array', () => {
    let arr = getRandomSizedArray();
    let copyArr = arr.slice();

    quickSort(arr, 0, arr.length-1);

    test('is sorted', () => {
        expect(isSorted(arr)).toBe(true);    
    })

    test('contains all elements from the original array', () => {
        expect(containsAll(arr, copyArr)).toBe(true);    
    })
});

describe('A blank array', () => {
    let arr = [];
    let copyArr = arr.slice();

    quickSort(arr, 0, arr.length-1);

    test('is sorted', () => {
        expect(isSorted(arr)).toBe(true);    
    })

    test('contains all elements from the original array', () => {
        expect(containsAll(arr, copyArr)).toBe(true);    
    })
});

describe('An array with one number', () => {
    let arr = getRandomArray(1);
    let copyArr = arr.slice();

    quickSort(arr, 0, arr.length-1);

    test('is sorted', () => {
        expect(isSorted(arr)).toBe(true);    
    })

    test('contains all elements from the original array', () => {
        expect(containsAll(arr, copyArr)).toBe(true);    
    })
});

describe('An array with two numbers', () => {
    let arr = getRandomArray(2);
    let copyArr = arr.slice();

    quickSort(arr, 0, arr.length-1);

    test('is sorted', () => {
        expect(isSorted(arr)).toBe(true);    
    })

    test('contains all elements from the original array', () => {
        expect(containsAll(arr, copyArr)).toBe(true);    
    })
});

describe('A randomly generated array', () => {
    const arr = getRandomArray(69);
    const copyArr = arr.slice();

    quickSort(arr, 0, arr.length-1);

    test('is sorted', () => {
        expect(isSorted(arr)).toBe(true);    
    })

    test('contains all elements from the original array', () => {
        expect(containsAll(arr, copyArr)).toBe(true);    
    })
});


describe('An array with elements in ascending order', () => {
    const arr = getAscendingArray();
    const copyArr = arr.slice();

    quickSort(arr, 0, arr.length-1);

    test('is sorted', () => {
        expect(isSorted(arr)).toBe(true);    
    })

    test('contains all elements from the original array', () => {
        expect(containsAll(arr, copyArr)).toBe(true);    
    })
});

describe('An array with elements in descending order', () => {
    const arr = getDescendingArray();
    const copyArr = arr.slice();

    quickSort(arr, 0, arr.length-1);

    test('is sorted', () => {
        expect(isSorted(arr)).toBe(true);    
    })

    test('contains all elements from the original array', () => {
        expect(containsAll(arr, copyArr)).toBe(true);    
    })
});

describe('An array with equal elements', () => {
    const arr = getEqualElementArray();
    const copyArr = arr.slice();

    quickSort(arr, 0, arr.length-1);

    test('is sorted', () => {
        expect(isSorted(arr)).toBe(true);    
    })

    test('contains all elements from the original array', () => {
        expect(containsAll(arr, copyArr)).toBe(true);    
    })
});



