package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgo {
    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> graph , int V){
        ArrayList<Integer> result = new ArrayList<>();
        int inDegree[] = new int[V];
        for(int i=0; i<V ; i++){
            for(int v : graph.get(i)){
                inDegree[v]++;


            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int j=0 ; j<V ; j++){
            if(inDegree[j]==0){
                q.offer(j);
                
            }
        }
        while(q.isEmpty()==false){
            int v = q.poll();
            result.add(v);
            for(int edg : graph.get(v)){
                inDegree[edg]--;
                if(inDegree[edg]==0){
                    q.offer(edg);
                   
                }

            }

        }
        return result;

    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 6;
        for(int i=0 ; i<V ; i++){
            graph.add(new ArrayList<>());

        }
        graph.get(5).add(0);
        graph.get(5).add(2);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        System.out.println("topological sort using kanhs algo : ");
        ArrayList<Integer> result = topoSort(graph,V);
        for(int i : result){
            System.out.print(i + " ");
        }
        
    }
    
}
