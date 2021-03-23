
import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 */
public class Leetcode_5680_找到最近的有相同X或Y坐标的点 {
    public static int nearestValidPoint(int x, int y, int[][] points) {
        int res = -1;
        int distance = Integer.MAX_VALUE;
        for(int i=0; i<points.length; i++){
            if(x==points[i][0] || y==points[i][1]) {
                //  有效点存在
                int newDistance = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (newDistance < distance) {
                    distance = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                    res = i;
                }else if(newDistance == distance){
                   res =  Math.min(res, i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 3, y = 4;
        int[][] points = new int[5][2];
        points[0] = new int[]{1, 2};
        points[1] = new int[]{3, 1};
        points[2] = new int[]{2, 4};
        points[3] = new int[]{2, 3};
        points[4] = new int[]{4, 4};
        int res = nearestValidPoint(x, y, points);
        System.out.println(res);
    }
}
