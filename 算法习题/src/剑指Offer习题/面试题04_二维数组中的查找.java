package 剑指Offer习题;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Description:
 */
public class 面试题04_二维数组中的查找 {
    /**
     * 二维数组中的查找
     * 数组数据从左向右、从上向下递增
     * @param arr：输入二维数组
     * @param num：要查找的值
     * @return： 是否查找成功
     */
    public static boolean test(int[][] arr, int num){
        if(arr==null || arr.length==0){
            return false;
        }
        int rows = arr.length, cols = arr[0].length;
        int row = 0, col = cols - 1;
        while(row<rows && col>=0){
            if(arr[row][col]==num){
                return true;
            }else if(arr[row][col]>num){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

    /**
     * 二维数组中第k小的数字
     * @param matrix：输入二维数组
     * @param k：第k小
     * @return： 第k小的值
     */
    public static int kthSmallest(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0, sum = 0;
        boolean lastLine = (m==1 || n==1);
        while(!lastLine && sum+m+n-1 < k){
            sum += m+n-1;
            m--;
            n--;
            start++;
            if(n==1 || m==1){
                lastLine = true;
            }
        }
        k -= sum;
        int[] res;
        if(lastLine){   // 剩下最后一行或一列
            if(m==1){// 剩下最后一行
                res = new int[matrix[0].length - start];
                for(int i=start; i<res.length; i++){
                    res[i-start] = matrix[start][i];
                }
            }else{  // 剩下最后一列
                res = new int[matrix.length - start];
                for(int i=start; i<res.length; i++){
                    res[i-start] = matrix[i][start];
                }
            }
        }
        //  将当前行和列加入res
        res = new int[m+n-1];
        int idx = 0;
        //  添加行
        for(int i=start; i<matrix[0].length; i++){
            res[idx++] = matrix[start][i];
        }
        //  添加列
        for (int i = start+1; i <matrix.length ; i++) {
            res[idx++] = matrix[i][start];
        }
        Arrays.sort(res);
        return res[k-1];
    }





    public static void main(String[] args) {
        int[][] arr = new int[3][4];
        arr[0] = new int[]{1, 9, 10};
        arr[1] = new int[]{6, 13, 15};
        arr[2] = new int[]{11,14,29};
        int k = 5;
        int res = kthSmallest(arr, k);
        System.out.println(res);
    }
}
