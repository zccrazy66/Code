package Code.bishi.src.main.java.笔试.bin;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/25.
 */
public class Perfect03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int knapsackCapacity = Integer.parseInt(input.nextLine().trim());

        String[] volumesStr = input.nextLine().split(" ");
        int[] volumes = new int[volumesStr.length];
        for (int i = 0; i < volumesStr.length; i++) {
            volumes[i] = Integer.parseInt(volumesStr[i].trim());
        }

        String[] valuesStr = input.nextLine().split(" ");
        int[] values = new int[valuesStr.length];
        for (int i = 0; i < valuesStr.length; i++) {
            values[i] = Integer.parseInt(valuesStr[i].trim());
        }

        if (volumes.length == values.length) {
            System.out.println(method(knapsackCapacity, volumes, values));
        }else {
            System.out.println("道具数量不一致。");
        }
        input.close();
    }
    public static int method(int knapsackCapacity, int[] weight, int[] val){

        int m = knapsackCapacity; //背包容量
        int n = val.length; //物品个数

        int[] f = new int[m+1];
        for(int i=0;i<f.length;i++){ 	//不必装满则初始化为0
            f[i] = 0;
        }
        for(int i=0;i<n;i++){
            for(int j=f.length-1;j>=weight[i];j--){
                f[j] = Math.max(f[j], f[j-weight[i]]+val[i]);
            }
        }
        for(int i=0;i<f.length;i++){
           // System.out.print(f[i]+" ");
        }
//        System.out.println();
//        System.out.println("最大价值为"+f[f.length-1]);
        return f[f.length-1];
    }
}
