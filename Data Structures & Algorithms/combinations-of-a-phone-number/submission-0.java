class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] letters = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        StringBuilder path = new StringBuilder();

        backtrack(digits, 0, letters, path, result);

        return result;
    }

    private void backtrack(
        String digits,
        int index,
        String[] letters,
        StringBuilder path,
        List<String> result
    ) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String current = letters[digits.charAt(index) - '0'];

        for (char c : current.toCharArray()) {
            path.append(c);

            backtrack(digits, index + 1, letters, path, result);

            path.deleteCharAt(path.length() - 1);
        }
    }
}