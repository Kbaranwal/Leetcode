class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> nums[a] - nums[b]);

        int[] sortedNums = new int[n];
        int[] rank = new int[n]; // rank[node] = position in sorted order
        for (int k = 0; k < n; k++) {
            sortedNums[k] = nums[idx[k]];
            rank[idx[k]] = k;
        }
        int[] far = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < i) j = i;
            while (j + 1 < n && sortedNums[j + 1] - sortedNums[i] <= maxDiff) j++;
            far[i] = j;
        }

        int[] comp = new int[n];
        for (int i = 1; i < n; i++) {
            comp[i] = far[i - 1] >= i ? comp[i - 1] : comp[i - 1] + 1;
        }

        int LOG = 1;
        while ((1 << LOG) < n) LOG++;
        LOG++;

        int[][] up = new int[LOG][n];
        up[0] = far;
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int m = queries.length;
        int[] ans = new int[m];
        for (int qi = 0; qi < m; qi++) {
            int u = rank[queries[qi][0]];
            int v = rank[queries[qi][1]];
            if (u > v) { int t = u; u = v; v = t; }
            if (u == v) { ans[qi] = 0; continue; }
            if (comp[u] != comp[v]) { ans[qi] = -1; continue; }

            int pos = u, steps = 0;
            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][pos] < v) {
                    pos = up[k][pos];
                    steps += (1 << k);
                }
            }
            ans[qi] = steps + 1;
        }
        return ans;
    }
}