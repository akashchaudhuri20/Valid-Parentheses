/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if -
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Example 1
 * Input: s = "()"
 * Output: true
 *
 * Example 2
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3
 * Input: s = "(]"
 * Output: false
 */

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()";
        System.out.println(hasValidParentheses(s));
    }

    private static boolean hasValidParentheses(String s) {
        Stack stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    char popped = (char) stack.pop();
                    switch (ch) {
                        case ')':
                            if (popped != '(')
                                return false;
                            break;
                        case '}':
                            if (popped != '{')
                                return false;
                            break;
                        case ']':
                            if (popped != '[')
                                return false;
                            break;
                        default:
                            return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
