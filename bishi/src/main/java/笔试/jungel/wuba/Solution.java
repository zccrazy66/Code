package 笔试.jungel.wuba;

public class Solution {

    private String str;
    private int n;
    public int translateNum(int num) {
        str = String.valueOf(num);
        n = str.length();

        return getNum(0);
    }

    private int getNum(int index) {

        if (n-index==2) {
            if (Integer.parseInt(str.substring(index,index+2))<=25) {
                return 2;
            }else {
                return 1;
            }
        }

        if (n-index==1) return 1;
        int second = 0;
        if ((n-index)>=2&&Integer.parseInt(str.substring(index,index+2))<=25) {
            second = getNum(index+2);
        }
        return getNum(index+1)+second;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(1215811));
    }
}
