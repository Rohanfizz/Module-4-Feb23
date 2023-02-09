import java.util.*;

class Solution {
    public int MaxSum(int[] arr, int n) {
        // Write your code here
		int maxSumSubarray = -100000;
		int currMax = maxSumSubarray;
		
		int minSumSubarray = 100000;
		int currMin = minSumSubarray;

		int wholeArraySum = 0;

		for(int i = 0;i<n;i++){
			wholeArraySum += arr[i];
			
			//for max sum subarray
			int maxIStartNew = arr[i];
			int maxIJoinPrev = arr[i] + currMax;
			currMax = Math.max(maxIStartNew,maxIJoinPrev);
			maxSumSubarray = Math.max(maxSumSubarray,currMax);

			//for min sum subarray
			int minIStartNew = arr[i];
			int minIJoinPrev = arr[i] + currMin;
			currMin = Math.min(minIStartNew,minIJoinPrev);
			minSumSubarray = Math.min(minSumSubarray,currMin);
		}
		// if all numbers are -ve
		if(wholeArraySum == minSumSubarray) return maxSumSubarray;
		// int allPositive = maxSumSubarray;
		// int noWrap = maxSumSubarray;
		// int wrapAround = wholeArraySum - minSumSubarray;
		return Math.max( maxSumSubarray , wholeArraySum - minSumSubarray);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
	    Solution Obj = new Solution();
        int ans = Obj.MaxSum(arr, n);
        System.out.println(ans);
    }
}