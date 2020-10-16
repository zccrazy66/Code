package bishi.src.main.java.笔试.bin.ebay;

import java.util.*;

/**
 * Created by 林松斌的船 on 2020/9/24.
 */
public class ebay02222222 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        List<String> res=new LinkedList<>();
        for (int i=0;i<n;i++){
            String str=s.next();
            if (isValid(str))res.add("Yes");
            else res.add("No");
        }
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }

    }
    public static boolean isValid(String s) {
        HashMap<Character,Character> hashMap=new HashMap<>();
        hashMap.put('}','{');
        hashMap.put(']','[');
        hashMap.put(')','(');
        if (s.length()==0){return  true;}
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if (s.charAt(i)=='{'|| s.charAt(i)=='('|| s.charAt(i)=='[')
            {
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i)=='}'|| s.charAt(i)==')'|| s.charAt(i)==']'){
                if (stack.isEmpty()){
                    return false;
                }
                if (stack.peek()!=hashMap.get(s.charAt(i))){
                    return false;
                }
                else {
                    stack.pop();
                }
            }
            else return false;
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }

}
