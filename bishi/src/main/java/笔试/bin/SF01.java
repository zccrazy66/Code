package Code.bishi.src.main.java.笔试.bin;

import java.util.Scanner;

/**6 3
 0 0 1 1 0 0
 * Created by 林松斌的船 on 2020/8/29.
 */
public class SF01 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=s.nextInt();
        }
        int max=0;
        int sum=0;
        int l=0,r=n-k;
        int resl=l,resr=r;
        for (int m=0;m<=r;m++){
            sum+=nums[m];
        }
        max=sum;
        while (r<n-1){
           // System.out.println("123");
            r++;
            sum+=nums[r];
            sum-=nums[l];
            l++;
            if (max<sum){
                max=sum;
                resl=l;
                resr=r;
            }
        }
       // System.out.println(sum);
        int res=0;
        for (int i=0;i<resl;i++){
            res+=nums[i]*nums[i];
        }
        for (int i=resr+1;i<n;i++){
            res+=nums[i]*nums[i];
        }
        res+=max*max;
        while (nums[l]==0){
            l++;
        }
        while (nums[r]==0){
            r--;
        }
        int len=r-l+1;
        System.out.print(res+" ");
        System.out.print(len);

    }
}
