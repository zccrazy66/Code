package bishi.src.main.java.笔试.bin.DXM;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/20.
 */
public class DXM02 {
     static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
     static int res;
     static  int[][] check;
    public static void main(String[] args) {
        List<Integer> list=new LinkedList<>();
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
           int n=s.nextInt();
           int m=s.nextInt();
           //System.out.println(n);
          // System.out.println(m);
           char[][] chars=new char[n][m];
           int[] start=new int[2];
           for (int i=0;i<n;i++) {
               String str=s.next();
               for (int j=0;j<m;j++){
                   chars[i][j]=str.charAt(j);
                   if (chars[i][j]=='@'){
                       start[0]=i;
                       start[1]=j;
                   }
               }
           }
            res=Integer.MAX_VALUE;
            check=new int[n][m];
            for (int i=0;i<check.length;i++){
                for (int j=0;j<check[0].length;j++){
                    check[i][j]=Integer.MAX_VALUE;
                }
            }
            dfs(chars,start,0);
           list.add(res==Integer.MAX_VALUE?-1:res);
        }
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
    public static void dfs(char[][] chars,int[] cur,int need){
            if (need>=res)return;
            int x=cur[0];
            int y=cur[1];
            check[x][y]=need;
           // System.out.println("newx="+x+"newy="+y);
            if (x==0||x==chars.length-1||y==0||y==chars[0].length-1){
                res=Math.min(res,need);
                //System.out.println("res="+res+"x="+x+"y="+y);
                return;
            }
            for (int i=0;i<4;i++){
                    int newx=x+dir[i][0];
                    int newy=y+dir[i][1];
                    int[] newint={newx,newy};
               // System.out.println("x="+newx+"y="+newy);
                    if (check(newint,chars)){
                        if (chars[newx][newy]=='*'&&check[newx][newy]>need+1){
                            dfs(chars,newint,need+1);
                        }
                        if (chars[newx][newy]=='.'&&check[newx][newy]>need){
                            dfs(chars,newint,need);
                        }
                    }
            }

    }
    public static boolean check(int[] cur,char[][] chars){
        if (cur[0]<0||cur[1]<0||cur[0]>=chars.length||cur[1]>=chars[0].length)return false;
        return true;
    }
}
 //   Queue<int[]> queue=new LinkedList<>();
//        int[][] checked=new int[chars.length][chars[0].length];
//        for (int i=0;i<chars.length;i++){
//            for (int j=0;j<chars[0].length;j++){
//                checked[i][j]=-1;
//            }
//        }
//        queue.add(start);
//        checked[start[0]][start[1]]=0;
//        while (!queue.isEmpty()){
//            int[] cur=queue.poll();
//            int x=cur[0];
//            int y=cur[1];
//            int need=checked[x][y];
//            for (int i=0;i<4;i++){
//                int newx=x+dir[i][0];
//                int newy=y+dir[i][1];
//                int[] newint={newx,newy};
//                if (check(newint, chars)) {
//                    if (chars[newx][newy] == '*') {
//
//                    }
//                    if (chars[newx][newy] == '.') {
//
//                    }
//                }
//            }
//        }