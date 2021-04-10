package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题29_顺时针打印矩阵 {
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0) return new int[0];
        int[] res = new int[matrix.length * matrix[0].length];
        int idx = 0;
        int loops = Math.min(matrix.length, matrix[0].length)>>1;
        for(int edge = 0; edge<=loops; edge++){
            int re = matrix[0].length-1-edge;   //  行上的左右边界
            int ce = matrix.length-1-edge;    //  列上的上下边界
            int i = edge, j = edge;
            //  这里需要提一下按外圈打印的一点细节，就是打印行的时候进行完整打印，打印两边的列的时候，我们要跳过边角的位置
            //  因为在打印行数据的时候我们已经包括了四个角的数据
            //  从左到右
            while(idx<res.length && j<=re){
                res[idx++] = matrix[i][j++];
            }
            //  更新下一个需要打印的坐标，避免重复打印角落数据
            j = re;
            i++;

            //  从上到下
            while(idx<res.length && i<ce){
                res[idx++] = matrix[i++][j];
            }

            //  从右到左
            while(idx<res.length && j>=edge){
                res[idx++] = matrix[i][j--];
            }
            //  更新下一个需要打印的坐标，避免重复打印角落数据
            j = edge;
            i--;

            //  从下到上
            while(idx<res.length && i>edge){
                res[idx++] = matrix[i--][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] res = spiralOrder(matrix);
        for(int num:res){
            System.out.print(num + "\t");
        }
    }
}
