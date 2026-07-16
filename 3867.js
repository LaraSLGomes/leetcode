/**
 * @param {number[]} nums
 * @return {number}
 */
var gcdSum = function(nums) {
    const n = nums.length;
    if (n === 0) return 0;

    const prefixGcd = new Array(n);
    let maxSoFar = 0;

    for (let i = 0; i < n; i++) {
        maxSoFar = Math.max(maxSoFar, nums[i]);
        prefixGcd[i] = gcd(nums[i], maxSoFar);
    }

    prefixGcd.sort((a, b) => a - b);

    let totalSum = 0;
    for (let i = 0; i < Math.floor(n / 2); i++) {
        totalSum += gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
    }

    return totalSum;
};

function gcd(a, b) {
    while (b !== 0) {
        const temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
