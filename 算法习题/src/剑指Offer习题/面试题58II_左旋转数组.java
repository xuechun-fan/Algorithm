package 剑指Offer习题;

/**
 * Description：
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class 面试题58II_左旋转数组 {
    //  这道题我修改了下题目定义，但是核心思想是不变的
    //  我把输入数据改成了字符数组
    public static void reverseLeftWords(char[] arr, int n){
        if(n==0 || arr==null || arr.length==0) return;
        swap(arr, 0, n-1);
        swap(arr, n, arr.length-1);
        swap(arr, 0, arr.length-1);
    }

    private static void swap(char[] arr, int i, int j){
        while(i<j){
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] arr = "abcdefg".toCharArray();
        reverseLeftWords(arr, 3);
        for(char ch : arr){
            System.out.print(ch + "\t");
        }
    }
}
