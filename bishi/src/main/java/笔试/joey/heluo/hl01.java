package main.java.笔试.joey.heluo;

import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/10/11 17:21
 */
public class hl01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(maxNoRepeatString(input));
    }
    public static String maxNoRepeatString(String txt){
        int len=txt.length();
        int i=0;
        int j=1;
        String son=null;
        int max=0;
        while(j<len){
            int repeat=txt.indexOf(txt.charAt(j),i);
            if(repeat>=i&&repeat<j){
                if((j-i)>max) {
                    son = txt.substring(i, j );
                    max = j - i;
                }
                i=repeat+1;
            }
            j++;
        }
        if((j-i)>max)
            son=txt.substring(i,j);
        return son;
    }
}
