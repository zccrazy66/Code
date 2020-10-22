package bishi.src.main.java.笔试.bin.TuHu;

/**
 * Created by 林松斌的船 on 2020/10/22.
 */
public class TuHu02 {
    public  int C(int r, int n)// 应用组合数的互补率简化计算量
    {
        int helf = n / 2;
        if (r > helf)
        {
            //System.out.print(m + "---->");
            r = n - r;
            // System.out.print(m + "\n");
        }
        // 分子的排列数
        int numerator = A(n, r);
        //System.out.println(numerator);
        // 分母的排列数
        int denominator = A(r, r);
        //System.out.println(denominator);
        return numerator / denominator;
    }
    public  int A(int n, int m)
    {
        int result = 1;
        // 循环m次,如A(6,2)需要循环2次，6*5
        for (int i = m; i > 0; i--)
        {
            result *= n;
            n--;// 下一次减一
        }
        return result;
    }
}
