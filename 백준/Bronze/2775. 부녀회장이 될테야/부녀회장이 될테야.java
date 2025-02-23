import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] buildings;
    static int k, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for(int i = 0; i < TC; i++){
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            buildings = new int[k+1][n+1];
            for (int j = 1; j < n+1; j++) {
                buildings[0][j] = j;
            }
            System.out.println(solve(k, n));
        }
    }

    private static int solve(int k, int n) {
        if(n == 1) return 1;

        if(buildings[k][n] != 0)
            return buildings[k][n];

        return buildings[k][n] = solve(k-1, n) + solve(k, n-1);
    }
}