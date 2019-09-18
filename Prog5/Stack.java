/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

/**
 *
 * @author austindase
 */
public class Stack {
   private final int maxSize;
   private final Node[] stackArray;
   private int top;
   
   public Stack(int s) {
      maxSize = s;
      stackArray = new Node[maxSize];
      top = -1;
   }
   @SuppressWarnings("ValueOfIncrementOrDecrementUsed")
   public void push(Node j) {
      stackArray[++top] = j;
   }
   @SuppressWarnings("ValueOfIncrementOrDecrementUsed")
   public Node pop() {
       if(top == -1){
           return null;
       }
      return stackArray[top--];
   }
   public Node peek() {
        if(top == -1){
           return null;
       }
      return stackArray[top];
   }
   public boolean isEmpty() {
      return (top == -1);
   }
   public boolean isFull() {
      return (top == maxSize - 1);
   }
}
