package 笔试.jungel.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

public class First {

    public static void main(String[] args){

        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        String[] split=str.split(" ");
        System.out.println(Arrays.toString(split));
        for (int i=0;i<split.length;i++){
            System.out.println(help(split[i]));
        }
    }

    public static int help(String s){
        if (s.length()<8||s.length()>120)return 1;
        boolean hasInt=false;
        boolean hasBig=false;
        boolean hasSmall=false;
        boolean hasFuHao=false;
        for (int i=0;i<s.length();i++){
            if (hasBig&&hasFuHao&&hasInt&&hasSmall)break;
            if (s.charAt(i)<='9'&&s.charAt(i)>='0'){
                hasInt=true;
            }
            if (s.charAt(i)<='z'&&s.charAt(i)>='a'){
                hasSmall=true;
            }
            if (s.charAt(i)<='Z'&&s.charAt(i)>='A'){
                hasBig=true;
            }
            else {
                hasFuHao=true;
            }
        }
        if (hasBig&&hasFuHao&&hasInt&&hasSmall)return 0;
        else return 2;
    }

}
