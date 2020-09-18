package 笔试.jungel.pinan;

import java.util.Scanner;

class Fibonacci{
    public static int get(int x){
        if(x==1 || x==2){
            return 1;
        }
        int a=1,b=1,c=0;
        for(int i=3;i<=x;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(Fibonacci.get(n)+1);
    }
}
