package 剑指Offer习题;

/**
 * Description：
 * 给定一个数组 A[0,1,…,n-1]，
 * 请构建一个数组 B[0,1,…,n-1]，
 * 其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 * 不能使用除法
 */
public class 面试题66_构建乘积数组 {
    public int[] constructArr(int[] a) {
        //  两次遍历把，然后用一个临时变量存放累乘积
        int[] res = new int[a.length];
        for(int i=0; i<res.length; i++) res[i]=1;
        int tmp = 1;
        //  首先顺序遍历，要从下标1开始
        for(int i=1; i<a.length; i++){
            tmp *= a[i-1];
            res[i] *= tmp;
        }
        //  反向遍历，从下标n-2开始
        tmp = 1;
        for(int i=a.length-2; i>=0; i--){
            tmp *= a[i+1];
            res[i] *= tmp;
        }
        return res;
    }
}
