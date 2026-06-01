class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int windowSize = s1.length();
        int[] result = new int[26];
        int[] windowCount = new int[26];
        for(int i=0;i<s1.length();i++){
            result[s1.charAt(i)-'a']++;
        }
        for(int j=0;j<s2.length();j++){
            windowCount[s2.charAt(j)-'a']++;
            if(j>=windowSize){
                char leftChar = s2.charAt(j-windowSize);
                windowCount[leftChar-'a']--;
            }
            if(j>=windowSize-1 && java.util.Arrays.equals(result,windowCount)){
                return true;
            } 

        }
        return false;
    }
}
