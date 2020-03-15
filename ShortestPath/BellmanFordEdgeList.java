import java.util.*;

class Solution{

	public static class Edge{
		double cost;
		int from, to;

		public Edge(int from, int to, double cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	public static double[] bellmanFord(Edge[] edges, int V, int start){

		double[] dist = new double[V];
		Arrays.fill(dist, Double.POSITIVE_INFINITY);
		dist[start] = 0;

		boolean relaxedAnEdge = true;	
		/*
			In some case we may achieve shortest path before V-1 iteration 
			so we don.t need to iterate over V-1 times

		*/

		for(int v = 0; v < V-1 && relaxedAnEdge; v++)
		{
			relaxedAnEdge = false;
			for( Edge edge : edges)
				if( dist[edge.from] + edge.cost < dist[edge.to]){
					dist[edge.to] = dist[edge.from] + edge.cost;
					relaxedAnEdge = true;
				}
		}

		/*
			Relax one more time to check negative cycle
			if somehow we relaxed any vertex then that implies 
			we have a negative cycle
			Run algorithm a second time to detect which nodes are part
			of a negative cycle. A negative cycle has occurred if we
			can find a better path beyond the optimal solution.
		*/
		relaxedAnEdge = true;
		
		for(int v = 0; v < V-1 && relaxedAnEdge; v++)
		{
			relaxedAnEdge = false;
			for( Edge edge : edges)
				if( dist[edge.from] + edge.cost < dist[edge.to]){
					dist[edge.to] = Double.NEGATIVE_INFINITY;
					relaxedAnEdge = true;
				}
		}	

		return dist;
	}

	public static void main(String[] args) {
		

		/*int E = 10, V = 9, start = 0;
		Edge[] edges = new Edge[E];
	    edges[0] = new Edge(0, 1, 1);
	    edges[1] = new Edge(1, 2, 1);
	    edges[2] = new Edge(2, 4, 1);
	    edges[3] = new Edge(4, 3, -3);
	    edges[4] = new Edge(3, 2, 1);
	    edges[5] = new Edge(1, 5, 4);
	    edges[6] = new Edge(1, 6, 4);
	    edges[7] = new Edge(5, 6, 5);
	    edges[8] = new Edge(6, 7, 4);
	    edges[9] = new Edge(5, 7, 3);*/

	    int E = 8, V = 5, start = 0;
		Edge[] edges = new Edge[E];
	    edges[0] = new Edge(0, 1, -1);
	    edges[1] = new Edge(0, 2, 4);
	    edges[2] = new Edge(1, 2, 3);
	    edges[3] = new Edge(1, 4, 2);
	    edges[4] = new Edge(1, 3, 2);
	    edges[5] = new Edge(3, 2, 5);
	    edges[6] = new Edge(3, 1, 1);
	    edges[7] = new Edge(4, 3, -3);

	    double[] d = bellmanFord(edges, V, start);

	    for (int i = 0; i < V; i++)
	        System.out.printf("The cost to get from node %d to %d is %.2f\n", start, i, d[i]);

	}
}