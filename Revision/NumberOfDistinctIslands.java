import java.util.*;
 
class Solution {
    static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	private static void dfs(int r, int c, boolean[][] visited, int[][] grid,  int x0, int y0, ArrayList<String> curr) {
		int rows = grid.length;
		int cols = grid[0].length;
		visited[r][c] = true;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
		    int nc = c + dc[i];
		    if(nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
			if(visited[nr][nc] == false && grid[nr][nc] == 1) {
				curr.add(Integer.toString(x0-nr) + "-" + Integer.toString(y0-nc));
				dfs(nr, nc, visited, grid, x0, y0, curr);
			}
		}	
	}
 
  public static int countDistinctIslands(int[][] grid) {
	  
	  int row = grid.length;
	  int col = grid[0].length;
 
	  boolean[][] visited = new boolean[row][col];
	  // HashMap<String, Integer> hm = new HashMap<>();
	    HashSet<ArrayList<String>> hm = new HashSet<> ();
	  for(int i = 0; i < row; i++){
		  for(int j = 0; j < col; j++) {
			  if(visited[i][j] == false && grid[i][j] == 1) {
			      // island = "";
				  ArrayList<String> curr = new ArrayList<String>();
				  dfs(i, j, visited, grid, i, j, curr);
				  hm.add(curr);
				  // hm.put(island, hm.getOrDefault(island, 0) + 1);
			  }
		  }
	  }
	  return hm.size();
  }
}
 
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
 
        for (int i = 0; i < n; i++) {
 
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
 
        Solution ob = new Solution();
        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }
}