package exercises;



/**
 * @author zhouwq
 * @date 2020/6/18 9:31
 */

public class IsPalindrome {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     *
     * 输入: "race a car"
     * 输出: false
     */

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        int start = 0;
        s = s.toLowerCase();
        int end = s.length() - 1;
        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if (!Character.isDigit(startChar) && !(startChar >= 'a' && startChar <= 'z')) {
                start++;
                continue;
            }
            if (!Character.isDigit(endChar) && !(endChar >= 'a' && endChar <= 'z')) {
                end--;
                continue;
            }
            if (startChar != endChar) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ss = isPalindrome("");
        System.out.println();
    }
}
