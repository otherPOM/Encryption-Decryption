package encryptdecrypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class Main {
    private static String alg = "shift";
    private static String mode = "enc";
    private static int key = 0;
    private static String data = "";
    private static Path in;
    private static Path out;

    public static void main(String[] args) {

        // Parsing arguments
        for (int i = 0; i < args.length; i++) {
            if (i + 1 < args.length) {
                try {
                    switch (args[i]) {
                        case "-alg":
                            alg = args[i + 1];
                            break;
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

        // Setting strategy
        var context = new Context();
        switch (alg) {
            case "shift":
                context.setStrategy(new ShiftStrategy());
                break;
            case "unicode":
                context.setStrategy(new UnicodeStrategy());
                break;
        }

        // Getting data from a file if needed
        try {
            if (in != null && data.equals("")) {
                data = Files.lines(in).reduce("", (s, s2) -> s + s2);
            }
        } catch (IOException e) {
            System.out.println("Error while opening a file");
            e.printStackTrace();
            return;
        }

        // Executing enc/dec
        String result = "";
        switch (mode) {
            case "enc":
                result = context.encrypt(data, key);
                break;
            case "dec":
                result = context.decrypt(data, key);
                break;
        }

        // Writing result to a file or console
        if (out != null) {
            try {
                Files.writeString(out, result);
            } catch (IOException e) {
                System.out.println("Error while opening a file");
                e.printStackTrace();
                return;
            }
        } else {
            System.out.println(result);
        }
    }
}
