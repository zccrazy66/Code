package Code.bishi.src.main.java.笔试.bin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *

 * Created by 林松斌的船 on 2020/8/25.
 */
public class Perfect01 {
     static int[] res=new int[6];
    public static void main(String[] args){
        int[][] weight = new int[6][];
        String[] pointsStr = { "V1", "V2", "V3", "V4", "V5","V6"};
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < pointsStr.length; i++) {
            String[] valuesStr = input.nextLine().split(" ");
            int[] values = new int[valuesStr.length];
            for (int j = 0; j < valuesStr.length; j++) {
                values[j] = Integer.parseInt(valuesStr[j]);
            }
            weight[i] = values;
        }
        input.close();

        method(weight, pointsStr);
    }
    public static void method (int[][] weight, String[] pointsStr){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int cur=queue.poll();
            //  System.out.println(cur);
            for (int k=1;k<6;k++){
                if (weight[cur][k]>0){
                    if((res[k]==0||res[k]>res[cur]+weight[cur][k])){
                        res[k]=res[cur]+weight[cur][k];
                       // System.out.println("k="+k+"   "+res[k]);
                        queue.add(k);
                    }
                }
            }
        }
        for (int i=1;i<6;i++){
            if(res[i]==0){
                System.out.println(-1);
            }
            else {
                System.out.println(res[i]);
            }

        }

    }
}
