package LeetCode刷题;

/**
 * 罗马数字转整数
 */
public class LeetCode_013_罗马数字转整数 {
    public static Integer romanToInt(String s){
        if(s==null || s.length()==0){
            return 0;
        }
        Integer sum = 0;
        Integer pre = getValue(s.charAt(0));
        for (int i = 1; i <s.length() ; i++) {
            Integer cur = getValue(s.charAt(i));
            if(pre<cur){
                sum -= pre;
            }else{
                sum += pre;
            }
            pre = cur;
        }
        sum += pre;
        return sum;
    }

    private static Integer getValue(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        String roman = "MLXI";
        Integer integer = romanToInt(roman);
        System.out.println(integer);
    }
}
