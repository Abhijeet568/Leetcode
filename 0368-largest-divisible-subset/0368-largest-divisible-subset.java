class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int dp[] =new int[n];
        int prev[]= new int[n];
        int max = 1;
        int index = 0;
        for(int i =0;i<n;i++){
            dp[i]  = 1;
            prev[i] =i;
            for(int j = 0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i] ){
                    dp[i] = dp[j]+1;
                    prev[i] =j;
                }
            }
            if(dp[i]>max){
                max = dp[i];
                index = i;
            }
        }
        while(prev[index]!=index){
            ans.add(nums[index]);
            index = prev[index];
        }
        ans.add(nums[index]);
        Collections.reverse(ans);
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna