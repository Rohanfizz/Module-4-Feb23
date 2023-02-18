import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

	public static class Pair{
		int node;
		String psf;
		int wsf;
		Pair(int node,String psf,int wsf){
			this.node = node;
			this.psf = psf;
			this.wsf = wsf;
		}
	}
	
  public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> graph, int S){
     // Write your code here
	  PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
		  return a.wsf-b.wsf;
	  });
	  pq.add( new Pair(S,""+S,0));
	  int[] visited = new int[V];
	  Arrays.fill(visited,-1);
		  //from now on normal bfs code
	  while(pq.size()>0){
		  Pair cp = pq.remove();
		  int node = cp.node;
		  String psf = cp.psf;
		  int wsf = cp.wsf;

		  if(visited[node] != -1)  continue;
		  visited[node] = wsf;

		  // System.out.println(node+" -> "+psf+" @ "+wsf);

		  for(ArrayList<Integer>  edge: graph.get(node)){
			  int nbr = edge.get(0);
			  int cost = edge.get(1);
			  if(visited[nbr]==-1) pq.add(new Pair( nbr,psf+nbr,wsf+cost));
		  }
	  }
	  return visited;
       
  }

  public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            int[] ptr = dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    

}
