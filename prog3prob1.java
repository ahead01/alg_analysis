/*
 *Author: Austin DAse
 * Programming Assingment 3
 *inputs: 
 *  path to the .txt file that contains the puzzle text
 
 *
 * Output:
* Length of longest sequence, longest sequence, coordinates of longest sequence
 */
package prob1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author austindase
 */
public class prog3prob1 {
   private int maxSize;
   private int[] stackArray;
   private int top;
   //int[][] aryPuzzle = new int[15][15];
   
   public prog3prob1(int x) {
      maxSize = x;
      stackArray = new int[maxSize+1];
      top = 0;
   }
   public void push(int j) {
      stackArray[++top] = j;
   }
   public int pop() {
      return stackArray[top--];
   }
   public int peek() {
      return stackArray[top];
   }
   public boolean isEmpty() {
      return (top == 0);
   }
   public boolean isFull() {
      return (top == maxSize);
   }

   

  public static void main(String[] args) throws IOException {
      int maxSize = 15*15;
      maxSize = 226;
      int maxAdjacent = 8;
      int previousLength = 0;
      String longString = "";
      String xyString = "";
  prog3prob1 stackA = new prog3prob1(maxAdjacent);
  prog3prob1 stackB = new prog3prob1(maxAdjacent);
  prog3prob1 theBigStack = new prog3prob1(maxSize);
  prog3prob1 theBigStackX = new prog3prob1(maxSize);
  prog3prob1 theBigStackY = new prog3prob1(maxSize);
  Scanner reader = new Scanner(System.in);
  //System.out.println("Please Enter the path to your puzzle doc:");
  //String file_name = reader.nextLine();
     String  file_name = "/Users/austindase/Desktop/600/testdataHW3.txt";    
  int[][] aryPuzzle = readLines(file_name); 
  //String
  //String  
  int longlength =0 ;
  int x,y;
  boolean push;
      for(x=0;x<15;x++){
        for (y=0;y<15; y++){
            //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            //System.out.println("Number: " + aryPuzzle[x][y]);
theBigStackX.push(x);
theBigStackY.push(y);
theBigStack.push(aryPuzzle[x][y]);

boolean found = true;
int counter =1;
int x2 = x;
int y2 = y;
int maxX = x2+2;
if (maxX >14){maxX = 15;}
int maxY = y2+2;
if (maxY >14){maxY = 15;}
while(found == true && counter < maxSize){
    //System.out.println("Into while loop number  "+ counter + " Last Number = " + theBigStack.peek());
   // //System.out.println("    Counter: "+ counter);
   // //System.out.println("    Found: "+ found);
   // //System.out.println("    x2,y2: "+ x2 +","+y2);
   //System.out.println("Searching around: " + aryPuzzle[x2][y2]);
for(int a = x2-1; a < 15 && a<x2+1; a++){
    if(a<0 || a>14){continue;}
    for(int b = y2-1; b < 15 && b<y2+2; b++){
        if(b<0 || b>14 || b == y && a ==x){continue;}
        ////System.out.println("");
        ////System.out.println("");
        ////System.out.println("Seraching the ints surrounding " + aryPuzzle[x2][y2]);
        int compare = aryPuzzle[x2][y2];
        int a1 = stackA.peek();
        int b1 = stackB.peek();
        int compare2 = aryPuzzle[a1][b1];
        int current = aryPuzzle[x2][y2];
        //System.out.println("looking at: " + aryPuzzle[a][b] + " : " + a +","+b);
        ////System.out.println("    Must be greater than " + aryPuzzle[x2][y2] + " and less than " + compare2);
        ////System.out.println("    Current int: " +aryPuzzle[a][b] + " > " + compare 
        //        + " and " + aryPuzzle[a][b] + " < " + compare2 + " or " + stackA.isEmpty());
        ////System.out.println(aryPuzzle[a][b] > compare && aryPuzzle[a][b] < compare2 || stackA.isEmpty());
        if(aryPuzzle[a][b] > compare ){
            if(stackA.isEmpty()){
            //System.out.println("PUSH: " + aryPuzzle[a][b]);
////System.out.println("    Small PUSH " + a + ", " + b +" Count = " + counter);
            stackA.push(a);
            stackB.push(b); 
            }
            if(aryPuzzle[a][b] < compare2) {
           //System.out.println("PUSH: " + aryPuzzle[a][b]);
////System.out.println("    Small PUSH " + a + ", " + b +" Count = " + counter);
            stackA.push(a);
            stackB.push(b);
            }
        }

    }
}
found = false;
int e,f;
if(!stackA.isEmpty()){
         e = stackA.pop();
         f = stackB.pop();
         //System.out.println("Smallest is: " + aryPuzzle[e][f]);
         /*//System.out.println("Smallest in the surrounding numbers is: ");
         //System.out.println(aryPuzzle[e][f]);
         //System.out.println("   Coordinates are : E: " + e + " F: " + f);
         //System.out.println("   Must be greater than " + theBigStack.peek() );
         */
         if (aryPuzzle[e][f]> theBigStack.peek()){
             ////System.out.println(""+ aryPuzzle[e][f] +"Was greater than " + theBigStack.peek());
         //System.out.println("theBigStack PUSH: " + aryPuzzle[e][f]);
         theBigStack.push(aryPuzzle[e][f]);
         theBigStackX.push(e);
         theBigStackY.push(f);
         x2 = e;
         y2 = f;
         found = true;
         counter++;
         }
}       
         
         while (!stackA.isEmpty()) {
         e = stackA.pop();
         f = stackB.pop();
         //System.out.print(aryPuzzle[e][f]);
        // System.out.print(" ");
         } 
                 
        ////System.out.println("" );
       // //System.out.println("##############################" );
        ////System.out.println("##############################" );
}
//System.out.println("This sequence length is: "+ counter);
/*//System.out.println("DOne with this sequence of length " );
//System.out.println("Length: " + counter);
//System.out.println("" );
//System.out.println("THe Big Stack:" );
*/
boolean longer = false;
////System.out.println("Counter: " + counter + " previousLength: " + previousLength);
         if(counter > previousLength){
             previousLength = counter; 
             longer = true;
             longString = "";
             xyString = "";
         }
         ////System.out.println("The Current Sequence is: ");
      while (!theBigStack.isEmpty()) {
         int value = theBigStack.pop();
         int x1 = theBigStackX.pop();
         int y1 = theBigStackY.pop();
         //System.out.print(value);
         //System.out.print(" [" + x1+","+y1+"]");
         if(longer == true){
            // //System.out.println("This sequence is now the longest");
            longlength = counter;
             longString = longString.concat(Integer.toString(value)+ ", ");
             xyString = xyString.concat(Integer.toString(x1) + "," + Integer.toString(y1) + " ");
         }

      } 
      //System.out.println("Onto The Next Number VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
        }
    } 
      
        
      while (!theBigStack.isEmpty()) {
         int value = theBigStack.pop();

      } 
        System.out.println("Longest sequence length: "+ longlength);
        System.out.println("Sequence: "+ longString);
        System.out.println("Coordinates: " + xyString);
  }   
  
  static int[][] readLines(String path) throws IOException {
    //System.out.println(path);
    FileReader file_to_read = new FileReader(path);
    BufferedReader bf = new BufferedReader(file_to_read);
int[][] tempPuzzle = new int[15][15];
//Scanner scanner = new Scanner(file_to_read);

int outerCounter = 0;
String line;
while((line = bf.readLine()) != null)
{
    String[] lineAr = line.split(",");
    int length = lineAr.length;
    int innerCounter = 0;
    while(innerCounter< length){ 
        int num = Integer.parseInt(lineAr[innerCounter].trim());
        tempPuzzle[outerCounter][innerCounter] = num;
        ////System.out.println(num);
        innerCounter++;
    }
    outerCounter++;
}
return tempPuzzle;    
}
}

/*
            push = true;
          int currentInt = aryPuzzle[x][y];
          int theTop = theStack.peek();
if(theStack.isEmpty()){
    theStack.push(currentInt);
}
if(theStack.isFull() && currentInt>theTop){
    theStack.push(currentInt);
}
*/