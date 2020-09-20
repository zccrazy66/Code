package 笔试.jungel.shunfeng;

import com.alibaba.fastjson.JSON;

import java.util.Scanner;

public class Second {

    static int size;
    static int k;
    static int[] arr;
    static int[] arrSum;
    static int[] kCar;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        k = scanner.nextInt();

        arr = new int[n];
        arrSum = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i]=scanner.nextInt();
            sum =sum + arr[i];
            arrSum[i] = sum;
        }

        size = n;

        kCar=new int[k];
        int maxValue = dfs(-1, k);
        System.out.println(maxValue);
        System.out.println(JSON.toJSONString(kCar));
    }


//    /**
//     *
//     * @param used 已经运了的货物
//     * @param save 还剩save辆车
//     * @return
//     */
//    private static int dfs(int used,int save) {
//
//        if (save==1) {
//            return (arrSum[size-1]-arrSum[used])*(arrSum[size-1]-arrSum[used]);
//        }
//
//        int max = 0;
//        for (int i = used+1; i < size-save; i++) {
//            int cur;
//            if (used==-1) {
//                cur = (arrSum[i])*(arrSum[i])+dfs(i,save-1);
//            }else {
//                cur = (arrSum[i]-arrSum[used])*(arrSum[i]-arrSum[used])+dfs(i,save-1);
//            }
//
//           max = Math.max(cur,max);
//        }
//
//        return max;
//    }

    /**
     *
     * @param used 已经运了的货物
     * @param save 还剩save辆车
     * @return
     */
    private static int dfs(int used,int save) {

        if (save==1) {
            return (arrSum[size-1]-arrSum[used])*(arrSum[size-1]-arrSum[used]);
        }

        int max = 0;
        for (int i = used+1; i < size-save; i++) {
            int cur;
            int order;
            if (used==-1) {
                order = (arrSum[i])*(arrSum[i]);

            }else {
                order = (arrSum[i]-arrSum[used])*(arrSum[i]-arrSum[used]);
            }
            cur = order+dfs(i,save-1);
            if (cur>max) {
                max = cur;
                kCar[k-save] = order;
            }
        }

        return max;
    }
}
