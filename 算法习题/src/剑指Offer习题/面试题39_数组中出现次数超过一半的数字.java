package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题39_数组中出现次数超过一半的数字 {
    public static int majorityElement(int[] nums) {
        int vote = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==vote){
                cnt++;
            }else{
                cnt--;
                if(cnt==0){
                    vote = nums[i];
                    cnt = 1;
                }
            }
        }
        return vote;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int res= majorityElement(nums);
        System.out.println(res);
    }
}
