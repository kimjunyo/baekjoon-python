import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int code1;
    static int code2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fibo(N);
        fibonacci(N);

        System.out.println(code1 + " " + code2);
    }

    private static int fibo(int N) {
        if (N == 1 || N == 2) {
            code1++;
            return 1;
        }
        return fibo(N - 1) + fibo(N - 2);
    }

    private static int fibonacci(int N) {
        int[] f = new int[N + 1];
        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= N; i++) {
           f[i] = f[i - 1] + f[i - 2];
           code2++;
        }

        return f[N];
    }
}