import java.util.*;

class Solution {
   public class Pair{
	   int data;
	   int color;
	   Pair(int data,int color){
		   this.data = data;
		   this.color = color;
	   }
   }
	public boolean dfs(int i,int c,int[] vis,ArrayList<ArrayList<Integer>> graph){
		vis[i] = c;
		int nbrc = c == 1?2:1;
		for(int nbr:graph.get(i)){
			if(vis[nbr] == c) return false;
			else if(vis[nbr] == 0){
				boolean check = dfs(nbr,nbrc,vis,graph);
				if(!check) return false;
			}
		}
		return true;
	}
    public int possibleBipartition(int n, int[][] dislikes) {
        // Write your code her
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0;i<=n;i++) graph.add(new ArrayList<>());
		for(int[] e: dislikes) {
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}
		int[] vis = new int[n+1];
		Queue<Pair> q = new LinkedList<>();
		for(int i = 1;i<=n;i++){
			if(vis[i]!=0) continue;
			boolean check = dfs(i,1,vis,graph);
			if(!check) return 0;
		}
		return 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}