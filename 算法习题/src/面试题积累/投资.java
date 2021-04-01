package 面试题积累;

import java.util.*;
import java.util.Map.Entry;

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
        //  通过TreeMap，对收益率降序排序， key：收益率， value：对应物品下标
        Map<Double, Integer> map = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < m; i++) {
            map.put(profit[i], i);
        }

        double res = 0.0;
        for(Map.Entry<Double, Integer> e:map.entrySet()){
            if(money>0){
                int index = e.getValue();   //  当前物品下标位置
                int lim = limit[index];     //  限购数量
                int c = cur[index];         //  当前价值
                Double fu = future[index];  //  未来的价值
                int nums = (int) Math.floor(money / c); //  当前money能够买当前物品的最大数量
                //  比较nums和lim的关系，如果限购数量大于nums，则最多只能买nums个当前物品
                if(lim>nums){
                    money -= nums*c;
                    res += nums*fu;
                }else{
                    money -= lim*c;
                    res += lim*fu;
                }
            }
        }
        res += money;
        System.out.println((int)res);
    }

}