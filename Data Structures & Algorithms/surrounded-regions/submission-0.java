
class Solution {
    private int m, n;

    private int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public void solve(char[][] board) {
        if (board.length == 0) return;

        m = board.length;
        n = board[0].length;

        // Duyệt hàng trên và hàng dưới
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        // Duyệt cột trái và cột phải
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        // Khôi phục và capture các vùng
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return;
        }

        if (board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#';

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            dfs(board, nr, nc);
        }
    }
}
