import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plain text : ");
        String plainText = sc.nextLine().trim();

        System.out.print("Enter no. of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter no. of columns: ");
        int columns = sc.nextInt();

        if(rows*columns < plainText.length()){
            System.out.println("The matrix is too small for the plainText to fit. ");
            return;
        }

        char matrix[][] = new char[rows][columns];
        int index = 0;

        for(int i = 0;  i < rows ; i++ ){
            for(int j = 0; j < columns ; j++){
                if(index < plainText.length()){
                    matrix[i][j] = plainText.charAt(index++);
                }else {
                    matrix[i][j] = ' ';
                }
            }
        }

        System.out.println("========================================== Matrix ==========================================");

        for(int i = 0; i < rows ; i ++){
            for(int j = 0; j < columns ; j ++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        StringBuilder cipherText = new StringBuilder() ;

        for(int j = columns - 1; j >= 0 ; j--){
            for(int i = 0; i < rows ; i ++){
                if(matrix[i][j] == ' '){
                    continue;
                }
                cipherText.append(matrix[i][j]);
            }
        }

        System.out.println("============================================ Cipher Text ============================================");

        System.out.println(cipherText.toString());
    }
}