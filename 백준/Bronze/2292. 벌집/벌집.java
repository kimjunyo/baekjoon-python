import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int sum = 1;
        int move = 1;
        while (sum < N) {
            sum += 6*move;
            move++;
        }

        System.out.println(move);
    }
}
