import java.io.*;
import java.util.*;
class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine());
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<N; i++)
        {
            String S[] = read.readLine().split(" ");
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<N; j++)
                temp.add(Integer.parseInt(S[j]));
            adj.add(temp);
        }

        Solution ob = new Solution();
        System.out.println(ob.components(adj,N));
    }
}

class Solution {
    int components(ArrayList<ArrayList<Integer>> graph, int N) {
       //Your code here
		boolean[] visited = new boolean[N];
		int cnt = 0;
		for(int i = 0;i<N;i++){
			if(visited[i]) continue;
			cnt++;
			
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			while(q.size()>0){
				int front = q.remove();
				if(visited[front]) continue;
				visited[front] = true;
				for(int ii = 0;ii<N;ii++){
					if(ii==front) continue;
					if(!visited[ii] && graph.get(front).get(ii) == 1) q.add(ii);
				}
			}
			
		}
		return cnt;
		
    }
};

