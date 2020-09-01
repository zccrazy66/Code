package Code.bishi.src.main.java.笔试.bin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/2.
 */
public class Pdd02 {
    static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] check;
    static int[][] nums;
    static int sum=0;
    static int all=0;
    static HashSet<String> set=new HashSet<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        nums=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                nums[i][j]=s.nextInt();
            }
        }
        int partnums=0;
        List<HashSet<String>> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        check=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (check[i][j]==0&&nums[i][j]==1){
                    check[i][j]=1;
                    partnums++;
                    set.clear();
                    sum=0;
                    dfs(i,j);
                    list.add(new HashSet<>(set));
                    Integer cur=new Integer(sum);
                    list1.add(cur);
                }
            }
        }
        int max=Integer.MIN_VALUE;

        for (int i=0;i<n;i++){
            if (max==all)break;
            for (int j=0;j<m;j++){
                if (nums[i][j]==0){
                    int a=0;
                    String cur=i+""+j;
                    for (int k=0;k<list.size();k++){
                        if (list.get(k).contains(cur)){
                            a+=list1.get(k);
                        }
                    }
                    if (a<all)a++;
                    if (a==all){
                        max=a;
                        break;
                    }
                    max=Math.max(max,a);
                }
            }
        }
        System.out.println(max);


    }
    public static void dfs(int i,int j){
        sum++;
        all++;
        int[] cur={i,j};
        boolean get=true;
        for (int m=0;m<4;m++){
            int newx=i+dir[m][0];
            int newy=j+dir[m][1];
            if (checked(newx,newy)&&nums[newx][newy]==1&&check[newx][newy]==0){
                check[newx][newy]=1;
                dfs(newx,newy);
            }
            if (checked(newx,newy)&&nums[newx][newy]==0){
                String a=newx+""+newy;
                set.add(a);
            }
        }

    }
    public static boolean checked(int i,int j){
        if (i<0||j<0||i>=check.length||j>=check[0].length){
            return false;
        }
        return true;
    }
}
