/**
 * Description:
 */
public class 面试题5_替换空格 {
    public static void main(String[] args) {
        char[] s = new char[20];
        s[0] = 'W';
        s[1] = 'e';
        s[2] = ' ';
        s[3] = 'a';
        s[4] = 'r';
        s[5] = 'e';
        s[6] = ' ';
        s[7] = 'h';
        s[8] = 'a';
        s[9] = 'p';
        s[10] = 'p';
        s[11] = 'y';
        s[12] = '.';
        System.out.println(String.valueOf(s));
        Test05.test(s);
        System.out.println(String.valueOf(s));
    }
}

class Test05{
    public static void test(char[] s){
        if(s==null || s.length==0){
            return;
        }
        //  统计空格数目
        int[] counts = countBlank(s);
        int first = counts[0], count = counts[1], size = counts[2];   //   first是第一个空格的下标，若没有空格，则为s.length-1
        int tail = size-1;
        int end = size + count*(3-1) - 1;
        while(end>first){
            if(s[tail]==' '){
                tail--;
                s[end--] = '0';
                s[end--] = '2';
                s[end--] = '%';
            }else {
                s[end--] = s[tail--];
            }
        }
    }

    public static int[] countBlank(char[] s){
        int first=s.length-1, count = 0;
        int[] res = new int[3];
        int i = 0;
        while(s[i]!='\0'){
            if(s[i]==' '){
                count++;
                if(count==1){
                   first = i;
                }
            }
            i++;
        }
        res[0] = first;
        res[1] = count;
        res[2] = i+1;
        return res;
    }
}
