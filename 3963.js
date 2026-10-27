var createGrid = function(m, n) {
    const grid = Array(m).fill('.'.padStart(n, '#'));  // walls, then the last cell open
    grid[0] = '.'.repeat(n);  // the first row is all open
    return grid;
};