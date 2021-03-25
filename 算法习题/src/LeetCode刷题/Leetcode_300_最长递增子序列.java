/**
 * Description:
 */
public class Leetcode_300_最长递增子序列 {
    public static int[] LIS(int[] arr){
        if(arr==null || arr.length==0) return null;
        int[] dp = new int[arr.length];
        //  计算dp数组，dp[i]表示为以arr[i]结尾的最大递增子序列的长度
        for(int i=0; i< arr.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        //  找到最大长度，和对应最后一位数字的下标
        int len = 0, index = 0;
        for (int i = 0; i < dp.length; i++) {
            if(len<dp[i]){
                len = dp[i];
                index = i;
            }
        }

        //  通过dp数组反推子序列包含的数据
        int[] lis = new int[len];
        lis[--len] = arr[index];
        for(int i=index; i>=0; i--){
            if(arr[i]<arr[index] && dp[i]==dp[index]-1){
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }
//    private static int[] getdp1(int[] arr){
//
//    }
//    private static int[] generateLIS(int[] arr, int[] dp){
//
//    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,3,6,4,8,9,7};
        int[] res = LIS(arr);
        for(int n:res){
            System.out.print(n+"\t");
        }

    }
}
