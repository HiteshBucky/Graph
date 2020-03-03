import java.util.*;

class Edge implements Comparable<Edge>{
	int source , destination, weight ;


	public void setData(int s,int d, int w){
		source = s; destination = d; weight = w;
	}

	@Override
	public int compareTo(Edge node ){
		return weight - node.weight;
	}

}

class Kruskal{

	public static void KruskalAlgo( Edge edge[] , int vertex, int noOfEdge){

		Edge output[] = new Edge[vertex-1]; 	// Making a output araay of edges 

		int parent[] = new int[vertex];	 //Initializing every vertex of parent to index to itself . This'll helf in cycle detection
		for(int i = 0; i<vertex ; i++)
			parent[i] = i;

		for(int i = 0,count = 0; count != vertex-1; i++){
			Edge currentedge = edge[i];

			int sourceParent = findParent(edge[i].source, parent);
			int destinationParent = findParent(edge[i].destination, parent);

			if( sourceParent != destinationParent){
				output[count++] = edge[i];
				parent[sourceParent] = destinationParent;
			}
		}
		printOutput(output, vertex);
	}

	public static int findParent(int v, int parent[]){
		if(parent[v] == v)
			return v;
		return findParent(parent[v], parent);
	}

	public static void printOutput(Edge output[], int vertex){
		for(int i = 0; i<vertex-1; i++)
			System.out.println(output[i].source + "----" + output[i].destination + "  =  " + output[i].weight);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int vertex = sc.nextInt();
		int noOfEdge = sc.nextInt();

		Edge edge[] = new Edge[noOfEdge];

		for(int i = 0; i<noOfEdge; i++)
		{
			System.out.println("Enter Source destination weight");
			int s = sc.nextInt(); 
			int d = sc.nextInt(); 
			int w = sc.nextInt(); 

			edge[i] = new Edge();
			edge[i].setData(s,d,w);

		}

		Arrays.sort(edge);

		// Arrays.sort(edge, new Comparator<Edge>(){     We can sort the array in this way also
		// 	@Override 
		// 	public int compare(Edge e1, Edge e2){
		// 		return e1.weight - e2.weight;
		// 	}
		// });

		KruskalAlgo(edge,vertex, noOfEdge);
	}
}