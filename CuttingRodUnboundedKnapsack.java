public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[][] dp=new int[n+1][n+1];
		for(int i=0;i<n+1;i++){
			dp[i][0]=0;
		}
		for(int j=0;j<n+1;j++){
			dp[0][j]=0;
		}
		for(int i=1;i<n+1;i++){
			for(int j=1;j<n+1;j++){
				if(i<=j){
					dp[i][j]=Math.max(price[i-1]+dp[i][j-i],dp[i-1][j]);
				}
				else{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n][n];
	}
}
