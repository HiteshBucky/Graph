import java.util.*;

public class NodeWeighted{
	int n;
	String name;
	private boolean visited;
	LinkedList<EdgeWeighted> edges;

	NodeWeighted(int n, String name){
		this.n = n; this.name = name;
		visited = false;
		edges = new LinkedList<>();
	}

	boolean isVisited(){
		return visited;
	}

	void visit(){
		visited = true;
	}

	void unvisit(){
		visited = false;
	}
}

public class EdgeWeighted implements Comparable<EdgeWeighted>{
	NodeWeighted source, destination;
	double weight;

	EdgeWeighted(NodeWeighted s, NodeWeighted d, double w){
		source = s; destination = d; weight = w;
	}

	public String toString(){
		return String.format("%s -> %s , %f", source.name, destination.name, weight)
	}

	public int comapareTo(EdgeWeighted otherEdge){
		return this.weight>otherEdge.weight ? 1 : -1;
	}
}

public class GraphWeighted{
	private Set<NodeWeighted> nodes;
	private boolean directed;

	GraphWeighted(boolean directed){
		this.directed = directed;
		nodes = new HashSet<>();
	}
	public void addNode(NodeWeighted... n){
		nodes.addAll(Arrays.asList(n));
	}
}


