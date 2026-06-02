class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] need = new int[128];
        int[] window = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int left = 0;
        int matched = 0;
        int bestStart = 0;
        int bestLength = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            window[rightChar]++;
            if (window[rightChar] <= need[rightChar]) {
                matched++;
            }

            while (matched == t.length()) {
                int currentLength = right - left + 1;

                if (currentLength < bestLength) {
                    bestLength = currentLength;
                    bestStart = left;
                }
                char leftChar = s.charAt(left);
                window[leftChar]--;

                if (window[leftChar] < need[leftChar]) {
                    matched--;
                }
                left++;
            }
        }
        if (bestLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(bestStart, bestStart + bestLength);
    }
}