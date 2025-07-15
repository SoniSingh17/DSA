// package Graphs.Minimum_spannig_Tree;

// Prerequisites: Disjoint Set Union (DSU)
// Step 1: Sort all edges by weight
// Step 2: Apply Kruskal's Algorithm to find MST
// Step 3: Add the edge if nodes belong to different sets
// Step 4: Skip edge if it forms a cycle (same parent)

import java.util.*;

public class Krushal_Algo {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight; // Sort ascending
        }
    }

    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY)
                return false;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public static void kruskalMST(List<Edge> edges, int V) {
        Collections.sort(edges);  // Step 1: Sort by weight
        DSU dsu = new DSU(V);     // Step 2: Initialize DSU

        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        for (Edge edge : edges) {
            if (dsu.union(edge.src, edge.dest)) { // Step 3: Add if no cycle
                mst.add(edge);
                totalWeight += edge.weight;
                if (mst.size() == V - 1)
                    break; // MST complete
            }
        }

        // Step 4: Output MST
        System.out.println("Edges in MST:");
        for (Edge e : mst) {
            System.out.println(e.src + " -- " + e.dest + " == " + e.weight);
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        kruskalMST(edges, V);
    }
}
