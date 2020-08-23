#include<bits/stdc++.h>
using namespace std;
#define ll long long
const int maxm=2e6+5;
char s[maxm];
int n;
struct SAM{
int ch[maxm][26];
int fa[maxm],l[maxm];//l[]是等价类的最长字符串长度len
int last=1,tot=1;//tot是节点数量
void add(int c){
    int p=last,np=++tot;last=np;l[np]=l[p]+1;
    for(;p&&!ch[p][c];p=fa[p])ch[p][c]=np;
    if(!p)fa[np]=1;
    else{
        int q=ch[p][c];
        if(l[p]+1==l[q])fa[np]=q;
        else{
            int nq=++tot;
            l[nq]=l[p]+1;
            memcpy(ch[nq],ch[q],sizeof ch[q]);
            fa[nq]=fa[q];
            fa[q]=fa[np]=nq;
            for(;ch[p][c]==q;p=fa[p])
                ch[p][c]=nq;
        }
    }
}
    //本题
    int cnt[maxm];
    int idx[maxm];
    int sz[maxm];
void cal_sz(){
        for(int i=1;i<=tot;i++)sz[i]=1;
//基数排序
        for(int i=1;i<=tot;i++)cnt[l[i]]++;
        for(int i=1;i<=tot;i++)cnt[i]+=cnt[i-1];
        for(int i=1;i<=tot;i++)idx[cnt[l[i]]--]=i;
//
        for(int i=tot;i>=1;i--){
        for(int j=0;j<26;j++){
        sz[idx[i]]+=sz[ch[idx[i]][j]];
        }
        }
}
    void solve(int k){
    int x=1;
    while(k){
        for(int j=0;j<26;j++){
            if(ch[x][j]){
            if(sz[ch[x][j]]>=k){
            printf("%c",'a'+j);
            x=ch[x][j];
            k--;
            break;
            }else{
            k-=sz[ch[x][j]];
            }
            }
        }
    }
    puts("");
    }
//
}S;
signed main(){
//
    scanf("%s",s+1);
    n=strlen(s+1);
    for(int i=1;i<=n;i++){
    S.add(s[i]-'a');
    }
    S.cal_sz();
    //
    int q;scanf("%d",&q);
    while(q--){
    int k;scanf("%d",&k);
    S.solve(k);
    }
    return 0;
}
