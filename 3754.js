/**
 * @param {number} n
 * @return {number}
 */
var sumAndMultiply = function(n) {
    let x = 0;
    let sum = 0;
    let place = 1;

    while (n > 0) {
        const d = n % 10;

        if (d !== 0) {
            x = d * place + x;
            place *= 10;
            sum += d;
        }

        n = Math.floor(n / 10);
    }

    return x * sum;
};
