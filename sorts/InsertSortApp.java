// insertSort.java
// demonstrate insertion sort
// ----------------------------
import java.util.*;
class ArrayIns {
  private long[] a;   // reference
  private int nElems;  // number of data items
  // ----------------------------
  public ArrayIns(int max) {   // constructor
    a = new long[max];   // create the array
    nElems = 0;          // no items yet
  }
  // ----------------------------
  public void insert(long value) {    // put element into array
    a[nElems] = value;    // insert it
    nElems++;             // increment size
  }
  // ----------------------------
  public void display() {   // displays array contents
    for(int j=0; j<nElems; j++)   // for each element,
      System.out.print(a[j] + " ");
    System.out.println("");
  }
  // ----------------------------
  public void insertionSort() {
    int in, out;

    for(out=1; out<nElems; out++) {   // out is dividing line
      long temp = a[out];               // remove marked item
      in = out;                         // start shifts at out
      while(in>0 && a[in-1] >= temp) {  // until on is smaller,
        a[in] = a[in-1];                // shift item
        --in;                           // go left one position
      }
      a[in] = temp;                     // insert marker item
    }
  }

}

// ----------------------------
class InsertSortApp {
  public static void main( String[] args)  {
    int maxSize = 15;     // array size
    if(args.length > 0) { // update maxSize if passed in
      maxSize = Integer.parseInt(args[0]);
    }

    ArrayIns arr;         // reference to array
    arr = new ArrayIns(maxSize);    // create the array
    Random rnd = new Random();
    for (int i = 0; i < maxSize; i++) {   // seed array
      arr.insert(rnd.nextInt(100));
    }

    System.out.println("Array(before):");
    arr.display();

    arr.insertionSort();

    System.out.println("Array(after):");
    arr.display();
  }
}
