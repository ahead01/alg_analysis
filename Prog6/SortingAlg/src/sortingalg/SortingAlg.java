/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalg;

/**
 *
 * @author austindase
 */
public class SortingAlg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] array = new int[100];
        int count = 0;
        for(int x = 100; x > 0; x--){
            array[count] = x;
            System.out.print(array[count] + ", ");
            count++;
        }
        int[] array_alt = {
            100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88,
            87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 
            61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 
            48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 
            35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 
            74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 
       
            22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 
            9, 8, 7, 6, 5, 4, 3, 2, 1, 
    };
        
    int[] array1 = {
 41,42,43,44,45,46,47,48,49
   
    };
    
            int[] array2 = {
         1,2,3,4,5,6,7,8,9,10,   20,30,40,50,60,70,80,90,100
           
    };
       // print(array_alt);
      //  int[] bs_fin = bubble_sort(array_alt);
      //  int[] merge_fin = merge_sort(array_alt);
      //  print(bs_fin);
    
      int[] merged = merge(array1,array2);
      print(merged);
        
        
    }

    public static int[] bubble_sort(int[] array) {
        int length = array.length;
        int count = 0;
        while(count < length ){
            if(count < length - 1){
                if(array[count] > array[count+1]){
                    int temp = array[count];
                    array[count] = array[count+1];
                    array[count+1] = temp;
                }
                count++;
            }else{
                //print(array);
                count = 0;
                length--;
            }
        }
        return array;
    }

    private static void print(int[] array) {
       int length = array.length;
       int count = 0;
       System.out.println("");
       while (count < length){
           System.out.print(array[count] + " ");
           count++;
       }
    }

    private static int[] merge_sort(int[] array) {
        int[] array2 = new int[array.length];
        for(int x = 0; x < array.length; x += 2){
           // int array 1 = merge(array);
        }
        if(array.length == 1){
        merge(array,array2);
        }else{
            
        }
        return array2;
    }

    public static int[] merge(int[] array1, int[] array2) {
        int a1 = array1.length;
        int a2 = array2.length;
        int a1_c = 0;
        int a2_c = 0;
        int len = a1 + a2;
        int[] array = new int[len];
        int count = 0;
        while(count < len){
        if(a1_c == a1){
            array[count] = array2[a2_c];
                a2_c++;
        }else if(a2_c == a2){
             array[count] = array1[a1_c];
                a1_c++;
        }else{
                if(array1[a1_c] > array2[a2_c]){
                    array[count] = array2[a2_c];
                    a2_c++;
                }else{
                    array[count] = array1[a1_c];
                    a1_c++;
                }
        }
                count++;
                
        }
        return array;
    }
    
}
