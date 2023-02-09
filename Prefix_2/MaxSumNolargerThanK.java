import java.util.*;

class Solution {

	public int getSumK(int[] rows,int k){
		int myAns = Integer.MIN_VALUE;
		for(int i = 0;i<rows.length;i++){
			int cWinSum = 0;
			for(int j = i;j<rows.length;j++){
				cWinSum += rows[j];
				if(cWinSum <= k) myAns = Math.max(myAns,cWinSum);
			}
		}
		return myAns;
	}
	
    public int maxSumSubmatrix(int[][] arr, int k) {
        //Write code here
		int ans = Integer.MIN_VALUE;
		for(int left = 0;left<arr[0].length;left++){
			int[] rows = new int[arr.length];
			for(int right = left;right<arr[0].length;right++){
				for(int i = 0;i<arr.length;i++) rows[i] += arr[i][right];
				ans = Math.max(ans,getSumK(rows,k));
			}
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.maxSumSubmatrix(matrix, k));
        sc.close();
    }
}