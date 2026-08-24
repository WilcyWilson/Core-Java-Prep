package leetcodeprep.twopointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));
            boolean isLeftAlphanumeric = (leftChar >= '0' && leftChar <= '9')
                    || (leftChar >= 'a' && leftChar <= 'z')
                    || (leftChar >= 'A' && leftChar <= 'Z');
            boolean isRightAlphanumeric = (rightChar >= '0' && rightChar <= '9')
                    || (rightChar >= 'a' && rightChar <= 'z')
                    || (rightChar >= 'A' && rightChar <= 'Z');
            if (isLeftAlphanumeric && isRightAlphanumeric) {
                if (leftChar == rightChar) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            } else {
                if (!isLeftAlphanumeric) {
                    left++;
                }
                if (!isRightAlphanumeric) {
                    right--;
                }
            }
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
