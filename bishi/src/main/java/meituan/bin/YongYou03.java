package Code.bishi.src.main.java.meituan.bin;

import java.util.Arrays;

/**
 * Created by 林松斌的船 on 2020/8/18.
 */
public class YongYou03 {
    public static void main(String[] args) {
        YongYou03 yongYou03 = new YongYou03();
        int[][] a = {{0, 1, 10}, {0, 3, 40}, {1, 2, 20}, {1, 3, 100}, {1, 4, 30}, {2, 3, 50}, {3, 4, 60}};
        System.out.println(Arrays.toString(yongYou03.findAllCheapestPrice(5, a, 1)));
    }

    public int[] findAllCheapestPrice(int n, int[][] fights, int str) {
        int[][] distant = new int[n][n];
        for (int i = 0; i < fights.length; i++) {
            distant[fights[i][0]][fights[i][1]] = fights[i][2];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (n == str) res[n] = 0;
            else res[i] = findCheapestPrice(n, fights, str, i, n);
        }
        return res;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dist = new int[2][n];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dist[0], INF);
        Arrays.fill(dist[1], INF);
        dist[0][src] = dist[1][src] = 0;

        for (int i = 0; i <= K; ++i)
            for (int[] edge : flights)
                dist[i & 1][edge[1]] = Math.min(dist[i & 1][edge[1]], dist[~i & 1][edge[0]] + edge[2]);
        return dist[K & 1][dst] < INF ? dist[K & 1][dst] : -1;
    }
}
