package main.java.笔试.zczc;

class TreeNode{
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


public class erchapaixu {

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
}
