import java.util.*;

class Solution {
    public int latestTimeCatchTheBus(int[] b, int[] p, int c) {
        //Write code here
		Arrays.sort(b);
		Arrays.sort(p);
		HashSet<Integer> hs = new HashSet<>();
		for(int x: p) hs.add(x);

		int n= b.length;
		int m = p.length;
		int bidx = 0;
		int pidx = 0;
		int solb  = c;//number of seats remaining in the bus which last passenger boarded
		int lastPerson = 1; //passenger who is boarding the bus latest

		while(bidx<n && pidx<m){
			int cc = c;
			while(cc>0 && pidx<m && b[bidx]>=p[pidx]){
				lastPerson = p[pidx];//last person boarding a bus will get updated
				pidx++;//for next person
				cc--;//capacity of this bus decreses by 1
			}
			solb = cc;//number of seats remaining in the bus which last passenger boarded
			bidx++;//lets try to fill the next bus
		}
		int ans = lastPerson;
		if(solb>0 || bidx<n) ans = b[b.length-1]; //case 1 = last bus is having seats
		while(hs.contains(ans)) ans--; //case 2 = find best time before last person gets boarded
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++)
            nums1[i] = sc.nextInt();
        int m = sc.nextInt();
        int nums2[] = new int[m];
        for (int i = 0; i < m; i++)
            nums2[i] = sc.nextInt();
        int cap = sc.nextInt();
        Solution Obj = new Solution();
        int res = Obj.latestTimeCatchTheBus(nums1, nums2, cap);
        System.out.println(res);
        sc.close();
    }
}
