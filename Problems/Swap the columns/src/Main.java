import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        int ii = scanner.nextInt();
        int jj = scanner.nextInt();
        for (int i = 0; i < n; i++){
            int buf = matrix[i][ii];
            matrix[i][ii] = matrix[i][jj];
            matrix[i][jj] = buf;

        }
        for (int[] a: matrix
             ) {
            for (int i: a
                 ) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }
}