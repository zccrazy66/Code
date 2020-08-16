package Code.bishi.src.main.java.meituan.bin;

import java.util.Scanner;
import java.util.Stack;

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
        if (str.length()==0){
            return "";
        }
        String[] strings=str.split(" ");
        for (int i=0;i<str.length();i++){

        }
        String[] res=new String[strings.length];
        Stack<String> stack=new Stack<>();
        //  System.out.println(Arrays.toString(strings));
        int n=0;int len=strings.length;
        int j=0;
        String pre=null;
        while (n<len){
            if (strings[n].equals("redo")){
                if(stack.isEmpty()){
                    n++;
                    continue;
                }
                res[j]=stack.pop();
                j++;
            }
            else if (strings[n].equals("undo")){
                if (j==0){
                    n++;
                    continue;
                }
                stack.push(res[--j]);
            }
            else {
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
