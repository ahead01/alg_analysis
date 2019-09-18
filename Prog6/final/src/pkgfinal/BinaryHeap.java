/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**
 *
 * @author austindase
 */

/**
 * Implements a binary heap.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class BinaryHeap
{
    /**
     * Construct the binary heap.
     */
    public BinaryHeap( )
    {
        this( DEFAULT_CAPACITY );
    }
 
    /**
     * Construct the binary heap.
     * @param capacity the capacity of the binary heap.
     */
    public BinaryHeap( int capacity )
    {
        currentSize = 0;
        array = new int[ capacity + 1 ];
    }
     
    /**
     * Construct the binary heap given an array of items.
     */
    public BinaryHeap( int [ ] items )
    {
            currentSize = items.length;
            array = new int[ ( currentSize + 2 ) * 11 / 10 ];
 
            int i = 1;
            for( int item : items )
                array[ i++ ] = item;
            buildHeap( );
    }
 
    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert( int x )
    {
        if( currentSize == array.length - 1 )
            enlargeArray( array.length * 2 + 1 );
 
            // Percolate up
        int hole = ++currentSize;
        for( array[ 0 ] = x; x < ( array[ hole / 2 ] ); hole /= 2 )
            array[ hole ] = array[ hole / 2 ];
        array[ hole ] = x;
    }
 
 
    private void enlargeArray( int newSize )
    {
            int [] old = array;
            array = new int[ newSize ];
            for( int i = 0; i < old.length; i++ )
                array[ i ] = old[ i ];        
    }
     
    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public int findMin( ) throws UnderflowException
    {
        if( isEmpty( ) ) {
            throw new UnderflowException( );
        }
        return array[ 1 ];
    }
 
    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
         * @throws pkgfinal.Final.UnderflowException
     */
    public int deleteMin( ) throws Final.UnderflowException
    {
        if( isEmpty( ) ) {
            throw new Final.UnderflowException( );
        }
 
        int minItem = findMin( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );
 
        return minItem;
    }
 
    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap( )
    {
        for( int i = currentSize / 2; i > 0; i-- )
            percolateDown( i );
    }
 
    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return currentSize == 0;
    }
 
    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty( )
    {
        currentSize = 0;
    }
 
    private static final int DEFAULT_CAPACITY = 10;
 
    private int currentSize;      // Number of elements in heap
    private int [ ] array; // The heap array
 
    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown( int hole )
    {
        int child;
        int tmp = array[ hole ];
 
        for( ; hole * 2 <= currentSize; hole = child )
        {
            child = hole * 2;
            if( child != currentSize && array[ child + 1 ] < array[ child ]  )
                child++;
            if( array[ child ].compareTo( tmp ) < 0 )
                array[ hole ] = array[ child ];
            else
                break;
        }
        array[ hole ] = tmp;
    }
 
    public int compareTo(int)
        // Test program

    private static class UnderflowException extends Exception {

        public UnderflowException() {
        }
    }

    }
    
