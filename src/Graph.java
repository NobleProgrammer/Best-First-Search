public class Graph {
    private Vertex vertexList [];
    private int adjMatrix [][];
    private int index = 0;
    private int vertexListLength;
    private String bfs = "";
    private PriorityQueue pq;
    
    public Graph(int vertexListLength){
        this.pq = new PriorityQueue(vertexListLength);
        this.vertexList = new Vertex[vertexListLength];
        this.adjMatrix = new int[vertexListLength][vertexListLength];
        this.vertexListLength = vertexListLength;
    }
    
    public int addVertex (char label,double cost) {
        if (index >= vertexListLength) {
            return -1;
        }
        if (isExists(label)) {
            return 0;
        }
        this.vertexList[index] = new Vertex(label , cost);
        this.index++;
        return 1;
    }
    
    public boolean addEdge (char vertex1 , char vertex2){
        if (!isExists(vertex1) || !isExists(vertex2)) {
            return false;
        }
        int index1 = -1;
        int index2 = -1;
        //Find the index of both vertices.
        for (int i = 0; i < vertexListLength; i++) {
            if (vertexList[i].getLabel() == vertex1)
                index1 = i;
            else if (vertexList[i].getLabel() == vertex2)
                index2 = i;
            if (index1 != -1 && index2 != -1) {
                break;
            }
        }
        if (adjMatrix[index1][index2] != 0) {
            return false;
        }
        //Because it's Undirected graph.
        this.adjMatrix[index1][index2] = 1;
        this.adjMatrix[index2][index1] = 1;
        return true;
    }
    
    private boolean isExists(char vertex){
        for (int i = 0; i < index; i++) {
            if (vertexList[i].getLabel() == vertex) {
                return true;
            }
        }
        return false;
    }
    
    public void displayAdjMatrix() {
        //the output given below
        System.out.printf("%-8s", ""); 
        for (int i = 0; i < vertexList.length; i++) {
            System.out.printf("%-5c" , vertexList[i].getLabel());
        }
        System.out.println("");
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.printf("%-2s%-6c","", vertexList[i].getLabel());
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.printf("%-5d", adjMatrix[i][j]); 
            }
            System.out.println("");
        }
    }
    
    private int searchIndex(char vertex){
        for (int i = 0; i < vertexListLength; i++) {
            if (vertexList[i].getLabel() == vertex) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean bfsTraversal(char start){
        clearPQ();
        setNullTail();
        setUnvisited();
        int index = searchIndex(start);
        if (index == -1) {
            return false;
        }
        this.pq.insert(vertexList[index]);
        while(!pq.isEmpty()){
            Vertex temp = pq.deleteMin();
            index = searchIndex(temp.getLabel());
            this.bfs += temp.getLabel() + " ";
            for (int i = 0; i < vertexListLength; i++) {
                if (adjMatrix[index][i] != 0 && !vertexList[i].isIsVisited()) {
                    vertexList[i].setIsVisited(true);
                    pq.insert(vertexList[i]);
                }
            }
            temp.setIsVisited(true);
        }
        return true;
    }
    
    private void setNullTail(){
        for (int i = 0; i < vertexListLength; i++) {
            vertexList[i].setTail(null);
        }
    }
    
    private void clearPQ(){
        pq.setIndex(0);
    }
    
    private void setUnvisited(){
        for (int i = 0; i < vertexListLength; i++) {
            vertexList[i].setIsVisited(false);
        }
    }
    
    public String bfs(char start , char goal){
        clearPQ();
        setNullTail();
        setUnvisited();
        int index = searchIndex(start);
        if (index == -1) {
            return "Start node doesn't exists.";
        }
        this.pq.insert(vertexList[index]);
        while(!pq.isEmpty()){
            Vertex temp = pq.deleteMin();
            index = searchIndex(temp.getLabel());
            if (temp.getLabel() == goal) {
                return "Goal is found!\nBFS: " + getPath(temp);
            }
            for (int i = 0; i < vertexListLength; i++) {
                if (adjMatrix[index][i] != 0 && !vertexList[i].isIsVisited()) {
                    vertexList[i].setIsVisited(true);
                    vertexList[i].setTail(temp);
                    pq.insert(vertexList[i]);
                }
            }
            temp.setIsVisited(true);
        }
        return "Goal is not found.";
    }
    
   private String getPath (Vertex goal){
        Vertex temp = goal;
        String path = "";
        double cost = 0;
        while(temp != null){
            path += temp.getLabel() + " ";
            cost += temp.getCost();
            temp = temp.getTail();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(path);
        sb.reverse();
        path = sb.toString() + "";
        path += "\nCost: " + cost;
        return path;
    }
   
    public void printVertices (){
        for (int i = 0; i < vertexListLength; i++) {
            System.out.println(i + " " + vertexList[i].getLabel());
        }
    }

    public String getBfs() {
        return bfs;
    }    
}