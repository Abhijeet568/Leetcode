class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i =0;
        int len = 0;
        HashSet<Character> st = new HashSet<>();
        for(int j = 0;j<s.length();j++){
            char ch = s.charAt(j);

            while(st.contains(ch)){
                st.remove(s.charAt(i));
                i++;
            }
            st.add(ch);

            len = Math.max(len,j-i+1);
        }
        return len;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna