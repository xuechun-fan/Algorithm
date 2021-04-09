package 面试题积累.便利蜂笔试题;

import java.util.*;

/**
 * Description：合并区间
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(",");
        int[][] matrix = new int[strs.length][2];
        for(int i=0; i<strs.length; i++){
            String[] data = strs[i].split("-");
            int[] tmp = new int[2];
            tmp[0] = Integer.parseInt(data[0]);
            tmp[1] = Integer.parseInt(data[1]);
            matrix[i] = tmp;
        }

        String res = process(matrix);
        System.out.println(res);
    }

    public static String process(int[][] matrix){
        if(matrix==null || matrix.length==0) return "";
        Arrays.sort(matrix, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        int[] tmp = matrix[0];
        for(int i=1; i<matrix.length; i++){
            if(matrix[i][0]-1<=tmp[1]){
                tmp[1] = Math.max(matrix[i][1], tmp[1]);
            }else{
                res.add(tmp);
                tmp = matrix[i];
            }
        }
        res.add(tmp);
        StringBuilder sb = new StringBuilder();
        for(int[] t : res){
            sb.append(t[0]);
            sb.append("-");
            sb.append(t[1]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}
