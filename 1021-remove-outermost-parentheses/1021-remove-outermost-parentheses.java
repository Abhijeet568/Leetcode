class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
            if(count>0){
              sb.append(ch);
            }
            count++;
            }
            else{
                if(ch==')'){
                    count--;
                    if(count>0){
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna