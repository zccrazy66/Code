package 笔试.jungel.keda;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        String[] split = s.split(",");

        int[] arr =new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (i!=n-1) {
                System.out.print(arr[i]+",");
            }else {
                System.out.print(arr[i]);
            }
        }
    }
}
