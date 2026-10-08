class Solution {
    public boolean isBalanced(String num) {
        int sumE = 0;
        int sumO = 0;
        for(int i = 0;i<num.length();i++){
            int digit =num.charAt(i)-'0';
          
            if(i%2==0){
                sumE+=digit;
            }
            else{
                sumO+=digit;
            }
        }
       
        return sumE==sumO;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna