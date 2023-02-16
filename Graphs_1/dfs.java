import java.util.*;

class Solution {
	public static void dfs(int currNode,ArrayList<ArrayList<Integer>> graph,boolean[] visited){
		//mark visited
		visited[currNode] = true;
		//do work
		System.out.print(currNode+" ");
		//this is not nessary in dfs
		// Collections.sort(graph.get(currNode));
		for(int nbr: graph.get(currNode)){
			// do dfs on those neighbours who are not visited
			if(!visited[nbr]) dfs(nbr,graph,visited);
		}
	}
    public static void DFSTraversal(List<List<Integer>> edges, int n) {
        //Write your code here
	
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0;i<n;i++) graph.add(new ArrayList<Integer>());

		for(List<Integer> edge: edges){
			int u = edge.get(0);
			int v = edge.get(1);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		boolean[] visited = new boolean[n];
		dfs(0,graph,visited);
		
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }

        Solution ob = new Solution();
        ob.DFSTraversal(ed, n);
    }
}