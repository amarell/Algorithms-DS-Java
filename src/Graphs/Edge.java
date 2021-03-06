package Graphs;

public class Edge implements Comparable<Edge>{

    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return this.weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if(vertex == v) {
            return w;
        } else if(vertex == w) {
            return v;
        } else {
            throw new RuntimeException("This vertex is not a part of this edge");
        }
    }

    @Override
    public int compareTo(Edge o) {
        double diff = weight - o.weight;
        if(diff > 0) {
            return 1;
        } else if(diff < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }


}
