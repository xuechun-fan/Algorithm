package LeetCode刷题;

/**
 * Description：
 */
public class Leetcode_168_Excel列表名称 {
    public static String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while(columnNumber!=0){
            //  这里是A-Z是1-26，正常26进制数是0-25，所以将原数减一，则余数就减一
            columnNumber--;
            res.insert(0, (char)(65+columnNumber%26));
            columnNumber /= 26;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String res = convertToTitle(28);
        System.out.println(res);
    }
}
