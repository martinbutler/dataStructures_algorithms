// mergeSort.java
// demonstrate recursive merge sort
// --------------------------------
import java.util.*;
class DArray {
  private long[] theArray;   // reference
  private int nElems;        // number of data items
  // ----------------------------
  public DArray(int max) {   // constructor
    theArray = new long[max];   // create the array
    nElems = 0;                 // no items yet
  }
  // ----------------------------
  public void insert(long value) {    // put element into array
    theArray[nElems] = value;    // insert it
    nElems++;             // increment size
  }
  // ----------------------------
  public void display() {   // displays array contents
    for(int j=0; j<nElems; j++)
      System.out.print(theArray[j] + " ");
    System.out.println("");
  }
  // ----------------------------
  public void mergeSort() {
    long[] workSpace = new long[nElems];
    recMergeSort(workSpace, 0, nElems-1);
  }
  // ----------------------------
  private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
    if(lowerBound == upperBound)    // if rante is 1,
      return;                       // no use sorting
    else {
      int mid = (lowerBound+upperBound) / 2;      // find midpoint
      recMergeSort(workSpace, lowerBound, mid);   // sort low half
      recMergeSort(workSpace, mid+1, upperBound); // sort high half
      merge(workSpace, lowerBound, mid+1, upperBound); // merge halfs
    }
  }
  private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
    int j = 0;      // workSpace index
    int lowerBound = lowPtr;
    int mid = highPtr -1;
    int n = upperBound - lowerBound + 1;  // # of items

    while(lowPtr <= mid && highPtr <= upperBound)
      if (theArray[lowPtr] < theArray[highPtr] )
        workSpace[j++] = theArray[lowPtr++];
      else
        workSpace[j++] = theArray[highPtr++];

    while(lowPtr <= mid)
      workSpace[j++] = theArray[lowPtr++];

    while(highPtr <= upperBound)
      workSpace[j++] = theArray[highPtr++];

    for(j=0; j<n; j++)
      theArray[lowerBound+j] = workSpace[j];
  }
}

// ----------------------------
class MergeSortApp {
  public static void main( String[] args)  {
    int maxSize = 15;     // array size
    if(args.length > 0) { // update maxSize if passed in
      maxSize = Integer.parseInt(args[0]);
    }

    DArray arr;         // reference to array
    arr = new DArray(maxSize);    // create the array
    Random rnd = new Random();
    for (int i = 0; i < maxSize; i++) {   // seed array
      arr.insert(rnd.nextInt(100));
    }

    System.out.println("Array(before):");
    arr.display();

    arr.mergeSort();

    System.out.println("Array(after):");
    arr.display();
  }
}
