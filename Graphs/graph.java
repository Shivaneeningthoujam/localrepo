package localrepo.Graphs;

import java.util.*;

public class graph {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 5));
        graph[3].add(new Edge(3, 4));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));
    }

    public static void bfs(ArrayList<Edge> graph[], int V, boolean vis[], int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr] == false) {
                System.out.println(curr + " ");
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // Depth first Search
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.println(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] == false)
                dfs(graph, e.dest, vis);
        }
    }

    // We are given a target .We have tofind all possible paths to reach the target
    // from source
    public static void printAllPath(ArrayList<Edge> graph[], boolean vis[], int src, String path, int target) {
        // O(V^V)
        if (src == target) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);// finds the neighbour of current vertex
            if (!vis[e.dest]) {
                vis[src] = true;
                printAllPath(graph, vis, e.dest, path + e.dest, target);
                vis[src] = false;
            }
        }
    }

    // Detecting any loop in a given directed graph
    public static boolean isCycle(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]) {
        vis[curr] = true;
        rec[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.dest]) {
                // Cycle exits
                return true;
            } else if (!vis[e.dest]) {
                isCycle(graph, vis, e.dest, rec);
            }
        }
        rec[curr] = false;
        return false;
    }
    //Detecting cycle in undirected graph
    public static boolean isCycleU(ArrayList<Edge> graph[],boolean vis[],int curr,int par){
        //par denotes parent node
        vis[curr]=true;//First set the current node as visited
        for(int i=0;i<graph[curr].size();i++){//finds the neighbours of the current node
            Edge e=graph[curr].get(i);
            if((vis[e.dest]&&e.dest!=par)==true){//if the neighbour is already visited but it's not its parent node
               return true;//=>Cycle exists
            }
            else if(!vis[e.dest]){//if the node isn't visited yet
                if(isCycleU(graph, vis, e.dest, curr))//call the function recursively to visit the node
                return true;//if cycle detected ,return true
            }
        }
        return false;//if allthe above conditions isn't met
    }
    //TOPOLOGICAL SORTING
    //It is used only for directed Acyclic graphs only
    //We r using stack to implement the algo
    //the output should be nodes with lesser in-degrees first
    public static void topSortUtil(ArrayList<Edge> graph[],int curr,boolean vis[],Stack<Integer> s){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtil(graph, e.dest, vis, s);
            }
        } s.push(curr);
    }
    public static void topSort(ArrayList<Edge> graph[],int V){
        boolean vis[]=new boolean[V];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topSortUtil(graph, i, vis, s);
            }
        }
        while(!s.isEmpty()){
            System.out.println(s.pop()+" ");
        }
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean vis[] = new boolean[V];
        int src = 0;
        // for (int i = 0; i < V; i++) {
        // if (vis[i] == false) {
        // bfs(graph, V, vis, i);
        // }
        // }

        // System.out.println();
        String path = "0";
        printAllPath(graph, vis, src, path, 5);
    }

}
