import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/10/16 19:50
 */
public class ebay01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] res = new int[n];
        for (int k = 0; k < m; k++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int target = scanner.nextInt();
            for (int i = start -1; i < end; i++) {
                res[i] += target;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}