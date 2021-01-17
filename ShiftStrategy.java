package encryptdecrypt;

public class ShiftStrategy implements EncDecStrategy {
    @Override
    public String encrypt(String data, int key) {
        var sb = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (c <= 'z' && c >= 'a') {
                char newChar = (char) (c + key);
                newChar = newChar < 'a' ? (char) (newChar + 26) :
                        newChar > 'z' ? (char) (newChar - 26) : newChar;
                sb.append(newChar);
            } else if (c <= 'Z' && c >= 'A') {
                char newChar = (char) (c + key);
                newChar = newChar < 'A' ? (char) (newChar + 26) :
                        newChar > 'Z' ? (char) (newChar - 26) : newChar;
                sb.append(newChar);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String data, int key) {
        var sb = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (c <= 'z' && c >= 'a') {
                char newChar = (char) (c - key);
                newChar = newChar < 'a' ? (char) (newChar + 26) :
                        newChar > 'z' ? (char) (newChar - 26) : newChar;
                sb.append(newChar);
            } else if (c <= 'Z' && c >= 'A') {
                char newChar = (char) (c - key);
                newChar = newChar < 'A' ? (char) (newChar + 26) :
                        newChar > 'Z' ? (char) (newChar - 26) : newChar;
                sb.append(newChar);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
