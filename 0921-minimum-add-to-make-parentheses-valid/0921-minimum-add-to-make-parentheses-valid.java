class Solution {
    public int minAddToMakeValid(String s) {
        int countL = 0;
        int countR = 0;
        for(char ch: s.toCharArray()){
            if(ch=='('){
                countL++;
            }
           else{
            if(countL>0){
                countL--;
            }
            else{
                countR++;
            }
           }
           
        }
        return countL+countR;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna