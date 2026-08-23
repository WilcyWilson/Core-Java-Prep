package leetcodeprep.twopointers;

import java.util.Stack;

public class ReverseString {
    public void reverseString(char[] s) {
        int right = s.length - 1, left = 0;
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

    public void reverseStringStack(char[] s) {
        Stack<Character> characterStack = new Stack<>();
        for (char c : s) {
            characterStack.push(c);
        }

        // LIFO Reverses the string
        for (int i = 0; i < s.length; i++) {
            s[i] = characterStack.pop();
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        new ReverseString().reverseString(new char[]{'H', 'e', 'l', 'l', 'o'});
        new ReverseString().reverseString(new char[]{'H', 'a', 'n', 'n', 'a', 'h'});
        new ReverseString().reverseStringStack(new char[]{'H', 'e', 'l', 'l', 'o'});
        new ReverseString().reverseStringStack(new char[]{'H', 'a', 'n', 'n', 'a', 'h'});
    }
}
