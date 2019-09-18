/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming4;

/**
 *
 * @author austindase
 */
public class node {
        String word;
        int freq;
        int depth;
	node leftChild;
	node rightChild;	
	public node(String str){
		word = str;
                this.freq = 1;
                depth = 0;
		leftChild = null;
		rightChild = null;
	}
        public node getLeftChild(){
            node child = leftChild;
            return child;
        }
        public node getRightChild(){
            node child = leftChild;
            return child;
        }
        public String leftChildStr(){
            if(leftChild != null){
            node child = leftChild;
            String leftWord = child.word;
            return leftWord;
            }else{
                return "";
            }
        }
        public String rightChildStr(){
            if(rightChild != null){
            node child = rightChild;
            String rightWord = child.word;
            return rightWord;
            }else{
                return "";
            }
        }
 
}
