package 笔试.jungel.tuhu;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr={1,2,3,3,3,4,5,6,7};
        System.out.println(reorder(arr));
    }

    public static int reorder (int[] prices) {

        // write code here
        Arrays.sort(prices);
        int n = prices.length;
        if(n<3) return 0;
        int[] arr=new int[n];

        int start= n/2;

        int j=0;
        for (int i = start; i < n; i++) {

            arr[j]=prices[i];
            j=j+2;
        }

        int k=1;
        for (int i = 0; i < start; i++) {
            arr[k]=prices[i];
            k=k+2;
        }

        int num=0;

        for (int i = 1; i < n-1; i++) {

            if (arr[i]<arr[i-1]&&arr[i]<arr[i+1]){
                num++;
            }
        }

        return num;
    }
}
