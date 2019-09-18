/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author austindase
 */
public class Programming4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BST newTree = new BST("sample");
        String[] array = {"O","D","Z","G","M","R","A","L","U","P","H","C","S","J"};
        array = readLines("/Users/austindase/Desktop/600/Prog4/concordinput.txt");
        //array = readFile(); 
        int length = array.length;
        int counter = 0;
        while(counter < length){
            String string = array[counter];
            if(string != null){
            node tempNode = new node(string);
            newTree.insert(tempNode);
            }
            counter++;
        }
        
        newTree.inOrder(newTree.root);
        newTree.preOrder(newTree.root);
        //System.out.println("");
        //node test = newTree.root;
        //System.out.println(test.word);
        
        //System.out.println("");
     
        //System.out.print(test.leftChildStr());
        //System.out.print("    ");
        //System.out.print(test.rightChildStr());
        
    }
    
    public void readFile(String filePath){
        
    }
    
static String[] readLines(String path) throws IOException {
    //System.out.println(path);
    FileReader file_to_read = new FileReader(path);
    BufferedReader bf = new BufferedReader(file_to_read);

//Scanner scanner = new Scanner(file_to_read);

int counter = 0;
String line = "";
String text = "";
while((line = bf.readLine()) != null)
{
text = text + " " + line;
    counter++;
}

String[] finalAry = text.split(" ");
int length = finalAry.length;
String check;
Matcher m;
String pattern = "(\\d.+)";
Pattern r = Pattern.compile(pattern);

char firstChar;
boolean digit;
int count = 0;
while (count < length){
    finalAry[count] =  finalAry[count].replaceAll("\\s","");
    if("".equals(finalAry[count])){
        finalAry[count] = null;
    }
    count++;
}


count =0;
while (count < length){
    digit = false;
    check = finalAry[count];
    if (check != null && !"".equals(check)){
        //System.out.println("Check: " + check);
     firstChar = check.charAt(0);
      digit = Character.isDigit(firstChar);
    }
   // m = r.matcher(firstChar); 
    if(digit){
        finalAry[count] = "";
    }else if(check != null){
        finalAry[count] = check.toUpperCase();
    }
    count++; 
}
count = 0;

return finalAry;    
}
}
