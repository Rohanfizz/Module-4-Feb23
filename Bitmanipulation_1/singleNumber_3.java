import java.util.*;

class Solution {

    public int[] singleNumber3(int n, int[] nums) {
        // write code here
		int xarr = 0;
		for(int num:nums) xarr ^= num;

		int k = 0;
		while( (xarr & 1<<k) == 0) k++;// we are finding the index of rightmost set bit

		int xorOfpeopleHavingKthBitSet = 0;
		int xorOfpeopleHavingKthBitUnset = 0;
		
		for(int num:nums){
			if((num & 1<<k) > 0){//if kth bit is set
				xorOfpeopleHavingKthBitSet ^= num;
			}else{
				xorOfpeopleHavingKthBitUnset ^= num;
			}
		}
		int[] ans = {xorOfpeopleHavingKthBitSet,xorOfpeopleHavingKthBitUnset};
		Arrays.sort(ans);
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        scn.close();
        int[] ans = Obj.singleNumber3(n, arr);
        System.out.print(ans[0] + " " + ans[1]);
    }
}