package 剑指Offer习题;

/**
 * Description：在一个数组 nums 中除一个数字只出现一次之外，
 * 其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class 面试题56II_数组中数字出现的次数II {
    public static int singleNumber(int[] nums){
        //  引入了有限状态机
        //  按位分析的话，每位上的所有数字的和对3取模，只有可能会是0、1、2三种情况
        //  但是每一位只能是0、1， 所以使用两个bit来表示，two、one
        int two = 0, one = 0;
        for(int num:nums){
            one = (num^one) & ~two;
            two = (num^two) & ~one;
        }
        //  因为我们只需要看0、1的情况，而0和1只在one的状态里，所以返回one即可
        return one;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 3, 4, 3, 3, 4, 4};
        int res = singleNumber(nums);
        System.out.println(res);
    }

}
