package leetcodeprep;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    // Time complexity O(n3)
    // replaceFirst uses regex internally which is O(n)
    public boolean isAnagramLoops(String s, String t) {
        if (s.length() == t.length()) {
            int inputLength = s.length();
            int resultLength = 0;

            for (int i = 0; i < t.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (t.charAt(i) == s.charAt(j)) {
                        s = s.replaceFirst(String.valueOf(s.charAt(j)), "");
                        resultLength += 1;
                        break;
                    }
                }
            }

            return resultLength == inputLength;
        }

        return false;
    }

    // Time Complexity O(n)
    public boolean isAnagramHash(String s, String t) {
        if (s.length() == t.length()) {
            Map<Character, Integer> hashS = new HashMap<>();
            Map<Character, Integer> hashT = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                int countT = 1;
                int countS = 1;
                if (hashT.containsKey(t.charAt(i))) {
                    hashT.replace(t.charAt(i), hashT.get(t.charAt(i)) + 1);
                } else {
                    hashT.put(t.charAt(i), countT);
                }

                if (hashS.containsKey(s.charAt(i))) {
                    hashS.replace(s.charAt(i), hashS.get(s.charAt(i)) + 1);
                } else {
                    hashS.put(s.charAt(i), countS);
                }

            }

            return hashS.equals(hashT);
        }

        return false;
    }

    public boolean isAnagramSingleHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) count.put(c, count.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray()) count.put(c, count.getOrDefault(c, 0) - 1);
        for (int v : count.values()) if (v != 0) return false;
        return true;
    }

    // Time Complexity O(n)
    public boolean isAnagramChar(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCounts = new int[26];

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            charCounts[sChars[i] - 'a']++;
            charCounts[tChars[i] - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0)
                return false;
        }

        return true;
    }


    public boolean isAnagramBytes(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] charCounts = new int[26];

        for (byte b : s.getBytes()) charCounts[b - 'a']++;

        for (byte b : t.getBytes()) if (--charCounts[b - 'a'] < 0) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagramLoops("anagram", "nagaram"));
        System.out.println(new ValidAnagram().isAnagramLoops("spider", "redspid"));
        System.out.println(new ValidAnagram().isAnagramLoops("spider", "spider"));

        System.out.println(new ValidAnagram().isAnagramHash("anagram", "nagaram"));
        System.out.println(new ValidAnagram().isAnagramHash("spider", "redspid"));
        System.out.println(new ValidAnagram().isAnagramHash("spider", "spider"));

        System.out.println(new ValidAnagram().isAnagramChar("anagram", "nagaram"));
        System.out.println(new ValidAnagram().isAnagramChar("spider", "redspid"));
        System.out.println(new ValidAnagram().isAnagramChar("ggii", "eekk"));

        System.out.println(new ValidAnagram().isAnagramSingleHashMap("anagram", "nagaram"));
        System.out.println(new ValidAnagram().isAnagramSingleHashMap("spider", "redspid"));
        System.out.println(new ValidAnagram().isAnagramSingleHashMap("ggii", "eekk"));

        System.out.println(new ValidAnagram().isAnagramBytes("anagram", "nagaram"));
        System.out.println(new ValidAnagram().isAnagramBytes("spider", "redspid"));
        System.out.println(new ValidAnagram().isAnagramBytes("ggii", "eekk"));
    }
}
