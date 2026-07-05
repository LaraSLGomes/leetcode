class Solution {
    int M=(int)1e9+7;
    public int solve (List<String> board , int i, int j,int[][] sdp,int[][] pdp){
     if(i==0 && j==0 ){
         pdp[i][j]=1; 
         return sdp[i][j]= 0; 
     }
    if(sdp[i][j]!= -1){
        return sdp[i][j];
    }
    int val=0;
    if(board.get(i).charAt(j)!='S') val= board.get(i).charAt(j) - '0';
    int ans=0, l=-(int)1e9, u=-(int)1e9, d=-(int)1e9;

     if(i-1 >=0 && board.get(i-1).charAt(j)!= 'X'){
         u = solve(board,i-1,j,sdp,pdp);
     }
     if(i-1 >=0 && j-1>=0  && board.get(i-1).charAt(j-1)!= 'X'){
         d = solve(board,i-1,j-1,sdp,pdp);
     }
     if(j-1 >=0 && board.get(i).charAt(j-1)!= 'X'){
         l = solve(board,i,j-1,sdp,pdp);
     }

    
     ans=Math.max(l,Math.max(u,d));

     if(ans == -(int)1e9){
         val=0; ans=0;
         
         if(board.get(i).charAt(j)=='S')return sdp[i][j]=0;

         return sdp[i][j]=-(int)1e9;
     }

     
     if(l==ans){ pdp[i][j]=(pdp[i][j]+pdp[i][j-1])%M; }
     if(u==ans){ pdp[i][j]=(pdp[i][j]+pdp[i-1][j])%M; }
     if(d==ans){ pdp[i][j]=(pdp[i][j]+pdp[i-1][j-1])%M; }
     
    return sdp[i][j]= ( ans + val ) % M;
    }
    
    public int[] pathsWithMaxScore(List<String> board) {
    int[] ans =new int[2];
    int r=board.size() , c= board.get(0).length();
    int[][] sdp=new int[r][c]; 
     int[][] pdp=new int[r][c]; 
    for(int[] d:sdp)Arrays.fill(d,-1);
    solve(board,r-1,c-1,sdp,pdp);

    ans[0]=sdp[r-1][c-1]; 
    ans[1]=pdp[r-1][c-1];

    return ans;    
    }
}