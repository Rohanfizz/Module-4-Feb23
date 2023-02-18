import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

	public boolean dfs(int curr,boolean[] visited,boolean[] path,ArrayList<Integer>[] graph){
		visited[curr] = true;
		path[curr] = true;

		for(int nbr: graph[curr]){
			if(visited[nbr] && path[nbr]) return true;
			else if(!visited[nbr]){
				boolean isThereAnyCycleMyDearNbr = dfs(nbr,visited,path,graph);
				if(isThereAnyCycleMyDearNbr) return true;
			}
		}
		//if we have reached this line, this means that we are not able to detect any cycle
		//from here on, our visited will remain true which will symbolize our failure to detect a cycle
		// but path will become false as we will not be present in the path
		path[curr] = false;
		return false;
	}
	
public boolean isCyclic(int V, ArrayList<Integer>[] graph) {
    // Your code here
		boolean[] visited = new boolean[V];
		boolean[] path = new boolean[V];
		for(int i = 0;i<V;i++){
			//multiple components
			if(visited[i]) continue;
			boolean cyclePresent = dfs(i,visited,path,graph);
			if(cyclePresent) return true;
		}
	return false;
   }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}