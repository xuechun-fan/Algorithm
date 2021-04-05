package 剑指Offer习题;

/**
 * Description：
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class 面试题56_数组中数字出现的次数 {
    public static int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        //  假设数组中只有a、b只出现了一次，首先全部异或，最后的结果就是a^b的值
        int t = 0;
        for(int num : nums) t ^=num;
        //  然后分析a^b的结果，这个结果按位分析的话，只要是为1的位，一定是a、b不同的位置
        int i = 1;
        while((i&t)==0) i <<= 1;
        //  此时i就是从右往左看第一位a、b不同的位置，根据这个位，我们可以将其他数字分成两部分
        //  根据当前位 & 上其他数字，就可以简单的分成两组，分别放到res[0] 和 res[1]中
        //  又因为其他数字都是偶数次，经过异或运算最终都会消失，只剩下单独出现的数字
        for(int num : nums){
            if((num&i)==0){
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,2};
        int[] res = singleNumbers(nums);
        for(int num:res){
            System.out.print(num + "\t");
        }
    }
}
