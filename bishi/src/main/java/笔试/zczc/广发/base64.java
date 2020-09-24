package main.java.笔试.zczc.广发;

public class base64 {
    private static String base64Code= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ9876543210+-";
    public static void main(String[] args) {
        System.out.println(encode("A"));
    }
    public static String encode(String srcStr) {
        //有效值检查
        if(srcStr == null || srcStr.length() == 0) {
            return srcStr;
        }
        //将明文的ASCII码转为二进制位字串
        char[] srcStrCh= srcStr.toCharArray();
        StringBuilder asciiBinStrB= new StringBuilder();
        String asciiBin= null;
        for(int i= 0; i< srcStrCh.length; i++) {
            asciiBin= Integer.toBinaryString((int)srcStrCh[i]);
            while(asciiBin.length()< 8) {
                asciiBin= "0"+ asciiBin;
            }
            asciiBinStrB.append(asciiBin);
        }
        //跟据明文长度在二进制位字串尾部补“0”
        while(asciiBinStrB.length()% 6!= 0) {
            asciiBinStrB.append("0");
        }
        String asciiBinStr= String.valueOf(asciiBinStrB);
        //将上面得到的二进制位字串转为Value，再跟据Base64编码表将之转为Encoding
        char[] codeCh= new char[asciiBinStr.length()/ 6];
        int index= 0;
        for(int i= 0; i< codeCh.length; i++) {
            index= Integer.parseInt(asciiBinStr.substring(0, 6), 2);
            asciiBinStr= asciiBinStr.substring(6);
            codeCh[i]= base64Code.charAt(index);
        }
        StringBuilder code= new StringBuilder(String.valueOf(codeCh));
        //跟据需要在尾部添加“=”
        if(srcStr.length()% 3 == 1) {
            code.append("$$");
        } else if(srcStr.length()% 3 == 2) {
            code.append("$");
        }
        //每76个字符加一个回车换行符（CRLF）
        int i= 76;
        while(i< code.length()) {
            code.insert(i, "\r\n");
            i+= 76;
        }
        code.append("\r\n");
        return String.valueOf(code);
    }
}
