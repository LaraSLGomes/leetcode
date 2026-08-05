class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> graph,boolean [] vis)
    {
        vis[node]=true;
        for(int neigh:graph.get(node))
        {
            if(!vis[neigh])
            {
                dfs(neigh,graph,vis);
            }
        }

    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int [] edge: invocations)
        graph.get(edge[0]).add(edge[1]);

        boolean [] vis=new boolean[n];

        dfs(k,graph,vis);
        
        for(int [] edges:invocations)
        {
            int u=edges[0];
            int v=edges[1];
            if(!vis[u] && vis[v])
            {
                List<Integer> ans = new ArrayList<>();
                for(int i = 0; i < n; i++)
                    ans.add(i);
                return ans;
            }
        }

        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            ans.add(i);
        }
    return ans;
    }
}