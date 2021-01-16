package encryptdecrypt;

public class Main {
    private static String mode = "enc";
    private static int key = 0;
    private static String data = "";

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (i + 1 < args.length) {
                switch (args[i]) {
                    case "-mode":
                        mode = args[i + 1];
                        break;
                    case "-key":
                        key = Integer.parseInt(args[i + 1]);
                        break;
                    case "-data":
                        data = args[i + 1];
                        break;
                }
            }
        }
        switch (mode) {
            case "enc":
                System.out.println(encrypt(data, key));
                break;
            case "dec":
                System.out.println(decrypt(data, key));
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
