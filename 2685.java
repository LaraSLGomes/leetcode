class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[][] edgesList = new int[n][n];
        int[] listSize = new int[n];
        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int[] edge : edges) {
            edgesList[edge[0]][listSize[edge[0]]++] = edge[1];
            edgesList[edge[1]][listSize[edge[1]]++] = edge[0];
        }
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                visited[node] = true;
                int[] edgeNodeCount = new int[]{0, 1};
                depthFirstSearch(node, edgesList, listSize, visited, edgeNodeCount);
                if (edgeNodeCount[0] / 2 == edgeNodeCount[1] * (edgeNodeCount[1] - 1) / 2) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public void depthFirstSearch(int node, int[][] edgeList, int[] listSize, boolean[] visited, int[] edgeNodeCount) {
        edgeNodeCount[0] += listSize[node];
        for (int next = 0; next < listSize[node]; next++) {
            if (!visited[edgeList[node][next]]) {
                visited[edgeList[node][next]] = true;
                edgeNodeCount[1]++;
                depthFirstSearch(edgeList[node][next], edgeList, listSize, visited, edgeNodeCount);
            }
        }
    }
}