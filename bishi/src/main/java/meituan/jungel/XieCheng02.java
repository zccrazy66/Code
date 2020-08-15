package meituan.jungel;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class XieCheng02 {

    static int[] arr = new int[2];
    static HashSet<Integer> set = new HashSet<>();
    static HashMap<String, Integer> map = new HashMap<>();
    static int[] divingBoard(int a,int b,int k) {



        arr[0]=a;
        arr[1]=b;
        helper(0,k,0,0);
        int[] result = new int[set.size()];
        PriorityQueue<Integer> queue = new PriorityQueue<>(set);

        int i =0;
        while (queue.size()!=0) {
            result[i] = queue.remove();
            i++;
        }

        return result;
    }

    private static void helper(int res, int k, int p, int q) {

        if (map.containsKey(p+","+q)) return;
        if (k==0) {
            set.add(res);
            return;

        }

        for (int i = 0; i < 2; i++) {

            if (i==0) {

                helper(res+arr[i],k-1,p+1,q);
                map.put((p+1)+","+q,1);

            }else {

                helper(res+arr[i],k-1,p,q+1);
                map.put((p)+","+(q+1),1);
            }

        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(JSON.toJSONString(divingBoard(a,b,k)));


    }


}
