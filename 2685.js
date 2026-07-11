/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number}
 */
var countCompleteComponents = function(n, edges) {
    const graph = Array.from({ length: n }, () => []);
    for (const [u, v] of edges) {
        graph[u].push(v);
        graph[v].push(u);
    }

    const visited = new Array(n).fill(false);
    let count = 0;

    for (let node = 0; node < n; node++) {
        if (!visited[node]) {
            visited[node] = true;
            let edgeCount = 0;
            let nodeCount = 0;
            const stack = [node];

            while (stack.length) {
                const curr = stack.pop();
                edgeCount += graph[curr].length;
                nodeCount += 1;

                for (const next of graph[curr]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        stack.push(next);
                    }
                }
            }

            if (edgeCount / 2 === (nodeCount * (nodeCount - 1)) / 2) {
                count += 1;
            }
        }
    }

    return count;
};
