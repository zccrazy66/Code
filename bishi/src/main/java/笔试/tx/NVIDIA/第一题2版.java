package main.java.笔试.tx.NVIDIA;

import java.util.Scanner;

/**
 * @author xin Tan
 * @create 2020-09-07 20:12
 */
public class 第一题2版 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(solve(input));
        }
        scanner.close();
    }

    private static String solve(String input) {

        if (input.contains("joker") || input.contains("JOKER")) {
            return "ERROR";
        }

        String[] parts = input.split("(\\s)+");

        if (parts.length != 4) {
            return "ERROR";
        }

        // 将牌转换成数字
        int[] ints = new int[parts.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = convert(parts[i]);
        }

        String[] r = {""};
        boolean result = point24(ints, r);

        // 有结果
        if (result) {
            return r[0];
        }

        return "NONE";
    }

    /**
     * 4个[1, 13]的能否通过加减乘除，得到数字为24
     *
     * @param opd 四个元素的数组
     * @param r   用于保存结果
     * @return true，可以组成24，false不可以组成24
     */
    private static boolean point24(int[] opd, String[] r) {

        char[] opt = new char[opd.length - 1];
        char[] all = {'+', '-', '*', '/'};
        return point24(opd, opt, all, 0, r);
    }

    /**
     * @param opd 操作数
     * @param opt 用于计算的操作符
     * @param all 可以使用的全部操作符
     * @param n   当前处理的数
     * @param r   用于保存表达式结果
     * @return true，计算的值为24，false，计算的值不是24
     */
    private static boolean point24(int[] opd, char[] opt, char[] all, int n, String[] r) {
        // 处理最后一个数字
        if (n == opd.length - 1) {
            if (calculate(opd, opt, r)) {
                return true;
            }
        } else {
            for (int i = n; i < opd.length; i++) {
                int temp = opd[n];
                opd[n] = opd[i];
                opd[i] = temp;
                for (char a : all) {
                    opt[n] = a;
                    boolean find = point24(opd, opt, all, n + 1, r);
                    if (find) {
                        return true;
                    }
                }

                //  现场还原
                temp = opd[n];
                opd[n] = opd[i];
                opd[i] = temp;
            }
        }
        return false;
    }

    /**
     * 计算值
     *
     * @param opd 操作数
     * @param opt 操作符
     * @param r   保存结果表达式
     * @return true，结果为24，false结果不是24
     */
    private static boolean calculate(int[] opd, char[] opt, String[] r) {

        double v = opd[0];
        for (int i = 0; i < opt.length; i++) {
            v = calculate(v, opd[i + 1], opt[i]);
        }

        boolean eq = Math.abs(v - 24) < 0.0000001;

        if (eq) {
            r[0] = convert(opd[0]);
            for (int i = 0; i < opt.length; i++) {
                r[0] = r[0] + opt[i] + convert(opd[i + 1]);
            }
        }

        return eq;
    }

    /**
     * 将牌转换成对应的数值
     *
     * @param s 牌
     * @return 数值
     */
    private static int convert(String s) {

        if (s.length() == 1) {
            char c = s.charAt(0);
            if (c >= '2' && c <= '9') {
                return c - '0';
            }

            switch (c) {
                case 'J':
                    return 11;
                case 'Q':
                    return 12;
                case 'K':
                    return 13;
                case 'A':
                    return 1;
                default:
            }

        } else {
            switch (s) {
                case "10":
                    return 10;
                default:
            }
        }

        throw new RuntimeException("参数错误：" + s + "，只能输入[2, 10]、J、Q、K、A");
    }

    /**
     * 将数值转换成牌
     *
     * @param i 数值
     * @return 牌
     */
    private static String convert(int i) {
        if (i >= 2 && i <= 10) {
            return "" + i;
        }

        switch (i) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
        }
        throw new RuntimeException("参数错误:" + i + "，牌值[1, 13]的整数");
    }

    /**
     * 表达式求值
     *
     * @param a   操作数一
     * @param b   操作数二
     * @param opt 操作符
     * @return 运算结果
     */
    private static double calculate(double a, double b, int opt) {
        switch (opt) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
        }

        throw new RuntimeException("参数错误：" + ((char) opt) + "计算操作只支持加(+)、减(-)、*(乘)、除(、)");
    }
}
