/**
 * Description：
 */
public class 面试题_45_把数组排成最小的数 {
    public static String minNumber(int[] nums) {
        //转成字符串，定义新的排序规则
        String[] strs = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length-1);
        StringBuilder res = new StringBuilder();
        for(String str:strs){
            res.append(str);
        }
        return res.toString();
    }
    private static void quickSort(String[] arr, int l, int r){
        if(l>=r) return;
        int i=l, j=r;
        String base = arr[l];
        while(i<j){
            while(i<j && (arr[j]+base).compareTo(base+arr[j])>=0) j--;
            while(i<j && (arr[i]+base).compareTo(base+arr[i])<=0) i++;
            if(i<j){
                String t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[l] = arr[j];
        arr[j] = base;
        quickSort(arr, l, j);
        quickSort(arr, j+1, r);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        String res = minNumber(nums);
        System.out.println(res);
    }
}
