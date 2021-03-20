package LeetCode刷题;

public class Leetcode_670_最大交换 {
    public static int maximumSwap(String num) {
        String s = String.valueOf(num);
        int len = s.length();
        char[] charArray = s.toCharArray();

        // 记录每个数字出现的最后一次出现的下标
        int[] last = new int[10];
        for (int i = 0; i < len; i++) {
            last[charArray[i] - '0'] = i;
        }

        // 从左向右扫描，找到当前位置右边的最大的数字并交换
        for (int i = 0; i < len - 1; i++) {
            // 找最大，所以倒着找
            for (int d = 9; d > charArray[i] - '0'; d--) {
                if (last[d] > i) {
                    swap(charArray, i, last[d]);
                    // 只允许交换一次，因此直接返回
                    return Integer.parseInt(new String(charArray));
                }
            }
        }
        return Integer.valueOf(num);
    }
    private static void swap(char[] arr, int a, int b){
        char ch = arr[a];
        arr[a] = arr[b];
        arr[b] = ch;
    }

    public static void main(String[] args) {
        String num = "012";
        int res = maximumSwap(num);
        System.out.println(res);
    }
}
