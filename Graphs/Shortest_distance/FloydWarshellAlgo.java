// package Graphs.Shortest_Distance;

public class FloydWarshellAlgo {
    final static int  INF = 9999;
    // This algorithm helps us in finding the minimun distance from all the vertex to all the other vertex
    // Time Complexity O(n^3)
    public static void FloydAlgo(int[][] graph , int n){
        for(int k=0 ; k<n ; k++){
            for(int i=0 ; i<n ; i++){
                for(int j=0 ; j<n ; j++){
                    if(graph[i][k]!=INF && graph[k][j]!=INF && graph[i][k] + graph[k][j] < graph[i][j]){
                        graph[i][j]=graph[i][k]+graph[k][j];
                    }
                }
            }
        }
        System.out.println("Lets Print the shortest distance : \n");
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(graph[i][j]==INF) System.out.print("INF"+"\t");
                else{
                    System.out.print(graph[i][j]+"\t");

                }

               
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] graph = {
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };
        FloydAlgo(graph , 4);
        
    }
    
}
