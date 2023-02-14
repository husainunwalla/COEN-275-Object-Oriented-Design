package assign2;
import java.util.Random;

public class EncryptionTester {

    public static void testSet1() {
        String[] plaintexts = {
                "abcdefghijklmnopqrstuvwxyz",
                "John D. Doe",
                "Xray defraction",
                "Zebra-tailed lizard",
                "Walkie-talkie",
                "COEN 275 OO Analysis, Design and Programming"
        };

        int[] offsets = {0, 3, 11, 25, 26};

        for (String plaintext : plaintexts) {
            for (int offset : offsets) {
                Encryptor encryptor = new Encryptor(offset);
                String encryptedText = encryptor.encrypt(plaintext);
                String decryptedText = encryptor.decrypt(encryptedText);

                System.out.println("Plaintext: " + plaintext);
                System.out.println("Offset: " + offset);
                System.out.println("Encrypted text: " + encryptedText);
                System.out.println("Decrypted text: " + decryptedText);
                System.out.println();
            }
        }
    }
}