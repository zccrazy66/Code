package 笔试.jungel.xiecheng;

import com.alibaba.fastjson.JSON;

import java.util.*;

//a bc d eag f
public class Second {

    private class Str{
        String val;
        boolean isLoop;

        public Str(String val, boolean isLoop) {
            this.val = val;
            this.isLoop = isLoop;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");

        List<Str> str = new Second().getStr(split);
        Collections.sort(str, Comparator.comparing(o -> o.val));
        for (Str str1 : str) {
            System.out.print(str1.val);
            if (str1.isLoop) System.out.print("--circular dependency");
            System.out.println();
        }
    }

    private List<Str> res;
    private boolean isLoop;
    private int[] arr;
    private List<Str> getStr(String[] str) {


        res = new LinkedList<>();
        isLoop = false;
        arr = new int[26];
        dfs(str,0,"");

        return res;

    }

    private void dfs(String[] str, int index,String string) {

        if (index==str.length) {
            res.add(new Str(string,isLoop));
            return;
        }

        int length = str[index].length();
        String singleStr = str[index];
        for (int i = 0; i < length; i++) {

            char c = singleStr.charAt(i);

            arr[c-'a']++;
            if (arr[c-'a']>=2) isLoop=true;
            String newStr = string+singleStr.charAt(i);
            dfs(str,index+1,newStr);
            arr[c-'a']--;
            if (arr[c-'a']<=1) isLoop=false;
        }

    }
}
