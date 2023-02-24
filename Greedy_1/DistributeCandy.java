import java.io.*;
import java.util.*;

class Solution {
    public int distributeCandy(int[] A) {
        // write code here
		int n = A.length;
		int[] candies = new int[n];
		Arrays.fill(candies,1);
		//we should look at both neighbours left and right]
		//lets satisfy the left condition (if we are having > rating than left neighbour)
		for(int i = 1;i<n;i++){
			if(A[i] > A[i-1]){
				candies[i] = candies[i-1]+1;
			}
		}
		//right condition
		for(int i = n-2;i>=0;i--){
			if(A[i] > A[i+1]){
				candies[i] = Math.max(candies[i],candies[i+1]+1);
			}
		}
		int total = 0;
		for(int x: candies) total+=x;
		return total;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	    
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++)
        {
            A[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.distributeCandy(A));
    }
}