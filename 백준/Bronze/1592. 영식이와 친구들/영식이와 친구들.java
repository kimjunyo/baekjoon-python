import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int[] friends = new int[N];
        int max = 1;
        int sum = 0;
        int idx = 0;
        friends[idx] = 1;

        while (max < M) {
            if (friends[idx] % 2 != 0) {
                if (idx + L >= N) {
                    idx = idx + L - N;
                } else {
                    idx = idx + L;
                }
            } else {
                if (idx - L < 0) {
                    idx = idx + N - L;
                } else {
                    idx = idx - L;
                }
            }
            friends[idx]++;
            if (max < friends[idx]) max++;
            sum++;
        }

        System.out.println(sum);
    }
}