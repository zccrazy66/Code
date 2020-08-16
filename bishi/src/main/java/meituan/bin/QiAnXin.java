package Code.bishi.src.main.java.meituan.bin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/16.
 */
public class QiAnXin {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        QiAnXin aNtest=new QiAnXin();
        System.out.println(aNtest.help(str));
    }
    public String help(String str){
        String[] strings=str.split(" ");
        String[] res=new String[strings.length];
        System.out.println(Arrays.toString(strings));
        int n=0;int len=strings.length;
        int j=0;
        while (n<len){
            if (strings[n].equals("redo")){
                j++;
            }
            else if (strings[n].equals("undo")){
                j--;

            }
            else {
                System.out.println(n+"+"+j);
                res[j]=strings[n];
                j++;
            }
            n++;
        }
        StringBuffer stringBuffer=new StringBuffer();
        for (int i=0;i<j;i++){
            stringBuffer.append(res[i]+" ");
        }
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        return stringBuffer.toString();
    }
}
