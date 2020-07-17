package app;


import java.util.LinkedList;
import java.util.Stack;



public class Graph{
    private int V;
    private LinkedList<Integer> visited ;
    int E;
    private LinkedList<Integer>[] adj;
    private LinkedList<Integer> Colored;
    private LinkedList<Integer> notColored;
    private boolean isBipartite =true;
    private boolean isCyclic=false;
    

    public Graph(int V){
        this.V=V;
        adj= (LinkedList<Integer>[]) new LinkedList[V];
        notColored=new LinkedList<>();
        Colored=new LinkedList<>();
        Colored.add(0);
        
        for(int i =0 ; i<V; i++){
            adj[i]= new LinkedList<>();
        }
        DFS(0);
    }
    void addEdge(int v, int w){
        E++;
        adj[v].addFirst(w);
        adj[w].addFirst(v);
    }
    int V(){
        return V;
    }
    int E(){
        return E;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];

    }

    boolean isCyclic(){
        return isCyclic;
    }
    
    
    public String toString(){
        String st =""; 
        String st2="";
        for (int i = 0 ; i<V ; i++){
            for(int j=0;j<adj[i].size();j++){
                st2+=adj[i].get(j)+" ";
            }
            st+=i+": "+st2+"\n" ;
            st2="";
        }
        return st;
    }
    public String toString(int v){
        String st2="";
        for(int j=0;j<adj[v].size();j++){
            st2+=adj[v].get(j)+" ";
        }
        return adj[v]+": "+st2+"\n";
    } 

    int c;
    public boolean isBipartite(){
        Bipartite(0);
        return isBipartite;
    }
    public void Bipartite(int v){
        
        
        System.out.println(v);
        visited.add(v);
        for(int i = 0; i<adj[v].size() ; i++){
            if(!Colored.contains(adj[v].get(i))){
                Colored.add(v); 
            }

            else if(!notColored.contains( adj[v].get(i))){{
                notColored.add(v);
            }
            
            if(Colored.contains(adj[v].get(i) ) && notColored.contains(adj[v].get(i))){
                isBipartite=false;
            }
            
            if(!visited.contains(adj[v].get(i))){
               DFS(adj[v].get(i)); 
            }
        }
        }
        
    }
    Stack<Integer> stack=new Stack<>();

    public void DFS(int v){
        
        visited = new LinkedList<>();
        stack.push(v);
        while(!stack.isEmpty()){
            int current = stack.pop();
            if(!visited.contains(current)){
                System.out.println((current));
                visited.add(current);
            }
            for(int i = 0 ;  i<adj[current].size();i++){
                if(!visited.contains(adj[current].get(i))){
                    stack.push(adj[current].get(i));
                }
            }
        }
    }
}
