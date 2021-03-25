package 牛客刷题;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 设计getMin功能的栈 {
    /**
     * return a array which include all ans for op3
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    public static int[] getMinStack (int[][] op) {
        // write code here
        if(op==null || op.length==0){
            return null;
        }
        int len = op.length;
        Stack<Integer> stackData = new Stack<>();
        Stack<Integer> stackMin = new Stack<>();
        List<Integer> res = new ArrayList<>();
        for(int[] arr : op){
            switch (arr[0]){
                case 1:{
                    if(stackMin.isEmpty()){
                        stackMin.push(arr[1]);
                    }else{
                        stackMin.push(arr[1]<stackMin.peek() ? arr[1] : stackMin.peek());
                    }
                    stackData.push(arr[1]);
                    break;
                }
                case 2:{
                    stackMin.pop();
                    stackData.pop();
                    break;
                }
                case 3:{
                    res.add(stackMin.peek());
                    break;
                }
            }
        }
        int[] ans = new int[res.size()];
        int i = 0;
        for(Integer integer : res){
            ans[i++] = integer;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] op = new int[6][];
        op[0] = new int[]{1,3};
        op[1] = new int[]{1,2};
        op[2] = new int[]{1,1};
        op[3] = new int[]{3};
        op[4] = new int[]{2};
        op[5] = new int[]{3};
        int[] res = getMinStack(op);
        System.out.println();
    }

}
