/*
 *Author: Austin DAse
 * Programming Assingment 3
 *inputs: 
 *  path to the .txt file that contains the puzzle text
 *
 * Output:
* Runtime in ms of each algorithim
 */
package problem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author austindase
 */
public class Problem2 {

    private static int getFrequency(int[] array, int num) {
        int count =0;
        int x;
       for(x=0;x<array.length;x++){
           if(num == array[x]){
               count++;
           }
       }
       return count;
    }

    /**
     * @param args the command line arguments
     */
    //public int allcounter =0;
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        int sampleArySize = 10;
        //int[] sampleAry = new int[sampleArySize];
        int[] sampleAry = {0,1,1,1,2};
        //System.out.println("Please Enter the path to your puzzle doc:");
        //String file_name = reader.nextLine();
        //String  file_name = "/Users/austindase/Desktop/600/testdataHW3.txt";    
        String[] file = new String[] {
            "/Users/austindase/Desktop/600/Majex1.txt",
            "/Users/austindase/Desktop/600/Majex2.txt",
            "/Users/austindase/Desktop/600/Majex3.txt",
            "/Users/austindase/Desktop/600/Majex4.txt"};
        
        int x;
        for(x=0;x<4;x++){
            String file_name = file[x];
        int[][] aryPuzzle = readLines(file_name);
        //System.out.println("Current File: " + file_name);
        
        /*
         //System.out.println("Current File: " + file_name);
         int[] aryPuzzle = new int[tempPuzzle[0].length];
         int one,two;
         int counter = 0;
         for(one=0;one<15;one++){
             for(two=0;two<15;two++){
             aryPuzzle[counter] = tempPuzzle[one][two];
                 
             }
         }
        
        */
        /*
        int length = aryPuzzle.length;
        int count;
        for(count=0;count<length;count++){
        int[] b = aryPuzzle[count];
        */
        int[] b = {1,1,1,1,1,1,1,1,6,6,6,6,6,6,6,6,6,6,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
            9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
        long startTime ;
        startTime     = System.currentTimeMillis();
        int nSquaredMax = nSquared(b);
        System.out.println("nSquared: " + (System.currentTimeMillis() - startTime));
        startTime     = System.currentTimeMillis();
        int nLogNMax = nLogN3(b);
        System.out.println("nlog: "+ (System.currentTimeMillis() - startTime));
        startTime     = System.currentTimeMillis();
        int n = n(b);
        System.out.println("n: " + (System.currentTimeMillis() - startTime));
           
         
       // }
   //*/     
 
        } 
   
    }
    
    public static int nSquared(int[] sampleAry){
        //System.out.println("nSquared +");
        int sampleArySize = sampleAry.length;
 //       //System.out.println("Array Size is: " + sampleArySize);
        int x,y;
        int currentInt, checkInt,counter;
        counter =0;
        //System.out.println("Half: " + sampleArySize/2 + "Length: " + sampleArySize);
        for(x=0;x<sampleArySize; x++){
            currentInt = sampleAry[x];
            counter = 0;
            for(y=0; y<sampleArySize; y++){
                checkInt = sampleAry[y];
                if(currentInt == checkInt){
                    counter++;
                    
                }
            }
              if(counter > sampleArySize/2){
                  //System.out.println("Counter 1: "+counter);
  //                   //System.out.println(currentInt + " is the majority element");
          //System.out.println("nSquared -+");           
  return currentInt;
                 }
        }
        //System.out.println("nSquared --");
        //System.out.println("Counter 1: "+ counter);
  //     //System.out.println("There was no majority element");
        return -1;
    }
  
    public static int nLogN(int[] sampleAry){
        int sampleArySize = sampleAry.length;
        if(sampleArySize == 1){
            return sampleAry[0];
        }
        int middle = sampleArySize/2;
        int[] tempAryLow = new int[middle];
        int[] tempAryHigh = new int[sampleArySize - middle];
        int x;
        for(x=0;x<middle;x++){
            tempAryLow[x] = sampleAry[x];
        }
        int counter = 0;
        for(x=middle;x<sampleArySize; x++){
            tempAryHigh[counter] = sampleAry[x];
            counter ++;
        }
        nLogN(tempAryLow);
        nLogN(tempAryHigh);
        return -1;
    }
    
