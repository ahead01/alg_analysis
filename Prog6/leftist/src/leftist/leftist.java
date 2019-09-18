/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leftist;

/**
 *
 * @author austindase
 */
public class leftist {
    public static void main( String [ ] args ) throws UnderflowException
    {
        LeftistHeap<Integer> h1  = new LeftistHeap<>( );
        LeftistHeap<Integer> h2 = new LeftistHeap<>( );
        int[] array1 = {2,11,5,12,17,8,18,15};
        int[] array2 = {4,9,6,8,10,11,31,21};
        
        int length = array1.length;
        int count = 1;
        while(count<16){
            h1.insert(count);
        }
        
        
        
        
        length = array2.length;
        count = 0;
        while(count<length){
            h2.insert(array2[count]);
        }
 
                   /*
                   int numItems = 100;
                   LeftistHeap<Integer> h  = new LeftistHeap<>( );
                   LeftistHeap<Integer> h1 = new LeftistHeap<>( );
                   int i ;
                   
                   for( i = 37; i != 0; i = ( i + 37 ) % numItems ) {
                   if( i % 2 == 0 ) {
                   h1.insert( i );
                   } else {
                   h.insert( i );
                   }
                   }
                   
                   h.merge( h1 );
                   for( i = 1; i < numItems; i++ ) {
                   if( h.deleteMin( ) != i ) {
                   System.out.println( "Oops! " + i );
                   }
                   }
                   */
       
    }    
}
