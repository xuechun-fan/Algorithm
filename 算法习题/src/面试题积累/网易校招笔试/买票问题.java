package 面试题积累.网易校招笔试;

import java.util.Scanner;

/**
 * Description：
 */
public class 买票问题 {
    private static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n-1];
            for(int j=0; j<n; j++){
                a[j] = sc.nextInt();
            }
            if(n>1) {
                for (int j = 0; j < n - 1; j++) {
                    b[j] = sc.nextInt();
                }
            }
            //  首先第一个人肯定要先买票，他是没有选择的，从第二个人就可以有选择了，要么自己买，
            //  要么和前面的大哥一起买，这样的话就是二选一，可以联想到是一个建树的过程，那么递归就应运而生了
            res = Integer.MAX_VALUE;    //  初始化累加和
            dfs(a, b, 0, 0);
            
            System.out.println(res);

        }
    }

    private static void dfs(int[] a, int[] b, int i, int sum){    //  i代表a数组的下标，j代表b数组的下标, sum代表当前的时间和
        if(i==a.length) {
            res = Math.min(res, sum);
            return;
        }
        if(i<a.length-1){
            dfs(a, b, i+1,sum+a[i]);
            dfs(a, b, i+2, sum+b[i]);
        }else{
            dfs(a, b, i+1, sum+a[i]);
        }
    }
}
