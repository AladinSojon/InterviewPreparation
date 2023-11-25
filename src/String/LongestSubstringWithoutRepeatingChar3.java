package String;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar3 {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();

        int result = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char key = s.charAt(right);

            if (charIndexMap.containsKey(key) && charIndexMap.get(key) >= left) {
                left = charIndexMap.get(key) + 1;
            } else {
                result = Math.max(result, right - left + 1);
            }

            charIndexMap.put(key, right);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "abcacbdd";

        System.out.println(lengthOfLongestSubstring(s));
    }
}
