package 面试题积累.京东笔试题;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Description：这道题比较简单，就是告诉你四种化学元素C、H、N、O和对应的重量，然后给一个化学式，计算重量
 */
public class 化学表达式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int res = weight(str);
        System.out.println(res);

    }

    private static int weight(String s){
        if(s==null || s.length()==0) return 0;
        HashMap<Character, Integer> dic = new HashMap<>();
        dic.put('C', 12);
        dic.put('H', 1);
        dic.put('O', 16);
        dic.put('N', 14);
        int res = 0;
        int i = 0;
        while(i<s.length()){
            if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                //  说明当前是元素
                int w = dic.get(s.charAt(i));
                i++;
                if(i==s.length()){
                    res += w;
                    break;
                }
                int t = 0;
                while(i<s.length() && s.charAt(i)<='9' && s.charAt(i)>='0'){
                    //  取数字
                    t = t*10 + (s.charAt(i)-'0');
                    i++;
                }
                res += t==0? w : t*w;
            }
        }
        return res;
    }
}
