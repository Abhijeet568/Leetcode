class Solution {
    public boolean checkString(String s) {
        boolean bFound = false;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='b'){
                bFound = true;
            }
            if(s.charAt(i)=='a'&& bFound){
                return false;
            }
        }
        return  true;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna