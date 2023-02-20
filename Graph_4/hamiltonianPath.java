import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {

	boolean hamiltonian(int curr,boolean[] visited,ArrayList<Integer> psf,ArrayList<ArrayList<Integer>> graph,int os){
		int totalNodes = graph.size()-1; //n+1 arraylists in graph ( because of 1 indexing )
		if(psf.size() == totalNodes-1){
			// we have found a hamiltonian path
			psf.add(curr);
			System.out.print(psf);
			psf.remove(psf.size()-1);

			// lets check if this node makes a cycle
			// it makes a cycle if it has the os node as one of its neighbours
			boolean isCycle = false;
			for(int nbr: graph.get(curr)){// why curr? because curr is the last node of the path
				if(nbr == os) isCycle = true;
			}
			if(isCycle)	System.out.println("  (Cycle)");
			else System.out.println();
			return true;
		}
		
		visited[curr] = true;
		psf.add(curr);

		boolean myRes = false;
		// try to visit all unvisited neighbours
		for(int nbr: graph.get(curr)){
			if(!visited[nbr]){
				boolean foundAPath = hamiltonian(nbr,visited,psf,graph,os);
				if(foundAPath) myRes = true;
			}
		}
		visited[curr] = false;
		psf.remove(psf.size()-1);
		return myRes;
	}
	
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0;i<=N;i++){
			graph.add(new ArrayList<Integer>());
		}
		for(ArrayList<Integer> e: Edges){
			int u  = e.get(0);
			int v  = e.get(1);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		boolean[] visited = new boolean[N+1];// 1 based indexing
		ArrayList<Integer> psf = new ArrayList<>();
		boolean ans = false;
		for(int i = 1;i<=N;i++){
			//trying all the nodes as source nodes
			boolean isHamiltonian = hamiltonian(i,visited,psf,graph,i); //treaing i as source, are we able to find hamiltonian paths
			//isHamiltonian = true when i detect hamiltonian path using i as source
			// if(isHamiltonian) ans = true; same result as below line
			ans = ans || isHamiltonian;
		}
		return ans;
    }
}





