package 笔试.bin;

import java.util.*;

/**1
 3
 3
 0 1
 2
 0 2 4
 1 2 5
 5
 0
 2
 3
 4
 5
 * Created by 林松斌的船 on 2020/7/31.
 */
public class AliTest1 {
    int sum=0;
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        int m;
        int n;
        int[][] dir;
        int Q;
        int[] nums;

        for (int i=0;i<T;T++){
            n=s.nextInt();
            m=s.nextInt();
            dir=new int[n][n];
            //得到dir矩阵
            for (int j=0;j<m;j++){
                int x=s.nextInt();
                int y=s.nextInt();
                dir[x][y]=s.nextInt();
                dir[y][x]=dir[x][y];
            }
            int max=Integer.MIN_VALUE;
            Q=s.nextInt();
            nums=new int[Q];
            //得到待求距离
            for (int j=0;j<Q;j++){
                nums[j]=s.nextInt();
                max=Math.max(m,nums[j]);
            }
            //得到两点之间最短距离矩阵
            int[][] a=help(dir,max);
            List<Integer> list=new LinkedList<>();
            //重点来了把因为只需要统计大于等于目标值点个数，所以把所有可以联通的点对距离全部放在一个数组，
            // 直接从数组找大于等于目标值的个数就可以了
            //先做list因为数量未知
            for (int q=0;q<a.length;q++){
                for (int p=0;p<a.length;p++){
                    if (a[q][p]!=0){
                        list.add(a[q][p]);
                    }
                }
            }
            //得到上面说的数组
            int[] res=new int[list.size()];
            for (int k=0;k<list.size();k++){
                res[k]=list.get(k);
            }
            //排序
            Arrays.sort(res);
           // System.out.println(Arrays.toString(res));
            //遍历Q数组依次求出结果
            for (int k=0;k<Q;k++){
                int cur=nums[k];
                int j=0;
                while (j<res.length&&res[j]<cur){
                    j++;
                }
               // System.out.println(cur+"qw"+j);
                System.out.println(res.length-j);
            }


        }


    }
    //通过dir矩阵得到距离矩阵，矩阵含义res[i][j]表示从i到j最短距离，可以把101-103行回复查看次矩阵
    public static int[][] help(int[][] dir,int tar){
        int[][] res=new int[dir.length][dir.length];
        Queue<Integer> queue=new LinkedList<>();
       for (int i=0;i<dir.length;i++){
                queue.add(i);
                res[i][i]=0;
           //System.out.println(i);
                while (!queue.isEmpty()){
                    int cur=queue.poll();
                  //  System.out.println(cur);
                    for (int k=0;k<dir.length;k++){
                        if (dir[cur][k]!=0){
                            if((res[i][k]==0||res[i][k]>res[i][cur]+dir[cur][k])&&i!=k){
                                res[i][k]=res[i][cur]+dir[cur][k];
                                queue.add(k);
                            }
                        }
                    }
                }

       }
//        for (int i=0;i<res.length;i++){
//           System.out.println(Arrays.toString(res[i]));
//        }
      return res;
    }

}
