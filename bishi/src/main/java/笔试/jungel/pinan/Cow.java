package 笔试.jungel.pinan;

public class Cow {

    public static int cowNum(int n){
        if(n < 1) return 0;
        if(n == 1 || n == 2 || n == 3) return n;
        else{
            return cowNum(n - 1) + cowNum(n - 3);
        }
    }

    public static void main(String[] args){
        System.out.println(cowNum( 6 ));
    }
}
