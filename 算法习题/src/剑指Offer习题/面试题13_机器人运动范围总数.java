package 剑指Offer习题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description：
 */
public class 面试题13_机器人运动范围总数 {
    //  机器人运动范围
    public static int countRange(int m, int n, int k){
        if(m<0 || n<0 || k<0){
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        return countRangeCore(m, n, k, 0, 0, 0, 0, visited);
    }
    //  DFS方法
    public static int countRangeCore(int m, int n, int k, int i, int j, int si, int sj, boolean[][] visited ){
        int count = 0;
        if(i<m && j<n && si+sj<=k && !visited[i][j]){
            visited[i][j] = true;
            count =  1
                    + countRangeCore(m, n, k, i+1, j, (i+1)%10!=0?si+1:si-8, sj, visited)
                    + countRangeCore(m, n, k, i, j+1, si, (j+1)%10!=0?sj+1:sj-8, visited);
        }
        return count;
    }

    //  检查坐标是否符合规则
    public static boolean checkCoordinates(int row, int col, int k){
        int res = 0;
        while(row%10!=0){
            res += row%10;
            row = row/10;
        }
        while(col%10!=0){
            res += col%10;
            col = col/10;
        }
        return res <= k;
    }

    //  BFS方法
    public static int movingCount(int m, int n, int k){
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0,0});
        while(queue.size()>0){
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if(i>=m || j>=n || si+sj>k || visited[i][j]){
                continue;
            }
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i+1, j, (i+1)%10!=0?si+1:si-8, sj});
            queue.add(new int[]{i, j+1, si, (j+1)%10!=0?sj+1:sj-8});
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[100][100];
        for(int i=0; i<20; i++){
            int res1 = countRange(100, 100, i);
            int res2 = movingCount(100, 100, i);
            System.out.println("k: " + i + "===> " + res1 + "------ " + res2);
        }

    }

}
