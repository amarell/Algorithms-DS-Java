package Graphs;

public class Main {

	public static void main(String[] args) {
		Graph g1 = new Graph(5);
		
		g1.addEdge(1, 2);
		g1.addEdge(1, 0);
		g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		
		System.out.println("The number of vertices : " + g1.V());
		System.out.println("The number of edges : " + g1.E());
		
		int vertex = 3;
		System.out.println("Adjacent vertices of " + vertex);
		
		Iterable<Integer> vertices = g1.adj(vertex);
		for(Integer v: vertices) {
			System.out.println(v + " ");
		}
		
	}

}
