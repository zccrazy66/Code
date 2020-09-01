package main.java.笔试.zczc.东方财富;

public class 股票 {

        public int maxProfit(int[] prices) {
            if(prices==null || prices.length==0) {
                return 0;
            }
            int n = prices.length;
            return dfs(prices,0,0,0);
        }

        private int dfs(int[] prices,int index,int status,int k) {
            //递归终止条件，数组执行到头了，或者交易了两次了
            if(index==prices.length || k==2) {
                return 0;
            }
            //定义三个变量，分别记录[不动]、[买]、[卖]
            int a=0,b=0,c=0;
            //保持不动
            a = dfs(prices,index+1,status,k);
            if(status==1) {
                //递归处理卖的情况，这里需要将k+1，表示执行了一次交易
                b = dfs(prices,index+1,0,k+1)+prices[index];
            }
            else {
                //递归处理买的情况
                c = dfs(prices,index+1,1,k)-prices[index];
            }
            //最终结果就是三个变量中的最大值
            return Math.max(Math.max(a,b),c);
        }



}
