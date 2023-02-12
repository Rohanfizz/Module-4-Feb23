import java.io.*;
import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int m,n,target;
        m=sc.nextInt();
        n=sc.nextInt();
        target=sc.nextInt();

        int matrix[][]=new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            matrix[i][j]=sc.nextInt();
        }

        Solution obj=new Solution();
        System.out.println(obj.solve(matrix,target));
        sc.close();
    }
}

class Solution{

	public void build(int[][] arr,int[][] pref){
		for(int i = 0;i<arr.length;i++){
			for(int j = 0;j<arr[0].length;j++){
				int A = arr[i][j];
				int B = j==0?0:pref[i][j-1];
				int C = i==0?0:pref[i-1][j];
				int D = i==0 || j==0?0:pref[i-1][j-1];

				pref[i][j] = A + B + C - D;
			}
		}
	}

	public int query(int[][] pref,int r1,int c1,int r2,int c2){
		int A = pref[r2][c2];
		int B = c1==0?0:pref[r2][c1-1];
		int C = r1==0?0:pref[r1-1][c2];
		int D = r1==0 || c1==0?0:pref[r1-1][c1-1];
		return A - B - C + D;
	}
	
    public int solve(int arr[][],int target){
        // your code here
		int n = arr.length;
		int m = arr[0].length;
		int[][] pref = new int[n][m];
		build(arr,pref);
		int cnt = 0;
		for(int r1 = 0;r1<n;r1++){
			for(int c1 = 0;c1<m;c1++){
				for(int r2 = r1;r2<n;r2++){
					for(int c2 = c1;c2<m;c2++){
						if(query(pref,r1,c1,r2,c2) == target) cnt++;
					}
				}
			}
		}
		return cnt;
		

    }

}



















