package assign2;

import assign2.Encryptable;

/**
 The Encryptor class provides methods for encrypting and decrypting text using a Caesar cipher.
 */
public class Encryptor implements Encryptable {

    private int offset;

    /**
     Constructs a new Encryptor object with the specified offset.
     @param offset the offset to use in the Caesar cipher
     @throws IllegalArgumentException if the offset is not between 1 and 25 (both inclusive)
     */
    public Encryptor(int offset) {
        if (offset >= 0 && offset <= 26) {
            this.offset = offset;
        } else {
            throw new IllegalArgumentException("Offset should be between 1 and 25 (both inclusive).");
        }
    }

    /**
     Sets the offset to use in the Caesar cipher.
     @param offset the new offset to use
     @throws IllegalArgumentException if the offset is not between 1 and 25 (both inclusive)
     */
    public void setOffset(int offset) {
        if (offset >= 0 && offset <= 26) {
            this.offset = offset;
        } else {
            throw new IllegalArgumentException("Offset should be between 1 and 25 (both inclusive).");
        }
    }

    /**
     Encrypts the plaintext using a Caesar cipher with the specified offset.
     @param plaintext the text to encrypt
     @return the encrypted text
     */
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

    /**
     Decrypts the encrypted text using a Caesar cipher with the specified offset.
     @param encryptedText the text to decrypt
     @return the decrypted text
     */
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
