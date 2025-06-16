package Graphs.Implementation;
import java.util.ArrayList;


class GraphImplementation {
    static class  Edge{
        int src;
        int des;
        Edge(int src , int des){
            this.src = src;
            this.des = des;
        }
    }
    public static void CreateGraph( ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,1));
    }
    public static void main(String[] args) {
        int V = 4;
      ArrayList<Edge> graph[]= new ArrayList[V];
      CreateGraph(graph);
      // Lets Print neighbour of 2
      System.out.println("Neighbour of 2 is : ");
      for(int i = 0 ; i < graph[2].size() ; i++){
         Edge e = graph[2].get(i);
         System.out.println(e.des);
      }


        
    }

    
}


