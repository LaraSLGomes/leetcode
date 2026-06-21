var largestAltitude = function(gain) {
    let alt = 0, mx = 0;

    for (let x of gain) {
        alt += x;
        mx = Math.max(mx, alt);
    }

    return mx;
};