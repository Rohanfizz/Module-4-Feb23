import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        Solution obj=new Solution();
        while(t-->0)
        {
            int n=sc.nextInt();
            int z=sc.nextInt();

            int a[]=new int[n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();

            long ans=obj.solve(n,z,a);
            System.out.println(ans);
        }
        
        sc.close();
    }

}

class Solution {
    long solve(int n,int z,int a[])
    {
        int ans = Integer.MIN_VALUE;
        for(int x : a){
            ans = Math.max(ans,x | z);
        }
        return ans;
    }
}


