package 牛客刷题;

import java.util.ArrayList;
import java.util.Arrays;

public class 寻找弟K大个数 {
    public static int findKth(int[] a, int n, int K) {
        // write code here
        if(a==null || a.length==0){
            return -1;
        }
        int[] index = quickSort(a, 0, n-1);     //  index[3] : 第一个数为中间数的下标， 第二、三个数为上次分组的start和end
        boolean find = false;
        while(!find){
            if(index[0]==K-1){
                find = true;
            }else if(index[0]>K-1){
                index = quickSort(a, index[1], index[0]-1);
            }else{
                index = quickSort(a, index[0]+1, index[2]);
            }
        }
        return a[index[0]];
    }
    private static int[] quickSort(int[] a, int start, int end){
        int[] res = new int[3];
        res[1] = start;
        res[2] = end;
        if(start>=end){
            res[0] = end;
            return res;
        }
        int base = a[start];
        int left = start, right = end;
        while(left<right){
            while(right>start && a[right]<=base){
                right--;
            }
            while(left<end && a[left]>=base){
                left++;
            }
            if(left<right){
                int t = a[left];
                a[left] = a[right];
                a[right] = t;
            }
        }
        a[start] = a[right];
        a[right] = base;
        res[0] = right;
        return res;
    }

    public static void main(String[] args) {
        int[] a = {10, 12, 3, 2, 6, 1, 4, 9, 5, 7, 11, 8, 13, -1, -4, -8};
        int n = 16;
        int K = 9;
        int res = findKth(a, n, n);
        System.out.println(res);
    }
}
