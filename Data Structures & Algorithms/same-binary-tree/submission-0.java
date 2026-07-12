class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Cả hai đều null
        if (p == null && q == null) {
            return true;
        }

        // Một trong hai null
        if (p == null || q == null) {
            return false;
        }

        // Giá trị khác nhau
        if (p.val != q.val) {
            return false;
        }

        // So sánh cả cây con trái và cây con phải
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}