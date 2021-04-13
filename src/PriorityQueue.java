
public class PriorityQueue {

    private int length;
    private Vertex[] pq;
    private int index;

    public PriorityQueue(int length){
        this.length = length;
        this.pq = new Vertex[length];
        this.index = 0;
    }    
    
    public boolean insert(Vertex vertex){
        if (isFull()) {
            return false;
        }
        this.pq[index] = vertex;
        index++;
        return true;
    }
    
    public boolean isFull(){
        if (index == length-1) {
            return true;
        }
        return false;
    }
    
    public boolean isEmpty(){
        if (index == 0) {
            return true;
        }
        return false;
    }
        
    public Vertex deleteMin() {

        double min_cost;
        int indexShift; // The second var. is for shifting in the next loop after deleting.
        min_cost = Integer.MAX_VALUE;
        indexShift = 0; //After knowing The vertex's index that removed, we'll do the shifting starting from that index.
        Vertex temp = new Vertex();

        for (int i = 0; i < this.index; i++) {
            if (pq[i].getCost() < min_cost) {
                min_cost = pq[i].getCost();
                temp = pq[i];
                indexShift = i;
            }
        }

        for (int i = indexShift; i < this.index - 1; i++) {
            pq[i] = pq[i + 1]; //Shifting
        }
        this.index--;
        return temp; //Return Vertex with least cost.

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    
}
