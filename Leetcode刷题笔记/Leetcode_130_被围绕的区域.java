package LeetCode刷题;

public class Leetcode_130_被围绕的区域 {
    /**
     * 给定一个二维的矩阵，包含'X'和'O'（字母 O）。
     *
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的'O' 用 'X' 填充。
     *
     * 示例:
     *
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * 运行你的函数后，矩阵变为：
     *
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * 解释:
     *
     * 被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。
     * 任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。
     * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的
     */

    public static void solve(char[][] board) {
        if(board==null || board.length==0) return;
        for(int i=0; i<board.length; i++){
            dfs(board, i, 0);
            dfs(board, i, board[0].length);
        }
        for(int i=0; i<board[0].length-1; i++){
            dfs(board, 0, i);
            dfs(board, board.length-1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='A') board[i][j] = 'O';
                if(board[i][j]=='X') board[i][j] = 'X';
            }
        }
    }

    private static void dfs(char[][] board, int i, int j){
        if(i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j]=='O'){
            board[i][j] = 'A';
            dfs(board, i-1, j);
            dfs(board, i+1, j);
            dfs(board, i, j-1);
            dfs(board, i, j+1);
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        board[0] = new char[]{'O', 'O', 'O'};
        board[1] = new char[]{'O', 'O', 'O'};
        board[2] = new char[]{'O', 'O', 'O'};
        solve(board);
        System.out.println();;
    }
}
