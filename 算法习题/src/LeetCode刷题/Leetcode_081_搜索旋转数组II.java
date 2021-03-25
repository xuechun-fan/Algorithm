package LeetCode刷题;

/**
	81. 搜索旋转排序数组 II
	假设按照升序排序的数组在预先未知的某个点上进行了旋转。

	( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

	编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
	示例 1:
	输入: nums = [2,5,6,0,0,1,2], target = 0
	输出: true
	
	示例 2:
	输入: nums = [2,5,6,0,0,1,2], target = 3
	输出: false
*/
public class Leetcode_081_搜索旋转数组II{
	public boolean search(int[] nums, int target){
		// 思路是二分查找，该数组的特点是前后两部分分别都是有序的
		int start = 0, end = nums.length-1;
		while(start<=end){
			int m = (start+end) >> 1;
			if(nums[m]==target) return true;
			if(nums[start]==nums[m]){
				start++;	//排除前面相等的元素，为后续找到两个有序子数组做准备
				continue;
			}
			if(nums[start]<nums[m]){//前半部分有序
				if(nums[start]<=target && nums[m]>target){
					//说明在前半部分
					end = m-1;
				}else{
					start = m+1;
				}
			}else{//后半部分有序
				if(nums[m]<target && nums[end]>=target){
					start = m+1;
				}else{
					end = m-1;	
				}
			}
		}
		return false;
	}
}
