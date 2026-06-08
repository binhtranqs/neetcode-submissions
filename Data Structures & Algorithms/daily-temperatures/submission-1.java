
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      int n =temperatures.length;
      Deque<Integer> stack = new ArrayDeque<>();
      int[] result = new int[n];
    
      for (int currentIndex =0; currentIndex<n; currentIndex++){
        while(!stack.isEmpty() && temperatures[currentIndex]> temperatures[stack.peek()]){
              int previousIndex = stack.pop();
              result[previousIndex]= currentIndex- previousIndex;
        }
        stack.push(currentIndex);
      }
      return result;
    }
}