import java.util.Scanner;
public class CeasarCipher {
public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
public static String encrypt(String plainText, int shiftKey) {
plainText = plainText.toLowerCase();
String cipherText = "";
for (int i = 0; i < plainText.length(); i++) {
char currentChar = plainText.charAt(i);
// Check if character is in the alphabet
if (ALPHABET.indexOf(currentChar) != -1) {
int charPosition = ALPHABET.indexOf(currentChar);
int keyVal = (shiftKey + charPosition) % 26;
char replaceVal = ALPHABET.charAt(keyVal);
cipherText += replaceVal;
} else {
// If character not in alphabet, just append it to the cipher text
cipherText += currentChar;
}
}
return cipherText;
}
public static String decrypt(String cipherText, int shiftKey) {
cipherText = cipherText.toLowerCase();
String plainText = "";
for (int i = 0; i < cipherText.length(); i++) {
char currentChar = cipherText.charAt(i);
if (ALPHABET.indexOf(currentChar) != -1) {
int charPosition = ALPHABET.indexOf(currentChar);
int keyVal = (charPosition - shiftKey) % 26;
if (keyVal < 0) {
keyVal = ALPHABET.length() + keyVal;
}
char replaceVal = ALPHABET.charAt(keyVal);
plainText += replaceVal;
} else {
plainText += currentChar;
}
}
return plainText;
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter the Plain text for Encryption: ");
String message = sc.nextLine();
System.out.println("Encrypted message: Cipher Text=" + encrypt(message, 3));
System.out.println("Decrypted message: Plain Text=" + decrypt(encrypt(message, 3), 3));
sc.close();
}