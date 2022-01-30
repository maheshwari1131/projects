package com.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Integer> adjs[];
    Graph(int v){
        V=v;
        adjs=new LinkedList[V];
        for(int i=0;i<V;i++){
            adjs[i]=new LinkedList<>();
        }

    }

    public void addEdge(int v, int w){
        adjs[v].add(w);
    }

    // Driver method to
    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        //g.BFS(2);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
    }

    private void DFS(int v) {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v]=true;
        System.out.print(v + " ");
        Iterator<Integer> it=adjs[v].listIterator();
        while (it.hasNext()){
            int ne=it.next();
            if(visited[ne]){
                DFSUtil(ne,visited);
            }
        }

    }

    // prints BFS traversal from a given source s
    private void BFS(int s) {

        boolean visited[]=new boolean[V];

        LinkedList<Integer> q=new LinkedList<>();
        visited[s]=true;
        q.add(s);
        while(q.size()!=0){
            q.poll();
            System.out.print(s+" ");
            LinkedList li=adjs[s];
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adjs[s].listIterator();
            while(i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    visited[n]=true;
                    q.add(n);
                }

            }
        }


    }
}
