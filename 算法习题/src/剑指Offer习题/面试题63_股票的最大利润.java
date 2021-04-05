package 剑指Offer习题;

import javax.print.DocFlavor;

/**
 * Description：
 * 假设把某股票的价格按照时间先后顺序存储在数组中，
 * 请问买卖该股票一次可能获得的最大利润是多少？
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，
 * 最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class 面试题63_股票的最大利润 {
    public static int maxProfit(int[] prices) {
        //  个人理解优点类似于双哨兵
        int maxP = 0;
        int min = Integer.MAX_VALUE;
        for(int num : prices){
            min = Math.min(min, num);
            if(num-min>maxP){
                maxP = num-min;
            }
        }
        return maxP;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        int res = maxProfit(nums);
        System.out.println(res);
    }
}
