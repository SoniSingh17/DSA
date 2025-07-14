// We can find if two elements are in in the same set or not ? using simple DFS and BFS --> time comp. O(V+E)
// Thus we try to reduce the Time complexity using disjoint_set data Structure in a O(1) : constant time complexity
// The optimization is due to the concept of Path compresion --> find_parent()
// The the find  Union method using Rank or Size.
// steps two array 1) parent containing the immediate Parent default value is : number it self
// 2) Rank basically denote the size of the subtree ; height of the top node deafult value is : 0
// Rank is not change while path compression due to  ovious reasons.
// This Algorithm is used in the Minimum Spanning Tree concept as well.(Krushal Algorithm)
// It is mostly dynamic . At the end all are in one SET.
// But it not nessary that all will always merge.(REMEMBER)
// This concept is based on finding the parent.
package Disjoint_Sets;

public class DisjointSet_Rank {
    static int[] rank;
    static int[] parent;
    public static void makeSet(int n){
        rank = new int[n];
        parent = new int[n];
        for(int i=0 ; i<n ; i++){
            rank[i] = 0;
            parent[i] = i;

        }

    }
    // Path compression 
    public static int find_parent(int u){
        if(parent[u]!=u){
            parent[u] = find_parent(parent[u]);
        }
        return parent[u]; // BackTracking

    }
    //    Union using rank
    public static void  Union(int u , int v){
        int pu = find_parent(u);
        int pv = find_parent(v);
        if(pu == pv) return; // Already in the same set.
        if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        }
        else if(rank[pu] > rank[pv]){
            parent[pv] = pu;
        }
        else{
            parent[pv] = pu;
            rank[pu]++;
        }
    }
    public static void main(String[] args) {
        int n = 7; // 0 to 6
        makeSet(n);

        Union(0, 1);
        Union(1, 2);
        Union(3, 4);
        Union(5, 6);
        Union(4, 5);
        Union(2, 6);

        // After all    Unions, all should have same parent
        for (int i = 0; i < n; i++) {
            System.out.println("Parent of " + i + " is " + find_parent(i));
        }
    }

    
}
