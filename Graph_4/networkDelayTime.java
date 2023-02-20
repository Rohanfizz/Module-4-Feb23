import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int v,e;
        v = sc.nextInt();
        e = sc.nextInt();
        //Create adjacency list of edges
        LinkedList<List<Integer>> adj[] = new LinkedList[v+1];
        for(int i=0;i<=v;i++)
            adj[i] = new LinkedList<>();
        
        for(int i=0;i<e;i++){
            int u,v1,w;
            u = sc.nextInt();
            v1 = sc.nextInt();
            w = sc.nextInt();
            adj[u].add(Arrays.asList(v1,w));
        }
        Solution obj = new Solution();
        System.out.println(obj.delayTime(v, adj));

    }
}

class Solution{

	static class Pair{
		int node;
		long cost;
		Pair(int node,long cost){
			this.node = node;
			this.cost = cost;
		}
	}
	
    static long delayTime(int V, LinkedList<List<Integer>>[] adj){
		int  md = (int) 1e9 + 7;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
			long diff = (a.cost-b.cost);
			if(diff>0) return 1;
			if(diff<0) return -1;
			return 0;
		});
		pq.add(new Pair(1,0));
		boolean[] visited = new boolean[V+1];
		long ans = 0;// is the time it takes data to reach the latest computer

		while(pq.size()>0){
			//pop
			Pair curr = pq.remove();

			//mark
			if(visited[curr.node]) continue;
			visited[curr.node] = true;

			//work
			ans = curr.cost;

			//visit
			for(List<Integer> edge: adj[curr.node]){
				int nbr = edge.get(0);
				int wt = edge.get(1);
				if(!visited[nbr]) pq.add(new Pair(nbr,(wt+curr.cost)));
			}
		}

		for(int i= 1;i<=V;i++){
			if(!visited[i]) return -1;
		}

		return ans;
    }
}

















