package 牛客刷题;

import java.util.ArrayList;

public class 螺旋矩阵 {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length==0){
            return res;
        }
        int len = Math.min(matrix.length, matrix[0].length);
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i=0; i<=len/2; i++){
            traverseLoop(matrix, res, visited, i, matrix.length-1-i, i, matrix[0].length-1-i);
        }
        return res;
    }

    private static void traverseLoop(int[][] matrix, ArrayList<Integer> res,
                                     boolean[][] visited,
                                     int rs, int re, int cs, int ce){
        int i = rs, j = cs;
        while(checkIndex(i, j, rs, re, cs, ce) && !visited[i][j]){
            res.add(matrix[i][j]);
            visited[i][j] = true;
            if(j==ce){
                i++;
                break;
            }
            j++;
        }
        while(checkIndex(i, j, rs, re, cs, ce) && !visited[i][j]){
            res.add(matrix[i][j]);
            visited[i][j] = true;
            if(i==re){
                j--;
                break;
            }
            i++;
        }
        while(checkIndex(i, j, rs, re, cs, ce)&& !visited[i][j]){
            res.add(matrix[i][j]);
            visited[i][j] = true;
            if(j==cs){
                i--;
                break;
            }
            j--;
        }
        while(checkIndex(i, j, rs, re, cs, ce) && !visited[i][j]){
            res.add(matrix[i][j]);
            visited[i][j] = true;
            if(i==rs){
                break;
            }
            i--;
        }
    }

    private static boolean checkIndex(int i, int j, int rs, int re, int cs, int ce){
        return i<=re && i>=rs && j<=ce && j>=cs;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[1][1];
        matrix[0] = new int[]{1};
//        matrix[1] = new int[]{4, 5, 6};
//        matrix[2] = new int[]{7, 8, 9};
        ArrayList<Integer> integers = spiralOrder(matrix);
        System.out.println(integers);
    }
}
