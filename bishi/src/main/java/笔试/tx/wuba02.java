package main.java.笔试.tx;


public class wuba1 {

    public static  int question (int a, int b) {
        //System.out.println(a);
        //System.out.println(a);
        int res = 0;
        for (int i = 0; i <=500 ; i++) {
            if (help(i + a) && help(i + b))
            {
                res = i;
                break;
            }
        }
        return res;
    }

    private static boolean help(int n)
    {
        boolean check = false;
        double fsqrt = Math.sqrt(n);
        int l = (int) fsqrt;

        if (n == Math.pow(l, 2))
        {
            check = true;
            //System.out.println(check);
        }
        return check;
    }
}




