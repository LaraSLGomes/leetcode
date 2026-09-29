class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int length = m + n - 1;

        if (length % 2 != 0 || grid[0][0] != '(' ||
            grid[m - 1][n - 1] != ')') {
            return false;
        }

        // Enough bits for balances 0 through length.
        int words = (length + 64) / 64;
        long[][] dp = new long[n][words];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                long[] next = new long[words];

                for (int word = 0; word < words; word++) {
                    if (row > 0) next[word] |= dp[col][word];
                    if (col > 0) next[word] |= dp[col - 1][word];
                }
                if (row == 0 && col == 0) next[0] = 1L;

                if (grid[row][col] == '(') {
                    // Go backward so the previous word is still unchanged.
                    for (int word = words - 1; word >= 0; word--) {
                        long carry = word > 0
                            ? next[word - 1] >>> 63 : 0L;
                        next[word] = (next[word] << 1) | carry;
                    }
                } else {
                    // Go forward so the next word is still unchanged.
                    for (int word = 0; word < words; word++) {
                        long carry = word + 1 < words
                            ? next[word + 1] << 63 : 0L;
                        next[word] = (next[word] >>> 1) | carry;
                    }
                }

                dp[col] = next;
            }
        }

        return (dp[n - 1][0] & 1L) != 0;
    }
}