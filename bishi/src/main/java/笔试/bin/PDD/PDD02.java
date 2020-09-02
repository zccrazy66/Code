package Code.bishi.src.main.java.笔试.bin.PDD;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/1.
 */
public class PDD02 {

        static int [][]a=new int[405][405];
        static int [][]col=new int[405][405];
        static int []qx=new int[200005];
        static int []qy=new int[200005];
        static int []siz=new int[200005];
        static int []v=new int[200005];
        static int cnt,n,m;

        static int []kx={0,0,1,-1};
        static int []ky={1,-1,0,0};

        public static void bfs(int x,int y)
        {
            int eh=1,ed=0,eh2=1,ed2=0;
            qx[++ed]=x; qy[++ed2]=y;
            while(eh<=ed)
            {
                int u=qx[eh],v=qy[eh2]; eh++; eh2++; col[u][v]=cnt; siz[col[u][v]]++;
                for(int i=0;i<=3;i++)
                {
                    int tx=u+kx[i],ty=v+ky[i];
                    if(tx<=0||tx>n||ty<=0||ty>m||col[tx][ty]!=0||a[tx][ty]==0) continue;
                    qx[++ed]=tx; qy[++ed2]=ty;
                }
            }
        }

        public static void main(String[] args)
        {
            Scanner S=new Scanner(System.in);
            n=S.nextInt(); m=S.nextInt();
            for(int i=1;i<=n;i++) for(int j=1;j<=m;j++) a[i][j]=S.nextInt();
            for(int i=1;i<=n;i++) for(int j=1;j<=m;j++)
                if(a[i][j]==1&&col[i][j]==0) {cnt++; bfs(i,j);}

            int ans=0;
            for(int i=1;i<=cnt;i++) ans=Math.max(ans,siz[i]);
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=m;j++)
                {
                    if(a[i][j]==1) continue;
                    int tmp=0;
                    for(int k=0;k<=3;k++)
                    {
                        int tx=i+kx[k],ty=j+ky[k];
                        if(tx<=0||tx>n||ty<=0||ty>m) continue;
                        if(v[col[tx][ty]]==0)
                        {
                            v[col[tx][ty]]=1;
                            tmp+=siz[col[tx][ty]];
                        }
                    }
                    ans=Math.max(ans,tmp+1);
                    for(int k=0;k<=3;k++)
                    {
                        int tx=i+kx[k],ty=j+ky[k];
                        if(tx<=0||tx>n||ty<=0||ty>m) continue;
                        v[col[tx][ty]]=0;
                    }
                }
            }

            int p2=0;
            for(int i=1;i<=n;i++) for(int j=1;j<=m;j++) p2+=a[i][j];
            System.out.println(Math.min(ans,p2));
        }
    }


