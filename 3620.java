class Solution {
    int max=-1;
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n=online.length;
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] e:edges){
            adj.get(e[0]).add(new int[]{e[1],e[2]});
        }
        dfs(0,Long.MAX_VALUE,0,adj,online,k,n);
        return max;
    }

    public void dfs(int f,long min,long sum,List<List<int[]>> adj,boolean[] online,long k,int n){
        if(sum>k || min<=max)return;
        if(f==n-1){
            max=(int)Math.max(max,min);
            return;
        }
        for(int[] nxt:adj.get(f)){
            if( nxt[0]!=0 && nxt[0]!=n-1 && !online[nxt[0]])continue;
            dfs(nxt[0], Math.min(min,nxt[1]),sum+nxt[1],adj,online,k,n);
        }
    }
}