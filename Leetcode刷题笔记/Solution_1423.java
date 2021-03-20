package LeetCode刷题;

/**
 * 可获得的最大点数
 */
public class Solution_1423 {
    public static int maxScore(int[] cardPoints, int k){
        if(cardPoints.length==0 || k<=0 || k>cardPoints.length){
            return 0;
        }
        int[] arrLeft = new int[k+1];
        int[] arrRight = new int[k+1];
        int len = cardPoints.length;
        for(int i=0; i<k; i++){
            arrLeft[i+1] = arrLeft[i] + cardPoints[i];
        }
        for(int i=k-1, j=len-1; i>=0; i--, j--){
            arrRight[i] = cardPoints[j] + arrRight[i+1];
        }
        int max = arrRight[0] + arrLeft[0];
        for(int i=1; i<=k; i++){
            if(arrLeft[i] + arrRight[i] > max){
                max = arrLeft[i] + arrRight[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,1};
        int score = maxScore(arr, 3);
        System.out.println(score);
    }
}
