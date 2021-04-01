package LeetCode刷题;

import java.util.ArrayList;
import java.util.List;

class Leetcode_022_括号生成{
	public List<String> generateParenthesis(int n){
		List<String> res = new ArrayList<>();
		dfs(new char[2*n], 0, res);
		return res;
	}
	/**暴力递归法，将所有的可能都生成然后判断是否有效，此版本还可以剪枝优化
	*/
	private void dfs(char[] arr, int pos, List<String> res){
		if(pos==arr.length){
			if(isValid(arr)){
				res.add(new String(arr));
				return;
			}
		}
		arr[pos] = '(';
		dfs(arr, pos+1, res);
		arr[pos] = ')';
		dfs(arr, pos+1, res);
	}
	
	private boolean isValid(char[] arr){
		int balance = 0;
		for(char c:arr){
			if(c=='(') balance++;
			else balance--;
			if(balance<0) return false;
		}
		return balance==0;
	}
}
