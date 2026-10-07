class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();

        int left = 0;
        int right = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        solve(s, 0, left, right, 0, new StringBuilder(), set);

        return new ArrayList<>(set);
    }

    void solve(String s, int index, int left, int right, int open,
               StringBuilder curr, Set<String> set) {

        if (index == s.length()) {
            if (left == 0 && right == 0 && open == 0) {
                set.add(curr.toString());
            }
            return;
        }

        char ch = s.charAt(index);

        if (ch == '(' && left > 0) {
            solve(s, index + 1, left - 1, right, open, curr, set);
        }

        if (ch == ')' && right > 0) {
            solve(s, index + 1, left, right - 1, open, curr, set);
        }

        curr.append(ch);

        if (ch == '(') {
            solve(s, index + 1, left, right, open + 1, curr, set);
        } else if (ch == ')') {
            if (open > 0) {
                solve(s, index + 1, left, right, open - 1, curr, set);
            }
        } else {
            solve(s, index + 1, left, right, open, curr, set);
        }

        curr.deleteCharAt(curr.length() - 1);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna