import java.util.*;

class Solution {
    @SuppressWarnings("unchecked")

	public class Pair{
		int wt;
		int node;
		Pair(int wt,int node){
			this.wt = wt;
			this.node = node;
		}
	}
	
	public void dijkstra(ArrayList<ArrayList<Integer>> graph,int[] dist){
		int n = dist.length;
		boolean[] visited = new boolean[n];

		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
			return a.wt - b.wt;
		});

		pq.add(new Pair(0,0));

		while(pq.size()>0){
			Pair curr = pq.remove();
			int wt = curr.wt;
			int node = curr.node;

			if(visited[node]) continue;
			visited[node] = true;

			dist[node] = wt;

			for(int nbr: graph.get(node)){
				if(!visited[nbr]) pq.add(new Pair(wt+1,nbr));
			}
		}
		
		
	}
	
    public int thanosTelepath(int[][] edges, int[] patience) {
       // Write your code here
			int n = patience.length;// total subordinates including thanos
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0;i<n;i++) graph.add(new ArrayList<>());

		for(int[] e: edges){
			int u = e[0];
			int v = e[1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		int[] dist = new int[n];
		dijkstra(graph,dist);

		int idleTime = 0;

		for(int i = 1;i<n;i++){

			//portal ke liye
			if(dist[i]==0) continue;
			
			int timeToRecieveReply = dist[i]*2;
			int timeAtWhichISendMyLastMessage = timeToRecieveReply - (timeToRecieveReply%patience[i]);

			//now it is possible that timeAtWhichISendMyLastMessage = timeToRecieveReply, we should 
			// decrease one interval
			if(timeAtWhichISendMyLastMessage==timeToRecieveReply) timeAtWhichISendMyLastMessage-=patience[i];

			//now after decrement it is possible that timeAtWhichISendMyLastMessage < 0, makeit = 0;
			if(timeAtWhichISendMyLastMessage < 0) timeAtWhichISendMyLastMessage = 0;
			int timeAtWhichIReceiveMyLastMessage = timeAtWhichISendMyLastMessage + timeToRecieveReply;
			int myIdleTime = timeAtWhichIReceiveMyLastMessage + 1;
			idleTime = Math.max(idleTime,myIdleTime);
		}
		return idleTime;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] edges = new int[n][2];
        for (int i = 0; i < n; i++) {
        edges[i][0] = sc.nextInt();
        edges[i][1] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] patience = new int[m];
        for (int i = 0; i < m; i++) {
        patience[i] = sc.nextInt();
        }
        sc.close();
        
        Solution Obj = new Solution();
        System.out.println(Obj.thanosTelepath(edges,patience));

    }
}