import java.util.*;

class Solution {
    static int maxOne(int arr[], int n,int k){
        //Write your code here
		int numOfZeroesInCurrWindow = 0;
		int sp = 0;
		int ep = 0;
		int ans = 0;

		while(ep<n){
			//end point is visited now
			if(arr[ep] == 0) numOfZeroesInCurrWindow++;

			// -------------------
			// shrink until window is Invalid.
			while(numOfZeroesInCurrWindow > k){
				if(arr[sp] == 0) numOfZeroesInCurrWindow--;
				sp++;
			}
			//on this line of code, our window will always be valid
			ans = Math.max(ans,ep-sp+1);
			ep++;
		}
		return ans;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxOne(array,n,k));
    }
}
