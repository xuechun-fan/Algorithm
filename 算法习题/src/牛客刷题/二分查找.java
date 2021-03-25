package 牛客刷题;

public class 二分查找 {
    public static int upper_bound(int n, int v, int[] a){
        // write code here
        if(a==null || a.length==0){
            return n+1;
        }
        int left = 0, right = n-1;
        while(left<right){
            int mid = (left+right)>>1;
            if(v==a[mid]){
                // 朝左侧检查重复值
                while(mid>=0 && v==a[mid]){
                    mid--;
                }
                return mid+2;
            }else if(v<a[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(a[left]>=v){
            return left+1;
        }
        return n+1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 4, 4, 5};
        int res = upper_bound(5, 5, arr);
        System.out.println(res);
    }
}
