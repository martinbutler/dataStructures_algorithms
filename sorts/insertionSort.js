insertionSort = function(arr) {

    var maxSize     = arr.length, // number of items in the array
        value,                      // the value currently being compared
        i,                          // index into unsorted section
        j;                          // index into sorted section

    for (i=0; i < maxSize; i++) {

        // store the current value because it may shift later
        value = arr[i];

        /*
         * Whenever the value in the sorted section is greater than the value
         * in the unsorted section, shift all items in the sorted section over
         * by one. This creates space in which to insert the value.
         */
        for (j=i-1; j > -1 && arr[j] > value; j--) {
            arr[j+1] = arr[j];
        }

        arr[j+1] = value;
    }

    return arr;
}

function init() {
    maxSize =  process.argv[2] || 15;

    unsortedArr = []
    for (var i=0; i < maxSize; i++) {
        unsortedArr[i] = Math.floor(Math.random() * 100);
    }

    console.log("Array(before):");
    console.log(unsortedArr);

    sortArr = insertionSort(unsortedArr)

    console.log("Array(after):");
    console.log(sortArr);

}
init();
