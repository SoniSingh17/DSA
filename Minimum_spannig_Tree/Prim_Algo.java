// In Minimun Spanning Tree we have two sets : set 1 contain all the nodes which are added to the MST
// set 2 contain all the set which are not added to the MST
// the task is is to traverse from MST to non-MST in the shortest path possible without ceating a cycle
// Sum_of_total_weights_ofEdges should be Minimum in an MST
// package Minimum_spannig_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim_Algo {

    public static class pair{
        int node;
        int weight;
     pair(int node , int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    static final int V = 5;
    public static void MST_prim_algo(List<List <pair>> graph){
        boolean[] visit = new boolean[V];
        PriorityQueue <pair> pq = new PriorityQueue<>((a,b) -> a.weight-b.weight);
        // start from 0
        pq.offer(new pair(0,0));
        int total_weight = 0;
        while(!pq.isEmpty()){
         pair edge = pq.poll();
            int u = edge.node;
            int w = edge.weight;
            if(visit[u]) continue;
            visit[u]=true;

            total_weight += w;
            if(w!=0){
                System.out.println(u +"\t" +w);
            }
            for (pair neighbor : graph.get(u)){
                if(!visit[neighbor.node]){
                    pq.offer(new pair(neighbor.node , neighbor.weight));
                } 

            } 
        }
        System.out.println("Total weight of the MST is : "+total_weight);

    }
    public static void main(String[] args) {
         List<List <pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Example undirected graph:
        adj.get(0).add(new pair(1, 2));
        adj.get(1).add(new pair(0, 2));

        adj.get(0).add(new pair(3, 6));
        adj.get(3).add(new pair(0, 6));

        adj.get(1).add(new pair(2, 3));
        adj.get(2).add(new pair(1, 3));

        adj.get(1).add(new pair(3, 8));
        adj.get(3).add(new pair(1, 8));

        adj.get(1).add(new pair(4, 5));
        adj.get(4).add(new pair(1, 5));

        adj.get(2).add(new pair(4, 7));
        adj.get(4).add(new pair(2, 7));

        adj.get(3).add(new pair(4, 9));
        adj.get(4).add(new pair(3, 9));
        MST_prim_algo(adj);

    }
}