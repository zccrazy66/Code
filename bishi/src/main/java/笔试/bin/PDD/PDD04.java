package Code.bishi.src.main.java.笔试.bin.PDD;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/1.
 */
public class PDD04 {

        public static void main(String[] args) {
            Scanner S = new Scanner(System.in);
            long N = S.nextLong();
            int M = S.nextInt();
            long[] arr = new long[M + 1];
            for (int i = 1; i <= M; i++) {
                arr[i] = S.nextInt();
            }
            long ed = pw(2, M), ans = N;
            for (int i = 1; i < ed; i++) {
                long cnt = 0, tmp = 1;
                for (int j = 1; j <= M; j++) {
                    if ((i & (1 << (j - 1))) != 0) {
                        cnt++;
                        tmp = tmp / gcd(tmp, arr[j]) * arr[j];
                    }
                }
                if (cnt % 2 == 1) ans -= (N / tmp);
                else ans += (N / tmp);
            }
            System.out.println(N - ans);
        }
            //快速指数
        public static long pw(long a, long b) {
            long ans = 1, base = a;
            while (b != 0) {
                if (b % 2 == 1) ans = (ans * base);
                base = (base * base);
                b >>= 1;
            }
            return ans;
        }

        public static long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }


