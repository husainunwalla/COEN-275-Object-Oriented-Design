package assign2;

/**
 The Encryptable interface provides methods for encrypting and decrypting text.
 */
public interface Encryptable {

    /**
     Encrypts the plaintext using a specific algorithm.
     @param plaintext the text to encrypt
     @return the encrypted text
     */
    String encrypt(String text);

    /**
     Decrypts the encrypted text using a specific algorithm.
     @param encryptedText the text to decrypt
     @return the decrypted text
     */
    String decrypt(String text);
}
