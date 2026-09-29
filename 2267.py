class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        m, n = len(grid), len(grid[0])
        length = m + n - 1

        if (length % 2 == 1 or grid[0][0] != "(" or
                grid[m - 1][n - 1] != ")"):
            return False

        dp = [0] * n

        for row in range(m):
            for col in range(n):
                reachable = 0
                if row > 0:
                    reachable |= dp[col]
                if col > 0:
                    reachable |= dp[col - 1]
                if row == 0 and col == 0:
                    reachable = 1  # Bit 0: balance before the first cell.

                dp[col] = (
                    reachable << 1
                    if grid[row][col] == "("
                    else reachable >> 1
                )

        return (dp[n - 1] & 1) != 0