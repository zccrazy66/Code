package Code.bishi.src.main.java.笔试.bin;

/**
 * Created by 林松斌的船 on 2020/8/31.
 */
public class FiveEight03 {
    public static void main(String[] args){
        System.out.println(translateNum(8760));
    }
    public static int translateNum (int num) {
        // write code here
        String str=String.valueOf(num);
       int n=str.length();
       int[] dp=new int[n+1];
       dp[0]=1;
       dp[1]=1;
       for (int i=2;i<=n;i++){
           if (((str.charAt(i-2)-'0')*10+(str.charAt(i-1)-'0'))<=25){
               dp[i]=dp[i-1]+dp[i-2];
           }
           else dp[i]=dp[i-1];
       }
       return dp[n];


    }
}
