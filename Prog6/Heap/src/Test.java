

import BinaryHeap.BinaryHeap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author austindase
 */
public class Test
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Binary Heap Test\n\n");
        System.out.println("Enter size of Binary heap");
        /** Make object of BinaryHeap **/
        BinaryHeap bh = new BinaryHeap(scan.nextInt() );
 
        char ch;
        /**  Perform Binary Heap operations  **/
        do    
        {
            System.out.println("\nBinary Heap Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete min");
            System.out.println("3. check full");            
            System.out.println("4. check empty");
            System.out.println("5. clear");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                try
                {
                    System.out.println("Enter integer element to insert");
                    bh.insert( scan.nextInt() ); 
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage() );
                }
                break;                          
            case 2 : 
                try
                {
                    System.out.println("Min Element : "+ bh.deleteMin()); 
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage() );
                }                 
                break;                                
            case 3 : 
                System.out.println("Full status = "+ bh.isFull());
                break;                                   
            case 4 : 
                System.out.println("Empty status = "+ bh.isEmpty());
                break; 
            case 5 : 
                bh.makeEmpty();
                System.out.println("Heap Cleared\n");
                break;         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /** Display heap **/
            bh.printHeap();  
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
    }
}