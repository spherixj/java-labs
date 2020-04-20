
public class Palindrome {
    public static String reverseString(String str) {
        int i, len = str.length();
        String dest = "";

        for (i = (len - 1); i >= 0; i--) {
            dest += str.charAt(i);
        }

        return dest;
    }

    public static boolean isPalindrome(String str) {
        return str.equals(reverseString(str));
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            String palidText = "";
            if (!isPalindrome(s)) {
                palidText = "not";
            }
            System.out.printf("Word: %s is %s palindrome\n", s, palidText);
        }
    }
}