package 字节跳动笔试编程题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description：
 *  题目：
 *      作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。
 *      为了使手串的色彩看起来不那么单调，金主要求，手串上的任意一种颜色（不包含无色），在任意连续的m个串珠
 *      里至多出现一次（注意这里手串是一个环形）。手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，
 *      每个串珠用所包含的颜色分别有哪些。请你判断该手串上有多少种颜色不符合要求。即询问有多少种颜色在任意
 *      连续m个串珠中出现了至少两次。
 *
 *      输入：
 *      第一行输入n，m，c三个数，用空格隔开。(1<=n<=10000,1<=m<=1000,1<=c<=501<=n<=10000,1<=m<=1000,1<=c<=50)
 *      接下来n行每行的第一个数numi(0<=numi<=c)numi(0<=numi<=c)表示第i颗珠子有多少种颜色。接下来依次读入numinumi个数字，
 *      每个数字x表示第i颗柱子上包含第x种颜色(1<=x<=c1<=x<=c)
 *
 *      输出：
 *      一个非负整数，表示该手链上有多少种颜色不符需求。
 *
 *      样例输入：
 *      5 2 3
 *      3 1 2 3
 *      0
 *      2 2 3
 *      1 2
 *      1 3
 *      样例输出：
 *      2
 */
public class 手串 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    // n个珠子
        int m = sc.nextInt();    // 至少连续m个不重复
        int c = sc.nextInt();    // c中颜色
        List<List<Integer>> data = new ArrayList<>();
        //  按颜色分类存储珠子序号
        for(int i=0; i<c; i++) data.add(new ArrayList<>());
        int len;
        for(int i=0; i<n; i++){
            //  i : 珠子序号
            len = sc.nextInt();
            for(int j=0; j<len; j++){
                int color = sc.nextInt();
                data.get(color-1).add(i);
            }
        }

        //  数据读取完毕，开始检查不合规的珠子
        //  按颜色检查，即按行遍历data
        int cnt = 0;
        for(List<Integer> color : data){
            int size = color.size();
            //  先判断首尾珠子
            if(size<=1) break;
            if(n-color.get(size-1) + color.get(0) + 1 <= m){
                cnt++;
                continue;
            }
            //  判断中间的珠子
            for(int i=1; i<size; i++){
                if(color.get(i)-color.get(i-1)<m){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
