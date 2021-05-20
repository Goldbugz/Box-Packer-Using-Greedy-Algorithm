//Written by Damien King
//implements a priority queue ussing a heap ADT

public class PriorityQueue <E> implements PriQue <E> {

    //E[] pq = (E[]) new queObject[1000];

    queObject<E> [] pq ;
    int currentSize = 0;


    public PriorityQueue(int size){
        pq =  new  queObject[size];
    }
//inserts an object into heap
    public void insert(int pri, E data) {
        if(currentSize != pq.length){
            queObject <E> newNode = new <E> queObject(pri, data);
            pq[currentSize] = newNode;
            trickleUp(currentSize++);
            //currentSize = currentSize++;
        }
    }

//removes the root node and reheaps the tree
    public E remove() {
        queObject <E> root = pq[0];
        pq[0]  = pq[--currentSize];
        trickleDown(0);
        return root.data;
    }

//checks if the structure is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    //trickles ups the tree and reheaps the structure
    public void trickleUp(int index){
        int parent = (index -1)/2;
        queObject<E> bottom = pq[index];

        while(index > 0 &&pq[parent].priority < bottom.priority){
            pq[index] = pq[parent];
            index = parent;
            parent = (parent-1)/2;
        }
        pq[index] = bottom;
    }

//trickles down the tree and reheaps the structure
    public void trickleDown(int index){
        int largerChild;
        queObject <E> top = pq[index];

        while(index < currentSize/2) {
           // System.out.println("loop");
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && pq[leftChild].priority < pq[rightChild].priority)
                largerChild = rightChild;
            else
                largerChild = leftChild;

            if (top.priority >= pq[largerChild].priority)
                break;

            pq[index] = pq[largerChild];
            index = largerChild;
        }
        pq[index] = top;
    }
}



