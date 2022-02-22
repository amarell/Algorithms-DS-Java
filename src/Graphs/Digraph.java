package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class Digraph {
    private int E;
    private int V;
    private ArrayList<Integer>[] adj; // array of arraylists

    public Digraph(int V) {
        this.V = V;
        this.E = 0;

        adj = (ArrayList<Integer>[]) new ArrayList[V];

        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }

    public Digraph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();

        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public int E() {
        return this.E;
    }

    public int V() {
        return this.V;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }
}
