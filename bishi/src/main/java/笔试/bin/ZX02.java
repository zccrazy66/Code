package bishi.src.main.java.笔试.bin;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/5.
 */
public class ZX02 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int k=s.nextInt();
        int minboy=Math.max(3,k-m);
        int maxboy=Math.min(k-2,n);
        int sum=0;
      //System.out.println(C(8,2));
        for (int i=minboy;i<=maxboy;i++){
                long k1=C(n,i);
                //System.out.println("n="+n+"i="+i+"k1="+k1);
                long k2=C(m,k-i);
                // System.out.println("k2="+k2);
                sum+=(k1*k2)%1000000007;
                sum=sum%1000000007;

        }
        System.out.println(sum);

    }
//    private static long CNM(int big,int small){
//        long n1 = 1;
//        for (int i = 0; i < small; i++) {
//            n1  *= big;
//            n1=n1%1000000007;
//            big--;
//        }
//        long n2=1;
//        for (int i = 1; i <= small; i++) {
//            n2  *= i;
//            n2=n2%1000000007;
//        }
//        return n1/n2;
//    }
    public static long A(int n, int m) {
        long result = 1;
        // 循环m次,如A(6,2)需要循环2次，6*5
        for (int i = m; i > 0; i--) {
            result *= n;
            result=result%1000000007;
            n--;// 下一次减一
        }
        return result;
    }

    public static long C(int n, int m){
        // 应用组合数的互补率简化计算量
        m = m > (n - m) ? (n - m) : m;
        // 分子的排列数
        long son = A(n, m);
        // 分母的排列数
        long mother = A(m, m);
        return son / mother ;
    }
}
