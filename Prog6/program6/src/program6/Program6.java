
package program6;

import static java.util.Optional.empty;
import java.util.Random;
import java.lang.Exception;

/**
 *
 * @author austindase
 */
public class Program6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
              int[] array = {20,26,28,41,33,57,31,66,71,69,88,97,67,44,53};
                 // 5,12,19,14,3,16,11,8,15,6,9,7,4,18,2};
              //{20,26,28,41,33,57,31,66,71,69,88,97,67,44,53
             //Heap heap1 = heapify(array);
              
              
              int len = array.length;
              Heap heap1 = new Heap(len+1);
              for(int x = 0; x < len; x++){
                     heap1.insert(array[x]);
              }
             // Heap heap2 = new Heap(array.length);
             // heap2.buildHeap(array);
            // heap2.printHeap();
             heap1.printHeap();
              System.out.println();
              
        Exception Exception = null;
        //heap1.printHeap();
        System.out.println();
        int delete = heap1.delete(0, Exception);
              heap1.printHeap();
              System.out.println("Swaps: " + heap1.swap);
   }}
          
          /*    
              Random rand = new Random(); 
              int value = rand.nextInt(100000); 
              int one = 5000;
              int two = 10000;
              int three = 20000;
              int four = 50000;
              int[] arrayFiveThousand = new int[one];
              int[] arrayTenThousand = new int[two];
              int[] arrayTwentyThousand = new int[three];
              int[] arrayFiftyThousand = new int[four];
              for(int x = 0;x < one;x++){
                  value = rand.nextInt(100000); 
                  arrayFiveThousand[x] = value;
              }
              for(int x = 0;x < two;x++){
                  value = rand.nextInt(100000); 
                  arrayTenThousand[x] = value;
              }
              for(int x = 0;x < three;x++){
                  value = rand.nextInt(100000); 
                  arrayTwentyThousand[x] = value;
              }
             for(int x = 0;x < four;x++){
                  value = rand.nextInt(100000); 
                  arrayFiftyThousand[x] = value;
              }
             
             Heap heap1 = new Heap(arrayFiveThousand.length);
             Heap heap2 = new Heap(arrayTenThousand.length);
             Heap heap3 = new Heap(arrayTwentyThousand.length);
             Heap heap4 = new Heap(arrayFiftyThousand.length);
             Heap heap1_ins = new Heap(arrayFiveThousand.length);
             Heap heap2_ins = new Heap(arrayTenThousand.length);
             Heap heap3_ins = new Heap(arrayTwentyThousand.length);
             Heap heap4_ins = new Heap(arrayFiftyThousand.length);
            
            System.out.println("");
             System.out.println("5,000 size array:");
             long start_build = System.currentTimeMillis();
                heap1.buildHeap(arrayFiveThousand);
             long finish_build = System.currentTimeMillis();
             System.out.println(finish_build - start_build + " milliseconds - buildHeap, Swaps:" + heap1.swap);
              
             long start_insert = System.currentTimeMillis();
                int len = arrayFiveThousand.length;
                for(int x = 0; x < len; x++){
                    int y = arrayFiveThousand[x];
                       heap1_ins.insert(y);
                }
             long finish_insert = System.currentTimeMillis();
             System.out.println(finish_insert - start_insert + " milliseconds - insert, Swaps:" + heap1_ins.swap);
            
           System.out.println("");
             System.out.println("10,000 size array:");
           start_build = System.currentTimeMillis();
                heap2.buildHeap(arrayTenThousand);
         finish_build = System.currentTimeMillis();
             System.out.println(finish_build - start_build + " milliseconds - buildHeap, Swaps:" + heap2.swap);
             
              
       start_insert = System.currentTimeMillis();
                len = arrayTenThousand.length;
                for(int x = 0; x < len; x++){
                       heap2_ins.insert(arrayTenThousand[x]);
                }
           finish_insert = System.currentTimeMillis();
             System.out.println(finish_insert - start_insert + " milliseconds - insert, Swaps:" + heap2_ins.swap);
             
             
             System.out.println("");
             System.out.println("20,000 size array:");
             start_build = System.currentTimeMillis();
                heap3.buildHeap(arrayTwentyThousand);
             finish_build = System.currentTimeMillis();
             System.out.println(finish_build - start_build + " milliseconds - buildHeap, Swaps:" + heap3.swap);
              
             start_insert = System.currentTimeMillis();
                len = arrayTwentyThousand.length;
                for(int x = 0; x < len; x++){
                       heap3_ins.insert(arrayTwentyThousand[x]);
                }
             finish_insert = System.currentTimeMillis();
             System.out.println(finish_insert - start_insert + " milliseconds - insert, Swaps:" + heap3_ins.swap);
             
             
             System.out.println("");
             System.out.println("50,000 size array:");
             start_build = System.currentTimeMillis();
                heap4.buildHeap(arrayFiftyThousand);
             finish_build = System.currentTimeMillis();
             System.out.println(finish_build - start_build + " milliseconds - buildHeap, Swaps:" + heap4.swap);
              
             start_insert = System.currentTimeMillis();
                len = arrayFiftyThousand.length;
                for(int x = 0; x < len; x++){
                       heap4_ins.insert(arrayFiftyThousand[x]);
                }
             finish_insert = System.currentTimeMillis();
             System.out.println(finish_insert - start_insert + " milliseconds - insert, Swaps:" + heap4_ins.swap);
             
    }
    
}
*/