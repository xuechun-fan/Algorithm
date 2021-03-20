/**
 * Description：
 */
public class 面试题16_数值的整数次方 {
    private static boolean isInvalid = false;

    //  使用递归来解决
    public static double Power(double base, double exponent){
        isInvalid = false;
        if(base==0.0 && exponent<0){
            isInvalid = true;
            return 0.0;
        }
        int absExponent = (exponent<0)?(-(int)exponent):((int)exponent);
        double result = PowerWithAbsExponent(base, absExponent);
        if(exponent<1){
            result = 1/result;
        }
        return result;
    }

    public static double PowerWithAbsExponent(double base, int absExponent){
        if(absExponent==0){
            return 1;
        }
        if (absExponent==1){
            return base;
        }
        double result = PowerWithAbsExponent(base, absExponent>>1);
        result = result*result;
        if((absExponent&0x1)==1){
            result *= base;
        }
        return result;
    }

    //  更简洁的一种快速幂求解法
    public static double myPow(double a, int b){
        if(a==0 && b<0){
            return 0.0;
        }
        double res = 1.0;
        boolean isNeg = (b<0)?true:false;
        long absB = b;
        if(absB<0){
            absB = -absB;
        }
        for(long i=absB;i!=0;i=i>>1){
            if((i&0x1)!=0){
                res *= a;
            }
            a *= a;
        }
        return (isNeg)?1.0/res:res;
    }

    public static void main(String[] args) {
        double res= myPow(2, 3);
        System.out.println(res);
        res= myPow(0, -3);
        System.out.println(res);
        res= myPow(3, -3);
        System.out.println(res);
        System.out.println((1/3.0) * (1/3.0) * (1/3.0));
    }
}
