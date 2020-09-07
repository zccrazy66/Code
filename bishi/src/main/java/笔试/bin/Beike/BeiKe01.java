package bishi.src.main.java.笔试.bin.Beike;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/7.
 */
public class BeiKe01 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        for (int i=0;i<n;i++){
            String[] strings=new String[4];
            strings[0]=s.next();
            strings[1]=s.next();
            strings[2]=s.next();
            strings[3]=s.next();
            System.out.println(help(strings));
           // System.out.println(Arrays.toString(strings));
        }
    }
    public static String help(String[] strings){
        String left=strings[0];
        String right=strings[1];
        String left1=strings[2];
        String right1=strings[3];
        int l=0;
        int r=0;
        if (compare(left,left1)){
            l++;
        }
        if (compare(left,right1)){
            l++;
        }
        if (compare(right,left1)){
            r++;
        }
        if (compare(right,right1)){
            r++;
        }
        if (l>r){
            return "left";
        }
        if (l<r){
            return "right";
        }
        else return "same";
    }
    public static boolean compare(String a,String b){
        if(a.equals("S")){
                if (b.equals("B")||b.equals("S")){
                    return false;
                }
                if(b.equals("J")){
                    return true;
                }
        }
        if(a.equals("J")){
            if (b.equals("S")||b.equals("J")){
                return false;
            }
            if(b.equals("B")){
                return true;
            }
        }
        if(a.equals("B")){
            if (b.equals("B")||b.equals("J")){
                return false;
            }
            if(b.equals("S")){
                return true;
            }
        }
        return false;
    }
}
