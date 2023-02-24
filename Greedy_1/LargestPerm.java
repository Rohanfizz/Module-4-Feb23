import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static int[] largestPermutation(int[] A, int b) {
        //Write your code here
		int n = A.length;
        int[] index = new int[n+1];
		for(int i = 0;i<n;i++){
			index[A[i]] = i;//index of A[i] = i;
		}

		int i = 0;
		while(i<n && b>0){
			int idealVal = n-i;
			if(A[i] != idealVal){
				//need to do a swap
				int currVal = A[i];
				int cvi = i;
				int ivi = index[idealVal];

				index[currVal] = ivi;
				index[idealVal] = cvi;

				A[i] = idealVal;
				A[ivi] = currVal;
				b--;
			}
			i++;
		}
		return A;
    }
}

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++)
            A[i] = sc.nextInt();

        int b =sc.nextInt();
        Solution obj= new Solution();
        int [] ans = obj.largestPermutation(A, b);

        for(int i=0;i<n;i++)
            System.out.print(ans[i]+" ");
    }
}