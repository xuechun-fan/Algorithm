package 面试题积累;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class 投资 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();

        int m = sc.nextInt();// 物品种类

        int[] limit = new int[m];
        for (int i = 0; i < m; i++)
            limit[i] = sc.nextInt();

        int[] cur = new int[m];
        for (int i = 0; i < m; i++)
            cur[i] = sc.nextInt();

        Double[] future = new Double[m];
        for (int i = 0; i < m; i++)
            future[i] = sc.nextDouble();

        Double[] profit = new Double[m];
        for (int i = 0; i < m; i++) {
            profit[i] = future[i] / cur[i];
        }
//  for (Double num : profit) {
//   System.out.println(num);
//  }

        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(profit[i], i);
        }
        List<Map.Entry<Double, Integer>> list = new ArrayList<Map.Entry<Double, Integer>>(map.entrySet());
        Collections.sort(list, (o1, o2) -> (int) Math.abs(o2.getKey()-o1.getKey()));
//  for (Entry<Double, Integer> e : list) {
//   System.out.println(e.getKey() + "---->" + e.getValue());
//  }
        double res = 0.0;
        for (Entry<Double, Integer> e : list) {
            if (money > 0) {
                int index = e.getValue();
                int lim = limit[index];
                int c = cur[index];
                Double fu = future[index];
                int nums = (int) Math.floor(money / c);
                if (money - nums * c > 0) {
                    money -= nums * c;
                    res += nums * fu;
                } else if (money - nums * c == 0) {
                    money -= nums * c;
                    res += nums * fu;
                    break;
                } else {
                    int n = money / c;
                    res += n * fu;
                    money -= n * c;
                }
            }
        }
        res += money;
        System.out.println((int)res);
    }

}