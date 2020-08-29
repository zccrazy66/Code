package 笔试.jungel.keda;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void fenjie(int n) {
        for (int i=2;i <=n;i++) {
            if (i == n) {
                System.out.print(i);
                return;
            }
            if (n > i && (n % i == 0)) {
                System.out.print(i+"*");
                fenjie(n / i);
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        fenjie(n);
    }

}
