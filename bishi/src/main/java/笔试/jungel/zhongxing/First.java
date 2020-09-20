package 笔试.jungel.zhongxing;


import java.util.Scanner;

// 7
// 5 3 2 1 6 7 4
public class First {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int maxLen;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        if (n==1) {
            System.out.println(1);
            return;
        }
        TreeNode root = new TreeNode(arr[0], null, null);
        for (int i = 1; i < n; i++) {

            TreeNode tree = getTree(root, arr[i]);
            root = tree;
        }

        getLen(root);
        System.out.println(maxLen);

    }

    private static int getLen(TreeNode root) {

        if (root==null) return 0;
        if (root.left==null&&root.right==null) return 1;
        int left = getLen(root.left);
        int right = getLen(root.right);
        int temp = left + right+1;
        maxLen = Math.max(temp,maxLen);
        return Math.max(left,right)+1;
    }

    /**
     * 顺序构造二叉排序树
     */
    private static TreeNode getTree(TreeNode root,int target) {

        if (root==null) {
            return new TreeNode(target,null,null);
        }

        if (root.val>=target) {
            root.left = getTree(root.left, target);
        }else {
            root.right= getTree(root.right, target);
        }

        return root;
    }
}
