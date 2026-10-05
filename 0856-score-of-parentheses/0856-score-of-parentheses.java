class Solution {
    public int scoreOfParentheses(String s) {
       int max = 0;
       int score = 0;
       for(int i = 0;i<s.length();i++){
        if(s.charAt(i)=='('){
            max++;

        }
        else{
            max--;
            if(s.charAt(i-1)=='('){
                score+=(int)Math.pow(2,max);
            }
        }
       }
       return score;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna