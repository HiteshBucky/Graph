
import java.util.*;

class ShortestPathDijkastra{

	static class Graph{
		int vertex, matrix[][];

		public Graph(int v){
			vertex = v;
			matrix = new int[v][v];
		}

		public void addEdge(int from , int to, int weight){
			matrix[from][to] = weight;
			matrix[to][from] = weight; // For Undirected graph
		}

		public int getMinimumVertex(boolean[] visited, int []distance){
			int minimum = Integer.MAX_VALUE;
			int vertex = -1;

			for(int i = 0; i<vertex; i++)
				if(!visited[i] && minimum>distance[i]){
					minimum = distance[i];
					vertex = i;
				}
			return vertex;	
		}

		public void dijkstrA_function(int sourceVertex){
			boolean[] visited = new boolean[vertex];
			int[] distance = new int[vertex];
			Arrays.fill(distance,Integer.MAX_VALUE);

			distance[sourceVertex] = 0;

			//here goes the fucking logic 
			for(int i = 0; i<vertex; i++){

				int miniDisVer = getMinimumVertex(visited,distance);

				visited[miniDisVer] = true;


				for(int current_V = 0; current_V<vertex; current_V++){
					if( matrix[miniDisVer][current_V]>0 && !visited[current_V] && )
				}
			}
		}
		
	}





	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int noVertex = 6;
		Graph graph = new Graph(noVertex);
		int sourceVertex = 0;

		graph.addEdge(0,1,4);
		graph.addEdge(0,2,3);
		graph.addEdge(1,2,1);
		graph.addEdge(1,3,2);
		graph.addEdge(2,3,4);
		graph.addEdge(3,4,2);
		graph.addEdge(4,5,6);
		
		graph.dijkstrA_function(sourceVertex);

	}
}