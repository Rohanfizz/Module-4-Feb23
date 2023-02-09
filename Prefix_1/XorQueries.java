import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	  public static void main(String[] args) throws Throwable {
		  Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int q = sc.nextInt();
	        int [] arr= new int[n];
	        for(int i=0;i<n;i++){
	            arr[i]=sc.nextInt();
	        }
	        int [][] queries= new int[q][2];
	        for(int i=0;i<q;i++){
	            for(int j=0;j<2;j++){
	                queries[i][j]=sc.nextInt();
	            }
	        }
	        Solution Obj= new Solution();
	        
	        int [] result = Obj.xorQueries(arr,queries);
	        for(int i=0;i<result.length;i++){
	            System.out.print(result[i]+" ");
	    }
}
public static class Solution{
	  public static void build(int[] pref,int[] arr){
			for(int i = 0;i<arr.length;i++){
				pref[i] = arr[i] ^ (i-1>=0?pref[i-1]:0);
			}
		}
		public static int getXorInRange(int[] pref,int sp,int ep){
			if(sp == 0) return pref[ep];
			return pref[ep]^pref[sp-1];
		}
	 public static int[] xorQueries(int[] A, int[][] q) {
	       // your code goes here
			 int[] pref = new int[A.length];
			 build(pref,A);
			 int[] ans =new int[q.length];
			 for(int i = 0;i<q.length;i++){
				 int sp =q[i][0];
				 int ep = q[i][1];
				 ans[i] = getXorInRange(pref,sp,ep);
			 }
			 return ans;
	    }   
}



}






