package Code.bishi.src.main.java.笔试.bin;

import java.util.Arrays;
import java.util.Scanner;

/**
 2 7 11 15
 1 10 4 11
 * Created by 林松斌的船 on 2020/8/25.
 */
public class East {
     static int[][]  res;
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String A=s.nextLine();
        String B=s.nextLine();
        String[] a=A.split(" ");
        String[] b=B.split(" ");
        int[] aint=new int[a.length];
        int[] bint=new int[b.length];
        for (int i=0;i<a.length;i++){
            aint[i]=Integer.valueOf(a[i]);
            bint[i]=Integer.valueOf(b[i]);
        }
        int[] t=new int[a.length];
        for (int i=0;i<a.length;i++){
            t[i]=bint[i];
        }
        Arrays.sort(aint);
        Arrays.sort(bint);
      //  System.out.println(Arrays.toString(t));
        res=new int[2][a.length];
        help(aint,bint);
       // System.out.println(Arrays.toString(res[0]));
      //  System.out.println(Arrays.toString(res[1]));
        int[] result=new int[a.length];
        for (int i=0;i<a.length;i++){
            int cur=t[i];
           // System.out.println("i"+i+"cur"+cur);
            for (int k=0;k<a.length;k++){
                if (res[1][k]==cur){
                    res[1][k]=-1;
                    aint[i]=res[0][k];
                   // System.out.println("k"+k+" "+aint[i]+"i"+i+"cur"+cur);
                }
            }
        }
        for (int i=0;i<a.length;i++){
            System.out.print(aint[i]+" ");
        }
        }
    public static void help(int[] a ,int[] b){
        int win = 0;
        int k=0;
        int i = 0, j = 0, x = a.length - 1, y = b.length - 1;
        while (i <= x){
            if (a[x] > b[y]){
                res[0][k]=a[x];
                res[1][k]=b[y];
                k++;
                x--;
                y--;

                win++;
            } else if (a[i] > b[j]){
                res[0][k]=a[i];
                res[1][k]=b[i];
                k++;
                i++;
                j++;
                win++;
            } else {
                res[0][k]=a[i];
                res[1][k]=b[y];
                k++;
                i++;
                y--;

            }
        }
    }
    }

