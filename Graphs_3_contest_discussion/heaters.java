import java.util.*;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        //Write code here
		Arrays.sort(houses);
		Arrays.sort(heaters);

		int minRadius = 0;
		for(int house: houses){
			int ceil = getBceil(heaters,house);
			int floor = getBfloor(heaters,house);
			int nearestHeater = Math.min(house-floor,ceil-house);
			minRadius = Math.max(minRadius,nearestHeater);
		}
		return minRadius;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();
        Solution Obj = new Solution();
        int res = Obj.findRadius(arr, arr2);
        System.out.println(res);
        sc.close();
    }
}