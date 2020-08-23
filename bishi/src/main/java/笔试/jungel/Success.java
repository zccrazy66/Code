import java.util.Scanner;


public class Main {
    static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        res = helper(arr,0, n-1, 0);
        System.out.println(res);
    }
    public static int helper(int[] arr, int l, int r, int h) {
        if (l > r) return 0;
        int minn = Integer.MAX_VALUE, ind = -1;
        int sum = 0;
        for (int i = l; i <= r; i++) {
            if (arr[i] < minn) {
                minn = arr[i];
                ind = i;
            }
            if (arr[i] > h)  sum++;
        }
        int num = minn - h;
        int next_h = minn;
        int res_l = helper(arr, l, ind-1, next_h);
        int res_r = helper(arr, ind+1, r, next_h);
        int res = Math.min(sum, res_l+res_r+num);
        return res;
    }
}
