package 笔试.jungel.bilibili;

public class First {

    public int GetMaxConsecutiveOnes (int[] arr, int k) {
        int n = arr.length;

        int l=0,r=0;
        int num_0 = 0;
        int res=0;
        while (r<n) {

            int rightVal = arr[r];
            if (rightVal==0) num_0++;
            int temp = r - l;
            res=Math.max(temp,res);
            r++;

            System.out.println("0的个数"+num_0);
            System.out.println("此时的最大值"+res);


            System.out.println("此时L是"+l+","+"R是"+r);

            System.out.println("============================");

            while (num_0>=3){
                int leftVal = arr[l];
                l++;
                if (leftVal==0) {
                    num_0--;
                }


            }

        }


        return res;
    }


    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,1,0,0,1,1,1,1,0};
        System.out.println(new First().GetMaxConsecutiveOnes(arr,2));
    }

}
