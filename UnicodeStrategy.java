package encryptdecrypt;

public class UnicodeStrategy implements EncDecStrategy {

    @Override
    public String encrypt(String message, int key) {
        return message.codePoints().map(c -> c + key).collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    @Override
    public String decrypt(String message, int key) {
        return message.codePoints().map(c -> c - key).collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}
