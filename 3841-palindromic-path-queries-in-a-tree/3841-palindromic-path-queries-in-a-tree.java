import java.util.*;

class Solution {
    int[][] up;
    int[] tin, tout, depth;
    int timer, LOG;
    ArrayList<Integer>[] adj;
    BIT bit;

    class BIT {
        int[] tree;
        int n;

        BIT(int n) {
            this.n = n;
            tree = new int[n + 2];
        }

        void update(int i, int val) {
            for (; i <= n; i += i & -i) {
                tree[i] ^= val;
            }
        }

        int query(int i) {
            int res = 0;
            for (; i > 0; i -= i & -i) {
                res ^= tree[i];
            }
            return res;
        }
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        LOG = 32 - Integer.numberOfLeadingZeros(n);
        up = new int[LOG][n];
        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        timer = 0;

        dfs(0, 0);

        bit = new BIT(n + 1);
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int mask = 1 << (chars[i] - 'a');
            bit.update(tin[i], mask);
            bit.update(tout[i] + 1, mask);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                int oldMask = 1 << (chars[u] - 'a');
                int newMask = 1 << (c - 'a');
                int diff = oldMask ^ newMask;

                bit.update(tin[u], diff);
                bit.update(tout[u] + 1, diff);

                chars[u] = c;
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int l = lca(u, v);

                int mask = bit.query(tin[u])
                         ^ bit.query(tin[v])
                         ^ (1 << (chars[l] - 'a'));

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    void dfs(int root, int parent) {
        int[] stack = new int[tin.length];
        int[] par = new int[tin.length];
        int[] iter = new int[tin.length];

        int top = 0;
        stack[0] = root;
        par[root] = parent;
        up[0][root] = parent;
        tin[root] = ++timer;
        iter[root] = 0;

        while (top >= 0) {
            int u = stack[top];

            if (iter[u] == adj[u].size()) {
                tout[u] = timer;
                top--;
                continue;
            }

            int v = adj[u].get(iter[u]++);

            if (v == par[u]) {
                continue;
            }

            par[v] = u;
            depth[v] = depth[u] + 1;
            up[0][v] = u;

            for (int j = 1; j < LOG; j++) {
                up[j][v] = up[j - 1][up[j - 1][v]];
            }

            tin[v] = ++timer;
            iter[v] = 0;
            stack[++top] = v;
        }
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna