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
public class BST {
    static String name;
    node root;
        
    public BST(String str){
            name = str;
            root = null;
    }
    
    public String getMin(){
     String min = null;
        return min;
    }
    public String getMax(){
        String max = null;
        return max;
    }
    public void insert(node newNode){
        node currentNode = root;
        
        if (currentNode == null){
            root = newNode;
            return;
        }
        
        String newWord = newNode.word;
        int depth = newNode.depth;
        while(true){
            node parent = currentNode;
            String currentWord = currentNode.word;
            int compare = newWord.compareTo(currentWord);

            if(compare<0){
                currentNode = currentNode.leftChild;
                depth++;
                if(currentNode == null){
                    newNode.depth = depth;
                    parent.leftChild = newNode;
                    return;
                }
            }
            if(compare>0){
                depth++;
                currentNode = currentNode.rightChild;
                if(currentNode == null){
                    newNode.depth = depth;
                    parent.rightChild = newNode;
                    return;
                }


            }
            if (compare == 0){
                parent.freq = currentNode.freq +1;
                return;
            }
        }
    }
  
    
    public void delete(node delNode){
        node parentNode = findParent(delNode);
        node currentNode = root;
        
        
        node leftChild = delNode.leftChild;
        node rightChild = delNode.rightChild;
        if (leftChild == null && rightChild == null){
            
        }
        
    }
    
    	public boolean find(node findNode){
		node currentNode = root;
                String findWord = findNode.word;
                String currentWord;
		while(currentNode!=null){
                    currentWord = currentNode.word;
                    int compare = findWord.compareTo(currentWord);
			if(compare == 0){
				return true;
			}else if(compare < 0){
				currentNode = currentNode.leftChild;
			}else{
				currentNode = currentNode.rightChild;
			}
		}
		return false;
	}
    
        public node findParent(node findNode){
		node currentNode = root;
                node parent = null;
                String findWord = findNode.word;
                String currentWord;
		while(currentNode!=null){
                    parent = currentNode;
                    currentWord = currentNode.word;
                    int compare = findWord.compareTo(currentWord);
			if(compare == 0){
				return parent;
			}else if(compare < 0){
				currentNode = currentNode.leftChild;
			}else{
				currentNode = currentNode.rightChild;
			}
		}
		return currentNode;
	}
        
//        public void printBST(){
//        	node currentNode = root;
//                String findWord = findNode.word;
//                String currentWord;
//                int n = 1;
//		while(currentNode!=null){
//                    
//                    currentWord = currentNode.word;
//                    node leftChild = currentNode.leftChild;
//                    node rightChild = currentNode.rightChild;
//                    String leftChildWord = leftChild.word;
//                    String rightChildWord = rightChild.word;
//                    int frequency = currentNode.freq;
//                    
// System.out.println("node: " + currentWord +" freq: "+ frequency + " leftChild: "+ leftChildWord + " rightChild: "+ rightChildWord);
//                    int compare = findWord.compareTo(currentWord);
//			if(compare == 0){
//				continue;
//			}else if(compare < 0){
//				currentNode = currentNode.leftChild;
//			}else{
//				currentNode = currentNode.rightChild;
//			}
//		n++;
//                }
//		System.out.println("Tree has " + n + " nodes.");    
//        }
//    
        public void preOrder(node root) {
            if(root !=  null) {
                
                //Visit the node by Printing the node data  
                //System.out.println(root.word);
                int depth = root.depth;
                //System.out.println(depth);
                String[] temp = new String[depth];
                int count = 0;
                String spaces = "";
                while(count<depth){
                    spaces = spaces + "  ";
                    count++;
                   // System.out.println(count);
                }
                System.out.println(spaces + root.word);
                preOrder(root.leftChild);
                preOrder(root.rightChild);
                
                }
             }
        
        public void inOrder(node root) {
            if(root !=  null) {
                
                inOrder(root.leftChild);
                System.out.println(root.word);
                //Visit the node by Printing the node data  
                //System.out.println(root.word);
                inOrder(root.rightChild);
                }
             }
}
