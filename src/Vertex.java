public class Vertex {
    private char label;
    private boolean isVisited;
    private double cost;
    private Vertex tail = null;
    public Vertex (char label){
        this.label = label;
    }  
    
    public Vertex (){
        
    }
    
    public Vertex (char label , double cost){
        this.label = label;
        this.cost = cost;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }    

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Vertex getTail() {
        return tail;
    }

    public void setTail(Vertex tail) {
        this.tail = tail;
    }
    
    
    
}
