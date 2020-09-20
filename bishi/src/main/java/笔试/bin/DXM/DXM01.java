package bishi.src.main.java.笔试.bin.DXM;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/20.
 */
public class DXM01 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String  str1=s.nextLine();
        String  str2=s.nextLine();
        int[] nums=new int[26];
        for (int i=0;i<str1.length();i++){
            nums[str1.charAt(i)-'A']++;
        }
        int res=0;
        for (int i=0;i<str2.length();i++){
            if (nums[str2.charAt(i)-'A']>0){
                res++;
                nums[str2.charAt(i)-'A']--;
            }
        }
        System.out.println(res);

    }
}
