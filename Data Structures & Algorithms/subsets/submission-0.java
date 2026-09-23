class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(nums, 0, subset, result);

        return result;
    }

    private void backtrack(
        int[] nums,
        int i,
        List<Integer> subset,
        List<List<Integer>> result
    ) {

        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // Chọn nums[i]
        subset.add(nums[i]);
        backtrack(nums, i + 1, subset, result);

        // Bỏ nums[i]
        subset.remove(subset.size() - 1);
        backtrack(nums, i + 1, subset, result);
    }
}