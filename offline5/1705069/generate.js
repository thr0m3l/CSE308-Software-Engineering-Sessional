const ARR_MAX = Math.floor(Number.MAX_SAFE_INTEGER/10000000000000);
const ARR_MIN = Math.floor(Number.MIN_SAFE_INTEGER/10000000000000);
const MIN = Math.floor(Number.MIN_SAFE_INTEGER);
const MAX = Math.floor(Number.MIN_SAFE_INTEGER);

const getRandom = (lower, upper) => {
    return Math.floor(Math.random() * (upper - lower+ 1) + lower);
}

const getRandomArray = size => {
    let arr = [];
    for (var i = 0; i < size; i++){
        arr.push(getRandom(MIN, MAX));
    }
    return arr;
}

const getRandomSizedArray = () => {
    const size = (getRandom(1, 10000));
    return getRandomArray(size);
}

const getBlankArray = () => {
    return [];
}

const getEqualElementArray = () => {
    const elem = getRandom(MIN, MAX);
    const size = getRandom(10, ARR_MAX);
    let arr = [];
    for(let i = 0; i < size; i++){
        arr.push(elem);
    }
    return arr;
}

const getAscendingArray = () => {
    const elem = getRandom(MIN, MAX);
    const size = getRandom(10, ARR_MAX); 
    let arr = [];

    for(let i = 0; i < size; i++){
        arr.push(elem + i);
    }

    return arr;
}

const getDescendingArray = () => {
    const elem = getRandom(MIN, MAX);
    const size = getRandom(10, ARR_MAX);
    let arr = [];

    for(let i = 0; i < size; i++){
        arr.push(elem - i);
    }
    return arr;
}

module.exports = {  getRandomArray, 
                    getRandomSizedArray, 
                    getBlankArray, 
                    getAscendingArray, 
                    getDescendingArray,
                    getEqualElementArray }