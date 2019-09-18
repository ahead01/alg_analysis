package avl;
/**
 *
 * @author austindase
 */
public class AVLTree {
    Node root;
    private static final int MAX = 9999999;
    int nodes;
    int maxDepth;
    public AVLTree() {
        root = null;
        nodes = 0;
        maxDepth = 0;
    }
    public AVLTree(Node x) {
        root = x;
        nodes = 1;
        maxDepth = 0;
    }
    public void inOrder(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        inOrder(rootNode.rightChild);
        String str = "";
        for (int x = 0; x < Math.abs(6 - rootNode.height); x++) {
            if (x < Math.abs(6 - rootNode.height) - 1) {
                str = str + "|      ";
            } else {
                str = str + "|------";
            }
        }
        System.out.println(str + rootNode.value + ":" + rootNode.height + ":" + rootNode.freq);
        inOrder(rootNode.leftChild);
    }
    public void insert(Node newNode) {
        // System.out.println("" );
        // System.out.println("" );
        // System.out.println("Inserting " + newNode.value);
        if (root == null) {
            root = newNode;
            root.height = 0;
            root.balanceFactor = 0;
            return;
        }
        // int depth = 0;
        //int height = 0;
        Node currentNode = root;
        boolean skip = true;
        Stack stack = new Stack(MAX);
        Stack stack3 = new Stack(MAX);
        boolean insert = false;
        while (currentNode != null && insert == false) {
            if (!stack.isEmpty()) {
                // System.out.println(stack.peek().value + "PEEK");
            }
            if (newNode.value < currentNode.value) {
                stack.push(currentNode);
                stack3.push(currentNode);
                // System.out.println("stack.push(currentNode)");
                // currentNode.height++;
                //height++;
                if (currentNode.leftChild == null) {
                    newNode.height = 0;
                    currentNode.leftChild = newNode;
                    insert = true;
                }
                currentNode = currentNode.leftChild;
                skip = false;
            } else if (skip && newNode.value > currentNode.value) {
                stack.push(currentNode);
                stack3.push(currentNode);
                // System.out.println("stack.push(currentNode)");
                // currentNode.height++;
                // height++;
                if (currentNode.rightChild == null) {
                    newNode.height = 0;
                    currentNode.rightChild = newNode;
                    insert = true;
                }
                currentNode = currentNode.rightChild;
            } else if (newNode.value == currentNode.value && insert == false) {
                currentNode.freq++;
                return;
            }
            skip = true;
        }
        // finishing the insert, now check the tree
        // System.out.println("At the stack loop: " + stack.isEmpty());
        // for every node touched update the height info
        Node currentNode3 = currentNode;
        Stack stackFin = new Stack(MAX);
        int newH = 0;
        while (!stack.isEmpty()) {
           /*
            currentNode = stack.pop();
            if (currentNode.leftChild != null && currentNode.rightChild != null) {
                currentNode.height = larger(currentNode.leftChild.height, currentNode.rightChild.height)+1;
            }
            if (currentNode.leftChild != null && currentNode.rightChild == null) {
                currentNode.height = 
            }
            if (currentNode.leftChild == null && currentNode.rightChild != null) {
                currentNode.balanceFactor = currentNode.rightChild.height - -1;
            }   
            */
            
            
            
            
            newH = currentNode.height + 1;
            currentNode3 = stack.pop();
            stackFin.push(currentNode3);
            
            // stack3.push(currentNode3);
            // System.out.println(currentNode2.value);
            // currentNode2.depth++;
            if (currentNode3.height < newH) {
                currentNode3.height++;
            }
            currentNode = currentNode3;
  
        }
        
        
        
        
        //inOrder(root);
        Node currentNode2;
        Boolean rotate = true;
        while (rotate && !stack3.isEmpty()) {
            currentNode2 = stack3.pop();
            if (currentNode2.leftChild != null && currentNode2.rightChild != null) {
                currentNode2.balanceFactor = currentNode2.rightChild.height - currentNode2.leftChild.height;
            }
            if (currentNode2.leftChild != null && currentNode2.rightChild == null) {
                currentNode2.balanceFactor = (-1 - currentNode2.leftChild.height);
            }
            if (currentNode2.leftChild == null && currentNode2.rightChild != null) {
                currentNode2.balanceFactor = currentNode2.rightChild.height - -1;
            }
            //System.out.println("Balance for " + currentNode2.value + ": " + currentNode2.balanceFactor);
            if (Math.abs(currentNode2.balanceFactor) > 1) {
                Node alpha = currentNode2;
                Node parentAlpha = stack3.peek();

                //System.out.println("Alpha is: " + alpha.value);
                
                Node leftChild = currentNode2.leftChild;
                Node rightChild = currentNode2.rightChild;
                if (rotate && find(leftChild, newNode)) {
                    rightChild = leftChild.rightChild;
                    leftChild = leftChild.leftChild;
                    // left child of left child - single
                    if (rotate && find(leftChild, newNode)) {
                        //System.out.println("left child of left child - single " + newNode.value);
                        // Node x = alpha;
                        Node y = alpha.leftChild;
                        Node y1 = y.rightChild;
                        if (parentAlpha != null && parentAlpha.leftChild.value == alpha.value) {
                            parentAlpha.leftChild = y;
                            //System.out.println("Parent is: " + parentAlpha.value);
                        } else if (parentAlpha != null && parentAlpha.rightChild.value == alpha.value) {
                            parentAlpha.rightChild = y;
                            //System.out.println("Parent is: " + parentAlpha.value);
                        } else {
                            //System.out.println("Parent is: root");
                            root = y;
                        }
                        alpha.leftChild = y1;
                        y.rightChild = alpha;
                        alpha.height = alpha.height - 2;
                        rotate = false;
                    }
                    // right child of left child - double
                    if (rotate && find(rightChild, newNode)) {
                        System.out.println("right child of left child - double " + newNode.value);
                        // rightLeftDoubleRoatate(alpha, alpha.leftChild);
                        Node x = alpha;
                        Node y = x.leftChild;
                        Node z = y.rightChild;
                        Node L = z.leftChild;
                        Node R = z.rightChild;
                        if (parentAlpha != null && parentAlpha.leftChild.value == alpha.value) {
                            parentAlpha.leftChild = z;
                        } else if (parentAlpha != null && parentAlpha.rightChild.value == alpha.value) {
                            parentAlpha.rightChild = z;
                        } else {
                            root = z;
                        }
                        z.rightChild = x;
                        z.leftChild = y;
                        x.leftChild = R;
                        y.rightChild = L;
                        z.height++;
                        x.height = x.height - 2;
                        y.height--;
                        rotate = false;
                    }
                }
                if (rotate && find(rightChild, newNode)) {
                    leftChild = rightChild.leftChild;
                    rightChild = rightChild.rightChild;
                    // left child of right child - double
                    if (rotate && find(leftChild, newNode)) {
                        System.out.println("left child of right child - double " + newNode.value);
                        Node x = alpha;
                        Node y = x.rightChild;
                        Node z = y.leftChild;
                        Node L = z.leftChild;
                        Node R = z.rightChild;
                        if (parentAlpha != null && parentAlpha.leftChild.value == alpha.value) {
                            parentAlpha.leftChild = z;
                        } else if (parentAlpha != null && parentAlpha.rightChild.value == alpha.value) {
                            parentAlpha.rightChild = z;
                        } else {
                            root = z;
                        }
                        z.leftChild = x;
                        z.rightChild = y;
                        x.rightChild = L;
                        y.leftChild = R;
                        z.height++;
                        x.height = x.height - 2;
                        y.height--;
                        rotate = false;
                    }
                    // right child of right child - single
                    if (rotate && find(rightChild, newNode)) {
                        System.out.println("right child of right child - single " + newNode.value);
                        // Node x = alpha;
                        Node y = alpha.rightChild;
                        Node y1 = y.leftChild;
                        if (parentAlpha != null && parentAlpha.leftChild.value == alpha.value) {
                            parentAlpha.leftChild = y;
                        } else if (parentAlpha != null && parentAlpha.rightChild.value == alpha.value) {
                            parentAlpha.rightChild = y;
                        } else {
                            root = y;
                        }
                        alpha.rightChild = y1;
                        y.leftChild = alpha;
                        alpha.height = alpha.height - 2;
                        rotate = false;
                    }
                }
            }
        }
        Node cn = null;
        while (!stackFin.isEmpty()) {
            cn = stackFin.pop();
            if (cn.leftChild != null && cn.rightChild != null) {
                cn.height = larger(cn.leftChild.height, cn.rightChild.height) + 1;
            } else if (cn.leftChild == null && cn.rightChild != null) {
                cn.height = cn.rightChild.height + 1;
            } else if (cn.leftChild != null && cn.rightChild == null) {
                cn.height = cn.leftChild.height + 1;
            }else{
                cn.height = 0;
            }

        }
    }
    public void delete(Node node) {
        if(root == null || find(root, node) == false){
            return;
        }
        Node delNode = getNode(root, node);
        int val = delNode.value;
        Node parent = findParent(root, val);
        boolean run = true;
        Stack stack = new Stack(MAX);
        //case 0 parent is null so root is the node
        if(node.value == root.value){
               Node currentNode = delNode.rightChild;
                int count = 0;
                while (currentNode != null) {
                    stack.push(currentNode);
                    count++;
                    currentNode = currentNode.leftChild;
                }
                Node candidate = stack.peek();
                Node R = candidate.rightChild;
                Node cParent = findParent(root, candidate.value);
                cParent.rightChild = R;
                delete(candidate);
                root = candidate;
                System.out.println("Candidate = root ");
                if(candidate != delNode.rightChild){
                candidate.rightChild = delNode.rightChild;
                }
                candidate.leftChild = delNode.leftChild;
                run = false;
        }
       
        //Case 1 no children
        if (run && delNode.height == 0) {
            System.out.println("Case 1 no children");
            if (parent.leftChild != null && parent.leftChild.value == delNode.value) {
                System.out.println("right right right");
                parent.leftChild = null;
                run = false;
            }
            if (run && parent.rightChild != null && parent.rightChild.value == delNode.value) {
                System.out.println("right right right");
                parent.rightChild = null;
                run = false;
            }
        }
        
//case 2 1 child
        if (run && delNode.leftChild == null && delNode.rightChild != null) {
            System.out.println("Case 2, 1 children, left null right not null");
            if (parent.leftChild != null && parent.leftChild.value == delNode.value) {
                System.out.println("Case 2, 1 children - leftChild");
                parent.leftChild = null;
                parent.leftChild = delNode.rightChild;
                run = false;
            }
            if (run && parent.rightChild != null && parent.rightChild.value == delNode.value) {
                System.out.println("Case 2, 1 children - rightChild");
                parent.rightChild = null;
                parent.rightChild = delNode.rightChild;
                run = false;
            }
        }
        if (run && delNode.leftChild != null && delNode.rightChild == null) {
            System.out.println("Case 2, 1 children, left not null and right null");
            if (run && parent.leftChild != null && parent.leftChild.value == delNode.value) {
                parent.leftChild = delNode.leftChild;
                run = false;
            }
            if (run && parent.rightChild != null && parent.rightChild.value == delNode.value) {
                parent.rightChild = delNode.leftChild;
                run = false;
            }
        }
        
        //case 3 2 children
        if (run && delNode.leftChild != null && delNode.rightChild != null) {
            System.out.println("Case 3, 2 children");
            
            //System.out.println(delNode.value);
            //System.out.println(parent.value);
            
            if (parent.leftChild != null && parent.leftChild.value == delNode.value) {
                
                //del is parents left child
                
                Node currentNode = delNode.rightChild;
                int count = 0;
                while (currentNode != null) {
                    stack.push(currentNode);
                    count++;
                    currentNode = currentNode.leftChild;
                }
                Node candidate = stack.peek();
                Node R = candidate.rightChild;
                Node cParent = findParent(root, candidate.value);
                cParent.rightChild = R;
                delete(candidate);
                parent.leftChild = candidate;
                System.out.println("Parent: "+ parent.value);
                if(candidate != delNode.rightChild){
                candidate.rightChild = delNode.rightChild;
                }
                candidate.leftChild = delNode.leftChild;
                run = false;
            }
            if (run && parent.rightChild != null && parent.rightChild.value == delNode.value) {
                //del is parents right child
                //Stack stack = new Stack(MAX);
                Node currentNode = delNode.rightChild;
                int count = 0;
                while (currentNode != null) {
                    stack.push(currentNode);
                    count++;
                    currentNode = currentNode.leftChild;
                }
                Node candidate = stack.peek();
                Node R = candidate.rightChild;
                Node cParent = findParent(root, candidate.value);
                delete(candidate);
                cParent.leftChild = R;
                parent.rightChild = candidate;
                if(candidate != delNode.rightChild){
                candidate.rightChild = delNode.rightChild;
                }
                candidate.leftChild = delNode.leftChild;
                run = false;
            }
            
            Node cn = null;
           while (!stack.isEmpty()) {
            cn = stack.pop();
            if (cn.leftChild != null && cn.rightChild != null) {
                cn.height = larger(cn.leftChild.height, cn.rightChild.height) + 1;
            } else if (cn.leftChild == null && cn.rightChild != null) {
                cn.height = cn.rightChild.height + 1;
            } else if (cn.leftChild != null && cn.rightChild == null) {
                cn.height = cn.leftChild.height + 1;
            }else{
                cn.height = 0;
            }
           }
        }
    }
    private Node leftMost(Node root) {
        Stack stack = new Stack(MAX);
        Node currentNode = root;
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.leftChild;
        }
        return stack.pop();
    }
    public Node findParent(Node root, int delNode) {
        if (root == null) {
            System.out.println("root == null");
            return null;
        }
        if (root.value == delNode) {
            System.out.println("root == value so no parent");
            return null;
        }
        Stack stack = new Stack(MAX);
        Node currentNode = root;
        Node parent = null;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode == null) {
                currentNode = stack.pop();
                //System.out.println(currentNode.value);
if(currentNode.leftChild != null && currentNode.leftChild.value ==  delNode){
    //System.out.println("found parent" + stack.peek().value);
    return currentNode;
}
if(currentNode.rightChild != null && currentNode.rightChild.value ==  delNode){
    //System.out.println("found parent" + stack.peek().value);
    return currentNode;
}
                //System.out.println(currentNode.value);
                currentNode = currentNode.rightChild;
            } else {
                stack.push(currentNode);
                parent = currentNode;
                currentNode = currentNode.leftChild;
            }
        }
        System.out.println("Parent not found");
        return null;
    }
    
    private void decreaseHeight(Node y) {
        if (y == null) {
            return;
        }
        decreaseHeight(y.leftChild);
        y.height--;
        decreaseHeight(y.rightChild);
    }
    private void increaseHeight(Node y) {
        if (y == null) {
            return;
        }
        increaseHeight(y.leftChild);
        y.height++;
        increaseHeight(y.rightChild);
    }
    public boolean find(Node root, Node find) {
        if (root == null) {
            return false;
        }
        if (root.value == find.value) {
            return true;
        }
        Stack stack = new Stack(MAX);
        Node currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode == null) {
                currentNode = stack.pop();
                if (currentNode.value == find.value) {
                    return true;
                }
                //System.out.println(currentNode.value);
                currentNode = currentNode.rightChild;
            } else {
                stack.push(currentNode);
                currentNode = currentNode.leftChild;
            }
        }
        return false;
    }
    
    
    
        public Node getNode(Node root, Node find) {
        if (root == null) {
            System.out.println("root is noull in get node");
            return null;
        }
        if (root.value == find.value) {
            System.out.println("root is value in get node");
            return root;
        }
        Stack stack = new Stack(MAX);
        Node currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode == null) {
                currentNode = stack.pop();
                if (currentNode.value == find.value) {
                    System.out.println("value is: " + currentNode.value+ " in get node");
                    return currentNode;
                }
                //System.out.println(currentNode.value + ":" +find.value);
                currentNode = currentNode.rightChild;
            } else {
                stack.push(currentNode);
                currentNode = currentNode.leftChild;
            }
        }
        System.out.println("did not get node");
        return null;
    }

    private int larger(int x, int y) {
        if(x>y){
            return x;
        }
        if(y>x){
            return y;
            
        }else{
            return x;
        }


    }
    
            
        public void preOrder(Node root) {
            if(root !=  null) {
                
                //Visit the node by Printing the node data  
                //System.out.println(root.word);
                int depth = root.height;
                //System.out.println(depth);
                String[] temp = new String[depth];
                int count = 0;
                String spaces = "";
                while(count<10 - depth){
                    spaces = spaces + "  ";
                    count++;
                   // System.out.println(count);
                }
                System.out.println(spaces + root.value);
                preOrder(root.leftChild);
                preOrder(root.rightChild);
                
                }
             }
        
           public void allAndFreq(Node root) {
            if(root !=  null) {
                
                System.out.println(root.value + ":" + root.freq);
                allAndFreq(root.leftChild);
                
                allAndFreq(root.rightChild);
                
                }
             }
}
