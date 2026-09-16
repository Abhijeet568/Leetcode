class Solution {
    public int lastStoneWeightII(int[] stones) {
       int totalSum = 0;
        for(int num:stones){
            totalSum+=num;
        }
        boolean dp[] = new boolean[totalSum+1];
        dp[0] = true;
        int target = totalSum/2;
        for(int num:stones){
        for(int i = target;i>=num;i--){
            dp[i] = dp[i]||dp[i-num];
        }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<=target;i++){
            if(dp[i]){
                int set1 = i;
                int set2 = totalSum-i;
                ans = Math.min(ans,Math.abs(set1-set2));
            }
        }
        return ans;  
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna