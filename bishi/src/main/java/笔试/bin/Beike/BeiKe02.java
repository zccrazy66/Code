package bishi.src.main.java.笔试.bin.Beike;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/7.
 */
public class BeiKe02 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        String tar=s.next();
        //System.out.println(tar);
        int t=help(tar);
        int res=0;
       // System.out.println(t);
       // System.out.println(help("ababababc"));
        res=(t+1)/2+1+(n-(t+1));
        //System.out.println(tar);
        System.out.println(res);

    }
    public static int help(String s){
        int res=0;
        int x=(s.length()/2)*2-1;
        for (int i=x;i>0;i-=2){
               if (s.substring(0,i/2+1).equals(s.substring(i/2+1,i+1))){
                   res=i;
                   break;
               }
        }
            return res;
    }
}
