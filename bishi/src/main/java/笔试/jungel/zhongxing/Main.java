package 笔试.jungel.zhongxing;

import java.util.Scanner;

public class Main {
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

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0; // 访问到空节点了，返回0
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }

    /**
     * 顺序构造二叉排序树
     */
    private  TreeNode getTree(TreeNode root,int target) {

        if (root==null) {
            return new TreeNode(target,null,null);
        }

        if (root.val>target) {
            root.left = getTree(root.left, target);
        }else {
            root.right= getTree(root.right, target);
        }

        return root;
    }

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
        Main main = new Main();
        for (int i = 1; i < n; i++) {

            TreeNode tree = main.getTree(root, arr[i]);
            root = tree;
        }

        int i = new Main().diameterOfBinaryTree(root);
        System.out.println(i);


    }
}
