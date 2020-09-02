package bishi.src.main.java.笔试.bin.HuaWei;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/2.
 */

    public class HuaWei02 {
        int[][] design;
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        public static void main(String[] args){
            Scanner s=new Scanner(System.in);
            String t=s.nextLine();
            String[] strings=t.split(",");
            int m=Integer.valueOf(strings[0]);
            int n=Integer.valueOf(strings[1]);
            if (n<=0){
                System.out.println(0);
                return;
            }
//System.out.println(m+" "+n);
            char[][] chars=new char[m][n];
            for (int i=0;i<m;i++){
                String cur=s.nextLine();
                for (int j=0;j<n;j++){
                    chars[i][j]=cur.charAt(j);
                }

            }
            HuaWei02 x=new HuaWei02();
            //char[][] a={{'S','S','H','H','H'},{'S','S','H','H','H'},{'H','H','S','H','H'},{'H','H','H','S','S'}};
            System.out.println(x.largestIsland(chars));
        }
        public int largestIsland(char[][] grid) {
            if (grid.length==0)return 0;
            design=new int[grid.length][grid[0].length];
            int part=0;
            //int[] partsize=new int[grid.length*grid[0].length+2];
            for (int i=0;i<grid.length;i++){
                for (int j=0;j<grid[0].length;j++){
                    if (design[i][j]==0&&grid[i][j]=='S'){
                        //System.out.println("qwe");
                        part++;
                        dfs(i,j,grid,part);

                    }
                }
            }
            // System.out.println(part);
//        for (int i=0;i<grid.length;i++){
//            System.out.println(Arrays.toString(grid[i]));
//        }
            int max=Integer.MIN_VALUE;
//        for (int x:partsize)max=Math.max(max,x);
//        for (int i=0;i<grid.length;i++){
//            for (int j=0;j<grid[0].length;j++){
//                    if (grid[i][j]==0){
//                        HashSet<Integer> set=new HashSet<>();
//                        for (int[] cur:getneibor(i,j,grid)){
//                            set.add(grid[cur[0]][cur[1]]);
//                        }
//                        int sum=1;
//                        for (int x:set){
//                            sum+=partsize[x];
//                        }
//                        max=Math.max(sum,max);
//                    }
//            }
//        }
            return part;
        }
        public int dfs(int i,int j,char[][] grid,int part){
            //System.out.println("i="+i+"j="+j);
            design[i][j]=1;
            int sum=1;
            for (int[] cur:getneibor(i,j,grid)){
                if(grid[cur[0]][cur[1]]=='S'&&design[cur[0]][cur[1]]==0){
                    sum+=dfs(cur[0],cur[1],grid,part);
                }
            }
            return sum;
        }
        public List<int[]> getneibor(int i, int j, char[][] grid){
            List<int[]> list=new LinkedList<>();
            for (int m=0;m<4;m++){
                int newx=i+dir[m][0];
                int newy=j+dir[m][1];
                if (newx<0||newy<0||newx>=grid.length||newy>=grid[0].length)continue;
                else {
                    int[] cur={newx,newy};
                    list.add(cur);
                }
            }
            return list;
        }
    }



