
class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        int minutes = 0;

        // Step 1: Find all rotten and fresh fruits
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
        };

        // Step 2: BFS
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow < 0 || newRow >= rows ||
                        newCol < 0 || newCol >= cols ||
                        grid[newRow][newCol] != 1) {
                        continue;
                    }

                    grid[newRow][newCol] = 2;
                    fresh--;
                    queue.offer(new int[]{newRow, newCol});
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
