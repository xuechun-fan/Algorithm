package 面试题积累.拼多多笔试题;

import java.util.Scanner;

/**
 * Description：
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long cal = 1;
        int res = process(n, m);
        System.out.println(res);
    }
    public static int process(int n, int m){
        long cal = 1;
        int res = 0;
        while(n>0){
            int t = n--;
            while(t%m==0){
                res ++;
                t /= m;
            }
            cal *= t;
            while(cal%m==0){
                res++;
                cal /= m;
            }
        }
        return res;
    }
}
