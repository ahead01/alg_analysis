/*
 *Author: Austin DAse
 * Programming Assingment 3
 *inputs: 
 * aray for each algorithim
 *
 * Output:
* Runtime of each algorithim in ms
 */
package problem3;
import java.util.Random;
/**
 *
 * @author austindase
 */
public class Problem3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int x;
        
        int[] ary1 = new int[5000];
        for(x=0;x<ary1.length;x++){
        int  n = rand.nextInt(2000) - 1000;
        ary1[x] = n;
        }
        
        int[] ary2 = new int[10000];
        for(x=0;x<ary2.length;x++){
        int  n = rand.nextInt(2000) - 1000;
        ary2[x] = n;
        }
        
        int[] ary3 = new int[15000];
        for(x=0;x<ary3.length;x++){
        int  n = rand.nextInt(2000) - 1000;
        ary3[x] = n;
        }
        
        int[] ary4 = new int[20000];
        for(x=0;x<ary4.length;x++){
        int  n = rand.nextInt(2000) - 1000;
        ary4[x] = n;
        }
        
        int[] ary5 = new int[25000];
        for(x=0;x<ary5.length;x++){
        int  n = rand.nextInt(2000) - 1000;
        ary5[x] = n;
        }
       long startTime ;
        startTime     = System.currentTimeMillis();
        alg4(ary1);
        System.out.println(System.currentTimeMillis() - startTime);
        startTime     = System.currentTimeMillis();
        alg4(ary2);
        System.out.println(System.currentTimeMillis() - startTime);
        startTime     = System.currentTimeMillis();
        alg4(ary3);
        System.out.println(System.currentTimeMillis() - startTime);
        startTime     = System.currentTimeMillis();
        alg4(ary4);
        System.out.println(System.currentTimeMillis() - startTime);
        startTime     = System.currentTimeMillis();
        alg4(ary5);
        System.out.println(System.currentTimeMillis() - startTime);
    
        
        
    }

    private static int alg1(int[] a) {
   int maxSum = 0;

 for( int i = 0; i < a.length; i++ )
 for( int j = i; j < a.length; j++ )
 {
 int thisSum = 0;

 for( int k = i; k <= j; k++ )
 thisSum += a[ k ];

 if( thisSum > maxSum )
 maxSum = thisSum;
 }

 return maxSum;
    }

    private static int alg2(int[] a) {
   int maxSum = 0;

 for( int i = 0; i < a.length; i++ )
 {
 int thisSum = 0;
 for( int j = i; j < a.length; j++ )
 {
 thisSum += a[ j ];

 if( thisSum > maxSum )
 maxSum = thisSum;
 }
 }

 return maxSum;
    }

private static int maxSumRec( int [ ] a, int left, int right )
 {
 if( left == right ) // Base case
 if( a[ left ] > 0 )
 return a[ left ];
 else
 return 0;

 int center = ( left + right ) / 2;
 int maxLeftSum = maxSumRec( a, left, center );
 int maxRightSum = maxSumRec( a, center + 1, right );

 int maxLeftBorderSum = 0, leftBorderSum = 0;
 for( int i = center; i >= left; i-- )
 {
 leftBorderSum += a[ i ];
 if( leftBorderSum > maxLeftBorderSum )
 maxLeftBorderSum = leftBorderSum;
 }

 int maxRightBorderSum = 0, rightBorderSum = 0;
 for( int i = center + 1; i <= right; i++ )
 {
 rightBorderSum += a[ i ];
 if( rightBorderSum > maxRightBorderSum )
 maxRightBorderSum = rightBorderSum;
 }

 return max3( maxLeftSum, maxRightSum,
 maxLeftBorderSum + maxRightBorderSum );
 }
public static int alg3( int []a)
{
    return maxSumRec( a, 0, a.length - 1 );
}  

private static int alg4(int[] a) {
   int maxSum = 0, thisSum = 0;

 for( int j = 0; j < a.length; j++ )
 {
 thisSum += a[ j ];

 if( thisSum > maxSum )
 maxSum = thisSum;
 else if( thisSum < 0 )
 thisSum = 0;
 }

 return maxSum;    
    }

    private static int max3(int a, int b, int c) {
        int max = a;
        if (b>= max) {max = b;}
        if (c>= max) {max = c;}
        return max;
    }
    
}
