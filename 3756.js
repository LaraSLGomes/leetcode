/**
 * @param {string} s
 * @param {number[][]} queries
 * @return {number[]}
 */
var sumAndMultiply = function(s, queries) {
    const MOD = 1_000_000_007;
    const n = s.length;

    const prefSum = new Array(n).fill(0);
    const prefNonZeroNum = new Array(n).fill(0);
    const prefNonZeroCnt = new Array(n).fill(0);

    for (let i = 0; i < n; i++) {
        const digit = s.charCodeAt(i) - 48;

        if (i > 0) {
            prefSum[i] = prefSum[i - 1];
            prefNonZeroNum[i] = prefNonZeroNum[i - 1];
            prefNonZeroCnt[i] = prefNonZeroCnt[i - 1];
        }

        if (digit !== 0) {
            prefSum[i] = (prefSum[i] + digit) % MOD;
            prefNonZeroCnt[i]++;
            prefNonZeroNum[i] = (prefNonZeroNum[i] * 10 + digit) % MOD;
        }
    }

    const ans = new Array(queries.length);

    for (let i = 0; i < queries.length; i++) {
        const [l, r] = queries[i];

        let sum = prefSum[r] - (l > 0 ? prefSum[l - 1] : 0);
        sum = ((sum % MOD) + MOD) % MOD;

        const cnt = prefNonZeroCnt[r] - (l > 0 ? prefNonZeroCnt[l - 1] : 0);

        let num = prefNonZeroNum[r] -
            (l > 0 ? (prefNonZeroNum[l - 1] * power(10, cnt, MOD)) % MOD : 0);
        num = ((num % MOD) + MOD) % MOD;

        ans[i] = Number((sum * num) % MOD);
    }

    return ans;
};

function power(a, b, mod) {
    let res = 1;
    a %= mod;

    while (b > 0) {
        if (b & 1) {
            res = (res * a) % mod;
        }
        a = (a * a) % mod;
        b >>= 1;
    }

    return res;
}
