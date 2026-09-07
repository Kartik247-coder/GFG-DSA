class Solution {
    public static int sol(int n,int[] dp){
        
        if(n==0 || n==1) return dp[n]=1;
        
        if(dp[n]!=-1) return dp[n];
        //vertically
        int ver=sol(n-1,dp);
        
        //horizontally
        int hor=sol(n-2,dp);
        
        return dp[n]=ver+hor;
      
    }
    public int numberOfWays(int n) {
        // code here
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return sol(n,dp);
    }
};