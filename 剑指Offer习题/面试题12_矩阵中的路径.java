import java.util.LinkedList;
import java.util.Queue;

/**
 * Description：
 */
public class 面试题12_矩阵中的路径 {
    //  深度优先方法
    int m, n, k;
    boolean[][] vis;
    public int movingCountDfs(int m, int n, int k){
        this.m = m;
        this.n = n;
        this.k = k;
        this.vis = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    /**
     * @param i:行索引
     * @param j：列索引
     * @param si：行索引数位和
     * @param sj：列索引数位和
     * @return：可到达方格总数
     */
    private int dfs(int i, int j, int si, int sj){
        if(i>=m || j>=n || vis[i][j] || si+sj>k) return 0;
        vis[i][j] = true;
        return 1
                + dfs(i+1, j, (i+1)%10==0 ? si-8 : si+1, sj)//  向右探测
                + dfs(i, j+1, si, (j+1)%10==0 ? sj-8 : sj+1);// 向下探测
    }


    //  广度优先方法
    public int movingCountBFS(int m, int n, int k){
        this.m = m;
        this.n = n;
        this.k = k;
        this.vis = new boolean[m][n];
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        //  将初始参数入队
        q.add(new int[]{0, 0, 0, 0});
        while(!q.isEmpty()){
            int[] t = q.poll();
            int i = t[0], j = t[1], si = t[2], sj = t[3];
            //  检查当前位置可否到达
            if(i>=m || j>=n || si+sj>k || vis[i][j]) continue;
            res++;
            vis[i][j] = true;
            q.add(new int[]{i+1, j, (i+1)%10==0 ? si-8 : si+1, sj});
            q.add(new int[]{i, j+1, si, (j+1)%10==0 ? sj-8 : sj+1});
        }
        return res;
    }
}
