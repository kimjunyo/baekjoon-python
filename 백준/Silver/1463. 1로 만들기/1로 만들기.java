import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new Integer[N + 1];
        arr[0] = 0;
        arr[1] = 0;

        System.out.println(dp(N));
    }

    private static int dp(int N) {
        if (arr[N] == null) {
            if (N % 6 == 0) {
                arr[N] = Integer.min(dp(N - 1), Integer.min(dp(N / 3), dp(N / 2))) + 1;
            } else if (N % 3 == 0) {
                arr[N] = Integer.min(dp(N - 1), dp(N / 3)) + 1;
            } else if (N % 2 == 0) {
                arr[N] = Integer.min(dp(N - 1), dp(N / 2)) + 1;
            } else {
                arr[N] = dp(N - 1) + 1;
            }

        }
        return arr[N];
    }
}