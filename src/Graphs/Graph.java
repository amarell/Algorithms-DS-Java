package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
	private int E;
	private int V;
	private ArrayList<Integer>[] adj; // array of arraylists
	
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		
		adj =(ArrayList<Integer>[]) new ArrayList[V];
		
		for(int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();
		}
	}
	
	public Graph(Scanner in) {
		this(in.nextInt());
		int E = in.nextInt();
		
		for(int i = 0; i<E; i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			addEdge(v,w);
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public int E() {
		return this.E;
	}
	
	public int V() {
		return this.V;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
}
