package encryptdecrypt;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        var message = scan.nextLine();
        var key = scan.nextInt();
        System.out.println(encrypt(message, key));
    }

    private static String encrypt(String message, int key) {
        var sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c <= 'z' && c >= 'a') {
                char newChar = (char) (c + key);
                newChar = newChar < 'a' ? (char) (newChar + 26) :
                        newChar > 'z' ? (char) (newChar - 26) : newChar;
                sb.append(newChar);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
