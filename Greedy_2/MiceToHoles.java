import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(read.readLine());
        String S[] = read.readLine().split(" ");
        String st[] = read.readLine().split(" ");
        
        int[] M = new int[N];
        int[] H = new int[N];
        
        for(int i=0 ; i<N ; i++)
            M[i] = Integer.parseInt(S[i]);
            
        for(int i=0 ; i<N ; i++)
            H[i] = Integer.parseInt(st[i]);

        Solution ob = new Solution();
        System.out.println(ob.assignMiceHoles(N,M,H));
    
    }
}

class Solution {
    static int assignMiceHoles(int N , int[] M , int[] H) {
        // code here
        Arrays.sort(M);
		Arrays.sort(H);
		int maxDiff = 0;
		for(int i = 0;i<N;i++){
			int micePos = M[i];
			int holePos = H[i];
			maxDiff = Math.max(maxDiff,Math.abs(micePos-holePos));
		}
		return maxDiff;
    }
}




