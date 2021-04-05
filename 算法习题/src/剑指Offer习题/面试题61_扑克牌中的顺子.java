package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题61_扑克牌中的顺子 {
    public static boolean isStraight(int[] nums) {
        //  普通顺子的特征一定是最小牌和最大牌的差为4
        //  但是由于癞子的存在，其实小于等于4就行，但是有一点需要注意，除了癞子可以重复，其他都不允许出现对子
        //  因为牌的数值范围较小，所以不使用Map，而是直接使用数组，类似于计数排序的思想把
        int[] poke = new int[14];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num==0){
                poke[0]++;
            }else{
                if(poke[num]!=0){
                    //  出现癞子外的对子了
                    return false;
                }
                poke[num]++;
                max = Math.max(num, max);
                min = Math.min(num, min);
            }
        }
        return max-min<=4;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 5, 6, 2};
        boolean res = isStraight(nums);
        System.out.println(res);
    }
}
