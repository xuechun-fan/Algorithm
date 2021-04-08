package LeetCode刷题;

public class Leetcode_048_旋转图像 {
    public static void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0) return;
        int loops = matrix.length>>1;   //  外环数
        for(int l=0; l<loops; l++){
            int s = l, e = matrix.length-1-s;
            for(int i = 0; i<e-s; i++){
                int t = matrix[s][s+i];
                matrix[s][s+i] = matrix[e-i][s];
                matrix[e-i][s] = matrix[e][e-i];
                matrix[e][e-i] = matrix[s+i][e];
                matrix[s+i][e] = t;
            }

        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{5,1,9,11};
        matrix[1] = new int[]{2,4,8,10};
        matrix[2] = new int[]{13,3,6,7};
        matrix[3] = new int[]{15,14,12,16};
        rotate(matrix);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
