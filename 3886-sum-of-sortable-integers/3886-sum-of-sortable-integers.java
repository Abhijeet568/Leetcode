
class Solution {
    public int sortableIntegers(int[] nums) {
        int b = nums.length;
        int c = 0;

        for (int d = 1; d * d <= b; d++) {
            if (b % d == 0) {
                if (q(d, b, nums)) {
                    c += d;
                }

                int e = b / d;
                if (d != e && q(e, b, nums)) {
                    c += e;
                }
            }
        }

        return c;
    }

    private boolean q(int f, int g, int[] h) {
        int i = Integer.MIN_VALUE;

        for (int j = 0; j < g; j += f) {
            int k = Integer.MAX_VALUE;
            int l = Integer.MIN_VALUE;
            int m = 0;

            for (int n = j; n < j + f - 1; n++) {
                int o = h[n];

                if (o < k) k = o;
                if (o > l) l = o;

                if (o > h[n + 1]) {
                    m++;
                }
            }

            int p = h[j + f - 1];

            if (p < k) k = p;
            if (p > l) l = p;

            if (p > h[j]) {
                m++;
            }

            if (m > 1 || k < i) {
                return false;
            }

            i = l;
        }

        return true;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna