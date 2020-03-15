import java.util.*;

class Solution{

	public static int INF = 9999;

	public static void AllPairsShortestPath(int[][] graph, int V){
		int dist[][] = new int[V][V];

		/*
			Initialize the dist matrix same as graph that have i=j -> 0 , 
			if( Vi and Vj is not connected then Infinity otherwise same data )
		*/
		for(int i = 0; i<V; i++)	
			dist[i] = graph[i].clone();

		for(int  k = 0; k < V; k++)
			for(int i = 0; i < V; i++)
				for(int j = 0; j < V; j++)
					dist[i][j] = Math.min( dist[i][j], dist[i][k] + dist[k][j]);

		for(int i = 0; i<V; i++){
			for(int j = 0; j<V; j++)
				if(dist[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j]+"   ");
			System.out.println();	
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = 4;
		int graph[][] = {
							{ 0,   5,   INF, 10 },
							{ INF, 0,   3,   INF},
							{ INF, INF, 0,   1  },
							{ INF, INF, INF, 0  }
						};

		AllPairsShortestPath(graph, V);
	}
}