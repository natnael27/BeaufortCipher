public class BeaufortCipher {
   
    public static String beaufortEncrypt(String plainText, String key) {
        StringBuilder cipherText = new StringBuilder();
        int keyIndex = 0;

        for (char plainChar : plainText.toCharArray()) {
            
            if (Character.isLetter(plainChar)) {
                char keyChar = key.charAt(keyIndex);
                int shift = Character.toUpperCase(keyChar) - 'A';
                char encryptedChar = (char) ((shift + Character.toUpperCase(plainChar) - 'A') % 26 + 'A');

                if (Character.isLowerCase(plainChar)) {
                    cipherText.append(Character.toLowerCase(encryptedChar));
                } 
                else {
                    cipherText.append(encryptedChar);
                }

                keyIndex = (keyIndex + 1) % key.length();
            } 
            else {
                cipherText.append(plainChar);
            }
        }

        return cipherText.toString();
    }

    public static String beaufortDecrypt(String cipherText, String key) {
        StringBuilder plainText = new StringBuilder();
        int keyIndex = 0;

        for (char cipherChar : cipherText.toCharArray()) {
            
            if (Character.isLetter(cipherChar)) {
                char keyChar = key.charAt(keyIndex);
                int shift = Character.toUpperCase(keyChar) - 'A';
                char decryptedChar = (char) ((26 + Character.toUpperCase(cipherChar) - 'A' - shift) % 26 + 'A');

                if (Character.isLowerCase(cipherChar)) {
                    plainText.append(Character.toLowerCase(decryptedChar));
                } 
                else {
                    plainText.append(decryptedChar);
                }

                keyIndex = (keyIndex + 1) % key.length();
            } 
            else {
                plainText.append(cipherChar);
            }
        }

        return plainText.toString();
    }

    public static void main(String[] args) {
        String plaintext = "NATNAEL";
        String key = "SECRETKEY";

        String ciphertext = beaufortEncrypt(plaintext, key);
        System.out.println("Original Text: " + plaintext);
        System.out.println("Encrypted Text: " + ciphertext);

        String decryptedText = beaufortDecrypt(ciphertext, key);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
