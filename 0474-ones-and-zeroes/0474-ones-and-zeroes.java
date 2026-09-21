class Solution {
    int dp[][][];
    public int findMaxForm(String[] strs, int m, int n) {
         dp = new int[strs.length][m+1][n+1];
        return fxn(strs,m,n,0);

    }
    int fxn(String[] strs,int m,int n,int i){
        if(i==strs.length) return 0;
        if(dp[i][m][n]>0) return dp[i][m][n];
        int zero = cntZ(strs[i]);
        int one = strs[i].length()-zero;
        int take = 0;
        int notTake = 0;
        if(m>=zero &&n>=one){
            take = fxn(strs,m-zero,n-one,i+1)+1;
        }
        notTake = fxn(strs,m,n,i+1);

        return dp[i][m][n] =  Math.max(take,notTake);
    }
    int cntZ(String s){
        int z = 0;
        for(char c:s.toCharArray()){
            if(c=='0'){
                z++;
            }
           
        }
         return z;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna