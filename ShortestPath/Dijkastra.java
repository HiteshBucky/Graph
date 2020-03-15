import java.util.*;
class SP{

	public static class Graph{
		int vertices, matrix[][];

		public Graph(int v){
			vertices = v;
			matrix = new int[v][v];
		}
		public void addEdge(int s, int d, int w){
			matrix[s][d] = matrix[d][s] = w;
		}
		public int getMin(boolean []visited, int []distance){
			int minDistance = Integer.MAX_VALUE;
			int minIndex = -1;
			for(int i = 0; i<vertices; i++)
				if(!visited[i] && minDistance >= distance[i]){
					minDistance = distance[i];
					minIndex = i;
				}
			return minIndex;
		}

		public void DIJ(int source){
			boolean[] visited = new boolean[vertices];
			int []distance = new int[vertices];
			Arrays.fill(distance, Integer.MAX_VALUE);


			distance[source] = 0;

			for(int i = 0; i<vertices-1; i++){
				int vertex_u = getMin(visited, distance);
				visited[vertex_u] = true;

				for (int vertex_v = 0;vertex_v<vertices ; vertex_v++ ) 
					if(matrix[vertex_v][vertex_u] != 0 && !visited[vertex_v] && distance[vertex_u] != Integer.MAX_VALUE)
						distance[vertex_v] = Math.min( distance[vertex_v], (matrix[vertex_v][vertex_u]+distance[vertex_u]) );

				System.out.println("i : " + i + " ver " + vertex_u);
			}

			System.out.println(Arrays.toString(distance));
		}
	}

	public static void main(String[] args) {
		  int vertices = 6;
	      Graph graph = new Graph(vertices);
	      int sourceVertex = 0;
	      graph.addEdge(0, 1, 4);
	      graph.addEdge(0, 2, 3);
	      graph.addEdge(1, 2, 1);
	      graph.addEdge(1, 3, 2);
	      graph.addEdge(2, 3, 4);
	      graph.addEdge(3, 4, 2);
	      graph.addEdge(4, 5, 6);
	      graph.DIJ(sourceVertex);
	}
}