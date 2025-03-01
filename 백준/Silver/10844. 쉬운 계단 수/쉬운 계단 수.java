import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1][10];

        for (int i = 1; i <= 9; i++) {
            arr[1][i] = 1;
        }



        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i-1][j] == 0) {
                } else if (j == 0) {
                    arr[i][j+1] += arr[i-1][j] % 1_000_000_000;
                } else if (j == 9){
                    arr[i][j-1] += arr[i-1][j] % 1_000_000_000;
                } else {
                    arr[i][j+1] += arr[i-1][j] % 1_000_000_000;
                    arr[i][j-1] += arr[i-1][j] % 1_000_000_000;
                }
            }
        }

        long sum =0;
        for (int i = 0; i <= 9; i++) {
            sum += arr[N][i];
        }

        System.out.println(sum % 1_000_000_000);
    }

}