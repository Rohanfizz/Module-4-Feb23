import java.util.*;

class Solution {
    public int setKBit(int n, int k) {
        // write code here
		int mask = 1<<k;
		int newNum = n | mask;
		return newNum;
    }
}

public class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        sc.close();
        System.out.println(Obj.setKBit(n, k));
    }
}