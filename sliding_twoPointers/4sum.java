import java.util.*;
import java.io.*;
class Solution {
   public List<List<Integer>> fourSum(int[] nums, int target) {
       // Write your code here
	   Arrays.sort(nums);
	   int n = nums.length;
	   List<List<Integer>> ans = new ArrayList<>();
	   for(int  i = 0;i<n;i++){
		   for(int j = i+1;j<n;j++){

			   //two sum
			   int newTar = target - (nums[i] + nums[j]);
			   int l = j+1;
			   int r = n-1;
			   while(l<r){
				   int sum = nums[l] + nums[r];
				   if(sum == newTar){
					   //add to ans arraylist
					   List<Integer> curr = new ArrayList<>();
					   curr.add(nums[i]);
					   curr.add(nums[j]);
					   curr.add(nums[l]);
					   curr.add(nums[r]);
					   ans.add(curr);
					   l++;
                       while(l<r && nums[l]==nums[l-1]) l++;
					   r--;
                       while(r>l && nums[r]==nums[r+1]) r--;
				   }else if(sum<newTar){
					   l++;
                       while(l<r && nums[l]==nums[l-1]) l++;
				   }else{
					   r--;
                       while(r>l && nums[r]==nums[r+1]) r--;
				   }
			   }
               //take j to the last index of the same value
			   while(j+1<n && nums[j] == nums[j+1]) j++;
		   }
           //take i to the last index of the same value
           while(i+1<n && nums[i] == nums[i+1]) i++;
	   }
	   return ans;
   }
}

public class Main
{
	    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        List<List<Integer>> res = Obj.fourSum(nums, k);

      
        for(int i= 0; i<res.size(); i++){
           Collections.sort(res.get(i));
        }

     
        Collections.sort(res, new Comparator<List<Integer>>() {
               public int compare(List<Integer> frst, List<Integer> scnd) {
                    int i=0;
                    while(frst.get(i)==scnd.get(i)) i++;
                    return frst.get(i)-scnd.get(i);
                    }
                });

        for(int i=0; i<res.size(); i++){   
            for(int j=0; j<4; j++){
                System.out.print(res.get(i).get(j) + " ");
            } 
            System.out.println("");
        }
        sc.close();
	}
}