package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class EdgeWeightedGraph {
	private int E;
	private int V;
	private ArrayList<Edge>[] adj; // array of arraylists
	
	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		
		adj =(ArrayList<Edge>[]) new ArrayList[V];
		
		for(int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Edge>();
		}
	}
	
	public EdgeWeightedGraph(Scanner in) {
		this(in.nextInt());
		int E = in.nextInt();
		
		for(int i = 0; i<E; i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			double weight = in.nextDouble();
			addEdge(new Edge(v, w, weight));
		}
	}
	
	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	
	public int E() {
		return this.E;
	}
	
	public int V() {
		return this.V;
	}
	
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	
	public Iterable<Edge> edges(){
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		for(int v = 0; v<V; v++) {
			for(Edge e: adj[v]) {
				if(e.other(v) > v) {
					edgeList.add(e);
				}
			}
		}
		
		return edgeList;
	}
}
