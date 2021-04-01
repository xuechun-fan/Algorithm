给一个二叉查找树（Binary Search Tree）的前序遍历结果数组，打印出所有的叶子节点。

**解析：**

这道题类似于二叉树的序列化与反序列化。个人感觉本题的精髓在于二叉搜索树的特点、前序序列的特点。

- 二叉搜索树的特点：左 < 根 < 右
- 前序序列特点：遍历顺序为  根 --》左 -- 》右

有上述两个特点，我们首先可以判断序列的第一个元素就是二叉搜索树的根节点值，那么在一个数组中，从下标1开始，后面所有的小于下标0元素的值都是左子树的节点，同理，大于root的值是右子树的节点（连续的）。
这样我们就可以划分子问题，分出来的左子树也是一个序列，右子树也是一个序列，按同样的规则取划分。直到序列中只有一个节点为止，此时该元素一定是叶子节点，因为它后面没有元素，也就意味着以它为根的树的左子树和右子树都为空。

说到这里，递归的截止条件、递归操作都已经确定了，剩下的就是写代码了。

```java
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main{
    public Main(){}
    private static List<Integer> res = null;
    private static void find(int[] nums, int start, int end){
        if(start>end) return;
        if(start==end){
            res.add(nums[start]);
            return;
        }
        int root = nums[start];
        int edge;
        for(edge=start+1; edge<=end; edge++){
            if(nums[edge]>root) break;
        }
        find(nums, start+1, edge-1);
        find(nums, edge, end);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[s.length];
        for(int i=0; i<nums.length; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        find(nums, 0, nums.length-1);
        for(Integer n : res){
            System.out.print(n);
            System.out.print(" ");
        }
    }
}
```

