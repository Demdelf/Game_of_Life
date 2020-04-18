import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        String result = "YES";

        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        //String[] s = scanner.nextLine().split(" ");
        while (true){
            String s = scanner.nextLine();
            if (s.equals("end")) break;
            strings.add(s);
        }
        int n = strings.size();
        int m = strings.get(0).split(" ").length;
        int[][] numbers = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                numbers[i][j] = getAbove(strings, i, j) + getBelow(strings, i, j) + getLeft(strings, i, j)
                        + getRight(strings, i, j);
            }
        }

        for (int[] a: numbers
        ) {
            for (int i:a
            ) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }



    }
    public static int getAbove(List<String> strings, int i, int j){
        int res = 0;
        if (i == 0) res = Integer.parseInt(strings.get(strings.size() - 1).split(" ")[j]);
        else res = Integer.parseInt(strings.get(i - 1).split(" ")[j]);
        return res;
    }

    public static int getBelow(List<String> strings, int i, int j){
        int res = 0;
        int n = strings.size();
        if (i == n - 1) res = Integer.parseInt(strings.get(0).split(" ")[j]);
        else res = Integer.parseInt(strings.get(i + 1).split(" ")[j]);
        return res;
    }

    public static int getLeft(List<String> strings, int i, int j){
        int res = 0;
        int m = strings.get(0).split(" ").length;
        if (j == 0) res = Integer.parseInt(strings.get(i).split(" ")[m - 1]);
        else res = Integer.parseInt(strings.get(i).split(" ")[j - 1]);
        return res;
    }

    public static int getRight(List<String> strings, int i, int j){
        int res = 0;
        int m = strings.get(0).split(" ").length;
        if (j == m - 1) res = Integer.parseInt(strings.get(i).split(" ")[0]);
        else res = Integer.parseInt(strings.get(i).split(" ")[j + 1]);
        return res;
    }
    
}