package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题45_把数组排成最小的数 {
    static private String[] arr = null;

    public static String minNumber(int[] nums) {
        if(nums==null || nums.length<1){
            return "";
        }
        //  根据自定义判断大小规则，使用快排思想对字符串数组进行排序即可
        //  首先将数组转换成字符串类型
        arr = new String[nums.length];
        for(int i=0; i<nums.length; i++) arr[i] = String.valueOf(nums[i]);
        quickSort(0, arr.length-1);
        StringBuilder res = new StringBuilder();
        for(String str : arr){
            res.append(str);
        }
        return res.toString();
    }
    private static void quickSort(int l, int r){
        if(l>=r) return;
        int i = l, j = r;
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
        quickSort(l, j);
        quickSort(j+1, r);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        String res = minNumber(nums);
        System.out.println(res);
    }
}
