package 笔试.jungel.wangyi;

import java.util.*;

public class Main {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 节点数
        int m = scanner.nextInt();
        // 边数
        int n = scanner.nextInt();

        scanner.nextLine();
        TreeNode[] arr =new TreeNode[m+1];

        arr[1] = new TreeNode(1);
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            // 获取父节点
            TreeNode parent = arr[Integer.parseInt(s1[0])];
            // 新建子节点
            arr[Integer.parseInt(s1[2])] = new TreeNode(Integer.parseInt(s1[2]));

            if (s1[1].equals("left")) {
                parent.left = arr[Integer.parseInt(s1[2])];
            }else {
                parent.right = arr[Integer.parseInt(s1[2])];
            }
        }

        System.out.println(getNum(arr[1]));

    }


    private static int getNum(TreeNode root) {

        if (root==null) return 0;

        if (root.left!=null&&root.right!=null&&root.left.left==null&&root.left.right==null
                &&root.right.left==null&&root.right.right==null) {
            return 1;
        }

        int numL = getNum(root.left);
        int numR = getNum(root.right);

        return numL+numR;
    }
}
