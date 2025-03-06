import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dr = {0, 0, 1};
    static int[] dc = {-1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int heartRow = -1;
        int heartCol = -1;
        boolean isHead = false;
        char[][] arr = new char[N][N];
        int[] length = new int[5];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                arr[i][j] = input[j];
                if (input[j] == '*' && !isHead) {
                    heartRow = i + 1;
                    heartCol = j;
                    isHead = true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < N; j++) {
                int nr = heartRow + dr[i] * j;
                int nc = heartCol + dc[i] * j;

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] != '_') {
                    length[i]++;
                }
            }
        }
        int LegRow = heartRow + length[2] + 1;
        int leftLegCol = heartCol - 1;
        int rightLegCol = heartCol + 1;

        for (int i = 0; i < N; i++) {
            int nr = LegRow + i;
            int nc = leftLegCol;

            if (nr >= 0 && nr < N && arr[nr][nc] != '_') {
                length[3]++;
            }
        }

        for (int i = 0; i < N; i++) {
            int nr = LegRow + i;
            int nc = rightLegCol;

            if (nr >= 0 && nr < N && arr[nr][nc] != '_') {
                length[4]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(heartRow + 1).append(" ").append(heartCol + 1).append("\n");

        for (int i = 0; i < length.length; i++) {
            sb.append(length[i]).append(" ");
        }

        System.out.println(sb);
    }
}