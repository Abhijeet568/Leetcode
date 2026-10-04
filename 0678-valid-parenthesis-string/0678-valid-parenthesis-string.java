class Solution {
    public boolean checkValidString(String s) {
     int min = 0;
     int max = 0;
     for(char ch: s.toCharArray()){
        if(ch=='('){
            min++;
            max++;
        }
        else if(ch==')'){
            min--;
            max--;
        }
        else{
            min--;
            max++;
        }
        if(max<0) return false;
        if(min<0) min = 0;

     }
     return min ==0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna