/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author austindase
 */
public class AVL {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        AVLTree newTree = new AVLTree();
        
        //int[] array = {6,4,5,10,9,1};
        int[] array = {
            1,2,3
            //9,20,4,30,1,15,6,5,3,7,14,16//,21,31
        };
        String path = "/Users/austindase/Desktop/600/Prog5/AVLinput.txt";
        
                
    FileReader file_to_read = new FileReader(path);
    BufferedReader bf = new BufferedReader(file_to_read);
    
    
int counter = 0;
String line = "";
String text = "";
while((line = bf.readLine()) != null)
{
text = text + " " + line;
    counter++;
}
text = text.replaceAll("\\s","");
System.out.println(text);
String[] finalAry = text.split(",");
int length = finalAry.length;
String check;
Matcher m;
//String digit = "(\\d.+)";
//Pattern r = Pattern.compile(digit);
counter =0;
while(counter < length){
    String sign = finalAry[counter].substring(0,1);
    String digit = finalAry[counter].substring(1);
    System.out.println("sign: "+ sign+ "digit: "+digit);
    int x = Integer.parseInt(digit);
        Node y = new Node(x);
    if("+".equals(sign)){
        if(y != null){
         System.out.println("Insert: " + y.value);
        newTree.insert(y);  
        //inOrder(newTree);
        }
        
    }else if("-".equals(sign)){
        if(y != null){
        System.out.println("Delete: " + y.value);
        newTree.delete(y);
        //inOrder(newTree);
        }
    }
        
    counter++;
}
    
       /* 
        int length = array.length;
        int counter = 0;
        
        while(counter < length){
        Node node = new Node(array[counter]);
        newTree.insert(node);
        counter++;
        }
        
        */
    // Node temp = newTree.root;
      // inOrder(newTree);
       //Node x = new Node(98);
       //newTree.delete(x);
       //System.out.println(newTree.findParent(newTree.root, x.value));
       //inOrder(newTree);
       //Node y= new Node(93);
       //Node z = new Node(93);
       //newTree.delete(y);
       //newTree.delete(y);
       System.out.println("Format:\nValue:Height:Frequency");
       inOrder(newTree);
       newTree.preOrder(newTree.root);
       newTree.allAndFreq(newTree.root);
       
    }
   public static void inOrder(AVLTree tree){
        tree.inOrder(tree.root);
    }
    private static void readLines(String path) throws FileNotFoundException, IOException {
    }
    
}
