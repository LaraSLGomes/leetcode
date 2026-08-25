var missingMultiple = function(nums, k) {
    const contains = new Array(101).fill(false);

    for (const ele of nums) {
        contains[ele] = true;
    }

    let ans = k;

    while (ans <= 100 && contains[ans]) {
        ans += k;
    }

    return ans;
};