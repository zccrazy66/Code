package meituan.jungel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 编程协议
 */
public class ByteDance01 {

    /**
     * 树私有类
     */
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 重构树
     * @param pre
     * @param tin
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre,int[] tin) {
        if (pre.length == 0 || tin.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 找到 第一个元素在 tin 中的位置
        int i = getIndex(tin, pre[0]);
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(tin, 0, i));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(tin, i+1, tin.length));
        return root;
    }
    private int getIndex(int[] array, int value){
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == value){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 输入根节点返回叶子节点个数
     */

    private int yeziNum(TreeNode root) {
        if (root!=null) {
            int l = yeziNum(root.left);
            int r = yeziNum(root.right);
            if (l==0&&r==0){
                return 1;
            }else {
                return l+r;
            }

        }else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        for (int j = 0; j < n; j++) {
            arr2[j] = scanner.nextInt();
        }
        ByteDance01 byteDance01 = new ByteDance01();
        TreeNode treeNode = byteDance01.reConstructBinaryTree(arr1, arr2);
        System.out.println(byteDance01.yeziNum(treeNode));
    }

}
