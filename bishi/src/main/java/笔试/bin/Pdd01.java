package Code.bishi.src.main.java.笔试.bin;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/2.
 */
public class Pdd01 {


        public static void main(String[] args) {
            Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            int m=s.nextInt();
            int[] weight = new int[n]; //物品重量
            int[] val =new int[n]; //物品价值
           for (int i=0;i<n;i++){
               weight[i]=s.nextInt();
               val[i]=s.nextInt();
           }


            int[] f = new int[m+1];
            for(int i=0;i<f.length;i++){ 	//不必装满则初始化为0
                f[i] = 0;
            }
            for(int i=0;i<n;i++){
                for(int j=f.length-1;j>=weight[i];j--){
                    f[j] = Math.max(f[j], f[j-weight[i]]+val[i]);
                }
            }
            System.out.println(f[f.length-1]);
        }
}
