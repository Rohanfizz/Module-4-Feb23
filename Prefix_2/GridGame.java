class Solution {
    public long rangeSum(long[] pref,int l,int r){
        if(r<0) return 0;
        if(l == 0) return pref[r];
        return pref[r] - pref[l-1];
    }

    public int kadanes(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int currTrain = Integer.MIN_VALUE;

        for(int i = 0;i<arr.length;i++){
            int ifIStartNewTrain = arr[i];
            int ifISitWithCurrTrain = currTrain + arr[i];

            currTrain = Math.max(ifIStartNewTrain, ifISitWithCurrTrain);
            maxSum = Math.max(maxSum, currTrain);
        }
        return maxSum;
    }
    
    public long gridGame(int[][] a) {
        int n = a[0].length;
        long[] row0 = new long[n];
        long[] row1 = new long[n];
        long ans = Long.MAX_VALUE;
        //building prefix sum arrays on both rows
        row0[0] = a[0][0];
        for(int i = 1;i<n;i++) row0[i] = a[0][i] + row0[i-1];

        row1[0] = a[1][0];
        for(int i = 1;i<n;i++) row1[i] = a[1][i] + row1[i-1];

        //robot 1 tries to switch rows at every i
        for(int i = 0;i<n;i++){
            long option1 = rangeSum(row0,i+1,n-1);
            long option2 = rangeSum(row1,0,i-1);
            long robot2Choice = Math.max(option1,option2);
            ans = Math.min(ans,robot2Choice);
        }
        return ans;
    }
}