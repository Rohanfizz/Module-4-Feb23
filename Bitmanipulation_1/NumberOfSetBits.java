import java.util.*;

class Solution {
    public int setBits(int n) {
        // write code here
		int cnt= 0;
		while(n!=0){
			cnt++;
			n = (n & (n-1));
		}
		return cnt;
    }
}

public class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution Obj = new Solution();
        sc.close();
        System.out.println(Obj.setBits(n));
    }
}