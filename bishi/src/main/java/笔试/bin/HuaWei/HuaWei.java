package bishi.src.main.java.笔试.bin.HuaWei;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/26.
 */
public class HuaWei {
     static int res=0;
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        String[] strings=str.split(" ");
        String string=strings[0];
        String test=strings[1];
        int len=(int)(test.length()*0.8);
        //System.out.println(help(string,test,8,0,len,0,0));
        for (int i=0;i<string.length();i++){
           // System.out.println(i);
            if (help(string,test,i,0,len,0,0)){
                //System.out.println(res);
                System.out.print(string.substring(0,i));
                for (int j=0;j<res-i;j++){
                        System.out.print("*");
                }
                System.out.println(string.substring(res,string.length()));
                break;
            }
        }
        //System.out.println(help("abcdefgBCDEFG0123456789","ACEF",8,0,3,0,0));

    }

    public static boolean help(String string,String test,int index,int i,int len,int match,int x){
                if (match>=len){
                    res=index;
                    return true;
                }
                if (i>test.length()-len+match&&i==test.length()){
                   // System.out.println("1");
                    return false;
                }
                if (string.charAt(index)==test.charAt(i)){
                    //System.out.println("2");
                    return help(string,test,index+1,i+1,len,match+1,1);
                }
                if (string.charAt(index)!=test.charAt(i)){
                    if (x==0){
                        //System.out.println("3");
                       return help(string,test,index,i+1,len,match,0);
                    }
                    else {
                        //System.out.println("4");
                        return help(string,test,index+1,i,len,match,0)||help(string,test,index,i+1,len,match,0);
                    }
                }
                return false;
    }
}
