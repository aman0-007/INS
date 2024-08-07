import java.util.Scanner;

public class VernarCipher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter SimpleColumnar Text : ");
        String plainText = sc.next();

        System.out.print("\nEnter Key : ");
        String cipherKey = sc.next();


        String cipherText = checkLength(plainText,cipherKey);
        System.out.println("===================================== CIPHER TEXT =====================================");
        System.out.println(cipherText);

        String deCryptedText = deCrypt(cipherText, cipherKey);
        System.out.println("===================================== PLAIN TEXT =====================================");
        System.out.println(deCryptedText);
    }

    public static String checkLength(String plainText, String key){
        if(plainText.length()==key.length()){
            return getCipher(plainText.toUpperCase(),key.toUpperCase());
        }else{
            return "Length of plain text and key do not match.";
        }
    }

    public static String getCipher(String plainText, String key){
        String cipherText = "";

        int cipher[] = new int[key.length()];

        for(int i = 0; i < key.length(); i++){
            cipher[i] = plainText.charAt(i) + key.charAt(i) - 130;
        }

        for(int i = 0; i < key.length(); i++){
            if(cipher[i] > 25){
                cipher[i] = cipher[i] - 26;
            }
        }

        for (int i = 0; i < key.length(); i++){
            int c = cipher[i] + 65;

            cipherText += (char) c;
        }
        return cipherText;
    }

    public static String deCrypt(String text, String key){
        String decryptedText = "";

        int decrypt[] = new int[key.length()];

        for(int i = 0; i < key.length(); i++){
            decrypt[i] = text.charAt(i) - 65;
        }

        for(int i = 0; i < key.length(); i++){
            int p = decrypt[i] - (key.charAt(i) - 65);
            if(p<0){
                p = p + 26;
            }
            decryptedText += (char) (p + 65);
        }

        return decryptedText;
    }
}