public class Main {

    public static void main(String[] args) {
        for (String p : args){
            if (isPalindrome(p)) {
                System.out.println(p + " True");
            } else {
                System.out.println(p + " False");
            }
        }
    }
    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--){
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    public static boolean isPalindrome(String p){
        String reversed = reverseString(p);
        return p.equals(reversed);
    }
}