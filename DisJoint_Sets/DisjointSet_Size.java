// This is more easy and intuitive to understand than 'rank' method
// In place of rank we use size ; simply total number of nodes.
// package Disjoint_Sets;

public class DisjointSet_Size {
    static int[] parent;
    static int[] size;

    // Initialize each node as its own parent, with size 1
    public static void makeSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Find the root (with path compression)
    public static int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);  // Path compression
        }
        return parent[u];
    }

    // Union by size
    public static void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return;  // Already in the same set

        // Attach smaller set under larger set
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }

    public static void main(String[] args) {
        int n = 7;
        makeSet(n);

        union(0, 1);
        union(1, 2);
        union(3, 4);
        union(5, 6);
        union(4, 5);

        System.out.println("Find operation results:");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + " → Root: " + find(i));
        }

        System.out.println("\nTotal Components:");
        java.util.HashSet<Integer> uniqueRoots = new java.util.HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueRoots.add(find(i));
        }
        System.out.println("Total disjoint sets: " + uniqueRoots.size());
    
}
}
