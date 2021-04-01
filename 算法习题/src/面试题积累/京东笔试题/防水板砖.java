package 面试题积累.京东笔试题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**                     防水板砖
 * 题目描述：
 * 在X星的一片建筑工地上堆放着很多防水板砖，它们每一块的规格都一模一样，但是每一叠都高矮不一，这些砖块堆放得非常整齐而且非常紧凑，
 * 紧凑到“滴水不漏”。俯视这些砖块可以得到一个n*m的矩阵。现在给你一个n*m的矩阵，第n行m列上的数字表示对应位置的板砖数量，
 * 例如下面的矩阵所示：
 * 第1行第1列的“2”表示这个位置对应的那一叠板砖的数量为2块。
 *
 * 某一天突然天降暴雨。暴雨过后，在板砖区形成了很多个小水坑。如果某一叠板砖的数量比它周围前、后、左、右的板砖数量少，
 * 将形成一个小水坑。相邻的两叠或者多叠板砖可能会构成一个大一点的水坑。例如在上面的图中，两叠红色的板砖将构成一个水坑，
 * 因为它们周围上、下、左、右的板砖（蓝色板砖）的数量比它们要多。
 * 当然，最旁边的板砖是没有办法形成小水坑的。
 * 假如这场雨下得足够大，足以让每一水坑都装满水。现在请问，暴雨过后在板砖区一共留下了多少个水坑？
 *
 * 单组输入。
 *
 * 第1行输入两个正整数分别表示n和m，n和m均不超过100，两个数字之间用空格隔开。
 *
 * 接下来n行是一个n*m的矩阵，每一行m个正整数，表示某一叠板砖的数量，两个正整数之间用空格隔开。
 * 输出一个整数，即留下的水坑数量（存在一个水坑也没有的情况）
 *
 */
public class 防水板砖 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int res = findPool(arr, n, m);
        System.out.println(res);
    }

    private static int findPool(int[][] arr, int n, int m) {
        if(arr==null || arr.length==0){
            return 0;
        }
        int[][] row = new int[n][m];
        int[][] col = new int[n][m];
        Deque<Integer> q = new LinkedList<>();
        //  从1，1开始，按行寻找水坑
        for(int i=1; i<n-1; i++){
            //  将左边界的下标放入单调栈中
            q.addLast(0);
            for(int j=1; j<m; j++){
                while(!q.isEmpty() && arr[i][j] >arr[i][q.peekLast()]){
                    int idx = q.pollLast();
                    row[i][idx] = (idx==0||idx==m-1) ? 0 : 1;
                }
                q.addLast(j);
            }
            q.removeAll(q);
        }
        //  从1，1开始，按列寻找水坑
        for(int j=1; j<m-1; j++){
            q.addLast(0);
            for(int i=1; i<n; i++){
                while(!q.isEmpty() && arr[i][j] > arr[q.peekLast()][j]){
                    int idx = q.pollLast();
                    col[idx][j] = (idx==0||idx==m-1) ? 0 : 1;
                }
                q.addLast(i);
            }
            q.removeAll(q);
        }
        int[][] nums = new int[n][m];
        for(int i=1; i<n-1; i++){
            for (int j = 1; j < m-1 ; j++) {
                nums[i][j] = row[i][j]*col[i][j];
            }
        }
        int res = 0;
        for(int i=1; i<n-1; i++){
            for(int j=1; j<n-1; j++){
                if(nums[i][j]==1){
                    dfs(nums, n, m, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] arr, int n, int m, int i, int j){
        if(i>=1 && i<n-1 && j>=1 && j<m-1 && arr[i][j]==1){
            arr[i][j] = -1;
            dfs(arr, n, m, i, j+1);
            dfs(arr, n, m, i+1, j);
        }
    }
}