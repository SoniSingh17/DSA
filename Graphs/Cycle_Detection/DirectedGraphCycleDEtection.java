package Cycle_Detection;

import java.util.ArrayList;

public class DirectedGraphCycleDEtection {
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
        /*
         *    > 1----> 2
         *  /   ^      |
         * 0    |      |
         *  \   |      >
         *    > 4<-----3      
         * 
         */
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 4));

        // graph[4].add(new Edge(4, 1)); cycle is removed ...
    }
    public static boolean dfs(ArrayList<Edge> graph[] , int cur , boolean rec[] ,boolean visit[]){
        visit[cur]=true;
        rec[cur]=true;
        for(int i=0 ; i<graph[cur].size() ; i++){
            Edge e = graph[cur].get(i);
            if(rec[e.des]==true){
                return true;
            }
            else if(!visit[e.des]){
                if (dfs(graph , e.des , rec , visit))  return true;
            }


        }
        rec[cur]=false;
        return false;
      
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);
        boolean visit[] = new boolean[V];
        boolean rec[] = new boolean[V];

        System.out.println("Cycle detected : " + dfs(graph ,0,rec,visit ));
       

        
    }
    
}
