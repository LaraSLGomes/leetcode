/**
 * @param {number} n
 * @param {number[][]} roads
 * @return {number}
 */
var minScore = function(n, roads) {
    const graph = Array.from({ length: n + 1 }, () => []);

    for (const [a, b, distance] of roads) {
        graph[a].push([b, distance]);
        graph[b].push([a, distance]);
    }

    const visited = new Array(n + 1).fill(false);

    const queue = [1];
    let front = 0;
    visited[1] = true;

    let answer = Infinity;

    while (front < queue.length) {
        const city = queue[front++];

        for (const [nextCity, distance] of graph[city]) {
            answer = Math.min(answer, distance);

            if (!visited[nextCity]) {
                visited[nextCity] = true;
                queue.push(nextCity);
            }
        }
    }

    return answer;
};