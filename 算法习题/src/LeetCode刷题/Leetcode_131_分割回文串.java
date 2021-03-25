package LeetCode刷题;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description:
 */
public class Leetcode_131_分割回文串 {
    List<List<String>> res;
    int len;
    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        if(s==null || s.length()==0) return res;
        this.len = s.length();

        Deque<String> path = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        dfs(arr, 0, path);
        return res;
    }

    private void dfs(char[] arr, int index, Deque<String> path){
        if(index==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index; i<len; i++){
            if(!check(arr, index, i)) continue;
            path.addLast(new String(arr, index, i+1-index));
            dfs(arr, i+1, path);
            path.removeLast();
        }
    }

    private boolean check(char[] arr, int left, int right){
        while(left<right){
            if(arr[left]!=arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode_131_分割回文串 tool = new Leetcode_131_分割回文串();
        String s = "aab";
        List<List<String>> res = tool.partition(s);
        System.out.println(res);
    }
}
