package main.java.笔试.tx.百度;

import java.util.Scanner;

/**
 * @author xin Tan
 * @create 2020-09-03 20:34
 */
public class 第一题 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int t = -1;
            int k;
            int sum = 0;
            int sum1 = 0;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sum+=a[i];
                if(a[i] == 0){
                    sum1++;
                }
                if(sum%9==0){
                    t=sum;
                }
            }
            if(t>0&&sum1>0){
                k=t/5;
                for (int i = 0; i < k; i++) {
                    System.out.print("5");
                }
                for (int i = 0; i < sum1; i++) {
                    System.out.print("0");
                }
                System.out.println();
            }else if(sum1>0){
                System.out.println("0");
            }
            else System.out.println("-1");
        }


    }
