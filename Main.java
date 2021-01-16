package encryptdecrypt;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        var command = scan.nextLine();
        var message = scan.nextLine();
        var key = scan.nextInt();
        switch (command) {
            case "enc":
                System.out.println(encrypt(message, key));
                break;
            case "dec":
                System.out.println(decrypt(message, key));
                break;
        }
    }

    private static String encrypt(String message, int key) {
        return message.codePoints().map(c -> c + key).collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    private static String decrypt(String message, int key) {
        return message.codePoints().map(c -> c - key).collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}
