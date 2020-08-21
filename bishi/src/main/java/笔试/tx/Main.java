package main.java.笔试.tx;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n<200||n>1998) {
            System.out.println(0);
            return;
        }

        Main main = new Main();
        List<H> helper = main.helper(n);

        if (helper.size()==0) {
            System.out.println(0);
            return;
        }

        System.out.println(helper.size());
        for (H h : helper) {
            System.out.println(h.A+" "+h.B);
        }


    }

    private List<H> helper(int n) {
        ArrayList<H> hs = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {

            for (int j = 0; j <=9 ; j++) {

                for (int k = 0; k <=9 ; k++) {

                    if (i!=j&&i!=k&&j!=k) {

                        int A = 100*i+10*j+k;

                        if ((n-A)>=100){
                            int B = 100*i+10*k+k;
                            if (A+B==n) {
                                hs.add(new H(A, B));
                            }
                        }


                    }

                }
            }

        }

        return hs;

    }

    private static class H{
        int A;
        int B;

        public H(int a, int b) {
            A = a;
            B = b;
        }
    }
}
