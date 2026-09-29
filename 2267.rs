impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<char>>) -> bool {
        let m = grid.len();
        let n = grid[0].len();
        let length = m + n - 1;

        if length % 2 == 1
            || grid[0][0] != '('
            || grid[m - 1][n - 1] != ')'
        {
            return false;
        }

        let words = (length + 64) / 64;
        let mut dp = vec![vec![0u64; words]; n];

        for row in 0..m {
            for col in 0..n {
                let mut next = vec![0u64; words];

                for word in 0..words {
                    if row > 0 {
                        next[word] |= dp[col][word];
                    }
                    if col > 0 {
                        next[word] |= dp[col - 1][word];
                    }
                }
                if row == 0 && col == 0 {
                    next[0] = 1;
                }

                if grid[row][col] == '(' {
                    // Go backward to preserve the carry from the prior word.
                    for word in (0..words).rev() {
                        let carry = if word > 0 {
                            next[word - 1] >> 63
                        } else {
                            0
                        };
                        next[word] = (next[word] << 1) | carry;
                    }
                } else {
                    // Go forward to preserve the carry from the next word.
                    for word in 0..words {
                        let carry = if word + 1 < words {
                            next[word + 1] << 63
                        } else {
                            0
                        };
                        next[word] = (next[word] >> 1) | carry;
                    }
                }

                dp[col] = next;
            }
        }

        (dp[n - 1][0] & 1) != 0
    }
}