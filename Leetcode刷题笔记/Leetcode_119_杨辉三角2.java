package LeetCode刷题;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_119_杨辉三角2 {
    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     */
    //  递推法
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for(int i=1; i<=rowIndex; i++){//   迭代计算每一行
            //  新加的数字就相当于上一行相同位置，因为上一行最后一位不存在，所以加0
            row.add(0);
            //  每行从右往左计算，保证左边的数字可作为上一行的数字来使用
            for(int j=i; j>0; j--){
                row.set(j, row.get(j) + row.get(j-1));
            }
        }
        return row;
    }

    //  数学公式法 Cnm = Cn(m-1) * (n-m+1)/m
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        for(int i=1; i<=rowIndex; i++) {
            res.add((int) ((long) res.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(3);
        System.out.println(row);
        System.out.println(1&2);
    }
}
