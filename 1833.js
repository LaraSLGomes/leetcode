var maxIceCream = function(costs, coins) {
    costs.sort((a, b) => a - b);

    let count = 0;

    for (const cost of costs) {
        if (cost > coins) break;

        coins -= cost;
        count++;
    }

    return count;
};