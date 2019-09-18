/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog6;

/**
 *
 * @author austindase
 */
public class Heap {
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize; // Number of elements in heap
    private int[] array; // The heap array
    
    public Heap() {
        currentSize = 0;
    }

    public Heap(int capacity) {
        currentSize = 0;
        array = new int[capacity];
    }

    public Heap(int[] items) {
        currentSize = items.length;
 array = (int[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

 int i = 1;
 for( int item : items )
 array[ i++ ] = item;
 buildHeap( );
    }

    public void insert(int x) {
        array[currentSize++] = x;
         /**
2 * Insert into the priority queue, maintaining heap order.
3 * Duplicates are allowed.
4 * @param x the item to insert.
5 */
/*
    if( currentSize == array.length - 1 )
enlargeArray( array.length * 2 + 1 );
*/
 // Percolate up
 int hole = ++currentSize;
 for( array[ 0 ] = x; x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
 array[ hole ] = array[ hole / 2 ];
 array[ hole ] = x;
 }

   

    public int findMin() {
        return 0;
        /* See online code */ }

    public int deleteMin() {
if( isEmpty( ) )
 throw new UnderflowException( );

 int minItem = findMin( );
 array[ 1 ] = array[ currentSize-- ];
 percolateDown( 1 );

return minItem;}

    public boolean isEmpty() {
        if(currentSize == 0){
            return true;
        }else{
        return false;
        }
    }

    public void makeEmpty() {
        
    }

    private void percolateDown(int hole) {
      int child;
int tmp = array[ hole ];

 for( ; hole * 2 <= currentSize; hole = child )
 {
 child = hole * 2;
 if( child != currentSize &&
 array[ child + 1 ].compareTo( array[ child ])<0)
 child++;
 if( array[ child ].compareTo( tmp ) < 0 )
 array[ hole ] = array[ child ];
 else
 break;
 }
 array[ hole ] = tmp;}

    private void buildHeap() {
       for( int i = currentSize / 2; i > 0; i-- )
 percolateDown( i );
    }

    private void enlargeArray(int newSize) {
        /* See online code */ }
}
