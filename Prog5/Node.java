/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;



public class Node {
    int value;
    int height;
    int balanceFactor;
    int freq;
    Node leftChild;
    Node rightChild;
    
    public Node(int x){
        value = x;
        height = 0;
        freq = 1;
        balanceFactor = 0;
        leftChild = null;
        rightChild = null;

    }
   

    
}
