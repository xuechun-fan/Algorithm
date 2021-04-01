package 剑指Offer习题;

public class 面试题12_矩阵中的路径_牛客版 {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null || matrix.length==0 || str==null || str.length==0) return false;
        boolean res = false;
        for(int i=0; i<rows*cols; i++){
            res = dfs(matrix, rows, cols, str, i/rows, i-(i/cols)*rows, 0);
            if(res) break;
        }
        return res;
    }
    private static boolean dfs(char[] matrix, int rows, int cols,
                               char[] str, int i, int j, int len){
        if(len==str.length) return true;
        boolean flag = false;
        if(i>=0 && i<rows && j>=0 && j<cols && matrix[i*cols+j]==str[len]){
            len++;
            char ch = matrix[i*cols+j];
            matrix[i*cols+j] = '0';
            flag = dfs(matrix, rows, cols, str, i, j-1, len)
                    || dfs(matrix, rows, cols, str, i, j+1, len)
                    || dfs(matrix, rows, cols, str, i-1, j, len)
                    || dfs(matrix, rows, cols, str, i+1, j, len);
            len--;
            matrix[i*cols+j] = ch;
        }
        return flag;
    }

    /**
     *  1 2 3 4 5 6 7 8
     *  A B C E H J I G
     *  S F C S L O P Q
     *  A D E E M N O E
     *  A D I D E J F M
     *  V C E I F G G S
     *
     *  S L H E C C E I D E J F G G F I E
     *
     */

    public static void main(String[] args) {
        char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] str = "SLHECCEIDEJFGGFIE".toCharArray();
        boolean res = hasPath(matrix,5, 8,  str);
        System.out.println(res);
    }
}
