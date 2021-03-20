/**
 * Description：
 */

public class  面试题11_旋转数组的最小数字 {
    //  最基础的算法，面试不可用
    public static int minValue(int[] arr){
        if(arr==null || arr.length==0){
            throw new RuntimeException("数组为空！");
        }
        int index = arr.length-1;
        int min = arr[index];
        if(arr[0] >= arr[index]){
            while(arr[index]>arr[index-1] && (index-1)>=0){
                min = arr[--index];
            }
        }
        return min;
    }

    //  使用二分查找来解决
    public static int binarySearchMinValue(int[] arr){
        if(arr==null || arr.length==0){
            throw new RuntimeException("数组为空！");
        }
        int left = 0, right = arr.length-1, midIndex=left;
        while(arr[left]>=arr[right]){
            if(left==right-1){
                midIndex=right;
                break;
            }
            midIndex = (left + right)>>1;
            if(arr[left]==arr[midIndex] && arr[midIndex]==arr[right]){
                return minInOrder(arr, left, right);
            }
            if(arr[midIndex]>=arr[right]){
                left=midIndex;
            }else if(arr[midIndex]<=arr[right]){
                right = midIndex;
            }
        }
        return arr[midIndex];
    }
    //  如果left == mid == right，则进行顺序查找
    public static int minInOrder(int[] arr, int left, int right){
        int res = arr[left];
        for(int i=left+1; i<=right; i++){
            if(res>arr[i]){
                res= arr[i];
            }
        }
        return res;
    }


    public static int leetcodeSolution(int[] arr){
        int i = 0, j = arr.length-1;
        while(i<j){
            int m = (i+j)>>1;
            if(arr[m]>arr[j]){
                i = m+1;
            }else if(arr[m]<arr[j]){
                j = m;
            }else {
                int x = i;
                for (int k = i+1; k <j ; k++) {
                    if(arr[k]<arr[x]){
                        x = k;
                    }
                }
                return arr[x];
            }
        }
        return arr[i];
    }

    //  测试函数
    public static void test(){
        System.out.println(binarySearchMinValue(new int[]{1, 2, 3, 4, 5}));
        System.out.println(binarySearchMinValue(new int[]{6, 2, 3, 4, 5}));
        System.out.println(binarySearchMinValue(new int[]{1, 2, 3, 4, 1}));
        System.out.println(binarySearchMinValue(new int[]{1, 1, 1, 1}));
        System.out.println(binarySearchMinValue(new int[]{1}));
//        System.out.println(binarySearchMinValue(new int[]{}));
    }


    public static void main(String[] args) {
        test();
        System.out.println("***************************************");
        System.out.println(leetcodeSolution(new int[]{1, 2, 3}));
        System.out.println(leetcodeSolution(new int[]{6, 2, 3, 4, 5}));
    }
}
