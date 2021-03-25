package 剑指Offer习题;

/**
 * Description：
 */
public class 查找类算法 {

    //  二分查找算法,返回该数字在数组中的下标
    public static int binarySearch(int[] arr, int n){
        if(arr==null || arr.length==0){
            return -1;
        }
        int i = 0, j = arr.length-1;
        while(i<j){
            int mid = i + (j-1)>>1;
            if(arr[mid] == n){
                return mid;
            } else if(arr[mid] > n){
                j = mid -1;
            }else{
                i = mid + 1;
            }
        }
        return -1;
    }


    //  二分查找测试函数
    public static void testBS(){
        int n1 = 2;
        int n2 = 8;
        int[] arr = new int[]{1, 3, 4, 5, 6, 8, 9};
        int r1 = binarySearch(arr, n1);
        int r2 = binarySearch(arr, n2);
        System.out.println(r1==-1?"不存在":"下标为：" + r1);
        System.out.println(r2==-1?"不存在":"下标为：" + r2);

    }
    public static void main(String[] args) {
        testBS();
    }
}
