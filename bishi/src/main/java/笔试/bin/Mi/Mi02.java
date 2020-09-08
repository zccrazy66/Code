package bishi.src.main.java.笔试.bin.Mi;
import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/8.
 */
public class Mi02 {
    private boolean[][] marked;
    private int[][] direction={{-1,0},{0,-1},{0,1},{1,0}};
    private int m;
    private int n;
    private String word;
    private char[][] board;
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
//        int m=s.nextInt();
//        int n=s.nextInt();
//        char[][] strings=new char[m][n];
//        for (int i=0;i<m;i++){
//           for (int j=0;j<n;j++){
//               strings[i][j]=s.next().charAt(0);
//           }
//        }
        String tar=s.next();
        char[][] chars={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        // char[][] board={{'a','b'}};
        // String word="ba";
        Mi02 mi02=new Mi02();
        System.out.println(mi02.exist(chars,tar));
    }
    //////////////////////////////////////////////////////////


    public boolean exist(char[][] board,String word){
        m=board.length;
        if (m==0){
            return false;
        }
        n=board[0].length;
        marked=new boolean[m][n];
        this.word=word;
        this.board=board;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i,int j,int start){
        if (start==word.length()-1){
            return board[i][j]==word.charAt(start);
        }
        if (board[i][j]==word.charAt(start)){
            marked[i][j]=true;
            for (int k=0;k<4;k++){
                int newx=i+direction[k][0];
                int newy=j+direction[k][1];
                if (inArea(newx,newy)&&!marked[newx][newy]){
                    if (dfs(newx,newy,start+1)){
                        return true;
                    }
                }
            }
            marked[i][j]=false;
        }
        return false;
    }
    public boolean inArea(int i,int j){
        return i>=0&&i<m&&j>=0&&j<n;
    }
}
