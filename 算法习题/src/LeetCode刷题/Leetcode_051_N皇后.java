package LeetCode刷题;

import java.util.*;

/**
 * Description：
 */
public class Leetcode_051_N皇后 {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        this.res = new ArrayList<>();
        int[] quuens = new int[n];  //  存放第i行放置Q的位置
        Arrays.fill(quuens, -1);
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        backTrace(quuens, 0, n, cols, diag1, diag2);
        return res;
    }
    private void backTrace(int[] quuens, int n, int row, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2){
        if(n==row){
            List<String> grid = generateGrid(quuens);
            res.add(grid);
            return;
        }
        for(int i=0; i<n; i++){
            if(cols.contains(i)) continue;
            int d1 = row - i;
            if(diag1.contains(d1)) continue;
            int d2 = row + i;
            if(diag2.contains(d2)) continue;
            //  运行到这里说明当前位置:(n行i列) 可以放置Q
            cols.add(i);
            diag1.add(d1);
            diag2.add(d2);
            quuens[n] = i;
            n++;

            backTrace(quuens, n, row, cols, diag1, diag2);

            n--;
            quuens[n] = -1;
            diag2.remove(d2);
            diag1.remove(d1);
            cols.remove(i);
        }
    }

    private List<String> generateGrid(int[] quuens){
        int n = quuens.length;
        List<String> board = new ArrayList<>();
        for(int i=0; i<n; i++){
            char[] line = new char[n];
            Arrays.fill(line, '.');
            line[quuens[i]] = 'Q';
            board.add(new String(line));
        }
        return board;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Leetcode_051_N皇后().solveNQueens(4);
        for(List<String> list : lists){
            System.out.println(list);
        }
    }
}
