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
public class Final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnderflowException {
            int numItems = 10000;
        BinaryHeap<Integer> h = new BinaryHeap<>();
        int i = 37;
 
        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
            h.insert( i );
        for( i = 1; i < numItems; i++ )
            if( h.deleteMin() != i )
                System.out.println( "Oops! " + i );
    }

    private static class UnderflowException extends Exception {

        public UnderflowException() {
        }
    }
    
 
}
