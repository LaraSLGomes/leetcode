var findTheDistanceValue = function(arr1, arr2, d) {
    const far = a => arr2.every(b => Math.abs(a - b) > d);  // no b in [a - d, a + d]
    return arr1.filter(far).length;
};