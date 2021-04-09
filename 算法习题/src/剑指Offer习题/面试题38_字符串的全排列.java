package 剑指Offer习题;

import java.util.*;


public class 面试题38_字符串的全排列 {
    private List<String> res = new ArrayList<>();
    private  char[] arr;
    public String[] permutation(String s){
        if(s.length()==1) return new String[]{s};
        this.arr = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    private void dfs(int idx){
        if(idx==arr.length-1){
            res.add(new String(arr));
            return;
        }
        Set<Character> dic = new HashSet<>();
        for(int i=idx; i<arr.length; i++){
            if(dic.contains(arr[i])){   //  剪枝
                continue;
            }
            dic.add(arr[i]);
            swap(i, idx);
            dfs(idx+1);
            swap(i, idx);
        }
    }

    private void swap(int a, int b){
        char t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }


    public static void main(String[] args) {
        String[] res = new 面试题38_字符串的全排列().permutation("aba");
        for (String s:
             res) {
            System.out.print(s + "\t");
        }
    }
}
