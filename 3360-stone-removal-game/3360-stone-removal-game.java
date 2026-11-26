class Solution {
    public boolean canAliceWin(int n) {
        int turn  =10;
        int count = 0;
        while(n>=turn){
            n-=turn;
            count++;
            turn--;
        }
        return count%2==1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna