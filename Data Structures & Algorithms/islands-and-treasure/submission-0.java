
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        // Step 1: Add all treasures to queue
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        // Step 2: Four directions
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Step 3: Multi-source BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            int row = cell[0];
            int col = cell[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries
                if (newRow < 0 || newRow >= rows ||
                    newCol < 0 || newCol >= cols) {
                    continue;
                }

                // Only visit unvisited land
                if (grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }

                // Update shortest distance
                grid[newRow][newCol] = grid[row][col] + 1;

                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}
