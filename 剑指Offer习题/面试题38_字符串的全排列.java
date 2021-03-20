import java.util.*;

public class 面试题38_字符串的全排列 {
    static List<String> res = new LinkedList<>();
    static char[] c;

    public static String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private static void dfs(int x){
        if(x==c.length-1){
            res.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i=x; i<c.length; i++){
            if(set.contains(c[i])) continue;
            set.add(c[i]);
            if(i!=x) swap(i, x);
            dfs(x+1);
            if(i!=x) swap(x, i);
        }
    }

    private static void swap(int a, int b){
        char ch = c[a];
        c[a] = c[b];
        c[b] = ch;
    }

    public static void main(String[] args) {
        String[] res = permutation("abc");
        for (String s:
             res) {
            System.out.println(s);
        }
    }
}
