package bishi.src.main.java.笔试.bin.TuHu;

import java.util.Arrays;

/**
 * Created by 林松斌的船 on 2020/10/22.
 */
public class TuHu01 {
    public static void main(String[] args){
        int[] array1={1,2,4,5};
        int[] array2={6,3};
        System.out.println(Arrays.toString(arrayMerge(array1,4,array2,2)));
    }
    public static int[] arrayMerge (int[] array1, int n, int[] array2, int m) {
        int[] res=new int[n+m];
        int a=0,b=array2.length-1;
        for (int i=0;i<res.length;i++){
            if (a<array1.length&&b>=0) res[i]=array1[a]<array2[b]?array1[a++]:array2[b--];
            else if (a<array1.length)res[i]=array1[a++];
            else if (b>=0)res[i]=array2[b--];
        }
        return res;
    }
}
