package LeetCode刷题;

public class Leetcode_048_旋转图像 {
    public static void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0) return;
        int loops = matrix.length>>1;   //  外环数
        for(int l=0; l<loops; l++){
            int s = l, e = matrix.length-1-s;
            process(matrix, s, e);
        }
    }
    private static void process(int[][] arr, int s, int e){
        for(int i=0; i<e-s; i++){
            int t = arr[s+i][e];
            arr[s+i][e] = arr[s][s+i];
            int tn = arr[e][e-i];
            arr[e][e-i] = t;
            t = arr[e-i][s];
            arr[e-i][s] = tn;
            arr[s][s+i] = t;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{5,1,9,11};
        matrix[1] = new int[]{2,4,8,10};
        matrix[2] = new int[]{13,3,6,7};
        matrix[3] = new int[]{15,14,12,16};
        rotate(matrix);
        System.out.println();
    }
}
