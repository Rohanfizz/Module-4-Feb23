import java.util.*;
import java.io.*;

 
public class Main {

	public static void bfs(int i,boolean[] visited,ArrayList<ArrayList<Integer>> graph){
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		while(q.size()>0){
			int curr = q.remove();
			if(visited[curr]) continue;
			visited[curr] = true;
			System.out.print(curr+" ");
			for(int nbr:graph.get(curr)){
				if(!visited[nbr]) q.add(nbr);
			}
		}
	}
	
    public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int e = scn.nextInt();
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {//<=n for portal purposes
			  graph.add(new ArrayList<Integer>());
		}
		//taking input for edges
		for (int i = 0; i < e; i++) {
		  int u = scn.nextInt();
		  int v = scn.nextInt();
		  //undirected graph
		  graph.get(u).add(v);
		}

		boolean[] visited = new boolean[n+1];
		// for(int i = 0;i<n;i++){
		// 	if(visited[i]) continue;//this node must have been marked as visited because of some previous node where we applied bfs
		// }
			bfs(0,visited,graph);
    }
}
