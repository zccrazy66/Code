package Code.bishi.src.main.java.笔试.bin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/22.
 */
public class Test360 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int[] ints=new int[m];
        for (int i=0;i<m;i++){
            ints[i]=s.nextInt();
        }
        int[] nums=new int[n];
        for (int i=1;i<=n;i++){
            nums[i-1]=i;
        }
       // help1(list);
      //  System.out.println(Arrays.toString(nums));
        int i=0;
        while (i<m){
            int z=0;
            while (i<m&&ints[i]==1){
                i++;
            }
            nums=help1(nums,z);
            int t=0;
            while (i<m&&ints[i]==2){
                t++;
                i++;
            }
            System.out.println(t);
            if (t%2==0)continue;
            if (t%2==1)nums=help(nums);
        }
        for (int j=0;j<n;j++){
            System.out.print(nums[j]+" ");
        }

    }
    public static   int[] help1(int[] nums,int d){
//        ArrayList<Integer> list=getlist(nums);
//        int l=list.get(0);
//        list.remove(0);
//        list.add(l);
//        for (int i=0;i<nums.length;i++){
//            nums[i]=list.get(i);
//        }
//        return nums;
        int[] q=new int[d];
        for (int i=0;i<d;i++){
            q[i]=nums[i];
        }
        for (int i=0;i<nums.length-d;i++){
            nums[i]=nums[i+d];
        }
        for (int i=0;i<d;i++){
            nums[nums.length-d+i]=q[i];
        }

        return nums;
    }
    public static int[]  help(int[] nums){
        for (int i=0;i<nums.length;i+=2){
          int x= nums[i];
          nums[i]=nums[i+1];
          nums[i+1]=x;
        }
        return nums;
    }
    public static ArrayList getlist(int[] ints){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i=0;i<ints.length;i++){
            list.add(ints[i]);
        }
        return list;
    }
}
