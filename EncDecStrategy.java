package encryptdecrypt;

public interface EncDecStrategy {
    String encrypt(String data, int key);
    String decrypt(String data, int key);
}
