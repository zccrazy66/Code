package bishi.src.main.java.笔试.bin.ebay;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/24.
 */
public class ebay02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        List<String> res=new LinkedList<>();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int m = s.nextInt();
            int k = s.nextInt();
            int[] nums = new int[n];
            int z=0;
            for (int i = 0; i < n; i++) {
                    nums[i]=s.nextInt();
                    if (nums[i]%k==0)z++;
            }
            if (z>=m) res.add("Yes");
            else res.add("No");
        }
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }

    }
}
