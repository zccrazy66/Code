//#include <bits/stdc++.h>
//        #define cls(a,b) memset(a,b,sizeof(a))
//        using namespace std;
//        const int maxn=20;
//
//        int n,m,r,c,ans,mp[maxn][maxn];
//        vector<int> row;
//        int dp[maxn][maxn],extra[maxn],cost[maxn][maxn];
//
//        inline void calc(){
//        cls(dp,0x3f),cls(extra,0),cls(cost,0);
//        for(int i=1;i<=m;i++)for(int j=i+1;j<=m;j++)for(auto ro:row)cost[i][j]+=abs(mp[ro][i]-mp[ro][j]);
//        for(int co=1;co<=m;co++)for(int i=0;i<row.size()-1;i++)extra[co]+=abs(mp[row[i]][co]-mp[row[i+1]][co]);
//        for(int i=0;i<=m;i++)dp[i][0]=0;
//        for(int i=1;i<=m;i++)
//        for(int j=1;j<=i;j++)
//        for(int k=j-1;k<i;k++)
//        dp[i][j]=min(dp[i][j],dp[k][j-1]+cost[k][i]+extra[i]);
//        for(int i=1;i<=m;i++)ans=min(ans,dp[i][c]);
//        }
//        void dfs(int now){
//        if(row.size()>r||row.size()+n-now+1<r)return;
//        if(now==n+1){
//        calc();
//        return;
//        }
//        row.push_back(now);
//        dfs(now+1);
//        row.pop_back();
//        dfs(now+1);
//        }
//
//        void read_and_parse(){
//        scanf("%d%d%d%d",&n,&m,&r,&c);
//        for(int i=1;i<=n;i++)for(int j=1;j<=m;j++)scanf("%d",&mp[i][j]);
//        }
//        void solve(){
//        ans=1<<30;
//        dfs(1);
//        printf("%d\n",ans);
//        }
//        int main(){
//        read_and_parse();
//        solve();
//        return 0;
//        }