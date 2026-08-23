package leetcodeprep;

public class ReverseString {
    public void reverseString(char[] s) {
        int right = s.length - 1;
        int left = 0;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        new ReverseString().reverseString(new char[]{'H', 'e', 'l', 'l', 'o'});
        new ReverseString().reverseString(new char[]{'H', 'a', 'n', 'n', 'a', 'h'});
    }
}
