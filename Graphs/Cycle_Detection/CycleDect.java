package Cycle_Detection;

import java.util.ArrayList;

public class CycleDect {
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
         * 
         *     1------3
         *   /        | \
         * 0          |   5---6       
         *  \         | /
         *    2-------4
         * 
         */
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }
    public static boolean UndirectedCycle(ArrayList<Edge> graph[] , boolean visit[] , int cur , int parent){
        visit[cur] = true;
        for(int i = 0 ; i<graph[cur].size() ; i++){
            Edge e = graph[cur].get(i);
            if(visit[e.des]==false){
                if(UndirectedCycle(graph, visit, e.des, cur) == true) return true;

            }
            if(visit[e.des]==true && parent!=e.des){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        boolean visit[] = new boolean[V];
        // Lets create the graph
        CreateGraph(graph);
        System.out.println("Does Cycle exist : "+UndirectedCycle(graph, visit, 0, -1));
        
    }
    
}
