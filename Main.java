package encryptdecrypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class Main {
    private static String mode = "enc";
    private static int key = 0;
    private static String data = "";
    private static Path in;
    private static Path out;

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (i + 1 < args.length) {
                try {
                    switch (args[i]) {
                        case "-mode":
                            mode = args[i + 1];
                            break;
                        case "-key":
                            if (!args[i + 1].matches("[0-9]+")) {
                                System.out.println("Error, key argument is not a valid number");
                                return;
                            }
                            key = Integer.parseInt(args[i + 1]);
                            break;
                        case "-data":
                            data = args[i + 1];
                            break;
                        case "-in":
                            in = Path.of(args[i + 1]);
                            break;
                        case "-out":
                            out = Path.of(args[i + 1]);
                            break;
                    }
                } catch (InvalidPathException e) {
                    System.out.println("Error, invalid path given");
                    e.printStackTrace();
                    return;
                }
            }
        }
        String result = "";
        try {
            if (in != null && data.equals("")) {
                data = Files.lines(in).reduce("", (s, s2) -> s + s2);
                switch (mode) {
                    case "enc":
                        result = encrypt(data, key);
                        break;
                    case "dec":
                        result = decrypt(data, key);
                        break;
                }

                if (out != null) {
                    Files.writeString(out, result);
                } else {
                    System.out.println(result);
                }
            }
        } catch (IOException e) {
            System.out.println("Error while opening a file");
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
