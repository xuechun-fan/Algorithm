/**
 * Description：排序类算法
 */
public class 排序类算法 {
    //  快速排序
    public static void quickSort(int[] arr, int start, int end){
        if(arr==null || arr.length==0 || start>=end){
            return;
        }
        int base = arr[start];
        int i = start, j = end;
        while(i<j){
            while (i<j && arr[j]>=base){
                j--;
            }
            while (i<j && arr[i]<=base){
                i++;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[start] = arr[j];
        arr[j] = base;
        quickSort(arr, start, j-1);
        quickSort(arr, j+1, end);
    }



    //  对几万名员工的年龄排序
    public static void sortAges(int[] ages){
        if(ages==null || ages.length==0){
            return;
        }
        final int oldestAge = 99;
        int[] timesOfAge = new int[oldestAge+1];
        for(int i=0; i<ages.length; i++){
            if(ages[i]>oldestAge || ages[i]<0){
                throw new RuntimeException("年龄数据有误！");
            }
            timesOfAge[ages[i]]++;
        }
        int index = 0;
        for(int i=0; i<=oldestAge; i++){
            for(int j=0; j<timesOfAge[i]; j++){
                ages[index++] = i;
            }
        }
    }

    //  快排测试函数
    public static void testQuickSort(){
        int[] arr = new int[]{1, 4, 2, 7, 3, 18, 23, 11, 16};
        quickSort(arr, 0, arr.length-1);
        for (int item:
                arr) {
            System.out.println(item);
        }
    }
    //  年龄排序测试函数
    public static void testSortAges(){
        int[] ages = new int[]{1, 2,3, 12, 1, 2, 3, 5,2 ,4, 3,};
        sortAges(ages);
        System.out.print("[");
        for(int age:ages){
            System.out.print(age + ", ");
        }
        System.out.print("]");
    }

    /*
    ----------------归并排序算法------------------------
    */

    //  Review 归并排序代码
    public static void mergeSort(int[] arr){
        if(arr==null || arr.length==0){
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
    }
    //  这一步将数组分成两部分
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) >> 1;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid+1, right, temp);
            mergeCore(arr, left, mid, right, temp);
        }
    }
    public static void mergeCore(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while(i<=mid && j<=right){
            if(arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
            while(i<=mid){
                temp[t++] = arr[i++];
            }
            while(j<=right){
                temp[t++] = arr[j++];
            }
            t = 0;
            while(left<=right){
                arr[left++] = temp[t++];
            }
        }
    }

    public static void testMergeSort(){
        int[] arr = {2, 1, 0, 3, 10};
        for(int n : arr){
            System.out.print(n + "\t");
        }
        System.out.println();
        mergeSort(arr);
        for(int n : arr){
            System.out.print(n + "\t");
        }
    }

    public static void main(String[] args) {
//        testQuickSort();
        testMergeSort();
    }

}
