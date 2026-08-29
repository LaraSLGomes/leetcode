const lexicographicallySmallestArray = (A, limit) => {
    const arr = [...A.entries()].sort((a, b) => a[1] - b[1]);
    let l = 0;

    arr.forEach((c, i) => {
        if (i === arr.length - 1 || arr[i + 1][1] - c[1] > limit) {
            arr.slice(l, i + 1)
                .map(([j]) => j)
                .sort((a, b) => a - b)
                .forEach((idx, k) => A[idx] = arr[l + k][1]);
            l = i + 1;
        }
    });

    return A;
};