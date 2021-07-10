const {getRandomArray, getRandomSizedArray, getAscendingArray} = require('./generate');
const quickSort = require('./quicksort');


const arr = getAscendingArray();
quickSort(arr, 0, arr.length-1);
console.log(arr);