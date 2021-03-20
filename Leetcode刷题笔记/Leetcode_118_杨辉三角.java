package LeetCode刷题;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_118_杨辉三角 {
    public static  List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) return res;
        //  直接创建出 N 行列表，用来存储结果
        for (int i = 0; i < n; i++) {
            List<Integer> ans = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0 || i==j) ans.add(1);
                else ans.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
            }
            res.add(ans);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = generate(10);
        for (List<Integer> list : res){
            System.out.println(list);
        }
    }
}
