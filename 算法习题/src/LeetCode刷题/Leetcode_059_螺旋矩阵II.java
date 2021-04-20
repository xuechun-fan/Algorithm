package LeetCode刷题;

/**
 * Description：
 */
public class Leetcode_059_螺旋矩阵II {
    public static int[][] generateMatrix(int n) {
    /**
    * 整体思路：
    *       根据n的奇偶性分开讨论，按圈赋值，如下图，按a->b->c->d的顺序赋值
    * case1：n为偶数
    *           a a a b
    *   loop1:  d x x b     loop2:  a b
    *           d x x b             d d
    *           d c c c
    * case2：n为奇数
    *           a a b
    *   loop1:  d x b       loop2:   x->a
    *           d c c
    *
    */
        int[][] res = new int[n][n];
        int N = (int)Math.pow(n, 2);
        int num = 1;
        int s = 0;//初始化起始坐标
        //  数据范围：[1,N]
        while(num<=N){
            //  单独处理奇数情况的最后剩下一个元素未填充的情况
            if(n-1==(s<<1)){
                res[s][s] = num++;
                break;
            }
            int i = s, j = s;
            //  a过程
            while(j<n-1-s && num<=N){
                res[i][j++] = num++;
            }
            //  b过程
            while(i<n-1-s && num<=N){
                res[i++][j] = num++;
            }
            //  c过程
            while(j>s && num<=N){
                res[i][j--] = num++;
            }
            //  d过程
            while(i>s && num<=N){
                res[i--][j] = num++;
            }
            //  更新起始坐标
            s++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = generateMatrix(5);
        for(int[] row:res){
            for(int num:row){
                System.out.print(num+"\t");
            }
            System.out.println();
        }
    }
}