package bishi.src.main.java.笔试.bin.DIdi;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**群岛群岛群岛群岛群岛群岛群岛群岛群岛群岛群岛群岛群岛群岛群岛群岛
 * Created by 林松斌的船 on 2020/8/21.
 */
public class DD01 {
    public static void main(String[] args) {
        List<String > res=new LinkedList<>();
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t=0;t<T;t++){
            int n=s.nextInt();
            int m=s.nextInt();
            int k=s.nextInt();
            int[][] board=new int[m][3];

            for (int i=0;i<m;i++){
                board[i][0]=s.nextInt();
                board[i][1]=s.nextInt();
                board[i][2]=s.nextInt();
            }
            int[][] dirs=new int[n][n];
            for (int i=0;i<m;i++){
                if (board[i][2]<=k){
                    dirs[board[i][0]-1][board[i][1]-1]=1;
                    dirs[board[i][1]-1][board[i][0]-1]=1;
                }
            }
//            for (int i=0;i<dirs.length;i++){
//                System.out.println(Arrays.toString(dirs[i]));
//            }
            boolean curres=bfs(0,dirs);
            if(curres)res.add("Yes");
            else res.add("No");
        }
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }

    }
    public static boolean bfs(int start,int[][] dirs){
        int[] checked=new int[dirs.length];
        checked[start]=1;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            int cur=queue.poll();
            for (int i=0;i<dirs[cur].length;i++){
                if (dirs[cur][i]==1&&checked[i]==0){
                    checked[i]=1;
                    queue.add(i);
                }
            }
        }
        for (int i=0;i<checked.length;i++){
            if (checked[i]==0){
                //System.out.println(i);
                return false;
            }
        }
        return true;
    }
}
