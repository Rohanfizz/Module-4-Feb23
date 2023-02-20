import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      // write your code here

	   Queue<Integer> q = new LinkedList<>();
		boolean[] vis= new boolean[vtces];
	   q.add(src);
	   int cnt = 0;

	   while(q.size()>0 && t>0){
		   t--;
		   int sz = q.size();
		   while(sz-- > 0){
			   int curr= q.remove();
			   if(vis[curr]) continue;
			   vis[curr] = true;
			   cnt++;
			   for(Edge e: graph[curr]){
				   int nbr = e.nbr;
				   if(!vis[nbr]) q.add(nbr);
			   }
		   }
	   }
	   System.out.println(cnt);
   }

}














