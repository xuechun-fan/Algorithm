package LeetCode刷题;

/**
 * Description:
 */
public class Leetcode_331_验证二叉树的前序序列化 {
    String[] arr;
    public boolean isValidSerialization(String preorder) {
        if("#".equals(preorder)) return true;
        this.arr = preorder.split(",");
        //  前序序列：根-> 左 -> 右
        int slot = "#".equals(arr[0]) ? 0 : 2;
        int i;
        for(i=1; i<arr.length && slot!=0; i++){
            slot = "#".equals(arr[i]) ? slot-1 : slot+1;
        }
        return i==arr.length && slot==0;
    }

    public static void main(String[] args) {
        Leetcode_331_验证二叉树的前序序列化 tool = new Leetcode_331_验证二叉树的前序序列化();
        boolean res;
        res = tool.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
        System.out.println(res);
        res = tool.isValidSerialization("#,#,#");
        System.out.println(res);
        res = tool.isValidSerialization("9,#,#,1");
        System.out.println(res);
    }

}
