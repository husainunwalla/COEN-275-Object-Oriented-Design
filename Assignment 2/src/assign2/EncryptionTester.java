package assign2;
import java.util.Random;

/**
 The EncryptionTester class contains methods to test the Encryptor class by encrypting and decrypting test strings.
 */
public class EncryptionTester {

    /**
     Tests the Encryptor class with a set of pre-defined plaintexts and offsets.
     Prints the plaintext, offset, encrypted text, and decrypted text for each test.
     */
    public static void testSet1() {
        String[] plaintexts = {
                "abcdefghijklmnopqrstuvwxyz",
                "John D. Doe",
                "Xray defraction",
                "Zebra-tailed lizard",
                "Walkie-talkie",
                "COEN 275 OO Analysis, Design and Programming"
        };

        int[] offsets = {0, 3, 11, 25, 25};

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

    /**
     Tests the Encryptor class with randomly generated offsets.
     Prints the test string, encrypted text, and decrypted text for each test.
     */
    public static void testSet2() {
        // Generate 4 random numbers between 1 and 25 for the offset values
        Random rand = new Random();
        int offset1 = rand.nextInt(27);
        int offset2 = rand.nextInt(27);
        int offset3 = rand.nextInt(27);
        int offset4 = rand.nextInt(27);

        // Create an instance of Encryptor and set the offset to the random values
        Encryptor encryptor = new Encryptor(offset1);
        String text1 = "This is a test string for encryption and decryption!";
        String encryptedText1 = encryptor.encrypt(text1);
        String decryptedText1 = encryptor.decrypt(encryptedText1);
        System.out.println("Test String 1: " + text1);
        System.out.println("Encrypted Text 1: " + encryptedText1);
        System.out.println("Decrypted Text 1: " + decryptedText1);

        encryptor.setOffset(offset2);
        String text2 = "Java is a popular programming language.";
        String encryptedText2 = encryptor.encrypt(text2);
        String decryptedText2 = encryptor.decrypt(encryptedText2);
        System.out.println("Test String 2: " + text2);
        System.out.println("Encrypted Text 2: " + encryptedText2);
        System.out.println("Decrypted Text 2: " + decryptedText2);

        encryptor.setOffset(offset3);
        String text3 = "The quick brown fox jumps over the lazy dog.";
        String encryptedText3 = encryptor.encrypt(text3);
        String decryptedText3 = encryptor.decrypt(encryptedText3);
        System.out.println("Test String 3: " + text3);
        System.out.println("Encrypted Text 3: " + encryptedText3);
        System.out.println("Decrypted Text 3: " + decryptedText3);

        encryptor.setOffset(offset4);
        String text4 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
        String encryptedText4 = encryptor.encrypt(text4);
        String decryptedText4 = encryptor.decrypt(encryptedText4);
        System.out.println("Test String 4: " + text4);
        System.out.println("Encrypted Text 4: " + encryptedText4);
        System.out.println("Decrypted Text 4: " + decryptedText4);
    }

    public static void main(String[] args) {
        EncryptionTester.testSet1();
        EncryptionTester.testSet2();
    }

}