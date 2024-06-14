import java.util.HashSet;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr={50,3,10,7,40,80};
        int ans=LIS(arr);
        System.out.println(ans);
    }
    public static int LIS(int[] arr){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int[] newArr=new int[set.size()];
        int i=0;
        for(int num:set){
            newArr[i]=num;
            i++;
        }
        return LCS(arr,newArr);
    }
    public static int LCS(int[] arr,int newArr[]){
        int n=arr.length;
        int m=newArr.length;
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr[i-1]==newArr[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    
}
