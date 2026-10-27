class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLen = 0;

        HashMap <Character, Integer> map = new HashMap<>();


        for(int i = 0; i< s.length(); i++){
            char currChar = s.charAt(i);

            if(map.containsKey(currChar)){
                start = Math.max(start, map.get(currChar)+1);
            }

            map.put(currChar, i);

            maxLen = Math.max(maxLen, i-start+1);

        }
        return maxLen;
    }
}