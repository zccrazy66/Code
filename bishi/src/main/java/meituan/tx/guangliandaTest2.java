package main.java.meituan.tx;

/**
 * @author xin Tan
 * @create 2020-08-15 18:53
 */
public class guangliandaTest2 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 0, 6};
        guangliandaTest2 test2 = new guangliandaTest2();
        System.out.println(test2.count(arr));
    }

    public  int count(int[] nums) {
        if (nums == null || nums.length <= 3) {
            return -1;
        }
        int mean = 0;
        for (int ele : nums) {
            mean += ele;
        }
        mean /= 4;
        //计算还剩多少
        int remain = 0;
        //计算还需要多少
        int lack = 0;
        for (int ele : nums) {
            if (ele > mean) {
                remain += ele - mean;
            } else {
                lack += mean - ele;
            }
        }
        if (remain % 2 == 0 && remain / 2 == lack) {
            return mean * 4;
        }
        return -1;
    }
}
