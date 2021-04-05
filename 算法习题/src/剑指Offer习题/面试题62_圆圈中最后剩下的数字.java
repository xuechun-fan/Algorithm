package 剑指Offer习题;

/**
 * Description：
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *  示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 *  示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 */
public class 面试题62_圆圈中最后剩下的数字 {
    public static int lastRemaining(int n, int m) {
        //  看评论说是约瑟夫环的问题
        //  个人理解就是根据最后一个数的下标一定是0， 然后反推到初始时刻的下标
        int size = 2;
        int i = 0;
        while(size<=n){
            i = (i+m)%size;
            size++;
        }
        return i;
    }

    public static void main(String[] args) {
        int res = lastRemaining(10, 17);
        System.out.println(res);
    }
}
