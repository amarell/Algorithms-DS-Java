package Graphs;

public class GraphSearch {
	private boolean[] marked;
	private int count;
	private Graph G;
	
	public GraphSearch(Graph G) {
		this.G = G;
		marked = new boolean[G.V()];
	}
	
	public void dfs(int v) {
		marked[v] = true;
		count++;
		System.out.println(v + " ");
		
		for(int w: G.adj(v)) {
			if(!marked[w]) {
				dfs(w);
			}
		}
	}
	
	public void bfs(int v) throws Exception {
		Queue<Integer> queue = new Queue<Integer>();
		marked[v] = true;
		queue.enqueue(v);
		while(!queue.isEmpty()) {
			int s = queue.dequeue();
			count++;
			System.out.println(s + " ");
			for(int w: G.adj(s)) {
				if(!marked[w]) {
					marked[w] = true;
					queue.enqueue(w);
				}
			}
		}
	}
	
	public void reset() {
		count = 0;
		marked = new boolean[G.V()];
	}
	
	public boolean marked(int v) {
		return marked[v];
	}
	
	public int count() {
		return count;
	}
	
	
}
