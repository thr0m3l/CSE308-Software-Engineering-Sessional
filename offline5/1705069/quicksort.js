const quickSort = (array, from, to) => {
    let value = array[from]
    let i = from
    let j = to
    if (from >= to) {
        return
    }
    while (i < j) {
        while (array[j] > value && i < j) j--;
        while (array[i] <= value && i < j) i++;
        if (i < j) {
            [array[i], array[j]] = [array[j], array[i]]
        }
    }
    array[from] = array[i]
    array[i] = value
    quickSort(array, from, i - 1)
    quickSort(array, i + 1, to)
}

module.exports = quickSort;