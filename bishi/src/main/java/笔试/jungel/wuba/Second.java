package 笔试.jungel.wuba;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Second {

    public int lineup(String peoples) {

        return Math.min(postGirl(peoples),preGirl(peoples));
    }

    /**
     * 女生排在后面
     */
    private int postGirl(String peoples) {

        int num_girl=peoples.length();

        int p=num_girl-1;

        int res=0;
        for (int i = num_girl-1; i >=0 ; i--) {

            if (peoples.charAt(i)=='G') {

                int dis = p - i;
                res=res+dis;
                p--;
            }
        }

        return res;
    }


    private int preGirl(String peoples) {

        int num_girl=peoples.length();

        int p=0;

        int res=0;
        for (int i = 0; i <num_girl ; i++) {

            if (peoples.charAt(i)=='G') {

                int dis = i - p;
                res=res+dis;
                p++;
            }
        }

        return res;
    }

//    public static void main(String[] args) {
//        String str="GGBBG";
//        System.out.println(new Second().lineup(str));
//
//
//    }
}
