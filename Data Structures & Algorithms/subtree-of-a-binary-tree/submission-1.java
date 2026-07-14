class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        // Kiểm tra cây bắt đầu tại root có giống subRoot không
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Tìm tiếp ở cây con bên trái và bên phải
        return isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        // Cả hai đều null: giống nhau
        if (a == null && b == null) {
            return true;
        }

        // Chỉ một cây null: khác nhau
        if (a == null || b == null) {
            return false;
        }

        // Giá trị khác nhau
        if (a.val != b.val) {
            return false;
        }

        // Hai cây con trái và phải cũng phải giống nhau
        return isSameTree(a.left, b.left)
            && isSameTree(a.right, b.right);
    }
}