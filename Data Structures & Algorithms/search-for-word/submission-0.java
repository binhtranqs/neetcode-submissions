class Solution {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {

        // Out of bounds
        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length) {
            return false;
        }

        // Wrong character
        if (board[r][c] != word.charAt(index)) {
            return false;
        }

        // We found the entire word
        if (index == word.length() - 1) {
            return true;
        }

        // Mark as visited
        char original = board[r][c];
        board[r][c] = '#';

        // Explore four directions
        boolean found =
                dfs(board, word, r + 1, c, index + 1) ||
                dfs(board, word, r - 1, c, index + 1) ||
                dfs(board, word, r, c + 1, index + 1) ||
                dfs(board, word, r, c - 1, index + 1);

        // Backtrack
        board[r][c] = original;

        return found;
    }
}