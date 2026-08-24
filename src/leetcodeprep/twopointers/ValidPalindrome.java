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

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
        System.out.println(new ValidPalindrome().isPalindrome(" "));

    }
}
