package bishi.src.main.java.笔试.bin.TENXUN;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/23.
 */
public class TX04 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] nums=new int[n];
        int[] sort=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=s.nextInt();
            sort[i]=nums[i];
        }
        Arrays.sort(sort);
        int r=sort[sort.length/2];
        int l=sort[sort.length/2-1];
        for (int i=0;i<n;i++){
            if (nums[i]<=l){
                System.out.println(r);
            }
            if (nums[i]>=r){
                System.out.println(l);
            }
        }

    }
}
