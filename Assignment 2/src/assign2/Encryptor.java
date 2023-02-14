package assign2;

import assign2.Encryptable;

public class Encryptor implements Encryptable {

    private int offset;

    public Encryptor(int offset) {
        if (offset > 0 && offset < 26) {
            this.offset = offset;
        } else {
            throw new IllegalArgumentException("Offset should be between 1 and 25 (both exclusive).");
        }
    }

    public void setOffset(int offset) {
        if (offset > 0 && offset < 26) {
            this.offset = offset;
        } else {
            throw new IllegalArgumentException("Offset should be between 1 and 25 (both exclusive).");
        }
    }

    @Override
    public String encrypt(String plaintext) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (Character.isAlphabetic(c)) {
                int base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) (((c - base + offset) % 26) + base);
            }
            result.append(c);
        }
        return result.toString();
    }

    @Override
    public String decrypt(String encryptedText) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char c = encryptedText.charAt(i);
            if (Character.isAlphabetic(c)) {
                int base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) (((c - base + (26 - offset)) % 26) + base);
            }
            result.append(c);
        }
        return result.toString();
    }
}
