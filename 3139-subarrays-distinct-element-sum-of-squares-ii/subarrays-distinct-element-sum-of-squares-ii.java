class Solution {
    static final long MOD = 1_000_000_007L;
    long[] s, sq, lz;

    void apply(int o, int len, long k) {
        sq[o] = (sq[o] + 2 * k % MOD * s[o] % MOD + k * k % MOD * len % MOD) % MOD;
        s[o] = (s[o] + k * len) % MOD;
        lz[o] = (lz[o] + k) % MOD;
    }

    void update(int o, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            apply(o, r - l + 1, 1);
            return;
        }
        int m = (l + r) >> 1;
        if (lz[o] != 0) {
            apply(2 * o, m - l + 1, lz[o]);
            apply(2 * o + 1, r - m, lz[o]);
            lz[o] = 0;
        }
        if (ql <= m) update(2 * o, l, m, ql, qr);
        if (qr > m) update(2 * o + 1, m + 1, r, ql, qr);
        s[o] = (s[2 * o] + s[2 * o + 1]) % MOD;
        sq[o] = (sq[2 * o] + sq[2 * o + 1]) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        s = new long[4 * n];
        sq = new long[4 * n];
        lz = new long[4 * n];

        Map<Integer, Integer> last = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int p = last.getOrDefault(nums[i], -1);
            update(1, 0, n - 1, p + 1, i);
            last.put(nums[i], i);
            ans = (ans + sq[1]) % MOD;
        }
        return (int) ans;
    }
}