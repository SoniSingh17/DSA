// This algorithm hepls to find the shorest distance from the src node to all the node.
// dis array scr -> 0 rest will be Integer.Max_Value
// do the relaxation for all the nodes for N-1 times
// If after N-1 times , again do the relaxation for once on all the nodes if again it reduces than the cycle exist.

package Graphs.Shortest_Distance;
import java.util.*;


public class BellmanAlgo {
    static class Edge{
        int src;
        int des;
        int weight;
        Edge(int src , int des , int weight){
            this.src=src;
            this.des=des;
            this.weight=weight;
        }
    }
    public static  void BellmanAlgo(List<Edge> edges , int V , int src){
        int[] dis = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;

        // Lets Rela all the edges N-1 times
        for(int i=1 ; i<=V-1 ; i++){
            for(Edge e : edges){
                int sorce = e.src;
                int des = e.des;
                int weight = e.weight;
                if(dis[sorce]!=Integer.MAX_VALUE && weight+dis[sorce]<dis[des]){
                    dis[des]=weight + dis[sorce];

                }

            }
        }

        // Lets Find negative cycle
        for(Edge e : edges){
            int sorce = e.src;
            int des = e.des;
            int weight = e.weight;
            if(dis[sorce]!=Integer.MAX_VALUE && weight+dis[sorce]<dis[des]){
                System.out.println("Negative Cycle is detected ... ");
                return;
            }


        }

        // Lets Print the shortest distance form the src Node to all the nodes
        System.out.println("Distance of all the nodes from the src node "+ src +"is as follows :");
        for(int i=0 ; i<V ; i++){
            System.out.println(i+ "\t\t" + (dis[i]==Integer.MAX_VALUE ? "∞" : dis[i]));
        }

    }
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        List<Edge> edges = new ArrayList<>();

        // Add edges: edge(src, dest, weight)
        edges.add(new Edge(0, 1, 6));
        edges.add(new Edge(0, 2, 7));
        edges.add(new Edge(1, 2, 8));
        edges.add(new Edge(1, 3, 5));
        edges.add(new Edge(1, 4, -4));
        edges.add(new Edge(2, 3, -3));
        edges.add(new Edge(2, 4, 9));
        edges.add(new Edge(3, 1, -2));
        edges.add(new Edge(4, 3, 7));

        int source = 0;
        BellmanAlgo(edges, V, source);
    }
}
    

    

