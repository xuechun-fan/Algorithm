package 牛客刷题;

import java.util.ArrayList;

public class 找出最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = input.length;
        if(input==null || len==0 || k>len || k<=0){
            return res;
        }
        int[] index = partition(input, 0, len-1);
        boolean find = false;
        while(!find){
            if(index[0]==k-1){
                find = true;
            }else if(index[0]>k-1){
                index = partition(input, index[1], index[0]-1);
            }else{
                index = partition(input, index[0]+1, index[2]);
            }
        }
        quickSort(input, 0, index[0]);
        for(int i=0; i<=index[0]; i++){
            res.add(input[i]);
        }
        return res;
    }
    private int[] partition(int[] a, int start, int end){
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
            while(right>start && a[right]>=base){
                right--;
            }
            while(left<end && a[left]<=base){
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
    private void quickSort(int[] a, int l, int r){
        if(l>=r){
            return;
        }
        int[] index = partition(a, l, r);
        quickSort(a, index[1], index[0]-1);
        quickSort(a, index[0]+1, index[2]);
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        找出最小的K个数 tool = new 找出最小的K个数();
        ArrayList<Integer> res = tool.GetLeastNumbers_Solution(arr, 4);
        System.out.println();
    }
}