    public static int nLogN2(int[] array){
    //    //System.out.println("");
   //     //System.out.println(" Times through. " + "Using: " + array.length);
   
        int length = array.length;
        if(length == 1){
            return array[0];
        }
        int middle = length/2;
        int[] leftAry = new int[middle];
        int[] rightAry = new int[length - middle];
        
        int x;
     //   //System.out.println("left: ");
        for(x=0;x<middle;x++){
            leftAry[x] = array[x];
     //       System.out.print(array[x]);
        }
        int counter = 0;
      //  //System.out.println("");
      //  //System.out.println("right: ");
        for(x=middle;x<length; x++){
            rightAry[counter] = array[x];
            counter ++;
       //     System.out.print(array[x]);
        }
    int leftSub = nLogN2(leftAry);
    int rightSub = nLogN2(rightAry);
    if(leftSub == rightSub){
        return leftSub;
    }
    int leftCount =0;
    int rightCount = 0;
    for(x=0;x<leftAry.length;x++){
        if (leftAry[x] == leftSub){
            leftCount++;
        }
    }
    for(x=0;x<leftAry.length;x++){
        if (leftAry[x] == leftSub){
            leftCount++;
        }
    }
    if (leftCount > middle){
        return leftSub;
    }else if(rightCount > middle){
        return rightSub;
    }else{
        return -1;
    }
    
    }
    
    public static int nLogN3(int[] array){
        int length = array.length;
       // //System.out.println("Step:: Length: " + length);
        if(length == 1){return array[0];}
        int half = length/2;
        
                //build an array from each half
                int[] leftAry = new int[half];
                int[] rightAry = new int[length - half];
                int x;
                
                for(x=0;x<half;x++){
                    leftAry[x] = array[x];
                }
                int counter = 0;
                for(x=half;x<length; x++){
                    rightAry[counter] = array[x];
                    counter ++;
                }
                /// arrays built
       int elemlsub = nLogN3(leftAry);
       int elemrsub = nLogN3(rightAry);
       if (elemlsub == elemrsub){return elemlsub;}
       int lcount = getFrequency(array,elemlsub);
       int rcount = getFrequency(array,elemrsub);
       if (lcount > half){
           return elemlsub;
       }else if(rcount > half){
           return elemrsub;
       }
       ////System.out.println("R: "+elemrsub+" count: "+ rcount + ", L: "+ elemlsub + " count: " + lcount);
       return -1;
    }
    
    public static int n(int[] array){
        int x;
        int length = array.length;
        int mode;
        int count =0;
        int majIndex =0;
        int middle = length/2;
	 //System.out.println("Half: " + middle + "Length: " + length);
        int i;
	for (i = 1;i<length;i++){
	
		if(array[majIndex] == array[i]){
			count++;
                       // //System.out.println("Count: "+ count);
        }else{ count--;
                                if (count == 0){
			majIndex = i;
			count = 1;}}
	} 
        mode = array[majIndex];
        
        if (majIndex>0){
            //System.out.println("Counter n: "+mode);
            return mode;
        }else{
            //System.out.println("Counter n: "+mode);
            return -1;
        }
    }
    
    
      static int[][] readLines(String path) throws IOException {
  //  //System.out.println(path);
    FileReader file_to_read = new FileReader(path);
    BufferedReader bf = new BufferedReader(file_to_read);
    BufferedReader bf2 = new BufferedReader(file_to_read);
//int[][] tempPuzzle = new int[15][15];
//Scanner scanner = new Scanner(file_to_read);

int count = 0;
int length2 = 0;
String tempString;
while((tempString = bf.readLine()) != null)
{
    String[] lineAr1 = tempString.split(" ");
    length2 = lineAr1.length;
count++;
}
  int[][] largeArray = new int[count][length2];  

int counter = 0;
String line;
while((line = bf.readLine()) != null)
{
    
     String value =" ";
    
   counter++;
    
    String[] lineAr = line.split(" ");
    int length = lineAr.length;
    int[]sampleAry = new int[length];
    int innerCounter = 0;
    ////System.out.println(""+ path);
    while(innerCounter< length){ 
        String tempStr = lineAr[innerCounter].trim();
        //System.out.print(lineAr[innerCounter].trim());
        int num = Integer.parseInt(tempStr);
        //tempPuzzle[outerCounter][innerCounter] = num;
        sampleAry[innerCounter] = num;       
        //System.out.print(num + ", ");
       //System.out.print(num + ", ");
        innerCounter++;
    }
largeArray[counter] = sampleAry;
    
}
        
return largeArray;    
}
}
