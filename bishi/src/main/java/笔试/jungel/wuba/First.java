package 笔试.jungel.wuba;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

public class First {

    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public  TreeNode createTreeNode(int[] array){
        TreeNode root = createTreeNode(array, 1);
        return root;
    }

    private  TreeNode createTreeNode(int[] array, int index) {
        if(index > array.length){
            return null;
        }
        int value = array[index - 1];
        if(value == -1){
            return null;
        }
        TreeNode node = new TreeNode(value);
        node.left = createTreeNode(array, index * 2);
        node.right = createTreeNode(array, index * 2 + 1);
        return node;
    }

    /**
     * 前序遍历
     * @param root
     */
    private void preOrderTraverse(TreeNode root) {
        if (root != null) {
            prelist.add(root.val);
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    private void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            inlist.add(root.val);
            inOrderTraverse(root.right);
        }
    }

    private void postOrderTraverse(TreeNode root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            postlist.add(root.val);
        }
    }

    private  ArrayList<Integer> prelist;
    private  ArrayList<Integer> inlist;
    private  ArrayList<Integer> postlist;
    public ArrayList<ArrayList<Integer>> binaryTreeScan(int[] input) {

        TreeNode treeNode = createTreeNode(input);
        prelist=new ArrayList<>();
        inlist=new ArrayList<>();
        postlist=new ArrayList<>();

        ArrayList<ArrayList<Integer>> res =new ArrayList<>();
        preOrderTraverse(treeNode);
        inOrderTraverse(treeNode);
        postOrderTraverse(treeNode);
        res.add(prelist);
        res.add(inlist);
        res.add(postlist);
        return res;
    }


//    public static void main(String[] args) {
//
//        First first = new First();
//        int[] arr ={1,7,2,6,-1,4,8};
//        System.out.println(JSON.toJSONString(first.binaryTreeScan(arr)));
//    }
}
