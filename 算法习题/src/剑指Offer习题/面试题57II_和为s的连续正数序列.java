package 剑指Offer习题;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */
public class 面试题57II_和为s的连续正数序列 {
    public static int[][] findContinuousSequence(int target){
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while(i<j){
            if(s==target){
                int[] t = new int[j-i+1];
                for (int k = i; k <=j ; k++) {
                    t[k-i] = k;
                }
                res.add(t);
            }
            if(s<target){
                j++;
                s += j;
            }else{
                s -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }


    public static void main(String[] args) {
        int[][] res = findContinuousSequence(9);
        for(int[] arr:res){
            for(int num : arr){
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
