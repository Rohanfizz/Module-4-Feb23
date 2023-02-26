import java.util.*;

class Solution {

    public long maxUseful(int n, int[][] roads) {
        // write code here
		int[] degrees = new int[n];
		for(int[] edge: roads){
			int u = edge[0];
			int v = edge[1];
			degrees[u]++;
			degrees[v]++;
		}
		Arrays.sort(degrees);
		long ans = 0;
		long currVal = 1;
		for(int i = 0;i<n;i++){
			ans += (degrees[i] * (currVal));
			currVal++;
		}
		return ans;
    }
}

class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[m][2];
        for (int i = 0; i < m; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            arr[i][0] = u;
            arr[i][1] = v;
        }
        sc.close();
        Solution Obj = new Solution();
        System.out.println(Obj.maxUseful(n, arr));
    }
}