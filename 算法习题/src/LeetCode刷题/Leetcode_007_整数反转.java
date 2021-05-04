package LeetCode刷题;

import org.junit.Test;

public class Leetcode_007_整数反转 {
    public int reverse(int x) {
        long res = 0;
        int flag = 1;
        if(x<0){
            flag = -1;
            x = -x;
        }
        while(x!=0){
            //  取出当前个位
            res = res *10 + x%10;
            x /= 10;
        }
        if(flag==-1) res = -res;
        return (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) ? 0 : (int)res;
    }

    @Test
    public void test(){
        int res = reverse(-123);
        System.out.println(res);
    }
}
