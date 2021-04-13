


//بسم الله الرحمن الرحيم
import java.util.Scanner;
import java.io.*;

public class BFSMain {

    public static void main(String[] args) throws FileNotFoundException {
        
        File input = new File ("input.txt");
                
        Scanner sc = new Scanner(input);
        
        if(!sc.hasNext("Start")){
            System.out.println("incorrect file format, system will exit.");
            System.exit(1);
        } else sc.next(); // Sktip Start line.
        
        
        int numOfVertices = sc.nextInt();
        int numOfEdges = sc.nextInt();
        Graph graph = new Graph(numOfVertices);
        
        // Reading and storing vertices with their huristic cost.
        for (int i = 0; i < numOfVertices; i++) {
            char vertex = sc.next().charAt(0);
            double cost = sc.nextDouble();
            int success =  graph.addVertex(vertex , cost);
            if (success == 1) {
                System.out.println("Vertex " + vertex + " has been added.");
            } else if (success == -1) {
                System.out.println("Vertex " + vertex + " cannot be added, graph is full.");
            } else {
                System.out.println("Vertex " + vertex + " already exists.");
                i--;
            }
        }
        
        // Reading and storing edges.
        for (int i = 0; i < numOfEdges; i++) {
            char source = sc.next().charAt(0);
            char destination = sc.next().charAt(0);
            
            if (graph.addEdge(source, destination)) {
                    System.out.println("Edge has been added.");
                } else {
                    System.out.println("One or both vertices don't exist. Or this edge is already created.");
                    i--;
                }
        }
        System.out.println("");
        String x = sc.next(); // Skip END line.
        sc.close(); // Close reading from file, then read from user!
        
        sc = new Scanner (System.in);
        //Done Adding edges.
        graph.displayAdjMatrix();
        
        System.out.println("Enter Start and goal vertex for Best-First Search");
        System.out.print("Enter Start Vertex : ");
       char start = sc.next().charAt(0);
        System.out.print("Enter Goal Vertex : ");
       char goal = sc.next().charAt(0);
       System.out.println(graph.bfs(start, goal));
        System.out.print("Enter the starting vertex for Best-First Search Traversal : ");
        graph.bfsTraversal(sc.next().charAt(0));
        System.out.println("BFS : " + graph.getBfs());
        //Done Printing the AdjMatrix
    
        
    }

}
