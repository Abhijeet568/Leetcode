class Solution {
    private static final long MOD = 1000000007L;
    public int countGoodStrings(long n) {
        long[][]M = {{1,1},{1,0}};
        long [][]res = {{1,0},{0,1}};
        long exp = n;
        while(exp>0){
            if((exp&1)==1){
                res = multiply(res,M);
                
            }
            M = multiply(M,M);
            exp>>=1;
        }
        return(int)((2*res[0][1])%MOD);
    }
    private long[][]multiply(long[][] a, long[][]b){
        long[][]c = new long[2][2];
        c[0][0]=(a[0][0]*b[0][0]+a[0][1]*b[1][0])%MOD;
        c[0][1] = (a[0][0]*b[0][1]+a[0][1]*b[1][1])%MOD;
        c[1][0] = (a[1][0]*b[0][0]+a[1][1]*b[1][0])%MOD;
        c[1][1] = (a[1][0]*b[0][1]+a[1][1]*b[1][1])%MOD;
        return c;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna