function mergeSort(items) {

  if (items.length < 2) {
    return items;
  }

  var middle = Math.floor(items.length / 2),
    left = items.slice(0, middle),
    right = items.slice(middle),
    params = merge(mergeSort(left), mergeSort(right));

  return merge(mergeSort(left), mergeSort(right));}

function merge(left, right) {
  var result = [],
    il = 0,
    ir = 0;

  while (il < left.length && ir < right.length) {
    if (left[il] < right[ir]) {
      result.push(left[il++]);
    } else {
      result.push(right[ir++]);
    }
  }

  return result.concat(left.slice(il)).concat(right.slice(ir));
}

function init() {
  maxSize = process.argv[2] || 15;

  unsortedArr = []
  for (var i = 0; i < maxSize; i++) {
    unsortedArr[i] = Math.floor(Math.random() * 100);
  }

  console.log("Array(before):");
  console.log(unsortedArr);

  sortArr = mergeSort(unsortedArr)

  console.log("Array(after):");
  console.log(sortArr);

}
init();
