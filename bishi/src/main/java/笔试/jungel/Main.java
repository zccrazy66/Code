package 笔试.jungel;

import java.util.*;



public class Main {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){

        }

        TreeNode(int value){
            this.val = value;
            this.left = null;
            this.right = null;
        }

        TreeNode(int value, TreeNode left, TreeNode right){
            this.val = value;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode buildBST(int[] data){
        //建立二叉排序树
        //假设data中的数字是互不相同的
        TreeNode root = new TreeNode(data[0]);
        for(int i = 1; i < data.length; i++){
            insert(root, data[i]);
        }

        return root;
    }

    private static TreeNode insert(TreeNode root, int value) {
        //二叉排序树插入节点
        if(root == null){
            root = new TreeNode(value);
        }else{
            if(value <= root.val){
                //插入到左子树
                root.left = insert(root.left, value);
            }else{
                //插入到右子树
                root.right = insert(root.right, value);
            }
        }
        return root;
    }

    private static int maxLen;
    private static int getLen(TreeNode root) {

        if (root==null) return 0;
        if (root.left==null&&root.right==null) return 1;
        int left = getLen(root.left);
        int right = getLen(root.right);
        int temp = left + right+1;
        maxLen = Math.max(temp,maxLen);
        return Math.max(left,right)+1;
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
        TreeNode root = buildBST(arr);

        int len = getLen(root);
        System.out.println(len);


    }
}
