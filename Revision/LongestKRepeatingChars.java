import java.util.*;

class Solution {

	public int getAns(String s,int x,int k){
		int ans = 0;
		int sp =0;
		int ep = 0;
		int unique = 0;
		int charAtLeastK = 0;
		int[] freq = new int[150];

		while(ep<s.length()){
			freq[s.charAt(ep)]++;
			if(freq[s.charAt(ep)] == 1) unique++;
			if(freq[s.charAt(ep)] == k) charAtLeastK++;

			while(sp<ep && unique>x){
				freq[s.charAt(sp)]--;
				if(freq[s.charAt(sp)] == 0) unique--;
				if(freq[s.charAt(sp)] == k-1) charAtLeastK--;
				sp++;
			}

			if(unique == charAtLeastK) ans = Math.max(ans,ep-sp+1);
			ep++;
		}
		return ans;
	}
	
    public int longestSubstring(String s, int k) {
        // write code here
		int ans  = 0;
		for(int i = 0;i<=26;i++) ans = Math.max(ans,getAns(s,i,k));
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubstring(str,k));
    }
}
