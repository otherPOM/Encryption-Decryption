package encryptdecrypt;

public class Context {
    private EncDecStrategy strategy;

    public void setStrategy(EncDecStrategy strategy) {
        this.strategy = strategy;
    }

    public String encrypt(String data, int key) {
        return strategy.encrypt(data, key);
    }
    public String decrypt(String data, int key) {
        return strategy.decrypt(data, key);
    }
}
