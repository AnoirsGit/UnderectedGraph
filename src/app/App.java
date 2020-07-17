package app;

public class App {
    public static void main(String[] args) throws Exception {
        
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(2, 3);
        g.addEdge(3,4);
        g.addEdge(4, 5);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(2, 0);
        System.out.println( g.toString());
        System.out.println();
        g.DFS(0);
        g.Bipartite(0);
        System.out.println(g.isBipartite());
        // System.out.println( g.isBipartite());
        // System.out.println(g.isCyclic());
    }

}