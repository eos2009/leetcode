package com.chenfei.leetcode.tree;

import com.chenfei.leetcode.utils.JsonUtil;

/**
 * 根据前序遍历和中序遍历生成二叉树
 *
 * @author chenfei
 * @since 2020/5/22
 */
public class BuildTree {

    public static void main(String[] args) {
        // 前序遍历
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        // 中序遍历
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        BuildTree buildTree = new BuildTree();

        System.out.println(JsonUtil.toString(buildTree.build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1)));
    }

    /**
     * 递归生成树
     * @param preorder  前序遍历
     * @param pStart    起始位置
     * @param pEnd      结束位置
     * @param inorder   中序遍历
     * @param iStart    起始位置
     * @param iEnd      结束位置
     * @return  生成结果树
     */
    private TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[pStart]);
        int index = 0;
        while (inorder[iStart + index] != preorder[pStart]) {
            index++;
        }
        rootNode.left = build(preorder, pStart + 1, pStart + index, inorder, iStart, iStart+index - 1);
        rootNode.right = build(preorder, pStart + index+1, pEnd, inorder, iStart+index + 1, iEnd);
        return rootNode;
    }

    class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
