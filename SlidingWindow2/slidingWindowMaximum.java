import java.util.*;

class Solution{
    static int[] SlidingWindowMaximum(int N, int K, int[] arr){
        // write code here
		Deque<Integer> dq = new LinkedList<>();
		int sp = 0;
		int ep = 0;
		int[] ans = new int[N-K+1];

		while(ep<K){
			while(dq.size()>0 && arr[dq.getLast()] < arr[ep]) dq.removeLast();
			dq.addLast(ep);
			ep++;
		}
		ans[0] = arr[dq.getFirst()];

		while(ep<N){
			//  we want to remove number on sp
			sp++;
			// we want to add number on ep
			while(dq.size()>0 && arr[dq.getLast()] < arr[ep]) dq.removeLast();
			dq.addLast(ep);
			ep++;
			// number in front is the maximum one, but that can or cannot be in range
			// remove until you find a number who is in range
			while(dq.getFirst()<sp) dq.removeFirst();
			//the number standing infront will be the maximum and will be inrange
			ans[sp] = arr[dq.getFirst()];
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
