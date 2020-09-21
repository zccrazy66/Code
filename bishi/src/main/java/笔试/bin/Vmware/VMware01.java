package bishi.src.main.java.笔试.bin.Vmware;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/21.
 */
public class VMware01 {
     static double curx;
     static double cury;
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        double n=s.nextDouble();
        int r=s.nextInt();
        double m=s.nextDouble();
        double x=0;
        double y=0;
        List<double[]> list=new ArrayList<>();
        while (r>0){
           help(m,n);
           double[] doubles={curx,cury};
          // System.out.println(curx+"   "+cury);
           list.add(doubles);
           r--;
        }
        for (int i=0;i<list.size();i++){
            double[] cur=list.get(i);
//            double x1=((int)(cur[0]*100));
//            double y1=((int)(cur[1]*100));
            DecimalFormat df=new DecimalFormat("#0.00");
           String x1=df.format(cur[0]);
           String y1=df.format(cur[1]);
            System.out.print(x1+" ");
            System.out.println(y1);
        }
    }
    public static void help(double len,double n){
        //System.out.println("len="+len+"curx="+curx+"cury="+cury);
        if (cury==0&&curx<n){
            if (curx+len<=n){
                curx=curx+len;
                return;
            }
            else {
                len-=n-curx;
                curx=n;
                help(len,n);
            }
        }
        else if (curx==n&&cury<n){
            if (cury+len<=n){
                cury=cury+len;
                //System.out.println("qwe");
                return;
            }
            else {
                len-=n-cury;
                cury=n;
                help(len,n);
            }
        }
        else if (cury==n&&curx>0){
            if (curx-len>=0){
                curx=curx-len;
                return;
            }
            else {
                len-=curx;
                curx=0;
                help(len,n);
            }
        }
        else if (curx==0&&cury>0){
            if (cury-len>=0){
                cury=cury-len;
                return;
            }
            else {
                len-=cury;
                cury=0;
                help(len,n);
            }
        }
    }
}
