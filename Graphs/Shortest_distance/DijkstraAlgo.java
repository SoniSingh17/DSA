package Graphs.Shortest_Distance;
// package Graphs.Shortest_Distance;
// Algorithm Steps:
// Initialize distance array with ∞ (or Integer.MAX_VALUE in Java) for all nodes, except the source node which is 0.

// Use a Min Heap (PriorityQueue) to always pick the node with the smallest current distance.

// For the picked node:

// Traverse its neighbors.

// If the distance through the current node is smaller, update the neighbor's distance.

// Repeat until all nodes are processed.
// package Graphs.Shortest_Distance;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    static class Pair{
        int node;
        int dist;
        Pair(int node , int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public static  int[] djalgo(int V , ArrayList<ArrayList<Pair>> graph , int src){
        int[] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist-b.dist); // trying to create a min heap
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            int node = cur.node;
            int dis = cur.dist;
            for(Pair p : graph.get(node)){
                int val = p.node;
                int weight = p.dist;
                if(weight+dis<distance[val]){
                    distance[val]=weight+dis;
                    pq.add(new Pair(val, distance[val]));
                }
            }
        }
        return distance;



    }
    public static  void main(String[] args) {
         int V = 5;
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Example edges: (u, v, w)
        graph.get(0).add(new Pair(1, 2));
        graph.get(0).add(new Pair(2, 4));
        graph.get(1).add(new Pair(2, 1));
        graph.get(1).add(new Pair(3, 7));
        graph.get(2).add(new Pair(4, 3));
        graph.get(3).add(new Pair(4, 1));

        int[] dist = djalgo(V, graph, 0);

        System.out.println("Shortest distances from source 0:");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("To node " + i + ": " + dist[i]);
        
    }

    
}
}