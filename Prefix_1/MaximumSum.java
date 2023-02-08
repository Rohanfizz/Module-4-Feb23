import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int maximumSum(int[] A, int[][] ops) {
	    int[] freq = new int[A.length];
		
		//iterate on all the operations
		for(int i = 0;i<ops.length;i++){
			int sp = ops[i][0];
			int ep = ops[i][1];
			 freq[sp]++;
			if(ep+1<A.length) freq[ep+1]--;
		}
		//prefix sum build of freq array
		for(int i = 1;i<A.length;i++) freq[i] += freq[i-1];
		Arrays.sort(freq);
		Arrays.sort(A);
		int score = 0;
		int md = (int) 1e9 + 7;
		for(int i = 0;i<A.length;i++){
			score = ((score%md) + ((freq[i]%md)*(A[i]%md))%md)%md;
		}
		return score;
    }
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          ops[i][0]=Integer.parseInt(inputLine1[0]);
          ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
	}
}



