public class TargetSumKnapSackVariationTabulation {
    public static void main(String[] args) {
        int[] arr={4,2,7,1,3};
        int sum=10;
        System.out.println(isTargetSubsetExist(arr,sum));
    }
    public static boolean isTargetSubsetExist(int[] arr,int sum){
        int n=arr.length;
        int W=sum;
        boolean dp[][]=new boolean[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v=arr[i-1];
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }
                else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }
        return dp[n][W];
    }
    
}
