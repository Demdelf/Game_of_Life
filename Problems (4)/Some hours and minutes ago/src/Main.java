import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        LocalTime first = LocalTime.parse(in);
        LocalTime second = first.minusHours(hour);
        System.out.println(second.minusMinutes(minute));
    }
}