/**
 * @param {number} n
 * @param {number} k
 * @param {number[][]} edges
 * @return {number[]}
 */
var remainingMethods = function(n, k, edges) {

    const graph = new Map();

    for(const [u,v] of edges){
        if(!graph.has(u)) graph.set(u, []);
        graph.get(u).push(v);
    }

    const mark = new Array(n).fill(0);
    let outsideConnection = false;

    const bfs = (color, src) => {
        const q = [src];
        mark[src] = color;

        while(q.length){
            const node = q.shift();

            if(!graph.has(node)) continue;

            for(const nxt of graph.get(node)){
                if(mark[nxt] === 1 && color === 2){
                    outsideConnection = true;
                    return;
                }

                if(mark[nxt] !== color){
                    mark[nxt] = color;
                    q.push(nxt);
                }
            }
        }
    };

    bfs(1, k);

    for(let i = 0; i < n; i++){
        if(i === k || mark[i] === 1) continue;
        bfs(2, i);
    }

    const res = [];

    for(let i = 0; i < n; i++){
        if(!outsideConnection && mark[i] === 1) continue;
        res.push(i);
    }

    return res;
};