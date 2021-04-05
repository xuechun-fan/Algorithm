package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题60_n个骰子的点数 {
    public static double[] dicesProbability(int n){
        double a = 1.0/6;
        double[] res = new double[]{a, a, a, a, a, a};
        for(int x=2; x<=n; x++){
            double[] tmp = new double[x*5+1];
            for(int i=0; i<res.length; i++){
                for(int j=i; j<i+6; j++){
                    tmp[j] += res[i]*(1.0/6);
                }
            }
            res = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        double[] res = dicesProbability(4);
        for(double num : res){
            System.out.print(num + "\t");
        }
    }
}
