import java.util.*;
import java.io.*;

class Solution {
    public long flipBits(long n) {
        // your code here
		long maxi = (1L<<32) - 1;
		// System.out.println(maxi);
		return maxi ^ n;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        Solution solution = new Solution();
        for(int qq = 0; qq < q; qq++){
            long n = input.nextLong();
            System.out.println(solution.flipBits(n));
        }
    }
}