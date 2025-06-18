// package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.Stack;

public class topoSort {
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
    public static void TopoSort(ArrayList<Edge> graph[] , boolean visit[] ,int cur , Stack<Integer> stack ){
        visit[cur] = true;
        for(int i = 0 ; i<graph[cur].size() ; i++){
            Edge e = graph[cur].get(i);
            if(visit[e.des]==false){
                TopoSort(graph, visit, e.des, stack);
            }

        }
        stack.push(cur);
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);
        boolean visit[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<V ;i++){
            if(visit[i]==false){
                TopoSort(graph, visit, i, stack);
            }

        }
        System.out.println("Topological sort is : ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
            
        }



        
    }
    
}
