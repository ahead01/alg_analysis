

package program6;

/**
 *
 * @author austindase
 */
import java.util.NoSuchElementException;

public class Heap {

    int heapSize;
    int[] heap;
    int swap;

    public Heap(int x) {
        heapSize = 0;
        heap = new int[x];

    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

//get child's parent's index 
    public int parent(int child) {
        return (int) Math.floor((child - 1) / 2);
    }

//get index of n th child of x 
    public int nChild(int x, int n) {
        int y = 2 * x + n;
        return y;
    }

    public void insert(int x) {

        heap[heapSize++] = x;
        percolateUp(heapSize - 1);
    }

//return min in a min heap
    public int findMin() {
 
        return heap[0];
    }

    /**
     * delete element at index
     *
     * @param ind
     * @param empty
     * @return  *
     * @throws java.lang.Exception
     */
    public int delete(int ind, Exception empty) throws Exception {
        if (isEmpty()) {
            throw empty;
        }
        int delItem = heap[ind];
        heap[ind] = heap[heapSize - 1];
        heapSize--;
        percolateDown(ind);
        return delItem;
    }

//percolateUp
    public void percolateUp(int childIndex) {
    
        int tmp = heap[childIndex];
        int parentIndex;
        while (tmp < heap[parent(childIndex)] && childIndex > 0) {
            //System.out.println("AT LINE 89");
            parentIndex = parent(childIndex);
            heap[childIndex] = heap[parentIndex];
            childIndex = parent(childIndex);
            swap++;
        }
        heap[childIndex] = tmp;
    }

//percolate down
    public void percolateDown(int index) {
        int child;
        int count = 0;
        int tmp = heap[index];
        while (nChild(index, 1) < heapSize) {
            count++;
            ////System.out.println("AT LINE 91" + count);
            child = minChild(index);
            if(child == -1){
                
            break;
            }
            if (heap[child] < tmp) {
                heap[index] = heap[child];
                swap++;
            } else {
                //die
                //next
                break;
            }
            index = child;
        }
        heap[index] = tmp;
    }
    
    
    //percolate down
    public void percolateDown2(int index) {
        int child;
        int count = 0;
      if(true){
          
      }
    
    }

//return smallest child's index
    private int minChild(int index) {
        int child1 = nChild(index, 1);
        int child2 = nChild(index, 2);
        System.out.print("Children: " + heap[child1] +","+heap[child2]);
        if(child1 > heapSize){
            if(child2 > heapSize){
                System.out.println("  | NO CHILD");
                return -1;
            }else{
                System.out.println("   child2-a " + heap[child2]);
                return child2;
            }
        }else{
            if(child2 > heapSize){
                System.out.println("   child1-b" + heap[child1]);
                return child1;
            }else{
                if(heap[child1] < heap[child2]){
                    System.out.println("   child1-c " + heap[child1]);
                    return child1;
                }else{
                    System.out.println("   child2 -d" + heap[child2]);
                    return child2;
                }
            }
        }

    }


//build heap from array 
    public void buildHeap(int[] array) {
        heap = array.clone();
        heapSize = array.length -1;
        System.out.println("heapSize=" + heapSize);
        swap = 0;
        int h = (int) Math.floor((Math.log(array.length)) / (Math.log(2)));
        //System.out.println("H: " + h);
        int currentIndex = (int) (Math.pow(2, h-1) - 1);
        while (currentIndex != -1 ) {
            System.out.println("At index: " + currentIndex + " Value: " + heap[currentIndex]);
            int minChild = minChild(currentIndex);
            int error1 = heap[minChild];

            if (minChild != -1 && heap[minChild] < heap[currentIndex]) {
                int parent = heap[currentIndex];
                heap[currentIndex] = heap[minChild];
                swap++;
                heap[minChild] = parent;
                percolateDown(minChild);
            }
//int parentIndex = parent(currentIndex);
//if(heap[parentIndex]<heap[currentIndex]){
//            percolateUp(currentIndex);
//}
            currentIndex--;
        }

    }

    public void printHeap() {
        System.out.println("");
        int level = 0;
        int count = 0;
        int full = (int) (Math.pow(2, (level + 1)) - 1);
        for (int x = 0; x < heapSize; x++) {

            if (x == full) {
                level++;
                count = 0;
                full = (int) (Math.pow(2, (level + 1)) - 1);
                System.out.println("");
            }
            System.out.print(heap[x] + "     ");
        }
    }
}


/*
 
public void printHeap(){
                System.out.println("");
                int level = 0;
                int count = 0;
                int full = (int) (Math.pow(2, (level +1)) -1);
                for(int x = 0; x<size; x++){
                               
                                if(x == full){
                                                level++;
                                                count = 0;
                                                full = (int) (Math.pow(2, (level +1)) -1);
                                                System.out.println("");
                                }
                                System.out.print(array[x] + "     ");
                }
}
 
 
 
 
public void insert(int i) {
heap[heapSize++] = i;
                int parentIndex = (int) Math.floor((heapSize-1)/2);
                int currentIndex = heapSize;
                int parent  = heap[parentIndex];
                int current = heap[heapSize];
               
                while(parent < current){
                                heap[parentIndex] = current;
                                heap[currentIndex] = parent;
                                current = heap[parentIndex];
                                parentIndex = (int) Math.floor((parentIndex-1)/2);
                                parent = heap[parentIndex];
                }
}
}
*/
