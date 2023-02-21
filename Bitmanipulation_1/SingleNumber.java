

import java.util.*;

class Solution {
    public void singleElement(int[]A,int n) {
        //Write code here and print output
        int res = 0;
		for(int num:A){
			res ^= num;
		}
		System.out.println(res);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
                A[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.singleElement(A,n);
        sc.close();
    }
}

