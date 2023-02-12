import java.io.*;
import java.util.*;
class Main{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.findPairs(a,n,k));		    
    }
}

class Solution
{
    public int findPairs(int[] nums,int n, int k) {
        //Write code here
		Arrays.sort(nums);
		int l = 0;
		int r = 1;
		int cnt =0;
		while(r<n){
			int diff = nums[r] - nums[l];

			if(diff == k){
				cnt++;
				l++;
				while(l<r && nums[l]==nums[l-1]) l++;
				r++;
				while(r<n && nums[r]==nums[r-1])r++;
			}else if(diff < k){
				r++;
				while(r<n && nums[r]==nums[r-1])r++;
			}else{
				l++;
				while(l<r && nums[l]==nums[l-1]) l++;
			}
			if(l == r) r++;
		}
		return cnt;
    }
}











