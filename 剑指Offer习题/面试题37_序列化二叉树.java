import java.util.LinkedList;
import java.util.Queue;

public class 面试题37_序列化二叉树 {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root==null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp!=null){
                sb.append(temp.val+",");
                queue.add(temp.left);
                queue.add(temp.right);
            }else{
                sb.append("null,");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data==null || "[]".equals(data)) return null;
        String[] dat = data.substring(1, data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dat[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(i<dat.length){
            TreeNode node = q.poll();
            if(!"null".equals(dat[i])){
                node.left = new TreeNode(Integer.parseInt(dat[i]));
                q.offer(node.left);
            }
            i++;
            if(!"null".equals(dat[i])){
                node.right = new TreeNode(Integer.parseInt(dat[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root;

//        if("[]".equals(data)) return null;
//        String[] vals = data.substring(1, data.length()-1).split(",");
//        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        int x = 1;
//        while(x<vals.length){
//            TreeNode t = queue.poll();
//            if(!"null".equals(vals[x])){
//                t.left = new TreeNode(Integer.parseInt(vals[x]));
//                queue.add(t.left);
//            }
//            x++;
//            if(!"null".equals(vals[x])){
//                t.right = new TreeNode(Integer.parseInt(vals[x]));
//                queue.add(t.right);
//            }
//            x++;
//        }
//        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(5)));
        String res = serialize(root);
        System.out.println(res);

        System.out.println("--------------------------------");
        TreeNode newRoot = deserialize("[1,2,3,null,null,4,5]");
        TreeTool.levelPrint(newRoot);
    }
}














