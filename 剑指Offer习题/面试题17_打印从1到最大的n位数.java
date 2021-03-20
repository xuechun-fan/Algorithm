import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 */
public class 面试题17_打印从1到最大的n位数 {

    //  使用StringBuilder来模拟加法（此方法代码较长）
    public static void printNums(int n){
        String[] str = new String[]{"0", "1", "2", "3", "4",
                                    "5", "6", "7", "8", "9"};
        StringBuilder temp = new StringBuilder("1");
        StringBuilder maxValue = new StringBuilder("1");
        for (int i = 0; i < n; i++) {
            maxValue.append("0");
        }
        while(!maxValue.toString().equals(temp.toString())){    //  如果没有到最大数，就一直循环
            System.out.println(temp.toString());
            increment(temp);
        }
    }

    public static void increment(StringBuilder sb){
        int len = sb.length();
        int res = 0;
        //  对sb进行模拟加法处理，从个位开始，向高位转移
        while(len>=1){
            //  令sb的最后一位加1，判断是否大于10，模拟手动加法
            res = Integer.parseInt(sb.substring(len-1, len))+1;
            if(res>=10){
                //  如果当前只有一位数9，则将当前位置0，并在前面插入1，结束while循环
                if (len == 1) {
                    sb.replace(0, 1, "0");
                    sb.insert(0, "1");
                    break;
                }else {
                    //  如果当前位是9，且前面还有数字，则len=len-1，继续做同样的处理
                    sb.replace(len - 1, len, "0");
                    len--;
                }
            }else{
                //  如果当前位不是9，则将当前位置为res，结束while循环。
                sb.replace(len-1, len, String.valueOf(res));
                break;
            }
        }
    }

    //  把问题转换成数字排列的解法， 递归让代码更简洁
    //  优化记录：原始解法是用char数组来进行存储，因为char需要4个字节，浪费空间，所以现在使用byte类型数组存储只需要1个字节空间，节约资源
    /*
    byte     1字节
    short    2字节
    int      4字节
    long     8字节
    char     2字节（C语言中是1字节）可以存储一个汉字
    float    4字节
    double   8字节
    */
    public static void printToMax(int n){
        if(n<=0){
            return;
        }
        byte[] numbers = new byte[n];
        for (byte i = 0; i < 10; i++) {
            numbers[0] = i;
            printToMaxRecursively(numbers, n, 0);
        }
    }
    public static void printToMaxRecursively(byte[] numbers, int length, int index){
        if(index == length-1){
            printNumber(numbers);
            return;
        }
        for (byte i = 0; i < 10; i++) {
            numbers[index+1] = i;
            printToMaxRecursively(numbers, length, index+1);
        }
    }

    //  打印函数，如果数组中数字以0开始，则选择跳过不打印，否则正常打印
    public static void printNumber(byte[] numbers){
        boolean isStartWith0 = true;
        for (int i = 0; i < numbers.length; i++) {
            if(isStartWith0 && numbers[i]!=0){
                isStartWith0 = false;
            }
            if(!isStartWith0){
                System.out.print(numbers[i]);
            }
        }
        System.out.println();
    }


    //  引申出一个全排列问题，打印['a', 'b', 'c', 'd']数组元素的全排列
    public static void permutation(char[] arr){
        if(arr==null || arr.length==0){
            return;
        }
        boolean[] visited = new boolean[arr.length];
        StringBuilder sb = new StringBuilder();
        permutationCore(arr, sb, visited);
    }

    private static int count = 0;       //  排列组合计数
    public static void permutationCore(char[] arr, StringBuilder sb, boolean[] visited){
        if(sb.length()== arr.length){
            System.out.println(++count + " : " + sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                sb.append(arr[i]);
                permutationCore(arr, sb, visited);
                visited[i] = false;
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }


    public static void main(String[] args) {

        //  测试递归打印从1到最大的n位数
        printToMax(5);
        //  测试全排列问题
//        char[] arr = new char[]{'a', 'b', 'c', 'd'};
//        permutation(arr);
    }
}
