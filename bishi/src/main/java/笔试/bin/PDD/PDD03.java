package Code.bishi.src.main.java.笔试.bin.PDD;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/1.
 */
public class PDD03 {

        static int []dp=new int[1000005];
        static int []c=new int[500005];
        static int []v=new int[500005];

        public static void main(String[] args)
        {
            Scanner S=new Scanner(System.in);
            int n=S.nextInt(),m=S.nextInt(),k=20005;
            for(int i=0;i<k;i++) dp[i]=-10000000;
            for(int i=1;i<=n;i++)
            {
                int w=S.nextInt(),v=S.nextInt();
                if(w<0)
                {
                    for(int j=0;j<k+m+w;j++)
                        dp[j]=Math.max(dp[j],dp[j-w]+v);
                }
                else
                {
                    for(int j=k+m;j>=w;j--)
                        dp[j]=Math.max(dp[j],dp[j-w]+v);
                }
            }
            int ans=0;
            for(int i=k-5;i<=k+m;i++) ans=Math.max(ans,dp[i]);
            System.out.println(ans);
        }
    }


