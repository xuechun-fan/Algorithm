package 牛客刷题;

/**
 * 求平方根，向下取整
 */
public class 求平方根 {
    public static int sqrt(int x){
        //  牛顿迭代法
        if(x<=0){
            return 0;
        }
        long r = x;
        while(r > x/r){
            r = (r + x/r) >> 1;
        }
        return (int)r;
    }

    public static int sqrt1(int x){
        //  二分法
        if(x<=0){
            return 0;
        }
        int l = 0, r = x;
        int ans = -1;
        while(l<=r){
            int mid = (l+r)>>1;
            if((long)mid*mid <= x){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int res = sqrt1(2);
        System.out.println(res);
    }
}
