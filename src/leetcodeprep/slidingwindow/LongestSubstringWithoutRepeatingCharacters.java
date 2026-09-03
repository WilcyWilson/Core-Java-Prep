package leetcodeprep.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstringForEach(String s) {
        Set<Character> substring = new HashSet<>();
        int longestSubstring = 0;
        int left = 0;
        for (Character c : s.toCharArray()) {
            while (substring.contains(c)) {
                substring.remove(s.charAt(left++));
            }
            substring.add(c);
            longestSubstring = Math.max(longestSubstring, substring.size());
        }
        return longestSubstring;
    }

    public int lengthOfLongestSubstringHashMap(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int maximumLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            if (seen.containsKey(s.charAt(end))) {
                start = Math.max(start, seen.get(s.charAt(end)) + 1);
            }
            seen.put(s.charAt(end), end);
            maximumLength = Math.max(maximumLength, end - start + 1);
        }
        return maximumLength;
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxlen = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left++));
            }
            set.add(ch);
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringHashMap("cdcda")); // 3

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringForEach("1R1T7")); // 4

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringForEach("!S``PW")); //3


        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringForEach("abcabcbb")); //3
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringForEach("bbbbb")); //1
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringForEach("pwwkew"));//3

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("cdcda")); // 3

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("1R1T7")); // 4

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("!S``PW")); //3


        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb")); //1
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));//3
    }
}
