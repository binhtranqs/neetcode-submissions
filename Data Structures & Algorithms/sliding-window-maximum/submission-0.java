

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        int resultIndex = 0;

        for (int i = 0; i < n; i++) {
            maxHeap.add(new int[]{nums[i], i});

            int left = i - k + 1;
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] < left) {
                maxHeap.poll();
            }
            if (i >= k - 1) {
                result[resultIndex] = maxHeap.peek()[0];
                resultIndex++;
            }
        }

        return result;
    }
}