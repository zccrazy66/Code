package Code.bishi.src.main.java.笔试.bin;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/23.
 */
public class TX03 {
       public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int[] nums=new int[t];
        for (int i=0;i<t;i++){
            int max=Integer.MIN_VALUE;
            int n=s.nextInt();
            int x=n-(n/10)*10+1;
            for (int j=0;j<n;j+=(10-x)){
                int k=n-j;
                max=Math.max(max,help(k,j));
                j+=x;
                k=n-j;
                max=Math.max(max,help(k,j));
            }
            System.out.println(max);
        }


    }
    public static int help(int x,int y){
        int sum=0;
        while (x>0){
            sum+=x%10;
            x=x/10;
        }
        while (y>0){
            sum+=y%10;
            y=y/10;
        }
        return sum;
    }
}
