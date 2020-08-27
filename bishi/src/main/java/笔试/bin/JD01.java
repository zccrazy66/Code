package Code.bishi.src.main.java.笔试.bin;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/27.
 */
public class JD01 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        n--;
        int k=3;
        int i=0;
        while (n>0){
            n-=k;
            k*=3;
            i++;
        }
        k/=3;
        n+=k;
        //  System.out.println(m);
        int[] nums = {2, 3, 5};
        StringBuffer res=new StringBuffer();
        for (int j=i;j>0;j--){
            int x=(int) Math.pow(3,j-1);
            // System.out.println("x="+x);
            //  System.out.println((m/x)-1);
            res.append(nums[(n/x)]);
            n=n%x;
        }
//        if (m==0){
//            for (int j=0;j<i;j++){
//                res.append('5');
//            }
//        }
//        else {
//
//
//           // System.out.println(k);
//           // ///System.out.println(i);
//            int[] nums = {2, 3, 5};
//            for (int j = i; j > 0; j--) {
//                int x = n / k;
//                n = n % k;
//                k /= 3;
//              //  System.out.println(x);
//                res.append(nums[x - 1]);
//            }
//        }


        System.out.println(res.toString());
    }
}
