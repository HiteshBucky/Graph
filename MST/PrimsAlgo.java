import java.util.*;

class PrimsAlgo{

	public static void primMST(int[][] graph, int V){
		int parent[] = new int[V];
		int key[] = new int[V];

		boolean visited[] = new boolean[V];	//Every vertex will be falsr initially

		Arrays.fill(key, Integer.MAX_VALUE);	// Every vertex will be filled with infinity except Vertex 0 

		key[0] = 0;
		parent[0] = -1;

		for(int i = 0; i< V-1; i++){
			int u = minKey(key,visited);
			visited[u] = true;

			for(int v = 0; v<V; v++)
				if( graph[u][v] != 0 && visited[v] == false && graph[u][v] <key[v]){
					parent[v] = u; key[v] = graph[u][v];
				}
		}

		printMST(parent, V, graph);
	}

	public static int minKey(int key[], boolean visited[]){
		int min = Integer.MAX_VALUE, minIndex = 0;

		for(int v = 0; v<visited.length; v++){
			if(visited[v] == false && key[v]<min){
				min = key[v]; minIndex = v;
			}
		}
		return minIndex;
	}

	public static void printMST(int[] parent, int V, int graph[][]){
		System.out.println("Edge weight");;
		for(int i=1; i<V; i++)
			System.out.println(parent[i] + "--" + i + " " + graph[i][parent[i]] );
	}

	public static void main(String[] args) {
		
		int vertex = 5;

		int graph[][] = {
							{0,3,0,6,0},
							{3,0,3,5,5},
							{0,3,0,0,7},
							{6,5,0,0,9},
							{0,5,7,9,0}
						};

		primMST(graph, vertex);
	}
}