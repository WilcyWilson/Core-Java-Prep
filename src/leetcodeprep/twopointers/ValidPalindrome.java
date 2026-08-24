package leetcodeprep.twopointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !((s.charAt(left) >= '0' && s.charAt(left) <= '9')
                    || (s.charAt(left) >= 'a' && s.charAt(left) <= 'z')
                    || (s.charAt(left) >= 'A' && s.charAt(left) <= 'Z'))) {
                left++;
            }
            while (left < right && !((s.charAt(right) >= '0' && s.charAt(right) <= '9')
                    || (s.charAt(right) >= 'a' && s.charAt(right) <= 'z')
                    || (s.charAt(right) >= 'A' && s.charAt(right) <= 'Z'))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindromeUsingCharacter(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (Character.isLetterOrDigit(s.charAt(left)) && Character.isLetterOrDigit(s.charAt(right))) {
                if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            } else {
                if (!Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                }
                if (!Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }
            }
        }
        return true;
    }

    // Double While loop doesn't automatically mean O(n^2) Time complexity. The inner while are just fast forwarding the same pointer values, not restarting from scratch
    // Like with other nested loops
    public boolean isPalindromeDoubleWhile(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
        System.out.println(new ValidPalindrome().isPalindrome(" "));
        System.out.println(new ValidPalindrome().isPalindrome("0P"));

        System.out.println();
        System.out.println(new ValidPalindrome().isPalindromeUsingCharacter("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindromeUsingCharacter("race a car"));
        System.out.println(new ValidPalindrome().isPalindromeUsingCharacter(" "));

        System.out.println();
        System.out.println(new ValidPalindrome().isPalindromeDoubleWhile("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindromeDoubleWhile("race a car"));
        System.out.println(new ValidPalindrome().isPalindromeDoubleWhile(" "));
    }
}
