import java.util.*;

class Solution {

    public int solve(int nums[],int n) {
        // Your code here
		int[] rMax  = new int[n];
		rMax[n-1] = nums[n-1];
		for(int i = n-2;i>=0;i--){
			rMax[i] = Math.max(nums[i],rMax[i+1]);
		}

		int i = 0;
		int j = 1;
		int ans = 0;

		while(j<n){
			if(nums[i] <= rMax[j]){
				ans = Math.max(ans,j-i);
				j++;
			}else i++;
		}
		return ans;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
        nums[i]=sc.nextInt();

        Solution obj=new Solution();
        System.out.println(obj.solve(nums,n));
        sc.close();
    }
}