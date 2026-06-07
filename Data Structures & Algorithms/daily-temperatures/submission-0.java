
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currentDay = 0; currentDay < n; currentDay++) {
            while (
                !stack.isEmpty()
                && temperatures[currentDay] > temperatures[stack.peek()]
            ) {
                int previousDay = stack.pop();
                result[previousDay] = currentDay - previousDay;
            }

            stack.push(currentDay);
        }
        return result;
    }
}