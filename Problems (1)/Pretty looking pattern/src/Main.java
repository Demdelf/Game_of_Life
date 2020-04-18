import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        String result = "YES";
        char[][] chars = new char[4][4];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++){
            chars[i] = scanner.nextLine().toCharArray();
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(chars[i][j] == chars[i + 1][j] && chars[i][j] == chars[i][j + 1]
                    && chars[i][j] == chars[i + 1][j + 1]){
                    result = "NO";
                    break;
                }
            }
        }
        System.out.println(result);
    }
}