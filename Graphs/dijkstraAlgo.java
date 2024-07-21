package localrepo.Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstraAlgo {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d,int wt) {
            this.src = s;
            this.dest = d;
            this.wt=wt;
        }
    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public  Pair(int n,int d){
            this.node=n;
            this.dist=d;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;//ascending
        }
    }
    public static void dijkstra(ArrayList<Edge> graph[],int src,int V){//V=vertices of the graph
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int dist[]=new int[V];
        //Setting all the node weights to infinity
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean vis[]=new boolean[V];
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();//Shortest
            vis[curr.node]=true;
            for(int i=0;i<graph[curr.node].size();i++){
                Edge e=graph[curr.node].get(i);
                int u=e.src;
                int v=e.dest;
                if(dist[u]+e.wt<dist[v]){
                    //relaxation:updation of the weights with a lesser one
                    dist[v]=dist[u]+e.wt;
                    pq.add(new Pair(v, dist[v]));//adding the new dist into the priority queue

                }
            }
        }
        for(int i=0;i<V;i++){
            System.out.println(dist[i]+" ");
        }
        System.out.println();
    }
}
