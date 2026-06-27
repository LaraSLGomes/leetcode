/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumLength = function(nums) {

    const mp = new Map();

    for (const num of nums) {
        mp.set(num, (mp.get(num) || 0) + 1);
    }

    let ans = 1;

    if (mp.has(1)) {
        const f = mp.get(1);
        if (f % 2 === 0)
            ans = Math.max(ans, f - 1);
        else
            ans = Math.max(ans, f);
    }

    const keys = Array.from(mp.keys());

    for (const cur of keys) {

        if (cur === 1)
            continue;

        let temp = cur;
        let len = 0;

        while (true) {

            if (!mp.has(temp) || mp.get(temp) < 2)
                break;

            len += 2;
            temp = temp * temp;
        }

        if (mp.has(temp) && mp.get(temp) === 1)
            len++;
        else
            len--;

        ans = Math.max(ans, len);
    }

    return ans;
};